package org.bbz.srxk.guotu.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.bbz.srxk.guotu.handler.codec.MessageDeCoder;
import org.bbz.srxk.guotu.server.DefaultGuotuServer;

/**
 * Created by liulaoye on 17-2-20.
 * 初始化client的pipeline
 */
public class ChannelInitializerHandler extends ChannelInitializer<SocketChannel>{
    private final DefaultGuotuServer server;

    public ChannelInitializerHandler( DefaultGuotuServer server ){
        this.server = server;
    }

    @Override
    protected void initChannel( SocketChannel ch ) throws Exception{

        ch.pipeline().addLast( new LoggingHandler( LogLevel.INFO ) );
        ch.pipeline().addLast( new MessageDeCoder() );
        ch.pipeline().addLast( new StringEncoder(   ) );
//        ch.pipeline().addLast( new IntProccessHandler3() );
//        ch.pipeline().addLast( new IntProccessHandler() );
//        ch.pipeline().addLast( new IntProccessHandler2() );
        ch.pipeline().addLast( new ProcessHandler() );
    }
}
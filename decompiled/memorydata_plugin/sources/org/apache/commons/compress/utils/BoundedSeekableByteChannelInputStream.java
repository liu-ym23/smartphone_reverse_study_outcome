package org.apache.commons.compress.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/* JADX INFO: loaded from: classes6.dex */
public class BoundedSeekableByteChannelInputStream extends BoundedArchiveInputStream {
    private final SeekableByteChannel channel;

    public BoundedSeekableByteChannelInputStream(long r3, long r5, SeekableByteChannel r7) {
        SeekableByteChannel r8 = (SeekableByteChannel) ZeusTransformUtils.wrapperContextForParams(r7, SeekableByteChannel.class, "com.obric.memorydata.plugin");
        super(r3, r5);
        this.channel = r8;
    }

    @Override // org.apache.commons.compress.utils.BoundedArchiveInputStream
    public int read(long r3, ByteBuffer r5) {
        SeekableByteChannel r0 = this.channel;
        monitor-enter(r0);
        this.channel.position(r3);     // Catch: Throwable -> L8
        int r2 = this.channel.read(r5);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        r5.flip();
        return r2;
    L8:
        th = move-exception;
        throw th;
    }
}

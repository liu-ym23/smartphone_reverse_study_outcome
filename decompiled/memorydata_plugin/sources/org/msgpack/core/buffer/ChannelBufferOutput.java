package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public class ChannelBufferOutput implements MessageBufferOutput {
    private MessageBuffer buffer;
    private WritableByteChannel channel;

    public ChannelBufferOutput(WritableByteChannel r3) {
        this((WritableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, WritableByteChannel.class, "com.obric.memorydata.plugin"), 8192);
    }

    public ChannelBufferOutput(WritableByteChannel r3, int r4) {
        this.channel = (WritableByteChannel) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((WritableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, WritableByteChannel.class, "com.obric.memorydata.plugin"), "output channel is null"), WritableByteChannel.class, "com.obric.memorydata.plugin");
        this.buffer = MessageBuffer.allocate(r4);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void add(byte[] r1, int r2, int r3) {
        write(r1, r2, r3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.channel.close();
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public MessageBuffer next(int r2) {
        if (this.buffer.size() >= r2) goto L6;
        this.buffer = MessageBuffer.allocate(r2);
    L6:
        return this.buffer;
    }

    public WritableByteChannel reset(WritableByteChannel r3) {
        WritableByteChannel r4 = (WritableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, WritableByteChannel.class, "com.obric.memorydata.plugin");
        WritableByteChannel r0 = this.channel;
        this.channel = r4;
        return r0;
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void write(byte[] r1, int r2, int r3) {
        ByteBuffer r4 = ByteBuffer.wrap(r1, r2, r3);
    L4:
        if (r4.hasRemaining() == false) goto L6;
        this.channel.write(r4);
        goto L4
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void writeBuffer(int r3) {
        ByteBuffer r4 = this.buffer.sliceAsByteBuffer(0, r3);
    L4:
        if (r4.hasRemaining() == false) goto L6;
        this.channel.write(r4);
        goto L4
    }
}

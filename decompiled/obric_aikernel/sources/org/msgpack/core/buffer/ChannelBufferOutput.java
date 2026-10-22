package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class ChannelBufferOutput implements MessageBufferOutput {
    private MessageBuffer buffer;
    private WritableByteChannel channel;

    public ChannelBufferOutput(WritableByteChannel r10) {
        this(r10, 8192);
    }

    public ChannelBufferOutput(WritableByteChannel r10, int r11) {
        this.channel = (WritableByteChannel) Preconditions.checkNotNull(r10, "output channel is null");
        this.buffer = MessageBuffer.allocate(r11);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void add(byte[] r10, int r11, int r12) {
        write(r10, r11, r12);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.channel.close();
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public MessageBuffer next(int r10) {
        if (this.buffer.size() >= r10) goto L6;
        this.buffer = MessageBuffer.allocate(r10);
    L6:
        return this.buffer;
    }

    public WritableByteChannel reset(WritableByteChannel r10) {
        WritableByteChannel r11 = this.channel;
        this.channel = r10;
        return r11;
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void write(byte[] r10, int r11, int r12) {
        ByteBuffer r13 = ByteBuffer.wrap(r10, r11, r12);
    L4:
        if (r13.hasRemaining() == false) goto L6;
        this.channel.write(r13);
        goto L4
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void writeBuffer(int r10) {
        ByteBuffer r11 = this.buffer.sliceAsByteBuffer(0, r10);
    L4:
        if (r11.hasRemaining() == false) goto L6;
        this.channel.write(r11);
        goto L4
    }
}

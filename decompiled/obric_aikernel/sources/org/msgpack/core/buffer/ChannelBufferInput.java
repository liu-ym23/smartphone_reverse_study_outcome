package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class ChannelBufferInput implements MessageBufferInput {
    private final MessageBuffer buffer;
    private ReadableByteChannel channel;

    public ChannelBufferInput(ReadableByteChannel r10) {
        this(r10, 8192);
    }

    public ChannelBufferInput(ReadableByteChannel r10, int r11) {
        this.channel = (ReadableByteChannel) Preconditions.checkNotNull(r10, "input channel is null");
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "buffer size must be > 0: " + r11);
        this.buffer = MessageBuffer.allocate(r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.channel.close();
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        ByteBuffer r10 = this.buffer.sliceAsByteBuffer();
        if (this.channel.read(r10) != (-1)) goto L6;
        return null;
    L6:
        r10.flip();
        return this.buffer.slice(0, r10.limit());
    }

    public ReadableByteChannel reset(ReadableByteChannel r10) {
        ReadableByteChannel r11 = this.channel;
        this.channel = r10;
        return r11;
    }
}

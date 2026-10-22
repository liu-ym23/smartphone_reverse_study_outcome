package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public class ChannelBufferInput implements MessageBufferInput {
    private final MessageBuffer buffer;
    private ReadableByteChannel channel;

    public ChannelBufferInput(ReadableByteChannel r3) {
        this((ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, ReadableByteChannel.class, "com.obric.memorydata.plugin"), 8192);
    }

    public ChannelBufferInput(ReadableByteChannel r3, int r4) {
        this.channel = (ReadableByteChannel) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, ReadableByteChannel.class, "com.obric.memorydata.plugin"), "input channel is null"), ReadableByteChannel.class, "com.obric.memorydata.plugin");
        if (r4 <= 0) goto L5;
        boolean r5 = true;
    L6:
        Preconditions.checkArgument(r5, "buffer size must be > 0: " + r4);
        this.buffer = MessageBuffer.allocate(r4);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.channel.close();
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        ByteBuffer r0 = this.buffer.sliceAsByteBuffer();
        if (this.channel.read(r0) != (-1)) goto L6;
        return null;
    L6:
        r0.flip();
        return this.buffer.slice(0, r0.limit());
    }

    public ReadableByteChannel reset(ReadableByteChannel r3) {
        ReadableByteChannel r4 = (ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, ReadableByteChannel.class, "com.obric.memorydata.plugin");
        ReadableByteChannel r0 = this.channel;
        this.channel = r4;
        return r0;
    }
}

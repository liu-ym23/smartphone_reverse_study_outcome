package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public class ByteBufferInput implements MessageBufferInput {
    private ByteBuffer input;
    private boolean isRead;

    public ByteBufferInput(ByteBuffer r3) {
        this.isRead = false;
        this.input = ((ByteBuffer) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3, "input ByteBuffer is null"), ByteBuffer.class, "com.obric.memorydata.plugin")).slice();
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        if (this.isRead == false) goto L6;
        return null;
    L6:
        MessageBuffer r0 = MessageBuffer.wrap(this.input);
        this.isRead = true;
        return r0;
    }

    public ByteBuffer reset(ByteBuffer r4) {
        ByteBuffer r0 = this.input;
        this.input = ((ByteBuffer) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r4, "input ByteBuffer is null"), ByteBuffer.class, "com.obric.memorydata.plugin")).slice();
        this.isRead = false;
        return r0;
    }
}

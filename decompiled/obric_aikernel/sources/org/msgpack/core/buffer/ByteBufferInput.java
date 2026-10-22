package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferInput implements MessageBufferInput {
    private ByteBuffer input;
    private boolean isRead;

    public ByteBufferInput(ByteBuffer r10) {
        this.isRead = false;
        this.input = ((ByteBuffer) Preconditions.checkNotNull(r10, "input ByteBuffer is null")).slice();
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        if (this.isRead == false) goto L6;
        return null;
    L6:
        MessageBuffer r10 = MessageBuffer.wrap(this.input);
        this.isRead = true;
        return r10;
    }

    public ByteBuffer reset(ByteBuffer r10) {
        ByteBuffer r11 = this.input;
        this.input = ((ByteBuffer) Preconditions.checkNotNull(r10, "input ByteBuffer is null")).slice();
        this.isRead = false;
        return r11;
    }
}

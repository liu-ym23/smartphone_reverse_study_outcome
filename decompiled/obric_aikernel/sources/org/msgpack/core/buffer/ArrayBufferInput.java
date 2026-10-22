package org.msgpack.core.buffer;

import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayBufferInput implements MessageBufferInput {
    private MessageBuffer buffer;
    private boolean isEmpty;

    public ArrayBufferInput(MessageBuffer r10) {
        this.buffer = r10;
        if (r10 != null) goto L5;
        boolean r11 = true;
    L6:
        this.isEmpty = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public ArrayBufferInput(byte[] r10) {
        this(r10, 0, r10.length);
    }

    public ArrayBufferInput(byte[] r10, int r11, int r12) {
        this(MessageBuffer.wrap((byte[]) Preconditions.checkNotNull(r10, "input array is null"), r11, r12));
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.buffer = null;
        this.isEmpty = true;
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        if (this.isEmpty == false) goto L6;
        return null;
    L6:
        this.isEmpty = true;
        return this.buffer;
    }

    public MessageBuffer reset(MessageBuffer r10) {
        MessageBuffer r11 = this.buffer;
        this.buffer = r10;
        if (r10 != null) goto L5;
        boolean r12 = true;
    L6:
        this.isEmpty = r12;
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    public void reset(byte[] r10) {
        reset(MessageBuffer.wrap((byte[]) Preconditions.checkNotNull(r10, "input array is null")));
    }

    public void reset(byte[] r10, int r11, int r12) {
        reset(MessageBuffer.wrap((byte[]) Preconditions.checkNotNull(r10, "input array is null"), r11, r12));
    }
}

package com.obric.aikernel.model_decrypt.api.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ByteBufferBackedOutputStream extends OutputStream {
    private final ByteBuffer buffer;

    public ByteBufferBackedOutputStream(ByteBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        this.buffer = r10;
    }

    @Override // java.io.OutputStream
    public void write(int r10) {
        if (this.buffer.hasRemaining() == false) goto L7;
        this.buffer.put((byte) r10);
        return;
    L7:
        throw new IOException("Buffer is full. no remaining");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "b");
        if (this.buffer.remaining() < r12) goto L7;
        this.buffer.put(r10, r11, r12);
        return;
    L7:
        throw new IOException("Buffer is full. len is " + r12 + ", remaining is " + this.buffer.remaining());
    }
}

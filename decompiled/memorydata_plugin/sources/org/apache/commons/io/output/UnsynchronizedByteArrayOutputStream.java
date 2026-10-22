package org.apache.commons.io.output;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class UnsynchronizedByteArrayOutputStream extends AbstractByteArrayOutputStream {
    public UnsynchronizedByteArrayOutputStream() {
        this(1024);
    }

    public UnsynchronizedByteArrayOutputStream(int r3) {
        if (r3 < 0) goto L7;
        needNewBuffer(r3);
        return;
    L7:
        throw new IllegalArgumentException("Negative initial size: " + r3);
    }

    public void reset() {
        resetImpl();
    }

    public int size() {
        return this.count;
    }

    @Override // org.apache.commons.io.output.AbstractByteArrayOutputStream
    public byte[] toByteArray() {
        return toByteArrayImpl();
    }

    public InputStream toInputStream() {
        return toInputStream($$Lambda$ipGJKfMNbik4rxMECu3q8DDjU7Q.INSTANCE);
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        writeImpl(r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) {
        if (r4 < 0) goto L14;
        if (r4 > r3.length) goto L14;
        if (r5 < 0) goto L14;
        int r0 = r4 + r5;
        if (r0 > r3.length) goto L14;
        if (r0 < 0) goto L14;
        if (r5 != 0) goto L11;
        return;
    L11:
        writeImpl(r3, r4, r5);
        return;
    L14:
        throw new IndexOutOfBoundsException(String.format("offset=%,d, length=%,d", new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
    }

    public void writeTo(OutputStream r1) {
        writeToImpl(r1);
    }
}

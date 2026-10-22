package org.apache.commons.io.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class UnsynchronizedByteArrayInputStream extends InputStream {
    private final byte[] data;
    private final int eod;
    private int markedOffset;
    private int offset;

    public UnsynchronizedByteArrayInputStream(byte[] r4) {
        this.data = (byte[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4, "data"), byte[].class, "com.obric.memorydata.plugin");
        this.offset = 0;
        this.eod = r4.length;
        this.markedOffset = 0;
    }

    public UnsynchronizedByteArrayInputStream(byte[] r4, int r5, int r6) {
        if (r5 < 0) goto L14;
        if (r6 < 0) goto L12;
        this.data = (byte[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4, "data"), byte[].class, "com.obric.memorydata.plugin");
        if (r4.length <= 0) goto L8;
        int r0 = r4.length;
    L9:
        int r7 = Math.min(r5, r0);
        this.offset = r7;
        this.eod = Math.min(r7 + r6, r4.length);
        this.markedOffset = this.offset;
        return;
    L8:
        r0 = r5;
        goto L9
    L12:
        throw new IllegalArgumentException("length cannot be negative");
    L14:
        throw new IllegalArgumentException("offset cannot be negative");
    }

    @Override // java.io.InputStream
    public int available() {
        int r0 = this.offset;
        int r1 = this.eod;
        if (r0 < r1) goto L7;
        return 0;
    L7:
        return r1 - r0;
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        this.markedOffset = this.offset;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        int r0 = this.offset;
        if (r0 >= this.eod) goto L5;
        byte[] r1 = this.data;
        this.offset = r0 + 1;
        return r1[r0] & 255;
    L5:
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) {
        Objects.requireNonNull(r3, "dest");
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        Objects.requireNonNull(r3, "dest");
        if (r4 < 0) goto L21;
        if (r5 < 0) goto L21;
        if ((r4 + r5) > r3.length) goto L21;
        int r0 = this.offset;
        int r1 = this.eod;
        if (r0 < r1) goto L11;
        return -1;
    L11:
        int r2 = r1 - r0;
        if (r5 < r2) goto L15;
        r5 = r2;
    L15:
        if (r5 > 0) goto L18;
        return 0;
    L18:
        System.arraycopy(this.data, r0, r3, r4, r5);
        this.offset += r5;
        return r5;
    L21:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public void reset() {
        this.offset = this.markedOffset;
    }

    @Override // java.io.InputStream
    public long skip(long r5) {
        if (r5 < 0) goto L11;
        int r0 = this.eod;
        int r1 = this.offset;
        long r2 = r0 - r1;
        if (r5 < r2) goto L8;
        r5 = r2;
    L8:
        this.offset = (int) (((long) r1) + r5);
        return r5;
    L11:
        throw new IllegalArgumentException("Skipping backward is not supported");
    }
}

package org.apache.commons.compress.compressors.lz77support;

import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractLZ77CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private int backReferenceOffset;
    private final byte[] buf;
    private long bytesRemaining;
    private final CountingInputStream in;
    private final byte[] oneByte;
    private int readIndex;
    private int size;
    protected final ByteUtils.ByteSupplier supplier;
    private final int windowSize;
    private int writeIndex;

    private int readFromBuffer(byte[] r3, int r4, int r5) {
        int r6 = Math.min(r5, available());
        if (r6 <= 0) goto L7;
        System.arraycopy(this.buf, this.readIndex, r3, r4, r6);
        int r7 = this.readIndex + r6;
        this.readIndex = r7;
        if (r7 <= (this.windowSize * 2)) goto L7;
        slideBuffer();
    L7:
        this.size += r6;
        return r6;
    }

    private void slideBuffer() {
        byte[] r0 = this.buf;
        int r1 = this.windowSize;
        System.arraycopy(r0, r1, r0, 0, r1 * 2);
        int r2 = this.writeIndex;
        int r3 = this.windowSize;
        this.writeIndex = r2 - r3;
        this.readIndex -= r3;
    }

    private void tryToCopy(int r7) {
        int r8 = Math.min((int) Math.min(r7, this.bytesRemaining), this.buf.length - this.writeIndex);
        if (r8 == 0) goto L17;
        int r0 = this.backReferenceOffset;
        if (r0 != 1) goto L9;
        byte[] r1 = this.buf;
        int r2 = this.writeIndex;
        Arrays.fill(r1, r2, r2 + r8, r1[r2 - 1]);
    L8:
        this.writeIndex += r8;
        goto L17
    L9:
        if (r8 >= r0) goto L11;
        byte[] r3 = this.buf;
        int r4 = this.writeIndex;
        System.arraycopy(r3, r4 - r0, r3, r4, r8);
        goto L8
    L11:
        int r5 = r8 / r0;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        byte[] r9 = this.buf;
        int r10 = this.writeIndex;
        int r11 = this.backReferenceOffset;
        System.arraycopy(r9, r10 - r11, r9, r10, r11);
        this.writeIndex += this.backReferenceOffset;
        r6 = r6 + 1;
        goto L12
    L14:
        int r12 = this.backReferenceOffset;
        int r13 = r8 - (r5 * r12);
        if (r13 <= 0) goto L17;
        byte[] r14 = this.buf;
        int r15 = this.writeIndex;
        System.arraycopy(r14, r15 - r12, r14, r15, r13);
        this.writeIndex += r13;
    L17:
        this.bytesRemaining -= (long) r8;
    }

    private void tryToReadLiteral(int r5) {
        int r6 = Math.min((int) Math.min(r5, this.bytesRemaining), this.buf.length - this.writeIndex);
        if (r6 <= 0) goto L5;
        int r0 = IOUtils.readFully(this.in, this.buf, this.writeIndex, r6);
    L6:
        count(r0);
        if (r6 != r0) goto L11;
        this.writeIndex += r6;
        this.bytesRemaining -= (long) r6;
        return;
    L11:
        throw new IOException("Premature end of stream reading literal");
    L5:
        r0 = 0;
        goto L6
    }

    @Override // java.io.InputStream
    public int available() {
        return this.writeIndex - this.readIndex;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    public final boolean hasMoreDataInBlock() {
        if (this.bytesRemaining <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.oneByte, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.oneByte[0] & 255;
    }

    public final int readBackReference(byte[] r2, int r3, int r4) {
        int r0 = available();
        if (r4 <= r0) goto L6;
        tryToCopy(r4 - r0);
    L6:
        return readFromBuffer(r2, r3, r4);
    }

    public final int readLiteral(byte[] r2, int r3, int r4) {
        int r0 = available();
        if (r4 <= r0) goto L6;
        tryToReadLiteral(r4 - r0);
    L6:
        return readFromBuffer(r2, r3, r4);
    }

    public final int readOneByte() {
        int r0 = this.in.read();
        if (r0 == (-1)) goto L6;
        count(1);
        return r0 & 255;
    L6:
        return -1;
    }

    public final void startBackReference(int r3, long r4) {
        if (r3 <= 0) goto L12;
        if (r3 > this.writeIndex) goto L12;
        if (r4 < 0) goto L10;
        this.backReferenceOffset = r3;
        this.bytesRemaining = r4;
        return;
    L10:
        throw new IllegalArgumentException("length must not be negative");
    L12:
        throw new IllegalArgumentException("offset must be bigger than 0 but not bigger than the number of bytes available for back-references");
    }

    public final void startLiteral(long r3) {
        if (r3 < 0) goto L7;
        this.bytesRemaining = r3;
        return;
    L7:
        throw new IllegalArgumentException("length must not be negative");
    }
}

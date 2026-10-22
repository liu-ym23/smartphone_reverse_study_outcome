package org.apache.commons.compress.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public class BitInputStream implements Closeable {
    private static final long[] MASKS = null;
    private long bitsCached;
    private int bitsCachedSize;
    private final ByteOrder byteOrder;
    private final CountingInputStream in;

    static {
        MASKS = new long[64];
        int r1 = 1;
    L4:
        if (r1 > 63) goto L6;
        long[] r2 = MASKS;
        r2[r1] = (r2[r1 - 1] << 1) + 1;
        r1 = r1 + 1;
        goto L4
    }

    public BitInputStream(InputStream r2, ByteOrder r3) {
        this.in = new CountingInputStream(r2);
        this.byteOrder = r3;
    }

    private boolean ensureCache(int r7) {
    L2:
        int r0 = this.bitsCachedSize;
        if (r0 >= r7) goto L15;
        if (r0 >= 57) goto L22;
        long r1 = this.in.read();
        if (r1 < 0) goto L8;
        if (this.byteOrder != ByteOrder.LITTLE_ENDIAN) goto L13;
        long r2 = this.bitsCached;
        r1 = r1 << this.bitsCachedSize;
    L14:
        this.bitsCached = r1 | r2;
        this.bitsCachedSize += 8;
        goto L2
    L13:
        r2 = this.bitsCached << 8;
        this.bitsCached = r2;
        goto L14
    L8:
        return true;
    L22:
        return false;
    L15:
        return false;
    }

    private long processBitsGreater57(int r12) {
        int r0 = r12 - this.bitsCachedSize;
        int r1 = 8 - r0;
        long r2 = this.in.read();
        if (r2 >= 0) goto L6;
        return r2;
    L6:
        if (this.byteOrder != ByteOrder.LITTLE_ENDIAN) goto L8;
        long[] r4 = MASKS;
        long r5 = r4[r0] & r2;
        this.bitsCached = (r5 << this.bitsCachedSize) | this.bitsCached;
        r2 = r2 >>> r0;
        long r6 = r4[r1];
    L9:
        long r3 = r2 & r6;
        long r7 = this.bitsCached & MASKS[r12];
        this.bitsCached = r3;
        this.bitsCachedSize = r1;
        return r7;
    L8:
        long r8 = this.bitsCached << r0;
        this.bitsCached = r8;
        long[] r9 = MASKS;
        this.bitsCached = r8 | ((r2 >>> r1) & r9[r0]);
        r6 = r9[r1];
        goto L9
    }

    private long readCachedBits(int r5) {
        if (this.byteOrder != ByteOrder.LITTLE_ENDIAN) goto L5;
        long r0 = this.bitsCached;
        long r2 = MASKS[r5] & r0;
        this.bitsCached = r0 >>> r5;
    L6:
        this.bitsCachedSize -= r5;
        return r2;
    L5:
        r2 = MASKS[r5] & (this.bitsCached >> (this.bitsCachedSize - r5));
        goto L6
    }

    public void alignWithByteBoundary() {
        int r0 = this.bitsCachedSize % 8;
        if (r0 <= 0) goto L6;
        readCachedBits(r0);
        return;
    }

    public long bitsAvailable() {
        return ((long) this.bitsCachedSize) + (((long) this.in.available()) * 8);
    }

    public int bitsCached() {
        return this.bitsCachedSize;
    }

    public void clearBitCache() {
        this.bitsCached = 0;
        this.bitsCachedSize = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    public long getBytesRead() {
        return this.in.getBytesRead();
    }

    public long readBits(int r2) {
        if (r2 < 0) goto L16;
        if (r2 > 63) goto L16;
        if (ensureCache(r2) == false) goto L10;
        return -1;
    L10:
        if (this.bitsCachedSize >= r2) goto L14;
        return processBitsGreater57(r2);
    L14:
        return readCachedBits(r2);
    L16:
        throw new IOException("count must not be negative or greater than 63");
    }
}

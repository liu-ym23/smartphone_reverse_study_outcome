package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.utils.CloseShieldFilterInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
class ExplodingInputStream extends InputStream implements InputStreamStatistics {
    private BitStream bits;
    private final CircularBuffer buffer;
    private final int dictionarySize;
    private BinaryTree distanceTree;
    private final InputStream in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;
    private long treeSizes;
    private long uncompressedCount;

    public ExplodingInputStream(int r3, int r4, InputStream r5) {
        this.buffer = new CircularBuffer(32768);
        if (r3 == 4096) goto L10;
        if (r3 == 8192) goto L10;
        throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
    L10:
        if (r4 != 2) goto L12;
    L16:
        this.dictionarySize = r3;
        this.numberOfTrees = r4;
        this.minimumMatchLength = r4;
        this.in = r5;
        return;
    L12:
        if (r4 == 3) goto L16;
        throw new IllegalArgumentException("The number of trees must be 2 or 3");
    }

    private void fillBuffer() {
        init();
        int r0 = this.bits.nextBit();
        if (r0 != (-1)) goto L6;
        return;
    L6:
        if (r0 != 1) goto L15;
        BinaryTree r1 = this.literalTree;
        if (r1 == null) goto L10;
        int r2 = r1.read(this.bits);
    L11:
        if (r2 != (-1)) goto L13;
        return;
    L13:
        this.buffer.put(r2);
        return;
    L10:
        r2 = this.bits.nextByte();
        goto L11
    L15:
        if (this.dictionarySize != 4096) goto L17;
        int r3 = 6;
    L18:
        int r4 = (int) this.bits.nextBits(r3);
        int r5 = this.distanceTree.read(this.bits);
        if (r5 != (-1)) goto L22;
        if (r4 > 0) goto L22;
        return;
    L22:
        int r6 = (r5 << r3) | r4;
        int r7 = this.lengthTree.read(this.bits);
        if (r7 != 63) goto L28;
        long r8 = this.bits.nextBits(8);
        if (r8 != (-1)) goto L27;
        return;
    L27:
        r7 = (int) (((long) r7) + r8);
    L28:
        int r9 = r7 + this.minimumMatchLength;
        this.buffer.copy(r6 + 1, r9);
        return;
    L17:
        r3 = 7;
        goto L18
    }

    private void init() {
        if (this.bits != null) goto L18;
        CountingInputStream r0 = new CountingInputStream(new CloseShieldFilterInputStream(this.in));
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    L6:
        if (this.numberOfTrees != 3) goto L8;
        this.literalTree = BinaryTree.decode(r0, 256);     // Catch: Throwable -> L10
    L8:
        this.lengthTree = BinaryTree.decode(r0, 64);     // Catch: Throwable -> L10
        this.distanceTree = BinaryTree.decode(r0, 64);     // Catch: Throwable -> L10
        this.treeSizes += r0.getBytesRead();     // Catch: Throwable -> L10
        r0.close();
        this.bits = new BitStream(this.in);
        return;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.bits.getBytesRead() + this.treeSizes;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.buffer.available() == false) goto L13;
    L9:
        int r0 = this.buffer.get();
        if (r0 <= (-1)) goto L12;
        this.uncompressedCount++;
    L12:
        return r0;
    L13:
        fillBuffer();     // Catch: IllegalArgumentException -> L6
    L6:
        e = move-exception;
        throw new IOException("bad IMPLODE stream", e);
    }
}

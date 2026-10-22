package com.bytedance.compression.zstd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDecompressCtx extends a {
    private ZstdDictDecompress decompression_dict;
    private long nativePtr;

    static {
        l6.a.m0();
    }

    public ZstdDecompressCtx() {
        this.nativePtr = 0;
        this.decompression_dict = null;
        init();
        if (0 == this.nativePtr) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createDeCompressCtx failed");
    }

    private native long decompressByteArray0(byte[] r8, int r10, int r11, byte[] r12, int r13, int r14);

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Decompression context is closed");
    }

    private native void free();

    private native void init();

    private native long loadDDict0(byte[] r8);

    private native long loadDDictFast0(ZstdDictDecompress r8);

    private native long reset0();

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public int decompress(byte[] r8, byte[] r10) {
        return decompressByteArray(r8, 0, r8.length, r10, 0, r10.length);
    }

    public int decompressByteArray(byte[] r8, int r10, int r11, byte[] r12, int r13, int r14) {
        if (this.nativePtr == 0) goto L19;
        acquireSharedLock();
        long r15 = decompressByteArray0(r8, r10, r11, r12, r13, r14);     // Catch: Throwable -> L15
        if (Zstd.isError(r15) == true) goto L14;
        if (r15 > 2147483647L) goto L11;
        int r16 = (int) r15;
        releaseSharedLock();
        return r16;
    L11:
        Zstd.errGeneric();     // Catch: Throwable -> L15
        throw new d("Output size is greater than MAX_INT");     // Catch: Throwable -> L15
    L14:
        throw new d(r15);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L19:
        throw new IllegalStateException("Decompression context is closed");
    }

    @Override // com.bytedance.compression.zstd.a
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdDecompressCtx loadDict(ZstdDictDecompress r8) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        r8.acquireSharedLock();
        long r10 = loadDDictFast0(r8);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        this.decompression_dict = r8;     // Catch: Throwable -> L12
        r8.releaseSharedLock();
        releaseSharedLock();
        return this;
    L11:
        throw new d(r10);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r8.releaseSharedLock();
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Decompression context is closed");
    }

    public void reset() {
        ensureOpen();
        long r8 = reset0();
        if (Zstd.isError(r8) == true) goto L6;
        return;
    L6:
        throw new d(r8);
    }

    public byte[] decompress(byte[] r8, int r10) {
        byte[] r11 = new byte[r10];
        int r12 = decompress(r11, r8);
        if (r12 != r10) goto L5;
        return r11;
    L5:
        return Arrays.copyOfRange(r11, 0, r12);
    }

    public ZstdDecompressCtx loadDict(byte[] r8) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        long r10 = loadDDict0(r8);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        this.decompression_dict = null;     // Catch: Throwable -> L12
        releaseSharedLock();
        return this;
    L11:
        throw new d(r10);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Compression context is closed");
    }
}

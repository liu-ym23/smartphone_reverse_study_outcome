package com.bytedance.compression.zstd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ZstdCompressCtx extends a {
    private ZstdDictCompress compression_dict;
    private long nativePtr;

    static {
        l6.a.m0();
    }

    public ZstdCompressCtx() {
        this.nativePtr = 0;
        this.compression_dict = null;
        init();
        if (0 == this.nativePtr) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createCompressCtx failed");
    }

    private native long compressByteArray0(byte[] r8, int r10, int r11, byte[] r12, int r13, int r14);

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Compression context is closed");
    }

    private native void free();

    private native void init();

    private native long loadCDict0(byte[] r8);

    private native long loadCDictFast0(ZstdDictCompress r8);

    private native long reset0();

    private native void setChecksum0(boolean r8);

    private native void setContentSize0(boolean r8);

    private native void setDictID0(boolean r8);

    private native void setLevel0(int r8);

    private native long setPledgedSrcSize0(long r8);

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public int compress(byte[] r8, byte[] r10) {
        return compressByteArray(r8, 0, r8.length, r10, 0, r10.length);
    }

    public int compressByteArray(byte[] r8, int r10, int r11, byte[] r12, int r13, int r14) {
        if (this.nativePtr == 0) goto L19;
        acquireSharedLock();
        long r15 = compressByteArray0(r8, r10, r11, r12, r13, r14);     // Catch: Throwable -> L15
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
        throw new IllegalStateException("Compression context is closed");
    }

    @Override // com.bytedance.compression.zstd.a
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdCompressCtx loadDict(ZstdDictCompress r8) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        r8.acquireSharedLock();
        long r10 = loadCDictFast0(r8);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        this.compression_dict = r8;     // Catch: Throwable -> L12
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
        throw new IllegalStateException("Compression context is closed");
    }

    public void reset() {
        ensureOpen();
        long r8 = reset0();
        if (Zstd.isError(r8) == true) goto L6;
        return;
    L6:
        throw new d(r8);
    }

    public ZstdCompressCtx setChecksum(boolean r8) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setChecksum0(r8);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setContentSize(boolean r8) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setContentSize0(r8);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setDictID(boolean r8) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setDictID0(r8);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLevel(int r8) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setLevel0(r8);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLong(int r8) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        ZstdCompress.setCompressionLong(this.nativePtr, r8);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public void setPledgedSrcSize(long r8) {
        ensureOpen();
        long r10 = setPledgedSrcSize0(r8);
        if (Zstd.isError(r10) == true) goto L6;
        return;
    L6:
        throw new d(r10);
    }

    public ZstdCompressCtx setWorkers(int r8) {
        acquireSharedLock();
        ZstdCompress.setCompressionWorkers(this.nativePtr, r8);
        releaseSharedLock();
        return this;
    }

    public byte[] compress(byte[] r11) {
        long r8 = ZstdCompress.compressBound(r11.length);
        if (r8 > 2147483647L) goto L6;
        int r10 = (int) r8;
        byte[] r12 = new byte[r10];
        return Arrays.copyOfRange(r12, 0, compressByteArray(r12, 0, r10, r11, 0, r11.length));
    L6:
        Zstd.errGeneric();
        throw new d("Max output size is greater than MAX_INT");
    }

    public ZstdCompressCtx loadDict(byte[] r8) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        long r10 = loadCDict0(r8);     // Catch: Throwable -> L12
        if (Zstd.isError(r10) == true) goto L11;
        this.compression_dict = null;     // Catch: Throwable -> L12
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

package com.bytedance.compression.zstd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ZstdCompressCtx extends a {
    private ZstdDictCompress compression_dict;
    private long nativePtr;

    static {
        h2.a.a();
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

    private native long compressByteArray0(byte[] r10, int r11, int r12, byte[] r13, int r14, int r15);

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Compression context is closed");
    }

    private native void free();

    private native void init();

    private native long loadCDict0(byte[] r10);

    private native long loadCDictFast0(ZstdDictCompress r10);

    private native long reset0();

    private native void setChecksum0(boolean r10);

    private native void setContentSize0(boolean r10);

    private native void setDictID0(boolean r10);

    private native void setLevel0(int r10);

    private native long setPledgedSrcSize0(long r10);

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public int compress(byte[] r10, byte[] r11) {
        return compressByteArray(r10, 0, r10.length, r11, 0, r11.length);
    }

    public byte[] compress(byte[] r11) {
        long r10 = ZstdCompress.compressBound(r11.length);
        if (r10 > 2147483647L) goto L7;
        int r12 = (int) r10;
        byte[] r13 = new byte[r12];
        return Arrays.copyOfRange(r13, 0, compressByteArray(r13, 0, r12, r11, 0, r11.length));
    L7:
        throw new ZstdException(Zstd.errGeneric(), "Max output size is greater than MAX_INT");
    }

    public int compressByteArray(byte[] r10, int r11, int r12, byte[] r13, int r14, int r15) {
        if (this.nativePtr == 0) goto L19;
        acquireSharedLock();
        long r16 = compressByteArray0(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L15
        if (Zstd.isError(r16) == true) goto L14;
        if (r16 > 2147483647L) goto L12;
        int r17 = (int) r16;
        releaseSharedLock();
        return r17;
    L12:
        throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");     // Catch: Throwable -> L15
    L14:
        throw new ZstdException(r16);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L19:
        throw new IllegalStateException("Compression context is closed");
    }

    @Override // com.bytedance.compression.zstd.a
    void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdCompressCtx loadDict(ZstdDictCompress r10) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        r10.acquireSharedLock();
        long r11 = loadCDictFast0(r10);     // Catch: Throwable -> L12
        if (Zstd.isError(r11) == true) goto L11;
        this.compression_dict = r10;     // Catch: Throwable -> L12
        r10.releaseSharedLock();
        releaseSharedLock();
        return this;
    L11:
        throw new ZstdException(r11);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r10.releaseSharedLock();
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx loadDict(byte[] r10) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        long r11 = loadCDict0(r10);     // Catch: Throwable -> L12
        if (Zstd.isError(r11) == true) goto L11;
        this.compression_dict = null;     // Catch: Throwable -> L12
        releaseSharedLock();
        return this;
    L11:
        throw new ZstdException(r11);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Compression context is closed");
    }

    public void reset() {
        ensureOpen();
        long r10 = reset0();
        if (Zstd.isError(r10) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r10);
    }

    public ZstdCompressCtx setChecksum(boolean r10) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setChecksum0(r10);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setContentSize(boolean r10) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setContentSize0(r10);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setDictID(boolean r10) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setDictID0(r10);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLevel(int r10) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setLevel0(r10);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLong(int r10) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        ZstdCompress.setCompressionLong(this.nativePtr, r10);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public void setPledgedSrcSize(long r10) {
        ensureOpen();
        long r11 = setPledgedSrcSize0(r10);
        if (Zstd.isError(r11) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r11);
    }

    public ZstdCompressCtx setWorkers(int r10) {
        acquireSharedLock();
        ZstdCompress.setCompressionWorkers(this.nativePtr, r10);
        releaseSharedLock();
        return this;
    }
}

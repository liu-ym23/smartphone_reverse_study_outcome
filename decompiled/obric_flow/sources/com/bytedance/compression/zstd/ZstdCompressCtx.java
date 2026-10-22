package com.bytedance.compression.zstd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdCompressCtx extends a {
    private ZstdDictCompress compression_dict;
    private long nativePtr;

    static {
        u8.a.w();
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

    private native long compressByteArray0(byte[] r5, int r10, int r11, byte[] r12, int r13, int r14);

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Compression context is closed");
    }

    private native void free();

    private native void init();

    private native long loadCDict0(byte[] r5);

    private native long loadCDictFast0(ZstdDictCompress r5);

    private native long reset0();

    private native void setChecksum0(boolean r5);

    private native void setContentSize0(boolean r5);

    private native void setDictID0(boolean r5);

    private native void setLevel0(int r5);

    private native long setPledgedSrcSize0(long r5);

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public int compress(byte[] r10, byte[] r11) {
        return compressByteArray(r10, 0, r10.length, r11, 0, r11.length);
    }

    public int compressByteArray(byte[] r5, int r10, int r11, byte[] r12, int r13, int r14) {
        if (this.nativePtr == 0) goto L20;
        acquireSharedLock();
        long r15 = compressByteArray0(r5, r10, r11, r12, r13, r14);     // Catch: Throwable -> L13
        if (Zstd.isError(r15) == true) goto L16;
        if (r15 > 2147483647L) goto L12;
        int r16 = (int) r15;
        releaseSharedLock();
        return r16;
    L12:
        throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");     // Catch: Throwable -> L13
    L16:
        throw new ZstdException(r15);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L20:
        throw new IllegalStateException("Compression context is closed");
    }

    @Override // com.bytedance.compression.zstd.a
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdCompressCtx loadDict(ZstdDictCompress r5) {
        if (this.nativePtr == 0) goto L17;
        acquireSharedLock();
        r5.acquireSharedLock();
        long r10 = loadCDictFast0(r5);     // Catch: Throwable -> L10
        if (Zstd.isError(r10) == true) goto L13;
        this.compression_dict = r5;     // Catch: Throwable -> L10
        r5.releaseSharedLock();
        releaseSharedLock();
        return this;
    L13:
        throw new ZstdException(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r5.releaseSharedLock();
        releaseSharedLock();
        throw th;
    L17:
        throw new IllegalStateException("Compression context is closed");
    }

    public void reset() {
        ensureOpen();
        long r5 = reset0();
        if (Zstd.isError(r5) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r5);
    }

    public ZstdCompressCtx setChecksum(boolean r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setChecksum0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setContentSize(boolean r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setContentSize0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setDictID(boolean r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setDictID0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLevel(int r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setLevel0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLong(int r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        ZstdCompress.setCompressionLong(this.nativePtr, r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public void setPledgedSrcSize(long r5) {
        ensureOpen();
        long r10 = setPledgedSrcSize0(r5);
        if (Zstd.isError(r10) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r10);
    }

    public ZstdCompressCtx setWorkers(int r5) {
        acquireSharedLock();
        ZstdCompress.setCompressionWorkers(this.nativePtr, r5);
        releaseSharedLock();
        return this;
    }

    public byte[] compress(byte[] r11) {
        long r5 = ZstdCompress.compressBound(r11.length);
        if (r5 > 2147483647L) goto L7;
        int r10 = (int) r5;
        byte[] r12 = new byte[r10];
        return Arrays.copyOfRange(r12, 0, compressByteArray(r12, 0, r10, r11, 0, r11.length));
    L7:
        throw new ZstdException(Zstd.errGeneric(), "Max output size is greater than MAX_INT");
    }

    public ZstdCompressCtx loadDict(byte[] r5) {
        if (this.nativePtr == 0) goto L17;
        acquireSharedLock();
        long r10 = loadCDict0(r5);     // Catch: Throwable -> L10
        if (Zstd.isError(r10) == true) goto L13;
        this.compression_dict = null;     // Catch: Throwable -> L10
        releaseSharedLock();
        return this;
    L13:
        throw new ZstdException(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L17:
        throw new IllegalStateException("Compression context is closed");
    }
}

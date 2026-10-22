package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDictCompress extends c {
    private int level;
    private long nativePtr;

    static {
        l6.a.m0();
    }

    public ZstdDictCompress(byte[] r8, int r10) {
        this(r8, 0, r8.length, r10);
    }

    private native void free();

    private native void init(byte[] r8, int r10, int r11, int r12);

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.bytedance.compression.zstd.a
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public int level() {
        return this.level;
    }

    public ZstdDictCompress(byte[] r8, int r10, int r11, int r12) {
        this.nativePtr = 0;
        ZstdCompress.defaultCompressionLevel();
        this.level = r12;
        if ((r8.length - r10) < 0) goto L11;
        init(r8, r10, r11, r12);
        if (0 == this.nativePtr) goto L9;
        storeFence();
        return;
    L9:
        throw new IllegalStateException("ZSTD_createCDict failed");
    L11:
        throw new IllegalArgumentException("Dictionary buffer is to short");
    }
}

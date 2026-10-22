package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdDictCompress extends d {
    private int level;
    private long nativePtr;

    static {
        u8.a.w();
    }

    public ZstdDictCompress(byte[] r5, int r10, int r11, int r12) {
        this.nativePtr = 0;
        ZstdCompress.defaultCompressionLevel();
        this.level = r12;
        if ((r5.length - r10) < 0) goto L11;
        init(r5, r10, r11, r12);
        if (0 == this.nativePtr) goto L9;
        storeFence();
        return;
    L9:
        throw new IllegalStateException("ZSTD_createCDict failed");
    L11:
        throw new IllegalArgumentException("Dictionary buffer is to short");
    }

    private native void free();

    private native void init(byte[] r5, int r10, int r11, int r12);

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

    public ZstdDictCompress(byte[] r5, int r10) {
        this(r5, 0, r5.length, r10);
    }
}

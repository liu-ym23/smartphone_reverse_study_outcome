package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDictDecompress extends c {
    private long nativePtr;

    static {
        l6.a.m0();
    }

    public ZstdDictDecompress(byte[] r8) {
        this(r8, 0, r8.length);
    }

    private native void free();

    private native void init(byte[] r8, int r10, int r11);

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

    public ZstdDictDecompress(byte[] r8, int r10, int r11) {
        this.nativePtr = 0;
        init(r8, r10, r11);
        if (this.nativePtr == 0) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createDDict failed");
    }
}

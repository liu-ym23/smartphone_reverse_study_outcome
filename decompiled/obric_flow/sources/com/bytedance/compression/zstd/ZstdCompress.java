package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdCompress {
    static {
        u8.a.w();
    }

    public ZstdCompress() {
    }

    public static byte[] compress(byte[] r5) throws ZstdException {
        return compress(r5, defaultCompressionLevel());
    }

    public static native long compressBound(long r5);

    public static native int defaultCompressionLevel();

    public static native int loadDictCompress(long r5, byte[] r10, int r11);

    public static native int loadFastDictCompress(long r5, ZstdDictCompress r10);

    public static native int maxCompressionLevel();

    public static native int minCompressionLevel();

    public static native int setCompressionChecksums(long r5, boolean r10);

    public static native int setCompressionLevel(long r5, int r10);

    public static native int setCompressionLong(long r5, int r10);

    public static native int setCompressionWorkers(long r5, int r10);

    public static byte[] compress(byte[] r5, int r10) throws ZstdException {
        ZstdCompressCtx r11 = new ZstdCompressCtx();
        r11.setLevel(r10);     // Catch: Throwable -> L6
        byte[] r12 = r11.compress(r5);     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static byte[] compress(byte[] r5, ZstdDictCompress r10) throws ZstdException {
        ZstdCompressCtx r11 = new ZstdCompressCtx();
        r11.loadDict(r10);     // Catch: Throwable -> L6
        r11.setLevel(r10.level());     // Catch: Throwable -> L6
        byte[] r12 = r11.compress(r5);     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static byte[] compress(byte[] r5, byte[] r10, int r11) throws ZstdException {
        ZstdCompressCtx r12 = new ZstdCompressCtx();
        r12.loadDict(r10);     // Catch: Throwable -> L6
        r12.setLevel(r11);     // Catch: Throwable -> L6
        byte[] r13 = r12.compress(r5);     // Catch: Throwable -> L6
        r12.close();
        return r13;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }
}

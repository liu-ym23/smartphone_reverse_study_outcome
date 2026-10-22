package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdCompress {
    static {
        l6.a.m0();
    }

    public ZstdCompress() {
    }

    public static int compress(byte[] r8, int r10, int r11, byte[] r12, int r13, int r14, int r15) {
        ZstdCompressCtx r16 = new ZstdCompressCtx();
        r16.setLevel(r15);     // Catch: Throwable -> L6
        int r17 = r16.compressByteArray(r8, r10, r11, r12, r13, r14);     // Catch: Throwable -> L6
        r16.close();
        return r17;
    L6:
        th = move-exception;
        r16.close();
        throw th;
    }

    public static native long compressBound(long r8);

    public static native int defaultCompressionLevel();

    public static native int loadDictCompress(long r8, byte[] r10, int r11);

    public static native int loadFastDictCompress(long r8, ZstdDictCompress r10);

    public static native int maxCompressionLevel();

    public static native int minCompressionLevel();

    public static native int setCompressionChecksums(long r8, boolean r10);

    public static native int setCompressionLevel(long r8, int r10);

    public static native int setCompressionLong(long r8, int r10);

    public static native int setCompressionWorkers(long r8, int r10);

    public static int compress(byte[] r8, int r10, int r11, byte[] r12, int r13, int r14, ZstdDictCompress r15) {
        ZstdCompressCtx r16 = new ZstdCompressCtx();
        r16.loadDict(r15);     // Catch: Throwable -> L6
        r16.setLevel(r15.level());     // Catch: Throwable -> L6
        int r17 = r16.compressByteArray(r8, r10, r11, r12, r13, r14);     // Catch: Throwable -> L6
        r16.close();
        return r17;
    L6:
        th = move-exception;
        r16.close();
        throw th;
    }

    public static byte[] compress(byte[] r8) {
        return compress(r8, defaultCompressionLevel());
    }

    public static byte[] compress(byte[] r8, int r10) {
        ZstdCompressCtx r11 = new ZstdCompressCtx();
        r11.setLevel(r10);     // Catch: Throwable -> L6
        byte[] r12 = r11.compress(r8);     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static byte[] compress(byte[] r8, ZstdDictCompress r10) {
        ZstdCompressCtx r11 = new ZstdCompressCtx();
        r11.loadDict(r10);     // Catch: Throwable -> L6
        r11.setLevel(r10.level());     // Catch: Throwable -> L6
        byte[] r12 = r11.compress(r8);     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static byte[] compress(byte[] r8, byte[] r10, int r11) {
        ZstdCompressCtx r12 = new ZstdCompressCtx();
        r12.loadDict(r10);     // Catch: Throwable -> L6
        r12.setLevel(r11);     // Catch: Throwable -> L6
        byte[] r13 = r12.compress(r8);     // Catch: Throwable -> L6
        r12.close();
        return r13;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }
}

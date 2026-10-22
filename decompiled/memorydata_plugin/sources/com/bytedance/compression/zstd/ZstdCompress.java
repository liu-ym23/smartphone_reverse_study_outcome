package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdCompress {
    static {
        com.bytedance.compression.zstd.a.a.a();
    }

    public ZstdCompress() {
    }

    public static int compress(byte[] r8, int r9, int r10, byte[] r11, int r12, int r13, int r14) {
        ZstdCompressCtx r7 = new ZstdCompressCtx();
        r7.setLevel(r14);     // Catch: Throwable -> L6
        int r15 = r7.compressByteArray(r8, r9, r10, r11, r12, r13);     // Catch: Throwable -> L6
        r7.close();
        return r15;
    L6:
        th = move-exception;
        r7.close();
        throw th;
    }

    public static int compress(byte[] r8, int r9, int r10, byte[] r11, int r12, int r13, ZstdDictCompress r14) {
        ZstdCompressCtx r7 = new ZstdCompressCtx();
        r7.loadDict(r14);     // Catch: Throwable -> L6
        r7.setLevel(r14.level());     // Catch: Throwable -> L6
        int r15 = r7.compressByteArray(r8, r9, r10, r11, r12, r13);     // Catch: Throwable -> L6
        r7.close();
        return r15;
    L6:
        th = move-exception;
        r7.close();
        throw th;
    }

    public static byte[] compress(byte[] r1) {
        return compress(r1, defaultCompressionLevel());
    }

    public static byte[] compress(byte[] r1, int r2) {
        ZstdCompressCtx r0 = new ZstdCompressCtx();
        r0.setLevel(r2);     // Catch: Throwable -> L6
        byte[] r3 = r0.compress(r1);     // Catch: Throwable -> L6
        r0.close();
        return r3;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static byte[] compress(byte[] r1, ZstdDictCompress r2) {
        ZstdCompressCtx r0 = new ZstdCompressCtx();
        r0.loadDict(r2);     // Catch: Throwable -> L6
        r0.setLevel(r2.level());     // Catch: Throwable -> L6
        byte[] r3 = r0.compress(r1);     // Catch: Throwable -> L6
        r0.close();
        return r3;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static byte[] compress(byte[] r1, byte[] r2, int r3) {
        ZstdCompressCtx r0 = new ZstdCompressCtx();
        r0.loadDict(r2);     // Catch: Throwable -> L6
        r0.setLevel(r3);     // Catch: Throwable -> L6
        byte[] r4 = r0.compress(r1);     // Catch: Throwable -> L6
        r0.close();
        return r4;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static native long compressBound(long r0);

    public static native int defaultCompressionLevel();

    static native int loadDictCompress(long r0, byte[] r2, int r3);

    static native int loadFastDictCompress(long r0, ZstdDictCompress r2);

    public static native int maxCompressionLevel();

    public static native int minCompressionLevel();

    static native int setCompressionChecksums(long r0, boolean r2);

    static native int setCompressionLevel(long r0, int r2);

    static native int setCompressionLong(long r0, int r2);

    static native int setCompressionWorkers(long r0, int r2);
}

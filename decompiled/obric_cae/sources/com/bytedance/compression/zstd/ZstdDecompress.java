package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDecompress {
    static {
        l6.a.m0();
    }

    public ZstdDecompress() {
    }

    public static byte[] decompress(byte[] r8) {
        long r10 = decompressedSize(r8);
        if (r10 <= 2147483647L) goto L5;
        Zstd.errGeneric();
        throw new d("original size is greater than MAX_INT");
    L5:
        return decompress(r8, (int) r10);
    }

    public static long decompressedSize(byte[] r8) {
        return decompressedSize(r8, 0);
    }

    private static native long decompressedSize0(byte[] r8, int r10, int r11);

    public static native int loadDictDecompress(long r8, byte[] r10, int r11);

    public static native int loadFastDictDecompress(long r8, ZstdDictDecompress r10);

    public static byte[] decompress(byte[] r8, int r10) {
        ZstdDecompressCtx r11 = new ZstdDecompressCtx();
        byte[] r12 = r11.decompress(r8, r10);     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static long decompressedSize(byte[] r8, int r10) {
        return decompressedSize(r8, r10, r8.length - r10);
    }

    public static byte[] decompress(byte[] r8, ZstdDictDecompress r10) {
        long r11 = decompressedSize(r8);
        if (r11 <= 2147483647L) goto L5;
        Zstd.errGeneric();
        throw new d("original size is greater than MAX_INT");
    L5:
        return decompress(r8, r10, (int) r11);
    }

    public static long decompressedSize(byte[] r8, int r10, int r11) {
        if (r10 >= r8.length) goto L11;
        int r12 = r10 + r11;
        if (r12 > r8.length) goto L9;
        return decompressedSize0(r8, r10, r11);
    L9:
        throw new ArrayIndexOutOfBoundsException(r12);
    L11:
        throw new ArrayIndexOutOfBoundsException(r10);
    }

    public static byte[] decompress(byte[] r8, ZstdDictDecompress r10, int r11) {
        ZstdDecompressCtx r12 = new ZstdDecompressCtx();
        r12.loadDict(r10);     // Catch: Throwable -> L6
        byte[] r13 = r12.decompress(r8, r11);     // Catch: Throwable -> L6
        r12.close();
        return r13;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }

    public static byte[] decompress(byte[] r8, byte[] r10) {
        long r11 = decompressedSize(r8);
        if (r11 <= 2147483647L) goto L5;
        Zstd.errGeneric();
        throw new d("original size is greater than MAX_INT");
    L5:
        return decompress(r8, r10, (int) r11);
    }

    public static byte[] decompress(byte[] r8, byte[] r10, int r11) {
        ZstdDecompressCtx r12 = new ZstdDecompressCtx();
        r12.loadDict(r10);     // Catch: Throwable -> L6
        byte[] r13 = r12.decompress(r8, r11);     // Catch: Throwable -> L6
        r12.close();
        return r13;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }
}

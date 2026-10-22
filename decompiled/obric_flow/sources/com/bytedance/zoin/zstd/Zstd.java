package com.bytedance.zoin.zstd;

/* JADX INFO: loaded from: classes2.dex */
public class Zstd {
    static {
        monitor-enter(cl.a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (cl.a.f1217a == false) goto L8;
        monitor-exit(cl.a.class);
        return;
    L8:
        System.loadLibrary("zstd-jni-decompress");     // Catch: Throwable -> L11
        cl.a.f1217a = true;     // Catch: Throwable -> L11
        monitor-exit(cl.a.class);     // Catch: Throwable -> L11
    }

    public Zstd() {
    }

    public static native long getErrorCode(long r5);

    public static native String getErrorName(long r5);

    public static native boolean isError(long r5);

    public static native int loadDictDecompress(long r5, byte[] r10, int r11);

    public static native int loadFastDictDecompress(long r5, ZstdDictDecompress r10);
}

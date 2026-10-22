package com.bytedance.zoin.zstd;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdDictDecompress extends bl.a {
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

    private native void free();

    private native void init(byte[] r5, int r10, int r11);
}

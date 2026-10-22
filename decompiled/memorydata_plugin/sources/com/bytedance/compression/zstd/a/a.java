package com.bytedance.compression.zstd.a;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2201a = false;

    static {
    }

    public static synchronized void a() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f2201a == false) goto L8;
        monitor-exit(a.class);
        return;
    L8:
        System.loadLibrary("bdzstd");     // Catch: Throwable -> L11
        f2201a = true;     // Catch: Throwable -> L11
        monitor-exit(a.class);
    }
}

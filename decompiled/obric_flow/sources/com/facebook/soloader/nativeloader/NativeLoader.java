package com.facebook.soloader.nativeloader;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NativeLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NativeLoaderDelegate f8492a;

    public static synchronized void a(NativeLoaderDelegate r5) {
        monitor-enter(NativeLoader.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f8492a != null) goto L12;
        f8492a = r5;     // Catch: Throwable -> L9
        monitor-exit(NativeLoader.class);
        return;
    L12:
        throw new IllegalStateException("Cannot re-initialize NativeLoader.");     // Catch: Throwable -> L9
    }

    public static synchronized boolean a() {
        monitor-enter(NativeLoader.class);
        NativeLoaderDelegate r5 = f8492a;     // Catch: Throwable -> L11
        monitor-exit(NativeLoader.class);
        if (r5 == null) goto L9;
        return true;
    L9:
        return false;
    L11:
        th = move-exception;
        throw th;
    }
}

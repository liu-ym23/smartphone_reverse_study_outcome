package com.bytedance.applog.log;

/* JADX INFO: loaded from: classes.dex */
public class NativeLogWrapper {
    public NativeLogWrapper() {
    }

    public static void a() {
        nativeSetLogEnable(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    private static native void nativeSetLogEnable(boolean r8);
}

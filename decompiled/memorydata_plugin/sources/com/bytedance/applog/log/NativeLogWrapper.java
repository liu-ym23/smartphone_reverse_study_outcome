package com.bytedance.applog.log;

/* JADX INFO: loaded from: classes.dex */
public class NativeLogWrapper {
    public NativeLogWrapper() {
    }

    public static void a(boolean r0) {
        nativeSetLogEnable(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private static native void nativeSetLogEnable(boolean r0);
}

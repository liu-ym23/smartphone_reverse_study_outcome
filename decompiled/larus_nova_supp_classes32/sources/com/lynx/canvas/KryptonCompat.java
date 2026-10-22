package com.lynx.canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonCompat {
    public KryptonCompat() {
    }

    private static native long nativeEnsureTaskRunnerForCurrentThread();

    public static long EnsureTaskRunnerForCurrentThread() {
        return nativeEnsureTaskRunnerForCurrentThread();
    }
}

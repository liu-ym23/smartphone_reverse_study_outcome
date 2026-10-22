package com.bytedance.platform.godzilla.sysopt;

/* JADX INFO: loaded from: classes2.dex */
public class PthreadCreateHook {
    static {
        System.loadLibrary("godzilla-sysopt");
    }

    private PthreadCreateHook() {
    }

    public static native void end();

    public static native void start(int r0);
}

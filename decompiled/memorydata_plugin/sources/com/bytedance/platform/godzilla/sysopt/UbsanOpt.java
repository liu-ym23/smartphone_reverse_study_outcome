package com.bytedance.platform.godzilla.sysopt;

/* JADX INFO: loaded from: classes2.dex */
public final class UbsanOpt {
    static {
        System.loadLibrary("godzilla-sysopt");
    }

    private UbsanOpt() {
    }

    public static native void end();

    public static native void start();
}

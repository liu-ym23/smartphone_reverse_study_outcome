package com.bytedance.article.common.nativecrash;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class NativeCrashInit {
    static {
        System.loadLibrary("ttnativecrash");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        Log.e("womendejia", Log.getStackTraceString(e));
    }

    public NativeCrashInit() {
    }

    private static native boolean Register(String r8, String r10);

    private static native void Unregister();

    private static native void makecrash();
}

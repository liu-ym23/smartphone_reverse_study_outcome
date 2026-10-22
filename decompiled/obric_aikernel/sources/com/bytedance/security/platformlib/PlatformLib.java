package com.bytedance.security.platformlib;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class PlatformLib {
    static {
        System.loadLibrary("platform_jni");
    }

    public PlatformLib() {
    }

    public native byte[] init(int r10, int r11, String r12, String r13, Bundle r14);
}

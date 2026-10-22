package com.bytedance.security.platformlib;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class PlatformLib {
    static {
        System.loadLibrary("platform_jni");
    }

    public PlatformLib() {
    }

    public native byte[] init(int r8, int r10, String r11, String r12, Bundle r13);
}

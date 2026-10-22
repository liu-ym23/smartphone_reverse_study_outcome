package com.bytedance.security.platformlib;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class PlatformLib {
    static {
        System.loadLibrary("platform_jni");
    }

    public PlatformLib() {
    }

    public native byte[] init(int r1, int r2, String r3, String r4, Bundle r5);
}

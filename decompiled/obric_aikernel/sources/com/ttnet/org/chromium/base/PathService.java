package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public abstract class PathService {
    public static final int DIR_MODULE = 3;

    interface Natives {
        void override(int r10, String r11);
    }

    private PathService() {
    }

    public static void override(int r10, String r11) {
        PathServiceJni.get().override(r10, r11);
    }
}

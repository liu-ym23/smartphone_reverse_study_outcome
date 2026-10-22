package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
public abstract class PathService {
    public static final int DIR_MODULE = 3;

    interface Natives {
        void override(int r1, String r2);
    }

    private PathService() {
    }

    public static void override(int r1, String r2) {
        PathServiceJni.get().override(r1, r2);
    }
}

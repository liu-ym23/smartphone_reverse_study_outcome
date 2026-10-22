package com.obric.aikernel.utils;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class JniUtils {
    public static final JniUtils INSTANCE = null;

    static {
        INSTANCE = new JniUtils();
        System.loadLibrary("aikernel_utils");
    }

    private JniUtils() {
    }

    public final native int getThreadTid();

    public final native void setEnv(String r10, String r11);
}

package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public final class StatisticsRecorderAndroid {
    private StatisticsRecorderAndroid() {
    }

    private static native String nativeToJson(int r8);

    public static String toJson(int r8) {
        return nativeToJson(r8);
    }
}

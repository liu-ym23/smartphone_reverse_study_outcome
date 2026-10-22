package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public final class StatisticsRecorderAndroid {

    interface Natives {
        String toJson(int r10);
    }

    private StatisticsRecorderAndroid() {
    }

    public static String toJson(int r10) {
        return StatisticsRecorderAndroidJni.get().toJson(r10);
    }
}

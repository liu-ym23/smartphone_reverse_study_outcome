package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;

/* JADX INFO: loaded from: classes2.dex */
@DoNotOptimize
@TargetApi(18)
class Api18TraceUtils {
    public Api18TraceUtils() {
    }

    public static void a(String r5) {
        String r10 = "SoLoader_".concat(r5);
        if (r10.length() <= 127) goto L5;
        r10 = "SoLoader" + "_".substring(0, 119 - r5.length()) + r5;
    L5:
        Trace.beginSection(r10);
    }

    public static void a() {
        Trace.endSection();
    }
}

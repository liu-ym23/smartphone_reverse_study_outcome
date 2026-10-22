package com.bytedance.apm6.util;

import android.os.Build;
import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public class TraceUtils {
    public TraceUtils() {
    }

    public static void beginSection(String r2) {
        if (ApmBaseContext.isSystraceMode() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 18) goto L9;
        Trace.beginSection(r2);
        return;
    }

    public static void endSection() {
        if (ApmBaseContext.isSystraceMode() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 18) goto L9;
        Trace.endSection();
        return;
    }
}

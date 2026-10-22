package com.lynx.tasm.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public i() {
    }

    public static float a(double r0) {
        return b((float) r0, 0.0f);
    }

    public static float c(float r1) {
        return r1 / DisplayMetricsHolder.getScreenDisplayMetrics().density;
    }

    public static float b(float r1, float r2) {
        if (r2 > 0.0f) goto L6;
        r2 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
    L6:
        return r1 * r2;
    }
}

package com.bumptech.glide.util;

import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f981a = 0.0d;

    static {
        double r1 = 1.0d;
        if (Build.VERSION.SDK_INT < 17) goto L5;
        r1 = 1.0d / Math.pow(10.0d, 6.0d);
    L5:
        f981a = r1;
    }

    public static double a(long r2) {
        return (a() - r2) * f981a;
    }

    public static long a() {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return SystemClock.elapsedRealtimeNanos();
    L7:
        return SystemClock.uptimeMillis();
    }
}

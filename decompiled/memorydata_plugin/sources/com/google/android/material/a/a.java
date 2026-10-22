package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f3741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f3742b = null;
    public static final TimeInterpolator c = null;
    public static final TimeInterpolator d = null;
    public static final TimeInterpolator e = null;

    static {
        f3741a = new LinearInterpolator();
        f3742b = new FastOutSlowInInterpolator();
        c = new FastOutLinearInInterpolator();
        d = new LinearOutSlowInInterpolator();
        e = new DecelerateInterpolator();
    }

    public static float a(float r0, float r1, float r2) {
        return r0 + (r2 * (r1 - r0));
    }

    public static float a(float r1, float r2, float r3, float r4, float r5) {
        if (r5 >= r3) goto L6;
        return r1;
    L6:
        if (r5 <= r4) goto L9;
        return r2;
    L9:
        return a(r1, r2, (r5 - r3) / (r4 - r3));
    }

    public static int a(int r0, int r1, float r2) {
        return r0 + Math.round(r2 * (r1 - r0));
    }
}

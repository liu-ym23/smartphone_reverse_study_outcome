package com.google.android.material.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3753b;
    private TimeInterpolator c;
    private int d;
    private int e;

    public i(long r3, long r5) {
        this.f3752a = 0;
        this.f3753b = 300;
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.f3752a = r3;
        this.f3753b = r5;
    }

    public i(long r3, long r5, TimeInterpolator r7) {
        TimeInterpolator r8 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r7, TimeInterpolator.class, "com.obric.memorydata.plugin");
        this.f3752a = 0;
        this.f3753b = 300;
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.f3752a = r3;
        this.f3753b = r5;
        this.c = r8;
    }

    static i a(ValueAnimator r7) {
        i r6 = new i(r7.getStartDelay(), r7.getDuration(), b(r7));
        r6.d = r7.getRepeatCount();
        r6.e = r7.getRepeatMode();
        return r6;
    }

    private static TimeInterpolator b(ValueAnimator r1) {
        TimeInterpolator r2 = r1.getInterpolator();
        if (ZeusTransformUtils.instanceOf(r2, AccelerateDecelerateInterpolator.class) == true) goto L15;
        if (r2 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r2, AccelerateInterpolator.class) == false) goto L11;
        return a.c;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, DecelerateInterpolator.class) == true) goto L13;
        return r2;
    L13:
        return a.d;
    L15:
        return a.f3742b;
    }

    public long a() {
        return this.f3752a;
    }

    public void a(Animator r4) {
        r4.setStartDelay(a());
        r4.setDuration(b());
        r4.setInterpolator(c());
        if (ZeusTransformUtils.instanceOf(r4, ValueAnimator.class) == false) goto L6;
        ((ValueAnimator) ZeusTransformUtils.preCheckCast(r4, ValueAnimator.class, "com.obric.memorydata.plugin")).setRepeatCount(d());
        ((ValueAnimator) ZeusTransformUtils.preCheckCast(r4, ValueAnimator.class, "com.obric.memorydata.plugin")).setRepeatMode(e());
        return;
    }

    public long b() {
        return this.f3753b;
    }

    public TimeInterpolator c() {
        TimeInterpolator r0 = this.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return a.f3742b;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, i.class) == true) goto L9;
        return false;
    L9:
        i r7 = (i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.memorydata.plugin");
        if (a() == r7.a()) goto L13;
        return false;
    L13:
        if (b() == r7.b()) goto L16;
        return false;
    L16:
        if (d() == r7.d()) goto L19;
        return false;
    L19:
        if (e() == r7.e()) goto L22;
        return false;
    L22:
        return c().getClass().equals(r7.c().getClass());
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }
}

package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f13701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f13702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f13703c;
    public float d;
    public float e;
    public float f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DisplayMetrics f13705i;

    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f13702b = -1;
        this.f13703c = new e();
        this.f13704h = true;
        this.f13705i = r5.getResources().getDisplayMetrics();
    }

    public final void a() {
        if (this.f13702b != (-1)) goto L6;
        return;
    L6:
        if (this.g != 1) goto L8;
        return;
    L8:
        d r5 = this.f13703c.b(AnimationUtils.currentAnimationTimeMillis() - this.f13702b);
        this.d = TypedValue.applyDimension(1, r5.f13710a, this.f13705i);
        boolean r10 = r5.f13711b;
        this.f13704h = r10;
        if (r10 == false) goto L12;
        this.g = 0;
        return;
    }

    public final void b(int r5) {
        float r10 = (r5 / 1000.0f) / this.f13705i.density;
        this.f13702b = AnimationUtils.currentAnimationTimeMillis();
        this.f13703c.a(r10, 0.0f);
        this.g = 2;
        this.f13704h = false;
    }

    public final float c(float r10, boolean r11, boolean r12) {
        if (Math.signum(r10) != Math.signum(this.d)) goto L5;
        boolean r5 = true;
    L7:
        if (r5 != r11) goto L55;
        if (r12 == true) goto L55;
        DisplayMetrics r13 = this.f13705i;
        float r14 = r13.density;
        float r15 = r10 / r14;
        if (this.g == 1) goto L25;
        float r16 = Math.abs(this.d / r14);
        float r17 = this.f13701a;
        if (r16 >= 0.0f) goto L15;
    L18:
        float r18 = 0.0f;
    L19:
        float r19 = r18 * (-Math.signum(this.d));
        this.e = r19;
        if (r19 != 0.0f) goto L22;
        float r20 = Math.signum(r15);
    L23:
        this.f = r20;
    L27:
        float r21 = this.e;
        float r22 = r15 + r21;
        this.e = r22;
        float r23 = Math.signum(r22);
        float r24 = this.f;
        if (r23 == r24) goto L33;
        if (r24 == 0.0f) goto L33;
        if (r11 == false) goto L37;
        this.e = 0.0f;
        this.f = 0.0f;
        r22 = 0.0f;
    L38:
        float r110 = Math.abs(r22);
        float r25 = this.f13701a;
        if (r110 >= 0.0f) goto L41;
    L44:
        float r26 = 0.0f;
    L45:
        this.d = TypedValue.applyDimension(1, Math.signum(r22) * (-r26), r13);
        this.g = 1;
        this.f13704h = false;
        if (r5 == false) goto L54;
        if (r22 == 0.0f) goto L50;
        return r10;
    L50:
        if (r21 != 0.0f) goto L57;
        return r10;
    L57:
        return -TypedValue.applyDimension(1, r21, r13);
    L54:
        return 0.0f;
    L41:
        if (r25 <= 0.0f) goto L44;
        r26 = (1.0f - (1.0f / (((r110 / r25) * 0.55f) + 1.0f))) * r25;
        goto L45
    L37:
        this.f = Math.signum(r22);
    L33:
        if (this.e != 0.0f) goto L38;
        this.f = 0.0f;
        goto L38
    L22:
        r20 = Math.signum(r19);
        goto L23
    L15:
        if (r17 <= 0.0f) goto L18;
        float r27 = RangesKt.coerceAtMost(r16, r17 - 1.0E-5f);
        r18 = ((r17 * r27) / (r17 - r27)) / 0.55f;
        goto L19
    L25:
        if (this.f != 0.0f) goto L27;
        this.f = Math.signum(r15);
    L55:
        return 0.0f;
    L5:
        r5 = false;
        goto L7
    }
}

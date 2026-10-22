package com.ss.android.lark.reaction.widget.detailwindow.scroller;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.profile.v2.entity.BaseField;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    public static final float[] y = null;
    public static final float z = 0.0f;
    public final Interpolator a;
    public final float b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public float p;
    public boolean q;
    public final boolean r;
    public float s;
    public float t;
    public int u;
    public float v;
    public float w;
    public final float x;

    public static class a implements Interpolator {
        public static final float a = 0.0f;
        public static final float b = 0.0f;

        public a() {
        }

        static {
            float r1 = 1.0f / a(1.0f);
            a = r1;
            b = 1.0f - (r1 * a(1.0f));
        }

        public static float a(float r3) {
            float r4 = r3 * 8.0f;
            if (r4 >= 1.0f) goto L6;
            return r4 - (1.0f - ((float) Math.exp(-r4)));
        L6:
            return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - r4))) * 0.63212055f);
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r2) {
            float r0 = a * a(r2);
            if (r0 > 0.0f) goto L5;
            return r0;
        L5:
            return r0 + b;
        }
    }

    static {
        y = new float[BaseField.FIELD_TYPE_S_PHONE_NUMBER];
        z = (float) (Math.log(0.78d) / Math.log(0.9d));
        float r0 = 0.0f;
        float r1 = 0.0f;
        int r2 = 0;
    L4:
        if (r2 >= 100) goto L20;
        float r5 = r2 / 100.0f;
        float r3 = 1.0f;
    L6:
        float r6 = ((r3 - r0) / 2.0f) + r0;
        float r10 = 1.0f - r6;
        float r9 = (r6 * 3.0f) * r10;
        float r12 = (r6 * r6) * r6;
        float r11 = (((0.175f * r10) + (0.35000002f * r6)) * r9) + r12;
        if (Math.abs(r11 - r5) < 1.0E-5d) goto L8;
        if (r11 > r5) goto L18;
        r0 = r6;
        goto L6
    L18:
        r3 = r6;
        goto L6
    L8:
        y[r2] = (r9 * ((r10 * 0.5f) + r6)) + r12;
        float r4 = 1.0f;
    L9:
        float r7 = ((r4 - r1) / 2.0f) + r1;
        float r13 = 1.0f - r7;
        float r14 = (((r7 * 3.0f) * r13) * ((r13 * 0.5f) + r7)) + ((r7 * r7) * r7);
        if (Math.abs(r14 - r5) < 1.0E-5d) goto L11;
        if (r14 > r5) goto L14;
        r1 = r7;
        goto L9
    L14:
        r4 = r7;
        goto L9
    L11:
        r2 = r2 + 1;
        goto L4
    L20:
        y[100] = 1.0f;
    }

    public final boolean a() {
        if (this.q == false) goto L6;
        return false;
    L6:
        int r1 = (int) (AnimationUtils.currentAnimationTimeMillis() - this.n);
        int r0 = this.o;
        if (r1 >= r0) goto L22;
        int r3 = this.c;
        float r4 = 0.0f;
        if (r3 == 0) goto L21;
        if (r3 != 1) goto L23;
        float r2 = r1 / r0;
        int r5 = (int) (r2 * 100.0f);
        if (r5 >= 100) goto L15;
        float r6 = r5 / 100.0f;
        int r7 = r5 + 1;
        float[] r8 = y;
        float r9 = r8[r5];
        float r10 = (r8[r7] - r9) / ((r7 / 100.0f) - r6);
        float r11 = r9 + ((r2 - r6) * r10);
        r4 = r10;
    L16:
        this.t = ((r4 * this.u) / r0) * 1000.0f;
        int r12 = this.d;
        int r13 = r12 + Math.round((this.f - r12) * r11);
        this.l = r13;
        int r14 = Math.min(r13, this.i);
        this.l = r14;
        this.l = Math.max(r14, this.h);
        int r15 = this.e;
        int r16 = r15 + Math.round(r11 * (this.g - r15));
        this.m = r16;
        int r17 = Math.min(r16, this.k);
        this.m = r17;
        int r18 = Math.max(r17, this.j);
        this.m = r18;
        if (this.l != this.f) goto L23;
        if (r18 != this.g) goto L23;
        this.q = true;
        goto L23
    L15:
        r11 = 1.0f;
    L23:
        return true;
    L21:
        float r19 = this.a.getInterpolation(r1 * 0.0f);
        this.l = this.d + Math.round(0.0f * r19);
        this.m = this.e + Math.round(r19 * this.p);
        goto L23
    L22:
        this.l = this.f;
        this.m = this.g;
        this.q = true;
        goto L23
    }

    public k(Context r4, boolean r5) {
        this.v = ViewConfiguration.getScrollFriction();
        this.q = true;
        this.a = new a();
        Resources r6 = r4.getResources();
        float r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density * 160.0f;
        this.b = r7;
        float r2 = r7 * 386.0878f;
        this.w = r2 * ViewConfiguration.getScrollFriction();
        this.r = r5;
        this.x = (r7 * 386.0878f) * 0.84f;
    }

    public final void b(int r15, int r16, int r17) {
        if (this.r == true) goto L5;
    L15:
        int r7 = r16;
    L16:
        int r5 = r7;
        int r2 = 0;
    L17:
        this.c = 1;
        this.q = false;
        float r4 = (float) Math.hypot(r2, r5);
        this.s = r4;
        double r8 = Math.log((Math.abs(r4) * 0.35f) / (this.v * this.x));
        float r6 = z;
        this.o = (int) (Math.exp(r8 / (((double) r6) - 1.0d)) * 1000.0d);
        this.n = AnimationUtils.currentAnimationTimeMillis();
        this.d = 0;
        this.e = r15;
        float r9 = 1.0f;
        if (r4 != 0.0f) goto L20;
        float r3 = 1.0f;
    L21:
        if (r4 == 0.0f) goto L24;
        r9 = r5 / r4;
    L24:
        double r10 = r6;
        double r12 = ((double) (this.v * this.x)) * Math.exp((r10 / (r10 - 1.0d)) * Math.log((Math.abs(r4) * 0.35f) / (this.v * this.x)));
        this.u = (int) (((double) Math.signum(r4)) * r12);
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = r17;
        int r11 = 0 + ((int) Math.round(((double) r3) * r12));
        this.f = r11;
        int r13 = Math.min(r11, this.i);
        this.f = r13;
        this.f = Math.max(r13, this.h);
        int r14 = ((int) Math.round(r12 * ((double) r9))) + r15;
        this.g = r14;
        int r1 = Math.min(r14, this.k);
        this.g = r1;
        this.g = Math.max(r1, this.j);
        return;
    L20:
        r3 = r2 / r4;
        goto L21
    L5:
        if (this.q == true) goto L15;
        if (this.c != 1) goto L9;
        float r18 = this.t;
    L10:
        float r19 = this.f - this.d;
        float r20 = this.g - this.e;
        float r21 = (float) Math.hypot(r19, r20);
        float r22 = (r19 / r21) * r18;
        float r23 = (r20 / r21) * r18;
        float r24 = 0;
        if (Math.signum(r24) != Math.signum(r22)) goto L15;
        r7 = r16;
        float r25 = r7;
        if (Math.signum(r25) != Math.signum(r23)) goto L16;
        r2 = (int) (r24 + r22);
        r5 = (int) (r25 + r23);
        goto L17
    L9:
        r18 = this.s - ((this.w * ((int) (AnimationUtils.currentAnimationTimeMillis() - this.n))) / 2000.0f);
        goto L10
    }
}

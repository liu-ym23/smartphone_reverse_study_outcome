package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f12798c;
    public final int d;
    public final gr.e e;
    public final ug.d f;
    public final Interpolator g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12800i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12801j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f12802k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f12803l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f12804m;

    public h0(ug.d r5, q r10, int r11, int r12, int r13, Interpolator r14, int r15, int r16) {
        this.e = new gr.e(1);
        this.f12799h = false;
        this.f12803l = new Rect();
        this.f12804m = false;
        this.f = r5;
        this.f12798c = r10;
        this.d = r12;
        this.f12802k = System.nanoTime();
        if (((ArrayList) r5.f) != null) goto L5;
        r5.f = new ArrayList();
    L5:
        ((ArrayList) r5.f).add(this);
        this.g = r14;
        this.f12796a = r15;
        this.f12797b = r16;
        if (r13 != 3) goto L8;
        this.f12804m = true;
    L8:
        if (r11 != 0) goto L10;
        float r17 = Float.MAX_VALUE;
    L11:
        this.f12801j = r17;
        a();
        return;
    L10:
        r17 = 1.0f / r11;
        goto L11
    }

    public final void a() {
        boolean r5 = this.f12799h;
        ug.d r10 = this.f;
        Interpolator r11 = this.g;
        q r12 = this.f12798c;
        int r13 = this.f12797b;
        int r14 = this.f12796a;
        if (r5 == false) goto L22;
        long r15 = System.nanoTime();
        long r16 = r15 - this.f12802k;
        this.f12802k = r15;
        float r17 = this.f12800i - (((float) (r16 * 1.0E-6d)) * this.f12801j);
        this.f12800i = r17;
        if (r17 >= 0.0f) goto L7;
        this.f12800i = 0.0f;
    L7:
        if (r11 != null) goto L10;
        float r18 = this.f12800i;
    L11:
        boolean r19 = r12.f(r18, r15, r12.f12874b, this.e);
        if (this.f12800i > 0.0f) goto L19;
        if (r14 == (-1)) goto L15;
        r12.f12874b.setTag(r14, Long.valueOf(System.nanoTime()));
    L15:
        if (r13 == (-1)) goto L17;
        r12.f12874b.setTag(r13, null);
    L17:
        ((ArrayList) r10.g).add(this);
    L19:
        if (this.f12800i > 0.0f) goto L21;
        if (r19 == true) goto L21;
        return;
    L21:
        ((MotionLayout) r10.f22357b).invalidate();
        return;
    L10:
        r18 = r11.getInterpolation(this.f12800i);
        goto L11
    L22:
        long r20 = System.nanoTime();
        long r21 = r20 - this.f12802k;
        this.f12802k = r20;
        float r22 = (((float) (r21 * 1.0E-6d)) * this.f12801j) + this.f12800i;
        this.f12800i = r22;
        if (r22 < 1.0f) goto L25;
        this.f12800i = 1.0f;
    L25:
        if (r11 != null) goto L28;
        float r23 = this.f12800i;
    L29:
        boolean r24 = r12.f(r23, r20, r12.f12874b, this.e);
        if (this.f12800i < 1.0f) goto L39;
        if (r14 == (-1)) goto L33;
        r12.f12874b.setTag(r14, Long.valueOf(System.nanoTime()));
    L33:
        if (r13 == (-1)) goto L36;
        r12.f12874b.setTag(r13, null);
    L36:
        if (this.f12804m == true) goto L39;
        ((ArrayList) r10.g).add(this);
    L39:
        if (this.f12800i < 1.0f) goto L41;
        if (r24 == true) goto L41;
        return;
    L41:
        ((MotionLayout) r10.f22357b).invalidate();
        return;
    L28:
        r23 = r11.getInterpolation(this.f12800i);
        goto L29
    }

    public final void b() {
        this.f12799h = true;
        int r5 = this.d;
        if (r5 == (-1)) goto L8;
        if (r5 != 0) goto L6;
        float r10 = Float.MAX_VALUE;
    L7:
        this.f12801j = r10;
        goto L8
    L6:
        r10 = 1.0f / r5;
    L8:
        ((MotionLayout) this.f.f22357b).invalidate();
        this.f12802k = System.nanoTime();
    }
}

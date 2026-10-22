package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {
    public static final float[][] E = null;
    public static final float[][] F = null;
    public final float A;
    public final float B;
    public final int C;
    public final int D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12775c;
    public final int d;
    public final int e;
    public final int f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f12778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f12782n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int[] f12783o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12784p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12785q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MotionLayout f12786r;
    public final float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f12787t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f12788u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f12789v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f12790w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f12791x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f12792y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f12793z;

    static {
        E = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        F = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    }

    public g0(Context r10, MotionLayout r11, XmlResourceParser r12) {
        this.f12773a = 0;
        this.f12774b = 0;
        this.f12775c = 0;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = 0.5f;
        this.f12776h = 0.5f;
        this.f12777i = -1;
        this.f12778j = false;
        this.f12779k = 0.0f;
        this.f12780l = 1.0f;
        this.f12781m = false;
        this.f12782n = new float[2];
        this.f12783o = new int[2];
        this.s = 4.0f;
        this.f12787t = 1.2f;
        this.f12788u = true;
        this.f12789v = 1.0f;
        this.f12790w = 0;
        this.f12791x = 10.0f;
        this.f12792y = 10.0f;
        this.f12793z = 1.0f;
        this.A = Float.NaN;
        this.B = Float.NaN;
        this.C = 0;
        this.D = 0;
        this.f12786r = r11;
        TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r12), R$styleable.OnSwipe);
        int r14 = r13.getIndexCount();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L65;
        int r5 = r13.getIndex(r15);
        if (r5 != R$styleable.OnSwipe_touchAnchorId) goto L8;
        this.d = r13.getResourceId(r5, this.d);
    L64:
        r15 = r15 + 1;
        goto L3
    L8:
        if (r5 != R$styleable.OnSwipe_touchAnchorSide) goto L11;
        int r16 = r13.getInt(r5, this.f12773a);
        this.f12773a = r16;
        float[] r17 = E[r16];
        this.f12776h = r17[0];
        this.g = r17[1];
        goto L64
    L11:
        if (r5 != R$styleable.OnSwipe_dragDirection) goto L17;
        int r18 = r13.getInt(r5, this.f12774b);
        this.f12774b = r18;
        if (r18 >= 6) goto L15;
        float[] r19 = F[r18];
        this.f12779k = r19[0];
        this.f12780l = r19[1];
        goto L64
    L15:
        this.f12780l = Float.NaN;
        this.f12779k = Float.NaN;
        this.f12778j = true;
        goto L64
    L17:
        if (r5 != R$styleable.OnSwipe_maxVelocity) goto L20;
        this.s = r13.getFloat(r5, this.s);
        goto L64
    L20:
        if (r5 != R$styleable.OnSwipe_maxAcceleration) goto L23;
        this.f12787t = r13.getFloat(r5, this.f12787t);
        goto L64
    L23:
        if (r5 != R$styleable.OnSwipe_moveWhenScrollAtTop) goto L26;
        this.f12788u = r13.getBoolean(r5, this.f12788u);
        goto L64
    L26:
        if (r5 != R$styleable.OnSwipe_dragScale) goto L29;
        this.f12789v = r13.getFloat(r5, this.f12789v);
        goto L64
    L29:
        if (r5 != R$styleable.OnSwipe_dragThreshold) goto L32;
        this.f12791x = r13.getFloat(r5, this.f12791x);
        goto L64
    L32:
        if (r5 != R$styleable.OnSwipe_touchRegionId) goto L35;
        this.e = r13.getResourceId(r5, this.e);
        goto L64
    L35:
        if (r5 != R$styleable.OnSwipe_onTouchUp) goto L38;
        this.f12775c = r13.getInt(r5, this.f12775c);
        goto L64
    L38:
        if (r5 != R$styleable.OnSwipe_nestedScrollFlags) goto L41;
        this.f12790w = r13.getInteger(r5, 0);
        goto L64
    L41:
        if (r5 != R$styleable.OnSwipe_limitBoundsTo) goto L44;
        this.f = r13.getResourceId(r5, 0);
        goto L64
    L44:
        if (r5 != R$styleable.OnSwipe_rotationCenterId) goto L47;
        this.f12777i = r13.getResourceId(r5, this.f12777i);
        goto L64
    L47:
        if (r5 != R$styleable.OnSwipe_springDamping) goto L50;
        this.f12792y = r13.getFloat(r5, this.f12792y);
        goto L64
    L50:
        if (r5 != R$styleable.OnSwipe_springMass) goto L53;
        this.f12793z = r13.getFloat(r5, this.f12793z);
        goto L64
    L53:
        if (r5 != R$styleable.OnSwipe_springStiffness) goto L56;
        this.A = r13.getFloat(r5, this.A);
        goto L64
    L56:
        if (r5 != R$styleable.OnSwipe_springStopThreshold) goto L59;
        this.B = r13.getFloat(r5, this.B);
        goto L64
    L59:
        if (r5 != R$styleable.OnSwipe_springBoundary) goto L62;
        this.C = r13.getInt(r5, this.C);
        goto L64
    L62:
        if (r5 != R$styleable.OnSwipe_autoCompleteMode) goto L64;
        this.D = r13.getInt(r5, this.D);
        goto L64
    L65:
        r13.recycle();
    }

    public final RectF a(MotionLayout r5, RectF r10) {
        int r11 = this.f;
        if (r11 != (-1)) goto L5;
        return null;
    L5:
        View r12 = r5.findViewById(r11);
        if (r12 != null) goto L8;
        return null;
    L8:
        r10.set(r12.getLeft(), r12.getTop(), r12.getRight(), r12.getBottom());
        return r10;
    }

    public final RectF b(MotionLayout r5, RectF r10) {
        int r11 = this.e;
        if (r11 != (-1)) goto L5;
        return null;
    L5:
        View r12 = r5.findViewById(r11);
        if (r12 != null) goto L8;
        return null;
    L8:
        r10.set(r12.getLeft(), r12.getTop(), r12.getRight(), r12.getBottom());
        return r10;
    }

    public final void c(boolean r10) {
        float[][] r5 = E;
        float[][] r11 = F;
        if (r10 == false) goto L5;
        r11[4] = r11[3];
        r11[5] = r11[2];
        r5[5] = r5[2];
        r5[6] = r5[1];
    L6:
        float[] r12 = r5[this.f12773a];
        this.f12776h = r12[0];
        this.g = r12[1];
        int r13 = this.f12774b;
        if (r13 < 6) goto L9;
        return;
    L9:
        float[] r14 = r11[r13];
        this.f12779k = r14[0];
        this.f12780l = r14[1];
        return;
    L5:
        r11[4] = r11[2];
        r11[5] = r11[3];
        r5[5] = r5[1];
        r5[6] = r5[2];
        goto L6
    }

    public final String toString() {
        if (Float.isNaN(this.f12779k) == false) goto L6;
        return "rotation";
    L6:
        return this.f12779k + " , " + this.f12780l;
    }
}

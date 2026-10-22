package com.obric.oui.constraintlayout.motion.widget;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements Comparable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f12696r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gr.e f12697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12699c;
    public float d;
    public float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12704l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q f12705m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinkedHashMap f12706n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12707o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double[] f12708p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double[] f12709q;

    static {
        f12696r = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public a0() {
        this.f12698b = 0;
        this.f12701i = Float.NaN;
        this.f12702j = -1;
        this.f12703k = -1;
        this.f12704l = Float.NaN;
        this.f12705m = null;
        this.f12706n = new LinkedHashMap();
        this.f12707o = 0;
        this.f12708p = new double[18];
        this.f12709q = new double[18];
    }

    public static boolean b(float r5, float r10) {
        if (Float.isNaN(r5) == true) goto L12;
        if (Float.isNaN(r10) == true) goto L12;
        if (Math.abs(r5 - r10) > 1.0E-6f) goto L10;
        return false;
    L10:
        return true;
    L12:
        if (Float.isNaN(r5) != Float.isNaN(r10)) goto L14;
        return false;
    L14:
        return true;
    }

    public static void f(float r12, float r13, float[] r14, int[] r15, double[] r16, double[] r17) {
        float r5 = 0.0f;
        float r10 = 0.0f;
        float r11 = 0.0f;
        float r18 = 0.0f;
        int r19 = 0;
    L4:
        if (r19 >= r15.length) goto L19;
        float r20 = (float) r16[r19];
        double r110 = r17[r19];
        int r111 = r15[r19];
        if (r111 != 1) goto L8;
        r5 = r20;
    L18:
        r19 = r19 + 1;
        goto L4
    L8:
        if (r111 != 2) goto L10;
        r11 = r20;
        goto L18
    L10:
        if (r111 != 3) goto L12;
        r10 = r20;
        goto L18
    L12:
        if (r111 != 4) goto L18;
        r18 = r20;
        goto L18
    L19:
        float r21 = r5 - ((0.0f * r10) / 2.0f);
        float r22 = r11 - ((0.0f * r18) / 2.0f);
        r14[0] = ((((r10 * 1.0f) + r21) * r12) + ((1.0f - r12) * r21)) + 0.0f;
        r14[1] = ((((r18 * 1.0f) + r22) * r13) + ((1.0f - r13) * r22)) + 0.0f;
    }

    public final void a(com.obric.oui.constraintlayout.widget.c r10) {
        this.f12697a = gr.e.d(r10.d.d);
        lr.h r5 = r10.d;
        this.f12702j = r5.e;
        this.f12703k = r5.f19751b;
        this.f12701i = r5.f19753h;
        this.f12698b = r5.f;
        this.f12704l = r10.e.C;
        Iterator r11 = r10.g.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        String r12 = (String) r11.next();
        lr.b r13 = (lr.b) r10.g.get(r12);
        if (r13 == null) goto L4;
        int r14 = lr.a.f19694a[r13.f19697c.ordinal()];
        if (r14 == 1) goto L4;
        if (r14 == 2) goto L4;
        if (r14 == 3) goto L4;
        this.f12706n.put(r12, r13);
        goto L4
    }

    public final void c(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r5 = this.e;
        float r10 = this.f;
        float r11 = this.g;
        float r12 = this.f12700h;
        int r13 = 0;
    L4:
        if (r13 >= r18.length) goto L18;
        float r14 = (float) r19[r13];
        int r15 = r18[r13];
        if (r15 == 1) goto L16;
        if (r15 != 2) goto L9;
        r10 = r14;
    L17:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r15 != 3) goto L11;
        r11 = r14;
        goto L17
    L11:
        if (r15 != 4) goto L17;
        r12 = r14;
        goto L17
    L16:
        r5 = r14;
        goto L17
    L18:
        q r17 = this.f12705m;
        if (r17 == null) goto L21;
        float[] r22 = new float[2];
        r17.c(r16, r22, new float[2]);
        float r23 = r22[0];
        float r24 = r22[1];
        double r110 = r5;
        double r25 = r10;
        double r111 = Math.sin(r25) * r110;
        r10 = (float) ((((double) r24) - (Math.cos(r25) * r110)) - ((double) (r12 / 2.0f)));
        r5 = (float) ((r111 + ((double) r23)) - ((double) (r11 / 2.0f)));
    L21:
        r20[r21] = ((r11 / 2.0f) + r5) + 0.0f;
        r20[r21 + 1] = ((r12 / 2.0f) + r10) + 0.0f;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        return Float.compare(this.d, ((a0) r5).d);
    }

    public final void d(String r10, double[] r11) {
        lr.b r5 = (lr.b) this.f12706n.get(r10);
        if (r5 != null) goto L5;
        return;
    L5:
        int r12 = 0;
        if (r5.c() != 1) goto L9;
        r11[0] = r5.a();
        return;
    L9:
        int r13 = r5.c();
        float[] r14 = new float[r13];
        r5.b(r14);
        int r15 = 0;
    L10:
        if (r12 >= r13) goto L12;
        r11[r15] = r14[r12];
        r12 = r12 + 1;
        r15 = r15 + 1;
        goto L10
    }

    public final void e(float r5, float r10, float r11, float r12) {
        this.e = r5;
        this.f = r10;
        this.g = r11;
        this.f12700h = r12;
    }

    public final void g(q r10, a0 r11) {
        double r5 = (((this.g / 2.0f) + this.e) - r11.e) - (r11.g / 2.0f);
        double r12 = (((this.f12700h / 2.0f) + this.f) - r11.f) - (r11.f12700h / 2.0f);
        this.f12705m = r10;
        this.e = (float) Math.hypot(r12, r5);
        if (Float.isNaN(this.f12704l) == false) goto L5;
        this.f = (float) (Math.atan2(r12, r5) + 1.5707963267948966d);
        return;
    L5:
        this.f = (float) Math.toRadians(this.f12704l);
    }
}

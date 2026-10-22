package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import com.obric.oui.constraintlayout.utils.widget.MotionLabel;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public n[] A;
    public int B;
    public int C;
    public View D;
    public int E;
    public float F;
    public Interpolator G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f12873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f12874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12875c;
    public boolean d;
    public int e;
    public final a0 f;
    public final a0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f12876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o f12877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public qo.a[] f12878j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public gr.b f12879k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12880l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12881m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12882n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f12883o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double[] f12884p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double[] f12885q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String[] f12886r;
    public int[] s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float[] f12887t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f12888u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float[] f12889v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f12890w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HashMap f12891x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HashMap f12892y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public HashMap f12893z;

    public q(View r5) {
        this.f12873a = new Rect();
        this.d = false;
        this.e = -1;
        this.f = new a0();
        this.g = new a0();
        this.f12876h = new o();
        this.f12877i = new o();
        this.f12880l = Float.NaN;
        this.f12881m = 0.0f;
        this.f12882n = 1.0f;
        this.f12887t = new float[4];
        this.f12888u = new ArrayList();
        this.f12889v = new float[1];
        this.f12890w = new ArrayList();
        this.B = -1;
        this.C = -1;
        this.D = null;
        this.E = -1;
        this.F = Float.NaN;
        this.G = null;
        this.H = false;
        this.f12874b = r5;
        this.f12875c = r5.getId();
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        ((ConstraintLayout.LayoutParams) r10).getClass();
        return;
    }

    public static void h(int r5, int r10, int r11, Rect r12, Rect r13) {
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L6;
        int r14 = r12.left + r12.right;
        int r15 = r12.top + r12.bottom;
        r13.left = r10 - ((r12.width() + r15) / 2);
        r13.top = (r14 - r12.height()) / 2;
        int r16 = r13.left;
        r13.right = r12.width() + r16;
        int r17 = r13.top;
        r13.bottom = r12.height() + r17;
        return;
    L6:
        if (r5 != 3) goto L8;
        int r18 = r12.left + r12.right;
        r13.left = ((r12.height() / 2) + r12.top) - (r18 / 2);
        r13.top = r11 - ((r12.height() + r18) / 2);
        int r19 = r13.left;
        r13.right = r12.width() + r19;
        int r20 = r13.top;
        r13.bottom = r12.height() + r20;
        return;
    L8:
        if (r5 != 4) goto L18;
        int r21 = r12.left + r12.right;
        int r22 = r12.bottom + r12.top;
        r13.left = r10 - ((r12.width() + r22) / 2);
        r13.top = (r21 - r12.height()) / 2;
        int r23 = r13.left;
        r13.right = r12.width() + r23;
        int r24 = r13.top;
        r13.bottom = r12.height() + r24;
        return;
    L18:
        return;
    L13:
        int r25 = r12.left + r12.right;
        r13.left = ((r12.top + r12.bottom) - r12.width()) / 2;
        r13.top = r11 - ((r12.height() + r25) / 2);
        int r26 = r13.left;
        r13.right = r12.width() + r26;
        int r27 = r13.top;
        r13.bottom = r12.height() + r27;
    }

    public final void a(c r5) {
        this.f12890w.add(r5);
    }

    public final float b(float r11, float[] r12) {
        float r5 = 0.0f;
        float r10 = 1.0f;
        if (r12 == null) goto L5;
        r12[0] = 1.0f;
    L15:
        gr.e r13 = this.f.f12697a;
        Iterator r14 = this.f12888u.iterator();
        float r15 = Float.NaN;
    L17:
        if (r14.hasNext() == false) goto L26;
        a0 r16 = (a0) r14.next();
        gr.e r17 = r16.f12697a;
        if (r17 == null) goto L17;
        float r18 = r16.f12699c;
        if (r18 < r11) goto L22;
        if (Float.isNaN(r15) == false) goto L17;
        r15 = r16.f12699c;
        goto L17
    L22:
        r13 = r17;
        r5 = r18;
        goto L17
    L26:
        if (r13 != null) goto L28;
        return r11;
    L28:
        if (Float.isNaN(r15) == true) goto L31;
        r10 = r15;
    L31:
        float r19 = r10 - r5;
        double r110 = (r11 - r5) / r19;
        float r20 = r5 + (((float) r13.a(r110)) * r19);
        if (r12 == null) goto L35;
        r12[0] = (float) r13.b(r110);
    L35:
        return r20;
    L5:
        float r21 = this.f12882n;
        if (r21 == 1.0d) goto L15;
        float r22 = this.f12881m;
        if (r11 >= r22) goto L11;
        r11 = 0.0f;
    L11:
        if (r11 <= r22) goto L15;
        if (r11 >= 1.0d) goto L15;
        r11 = Math.min((r11 - r22) * r21, 1.0f);
        goto L15
    }

    public final void c(double r22, float[] r24, float[] r25) {
        double[] r5 = new double[4];
        double[] r10 = new double[4];
        this.f12878j[0].w(r22, r5);
        this.f12878j[0].z(r22, r10);
        float r11 = 0.0f;
        Arrays.fill(r25, 0.0f);
        int[] r12 = this.f12883o;
        a0 r13 = this.f;
        float r14 = r13.e;
        float r15 = r13.f;
        float r16 = r13.g;
        float r17 = r13.f12700h;
        float r18 = 0.0f;
        float r19 = 0.0f;
        float r110 = 0.0f;
        int r111 = 0;
    L4:
        if (r111 >= r12.length) goto L19;
        float r20 = r16;
        float r112 = r17;
        r16 = (float) r5[r111];
        double[] r113 = r5;
        float r21 = (float) r10[r111];
        int r23 = r12[r111];
        if (r23 != 1) goto L8;
        r14 = r16;
        r18 = r21;
    L13:
        r16 = r20;
    L18:
        r111 = r111 + 1;
        r5 = r113;
        r17 = r112;
        goto L4
    L8:
        if (r23 != 2) goto L10;
        r15 = r16;
        r11 = r21;
        goto L13
    L10:
        if (r23 != 3) goto L12;
        r19 = r21;
        goto L18
    L12:
        if (r23 != 4) goto L13;
        r112 = r16;
        r110 = r21;
        goto L13
    L19:
        float r26 = r16;
        float r114 = r17;
        float r115 = (r19 / 2.0f) + r18;
        float r116 = (r110 / 2.0f) + r11;
        q r27 = r13.f12705m;
        if (r27 == null) goto L22;
        float[] r28 = new float[2];
        float[] r29 = new float[2];
        r27.c(r22, r28, r29);
        float r30 = r28[0];
        float r31 = r28[1];
        float r32 = r29[0];
        float r33 = r29[1];
        double r117 = r14;
        double r118 = r15;
        float r34 = (float) (((Math.sin(r118) * r117) + ((double) r30)) - ((double) (r26 / 2.0f)));
        float r35 = (float) ((((double) r31) - (Math.cos(r118) * r117)) - ((double) (r114 / 2.0f)));
        double r119 = r18;
        double r36 = r11;
        float r37 = (float) ((Math.cos(r118) * r36) + ((Math.sin(r118) * r119) + ((double) r32)));
        r116 = (float) ((Math.sin(r118) * r36) + (((double) r33) - (Math.cos(r118) * r119)));
        r14 = r34;
        r15 = r35;
        r115 = r37;
    L22:
        r24[0] = ((r26 / 2.0f) + r14) + 0.0f;
        r24[1] = ((r114 / 2.0f) + r15) + 0.0f;
        r25[0] = r115;
        r25[1] = r116;
    }

    public final void d(float r12, float r13, float r14, float[] r15) {
        float[] r5 = this.f12889v;
        float r16 = b(r12, r5);
        qo.a[] r10 = this.f12878j;
        int r11 = 0;
        if (r10 == null) goto L16;
        double r17 = r16;
        r10[0].z(r17, this.f12885q);
        this.f12878j[0].w(r17, this.f12884p);
        float r18 = r5[0];
    L5:
        double[] r19 = this.f12885q;
        if (r11 >= r19.length) goto L8;
        r19[r11] = r19[r11] * ((double) r18);
        r11 = r11 + 1;
        goto L5
    L8:
        gr.b r110 = this.f12879k;
        if (r110 == null) goto L14;
        double[] r20 = this.f12884p;
        if (r20.length <= 0) goto L19;
        r110.w(r17, r20);
        this.f12879k.z(r17, this.f12885q);
        int[] r21 = this.f12883o;
        double[] r22 = this.f12885q;
        double[] r111 = this.f12884p;
        this.f.getClass();
        a0.f(r13, r14, r15, r21, r22, r111);
        return;
    L19:
        return;
    L14:
        int[] r23 = this.f12883o;
        double[] r112 = this.f12884p;
        this.f.getClass();
        a0.f(r13, r14, r15, r23, r19, r112);
        return;
    L16:
        a0 r113 = this.g;
        float r24 = r113.e;
        a0 r114 = this.f;
        float r25 = r24 - r114.e;
        float r26 = r113.f - r114.f;
        float r27 = r113.g - r114.g;
        float r115 = (r113.f12700h - r114.f12700h) + r26;
        r15[0] = ((r27 + r25) * r13) + ((1.0f - r13) * r25);
        r15[1] = (r115 * r14) + ((1.0f - r14) * r26);
    }

    public final float e() {
        float[] r5 = new float[2];
        float r10 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        int r11 = 0;
        float r17 = 0.0f;
    L4:
        if (r11 >= 100) goto L27;
        float r12 = r11 * r10;
        double r14 = r12;
        gr.e r16 = this.f.f12697a;
        Iterator r18 = this.f12888u.iterator();
        float r19 = Float.NaN;
        float r110 = 0.0f;
    L7:
        if (r18.hasNext() == false) goto L17;
        a0 r20 = (a0) r18.next();
        gr.e r111 = r20.f12697a;
        if (r111 == null) goto L7;
        float r112 = r20.f12699c;
        if (r112 >= r12) goto L14;
        r16 = r111;
        r110 = r112;
        goto L7
    L14:
        if (Float.isNaN(r19) == false) goto L7;
        r19 = r20.f12699c;
        goto L7
    L17:
        if (r16 != null) goto L19;
    L22:
        this.f12878j[0].w(r14, this.f12884p);
        int r113 = r11;
        this.f.c(r14, this.f12883o, this.f12884p, r5, 0);
        if (r113 <= 0) goto L25;
        char r21 = 0;
        r17 = r17 + ((float) Math.hypot(r15 - ((double) r5[1]), r13 - ((double) r5[0])));
    L26:
        r13 = r5[r21];
        r11 = r113 + 1;
        r15 = r5[1];
        goto L4
    L25:
        r21 = 0;
        goto L26
    L19:
        if (Float.isNaN(r19) == false) goto L21;
        r19 = 1.0f;
    L21:
        float r22 = r19 - r110;
        r14 = (((float) r16.a((r12 - r110) / r22)) * r22) + r110;
        goto L22
    L27:
        return r17;
    }

    public final boolean f(float r30, long r31, View r33, gr.e r34) {
        q r5 = this;
        View r10 = r33;
        float r11 = r5.b(r30, null);
        int r12 = r5.E;
        if (r12 == (-1)) goto L15;
        float r13 = 1.0f / r12;
        float r14 = ((float) Math.floor(r11 / r13)) * r13;
        float r15 = (r11 % r13) / r13;
        if (Float.isNaN(r5.F) == true) goto L7;
        r15 = (r15 + r5.F) % 1.0f;
    L7:
        Interpolator r16 = r5.G;
        if (r16 == null) goto L11;
        float r17 = r16.getInterpolation(r15);
    L14:
        r11 = (r17 * r13) + r14;
        goto L15
    L11:
        if (r15 <= 0.5d) goto L13;
        r17 = 1.0f;
        goto L14
    L13:
        r17 = 0.0f;
    L15:
        float r18 = r11;
        HashMap r19 = r5.f12892y;
        if (r19 == null) goto L21;
        Iterator r20 = r19.values().iterator();
    L19:
        if (r20.hasNext() == false) goto L21;
        ((jr.l) r20.next()).c(r10, r18);
    L21:
        HashMap r21 = r5.f12891x;
        if (r21 == null) goto L30;
        Iterator r110 = r21.values().iterator();
        jr.o r111 = null;
        boolean r112 = false;
    L25:
        if (r110.hasNext() == false) goto L31;
        jr.q r22 = (jr.q) r110.next();
        if ((r22 instanceof jr.o) == true) goto L28;
        r112 = r112 | r22.d(r18, r31, r33, r34);
        goto L25
    L28:
        r111 = (jr.o) r22;
    L31:
        qo.a[] r23 = r5.f12878j;
        a0 r113 = r5.f;
        if (r23 == null) goto L153;
        double r24 = r18;
        r23[0].w(r24, r5.f12884p);
        r5.f12878j[0].z(r24, r5.f12885q);
        gr.b r25 = r5.f12879k;
        if (r25 == null) goto L39;
        double[] r26 = r5.f12884p;
        if (r26.length <= 0) goto L39;
        r25.w(r24, r26);
        r5.f12879k.z(r24, r5.f12885q);
    L39:
        if (r5.H == true) goto L103;
        int[] r27 = r5.f12883o;
        double[] r114 = r5.f12884p;
        double[] r28 = r5.f12885q;
        boolean r29 = r5.d;
        float r32 = r113.e;
        float r35 = r113.f;
        float r115 = r113.g;
        float r36 = r113.f12700h;
        if (r27.length == 0) goto L45;
        float r116 = r32;
        if (r113.f12708p.length > r27[r27.length - 1]) goto L46;
        int r37 = r27[r27.length - 1] + 1;
        r113.f12708p = new double[r37];
        r113.f12709q = new double[r37];
    L46:
        Arrays.fill(r113.f12708p, Double.NaN);
        int r38 = 0;
    L48:
        if (r38 >= r27.length) goto L50;
        double[] r39 = r113.f12708p;
        int r40 = r27[r38];
        r39[r40] = r114[r38];
        r113.f12709q[r40] = r28[r38];
        r38 = r38 + 1;
        goto L48
    L50:
        float r41 = Float.NaN;
        float r42 = r36;
        float r43 = r116;
        float r44 = r35;
        float r117 = 0.0f;
        int r118 = 0;
        float r119 = 0.0f;
        float r120 = 0.0f;
        float r121 = 0.0f;
    L51:
        double[] r122 = r113.f12708p;
        boolean r210 = r29;
        if (r118 >= r122.length) goto L77;
        if (Double.isNaN(r122[r118]) == false) goto L56;
        double r211 = r24;
    L76:
        r118 = r118 + 1;
        r29 = r210;
        r24 = r211;
        goto L51
    L56:
        double r212 = 0.0d;
        if (Double.isNaN(r113.f12708p[r118]) == false) goto L59;
    L58:
        r211 = r24;
        float r45 = (float) r212;
        float r46 = (float) r113.f12709q[r118];
        if (r118 != 1) goto L63;
        r43 = r45;
        r117 = r46;
        goto L76
    L63:
        if (r118 != 2) goto L65;
        r44 = r45;
        r121 = r46;
        goto L76
    L65:
        if (r118 != 3) goto L67;
        r115 = r45;
        r119 = r46;
        goto L76
    L67:
        if (r118 != 4) goto L69;
        r42 = r45;
        r120 = r46;
        goto L76
    L69:
        if (r118 != 5) goto L76;
        r41 = r45;
        goto L76
    L59:
        r212 = r113.f12708p[r118] + 0.0d;
        goto L58
    L77:
        double r213 = r24;
        q r47 = r113.f12705m;
        if (r47 == null) goto L87;
        float[] r48 = new float[2];
        float[] r49 = new float[2];
        float r123 = r41;
        r47.c(r213, r48, r49);
        float r124 = r48[0];
        float r50 = r48[1];
        float r51 = r49[0];
        float r52 = r49[1];
        a0 r214 = r113;
        double r53 = r43;
        double r54 = r44;
        float r125 = (float) (((Math.sin(r54) * r53) + ((double) r124)) - ((double) (r115 / 2.0f)));
        float r55 = (float) ((((double) r50) - (Math.cos(r54) * r53)) - ((double) (r42 / 2.0f)));
        double r56 = r117;
        float r57 = r115;
        double r126 = r121;
        float r127 = (float) (((Math.cos(r54) * r53) * r126) + ((Math.sin(r54) * r56) + ((double) r51)));
        float r58 = (float) (((Math.sin(r54) * r53) * r126) + (((double) r52) - (Math.cos(r54) * r56)));
        if (r28.length < 2) goto L83;
        r28[0] = r127;
        r28[1] = r58;
    L83:
        if (Float.isNaN(r123) == true) goto L85;
        float r59 = (float) (Math.toDegrees(Math.atan2(r58, r127)) + ((double) r123));
        r10 = r33;
        r10.setRotation(r59);
    L86:
        r44 = r55;
        r43 = r125;
    L91:
        if ((r10 instanceof b) == false) goto L94;
        ((MotionLabel) ((b) r10)).c(r43, r44, r43 + r57, r42 + r44);
    L93:
        r5 = this;
        r5.d = false;
    L105:
        if (r5.C != (-1)) goto L107;
    L116:
        HashMap r60 = r5.f12892y;
        if (r60 == null) goto L128;
        Iterator r61 = r60.values().iterator();
    L120:
        if (r61.hasNext() == false) goto L128;
        jr.l r62 = (jr.l) r61.next();
        if ((r62 instanceof jr.j) == false) goto L126;
        double[] r63 = r5.f12885q;
        if (r63.length <= 1) goto L126;
        double r64 = r63[0];
        float r128 = r18;
        r10.setRotation(((jr.j) r62).a(r128) + ((float) Math.toDegrees(Math.atan2(r63[1], r64))));
    L127:
        r18 = r128;
    L126:
        r128 = r18;
    L128:
        float r129 = r18;
        if (r111 == 0) goto L131;
        double[] r65 = r5.f12885q;
        double r66 = r65[0];
        double r130 = r213;
        int r131 = 1;
        r10.setRotation(r111.b(r129, r31, r33, r34) + ((float) Math.toDegrees(Math.atan2(r65[1], r66))));
        boolean r67 = r112 | r111.f18450h;
    L132:
        int r68 = r131;
    L133:
        qo.a[] r69 = r5.f12878j;
        if (r68 >= r69.length) goto L136;
        qo.a r70 = r69[r68];
        float[] r71 = r5.f12887t;
        r70.x(r130, r71);
        f4.a.n((lr.b) r214.f12706n.get(r5.f12886r[r68 - 1]), r10, r71);
        r68 = r68 + 1;
        goto L133
    L136:
        o r72 = r5.f12876h;
        if (r72.f12859b != 0) goto L148;
        if (r129 > 0.0f) goto L141;
        r10.setVisibility(r72.f12860c);
        goto L148
    L141:
        o r73 = r5.f12877i;
        if (r129 < 1.0f) goto L145;
        r10.setVisibility(r73.f12860c);
        goto L148
    L145:
        if (r73.f12860c == r72.f12860c) goto L148;
        r10.setVisibility(0);
    L148:
        if (r5.A == null) goto L161;
        int r74 = 0;
    L150:
        n[] r75 = r5.A;
        if (r74 >= r75.length) goto L161;
        r75[r74].h(r129, r10);
        r74 = r74 + 1;
    L161:
        HashMap r76 = r5.f12893z;
        if (r76 == null) goto L170;
        Iterator r77 = r76.values().iterator();
    L165:
        if (r77.hasNext() == false) goto L170;
        jr.g r78 = (jr.g) r77.next();
        if ((r78 instanceof jr.e) == true) goto L168;
        r78.e(r10, r129);
        goto L165
    L168:
        double[] r79 = r5.f12885q;
        double r80 = r79[0];
        r10.setRotation(((jr.e) r78).a(r129) + ((float) Math.toDegrees(Math.atan2(r79[r131], r80))));
    L170:
        return r67;
    L131:
        r130 = r213;
        r131 = 1;
        r67 = r112;
        goto L132
    L107:
        if (r5.D != null) goto L109;
        r5.D = ((View) r33.getParent()).findViewById(r5.C);
    L109:
        View r81 = r5.D;
        if (r81 == null) goto L116;
        float r82 = (r5.D.getBottom() + r81.getTop()) / 2.0f;
        float r83 = (r5.D.getRight() + r5.D.getLeft()) / 2.0f;
        if ((r33.getRight() - r33.getLeft()) <= 0) goto L116;
        if ((r33.getBottom() - r33.getTop()) <= 0) goto L116;
        float r84 = r83 - r33.getLeft();
        float r85 = r82 - r33.getTop();
        r10.setPivotX(r84);
        r10.setPivotY(r85);
        goto L116
    L94:
        float r86 = r43 + 0.5f;
        int r87 = (int) r86;
        float r88 = r44 + 0.5f;
        int r89 = (int) r88;
        int r90 = (int) (r86 + r57);
        int r91 = (int) (r88 + r42);
        int r92 = r90 - r87;
        int r93 = r91 - r89;
        if (r92 == r33.getMeasuredWidth()) goto L97;
    L100:
        r10.measure(View.MeasureSpec.makeMeasureSpec(r92, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r93, BasicMeasure.EXACTLY));
    L101:
        r10.layout(r87, r89, r90, r91);
        goto L93
    L97:
        if (r93 != r33.getMeasuredHeight()) goto L100;
        if (r210 == false) goto L101;
    L85:
        r10 = r33;
        goto L86
    L87:
        float r94 = r41;
        r57 = r115;
        r214 = r113;
        if (Float.isNaN(r94) == true) goto L91;
        r10.setRotation((r94 + ((float) Math.toDegrees(Math.atan2((r120 / 2.0f) + r121, (r119 / 2.0f) + r117)))) + 0.0f);
        goto L91
    L45:
        r116 = r32;
        goto L46
    L103:
        r213 = r24;
        r214 = r113;
        goto L105
    L153:
        r129 = r18;
        boolean r132 = r112;
        r131 = 1;
        float r95 = r113.e;
        a0 r96 = r5.g;
        float r97 = ai.j0.b(r96.e, r95, r129, r95);
        float r98 = r113.f;
        float r99 = ai.j0.b(r96.f, r98, r129, r98);
        float r100 = r113.g;
        float r101 = r96.g;
        float r102 = ai.j0.b(r101, r100, r129, r100);
        float r103 = r113.f12700h;
        float r104 = r96.f12700h;
        float r105 = r97 + 0.5f;
        int r133 = (int) r105;
        float r106 = r99 + 0.5f;
        int r134 = (int) r106;
        int r107 = (int) (r105 + r102);
        int r108 = (int) (r106 + ai.j0.b(r104, r103, r129, r103));
        int r109 = r107 - r133;
        int r135 = r108 - r134;
        if (r101 == r100) goto L156;
    L159:
        r10.measure(View.MeasureSpec.makeMeasureSpec(r109, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r135, BasicMeasure.EXACTLY));
        r5.d = false;
    L160:
        r10.layout(r133, r134, r107, r108);
        r67 = r132;
        goto L161
    L156:
        if (r104 != r103) goto L159;
        if (r5.d == false) goto L160;
    L30:
        r111 = null;
        r112 = false;
        goto L31
    }

    public final void g(a0 r5) {
        r5.e((int) this.f12874b.getX(), (int) this.f12874b.getY(), this.f12874b.getWidth(), this.f12874b.getHeight());
    }

    public final void i(int r48, long r49, int r51) {
        String r5 = "translationY";
        String r10 = "translationX";
        String r11 = "scaleY";
        String r12 = "scaleX";
        String r13 = "rotationY";
        String r14 = "rotationX";
        String r15 = NotificationCompat.CATEGORY_PROGRESS;
        String r16 = "transitionPathRotate";
        String r17 = "rotation";
        String r18 = "alpha";
        new HashSet();
        HashSet r19 = new HashSet();
        HashSet r110 = new HashSet();
        HashSet r111 = new HashSet();
        HashMap r112 = new HashMap();
        int r113 = this.B;
        HashSet r20 = r19;
        a0 r114 = this.f;
        HashSet r21 = r111;
        if (r113 == (-1)) goto L5;
        r114.f12702j = r113;
    L5:
        o r115 = this.f12876h;
        float r116 = r115.e;
        a0 r22 = r114;
        o r117 = this.f12877i;
        if (o.b(r116, r117.e) == false) goto L9;
        r110.add("alpha");
    L9:
        if (o.b(r115.f, r117.f) == false) goto L11;
        r110.add("elevation");
    L11:
        int r23 = r115.f12860c;
        int r118 = r117.f12860c;
        Object r24 = "elevation";
        if (r23 == r118) goto L19;
        if (r115.f12859b != 0) goto L19;
        if (r23 == 0) goto L17;
        if (r118 != 0) goto L19;
    L17:
        r110.add("alpha");
    L19:
        if (o.b(r115.g, r117.g) == false) goto L22;
        r110.add("rotation");
    L22:
        if (Float.isNaN(r115.f12869p) == true) goto L24;
    L25:
        r110.add("transitionPathRotate");
    L27:
        if (Float.isNaN(r115.f12870q) == true) goto L29;
    L30:
        r110.add(NotificationCompat.CATEGORY_PROGRESS);
    L32:
        if (o.b(r115.f12861h, r117.f12861h) == false) goto L35;
        r110.add("rotationX");
    L35:
        if (o.b(r115.f12858a, r117.f12858a) == false) goto L38;
        r110.add("rotationY");
    L38:
        if (o.b(r115.f12864k, r117.f12864k) == false) goto L41;
        r110.add("transformPivotX");
    L41:
        if (o.b(r115.f12865l, r117.f12865l) == false) goto L44;
        r110.add("transformPivotY");
    L44:
        if (o.b(r115.f12862i, r117.f12862i) == false) goto L47;
        r110.add("scaleX");
    L47:
        if (o.b(r115.f12863j, r117.f12863j) == false) goto L50;
        r110.add("scaleY");
    L50:
        if (o.b(r115.f12866m, r117.f12866m) == false) goto L53;
        r110.add("translationX");
    L53:
        if (o.b(r115.f12867n, r117.f12867n) == false) goto L56;
        r110.add("translationY");
    L56:
        if (o.b(r115.f12868o, r117.f12868o) == false) goto L58;
        r110.add("translationZ");
    L58:
        q r25 = this;
        ArrayList r119 = r25.f12890w;
        a0 r120 = r25.g;
        ArrayList r121 = r25.f12888u;
        if (r119 == null) goto L220;
        Iterator r27 = r119.iterator();
        ArrayList r28 = null;
    L62:
        if (r27.hasNext() == false) goto L219;
        c r122 = (c) r27.next();
        String r29 = r14;
        if ((r122 instanceof j) == false) goto L204;
        j r123 = (j) r122;
        a0 r26 = new a0();
        String r30 = r13;
        r26.f12698b = 0;
        r26.f12701i = Float.NaN;
        r26.f12702j = -1;
        r26.f12703k = -1;
        r26.f12704l = Float.NaN;
        r26.f12705m = null;
        r26.f12706n = new LinkedHashMap();
        r26.f12707o = 0;
        String r31 = r10;
        r26.f12708p = new double[18];
        r26.f12709q = new double[18];
        a0 r32 = r22;
        String r33 = r5;
        if (r32.f12703k == (-1)) goto L98;
        float r34 = r123.f12713a / 100.0f;
        r26.f12699c = r34;
        r26.f12698b = r123.f12822h;
        r26.f12707o = r123.f12827m;
        if (Float.isNaN(r123.f12823i) == false) goto L71;
        float r35 = r34;
    L70:
        String r36 = r15;
        if (Float.isNaN(r123.f12824j) == false) goto L76;
        float r37 = r34;
    L75:
        String r38 = r12;
        float r39 = r120.g;
        String r310 = r11;
        float r40 = r32.g;
        String r311 = r17;
        float r41 = r120.f12700h;
        String r312 = r16;
        float r42 = r32.f12700h;
        String r313 = r18;
        r26.d = r26.f12699c;
        r26.g = (int) (((r39 - r40) * r35) + r40);
        r26.f12700h = (int) (((r41 - r42) * r37) + r42);
        if (r123.f12827m == 2) goto L89;
        if (Float.isNaN(r123.f12825k) == false) goto L82;
        float r43 = r34;
    L83:
        float r44 = r120.e;
        float r45 = r32.e;
        r26.e = ai.j0.b(r44, r45, r43, r45);
        if (Float.isNaN(r123.f12826l) == true) goto L87;
        r34 = r123.f12826l;
    L87:
        float r46 = r120.f;
        float r47 = r32.f;
        r26.f = ai.j0.b(r46, r47, r34, r47);
    L97:
        r26.f12703k = r32.f12703k;
        r26.f12697a = gr.e.d(r123.f);
        r26.f12702j = r123.g;
        a0 r50 = r32;
        r119 = r119;
        ArrayList r52 = r121;
        j r53 = r123;
        r110 = r110;
    L196:
        int r54 = Collections.binarySearch(r52, r26);
        if (r54 != 0) goto L199;
        Log.e("MotionController", " KeyPath position \"" + r26.d + "\" outside of range");
    L199:
        r52.add((-r54) - 1, r26);
        int r55 = r53.e;
        if (r55 == (-1)) goto L202;
        q r56 = this;
        r56.e = r55;
    L203:
        HashSet r57 = r20;
        HashSet r58 = r21;
    L216:
        HashSet r59 = r110;
    L218:
        r121 = r52;
        r21 = r58;
        r25 = r56;
        r20 = r57;
        r112 = r112;
        r22 = r50;
        r110 = r59;
        r14 = r29;
        r13 = r30;
        r10 = r31;
        r5 = r33;
        r15 = r36;
        r12 = r38;
        r11 = r310;
        r17 = r311;
        r16 = r312;
        r18 = r313;
        r119 = r119;
        goto L62
    L202:
        r56 = this;
        goto L203
    L82:
        r43 = r123.f12825k;
        goto L83
    L89:
        if (Float.isNaN(r123.f12825k) == false) goto L91;
        float r60 = r120.e;
        float r61 = r32.e;
        float r62 = ai.j0.b(r60, r61, r34, r61);
    L92:
        r26.e = r62;
        if (Float.isNaN(r123.f12826l) == false) goto L95;
        float r63 = r120.f;
        float r64 = r32.f;
        float r65 = ai.j0.b(r63, r64, r34, r64);
    L96:
        r26.f = r65;
        goto L97
    L95:
        r65 = r123.f12826l;
        goto L96
    L91:
        r62 = r123.f12825k * Math.min(r37, r35);
        goto L92
    L76:
        r37 = r123.f12824j;
        goto L75
    L71:
        r35 = r123.f12823i;
        goto L70
    L98:
        r310 = r11;
        r38 = r12;
        r36 = r15;
        r312 = r16;
        r311 = r17;
        r313 = r18;
        int r66 = r123.f12827m;
        if (r66 != 1) goto L101;
        float r67 = r123.f12713a / 100.0f;
        r26.f12699c = r67;
        r26.f12698b = r123.f12822h;
        if (Float.isNaN(r123.f12823i) == false) goto L182;
        float r68 = r67;
    L184:
        if (Float.isNaN(r123.f12824j) == false) goto L186;
        float r69 = r67;
    L187:
        float r70 = r120.g - r32.g;
        float r71 = r120.f12700h - r32.f12700h;
        r26.d = r26.f12699c;
        if (Float.isNaN(r123.f12825k) == true) goto L191;
        r67 = r123.f12825k;
    L191:
        float r72 = r32.e;
        float r73 = r32.g;
        float r124 = r32.f;
        float r125 = r32.f12700h;
        float r126 = ((r120.g / 2.0f) + r120.e) - ((r73 / 2.0f) + r72);
        float r127 = ((r120.f12700h / 2.0f) + r120.f) - ((r125 / 2.0f) + r124);
        float r74 = r126 * r67;
        float r75 = r70 * r68;
        float r76 = r75 / 2.0f;
        r26.e = (int) ((r72 + r74) - r76);
        float r77 = r67 * r127;
        float r78 = r71 * r69;
        float r79 = r78 / 2.0f;
        r26.f = (int) ((r124 + r77) - r79);
        r26.g = (int) (r73 + r75);
        r26.f12700h = (int) (r125 + r78);
        r53 = r123;
        if (Float.isNaN(r53.f12826l) == false) goto L194;
        float r80 = 0.0f;
    L195:
        float r81 = (-r127) * r80;
        float r128 = r126 * r80;
        r26.f12707o = 1;
        r50 = r32;
        float r82 = (int) ((r50.e + r74) - r76);
        float r83 = (int) ((r50.f + r77) - r79);
        r26.e = r82 + r81;
        r26.f = r83 + r128;
        r26.f12703k = r26.f12703k;
        r26.f12697a = gr.e.d(r53.f);
        r26.f12702j = r53.g;
    L163:
        r52 = r121;
        goto L196
    L194:
        r80 = r53.f12826l;
        goto L195
    L186:
        r69 = r123.f12824j;
        goto L187
    L182:
        r68 = r123.f12823i;
        goto L184
    L101:
        if (r66 != 2) goto L103;
        r119 = r119;
        ArrayList r410 = r121;
        r110 = r110;
        float r84 = r123.f12713a / 100.0f;
        r26.f12699c = r84;
        r26.f12698b = r123.f12822h;
        if (Float.isNaN(r123.f12823i) == false) goto L167;
        float r85 = r84;
    L169:
        if (Float.isNaN(r123.f12824j) == false) goto L171;
        float r86 = r84;
    L172:
        float r87 = r120.g;
        float r88 = r32.g;
        float r89 = r87 - r88;
        float r90 = r120.f12700h;
        float r129 = r32.f12700h;
        float r130 = r90 - r129;
        r26.d = r26.f12699c;
        float r131 = r32.e;
        float r91 = r32.f;
        float r92 = (r87 / 2.0f) + r120.e;
        float r93 = (r90 / 2.0f) + r120.f;
        float r94 = r89 * r85;
        r26.e = (int) ((((r92 - ((r88 / 2.0f) + r131)) * r84) + r131) - (r94 / 2.0f));
        float r132 = r130 * r86;
        r26.f = (int) ((((r93 - ((r129 / 2.0f) + r91)) * r84) + r91) - (r132 / 2.0f));
        r26.g = (int) (r88 + r94);
        r26.f12700h = (int) (r129 + r132);
        r26.f12707o = 2;
        if (Float.isNaN(r123.f12825k) == true) goto L176;
        r26.e = (int) (r123.f12825k * (r48 - ((int) r26.g)));
    L176:
        if (Float.isNaN(r123.f12826l) == true) goto L178;
        r26.f = (int) (r123.f12826l * (r51 - ((int) r26.f12700h)));
    L178:
        r26.f12703k = r26.f12703k;
        r26.f12697a = gr.e.d(r123.f);
        r26.f12702j = r123.g;
        r53 = r123;
        r52 = r410;
        r50 = r32;
        goto L196
    L171:
        r86 = r123.f12824j;
        goto L172
    L167:
        r85 = r123.f12823i;
        goto L169
    L103:
        if (r66 == 3) goto L130;
        float r95 = r123.f12713a / 100.0f;
        r26.f12699c = r95;
        r26.f12698b = r123.f12822h;
        if (Float.isNaN(r123.f12823i) == false) goto L107;
        float r96 = r95;
    L109:
        if (Float.isNaN(r123.f12824j) == false) goto L111;
        float r97 = r95;
    L112:
        float r98 = r120.g;
        float r99 = r32.g;
        float r133 = r98 - r99;
        float r100 = r120.f12700h;
        float r101 = r32.f12700h;
        float r210 = r100 - r101;
        r119 = r119;
        r26.d = r26.f12699c;
        float r134 = r32.e;
        r110 = r110;
        float r135 = r32.f;
        float r102 = ((r98 / 2.0f) + r120.e) - ((r99 / 2.0f) + r134);
        float r103 = ((r100 / 2.0f) + r120.f) - ((r101 / 2.0f) + r135);
        float r136 = r133 * r96;
        float r104 = r136 / 2.0f;
        r26.e = (int) (((r102 * r95) + r134) - r104);
        float r211 = r210 * r97;
        float r105 = r211 / 2.0f;
        r26.f = (int) (((r103 * r95) + r135) - r105);
        r26.g = (int) (r99 + r136);
        r26.f12700h = (int) (r101 + r211);
        if (Float.isNaN(r123.f12825k) == false) goto L116;
        float r106 = r95;
    L118:
        if (Float.isNaN(Float.NaN) == false) goto L120;
        float r107 = 0.0f;
    L122:
        if (Float.isNaN(r123.f12826l) == true) goto L126;
        r95 = r123.f12826l;
    L126:
        if (Float.isNaN(Float.NaN) == false) goto L128;
        int r108 = 0;
        float r314 = 0.0f;
    L129:
        r26.f12707o = r108;
        r26.e = (int) (((r314 * r103) + ((r106 * r102) + r32.e)) - r104);
        r26.f = (int) (((r103 * r95) + ((r102 * r107) + r32.f)) - r105);
        r26.f12697a = gr.e.d(r123.f);
        r26.f12702j = r123.g;
        r50 = r32;
        r52 = r121;
        r53 = r123;
        goto L196
    L128:
        r108 = 0;
        r314 = Float.NaN;
        goto L129
    L120:
        r107 = Float.NaN;
        goto L122
    L116:
        r106 = r123.f12825k;
        goto L118
    L111:
        r97 = r123.f12824j;
        goto L112
    L107:
        r96 = r123.f12823i;
        goto L109
    L130:
        float r109 = r123.f12713a / 100.0f;
        r26.f12699c = r109;
        r26.f12698b = r123.f12822h;
        if (Float.isNaN(r123.f12823i) == false) goto L133;
        float r137 = r109;
    L135:
        if (Float.isNaN(r123.f12824j) == false) goto L137;
        float r138 = r109;
    L138:
        float r139 = r120.g;
        float r140 = r32.g;
        float r141 = r139 - r140;
        float r142 = r120.f12700h;
        float r143 = r32.f12700h;
        float r144 = r142 - r143;
        r26.d = r26.f12699c;
        float r145 = r32.e;
        float r212 = (r140 / 2.0f) + r145;
        float r146 = r32.f;
        float r411 = (r143 / 2.0f) + r146;
        float r147 = (r139 / 2.0f) + r120.e;
        float r148 = (r142 / 2.0f) + r120.f;
        if (r212 <= r147) goto L142;
        r212 = r147;
        r147 = r212;
    L142:
        if (r411 > r148) goto L145;
        r411 = r148;
        r148 = r411;
    L145:
        float r149 = r147 - r212;
        float r412 = r411 - r148;
        float r150 = r141 * r137;
        float r151 = r150 / 2.0f;
        r26.e = (int) (((r149 * r109) + r145) - r151);
        float r152 = r144 * r138;
        float r153 = r152 / 2.0f;
        r26.f = (int) (((r412 * r109) + r146) - r153);
        r26.g = (int) (r140 + r150);
        r26.f12700h = (int) (r143 + r152);
        if (Float.isNaN(r123.f12825k) == false) goto L149;
        float r154 = r109;
    L151:
        if (Float.isNaN(Float.NaN) == false) goto L153;
        float r155 = 0.0f;
    L155:
        if (Float.isNaN(r123.f12826l) == true) goto L159;
        r109 = r123.f12826l;
    L159:
        if (Float.isNaN(Float.NaN) == false) goto L161;
        int r156 = 0;
        float r315 = 0.0f;
    L162:
        r26.f12707o = r156;
        r26.e = (int) (((r315 * r412) + ((r154 * r149) + r32.e)) - r151);
        r26.f = (int) (((r412 * r109) + ((r149 * r155) + r32.f)) - r153);
        r26.f12697a = gr.e.d(r123.f);
        r26.f12702j = r123.g;
        r50 = r32;
        r53 = r123;
        goto L163
    L161:
        r315 = Float.NaN;
        r156 = 0;
        goto L162
    L153:
        r155 = Float.NaN;
        goto L155
    L149:
        r154 = r123.f12825k;
        goto L151
    L137:
        r138 = r123.f12824j;
        goto L138
    L133:
        r137 = r123.f12823i;
        goto L135
    L204:
        r33 = r5;
        r31 = r10;
        r310 = r11;
        r38 = r12;
        r30 = r13;
        r36 = r15;
        r312 = r16;
        r311 = r17;
        r119 = r119;
        r313 = r18;
        r110 = r110;
        r50 = r22;
        r56 = r25;
        r52 = r121;
        if ((r122 instanceof g) == false) goto L207;
        r58 = r21;
        r122.d(r58);
        r57 = r20;
        goto L216
    L207:
        r58 = r21;
        if ((r122 instanceof l) == false) goto L210;
        r57 = r20;
        r122.d(r57);
        goto L216
    L210:
        r57 = r20;
        if ((r122 instanceof n) == false) goto L217;
        if (r28 != null) goto L214;
        r28 = new ArrayList();
    L214:
        ArrayList r157 = r28;
        r157.add((n) r122);
        r28 = r157;
        goto L216
    L217:
        r112 = r112;
        r122.f(r112);
        r59 = r110;
        r122.d(r59);
        goto L218
    L219:
        String r316 = r5;
        String r317 = r10;
        String r318 = r11;
        String r319 = r12;
        String r320 = r13;
        String r213 = r14;
        String r321 = r15;
        String r322 = r16;
        String r323 = r17;
        ArrayList r413 = r119;
        String r324 = r18;
        HashSet r158 = r110;
        HashMap r159 = r112;
        HashSet r160 = r20;
        HashSet r161 = r21;
        a0 r162 = r22;
        q r163 = r25;
        ArrayList r164 = r121;
        ArrayList r165 = r28;
    L221:
        if (r165 == null) goto L223;
        r163.A = (n[]) r165.toArray(new n[0]);
    L223:
        String r166 = "CUSTOM,";
        if (r158.isEmpty() == true) goto L353;
        r163.f12892y = new HashMap();
        Iterator r167 = r158.iterator();
    L227:
        if (r167.hasNext() == false) goto L332;
        String r168 = (String) r167.next();
        if (r168.startsWith("CUSTOM,") == false) goto L240;
        SparseArray r169 = new SparseArray();
        String r170 = r168.split(",")[1];
        Iterator r171 = r413.iterator();
    L232:
        if (r171.hasNext() == false) goto L239;
        c r172 = (c) r171.next();
        Iterator r414 = r167;
        HashMap r173 = r172.d;
        if (r173 == null) goto L235;
        lr.b r174 = (lr.b) r173.get(r170);
        if (r174 == null) goto L235;
        r169.append(r172.f12713a, r174);
    L235:
        r167 = r414;
        goto L232
    L239:
        Iterator r415 = r167;
        jr.i r175 = new jr.i();
        String r176 = r168.split(",")[1];
        r175.f = r169;
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        jr.l r177 = r175;
        r120 = r120;
        Object r178 = r24;
        String r179 = r316;
        String r180 = r321;
        String r181 = r319;
        String r182 = r318;
        String r183 = r323;
        String r184 = r322;
        String r185 = r324;
    L329:
        if (r177 == null) goto L330;
        r177.e = r168;
        r163.f12892y.put(r168, r177);
    L330:
        r319 = r181;
        r321 = r180;
        r324 = r185;
        r322 = r184;
        r24 = r178;
        r323 = r183;
        r316 = r179;
        r318 = r182;
        r120 = r120;
        r161 = r161;
        r162 = r162;
        r164 = r164;
        r158 = r158;
        r167 = r415;
        goto L227
    L240:
        r415 = r167;
        switch(r168.hashCode()) {
            case -1249320806: goto L307;
            case -1249320805: goto L303;
            case -1225497657: goto L299;
            case -1225497656: goto L295;
            case -1225497655: goto L291;
            case -1001078227: goto L287;
            case -908189618: goto L283;
            case -908189617: goto L279;
            case -797520672: goto L275;
            case -760884510: goto L271;
            case -760884509: goto L266;
            case -40300674: goto L262;
            case -4379043: goto L256;
            case 37232917: goto L252;
            case 92909918: goto L248;
            case 156108012: goto L245;
            default: goto L242;
        };
    L242:
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r178 = r24;
        String r186 = r213;
        String r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
    L243:
        byte r214 = -1;
    L311:
        switch(r214) {
            case 0: goto L328;
            case 1: goto L327;
            case 2: goto L326;
            case 3: goto L325;
            case 4: goto L324;
            case 5: goto L323;
            case 6: goto L322;
            case 7: goto L321;
            case 8: goto L320;
            case 9: goto L319;
            case 10: goto L318;
            case 11: goto L317;
            case 12: goto L316;
            case 13: goto L315;
            case 14: goto L314;
            case 15: goto L313;
            default: goto L312;
        };
    L312:
        r213 = r186;
        r317 = r187;
        r177 = null;
        goto L329
    L313:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(0);
        goto L329
    L314:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(0);
        goto L329
    L315:
        r213 = r186;
        r317 = r187;
        r177 = new jr.j();
        goto L329
    L316:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(1);
        goto L329
    L317:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(4);
        goto L329
    L318:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(3);
        goto L329
    L319:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(2);
        goto L329
    L320:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(0);
        goto L329
    L321:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(8);
        goto L329
    L322:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(7);
        goto L329
    L323:
        r213 = r186;
        r317 = r187;
        jr.k r188 = new jr.k();
        r188.f = false;
        r177 = r188;
        goto L329
    L324:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(11);
        goto L329
    L325:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(10);
        goto L329
    L326:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(9);
        goto L329
    L327:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(6);
        goto L329
    L328:
        r213 = r186;
        r317 = r187;
        r177 = new jr.h(5);
        goto L329
    L248:
        r185 = r324;
        if (r168.equals(r185) == true) goto L251;
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r178 = r24;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        goto L243
    L251:
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r214 = 14;
        r120 = r120;
        r178 = r24;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        goto L311
    L252:
        r184 = r322;
        r185 = r324;
        if (r168.equals(r184) == true) goto L255;
        r178 = r24;
    L259:
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        goto L243
    L255:
        r214 = 13;
        r178 = r24;
    L261:
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        goto L311
    L256:
        r178 = r24;
        r184 = r322;
        r185 = r324;
        if (r168.equals(r178) == false) goto L259;
        r214 = 12;
        goto L261
    L262:
        r178 = r24;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        if (r168.equals(r183) == false) goto L277;
        byte r189 = 11;
    L270:
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r214 = r189;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
    L277:
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        goto L243
    L266:
        r178 = r24;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        if (r168.equals("transformPivotY") == false) goto L277;
        r189 = 10;
        goto L270
    L271:
        r178 = r24;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        if (r168.equals("transformPivotX") == false) goto L277;
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r214 = 9;
        goto L311
    L275:
        r178 = r24;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        if (r168.equals("waveVariesBy") == false) goto L277;
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r214 = 8;
        goto L311
    L279:
        r178 = r24;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        if (r168.equals(r182) == true) goto L282;
        r120 = r120;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        goto L243
    L282:
        r120 = r120;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r214 = 7;
        goto L311
    L283:
        r161 = r161;
        r178 = r24;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        r164 = r164;
        r162 = r162;
        r158 = r158;
        if (r168.equals(r181) == true) goto L286;
        r120 = r120;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        goto L243
    L286:
        r120 = r120;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r214 = 6;
        goto L311
    L287:
        r161 = r161;
        r158 = r158;
        r178 = r24;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        r164 = r164;
        r162 = r162;
        if (r168.equals(r180) == true) goto L290;
        r120 = r120;
        r186 = r213;
        r187 = r317;
    L293:
        r179 = r316;
        goto L243
    L290:
        r120 = r120;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r214 = 5;
        goto L311
    L291:
        r161 = r161;
        r158 = r158;
        r120 = r120;
        r178 = r24;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        r164 = r164;
        r162 = r162;
        r186 = r213;
        r187 = r317;
        if (r168.equals("translationZ") == false) goto L293;
        r179 = r316;
        r214 = 4;
        goto L311
    L295:
        r161 = r161;
        r158 = r158;
        r120 = r120;
        r178 = r24;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        r164 = r164;
        r162 = r162;
        r186 = r213;
        r187 = r317;
        if (r168.equals(r179) == false) goto L243;
        r214 = 3;
        goto L311
    L299:
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r178 = r24;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        r164 = r164;
        r186 = r213;
        if (r168.equals(r187) == false) goto L243;
        r214 = 2;
        goto L311
    L303:
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r178 = r24;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        r186 = r213;
        if (r168.equals(r320) == false) goto L243;
        r214 = 1;
        goto L311
    L307:
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r120 = r120;
        r178 = r24;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        if (r168.equals(r186) == false) goto L243;
        r214 = 0;
        goto L311
    L245:
        if (r168.equals("waveOffset") == false) goto L242;
        r164 = r164;
        r161 = r161;
        r162 = r162;
        r158 = r158;
        r214 = 15;
        r120 = r120;
        r178 = r24;
        r186 = r213;
        r187 = r317;
        r179 = r316;
        r180 = r321;
        r181 = r319;
        r182 = r318;
        r183 = r323;
        r184 = r322;
        r185 = r324;
        goto L311
    L332:
        ArrayList r416 = r164;
        HashSet r215 = r161;
        a0 r216 = r162;
        HashSet r417 = r158;
        a0 r190 = r120;
        Object r191 = r24;
        String r192 = r316;
        String r193 = r321;
        String r194 = r319;
        String r195 = r318;
        String r196 = r323;
        String r197 = r322;
        String r198 = r324;
        if (r413 == null) goto L340;
        Iterator r199 = r413.iterator();
    L336:
        if (r199.hasNext() == false) goto L340;
        c r200 = (c) r199.next();
        if ((r200 instanceof e) == false) goto L336;
        r200.a(r163.f12892y);
    L340:
        r115.a(r163.f12892y, 0);
        r117.a(r163.f12892y, 100);
        Iterator r201 = r163.f12892y.keySet().iterator();
    L342:
        if (r201.hasNext() == false) goto L355;
        String r202 = (String) r201.next();
        if (r159.containsKey(r202) == false) goto L348;
        Integer r1100 = (Integer) r159.get(r202);
        if (r1100 == null) goto L348;
        int r1101 = r1100.intValue();
    L349:
        jr.l r203 = (jr.l) r163.f12892y.get(r202);
        if (r203 == null) goto L352;
        r203.d(r1101);
    L352:
        r201 = r201;
    L348:
        r1101 = 0;
    L355:
        if (r160.isEmpty() == false) goto L357;
        String r510 = "CUSTOM,";
    L467:
        int r204 = r416.size();
        int r1102 = r204 + 2;
        a0[] r205 = new a0[r1102];
        r205[0] = r216;
        r205[r204 + 1] = r190;
        if (r416.size() > 0) goto L470;
    L472:
        Iterator r206 = r416.iterator();
        int r207 = 1;
    L474:
        if (r206.hasNext() == false) goto L476;
        r205[r207] = (a0) r206.next();
        r207 = r207 + 1;
        goto L474
    L476:
        HashSet r208 = new HashSet();
        Iterator r209 = r190.f12706n.keySet().iterator();
    L478:
        if (r209.hasNext() == false) goto L486;
        String r217 = (String) r209.next();
        a0 r218 = r216;
        if (r218.f12706n.containsKey(r217) == false) goto L484;
        String r219 = r510;
        HashSet r220 = r417;
        if (r220.contains(r219 + r217) == true) goto L485;
        r208.add(r217);
    L485:
        r216 = r218;
        r510 = r219;
        r417 = r220;
        goto L478
    L484:
        r219 = r510;
        r220 = r417;
        goto L485
    L486:
        String[] r221 = (String[]) r208.toArray(new String[0]);
        r163.f12886r = r221;
        r163.s = new int[r221.length];
        int r222 = 0;
    L487:
        String[] r223 = r163.f12886r;
        if (r222 >= r223.length) goto L500;
        String r224 = r223[r222];
        r163.s[r222] = 0;
        int r225 = 0;
    L490:
        if (r225 >= r1102) goto L498;
        if (r205[r225].f12706n.containsKey(r224) == false) goto L497;
        lr.b r226 = (lr.b) r205[r225].f12706n.get(r224);
        if (r226 == null) goto L497;
        int[] r227 = r163.s;
        r227[r222] = r226.c() + r227[r222];
    L497:
        r225 = r225 + 1;
    L498:
        r222 = r222 + 1;
        goto L487
    L500:
        if (r205[0].f12702j == (-1)) goto L502;
        boolean r228 = true;
    L503:
        int r1103 = 18 + r223.length;
        boolean[] r229 = new boolean[r1103];
        int r230 = 1;
    L504:
        if (r230 >= r1102) goto L506;
        a0 r231 = r205[r230];
        a0 r232 = r205[r230 - 1];
        boolean r233 = a0.b(r231.e, r232.e);
        boolean r234 = a0.b(r231.f, r232.f);
        r229[0] = r229[0] | a0.b(r231.d, r232.d);
        boolean r235 = (r233 | r234) | r228;
        r229[1] = r229[1] | r235;
        r229[2] = r235 | r229[2];
        r229[3] = r229[3] | a0.b(r231.g, r232.g);
        r229[4] = a0.b(r231.f12700h, r232.f12700h) | r229[4];
        r230 = r230 + 1;
        goto L504
    L506:
        int r236 = 1;
        int r237 = 0;
    L507:
        if (r236 >= r1103) goto L512;
        if (r229[r236] == false) goto L511;
        r237 = r237 + 1;
    L511:
        r236 = r236 + 1;
        goto L507
    L512:
        r163.f12883o = new int[r237];
        int r238 = Math.max(2, r237);
        r163.f12884p = new double[r238];
        r163.f12885q = new double[r238];
        int r239 = 1;
        int r240 = 0;
    L513:
        if (r239 >= r1103) goto L519;
        if (r229[r239] == false) goto L517;
        int r241 = 1;
        r163.f12883o[r240] = r239;
        r240 = r240 + 1;
    L518:
        r239 = r239 + r241;
        goto L513
    L517:
        r241 = 1;
        goto L518
    L519:
        double[][] r242 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1102, r163.f12883o.length});
        double[] r243 = new double[r1102];
        int r244 = 0;
    L520:
        if (r244 >= r1102) goto L529;
        a0 r245 = r205[r244];
        double[] r246 = r242[r244];
        int[] r247 = r163.f12883o;
        int r1104 = 6;
        float[] r1105 = {r245.d, r245.e, r245.f, r245.g, r245.f12700h, r245.f12701i};
        int r248 = 0;
        int r1106 = 0;
    L523:
        if (r248 >= r247.length) goto L528;
        int r249 = r247[r248];
        if (r249 >= r1104) goto L527;
        r246[r1106] = r1105[r249];
        r1106 = r1106 + 1;
    L527:
        r248 = r248 + 1;
        r1104 = 6;
        goto L523
    L528:
        r243[r244] = r205[r244].f12699c;
        r244 = r244 + 1;
        goto L520
    L529:
        int r250 = 0;
    L530:
        int[] r251 = r163.f12883o;
        if (r250 >= r251.length) goto L538;
        if (r251[r250] >= 6) goto L537;
        String r252 = ai.j0.q(new StringBuilder(), a0.f12696r[r163.f12883o[r250]], " [");
        int r253 = 0;
    L535:
        if (r253 >= r1102) goto L537;
        StringBuilder r254 = ai.j0.u(r252);
        r254.append(r242[r253][r250]);
        r252 = r254.toString();
        r253 = r253 + 1;
    L537:
        r250 = r250 + 1;
        goto L530
    L538:
        r163.f12878j = new qo.a[r163.f12886r.length + 1];
        int r255 = 0;
    L539:
        String[] r256 = r163.f12886r;
        if (r255 >= r256.length) goto L556;
        String r257 = r256[r255];
        int r258 = 0;
        int r259 = 0;
        double[] r260 = null;
        double[][] r261 = null;
    L542:
        if (r258 >= r1102) goto L555;
        if (r205[r258].f12706n.containsKey(r257) == false) goto L553;
        if (r261 != null) goto L552;
        r260 = new double[r1102];
        lr.b r262 = (lr.b) r205[r258].f12706n.get(r257);
        if (r262 != null) goto L550;
        int r263 = 0;
    L551:
        r261 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1102, r263});
        goto L552
    L550:
        r263 = r262.c();
    L552:
        a0 r1107 = r205[r258];
        r260[r259] = r1107.f12699c;
        r1107.d(r257, r261[r259]);
        int r1108 = 1;
        r259 = r259 + 1;
    L554:
        r258 = r258 + r1108;
        goto L542
    L553:
        r1108 = 1;
        goto L554
    L555:
        r255 = r255 + 1;
        r163.f12878j[r255] = qo.a.u(r163.e, Arrays.copyOf(r260, r259), (double[][]) Arrays.copyOf(r261, r259));
        goto L539
    L556:
        r163.f12878j[0] = qo.a.u(r163.e, r243, r242);
        if (r205[0].f12702j == (-1)) goto L562;
        int[] r264 = new int[r1102];
        double[] r265 = new double[r1102];
        double[][] r266 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1102, 2});
        int r267 = 0;
    L559:
        if (r267 >= r1102) goto L561;
        a0 r268 = r205[r267];
        r264[r267] = r268.f12702j;
        r265[r267] = r268.f12699c;
        double[] r269 = r266[r267];
        r269[0] = r268.e;
        r269[1] = r268.f;
        r267 = r267 + 1;
        goto L559
    L561:
        r163.f12879k = new gr.b(r264, r265, r266);
    L562:
        r163.f12893z = new HashMap();
        if (r413 == null) goto L586;
        Iterator r270 = r215.iterator();
        float r1109 = Float.NaN;
    L566:
        if (r270.hasNext() == false) goto L576;
        String r271 = (String) r270.next();
        jr.g r272 = jr.g.c(r271);
        if (r272 == null) goto L566;
        if (r272.e == 1) goto L573;
    L575:
        r272.f18436b = r271;
        r163.f12893z.put(r271, r272);
        goto L566
    L573:
        if (Float.isNaN(r1109) == false) goto L575;
        r1109 = e();
        goto L575
    L576:
        Iterator r273 = r413.iterator();
    L578:
        if (r273.hasNext() == false) goto L582;
        c r274 = (c) r273.next();
        if ((r274 instanceof g) == false) goto L578;
        ((g) r274).h(r163.f12893z);
        goto L578
    L582:
        Iterator r275 = r163.f12893z.values().iterator();
    L584:
        if (r275.hasNext() == false) goto L662;
        ((jr.g) r275.next()).f();
        goto L584
    L662:
        return;
    L586:
        return;
    L502:
        r228 = false;
        goto L503
    L470:
        if (r163.e != (-1)) goto L472;
        r163.e = 0;
        goto L472
    L357:
        if (r163.f12891x != null) goto L359;
        r163.f12891x = new HashMap();
    L359:
        Iterator r276 = r160.iterator();
    L361:
        if (r276.hasNext() == false) goto L450;
        String r277 = (String) r276.next();
        if (r163.f12891x.containsKey(r277) == true) goto L361;
        if (r277.startsWith(r166) == false) goto L378;
        SparseArray r278 = new SparseArray();
        String r1110 = r277.split(",")[1];
        Iterator r279 = r413.iterator();
    L369:
        if (r279.hasNext() == false) goto L376;
        Iterator r418 = r276;
        c r280 = (c) r279.next();
        String r511 = r166;
        HashMap r281 = r280.d;
        if (r281 == null) goto L372;
        lr.b r282 = (lr.b) r281.get(r1110);
        if (r282 == null) goto L372;
        r278.append(r280.f12713a, r282);
    L372:
        r276 = r418;
        r166 = r511;
        goto L369
    L376:
        Iterator r419 = r276;
        String r512 = r166;
        jr.n r283 = new jr.n();
        r283.f18444m = new SparseArray();
        r283.f18442k = r277.split(",")[1];
        r283.f18443l = r278;
        jr.n r1111 = r283;
        String r284 = r213;
        String r285 = r320;
    L377:
        jr.q r1112 = r1111;
    L447:
        if (r1112 != null) goto L449;
    L448:
        r276 = r419;
        r320 = r285;
        r213 = r284;
        r194 = r194;
        r166 = r512;
        goto L361
    L449:
        r1112.f = r277;
        r163.f12891x.put(r277, r1112);
        goto L448
    L378:
        r419 = r276;
        r512 = r166;
        switch(r277.hashCode()) {
            case -1249320806: goto L427;
            case -1249320805: goto L423;
            case -1225497657: goto L419;
            case -1225497656: goto L416;
            case -1225497655: goto L412;
            case -1001078227: goto L408;
            case -908189618: goto L404;
            case -908189617: goto L400;
            case -40300674: goto L396;
            case -4379043: goto L392;
            case 37232917: goto L387;
            case 92909918: goto L383;
            default: goto L380;
        };
    L380:
        r284 = r213;
        r285 = r320;
        r317 = r317;
    L381:
        byte r1113 = -1;
    L431:
        switch(r1113) {
            case 0: goto L445;
            case 1: goto L444;
            case 2: goto L443;
            case 3: goto L442;
            case 4: goto L441;
            case 5: goto L440;
            case 6: goto L439;
            case 7: goto L438;
            case 8: goto L437;
            case 9: goto L436;
            case 10: goto L435;
            case 11: goto L433;
            default: goto L432;
        };
    L432:
        r317 = r317;
        r1111 = null;
        goto L377
    L433:
        jr.q r1114 = new jr.m(0);
    L434:
        r194 = r194;
        r1114.f18451i = r49;
        r1112 = r1114;
        goto L447
    L435:
        r1114 = new jr.o();
        goto L434
    L436:
        r1114 = new jr.m(1);
        goto L434
    L437:
        r1114 = new jr.m(2);
        goto L434
    L438:
        r1114 = new jr.m(6);
        goto L434
    L439:
        r1114 = new jr.m(5);
        goto L434
    L440:
        jr.p r1115 = new jr.p();
        r1115.f18446k = false;
        r1114 = r1115;
        goto L434
    L441:
        r1114 = new jr.m(9);
        goto L434
    L442:
        r1114 = new jr.m(8);
        goto L434
    L443:
        r1114 = new jr.m(7);
        goto L434
    L444:
        r1114 = new jr.m(4);
        goto L434
    L445:
        r1114 = new jr.m(3);
        goto L434
    L419:
        r317 = r317;
        r284 = r213;
        if (r277.equals(r317) == true) goto L422;
        r285 = r320;
        goto L381
    L422:
        r285 = r320;
        r1113 = 2;
        goto L431
    L423:
        r285 = r320;
        r317 = r317;
        if (r277.equals(r285) == true) goto L426;
        r284 = r213;
        goto L381
    L426:
        r284 = r213;
        r1113 = 1;
        goto L431
    L427:
        r284 = r213;
        r285 = r320;
        r317 = r317;
        if (r277.equals(r284) == false) goto L381;
        r1113 = 0;
        goto L431
    L383:
        if (r277.equals(r198) == false) goto L380;
        byte r286 = 11;
    L390:
        r1113 = r286;
        r284 = r213;
        r285 = r320;
        r317 = r317;
        goto L431
    L387:
        if (r277.equals(r197) == false) goto L380;
        r286 = 10;
        goto L390
    L392:
        if (r277.equals(r191) == false) goto L380;
        r284 = r213;
        r285 = r320;
        r317 = r317;
        r1113 = 9;
        goto L431
    L396:
        if (r277.equals(r196) == false) goto L380;
        r284 = r213;
        r285 = r320;
        r317 = r317;
        r1113 = 8;
        goto L431
    L400:
        if (r277.equals(r195) == false) goto L380;
        r284 = r213;
        r285 = r320;
        r317 = r317;
        r1113 = 7;
        goto L431
    L404:
        if (r277.equals(r194) == false) goto L380;
        r284 = r213;
        r285 = r320;
        r317 = r317;
        r1113 = 6;
        goto L431
    L408:
        if (r277.equals(r193) == false) goto L380;
        r284 = r213;
        r285 = r320;
        r317 = r317;
        r1113 = 5;
        goto L431
    L412:
        if (r277.equals("translationZ") == false) goto L380;
        r284 = r213;
        r285 = r320;
        r317 = r317;
        r1113 = 4;
        goto L431
    L416:
        if (r277.equals(r192) == false) goto L380;
        r284 = r213;
        r285 = r320;
        r317 = r317;
        r1113 = 3;
        goto L431
    L450:
        r510 = r166;
        if (r413 == null) goto L458;
        Iterator r287 = r413.iterator();
    L454:
        if (r287.hasNext() == false) goto L458;
        c r288 = (c) r287.next();
        if ((r288 instanceof l) == false) goto L454;
        ((l) r288).h(r163.f12891x);
    L458:
        Iterator r289 = r163.f12891x.keySet().iterator();
    L460:
        if (r289.hasNext() == false) goto L467;
        String r290 = (String) r289.next();
        if (r159.containsKey(r290) == false) goto L464;
        int r291 = ((Integer) r159.get(r290)).intValue();
    L465:
        ((jr.q) r163.f12891x.get(r290)).e(r291);
        goto L460
    L464:
        r291 = 0;
        goto L465
    L353:
        r416 = r164;
        r215 = r161;
        r216 = r162;
        r417 = r158;
        r190 = r120;
        r191 = r24;
        r192 = r316;
        r193 = r321;
        r194 = r319;
        r195 = r318;
        r196 = r323;
        r197 = r322;
        r198 = r324;
        goto L355
    L220:
        r316 = "translationY";
        r317 = "translationX";
        r318 = "scaleY";
        r319 = "scaleX";
        r320 = "rotationY";
        r213 = "rotationX";
        r321 = NotificationCompat.CATEGORY_PROGRESS;
        r322 = "transitionPathRotate";
        r323 = "rotation";
        r413 = r119;
        r324 = "alpha";
        r158 = r110;
        r159 = r112;
        r160 = r20;
        r161 = r21;
        r162 = r22;
        r163 = r25;
        r164 = r121;
        r165 = null;
        goto L221
    L29:
        if (Float.isNaN(r117.f12870q) == true) goto L32;
    L24:
        if (Float.isNaN(r117.f12869p) == true) goto L27;
        goto L25
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder(" start: x: ");
        a0 r10 = this.f;
        r5.append(r10.e);
        r5.append(" y: ");
        r5.append(r10.f);
        r5.append(" end: x: ");
        a0 r11 = this.g;
        r5.append(r11.e);
        r5.append(" y: ");
        r5.append(r11.f);
        return r5.toString();
    }
}

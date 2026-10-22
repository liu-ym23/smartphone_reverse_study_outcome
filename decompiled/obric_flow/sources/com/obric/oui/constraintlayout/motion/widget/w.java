package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.obric.oui.constraintlayout.widget.Barrier;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.Constraints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hr.g f12910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hr.g f12911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.constraintlayout.widget.d f12912c;
    public com.obric.oui.constraintlayout.widget.d d;
    public int e;
    public int f;
    public final /* synthetic */ MotionLayout g;

    public w(MotionLayout r5) {
        this.g = r5;
        this.f12910a = new hr.g();
        this.f12911b = new hr.g();
        this.f12912c = null;
        this.d = null;
    }

    public static void c(hr.g r5, hr.g r10) {
        ArrayList r11 = r5.f17432u0;
        HashMap r12 = new HashMap();
        r12.put(r5, r10);
        r10.f17432u0.clear();
        r10.g(r5, r12);
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L25;
        hr.f r14 = (hr.f) r13.next();
        if ((r14 instanceof hr.a) == false) goto L9;
        hr.f r15 = new hr.a();
    L21:
        r10.f17432u0.add(r15);
        hr.f r16 = r15.V;
        if (r16 == null) goto L24;
        ((hr.g) r16).f17432u0.remove(r15);
        r15.D();
    L24:
        r15.V = r10;
        r12.put(r14, r15);
        goto L4
    L9:
        if ((r14 instanceof hr.k) == false) goto L12;
        r15 = new hr.k();
        goto L21
    L12:
        if ((r14 instanceof hr.i) == false) goto L15;
        r15 = new hr.i();
        goto L21
    L15:
        if ((r14 instanceof hr.n) == false) goto L18;
        r15 = new hr.n();
        goto L21
    L18:
        if ((r14 instanceof hr.l) == false) goto L20;
        r15 = new hr.l();
        goto L21
    L20:
        r15 = new hr.f();
        goto L21
    L25:
        Iterator r17 = r11.iterator();
    L27:
        if (r17.hasNext() == false) goto L29;
        hr.f r18 = (hr.f) r17.next();
        ((hr.f) r12.get(r18)).g(r18, r12);
        goto L27
    }

    public static hr.f d(hr.g r5, View r10) {
        if (r5.f17404h0 != r10) goto L5;
        return r5;
    L5:
        ArrayList r11 = r5.f17432u0;
        int r12 = r11.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        hr.f r14 = (hr.f) r11.get(r13);
        if (r14.f17404h0 == r10) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return r14;
    L11:
        return null;
    }

    public final void a() {
        MotionLayout r5 = this.g;
        int r10 = r5.getChildCount();
        r5.A.clear();
        SparseArray r11 = new SparseArray();
        int[] r12 = new int[r10];
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        View r14 = r5.getChildAt(r13);
        q r15 = new q(r14);
        int r16 = r14.getId();
        r12[r13] = r16;
        r11.put(r16, r15);
        r5.A.put(r14, r15);
        r13 = r13 + 1;
        goto L3
    L5:
        int r17 = 0;
    L6:
        if (r17 >= r10) goto L55;
        View r18 = r5.getChildAt(r17);
        q r19 = (q) r5.A.get(r18);
        if (r19 != null) goto L10;
        int r110 = r10;
        SparseArray r111 = r11;
        int[] r112 = r12;
        int r113 = r17;
    L54:
        r17 = r113 + 1;
        r11 = r111;
        r12 = r112;
        r10 = r110;
        goto L6
    L10:
        com.obric.oui.constraintlayout.widget.d r114 = this.f12912c;
        a0 r115 = r19.f;
        if (r114 == null) goto L42;
        hr.f r116 = d(this.f12910a, r18);
        if (r116 == null) goto L39;
        Rect r117 = MotionLayout.u(r5, r116);
        com.obric.oui.constraintlayout.widget.d r20 = this.f12912c;
        int r21 = r5.getWidth();
        r111 = r11;
        int r22 = r5.getHeight();
        r112 = r12;
        int r23 = r20.d;
        r110 = r10;
        if (r23 == 0) goto L17;
        q.h(r23, r21, r22, r117, r19.f12873a);
    L17:
        r115.f12699c = 0.0f;
        r115.d = 0.0f;
        r19.g(r115);
        r113 = r17;
        r115.e(r117.left, r117.top, r117.width(), r117.height());
        com.obric.oui.constraintlayout.widget.c r24 = r20.h(r19.f12875c);
        r115.a(r24);
        lr.h r25 = r24.d;
        r19.f12880l = r25.g;
        r19.f12876h.c(r117, r20, r23, r19.f12875c);
        r19.C = r24.f.f19767i;
        r19.E = r25.f19755j;
        r19.F = r25.f19754i;
        Context r26 = r19.f12874b.getContext();
        int r27 = r25.f19757l;
        String r28 = r25.f19756k;
        int r29 = r25.f19758m;
        if (r27 != (-2)) goto L20;
        Interpolator r30 = AnimationUtils.loadInterpolator(r26, r29);
    L38:
        r19.G = r30;
    L44:
        if (this.d == null) goto L54;
        hr.f r31 = d(this.f12911b, r18);
        if (r31 == null) goto L52;
        Rect r32 = MotionLayout.u(r5, r31);
        com.obric.oui.constraintlayout.widget.d r33 = this.d;
        int r34 = r5.getWidth();
        int r35 = r5.getHeight();
        int r36 = r33.d;
        if (r36 == 0) goto L50;
        q.h(r36, r34, r35, r32, r19.f12873a);
        r32 = r19.f12873a;
    L50:
        a0 r37 = r19.g;
        r37.f12699c = 1.0f;
        r37.d = 1.0f;
        r19.g(r37);
        r37.e(r32.left, r32.top, r32.width(), r32.height());
        r37.a(r33.h(r19.f12875c));
        r19.f12877i.c(r32, r33, r36, r19.f12875c);
        goto L54
    L52:
        if (r5.K == 0) goto L54;
        Log.e("MotionLayout", ym.k.f() + "no widget for  " + ym.k.h(r18) + " (" + r18.getClass().getName() + ")");
        goto L54
    L20:
        if (r27 == (-1)) goto L36;
        if (r27 != 0) goto L23;
        r30 = new AccelerateDecelerateInterpolator();
        goto L38
    L23:
        if (r27 != 1) goto L25;
        r30 = new AccelerateInterpolator();
        goto L38
    L25:
        if (r27 != 2) goto L27;
        r30 = new DecelerateInterpolator();
        goto L38
    L27:
        if (r27 != 4) goto L29;
        r30 = new BounceInterpolator();
        goto L38
    L29:
        if (r27 == 5) goto L31;
        r30 = null;
        goto L38
    L31:
        r30 = new OvershootInterpolator();
        goto L38
    L36:
        r30 = new p(gr.e.d(r28), 0);
        goto L38
    L39:
        r110 = r10;
        r111 = r11;
        r112 = r12;
        r113 = r17;
        if (r5.K == 0) goto L44;
        Log.e("MotionLayout", ym.k.f() + "no widget for  " + ym.k.h(r18) + " (" + r18.getClass().getName() + ")");
        goto L44
    L42:
        r110 = r10;
        r111 = r11;
        r112 = r12;
        r113 = r17;
        goto L44
    L55:
        SparseArray r118 = r11;
        int[] r119 = r12;
        int r38 = r10;
        int r39 = 0;
    L56:
        if (r39 >= r38) goto L61;
        SparseArray r40 = r118;
        q r41 = (q) r40.get(r119[r39]);
        int r42 = r41.f.f12703k;
        if (r42 == (-1)) goto L60;
        q r43 = (q) r40.get(r42);
        r41.f.g(r43, r43.f);
        r41.g.g(r43, r43.g);
    L60:
        r39 = r39 + 1;
        r118 = r40;
        goto L56
    }

    public final void b(int r10, int r11) {
        MotionLayout r5 = this.g;
        int r12 = r5.getOptimizationLevel();
        if (r5.f12685v != r5.getStartState()) goto L26;
        hr.g r13 = this.f12911b;
        com.obric.oui.constraintlayout.widget.d r14 = this.d;
        if (r14 != null) goto L7;
    L10:
        int r15 = r10;
    L11:
        if (r14 != null) goto L13;
    L16:
        int r16 = r11;
    L17:
        r5.s(r13, r12, r15, r16);
        com.obric.oui.constraintlayout.widget.d r17 = this.f12912c;
        if (r17 == null) goto L49;
        hr.g r18 = this.f12910a;
        int r19 = r17.d;
        if (r19 != 0) goto L22;
        int r20 = r10;
    L23:
        if (r19 != 0) goto L25;
        r10 = r11;
    L25:
        r5.s(r18, r12, r20, r10);
        return;
    L22:
        r20 = r11;
        goto L23
    L49:
        return;
    L13:
        if (r14.d == 0) goto L16;
        r16 = r10;
        goto L17
    L7:
        if (r14.d == 0) goto L10;
        r15 = r11;
        goto L11
    L26:
        com.obric.oui.constraintlayout.widget.d r21 = this.f12912c;
        if (r21 == null) goto L36;
        hr.g r22 = this.f12910a;
        int r23 = r21.d;
        if (r23 != 0) goto L31;
        int r24 = r10;
    L32:
        if (r23 != 0) goto L34;
        int r25 = r11;
    L35:
        r5.s(r22, r12, r24, r25);
        goto L36
    L34:
        r25 = r10;
        goto L35
    L31:
        r24 = r11;
    L36:
        hr.g r26 = this.f12911b;
        com.obric.oui.constraintlayout.widget.d r27 = this.d;
        if (r27 != null) goto L39;
    L42:
        int r28 = r10;
    L43:
        if (r27 != null) goto L45;
    L46:
        r10 = r11;
    L47:
        r5.s(r26, r12, r28, r10);
        return;
    L45:
        if (r27.d != 0) goto L47;
    L39:
        if (r27.d == 0) goto L42;
        r28 = r11;
        goto L43
    }

    public final void e(com.obric.oui.constraintlayout.widget.d r10, com.obric.oui.constraintlayout.widget.d r11) {
        this.f12912c = r10;
        this.d = r11;
        this.f12910a = new hr.g();
        hr.g r5 = new hr.g();
        this.f12911b = r5;
        hr.g r12 = this.f12910a;
        boolean r13 = MotionLayout.F0;
        MotionLayout r14 = this.g;
        hr.g r15 = r14.f12992c;
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r16 = r15.f17436y0;
        r12.f17436y0 = r16;
        r12.f17434w0.g = r16;
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r17 = r15.f17436y0;
        r5.f17436y0 = r17;
        r5.f17434w0.g = r17;
        r12.f17432u0.clear();
        this.f12911b.f17432u0.clear();
        c(r14.f12992c, this.f12910a);
        c(r14.f12992c, this.f12911b);
        if (r14.E <= 0.5d) goto L7;
        if (r10 == null) goto L6;
        g(this.f12910a, r10);
    L6:
        g(this.f12911b, r11);
    L10:
        this.f12910a.f17437z0 = r14.p();
        hr.g r18 = this.f12910a;
        r18.f17433v0.A(r18);
        this.f12911b.f17437z0 = r14.p();
        hr.g r19 = this.f12911b;
        r19.f17433v0.A(r19);
        ViewGroup.LayoutParams r20 = r14.getLayoutParams();
        if (r20 != null) goto L13;
        return;
    L13:
        if (r20.width != (-2)) goto L16;
        hr.g r21 = this.f12910a;
        ConstraintWidget$DimensionBehaviour r22 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        r21.N(r22);
        this.f12911b.N(r22);
    L16:
        if (r20.height != (-2)) goto L20;
        hr.g r23 = this.f12910a;
        ConstraintWidget$DimensionBehaviour r24 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        r23.O(r24);
        this.f12911b.O(r24);
        return;
    L20:
        return;
    L7:
        g(this.f12911b, r11);
        if (r10 == null) goto L10;
        g(this.f12910a, r10);
        goto L10
    }

    public final void f() {
        MotionLayout r10 = this.g;
        int r5 = r10.f12689x;
        int r11 = r10.f12691y;
        int r12 = View.MeasureSpec.getMode(r5);
        int r13 = View.MeasureSpec.getMode(r11);
        r10.f12675p0 = r12;
        r10.f12677q0 = r13;
        b(r5, r11);
        boolean r14 = true;
        int r15 = 0;
        if ((r10.getParent() instanceof MotionLayout) == true) goto L5;
    L8:
        b(r5, r11);
        r10.l0 = this.f12910a.r();
        r10.f12672m0 = this.f12910a.l();
        r10.f12673n0 = this.f12911b.r();
        int r16 = this.f12911b.l();
        r10.f12674o0 = r16;
        if (r10.l0 == r10.f12673n0) goto L11;
    L14:
        boolean r17 = true;
    L15:
        r10.f12671k0 = r17;
    L16:
        int r18 = r10.l0;
        int r19 = r10.f12672m0;
        int r20 = r10.f12675p0;
        if (r20 == Integer.MIN_VALUE) goto L21;
        if (r20 == 0) goto L21;
    L20:
        int r21 = r18;
        int r22 = r10.f12677q0;
        if (r22 == Integer.MIN_VALUE) goto L27;
        if (r22 == 0) goto L27;
        int r23 = r19;
    L28:
        hr.g r24 = this.f12910a;
        if (r24.I0 == false) goto L31;
    L34:
        boolean r25 = true;
    L36:
        if (r24.J0 == false) goto L38;
    L41:
        boolean r110 = true;
    L42:
        r10.r(r5, r11, r21, r23, r25, r110);
        int r111 = r10.getChildCount();
        r10.f12694z0.a();
        r10.I = true;
        SparseArray r26 = new SparseArray();
        int r27 = 0;
    L43:
        HashMap r28 = r10.A;
        if (r27 >= r111) goto L46;
        View r29 = r10.getChildAt(r27);
        r26.put(r29.getId(), (q) r28.get(r29));
        r27 = r27 + 1;
        goto L43
    L46:
        int r30 = r10.getWidth();
        int r31 = r10.getHeight();
        c0 r32 = r10.f12676q.f12733c;
        if (r32 == null) goto L49;
        int r33 = r32.f12727p;
    L50:
        if (r33 == (-1)) goto L57;
        int r34 = 0;
    L52:
        if (r34 >= r111) goto L57;
        q r35 = (q) r28.get(r10.getChildAt(r34));
        if (r35 == null) goto L56;
        r35.B = r33;
    L56:
        r34 = r34 + 1;
    L57:
        SparseBooleanArray r36 = new SparseBooleanArray();
        int[] r37 = new int[r28.size()];
        int r38 = 0;
        int r112 = 0;
    L58:
        if (r38 >= r111) goto L64;
        q r113 = (q) r28.get(r10.getChildAt(r38));
        int r114 = r113.f.f12703k;
        if (r114 == (-1)) goto L62;
        r36.put(r114, true);
        r37[r112] = r113.f.f12703k;
        r112 = r112 + 1;
    L62:
        r38 = r38 + 1;
        goto L58
    L64:
        if (r10.f12666d0 == null) goto L83;
        int r39 = 0;
    L66:
        if (r39 >= r112) goto L72;
        q r40 = (q) r28.get(r10.findViewById(r37[r39]));
        if (r40 == null) goto L71;
        r10.f12676q.f(r40);
    L71:
        r39 = r39 + 1;
        goto L66
    L72:
        Iterator r41 = r10.f12666d0.iterator();
    L74:
        if (r41.hasNext() == false) goto L76;
        ((MotionHelper) r41.next()).r(r10, r28);
        goto L74
    L76:
        int r42 = 0;
    L77:
        if (r42 >= r112) goto L90;
        q r43 = (q) r28.get(r10.findViewById(r37[r42]));
        if (r43 == null) goto L82;
        r43.i(r30, r10.getNanoTime(), r31);
    L82:
        r42 = r42 + 1;
    L90:
        int r44 = 0;
    L91:
        if (r44 >= r111) goto L98;
        View r45 = r10.getChildAt(r44);
        q r46 = (q) r28.get(r45);
        if (r36.get(r45.getId()) == true) goto L97;
        if (r46 == null) goto L97;
        r10.f12676q.f(r46);
        r46.i(r30, r10.getNanoTime(), r31);
    L97:
        r44 = r44 + 1;
        goto L91
    L98:
        c0 r47 = r10.f12676q.f12733c;
        if (r47 == null) goto L101;
        float r48 = r47.f12720i;
    L103:
        if (r48 != 0.0f) goto L105;
        return;
    L105:
        if (r48 < 0.0d) goto L108;
        r14 = false;
    L108:
        float r49 = Math.abs(r48);
        float r50 = -3.4028235E38f;
        float r51 = Float.MAX_VALUE;
        float r52 = -3.4028235E38f;
        float r53 = Float.MAX_VALUE;
        int r54 = 0;
    L110:
        if (r54 >= r111) goto L132;
        q r115 = (q) r28.get(r10.getChildAt(r54));
        if (Float.isNaN(r115.f12880l) == false) goto L113;
        a0 r116 = r115.g;
        float r117 = r116.e;
        float r118 = r116.f;
        if (r14 == false) goto L130;
        float r119 = r118 - r117;
    L131:
        r53 = Math.min(r53, r119);
        r52 = Math.max(r52, r119);
        r54 = r54 + 1;
        goto L110
    L130:
        r119 = r118 + r117;
        goto L131
    L113:
        int r55 = 0;
    L114:
        if (r55 >= r111) goto L119;
        q r56 = (q) r28.get(r10.getChildAt(r55));
        if (Float.isNaN(r56.f12880l) == true) goto L118;
        r51 = Math.min(r51, r56.f12880l);
        r50 = Math.max(r50, r56.f12880l);
    L118:
        r55 = r55 + 1;
    L119:
        if (r15 >= r111) goto L174;
        q r57 = (q) r28.get(r10.getChildAt(r15));
        if (Float.isNaN(r57.f12880l) == true) goto L126;
        r57.f12882n = 1.0f / (1.0f - r49);
        if (r14 == false) goto L125;
        r57.f12881m = r49 - (((r50 - r57.f12880l) / (r50 - r51)) * r49);
        goto L126
    L125:
        r57.f12881m = r49 - (((r57.f12880l - r51) * r49) / (r50 - r51));
    L126:
        r15 = r15 + 1;
        goto L119
    L174:
        return;
    L132:
        if (r15 >= r111) goto L175;
        q r58 = (q) r28.get(r10.getChildAt(r15));
        a0 r59 = r58.g;
        float r60 = r59.e;
        float r61 = r59.f;
        if (r14 == false) goto L136;
        float r62 = r61 - r60;
    L137:
        r58.f12882n = 1.0f / (1.0f - r49);
        r58.f12881m = r49 - (((r62 - r53) * r49) / (r52 - r53));
        r15 = r15 + 1;
        goto L132
    L136:
        r62 = r61 + r60;
        goto L137
    L175:
        return;
    L101:
        r48 = 0.0f;
        goto L103
    L83:
        int r63 = 0;
    L84:
        if (r63 >= r112) goto L90;
        q r64 = (q) r28.get(r10.findViewById(r37[r63]));
        if (r64 == null) goto L89;
        r10.f12676q.f(r64);
        r64.i(r30, r10.getNanoTime(), r31);
    L89:
        r63 = r63 + 1;
        goto L84
    L49:
        r33 = -1;
        goto L50
    L38:
        if (this.f12911b.J0 == true) goto L41;
        r110 = false;
        goto L42
    L31:
        if (this.f12911b.I0 == true) goto L34;
        r25 = false;
    L27:
        r23 = (int) ((r10.f12679r0 * (r10.f12674o0 - r19)) + r19);
    L21:
        r18 = (int) ((r10.f12679r0 * (r10.f12673n0 - r18)) + r18);
        goto L20
    L11:
        if (r10.f12672m0 != r16) goto L14;
        r17 = false;
        goto L15
    L5:
        if (r12 != 1073741824) goto L8;
        if (r13 != 1073741824) goto L8;
        goto L8
    }

    public final void g(hr.g r18, com.obric.oui.constraintlayout.widget.d r19) {
        SparseArray r10 = new SparseArray();
        Constraints.LayoutParams r11 = new Constraints.LayoutParams();
        r10.clear();
        r10.put(0, r18);
        MotionLayout r13 = this.g;
        r10.put(r13.getId(), r18);
        if (r19 != null) goto L5;
    L7:
        Iterator r5 = r18.f17432u0.iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        hr.f r12 = (hr.f) r5.next();
        r12.f17407j0 = true;
        r10.put(r12.f17404h0.getId(), r12);
        goto L9
    L11:
        Iterator r14 = r18.f17432u0.iterator();
    L13:
        if (r14.hasNext() == false) goto L35;
        hr.f r15 = (hr.f) r14.next();
        View r16 = r15.f17404h0;
        int r17 = r16.getId();
        HashMap r20 = r19.g;
        if (r20.containsKey(Integer.valueOf(r17)) == false) goto L19;
        com.obric.oui.constraintlayout.widget.c r21 = (com.obric.oui.constraintlayout.widget.c) r20.get(Integer.valueOf(r17));
        if (r21 == null) goto L19;
        r21.a(r11);
    L19:
        r15.P(r19.h(r16.getId()).e.f19719c);
        r15.M(r19.h(r16.getId()).e.d);
        if ((r16 instanceof ConstraintHelper) == false) goto L31;
        ConstraintHelper r22 = (ConstraintHelper) r16;
        int r23 = r22.getId();
        HashMap r24 = r19.g;
        if (r24.containsKey(Integer.valueOf(r23)) == false) goto L29;
        com.obric.oui.constraintlayout.widget.c r25 = (com.obric.oui.constraintlayout.widget.c) r24.get(Integer.valueOf(r23));
        if (r25 == null) goto L29;
        if ((r15 instanceof hr.l) == false) goto L29;
        r22.l(r25, (hr.l) r15, r11, r10);
    L29:
        if ((r16 instanceof Barrier) == false) goto L31;
        ((Barrier) r16).q();
    L31:
        r11.resolveLayoutDirection(r13.getLayoutDirection());
        boolean r26 = MotionLayout.F0;
        this.g.a(false, r16, r15, r11, r10);
        if (r19.h(r16.getId()).f13064c.f19761c == 1) goto L33;
        r15.i0 = r19.h(r16.getId()).f13064c.f19760b;
        goto L13
    L33:
        r15.i0 = r16.getVisibility();
        goto L13
    L35:
        Iterator r27 = r18.f17432u0.iterator();
    L37:
        if (r27.hasNext() == false) goto L47;
        hr.f r28 = (hr.f) r27.next();
        if ((r28 instanceof hr.o) == false) goto L37;
        ConstraintHelper r29 = (ConstraintHelper) r28.f17404h0;
        hr.l r30 = (hr.l) r28;
        r29.p(r30, r10);
        hr.o r31 = (hr.o) r30;
        int r32 = 0;
    L42:
        if (r32 >= r31.f17463v0) goto L37;
        hr.f r33 = r31.f17462u0[r32];
        if (r33 == null) goto L46;
        r33.G = true;
    L46:
        r32 = r32 + 1;
        goto L42
    L47:
        return;
    L5:
        if (r19.d == 0) goto L7;
        hr.g r34 = this.f12911b;
        int r35 = r13.getOptimizationLevel();
        int r36 = View.MeasureSpec.makeMeasureSpec(r13.getHeight(), BasicMeasure.EXACTLY);
        int r37 = View.MeasureSpec.makeMeasureSpec(r13.getWidth(), BasicMeasure.EXACTLY);
        boolean r38 = MotionLayout.F0;
        r13.s(r34, r35, r36, r37);
        goto L7
    }
}

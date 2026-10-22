package com.obric.oui.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12917c;
    public int d;
    public final /* synthetic */ MotionLayout e;

    public y(MotionLayout r5) {
        this.e = r5;
        this.f12915a = Float.NaN;
        this.f12916b = Float.NaN;
        this.f12917c = -1;
        this.d = -1;
    }

    public final void a() {
        int r5 = this.f12917c;
        float r10 = 1.0f;
        MotionLayout r11 = this.e;
        if (r5 == (-1)) goto L5;
    L6:
        if (r5 != (-1)) goto L111;
        int r12 = this.d;
        if (r11.isAttachedToWindow() == false) goto L10;
        d0 r13 = r11.f12676q;
        if (r13 == null) goto L45;
        al.a r14 = r13.f12732b;
        if (r14 == null) goto L45;
        int r15 = r11.f12685v;
        float r16 = -1;
        lr.n r17 = (lr.n) ((SparseArray) r14.f314b).get(r12);
        if (r17 != null) goto L20;
        r15 = r12;
    L43:
        if (r15 == (-1)) goto L45;
        r12 = r15;
        goto L45
    L20:
        ArrayList r18 = r17.f19775b;
        int r19 = r17.f19776c;
        if (r16 == (-1.0f)) goto L36;
        if (r16 == (-1.0f)) goto L36;
        Iterator r110 = r18.iterator();
        lr.o r111 = null;
    L26:
        if (r110.hasNext() == false) goto L33;
        lr.o r112 = (lr.o) r110.next();
        if (r112.a(r16, r16) == false) goto L26;
        if (r15 == r112.e) goto L43;
        r111 = r112;
        goto L26
    L33:
        if (r111 == null) goto L35;
        r15 = r111.e;
    L35:
        r15 = r19;
    L36:
        if (r19 == r15) goto L43;
        Iterator r20 = r18.iterator();
    L40:
        if (r20.hasNext() == false) goto L35;
        if (r15 != ((lr.o) r20.next()).e) goto L40;
    L45:
        int r21 = r11.f12685v;
        if (r21 != r12) goto L49;
    L115:
        r11.setState(MotionLayout.TransitionState.SETUP);
    L117:
        if (Float.isNaN(this.f12916b) == true) goto L119;
        float r22 = this.f12915a;
        float r23 = this.f12916b;
        if (r11.isAttachedToWindow() == false) goto L126;
        r11.setProgress(r22);
        r11.setState(MotionLayout.TransitionState.MOVING);
        r11.f12681t = r23;
        if (r23 == 0.0f) goto L136;
        if (r23 > 0.0f) goto L134;
        r10 = 0.0f;
    L134:
        r11.v(r10);
    L144:
        this.f12915a = Float.NaN;
        this.f12916b = Float.NaN;
        this.f12917c = -1;
        this.d = -1;
        return;
    L136:
        if (r22 == 0.0f) goto L144;
        if (r22 == 1.0f) goto L144;
        if (r22 > 0.5f) goto L143;
        r10 = 0.0f;
    L143:
        r11.v(r10);
        goto L144
    L126:
        if (r11.f12684u0 != null) goto L128;
        r11.f12684u0 = new y(r11);
    L128:
        y r24 = r11.f12684u0;
        r24.f12915a = r22;
        r24.f12916b = r23;
        goto L144
    L119:
        if (Float.isNaN(this.f12915a) == false) goto L121;
        return;
    L121:
        r11.setProgress(this.f12915a);
        return;
    L49:
        if (r11.f12683u != r12) goto L52;
        r11.v(0.0f);
        goto L115
    L52:
        if (r11.f12687w != r12) goto L54;
        r11.v(1.0f);
        goto L115
    L54:
        r11.f12687w = r12;
        if (r21 == (-1)) goto L57;
        r11.I(r21, r12);
        r11.v(1.0f);
        r11.E = 0.0f;
        r11.v(1.0f);
        r11.f12686v0 = null;
        goto L115
    L57:
        r11.M = false;
        r11.G = 1.0f;
        r11.D = 0.0f;
        r11.E = 0.0f;
        r11.F = r11.getNanoTime();
        r11.B = r11.getNanoTime();
        r11.H = false;
        r11.f12678r = null;
        r11.C = r11.f12676q.c() / 1000.0f;
        r11.f12683u = -1;
        r11.f12676q.n(-1, r11.f12687w);
        SparseArray r25 = new SparseArray();
        int r26 = r11.getChildCount();
        HashMap r113 = r11.A;
        r113.clear();
        int r114 = 0;
    L58:
        if (r114 >= r26) goto L60;
        View r115 = r11.getChildAt(r114);
        r113.put(r115, new q(r115));
        r25.put(r115.getId(), (q) r113.get(r115));
        r114 = r114 + 1;
        goto L58
    L60:
        r11.I = true;
        com.obric.oui.constraintlayout.widget.d r27 = r11.f12676q.b(r12);
        w r116 = r11.f12694z0;
        r116.e(null, r27);
        r11.G();
        r116.a();
        int r28 = r11.getChildCount();
        int r29 = 0;
    L61:
        if (r29 >= r28) goto L71;
        View r117 = r11.getChildAt(r29);
        q r118 = (q) r113.get(r117);
        if (r118 == null) goto L70;
        a0 r119 = r118.f;
        r119.f12699c = 0.0f;
        r119.d = 0.0f;
        r119.e(r117.getX(), r117.getY(), r117.getWidth(), r117.getHeight());
        o r30 = r118.f12876h;
        r30.getClass();
        r117.getX();
        r117.getY();
        r117.getWidth();
        r117.getHeight();
        r30.f12860c = r117.getVisibility();
        if (r117.getVisibility() == 0) goto L68;
        float r31 = 0.0f;
    L69:
        r30.e = r31;
        r30.f = r117.getElevation();
        r30.g = r117.getRotation();
        r30.f12861h = r117.getRotationX();
        r30.f12858a = r117.getRotationY();
        r30.f12862i = r117.getScaleX();
        r30.f12863j = r117.getScaleY();
        r30.f12864k = r117.getPivotX();
        r30.f12865l = r117.getPivotY();
        r30.f12866m = r117.getTranslationX();
        r30.f12867n = r117.getTranslationY();
        r30.f12868o = r117.getTranslationZ();
        goto L70
    L68:
        r31 = r117.getAlpha();
    L70:
        r29 = r29 + 1;
        goto L61
    L71:
        int r32 = r11.getWidth();
        int r33 = r11.getHeight();
        if (r11.f12666d0 == null) goto L91;
        int r34 = 0;
    L74:
        if (r34 >= r26) goto L80;
        q r35 = (q) r113.get(r11.getChildAt(r34));
        if (r35 == null) goto L79;
        r11.f12676q.f(r35);
    L79:
        r34 = r34 + 1;
        goto L74
    L80:
        Iterator r36 = r11.f12666d0.iterator();
    L82:
        if (r36.hasNext() == false) goto L84;
        ((MotionHelper) r36.next()).r(r11, r113);
        goto L82
    L84:
        int r37 = 0;
    L85:
        if (r37 >= r26) goto L98;
        q r38 = (q) r113.get(r11.getChildAt(r37));
        if (r38 == null) goto L90;
        r38.i(r32, r11.getNanoTime(), r33);
    L90:
        r37 = r37 + 1;
    L98:
        c0 r39 = r11.f12676q.f12733c;
        if (r39 == null) goto L101;
        float r40 = r39.f12720i;
    L103:
        if (r40 == 0.0f) goto L110;
        float r41 = Float.MAX_VALUE;
        float r42 = -3.4028235E38f;
        int r43 = 0;
    L105:
        if (r43 >= r26) goto L107;
        a0 r120 = ((q) r113.get(r11.getChildAt(r43))).g;
        float r121 = r120.f + r120.e;
        r41 = Math.min(r41, r121);
        r42 = Math.max(r42, r121);
        r43 = r43 + 1;
        goto L105
    L107:
        int r44 = 0;
    L108:
        if (r44 >= r26) goto L110;
        q r122 = (q) r113.get(r11.getChildAt(r44));
        a0 r123 = r122.g;
        float r124 = r123.e;
        float r125 = r123.f;
        r122.f12882n = 1.0f / (1.0f - r40);
        r122.f12881m = r40 - ((((r124 + r125) - r41) * r40) / (r42 - r41));
        r44 = r44 + 1;
    L110:
        r11.D = 0.0f;
        r11.E = 0.0f;
        r11.I = true;
        r11.invalidate();
        goto L115
    L101:
        r40 = 0.0f;
        goto L103
    L91:
        int r45 = 0;
    L92:
        if (r45 >= r26) goto L98;
        q r46 = (q) r113.get(r11.getChildAt(r45));
        if (r46 == null) goto L97;
        r11.f12676q.f(r46);
        r46.i(r32, r11.getNanoTime(), r33);
    L97:
        r45 = r45 + 1;
        goto L92
    L10:
        if (r11.f12684u0 != null) goto L12;
        r11.f12684u0 = new y(r11);
    L12:
        r11.f12684u0.d = r12;
        goto L115
    L111:
        int r47 = this.d;
        if (r47 != (-1)) goto L114;
        r11.H(r5, -1, -1);
        goto L115
    L114:
        r11.I(r5, r47);
        goto L115
    L5:
        if (this.d == (-1)) goto L117;
        goto L6
    }
}

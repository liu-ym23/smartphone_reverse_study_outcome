package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionHelper;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.a0;
import com.obric.oui.constraintlayout.motion.widget.d0;
import com.obric.oui.constraintlayout.motion.widget.e;
import com.obric.oui.constraintlayout.motion.widget.i0;
import com.obric.oui.constraintlayout.motion.widget.j;
import com.obric.oui.constraintlayout.motion.widget.q;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import ym.k;

/* JADX INFO: loaded from: classes3.dex */
public class MotionEffect extends MotionHelper {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12653o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12654p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12655q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12656r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12657t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12658u;

    public MotionEffect(Context r5) {
        super(r5);
        this.f12652n = 0.1f;
        this.f12653o = 49;
        this.f12654p = 50;
        this.f12655q = 0;
        this.f12656r = 0;
        this.s = true;
        this.f12657t = -1;
        this.f12658u = -1;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper
    public final void r(MotionLayout r20, HashMap r21) {
        MotionEffect r5 = this;
        HashMap r10 = r21;
        View[] r11 = r5.j((ConstraintLayout) getParent());
        if (r11 != null) goto L6;
        Log.v("FadeMove", k.e() + " views = null");
        return;
    L6:
        e r12 = new e();
        e r13 = new e();
        r12.h("alpha", Float.valueOf(r5.f12652n));
        r13.h("alpha", Float.valueOf(r5.f12652n));
        int r14 = r5.f12653o;
        r12.f12713a = r14;
        r13.f12713a = r5.f12654p;
        j r15 = new j();
        r15.f12713a = r14;
        int r16 = 0;
        r15.f12827m = 0;
        r15.h("percentX", 0);
        r15.h("percentY", 0);
        j r17 = new j();
        r17.f12713a = r5.f12654p;
        r17.f12827m = 0;
        r17.h("percentX", 1);
        r17.h("percentY", 1);
        e r18 = null;
        if (r5.f12655q <= 0) goto L9;
        e r19 = new e();
        e r110 = new e();
        r19.h("translationX", Integer.valueOf(r5.f12655q));
        r19.f12713a = r5.f12654p;
        r110.h("translationX", 0);
        r110.f12713a = r5.f12654p - 1;
    L11:
        if (r5.f12656r <= 0) goto L13;
        r18 = new e();
        e r111 = new e();
        r18.h("translationY", Integer.valueOf(r5.f12656r));
        r18.f12713a = r5.f12654p;
        r111.h("translationY", 0);
        r111.f12713a = r5.f12654p - 1;
    L14:
        int r112 = r5.f12658u;
        if (r112 != (-1)) goto L42;
        int[] r113 = new int[4];
        int r114 = 0;
    L18:
        if (r114 >= r11.length) goto L36;
        q r115 = (q) r10.get(r11[r114]);
        if (r115 != null) goto L22;
        e r116 = r111;
    L35:
        r114 = r114 + 1;
        r111 = r116;
        r16 = 0;
        goto L18
    L22:
        a0 r22 = r115.g;
        float r117 = r22.e;
        a0 r118 = r115.f;
        r116 = r111;
        float r119 = r117 - r118.e;
        float r23 = r22.f - r118.f;
        if (r23 >= 0.0f) goto L25;
        int r120 = 1;
        r113[1] = r113[1] + 1;
    L27:
        if (r23 <= 0.0f) goto L30;
        r113[0] = r113[0] + r120;
    L30:
        if (r119 <= 0.0f) goto L33;
        r113[3] = r113[3] + r120;
    L33:
        if (r119 >= 0.0f) goto L35;
        r113[2] = r113[2] + r120;
        goto L35
    L25:
        r120 = 1;
        goto L27
    L36:
        e r121 = r111;
        int r122 = r113[r16];
        r112 = r16;
        int r123 = 1;
    L37:
        if (r123 >= 4) goto L43;
        int r24 = r113[r123];
        if (r122 >= r24) goto L41;
        r122 = r24;
        r112 = r123;
    L41:
        r123 = r123 + 1;
    L43:
        int r25 = 0;
    L45:
        if (r25 >= r11.length) goto L113;
        q r124 = (q) r10.get(r11[r25]);
        if (r124 != null) goto L50;
    L48:
        View[] r125 = r11;
        e r126 = r121;
    L112:
        r25 = r25 + 1;
        r5 = this;
        r10 = r21;
        r121 = r126;
        r11 = r125;
        goto L45
    L50:
        a0 r127 = r124.g;
        float r128 = r127.e;
        a0 r129 = r124.f;
        float r130 = r128 - r129.e;
        float r26 = r127.f - r129.f;
        if (r112 != 0) goto L62;
        if (r26 <= 0.0f) goto L90;
        if (r5.s == false) goto L48;
        if (r130 == 0.0f) goto L48;
    L90:
        int r27 = r5.f12657t;
        if (r27 != (-1)) goto L101;
        r124.a(r12);
        r124.a(r13);
        r124.a(r15);
        r124.a(r17);
        if (r5.f12655q <= 0) goto L96;
        r124.a(r19);
        r124.a(r110);
    L96:
        if (r5.f12656r <= 0) goto L100;
        r124.a(r18);
        r126 = r121;
        r124.a(r126);
    L99:
        r125 = r11;
        goto L112
    L100:
        r126 = r121;
        goto L99
    L101:
        r126 = r121;
        d0 r131 = r20.f12676q;
        if (r131 == null) goto L99;
        Iterator r132 = ((ArrayList) r131.f12743q.f22358c).iterator();
    L105:
        if (r132.hasNext() == false) goto L99;
        i0 r28 = (i0) r132.next();
        r125 = r11;
        if (r28.f12806a == r27) goto L108;
        r11 = r125;
        goto L105
    L108:
        ArrayList r29 = (ArrayList) r28.f.f12795a.get(-1);
        if (r29 == null) goto L112;
        r124.f12890w.addAll(r29);
        goto L112
    L62:
        if (r112 != 1) goto L71;
        if (r26 >= 0.0f) goto L90;
        if (r5.s == false) goto L48;
        if (r130 != 0.0f) goto L90;
    L71:
        if (r112 != 2) goto L82;
        if (r130 >= 0.0f) goto L90;
        if (r5.s == false) goto L48;
        if (r26 != 0.0f) goto L90;
    L82:
        if (r112 != 3) goto L90;
        if (r130 <= 0.0f) goto L90;
        if (r5.s == false) goto L48;
        if (r26 != 0.0f) goto L90;
    L113:
        return;
    L42:
        r121 = r111;
        goto L43
    L13:
        r111 = null;
        goto L14
    L9:
        r19 = null;
        r110 = null;
        goto L11
    }

    public final void s(Context r10, AttributeSet r11) {
        if (r11 == null) goto L47;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.MotionEffect);
        int r13 = r12.getIndexCount();
        int r5 = 0;
    L4:
        if (r5 >= r13) goto L30;
        int r14 = r12.getIndex(r5);
        if (r14 != R$styleable.MotionEffect_motionEffect_start) goto L9;
        int r15 = r12.getInt(r14, this.f12653o);
        this.f12653o = r15;
        this.f12653o = Math.max(Math.min(r15, 99), 0);
    L29:
        r5 = r5 + 1;
        goto L4
    L9:
        if (r14 != R$styleable.MotionEffect_motionEffect_end) goto L12;
        int r16 = r12.getInt(r14, this.f12654p);
        this.f12654p = r16;
        this.f12654p = Math.max(Math.min(r16, 99), 0);
        goto L29
    L12:
        if (r14 != R$styleable.MotionEffect_motionEffect_translationX) goto L15;
        this.f12655q = r12.getDimensionPixelOffset(r14, this.f12655q);
        goto L29
    L15:
        if (r14 != R$styleable.MotionEffect_motionEffect_translationY) goto L18;
        this.f12656r = r12.getDimensionPixelOffset(r14, this.f12656r);
        goto L29
    L18:
        if (r14 != R$styleable.MotionEffect_motionEffect_alpha) goto L21;
        this.f12652n = r12.getFloat(r14, this.f12652n);
        goto L29
    L21:
        if (r14 != R$styleable.MotionEffect_motionEffect_move) goto L24;
        this.f12658u = r12.getInt(r14, this.f12658u);
        goto L29
    L24:
        if (r14 != R$styleable.MotionEffect_motionEffect_strict) goto L27;
        this.s = r12.getBoolean(r14, this.s);
        goto L29
    L27:
        if (r14 != R$styleable.MotionEffect_motionEffect_viewTransition) goto L29;
        this.f12657t = r12.getResourceId(r14, this.f12657t);
        goto L29
    L30:
        int r17 = this.f12653o;
        int r18 = this.f12654p;
        if (r17 != r18) goto L35;
        if (r17 <= 0) goto L34;
        this.f12653o = r17 - 1;
        goto L35
    L34:
        this.f12654p = r18 + 1;
    L35:
        r12.recycle();
        return;
    }

    public MotionEffect(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12652n = 0.1f;
        this.f12653o = 49;
        this.f12654p = 50;
        this.f12655q = 0;
        this.f12656r = 0;
        this.s = true;
        this.f12657t = -1;
        this.f12658u = -1;
        s(r5, r10);
    }

    public MotionEffect(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12652n = 0.1f;
        this.f12653o = 49;
        this.f12654p = 50;
        this.f12655q = 0;
        this.f12656r = 0;
        this.s = true;
        this.f12657t = -1;
        this.f12658u = -1;
        s(r5, r10);
    }
}

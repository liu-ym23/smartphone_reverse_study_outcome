package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12718c;
    public int d;
    public int e;
    public String f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f12720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d0 f12721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f12722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g0 f12723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f12724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f12725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f12726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f12728q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f12729r;

    public c0(d0 r5, c0 r10) {
        this.f12716a = -1;
        this.f12717b = false;
        this.f12718c = -1;
        this.d = -1;
        this.e = 0;
        this.f = null;
        this.g = -1;
        this.f12719h = 400;
        this.f12720i = 0.0f;
        this.f12722k = new ArrayList();
        this.f12723l = null;
        this.f12724m = new ArrayList();
        this.f12725n = 0;
        this.f12726o = false;
        this.f12727p = -1;
        this.f12728q = 0;
        this.f12729r = 0;
        this.f12721j = r5;
        this.f12719h = r5.f12736j;
        if (r10 == null) goto L6;
        this.f12727p = r10.f12727p;
        this.e = r10.e;
        this.f = r10.f;
        this.g = r10.g;
        this.f12719h = r10.f12719h;
        this.f12722k = r10.f12722k;
        this.f12720i = r10.f12720i;
        this.f12728q = r10.f12728q;
        return;
    }

    public c0(d0 r5, int r10, int r11) {
        this.f12716a = -1;
        this.f12717b = false;
        this.f12718c = -1;
        this.d = -1;
        this.e = 0;
        this.f = null;
        this.g = -1;
        this.f12719h = 400;
        this.f12720i = 0.0f;
        this.f12722k = new ArrayList();
        this.f12723l = null;
        this.f12724m = new ArrayList();
        this.f12725n = 0;
        this.f12726o = false;
        this.f12727p = -1;
        this.f12728q = 0;
        this.f12729r = 0;
        this.f12716a = -1;
        this.f12721j = r5;
        this.d = r10;
        this.f12718c = r11;
        this.f12719h = r5.f12736j;
        this.f12728q = r5.f12737k;
    }

    public c0(d0 r11, Context r12, XmlResourceParser r13) {
        this.f12716a = -1;
        this.f12717b = false;
        this.f12718c = -1;
        this.d = -1;
        this.e = 0;
        this.f = null;
        this.g = -1;
        this.f12719h = 400;
        this.f12720i = 0.0f;
        this.f12722k = new ArrayList();
        this.f12723l = null;
        this.f12724m = new ArrayList();
        this.f12725n = 0;
        this.f12726o = false;
        this.f12727p = -1;
        this.f12728q = 0;
        this.f12729r = 0;
        this.f12719h = r11.f12736j;
        this.f12728q = r11.f12737k;
        this.f12721j = r11;
        TypedArray r14 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), R$styleable.Transition);
        int r5 = r14.getIndexCount();
        int r10 = 0;
    L4:
        if (r10 >= r5) goto L65;
        int r15 = r14.getIndex(r10);
        int r16 = R$styleable.Transition_constraintSetEnd;
        SparseArray r17 = r11.g;
        if (r15 != r16) goto L14;
        this.f12718c = r14.getResourceId(r15, -1);
        String r18 = r12.getResources().getResourceTypeName(this.f12718c);
        if ("layout".equals(r18) == false) goto L11;
        com.obric.oui.constraintlayout.widget.d r19 = new com.obric.oui.constraintlayout.widget.d();
        r19.j(r12, this.f12718c);
        r17.append(this.f12718c, r19);
    L63:
        r10 = r10 + 1;
        goto L4
    L11:
        if ("xml".equals(r18) == false) goto L63;
        this.f12718c = r11.j(this.f12718c, r12);
        goto L63
    L14:
        if (r15 != R$styleable.Transition_constraintSetStart) goto L22;
        this.d = r14.getResourceId(r15, this.d);
        String r20 = r12.getResources().getResourceTypeName(this.d);
        if ("layout".equals(r20) == false) goto L19;
        com.obric.oui.constraintlayout.widget.d r21 = new com.obric.oui.constraintlayout.widget.d();
        r21.j(r12, this.d);
        r17.append(this.d, r21);
        goto L63
    L19:
        if ("xml".equals(r20) == false) goto L63;
        this.d = r11.j(this.d, r12);
        goto L63
    L22:
        if (r15 != R$styleable.Transition_motionInterpolator) goto L38;
        int r22 = r14.peekValue(r15).type;
        if (r22 != 1) goto L29;
        int r23 = r14.getResourceId(r15, -1);
        this.g = r23;
        if (r23 == (-1)) goto L63;
        this.e = -2;
        goto L63
    L29:
        if (r22 != 3) goto L36;
        String r24 = r14.getString(r15);
        this.f = r24;
        if (r24 == null) goto L63;
        if (r24.indexOf("/") <= 0) goto L35;
        this.g = r14.getResourceId(r15, -1);
        this.e = -2;
        goto L63
    L35:
        this.e = -1;
        goto L63
    L36:
        this.e = r14.getInteger(r15, this.e);
        goto L63
    L38:
        if (r15 != R$styleable.Transition_duration) goto L43;
        int r25 = r14.getInt(r15, this.f12719h);
        this.f12719h = r25;
        if (r25 >= 8) goto L63;
        this.f12719h = 8;
        goto L63
    L43:
        if (r15 != R$styleable.Transition_staggered) goto L46;
        this.f12720i = r14.getFloat(r15, this.f12720i);
        goto L63
    L46:
        if (r15 != R$styleable.Transition_autoTransition) goto L49;
        this.f12725n = r14.getInteger(r15, this.f12725n);
        goto L63
    L49:
        if (r15 != R$styleable.Transition_android_id) goto L52;
        this.f12716a = r14.getResourceId(r15, this.f12716a);
        goto L63
    L52:
        if (r15 != R$styleable.Transition_transitionDisable) goto L55;
        this.f12726o = r14.getBoolean(r15, this.f12726o);
        goto L63
    L55:
        if (r15 != R$styleable.Transition_pathMotionArc) goto L58;
        this.f12727p = r14.getInteger(r15, -1);
        goto L63
    L58:
        if (r15 != R$styleable.Transition_layoutDuringTransition) goto L61;
        this.f12728q = r14.getInteger(r15, 0);
        goto L63
    L61:
        if (r15 != R$styleable.Transition_transitionFlags) goto L63;
        this.f12729r = r14.getInteger(r15, 0);
        goto L63
    L65:
        if (this.d != (-1)) goto L67;
        this.f12717b = true;
    L67:
        r14.recycle();
    }
}

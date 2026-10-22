package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$id;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12808c;
    public int d;
    public int e;
    public final h f;
    public final com.obric.oui.constraintlayout.widget.c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f12812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f12814m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12815n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f12816o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12817p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12818q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12819r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12820t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12821u;

    public i0(Context r11, XmlResourceParser r12) {
        this.f12807b = -1;
        this.f12808c = false;
        this.d = 0;
        this.f12809h = -1;
        this.f12810i = -1;
        this.f12813l = 0;
        this.f12814m = null;
        this.f12815n = -1;
        this.f12817p = -1;
        this.f12818q = -1;
        this.f12819r = -1;
        this.s = -1;
        this.f12820t = -1;
        this.f12821u = -1;
        this.f12816o = r11;
        int r5 = r12.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L5:
        if (r5 == 1) goto L64;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L11;
    L46:
        r5 = r12.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L11:
        if ("ViewTransition".equals(r12.getName()) == false) goto L46;
        return;
    L17:
        String r10 = r12.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        switch(r10.hashCode()) {
            case -1962203927: goto L33;
            case -1239391468: goto L30;
            case 61998586: goto L27;
            case 366511058: goto L24;
            case 1791837707: goto L21;
            default: goto L35;
        };     // Catch: IOException -> L13 XmlPullParserException -> L15
    L35:
        byte r13 = -1;
    L36:
        if (r13 == 0) goto L45;
        if (r13 == 1) goto L44;
        if (r13 == 2) goto L43;
        if (r13 == 3) goto L42;
        if (r13 == 4) goto L42;
        Log.e("ViewTransition", ym.k.e() + " unknown tag " + r10);     // Catch: IOException -> L13 XmlPullParserException -> L15
        StringBuilder r14 = new StringBuilder();     // Catch: IOException -> L13 XmlPullParserException -> L15
        r14.append(".xml:");     // Catch: IOException -> L13 XmlPullParserException -> L15
        r14.append(r12.getLineNumber());     // Catch: IOException -> L13 XmlPullParserException -> L15
        Log.e("ViewTransition", r14.toString());     // Catch: IOException -> L13 XmlPullParserException -> L15
    L42:
        lr.b.d(r11, r12, this.g.g);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L46
    L43:
        this.g = com.obric.oui.constraintlayout.widget.d.d(r11, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L46
    L44:
        this.f = new h(r11, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L46
    L45:
        d(r11, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L46
    L21:
        if (r10.equals("CustomAttribute") == false) goto L35;
        r13 = 3;
        goto L36
    L24:
        if (r10.equals("CustomMethod") == false) goto L35;
        r13 = 4;
        goto L36
    L27:
        if (r10.equals("ViewTransition") == false) goto L35;
        r13 = 0;
        goto L36
    L30:
        if (r10.equals("KeyFrameSet") == false) goto L35;
        r13 = 1;
        goto L36
    L33:
        if (r10.equals("ConstraintOverride") == false) goto L35;
        r13 = 2;
        goto L36
    L64:
        return;
    L13:
        e = move-exception;
        Log.e("ViewTransition", "Error parsing XML resource", e);
        return;
    L15:
        e = move-exception;
        Log.e("ViewTransition", "Error parsing XML resource", e);
    }

    public final void a(ug.d r21, MotionLayout r22, int r23, com.obric.oui.constraintlayout.widget.d r24, View... r25) {
        if (this.f12808c == false) goto L5;
        return;
    L5:
        int r5 = this.e;
        h r10 = this.f;
        int r11 = 0;
        if (r5 != 2) goto L42;
        View r12 = r25[0];
        q r13 = new q(r12);
        a0 r14 = r13.f;
        float r15 = 0.0f;
        r14.f12699c = 0.0f;
        r14.d = 0.0f;
        r13.H = true;
        r14.e(r12.getX(), r12.getY(), r12.getWidth(), r12.getHeight());
        r13.g.e(r12.getX(), r12.getY(), r12.getWidth(), r12.getHeight());
        o r16 = r13.f12876h;
        r16.getClass();
        r12.getX();
        r12.getY();
        r12.getWidth();
        r12.getHeight();
        r16.f12860c = r12.getVisibility();
        if (r12.getVisibility() == 0) goto L10;
        float r17 = 0.0f;
    L11:
        r16.e = r17;
        r16.f = r12.getElevation();
        r16.g = r12.getRotation();
        r16.f12861h = r12.getRotationX();
        r16.f12858a = r12.getRotationY();
        r16.f12862i = r12.getScaleX();
        r16.f12863j = r12.getScaleY();
        r16.f12864k = r12.getPivotX();
        r16.f12865l = r12.getPivotY();
        r16.f12866m = r12.getTranslationX();
        r16.f12867n = r12.getTranslationY();
        r16.f12868o = r12.getTranslationZ();
        o r18 = r13.f12877i;
        r18.getClass();
        r12.getX();
        r12.getY();
        r12.getWidth();
        r12.getHeight();
        r18.f12860c = r12.getVisibility();
        if (r12.getVisibility() != 0) goto L15;
        r15 = r12.getAlpha();
    L15:
        r18.e = r15;
        r18.f = r12.getElevation();
        r18.g = r12.getRotation();
        r18.f12861h = r12.getRotationX();
        r18.f12858a = r12.getRotationY();
        r18.f12862i = r12.getScaleX();
        r18.f12863j = r12.getScaleY();
        r18.f12864k = r12.getPivotX();
        r18.f12865l = r12.getPivotY();
        r18.f12866m = r12.getTranslationX();
        r18.f12867n = r12.getTranslationY();
        r18.f12868o = r12.getTranslationZ();
        ArrayList r19 = (ArrayList) r10.f12795a.get(-1);
        if (r19 == null) goto L18;
        r13.f12890w.addAll(r19);
    L18:
        r13.i(r22.getWidth(), System.nanoTime(), r22.getHeight());
        int r110 = this.f12809h;
        int r111 = this.f12810i;
        int r20 = this.f12807b;
        Context r26 = r22.getContext();
        int r27 = this.f12813l;
        if (r27 == (-2)) goto L39;
        if (r27 == (-1)) goto L38;
        if (r27 == 0) goto L37;
        if (r27 == 1) goto L36;
        if (r27 != 2) goto L25;
        Interpolator r28 = new DecelerateInterpolator();
    L32:
        Interpolator r112 = r28;
    L40:
        new h0(r21, r13, r110, r111, r20, r112, this.f12817p, this.f12818q);
        return;
    L25:
        if (r27 != 4) goto L27;
        r28 = new BounceInterpolator();
        goto L32
    L27:
        if (r27 != 5) goto L29;
        r28 = new OvershootInterpolator();
        goto L32
    L29:
        if (r27 == 6) goto L31;
        r112 = null;
        goto L40
    L31:
        r28 = new AnticipateInterpolator();
        goto L32
    L36:
        r28 = new AccelerateInterpolator();
        goto L32
    L37:
        r28 = new AccelerateDecelerateInterpolator();
        goto L32
    L38:
        r28 = new p(gr.e.d(this.f12814m), 2);
        goto L32
    L39:
        r28 = AnimationUtils.loadInterpolator(r26, this.f12815n);
        goto L32
    L10:
        r17 = r12.getAlpha();
        goto L11
    L42:
        com.obric.oui.constraintlayout.widget.c r113 = this.g;
        if (r5 != 1) goto L64;
        int[] r29 = r22.getConstraintSetIds();
        int r30 = 0;
    L46:
        if (r30 >= r29.length) goto L64;
        int r114 = r29[r30];
        if (r114 == r23) goto L63;
        d0 r115 = r22.f12676q;
        if (r115 != null) goto L53;
        com.obric.oui.constraintlayout.widget.d r116 = null;
    L54:
        int r117 = r25.length;
        int r118 = 0;
    L55:
        if (r118 >= r117) goto L63;
        com.obric.oui.constraintlayout.widget.c r119 = r116.i(r25[r118].getId());
        if (r113 == null) goto L62;
        lr.f r31 = r113.f13065h;
        if (r31 == null) goto L61;
        r31.e(r119);
    L61:
        r119.g.putAll(r113.g);
    L62:
        r118 = r118 + 1;
        goto L55
    L53:
        r116 = r115.b(r114);
    L63:
        r30 = r30 + 1;
    L64:
        com.obric.oui.constraintlayout.widget.d r32 = new com.obric.oui.constraintlayout.widget.d();
        HashMap r33 = r32.g;
        r33.clear();
        Iterator r34 = r24.g.keySet().iterator();
    L66:
        if (r34.hasNext() == false) goto L71;
        Integer r120 = (Integer) r34.next();
        com.obric.oui.constraintlayout.widget.c r121 = (com.obric.oui.constraintlayout.widget.c) r24.g.get(r120);
        if (r121 == null) goto L66;
        r33.put(r120, r121.b());
        goto L66
    L71:
        int r35 = r25.length;
        int r36 = 0;
    L72:
        if (r36 >= r35) goto L80;
        com.obric.oui.constraintlayout.widget.c r122 = r32.i(r25[r36].getId());
        if (r113 == null) goto L79;
        lr.f r123 = r113.f13065h;
        if (r123 == null) goto L78;
        r123.e(r122);
    L78:
        r122.g.putAll(r113.g);
    L79:
        r36 = r36 + 1;
        goto L72
    L80:
        r22.K(r23, r32);
        r22.K(R$id.view_transition, r24);
        r22.H(R$id.view_transition, -1, -1);
        c0 r37 = new c0(r22.f12676q, R$id.view_transition, r23);
        int r38 = r25.length;
    L81:
        if (r11 >= r38) goto L93;
        View r39 = r25[r11];
        int r40 = this.f12809h;
        if (r40 == (-1)) goto L85;
        r37.f12719h = Math.max(r40, 8);
    L85:
        r37.f12727p = this.d;
        int r41 = this.f12813l;
        String r42 = this.f12814m;
        int r124 = this.f12815n;
        r37.e = r41;
        r37.f = r42;
        r37.g = r124;
        int r43 = r39.getId();
        if (r10 == null) goto L92;
        ArrayList r44 = (ArrayList) r10.f12795a.get(-1);
        h r45 = new h();
        r45.f12795a = new HashMap();
        Iterator r46 = r44.iterator();
    L89:
        if (r46.hasNext() == false) goto L91;
        c r125 = ((c) r46.next()).b();
        r125.f12714b = r43;
        r45.b(r125);
        goto L89
    L91:
        r37.f12722k.add(r45);
    L92:
        r11 = r11 + 1;
        goto L81
    L93:
        r22.setTransition(r37);
        a2.b r47 = new a2.b(15, this, r25);
        r22.v(1.0f);
        r22.f12686v0 = r47;
    }

    public final boolean b(View r5) {
        int r10 = this.f12819r;
        if (r10 != (-1)) goto L6;
    L4:
        boolean r11 = true;
    L9:
        int r12 = this.s;
        if (r12 != (-1)) goto L13;
    L11:
        boolean r13 = true;
    L16:
        if (r11 == false) goto L20;
        if (r13 == true) goto L19;
        return false;
    L19:
        return true;
    L20:
        return false;
    L13:
        if (r5.getTag(r12) == null) goto L11;
        r13 = false;
        goto L16
    L6:
        if (r5.getTag(r10) != null) goto L4;
        r11 = false;
        goto L9
    }

    public final boolean c(View r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.f12811j != (-1)) goto L11;
        if (this.f12812k != null) goto L11;
        return false;
    L11:
        if (b(r5) == true) goto L14;
        return false;
    L14:
        if (r5.getId() != this.f12811j) goto L17;
        return true;
    L17:
        if (this.f12812k != null) goto L20;
        return false;
    L20:
        if ((r5.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        String r10 = ((ConstraintLayout.LayoutParams) r5.getLayoutParams()).Y;
        if (r10 == null) goto L26;
        if (r10.matches(this.f12812k) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public final void d(Context r10, XmlResourceParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.ViewTransition);
        int r13 = r12.getIndexCount();
        int r5 = 0;
    L3:
        if (r5 >= r13) goto L70;
        int r14 = r12.getIndex(r5);
        if (r14 != R$styleable.ViewTransition_android_id) goto L8;
        this.f12806a = r12.getResourceId(r14, this.f12806a);
    L69:
        r5 = r5 + 1;
        goto L3
    L8:
        if (r14 != R$styleable.ViewTransition_motionTarget) goto L19;
        if (MotionLayout.F0 == false) goto L15;
        int r15 = r12.getResourceId(r14, this.f12811j);
        this.f12811j = r15;
        if (r15 != (-1)) goto L69;
        this.f12812k = r12.getString(r14);
        goto L69
    L15:
        if (r12.peekValue(r14).type != 3) goto L17;
        this.f12812k = r12.getString(r14);
        goto L69
    L17:
        this.f12811j = r12.getResourceId(r14, this.f12811j);
        goto L69
    L19:
        if (r14 != R$styleable.ViewTransition_onStateTransition) goto L22;
        this.f12807b = r12.getInt(r14, this.f12807b);
        goto L69
    L22:
        if (r14 != R$styleable.ViewTransition_transitionDisable) goto L25;
        this.f12808c = r12.getBoolean(r14, this.f12808c);
        goto L69
    L25:
        if (r14 != R$styleable.ViewTransition_pathMotionArc) goto L28;
        this.d = r12.getInt(r14, this.d);
        goto L69
    L28:
        if (r14 != R$styleable.ViewTransition_duration) goto L31;
        this.f12809h = r12.getInt(r14, this.f12809h);
        goto L69
    L31:
        if (r14 != R$styleable.ViewTransition_upDuration) goto L34;
        this.f12810i = r12.getInt(r14, this.f12810i);
        goto L69
    L34:
        if (r14 != R$styleable.ViewTransition_viewTransitionMode) goto L37;
        this.e = r12.getInt(r14, this.e);
        goto L69
    L37:
        if (r14 != R$styleable.ViewTransition_motionInterpolator) goto L52;
        int r16 = r12.peekValue(r14).type;
        if (r16 != 1) goto L43;
        int r17 = r12.getResourceId(r14, -1);
        this.f12815n = r17;
        if (r17 == (-1)) goto L69;
        this.f12813l = -2;
        goto L69
    L43:
        if (r16 != 3) goto L50;
        String r18 = r12.getString(r14);
        this.f12814m = r18;
        if (r18 != null) goto L47;
    L49:
        this.f12813l = -1;
        goto L69
    L47:
        if (r18.indexOf("/") <= 0) goto L49;
        this.f12815n = r12.getResourceId(r14, -1);
        this.f12813l = -2;
        goto L69
    L50:
        this.f12813l = r12.getInteger(r14, this.f12813l);
        goto L69
    L52:
        if (r14 != R$styleable.ViewTransition_setsTag) goto L55;
        this.f12817p = r12.getResourceId(r14, this.f12817p);
        goto L69
    L55:
        if (r14 != R$styleable.ViewTransition_clearsTag) goto L58;
        this.f12818q = r12.getResourceId(r14, this.f12818q);
        goto L69
    L58:
        if (r14 != R$styleable.ViewTransition_ifTagSet) goto L61;
        this.f12819r = r12.getResourceId(r14, this.f12819r);
        goto L69
    L61:
        if (r14 != R$styleable.ViewTransition_ifTagNotSet) goto L64;
        this.s = r12.getResourceId(r14, this.s);
        goto L69
    L64:
        if (r14 != R$styleable.ViewTransition_SharedValueId) goto L67;
        this.f12821u = r12.getResourceId(r14, this.f12821u);
        goto L69
    L67:
        if (r14 != R$styleable.ViewTransition_SharedValue) goto L69;
        this.f12820t = r12.getInteger(r14, this.f12820t);
        goto L69
    L70:
        r12.recycle();
    }

    public final String toString() {
        return "ViewTransition(" + ym.k.g(this.f12816o, this.f12806a) + ")";
    }
}

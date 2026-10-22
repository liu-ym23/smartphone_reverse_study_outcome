package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionScene;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f12710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12712c;

    public b0(Context r5, c0 r10, XmlResourceParser r11) {
        this.f12711b = -1;
        this.f12712c = 17;
        this.f12710a = r10;
        TypedArray r12 = r5.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.OnClick);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.OnClick_targetId) goto L8;
        this.f12711b = r12.getResourceId(r15, this.f12711b);
    L10:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r15 != R$styleable.OnClick_clickAction) goto L10;
        this.f12712c = r12.getInt(r15, this.f12712c);
        goto L10
    L11:
        r12.recycle();
    }

    public final void a(MotionLayout r10, int r11, c0 r12) {
        int r5 = this.f12711b;
        View r13 = r10;
        if (r5 == (-1)) goto L6;
        r13 = r10.findViewById(r5);
    L6:
        if (r13 != null) goto L9;
        Log.e(MotionScene.TAG, "OnClick could not find id " + r5);
        return;
    L9:
        int r14 = r12.d;
        int r15 = r12.f12718c;
        if (r14 != (-1)) goto L13;
        r13.setOnClickListener(this);
        return;
    L13:
        int r16 = this.f12712c;
        int r17 = r16 & 1;
        boolean r18 = true;
        if (r17 == 0) goto L17;
        if (r11 != r14) goto L17;
        boolean r19 = true;
    L19:
        if ((r16 & 256) == 0) goto L22;
        if (r11 != r14) goto L22;
        boolean r20 = true;
    L23:
        boolean r21 = r19 | r20;
        if (r17 == 0) goto L27;
        if (r11 != r14) goto L27;
        boolean r22 = true;
    L28:
        boolean r23 = r22 | r21;
        if ((r16 & 16) == 0) goto L32;
        if (r11 != r15) goto L32;
        boolean r24 = true;
    L33:
        boolean r25 = r23 | r24;
        if ((r16 & 4096) == 0) goto L37;
        if (r11 != r15) goto L37;
    L39:
        if ((r25 | r18) == false) goto L42;
        r13.setOnClickListener(this);
        return;
    L42:
        return;
    L37:
        r18 = false;
    L32:
        r24 = false;
    L27:
        r22 = false;
    L22:
        r20 = false;
    L17:
        r19 = false;
        goto L19
    }

    public final void b(MotionLayout r5) {
        int r10 = this.f12711b;
        if (r10 != (-1)) goto L5;
        return;
    L5:
        View r11 = r5.findViewById(r10);
        if (r11 != null) goto L9;
        Log.e(MotionScene.TAG, " (*)  could not find id " + r10);
        return;
    L9:
        r11.setOnClickListener(null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        c0 r16 = this.f12710a;
        d0 r5 = r16.f12721j;
        MotionLayout r10 = r5.f12731a;
        if (r10.f12693z == true) goto L5;
        return;
    L5:
        int r11 = 0;
        boolean r12 = true;
        if (r16.d != (-1)) goto L115;
        int r14 = r10.getCurrentState();
        if (r14 != (-1)) goto L113;
        int r17 = r16.f12718c;
        if (r10.isAttachedToWindow() == false) goto L12;
        d0 r18 = r10.f12676q;
        if (r18 == null) goto L47;
        al.a r19 = r18.f12732b;
        if (r19 == null) goto L47;
        int r13 = r10.f12685v;
        float r20 = -1;
        lr.n r110 = (lr.n) ((SparseArray) r19.f314b).get(r17);
        if (r110 != null) goto L22;
        r13 = r17;
    L45:
        if (r13 == (-1)) goto L47;
        r17 = r13;
        goto L47
    L22:
        ArrayList r111 = r110.f19775b;
        int r112 = r110.f19776c;
        if (r20 == (-1.0f)) goto L38;
        if (r20 == (-1.0f)) goto L38;
        Iterator r21 = r111.iterator();
        lr.o r113 = null;
    L28:
        if (r21.hasNext() == false) goto L35;
        lr.o r114 = (lr.o) r21.next();
        if (r114.a(r20, r20) == false) goto L28;
        if (r13 == r114.e) goto L45;
        r113 = r114;
        goto L28
    L35:
        if (r113 == null) goto L37;
        r13 = r113.e;
    L37:
        r13 = r112;
    L38:
        if (r112 == r13) goto L45;
        Iterator r22 = r111.iterator();
    L42:
        if (r22.hasNext() == false) goto L37;
        if (r13 != ((lr.o) r22.next()).e) goto L42;
    L47:
        int r115 = r10.f12685v;
        if (r115 != r17) goto L51;
        return;
    L51:
        if (r10.f12683u != r17) goto L54;
        r10.v(0.0f);
        return;
    L54:
        if (r10.f12687w != r17) goto L56;
        r10.v(1.0f);
        return;
    L56:
        r10.f12687w = r17;
        if (r115 == (-1)) goto L59;
        r10.I(r115, r17);
        r10.v(1.0f);
        r10.E = 0.0f;
        r10.v(1.0f);
        r10.f12686v0 = null;
        return;
    L59:
        r10.M = false;
        r10.G = 1.0f;
        r10.D = 0.0f;
        r10.E = 0.0f;
        r10.F = r10.getNanoTime();
        r10.B = r10.getNanoTime();
        r10.H = false;
        r10.f12678r = null;
        r10.C = r10.f12676q.c() / 1000.0f;
        r10.f12683u = -1;
        r10.f12676q.n(-1, r10.f12687w);
        SparseArray r116 = new SparseArray();
        int r23 = r10.getChildCount();
        HashMap r24 = r10.A;
        r24.clear();
        int r25 = 0;
    L60:
        if (r25 >= r23) goto L62;
        View r26 = r10.getChildAt(r25);
        r24.put(r26, new q(r26));
        r116.put(r26.getId(), (q) r24.get(r26));
        r25 = r25 + 1;
        goto L60
    L62:
        r10.I = true;
        com.obric.oui.constraintlayout.widget.d r117 = r10.f12676q.b(r17);
        w r118 = r10.f12694z0;
        r118.e(null, r117);
        r10.G();
        r118.a();
        int r119 = r10.getChildCount();
        int r120 = 0;
    L63:
        if (r120 >= r119) goto L73;
        View r27 = r10.getChildAt(r120);
        q r28 = (q) r24.get(r27);
        if (r28 == null) goto L72;
        a0 r29 = r28.f;
        r29.f12699c = 0.0f;
        r29.d = 0.0f;
        r29.e(r27.getX(), r27.getY(), r27.getWidth(), r27.getHeight());
        o r30 = r28.f12876h;
        r30.getClass();
        r27.getX();
        r27.getY();
        r27.getWidth();
        r27.getHeight();
        r30.f12860c = r27.getVisibility();
        if (r27.getVisibility() == 0) goto L70;
        float r31 = 0.0f;
    L71:
        r30.e = r31;
        r30.f = r27.getElevation();
        r30.g = r27.getRotation();
        r30.f12861h = r27.getRotationX();
        r30.f12858a = r27.getRotationY();
        r30.f12862i = r27.getScaleX();
        r30.f12863j = r27.getScaleY();
        r30.f12864k = r27.getPivotX();
        r30.f12865l = r27.getPivotY();
        r30.f12866m = r27.getTranslationX();
        r30.f12867n = r27.getTranslationY();
        r30.f12868o = r27.getTranslationZ();
        goto L72
    L70:
        r31 = r27.getAlpha();
    L72:
        r120 = r120 + 1;
        goto L63
    L73:
        int r121 = r10.getWidth();
        int r122 = r10.getHeight();
        if (r10.f12666d0 == null) goto L93;
        int r32 = 0;
    L76:
        if (r32 >= r23) goto L82;
        q r33 = (q) r24.get(r10.getChildAt(r32));
        if (r33 == null) goto L81;
        r10.f12676q.f(r33);
    L81:
        r32 = r32 + 1;
        goto L76
    L82:
        Iterator r34 = r10.f12666d0.iterator();
    L84:
        if (r34.hasNext() == false) goto L86;
        ((MotionHelper) r34.next()).r(r10, r24);
        goto L84
    L86:
        int r35 = 0;
    L87:
        if (r35 >= r23) goto L100;
        q r36 = (q) r24.get(r10.getChildAt(r35));
        if (r36 == null) goto L92;
        r36.i(r121, r10.getNanoTime(), r122);
    L92:
        r35 = r35 + 1;
    L100:
        c0 r123 = r10.f12676q.f12733c;
        if (r123 == null) goto L103;
        float r124 = r123.f12720i;
    L105:
        if (r124 == 0.0f) goto L111;
        float r125 = Float.MAX_VALUE;
        float r37 = -3.4028235E38f;
        int r38 = 0;
    L107:
        if (r38 >= r23) goto L109;
        a0 r39 = ((q) r24.get(r10.getChildAt(r38))).g;
        float r40 = r39.f + r39.e;
        r125 = Math.min(r125, r40);
        r37 = Math.max(r37, r40);
        r38 = r38 + 1;
    L109:
        if (r11 >= r23) goto L111;
        q r41 = (q) r24.get(r10.getChildAt(r11));
        a0 r42 = r41.g;
        float r126 = r42.e;
        float r43 = r42.f;
        r41.f12882n = 1.0f / (1.0f - r124);
        r41.f12881m = r124 - ((((r126 + r43) - r125) * r124) / (r37 - r125));
        r11 = r11 + 1;
    L111:
        r10.D = 0.0f;
        r10.E = 0.0f;
        r10.I = true;
        r10.invalidate();
        return;
    L103:
        r124 = 0.0f;
        goto L105
    L93:
        int r44 = 0;
    L94:
        if (r44 >= r23) goto L100;
        q r45 = (q) r24.get(r10.getChildAt(r44));
        if (r45 == null) goto L99;
        r10.f12676q.f(r45);
        r45.i(r121, r10.getNanoTime(), r122);
    L99:
        r44 = r44 + 1;
        goto L94
    L12:
        if (r10.f12684u0 != null) goto L14;
        r10.f12684u0 = new y(r10);
    L14:
        r10.f12684u0.d = r17;
        return;
    L113:
        c0 r46 = new c0(r5, r16);
        r46.d = r14;
        r46.f12718c = r16.f12718c;
        r10.setTransition(r46);
        r10.v(1.0f);
        r10.f12686v0 = null;
        return;
    L115:
        c0 r47 = r5.f12733c;
        int r127 = this.f12712c;
        int r48 = r127 & 1;
        if (r48 == 0) goto L118;
    L121:
        int r49 = 1;
    L122:
        int r128 = r127 & 16;
        if (r128 == 0) goto L125;
    L128:
        if (r49 == 0) goto L138;
        if (r12 == false) goto L138;
        if (r47 == r16) goto L133;
        r10.setTransition(r16);
    L133:
        if (r10.getCurrentState() != r10.getEndState()) goto L135;
    L139:
        if (r16 == r47) goto L149;
        int r50 = r16.f12718c;
        int r51 = r16.d;
        if (r51 == (-1)) goto L144;
        int r52 = r10.f12685v;
        if (r52 == r51) goto L149;
        if (r52 == r50) goto L149;
        return;
    L144:
        if (r10.f12685v != r50) goto L149;
        return;
    L149:
        if (r11 == 0) goto L152;
        if (r48 == 0) goto L152;
        r10.setTransition(r16);
        r10.v(1.0f);
        r10.f12686v0 = null;
        return;
    L152:
        if (r12 == false) goto L155;
        if (r128 == 0) goto L155;
        r10.setTransition(r16);
        r10.v(0.0f);
        return;
    L155:
        if (r11 != 0) goto L157;
    L159:
        if (r12 == true) goto L161;
        return;
    L161:
        if ((r127 & 4096) == 0) goto L200;
        r10.setTransition(r16);
        r10.setProgress(0.0f);
        return;
    L200:
        return;
    L157:
        if ((r127 & 256) == 0) goto L159;
        r10.setTransition(r16);
        r10.setProgress(1.0f);
        return;
    L135:
        if (r10.getProgress() > 0.5f) goto L139;
        r12 = false;
    L138:
        r11 = r49;
        goto L139
    L125:
        if ((r127 & 4096) != 0) goto L128;
        r12 = false;
        goto L128
    L118:
        if ((r127 & 256) != 0) goto L121;
        r49 = 0;
        goto L122
    }
}

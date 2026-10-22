package com.obric.oui.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import hr.f;
import hr.g;
import hr.o;
import lr.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.oui.constraintlayout.core.widgets.analyzer.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13060c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f13061h;

    public b(ConstraintLayout r5, ConstraintLayout r10) {
        this.f13061h = r5;
        this.f13058a = r10;
    }

    public static boolean a(int r5, int r10, int r11) {
        if (r5 != r10) goto L5;
        return true;
    L5:
        int r12 = View.MeasureSpec.getMode(r5);
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getSize(r10);
        if (r13 == 1073741824) goto L8;
    L12:
        return false;
    L8:
        if (r12 == Integer.MIN_VALUE) goto L10;
        if (r12 != 0) goto L12;
    L10:
        if (r11 != r14) goto L12;
        return true;
    }

    public final void b(f r19, com.obric.oui.constraintlayout.core.widgets.analyzer.b r20) {
        if (r19 != null) goto L6;
        return;
    L6:
        if (r19.i0 != 8) goto L12;
        if (r19.F == true) goto L12;
        r20.e = 0;
        r20.f = 0;
        r20.g = 0;
        return;
    L12:
        if (r19.V != null) goto L14;
        return;
    L14:
        m r5 = ConstraintLayout.f12989p;
        ConstraintLayout r10 = this.f13061h;
        r10.getClass();
        ConstraintWidget$DimensionBehaviour r11 = r20.f12559a;
        ConstraintWidget$DimensionBehaviour r12 = r20.f12560b;
        int r13 = r20.f12561c;
        int r14 = r20.d;
        int r15 = this.f13059b + this.f13060c;
        int r16 = this.d;
        View r17 = r19.f17404h0;
        int[] r18 = lr.c.f19699a;
        int r110 = r18[r11.ordinal()];
        hr.d r111 = r19.L;
        hr.d r112 = r19.J;
        if (r110 == 1) goto L52;
        if (r110 != 2) goto L18;
        int r21 = ViewGroup.getChildMeasureSpec(this.f, r16, -2);
    L43:
        int r22 = r21;
    L53:
        int r23 = r18[r12.ordinal()];
        if (r23 == 1) goto L90;
        if (r23 != 2) goto L57;
        int r24 = ViewGroup.getChildMeasureSpec(this.g, r15, -2);
    L91:
        g r25 = (g) r19.V;
        if (r25 != null) goto L94;
    L113:
        ConstraintWidget$DimensionBehaviour r26 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r11 != r26) goto L116;
        boolean r27 = true;
    L117:
        if (r12 != r26) goto L119;
        boolean r28 = true;
    L120:
        ConstraintWidget$DimensionBehaviour r113 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
        if (r12 != r113) goto L123;
    L126:
        boolean r29 = true;
    L127:
        if (r11 != r113) goto L129;
    L132:
        boolean r114 = true;
    L134:
        if (r27 == true) goto L136;
    L138:
        boolean r115 = false;
    L139:
        if (r28 == true) goto L141;
    L143:
        boolean r30 = false;
    L144:
        if (r17 != null) goto L146;
        return;
    L146:
        ConstraintLayout.LayoutParams r116 = (ConstraintLayout.LayoutParams) r17.getLayoutParams();
        int r117 = r20.f12564j;
        if (r117 == 1) goto L158;
        if (r117 == 2) goto L158;
        if (r27 == false) goto L158;
        if (r19.f17421r != 0) goto L158;
        if (r28 == false) goto L158;
        if (r19.s != 0) goto L158;
        int r31 = -1;
        int r32 = 0;
        boolean r118 = false;
        int r119 = 0;
        int r120 = 0;
    L197:
        if (r32 == r31) goto L199;
        boolean r33 = true;
    L201:
        if (r119 == r20.f12561c) goto L203;
    L206:
        boolean r34 = true;
    L207:
        r20.f12563i = r34;
        if (r116.f13006c0 == false) goto L210;
        boolean r121 = true;
    L211:
        if (r121 == true) goto L213;
    L217:
        r20.e = r119;
        r20.f = r120;
        r20.f12562h = r121;
        r20.g = r32;
        return;
    L213:
        if (r32 == (-1)) goto L217;
        if (r19.f17399c0 == r32) goto L217;
        r20.f12563i = true;
        goto L217
    L210:
        r121 = r33;
        goto L211
    L203:
        if (r120 != r20.d) goto L206;
        r34 = r118;
        goto L207
    L199:
        r33 = r118;
    L158:
        if ((r17 instanceof VirtualLayout) == true) goto L160;
    L162:
        r17.measure(r22, r24);
    L163:
        r19.H = r22;
        r19.I = r24;
        r19.g = false;
        int r35 = r17.getMeasuredWidth();
        int r36 = r17.getMeasuredHeight();
        int r37 = r17.getBaseline();
        int r122 = r19.f17426u;
        if (r122 <= 0) goto L166;
        r119 = Math.max(r122, r35);
    L167:
        int r123 = r19.f17427v;
        if (r123 <= 0) goto L170;
        r119 = Math.min(r123, r119);
    L170:
        int r124 = r19.f17429x;
        if (r124 <= 0) goto L173;
        r120 = Math.max(r124, r36);
    L174:
        int r38 = r19.f17430y;
        if (r38 <= 0) goto L178;
        r120 = Math.min(r38, r120);
    L178:
        if (hr.m.c(r10.f12994i, 1) == false) goto L180;
    L186:
        if (r35 != r119) goto L191;
        if (r36 != r120) goto L191;
        r32 = r37;
        r31 = -1;
        r118 = false;
    L191:
        if (r35 == r119) goto L193;
        r22 = View.MeasureSpec.makeMeasureSpec(r119, BasicMeasure.EXACTLY);
    L193:
        if (r36 == r120) goto L195;
        int r39 = View.MeasureSpec.makeMeasureSpec(r120, BasicMeasure.EXACTLY);
    L196:
        r17.measure(r22, r39);
        r19.H = r22;
        r19.I = r39;
        r118 = false;
        r19.g = false;
        int r40 = r17.getMeasuredWidth();
        r120 = r17.getMeasuredHeight();
        r119 = r40;
        r31 = -1;
        r32 = r17.getBaseline();
        goto L197
    L195:
        r39 = r24;
        goto L196
    L180:
        if (r115 == false) goto L183;
        if (r29 == false) goto L183;
        r119 = (int) ((r120 * r19.Y) + 0.5f);
    L183:
        if (r30 == false) goto L186;
        if (r114 == false) goto L186;
        r120 = (int) ((r119 / r19.Y) + 0.5f);
        goto L186
    L173:
        r120 = r36;
        goto L174
    L166:
        r119 = r35;
        goto L167
    L160:
        if ((r19 instanceof o) == false) goto L162;
        ((VirtualLayout) r17).r((o) r19, r22, r24);
        goto L163
    L141:
        if (r19.Y <= 0.0f) goto L143;
        r30 = true;
        goto L144
    L136:
        if (r19.Y <= 0.0f) goto L138;
        r115 = true;
        goto L139
    L129:
        if (r11 == ConstraintWidget$DimensionBehaviour.FIXED) goto L132;
        r114 = false;
        goto L134
    L123:
        if (r12 == ConstraintWidget$DimensionBehaviour.FIXED) goto L126;
        r29 = false;
        goto L127
    L119:
        r28 = false;
        goto L120
    L116:
        r27 = false;
        goto L117
    L94:
        if (hr.m.c(r10.f12994i, 256) == false) goto L113;
        if (r17.getMeasuredWidth() != r19.r()) goto L113;
        if (r17.getMeasuredWidth() >= r25.r()) goto L113;
        if (r17.getMeasuredHeight() != r19.l()) goto L113;
        if (r17.getMeasuredHeight() >= r25.l()) goto L113;
        if (r17.getBaseline() != r19.f17399c0) goto L113;
        if (r19.A() == true) goto L113;
        if (a(r19.H, r22, r19.r()) == false) goto L113;
        if (a(r19.I, r24, r19.l()) == false) goto L113;
        r20.e = r19.r();
        r20.f = r19.l();
        r20.g = r19.f17399c0;
        return;
    L57:
        if (r23 != 3) goto L59;
        int r41 = this.g;
        if (r112 == null) goto L85;
        int r42 = r19.K.g;
    L86:
        if (r111 == null) goto L88;
        r42 = r42 + r19.M.g;
    L88:
        r24 = ViewGroup.getChildMeasureSpec(r41, r15 + r42, -1);
        goto L91
    L85:
        r42 = 0;
        goto L86
    L59:
        if (r23 == 4) goto L61;
        r24 = 0;
        goto L91
    L61:
        r24 = ViewGroup.getChildMeasureSpec(this.g, r15, -2);
        if (r19.s != 1) goto L64;
        boolean r43 = true;
    L65:
        int r44 = r20.f12564j;
        if (r44 == 1) goto L69;
        if (r44 != 2) goto L91;
    L69:
        if (r17.getMeasuredWidth() != r19.r()) goto L71;
        boolean r45 = true;
    L73:
        if (r20.f12564j == 2) goto L81;
        if (r43 == false) goto L81;
        if (r43 == false) goto L78;
        if (r45 == true) goto L81;
    L78:
        if ((r17 instanceof Placeholder) == true) goto L81;
        if (r19.C() == false) goto L91;
    L81:
        r24 = View.MeasureSpec.makeMeasureSpec(r19.l(), BasicMeasure.EXACTLY);
        goto L91
    L71:
        r45 = false;
        goto L73
    L64:
        r43 = false;
        goto L65
    L90:
        r24 = View.MeasureSpec.makeMeasureSpec(r14, BasicMeasure.EXACTLY);
        goto L91
    L18:
        if (r110 != 3) goto L20;
        int r46 = this.f;
        if (r112 == null) goto L47;
        int r47 = r112.g;
    L48:
        if (r111 == null) goto L50;
        r47 = r47 + r111.g;
    L50:
        r21 = ViewGroup.getChildMeasureSpec(r46, r16 + r47, -1);
        goto L43
    L47:
        r47 = 0;
        goto L48
    L20:
        if (r110 == 4) goto L22;
        r22 = 0;
        goto L53
    L22:
        r22 = ViewGroup.getChildMeasureSpec(this.f, r16, -2);
        if (r19.f17421r != 1) goto L25;
        boolean r125 = true;
    L26:
        int r126 = r20.f12564j;
        if (r126 == 1) goto L30;
        if (r126 != 2) goto L53;
    L30:
        if (r17.getMeasuredHeight() != r19.l()) goto L32;
        boolean r48 = true;
    L34:
        if (r20.f12564j == 2) goto L42;
        if (r125 == false) goto L42;
        if (r125 == false) goto L39;
        if (r48 == true) goto L42;
    L39:
        if ((r17 instanceof Placeholder) == true) goto L42;
        if (r19.B() == false) goto L53;
    L42:
        r21 = View.MeasureSpec.makeMeasureSpec(r19.r(), BasicMeasure.EXACTLY);
        goto L43
    L32:
        r48 = false;
        goto L34
    L25:
        r125 = false;
        goto L26
    L52:
        r22 = View.MeasureSpec.makeMeasureSpec(r13, BasicMeasure.EXACTLY);
        goto L53
    }
}

package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f12586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f12587l;

    public p(hr.f r5) {
        super(r5);
        g r10 = new g(this);
        this.f12586k = r10;
        this.f12587l = null;
        g r11 = this.f12595h;
        r11.e = DependencyNode$Type.TOP;
        g r12 = this.f12596i;
        r12.e = DependencyNode$Type.BOTTOM;
        r10.e = DependencyNode$Type.BASELINE;
        this.f = 1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.e
    public final void a(e r10) {
        if (o.f12585a[this.f12597j.ordinal()] == 3) goto L81;
        h r11 = this.e;
        if (r11.f12573c == true) goto L7;
    L32:
        g r5 = this.f12595h;
        if (r5.f12573c == false) goto L83;
        g r12 = this.f12596i;
        if (r12.f12573c == true) goto L38;
        return;
    L38:
        if (r5.f12576j == false) goto L45;
        if (r12.f12576j == false) goto L45;
        if (r11.f12576j == false) goto L45;
        return;
    L45:
        if (r11.f12576j == true) goto L55;
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L55;
        hr.f r13 = this.f12593b;
        if (r13.f17421r != 0) goto L55;
        if (r13.z() == true) goto L55;
        g r14 = (g) r5.f12578l.get(0);
        g r15 = (g) r12.f12578l.get(0);
        int r16 = r14.g + r5.f;
        int r17 = r15.g + r12.f;
        r5.d(r16);
        r12.d(r17);
        r11.d(r17 - r16);
        return;
    L55:
        if (r11.f12576j == true) goto L69;
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L69;
        if (this.f12592a != 1) goto L69;
        if (r5.f12578l.size() <= 0) goto L69;
        if (r12.f12578l.size() <= 0) goto L69;
        g r18 = (g) r5.f12578l.get(0);
        g r19 = (g) r12.f12578l.get(0);
        int r20 = (r19.g + r12.f) - (r18.g + r5.f);
        int r21 = r11.f12579m;
        if (r20 >= r21) goto L67;
        r11.d(r20);
        goto L69
    L67:
        r11.d(r21);
    L69:
        if (r11.f12576j == true) goto L72;
        return;
    L72:
        if (r5.f12578l.size() > 0) goto L74;
        return;
    L74:
        if (r12.f12578l.size() <= 0) goto L85;
        g r22 = (g) r5.f12578l.get(0);
        g r23 = (g) r12.f12578l.get(0);
        int r24 = r22.g;
        int r25 = r5.f + r24;
        int r26 = r23.g;
        int r27 = r12.f + r26;
        float r28 = this.f12593b.g0;
        if (r22 != r23) goto L78;
        r28 = 0.5f;
    L79:
        r5.d((int) ((((r26 - r24) - r11.g) * r28) + (r24 + 0.5f)));
        r12.d(r5.g + r11.g);
        return;
    L78:
        r24 = r25;
        r26 = r27;
        goto L79
    L85:
        return;
    L83:
        return;
    L7:
        if (r11.f12576j == true) goto L32;
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        hr.f r29 = this.f12593b;
        int r30 = r29.s;
        if (r30 == 2) goto L27;
        if (r30 != 3) goto L32;
        h r31 = r29.d.e;
        if (r31.f12576j == false) goto L32;
        int r32 = r29.Z;
        if (r32 == (-1)) goto L25;
        if (r32 == 0) goto L24;
        if (r32 == 1) goto L21;
        int r33 = 0;
    L26:
        r11.d(r33);
        goto L32
    L21:
        float r34 = r31.g;
        float r35 = r29.Y;
    L22:
        float r36 = r34 / r35;
    L23:
        r33 = (int) (r36 + 0.5f);
        goto L26
    L24:
        r36 = r31.g * r29.Y;
        goto L23
    L25:
        r34 = r31.g;
        r35 = r29.Y;
        goto L22
    L27:
        hr.f r37 = r29.V;
        if (r37 == null) goto L32;
        h r38 = r37.e.e;
        if (r38.f12576j == false) goto L32;
        r11.d((int) ((r38.g * r29.f17431z) + 0.5f));
        goto L32
    L81:
        hr.f r110 = this.f12593b;
        l(r110.K, r110.M, 1);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void d() {
        hr.f r5 = this.f12593b;
        boolean r10 = r5.f17394a;
        h r11 = this.e;
        if (r10 == false) goto L5;
        r11.d(r5.l());
    L5:
        boolean r12 = r11.f12576j;
        g r13 = this.f12596i;
        g r14 = this.f12595h;
        if (r12 == true) goto L24;
        hr.f r15 = this.f12593b;
        this.d = r15.U[1];
        if (r15.E == false) goto L10;
        this.f12587l = new a(this);
    L10:
        ConstraintWidget$DimensionBehaviour r16 = this.d;
        if (r16 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
    L31:
        boolean r17 = r11.f12576j;
        g r18 = this.f12586k;
        if (r17 == false) goto L80;
        hr.f r19 = this.f12593b;
        if (r19.f17394a == false) goto L80;
        hr.d[] r20 = r19.R;
        hr.d r110 = r20[2];
        hr.d r111 = r110.f;
        if (r111 != null) goto L38;
    L52:
        if (r111 == null) goto L58;
        g r21 = s.h(r110);
        if (r21 == null) goto L160;
        s.b(r14, r21, this.f12593b.R[2].e());
        s.b(r13, r14, r11.g);
        hr.f r112 = this.f12593b;
        if (r112.E == false) goto L161;
        s.b(r18, r14, r112.f17399c0);
        return;
    L161:
        return;
    L160:
        return;
    L58:
        hr.d r22 = r20[3];
        if (r22.f == null) goto L66;
        g r23 = s.h(r22);
        if (r23 == null) goto L63;
        s.b(r13, r23, -this.f12593b.R[3].e());
        s.b(r14, r13, -r11.g);
    L63:
        hr.f r113 = this.f12593b;
        if (r113.E == false) goto L163;
        s.b(r18, r14, r113.f17399c0);
        return;
    L163:
        return;
    L66:
        hr.d r24 = r20[4];
        if (r24.f == null) goto L72;
        g r25 = s.h(r24);
        if (r25 == null) goto L165;
        s.b(r18, r25, 0);
        s.b(r14, r18, -this.f12593b.f17399c0);
        s.b(r13, r14, r11.g);
        return;
    L165:
        return;
    L72:
        if ((r19 instanceof hr.l) == false) goto L74;
        return;
    L74:
        if (r19.V != null) goto L76;
        return;
    L76:
        if (r19.j(ConstraintAnchor$Type.CENTER).f != null) goto L169;
        hr.f r26 = this.f12593b;
        s.b(r14, r26.V.e.f12595h, r26.t());
        s.b(r13, r14, r11.g);
        hr.f r114 = this.f12593b;
        if (r114.E == false) goto L170;
        s.b(r18, r14, r114.f17399c0);
        return;
    L170:
        return;
    L169:
        return;
    L38:
        if (r20[3].f == null) goto L52;
        if (r19.z() == false) goto L42;
        r14.f = this.f12593b.R[2].e();
        r13.f = -this.f12593b.R[3].e();
    L49:
        hr.f r115 = this.f12593b;
        if (r115.E == false) goto L158;
        s.b(r18, r14, r115.f17399c0);
        return;
    L158:
        return;
    L42:
        g r27 = s.h(this.f12593b.R[2]);
        if (r27 == null) goto L45;
        s.b(r14, r27, this.f12593b.R[2].e());
    L45:
        g r28 = s.h(this.f12593b.R[3]);
        if (r28 == null) goto L48;
        s.b(r13, r28, -this.f12593b.R[3].e());
    L48:
        r14.f12572b = true;
        r13.f12572b = true;
    L80:
        if (r17 == false) goto L82;
    L97:
        r11.b(this);
    L98:
        hr.f r29 = this.f12593b;
        hr.d[] r116 = r29.R;
        hr.d r117 = r116[2];
        hr.d r118 = r117.f;
        if (r118 == null) goto L115;
        if (r116[3].f == null) goto L115;
        if (r29.z() == false) goto L105;
        r14.f = this.f12593b.R[2].e();
        r13.f = -this.f12593b.R[3].e();
    L112:
        if (this.f12593b.E == false) goto L155;
        c(r18, r14, 1, this.f12587l);
    L155:
        if (r11.f12578l.size() != 0) goto L172;
        r11.f12573c = true;
        return;
    L172:
        return;
    L105:
        g r30 = s.h(this.f12593b.R[2]);
        g r31 = s.h(this.f12593b.R[3]);
        if (r30 == null) goto L108;
        r30.b(this);
    L108:
        if (r31 == null) goto L110;
        r31.b(this);
    L110:
        this.f12597j = WidgetRun$RunType.CENTER;
    L115:
        if (r118 == null) goto L128;
        g r32 = s.h(r117);
        if (r32 == null) goto L155;
        s.b(r14, r32, this.f12593b.R[2].e());
        c(r13, r14, 1, r11);
        if (this.f12593b.E == false) goto L121;
        c(r18, r14, 1, this.f12587l);
    L121:
        ConstraintWidget$DimensionBehaviour r33 = this.d;
        ConstraintWidget$DimensionBehaviour r34 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r33 != r34) goto L155;
        hr.f r35 = this.f12593b;
        if (r35.Y <= 0.0f) goto L155;
        m r36 = r35.d;
        if (r36.d != r34) goto L155;
        r36.e.f12577k.add(r11);
        r11.f12578l.add(this.f12593b.d.e);
        r11.f12571a = this;
        goto L155
    L128:
        hr.d r37 = r116[3];
        if (r37.f == null) goto L135;
        g r38 = s.h(r37);
        if (r38 == null) goto L155;
        s.b(r13, r38, -this.f12593b.R[3].e());
        c(r14, r13, -1, r11);
        if (this.f12593b.E == false) goto L155;
        c(r18, r14, 1, this.f12587l);
        goto L155
    L135:
        hr.d r39 = r116[4];
        if (r39.f == null) goto L141;
        g r40 = s.h(r39);
        if (r40 == null) goto L155;
        s.b(r18, r40, 0);
        c(r14, r18, -1, this.f12587l);
        c(r13, r14, 1, r11);
        goto L155
    L141:
        if ((r29 instanceof hr.l) == true) goto L155;
        hr.f r41 = r29.V;
        if (r41 == null) goto L155;
        s.b(r14, r41.e.f12595h, r29.t());
        c(r13, r14, 1, r11);
        if (this.f12593b.E == false) goto L147;
        c(r18, r14, 1, this.f12587l);
    L147:
        ConstraintWidget$DimensionBehaviour r42 = this.d;
        ConstraintWidget$DimensionBehaviour r43 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r42 != r43) goto L155;
        hr.f r44 = this.f12593b;
        if (r44.Y <= 0.0f) goto L155;
        m r45 = r44.d;
        if (r45.d != r43) goto L155;
        r45.e.f12577k.add(r11);
        r11.f12578l.add(this.f12593b.d.e);
        r11.f12571a = this;
        goto L155
    L82:
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
        hr.f r46 = this.f12593b;
        int r119 = r46.s;
        if (r119 == 2) goto L93;
        if (r119 != 3) goto L98;
        if (r46.z() == true) goto L98;
        hr.f r47 = this.f12593b;
        if (r47.f17421r == 3) goto L98;
        h r48 = r47.d.e;
        r11.f12578l.add(r48);
        r48.f12577k.add(r11);
        r11.f12572b = true;
        r11.f12577k.add(r14);
        r11.f12577k.add(r13);
        goto L98
    L93:
        hr.f r49 = r46.V;
        if (r49 == null) goto L98;
        h r50 = r49.e.e;
        r11.f12578l.add(r50);
        r50.f12577k.add(r11);
        r11.f12572b = true;
        r11.f12577k.add(r14);
        r11.f12577k.add(r13);
        goto L98
    L13:
        if (r16 != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L21;
        hr.f r51 = this.f12593b.V;
        if (r51 == null) goto L21;
        if (r51.U[1] != ConstraintWidget$DimensionBehaviour.FIXED) goto L21;
        int r52 = (r51.l() - this.f12593b.K.e()) - this.f12593b.M.e();
        s.b(r14, r51.e.f12595h, this.f12593b.K.e());
        s.b(r13, r51.e.f12596i, -this.f12593b.M.e());
        r11.d(r52);
        return;
    L21:
        if (r16 != ConstraintWidget$DimensionBehaviour.FIXED) goto L31;
        r11.d(this.f12593b.l());
        goto L31
    L24:
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L31;
        hr.f r53 = this.f12593b;
        hr.f r54 = r53.V;
        if (r54 == null) goto L31;
        if (r54.U[1] != ConstraintWidget$DimensionBehaviour.FIXED) goto L31;
        s.b(r14, r54.e.f12595h, r53.K.e());
        s.b(r13, r54.e.f12596i, -this.f12593b.M.e());
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void e() {
        g r5 = this.f12595h;
        if (r5.f12576j == false) goto L6;
        hr.f r10 = this.f12593b;
        r10.f17397b0 = r5.g;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void f() {
        this.f12594c = null;
        this.f12595h.c();
        this.f12596i.c();
        this.f12586k.c();
        this.e.c();
        this.g = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final boolean k() {
        if (this.d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.f12593b.s != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final void m() {
        this.g = false;
        g r5 = this.f12595h;
        r5.c();
        r5.f12576j = false;
        g r10 = this.f12596i;
        r10.c();
        r10.f12576j = false;
        g r11 = this.f12586k;
        r11.c();
        r11.f12576j = false;
        this.e.f12576j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f12593b.f17409k0;
    }
}

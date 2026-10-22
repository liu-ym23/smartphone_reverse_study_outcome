package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f12582k = null;

    static {
        f12582k = new int[2];
    }

    public m(hr.f r5) {
        super(r5);
        g r10 = this.f12595h;
        r10.e = DependencyNode$Type.LEFT;
        g r11 = this.f12596i;
        r11.e = DependencyNode$Type.RIGHT;
        this.f = 0;
    }

    public static void m(int[] r5, int r10, int r11, int r12, int r13, float r14, int r15) {
        int r16 = r11 - r10;
        int r17 = r13 - r12;
        if (r15 == (-1)) goto L9;
        if (r15 == 0) goto L8;
        if (r15 != 1) goto L19;
        r5[0] = r16;
        r5[1] = (int) ((r16 * r14) + 0.5f);
        return;
    L19:
        return;
    L8:
        r5[0] = (int) ((r17 * r14) + 0.5f);
        r5[1] = r17;
        return;
    L9:
        int r18 = (int) ((r17 * r14) + 0.5f);
        int r19 = (int) ((r16 / r14) + 0.5f);
        if (r18 > r16) goto L12;
        r5[0] = r18;
        r5[1] = r17;
        return;
    L12:
        if (r19 > r17) goto L18;
        r5[0] = r16;
        r5[1] = r19;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.e
    public final void a(e r23) {
        if (l.f12581a[this.f12597j.ordinal()] == 3) goto L173;
        h r5 = this.e;
        boolean r10 = r5.f12576j;
        g r11 = this.f12595h;
        g r12 = this.f12596i;
        if (r10 == true) goto L129;
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L129;
        hr.f r13 = this.f12593b;
        int r14 = r13.f17421r;
        if (r14 == 2) goto L123;
        if (r14 != 3) goto L129;
        int r15 = r13.s;
        if (r15 == 0) goto L27;
        if (r15 == 3) goto L27;
        int r16 = r13.Z;
        if (r16 == (-1)) goto L25;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L21;
        int r17 = 0;
    L26:
        r5.d(r17);
        goto L129
    L21:
        float r18 = r13.e.e.g;
        float r19 = r13.Y;
    L22:
        float r20 = r18 * r19;
    L23:
        r17 = (int) (r20 + 0.5f);
        goto L26
    L24:
        r20 = r13.e.e.g / r13.Y;
        goto L23
    L25:
        r18 = r13.e.e.g;
        r19 = r13.Y;
    L27:
        p r21 = r13.e;
        g r22 = r21.f12595h;
        g r24 = r21.f12596i;
        if (r13.J.f == null) goto L30;
        boolean r110 = true;
    L32:
        if (r13.K.f == null) goto L34;
        boolean r111 = true;
    L36:
        if (r13.L.f == null) goto L38;
        boolean r112 = true;
    L40:
        if (r13.M.f == null) goto L42;
        boolean r113 = true;
    L43:
        int r114 = r13.Z;
        if (r110 == false) goto L81;
        if (r111 == false) goto L81;
        if (r112 == false) goto L81;
        if (r113 == false) goto L81;
        float r25 = r13.Y;
        boolean r115 = r22.f12576j;
        int[] r116 = f12582k;
        if (r115 == true) goto L51;
    L59:
        boolean r117 = r11.f12576j;
        ArrayList r118 = r22.f12578l;
        if (r117 == false) goto L71;
        if (r12.f12576j == false) goto L71;
        if (r22.f12573c == true) goto L66;
        return;
    L66:
        if (r24.f12573c == false) goto L177;
        m(r116, r11.g + r11.f, r12.g - r12.f, ((g) r118.get(0)).g + r22.f, ((g) r24.f12578l.get(0)).g - r24.f, r25, r114);
        r5.d(r116[0]);
        this.f12593b.e.e.d(r116[1]);
        goto L71
    L177:
        return;
    L71:
        if (r11.f12573c == true) goto L73;
        return;
    L73:
        if (r12.f12573c == true) goto L75;
        return;
    L75:
        if (r22.f12573c == true) goto L77;
        return;
    L77:
        if (r24.f12573c == false) goto L180;
        m(r116, ((g) r11.f12578l.get(0)).g + r11.f, ((g) r12.f12578l.get(0)).g - r12.f, ((g) r118.get(0)).g + r22.f, ((g) r24.f12578l.get(0)).g - r24.f, r25, r114);
        r5.d(r116[0]);
        this.f12593b.e.e.d(r116[1]);
        goto L129
    L180:
        return;
    L51:
        if (r24.f12576j == false) goto L59;
        if (r11.f12573c == true) goto L55;
        return;
    L55:
        if (r12.f12573c == false) goto L176;
        m(r116, ((g) r11.f12578l.get(0)).g + r11.f, ((g) r12.f12578l.get(0)).g - r12.f, r22.g + r22.f, r24.g - r24.f, r25, r114);
        r5.d(r116[0]);
        this.f12593b.e.e.d(r116[1]);
        return;
    L176:
        return;
    L81:
        if (r110 == false) goto L102;
        if (r112 == false) goto L102;
        if (r11.f12573c == true) goto L86;
        return;
    L86:
        if (r12.f12573c == false) goto L181;
        float r26 = r13.Y;
        int r27 = ((g) r11.f12578l.get(0)).g + r11.f;
        int r28 = ((g) r12.f12578l.get(0)).g - r12.f;
        if (r114 == (-1)) goto L97;
        if (r114 == 0) goto L97;
        if (r114 != 1) goto L129;
        int r29 = g(r28 - r27, 0);
        int r30 = (int) ((r29 / r26) + 0.5f);
        int r119 = g(r30, 1);
        if (r30 == r119) goto L96;
        r29 = (int) ((r119 * r26) + 0.5f);
    L96:
        r5.d(r29);
        this.f12593b.e.e.d(r119);
    L97:
        int r31 = g(r28 - r27, 0);
        int r32 = (int) ((r31 * r26) + 0.5f);
        int r120 = g(r32, 1);
        if (r32 == r120) goto L100;
        r31 = (int) ((r120 / r26) + 0.5f);
    L100:
        r5.d(r31);
        this.f12593b.e.e.d(r120);
        goto L129
    L181:
        return;
    L102:
        if (r111 == false) goto L129;
        if (r113 == false) goto L129;
        if (r22.f12573c == true) goto L107;
        return;
    L107:
        if (r24.f12573c == false) goto L182;
        float r33 = r13.Y;
        int r121 = ((g) r22.f12578l.get(0)).g + r22.f;
        int r34 = ((g) r24.f12578l.get(0)).g - r24.f;
        if (r114 == (-1)) goto L118;
        if (r114 == 0) goto L114;
        if (r114 == 1) goto L118;
    L114:
        int r35 = g(r34 - r121, 1);
        int r36 = (int) ((r35 * r33) + 0.5f);
        int r122 = g(r36, 0);
        if (r36 == r122) goto L117;
        r35 = (int) ((r122 / r33) + 0.5f);
    L117:
        r5.d(r122);
        this.f12593b.e.e.d(r35);
    L118:
        int r37 = g(r34 - r121, 1);
        int r38 = (int) ((r37 / r33) + 0.5f);
        int r123 = g(r38, 0);
        if (r38 == r123) goto L121;
        r37 = (int) ((r123 * r33) + 0.5f);
    L121:
        r5.d(r123);
        this.f12593b.e.e.d(r37);
        goto L129
    L182:
        return;
    L42:
        r113 = false;
        goto L43
    L38:
        r112 = false;
        goto L40
    L34:
        r111 = false;
        goto L36
    L30:
        r110 = false;
        goto L32
    L123:
        hr.f r39 = r13.V;
        if (r39 == null) goto L129;
        h r40 = r39.d.e;
        if (r40.f12576j == false) goto L129;
        r5.d((int) ((r40.g * r13.f17428w) + 0.5f));
    L129:
        if (r11.f12573c == true) goto L131;
        return;
    L131:
        if (r12.f12573c == true) goto L134;
        return;
    L134:
        if (r11.f12576j == false) goto L141;
        if (r12.f12576j == false) goto L141;
        if (r5.f12576j == false) goto L141;
        return;
    L141:
        if (r5.f12576j == true) goto L151;
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L151;
        hr.f r41 = this.f12593b;
        if (r41.f17421r != 0) goto L151;
        if (r41.y() == true) goto L151;
        g r42 = (g) r11.f12578l.get(0);
        g r43 = (g) r12.f12578l.get(0);
        int r44 = r42.g + r11.f;
        int r45 = r43.g + r12.f;
        r11.d(r44);
        r12.d(r45);
        r5.d(r45 - r44);
        return;
    L151:
        if (r5.f12576j == true) goto L165;
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L165;
        if (this.f12592a != 1) goto L165;
        if (r11.f12578l.size() <= 0) goto L165;
        if (r12.f12578l.size() <= 0) goto L165;
        g r46 = (g) r11.f12578l.get(0);
        g r47 = (g) r12.f12578l.get(0);
        int r48 = Math.min((r47.g + r12.f) - (r46.g + r11.f), r5.f12579m);
        hr.f r49 = this.f12593b;
        int r50 = r49.f17427v;
        int r51 = Math.max(r49.f17426u, r48);
        if (r50 <= 0) goto L163;
        r51 = Math.min(r50, r51);
    L163:
        r5.d(r51);
    L165:
        if (r5.f12576j == true) goto L167;
        return;
    L167:
        g r52 = (g) r11.f12578l.get(0);
        g r53 = (g) r12.f12578l.get(0);
        int r54 = r52.g;
        int r55 = r11.f + r54;
        int r56 = r53.g;
        int r124 = r12.f + r56;
        float r57 = this.f12593b.f17402f0;
        if (r52 != r53) goto L170;
        r57 = 0.5f;
    L171:
        r11.d((int) ((((r56 - r54) - r5.g) * r57) + (r54 + 0.5f)));
        r12.d(r11.g + r5.g);
        return;
    L170:
        r54 = r55;
        r56 = r124;
        goto L171
    L173:
        hr.f r58 = this.f12593b;
        l(r58.J, r58.L, 0);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void d() {
        hr.f r5 = this.f12593b;
        boolean r10 = r5.f17394a;
        h r11 = this.e;
        if (r10 == false) goto L5;
        r11.d(r5.r());
    L5:
        boolean r12 = r11.f12576j;
        g r13 = this.f12596i;
        g r14 = this.f12595h;
        if (r12 == true) goto L21;
        hr.f r15 = this.f12593b;
        ConstraintWidget$DimensionBehaviour r16 = r15.U[0];
        this.d = r16;
        if (r16 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L31;
        ConstraintWidget$DimensionBehaviour r17 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
        if (r16 != r17) goto L19;
        hr.f r18 = r15.V;
        if (r18 == null) goto L19;
        ConstraintWidget$DimensionBehaviour r19 = r18.U[0];
        if (r19 == ConstraintWidget$DimensionBehaviour.FIXED) goto L16;
        if (r19 != r17) goto L19;
    L16:
        int r20 = (r18.r() - this.f12593b.J.e()) - this.f12593b.L.e();
        s.b(r14, r18.d.f12595h, this.f12593b.J.e());
        s.b(r13, r18.d.f12596i, -this.f12593b.L.e());
        r11.d(r20);
        return;
    L19:
        if (r16 != ConstraintWidget$DimensionBehaviour.FIXED) goto L31;
        r11.d(r15.r());
    L31:
        if (r11.f12576j == false) goto L65;
        hr.f r21 = this.f12593b;
        if (r21.f17394a == false) goto L65;
        hr.d[] r22 = r21.R;
        hr.d r23 = r22[0];
        hr.d r24 = r23.f;
        if (r24 != null) goto L37;
    L48:
        if (r24 == null) goto L52;
        g r25 = s.h(r23);
        if (r25 == null) goto L115;
        s.b(r14, r25, this.f12593b.R[0].e());
        s.b(r13, r14, r11.g);
        return;
    L115:
        return;
    L52:
        hr.d r26 = r22[1];
        if (r26.f == null) goto L58;
        g r27 = s.h(r26);
        if (r27 == null) goto L117;
        s.b(r13, r27, -this.f12593b.R[1].e());
        s.b(r14, r13, -r11.g);
        return;
    L117:
        return;
    L58:
        if ((r21 instanceof hr.l) == false) goto L60;
        return;
    L60:
        if (r21.V != null) goto L62;
        return;
    L62:
        if (r21.j(ConstraintAnchor$Type.CENTER).f != null) goto L121;
        hr.f r110 = this.f12593b;
        s.b(r14, r110.V.d.f12595h, r110.s());
        s.b(r13, r14, r11.g);
        return;
    L121:
        return;
    L37:
        if (r22[1].f == null) goto L48;
        if (r21.y() == false) goto L41;
        r14.f = this.f12593b.R[0].e();
        r13.f = -this.f12593b.R[1].e();
        return;
    L41:
        g r28 = s.h(this.f12593b.R[0]);
        if (r28 == null) goto L44;
        s.b(r14, r28, this.f12593b.R[0].e());
    L44:
        g r29 = s.h(this.f12593b.R[1]);
        if (r29 == null) goto L47;
        s.b(r13, r29, -this.f12593b.R[1].e());
    L47:
        r14.f12572b = true;
        r13.f12572b = true;
        return;
    L65:
        if (this.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L85;
        hr.f r30 = this.f12593b;
        int r31 = r30.f17421r;
        if (r31 != 2) goto L69;
        hr.f r32 = r30.V;
        if (r32 == null) goto L85;
        h r33 = r32.e.e;
        r11.f12578l.add(r33);
        r33.f12577k.add(r11);
        r11.f12572b = true;
        r11.f12577k.add(r14);
        r11.f12577k.add(r13);
        goto L85
    L69:
        if (r31 != 3) goto L85;
        if (r30.s != 3) goto L80;
        r14.f12571a = this;
        r13.f12571a = this;
        p r34 = r30.e;
        r34.f12595h.f12571a = this;
        r34.f12596i.f12571a = this;
        r11.f12571a = this;
        if (r30.z() == false) goto L77;
        r11.f12578l.add(this.f12593b.e.e);
        this.f12593b.e.e.f12577k.add(r11);
        p r35 = this.f12593b.e;
        r35.e.f12571a = this;
        r11.f12578l.add(r35.f12595h);
        r11.f12578l.add(this.f12593b.e.f12596i);
        this.f12593b.e.f12595h.f12577k.add(r11);
        this.f12593b.e.f12596i.f12577k.add(r11);
        goto L85
    L77:
        if (this.f12593b.y() == false) goto L79;
        this.f12593b.e.e.f12578l.add(r11);
        r11.f12577k.add(this.f12593b.e.e);
        goto L85
    L79:
        this.f12593b.e.e.f12578l.add(r11);
        goto L85
    L80:
        h r36 = r30.e.e;
        r11.f12578l.add(r36);
        r36.f12577k.add(r11);
        this.f12593b.e.f12595h.f12577k.add(r11);
        this.f12593b.e.f12596i.f12577k.add(r11);
        r11.f12572b = true;
        r11.f12577k.add(r14);
        r11.f12577k.add(r13);
        r14.f12578l.add(r11);
        r13.f12578l.add(r11);
    L85:
        hr.f r37 = this.f12593b;
        hr.d[] r38 = r37.R;
        hr.d r39 = r38[0];
        hr.d r40 = r39.f;
        if (r40 != null) goto L88;
    L98:
        if (r40 == null) goto L102;
        g r41 = s.h(r39);
        if (r41 == null) goto L125;
        s.b(r14, r41, this.f12593b.R[0].e());
        c(r13, r14, 1, r11);
        return;
    L125:
        return;
    L102:
        hr.d r42 = r38[1];
        if (r42.f == null) goto L108;
        g r43 = s.h(r42);
        if (r43 == null) goto L127;
        s.b(r13, r43, -this.f12593b.R[1].e());
        c(r14, r13, -1, r11);
        return;
    L127:
        return;
    L108:
        if ((r37 instanceof hr.l) == true) goto L129;
        hr.f r44 = r37.V;
        if (r44 == null) goto L130;
        s.b(r14, r44.d.f12595h, r37.s());
        c(r13, r14, 1, r11);
        return;
    L130:
        return;
    L129:
        return;
    L88:
        if (r38[1].f == null) goto L98;
        if (r37.y() == false) goto L92;
        r14.f = this.f12593b.R[0].e();
        r13.f = -this.f12593b.R[1].e();
        return;
    L92:
        g r45 = s.h(this.f12593b.R[0]);
        g r46 = s.h(this.f12593b.R[1]);
        if (r45 == null) goto L95;
        r45.b(this);
    L95:
        if (r46 == null) goto L97;
        r46.b(this);
    L97:
        this.f12597j = WidgetRun$RunType.CENTER;
        return;
    L21:
        ConstraintWidget$DimensionBehaviour r47 = this.d;
        ConstraintWidget$DimensionBehaviour r48 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
        if (r47 != r48) goto L31;
        hr.f r49 = this.f12593b;
        hr.f r50 = r49.V;
        if (r50 == null) goto L31;
        ConstraintWidget$DimensionBehaviour r51 = r50.U[0];
        if (r51 == ConstraintWidget$DimensionBehaviour.FIXED) goto L28;
        if (r51 != r48) goto L31;
    L28:
        s.b(r14, r50.d.f12595h, r49.J.e());
        s.b(r13, r50.d.f12596i, -this.f12593b.L.e());
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void e() {
        g r5 = this.f12595h;
        if (r5.f12576j == false) goto L6;
        hr.f r10 = this.f12593b;
        r10.f17395a0 = r5.g;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void f() {
        this.f12594c = null;
        this.f12595h.c();
        this.f12596i.c();
        this.e.c();
        this.g = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final boolean k() {
        if (this.d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.f12593b.f17421r != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final void n() {
        this.g = false;
        g r5 = this.f12595h;
        r5.c();
        r5.f12576j = false;
        g r10 = this.f12596i;
        r10.c();
        r10.f12576j = false;
        this.e.f12576j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f12593b.f17409k0;
    }
}

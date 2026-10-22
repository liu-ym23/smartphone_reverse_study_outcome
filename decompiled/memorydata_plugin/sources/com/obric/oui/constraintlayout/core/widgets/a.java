package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.SolverVariable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f13611a;
    private int aB;
    private boolean aC;
    private int aD;

    public a() {
        this.aB = 0;
        this.aC = true;
        this.aD = 0;
        this.f13611a = false;
    }

    public void a(int r1) {
        this.aB = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(com.obric.oui.constraintlayout.core.d r13, boolean r14) {
        this.f13606J[0] = this.B;
        this.f13606J[2] = this.C;
        this.f13606J[1] = this.D;
        this.f13606J[3] = this.E;
        int r15 = 0;
    L4:
        if (r15 >= this.f13606J.length) goto L6;
        this.f13606J[r15].f = r13.a(this.f13606J[r15]);
        r15 = r15 + 1;
        goto L4
    L6:
        int r16 = this.aB;
        if (r16 >= 0) goto L9;
        return;
    L9:
        if (r16 >= 4) goto L130;
        ConstraintAnchor r17 = this.f13606J[this.aB];
        if (this.f13611a == true) goto L14;
        i();
    L14:
        if (this.f13611a == false) goto L25;
        this.f13611a = false;
        int r18 = this.aB;
        if (r18 == 0) goto L22;
        if (r18 == 1) goto L22;
        if (r18 == 2) goto L21;
        if (r18 == 3) goto L21;
        return;
    L21:
        r13.a(this.C.f, this.S);
        SolverVariable r19 = this.E.f;
        int r12 = this.S;
    L23:
        r13.a(r19, r12);
        return;
    L22:
        r13.a(this.B.f, this.R);
        r19 = this.D.f;
        r12 = this.R;
        goto L23
    L25:
        int r5 = 0;
    L27:
        if (r5 >= this.aA) goto L54;
        ConstraintWidget r6 = this.az[r5];
        if (this.aC == false) goto L31;
    L33:
        int r7 = this.aB;
        if (r7 == 0) goto L37;
        if (r7 == 1) goto L37;
    L43:
        int r8 = this.aB;
        if (r8 == 2) goto L47;
        if (r8 == 3) goto L47;
    L53:
        r5 = r5 + 1;
    L47:
        if (r6.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L53;
        if (r6.C.c == null) goto L53;
        if (r6.E.c == null) goto L53;
    L42:
        boolean r9 = true;
    L56:
        if (this.B.c() == false) goto L58;
    L61:
        boolean r10 = true;
    L63:
        if (this.C.c() == false) goto L65;
    L68:
        boolean r11 = true;
    L69:
        if (r9 == true) goto L80;
        int r20 = this.aB;
        if (r20 != 0) goto L73;
        if (r10 == false) goto L73;
    L79:
        boolean r21 = true;
    L81:
        int r22 = 5;
        if (r21 == true) goto L84;
        r22 = 4;
    L84:
        int r23 = 0;
    L86:
        if (r23 >= this.aA) goto L106;
        ConstraintWidget r24 = this.az[r23];
        if (this.aC == false) goto L90;
    L92:
        SolverVariable r25 = r13.a(r24.f13606J[this.aB]);
        r24.f13606J[this.aB].f = r25;
        if (r24.f13606J[this.aB].c != null) goto L95;
    L97:
        int r26 = 0;
    L98:
        int r110 = this.aB;
        if (r110 == 0) goto L103;
        if (r110 == 2) goto L103;
        r13.a(r17.f, r25, this.aD + r26, r9);
    L104:
        r13.c(r17.f, r25, this.aD + r26, r22);
    L105:
        r23 = r23 + 1;
    L103:
        r13.b(r17.f, r25, this.aD - r26, r9);
        goto L104
    L95:
        if (r24.f13606J[this.aB].c.f13603a != this) goto L97;
        r26 = r24.f13606J[this.aB].d + 0;
        goto L98
    L90:
        if (r24.a() == true) goto L92;
    L106:
        int r111 = this.aB;
        if (r111 != 0) goto L110;
        r13.c(this.D.f, this.B.f, 0, 8);
        r13.c(this.B.f, this.M.D.f, 0, 4);
        SolverVariable r112 = this.B.f;
        ConstraintAnchor r113 = this.M.B;
    L109:
        r13.c(r112, r113.f, 0, 0);
        return;
    L110:
        if (r111 != 1) goto L112;
        r13.c(this.B.f, this.D.f, 0, 8);
        r13.c(this.B.f, this.M.B.f, 0, 4);
        r112 = this.B.f;
        r113 = this.M.D;
        goto L109
    L112:
        if (r111 != 2) goto L114;
        r13.c(this.E.f, this.C.f, 0, 8);
        r13.c(this.C.f, this.M.E.f, 0, 4);
        r112 = this.C.f;
        r113 = this.M.C;
        goto L109
    L114:
        if (r111 != 3) goto L132;
        r13.c(this.C.f, this.E.f, 0, 8);
        r13.c(this.C.f, this.M.C.f, 0, 4);
        r112 = this.C.f;
        r113 = this.M.E;
        goto L109
    L132:
        return;
    L73:
        if (r20 != 2) goto L75;
        if (r11 == true) goto L79;
    L75:
        if (r20 != 1) goto L77;
        if (r10 == true) goto L79;
    L77:
        if (r20 != 3) goto L80;
        if (r11 == true) goto L79;
    L80:
        r21 = false;
        goto L81
    L65:
        if (this.E.c() == true) goto L68;
        r11 = false;
        goto L69
    L58:
        if (this.D.c() == true) goto L61;
        r10 = false;
    L37:
        if (r6.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L43;
        if (r6.B.c == null) goto L43;
        if (r6.D.c == null) goto L43;
    L31:
        if (r6.a() == true) goto L33;
    L54:
        r9 = false;
        goto L56
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.h, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(ConstraintWidget r2, HashMap<ConstraintWidget, ConstraintWidget> r3) {
        super.a(r2, r3);
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin");
        this.aB = r4.aB;
        this.aC = r4.aC;
        this.aD = r4.aD;
    }

    public void a(boolean r1) {
        this.aC = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean a() {
        return true;
    }

    public int b() {
        return this.aB;
    }

    public void b(int r1) {
        this.aD = r1;
    }

    public boolean c() {
        return this.aC;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean d() {
        return this.f13611a;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean e() {
        return this.f13611a;
    }

    public void f() {
        int r1 = 0;
    L4:
        if (r1 >= this.aA) goto L21;
        ConstraintWidget r2 = this.az[r1];
        if (this.aC == false) goto L8;
    L10:
        int r3 = this.aB;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L17;
    L18:
        r2.a(1, true);
    L20:
        r1 = r1 + 1;
        goto L4
    L17:
        if (r3 != 3) goto L20;
    L19:
        r2.a(0, true);
        goto L20
    L8:
        if (r2.a() == true) goto L10;
    }

    public int g() {
        return this.aD;
    }

    public int h() {
        int r2 = this.aB;
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if (r2 != 1) goto L7;
        return 0;
    L7:
        if (r2 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r2 == 3) goto L12;
        return -1;
    }

    public boolean i() {
        int r0 = 0;
        int r2 = 0;
        boolean r3 = true;
    L4:
        if (r2 >= this.aA) goto L23;
        ConstraintWidget r4 = this.az[r2];
        if (this.aC == false) goto L8;
    L10:
        int r7 = this.aB;
        if (r7 == 0) goto L14;
        if (r7 == 1) goto L14;
    L16:
        int r8 = this.aB;
        if (r8 == 2) goto L20;
        if (r8 == 3) goto L20;
    L22:
        r2 = r2 + 1;
    L20:
        if (r4.e() == true) goto L22;
    L15:
        r3 = false;
    L14:
        if (r4.d() == true) goto L16;
    L8:
        if (r4.a() == true) goto L10;
    L23:
        if (r3 == true) goto L25;
    L66:
        return false;
    L25:
        if (this.aA <= 0) goto L66;
        int r5 = 0;
        boolean r6 = false;
    L28:
        if (r0 >= this.aA) goto L58;
        ConstraintWidget r9 = this.az[r0];
        if (this.aC == false) goto L32;
    L34:
        if (r6 == true) goto L46;
        int r10 = this.aB;
        if (r10 != 0) goto L39;
        ConstraintAnchor.Type r11 = ConstraintAnchor.Type.LEFT;
    L38:
        r5 = r9.a(r11).d();
    L45:
        r6 = true;
        goto L46
    L39:
        if (r10 != 1) goto L41;
        r11 = ConstraintAnchor.Type.RIGHT;
        goto L38
    L41:
        if (r10 != 2) goto L43;
        r11 = ConstraintAnchor.Type.TOP;
        goto L38
    L43:
        if (r10 != 3) goto L45;
        r11 = ConstraintAnchor.Type.BOTTOM;
    L46:
        int r12 = this.aB;
        if (r12 != 0) goto L50;
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.LEFT;
    L49:
        r5 = Math.min(r5, r9.a(r13).d());
    L57:
        r0 = r0 + 1;
        goto L28
    L50:
        if (r12 != 1) goto L53;
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
    L52:
        r5 = Math.max(r5, r9.a(r14).d());
        goto L57
    L53:
        if (r12 != 2) goto L55;
        r13 = ConstraintAnchor.Type.TOP;
        goto L49
    L55:
        if (r12 != 3) goto L57;
        r14 = ConstraintAnchor.Type.BOTTOM;
        goto L52
    L32:
        if (r9.a() == true) goto L34;
    L58:
        int r15 = r5 + this.aD;
        int r1 = this.aB;
        if (r1 == 0) goto L63;
        if (r1 == 1) goto L63;
        b(r15, r15);
    L64:
        this.f13611a = true;
        return true;
    L63:
        a(r15, r15);
        goto L64
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String r0 = "[Barrier] " + C() + " {";
        int r1 = 0;
    L4:
        if (r1 >= this.aA) goto L10;
        ConstraintWidget r2 = this.az[r1];
        if (r1 <= 0) goto L8;
        r0 = r0 + ", ";
    L8:
        r0 = r0 + r2.C();
        r1 = r1 + 1;
        goto L4
    L10:
        return r0 + "}";
    }
}

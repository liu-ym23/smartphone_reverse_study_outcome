package com.obric.oui.constraintlayout.core.widgets;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes5.dex */
public class k extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.obric.oui.constraintlayout.core.widgets.analyzer.b.a f13644a;
    com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b aB;
    private int aC;
    private int aD;
    private int aE;
    private int aF;
    private int aG;
    private int aH;
    private int aI;
    private int aJ;
    private boolean aK;
    private int aL;
    private int aM;

    public k() {
        this.aC = 0;
        this.aD = 0;
        this.aE = 0;
        this.aF = 0;
        this.aG = 0;
        this.aH = 0;
        this.aI = 0;
        this.aJ = 0;
        this.aK = false;
        this.aL = 0;
        this.aM = 0;
        this.f13644a = new com.obric.oui.constraintlayout.core.widgets.analyzer.b.a();
        this.aB = null;
    }

    public void M(int r1) {
        this.aE = r1;
        this.aC = r1;
        this.aF = r1;
        this.aD = r1;
        this.aG = r1;
        this.aH = r1;
    }

    public void N(int r1) {
        this.aG = r1;
        this.aI = r1;
        this.aJ = r1;
    }

    public void O(int r1) {
        this.aH = r1;
    }

    public void P(int r1) {
        this.aE = r1;
        this.aI = r1;
    }

    public void Q(int r1) {
        this.aC = r1;
    }

    public void R(int r1) {
        this.aF = r1;
        this.aJ = r1;
    }

    public void S(int r1) {
        this.aD = r1;
    }

    public void a(ConstraintWidget r4, ConstraintWidget.DimensionBehaviour r5, int r6, ConstraintWidget.DimensionBehaviour r7, int r8) {
    L3:
        if (this.aB != null) goto L7;
        if (A() == null) goto L7;
        this.aB = ((d) ZeusTransformUtils.preCheckCast(A(), d.class, "com.obric.memorydata.plugin")).g();
    L7:
        this.f13644a.d = r5;
        this.f13644a.e = r7;
        this.f13644a.f = r6;
        this.f13644a.g = r8;
        this.aB.a(r4, this.f13644a);
        r4.q(this.f13644a.h);
        r4.r(this.f13644a.i);
        r4.c(this.f13644a.k);
        r4.u(this.f13644a.j);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.h, com.obric.oui.constraintlayout.core.widgets.g
    public void a(d r1) {
        i();
    }

    public void a(boolean r3) {
        int r0 = this.aG;
        if (r0 <= 0) goto L5;
    L6:
        if (r3 == false) goto L8;
        this.aI = this.aH;
        this.aJ = r0;
        return;
    L8:
        this.aI = r0;
        this.aJ = this.aH;
        return;
    L5:
        if (this.aH > 0) goto L6;
    }

    public boolean a(HashSet<ConstraintWidget> r4) {
        int r1 = 0;
    L4:
        if (r1 >= this.aA) goto L10;
        if (r4.contains(this.az[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public int af() {
        return this.aL;
    }

    public int ag() {
        return this.aM;
    }

    public boolean ah() {
        if (this.M == null) goto L5;
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b r0 = ((d) ZeusTransformUtils.preCheckCast(this.M, d.class, "com.obric.memorydata.plugin")).g();
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        int r2 = 0;
    L10:
        boolean r4 = true;
        if (r2 >= this.aA) goto L38;
        ConstraintWidget r3 = this.az[r2];
        if (r3 == null) goto L37;
        if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L37;
        ConstraintWidget.DimensionBehaviour r5 = r3.x(0);
        ConstraintWidget.DimensionBehaviour r6 = r3.x(1);
        if (r5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L21;
    L27:
        r4 = false;
    L28:
        if (r4 == true) goto L37;
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L34;
        r5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L34:
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L36:
        this.f13644a.d = r5;
        this.f13644a.e = r6;
        this.f13644a.f = r3.F();
        this.f13644a.g = r3.G();
        r0.a(r3, this.f13644a);
        r3.q(this.f13644a.h);
        r3.r(this.f13644a.i);
        r3.u(this.f13644a.j);
        goto L37
    L21:
        if (r3.n == 1) goto L27;
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L27;
        if (r3.o == 1) goto L27;
    L37:
        r2 = r2 + 1;
        goto L10
    L38:
        return true;
    L5:
        r0 = null;
        goto L7
    }

    public int b() {
        return this.aC;
    }

    public void b(int r1, int r2, int r3, int r4) {
    }

    public int c() {
        return this.aD;
    }

    public int f() {
        return this.aI;
    }

    public int g() {
        return this.aJ;
    }

    public void g(boolean r1) {
        this.aK = r1;
    }

    public void h(int r1, int r2) {
        this.aL = r1;
        this.aM = r2;
    }

    public boolean h() {
        return this.aK;
    }

    public void i() {
        int r0 = 0;
    L4:
        if (r0 >= this.aA) goto L9;
        ConstraintWidget r1 = this.az[r0];
        if (r1 == null) goto L8;
        r1.b(true);
    L8:
        r0 = r0 + 1;
        goto L4
    }
}

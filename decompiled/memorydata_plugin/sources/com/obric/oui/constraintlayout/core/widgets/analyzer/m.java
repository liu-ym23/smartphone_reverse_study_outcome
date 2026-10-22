package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class m extends WidgetRun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DependencyNode f13629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    f f13630b;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.analyzer.m$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13631a = null;

        static {
            int[] r0 = new int[WidgetRun.RunType.values().length];
            f13631a = r0;
            r0[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f13631a[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f13631a[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public m(ConstraintWidget r2) {
        super(r2);
        this.f13629a = new DependencyNode(this);
        this.f13630b = null;
        DependencyNode r3 = this.j;
        r3.e = DependencyNode.Type.TOP;
        DependencyNode r4 = this.k;
        r4.e = DependencyNode.Type.BOTTOM;
        DependencyNode r5 = this.f13629a;
        r5.e = DependencyNode.Type.BASELINE;
        this.h = 1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean a() {
        if (this.f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.d.o != 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void c() {
        this.e = null;
        this.j.a();
        this.k.a();
        this.f13629a.a();
        this.g.a();
        this.i = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        this.i = false;
        this.j.a();
        this.j.j = false;
        this.k.a();
        this.k.j = false;
        this.f13629a.a();
        this.f13629a.j = false;
        this.g.j = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (this.j.j == false) goto L6;
        this.d.p(this.j.g);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        if (this.d.f13608b == false) goto L6;
        this.g.a(this.d.G());
    L6:
        if (this.g.j == true) goto L24;
        this.f = this.d.ab();
        if (this.d.R() == false) goto L11;
        this.f13630b = new a(this);
    L11:
        if (this.f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r0 = this.d.A();
        if (r0 == null) goto L21;
        if (r0.ab() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r1 = (r0.G() - this.d.C.i()) - this.d.E.i();
        a(this.j, r0.g.j, this.d.C.i());
        a(this.k, r0.g.k, -this.d.E.i());
        this.g.a(r1);
        return;
    L21:
        if (this.f != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.g.a(this.d.G());
    L32:
        if (this.g.j == false) goto L83;
        if (this.d.f13608b == false) goto L83;
        if (this.d.f13606J[2].c == null) goto L54;
        if (this.d.f13606J[3].c == null) goto L54;
        if (this.d.ad() == false) goto L42;
        DependencyNode r2 = this.j;
        r2.f = this.d.f13606J[2].i();
        DependencyNode r3 = this.k;
        r3.f = -this.d.f13606J[3].i();
    L50:
        if (this.d.R() == false) goto L163;
    L51:
        DependencyNode r4 = this.f13629a;
        DependencyNode r5 = this.j;
        int r6 = this.d.S();
    L52:
        a(r4, r5, r6);
        return;
    L163:
        return;
    L42:
        DependencyNode r7 = a(this.d.f13606J[2]);
        if (r7 == null) goto L45;
        a(this.j, r7, this.d.f13606J[2].i());
    L45:
        DependencyNode r8 = a(this.d.f13606J[3]);
        if (r8 == null) goto L48;
        a(this.k, r8, -this.d.f13606J[3].i());
    L48:
        this.j.f13613b = true;
        this.k.f13613b = true;
    L54:
        if (this.d.f13606J[2].c == null) goto L61;
        DependencyNode r9 = a(this.d.f13606J[2]);
        if (r9 == null) goto L165;
        a(this.j, r9, this.d.f13606J[2].i());
        a(this.k, this.j, this.g.g);
        if (this.d.R() == true) goto L51;
        return;
    L165:
        return;
    L61:
        if (this.d.f13606J[3].c == null) goto L69;
        DependencyNode r10 = a(this.d.f13606J[3]);
        if (r10 == null) goto L66;
        a(this.k, r10, -this.d.f13606J[3].i());
        a(this.j, this.k, -this.g.g);
    L66:
        if (this.d.R() == true) goto L51;
        return;
    L69:
        if (this.d.f13606J[4].c == null) goto L74;
        DependencyNode r11 = a(this.d.f13606J[4]);
        if (r11 == null) goto L168;
        a(this.f13629a, r11, 0);
        a(this.j, this.f13629a, -this.d.S());
        r4 = this.k;
        r5 = this.j;
        r6 = this.g.g;
        goto L52
    L168:
        return;
    L74:
        if (ZeusTransformUtils.instanceOf(this.d, com.obric.oui.constraintlayout.core.widgets.g.class) == false) goto L76;
        return;
    L76:
        if (this.d.A() != null) goto L78;
        return;
    L78:
        if (this.d.a(ConstraintAnchor.Type.CENTER).c != null) goto L171;
        DependencyNode r12 = this.d.A().g.j;
        a(this.j, r12, this.d.E());
        a(this.k, this.j, this.g.g);
        if (this.d.R() == true) goto L51;
        return;
    L171:
        return;
    L83:
        if (this.g.j == false) goto L85;
    L101:
        this.g.a(this);
    L103:
        if (this.d.f13606J[2].c == null) goto L120;
        if (this.d.f13606J[3].c == null) goto L120;
        if (this.d.ad() == false) goto L109;
        DependencyNode r13 = this.j;
        r13.f = this.d.f13606J[2].i();
        DependencyNode r14 = this.k;
        r14.f = -this.d.f13606J[3].i();
    L116:
        if (this.d.R() == false) goto L160;
    L117:
        DependencyNode r15 = this.f13629a;
        DependencyNode r16 = this.j;
        f r17 = this.f13630b;
    L118:
        a(r15, r16, 1, r17);
    L160:
        if (this.g.l.size() != 0) goto L173;
        this.g.c = true;
        return;
    L173:
        return;
    L109:
        DependencyNode r18 = a(this.d.f13606J[2]);
        DependencyNode r19 = a(this.d.f13606J[3]);
        if (r18 == null) goto L112;
        r18.a(this);
    L112:
        if (r19 == null) goto L114;
        r19.a(this);
    L114:
        this.l = WidgetRun.RunType.CENTER;
    L120:
        if (this.d.f13606J[2].c == null) goto L134;
        DependencyNode r20 = a(this.d.f13606J[2]);
        if (r20 == null) goto L160;
        a(this.j, r20, this.d.f13606J[2].i());
        a(this.k, this.j, 1, this.g);
        if (this.d.R() == false) goto L127;
        a(this.f13629a, this.j, 1, this.f13630b);
    L127:
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
        if (this.d.U() <= 0.0f) goto L160;
        if (this.d.f.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
    L158:
        this.d.f.g.k.add(this.g);
        this.g.l.add(this.d.f.g);
        this.g.f13612a = this;
        goto L160
    L134:
        if (this.d.f13606J[3].c == null) goto L141;
        DependencyNode r21 = a(this.d.f13606J[3]);
        if (r21 == null) goto L160;
        a(this.k, r21, -this.d.f13606J[3].i());
        a(this.j, this.k, -1, this.g);
        if (this.d.R() == false) goto L160;
    L141:
        if (this.d.f13606J[4].c == null) goto L146;
        DependencyNode r22 = a(this.d.f13606J[4]);
        if (r22 == null) goto L160;
        a(this.f13629a, r22, 0);
        a(this.j, this.f13629a, -1, this.f13630b);
        r15 = this.k;
        r16 = this.j;
        r17 = this.g;
        goto L118
    L146:
        if (ZeusTransformUtils.instanceOf(this.d, com.obric.oui.constraintlayout.core.widgets.g.class) == true) goto L160;
        if (this.d.A() == null) goto L160;
        DependencyNode r23 = this.d.A().g.j;
        a(this.j, r23, this.d.E());
        a(this.k, this.j, 1, this.g);
        if (this.d.R() == false) goto L153;
        a(this.f13629a, this.j, 1, this.f13630b);
    L153:
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
        if (this.d.U() <= 0.0f) goto L160;
        if (this.d.f.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
    L85:
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L101;
        int r24 = this.d.o;
        if (r24 == 2) goto L96;
        if (r24 != 3) goto L103;
        if (this.d.ad() == true) goto L103;
        if (this.d.n == 3) goto L103;
        f r25 = this.d.f.g;
    L100:
        this.g.l.add(r25);
        r25.k.add(this.g);
        this.g.f13613b = true;
        this.g.k.add(this.j);
        this.g.k.add(this.k);
        goto L103
    L96:
        ConstraintWidget r26 = this.d.A();
        if (r26 == null) goto L103;
        r25 = r26.g.g;
        goto L100
    L24:
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
        ConstraintWidget r27 = this.d.A();
        if (r27 == null) goto L32;
        if (r27.ab() != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        a(this.j, r27.g.j, this.d.C.i());
        a(this.k, r27.g.k, -this.d.E.i());
    }

    public String toString() {
        return "VerticalRun " + this.d.C();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.memorydata.plugin");
        int r0 = AnonymousClass1.f13631a[this.l.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L12;
        a(r9, this.d.C, this.d.E, 1);
        return;
    L12:
        if (this.g.c == false) goto L38;
        if (this.g.j == true) goto L38;
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        int r10 = this.d.o;
        if (r10 == 2) goto L31;
        if (r10 != 3) goto L38;
        if (this.d.f.g.j == false) goto L38;
        int r11 = this.d.V();
        if (r11 == (-1)) goto L29;
        if (r11 == 0) goto L28;
        if (r11 == 1) goto L29;
        int r12 = 0;
    L30:
        this.g.a(r12);
        goto L38
    L28:
        float r13 = this.d.f.g.g * this.d.U();
    L36:
        r12 = (int) (r13 + 0.5f);
    L29:
        r13 = this.d.f.g.g / this.d.U();
        goto L36
    L31:
        ConstraintWidget r14 = this.d.A();
        if (r14 == null) goto L38;
        if (r14.g.g.j == false) goto L38;
        r13 = r14.g.g.g * this.d.v;
    L38:
        if (this.j.c == true) goto L40;
        return;
    L40:
        if (this.k.c == true) goto L43;
        return;
    L43:
        if (this.j.j == false) goto L50;
        if (this.k.j == false) goto L50;
        if (this.g.j == false) goto L50;
        return;
    L50:
        if (this.g.j == true) goto L60;
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L60;
        if (this.d.n != 0) goto L60;
        if (this.d.ad() == true) goto L60;
        DependencyNode r15 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r1 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r16 = r15.g + this.j.f;
        int r2 = r1.g + this.k.f;
        this.j.a(r16);
        this.k.a(r2);
        this.g.a(r2 - r16);
        return;
    L60:
        if (this.g.j == true) goto L75;
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L75;
        if (this.c != 1) goto L75;
        if (this.j.l.size() <= 0) goto L75;
        if (this.k.l.size() <= 0) goto L75;
        DependencyNode r17 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r3 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r4 = (r3.g + this.k.f) - (r17.g + this.j.f);
        if (r4 >= this.g.m) goto L72;
        f r18 = this.g;
    L73:
        r18.a(r4);
        goto L75
    L72:
        r18 = this.g;
        r4 = this.g.m;
    L75:
        if (this.g.j == true) goto L78;
        return;
    L78:
        if (this.j.l.size() > 0) goto L80;
        return;
    L80:
        if (this.k.l.size() <= 0) goto L88;
        DependencyNode r19 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r5 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r6 = r19.g + this.j.f;
        int r7 = r5.g + this.k.f;
        float r20 = this.d.Q();
        if (r19 != r5) goto L84;
        r6 = r19.g;
        r7 = r5.g;
        r20 = 0.5f;
    L84:
        this.j.a((int) ((r6 + 0.5f) + (((r7 - r6) - this.g.g) * r20)));
        this.k.a(this.j.g + this.g.g);
        return;
    L88:
        return;
    L9:
        b(r9);
        goto L12
    L10:
        a(r9);
        goto L12
    }
}

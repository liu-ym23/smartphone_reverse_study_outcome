package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class k extends WidgetRun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int[] f13625a;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.analyzer.k$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13626a = null;

        static {
            int[] r0 = new int[WidgetRun.RunType.values().length];
            f13626a = r0;
            r0[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f13626a[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f13626a[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f13625a = new int[2];
    }

    public k(ConstraintWidget r2) {
        super(r2);
        DependencyNode r3 = this.j;
        r3.e = DependencyNode.Type.LEFT;
        DependencyNode r4 = this.k;
        r4.e = DependencyNode.Type.RIGHT;
        this.h = 0;
    }

    private void a(int[] r2, int r3, int r4, int r5, int r6, float r7, int r8) {
        int r9 = r4 - r3;
        int r10 = r6 - r5;
        if (r8 == (-1)) goto L9;
        if (r8 == 0) goto L8;
        if (r8 != 1) goto L22;
        r2[0] = r9;
        r2[1] = (int) ((r9 * r7) + 0.5f);
        return;
    L22:
        return;
    L8:
        r2[0] = (int) ((r10 * r7) + 0.5f);
        r2[1] = r10;
        return;
    L9:
        int r1 = (int) ((r10 * r7) + 0.5f);
        int r11 = (int) ((r9 / r7) + 0.5f);
        if (r1 > r9) goto L13;
        if (r10 > r10) goto L13;
        r2[0] = r1;
        r2[1] = r10;
        return;
    L13:
        if (r9 > r9) goto L20;
        if (r11 > r10) goto L21;
        r2[0] = r9;
        r2[1] = r11;
        return;
    L21:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean a() {
        if (this.f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.d.n != 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void c() {
        this.e = null;
        this.j.a();
        this.k.a();
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
        this.g.j = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (this.j.j == false) goto L6;
        this.d.o(this.j.g);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        if (this.d.f13608b == false) goto L6;
        this.g.a(this.d.F());
    L6:
        if (this.g.j == true) goto L23;
        this.f = this.d.aa();
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L10;
    L32:
        int r2 = 1;
        if (this.g.j == false) goto L70;
        if (this.d.f13608b == false) goto L70;
        if (this.d.f13606J[0].c == null) goto L51;
        if (this.d.f13606J[1].c == null) goto L51;
        if (this.d.ac() == false) goto L43;
        DependencyNode r0 = this.j;
        r0.f = this.d.f13606J[0].i();
        DependencyNode r1 = this.k;
        ConstraintAnchor r5 = this.d.f13606J[1];
    L99:
        r1.f = -r5.i();
        return;
    L43:
        DependencyNode r3 = a(this.d.f13606J[0]);
        if (r3 == null) goto L46;
        a(this.j, r3, this.d.f13606J[0].i());
    L46:
        DependencyNode r4 = a(this.d.f13606J[1]);
        if (r4 == null) goto L49;
        a(this.k, r4, -this.d.f13606J[1].i());
    L49:
        this.j.f13613b = true;
        this.k.f13613b = true;
        return;
    L51:
        if (this.d.f13606J[0].c == null) goto L56;
        DependencyNode r6 = a(this.d.f13606J[0]);
        if (r6 == null) goto L125;
        a(this.j, r6, this.d.f13606J[0].i());
    L67:
        DependencyNode r7 = this.k;
        DependencyNode r8 = this.j;
        int r9 = this.g.g;
    L68:
        a(r7, r8, r9);
        return;
    L125:
        return;
    L56:
        if (this.d.f13606J[1].c == null) goto L61;
        DependencyNode r10 = a(this.d.f13606J[1]);
        if (r10 == null) goto L126;
        a(this.k, r10, -this.d.f13606J[1].i());
        r7 = this.j;
        r8 = this.k;
        r9 = -this.g.g;
        goto L68
    L126:
        return;
    L61:
        if (ZeusTransformUtils.instanceOf(this.d, com.obric.oui.constraintlayout.core.widgets.g.class) == false) goto L63;
        return;
    L63:
        if (this.d.A() != null) goto L65;
        return;
    L65:
        if (this.d.a(ConstraintAnchor.Type.CENTER).c != null) goto L129;
        DependencyNode r11 = this.d.A().f.j;
        a(this.j, r11, this.d.D());
        goto L67
    L129:
        return;
    L70:
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L93;
        int r12 = this.d.n;
        if (r12 != 2) goto L74;
        ConstraintWidget r13 = this.d.A();
        if (r13 == null) goto L93;
        f r14 = r13.g.g;
        this.g.l.add(r14);
        r14.k.add(this.g);
        this.g.f13613b = true;
        this.g.k.add(this.j);
        List<d> r15 = this.g.k;
        d r16 = this.k;
    L91:
        r15.add(r16);
        goto L93
    L74:
        if (r12 != 3) goto L93;
        if (this.d.o != 3) goto L85;
        this.j.f13612a = this;
        this.k.f13612a = this;
        this.d.g.j.f13612a = this;
        this.d.g.k.f13612a = this;
        this.g.f13612a = this;
        if (this.d.ad() == false) goto L82;
        this.g.l.add(this.d.g.g);
        this.d.g.g.k.add(this.g);
        this.d.g.g.f13612a = this;
        this.g.l.add(this.d.g.j);
        this.g.l.add(this.d.g.k);
        this.d.g.j.k.add(this.g);
        r15 = this.d.g.k.k;
    L86:
        r16 = this.g;
        goto L91
    L82:
        if (this.d.ac() == false) goto L84;
        this.d.g.g.l.add(this.g);
        r15 = this.g.k;
        r16 = this.d.g.g;
        goto L91
    L84:
        r15 = this.d.g.g.l;
        goto L86
    L85:
        f r17 = this.d.g.g;
        this.g.l.add(r17);
        r17.k.add(this.g);
        this.d.g.j.k.add(this.g);
        this.d.g.k.k.add(this.g);
        this.g.f13613b = true;
        this.g.k.add(this.j);
        this.g.k.add(this.k);
        this.j.l.add(this.g);
        r15 = this.k.l;
    L93:
        if (this.d.f13606J[0].c == null) goto L107;
        if (this.d.f13606J[1].c == null) goto L107;
        if (this.d.ac() == false) goto L100;
        DependencyNode r18 = this.j;
        r18.f = this.d.f13606J[0].i();
        r1 = this.k;
        r5 = this.d.f13606J[1];
        goto L99
    L100:
        DependencyNode r19 = a(this.d.f13606J[0]);
        DependencyNode r20 = a(this.d.f13606J[1]);
        if (r19 == null) goto L103;
        r19.a(this);
    L103:
        if (r20 == null) goto L105;
        r20.a(this);
    L105:
        this.l = WidgetRun.RunType.CENTER;
        return;
    L107:
        if (this.d.f13606J[0].c == null) goto L112;
        DependencyNode r21 = a(this.d.f13606J[0]);
        if (r21 == null) goto L133;
        a(this.j, r21, this.d.f13606J[0].i());
    L121:
        DependencyNode r22 = this.k;
        DependencyNode r23 = this.j;
    L122:
        a(r22, r23, r2, this.g);
        return;
    L133:
        return;
    L112:
        if (this.d.f13606J[1].c == null) goto L117;
        DependencyNode r24 = a(this.d.f13606J[1]);
        if (r24 == null) goto L134;
        a(this.k, r24, -this.d.f13606J[1].i());
        r22 = this.j;
        r23 = this.k;
        r2 = -1;
        goto L122
    L134:
        return;
    L117:
        if (ZeusTransformUtils.instanceOf(this.d, com.obric.oui.constraintlayout.core.widgets.g.class) == false) goto L119;
        return;
    L119:
        if (this.d.A() == null) goto L136;
        DependencyNode r25 = this.d.A().f.j;
        a(this.j, r25, this.d.D());
        goto L121
    L136:
        return;
    L10:
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L20;
        ConstraintWidget r26 = this.d.A();
        if (r26 == null) goto L20;
        if (r26.aa() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r27 = (r26.F() - this.d.B.i()) - this.d.D.i();
        a(this.j, r26.f.j, this.d.B.i());
        a(this.k, r26.f.k, -this.d.D.i());
        this.g.a(r27);
        return;
    L16:
        if (r26.aa() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L17;
    L20:
        if (this.f != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.g.a(this.d.F());
        goto L32
    L23:
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
        ConstraintWidget r28 = this.d.A();
        if (r28 == null) goto L32;
        if (r28.aa() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        a(this.j, r28.f.j, this.d.B.i());
        a(this.k, r28.f.k, -this.d.D.i());
        return;
    L29:
        if (r28.aa() != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
        goto L30
    }

    public String toString() {
        return "HorizontalRun " + this.d.C();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r18) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r18, d.class, "com.obric.memorydata.plugin");
        int r1 = AnonymousClass1.f13626a[this.l.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L9;
        if (r1 != 3) goto L12;
        a(r0, this.d.B, this.d.D, 0);
        return;
    L12:
        if (this.g.j == true) goto L136;
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L136;
        int r2 = this.d.n;
        if (r2 == 2) goto L129;
        if (r2 != 3) goto L136;
        if (this.d.o != 0) goto L22;
    L32:
        DependencyNode r13 = this.d.g.j;
        DependencyNode r14 = this.d.g.k;
        if (this.d.B.c == null) goto L35;
        boolean r3 = true;
    L37:
        if (this.d.C.c == null) goto L39;
        boolean r4 = true;
    L41:
        if (this.d.D.c == null) goto L43;
        boolean r5 = true;
    L45:
        if (this.d.E.c == null) goto L47;
        boolean r6 = true;
    L48:
        int r15 = this.d.V();
        if (r3 == false) goto L86;
        if (r4 == false) goto L86;
        if (r5 == false) goto L86;
        if (r6 == false) goto L86;
        float r16 = this.d.U();
        if (r13.j == false) goto L65;
        if (r14.j == false) goto L65;
        if (this.j.c == true) goto L60;
        return;
    L60:
        if (this.k.c == false) goto L180;
        a(f13625a, ((DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g + this.j.f, ((DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g - this.k.f, r13.g + r13.f, r14.g - r14.f, r16, r15);
        this.g.a(f13625a[0]);
        this.d.g.g.a(f13625a[1]);
        return;
    L180:
        return;
    L65:
        if (this.j.j == false) goto L76;
        if (this.k.j == false) goto L76;
        if (r13.c == true) goto L71;
        return;
    L71:
        if (r14.c == false) goto L181;
        a(f13625a, this.j.g + this.j.f, this.k.g - this.k.f, ((DependencyNode) ZeusTransformUtils.preCheckCast(r13.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g + r13.f, ((DependencyNode) ZeusTransformUtils.preCheckCast(r14.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g - r14.f, r16, r15);
        this.g.a(f13625a[0]);
        this.d.g.g.a(f13625a[1]);
        goto L76
    L181:
        return;
    L76:
        if (this.j.c == true) goto L78;
        return;
    L78:
        if (this.k.c == true) goto L80;
        return;
    L80:
        if (r13.c == true) goto L82;
        return;
    L82:
        if (r14.c == false) goto L184;
        a(f13625a, ((DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g + this.j.f, ((DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g - this.k.f, ((DependencyNode) ZeusTransformUtils.preCheckCast(r13.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g + r13.f, ((DependencyNode) ZeusTransformUtils.preCheckCast(r14.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g - r14.f, r16, r15);
        this.g.a(f13625a[0]);
        f r7 = this.d.g.g;
        int r8 = f13625a[1];
    L127:
        r7.a(r8);
        goto L136
    L184:
        return;
    L86:
        if (r3 == false) goto L107;
        if (r5 == false) goto L107;
        if (this.j.c == true) goto L91;
        return;
    L91:
        if (this.k.c == false) goto L185;
        float r9 = this.d.U();
        int r10 = ((DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g + this.j.f;
        int r11 = ((DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g - this.k.f;
        if (r15 == (-1)) goto L101;
        if (r15 == 0) goto L101;
        if (r15 != 1) goto L136;
        int r12 = a(r11 - r10, 0);
        int r17 = (int) ((r12 / r9) + 0.5f);
        int r19 = a(r17, 1);
        if (r17 == r19) goto L105;
        float r20 = r19 * r9;
    L104:
        r12 = (int) (r20 + 0.5f);
    L105:
        this.g.a(r12);
        this.d.g.g.a(r19);
    L101:
        r12 = a(r11 - r10, 0);
        int r21 = (int) ((r12 * r9) + 0.5f);
        r19 = a(r21, 1);
        if (r21 == r19) goto L105;
        r20 = r19 / r9;
        goto L104
    L185:
        return;
    L107:
        if (r4 == false) goto L136;
        if (r6 == false) goto L136;
        if (r13.c == true) goto L112;
        return;
    L112:
        if (r14.c == false) goto L186;
        float r22 = this.d.U();
        int r23 = ((DependencyNode) ZeusTransformUtils.preCheckCast(r13.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g + r13.f;
        int r24 = ((DependencyNode) ZeusTransformUtils.preCheckCast(r14.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g - r14.f;
        if (r15 == (-1)) goto L122;
        if (r15 == 0) goto L119;
        if (r15 == 1) goto L122;
    L119:
        r8 = a(r24 - r23, 1);
        int r25 = (int) ((r8 * r22) + 0.5f);
        int r26 = a(r25, 0);
        if (r25 == r26) goto L126;
        float r27 = r26 / r22;
    L125:
        r8 = (int) (r27 + 0.5f);
    L126:
        this.g.a(r26);
        r7 = this.d.g.g;
    L122:
        r8 = a(r24 - r23, 1);
        int r28 = (int) ((r8 / r22) + 0.5f);
        r26 = a(r28, 0);
        if (r28 == r26) goto L126;
        r27 = r26 * r22;
        goto L125
    L186:
        return;
    L47:
        r6 = false;
        goto L48
    L43:
        r5 = false;
        goto L45
    L39:
        r4 = false;
        goto L41
    L35:
        r3 = false;
        goto L37
    L22:
        if (this.d.o == 3) goto L32;
        int r29 = this.d.V();
        if (r29 == (-1)) goto L30;
        if (r29 == 0) goto L29;
        if (r29 == 1) goto L30;
        int r30 = 0;
    L31:
        this.g.a(r30);
        goto L136
    L29:
        float r31 = this.d.g.g.g / this.d.U();
    L134:
        r30 = (int) (r31 + 0.5f);
    L30:
        r31 = this.d.g.g.g * this.d.U();
        goto L134
    L129:
        ConstraintWidget r32 = this.d.A();
        if (r32 == null) goto L136;
        if (r32.f.g.j == false) goto L136;
        r31 = r32.f.g.g * this.d.s;
    L136:
        if (this.j.c == true) goto L138;
        return;
    L138:
        if (this.k.c == true) goto L141;
        return;
    L141:
        if (this.j.j == false) goto L148;
        if (this.k.j == false) goto L148;
        if (this.g.j == false) goto L148;
        return;
    L148:
        if (this.g.j == true) goto L158;
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L158;
        if (this.d.n != 0) goto L158;
        if (this.d.ac() == true) goto L158;
        DependencyNode r33 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r34 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r35 = r33.g + this.j.f;
        int r36 = r34.g + this.k.f;
        this.j.a(r35);
        this.k.a(r36);
        this.g.a(r36 - r35);
        return;
    L158:
        if (this.g.j == true) goto L172;
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L172;
        if (this.c != 1) goto L172;
        if (this.j.l.size() <= 0) goto L172;
        if (this.k.l.size() <= 0) goto L172;
        DependencyNode r37 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r38 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r39 = Math.min((r38.g + this.k.f) - (r37.g + this.j.f), this.g.m);
        int r40 = this.d.r;
        int r41 = Math.max(this.d.q, r39);
        if (r40 <= 0) goto L170;
        r41 = Math.min(r40, r41);
    L170:
        this.g.a(r41);
    L172:
        if (this.g.j == true) goto L174;
        return;
    L174:
        DependencyNode r42 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r43 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.k.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r44 = r42.g + this.j.f;
        int r45 = r43.g + this.k.f;
        float r46 = this.d.P();
        if (r42 != r43) goto L177;
        r44 = r42.g;
        r45 = r43.g;
        r46 = 0.5f;
    L177:
        this.j.a((int) ((r44 + 0.5f) + (((r45 - r44) - this.g.g) * r46)));
        this.k.a(this.j.g + this.g.g);
        return;
    L9:
        b(r0);
        goto L12
    L10:
        a(r0);
        goto L12
    }
}

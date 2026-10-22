package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<l> f13621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.constraintlayout.core.widgets.d f13622b;
    private boolean c;
    private boolean d;
    private com.obric.oui.constraintlayout.core.widgets.d e;
    private ArrayList<WidgetRun> f;
    private ArrayList<l> g;
    private b.InterfaceC0736b h;
    private b.a i;

    public e(com.obric.oui.constraintlayout.core.widgets.d r2) {
        this.c = true;
        this.d = true;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = null;
        this.i = new b.a();
        this.f13621a = new ArrayList();
        this.f13622b = r2;
        this.e = r2;
    }

    private int a(com.obric.oui.constraintlayout.core.widgets.d r8, int r9) {
        int r0 = this.f13621a.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = Math.max(r1, ((l) ZeusTransformUtils.preCheckCast(this.f13621a.get(r3), l.class, "com.obric.memorydata.plugin")).a(r8, r9));
        r3 = r3 + 1;
        goto L3
    L6:
        return (int) r1;
    }

    private void a(ConstraintWidget r2, ConstraintWidget.DimensionBehaviour r3, int r4, ConstraintWidget.DimensionBehaviour r5, int r6) {
        this.i.d = r3;
        this.i.e = r5;
        this.i.f = r4;
        this.i.g = r6;
        this.h.a(r2, this.i);
        r2.q(this.i.h);
        r2.r(this.i.i);
        r2.c(this.i.k);
        r2.u(this.i.j);
    }

    private void a(DependencyNode r10, int r11, int r12, DependencyNode r13, ArrayList<l> r14, l r15) {
        WidgetRun r16 = r10.d;
        if (r16.e == null) goto L5;
        return;
    L5:
        if (r16 != this.f13622b.f) goto L7;
        return;
    L7:
        if (r16 == this.f13622b.g) goto L80;
        if (r15 != null) goto L11;
        r15 = new l(r16, r12);
        r14.add(r15);
    L11:
        r16.e = r15;
        r15.a(r16);
        Iterator<d> r17 = r16.j.k.iterator();
    L13:
        if (r17.hasNext() == false) goto L17;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r17.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, DependencyNode.class) == false) goto L13;
        a((DependencyNode) ZeusTransformUtils.preCheckCast(r0, DependencyNode.class, "com.obric.memorydata.plugin"), r11, 0, r13, r14, r15);
        goto L13
    L17:
        Iterator<d> r18 = r16.k.k.iterator();
    L19:
        if (r18.hasNext() == false) goto L24;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r18.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, DependencyNode.class) == false) goto L19;
        a((DependencyNode) ZeusTransformUtils.preCheckCast(r1, DependencyNode.class, "com.obric.memorydata.plugin"), r11, 1, r13, r14, r15);
        goto L19
    L24:
        if (r11 == 1) goto L26;
    L33:
        Iterator<DependencyNode> r8 = r16.j.l.iterator();
    L35:
        if (r8.hasNext() == false) goto L40;
        DependencyNode r2 = (DependencyNode) ZeusTransformUtils.preCheckCast(r8.next(), DependencyNode.class, "com.obric.memorydata.plugin");
        if (r2 != r13) goto L39;
        r15.c = true;
    L39:
        a(r2, r11, 0, r13, r14, r15);
        goto L35
    L40:
        Iterator<DependencyNode> r9 = r16.k.l.iterator();
    L42:
        if (r9.hasNext() == false) goto L47;
        DependencyNode r3 = (DependencyNode) ZeusTransformUtils.preCheckCast(r9.next(), DependencyNode.class, "com.obric.memorydata.plugin");
        if (r3 != r13) goto L46;
        r15.c = true;
    L46:
        a(r3, r11, 1, r13, r14, r15);
        goto L42
    L47:
        if (r11 == 1) goto L49;
        return;
    L49:
        if (ZeusTransformUtils.instanceOf(r16, m.class) == false) goto L79;
        Iterator<DependencyNode> r19 = ((m) ZeusTransformUtils.preCheckCast(r16, m.class, "com.obric.memorydata.plugin")).f13629a.l.iterator();
    L52:
        if (r19.hasNext() == false) goto L81;
        a((DependencyNode) ZeusTransformUtils.preCheckCast(r19.next(), DependencyNode.class, "com.obric.memorydata.plugin"), r11, 2, r13, r14, r15);
        goto L52
    L81:
        return;
    L79:
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r16, m.class) == false) goto L33;
        Iterator<d> r20 = ((m) ZeusTransformUtils.preCheckCast(r16, m.class, "com.obric.memorydata.plugin")).f13629a.k.iterator();
    L29:
        if (r20.hasNext() == false) goto L33;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r20.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, DependencyNode.class) == false) goto L29;
        a((DependencyNode) ZeusTransformUtils.preCheckCast(r4, DependencyNode.class, "com.obric.memorydata.plugin"), r11, 2, r13, r14, r15);
        goto L29
    }

    private void a(WidgetRun r11, int r12, ArrayList<l> r13) {
        Iterator<d> r0 = r11.j.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, DependencyNode.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r1, WidgetRun.class) == false) goto L4;
        DependencyNode r3 = ((WidgetRun) ZeusTransformUtils.preCheckCast(r1, WidgetRun.class, "com.obric.memorydata.plugin")).j;
    L8:
        a(r3, r12, 0, r11.k, r13, null);
        goto L4
    L7:
        r3 = (DependencyNode) ZeusTransformUtils.preCheckCast(r1, DependencyNode.class, "com.obric.memorydata.plugin");
        goto L8
    L12:
        Iterator<d> r2 = r11.k.k.iterator();
    L14:
        if (r2.hasNext() == false) goto L23;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, DependencyNode.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r4, WidgetRun.class) == false) goto L14;
        DependencyNode r5 = ((WidgetRun) ZeusTransformUtils.preCheckCast(r4, WidgetRun.class, "com.obric.memorydata.plugin")).k;
    L18:
        a(r5, r12, 1, r11.j, r13, null);
        goto L14
    L17:
        r5 = (DependencyNode) ZeusTransformUtils.preCheckCast(r4, DependencyNode.class, "com.obric.memorydata.plugin");
        goto L18
    L23:
        if (r12 != 1) goto L30;
        Iterator<d> r14 = ((m) ZeusTransformUtils.preCheckCast(r11, m.class, "com.obric.memorydata.plugin")).f13629a.k.iterator();
    L26:
        if (r14.hasNext() == false) goto L48;
        d r6 = (d) ZeusTransformUtils.preCheckCast(r14.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, DependencyNode.class) == false) goto L26;
        a((DependencyNode) ZeusTransformUtils.preCheckCast(r6, DependencyNode.class, "com.obric.memorydata.plugin"), r12, 2, null, r13, null);
        goto L26
    L48:
        return;
    }

    private boolean a(com.obric.oui.constraintlayout.core.widgets.d r13) {
        Iterator<ConstraintWidget> r0 = r13.aV.iterator();
    L4:
        if (r0.hasNext() == false) goto L168;
        ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        ConstraintWidget.DimensionBehaviour r3 = r1.L[0];
        ConstraintWidget.DimensionBehaviour r4 = r1.L[1];
        if (r1.B() == 8) goto L7;
        if (r1.s >= 1.0f) goto L14;
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        r1.n = 2;
    L14:
        if (r1.v >= 1.0f) goto L19;
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        r1.o = 2;
    L19:
        if (r1.U() <= 0.0f) goto L45;
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L28;
        if (r4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
    L26:
        r1.n = 3;
        goto L45
    L25:
        if (r4 == ConstraintWidget.DimensionBehaviour.FIXED) goto L26;
    L28:
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L35;
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
    L33:
        r1.o = 3;
        goto L45
    L32:
        if (r3 == ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
    L35:
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L45;
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L45;
        if (r1.n != 0) goto L42;
        r1.n = 3;
    L42:
        if (r1.o == 0) goto L33;
    L45:
        if (r3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L47;
    L53:
        ConstraintWidget.DimensionBehaviour r5 = r3;
        if (r4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L56;
    L62:
        ConstraintWidget.DimensionBehaviour r8 = r4;
    L63:
        r1.f.f = r5;
        r1.f.c = r1.n;
        r1.g.f = r8;
        r1.g.c = r1.o;
        if (r5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L70;
        if (r5 == ConstraintWidget.DimensionBehaviour.FIXED) goto L70;
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L70;
    L77:
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L108;
        if (r8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L83;
        if (r8 != ConstraintWidget.DimensionBehaviour.FIXED) goto L108;
    L83:
        if (r1.n == 3) goto L85;
        if (r1.n == 1) goto L92;
        if (r1.n != 2) goto L102;
        if (r13.L[0] == ConstraintWidget.DimensionBehaviour.FIXED) goto L100;
        if (r13.L[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L108;
    L100:
        int r6 = (int) ((r1.s * r13.F()) + 0.5f);
        int r2 = r1.G();
        r5 = ConstraintWidget.DimensionBehaviour.FIXED;
    L106:
        ConstraintWidget.DimensionBehaviour r7 = r8;
        int r9 = r2;
    L167:
        a(r1, r5, r6, r7, r9);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        goto L7
    L102:
        if (r1.f13606J[0].c == null) goto L105;
        if (r1.f13606J[1].c != null) goto L108;
    L105:
        r5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r6 = 0;
        r2 = 0;
        goto L106
    L92:
        a(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, r8, 0);
        f r10 = r1.f.g;
        int r11 = r1.F();
    L93:
        r10.m = r11;
        goto L4
    L85:
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L87;
        a(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
    L87:
        r9 = r1.G();
        r6 = (int) ((r9 * r1.P) + 0.5f);
    L88:
        r5 = ConstraintWidget.DimensionBehaviour.FIXED;
    L89:
        r7 = ConstraintWidget.DimensionBehaviour.FIXED;
    L108:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L140;
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L114;
        if (r5 != ConstraintWidget.DimensionBehaviour.FIXED) goto L140;
    L114:
        if (r1.o == 3) goto L116;
        if (r1.o == 1) goto L125;
        if (r1.o != 2) goto L135;
        if (r13.L[1] == ConstraintWidget.DimensionBehaviour.FIXED) goto L133;
        if (r13.L[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L140;
    L133:
        float r12 = r1.v;
        r6 = r1.F();
        r9 = (int) ((r12 * r13.G()) + 0.5f);
        goto L89
    L135:
        if (r1.f13606J[2].c == null) goto L105;
        if (r1.f13606J[3].c != null) goto L140;
    L125:
        a(r1, r5, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
    L126:
        r10 = r1.g.g;
        r11 = r1.G();
        goto L93
    L116:
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L118;
        a(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
    L118:
        r6 = r1.F();
        float r14 = r1.P;
        if (r1.V() != (-1)) goto L121;
        r14 = 1.0f / r14;
    L121:
        float r15 = r6;
    L122:
        r9 = (int) ((r15 * r14) + 0.5f);
    L140:
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L4;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L4;
        if (r1.n == 1) goto L157;
        if (r1.o == 1) goto L157;
        if (r1.o != 2) goto L4;
        if (r1.n != 2) goto L4;
        if (r13.L[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L4;
        if (r13.L[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L4;
        float r16 = r1.s;
        r15 = r1.v;
        r6 = (int) ((r16 * r13.F()) + 0.5f);
        r14 = r13.G();
    L157:
        a(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
        r1.f.g.m = r1.F();
    L70:
        if (r8 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L158;
        if (r8 == ConstraintWidget.DimensionBehaviour.FIXED) goto L158;
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L77;
    L158:
        int r17 = r1.F();
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L161;
        r6 = (r13.F() - r1.B.d) - r1.D.d;
        r5 = ConstraintWidget.DimensionBehaviour.FIXED;
    L162:
        int r18 = r1.G();
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L165;
        r9 = (r13.G() - r1.C.d) - r1.E.d;
        r7 = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L167
    L165:
        r7 = r8;
        r9 = r18;
        goto L167
    L161:
        r6 = r17;
        goto L162
    L56:
        if (r1.o != 1) goto L62;
        if (r1.C.c != null) goto L60;
    L61:
        r8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L63
    L60:
        if (r1.E.c != null) goto L62;
    L47:
        if (r1.n != 1) goto L53;
        if (r1.B.c != null) goto L51;
    L52:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L53
    L51:
        if (r1.D.c != null) goto L53;
    L7:
        r1.f13608b = true;
        goto L4
    L168:
        return false;
    }

    public void a() {
        Iterator<ConstraintWidget> r0 = this.f13622b.aV.iterator();
    L4:
        if (r0.hasNext() == false) goto L46;
        ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r1.f13608b == true) goto L4;
        boolean r3 = false;
        ConstraintWidget.DimensionBehaviour r8 = r1.L[0];
        ConstraintWidget.DimensionBehaviour r10 = r1.L[1];
        int r2 = r1.n;
        int r4 = r1.o;
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L11;
    L15:
        boolean r5 = true;
    L17:
        if (r10 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L19;
    L21:
        r3 = true;
    L22:
        boolean r6 = r1.f.g.j;
        boolean r7 = r1.g.g.j;
        if (r6 == false) goto L27;
        if (r7 == false) goto L27;
        a(r1, ConstraintWidget.DimensionBehaviour.FIXED, r1.f.g.g, ConstraintWidget.DimensionBehaviour.FIXED, r1.g.g.g);
    L26:
        r1.f13608b = true;
    L42:
        if (r1.f13608b == false) goto L4;
        if (r1.g.f13630b == null) goto L4;
        r1.g.f13630b.a(r1.S());
    L27:
        if (r6 == false) goto L35;
        if (r3 == false) goto L35;
        a(r1, ConstraintWidget.DimensionBehaviour.FIXED, r1.f.g.g, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, r1.g.g.g);
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L33;
        f r9 = r1.g.g;
        int r11 = r1.G();
    L32:
        r9.m = r11;
        goto L42
    L33:
        f r12 = r1.g.g;
        int r13 = r1.G();
    L34:
        r12.a(r13);
    L35:
        if (r7 == false) goto L42;
        if (r5 == false) goto L42;
        a(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, r1.f.g.g, ConstraintWidget.DimensionBehaviour.FIXED, r1.g.g.g);
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L40;
        r9 = r1.f.g;
        r11 = r1.F();
        goto L32
    L40:
        r12 = r1.f.g;
        r13 = r1.F();
        goto L34
    L19:
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L22;
        if (r4 != 1) goto L22;
    L11:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        if (r2 == 1) goto L15;
    L14:
        r5 = false;
        goto L17
    }

    public void a(b.InterfaceC0736b r3) {
        this.h = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r3, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
    }

    public void a(ArrayList<WidgetRun> r6) {
        r6.clear();
        this.e.f.c();
        this.e.g.c();
        r6.add(this.e.f);
        r6.add(this.e.g);
        Iterator<ConstraintWidget> r0 = this.e.aV.iterator();
        HashSet r1 = null;
    L4:
        if (r0.hasNext() == false) goto L30;
        ConstraintWidget r2 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.constraintlayout.core.widgets.f.class) == true) goto L7;
        if (r2.ac() == true) goto L12;
        r6.add(r2.f);
    L19:
        if (r2.ad() == true) goto L21;
        r6.add(r2.g);
    L28:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.constraintlayout.core.widgets.h.class) == false) goto L4;
        WidgetRun r3 = new j(r2);
    L8:
        r6.add(r3);
        goto L4
    L21:
        if (r2.e != null) goto L23;
        r2.e = new c(r2, 1);
    L23:
        if (r1 != null) goto L25;
        r1 = new HashSet();
    L25:
        r1.add(r2.e);
        goto L28
    L12:
        if (r2.d != null) goto L14;
        r2.d = new c(r2, 0);
    L14:
        if (r1 != null) goto L16;
        r1 = new HashSet();
    L16:
        r1.add(r2.d);
        goto L19
    L7:
        r3 = new i(r2);
        goto L8
    L30:
        if (r1 == null) goto L32;
        r6.addAll(r1);
    L32:
        Iterator<WidgetRun> r4 = r6.iterator();
    L34:
        if (r4.hasNext() == false) goto L36;
        ((WidgetRun) ZeusTransformUtils.preCheckCast(r4.next(), WidgetRun.class, "com.obric.memorydata.plugin")).c();
        goto L34
    L36:
        Iterator<WidgetRun> r7 = r6.iterator();
    L38:
        if (r7.hasNext() == false) goto L43;
        WidgetRun r5 = (WidgetRun) ZeusTransformUtils.preCheckCast(r7.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r5.d == this.e) goto L38;
        r5.f();
        goto L38
    }

    public boolean a(boolean r11) {
        boolean r0 = true;
        boolean r12 = r11 & true;
        if (this.c == false) goto L5;
    L6:
        Iterator<ConstraintWidget> r1 = this.f13622b.aV.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ConstraintWidget r4 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r1.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r4.z();
        r4.f13608b = false;
        r4.f.d();
        r4.g.d();
        goto L8
    L10:
        this.f13622b.z();
        this.f13622b.f13608b = false;
        this.f13622b.f.d();
        this.f13622b.g.d();
        this.d = false;
    L12:
        if (a(this.e) == false) goto L14;
        return false;
    L14:
        this.f13622b.o(0);
        this.f13622b.p(0);
        ConstraintWidget.DimensionBehaviour r2 = this.f13622b.x(0);
        ConstraintWidget.DimensionBehaviour r5 = this.f13622b.x(1);
        if (this.c == false) goto L17;
        d();
    L17:
        int r6 = this.f13622b.D();
        int r7 = this.f13622b.E();
        this.f13622b.f.j.a(r6);
        this.f13622b.g.j.a(r7);
        a();
        if (r2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L20;
    L21:
        if (r12 == false) goto L28;
        Iterator<WidgetRun> r8 = this.f.iterator();
    L24:
        if (r8.hasNext() == false) goto L28;
        if (((WidgetRun) ZeusTransformUtils.preCheckCast(r8.next(), WidgetRun.class, "com.obric.memorydata.plugin")).a() == true) goto L24;
        r12 = false;
    L28:
        if (r12 == true) goto L30;
    L32:
        if (r12 == true) goto L34;
    L37:
        if (this.f13622b.L[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L39;
    L42:
        int r13 = this.f13622b.F() + r6;
        this.f13622b.f.k.a(r13);
        this.f13622b.f.g.a(r13 - r6);
        a();
        if (this.f13622b.L[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L45;
    L46:
        int r14 = this.f13622b.G() + r7;
        this.f13622b.g.k.a(r14);
        this.f13622b.g.g.a(r14 - r7);
    L47:
        a();
        boolean r15 = true;
    L48:
        Iterator<WidgetRun> r9 = this.f.iterator();
    L50:
        if (r9.hasNext() == false) goto L57;
        WidgetRun r10 = (WidgetRun) ZeusTransformUtils.preCheckCast(r9.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r10.d != this.f13622b) goto L56;
        if (r10.i == false) goto L50;
    L56:
        r10.e();
        goto L50
    L57:
        Iterator<WidgetRun> r16 = this.f.iterator();
    L59:
        if (r16.hasNext() == false) goto L80;
        WidgetRun r17 = (WidgetRun) ZeusTransformUtils.preCheckCast(r16.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r15 == true) goto L66;
        if (r17.d == this.f13622b) goto L59;
    L66:
        if (r17.j.j == false) goto L67;
        if (r17.k.j == true) goto L74;
        if (ZeusTransformUtils.instanceOf(r17, i.class) == false) goto L67;
    L74:
        if (r17.g.j == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r17, c.class) == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r17, i.class) == true) goto L59;
    L67:
        r0 = false;
    L80:
        this.f13622b.a(r2);
        this.f13622b.b(r5);
        return r0;
    L45:
        if (this.f13622b.L[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L47;
    L39:
        if (this.f13622b.L[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L42;
        r15 = false;
        goto L48
    L34:
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L37;
        this.f13622b.b(ConstraintWidget.DimensionBehaviour.FIXED);
        com.obric.oui.constraintlayout.core.widgets.d r18 = this.f13622b;
        r18.r(a(r18, 1));
        this.f13622b.g.g.a(this.f13622b.G());
        goto L37
    L30:
        if (r2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
        this.f13622b.a(ConstraintWidget.DimensionBehaviour.FIXED);
        com.obric.oui.constraintlayout.core.widgets.d r19 = this.f13622b;
        r19.q(a(r19, 0));
        this.f13622b.f.g.a(this.f13622b.F());
        goto L32
    L20:
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L37;
    L5:
        if (this.d == false) goto L12;
        goto L6
    }

    public boolean a(boolean r11, int r12) {
        boolean r0 = true;
        boolean r13 = r11 & true;
        ConstraintWidget.DimensionBehaviour r1 = this.f13622b.x(0);
        ConstraintWidget.DimensionBehaviour r3 = this.f13622b.x(1);
        int r4 = this.f13622b.D();
        int r5 = this.f13622b.E();
        if (r13 == true) goto L5;
    L26:
        ConstraintWidget.DimensionBehaviour[] r14 = this.f13622b.L;
        if (r12 != 0) goto L34;
        if (r14[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
    L32:
        int r15 = this.f13622b.F() + r4;
        this.f13622b.f.k.a(r15);
        this.f13622b.f.g.a(r15 - r4);
    L40:
        boolean r16 = true;
    L41:
        a();
        Iterator<WidgetRun> r6 = this.f.iterator();
    L43:
        if (r6.hasNext() == false) goto L53;
        WidgetRun r7 = (WidgetRun) ZeusTransformUtils.preCheckCast(r6.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r7.h != r12) goto L43;
        if (r7.d != this.f13622b) goto L52;
        if (r7.i == false) goto L43;
    L52:
        r7.e();
        goto L43
    L53:
        Iterator<WidgetRun> r8 = this.f.iterator();
    L55:
        if (r8.hasNext() == false) goto L74;
        WidgetRun r9 = (WidgetRun) ZeusTransformUtils.preCheckCast(r8.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r9.h != r12) goto L55;
        if (r16 == true) goto L64;
        if (r9.d == this.f13622b) goto L55;
    L64:
        if (r9.j.j == false) goto L65;
        if (r9.k.j == false) goto L65;
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L55;
        if (r9.g.j == true) goto L55;
    L65:
        r0 = false;
    L74:
        this.f13622b.a(r1);
        this.f13622b.b(r3);
        return r0;
    L31:
        if (this.f13622b.L[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
    L38:
        r16 = false;
        goto L41
    L34:
        if (r14[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L36;
    L39:
        int r17 = this.f13622b.G() + r5;
        this.f13622b.g.k.a(r17);
        this.f13622b.g.g.a(r17 - r5);
        goto L40
    L36:
        if (this.f13622b.L[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L38;
    L5:
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L7;
    L8:
        Iterator<WidgetRun> r10 = this.f.iterator();
    L10:
        if (r10.hasNext() == false) goto L16;
        WidgetRun r18 = (WidgetRun) ZeusTransformUtils.preCheckCast(r10.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r18.h != r12) goto L10;
        if (r18.a() == true) goto L10;
        r13 = false;
    L16:
        if (r12 != 0) goto L21;
        if (r13 == false) goto L26;
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L26;
        this.f13622b.a(ConstraintWidget.DimensionBehaviour.FIXED);
        com.obric.oui.constraintlayout.core.widgets.d r19 = this.f13622b;
        r19.q(a(r19, 0));
        f r110 = this.f13622b.f.g;
        int r20 = this.f13622b.F();
    L25:
        r110.a(r20);
        goto L26
    L21:
        if (r13 == false) goto L26;
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L26;
        this.f13622b.b(ConstraintWidget.DimensionBehaviour.FIXED);
        com.obric.oui.constraintlayout.core.widgets.d r111 = this.f13622b;
        r111.r(a(r111, 1));
        r110 = this.f13622b.g.g;
        r20 = this.f13622b.G();
        goto L25
    L7:
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L26;
        goto L8
    }

    public void b() {
        this.c = true;
    }

    public boolean b(boolean r5) {
        if (this.c == false) goto L10;
        Iterator<ConstraintWidget> r6 = this.f13622b.aV.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r6.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r1.z();
        r1.f13608b = false;
        r1.f.g.j = false;
        r1.f.i = false;
        r1.f.d();
        r1.g.g.j = false;
        r1.g.i = false;
        r1.g.d();
        goto L6
    L8:
        this.f13622b.z();
        this.f13622b.f13608b = false;
        this.f13622b.f.g.j = false;
        this.f13622b.f.i = false;
        this.f13622b.f.d();
        this.f13622b.g.g.j = false;
        this.f13622b.g.i = false;
        this.f13622b.g.d();
        d();
    L10:
        if (a(this.e) == false) goto L12;
        return false;
    L12:
        this.f13622b.o(0);
        this.f13622b.p(0);
        this.f13622b.f.j.a(0);
        this.f13622b.g.j.a(0);
        return true;
    }

    public void c() {
        this.d = true;
    }

    public void d() {
        a(this.f);
        this.f13621a.clear();
        l.f13627a = 0;
        a(this.f13622b.f, 0, this.f13621a);
        a(this.f13622b.g, 1, this.f13621a);
        this.c = false;
    }
}

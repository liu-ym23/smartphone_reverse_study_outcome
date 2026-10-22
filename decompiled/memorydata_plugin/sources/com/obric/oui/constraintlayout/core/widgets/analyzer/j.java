package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
class j extends WidgetRun {
    j(ConstraintWidget r1) {
        super(r1);
    }

    private void a(DependencyNode r2) {
        this.j.k.add(r2);
        r2.l.add(this.j);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean a() {
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void c() {
        this.e = null;
        this.j.a();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        this.j.j = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (ZeusTransformUtils.instanceOf(this.d, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L12;
        int r0 = ((com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(this.d, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin")).b();
        if (r0 != 0) goto L7;
    L10:
        this.d.o(this.j.g);
        return;
    L7:
        if (r0 == 1) goto L10;
        this.d.p(this.j.g);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        if (ZeusTransformUtils.instanceOf(this.d, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L68;
        this.j.f13613b = true;
        com.obric.oui.constraintlayout.core.widgets.a r0 = (com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(this.d, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin");
        int r2 = r0.b();
        boolean r3 = r0.c();
        int r5 = 0;
        if (r2 == 0) goto L43;
        if (r2 != 1) goto L8;
        DependencyNode r1 = this.j;
        r1.e = DependencyNode.Type.RIGHT;
    L35:
        if (r5 >= r0.aA) goto L53;
        ConstraintWidget r4 = r0.az[r5];
        if (r3 == false) goto L39;
    L41:
        DependencyNode r6 = r4.f.k;
        r6.k.add(this.j);
        this.j.l.add(r6);
    L42:
        r5 = r5 + 1;
        goto L35
    L39:
        if (r4.B() != 8) goto L41;
    L53:
        a(this.d.f.j);
        DependencyNode r7 = this.d.f.k;
    L54:
        a(r7);
        return;
    L8:
        if (r2 != 2) goto L10;
        DependencyNode r8 = this.j;
        r8.e = DependencyNode.Type.TOP;
    L24:
        if (r5 >= r0.aA) goto L32;
        ConstraintWidget r9 = r0.az[r5];
        if (r3 == false) goto L28;
    L30:
        DependencyNode r10 = r9.g.j;
        r10.k.add(this.j);
        this.j.l.add(r10);
    L31:
        r5 = r5 + 1;
        goto L24
    L28:
        if (r9.B() != 8) goto L30;
    L32:
        a(this.d.g.j);
        r7 = this.d.g.k;
        goto L54
    L10:
        if (r2 != 3) goto L69;
        DependencyNode r11 = this.j;
        r11.e = DependencyNode.Type.BOTTOM;
    L14:
        if (r5 >= r0.aA) goto L32;
        ConstraintWidget r12 = r0.az[r5];
        if (r3 == false) goto L18;
    L20:
        DependencyNode r13 = r12.g.k;
        r13.k.add(this.j);
        this.j.l.add(r13);
    L21:
        r5 = r5 + 1;
        goto L14
    L18:
        if (r12.B() != 8) goto L20;
    L69:
        return;
    L43:
        DependencyNode r14 = this.j;
        r14.e = DependencyNode.Type.LEFT;
    L45:
        if (r5 >= r0.aA) goto L53;
        ConstraintWidget r15 = r0.az[r5];
        if (r3 == false) goto L49;
    L51:
        DependencyNode r16 = r15.f.j;
        r16.k.add(this.j);
        this.j.l.add(r16);
    L52:
        r5 = r5 + 1;
        goto L45
    L49:
        if (r15.B() != 8) goto L51;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r9) {
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.memorydata.plugin");
        com.obric.oui.constraintlayout.core.widgets.a r11 = (com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(this.d, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin");
        int r0 = r11.b();
        Iterator<DependencyNode> r2 = this.j.l.iterator();
        int r4 = 0;
        int r5 = -1;
    L4:
        if (r2.hasNext() == false) goto L11;
        int r6 = ((DependencyNode) ZeusTransformUtils.preCheckCast(r2.next(), DependencyNode.class, "com.obric.memorydata.plugin")).g;
        if (r5 == (-1)) goto L8;
        if (r6 < r5) goto L8;
    L9:
        if (r4 >= r6) goto L4;
        r4 = r6;
    L8:
        r5 = r6;
        goto L9
    L11:
        if (r0 != 0) goto L13;
    L16:
        this.j.a(r5 + r11.g());
        return;
    L13:
        if (r0 == 2) goto L16;
        this.j.a(r4 + r11.g());
    }
}

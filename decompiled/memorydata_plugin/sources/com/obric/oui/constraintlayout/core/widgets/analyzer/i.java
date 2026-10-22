package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class i extends WidgetRun {
    i(ConstraintWidget r3) {
        super(r3);
        r3.f.c();
        r3.g.c();
        this.h = ((com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin")).c();
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
        this.j.a();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        this.j.j = false;
        this.k.j = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (((com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(this.d, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin")).c() != 1) goto L5;
        this.d.o(this.j.g);
        return;
    L5:
        this.d.p(this.j.g);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        com.obric.oui.constraintlayout.core.widgets.f r0 = (com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(this.d, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin");
        int r1 = r0.g();
        int r2 = r0.h();
        r0.f();
        if (r0.c() != 1) goto L12;
        DependencyNode r3 = this.j;
        if (r1 == (-1)) goto L8;
        r3.l.add(this.d.M.f.j);
        this.d.M.f.j.k.add(this.j);
        DependencyNode r4 = this.j;
    L7:
        r4.f = r1;
    L11:
        a(this.d.f.j);
        DependencyNode r5 = this.d.f.k;
    L20:
        a(r5);
        return;
    L8:
        if (r2 == (-1)) goto L10;
        r3.l.add(this.d.M.f.k);
        this.d.M.f.k.k.add(this.j);
        r4 = this.j;
        r1 = -r2;
        goto L7
    L10:
        r3.f13613b = true;
        this.j.l.add(this.d.M.f.k);
        this.d.M.f.k.k.add(this.j);
        goto L11
    L12:
        DependencyNode r6 = this.j;
        if (r1 == (-1)) goto L16;
        r6.l.add(this.d.M.g.j);
        this.d.M.g.j.k.add(this.j);
        DependencyNode r7 = this.j;
    L15:
        r7.f = r1;
    L19:
        a(this.d.g.j);
        r5 = this.d.g.k;
        goto L20
    L16:
        if (r2 == (-1)) goto L18;
        r6.l.add(this.d.M.g.k);
        this.d.M.g.k.k.add(this.j);
        r7 = this.j;
        r1 = -r2;
        goto L15
    L18:
        r6.f13613b = true;
        this.j.l.add(this.d.M.g.k);
        this.d.M.g.k.k.add(this.j);
        goto L19
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        if (this.j.c == true) goto L6;
        return;
    L6:
        if (this.j.j == false) goto L8;
        return;
    L8:
        this.j.a((int) ((((DependencyNode) ZeusTransformUtils.preCheckCast(this.j.l.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).g * ((com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(this.d, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin")).f()) + 0.5f));
    }
}

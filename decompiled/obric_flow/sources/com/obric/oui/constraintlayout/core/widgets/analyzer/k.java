package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends s {
    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.e
    public final void a(e r10) {
        hr.a r11 = (hr.a) this.f12593b;
        int r5 = r11.f17369w0;
        g r12 = this.f12595h;
        Iterator r13 = r12.f12578l.iterator();
        int r14 = 0;
        int r15 = -1;
    L4:
        if (r13.hasNext() == false) goto L11;
        int r16 = ((g) r13.next()).g;
        if (r15 == (-1)) goto L8;
        if (r16 < r15) goto L8;
    L9:
        if (r14 >= r16) goto L4;
        r14 = r16;
    L8:
        r15 = r16;
        goto L9
    L11:
        if (r5 != 0) goto L13;
    L16:
        r12.d(r15 + r11.f17371y0);
        return;
    L13:
        if (r5 == 2) goto L16;
        r12.d(r14 + r11.f17371y0);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void d() {
        hr.f r5 = this.f12593b;
        if ((r5 instanceof hr.a) == false) goto L69;
        g r10 = this.f12595h;
        r10.f12572b = true;
        hr.a r11 = (hr.a) r5;
        int r12 = r11.f17369w0;
        boolean r13 = r11.f17370x0;
        int r14 = 0;
        if (r12 == 0) goto L45;
        if (r12 != 1) goto L8;
        r10.e = DependencyNode$Type.RIGHT;
    L36:
        if (r14 >= r11.f17463v0) goto L44;
        hr.f r15 = r11.f17462u0[r14];
        if (r13 == false) goto L40;
    L42:
        g r16 = r15.d.f12596i;
        r16.f12577k.add(r10);
        r10.f12578l.add(r16);
    L43:
        r14 = r14 + 1;
        goto L36
    L40:
        if (r15.i0 != 8) goto L42;
    L44:
        m(this.f12593b.d.f12595h);
        m(this.f12593b.d.f12596i);
        return;
    L8:
        if (r12 != 2) goto L10;
        r10.e = DependencyNode$Type.TOP;
    L25:
        if (r14 >= r11.f17463v0) goto L33;
        hr.f r17 = r11.f17462u0[r14];
        if (r13 == false) goto L29;
    L31:
        g r18 = r17.e.f12595h;
        r18.f12577k.add(r10);
        r10.f12578l.add(r18);
    L32:
        r14 = r14 + 1;
        goto L25
    L29:
        if (r17.i0 != 8) goto L31;
    L33:
        m(this.f12593b.e.f12595h);
        m(this.f12593b.e.f12596i);
        return;
    L10:
        if (r12 != 3) goto L73;
        r10.e = DependencyNode$Type.BOTTOM;
    L14:
        if (r14 >= r11.f17463v0) goto L22;
        hr.f r19 = r11.f17462u0[r14];
        if (r13 == false) goto L18;
    L20:
        g r20 = r19.e.f12596i;
        r20.f12577k.add(r10);
        r10.f12578l.add(r20);
    L21:
        r14 = r14 + 1;
        goto L14
    L18:
        if (r19.i0 != 8) goto L20;
    L22:
        m(this.f12593b.e.f12595h);
        m(this.f12593b.e.f12596i);
        return;
    L73:
        return;
    L45:
        r10.e = DependencyNode$Type.LEFT;
    L47:
        if (r14 >= r11.f17463v0) goto L55;
        hr.f r21 = r11.f17462u0[r14];
        if (r13 == false) goto L51;
    L53:
        g r22 = r21.d.f12595h;
        r22.f12577k.add(r10);
        r10.f12578l.add(r22);
    L54:
        r14 = r14 + 1;
        goto L47
    L51:
        if (r21.i0 != 8) goto L53;
    L55:
        m(this.f12593b.d.f12595h);
        m(this.f12593b.d.f12596i);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void e() {
        hr.f r5 = this.f12593b;
        if ((r5 instanceof hr.a) == false) goto L12;
        int r10 = ((hr.a) r5).f17369w0;
        g r11 = this.f12595h;
        if (r10 != 0) goto L7;
    L10:
        r5.f17395a0 = r11.g;
        return;
    L7:
        if (r10 == 1) goto L10;
        r5.f17397b0 = r11.g;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void f() {
        this.f12594c = null;
        this.f12595h.c();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final boolean k() {
        return false;
    }

    public final void m(g r5) {
        g r10 = this.f12595h;
        r10.f12577k.add(r5);
        r5.f12578l.add(r10);
    }
}

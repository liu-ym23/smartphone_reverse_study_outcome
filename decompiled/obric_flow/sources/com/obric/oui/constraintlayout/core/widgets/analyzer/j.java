package com.obric.oui.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends s {
    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.e
    public final void a(e r5) {
        g r10 = this.f12595h;
        if (r10.f12573c == true) goto L6;
        return;
    L6:
        if (r10.f12576j == false) goto L8;
        return;
    L8:
        r10.d((int) ((((g) r10.f12578l.get(0)).g * ((hr.k) this.f12593b).f17456u0) + 0.5f));
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void d() {
        hr.f r5 = this.f12593b;
        hr.k r10 = (hr.k) r5;
        int r11 = r10.f17457v0;
        int r12 = r10.f17458w0;
        int r13 = r10.f17460y0;
        g r14 = this.f12595h;
        if (r13 != 1) goto L10;
        if (r11 == (-1)) goto L6;
        r14.f12578l.add(r5.V.d.f12595h);
        this.f12593b.V.d.f12595h.f12577k.add(r14);
        r14.f = r11;
    L9:
        m(this.f12593b.d.f12595h);
        m(this.f12593b.d.f12596i);
        return;
    L6:
        if (r12 == (-1)) goto L8;
        r14.f12578l.add(r5.V.d.f12596i);
        this.f12593b.V.d.f12596i.f12577k.add(r14);
        r14.f = -r12;
        goto L9
    L8:
        r14.f12572b = true;
        r14.f12578l.add(r5.V.d.f12596i);
        this.f12593b.V.d.f12596i.f12577k.add(r14);
        goto L9
    L10:
        if (r11 == (-1)) goto L12;
        r14.f12578l.add(r5.V.e.f12595h);
        this.f12593b.V.e.f12595h.f12577k.add(r14);
        r14.f = r11;
    L15:
        m(this.f12593b.e.f12595h);
        m(this.f12593b.e.f12596i);
        return;
    L12:
        if (r12 == (-1)) goto L14;
        r14.f12578l.add(r5.V.e.f12596i);
        this.f12593b.V.e.f12596i.f12577k.add(r14);
        r14.f = -r12;
        goto L15
    L14:
        r14.f12572b = true;
        r14.f12578l.add(r5.V.e.f12596i);
        this.f12593b.V.e.f12596i.f12577k.add(r14);
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void e() {
        hr.f r5 = this.f12593b;
        int r10 = ((hr.k) r5).f17460y0;
        g r11 = this.f12595h;
        if (r10 != 1) goto L5;
        r5.f17395a0 = r11.g;
        return;
    L5:
        r5.f17397b0 = r11.g;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void f() {
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

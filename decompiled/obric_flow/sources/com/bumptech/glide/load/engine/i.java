package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public final class i implements com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f1513b;

    public /* synthetic */ i(e r5, Object r10) {
        this.f1513b = r5;
        this.f1512a = r10;
    }

    @Override // com.bumptech.glide.load.data.d
    public void a(Exception r5) {
        i0 r10 = (i0) this.f1513b;
        d0.q r11 = (d0.q) this.f1512a;
        d0.q r12 = r10.f;
        if (r12 == null) goto L7;
        if (r12 != r11) goto L8;
        d r13 = r10.g;
        com.bumptech.glide.load.data.e r14 = r11.f16567c;
        DataSource r15 = r14.d();
        r10.f1515b.a(r13, r5, r14, r15);
        return;
    L8:
        return;
    }

    @Override // com.bumptech.glide.load.data.d
    public void f(Object r10) {
        i0 r5 = (i0) this.f1513b;
        d0.q r11 = (d0.q) this.f1512a;
        d0.q r12 = r5.f;
        if (r12 == null) goto L12;
        if (r12 != r11) goto L13;
        m r13 = r5.f1514a.f1503p;
        if (r10 != null) goto L8;
    L10:
        z.c r14 = r11.f16565a;
        com.bumptech.glide.load.data.e r15 = r11.f16567c;
        DataSource r16 = r15.d();
        d r17 = r5.g;
        r5.f1515b.c(r14, r10, r15, r16, r17);
        return;
    L8:
        if (r13.a(r11.f16567c.d()) == false) goto L10;
        r5.e = r10;
        r5.f1515b.l();
        return;
    L13:
        return;
    }
}

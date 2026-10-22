package com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Collections;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f14988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f14990c;
    public i d;
    public final ArrayList e;
    public final ArrayList f;

    public l(String r5, x r10) {
        int r11 = i.f14970c;
        this.f14990c = new g();
        this.d = null;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.f14988a = r10;
        this.f14989b = r5;
    }

    public final void a(e r5) {
        this.e.add(b.a(r5).b());
    }

    public final void b(Modifier... r5) {
        Collections.addAll(this.f, r5);
    }

    public final m c() {
        return new m(this);
    }

    public final void d(i r5) {
        if (this.d != null) goto L5;
        boolean r10 = true;
    L6:
        com.bytedance.android.anniex.base.service.f.t(r10, "initializer was already set", new Object[0]);
        com.bytedance.android.anniex.base.service.f.s(r5, "codeBlock == null", new Object[0]);
        this.d = r5;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void e(String r5, Object... r10) {
        d(i.d(r5, r10));
    }
}

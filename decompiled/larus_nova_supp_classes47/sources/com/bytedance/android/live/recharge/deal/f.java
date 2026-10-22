package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class f {
    public i a;

    public f() {
    }

    public abstract long b();

    public abstract String d();

    public abstract int e();

    public abstract String f();

    public abstract long g();

    public abstract int h();

    public final i c() {
        i r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r.b;
    }

    public final int i() {
        return e() + h();
    }

    public final void a(i r2) {
        Intrinsics.checkNotNullParameter(r2, "dealSet");
        if (this.a != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.a = r2;
        return;
    L10:
        throw new IllegalStateException("DealSet is already set.".toString());
    L5:
        r0 = false;
        goto L6
    }
}

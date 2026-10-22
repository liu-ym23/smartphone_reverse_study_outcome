package com.bytedance.android.live.revlink.impl.utils;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 {
    public String a;
    public Disposable b;
    public final b0 c;
    public final com.bytedance.android.live.revlink.impl.global.c d;
    public final long e;
    public final Function0<Integer> f;

    public final void a() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(or2.d.class);
        Intrinsics.checkNotNull(r0);
        or2.d r2 = (com.bytedance.live.kmp.core.c) r0;
        String r3 = r2.getCurrentResolution();
        String r4 = this.a;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L10;
        return;
    L10:
        if ((!Intrinsics.areEqual(this.a, r3)) == false) goto L18;
        String r6 = this.a;
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r2.on(r6);
        return;
    L18:
        return;
    L7:
        r5 = false;
        goto L8
    }

    public d0(com.bytedance.android.live.revlink.impl.global.c r2, long r3, Function0<Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "sceneFn");
        this.d = r2;
        this.e = r3;
        this.f = r5;
        d51.c r4 = d51.c.A0;
        r4.getClass();
        this.c = (b0) d51.c.w.getValue(r4, d51.c.a[21]);
    }
}

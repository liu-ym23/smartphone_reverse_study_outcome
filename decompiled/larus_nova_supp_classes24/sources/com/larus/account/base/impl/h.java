package com.larus.account.base.impl;

import com.larus.login.impl.r3;
import ua7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h extends yb7.c {
    public final /* synthetic */ n38.m a;

    public h(r3 r1) {
        this.a = r1;
    }

    public final void b(e<wb7.c> r2) {
        this.a.onSuccess(null);
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((e) r1);
    }

    public final void a(e<wb7.c> r3, int r4) {
        n38.m r0 = this.a;
        if (r3 == null) goto L5;
        String r5 = ((ua7.b) r3).i;
    L6:
        r0.a(r4, r5, null, null);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((e) r1, r2);
    }
}

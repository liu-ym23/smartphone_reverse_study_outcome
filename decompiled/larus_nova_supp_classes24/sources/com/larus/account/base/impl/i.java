package com.larus.account.base.impl;

import com.larus.login.impl.t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i extends yb7.k {
    public final /* synthetic */ n38.m a;

    public i(t3 r1) {
        this.a = r1;
    }

    public final void onSuccess(ua7.b r2) {
        ua7.i r3 = (ua7.i) r2;
        n38.m r0 = this.a;
        if (r3 == null) goto L5;
        String r4 = r3.p;
    L6:
        r0.onSuccess(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onError(ua7.b r3, int r4) {
        ua7.i r5 = (ua7.i) r3;
        n38.m r0 = this.a;
        if (r5 == null) goto L5;
        String r6 = ((ua7.b) r5).i;
    L6:
        r0.a(r4, r6, null, null);
        return;
    L5:
        r6 = null;
        goto L6
    }
}

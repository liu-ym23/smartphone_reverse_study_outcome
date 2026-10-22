package com.larus.account.base.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LoginServiceImpl$b extends com.ss.android.account.l {
    public final /* synthetic */ n38.m a;

    public LoginServiceImpl$b(n38.m r1) {
        this.a = r1;
    }

    public final void a(ua7.h r4) {
        n38.m r0 = this.a;
        if (r4 == null) goto L5;
        int r1 = ((ua7.b) r4).g;
    L7:
        if (r4 == null) goto L9;
        String r5 = ((ua7.b) r4).i;
    L10:
        r0.a(r1, r5, null, null);
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = -1;
        goto L7
    }

    public final void c(ua7.h r2) {
        this.a.onSuccess(null);
    }

    public final void b(ua7.h r1, String r2, String r3, String r4) {
        n38.m r5 = this.a;
        if (r1 == null) goto L5;
        int r6 = ((ua7.b) r1).g;
    L6:
        r5.a(r6, String.valueOf(r2), null, null);
        return;
    L5:
        r6 = -1;
        goto L6
    }
}

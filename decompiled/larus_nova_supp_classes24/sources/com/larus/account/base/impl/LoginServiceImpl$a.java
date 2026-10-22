package com.larus.account.base.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LoginServiceImpl$a extends com.ss.android.account.l {
    public final /* synthetic */ n38.m a;
    public final /* synthetic */ LoginServiceImpl b;

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
        this.b.z();
    }

    public LoginServiceImpl$a(n38.m r1, LoginServiceImpl r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(ua7.h r2, String r3, String r4, String r5) {
        n38.m r6 = this.a;
        if (r2 == null) goto L5;
        int r0 = ((ua7.b) r2).g;
    L6:
        String r7 = String.valueOf(r3);
        if (r2 == null) goto L9;
        String r8 = r2.y;
    L10:
        r6.a(r0, r7, r5, r8);
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r0 = -1;
        goto L6
    }
}

package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import com.larus.login.impl.v3;
import com.ss.android.account.d;
import ua7.e;
import yb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g extends a {
    public final /* synthetic */ String a;
    public final /* synthetic */ LoginPlatform b;
    public final /* synthetic */ n38.h c;

    public final void b(e<wb7.a> r4) {
        if (r4 == null) goto L10;
        wb7.a r5 = r4.p;
        if (r5 == null) goto L10;
        d r6 = r5.e;
        if (r6 == null) goto L10;
        boolean r0 = true;
        if (((sc7.a) r6).g != true) goto L10;
    L11:
        m38.a r7 = m38.a.a;
        r7.getClass();
        m38.a.c = r0;
        String r1 = this.a;
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        m38.a.c(r7, r1, this.b);
        this.c.b(this.b, this.a, Boolean.valueOf(r0));
        return;
    L10:
        r0 = false;
        goto L11
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((e) r1);
    }

    public g(LoginPlatform r2, v3 r3) {
        this.a = "VerificationCodeFragment";
        this.b = r2;
        this.c = r3;
    }

    public final void a(e<wb7.a> r11, int r12) {
        m38.a.a.getClass();
        n38.h r0 = this.c;
        LoginPlatform r1 = this.b;
        if (r11 == null) goto L5;
        int r2 = ((ua7.b) r11).g;
    L6:
        if (r11 == null) goto L8;
        String r13 = ((ua7.b) r11).i;
    L9:
        n38.h.a.a(r0, r1, r2, r13, this.a, null, null, null, null, 480);
        return;
    L8:
        r13 = null;
        goto L9
    L5:
        r2 = -1;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((e) r1, r2);
    }
}

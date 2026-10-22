package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import com.larus.login.impl.u3;
import com.ss.android.account.d;
import kotlin.jvm.internal.Intrinsics;
import m38.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends com.ss.android.account.l {
    public final /* synthetic */ n38.h a;
    public final /* synthetic */ LoginPlatform b;
    public final /* synthetic */ String c;

    public final void a(ua7.h r12) {
        a.a.getClass();
        n38.h r1 = this.a;
        LoginPlatform r2 = this.b;
        if (r12 == null) goto L5;
        int r3 = ((ua7.b) r12).g;
    L6:
        if (r12 == null) goto L8;
        String r13 = ((ua7.b) r12).i;
    L9:
        n38.h.a.a(r1, r2, r3, r13, this.c, null, null, null, null, 480);
        return;
    L8:
        r13 = null;
        goto L9
    L5:
        r3 = -1;
        goto L6
    }

    public final void c(ua7.h r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        d r5 = r4.p;
        if (r5 == null) goto L7;
        boolean r0 = true;
        if (((sc7.a) r5).g != true) goto L7;
    L8:
        a r6 = a.a;
        r6.getClass();
        a.c = r0;
        String r1 = this.c;
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        a.c(r6, r1, this.b);
        this.a.b(this.b, this.c, Boolean.valueOf(r0));
        return;
    L7:
        r0 = false;
        goto L8
    }

    public f(u3 r1, LoginPlatform r2) {
        this.a = r1;
        this.b = r2;
        this.c = "VerificationCodeFragment";
    }

    public final void b(ua7.h r11, String r12, String r13, String r14) {
        a.a.getClass();
        n38.h r0 = this.a;
        LoginPlatform r1 = this.b;
        if (r11 == null) goto L5;
        int r2 = ((ua7.b) r11).g;
    L6:
        if (r11 == null) goto L8;
        String r15 = r11.q;
    L9:
        n38.h.a.a(r0, r1, r2, r15, this.c, null, null, null, null, 480);
        return;
    L8:
        r15 = null;
        goto L9
    L5:
        r2 = -1;
        goto L6
    }
}

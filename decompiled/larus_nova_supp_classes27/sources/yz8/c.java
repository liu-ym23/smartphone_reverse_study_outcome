package yz8;

import com.larus.account.base.impl.o;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.phone.PhoneLogin;
import wb7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends yb7.f {
    public final /* synthetic */ n38.h a;
    public final /* synthetic */ PhoneLogin b;
    public final /* synthetic */ String c;

    public final void b(ua7.e<j> r4) {
        if (r4 == null) goto L10;
        j r5 = r4.p;
        if (r5 == null) goto L10;
        com.ss.android.account.d r6 = r5.e;
        if (r6 == null) goto L10;
        boolean r0 = true;
        if (((sc7.a) r6).g != true) goto L10;
    L11:
        n38.h r7 = this.a;
        this.b.getClass();
        r7.b(LoginPlatform.PHONE, this.c, Boolean.valueOf(r0));
        return;
    L10:
        r0 = false;
        goto L11
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((ua7.e) r1);
    }

    public c(o r1, PhoneLogin r2) {
        this.a = r1;
        this.b = r2;
        this.c = "PhoneLoginAccountDiscoveryActivity";
    }

    public final void a(ua7.e<j> r11, int r12) {
        n38.h r0 = this.a;
        this.b.getClass();
        LoginPlatform r1 = LoginPlatform.PHONE;
        if (r11 == null) goto L5;
        String r13 = ((ua7.b) r11).i;
    L6:
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        n38.h.a.a(r0, r1, r12, r13, this.c, null, null, null, null, 480);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((ua7.e) r1, r2);
    }
}

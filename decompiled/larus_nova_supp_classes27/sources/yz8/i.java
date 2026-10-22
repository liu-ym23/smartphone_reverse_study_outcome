package yz8;

import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.phone.PhoneLogin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i extends yb7.g {
    public final /* synthetic */ n38.h a;
    public final /* synthetic */ PhoneLogin b;
    public final /* synthetic */ String c;

    public final void b(ua7.e<wb7.h> r4) {
        n38.h r5 = this.a;
        this.b.getClass();
        r5.b(LoginPlatform.PHONE, this.c, Boolean.TRUE);
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((ua7.e) r1);
    }

    public final void a(ua7.e<wb7.h> r11, int r12) {
        n38.h r0 = this.a;
        this.b.getClass();
        LoginPlatform r1 = LoginPlatform.PHONE;
        if (r11 == null) goto L6;
        String r13 = ((ua7.b) r11).i;
        if (r13 == null) goto L6;
    L7:
        n38.h.a.a(r0, r1, r12, r13, this.c, null, null, null, null, 480);
        return;
    L6:
        r13 = "";
        goto L7
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((ua7.e) r1, r2);
    }

    public i(n38.h r1, PhoneLogin r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

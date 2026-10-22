package yz8;

import com.larus.account.base.impl.o;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.phone.PhoneLogin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d extends va7.e {
    public final /* synthetic */ n38.h a;
    public final /* synthetic */ PhoneLogin b;
    public final /* synthetic */ String c;

    public final void onSuccess(ua7.b r4) {
        xa7.g r5 = (xa7.g) r4;
        if (r5 == null) goto L9;
        com.ss.android.account.d r6 = r5.v;
        if (r6 == null) goto L9;
        boolean r0 = true;
        if (((sc7.a) r6).g != true) goto L9;
    L10:
        n38.h r7 = this.a;
        this.b.getClass();
        r7.b(LoginPlatform.PHONE, this.c, Boolean.valueOf(r0));
        return;
    L9:
        r0 = false;
        goto L10
    }

    public d(o r1, PhoneLogin r2) {
        this.a = r1;
        this.b = r2;
        this.c = "PhoneLoginAccountDiscoveryActivity";
    }

    public final void onError(ua7.b r11, int r12) {
        xa7.g r13 = (xa7.g) r11;
        n38.h r0 = this.a;
        this.b.getClass();
        LoginPlatform r1 = LoginPlatform.PHONE;
        if (r13 == null) goto L5;
        String r14 = ((ua7.b) r13).i;
    L6:
        if (r14 != null) goto L8;
        r14 = "";
    L8:
        n38.h.a.a(r0, r1, r12, r14, this.c, null, null, null, null, 480);
        return;
    L5:
        r14 = null;
        goto L6
    }
}

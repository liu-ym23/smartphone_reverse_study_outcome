package c09;

import com.larus.account.base.impl.s;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.weixin.WeixinLogin;
import com.ss.android.account.d;
import kotlin.jvm.internal.Intrinsics;
import sa7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b extends h<ua7.h> {
    public final /* synthetic */ n38.h a;
    public final /* synthetic */ WeixinLogin b;

    public final void onSuccess(ua7.b r4) {
        ua7.h r5 = (ua7.h) r4;
        Intrinsics.checkNotNullParameter(r5, "response");
        d r6 = r5.p;
        if (r6 == null) goto L7;
        boolean r0 = true;
        if (((sc7.a) r6).g != true) goto L7;
    L8:
        n38.h r7 = this.a;
        this.b.getClass();
        r7.b(LoginPlatform.WEIXIN, "WeixinLogin", Boolean.valueOf(r0));
        return;
    L7:
        r0 = false;
        goto L8
    }

    public b(s r1, WeixinLogin r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onError(ua7.b r11, int r12) {
        ua7.h r13 = (ua7.h) r11;
        n38.h r0 = this.a;
        this.b.getClass();
        LoginPlatform r1 = LoginPlatform.WEIXIN;
        if (r13 == null) goto L6;
        String r14 = ((ua7.b) r13).i;
        if (r14 == null) goto L6;
    L7:
        n38.h.a.a(r0, r1, r12, r14, "WeixinLogin", null, null, null, null, 480);
        return;
    L6:
        r14 = "";
        goto L7
    }
}

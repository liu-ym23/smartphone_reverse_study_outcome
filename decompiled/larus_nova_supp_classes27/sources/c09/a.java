package c09;

import android.content.Context;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.larus.account.base.impl.n;
import com.larus.account.base.model.LoginPlatform;
import com.larus.utils.logger.FLogger;
import com.ss.android.account.d;
import kotlin.jvm.internal.Intrinsics;
import n38.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends PlatformLoginAdapter {
    public final /* synthetic */ h a;
    public final /* synthetic */ LoginPlatform b;
    public final /* synthetic */ String c;

    public final void onLoginError(ua7.h r14) {
        Intrinsics.checkNotNullParameter(r14, "response");
        FLogger.a.i("WeixinLogin", "onLoginError:" + r14);
        h.a.a(this.a, this.b, ((ua7.b) r14).g, ((ua7.b) r14).i, this.c, r14.y, null, null, null, 448);
    }

    public final void onLoginSuccess(ua7.h r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        d r5 = r4.p;
        if (r5 == null) goto L7;
        boolean r0 = true;
        if (((sc7.a) r5).g != true) goto L7;
    L8:
        this.a.b(this.b, this.c, Boolean.valueOf(r0));
        return;
    L7:
        r0 = false;
        goto L8
    }

    public a(n r1, LoginPlatform r2, String r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        super(r4, "15210", "weixin");
    }
}

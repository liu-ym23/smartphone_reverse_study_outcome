package com.larus.common.account.platform.larklogin;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k extends sa7.h<xa7.c> {
    public final /* synthetic */ String a;

    public k(String r1) {
        this.a = r1;
    }

    public final void onSuccess(ua7.b r4) {
        xa7.c r5 = (xa7.c) r4;
        FLogger.a.i("LarkLogin", "update authorize info success");
        LarkLogin.h.c(this.a, new LarkOAuthSessionCoordinator$c.d(null));
    }

    public final void onError(ua7.b r5, int r6) {
        xa7.c r7 = (xa7.c) r5;
        FLogger.a.i("LarkLogin", "update authorize info fail, error: " + r6);
        LarkOAuthSessionCoordinator r0 = LarkLogin.h;
        String r1 = this.a;
        String r8 = String.valueOf(r6);
        if (r7 == null) goto L5;
        String r9 = ((ua7.b) r7).i;
    L6:
        r0.c(r1, new LarkOAuthSessionCoordinator$c.c(r8, r9, null, null));
        return;
    L5:
        r9 = null;
        goto L6
    }
}

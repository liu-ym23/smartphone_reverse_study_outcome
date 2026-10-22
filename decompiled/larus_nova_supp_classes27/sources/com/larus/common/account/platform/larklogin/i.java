package com.larus.common.account.platform.larklogin;

import com.larus.utils.logger.FLogger;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i extends sa7.h<xa7.c> {
    public final /* synthetic */ LarkLogin a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public final void onSuccess(ua7.b r8) {
        xa7.c r9 = (xa7.c) r8;
        FLogger.a.i("LarkLogin", "supplement update authorize info success");
        BuildersKt.launch$default(this.a.c, null, null, new LarkLogin$authorize$startResult$1$1$onSuccess$1(this.b, this.c, this.d, null), 3, null);
    }

    public final void onError(ua7.b r6, int r7) {
        xa7.c r8 = (xa7.c) r6;
        FLogger.a.i("LarkLogin", "supplement update authorize info failed, error: " + r7);
        LarkOAuthSessionCoordinator r0 = LarkLogin.h;
        String r1 = this.d;
        String r9 = "passport:" + r7;
        if (r8 == null) goto L5;
        String r10 = ((ua7.b) r8).i;
    L6:
        r0.c(r1, new LarkOAuthSessionCoordinator$c.c(r9, r10, null, null));
        return;
    L5:
        r10 = null;
        goto L6
    }

    public i(LarkLogin r1, String r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}

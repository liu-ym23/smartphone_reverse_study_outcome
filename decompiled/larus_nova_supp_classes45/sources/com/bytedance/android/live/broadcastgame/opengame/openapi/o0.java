package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o0 implements ICaptchaCallback {
    public final /* synthetic */ PayMethod a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public final void onSuccess() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"verify success"});
        Logger.d("showCaptcha", "showCaptcha, onSuccess");
        PayMethod.t(this.a, this.b, this.c, this.d);
    }

    public final void onFailure(int r4) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"verify fail, code: " + r4});
        Logger.d("showCaptcha", "showCaptcha, onFailure");
        this.a.y(OpenApiErrorInfo.NO_REQUEST_PERMISSION);
    }

    public o0(PayMethod r1, String r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}

package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u0 implements ICaptchaCallback {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public final void onSuccess() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"verify success"});
        p0.t(this.a, this.b, this.c, this.d);
    }

    public final void onFailure(int r4) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethodV3", new Object[]{"verify fail, code: " + r4});
        p0.x(this.a, OpenApiErrorInfo.NO_REQUEST_PERMISSION, this.b);
    }

    public u0(p0 r1, String r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}

package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x0 implements ICaptchaCallback {
    public final /* synthetic */ XplayPanelService a;

    public final void onSuccess() {
        XplayLog.a("showCaptcha", "showCaptcha, onSuccess");
        q1.a.onNext(Unit.INSTANCE);
    }

    public x0(XplayPanelService r1) {
        this.a = r1;
    }

    public final void onFailure(int r9) {
        XplayLog.a("showCaptcha", "showCaptcha, onFailure");
        this.a.k(new XplayException(q.a.c(q.c, Integer.valueOf(r9), null, 6), true, null, 4, null));
    }
}

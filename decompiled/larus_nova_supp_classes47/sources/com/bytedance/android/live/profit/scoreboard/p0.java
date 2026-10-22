package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ d c;

    public p0(String r1, long r2, com.bytedance.android.live.broadcastgame.opengame.sonicgame.l r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r5) {
        dv0.h r6 = (dv0.h) r5;
        if (r6.isFinished() == false) goto L5;
        jy0.b.d("ScoreboardServiceFacade", "subscription event: " + this.a + ' ' + this.b + " finish");
        this.c.a(EventName.ON_ROUND_MESSAGE_FINISH, ScoreboardExternalServiceFacade.a.a(ScoreboardExternalServiceFacade.e, r6));
        return;
    L5:
        jy0.b.d("ScoreboardServiceFacade", "subscription event: " + this.a + ' ' + this.b + " change");
        this.c.a(EventName.ON_ROUND_MESSAGE_SCORE_CHANGE, ScoreboardExternalServiceFacade.a.a(ScoreboardExternalServiceFacade.e, r6));
    }
}

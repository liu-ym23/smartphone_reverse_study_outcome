package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ d c;

    public n0(String r1, long r2, com.bytedance.android.live.broadcastgame.opengame.sonicgame.l r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r4) {
        jy0.b.d("ScoreboardServiceFacade", "subscription event: " + this.a + ' ' + this.b + " start");
        this.c.a(EventName.ON_ROUND_MESSAGE_START, ScoreboardExternalServiceFacade.a.a(ScoreboardExternalServiceFacade.e, (dv0.h) r4));
    }
}

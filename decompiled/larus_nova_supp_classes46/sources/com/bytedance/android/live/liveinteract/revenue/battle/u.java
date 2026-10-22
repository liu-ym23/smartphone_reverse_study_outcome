package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ GuestBattleWidget a;

    public u(GuestBattleWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        GuestBattleWidget r4 = this.a;
        int r0 = GuestBattleWidget.u;
        GuestBattleStateMachine.c r5 = r4.Eq();
        r5.getClass();
        if ((r5 instanceof GuestBattleStateMachine.c.C0068c) == false) goto L6;
        ALogger.e("[GuestBattle]GuestBattleWidget", "anchor fallback time is up, finish game current=" + this.a.Cq());
        this.a.Bq(3);
        return;
    }
}

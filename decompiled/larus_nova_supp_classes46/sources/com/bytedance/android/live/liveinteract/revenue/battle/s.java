package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ GuestBattleWidget a;

    public s(GuestBattleWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        ALogger.i("[GuestBattle]GuestBattleWidget", "show result time is up, reset to normal");
        GuestBattleWidget r4 = this.a;
        int r0 = GuestBattleWidget.u;
        r4.Eq().a.setFinishReason(3);
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r5 = this.a.Cq();
        if (r5 == null) goto L5;
        r5.setFinishReason(3);
    L5:
        this.a.m.b(GuestBattleStateMachine.a.j.b);
    }
}

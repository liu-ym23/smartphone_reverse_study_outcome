package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ GuestBattleWidget a;

    public r(GuestBattleWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        StringBuilder r5 = new StringBuilder("battle state changed sync store state-isShowing=");
        GuestBattleContext.a r0 = GuestBattleContext.Companion;
        r5.append(r0.e());
        ALogger.i("GuestBattleStore", r5.toString());
        ne0.c r6 = this.a.getStore();
        if (r6 == null) goto L6;
        int r1 = ji0.j.a;
        r6.b("guest_battle_is_showing", Boolean.valueOf(r0.e()));
        return;
    }
}

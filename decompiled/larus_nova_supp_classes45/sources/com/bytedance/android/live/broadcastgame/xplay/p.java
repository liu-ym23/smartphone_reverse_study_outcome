package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ XplayCoreService a;

    public p(XplayCoreService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        int r4 = XplayLog.a;
        XplayLog.c("XplayCoreService", "guide player count down over, state=" + this.a.h);
        this.a.h(IXplayCoreService.State.SwitchToHost);
        XplayCoreService.d(this.a);
        f2.b(2131923558, 0);
    }
}

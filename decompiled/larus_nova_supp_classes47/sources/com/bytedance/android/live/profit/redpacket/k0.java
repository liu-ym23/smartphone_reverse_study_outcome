package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ RedPacketIconModel a;

    public k0(RedPacketIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        xr2.c.a.a(this.a, RedPacketTempStatusStrategy.STRATEGY_PARTICIPATION_SURGE.getStrategyNum());
        int r4 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("RedPacketIconModel", "ask for strategy2");
    }
}

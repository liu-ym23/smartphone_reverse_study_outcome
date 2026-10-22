package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a1<T> implements Consumer {
    public final /* synthetic */ LotteryIconModel a;

    public a1(LotteryIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Boolean r6 = (Boolean) r5;
        g3.a r0 = this.a.getCurrentState();
        LotteryIconModel r1 = this.a;
        r1.k = r6.booleanValue();
        if (r6.booleanValue() == true) goto L5;
        return;
    L5:
        if ((r0 instanceof g3.a.b) == false) goto L9;
        long r2 = ((g3.a.b) r0).a.c - System.currentTimeMillis();
        this.a.registerShowTempState(LotteryTempStatusStrategy.STRATEGY_HOST.getStrategyNum(), r2);
        int r7 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("LotteryIconModel", "ask for strategy4");
        return;
    }
}

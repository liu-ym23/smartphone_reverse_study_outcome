package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y0<T> implements Consumer {
    public final /* synthetic */ LotteryIconModel a;

    public y0(LotteryIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        sh6.d r13 = (sh6.b) r12;
        if ((r13 instanceof sh6.d) == false) goto L10;
        y2 r14 = (y2) r13.a;
        this.a.l.onNext(r14);
        long r0 = System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN);
        LotteryIconModel r2 = this.a;
        LotteryTempStatusStrategy r3 = LotteryTempStatusStrategy.STRATEGY_PARTICIPATION_SURGE;
        long r4 = r2.getTempShowTime(r3.getStrategyNum());
        int r5 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("LotteryIconModel", "receive lotteryTempStatusInfo, luckyCount:" + r14.c + ", candidateTotalCount:" + r14.e + ", lastSurgeTimeStamp:" + r14.f + ", localTime:" + r0 + ", durationTime:" + r4);
        long r9 = r14.f;
        if (r9 <= r0) goto L7;
        return;
    L7:
        if (r0 > (r9 + r4)) goto L12;
        xr2.c.a.a(this.a, r3.getStrategyNum());
        com.bytedance.android.live.revenue.common.v.e("LotteryIconModel", "ask for strategy2, lastSurgeTimeStamp:" + r14.f + ", localTime:" + r0 + ", durationTime:" + r4);
        return;
    L12:
        return;
    }
}

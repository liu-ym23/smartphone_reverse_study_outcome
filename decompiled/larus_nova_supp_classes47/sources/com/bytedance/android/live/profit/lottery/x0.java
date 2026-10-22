package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import io.reactivex.functions.Consumer;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x0<T> implements Consumer {
    public final /* synthetic */ LotteryIconModel a;

    public x0(LotteryIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        if (r8 == null) goto L5;
        long r2 = MathKt.roundToLong(r8.longValue() / WebcastRedirectException.UNKNOWN);
    L7:
        if (r2 > ((Number) com.bytedance.android.live.profit.util.g.b.getValue(null, com.bytedance.android.live.profit.util.g.a[0])).intValue()) goto L12;
        LotteryIconModel r9 = this.a;
        if (r9.k == true) goto L13;
        r9.registerShowTempState(LotteryTempStatusStrategy.STRATEGY_COUNT_DOWN.getStrategyNum(), 0);
        int r10 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("LotteryIconModel", "ask for strategy3");
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = 0;
        goto L7
    }
}

package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import io.reactivex.functions.Consumer;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ RedPacketIconModel a;

    public j0(RedPacketIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        if (r6 == null) goto L5;
        long r0 = MathKt.roundToLong(r6.longValue() / WebcastRedirectException.UNKNOWN);
    L7:
        if (r0 > ((Number) com.bytedance.android.live.profit.util.g.b.getValue(null, com.bytedance.android.live.profit.util.g.a[0])).intValue()) goto L10;
        xr2.c.a.a(this.a, RedPacketTempStatusStrategy.STRATEGY_COUNT_DOWN.getStrategyNum());
        int r7 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("RedPacketIconModel", "ask for strategy3");
        return;
    L10:
        return;
    L5:
        r0 = 0;
        goto L7
    }
}

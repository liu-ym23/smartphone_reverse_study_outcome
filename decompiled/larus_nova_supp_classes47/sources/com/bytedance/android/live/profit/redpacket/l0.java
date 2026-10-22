package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ RedPacketIconModel a;

    public l0(RedPacketIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        if (sh6.c.b((sh6.b) r6) == null) goto L8;
        RedPacketIconModel r7 = this.a;
        r7.l = true;
        Long r8 = r7.getCountDownSec();
        if (r8 == null) goto L9;
        long r0 = r8.longValue();
        this.a.registerShowTempState(RedPacketTempStatusStrategy.STRATEGY_HOST.getStrategyNum(), r0 * ((long) WebcastRedirectException.UNKNOWN));
        return;
    L9:
        return;
    }
}

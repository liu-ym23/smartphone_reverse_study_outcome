package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        g r4 = (g) sh6.c.b((sh6.b) r3);
        LotteryState r0 = null;
        if (r4 == null) goto L5;
        LotteryState r5 = r4.getState();
    L7:
        if ((r5 instanceof LotteryState.g) == false) goto L10;
        r0 = r5;
    L10:
        LotteryState.g r1 = (LotteryState.g) r0;
        if (r1 == null) goto L15;
        this.a.getClass();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r6 = ((mz0.c) f.a(mz0.c.class)).W2(LogCommon.ROOM);
        if (r6 == null) goto L19;
        r6.i("lottery_id", String.valueOf(r1.a.a));
        return;
    L19:
        return;
    L15:
        this.a.getClass();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r7 = ((mz0.c) f.a(mz0.c.class)).W2(LogCommon.ROOM);
        if (r7 == null) goto L21;
        r7.n();
        return;
    L21:
        return;
    L5:
        r5 = null;
        goto L7
    }
}

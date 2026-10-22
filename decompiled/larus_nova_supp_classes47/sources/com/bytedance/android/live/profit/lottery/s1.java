package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s1<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g b;
    public final /* synthetic */ LotteryState.a c;
    public final /* synthetic */ Lottery d;

    public s1(LotteryRepository r1, com.bytedance.android.live.revenue.common.g r2, LotteryState.a r3, Lottery r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r8) {
        Long r9 = (Long) r8;
        this.b.a("draw_result_failed");
        this.a.i(this.c, this.d, 10, null, this.b);
    }
}

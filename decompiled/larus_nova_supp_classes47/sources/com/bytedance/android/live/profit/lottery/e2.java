package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e2<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ Lottery b;

    public e2(LotteryRepository r1, Lottery r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        int r0 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_lottery", "onCurrentLotteryChanged lottery=" + this.b.c + " state=" + ((LotteryState) r3) + " currentLottery=" + ((Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(this.a.d)));
    }
}

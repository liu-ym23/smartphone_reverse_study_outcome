package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f2<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;

    public f2(LotteryRepository r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.o.getCurrentLottery().setValue(sh6.c.b((sh6.b) r2));
    }
}

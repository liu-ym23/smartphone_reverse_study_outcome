package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g2<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;

    public g2(LotteryRepository r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.live.datacontext.m<Boolean> r0 = this.a.o.getHasLotteryPermission();
        r0.setValue((Boolean) r2);
    }
}

package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m1<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;

    public m1(LotteryRepository r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        sh6.d r6 = (sh6.b) r5;
        LotteryRepository r0 = this.a;
        if ((r0.c.a instanceof sh6.a) == true) goto L5;
        return;
    L5:
        if ((r6 instanceof sh6.d) == false) goto L9;
        sh6.d r7 = r6;
        r0.h(new Lottery(new LotteryState.g((t) r7.a)));
        d1.d(this.a, (t) r7.a);
        LotteryRepository.a(this.a, (t) r7.a);
        return;
    }
}

package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public t2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        LotteryState.d r5 = (LotteryState.d) r4;
        m2 r0 = this.a;
        r0.getClass();
        if (r5.b.f == false) goto L6;
        String r1 = m2.f(r5.a).c;
        i.B0.getClass();
        r0.g(r1, r5, 0);
        return;
    }
}

package com.bytedance.android.live.profit.lottery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y<T1, T2> implements ttc.a {
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g a;
    public final /* synthetic */ long b;

    public y(com.bytedance.android.live.revenue.common.g r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3, Object r4) {
        Throwable r5 = (Throwable) r4;
        if (((s) r3) == null) goto L5;
        this.a.a("lotteryId=" + this.b);
        return;
    L5:
        this.a.c(r5);
    }
}

package com.bytedance.android.live.profit.lottery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0<T1, T2> implements ttc.a {
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g a;

    public d0(com.bytedance.android.live.revenue.common.g r1) {
        this.a = r1;
    }

    public final void accept(Object r1, Object r2) {
        Throwable r3 = (Throwable) r2;
        if (((v.a) r1) == null) goto L5;
        this.a.b("finish");
        return;
    L5:
        this.a.c(r3);
    }
}

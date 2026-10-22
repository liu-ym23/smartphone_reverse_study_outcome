package com.bytedance.android.live.profit.lottery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0<T1, T2> implements ttc.a {
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g a;

    public a0(com.bytedance.android.live.revenue.common.g r1) {
        this.a = r1;
    }

    public final void accept(Object r1, Object r2) {
        Boolean r3 = (Boolean) r1;
        Throwable r4 = (Throwable) r2;
        if (r3 == null) goto L5;
        this.a.a(String.valueOf(r3.booleanValue()));
        return;
    L5:
        this.a.c(r4);
    }
}

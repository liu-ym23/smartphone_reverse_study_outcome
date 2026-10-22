package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g a;

    public k0(com.bytedance.android.live.revenue.common.g r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.b(((v.b) r2).toString());
    }
}

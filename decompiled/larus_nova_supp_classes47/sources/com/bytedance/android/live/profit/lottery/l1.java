package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l1<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g a;

    public l1(com.bytedance.android.live.revenue.common.g r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        this.a.a("get review result: " + ((v.b) r4));
    }
}

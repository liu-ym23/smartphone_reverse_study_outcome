package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.profit.fansclub.r;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g a;

    public j(com.bytedance.android.live.revenue.common.g r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        r r3 = (r) r2;
        this.a.a("success");
    }
}

package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ d0 a;

    public z(d0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        SkuLimit r10 = (SkuLimit) r1;
        d0.d0(this.a);
    }
}

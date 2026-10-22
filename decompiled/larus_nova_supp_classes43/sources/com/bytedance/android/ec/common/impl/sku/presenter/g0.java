package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g0<T> implements Observer {
    public final /* synthetic */ i0 a;

    public g0(i0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        SkuLimit r10 = (SkuLimit) r1;
        i0.d0(this.a);
    }
}

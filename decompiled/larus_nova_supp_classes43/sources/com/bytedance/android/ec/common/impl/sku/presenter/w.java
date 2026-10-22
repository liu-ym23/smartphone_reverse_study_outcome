package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ CarModelOptimizePresenter a;

    public w(CarModelOptimizePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        CarModelOptimizePresenter r0 = this.a;
        r0.d0((CarAdaptComponent) r10);
    }
}

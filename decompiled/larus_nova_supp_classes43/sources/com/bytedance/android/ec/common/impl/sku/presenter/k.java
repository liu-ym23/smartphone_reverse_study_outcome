package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.model.sku.TradeModeSelection;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ ButtonOptimizePresenter a;

    public k(ButtonOptimizePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        TradeModeSelection r10 = (TradeModeSelection) r1;
        this.a.r0();
    }
}

package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ ButtonOptimizePresenter a;

    public f(ButtonOptimizePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        ButtonOptimizePresenter r0 = this.a;
        ButtonOptimizePresenter.h0(r0, (ButtonTipComponent) r10);
    }
}

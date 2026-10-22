package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ ButtonPresenter a;

    public p(ButtonPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Long r10 = (Long) r1;
        ButtonPresenter.i0(this.a);
    }
}

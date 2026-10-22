package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j1<T> implements Observer {
    public final /* synthetic */ l1 a;

    public j1(l1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Long r10 = (Long) r1;
        l1.d0(this.a);
    }
}

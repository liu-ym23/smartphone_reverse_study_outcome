package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t0<T> implements Observer {
    public final /* synthetic */ f1 a;

    public t0(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Long r10 = (Long) r1;
        f1.i0(this.a);
    }
}

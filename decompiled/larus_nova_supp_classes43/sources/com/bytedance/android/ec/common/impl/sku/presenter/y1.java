package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y1<T> implements Observer {
    public final /* synthetic */ b2 a;

    public y1(b2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        String r10 = (String) r1;
        this.a.m0();
        this.a.n0();
        this.a.l0();
    }
}

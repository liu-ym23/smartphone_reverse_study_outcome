package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a1<T> implements Observer {
    public final /* synthetic */ f1 a;

    public a1(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        this.a.l0((String) ((rg.a) r10).b);
    }
}

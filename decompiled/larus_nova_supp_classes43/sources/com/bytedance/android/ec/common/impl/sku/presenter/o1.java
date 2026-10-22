package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o1<T> implements Observer {
    public final /* synthetic */ s1 a;

    public o1(s1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Long r10 = (Long) r1;
        s1.d0(this.a);
    }
}

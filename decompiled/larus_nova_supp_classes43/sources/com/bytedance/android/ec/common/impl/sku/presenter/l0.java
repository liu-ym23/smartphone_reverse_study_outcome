package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l0<T> implements Observer {
    public final /* synthetic */ s0 a;

    public l0(s0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Long r10 = (Long) r1;
        s0.h0(this.a);
    }
}

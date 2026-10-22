package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z1<T> implements Observer {
    public final /* synthetic */ b2 a;

    public z1(b2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        if (((Boolean) r10).booleanValue() == false) goto L6;
        b2.e0(this.a).getFirstUnCheckSpecY().g(Integer.valueOf(b2.d0(this.a).getUncheckSpecOffset()));
        return;
    }
}

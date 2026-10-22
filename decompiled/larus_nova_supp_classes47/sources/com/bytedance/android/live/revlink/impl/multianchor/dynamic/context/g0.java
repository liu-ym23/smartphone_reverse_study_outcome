package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0<T> implements Consumer {
    public final /* synthetic */ k0 a;

    public g0(k0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        this.a.e.setValue(r3);
        this.a.u.setValue(k0.l(r3.booleanValue()));
    }
}

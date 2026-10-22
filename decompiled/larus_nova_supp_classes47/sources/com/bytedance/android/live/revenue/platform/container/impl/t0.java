package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0<T> implements Consumer {
    public final /* synthetic */ RpcMethodImpl a;

    public t0(RpcMethodImpl r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.d = (String) r2;
    }
}

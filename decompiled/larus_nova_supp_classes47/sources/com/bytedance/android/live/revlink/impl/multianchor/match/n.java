package com.bytedance.android.live.revlink.impl.multianchor.match;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ MultiPkMatchWidget a;

    public n(MultiPkMatchWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.k = false;
    }
}

package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ h a;

    public c(d r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        this.a.onFailed();
    }
}

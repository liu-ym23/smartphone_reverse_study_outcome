package com.bytedance.android.live.revlink.impl.multianchor.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ p a;

    public k(p r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        p r0 = this.a;
        r0.c = false;
        p.a(r0, (Throwable) r3);
    }
}

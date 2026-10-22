package com.bytedance.android.live.broadcastgame;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ a a;

    public i(a r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        a.c(this.a);
    }
}

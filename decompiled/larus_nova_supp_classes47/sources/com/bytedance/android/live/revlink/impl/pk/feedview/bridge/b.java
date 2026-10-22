package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ FeedPkBridgePresenter a;

    public b(FeedPkBridgePresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.c("timeUp");
    }
}

package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ FollowMVIViewModel a;

    public g(FollowMVIViewModel r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.u = false;
    }
}

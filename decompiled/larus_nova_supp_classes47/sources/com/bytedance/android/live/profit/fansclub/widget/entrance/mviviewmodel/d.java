package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.live.profit.fansclub.widget.entrance.EntranceUtilsKt;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ FollowMVIViewModel a;
    public final /* synthetic */ m b;

    public d(FollowMVIViewModel r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.profit.fansclub.e r6 = (com.bytedance.android.live.profit.fansclub.e) r5;
        if (((com.bytedance.android.live.profit.fansclub.e) this.b.getValue()).a == 0) goto L6;
        this.a.K0(EntranceUtilsKt.a());
        return;
    }
}

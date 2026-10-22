package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ v a;

    public y(v r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        jy0.b.d("ScoreboardBannerController", "banner width after layout: " + r4);
        this.a.c.s().a(r4);
    }
}

package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ ScoreboardExternalServiceFacade a;
    public final /* synthetic */ long b;

    public k0(ScoreboardExternalServiceFacade r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        j.a r5 = (j.a) r4;
        jy0.b.d("ScoreboardServiceFacade", "banner state changed: " + r5);
        this.a.d.onNext(TuplesKt.to(Long.valueOf(this.b), r5));
    }
}

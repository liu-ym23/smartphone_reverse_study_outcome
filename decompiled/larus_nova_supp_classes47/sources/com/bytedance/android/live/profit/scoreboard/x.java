package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x<T, R> implements Function {
    public final /* synthetic */ ScoreboardBannerView a;

    public x(ScoreboardBannerView r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Unit) r2, "it");
        return Integer.valueOf(this.a.getWidth());
    }
}

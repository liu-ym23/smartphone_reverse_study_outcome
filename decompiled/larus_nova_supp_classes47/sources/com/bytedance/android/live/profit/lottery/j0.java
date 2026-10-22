package com.bytedance.android.live.profit.lottery;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0<T, R> implements Function {
    public final /* synthetic */ long a;

    public j0(long r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        Intrinsics.checkNotNullParameter((Long) r5, "it");
        v.c r6 = v.a;
        return v.a(this.a, false, LotteryApi.QueryFrom.ClientPoll, 10).toObservable().filter(h0.a).onErrorResumeNext(Observable.empty()).map(i0.a);
    }
}

package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q1<T> implements Predicate {
    public final /* synthetic */ LotteryState.a a;

    public q1(LotteryState.a r1) {
        this.a = r1;
    }

    public final boolean test(Object r5) {
        e1 r6 = (e1) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        if (r6.a != this.a.a.a) goto L5;
        return true;
    L5:
        return false;
    }
}

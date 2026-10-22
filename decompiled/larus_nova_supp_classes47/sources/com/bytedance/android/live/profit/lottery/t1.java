package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t1<T> implements Predicate {
    public final /* synthetic */ LotteryState.a a;
    public final /* synthetic */ Lottery b;

    public t1(LotteryState.a r1, Lottery r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean test(Object r5) {
        e1 r6 = (e1) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        if (r6.a == this.a.a.a) goto L5;
    L7:
        return false;
    L5:
        if ((this.b.getState() instanceof LotteryState.a) == false) goto L7;
        return true;
    }
}

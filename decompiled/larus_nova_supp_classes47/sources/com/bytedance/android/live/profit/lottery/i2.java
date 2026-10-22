package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i2<T> implements Predicate {
    public final /* synthetic */ LotteryRepository a;

    public i2(LotteryRepository r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        Intrinsics.checkNotNullParameter((s) r2, "it");
        ParticipateStatus r3 = (ParticipateStatus) this.a.g.a;
        if (r3 != ParticipateStatus.PARTICIPATED) goto L5;
    L8:
        return true;
    L5:
        if (r3 == ParticipateStatus.PARTICIPATEINSUCCESS) goto L8;
        return false;
    }
}

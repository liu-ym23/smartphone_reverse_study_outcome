package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0<T> implements Predicate {
    public final /* synthetic */ Long a;

    public t0(Long r1) {
        this.a = r1;
    }

    public final boolean test(Object r5) {
        dv0.k r6 = (dv0.k) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        long r0 = r6.getRoundId();
        Long r7 = this.a;
        if (r7 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0 != r7.longValue()) goto L8;
        return true;
    }
}

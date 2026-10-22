package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0<T> implements Predicate {
    public final /* synthetic */ long a;

    public o0(long r1) {
        this.a = r1;
    }

    public final boolean test(Object r5) {
        dv0.h r6 = (dv0.h) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        if (r6.getRoomId() != this.a) goto L5;
        return true;
    L5:
        return false;
    }
}

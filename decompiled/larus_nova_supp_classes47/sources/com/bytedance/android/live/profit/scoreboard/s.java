package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s<T> implements Predicate {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    public final boolean test(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        com.bytedance.android.live.profit.scoreboard.dto.d r7 = ((com.bytedance.android.live.profit.scoreboard.dto.m) ((ExtraResponse) r6).data).getCounterInfo();
        if (r7 == null) goto L5;
        long r2 = r7.getActualFinishTime();
    L7:
        if (r2 > 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r2 = 0;
        goto L7
    }
}

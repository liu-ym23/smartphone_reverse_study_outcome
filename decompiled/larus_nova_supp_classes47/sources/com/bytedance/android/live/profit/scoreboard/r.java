package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Predicate {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final boolean test(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        if (((com.bytedance.android.live.profit.scoreboard.dto.m) ((ExtraResponse) r6).data).getCounterInfo() == null) goto L9;
        com.bytedance.android.live.profit.scoreboard.dto.d r7 = ((com.bytedance.android.live.profit.scoreboard.dto.m) ((ExtraResponse) r6).data).getCounterInfo();
        if (r7 != null) goto L7;
    L8:
        return true;
    L7:
        if (r7.getCounterId() != 0) goto L8;
    L9:
        return false;
    }
}

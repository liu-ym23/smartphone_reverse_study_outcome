package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u<T, R> implements Function {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public final Object apply(Object r2) {
        com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (com.bytedance.android.live.profit.scoreboard.dto.g) ((ExtraResponse) r3).data;
    }
}

package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T1, T2> implements BiPredicate {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final boolean test(Object r4, Object r5) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r6 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r4;
        com.ss.ugc.live.sdk.message.wrsc.data.a r7 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r5;
        Intrinsics.checkNotNullParameter(r6, "old");
        Intrinsics.checkNotNullParameter(r7, "new");
        if (r6.a != r7.a) goto L5;
        return true;
    L5:
        return false;
    }
}

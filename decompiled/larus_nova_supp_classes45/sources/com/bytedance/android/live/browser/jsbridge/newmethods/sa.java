package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class sa<T1, T2> implements BiPredicate {
    public static final sa a = null;

    static {
        a = new sa();
    }

    public sa() {
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

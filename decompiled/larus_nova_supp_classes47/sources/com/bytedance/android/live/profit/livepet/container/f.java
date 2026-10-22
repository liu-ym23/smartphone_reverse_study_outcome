package com.bytedance.android.live.profit.livepet.container;

import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T1, T2> implements BiPredicate {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final boolean test(Object r3, Object r4) {
        i32.a r5 = (i32.a) r3;
        i32.a r6 = (i32.a) r4;
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r6, "b");
        if (r5.a == r6.a) goto L5;
    L7:
        return false;
    L5:
        if (r5.b != r6.b) goto L7;
        return true;
    }
}

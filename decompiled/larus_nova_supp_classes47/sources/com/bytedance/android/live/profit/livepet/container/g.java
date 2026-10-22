package com.bytedance.android.live.profit.livepet.container;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T, R> implements Function {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r2) {
        i32.a r3 = (i32.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Integer.valueOf(r3.b + r3.a);
    }
}

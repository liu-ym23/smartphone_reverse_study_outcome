package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Predicate {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final boolean test(Object r2) {
        h80.c r3 = (h80.c) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.b();
    }
}

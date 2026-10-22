package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import io.reactivex.functions.Function4;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T1, T2, T3, T4, R> implements Function4 {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2, Object r3, Object r4, Object r5) {
        Intrinsics.checkNotNullParameter((Unit) r2, "unit");
        Intrinsics.checkNotNullParameter((Unit) r3, "unit1");
        Intrinsics.checkNotNullParameter((Unit) r4, "unit2");
        Intrinsics.checkNotNullParameter((Unit) r5, "unit3");
        return Boolean.TRUE;
    }
}

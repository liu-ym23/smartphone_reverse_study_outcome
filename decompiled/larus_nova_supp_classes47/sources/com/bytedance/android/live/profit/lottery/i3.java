package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i3<T, R> implements Function {
    public static final i3 a = null;

    static {
        a = new i3();
    }

    public i3() {
    }

    public final Object apply(Object r2) {
        k3 r3 = (k3) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.c;
    }
}

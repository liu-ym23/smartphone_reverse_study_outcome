package com.bytedance.android.live.profit.redpacket;

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
        k1 r3 = (k1) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.c;
    }
}

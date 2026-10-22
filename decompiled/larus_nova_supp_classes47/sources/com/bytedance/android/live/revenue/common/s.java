package com.bytedance.android.live.revenue.common;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s<K, V> {
    public final K a;
    public final Function0<V> b;

    /* JADX WARN: Multi-variable type inference failed */
    public s(K r2, Function0<? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "fallbackValue");
        this.a = r2;
        this.b = r3;
    }
}

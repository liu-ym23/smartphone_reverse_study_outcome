package com.bytedance.android.live.revenue.common;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w<K, V> {
    public final K a;
    public final Function0<V> b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(K r2, Function0<? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "fallbackValue");
        this.a = r2;
        this.b = r3;
    }

    public final V a(Map<K, ? extends V> r2, KProperty<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        V r4 = r2.get(this.a);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return (V) this.b.invoke();
    }

    public final void b(Map<K, V> r2, KProperty<?> r3, V r4) {
        Intrinsics.checkNotNullParameter(r2, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        r2.put(this.a, r4);
    }
}

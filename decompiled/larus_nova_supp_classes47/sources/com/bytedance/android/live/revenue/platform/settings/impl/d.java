package com.bytedance.android.live.revenue.platform.settings.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements ReadOnlyProperty {
    public final Function0<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "getValue");
        this.a = r2;
    }

    public final T getValue(Object r1, KProperty<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "property");
        return (T) this.a.invoke();
    }
}

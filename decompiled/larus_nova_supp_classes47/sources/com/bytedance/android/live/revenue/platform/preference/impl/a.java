package com.bytedance.android.live.revenue.platform.preference.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements com.bytedance.tools.kcp.spongepreference.runtime.a<T> {
    public final Function0<T> a;
    public final Function1<T, Unit> b;
    public final Function0<Unit> c;

    public final T getValue(Object r1, KProperty<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "property");
        return (T) this.a.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends T> r2, Function1<? super T, Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "getValue");
        Intrinsics.checkNotNullParameter(r3, "setValue");
        Intrinsics.checkNotNullParameter(r4, "_clearValue");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void setValue(Object r1, KProperty<?> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "property");
        this.b.invoke(r3);
    }
}

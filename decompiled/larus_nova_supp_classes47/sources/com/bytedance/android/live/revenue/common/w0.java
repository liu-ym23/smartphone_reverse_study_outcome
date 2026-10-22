package com.bytedance.android.live.revenue.common;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w0<T> {
    public final Function2<String, T, T> a;
    public final Function2<String, T, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public w0(Function2<? super String, ? super T, ? extends T> r2, Function2<? super String, ? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "read");
        Intrinsics.checkNotNullParameter(r3, "write");
        this.a = r2;
        this.b = r3;
    }
}

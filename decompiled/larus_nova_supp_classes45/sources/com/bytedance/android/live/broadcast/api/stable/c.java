package com.bytedance.android.live.broadcast.api.stable;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> extends AbsAnchorFactor<T> {
    public final String b;
    public final Function0<T> c;

    @Override // com.bytedance.android.live.broadcast.api.stable.AbsAnchorFactor
    public final T b() {
        return (T) this.c.invoke();
    }

    @Override // com.bytedance.android.live.broadcast.api.stable.AbsAnchorFactor
    public final String a() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r2, Function0<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "valueGetter");
        this.b = r2;
        this.c = r3;
    }
}

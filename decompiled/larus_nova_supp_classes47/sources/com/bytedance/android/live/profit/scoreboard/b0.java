package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0<T, R> implements Function {
    public final /* synthetic */ v a;

    public b0(v r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Unit) r2, "it");
        return com.bytedance.android.live.core.arch.mvvm.f.b(this.a.c.n());
    }
}

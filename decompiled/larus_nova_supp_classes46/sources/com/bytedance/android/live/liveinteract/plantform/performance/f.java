package com.bytedance.android.live.liveinteract.plantform.performance;

import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ String a;

    public f(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        d0 r3 = (d0) r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        return TuplesKt.to(this.a, r3);
    }
}

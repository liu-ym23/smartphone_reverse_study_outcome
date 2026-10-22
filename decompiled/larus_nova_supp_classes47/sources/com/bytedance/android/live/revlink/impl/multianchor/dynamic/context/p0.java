package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0<T, R> implements Function {
    public final /* synthetic */ o0 a;

    public p0(o0 r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        k31.f r3 = (k31.f) r2;
        Intrinsics.checkNotNullParameter(r3, "seiCache");
        return this.a.j(r3);
    }
}

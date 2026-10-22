package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s0<T, R> implements Function {
    public final /* synthetic */ RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 a;

    public s0(RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Integer r3 = (Integer) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return o0.i(this.a.b, r3.intValue());
    }
}

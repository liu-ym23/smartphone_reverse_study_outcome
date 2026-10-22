package com.bytedance.android.live.revlink.impl.pk.feedview;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T, R> implements Function {
    public final /* synthetic */ o a;

    public m(o r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Integer r4 = (Integer) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        o r0 = this.a;
        return q.a(r4, r0.b, r0.c);
    }
}

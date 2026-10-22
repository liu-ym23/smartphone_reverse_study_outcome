package com.bytedance.android.live.profit.vote.ui;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ com.bytedance.android.live.profit.vote.b a;

    public j(com.bytedance.android.live.profit.vote.b r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((Long) r3, "it");
        return Long.valueOf(MathKt.roundToLong(this.a.a() / 1000.0f));
    }
}

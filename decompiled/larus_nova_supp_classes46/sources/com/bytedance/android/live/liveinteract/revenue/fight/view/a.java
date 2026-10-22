package com.bytedance.android.live.liveinteract.revenue.fight.view;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T, R> implements Function {
    public final /* synthetic */ long a;

    public a(long r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        Long r6 = (Long) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        return Long.valueOf(this.a - r6.longValue());
    }
}

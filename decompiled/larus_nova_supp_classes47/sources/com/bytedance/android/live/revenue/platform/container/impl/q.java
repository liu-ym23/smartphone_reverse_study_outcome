package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.functions.Predicate;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Predicate {
    public final /* synthetic */ Set a;

    public q(Set r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        m.a r3 = (m.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return this.a.contains(r3.b);
    }
}

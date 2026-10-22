package com.bytedance.ies.argus.strategy;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f5141b;

    public f(e r5) {
        Intrinsics.checkNotNullParameter(r5, "depend");
        this.f5140a = r5;
        this.f5141b = LazyKt.lazy(new StrategyCalculateHandler$clientStrategyProviderMap$2(this));
    }
}

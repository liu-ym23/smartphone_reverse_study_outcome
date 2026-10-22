package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ DynamicHostNetworkServiceImpl a;
    public final /* synthetic */ Function1 b;

    public d(DynamicHostNetworkServiceImpl r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r5) {
        stc.b r6 = (stc.b) r5;
        Intrinsics.checkNotNullParameter(r6, "groupedObs");
        return r6.distinctUntilChanged(j.a).sample(this.a.c.getWrdsMethodSamplingIntervalMs(), TimeUnit.MILLISECONDS).map(new c(r6)).observeOn(Schedulers.io(), false, 2);
    }
}

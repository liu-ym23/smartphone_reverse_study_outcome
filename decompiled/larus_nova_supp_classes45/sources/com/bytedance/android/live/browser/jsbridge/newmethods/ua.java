package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ua<T, R> implements Function {
    public final /* synthetic */ wa a;

    public ua(wa r1) {
        this.a = r1;
    }

    public final Object apply(Object r8) {
        stc.b r9 = (stc.b) r8;
        Intrinsics.checkNotNullParameter(r9, "groupedObs");
        return r9.distinctUntilChanged(sa.a).sample(this.a.f.getWrdsMethodSamplingIntervalMs(), TimeUnit.MILLISECONDS, Schedulers.io(), true).map(new ta(r9)).observeOn(Schedulers.io(), false, 2);
    }
}

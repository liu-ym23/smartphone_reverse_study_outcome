package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0<T, R> implements Function {
    public static final m0 a = null;

    static {
        a = new m0();
    }

    public m0() {
    }

    public final Object apply(Object r2) {
        j57.a r3 = (j57.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        Observable r4 = r3.a;
        int r0 = com.bytedance.revenue.platform.api.core.rx.p.a;
        return r4.subscribeOn(Schedulers.computation());
    }
}

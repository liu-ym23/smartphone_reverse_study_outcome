package com.bytedance.android.live.revenue.common.reactive;

import com.bytedance.revenue.platform.api.core.rx.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T, R> implements Function {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        T r4 = r3.a;
        if (r4 == null) goto L5;
        l r0 = l.a;
        return Observable.just(r4);
    L5:
        l r5 = l.a;
        return Observable.empty();
    }
}

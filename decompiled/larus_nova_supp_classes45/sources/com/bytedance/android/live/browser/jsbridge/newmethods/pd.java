package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class pd<T, R> implements Function {
    public static final pd a = null;

    static {
        a = new pd();
    }

    public pd() {
    }

    public final Object apply(Object r2) {
        Flowable r3 = (Flowable) r2;
        Intrinsics.checkNotNullParameter(r3, "throwableFlowable");
        return r3.flatMap(od.a);
    }
}

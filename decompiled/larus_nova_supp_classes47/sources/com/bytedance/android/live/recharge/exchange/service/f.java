package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.recharge.exchange.model.AutoExchangeStatus;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T, R> implements Function {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r2) {
        Integer r3 = (Integer) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        int r0 = AutoExchangeStatus.Open.getValue();
        if (r3.intValue() != r0) goto L5;
        boolean r4 = true;
    L7:
        return Boolean.valueOf(r4);
    L5:
        r4 = false;
        goto L7
    }
}

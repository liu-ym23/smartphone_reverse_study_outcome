package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ long a;

    public l(long r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        long r0 = ((Number) r5).longValue();
        return Long.valueOf(this.a - r0);
    }
}

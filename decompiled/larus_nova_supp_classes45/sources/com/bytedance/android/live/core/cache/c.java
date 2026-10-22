package com.bytedance.android.live.core.cache;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class c implements Function {
    public /* synthetic */ c() {
    }

    public final Object apply(Object r1) {
        return Integer.valueOf(r1.hashCode());
    }
}

package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.platform.model.DiamondExtraListResult;
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
        ExtraResponse r3 = (ExtraResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (DiamondExtraListResult) r3.data;
    }
}

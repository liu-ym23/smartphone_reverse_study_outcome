package com.bytedance.android.live.revenue.platform.network.dynamic;

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
        com.ss.ugc.live.sdk.message.wrsc.data.a r3 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.g;
    }
}

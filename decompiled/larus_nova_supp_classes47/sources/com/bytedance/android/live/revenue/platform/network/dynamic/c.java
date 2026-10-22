package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ stc.b a;

    public c(stc.b r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r4 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        return new Pair(this.a.a, r4);
    }
}

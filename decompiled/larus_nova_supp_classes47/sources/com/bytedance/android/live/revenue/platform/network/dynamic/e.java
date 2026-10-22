package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public e(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r3 = (com.ss.ugc.live.sdk.message.wrsc.data.a) ((Pair) r2).component2();
        this.a.invoke(r3);
    }
}

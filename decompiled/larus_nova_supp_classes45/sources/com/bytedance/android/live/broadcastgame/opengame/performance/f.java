package com.bytedance.android.live.broadcastgame.opengame.performance;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public f(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        com.bytedance.android.live.network.response.e r2 = (com.bytedance.android.live.network.response.e) r1;
        this.a.invoke();
    }
}

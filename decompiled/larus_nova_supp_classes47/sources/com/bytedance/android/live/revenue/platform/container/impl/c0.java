package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ d0 a;

    public c0(d0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.finishWithFailure(r4);
        ALogger.e("RpcJsBridgeImpl", "invoke method fail " + r4);
    }
}

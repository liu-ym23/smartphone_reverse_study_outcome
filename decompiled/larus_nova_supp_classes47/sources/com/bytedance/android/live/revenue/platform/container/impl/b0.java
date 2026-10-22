package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ com.bytedance.platform.aio.channel.js.model.e b;

    public b0(d0 r1, com.bytedance.platform.aio.channel.js.model.e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        this.a.finishWithResult(Unit.INSTANCE);
        ALogger.e("RpcJsBridgeImpl", "invoke method success " + this.b);
    }
}

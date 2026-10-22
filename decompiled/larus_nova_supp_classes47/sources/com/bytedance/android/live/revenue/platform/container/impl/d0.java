package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 extends wy0.a<com.bytedance.platform.aio.channel.js.model.e, Unit> {
    public Disposable a;
    public final /* synthetic */ com.bytedance.platform.aio.channel.js.b b;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public d0(com.bytedance.platform.aio.channel.js.b<Object, Object> r1) {
        this.b = r1;
    }

    public final void invoke(Object r2, CallContext r3) {
        com.bytedance.platform.aio.channel.js.model.e r4 = (com.bytedance.platform.aio.channel.js.model.e) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        ALogger.e("RpcJsBridgeImpl", "receive message" + r4);
        this.a = this.b.invoke(r4).subscribe(new b0(this, r4), new c0(this));
    }
}

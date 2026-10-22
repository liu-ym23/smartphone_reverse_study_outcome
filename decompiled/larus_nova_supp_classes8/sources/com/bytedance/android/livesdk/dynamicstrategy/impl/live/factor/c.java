package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends DynamicFactor<Long> {
    public static final c b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "device_id";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        b = new c();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Long b() {
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L9;
        String r1 = r0.getServerDeviceId();
        if (r1 == null) goto L9;
        Long r2 = StringsKt.toLongOrNull(r1);
        if (r2 == null) goto L9;
        long r3 = r2.longValue();
    L11:
        return Long.valueOf(r3);
    L9:
        r3 = 0;
        goto L11
    }

    public c() {
    }
}

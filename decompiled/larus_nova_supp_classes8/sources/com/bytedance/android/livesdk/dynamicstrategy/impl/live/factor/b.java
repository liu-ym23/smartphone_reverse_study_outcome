package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends DynamicFactor<String> {
    public static final b b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "channel";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        b = new b();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String b() {
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L6;
        String r1 = r0.getChannel();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public b() {
    }
}

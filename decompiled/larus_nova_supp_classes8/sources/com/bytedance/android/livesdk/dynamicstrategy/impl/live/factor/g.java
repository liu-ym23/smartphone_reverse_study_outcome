package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends DynamicFactor<Integer> {
    public static final g b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "version_code";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        b = new g();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L9;
        String r1 = r0.getVersionCode();
        if (r1 == null) goto L9;
        Integer r2 = StringsKt.toIntOrNull(r1);
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L11:
        return Integer.valueOf(r3);
    L9:
        r3 = 0;
        goto L11
    }

    public g() {
    }
}

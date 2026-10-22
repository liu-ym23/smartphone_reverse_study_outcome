package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.k6;
import com.bytedance.android.livesdk.l6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n extends DynamicFactor<Integer> {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_device_performance";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        if (this.b == true) goto L5;
        int r0 = ((Integer) l6.a.getValue()).intValue();
    L7:
        return Integer.valueOf(r0);
    L5:
        r0 = ((Integer) k6.a.getValue()).intValue();
        goto L7
    }

    public n(boolean r1) {
        this.b = r1;
    }
}

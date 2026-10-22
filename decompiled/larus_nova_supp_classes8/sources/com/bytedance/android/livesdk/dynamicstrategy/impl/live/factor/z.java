package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z extends DynamicFactor<Integer> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_factor_consume";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IStrategyService r0 = jc1.k.f(IStrategyService.class);
        int r1 = -1;
        if (r0 == null) goto L10;
        LiveData r2 = r0.getFactor("factor_consume", -1, false, true);
        if (r2 == null) goto L10;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L10;
        r1 = r3.intValue();
    L10:
        return Integer.valueOf(r1);
    }

    public z() {
    }
}

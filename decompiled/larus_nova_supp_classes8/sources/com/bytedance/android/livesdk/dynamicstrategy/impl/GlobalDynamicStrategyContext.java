package com.bytedance.android.livesdk.dynamicstrategy.impl;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/GlobalDynamicStrategyContext;", "Lcom/bytedance/android/livesdk/dynamicstrategy/impl/AbsDynamicStrategyContext;", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "onLoadFeatureList", "", "strategyName", "Liu1/b;", "onLoadStrategy", "<init>", "()V", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GlobalDynamicStrategyContext extends AbsDynamicStrategyContext {
    public static final GlobalDynamicStrategyContext INSTANCE = null;

    static {
        INSTANCE = new GlobalDynamicStrategyContext();
    }

    private GlobalDynamicStrategyContext() {
        super("global", IDynamicStrategyContext.Scope.GLOBAL);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.AbsDynamicStrategyContext
    public List<DynamicFactor<? extends Object>> onLoadFeatureList() {
        return a.a();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.AbsDynamicStrategyContext
    public iu1.b onLoadStrategy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "strategyName");
        return c.a(r2, null);
    }
}

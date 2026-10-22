package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import kotlin.Result;
import kotlin.ResultKt;
import r52.x1;
import r52.y1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u extends DynamicFactor<Integer> {
    public final Double b;
    public final Double c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L32
        IFeatureService r2 = jc1.k.f(IFeatureService.class);     // Catch: Throwable -> L32
        float r3 = -1.0f;
        if (r2 == null) goto L10;
        z90.a r4 = r2.getFeatureManager();     // Catch: Throwable -> L32
        if (r4 == null) goto L10;
        Float r5 = (Float) r4.getFeature("cpu_rate", Float.valueOf(-1.0f));     // Catch: Throwable -> L32
        if (r5 == null) goto L10;
        float r6 = r5.floatValue();     // Catch: Throwable -> L32
    L11:
        IFeatureService r7 = jc1.k.f(IFeatureService.class);     // Catch: Throwable -> L32
        if (r7 == null) goto L18;
        z90.a r8 = r7.getFeatureManager();     // Catch: Throwable -> L32
        if (r8 == null) goto L18;
        Float r9 = (Float) r8.getFeature("memory_available_rate", Float.valueOf(-1.0f));     // Catch: Throwable -> L32
        if (r9 == null) goto L18;
        r3 = r9.floatValue();     // Catch: Throwable -> L32
    L18:
        float r10 = 0;
        if (r6 < r10) goto L39;
        if (r3 < r10) goto L39;
        double r11 = (((double) (1 - r3)) * 0.1d) + (((double) r6) * 0.9d);     // Catch: Throwable -> L32
        if (r11 > this.b.doubleValue()) goto L27;
        return 3;
    L27:
        if (r11 > this.c.doubleValue()) goto L38;
        return 2;
    L38:
        return 1;
    L39:
        return -1;
    L10:
        r6 = -1.0f;
    L32:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return -1;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_realtime_performance";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    public u() {
        this.b = (Double) y1.a.getValue();
        this.c = (Double) x1.a.getValue();
    }
}

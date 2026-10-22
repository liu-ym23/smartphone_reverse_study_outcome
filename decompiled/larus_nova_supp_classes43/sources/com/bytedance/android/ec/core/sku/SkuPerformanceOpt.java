package com.bytedance.android.ec.core.sku;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SkuPerformanceOpt {
    public static final Lazy a = null;

    public static Map b() {
        return (Map) a.getValue();
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, SkuPerformanceOpt$performanceAB$2.INSTANCE);
    }

    public static void a() {
        Map r0 = b();
        if (r0 == null) goto L5;
        Object r1 = r0.get("ec_sku_client_opt");
    L6:
        Intrinsics.areEqual(r1, 1);
        return;
    L5:
        r1 = null;
        goto L6
    }
}

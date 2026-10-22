package com.bytedance.android.livesdk.dslservice.slice.cache;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GlobalExprParseContext {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(GlobalExprParseContext$exprCacheManager$2.INSTANCE);
        b = LazyKt.lazy(GlobalExprParseContext$exprContext$2.INSTANCE);
    }
}

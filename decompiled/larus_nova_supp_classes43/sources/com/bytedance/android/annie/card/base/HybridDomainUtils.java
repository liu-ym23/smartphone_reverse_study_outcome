package com.bytedance.android.annie.card.base;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class HybridDomainUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(HybridDomainUtils$safeHostList$2.INSTANCE);
        b = LazyKt.lazy(HybridDomainUtils$secLinkSafeList$2.INSTANCE);
    }
}

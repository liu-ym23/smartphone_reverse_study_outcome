package com.larksuite.component.universe_design.icon.compose;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDIconCatalog {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        a = LazyKt.lazy(r0, UDIconCatalog$outlined$2.INSTANCE);
        b = LazyKt.lazy(r0, UDIconCatalog$filled$2.INSTANCE);
        c = LazyKt.lazy(r0, UDIconCatalog$colorful$2.INSTANCE);
        d = LazyKt.lazy(r0, UDIconCatalog$all$2.INSTANCE);
    }
}

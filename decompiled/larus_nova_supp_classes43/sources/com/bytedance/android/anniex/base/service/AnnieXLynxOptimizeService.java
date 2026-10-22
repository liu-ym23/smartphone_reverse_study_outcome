package com.bytedance.android.anniex.base.service;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLynxOptimizeService {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(AnnieXLynxOptimizeService$lynxModelCacheMap$2.INSTANCE);
        b = LazyKt.lazy(AnnieXLynxOptimizeService$lynxViewCacheMap$2.INSTANCE);
        c = LazyKt.lazy(AnnieXLynxOptimizeService$lynxAsyncManager$2.INSTANCE);
    }

    public static HashMap a() {
        return (HashMap) a.getValue();
    }

    public static HashMap b() {
        return (HashMap) b.getValue();
    }
}

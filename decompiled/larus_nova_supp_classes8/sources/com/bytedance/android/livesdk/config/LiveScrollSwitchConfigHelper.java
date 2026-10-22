package com.bytedance.android.livesdk.config;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveScrollSwitchConfigHelper {
    public static final Lazy a = null;

    public static b81 a() {
        return (b81) a.getValue();
    }

    static {
        a = LazyKt.lazy(LiveScrollSwitchConfigHelper$config$2.INSTANCE);
    }
}

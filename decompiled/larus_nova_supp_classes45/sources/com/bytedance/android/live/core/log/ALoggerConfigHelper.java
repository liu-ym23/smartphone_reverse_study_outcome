package com.bytedance.android.live.core.log;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.log.ALoggerConfig;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ALoggerConfigHelper {
    public static boolean a;
    public static final Lazy b = null;

    public static ALoggerConfig a() {
        return (ALoggerConfig) b.getValue();
    }

    static {
        b = LazyKt.lazy(ALoggerConfigHelper$alogConfig$2.INSTANCE);
    }
}

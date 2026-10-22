package com.bytedance.android.ec.core.monitor;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECSchemaMonitor {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(ECSchemaMonitor$version$2.INSTANCE);
        b = LazyKt.lazy(ECSchemaMonitor$logData$2.INSTANCE);
    }
}

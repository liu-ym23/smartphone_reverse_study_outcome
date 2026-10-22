package com.obric.assistant.performance;

import android.os.PowerManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class b implements Function0 {
    public /* synthetic */ b() {
    }

    public final Object invoke() {
        Object r0 = AppHost.a.getApplication().getSystemService("power");     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");     // Catch: Exception -> L4
        return (PowerManager) r0;
    L4:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "init: get power manager failed", e);
        return null;
    }
}

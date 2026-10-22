package com.bytedance.android.monitorV2.executor;

import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3576a = null;

    static {
        f3576a = LazyKt.lazy(HybridMonitorSingleExecutor$singleExecutorService$2.f3570a);
    }

    public static void a(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        ((ExecutorService) f3576a.getValue()).execute(new com.bytedance.android.anniex.monitor.b(2, r5));
    }
}

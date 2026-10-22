package com.ss.android.lark.log.trace;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LogTraceWrapper {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public LogTraceWrapper() {
    }

    static {
        a = LazyKt.lazy(LogTraceWrapper$processName$2.INSTANCE);
        b = LazyKt.lazy(LogTraceWrapper$processId$2.INSTANCE);
    }

    public static void a(String r10, String r11, int r12, long r13) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, "name");
        com.bytedance.apm6.foundation.trace.a.a((String) a.getValue(), ((Number) b.getValue()).longValue(), r10, r11, r13, r12, null);
    }
}

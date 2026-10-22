package com.bytedance.android.livesdk.dsl.util;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DSLLog {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(DSLLog$isLocalTest$2.INSTANCE);
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "content");
        ALogger.i("DSL_DYNAMIC_LOG", r1);
    }
}

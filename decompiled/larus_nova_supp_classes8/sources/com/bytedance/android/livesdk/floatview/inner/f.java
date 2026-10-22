package com.bytedance.android.livesdk.floatview.inner;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        ALogger.i("InnerFloatWindowTracker", "dismiss window for reason: " + r2);
    }
}

package com.bytedance.android.livesdk.interactivity.api.asr.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.e("AnchorAsr", r1);
    }

    @JvmStatic
    public static final void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("AnchorAsr", r1);
    }

    @JvmStatic
    public static final void b(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "info");
        Intrinsics.checkNotNullParameter(r2, "t");
        ALogger.e("AnchorAsr", r1, r2);
    }
}

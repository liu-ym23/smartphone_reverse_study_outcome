package com.bytedance.android.live.core.log;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements pm0.b {
    public b() {
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ALogger.d(r2, r3);
    }

    public final void e(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        ALogger.e(r2, r3);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ALogger.i(r2, r3);
    }

    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ALogger.w(r2, r3);
    }

    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ALogger.e(r2, r3);
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        ALogger.e(r2, r3, r4);
    }

    public final void stacktrace(int r1, String r2, StackTraceElement[] r3) {
        Intrinsics.checkNotNullParameter("ttlive_exception", "tag");
        Intrinsics.checkNotNullParameter(r3, "traceElement");
        ALogger.stacktrace(6, "ttlive_exception", r3);
    }
}

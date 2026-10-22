package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "str");
        ALogger.i("ttlive_ktv", String.valueOf(r1));
    }

    public static final void b(String r2) {
        Intrinsics.checkNotNullParameter("openDialog", "tag");
        Intrinsics.checkNotNullParameter(r2, "str");
        ALogger.d("ttlive_ktv_openDialog", r2);
    }

    public static final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "str");
        ALogger.e(bb0.b.b(), "logTemp: " + r3);
    }

    public static final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "str");
        ALogger.i(bb0.b.b(), "ktv-mv: " + r3);
    }

    public static final void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "str");
        ALogger.e(bb0.b.b(), "ktv-mv: " + r3);
    }

    public static final void f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "str");
        ALogger.i("ktv-opus", r1);
    }

    public static final void g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "str");
        ALogger.i(bb0.b.b(), "logTemp: " + r3);
    }
}

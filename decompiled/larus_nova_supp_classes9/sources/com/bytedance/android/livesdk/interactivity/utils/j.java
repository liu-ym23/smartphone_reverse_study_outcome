package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements kf6.a {
    public static final j a = null;

    public j() {
    }

    public final void debug(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
    }

    public final void error(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter("CoreEngine", "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    static {
        a = new j();
    }

    @JvmStatic
    public static final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("LiveDanmaku", r1);
    }
}

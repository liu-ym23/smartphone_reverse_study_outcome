package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.fk0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        return ((Boolean) fk0.a.getValue()).booleanValue();
    }

    static {
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.e("SimpleZDanmakuUtil", r1);
    }

    public static void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("SimpleZDanmakuUtil", r1);
    }

    public static void d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("SimpleZDanmakuSetting", r1);
    }
}

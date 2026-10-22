package com.bytedance.android.live.core.tetris.widgets.cache;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(String... r11) {
        Intrinsics.checkNotNullParameter(r11, "strings");
        ALogger.i("ComponentCacheLog", String.valueOf(ArraysKt.joinToString$default(r11, ", ", null, null, 0, null, null, 62, null)));
    }

    public static void a(String r11, String... r12) {
        Intrinsics.checkNotNullParameter(r11, "logKey");
        Intrinsics.checkNotNullParameter(r12, "strings");
        ALogger.i("ComponentCacheLog", "当前操作的直播间是 ：" + ArraysKt.joinToString$default(r12, ", ", null, null, 0, null, null, 62, null) + "， 当前的路径是" + r11 + ' ');
    }

    public static void b(String r11, String... r12) {
        Intrinsics.checkNotNullParameter(r11, "logKey");
        Intrinsics.checkNotNullParameter(r12, "strings");
        if (MultiRoomConfig.INSTANCE.enableComponentCacheFullLog() == false) goto L6;
        ALogger.i("ComponentCacheLog", "当前操作的直播间是 ：" + ArraysKt.joinToString$default(r12, ", ", null, null, 0, null, null, 62, null) + "， 当前的路径是" + r11 + ' ');
        return;
    }
}

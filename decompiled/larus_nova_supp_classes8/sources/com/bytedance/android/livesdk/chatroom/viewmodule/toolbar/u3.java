package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u3 {
    public static final /* synthetic */ int a = 0;

    static {
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("ToolbarLogger", r1);
    }
}

package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayRoomFragmentScopeUtil {
    public static com.bytedance.android.livesdk.chatroom.vs_base.base.d a;
    public static final Lazy b = null;

    static {
        b = LazyKt.lazy(ReplayRoomFragmentScopeUtil$fallbackUIStateService$2.INSTANCE);
    }

    public static d0 b() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (d0) com.bytedance.android.scope.m.e.d(r0, d0.class);
    }

    public static ir1.c a(Class r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        d0 r0 = b();
        if (r0 != null) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("ReplayRoomFragmentScopeUtil", "fragment scope没enter");
        r0 = (d0) b.getValue();
    L6:
        return r0.c(r3);
    }
}

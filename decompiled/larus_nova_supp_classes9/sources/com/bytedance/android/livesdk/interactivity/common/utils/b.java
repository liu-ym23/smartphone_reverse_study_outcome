package com.bytedance.android.livesdk.interactivity.common.utils;

import am2.x;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b {
    public b() {
    }

    public static /* synthetic */ void b() {
        a("livesdk_livevip_word_to_emoji_show", BaseAppLogger$sendEvent$1.INSTANCE);
    }

    public static void a(String r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "paramsBuilder");
        HashMap r0 = new HashMap();     // Catch: Exception -> L5
        r5.invoke(r0);     // Catch: Exception -> L5
        j0.l().sendLog(r4, r0, new Object[]{new x(), IRoom.class});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SafetyGuard.a(null, e, "BaseAppLogger");
    }
}

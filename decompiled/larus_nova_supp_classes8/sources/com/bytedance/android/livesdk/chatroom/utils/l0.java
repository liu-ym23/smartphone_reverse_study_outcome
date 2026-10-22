package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(long r2, boolean r4) {
        Intrinsics.checkNotNullParameter("live_take_detail", "page");
        HashMap r0 = new HashMap();
        r0.put("duration", String.valueOf(r2));
        if (r4 == false) goto L5;
        String r3 = "1";
    L6:
        r0.put("is_righten", r3);
        b("livesdk_live_take_high_temperature_degrade_result", r0);
        return;
    L5:
        r3 = "0";
        goto L6
    }

    public static void b(String r4, HashMap r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "logMap");
        Intrinsics.checkNotNullParameter("live_take_detail", "eventPage");
        r5.put("event_page", "live_take_detail");
        if (Intrinsics.areEqual("live_take_detail", "live_take_page") == false) goto L6;
        r5.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        com.bytedance.android.livesdk.log.u.l().sendLog(r4, r5, new Object[0]);
        return;
    L6:
        if (Intrinsics.areEqual("live_take_detail", "live_take_detail") == false) goto L10;
        com.bytedance.android.livesdk.log.u.l().sendLog(r4, r5, new Object[]{Room.class});
        return;
    }
}

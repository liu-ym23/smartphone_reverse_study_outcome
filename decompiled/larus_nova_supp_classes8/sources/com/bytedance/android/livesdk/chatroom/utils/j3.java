package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.nu;
import com.bytedance.android.livesdk.config.q21;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j3 {
    public static void a(long r2, long r4, String r6) {
    L10:
        th = move-exception;
        ALogger.e("enterRoom", "error report " + th.toString());
        return;
    L3:
        if (q21.a() == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - r4;     // Catch: Throwable -> L10
        HashMap r5 = new HashMap();     // Catch: Throwable -> L10
        r5.put("api_time_cost", String.valueOf(r0));     // Catch: Throwable -> L10
        r5.put("api_status", r6);     // Catch: Throwable -> L10
        r5.put("room_id", String.valueOf(r2));     // Catch: Throwable -> L10
        r5.put("business_type", "room_enter");     // Catch: Throwable -> L10
        String r3 = "old";
        if (nu.a.getValue().booleanValue() == false) goto L8;
        r3 = "new";
    L8:
        r5.put("api_version", r3);     // Catch: Throwable -> L10
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_interface_request_duration", r5, new Object[0]);     // Catch: Throwable -> L10
    }
}

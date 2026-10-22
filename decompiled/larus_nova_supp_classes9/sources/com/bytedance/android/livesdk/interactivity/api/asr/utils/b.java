package com.bytedance.android.livesdk.interactivity.api.asr.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static String c(boolean r0) {
        if (r0 == false) goto L4;
        return "on";
    L4:
        return "off";
    }

    public static String a() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        m r1 = r0.getRoom();
        if (r1 == null) goto L10;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L10;
        String r3 = r2.getIdStr();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return "0";
    }

    static {
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "triggerType");
        HashMap r0 = new HashMap();
        r0.put("room_id", a());
        r0.put("trigger_type", r3);
        u.l().sendLog("livesdk_anchor_voice_recognition_fail", r0, new Object[0]);
    }
}

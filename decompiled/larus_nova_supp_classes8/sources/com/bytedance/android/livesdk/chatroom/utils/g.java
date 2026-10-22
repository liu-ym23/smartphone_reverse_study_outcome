package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements com.bytedance.android.livesdk.chatroom.j {
    public static final g a = null;

    public g() {
    }

    static {
        a = new g();
    }

    public final void a(DataCenter r6, Bundle r7) {
        if (r7 == null) goto L19;
        if (r6 == null) goto L19;
        Bundle r1 = com.bytedance.android.livesdk.chatroom.m0.a(r7);
        if (r1 == null) goto L19;
        Bundle r2 = r1.getBundle("copy_extra");
        if (Logger.debug() == false) goto L16;
        StringBuilder r3 = new StringBuilder("save:");
        if (r2 == null) goto L14;
        String r4 = r2.toString();
    L15:
        r3.append(r4);
        Logger.d("BackToRoomDataUtils", r3.toString());
        goto L16
    L14:
        r4 = "null";
    L16:
        if (r2 == null) goto L19;
        r2.remove("live.intent.extra.BACK_PRE_ROOM_EXTRA");
        r6.put("data_room_back_extra", r2);
    L19:
        if (r7 == null) goto L42;
        if (r6 == null) goto L45;
        Bundle r0 = r7.getBundle("live.intent.extra.BACK_PRE_ROOM_EXTRA");
        if (r0 == null) goto L43;
        boolean r5 = false;
        if (r0.getBoolean("can_go_back", false) == false) goto L46;
        Bundle r8 = com.bytedance.android.livesdk.chatroom.m0.a(r7);
        if (r8 == null) goto L32;
        r5 = r8.getBoolean("live.intent.extra.IS_BACK_PRE_ROOM_NOW", false);
    L32:
        if ("draw".equals(r7.getString("live.intent.extra.ENTER_TYPE")) == false) goto L35;
        r6.put("data_room_back", null);
    L39:
        if (r8 == null) goto L44;
        r6.put("data_back_to_pre_room_countdown_dismiss", Boolean.valueOf(r8.getBoolean("data_back_to_pre_room_countdown_dismiss", true)));
        return;
    L44:
        return;
    L35:
        if (tb1.c.a == false) goto L39;
        if (r5 == false) goto L38;
        r0 = null;
    L38:
        r6.put("data_room_back", r0);
        goto L39
    L46:
        return;
    L43:
        return;
    L45:
        return;
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import am2.x;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    static {
    }

    public static void a(kj r4) {
        HashMap r0 = new HashMap();
        if (r4 == null) goto L6;
        String r1 = String.valueOf(r4.s());
        if (r1 == null) goto L6;
    L7:
        r0.put("type", r1);
        if (r4 == null) goto L11;
        String r2 = r4.getContent();
        if (r2 == null) goto L11;
    L12:
        r0.put("content", r2);
        String r3 = "0";
        if (r4 == null) goto L16;
        String r5 = String.valueOf(r4.noticeTime);
        if (r5 == null) goto L16;
    L17:
        r0.put("notice_time", r5);
        if (r4 == null) goto L23;
        String r6 = String.valueOf(r4.version);
        if (r6 == null) goto L23;
        r3 = r6;
    L23:
        r0.put("version", r3);
        u.l().sendLog("livesdk_live_notice_info_show", r0, new Object[]{Room.class, new x()});
        return;
    L16:
        r5 = "0";
    L11:
        r2 = "";
    L6:
        r1 = "-1";
        goto L7
    }
}

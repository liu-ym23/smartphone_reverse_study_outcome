package com.bytedance.android.live.liveinteract.voicechat.emoji;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r3, int r4) {
        if (r3 == false) goto L5;
        ALogger.e("interact_emoji", "stop self emoji of fromPos " + r4);
    L7:
        if (hd0.c.f().g() == false) goto L9;
        return;
    L9:
        int r0 = x.a;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r3 == false) goto L12;
        String r5 = "from_seat";
    L13:
        r1.put("seat_type", r5);
        r1.put("pos", Integer.valueOf(r4));
        x.v0("stop_seat_emoji", r1);
        return;
    L12:
        r5 = "to_seat";
        goto L13
    L5:
        ALogger.e("interact_emoji", "stop self emoji of toPos " + r4);
        goto L7
    }
}

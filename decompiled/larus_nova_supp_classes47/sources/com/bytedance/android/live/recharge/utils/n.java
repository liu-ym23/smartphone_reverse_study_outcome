package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n {
    public n() {
    }

    public static String a() {
        int r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene();
        if (r0 != 4) goto L5;
    L11:
        return "video_live";
    L5:
        if (r0 != 5) goto L7;
    L10:
        return "voice_live";
    L7:
        if (r0 == 12) goto L11;
        switch(r0) {
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L10;
            default: goto L9;
        };
    L9:
        return "";
    }

    static {
    }

    public static void b(Map r6) {
        Integer r0 = Integer.valueOf(vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene());
        Intrinsics.checkNotNullParameter(r6, "logMap");
        if (r0 != null) goto L6;
    L14:
        if (r0 != null) goto L17;
    L19:
        if (r0 != null) goto L22;
    L24:
        if (r0 != null) goto L27;
    L29:
        if (r0 != null) goto L32;
    L34:
        if (r0 != null) goto L37;
        return;
    L37:
        if (r0.intValue() != 12) goto L48;
        r6.put("function_type", "party");
        return;
    L48:
        return;
    L32:
        if (r0.intValue() != 4) goto L34;
        r6.put("function_type", "audience");
        return;
    L27:
        if (r0.intValue() != 10) goto L29;
        r6.put("function_type", "watch");
        return;
    L22:
        if (r0.intValue() != 9) goto L24;
        r6.put("function_type", "ktv");
        return;
    L17:
        if (r0.intValue() != 8) goto L19;
        r6.put("function_type", "radio");
        return;
    L6:
        if (r0.intValue() != 5) goto L14;
        r6.put("function_type", "radio");
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L40;
        IRoom r2 = r1.getRoom();
        if (r2 != null) goto L12;
        return;
    L12:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).X1(r2) == false) goto L42;
        r6.put("function_type", "party");
        return;
    L42:
        return;
    }

    public static void c(Map r2) {
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene();
        Intrinsics.checkNotNullParameter(r2, "logMap");
        r2.put("live_type", a());
    }
}

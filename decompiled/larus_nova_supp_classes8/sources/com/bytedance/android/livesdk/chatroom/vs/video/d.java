package com.bytedance.android.livesdk.chatroom.vs.video;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.paid.PaidPrivilegeItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(DataCenter r7) {
        long r0 = -1;
        if (r7 == null) goto L7;
        Long r4 = (Long) r7.get("video_start_play_ts", -1L);
        if (r4 == null) goto L7;
        r0 = r4.longValue();
    L7:
        long r5 = 0;
        if (r0 <= 0) goto L10;
        r5 = (System.currentTimeMillis() - r0) / ((long) BubbleId.PadCast);
    L10:
        b(r7, "livesdk_vs_right_video_play_time", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(r5))}));
        if (r7 == null) goto L14;
        r7.put("video_start_play_ts", -1L);
        return;
    }

    public static void b(DataCenter r2, String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        PaidPrivilegeItem r0 = null;
        if (r2 == null) goto L5;
        r0 = (PaidPrivilegeItem) r2.get("paid_privilege_item", null);
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        if (r0 == null) goto L9;
        Map r5 = r0.getExtraLogMap();
        if (r5 == null) goto L9;
    L10:
        r1.putAll(r5);
        if (r4 != null) goto L13;
        r4 = new LinkedHashMap();
    L13:
        r1.putAll(r4);
        String r6 = "";
        if (r2 == null) goto L19;
        String r7 = (String) r2.get("current_playing_video_id", "");
        if (r7 == null) goto L19;
        r6 = r7;
    L19:
        r1.put("special_video_id", r6);
        if (r2 != null) goto L22;
    L25:
        String r8 = "portrait";
    L26:
        r1.put("screen_type", r8);
        u.l().sendLog(r3, r1, new Object[0]);
        return;
    L22:
        if (z.m(r2, true) == true) goto L25;
        r8 = "landscape";
    L9:
        r5 = new LinkedHashMap();
        goto L10
    }
}

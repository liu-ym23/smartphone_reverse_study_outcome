package com.bytedance.android.livesdk.clearscreen.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final f b = null;

    public f() {
    }

    static {
        b = new f();
        a = new com.bytedance.android.livesdk.log.b("TrialLiveInjector", null);
    }

    public final void Rd() {
        a.a("added");
    }

    public final void onRemove() {
        a.a("removed");
    }

    public final void L9(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        switch(r5.hashCode()) {
            case -1122536402: goto L63;
            case -1115849514: goto L60;
            case -1103263308: goto L57;
            case -804282046: goto L54;
            case -597919004: goto L51;
            case -546689387: goto L48;
            case -505186085: goto L45;
            case 21313630: goto L42;
            case 479193863: goto L39;
            case 516631638: goto L36;
            case 516908681: goto L33;
            case 963627730: goto L30;
            case 1059589542: goto L27;
            case 1499179894: goto L24;
            case 1499265855: goto L21;
            case 1744840954: goto L18;
            case 1763681274: goto L15;
            case 2009019068: goto L12;
            case 2022034541: goto L9;
            case 2041791848: goto L6;
            default: goto L95;
        };
    L95:
        return;
    L6:
        if (r5.equals("livesdk_like") == false) goto L75;
    L64:
        Integer r3 = null;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L71;
        m r8 = r7.getRoom();
        if (r8 == null) goto L71;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L71;
        r3 = Integer.valueOf(r9.getVisibilityRange());
    L71:
        if (r3 == null) goto L73;
        r6.put("visibility_range", String.valueOf(r3.intValue()));
    L73:
        a.a("inject visibility_range: " + r3);
        return;
    L75:
        return;
    L9:
        if (r5.equals("livesdk_watch_onemin") == true) goto L64;
        return;
    L12:
        if (r5.equals("livesdk_recharge_success") == true) goto L64;
        return;
    L15:
        if (r5.equals("livesdk_live_window_duration_v2") == true) goto L64;
        return;
    L18:
        if (r5.equals("livesdk_send_barrage") == true) goto L64;
        return;
    L21:
        if (r5.equals("livesdk_live_show") == true) goto L64;
        return;
    L24:
        if (r5.equals("livesdk_live_play") == true) goto L64;
        return;
    L27:
        if (r5.equals("livesdk_live_user_report") == true) goto L64;
        return;
    L30:
        if (r5.equals("livesdk_report_submit") == true) goto L64;
        return;
    L33:
        if (r5.equals("livesdk_send_prop") == true) goto L64;
        return;
    L36:
        if (r5.equals("livesdk_send_gift") == true) goto L64;
        return;
    L39:
        if (r5.equals("livesdk_rec_live_play") == true) goto L64;
        return;
    L42:
        if (r5.equals("livesdk_audience_live_message") == true) goto L64;
        return;
    L45:
        if (r5.equals("livesdk_unfollow") == true) goto L64;
        return;
    L48:
        if (r5.equals("livesdk_live_user_report_submit_success") == true) goto L64;
        return;
    L51:
        if (r5.equals("livesdk_live_click_user") == true) goto L64;
        return;
    L54:
        if (r5.equals("livesdk_follow") == true) goto L64;
        return;
    L57:
        if (r5.equals("livesdk_dislike") == true) goto L64;
        return;
    L60:
        if (r5.equals("livesdk_live_duration") == true) goto L64;
        return;
    L63:
        if (r5.equals("livesdk_share") == true) goto L64;
    }
}

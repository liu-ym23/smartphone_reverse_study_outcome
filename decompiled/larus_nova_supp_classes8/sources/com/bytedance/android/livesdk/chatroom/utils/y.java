package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y implements com.bytedance.android.livesdk.log.filter.v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final y b = null;

    public y() {
    }

    static {
        b = new y();
        a = new com.bytedance.android.livesdk.log.b("FromRequestIdInjector", null);
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
            case -1837102167: goto L33;
            case -1122536402: goto L30;
            case -1115849514: goto L27;
            case -1103263308: goto L24;
            case -804282046: goto L21;
            case 21313630: goto L18;
            case 516631638: goto L15;
            case 1499179894: goto L12;
            case 1499265855: goto L9;
            case 2041791848: goto L6;
            default: goto L51;
        };
    L51:
        return;
    L6:
        if (r5.equals("livesdk_like") == false) goto L41;
    L34:
        String r3 = null;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L39;
        com.bytedance.live.datacontext.j r8 = r7.getFromRequestId();
        if (r8 == null) goto L39;
        r3 = (String) r8.getValue();
    L39:
        r6.put("from_request_id", r3);
        a.a("inject from_request_id " + r3);
        return;
    L41:
        return;
    L9:
        if (r5.equals("livesdk_live_show") == true) goto L34;
        return;
    L12:
        if (r5.equals("livesdk_live_play") == true) goto L34;
        return;
    L15:
        if (r5.equals("livesdk_send_gift") == true) goto L34;
        return;
    L18:
        if (r5.equals("livesdk_audience_live_message") == true) goto L34;
        return;
    L21:
        if (r5.equals("livesdk_follow") == true) goto L34;
        return;
    L24:
        if (r5.equals("livesdk_dislike") == true) goto L34;
        return;
    L27:
        if (r5.equals("livesdk_live_duration") == true) goto L34;
        return;
    L30:
        if (r5.equals("livesdk_share") == true) goto L34;
        return;
    L33:
        if (r5.equals("livesdk_fans_club_join_success") == true) goto L34;
    }
}

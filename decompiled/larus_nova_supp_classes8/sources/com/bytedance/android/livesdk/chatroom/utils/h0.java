package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h0 implements com.bytedance.android.livesdk.log.filter.v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final h0 b = null;

    public h0() {
    }

    static {
        b = new h0();
        a = new com.bytedance.android.livesdk.log.b("IsLifeInjector", null);
    }

    public final void Rd() {
        a.a("added");
    }

    public final void onRemove() {
        a.a("removed");
    }

    public final void L9(String r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r14, "eventName");
        Intrinsics.checkNotNullParameter(r15, "params");
        Integer r4 = null;
        switch(r14.hashCode()) {
            case -1837102167: goto L30;
            case -1122536402: goto L27;
            case -1115849514: goto L24;
            case -1103263308: goto L21;
            case -804282046: goto L18;
            case 21313630: goto L15;
            case 516631638: goto L12;
            case 1499179894: goto L9;
            case 2041791848: goto L6;
            default: goto L45;
        };
    L6:
        if (r14.equals("livesdk_like") == false) goto L45;
    L31:
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L42;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L42;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L42;
        RoomSpecificSceneTypeInfo r3 = r2.getSceneTypeInfo();
        if (r3 == null) goto L42;
        if (r3.isLife() != true) goto L42;
        String r5 = "1";
    L43:
        r15.put("is_life", r5);
        a.a("inject is_life ".concat(r5));
    L42:
        r5 = "0";
        goto L43
    L9:
        if (r14.equals("livesdk_live_play") == false) goto L45;
    L12:
        if (r14.equals("livesdk_send_gift") == false) goto L45;
    L15:
        if (r14.equals("livesdk_audience_live_message") == false) goto L45;
    L18:
        if (r14.equals("livesdk_follow") == false) goto L45;
    L21:
        if (r14.equals("livesdk_dislike") == false) goto L45;
    L24:
        if (r14.equals("livesdk_live_duration") == false) goto L45;
    L27:
        if (r14.equals("livesdk_share") == false) goto L45;
    L30:
        if (r14.equals("livesdk_fans_club_join_success") == true) goto L31;
    L45:
        switch(r14.hashCode()) {
            case -1115849514: goto L60;
            case -804282046: goto L57;
            case 21313630: goto L54;
            case 1499179894: goto L51;
            case 2041791848: goto L48;
            default: goto L90;
        };
    L90:
        return;
    L48:
        if (r14.equals("livesdk_like") == false) goto L85;
    L61:
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r16 == null) goto L66;
        com.bytedance.live.datacontext.m r17 = r16.getRoom();
        if (r17 == null) goto L66;
        Room r18 = (Room) r17.getValue();
    L67:
        int r6 = com.bytedance.android.live.core.utils.h1.a;
        if (r18 == null) goto L72;
        IBaseStreamUrl r19 = r18.getStreamUrl();
        if (r19 == null) goto L72;
        r4 = Integer.valueOf(r19.getStreamOrientation());
    L72:
        if (r4 != null) goto L75;
    L77:
        if (r4 != null) goto L80;
    L82:
        String r110 = "";
    L83:
        r15.put("room_screen_type", r110);
        return;
    L80:
        if (r4.intValue() != 2) goto L82;
        r110 = "horizontal";
        goto L83
    L75:
        if (r4.intValue() != 1) goto L77;
        r110 = "vertical";
    L66:
        r18 = null;
        goto L67
    L85:
        return;
    L51:
        if (r14.equals("livesdk_live_play") == true) goto L61;
        return;
    L54:
        if (r14.equals("livesdk_audience_live_message") == true) goto L61;
        return;
    L57:
        if (r14.equals("livesdk_follow") == true) goto L61;
        return;
    L60:
        if (r14.equals("livesdk_live_duration") == true) goto L61;
    }
}

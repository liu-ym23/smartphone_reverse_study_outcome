package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i4 implements com.bytedance.android.livesdk.log.filter.v {
    public static final i4 a = null;

    public i4() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new i4();
    }

    public final void L9(String r13, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r13, "eventName");
        Intrinsics.checkNotNullParameter(r14, "params");
        String r4 = null;
        String r7 = "1";
        boolean r10 = true;
        boolean r11 = false;
        switch(r13.hashCode()) {
            case -1837102167: goto L93;
            case -1122536402: goto L90;
            case -1115849514: goto L87;
            case -1103263308: goto L84;
            case -804282046: goto L81;
            case -597919004: goto L78;
            case -505186085: goto L75;
            case 21313630: goto L72;
            case 123315088: goto L69;
            case 479193863: goto L66;
            case 516631638: goto L63;
            case 1059589542: goto L60;
            case 1060883835: goto L57;
            case 1230001277: goto L18;
            case 1763681274: goto L15;
            case 1866074004: goto L12;
            case 2022034541: goto L9;
            case 2041791848: goto L6;
            default: goto L141;
        };
    L141:
        return;
    L6:
        if (r13.equals("livesdk_like") == false) goto L119;
    L94:
        RoomContext r15 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r15 == null) goto L114;
        com.bytedance.live.datacontext.m r16 = r15.getRoom();
        if (r16 == null) goto L114;
        Room r17 = (Room) r16.getValue();
        if (r17 == null) goto L114;
        RoomOthersData r18 = r17.others;
        if (r18 == null) goto L114;
        IAnchorTogetherLive r19 = r18.getAnchorTogetherLive();
        if (r19 == null) goto L114;
        if (r19.getLiveTogetherStatus() != 1) goto L112;
        List r110 = r19.getTogetherAnchor();
        if (r110 == null) goto L109;
        int r111 = r110.size();
    L110:
        if (r111 <= 0) goto L112;
    L113:
        r11 = r10;
        goto L114
    L109:
        r111 = 0;
    L112:
        r10 = false;
    L114:
        if (r11 == true) goto L117;
        r7 = "0";
    L117:
        r14.put("is_group_co_rec", r7);
        return;
    L119:
        return;
    L9:
        if (r13.equals("livesdk_watch_onemin") == true) goto L94;
        return;
    L12:
        if (r13.equals("livesdk_group_live_member_list_entrance") == true) goto L94;
        return;
    L15:
        if (r13.equals("livesdk_live_window_duration_v2") == true) goto L94;
        return;
    L18:
        if (r13.equals("livesdk_gift_show_change_click") == false) goto L123;
        RoomContext r112 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r112 == null) goto L37;
        com.bytedance.live.datacontext.m r113 = r112.getRoom();
        if (r113 == null) goto L37;
        Room r114 = (Room) r113.getValue();
        if (r114 == null) goto L37;
        RoomOthersData r115 = r114.others;
        if (r115 == null) goto L37;
        IAnchorTogetherLive r116 = r115.getAnchorTogetherLive();
        if (r116 == null) goto L37;
        if (r116.getLiveTogetherStatus() != 1) goto L37;
        List r117 = r116.getTogetherAnchor();
        if (r117 == null) goto L34;
        int r118 = r117.size();
    L35:
        if (r118 <= 0) goto L37;
        boolean r119 = true;
    L38:
        if (r119 == true) goto L41;
        r7 = "0";
    L41:
        r14.put("is_group_co_rec", r7);
        com.bytedance.android.livesdk.log.filter.o r120 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r120 instanceof com.bytedance.android.livesdk.log.filter.n0) == true) goto L44;
        r120 = null;
    L44:
        com.bytedance.android.livesdk.log.filter.n0 r121 = (com.bytedance.android.livesdk.log.filter.n0) r120;
        if (r121 == null) goto L124;
        String r122 = r121.D();
        if (r122 != null) goto L49;
        return;
    L49:
        if (r122.length() > 0) goto L52;
        r10 = false;
    L52:
        if (r10 == false) goto L54;
        r4 = r122;
    L54:
        if (r4 == null) goto L126;
        r14.put("group_member_id", r4);
        return;
    L126:
        return;
    L124:
        return;
    L34:
        r118 = 0;
    L37:
        r119 = false;
        goto L38
    L123:
        return;
    L57:
        if (r13.equals("livesdk_gift_show") == true) goto L94;
        return;
    L60:
        if (r13.equals("livesdk_live_user_report") == true) goto L94;
        return;
    L63:
        if (r13.equals("livesdk_send_gift") == true) goto L94;
        return;
    L66:
        if (r13.equals("livesdk_rec_live_play") == true) goto L94;
        return;
    L69:
        if (r13.equals("livesdk_gift_show_send_show") == true) goto L94;
        return;
    L72:
        if (r13.equals("livesdk_audience_live_message") == true) goto L94;
        return;
    L75:
        if (r13.equals("livesdk_unfollow") == true) goto L94;
        return;
    L78:
        if (r13.equals("livesdk_live_click_user") == true) goto L94;
        return;
    L81:
        if (r13.equals("livesdk_follow") == true) goto L94;
        return;
    L84:
        if (r13.equals("livesdk_dislike") == true) goto L94;
        return;
    L87:
        if (r13.equals("livesdk_live_duration") == true) goto L94;
        return;
    L90:
        if (r13.equals("livesdk_share") == true) goto L94;
        return;
    L93:
        if (r13.equals("livesdk_fans_club_join_success") == true) goto L94;
    }
}

package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.lz;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements com.bytedance.android.livesdk.log.filter.v {
    public static long a;
    public static final Map<String, String> b = null;
    public static final a0 c = null;

    public a0() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        c = new a0();
        b = new LinkedHashMap();
    }

    public static String a() {
        IGiftCoreService r0 = jc1.k.f(IGiftCoreService.class);
        if (r0 != null) goto L5;
    L7:
        return "0";
    L5:
        if (r0.checkGroupContainerType(6) != true) goto L7;
        return "1";
    }

    public final void b(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        Long r3 = null;
        if (r0 == true) goto L11;
        r10 = null;
    L11:
        if (r10 == null) goto L28;
        LiveSeiUtil.i.getClass();
        JSONObject r11 = LiveSeiUtil.c(r10).optJSONObject("group_live");
        if (r11 == null) goto L29;
        JSONObject r1 = r11.optJSONObject("extra");
        if (r1 == null) goto L30;
        Long r2 = Long.valueOf(r1.optLong("ts"));
        if (r2.longValue() <= a) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L22;
        r3 = r2;
    L22:
        if (r3 == null) goto L31;
        long r5 = r3.longValue();
        JSONObject r12 = r11.optJSONObject("game_event_params");
        if (r12 == null) goto L32;
        Map<? extends String, ? extends String> r13 = com.bytedance.ies.bullet.prefetchv2.i.b(r12);
        a = r5;
        Map<String, String> r6 = b;
        ((LinkedHashMap) r6).clear();
        r6.putAll(r13);
        com.bytedance.android.livesdk.log.u.l().d("livesdk_group_live_playmode_watch", new Object[]{IRoom.class, am2.x.class});
        return;
    L32:
        return;
    L31:
        return;
    L19:
        r4 = false;
        goto L20
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L6:
        r0 = false;
        goto L7
    }

    public final void L9(String r17, Map<String, String> r18) {
        Intrinsics.checkNotNullParameter(r17, "eventName");
        Intrinsics.checkNotNullParameter(r18, "params");
        switch(r17.hashCode()) {
            case -1837102167: goto L66;
            case -1303580119: goto L63;
            case -1122536402: goto L60;
            case -1115849514: goto L57;
            case -1103263308: goto L54;
            case -804282046: goto L51;
            case -597919004: goto L48;
            case -505186085: goto L45;
            case 21313630: goto L42;
            case 123315088: goto L39;
            case 479193863: goto L36;
            case 516631638: goto L33;
            case 1059589542: goto L30;
            case 1060883835: goto L27;
            case 1230001277: goto L24;
            case 1499179894: goto L21;
            case 1763681274: goto L18;
            case 1858986729: goto L15;
            case 1866074004: goto L12;
            case 2022034541: goto L9;
            case 2041791848: goto L6;
            default: goto L158;
        };
    L6:
        if (r17.equals("livesdk_like") == false) goto L158;
    L67:
        RoomContext.a r2 = RoomContext.Companion;
        Map<? extends String, ? extends String> r6 = null;
        RoomContext r10 = RoomContext.a.c(r2, null, 0, 3);
        if (r10 == null) goto L74;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L74;
        Room r12 = (Room) r11.getValue();
        if (r12 == null) goto L74;
        long r13 = r12.getRoomId();
    L75:
        RoomContext r14 = RoomContext.a.c(r2, null, 0, 3);
        if (r14 == null) goto L84;
        com.bytedance.live.datacontext.m r15 = r14.getRoom();
        if (r15 == null) goto L84;
        Room r16 = (Room) r15.getValue();
        if (r16 == null) goto L84;
        User r19 = r16.getOwner();
        if (r19 == null) goto L84;
        String r110 = r19.getIdString();
    L85:
        RoomContext r111 = RoomContext.a.c(r2, null, 0, 3);
        if (r111 == null) goto L97;
        com.bytedance.live.datacontext.m r112 = r111.getRoom();
        if (r112 == null) goto L97;
        Room r113 = (Room) r112.getValue();
        if (r113 == null) goto L97;
        RoomOthersData r114 = r113.others;
        if (r114 == null) goto L97;
        IGroupLiveData r115 = r114.getGroupData();
        if (r115 == null) goto L97;
        String r116 = String.valueOf(r115.isGroupLive());
        if (r116 == null) goto L97;
    L98:
        r18.put("is_grouped_lived", r116);
        RoomContext r3 = RoomContext.a.c(r2, null, 0, 3);
        boolean r9 = false;
        if (r3 == null) goto L109;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L109;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L109;
        RoomOthersData r7 = r5.others;
        if (r7 == null) goto L109;
        IGroupLiveData r8 = r7.getGroupData();
        if (r8 == null) goto L109;
        int r20 = r8.getGroupLiveMode();
    L110:
        r18.put("is_union_battle", String.valueOf(r20));
        r18.put("is_gift_menu_on", a());
        r18.put("group_live_mode", String.valueOf(r20));
        if (((Boolean) lz.a.getValue()).booleanValue() == false) goto L121;
        IGroupLiveService r21 = jc1.k.f(IGroupLiveService.class);
        if (r21 == null) goto L154;
        Map<? extends String, ? extends String> r22 = r21.getCloudCollaborateExtraParams(r13);
        if (r22 == null) goto L154;
        if ((!r22.isEmpty()) == false) goto L119;
        r6 = r22;
    L119:
        if (r6 == null) goto L154;
        r18.putAll(r6);
    L154:
        Map<String, String> r23 = b;
        if ((!r23.isEmpty()) == false) goto L158;
        r18.putAll(r23);
        goto L158
    L121:
        IGroupLiveService r24 = jc1.k.f(IGroupLiveService.class);
        if (r24 == null) goto L135;
        String r25 = r24.getAnchorIdBeforeJump();
        if (r25 == null) goto L135;
        if (r25.length() <= 0) goto L128;
        boolean r117 = true;
    L129:
        if (r117 == false) goto L135;
        if ((!Intrinsics.areEqual(r25, "0")) == false) goto L135;
        if ((!Intrinsics.areEqual(r110, r25)) == false) goto L135;
        String r26 = "1";
    L136:
        r18.put("is_link_screen_co_rec", r26);
        Map<? extends String, ? extends String> r27 = (IGroupLiveService) jc1.k.f(IGroupLiveService.class);
        if (r27 == null) goto L154;
        if (r27.getAnchorIdBeforeJump().length() <= 0) goto L141;
        boolean r118 = true;
    L142:
        if (r118 == true) goto L144;
    L150:
        if (r9 == false) goto L152;
        r6 = r27;
    L152:
        if (r6 == null) goto L154;
        r18.put("throw_user_id", r6.getAnchorIdBeforeJump());
        r18.put("throw_room_id", String.valueOf(r6.getRoomIdBeforeJump()));
        r18.put("link_screen_request_id", r6.getRequestIdBeforeJump());
        goto L154
    L144:
        if ((!Intrinsics.areEqual(r27.getAnchorIdBeforeJump(), "0")) == false) goto L150;
        if (r27.getRoomIdBeforeJump() <= 0) goto L150;
        if ((!Intrinsics.areEqual(r110, r27.getAnchorIdBeforeJump())) == false) goto L150;
        r9 = true;
        goto L150
    L141:
        r118 = false;
        goto L142
    L128:
        r117 = false;
    L135:
        r26 = "0";
    L109:
        r20 = 0;
    L97:
        r116 = "0";
    L84:
        r110 = null;
    L74:
        r13 = 0;
        goto L75
    L9:
        if (r17.equals("livesdk_watch_onemin") == false) goto L158;
    L12:
        if (r17.equals("livesdk_group_live_member_list_entrance") == false) goto L158;
    L15:
        if (r17.equals("livesdk_profile_card_function_click") == false) goto L158;
    L18:
        if (r17.equals("livesdk_live_window_duration_v2") == false) goto L158;
    L21:
        if (r17.equals("livesdk_live_play") == false) goto L158;
    L24:
        if (r17.equals("livesdk_gift_show_change_click") == false) goto L158;
    L27:
        if (r17.equals("livesdk_gift_show") == false) goto L158;
    L30:
        if (r17.equals("livesdk_live_user_report") == false) goto L158;
    L33:
        if (r17.equals("livesdk_send_gift") == false) goto L158;
    L36:
        if (r17.equals("livesdk_rec_live_play") == false) goto L158;
    L39:
        if (r17.equals("livesdk_gift_show_send_show") == false) goto L158;
    L42:
        if (r17.equals("livesdk_audience_live_message") == false) goto L158;
    L45:
        if (r17.equals("livesdk_unfollow") == false) goto L158;
    L48:
        if (r17.equals("livesdk_live_click_user") == false) goto L158;
    L51:
        if (r17.equals("livesdk_follow") == false) goto L158;
    L54:
        if (r17.equals("livesdk_dislike") == false) goto L158;
    L57:
        if (r17.equals("livesdk_live_duration") == false) goto L158;
    L60:
        if (r17.equals("livesdk_share") == false) goto L158;
    L63:
        if (r17.equals("livesdk_group_live_playmode_watch") == false) goto L158;
    L66:
        if (r17.equals("livesdk_fans_club_join_success") == true) goto L67;
    L158:
        if (r17.hashCode() != 1060883835) goto L166;
        if (r17.equals("livesdk_gift_show") == false) goto L166;
        r18.put("is_gift_menu_on", a());
        Map<String, String> r28 = b;
        if ((!r28.isEmpty()) == false) goto L166;
        r18.putAll(r28);
    L166:
        if (r17.hashCode() == 1499265855) goto L169;
        return;
    L169:
        if (r17.equals("livesdk_live_show") == false) goto L172;
        r18.put("is_gift_menu_on", a());
        return;
    }
}

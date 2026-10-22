package com.bytedance.android.live.anchormodelink.util;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import iy.g;
import java.util.Map;
import java.util.Set;
import je0.d;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements v {
    public static final Set<String> a = null;
    public static final b b = null;

    public b() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        b = new b();
        a = SetsKt.setOf(new String[]{"livesdk_live_play", "livesdk_watch_onemin", "livesdk_live_click_user", "livesdk_rec_live_play", "livesdk_live_duration", "livesdk_follow", "livesdk_unfollow", "livesdk_share", "livesdk_audience_live_message", "livesdk_fans_club_join_success", "livesdk_profile_card_function_click", "livesdk_like", "livesdk_gift_show", "livesdk_gift_show_send_show", "livesdk_gift_show_change_click", "livesdk_send_gift", "livesdk_dislike", "livesdk_live_user_report", "livesdk_group_live_playmode_watch", "livesdk_group_live_member_list_entrance", "livesdk_live_window_duration_v2", "livesdk_live_show"});
    }

    public final void L9(String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "params");
        Long r0 = null;
        IRoom r1 = d.e(null);
        if (r1 == null) goto L17;
        Map r3 = r1.getLinkMap();
        if (r3 == null) goto L17;
        if (r3.containsKey(String.valueOf(20)) != true) goto L17;
        r8.put("is_new_video_link", GamePromoteDataContext.GAME_TYPE_MOBILE);
        z5 r4 = r1.getLinkerDetail();
        if (r4 == null) goto L13;
        String r5 = r4.getFunctionType2();
        if (r5 == null) goto L13;
        r8.put("function_type", r5);
        r8.put("function_type2", r5);
    L13:
        z5 r6 = r1.getLinkerDetail();
        if (r6 == null) goto L17;
        r8.put("layout_type_x", String.valueOf(r6.getUiLayout()));
    L17:
        if (a.contains(r7) == false) goto L28;
        g r9 = com.bytedance.android.live.anchormodelink.linkroom.a.a(null);
        if (r9 == null) goto L28;
        Map<String, String> r11 = r9.to(r7);
        if (r11 == null) goto L28;
        if ((!r11.isEmpty()) == true) goto L26;
        r11 = null;
    L26:
        if (r11 == null) goto L28;
        r8.putAll(r11);
    L28:
        if (r1 == null) goto L67;
        IRoomOthersData r12 = r1.getRoomOthers();
        if (r12 == null) goto L68;
        IChangeRoomInfo r13 = r12.getChangeRoomInfo();
        if (r13 != null) goto L34;
        return;
    L34:
        if (r13.getChangeRoomReason() != 1) goto L70;
        IRoomOthersData r14 = r1.getRoomOthers();
        if (r14 == null) goto L40;
        IChangeRoomInfo r15 = r14.getChangeRoomInfo();
        if (r15 == null) goto L40;
        long r16 = r15.getBeforeAnchorId();
    L42:
        if (r16 <= 0) goto L71;
        IRoomOthersData r17 = r1.getRoomOthers();
        if (r17 == null) goto L48;
        IChangeRoomInfo r18 = r17.getChangeRoomInfo();
        if (r18 == null) goto L48;
        long r19 = r18.getBeforeRoomId();
    L50:
        if (r19 <= 0) goto L72;
        IRoomOthersData r21 = r1.getRoomOthers();
        if (r21 == null) goto L56;
        IChangeRoomInfo r22 = r21.getChangeRoomInfo();
        if (r22 == null) goto L56;
        Long r23 = Long.valueOf(r22.getBeforeAnchorId());
    L57:
        r8.put("throw_user_id", String.valueOf(r23));
        IRoomOthersData r24 = r1.getRoomOthers();
        if (r24 == null) goto L62;
        IChangeRoomInfo r25 = r24.getChangeRoomInfo();
        if (r25 == null) goto L62;
        r0 = Long.valueOf(r25.getBeforeRoomId());
    L62:
        r8.put("throw_room_id", String.valueOf(r0));
        String r26 = r8.get("request_id");
        if (r26 != null) goto L65;
        r26 = "";
    L65:
        r8.put("link_screen_request_id", r26);
        return;
    L56:
        r23 = null;
        goto L57
    L72:
        return;
    L48:
        r19 = 0;
        goto L50
    L71:
        return;
    L40:
        r16 = 0;
        goto L42
    L70:
        return;
    L68:
        return;
    }
}

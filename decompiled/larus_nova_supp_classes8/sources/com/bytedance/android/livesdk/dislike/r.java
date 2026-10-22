package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.i1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r {
    static {
    }

    @JvmStatic
    public static final void a(Room r4, boolean r5, Map<String, String> r6) {
        HashMap r0 = new HashMap();
        r0.put("layer_show_page", "live_detail");
        r0.put("event_page", "live_detail");
        Boolean r1 = null;
        if (r4 == null) goto L5;
        Long r2 = Long.valueOf(r4.id);
    L6:
        r0.put("room_id", String.valueOf(r2));
        if (r4 == null) goto L9;
        String r7 = r4.getOwnerUserIdString();
    L10:
        r0.put("anchor_id", String.valueOf(r7));
        Boolean r8 = Boolean.valueOf(r5);
        if (r8.booleanValue() == false) goto L13;
        r1 = r8;
    L13:
        if (r1 == null) goto L17;
        r1.booleanValue();
        if (r6 == null) goto L17;
        r0.putAll(r6);
    L17:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_click_trans_layer", r0, new Object[]{am2.x.class, Room.class});
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void b(Room r9, DataCenter r10, Map<String, String> r11, boolean r12, Map<String, String> r13) {
        if (r12 == false) goto L7;
        if (r9 == null) goto L7;
        if (r9.getLiveRoomMode() != 5) goto L7;
        return;
    L7:
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r3 = "";
        if (r0.getMap().containsKey("enter_from_merge") == false) goto L10;
        String r1 = (String) r0.getMap().get("enter_from_merge");
    L12:
        if (r0.getMap().containsKey("enter_method") == false) goto L14;
        String r4 = (String) r0.getMap().get("enter_method");
    L16:
        if (r0.getMap().containsKey("action_type") == false) goto L18;
        String r6 = (String) r0.getMap().get("action_type");
    L20:
        if (tb1.c.a == false) goto L22;
        r1 = k1.c();
    L22:
        HashMap r8 = new HashMap();
        r8.put("enter_from_merge", r1);
        r8.put("enter_method", r4);
        r8.put("action_type", r6);
        r8.put("share_platform", "long_press");
        r8.put("event_page", "live_detail");
        if (r11 != null) goto L25;
    L30:
        Boolean r14 = Boolean.valueOf(r12);
        if (r14.booleanValue() == true) goto L35;
        r14 = null;
    L35:
        if (r14 == null) goto L50;
        r14.booleanValue();
        if (r13 == null) goto L39;
        r8.putAll(r13);
    L39:
        r8.put("action_type", "click");
        if (r9 == null) goto L42;
        String r15 = String.valueOf(r9.getRoomId());
    L43:
        r8.put("room_id", r15);
        if (r9 == null) goto L48;
        String r16 = r9.getAnchorId();
        if (r16 == null) goto L48;
    L49:
        r8.put("anchor_id", r16);
    L48:
        r16 = null;
        goto L49
    L42:
        r15 = null;
    L50:
        String r17 = (String) r0.getMap().get("is_second_label");
        if (r17 == null) goto L54;
        r3 = r17;
    L54:
        r8.put("is_second_label", r3);
        if (r11 == null) goto L57;
        String r18 = r11.get("to_user_id");
    L58:
        r8.putAll(com.bytedance.android.livesdk.locallife.g.a(r9, r18));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_share", r8, new Object[]{Room.class, am2.n.f()});
        r8.put("source", "new_long_press");
        r8.put("live_share_type", String.valueOf(LiveShareType.SHARE_IM.ordinal()));
        r8.put("result", "1");
        r8.put("share_content", "live");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_experience_link_share_params_check", r8, new Object[]{am2.x.class, Room.class});
        int r19 = i1.a;
        if (r11 != null) goto L61;
        r11 = new LinkedHashMap();
    L61:
        i1.c(r9, r11, "press");
        if (c1.b(r10) == false) goto L64;
    L65:
        JSONObject r110 = new JSONObject();
        if (r9 != null) goto L92;
    L72:
        String r111 = null;
    L73:
        r110.put("anchor_id", String.valueOf(r111));     // Catch: JSONException -> L70
        if (r9 == null) goto L76;
        Long r20 = Long.valueOf(r9.id);     // Catch: JSONException -> L70
    L77:
        r110.put("room_id", String.valueOf(r20));     // Catch: JSONException -> L70
    L80:
        k1.f(r110);
        if (c1.b(r10) == false) goto L83;
        Map r21 = c1.e(r10);
    L84:
        ILiveDouPlusService r112 = jc1.k.n(ILiveDouPlusService.class);
        HashMap r113 = new HashMap();
        r113.put("ad_extra_data", r110.toString());
        if (r21 != null) goto L87;
    L90:
        r112.logEvent(true, "live_ad", "live_share", r113);
        return;
    L87:
        if (r21.isEmpty() == true) goto L90;
        r113.putAll(r21);
        goto L90
    L83:
        r21 = c1.f(r10);
    L70:
        e = move-exception;
        SafetyGuard.a(null, null, e.getMessage());
        goto L80
    L76:
        r20 = null;
        goto L77
    L92:
        IUser r114 = r9.author();     // Catch: JSONException -> L70
        if (r114 == null) goto L72;
        r111 = r114.getIdString();     // Catch: JSONException -> L70
        goto L73
    L64:
        if (c1.c(r10) == true) goto L65;
        return;
    L57:
        r18 = null;
        goto L58
    L25:
        if (r11.containsKey("conversation_id") == false) goto L28;
        r8.put("conversation_id", r11.get("conversation_id"));
        goto L30
    L28:
        if (r11.containsKey("to_user_id") == false) goto L30;
        r8.put("to_user_id", r11.get("to_user_id"));
        goto L30
    L18:
        r6 = "";
        goto L20
    L14:
        r4 = "";
        goto L16
    L10:
        r1 = "";
        goto L12
    }
}

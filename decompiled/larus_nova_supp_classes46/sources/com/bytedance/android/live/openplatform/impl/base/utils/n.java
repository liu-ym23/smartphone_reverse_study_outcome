package com.bytedance.android.live.openplatform.impl.base.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.utils.OpenPlatformHostInfoPresenter;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.e0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static Map b() {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = am2.n.f().d();
        boolean r3 = false;
        if (r1.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        String r5 = null;
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L117;
        r0.put("launch_from", "ad");
        r0.put("scene", LaunchParamConstant$Scene.d);
        String r4 = a();
        if ((!StringsKt.isBlank(r4)) == true) goto L15;
        r4 = null;
    L15:
        if (r4 != null) goto L17;
        r4 = "natural";
    L17:
        r0.put("is_ad_channel", r4);
        String r6 = am2.n.f().a();
        if (r6.length() <= 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == true) goto L24;
        r6 = null;
    L24:
        if (r6 == null) goto L26;
        r0.put("aid", r6);
        String r8 = (String) r0.put("ad_id", r6);
    L26:
        String r9 = am2.n.f().c();
        if (r9.length() <= 0) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == true) goto L33;
        r9 = null;
    L33:
        if (r9 == null) goto L35;
        String r11 = (String) r0.put("cid", r9);
    L35:
        r0.put("log_extra", r1);
        JSONObject r12 = new JSONObject(r1);     // Catch: JSONException -> L38
    L39:
        if (r12 == null) goto L117;
        String r13 = r12.optString("project_id");
        if (r13 != null) goto L43;
    L46:
        boolean r14 = true;
    L48:
        if ((!r14) == true) goto L51;
        r13 = null;
    L51:
        if (r13 == null) goto L53;
        String r15 = (String) r0.put("project_id", r13);
    L53:
        String r16 = r12.optString("promotion_id");
        if (r16 != null) goto L56;
    L59:
        boolean r17 = true;
    L61:
        if ((!r17) == true) goto L64;
        r16 = null;
    L64:
        if (r16 == null) goto L66;
        String r18 = (String) r0.put("promotion_id", r16);
    L66:
        String r19 = r12.optString("clickid");
        if (r19 != null) goto L69;
    L72:
        boolean r20 = true;
    L74:
        if ((!r20) == true) goto L77;
        r19 = null;
    L77:
        if (r19 == null) goto L79;
        String r21 = (String) r0.put("clickid", r19);
    L79:
        Object r22 = r12.opt("is_double_stock");
        String r23 = "1";
        if ((r22 instanceof Boolean) == false) goto L87;
        if (((Boolean) r22).booleanValue() == false) goto L84;
        Object r24 = "1";
    L85:
        r0.put("is_double_stock", r24);
    L92:
        r0.put("is_soft_ad", String.valueOf(r12.optInt("is_soft_ad")));
        String r25 = r12.optString("rit");
        String r26 = r12.optString("orit");
        if (TextUtils.isEmpty(r25) == true) goto L102;
        if (TextUtils.isEmpty(r26) == true) goto L102;
        if ((!Intrinsics.areEqual(r25, r26)) == true) goto L100;
        r23 = "0";
    L100:
        r0.put("is_blind_ad", r23);
    L102:
        if (r25.length() <= 0) goto L104;
        boolean r27 = true;
    L105:
        if (r27 == true) goto L108;
        r25 = null;
    L108:
        if (r25 == null) goto L111;
        String r28 = (String) r0.put("rit", r25);
    L111:
        if (r26.length() <= 0) goto L113;
        r3 = true;
    L113:
        if (r3 == false) goto L115;
        r5 = r26;
    L115:
        if (r5 == null) goto L117;
        r0.put("orit", r5);
        goto L117
    L104:
        r27 = false;
        goto L105
    L84:
        r24 = "0";
        goto L85
    L87:
        if ((r22 instanceof Integer) == false) goto L90;
        r0.put("is_double_stock", r22.toString());
        goto L92
    L90:
        if ((r22 instanceof String) == false) goto L92;
        r0.put("is_double_stock", r22);
        goto L92
    L69:
        if (StringsKt.isBlank(r19) == true) goto L72;
        r20 = false;
        goto L74
    L56:
        if (StringsKt.isBlank(r16) == true) goto L59;
        r17 = false;
        goto L61
    L43:
        if (StringsKt.isBlank(r13) == true) goto L46;
        r14 = false;
    L38:
        r12 = null;
        goto L39
    L29:
        r10 = false;
        goto L30
    L20:
        r7 = false;
    L117:
        return r0;
    L5:
        r2 = false;
        goto L6
    }

    public static String a() {
        if (TextUtils.isEmpty(l0.a("is_other_channel", com.bytedance.android.livesdk.log.u.l().c(am2.n.class))) == true) goto L6;
        return l0.a("is_other_channel", com.bytedance.android.livesdk.log.u.l().c(am2.n.class));
    L6:
        return l0.a("is_other_channel", com.bytedance.android.livesdk.log.u.l().c(am2.x.class));
    }

    public static String c() {
        n0 r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r0 instanceof n0) == false) goto L20;
        n0 r1 = r0;
        if (((com.bytedance.android.livesdk.log.filter.a) r1).b.containsKey("enter_from") == false) goto L8;
        String r2 = (String) ((com.bytedance.android.livesdk.log.filter.a) r1).b.get("enter_from");
    L8:
        if (((com.bytedance.android.livesdk.log.filter.a) r1).b.containsKey("source") == false) goto L10;
        String r3 = (String) ((com.bytedance.android.livesdk.log.filter.a) r1).b.get("source");
    L10:
        Map r4 = ((com.bytedance.android.livesdk.log.filter.a) r1).b;
        Map r5 = e0.a;
        if (OpenPlatformHostInfoPresenter.a() == false) goto L19;
        if (r4.containsKey("enter_from_ad_type") == false) goto L19;
        if (TextUtils.isEmpty((CharSequence) r4.get("enter_from_ad_type")) == true) goto L19;
        return (String) r4.get("enter_from_ad_type");
    L19:
        return (String) r4.get("enter_from_merge");
    L20:
        return "";
    }

    static {
    }

    public static void e(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        n0 r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r0 instanceof n0) == false) goto L17;
        n0 r1 = r0;
        String r2 = r1.h("conversation_id");
        if (r2 == null) goto L7;
        String r4 = (String) r3.put("conversation_id", r2);
    L7:
        String r5 = r1.h("from_user_id");
        if (r5 == null) goto L10;
        String r6 = (String) r3.put("from_uid", r5);
    L10:
        String r7 = r1.h("group_chat_owner_id");
        if (r7 == null) goto L13;
        String r8 = (String) r3.put("group_chat_owner_id", r7);
    L13:
        String r9 = r1.h("chat_type");
        if (r9 == null) goto L18;
        String r10 = (String) r3.put("chat_type", r9);
        return;
    L18:
        return;
    }

    public static void d(Room r6, Map r7) {
        Intrinsics.checkNotNullParameter(r7, "map");
        if (r6 == null) goto L7;
        String r0 = r6.getIdStr();
        if (r0 == null) goto L7;
        String r1 = (String) r7.put("room_id", r0);
    L7:
        if (r6 == null) goto L11;
        String r2 = r6.getRequestId();
        if (r2 == null) goto L11;
        String r3 = (String) r7.put("request_id", r2);
    L11:
        if (r6 == null) goto L14;
        String r4 = r6.getOwnerUserIdString();
        if (r4 == null) goto L14;
    L15:
        r7.put("anchor_id", r4);
        String r5 = "1";
        if (r6 == null) goto L24;
        User r8 = r6.getOwner();
        if (r8 == null) goto L24;
        if (r8.isFollowing() == false) goto L22;
        Object r9 = "1";
    L23:
        String r10 = (String) r7.put("follow_status", r9);
        goto L24
    L22:
        r9 = "0";
    L24:
        String r11 = null;
        RoomContext r12 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r12 == null) goto L35;
        com.bytedance.live.datacontext.m r13 = r12.isCleanMode();
        if (r13 == null) goto L35;
        Boolean r14 = (Boolean) r13.getValue();
        if (r14 == null) goto L35;
        if (r14.booleanValue() == true) goto L34;
        r5 = "0";
    L34:
        String r15 = (String) r7.put("if_clear_mode", r5);
    L35:
        r7.put("is_other_channel", a());
        String r16 = a();
        if ((!StringsKt.isBlank(r16)) == false) goto L38;
        r11 = r16;
    L38:
        if (r11 != null) goto L40;
        r11 = "natural";
    L40:
        r7.put("is_ad_channel", r11);
        r7.put("live_enter_method", l0.a("enter_method", com.bytedance.android.livesdk.log.u.l().c(am2.x.class)));
        r7.put("live_action_type", l0.a("action_type", com.bytedance.android.livesdk.log.u.l().c(am2.x.class)));
        r7.put("enter_method", l0.a("enter_method", com.bytedance.android.livesdk.log.u.l().c(am2.x.class)));
        r7.put("action_type", l0.a("action_type", com.bytedance.android.livesdk.log.u.l().c(am2.x.class)));
        String r17 = c();
        if (r17 == null) goto L44;
        r7.put("enter_from_merge", r17);
        return;
    L44:
        return;
    L14:
        r4 = jc1.k.n(IUserService.class).user().n();
        goto L15
    }
}

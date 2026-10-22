package jf0;

import am2.x;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.f0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.utils.d;
import com.bytedance.android.live.liveinteract.utils.g1;
import com.bytedance.android.live.liveinteract.utils.k;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodel.e;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.live.datacontext.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements k {
    public static d a;
    public static final c b = null;

    public c() {
    }

    static {
        b = new c();
    }

    public static void b() {
        HashMap r0 = new HashMap();
        if (f() == false) goto L5;
        String r1 = "radio";
    L6:
        r0.put("function_type", r1);
        r0.put("connect_type", "apply");
        k(r0);
        String r2 = tc0.c.h().F;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        String r4 = "null";
    L16:
        r0.put("application_status", r4);
        j0.l().sendLog("livesdk_guest_connection_application_add_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L15:
        r4 = "edit";
        goto L16
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = "audience";
        goto L6
    }

    public static boolean f() {
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r0 != 5) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 8) goto L10;
        if (r0 == 12) goto L10;
        return false;
    }

    public static void i() {
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L5;
        r0.put("function_type", "new_audience");
        r0.put("function_type2", "new_audience");
    L6:
        r0.put("request_page", tc0.c.h().z);
        TalkRoomLogUtils.O0(r0);
        r0.put("play_mode", u0.b());
        j0.l().sendLog("livesdk_audience_voice_room_show", r0, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L5:
        r0.put("function_type", "audience");
        r0.put("function_type2", "audience");
        goto L6
    }

    public static void n() {
        HashMap r0 = new HashMap();
        if (f() == false) goto L5;
        String r1 = "radio";
    L6:
        r0.put("function_type", r1);
        r0.put("connect_type", "apply");
        k(r0);
        String r2 = tc0.c.h().F;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        String r4 = "null";
    L16:
        r0.put("application_status", r4);
        j0.l().sendLog("livesdk_guest_connection_application_add_show", r0, new Object[]{IRoom.class, x.class});
        return;
    L15:
        r4 = "edit";
        goto L16
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = "audience";
        goto L6
    }

    public static boolean g() {
        j r0 = m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L10;
        e r1 = (e) r0.getValue();
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L10;
        List r3 = r2.b;
        if (r3 == null) goto L10;
    L12:
        return r3.contains(4);
    L10:
        r3 = CollectionsKt.emptyList();
        goto L12
    }

    public static void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        HashMap r0 = new HashMap();
        if (f() == false) goto L5;
        String r1 = "radio";
    L6:
        r0.put("function_type", r1);
        k(r0);
        r0.put("selection", r4);
        r0.put("connect_type", "apply");
        j0.l().sendLog("livesdk_guest_connection_application_edit_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r1 = "audience";
        goto L6
    }

    public static void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        HashMap r0 = new HashMap();
        r0.put("function_type", "audience");
        if (hd0.c.f().g != 1) goto L5;
        String r1 = "video";
    L6:
        r0.put("guest_connection_type", r1);
        r0.put("toast_reason", r5);
        j0.l().sendLog("livesdk_guest_connection_application_toast_show", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r1 = "voice";
        goto L6
    }

    public static void e(String r6) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        IRoom r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.getValue();
    L6:
        HashMap r3 = new HashMap();
        String r4 = "0";
        if (r2 == null) goto L10;
        String r5 = r2.getOwnerUserIdString();
        if (r5 == null) goto L10;
    L11:
        r3.put("anchor_id", r5);
        if (r2 == null) goto L17;
        String r7 = String.valueOf(r2.getId());
        if (r7 == null) goto L17;
        r4 = r7;
    L17:
        r3.put("room_id", r4);
        com.bytedance.live.datacontext.m r8 = m.i().getRoom();
        if (r8 == null) goto L20;
        r1 = (IRoom) r8.getValue();
    L20:
        r3.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n().toString());
        if (r1 == null) goto L24;
        String r9 = r1.getRequestId();
        if (r9 == null) goto L24;
    L25:
        r3.put("request_id", r9);
        j0.l().sendLog(r6, r3, new Object[]{IRoom.class, x.class});
        return;
    L24:
        r9 = "";
    L10:
        r5 = "0";
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static void k(HashMap r2) {
        if (f() == false) goto L6;
        String r0 = "live_chat";
    L9:
        r2.put("guest_connection_type", r0);
        return;
    L6:
        if (hd0.c.f().g != 1) goto L8;
        r0 = "video";
        goto L9
    L8:
        r0 = "voice";
        goto L9
    }

    public static void a(HashMap r7, d r8) {
        r7.put("live_type", "video_live");
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r0 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        String r1 = "0";
        if (r0 == null) goto L8;
        y r2 = r0.getLinkUserCenter();
        if (r2 == null) goto L8;
        String r3 = String.valueOf(je0.d.j(r2));
        if (r3 == null) goto L8;
    L9:
        r7.put("link_cnt", r3);
        r7.put("function_type", "audience");
        if (Intrinsics.areEqual(r8.b, "invite") == false) goto L12;
    L13:
        int r4 = bh0.a.a;
        r8.d = 100;
    L14:
        Map<String, String> r5 = r8.j;
        if (r5 == null) goto L20;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<String, String> r9 = r6.next();
        r7.put(r9.getKey(), r9.getValue());
    L20:
        int r10 = r8.d;
        int r11 = bh0.a.a;
        if (r10 != 101) goto L24;
        r7.put("request_page", "seat");
    L43:
        if (r8.a == true) goto L46;
        r1 = "1";
    L46:
        r7.put("is_approve_needed", r1);
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r12 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r12 == null) goto L64;
        if (r12.isEngineOn() == false) goto L64;
        r7.put("connect_type", r8.b);
        if (Intrinsics.areEqual(r8.b, "invite") == false) goto L53;
    L54:
        r7.put("from_user_id", r8.c);
        if (Intrinsics.areEqual(r8.c, r8.f) == false) goto L57;
        r7.put("from_user_type", "anchor");
    L59:
        if (Intrinsics.areEqual(r8.b, "gift_message_invite") == false) goto L64;
        IMessageBoardInfo r13 = r8.k;
        if (r13 == null) goto L64;
        r7.put("message_text", f0.a(r13));
        goto L64
    L57:
        r7.put("from_user_type", "admin");
        goto L59
    L53:
        if (Intrinsics.areEqual(r8.b, "gift_message_invite") == false) goto L59;
    L64:
        if (hd0.c.f().g != 1) goto L66;
        String r14 = "video";
    L67:
        r7.put("guest_connection_type", r14);
        return;
    L66:
        r14 = "voice";
        goto L67
    L24:
        if (r10 != 102) goto L27;
        r7.put("request_page", "bottom");
        goto L43
    L27:
        if (r10 != 103) goto L30;
        r7.put("request_page", "popup");
        goto L43
    L30:
        if (r10 != 107) goto L33;
        r7.put("request_page", "link_user_invite");
        goto L43
    L33:
        if (r10 != 113) goto L36;
        r7.put("request_page", "card");
        goto L43
    L36:
        if (r10 != 114) goto L39;
        r7.put("request_page", "live_song");
        goto L43
    L39:
        if (tc0.c.h().J == 114) goto L41;
        r7.put("request_page", "");
        goto L43
    L41:
        r7.put("request_page", "live_song");
        goto L43
    L12:
        if (Intrinsics.areEqual(r8.b, "gift_message_invite") == false) goto L14;
    L8:
        r3 = "0";
        goto L9
    }

    public static void j(IRoom r12, d r13) {
        Intrinsics.checkNotNullParameter(r13, "logParams");
        HashMap r0 = new HashMap();
        a(r0, r13);
        if (hd0.c.f().g != 1) goto L5;
        boolean r1 = true;
    L6:
        String r4 = "1";
        if (r1 == false) goto L9;
        Object r6 = "1";
    L10:
        r0.put("is_camera_open", r6);
        gk0.a.b.getClass();
        r0.put("previous_page", gk0.a.C0214a.c());
        if (fj0.e.i() == true) goto L13;
    L15:
        Object r7 = "0";
    L16:
        r0.put("is_rechargeble", r7);
        r0.put("is_full", "1");
        TalkRoomLogUtils.L0(r0);
        if (r12 == null) goto L24;
        ICircleInfo r8 = r12.getCircleInfo();
        if (r8 == null) goto L24;
        String r9 = r8.getCircleName();
        if (r9 == null) goto L24;
        r0.put("circle_name", r9);
    L24:
        if (fj0.e.i() == false) goto L44;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        int r10 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.d();
        PaidLinkMicContext r11 = PaidLinkMicContext.Companion.getContext();
        if (r11 == null) goto L32;
        com.bytedance.live.datacontext.m<Integer> r14 = r11.getDiscountMode();
        if (r14 == null) goto L32;
        Integer r15 = (Integer) r14.getValue();
        if (r15 == null) goto L32;
        int r16 = r15.intValue();
    L33:
        if (r16 == 1) goto L39;
        if (r16 == 2) goto L38;
        if (r16 == 3) goto L37;
        String r17 = "";
    L40:
        r0.put("discount_type", r17);
        l(r0, r10, r16);
        if (fj0.b.a.g == false) goto L44;
        r0.put("is_vip_recharge_privilege", "1");
        goto L44
    L37:
        r17 = "strategy";
        goto L40
    L38:
        r17 = "activity";
        goto L40
    L39:
        r17 = "vip";
    L32:
        r16 = 0;
    L44:
        if (g1.b() == false) goto L46;
        Object r18 = "1";
    L47:
        r0.put("is_priority_queue", r18);
        if (g1.b() == false) goto L54;
        n0 r19 = tc0.c.h().P;
        if (r19 == null) goto L52;
        long r20 = r19.getPaidAmount();
    L53:
        String r21 = String.valueOf(r20);
    L55:
        r0.put("pay_amt", r21);
        if (g() == false) goto L58;
        String r22 = "on";
    L59:
        r0.put("seat_fit_status", r22);
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(r1) == false) goto L62;
        r0.put("is_pre_link", "1");
    L64:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L67;
        r4 = "0";
    L67:
        r0.put("is_invite_only", r4);
        TalkRoomLogUtils.O0(r0);
        if (r0.containsValue("invite_mutual") == true) goto L70;
        r0.put("wait_time", String.valueOf(r13.l));
    L70:
        r0.put("watch_duration", String.valueOf(r13.m));
        InteractiveSongLoggerKt.b(r0);
        if (us1.e.a == false) goto L73;
        r0.put("is_from_audience", "0");
    L73:
        com.bytedance.android.live.liveinteract.utils.f0.b(r0);
        li0.b r110 = li0.b.b;
        li0.b.i(r0);
        j0.l().sendLog("livesdk_guest_connection_success", r0, new Object[]{r12, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L62:
        r0.put("is_pre_link", "0");
        goto L64
    L58:
        r22 = "off";
        goto L59
    L52:
        r20 = 0;
        goto L53
    L54:
        r21 = "0";
        goto L55
    L46:
        r18 = "0";
        goto L47
    L13:
        if (fj0.b.a.b == false) goto L15;
        r7 = "1";
        goto L16
    L9:
        r6 = "0";
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public static void m(String r3, IMessageBoardInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "refuseType");
        HashMap r0 = new HashMap();
        r0.put("function_type", "audience");
        r0.put("refuse_type", r3);
        if (r4 == null) goto L5;
        r0.put("request_page", "gift_message_panel");
        r0.put("message_text", f0.a(r4));
    L5:
        TalkRoomLogUtils.O0(r0);
        j0.l().sendLog("livesdk_guest_refuse_chat_invited", r0, new Object[]{IRoom.class, x.class});
    }

    public static void l(HashMap r3, int r4, int r5) {
        fj0.a r0 = fj0.b.a;
        int r1 = r0.h;
        int r2 = r0.i;
        if (r5 != 1) goto L6;
        int r6 = r4 - r1;
    L12:
        if (r6 < 0) goto L14;
        String r7 = String.valueOf(r6);
    L15:
        r3.put("pay_price", r7);
        return;
    L14:
        r7 = "0";
        goto L15
    L6:
        if (r5 != 2) goto L8;
    L11:
        r6 = r4 - r2;
        goto L12
    L8:
        if (r5 == 3) goto L11;
        r6 = 0;
        goto L12
    }

    public static void h(IRoom r15, String r16, d r17, long r18, long r20, Long r22, Long r23) {
        Intrinsics.checkNotNullParameter(r16, "overType");
        Intrinsics.checkNotNullParameter(r17, "logParams");
        long r2 = 0;
        if (r18 != 0) goto L5;
        return;
    L5:
        HashMap r4 = new HashMap();
        String r6 = "";
        if (Intrinsics.areEqual(r16, "limit_time_up") == false) goto L9;
        r4.put("over_type", "timeout");
    L18:
        long r9 = 1000;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r18) / r9));
        r4.put("camera_duration", String.valueOf(r20 / r9));
        gk0.a.b.getClass();
        r4.put("previous_page", gk0.a.C0214a.c());
        String r5 = "1";
        if (fj0.e.i() == true) goto L21;
    L23:
        Object r0 = "0";
    L24:
        r4.put("is_rechargeble", r0);
        r4.put("talk_duration", String.valueOf(r17.i));
        r4.put("live_type", "video_live");
        if (fj0.e.i() == false) goto L44;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        int r1 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.d();
        PaidLinkMicContext r12 = PaidLinkMicContext.Companion.getContext();
        if (r12 == null) goto L33;
        com.bytedance.live.datacontext.m<Integer> r13 = r12.getDiscountMode();
        if (r13 == null) goto L33;
        Integer r14 = (Integer) r13.getValue();
        if (r14 == null) goto L33;
        int r19 = r14.intValue();
    L34:
        if (r19 == 1) goto L40;
        if (r19 == 2) goto L39;
        if (r19 != 3) goto L41;
        r6 = "strategy";
    L41:
        r4.put("discount_type", r6);
        l(r4, r1, r19);
        if (fj0.b.a.g == false) goto L44;
        r4.put("is_vip_recharge_privilege", "1");
        goto L44
    L39:
        r6 = "activity";
        goto L41
    L40:
        r6 = "vip";
    L33:
        r19 = 0;
    L44:
        TalkRoomLogUtils.L0(r4);
        a(r4, r17);
        if (r15 == null) goto L52;
        ICircleInfo r3 = r15.getCircleInfo();
        if (r3 == null) goto L52;
        String r7 = r3.getCircleName();
        if (r7 == null) goto L52;
        r4.put("circle_name", r7);
    L52:
        if (hd0.c.f().g != 1) goto L54;
        boolean r8 = true;
    L56:
        if (g() == false) goto L58;
        Object r10 = "on";
    L59:
        r4.put("seat_fit_status", r10);
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(r8) == false) goto L62;
        r4.put("is_pre_link", "1");
    L64:
        if (fj0.e.i() == false) goto L70;
        if (fj0.e.d() == false) goto L68;
        r17.j.put("anonymous_switch", "on");
        goto L70
    L68:
        r17.j.put("anonymous_switch", "off");
    L70:
        if (g1.b() == false) goto L72;
        Object r11 = "1";
    L73:
        r4.put("is_priority_queue", r11);
        if (g1.b() == false) goto L79;
        n0 r21 = tc0.c.h().P;
        if (r21 == null) goto L78;
        r2 = r21.getPaidAmount();
    L78:
        String r24 = String.valueOf(r2);
    L80:
        r4.put("pay_amt", r24);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L84;
        r5 = "0";
    L84:
        r4.put("is_invite_only", r5);
        if (r22 == null) goto L89;
        long r25 = r22.longValue();
        if (r4.containsValue("invite_mutual") == true) goto L89;
        r4.put("wait_time", String.valueOf(r25));
    L89:
        if (r23 == null) goto L92;
        r4.put("watch_duration", String.valueOf(r23.longValue()));
    L92:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L94;
        r4.put("function_type", "new_audience");
        r4.put("function_type2", "new_audience");
    L94:
        InteractiveSongLoggerKt.b(r4);
        TalkRoomLogUtils.O0(r4);
        li0.b r26 = li0.b.b;
        li0.b.i(r4);
        j0.l().sendLog("livesdk_guest_connection_over", r4, new Object[]{r15, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L79:
        r24 = "0";
        goto L80
    L72:
        r11 = "0";
        goto L73
    L62:
        r4.put("is_pre_link", "0");
        goto L64
    L58:
        r10 = "off";
        goto L59
    L54:
        r8 = false;
        goto L56
    L21:
        if (fj0.b.a.b == false) goto L23;
        r0 = "1";
        goto L24
    L9:
        if (Intrinsics.areEqual(r16, "kick_out") == false) goto L11;
    L17:
        r4.put("over_type", "anchor");
        goto L18
    L11:
        if (Intrinsics.areEqual(r16, "live_end") == true) goto L17;
        r4.put("over_type", "audience");
        String r27 = tc0.c.h().G;
        if (r27 != null) goto L16;
        r27 = "";
    L16:
        r4.put("break_page", r27);
        goto L18
    }
}

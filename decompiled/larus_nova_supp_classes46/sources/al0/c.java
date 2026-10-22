package al0;

import am2.x;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.f0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.w0;
import com.bytedance.android.live.liveinteract.utils.m0;
import com.bytedance.android.live.liveinteract.utils.q;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.CircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.live.datacontext.m;
import dl0.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static long a;
    public static final /* synthetic */ int b = 0;

    public static String e() {
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == false) goto L5;
        return "new_audience";
    L5:
        return "audience";
    }

    static {
    }

    public static void b(HashMap r6) {
        lc0.c r0 = k.n(ILinkServiceExternal.class).getMultiDataHolderExternal();
        if (r0.getPkId() != 0) goto L5;
        long r1 = a;
    L6:
        r6.put("pk_id", String.valueOf(r1));
        r6.put("is_in_pk", "1");
        return;
    L5:
        r1 = r0.getPkId();
        goto L6
    }

    public static void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        HashMap r0 = new HashMap();
        r0.put("function_type", e());
        r0.put("request_page", r5);
        if (hd0.c.f().g != 1) goto L5;
        String r6 = "video";
    L6:
        r0.put("guest_connection_type", r6);
        b(r0);
        u.l().sendLog("livesdk_guest_connection_break_click", r0, new Object[]{Room.class, x.class});
        return;
    L5:
        r6 = "audio";
        goto L6
    }

    public static void a(HashMap r6, com.bytedance.android.live.liveinteract.utils.d r7) {
        r6.put("live_type", "video_live");
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r0 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        String r1 = "0";
        if (r0 == null) goto L8;
        i r2 = r0.getLinkUserCenter();
        if (r2 == null) goto L8;
        String r3 = String.valueOf(com.bytedance.android.live.livepkaudience.emoji.c.a(r2));
        if (r3 == null) goto L8;
    L9:
        r6.put("link_cnt", r3);
        r6.put("function_type", e());
        r6.put("function_type2", e());
        if (Intrinsics.areEqual(r7.b, "invite") == false) goto L12;
    L13:
        int r4 = bh0.a.a;
        r7.d = 100;
    L14:
        Map<String, String> r5 = r7.j;
        if (r5 == null) goto L20;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();
    L18:
        if (r8.hasNext() == false) goto L20;
        Map.Entry<String, String> r9 = r8.next();
        r6.put(r9.getKey(), r9.getValue());
    L20:
        int r10 = r7.d;
        int r11 = bh0.a.a;
        if (r10 != 101) goto L24;
        r6.put("request_page", "seat");
    L37:
        if (r7.a == true) goto L40;
        r1 = "1";
    L40:
        r6.put("is_approve_needed", r1);
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r12 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r12 == null) goto L58;
        if (r12.isEngineOn() == false) goto L58;
        r6.put("connect_type", r7.b);
        if (Intrinsics.areEqual(r7.b, "invite") == false) goto L47;
    L48:
        r6.put("from_user_id", r7.c);
        if (Intrinsics.areEqual(r7.c, r7.f) == false) goto L51;
        r6.put("from_user_type", "anchor");
    L53:
        if (Intrinsics.areEqual(r7.b, "gift_message_invite") == false) goto L58;
        IMessageBoardInfo r13 = r7.k;
        if (r13 == null) goto L58;
        r6.put("message_text", f0.a(r13));
        goto L58
    L51:
        r6.put("from_user_type", "admin");
        goto L53
    L47:
        if (Intrinsics.areEqual(r7.b, "gift_message_invite") == false) goto L53;
    L58:
        if (hd0.c.f().g != 1) goto L60;
        String r14 = "video";
    L61:
        r6.put("guest_connection_type", r14);
        return;
    L60:
        r14 = "voice";
        goto L61
    L24:
        if (r10 != 102) goto L27;
        r6.put("request_page", "bottom");
        goto L37
    L27:
        if (r10 != 103) goto L30;
        r6.put("request_page", "popup");
        goto L37
    L30:
        if (r10 != 107) goto L33;
        r6.put("request_page", "link_user_invite");
        goto L37
    L33:
        if (r10 != 113) goto L35;
        r6.put("request_page", "card");
        goto L37
    L35:
        r6.put("request_page", "");
        goto L37
    L12:
        if (Intrinsics.areEqual(r7.b, "gift_message_invite") == false) goto L14;
    L8:
        r3 = "0";
        goto L9
    }

    public static void f(long r6, CircleInfo r8) {
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        r0.put("function_type", e());
        r0.put("function_type2", e());
        r0.put("duration", String.valueOf((System.currentTimeMillis() - r6) / ((long) 1000)));
        if (r8 == null) goto L7;
        String r7 = r8.getCircleName();
        if (r7 == null) goto L7;
        r0.put("circle_name", r7);
    L7:
        String r9 = "off";
        r0.put("seat_fit_status", "off");
        r0.put("is_pre_link", "0");
        b(r0);
        RoomContext.a r10 = RoomContext.Companion;
        RoomContext r4 = RoomContext.a.c(r10, null, 0, 3);
        if (r4 == null) goto L13;
        m r5 = r4.getWiredHeadsetConnectState();
        if (r5 == null) goto L13;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L13;
    L19:
        r9 = "on";
    L20:
        r0.put("earphone_status", r9);
        u.l().sendLog("livesdk_voice_room_watch_duration", r0, new Object[]{Room.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L13:
        RoomContext r11 = RoomContext.a.c(r10, null, 0, 3);
        if (r11 == null) goto L20;
        m r12 = r11.getWirelessHeadsetState();
        if (r12 == null) goto L20;
        if (((Boolean) r12.getValue()).booleanValue() != true) goto L20;
        goto L19
    }

    public static void i(String r3, MessageBoardInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "refuseType");
        HashMap r0 = new HashMap();
        r0.put("function_type", e());
        r0.put("refuse_type", r3);
        if (r4 == null) goto L5;
        r0.put("request_page", "gift_message_panel");
        r0.put("message_text", f0.a(r4));
    L5:
        b(r0);
        u.l().sendLog("livesdk_guest_refuse_chat_invited", r0, new Object[]{Room.class, x.class});
    }

    public static void d(String r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "userType");
        HashMap r0 = new HashMap();
        r0.put("function_type", e());
        r0.put("user_type", r3);
        String r6 = "0";
        if (r4 != null) goto L5;
        r4 = "0";
    L5:
        r0.put("user_id", r4);
        if (r5 <= 0) goto L8;
        r0.put("tag_type", String.valueOf(r5));
    L8:
        r0.put("channel_id", String.valueOf(p.a().getChannelId()));
        b(r0);
        Integer r7 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r7 != null) goto L12;
    L14:
        r0.put("is_user_guest", r6);
        u.l().sendLog("livesdk_seat_head_click", r0, new Object[]{Room.class, x.class});
        return;
    L12:
        if (r7.intValue() != 2) goto L14;
        r6 = "1";
        goto L14
    }

    public static void h(Room r18, com.bytedance.android.live.liveinteract.utils.d r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "logParams");
        HashMap r1 = new HashMap();
        a(r1, r19);
        if (hd0.c.f().g != 1) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        Object r6 = "1";
    L10:
        r1.put("is_camera_open", r6);
        n0 r7 = u.l().c(x.class);
        if (r7 != null) goto L13;
    L24:
        String r8 = "";
    L25:
        r1.put("previous_page", r8);
        r1.put("is_rechargeble", "0");
        r1.put("is_full", "1");
        if (r18 == null) goto L32;
        ICircleInfo r9 = r18.getCircleInfo();
        if (r9 == null) goto L32;
        String r10 = r9.getCircleName();
        if (r10 == null) goto L32;
        r1.put("circle_name", r10);
    L32:
        r1.put("seat_fit_status", "off");
        r1.put("is_pre_link", "0");
        b(r1);
        if (r1.containsValue("invite_mutual") == true) goto L35;
        r1.put("wait_time", String.valueOf(r19.l));
    L35:
        HashMap r15 = new HashMap();
        if (Intrinsics.areEqual(r19.b, "invite") == false) goto L38;
    L39:
        r15.put("from_user_id", r19.c);
        if (Intrinsics.areEqual(r19.c, r19.f) == false) goto L42;
        r15.put("from_user_type", "anchor");
    L44:
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == true) goto L46;
        u.l().sendLog("livesdk_guest_connection_success", r1, new Object[]{r18, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L46:
        if (r20 == false) goto L59;
        ((TalkRoomLogUtils) ((IInteractService) k.n(IInteractService.class)).getTalkRoomLogUtils()).getClass();
        m0 r0 = TalkRoomLogUtils.l;
        if (r0 == null) goto L71;
        q r2 = ((IInteractService) k.n(IInteractService.class)).getTalkRoomLogUtils();
        String r12 = r0.a;
        int r13 = r0.b;
        boolean r14 = r0.c;
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r3 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r3 == null) goto L57;
        i r4 = r3.getLinkUserCenter();
        if (r4 == null) goto L57;
        String r5 = String.valueOf(com.bytedance.android.live.livepkaudience.emoji.c.a(r4));
        if (r5 == null) goto L57;
        String r16 = r5;
    L58:
        m0 r17 = new m0(r12, r13, r14, r16, r0.e, r11, r0.g, r0.h, r0.i, r0.j, r15, 15360);
        ((TalkRoomLogUtils) r2).getClass();
        Intrinsics.checkNotNullParameter(r17, "params");
        TalkRoomLogUtils.l = r17;
    L57:
        r16 = "0";
    L71:
        ((TalkRoomLogUtils) ((IInteractService) k.n(IInteractService.class)).getTalkRoomLogUtils()).g0();
        return;
    L59:
        q r110 = ((IInteractService) k.n(IInteractService.class)).getTalkRoomLogUtils();
        String r21 = r19.b;
        int r22 = r19.d;
        boolean r23 = r19.a;
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r24 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r24 == null) goto L65;
        i r25 = r24.getLinkUserCenter();
        if (r25 == null) goto L65;
        String r26 = String.valueOf(com.bytedance.android.live.livepkaudience.emoji.c.a(r25));
        if (r26 == null) goto L65;
    L67:
        if (r19.h == false) goto L69;
        String r27 = "1";
    L70:
        String r28 = r26;
        boolean r29 = r11;
        m0 r111 = new m0(r21, r22, r23, r28, false, r29, r27, r18, e(), Long.valueOf(r19.l), r15, 15360);
        ((TalkRoomLogUtils) r110).getClass();
        Intrinsics.checkNotNullParameter(r111, "params");
        TalkRoomLogUtils.l = r111;
        goto L71
    L69:
        r27 = "0";
    L65:
        r26 = "0";
        goto L67
    L42:
        r15.put("from_user_type", "admin");
        goto L44
    L38:
        if (Intrinsics.areEqual(r19.b, "gift_message_invite") == false) goto L44;
    L13:
        if ((r7 instanceof n0) == false) goto L24;
        n0 r30 = r7;
        String r31 = r30.c;
        if (r31 != null) goto L17;
    L20:
        boolean r32 = true;
    L21:
        if (r32 == true) goto L24;
        r8 = r30.c;
        if (r8 != null) goto L25;
    L17:
        if (r31.length() == 0) goto L20;
        r32 = false;
        goto L21
    L9:
        r6 = "0";
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    public static void g(Room r49, String r50, com.bytedance.android.live.liveinteract.utils.d r51, long r52, long r54, boolean r56, Long r57) {
        Intrinsics.checkNotNullParameter(r50, "overType");
        Intrinsics.checkNotNullParameter(r51, "logParams");
        HashMap r2 = new HashMap();
        if (Intrinsics.areEqual(r50, "limit_time_up") == false) goto L6;
        String r0 = "timeout";
        r2.put("over_type", "timeout");
    L14:
        String r17 = r0;
    L17:
        if (r56 == false) goto L19;
        String r3 = "1";
    L20:
        r2.put("is_camera_open", r3);
        long r8 = 1000;
        r2.put("duration", String.valueOf((System.currentTimeMillis() - r52) / r8));
        long r6 = r54 / r8;
        r2.put("camera_duration", String.valueOf(r6));
        r2.put("is_rechargeble", "0");
        r2.put("talk_duration", String.valueOf(r51.i));
        r2.put("live_type", "video_live");
        a(r2, r51);
        if (r49 == null) goto L27;
        ICircleInfo r4 = r49.getCircleInfo();
        if (r4 == null) goto L27;
        String r5 = r4.getCircleName();
        if (r5 == null) goto L27;
        r2.put("circle_name", r5);
    L27:
        r2.put("seat_fit_status", "off");
        r2.put("is_pre_link", "0");
        if (r57 == null) goto L32;
        long r10 = r57.longValue();
        if (r2.containsValue("invite_mutual") == true) goto L32;
        r2.put("wait_time", String.valueOf(r10));
    L32:
        b(r2);
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == false) goto L64;
        HashMap r7 = new HashMap();
        if (Intrinsics.areEqual(r51.b, "invite") == false) goto L37;
    L38:
        r7.put("from_user_id", r51.c);
        if (Intrinsics.areEqual(r51.c, r51.f) == false) goto L41;
        r7.put("from_user_type", "anchor");
    L42:
        b(r7);
        ((TalkRoomLogUtils) ((IInteractService) k.n(IInteractService.class)).getTalkRoomLogUtils()).getClass();
        m0 r1 = TalkRoomLogUtils.l;
        if (r1 == null) goto L56;
        q r9 = ((IInteractService) k.n(IInteractService.class)).getTalkRoomLogUtils();
        String r11 = r1.a;
        int r12 = r1.b;
        boolean r13 = r1.c;
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r14 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r14 == null) goto L50;
        i r15 = r14.getLinkUserCenter();
        if (r15 == null) goto L50;
        String r16 = String.valueOf(com.bytedance.android.live.livepkaudience.emoji.c.a(r15));
        if (r16 == null) goto L50;
    L51:
        boolean r18 = r1.e;
        String r19 = r1.g;
        IRoom r110 = r1.h;
        String r22 = "";
        String r20 = r1.i;
        Long r21 = r1.j;
        String r23 = tc0.c.h().G;
        if (r23 != null) goto L54;
        String r111 = r22;
    L55:
        m0 r24 = new m0(r11, r12, r13, r16, r18, r56, r19, r110, r20, r21, r17, r111, Long.valueOf((System.currentTimeMillis() - r52) / r8), String.valueOf(r6), r7);
        ((TalkRoomLogUtils) r9).getClass();
        Intrinsics.checkNotNullParameter(r24, "params");
        TalkRoomLogUtils.l = r24;
    L57:
        ((TalkRoomLogUtils) ((IInteractService) k.n(IInteractService.class)).getTalkRoomLogUtils()).getClass();
        m0 r25 = TalkRoomLogUtils.l;
        if (r25 == null) goto L66;
        String r26 = r25.a;
        Long r27 = r25.m;
        Long r28 = r25.j;
        int r29 = r25.b;
        LinkApplyType r210 = LinkApplyType.NORMAL;
        boolean r30 = r25.c;
        String r31 = r25.d;
        IRoom r32 = r25.h;
        String r33 = r25.k;
        if (r33 != null) goto L62;
        String r34 = r22;
    L63:
        TalkRoomLogUtils.Z(r26, r27, r28, null, r29, r210, r30, r31, r32, r34, r25.l, r25.i, null, null, null, r25.f, "", null, null, null, null, null, new w0(), r25.o, null, 100663296);
        return;
    L62:
        r34 = r33;
        goto L63
    L66:
        return;
    L54:
        r111 = r23;
    L50:
        r16 = "0";
        goto L51
    L56:
        r22 = "";
        goto L57
    L41:
        r7.put("from_user_type", "admin");
        goto L42
    L37:
        if (Intrinsics.areEqual(r51.b, "gift_message_invite") == false) goto L42;
    L64:
        u.l().sendLog("livesdk_guest_connection_over", r2, new Object[]{r49, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L19:
        r3 = "0";
        goto L20
    L6:
        if (Intrinsics.areEqual(r50, "kick_out") == false) goto L8;
    L15:
        r2.put("over_type", "anchor");
        r17 = "anchor";
        goto L17
    L8:
        if (Intrinsics.areEqual(r50, "live_end") == true) goto L15;
        r0 = "audience";
        r2.put("over_type", "audience");
        String r35 = tc0.c.h().G;
        if (r35 != null) goto L13;
        r35 = "";
    L13:
        r2.put("break_page", r35);
        goto L14
    }
}

package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static void i() {
        HashMap r0 = new HashMap();
        IUserService r1 = jc1.k.f(IUserService.class);
        if (r1 == null) goto L38;
        com.bytedance.android.livesdk.user.f r2 = r1.user();
        if (r2 == null) goto L39;
        IUser r3 = r2.b();
        if (r3 == null) goto L40;
        r0.put("invitee_user_id", r3.getIdString());
        String r4 = r3.getNickName();
        String r5 = BuildConfig.FLAVOR;
        if (r4 != null) goto L12;
        r4 = BuildConfig.FLAVOR;
    L12:
        r0.put("nickname", r4);
        com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r6 == null) goto L21;
        Map r7 = r6.getMap();
        if (r7 == null) goto L21;
        String r8 = (String) r7.get("enter_from_merge");
        if (r8 == null) goto L21;
        r5 = r8;
    L21:
        switch(r5.hashCode()) {
            case 3052376: goto L33;
            case 3452698: goto L30;
            case 390174972: goto L27;
            case 823500643: goto L24;
            default: goto L35;
        };
    L35:
        String r9 = "other";
    L36:
        r0.put("join_type", r9);
        l("livesdk_match_chat_invitee_join", r0);
        return;
    L24:
        if (r5.equals("inner_push") == false) goto L35;
        r9 = "in_push";
        goto L36
    L27:
        if (r5.equals("share_alert") == false) goto L35;
        r9 = "share_password";
        goto L36
    L30:
        if (r5.equals("push") == false) goto L35;
        r9 = "out_push";
        goto L36
    L33:
        if (r5.equals("chat") == false) goto L35;
        r9 = "mess";
        goto L36
    L40:
        return;
    L39:
        return;
    }

    static {
    }

    public static void a(s22.a r3) {
        Intrinsics.checkNotNullParameter(r3, "chatChannel");
        HashMap r0 = new HashMap();
        r0.put("msg_show_type", "chat_channel_qualify_guide");
        r0.put("create_type", String.valueOf(r3.y()));
        FansChannelCreateInfo r1 = r3.C();
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.getFansChannelType());
    L6:
        r0.put("sub_create_type", String.valueOf(r2));
        r0.put("channel_id", String.valueOf(r3.getChannelId()));
        r0.put("create_app_id", String.valueOf(r3.f()));
        r0.put("click_type", "audience_action_sheet");
        l("livesdk_chat_channel_system_msg_click", r0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void c(com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r3) {
        Intrinsics.checkNotNullParameter(r3, "logInfo");
        HashMap r0 = new HashMap();
        String r1 = r3.a;
        if (r1 == null) goto L5;
        r0.put("enter_from", r1);
    L5:
        r0.put("is_group", m(Boolean.valueOf(r3.b)));
        r0.put("is_repeat", m(Boolean.valueOf(r3.c)));
        r0.put("number", String.valueOf(r3.d));
        String r4 = r3.e;
        if (r4 == null) goto L8;
        r0.put("friend_list", r4);
    L8:
        l("livesdk_match_chat_channel_icon_click", r0);
    }

    public static void e(s22.a r3) {
        Intrinsics.checkNotNullParameter(r3, "chatChannel");
        HashMap r0 = new HashMap();
        r0.put("create_type", String.valueOf(r3.y()));
        FansChannelCreateInfo r4 = r3.C();
        if (r4 == null) goto L5;
        Long r5 = Long.valueOf(r4.getFansChannelType());
    L6:
        r0.put("sub_create_type", String.valueOf(r5));
        l("livesdk_match_chat_channel_set_success", r0);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entranceType");
        l("livesdk_match_chat_invite_icon_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("entrance_type", r2)}));
    }

    public static void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entranceType");
        l("livesdk_match_chat_invite_icon_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("entrance_type", r2)}));
    }

    public static void j(s22.a r5) {
        Intrinsics.checkNotNullParameter(r5, "chatChannel");
        HashMap r0 = new HashMap();
        r0.put("create_type", String.valueOf(r5.y()));
        FansChannelCreateInfo r1 = r5.C();
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.getFansChannelType());
    L6:
        r0.put("sub_create_type", String.valueOf(r2));
        r0.put("channel_id", String.valueOf(r5.getChannelId()));
        r0.put("create_app_id", String.valueOf(r5.f()));
        String r3 = "1";
        if (r5.s() == false) goto L9;
        Object r4 = "1";
    L10:
        r0.put("join_status", r4);
        if (r5.x() == false) goto L13;
        r3 = "0";
    L13:
        r0.put("is_qualified", r3);
        l("livesdk_chat_channel_msg_user_receive", r0);
        return;
    L9:
        r4 = "0";
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static String m(Boolean r1) {
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L5;
        return "1";
    L5:
        return "0";
    }

    public static void b(s22.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "chatChannel");
        Intrinsics.checkNotNullParameter(r4, "joinType");
        HashMap r0 = new HashMap();
        r0.put("create_type", String.valueOf(r3.y()));
        FansChannelCreateInfo r1 = r3.C();
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.getFansChannelType());
    L6:
        r0.put("sub_create_type", String.valueOf(r2));
        r0.put("channel_id", String.valueOf(r3.getChannelId()));
        r0.put("create_app_id", String.valueOf(r3.f()));
        r0.put("join_type", r4);
        l("livesdk_chat_channel_join_success", r0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void d(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        HashMap r0 = new HashMap();
        if (r2 == false) goto L5;
        String r4 = "chat_tab";
    L6:
        r0.put("entrance_type", r4);
        r0.put("enter_from", r3);
        l("livesdk_match_chat_channel_entrance_show", r0);
        return;
    L5:
        r4 = "create_icon";
        goto L6
    }

    public static void l(String r4, Map r5) {
        com.bytedance.android.livesdk.log.u.l().sendLog(r4, r5, new Object[]{am2.x.class, Room.class, com.bytedance.android.livesdk.log.filter.n.class});
    }

    public static void f(String r3, boolean r4, Map r5, List r6) {
        Intrinsics.checkNotNullParameter(r3, "entranceType");
        Intrinsics.checkNotNullParameter(r5, "logMap");
        r5.put("entrance_type", r3);
        if (r6 == null) goto L9;
        ArrayList r7 = new ArrayList();
        ArrayList r0 = new ArrayList();
        Iterator r1 = r6.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((com.bytedance.android.live.base.model.user.f) r1.next()).getClass();
        r0.add(null);
        goto L6
    L8:
        r5.put("is_group", m(Boolean.valueOf(!r0.isEmpty())));
        r5.put("is_repeat", m(Boolean.valueOf(r4)));
        r5.put("number", String.valueOf(r6.size()));
        r5.put("friend_list", GsonProtectorUtils.toJson(GsonHelper.get(), r7));
        r5.put("group_list", GsonProtectorUtils.toJson(GsonHelper.get(), r0));
    L9:
        l("livesdk_match_chat_invite", r5);
    }

    public static void k(String r13, String r14, long r15, long r17, boolean r19, String r20, String r21, String r23) {
        Intrinsics.checkNotNullParameter(r13, "content");
        Intrinsics.checkNotNullParameter(r14, "type");
        Intrinsics.checkNotNullParameter(r20, "channelId");
        Intrinsics.checkNotNullParameter(r21, "createAppId");
        HashMap r5 = new HashMap();
        IUserService r6 = jc1.k.f(IUserService.class);
        String r7 = BuildConfig.FLAVOR;
        if (r6 == null) goto L8;
        com.bytedance.android.livesdk.user.f r8 = r6.user();
        if (r8 == null) goto L8;
        String r9 = r8.n();
        if (r9 == null) goto L8;
    L9:
        r5.put("user_id", r9);
        RoomContext.a r10 = RoomContext.Companion;
        RoomContext r16 = RoomContext.a.c(r10, null, 0, 3);
        if (r16 == null) goto L19;
        com.bytedance.live.datacontext.m r18 = r16.getRoom();
        if (r18 == null) goto L19;
        Room r110 = (Room) r18.getValue();
        if (r110 == null) goto L19;
        String r111 = r110.getAnchorId();
        if (r111 == null) goto L19;
        r7 = r111;
    L19:
        r5.put("anchor_id", r7);
        RoomContext r11 = RoomContext.a.c(r10, null, 0, 3);
        if (r11 == null) goto L26;
        com.bytedance.live.datacontext.i r24 = r11.isAnchor();
        if (r24 == null) goto L26;
        if (((Boolean) r24.getValue()).booleanValue() != true) goto L26;
        String r25 = "anchor";
    L27:
        r5.put("user_type", r25);
        r5.put("create_type", String.valueOf(r17));
        if (r19 == false) goto L30;
        String r26 = "1";
    L31:
        r5.put("is_creator", r26);
        r5.put("channel_id", r20);
        r5.put("message", r13);
        r5.put("message_type", r14);
        if (r15 == 0) goto L34;
        r5.put("emoji_id", String.valueOf(r15));
    L34:
        r5.put("create_app_id", r21);
        if (r23 == null) goto L37;
        r5.put("paste_edit_method", r23);
    L37:
        l("livesdk_match_chat_message_send", r5);
        return;
    L30:
        r26 = "0";
    L26:
        r25 = "user";
    L8:
        r9 = BuildConfig.FLAVOR;
        goto L9
    }
}

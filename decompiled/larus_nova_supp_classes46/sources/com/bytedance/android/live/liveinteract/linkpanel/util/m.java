package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.text.TextUtils;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.f0;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.l0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.android.livesdk.chatroom.model.q1;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    public static final String c() {
        ArrayList r0 = new ArrayList();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r1 == null) goto L54;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();
        if (r2 == null) goto L54;
        com.bytedance.live.datacontext.m r3 = r2.getPlayModes();
        if (r3 == null) goto L54;
        Set r4 = (Set) r3.getValue();
        if (r4 == null) goto L54;
        Sequence r5 = CollectionsKt.asSequence(r4);
        if (r5 == null) goto L54;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L54;
        int r7 = ((Number) r6.next()).intValue();
        StringBuilder r8 = new StringBuilder();
        if (r7 != 13) goto L18;
        String r9 = "enlarge";
    L50:
        r8.append(r9);
        r8.append("");
        String r10 = r8.toString();
        if ((!Intrinsics.areEqual(r10, "normal")) == false) goto L14;
        r0.add(r10);
        goto L14
    L18:
        if (r7 != 19) goto L20;
        r9 = "request_song";
        goto L50
    L20:
        if (r7 != 21) goto L22;
        r9 = "music";
        goto L50
    L22:
        if (r7 != 23) goto L24;
        r9 = "pk_chorus";
        goto L50
    L24:
        if (r7 != 29) goto L26;
        r9 = "meetgame";
        goto L50
    L26:
        if (r7 != 31) goto L28;
        r9 = "danmu";
        goto L50
    L28:
        if (r7 == Integer.MAX_VALUE) goto L43;
        if (r7 != 16) goto L31;
        r9 = "room_grouppk";
        goto L50
    L31:
        if (r7 == 17) goto L41;
        switch(r7) {
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L34;
            default: goto L33;
        };
    L33:
        r9 = "normal";
        goto L50
    L34:
        r9 = "rechargeable_normal";
        goto L50
    L35:
        r9 = "ktv";
        goto L50
    L36:
        r9 = "bgm";
        goto L50
    L37:
        r9 = "ksong";
        goto L50
    L38:
        r9 = "grouppk";
        goto L50
    L39:
        r9 = "sing_challenge";
        goto L50
    L40:
        r9 = "boom";
        goto L50
    L41:
        r9 = "self_discipline";
        goto L50
    L43:
        r9 = "order_by_user";
    L54:
        if (o.c() != 16) goto L57;
        r0.add("link_room");
    L57:
        if (r0.size() != 0) goto L60;
        r0.add("normal");
    L60:
        return CollectionsKt.joinToString$default(r0, ",", "[", "]", 0, null, null, 56, null);
    }

    public static final String d() {
        Integer r0 = (Integer) b6.B.getValue();
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        if (r0 != null) goto L16;
        return "time_first";
    L16:
        if (r0.intValue() != 42) goto L20;
        return "complex_value";
    L20:
        return "time_first";
    L11:
        if (r0.intValue() != 41) goto L13;
        return "money_first";
    L6:
        if (r0.intValue() != 40) goto L8;
        return "time_first";
    }

    public static String a() {
        Integer r0 = Integer.valueOf(l0.a());
        LinkedHashMap r1 = new LinkedHashMap();
        A(r1, r0, null);
        String r2 = (String) r1.get("function_type");
        if (r2 != null) goto L6;
        return "live";
    L6:
        return r2;
    }

    public static final Pair<String, String> e() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        String r0 = "anchor";
    L7:
        return TuplesKt.to("user_type", r0);
    L5:
        r0 = "admin";
        goto L7
    }

    public static final boolean h() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
    L8:
        return true;
    L5:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L8;
        return false;
    }

    public static final void D(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        String r0 = o.g();
        if (r0 != null) goto L5;
        return;
    L5:
        if (ln1.a.a.a(r0) != true) goto L9;
        r2.put("is_join_spring_festival_task", "1");
        return;
    }

    public static final void E(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L7:
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.e(r1, null) == false) goto L9;
        String r3 = "1";
    L10:
        ((HashMap) r2).put("is_paidlive", r3);
        return;
    L9:
        r3 = "0";
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public static /* synthetic */ void G(Map r1) {
        F(r1, l0.a());
    }

    public static final void I(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L8;
        li0.b r0 = li0.b.b;
        String r1 = li0.b.b();
        if (r1 == null) goto L9;
        ((HashMap) r2).put("grouppk_stage", r1);
        return;
    L9:
        return;
    }

    public static final void J(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L16;
        List r4 = r2.b;
        if (r4 == null) goto L16;
        if (r4.contains(1) == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L16;
        String r5 = "video_friend";
    L17:
        o.c();
        r3.put("play_type", r5);
        return;
    L16:
        r5 = "";
        goto L17
    }

    public static final void K(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r1.t();
        if (r3 != null) goto L9;
        return;
    L9:
        if (d0.e(r3.b) == false) goto L11;
        r2.put("seat_fit_status", "on");
        return;
    L11:
        r2.put("seat_fit_status", "off");
        return;
    L14:
        return;
    }

    public static final void N(boolean r5) {
        Intrinsics.checkNotNullParameter("live_chat", "connectionType");
        HashMap r0 = new HashMap();
        r0.put("connection_type", "live_chat");
        r0.put("_param_live_platfom", "live");
        r0.put("event_belong", "live");
        r0.put("event_page", "live_take_detail");
        r0.put("local_time_ms", String.valueOf(System.currentTimeMillis()));
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        B(r0, Integer.valueOf(r1), 4);
        J(r0);
        H(r0, Integer.valueOf(r1));
        j0 r2 = j0.l();
        if (r5 == false) goto L5;
        String r6 = "livesdk_admin_authorization_switch_open";
    L6:
        r2.sendLog(r6, r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r6 = "livesdk_admin_authorization_switch_close";
        goto L6
    }

    public static final void j(boolean r2) {
        HashMap r0 = new HashMap();
        if (r2 == false) goto L5;
        String r3 = "voice_live";
    L6:
        r0.put("live_type", r3);
        r0.put("user_type", "anchor");
        B(r0, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        H(r0, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        L("livesdk_anchor_audience_connection_invite_more_button_click", r0, new Object[0]);
        return;
    L5:
        r3 = "video_live";
        goto L6
    }

    public static final void o(k1 r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        if (r5.getGameDataType() != 0) goto L5;
        return;
    L5:
        if (r5.getPlayModeId() != 0) goto L28;
        q1 r0 = r5.getInteractInfo();
        if (r0 == null) goto L9;
        int r1 = r0.getInteractType();
    L11:
        if (r1 != 100) goto L13;
        String r2 = "little_plugin";
    L20:
        Pair[] r3 = new Pair[4];
        q1 r4 = r5.getInteractInfo();
        if (r4 == null) goto L24;
        String r6 = r4.getAppId();
        if (r6 == null) goto L24;
    L25:
        r3[0] = TuplesKt.to("program_id", r6);
        r3[1] = TuplesKt.to("program_name", r5.getTitle());
        r3[2] = TuplesKt.to("program_type", r2);
        r3[3] = TuplesKt.to("source", ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentSwitchSceneSource());
        Map r7 = MapsKt.mutableMapOf(r3);
        j0.l().sendLog("livesdk_live_function_panel_program_show", r7, new Object[]{IRoom.class});
        return;
    L24:
        r6 = "";
        goto L25
    L13:
        if (r1 != 103) goto L15;
        r2 = "little_program";
        goto L20
    L15:
        if (r1 == 104) goto L17;
        r2 = "unknown type";
        goto L20
    L17:
        r2 = "little_game_sonic";
        goto L20
    L9:
        r1 = 0;
        goto L11
    }

    public static final void p(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "extraParams");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r4);
        B(r0, null, 6);
        r0.put("user_type", o.i());
        j0.l().sendLog("livesdk_panel_first_frame_duration", r0, new Object[]{IRoom.class, am2.x.class});
    }

    public static final void q(boolean r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("live_type", "voice_live");
        r0.put("function_type", "party");
        if (r4 == false) goto L5;
        String r5 = "on";
    L6:
        r0.put("button_type", r5);
        j0.l().sendLog("livesdk_anchor_audience_connection_empty_show_setting", r0, new Object[]{IRoom.class});
        return;
    L5:
        r5 = "off";
        goto L6
    }

    public static final void u(String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        long r3 = r2.getRoomId();
    L8:
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L13;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L13;
        String r6 = r5.getOwnerUserIdString();
    L14:
        LinkedHashMap r8 = new LinkedHashMap();
        G(r8);
        B(r8, null, 6);
        K(r8);
        r8.put("source", r7);
        r8.put("room_id", String.valueOf(r3));
        r8.put("anchor_id", String.valueOf(r6));
        j0.l().sendLog("livesdk_live_music_icon_show", r8, new Object[]{IRoom.class});
        return;
    L13:
        r6 = null;
    L7:
        r3 = 0;
        goto L8
    }

    public static final void w(String r4) {
        Intrinsics.checkNotNullParameter("link_panel", "requestPage");
        Intrinsics.checkNotNullParameter(r4, "source");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("request_page", "link_panel");
        B(r2, null, 6);
        r2.put("source", r4);
        j0.l().sendLog("livesdk_room_grouppk_icon_show", r2, new Object[]{IRoom.class});
    }

    public static final void x(String r5) {
        Intrinsics.checkNotNullParameter("link_panel", "requestPage");
        Intrinsics.checkNotNullParameter(r5, "source");
        LinkedHashMap r2 = new LinkedHashMap();
        B(r2, null, 6);
        r2.put("request_page", "link_panel");
        Intrinsics.checkNotNullParameter(r2, "param");
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        String r1 = "anchor";
    L6:
        r2.put("user_type", r1);
        r2.put("source", r5);
        j0.l().sendLog("livesdk_grouppk_icon_show", r2, new Object[]{IRoom.class});
        return;
    L5:
        r1 = "admin";
        goto L6
    }

    public static final void z(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L8;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        r3.put("anchor_id", r1.getOwnerUserIdString());
        r3.put("room_id", String.valueOf(r1.getId()));
        return;
    L9:
        return;
    }

    public static final void C(int r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getEnlargeGuestType();
        if (r0 == EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal()) goto L14;
        boolean r2 = true;
        if (r0 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Single.ordinal()) goto L10;
        if (r3 != 0) goto L14;
    L15:
        if (r2 == false) goto L18;
        r4.put("is_enlarge_seat", "1");
        return;
    L18:
        return;
    L10:
        if (r0 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L14;
        if (r3 == 0) goto L15;
        if (r3 == 1) goto L15;
    L14:
        r2 = false;
        goto L15
    }

    public static final void F(Map<String, String> r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        if (r5 != 1) goto L5;
    L17:
        r4.put("live_type", "video_live");
        return;
    L5:
        if (r5 != 12) goto L7;
        r4.put("live_type", "video_live");
        return;
    L7:
        if (r5 == 4) goto L17;
        if (r5 == 5) goto L15;
        switch(r5) {
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L24;
        };
    L12:
        r4.put("live_type", "voice_live");
        return;
    L13:
        r4.put("live_type", "voice_live");
        return;
    L14:
        r4.put("live_type", "video_live");
        return;
    L24:
        return;
    L15:
        r4.put("live_type", "voice_live");
    }

    public static final void H(Map<String, String> r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.intValue() != 1) goto L9;
        r2.put("pk_id", String.valueOf(jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId()));
        r2.put("is_in_pk", "1");
        return;
    }

    public static final String b(Integer r9, Integer r10) {
        if (r9 == null) goto L64;
        r9.intValue();
        if (r9.intValue() != 5) goto L18;
        if (r10 != null) goto L7;
    L11:
        com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L66;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 != null) goto L16;
        return "radio";
    L16:
        if (d0.h(r12) == true) goto L74;
        return "radio";
    L74:
        return "party";
    L66:
        return "radio";
    L7:
        if (r10.intValue() == 0) goto L11;
        if (r10.intValue() == 22) goto L74;
        return "radio";
    L18:
        boolean r6 = true;
        boolean r7 = false;
        if (r9.intValue() != 8) goto L34;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L23;
    L26:
        if (r10 != null) goto L28;
    L30:
        r7 = r6;
    L31:
        if (r7 == false) goto L69;
        return "new_audience";
    L69:
        return "radio";
    L28:
        if (r10.intValue() == 7) goto L30;
    L23:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudienceGuestCache() == true) goto L26;
        r6 = false;
        goto L26
    L34:
        if (r9.intValue() != 9) goto L42;
        if (r10 != null) goto L38;
    L40:
        return "ktv";
    L38:
        if (r10.intValue() != 61) goto L40;
        return "chorus";
    L42:
        if (r9.intValue() != 10) goto L45;
        return "watch";
    L45:
        if (r9.intValue() != 4) goto L48;
    L73:
        return "audience";
    L48:
        if (r9.intValue() != 1) goto L58;
        boolean r13 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience();
        if (r10 != null) goto L52;
    L54:
        r7 = r13;
    L55:
        if (r7 == false) goto L73;
        return "new_audience";
    L52:
        if (r10.intValue() == 7) goto L54;
    L58:
        if (r9.intValue() == 12) goto L74;
        if (r9.intValue() == 16) goto L74;
        return "radio";
    L64:
        return null;
    }

    public static final void m(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "switchName");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        LinkedHashMap r0 = new LinkedHashMap();
        z(r0);
        G(r0);
        B(r0, null, 6);
        r0.put("play_mode", c());
        r0.put("switch_name", r3);
        r0.put("action_type", r4);
        H(r0, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        j0.l().sendLog("livesdk_ktv_anchor_live_manage", r0, new Object[]{IRoom.class});
    }

    public static final void n(String r6, g0 r7) {
        Intrinsics.checkNotNullParameter(r6, "showPageName");
        Intrinsics.checkNotNullParameter(r7, "tagInfo");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Long r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.getValue();
    L6:
        LinkedHashMap r3 = new LinkedHashMap();
        if (r2 == null) goto L9;
        r1 = Long.valueOf(r2.getId());
    L9:
        r3.put("room_id", String.valueOf(r1));
        if (r2 == null) goto L13;
        String r4 = r2.getOwnerUserIdString();
        if (r4 == null) goto L13;
    L14:
        r3.put("anchor_id", r4);
        r3.put("function_type", a());
        if (r2 != null) goto L17;
    L19:
        String r5 = "video_live";
    L20:
        r3.put("live_type", r5);
        r3.put("user_type", o.i());
        r3.put("play_mode", c());
        r3.put("show_page_name", r6);
        r3.put("tag_type", String.valueOf(r7.getTagType()));
        r3.put("resource_name", String.valueOf(r7.getPositionTagName()));
        r3.put("resource_type", "ksong");
        r3.put("midi_id", "");
        H(r3, Integer.valueOf(o.c()));
        j0.l().sendLog("livesdk_connection_audience_tag_show", r3, new Object[]{IRoom.class});
        return;
    L17:
        if (r2.isLiveTypeAudio() != true) goto L19;
        r5 = "voice_live";
    L13:
        r4 = "";
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public static final void t(int r5, String r6) {
        Intrinsics.checkNotNullParameter("Link_panel", "requestPage");
        Intrinsics.checkNotNullParameter(r6, "source");
        LinkedHashMap r2 = new LinkedHashMap();
        G(r2);
        B(r2, null, 6);
        K(r2);
        r2.put("playmode_type", String.valueOf(r5));
        r2.put("request_page", "Link_panel");
        r2.put("source", r6);
        j0.l().sendLog("livesdk_live_link_interact_playmode_panel_item_show", r2, new Object[]{IRoom.class});
    }

    public static final String v(Integer r4, List<Integer> r5) {
        if (r4 == null) goto L41;
        r4.intValue();
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L22;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L22;
        if (r1.isLiveTypeAudio() != true) goto L22;
        if (r4.intValue() != 26) goto L16;
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout() != 26) goto L16;
        return "seat_enlarge_double";
    L16:
        if (d0.c(r5) == false) goto L19;
        return "seat_enlarge";
    L19:
        if (r4.intValue() != 28) goto L21;
        return "seat_enlarge";
    L21:
        return "normal";
    L22:
        int r6 = r4.intValue();
        if (r6 != 2) goto L25;
    L39:
        return "seat_fit";
    L25:
        if (r6 == 3) goto L44;
        if (r6 == 6) goto L44;
        if (r6 == 7) goto L39;
        if (r6 == 43) goto L44;
        if (r6 != 102) goto L35;
    L37:
        return "big_frame";
    L35:
        if (r6 == 103) goto L37;
        return "normal";
    L44:
        return "seat_enlarge";
    L41:
        return null;
    }

    public static final void A(Map<String, String> r3, Integer r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L6;
        String r0 = TalkRoomLogUtils.h;
        if (r0 == null) goto L6;
    L8:
        if (vm2.d.v0() == false) goto L10;
        r3.put("function_type", r0);
        return;
    L10:
        if (r4 != null) goto L12;
    L17:
        r3.put("function_type", r0);
        return;
    L12:
        if (r4.intValue() == 0) goto L17;
        String r6 = b(r4, r5);
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r3.put("function_type", r6);
        return;
    L6:
        r0 = "live";
        goto L8
    }

    public static /* synthetic */ void B(Map r0, Integer r1, int r2) {
        if ((r2 & 2) == 0) goto L5;
        r1 = Integer.valueOf(l0.a());
    L5:
        A(r0, r1, null);
    }

    public static final void L(String r4, Map<String, String> r5, Object... r6) {
        j0.l().sendLog(r4, r5, new Object[]{IRoom.class, am2.x.class, r6});
    }

    public static final void f(String r2, MessageBoardInfo r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "refuseType");
        Intrinsics.checkNotNullParameter(r4, "fromUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("refuse_type", r2);
        F(r0, ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene());
        B(r0, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        J(r0);
        if (((Boolean) b6.q.getValue()).booleanValue() == false) goto L5;
        String r5 = "on";
    L6:
        r0.put("link_distribute_switch_type", r5);
        if (r3 == null) goto L9;
        r0.put("request_page", "gift_message_panel");
        r0.put("message_text", f0.a(r3));
    L9:
        r0.put("from_user_id", r4);
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r6 == null) goto L14;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L14;
        String r8 = r7.getOwnerUserIdString();
    L16:
        if (Intrinsics.areEqual(r4, r8) == false) goto L18;
        String r9 = "anchor";
    L19:
        r0.put("from_user_type", r9);
        K(r0);
        j0.l().sendLog("livesdk_guest_refuse_chat_invited", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L18:
        r9 = "admin";
    L14:
        r8 = null;
        goto L16
    L5:
        r5 = "off";
        goto L6
    }

    public static final void g(String r6, String r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "inviteType");
        Intrinsics.checkNotNullParameter(r7, "inviteeId");
        Intrinsics.checkNotNullParameter(r8, "requestPage");
        HashMap r0 = new HashMap();
        r0.put("invite_type", r6);
        r0.put("invitee_id", r7.toString());
        r0.put("request_page", r8);
        String r10 = "1";
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L5;
        Object r11 = "1";
    L6:
        r0.put("is_invite_only", r11);
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r12 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r12 == null) goto L27;
        List<LinkmicPositionItem> r13 = r12.d();
        if (r13 == null) goto L27;
        Iterator<T> r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L19;
        Object r3 = r14.next();
        if (((int) ((LinkmicPositionItem) r3).getPosition()) != r9) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L12;
    L20:
        LinkmicPositionItem r5 = (LinkmicPositionItem) r3;
        if (r5 == null) goto L27;
        if (r5.getStatus() == LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal()) goto L26;
        r10 = "0";
    L26:
        r0.put("is_lock", r10);
        goto L27
    L16:
        r4 = false;
        goto L17
    L19:
        r3 = null;
    L27:
        int r15 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L30;
        r0.put("function_type2", "new_audience");
    L30:
        F(r0, r15);
        J(r0);
        K(r0);
        r0.put("play_mode", c());
        H(r0, Integer.valueOf(r15));
        E(r0);
        String r16 = v(Integer.valueOf(o.d()), ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentPlayModes());
        if (r16 == null) goto L33;
        r0.put("layout_type", r16);
    L33:
        C(r9, r0);
        D(r0);
        j0.l().sendLog("livesdk_anchor_audience_connection_invite", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r11 = "0";
        goto L6
    }

    public static final void r(String r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter("click", "actionType");
        Intrinsics.checkNotNullParameter(r5, "page");
        Pair[] r9 = new Pair[3];
        r9[0] = e();
        r9[1] = TuplesKt.to("request_page", "invite");
        int r0 = "invite".hashCode();
        if (r0 != 3046160) goto L5;
        String r1 = "card";
        if ("invite".equals("card") == true) goto L14;
    L13:
        r1 = "icon";
    L14:
        r9[2] = TuplesKt.to("enter_from", r1);
        Map r10 = MapsKt.mutableMapOf(r9);
        B(r10, null, 6);
        H(r10, Integer.valueOf(o.c()));
        r10.put("action_type", "click");
        JSONObject r2 = new JSONObject();
        r2.put("applicant", String.valueOf(r6));
        r2.put("audience", String.valueOf(r7));
        r2.put("mutual", String.valueOf(r8));
        r10.put("show_num", r2.toString());
        L("anchor_invite_page_search_entry", r10, new Object[0]);
        return;
    L5:
        if (r0 != 3526149) goto L13;
        r1 = "seat";
        if ("invite".equals("seat") == false) goto L13;
        goto L13
    }

    public static final void s(boolean r3, int r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "isSearch");
        if (r4 != 1) goto L5;
        String r7 = "invite";
    L6:
        Pair[] r1 = new Pair[4];
        if (r3 == false) goto L9;
        String r8 = "voice_live";
    L10:
        r1[0] = TuplesKt.to("live_type", r8);
        r1[1] = e();
        r1[2] = TuplesKt.to("request_page", r7);
        int r9 = r7.hashCode();
        if (r9 != 3046160) goto L13;
        String r10 = "card";
        if (r7.equals("card") == true) goto L22;
    L21:
        r10 = "icon";
    L22:
        r1[3] = TuplesKt.to("enter_from", r10);
        Map r11 = MapsKt.mutableMapOf(r1);
        r11.put("show_num", String.valueOf(r6));
        B(r11, null, 6);
        H(r11, Integer.valueOf(o.c()));
        r11.put("is_search", r5);
        L("anchor_invite_search_page_show", r11, new Object[0]);
        return;
    L13:
        if (r9 != 3526149) goto L21;
        r10 = "seat";
        if (r7.equals("seat") == false) goto L21;
    L9:
        r8 = "video_live";
        goto L10
    L5:
        r7 = "apply";
        goto L6
    }

    public static final void i(boolean r3, String r4, boolean r5, boolean r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "inviteeId");
        if (h() == false) goto L49;
        HashMap r0 = new HashMap();
        if (r3 == false) goto L7;
        String r9 = "voice_live";
    L8:
        r0.put("live_type", r9);
        B(r0, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        r0.put("invitee_id", r4.toString());
        r0.put("invitee_type", r8);
        String r10 = "1";
        if (Intrinsics.areEqual(r8, "AI_guest") == false) goto L11;
        Object r11 = "1";
    L12:
        r0.put("is_AI_guest", r11);
        if (r5 == false) goto L15;
        String r12 = "online";
    L16:
        r0.put("online_status", r12);
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L19;
        String r13 = "anchor";
    L20:
        r0.put("user_type", r13);
        if (r6 == false) goto L23;
        Object r14 = "1";
    L24:
        r0.put("icon_type", r14);
        I(r0);
        if (r7 == false) goto L27;
        Object r15 = "1";
    L28:
        r0.put("if_invitee_subscribe", r15);
        boolean r16 = true;
        if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() == 1) goto L32;
        r16 = false;
    L32:
        String r17 = "";
        if (r16 == false) goto L35;
        String r18 = String.valueOf(jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId());
    L36:
        r0.put("pk_id", r18);
        if (r16 == false) goto L39;
        Object r19 = "1";
    L40:
        r0.put("is_in_pk", r19);
        if (o.I() == false) goto L43;
        r17 = o.J().toString();
    L43:
        r0.put("admin_id", r17);
        if (o.I() == true) goto L47;
        r10 = "0";
    L47:
        r0.put("is_admin", r10);
        D(r0);
        L("livesdk_anchor_invitee_show", r0, new Object[0]);
        return;
    L39:
        r19 = "0";
        goto L40
    L35:
        r18 = "";
        goto L36
    L27:
        r15 = "0";
        goto L28
    L23:
        r14 = "0";
        goto L24
    L19:
        r13 = "admin";
        goto L20
    L15:
        r12 = "offline";
        goto L16
    L11:
        r11 = "0";
        goto L12
    L7:
        r9 = "video_live";
        goto L8
    }

    public static final void k(boolean r3, String r4, String r5, String r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        Pair[] r0 = new Pair[4];
        if (r3 == false) goto L5;
        String r10 = "voice_live";
    L6:
        r0[0] = TuplesKt.to("live_type", r10);
        r0[1] = e();
        r0[2] = TuplesKt.to("request_page", r4);
        r0[3] = TuplesKt.to("enter_from", r5);
        Map r11 = MapsKt.mutableMapOf(r0);
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r11.put("is_task", "1");
        Intrinsics.checkNotNull(r6);
        r11.put("activity_name", r6);
    L9:
        JSONObject r12 = new JSONObject();
        r12.put("applicant", String.valueOf(r7));
        r12.put("audience", String.valueOf(r8));
        r12.put("mutual", String.valueOf(r9));
        r11.put("show_num", r12.toString());
        B(r11, null, 6);
        H(r11, Integer.valueOf(o.c()));
        D(r11);
        L("anchor_invite_page_show", r11, new Object[0]);
        return;
    L5:
        r10 = "video_live";
        goto L6
    }

    public static void l(boolean r2, String r3, boolean r4, String r5, boolean r6, String r7, int r8) {
        if ((r8 & 32) == 0) goto L5;
        r7 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, "inviteeId");
        HashMap r9 = new HashMap();
        B(r9, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        if (r2 == false) goto L8;
        String r10 = "voice_live";
    L9:
        r9.put("live_type", r10);
        if (r4 == false) goto L12;
        String r11 = "online";
    L13:
        r9.put("online_status", r11);
        r9.put("enter_from", "live_detail");
        r9.put("request_page", r5);
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L17;
        String r12 = "anchor";
    L20:
        r9.put("user_type", r12);
        r9.put("invitee_id", r3.toString());
        String r13 = "1";
        if (TextUtils.isEmpty(r7) == true) goto L23;
        r9.put("is_task", "1");
        Intrinsics.checkNotNull(r7);
        r9.put("activity_name", r7);
    L23:
        K(r9);
        if (r6 == false) goto L26;
        Object r14 = "1";
    L27:
        r9.put("if_invitee_subscribe", r14);
        if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L30;
        boolean r15 = true;
    L31:
        String r16 = "";
        if (r15 == false) goto L34;
        String r0 = String.valueOf(jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId());
    L35:
        r9.put("pk_id", r0);
        if (r15 == false) goto L38;
        Object r17 = "1";
    L39:
        r9.put("is_in_pk", r17);
        if (o.I() == false) goto L42;
        r16 = o.J().toString();
    L42:
        r9.put("admin_id", r16);
        if (o.I() == false) goto L45;
        Object r18 = "1";
    L46:
        r9.put("is_admin", r18);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L50;
        r13 = "0";
    L50:
        r9.put("is_invite_only", r13);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L53;
        r9.put("function_type2", "new_audience");
    L53:
        String r19 = o.g();
        if (r19 != null) goto L56;
    L58:
        L("livesdk_anchor_friend_connection_invite", r9, new Object[0]);
        return;
    L56:
        if (ln1.a.a.a(r19) != true) goto L58;
        r9.put("enter_from_merge", "party_spring_festival");
        goto L58
    L45:
        r18 = "0";
        goto L46
    L38:
        r17 = "0";
        goto L39
    L34:
        r0 = "";
        goto L35
    L30:
        r15 = false;
        goto L31
    L26:
        r14 = "0";
        goto L27
    L17:
        if (o.I() == false) goto L19;
        r12 = "admin";
        goto L20
    L19:
        r12 = "link_user";
        goto L20
    L12:
        r11 = "offline";
        goto L13
    L8:
        r10 = "video_live";
        goto L9
    }

    public static final void M(String r15, boolean r16, String r17, String r18, String r19, String r20, Long r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter("list", "page");
        Intrinsics.checkNotNullParameter(r17, "fanTicket");
        Intrinsics.checkNotNullParameter(r18, "relationship");
        Intrinsics.checkNotNullParameter(r19, "topPos");
        Intrinsics.checkNotNullParameter(r20, "userLevel");
        HashMap r7 = new HashMap();
        int r8 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r8 != 5) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == false) goto L11;
        String r10 = "voice_live";
    L12:
        r7.put("live_type", r10);
        ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        String r11 = "";
        if (r15 == null) goto L15;
        String r12 = r15;
    L16:
        r7.put("applicant_id", r12);
        String r13 = "1";
        r7.put("is_application_valid", "1");
        if (r16 == false) goto L19;
        String r14 = "anchor";
    L20:
        r7.put("pass_type", r14);
        if (TextUtils.isEmpty("") == false) goto L23;
        r7.put("is_application", "0");
    L24:
        r7.put("request_page", "list");
        I(r7);
        if (r16 == true) goto L29;
        if (o.I() == true) goto L29;
    L31:
        if (r21 == null) goto L34;
        r21.longValue();
        r7.put("tag_type", String.valueOf(r21));
    L34:
        if (o.I() == false) goto L36;
        r11 = o.J().toString();
    L36:
        r7.put("admin_id", r11);
        if (o.I() == true) goto L40;
        r13 = "0";
    L40:
        r7.put("is_admin", r13);
        r7.put("label_name_live", String.valueOf(r22));
        if (r23 != null) goto L43;
    L48:
        r7.put("module_type", "request");
        j0.l().sendLog("livesdk_anchor_audience_connection_pass_show", r7, new Object[]{IRoom.class, am2.x.class});
        return;
    L43:
        if (r23.length() <= 0) goto L45;
        boolean r0 = true;
    L46:
        if (r0 != true) goto L48;
        r7.put("interactive_info", r23);
        goto L48
    L45:
        r0 = false;
    L29:
        if (vm2.d.r() != 1) goto L31;
        r7.put("ordering_mode", d());
        r7.put("money", r17);
        r7.put("relationship", r18);
        r7.put("top_r", r19);
        r7.put("contribution_level", r20);
        goto L31
    L23:
        r7.put("is_application", "1");
        r7.put("application_message", "");
        goto L24
    L19:
        r14 = "administrator";
        goto L20
    L15:
        r12 = "";
        goto L16
    L11:
        r10 = "video_live";
        goto L12
    L5:
        if (r8 == 9) goto L8;
        r9 = false;
        goto L9
    }

    public static final void y(String r16, String r17, List<KtvMusic> r18, String r19, boolean r20, String r21, String r22, String r23, String r24, boolean r25, Long r26, boolean r27, Map<String, String> r28) {
        Intrinsics.checkNotNullParameter(r16, "applicantId");
        Intrinsics.checkNotNullParameter(r17, "passType");
        Intrinsics.checkNotNullParameter(r19, "page");
        Intrinsics.checkNotNullParameter(r21, "fanTicket");
        Intrinsics.checkNotNullParameter(r22, "relationship");
        Intrinsics.checkNotNullParameter(r23, "topPos");
        Intrinsics.checkNotNullParameter(r24, "userLevel");
        Intrinsics.checkNotNullParameter(r28, PbRequest.SwitchType.OTHER);
        HashMap r10 = new HashMap();
        r10.put("applicant_id", r16.toString());
        r10.put("pass_type", r17);
        if (r19.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r10.put("request_page", r19);
    L9:
        if (r20 == false) goto L11;
        Object r12 = "1";
    L12:
        r10.put("is_application", r12);
        int r13 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        B(r10, Integer.valueOf(r13), 4);
        Integer r14 = Integer.valueOf(r13);
        List<KtvMusic> r15 = r18;
        if (r15 != null) goto L15;
    L18:
        boolean r110 = true;
    L19:
        boolean r111 = !r110;
        Intrinsics.checkNotNullParameter(r10, "logMap");
        if (r14 != null) goto L22;
        String r112 = "0";
    L26:
        r10.put("guest_connection_type", "live_chat");
    L27:
        if (r13 == 0) goto L50;
        if (r15 != null) goto L30;
    L33:
        boolean r2 = true;
    L34:
        if (r2 == true) goto L50;
        Intrinsics.checkNotNullParameter(r10, "logMap");
        Intrinsics.checkNotNullParameter(r18, "songList");
        StringBuilder r3 = new StringBuilder();
        StringBuilder r8 = new StringBuilder();
        Iterator<T> r1 = r18.iterator();
        int r11 = 0;
    L37:
        if (r1.hasNext() == false) goto L48;
        Object r113 = r1.next();
        int r114 = r11 + 1;
        if (r11 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        KtvMusic r115 = (KtvMusic) r113;
        if (r11 <= 0) goto L44;
        r3.append(",");
        r8.append(",");
    L44:
        r3.append(r115.getId());
        String r116 = r115.getTitle();
        if (r116 != null) goto L47;
        r116 = "";
    L47:
        r8.append(r116);
        r11 = r114;
        goto L37
    L48:
        r10.put("song_id", r3.toString());
        r10.put("song_name", r8.toString());
        goto L50
    L30:
        if (r15.isEmpty() == true) goto L33;
        r2 = false;
    L50:
        if (vm2.d.r() != 1) goto L52;
        r10.put("ordering_mode", d());
        r10.put("money", r21.toString());
        r10.put("relationship", r22);
        r10.put("top_r", r23);
        r10.put("contribution_level", r24);
    L52:
        if (r26 == null) goto L54;
        r10.put("tag_type", String.valueOf(r26.longValue()));
    L54:
        J(r10);
        F(r10, r13);
        I(r10);
        if (r25 == false) goto L57;
        String r4 = "1";
    L58:
        r10.put("if_invitee_subscribe", r4);
        E(r10);
        SimpleDateFormat r5 = o.a;
        if ((!r28.isEmpty()) == false) goto L65;
        String r6 = r28.get("position");
        if (r6 != null) goto L63;
        String r7 = r112;
    L64:
        r10.put("order", r7);
        goto L65
    L63:
        r7 = r6;
    L65:
        H(r10, Integer.valueOf(r13));
        I(r10);
        if (r27 == false) goto L68;
        r10.put("is_enlarge_seat", "1");
    L68:
        j0.l().sendLog("livesdk_anchor_audience_connection_pass", r10, new Object[]{am2.x.class, IRoom.class});
        return;
    L57:
        r4 = r112;
        goto L58
    L22:
        r112 = "0";
        if (r14.intValue() != 9) goto L26;
        if (r111 == false) goto L26;
        r10.put("guest_connection_type", "live_song");
        goto L27
    L15:
        if (r15.isEmpty() == true) goto L18;
        r110 = false;
        goto L19
    L11:
        r12 = "0";
        goto L12
    L5:
        r0 = false;
        goto L6
    }
}

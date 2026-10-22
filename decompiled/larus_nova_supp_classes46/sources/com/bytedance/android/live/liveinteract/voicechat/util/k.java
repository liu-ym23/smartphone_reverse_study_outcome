package com.bytedance.android.live.liveinteract.voicechat.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.f0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.r0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.utils.g1;
import com.bytedance.android.live.liveinteract.widget.widget.LinkDistributeSettingDialog;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.b1;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public static final /* synthetic */ int g = 0;
    public long a;
    public long b;
    public final Map<Integer, Long> c;
    public final Map<Integer, Long> d;
    public final DataCenter e;
    public final com.bytedance.android.livesdk.chatroom.o f;

    public static final class a {
    }

    static {
    }

    public static boolean b() {
        String r0 = gh0.a.c();
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L7;
        ILinkPlayerInfoBridge r2 = r1.getGuestInfo(r0, null);
        if (r2 == null) goto L7;
        long r3 = r2.getChorusGuestStatus();
    L9:
        if (r3 <= 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        r3 = 0;
        goto L9
    }

    public static void r() {
        j0.l().sendLog("sing_room_play", null, new Object[]{IRoom.class, am2.x.class});
    }

    public static void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "userType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", "seat");
        r0.put("user_type", r4);
        j0.l().sendLog("anchor_invite_guide_icon_click", r0, new Object[]{IRoom.class});
    }

    public static void s(long r3) {
        HashMap r0 = new HashMap();
        r0.put("duration", String.valueOf(r3));
        j0.l().sendLog("livesdk_sing_room_watch_duration", r0, new Object[]{IRoom.class, am2.x.class});
    }

    public static void z(int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("connect_acu", String.valueOf(r4));
        r0.put("room_type", "radio");
        j0.l().sendLog("anchor_audience_connection_onemin", r0, new Object[]{IRoom.class});
    }

    public k(DataCenter r2, com.bytedance.android.livesdk.chatroom.o r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.e = r2;
        this.f = r3;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    public static void F(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        HashMap r0 = new HashMap();
        if (r4 == false) goto L5;
        String r5 = "click";
    L6:
        r0.put("action_type", r5);
        r0.put("anchor_id", r3);
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L11;
        String r7 = r6.getCurrentFunctionType();
        if (r7 == null) goto L11;
        String r8 = (String) r0.put("function_type", r7);
    L11:
        String r9 = ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2();
        if (r9 == null) goto L14;
        r0.put("function_type2", r9);
    L14:
        j0.l().sendLog("livesdk_audience_associated_apply_entry", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        r5 = "show";
        goto L6
    }

    public static void n(int r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "requestPage");
        HashMap r0 = new HashMap();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L9;
        int r4 = r3.b;
    L11:
        if (r7 != 9) goto L13;
        if (r4 != 61) goto L18;
        String r5 = "chorus";
    L19:
        r0.put("before_function", r5);
        if (r7 != 5) goto L23;
        if (r4 != 61) goto L23;
        r0.put("interact_function", "chorus");
    L25:
        if (r2.a(TalkRoomLogUtils.e) == false) goto L28;
        String r9 = TalkRoomLogUtils.e;
        Intrinsics.checkNotNull(r9);
        r0.put("request_page", r9);
    L32:
        j0.l().sendLog("anchor_switch_room_type", r0, new Object[]{IRoom.class, am2.x.class});
        TalkRoomLogUtils.e = null;
        return;
    L28:
        if (r2.a(r8) == true) goto L31;
        r8 = "link_icon";
    L31:
        r0.put("request_page", r8);
    L23:
        r0.put("interact_function", "live_room");
        goto L25
    L18:
        r5 = "sing_room";
        goto L19
    L13:
        if (r7 == 10) goto L15;
        r5 = "chat_room";
        goto L19
    L15:
        r5 = "watch_room";
    L9:
        r4 = 0;
        goto L11
    }

    public final Map<String, String> a(Map<String, String> r4, boolean r5) {
        HashMap r0 = new HashMap();
        Intrinsics.checkNotNull(r4);
        Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r6.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        r0.put("live_type", "voice_live");
        boolean r7 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        if (r5 == false) goto L9;
    L15:
        String r8 = ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2();
        if (r8 == null) goto L18;
        r0.put("function_type2", r8);
    L18:
        return r0;
    L9:
        if (a0.d(this.e, false) == true) goto L13;
        if (r7 == false) goto L13;
        String r9 = "administrator";
    L14:
        r0.put("user_type", r9);
    L13:
        r9 = "anchor";
        goto L14
    }

    public final void e(long r5, boolean r7) {
        HashMap r0 = new HashMap();
        if (r5 <= 0) goto L6;
        r0.put("duration", String.valueOf((SystemClock.elapsedRealtime() - r5) / ((long) 1000)));
    L6:
        if (((Boolean) this.e.get("data_audio_chat_support_send_gift_to_linker", Boolean.TRUE)).booleanValue() == false) goto L8;
        String r6 = "on";
    L9:
        r0.put("gift_guest_switch_type", r6);
        if (r7 == false) goto L12;
        TalkRoomLogUtils.b(r0);
    L12:
        TalkRoomLogUtils.a(r0, false);
        j0.l().sendLog("livesdk_anchor_ktv_over", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L8:
        r6 = "off";
        goto L9
    }

    public static void E(Map r3, int r4, int r5) {
        fj0.a r0 = fj0.b.a;
        int r1 = r0.h;
        int r2 = r0.i;
        if (r5 != 1) goto L6;
        int r6 = r4 - r1;
    L12:
        if (r6 < 0) goto L14;
        String r7 = String.valueOf(r6);
    L15:
        ((HashMap) r3).put("pay_price", r7);
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

    public static void c(int r3, int r4, Map r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        String r0 = TalkRoomLogUtils.d;
        if (r0 != null) goto L5;
    L11:
        String r6 = qi0.c.b;
        qi0.c.k("source", r5);
        j0.l().sendLog("livesdk_anchor_audience_connection_open_success", r5, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        if (r2.a(r0) != true) goto L11;
        if (r4 == 0) goto L11;
        Map<r0, String> r1 = TalkRoomLogUtils.f;
        r0 r2 = new r0(r3, r4);
        String r7 = TalkRoomLogUtils.d;
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        r1.put(r2, r7);
        goto L11
    }

    public static void l(k r8, Integer r9, Map r10, int r11) {
        Set r1 = null;
        if ((r11 & 4) == 0) goto L6;
        r9 = null;
    L6:
        if ((r11 & 8) == 0) goto L8;
        r10 = null;
    L8:
        HashMap r12 = new HashMap();
        TalkRoomLogUtils.u0(r12);
        TalkRoomLogUtils.J0(r12);
        TalkRoomLogUtils.B0(r12, null, null, 6);
        String r0 = TalkRoomLogUtils.d;
        if (r0 == null) goto L11;
        r12.put("source", r0);
    L11:
        Map<Integer, String> r2 = TalkRoomLogUtils.g;
        if (r9 == null) goto L14;
        int r3 = r9.intValue();
    L15:
        Integer r4 = Integer.valueOf(r3);
        String r5 = TalkRoomLogUtils.d;
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r2.put(r4, r5);
        if (r10 == null) goto L24;
        Iterator r13 = r10.entrySet().iterator();
    L22:
        if (r13.hasNext() == false) goto L24;
        Map.Entry r6 = (Map.Entry) r13.next();
        r12.put(r6.getKey(), r6.getValue());
    L24:
        r12.put("is_link_room", TalkRoomLogUtils.s);
        zi0.d.b(r12, false);
        if (r9 == null) goto L27;
        r12.put("play_mode", u0.k(r9.intValue()));
        r8.d.put(r9, Long.valueOf(System.currentTimeMillis()));
        j0.l().sendLog("livesdk_anchor_playmode_open_success", r12, new Object[]{IRoom.class, am2.x.class});
        return;
    L27:
        com.bytedance.live.datacontext.j r14 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r14 == null) goto L34;
        LivePlayModeLogContext r15 = (LivePlayModeLogContext) r14.getValue();
        if (r15 == null) goto L34;
        com.bytedance.live.datacontext.m r16 = r15.getPlayModes();
        if (r16 == null) goto L34;
        r1 = (Set) r16.getValue();
    L34:
        if (r1 == null) goto L49;
        Iterator r17 = r1.iterator();
    L38:
        if (r17.hasNext() == false) goto L50;
        int r7 = ((Number) r17.next()).intValue();
        if (TalkRoomLogUtils.t0(r7) == false) goto L38;
        r12.put("play_mode", u0.k(r7));
        r8.d.put(Integer.valueOf(r7), Long.valueOf(System.currentTimeMillis()));
        j0.l().sendLog("livesdk_anchor_playmode_open_success", r12, new Object[]{IRoom.class, am2.x.class});
        goto L38
    L50:
        return;
    L49:
        return;
    L14:
        r3 = 0;
        goto L15
    }

    public final void f(String r4, String r5, String r6, String r7) {
        HashMap r0 = new HashMap();
        TalkRoomLogUtils.u0(r0);
        TalkRoomLogUtils.J0(r0);
        if (r4 == null) goto L5;
        r0.put("function_type", r4);
    L6:
        i0 r8 = TalkRoomLogUtils.a;
        r0.put("function_type2", TalkRoomLogUtils.h);
        if (r5 == null) goto L9;
        r0.put("layout_type", r5);
    L9:
        if (r7 != null) goto L11;
        r7 = "normal";
    L11:
        r0.put("enlarge_show_type", r7);
        String r9 = TalkRoomLogUtils.q;
        if (r9 == null) goto L15;
        r0.put("enlarge_user_id", r9);
        TalkRoomLogUtils.q = null;
    L15:
        if (r6 == null) goto L17;
        r0.put("source", r6);
    L20:
        this.a = System.currentTimeMillis();
        Integer r10 = je0.d.h();
        if (r10 != null) goto L24;
    L26:
        String r11 = "classic";
    L27:
        r0.put("play_layout", r11);
        HamletAvatarContext r12 = HamletAvatarContext.Companion.getContext();
        if (r12 == null) goto L36;
        com.bytedance.live.datacontext.j<gd0.g> r13 = r12.getHamletAvatarService();
        if (r13 == null) goto L36;
        gd0.g r14 = (gd0.g) r13.getValue();
        if (r14 == null) goto L36;
        Long r15 = r14.Ue();
        if (r15 == null) goto L36;
        r0.put("avatar_id", String.valueOf(r15.longValue()));
    L36:
        r0.putAll(TalkRoomLogUtils.e());
        String r16 = qi0.c.b;
        qi0.c.k("source", r0);
        j0.l().sendLog("livesdk_anchor_layout_type_open_success", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L24:
        if (r10.intValue() != 28) goto L26;
        r11 = "avatar";
        goto L27
    L17:
        String r17 = TalkRoomLogUtils.d;
        if (r17 == null) goto L20;
        r0.put("source", r17);
        goto L20
    L5:
        TalkRoomLogUtils.B0(r0, null, null, 6);
        goto L6
    }

    public final void o(HashMap<String, String> r9, int r10, int r11, ICircleInfo r12) {
        Intrinsics.checkNotNullParameter(r9, "logMap");
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.A0(r9, Integer.valueOf(r10), Integer.valueOf(r11));
        TalkRoomLogUtils.y0(r9, false);
        TalkRoomLogUtils.Q0(r9);
        if (((Boolean) this.e.get("data_enter_room_is_quick_invite", Boolean.FALSE)).booleanValue() == false) goto L5;
        String r1 = "1";
    L6:
        r9.put("is_quick_invite", r1);
        if (r12 == null) goto L11;
        String r13 = r12.getCircleName();
        if (r13 == null) goto L11;
        r9.put("circle_name", r13);
    L11:
        TalkRoomLogUtils.T0(r9, true);
        com.bytedance.android.livesdk.log.filter.t r2 = j0.l().c(am2.x.class);
        if ((r2 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L24;
        com.bytedance.android.livesdk.log.filter.t r3 = r2;
        String r4 = r3.getRoomTag();
        if (r4 == null) goto L24;
        if (r4.length() <= 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 != true) goto L24;
        String r6 = r3.getRoomTag();
        if (r6 != null) goto L23;
        r6 = "";
    L23:
        r9.put("room_tag", r6);
        goto L24
    L18:
        r5 = false;
    L24:
        IRoom r7 = je0.d.e(null);
        String r8 = "avatar";
        if (r7 == null) goto L43;
        z5 r14 = r7.getLinkerDetail();
        if (r14 == null) goto L43;
        List r15 = r14.getPlayModes();
        if (r15 == null) goto L43;
        if (r15.contains(Long.valueOf(19)) != true) goto L43;
        IRoom r16 = je0.d.e(null);
        if (r16 == null) goto L41;
        z5 r17 = r16.getLinkerDetail();
        if (r17 == null) goto L41;
        List r18 = r17.getFeatureList();
        if (r18 == null) goto L41;
        if (r18.contains(1L) != true) goto L41;
        String r19 = "avatar";
    L42:
        r9.put("play_layout", r19);
    L41:
        r19 = "classic";
    L43:
        r9.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        r9.put("play_mode", u0.b());
        if (r11 == 28) goto L47;
        r8 = "classic";
    L47:
        r9.put("play_layout", r8);
        int r20 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.c(this.e, r9.get("function_type2"), "VoiceChatLogger#scene=" + r10 + ",ui_layout=" + r11);
        j0.l().sendLog("livesdk_audience_voice_room_show", r9, new Object[]{IRoom.class, am2.x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L5:
        r1 = "0";
        goto L6
    }

    public final void p(HashMap<String, String> r3, int r4, int r5, ICircleInfo r6) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.A0(r3, Integer.valueOf(r4), Integer.valueOf(r5));
        TalkRoomLogUtils.y0(r3, false);
        TalkRoomLogUtils.Q0(r3);
        if (((Boolean) this.e.get("data_enter_room_is_quick_invite", Boolean.FALSE)).booleanValue() == false) goto L5;
        String r7 = "1";
    L6:
        r3.put("is_quick_invite", r7);
        if (r6 == null) goto L11;
        String r8 = r6.getCircleName();
        if (r8 == null) goto L11;
        r3.put("circle_name", r8);
    L11:
        TalkRoomLogUtils.T0(r3, true);
        com.bytedance.android.livesdk.log.filter.t r9 = j0.l().c(am2.x.class);
        if ((r9 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L24;
        com.bytedance.android.livesdk.log.filter.t r10 = r9;
        String r1 = r10.getRoomTag();
        if (r1 == null) goto L24;
        if (r1.length() <= 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 != true) goto L24;
        String r11 = r10.getRoomTag();
        if (r11 != null) goto L23;
        r11 = "";
    L23:
        r3.put("room_tag", r11);
        goto L24
    L18:
        r2 = false;
    L24:
        r3.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        j0.l().sendLog("livesdk_audience_voice_room_show_v4", r3, new Object[]{IRoom.class, am2.x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L5:
        r7 = "0";
        goto L6
    }

    public final void v(String r6, String r7, String r8, String r9) {
        if (this.b > 0) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        TalkRoomLogUtils.u0(r0);
        TalkRoomLogUtils.J0(r0);
        if (r6 == null) goto L8;
        r0.put("function_type", r6);
        r0.put("function_type2", r6);
    L9:
        if (r7 == null) goto L11;
        r0.put("layout_type", r7);
    L11:
        if (r8 == null) goto L13;
        r0.put("enlarge_show_type", r8);
    L13:
        if (r9 == null) goto L15;
        r0.put("play_layout", r9);
    L15:
        r0.put("duration", String.valueOf((System.currentTimeMillis() - this.b) / ((long) 1000)));
        this.b = 0;
        j0.l().sendLog("livesdk_voice_room_layout_watch_duration", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L8:
        TalkRoomLogUtils.B0(r0, null, null, 6);
        goto L9
    }

    public final void x(String r3, String r4, String r5, String r6) {
        HashMap r0 = new HashMap();
        TalkRoomLogUtils.u0(r0);
        TalkRoomLogUtils.J0(r0);
        if (r3 == null) goto L5;
        r0.put("function_type", r3);
    L6:
        if (r4 == null) goto L8;
        r0.put("layout_type", r4);
    L8:
        if (r5 == null) goto L10;
        r0.put("enlarge_show_type", r5);
    L10:
        if (r6 == null) goto L12;
        r0.put("play_layout", r6);
    L12:
        this.b = System.currentTimeMillis();
        j0.l().sendLog("livesdk_audience_room_layout_show", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        TalkRoomLogUtils.B0(r0, null, null, 6);
        goto L6
    }

    public static /* synthetic */ void i(k r7, String r8, String r9, String r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r8 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        String r2 = null;
    L10:
        if ((r11 & 8) == 0) goto L12;
        String r4 = null;
    L13:
        r7.h(r8, r2, "layout_type_close", r4, null, null);
        return;
    L12:
        r4 = r10;
        goto L13
    L8:
        r2 = r9;
        goto L10
    }

    public static void t(k r18, Integer r19, Map r20, long r21, int r23) {
        if ((r23 & 4) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r23 & 8) == 0) goto L9;
        Map r3 = null;
    L10:
        long r5 = 0;
        if ((r23 & 16) == 0) goto L13;
        long r7 = 0;
    L14:
        HashMap r4 = new HashMap();
        if (r3 == null) goto L20;
        Iterator r6 = r3.entrySet().iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        Map.Entry r9 = (Map.Entry) r6.next();
        r4.put(r9.getKey(), r9.getValue());
    L20:
        TalkRoomLogUtils.u0(r4);
        TalkRoomLogUtils.J0(r4);
        TalkRoomLogUtils.B0(r4, null, null, 6);
        zi0.d.b(r4, true);
        if (r1 == null) goto L29;
        r4.put("play_mode", u0.k(r1.intValue()));
        if (r7 == 0) goto L25;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r7) / ((long) 1000)));
    L28:
        r18.c.put(r1, null);
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r4, new Object[]{IRoom.class, am2.x.class});
        return;
    L25:
        Long r8 = (Long) ((LinkedHashMap) r18.c).get(r1);
        if (r8 == null) goto L53;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r8.longValue()) / ((long) 1000)));
        goto L28
    L53:
        return;
    L29:
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r2 == null) goto L36;
        LivePlayModeLogContext r10 = (LivePlayModeLogContext) r2.getValue();
        if (r10 == null) goto L36;
        com.bytedance.live.datacontext.m r11 = r10.getPlayModes();
        if (r11 == null) goto L36;
        Set r12 = (Set) r11.getValue();
    L37:
        if (r12 == null) goto L60;
        Iterator r13 = r12.iterator();
    L41:
        if (r13.hasNext() == false) goto L61;
        int r15 = ((Number) r13.next()).intValue();
        if (TalkRoomLogUtils.t0(r15) == false) goto L52;
        r4.put("play_mode", u0.k(r15));
        if (r7 == r5) goto L47;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r7) / ((long) 1000)));
    L50:
        r18.c.put(Integer.valueOf(r15), null);
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r4, new Object[]{IRoom.class, am2.x.class});
        goto L52
    L47:
        Long r14 = (Long) ((LinkedHashMap) r18.c).get(Integer.valueOf(r15));
        if (r14 == null) goto L62;
        r4.put("duration", String.valueOf((System.currentTimeMillis() - r14.longValue()) / ((long) 1000)));
        goto L50
    L62:
        return;
    L52:
        r5 = 0;
        goto L41
    L61:
        return;
    L60:
        return;
    L36:
        r12 = null;
        goto L37
    L13:
        r7 = r21;
        goto L14
    L9:
        r3 = r20;
        goto L10
    L5:
        r1 = r19;
        goto L7
    }

    public static void u(k r8, Integer r9, Map r10, boolean r11, int r12) {
        Set r1 = null;
        if ((r12 & 4) == 0) goto L6;
        r9 = null;
    L6:
        if ((r12 & 8) == 0) goto L9;
        r10 = null;
    L9:
        if ((r12 & 16) == 0) goto L11;
        r11 = false;
    L11:
        HashMap r13 = new HashMap();
        if (r10 == null) goto L17;
        Iterator r14 = r10.entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r14.next();
        r13.put(r2.getKey(), r2.getValue());
    L17:
        TalkRoomLogUtils.u0(r13);
        TalkRoomLogUtils.J0(r13);
        TalkRoomLogUtils.B0(r13, null, null, 6);
        i0 r15 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r13);
        zi0.d.b(r13, false);
        if (r9 == null) goto L22;
        r13.put("play_mode", u0.k(r9.intValue()));
        r8.c.put(r9, Long.valueOf(System.currentTimeMillis()));
        if (r11 == true) goto L39;
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r13, new Object[]{IRoom.class, am2.x.class});
        return;
    L39:
        return;
    L22:
        com.bytedance.live.datacontext.j r16 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r16 == null) goto L29;
        LivePlayModeLogContext r17 = (LivePlayModeLogContext) r16.getValue();
        if (r17 == null) goto L29;
        com.bytedance.live.datacontext.m r18 = r17.getPlayModes();
        if (r18 == null) goto L29;
        r1 = (Set) r18.getValue();
    L29:
        if (r1 == null) goto L49;
        Iterator r19 = r1.iterator();
    L33:
        if (r19.hasNext() == false) goto L50;
        int r3 = ((Number) r19.next()).intValue();
        if (TalkRoomLogUtils.t0(r3) == false) goto L33;
        r13.put("play_mode", u0.k(r3));
        r8.c.put(Integer.valueOf(r3), Long.valueOf(System.currentTimeMillis()));
        if (r11 == true) goto L33;
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r13, new Object[]{IRoom.class, am2.x.class});
        goto L33
    L50:
        return;
    }

    public static /* synthetic */ void w(k r2, String r3, String r4, String r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        r2.v(null, r3, r4, r5);
    }

    public static /* synthetic */ void y(k r2, String r3, String r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        r2.x(r3, r4, r5, null);
    }

    public static /* synthetic */ void g(k r2, String r3, String r4, String r5, String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = null;
    L14:
        r2.f(r3, r4, r5, r6);
    }

    public final void D(String r6, boolean r7, String r8, boolean r9, String r10, List<KtvMusic> r11) {
        Intrinsics.checkNotNullParameter(r6, "clickType");
        HashMap r0 = new HashMap();
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.B0(r0, Integer.valueOf(r1), null, 4);
        r0.put("function_type", "ktv");
        if (a0.d(this.e, false) == false) goto L5;
        String r2 = "anchor";
    L6:
        r0.put("user_type", r2);
        if (r7 == false) goto L9;
        String r12 = "on";
    L10:
        r0.put("button_type", r12);
        r0.put("click_type", r6);
        if (a0.d(this.e, false) == true) goto L52;
        Integer r13 = Integer.valueOf(r1);
        List<KtvMusic> r14 = r11;
        if (r14 != null) goto L15;
    L18:
        boolean r15 = true;
    L19:
        TalkRoomLogUtils.D0(r0, r13, !r15);
        if (r10 != null) goto L22;
        String r16 = "";
    L23:
        r0.put("connect_type", r16);
        int r17 = bh0.a.a;
        if (Intrinsics.areEqual(r8, String.valueOf(101)) == false) goto L27;
        r8 = "seat";
    L46:
        r0.put("request_page", r8);
        if (Intrinsics.areEqual(r10, "apply") == false) goto L52;
        if (r9 == false) goto L50;
        String r18 = "0";
    L51:
        r0.put("is_approve_needed", r18);
        goto L52
    L50:
        r18 = "1";
        goto L51
    L27:
        if (Intrinsics.areEqual(r8, String.valueOf(102)) == false) goto L30;
        r8 = "bottom";
        goto L46
    L30:
        if (Intrinsics.areEqual(r8, String.valueOf(103)) == false) goto L33;
        r8 = "popup";
        goto L46
    L33:
        if (Intrinsics.areEqual(r8, String.valueOf(104)) == false) goto L36;
        r8 = "seat_popup";
        goto L46
    L36:
        if (Intrinsics.areEqual(r8, String.valueOf(113)) == false) goto L39;
        r8 = "card";
        goto L46
    L39:
        if (Intrinsics.areEqual(r8, String.valueOf(114)) == false) goto L42;
    L45:
        r8 = "live_song";
        goto L46
    L42:
        if (tc0.c.h().J == 114) goto L45;
        if (r8 != null) goto L46;
        r8 = "";
        goto L46
    L22:
        r16 = r10;
        goto L23
    L15:
        if (r14.isEmpty() == true) goto L18;
        r15 = false;
    L52:
        j0.l().sendLog("livesdk_audience_connection_user_camera_open_click", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L9:
        r12 = "off";
        goto L10
    L5:
        r2 = "guest";
        goto L6
    }

    public final void h(String r6, String r7, String r8, String r9, Integer r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r8, "closeType");
        if (this.a > 0) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        TalkRoomLogUtils.u0(r0);
        TalkRoomLogUtils.J0(r0);
        if (r6 == null) goto L8;
        r0.put("function_type", r6);
        r0.put("function_type2", r6);
    L9:
        if (r7 == null) goto L11;
        r0.put("layout_type", r7);
    L11:
        if (r9 != null) goto L13;
        r9 = "normal";
    L13:
        r0.put("enlarge_show_type", r9);
        r0.put("close_type", r8);
        r0.put("duration", String.valueOf((System.currentTimeMillis() - this.a) / ((long) 1000)));
        this.a = 0;
        Map<r0, String> r12 = TalkRoomLogUtils.f;
        if (r10 == null) goto L16;
        int r13 = r10.intValue();
    L17:
        if (r11 == null) goto L19;
        int r1 = r11.intValue();
    L20:
        LinkedHashMap r14 = (LinkedHashMap) r12;
        String r15 = (String) r14.get(new r0(r13, r1));
        if (r15 != null) goto L23;
    L35:
        String r16 = TalkRoomLogUtils.d;
        if (r16 == null) goto L38;
        r0.put("source", r16);
    L38:
        Integer r17 = je0.d.h();
        if (r17 != null) goto L42;
    L44:
        String r18 = "classic";
    L45:
        r0.put("play_layout", r18);
        HamletAvatarContext r19 = HamletAvatarContext.Companion.getContext();
        if (r19 == null) goto L54;
        com.bytedance.live.datacontext.j<gd0.g> r20 = r19.getHamletAvatarService();
        if (r20 == null) goto L54;
        gd0.g r21 = (gd0.g) r20.getValue();
        if (r21 == null) goto L54;
        Long r22 = r21.Ue();
        if (r22 == null) goto L54;
        r0.put("avatar_id", String.valueOf(r22.longValue()));
    L54:
        String r23 = qi0.c.b;
        qi0.c.k("source", r0);
        j0.l().sendLog("livesdk_anchor_layout_type_over", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L42:
        if (r17.intValue() != 28) goto L44;
        r18 = "avatar";
        goto L45
    L23:
        if (r2.a(r15) != true) goto L35;
        if (r10 == null) goto L27;
        int r110 = r10.intValue();
    L28:
        if (r11 == null) goto L30;
        int r111 = r11.intValue();
    L31:
        String r24 = (String) r14.get(new r0(r110, r111));
        if (r24 != null) goto L34;
        r24 = "";
    L34:
        r0.put("source", r24);
        goto L38
    L30:
        r111 = 0;
        goto L31
    L27:
        r110 = 0;
        goto L28
    L19:
        r1 = 0;
        goto L20
    L16:
        r13 = 0;
        goto L17
    L8:
        TalkRoomLogUtils.B0(r0, null, null, 6);
        goto L9
    }

    public static void B(String r4, String r5, LinkApplyType r6, String r7, String r8, long r9, String r11) {
        HashMap r0 = new HashMap();
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.u0(r0);
        r0.put("function_type2", TalkRoomLogUtils.h);
        r0.put("from_user_id", r7);
        if (r4 != null) goto L5;
        String r2 = "";
    L6:
        r0.put("connect_type", r2);
        if (Intrinsics.areEqual(r4, "invite") == false) goto L18;
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L13;
        IRoom r12 = (IRoom) r10.getValue();
        if (r12 == null) goto L13;
        String r13 = r12.getOwnerUserIdString();
    L15:
        if (Intrinsics.areEqual(r7, r13) == false) goto L17;
        r0.put("from_user_type", "anchor");
    L19:
        String r14 = "live_song";
        if (TextUtils.isEmpty(r5) == true) goto L65;
        int r15 = bh0.a.a;
        if (Intrinsics.areEqual(r5, String.valueOf(101)) == false) goto L25;
        r0.put("request_page", "seat");
    L74:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L76;
        r0.put("request_page", tc0.c.h().L.getValue());
    L76:
        r0.put("error_code", String.valueOf(r9));
        r0.put("error_msg", String.valueOf(r11));
        j0.l().sendLog("livesdk_guest_connection_failed", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L25:
        if (Intrinsics.areEqual(r5, String.valueOf(102)) == false) goto L28;
        r0.put("request_page", "bottom");
        goto L74
    L28:
        if (Intrinsics.areEqual(r5, String.valueOf(103)) == false) goto L31;
        r0.put("request_page", "popup");
        goto L74
    L31:
        if (Intrinsics.areEqual(r5, String.valueOf(104)) == false) goto L34;
        r0.put("request_page", "seat_popup");
        goto L74
    L34:
        if (Intrinsics.areEqual(r5, String.valueOf(109)) == false) goto L37;
        r0.put("request_page", "emoji_panel");
        goto L74
    L37:
        if (Intrinsics.areEqual(r5, String.valueOf(108)) == false) goto L40;
        r0.put("request_page", "pre_link_seat");
        goto L74
    L40:
        if (Intrinsics.areEqual(r5, String.valueOf(110)) == false) goto L43;
        r0.put("request_page", "task");
        goto L74
    L43:
        if (Intrinsics.areEqual(r5, String.valueOf(112)) == false) goto L46;
        r0.put("request_page", "apply_panel");
        goto L74
    L46:
        if (Intrinsics.areEqual(r5, String.valueOf(113)) == false) goto L49;
        r0.put("request_page", "card");
        goto L74
    L49:
        if (Intrinsics.areEqual(r5, String.valueOf(114)) == false) goto L55;
        if (r6 != LinkApplyType.KTV_MULTI_CHORUS) goto L53;
        r14 = "live_chorus";
    L53:
        r0.put("request_page", r14);
        goto L74
    L55:
        if (Intrinsics.areEqual(r5, String.valueOf(115)) == false) goto L58;
        r0.put("request_page", "associated_apply");
        goto L74
    L58:
        if (tc0.c.h().J == 114) goto L61;
        Intrinsics.checkNotNull(r5);
        r0.put("request_page", r5);
        goto L74
    L61:
        if (r6 != LinkApplyType.KTV_MULTI_CHORUS) goto L63;
        r14 = "live_chorus";
    L63:
        r0.put("request_page", r14);
        goto L74
    L65:
        if (TextUtils.isEmpty(r8) == true) goto L70;
        if (r8 != null) goto L68;
        r8 = "";
    L68:
        r0.put("request_page", r8);
        goto L74
    L70:
        if (tc0.c.h().J == 114) goto L72;
        r0.put("request_page", "");
        goto L74
    L72:
        r0.put("request_page", "live_song");
        goto L74
    L17:
        r0.put("from_user_type", "admin");
    L13:
        r13 = null;
        goto L15
    L18:
        r0.put("from_user_type", "");
        goto L19
    L5:
        r2 = r4;
        goto L6
    }

    public static /* synthetic */ void k(k r9, long r10, int r12, Integer r13, boolean r14, ICircleInfo r15, String r16) {
        r9.j(r10, r12, r13, r14, r15, r16, null);
    }

    public final void j(long r18, int r20, Integer r21, boolean r22, ICircleInfo r23, String r24, String r25) {
        HashMap r5 = new HashMap();
        TalkRoomLogUtils.A0(r5, Integer.valueOf(r20), r21);
        if (r20 != 5) goto L8;
        if (r21 == null) goto L8;
        if (r21.intValue() != 22) goto L8;
        r5.put("function_type", "party");
    L8:
        String r8 = "0";
        String r9 = "on";
        String r11 = "";
        if (r20 != 9) goto L16;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.R0.getValue()).booleanValue() == false) goto L13;
        Object r6 = "on";
    L14:
        r5.put("is_camera_allow", r6);
        r5.put("camera_duration", "");
        r5.put("is_avatar_used", "0");
        goto L16
    L13:
        r6 = "off";
    L16:
        if (r18 <= 0) goto L19;
        r5.put("duration", String.valueOf((SystemClock.elapsedRealtime() - r18) / ((long) 1000)));
    L19:
        if (tc0.c.h().d <= 0) goto L21;
        int r7 = tc0.c.h().d - 1;
    L22:
        r5.put("connect_pcu", String.valueOf(r7));
        TalkRoomBusinessFullLinkMonitor r14 = TalkRoomBusinessFullLinkMonitor.a;
        long r12 = SystemClock.elapsedRealtime() - r18;
        r14.getClass();
        TalkRoomBusinessFullLinkMonitor.s0(r12, r7);
        tc0.c.h().d = 0;
        r5.put("over_type", "anchor");
        r5.put("send_gift_scene", ((IInteractService) jc1.k.n(IInteractService.class)).changeMode2String(8));
        if (((Boolean) this.e.get("data_audio_chat_support_send_gift_to_linker", Boolean.TRUE)).booleanValue() == false) goto L25;
        Object r10 = "on";
    L26:
        r5.put("gift_guest_switch_type", r10);
        r5.put("play_shoot_switch_type", "off");
        if (r22 == false) goto L29;
        TalkRoomLogUtils.b(r5);
    L29:
        TalkRoomLogUtils.a(r5, false);
        com.bytedance.android.livesdk.log.filter.t r13 = j0.l().c(am2.x.class);
        boolean r15 = r13 instanceof com.bytedance.android.livesdk.log.filter.t;
        if (r15 == true) goto L32;
    L34:
        r5.put("shoot_way", this.e.get("data_voice_chat_room_shoot_way", "null"));
        String r16 = (String) this.e.get("data_voice_chat_room_close_page", "");
        if (TextUtils.isEmpty(r16) == true) goto L37;
        r5.put("close_page", r16);
        this.e.put("data_voice_chat_room_close_page", "");
    L37:
        String r17 = (String) this.e.get("data_room_video_talk_log_over_for_over_path", "");
        if (r2.a(r17) == false) goto L40;
        r5.put("over_path", r17);
        this.e.put("data_room_video_talk_log_over_for_over_path", "");
    L40:
        if (r23 == null) goto L44;
        String r19 = r23.getCircleName();
        if (r19 == null) goto L44;
        r5.put("circle_name", r19);
    L44:
        TalkRoomLogUtils.b1(r5, Integer.valueOf(je0.d.f()));
        r5.put("play_mode", u0.b());
        com.bytedance.android.livesdk.sharedpref.e r110 = b6.c0;
        if (((Boolean) r110.getValue()).booleanValue() == false) goto L47;
        com.bytedance.android.livesdk.sharedpref.f.d(r110, Boolean.FALSE);
    L48:
        r5.put("rechargeable_mode_status", r9);
        i0 r26 = TalkRoomLogUtils.a;
        Map<r0, String> r27 = TalkRoomLogUtils.f;
        if (r21 == null) goto L51;
        int r111 = r21.intValue();
    L52:
        LinkedHashMap r28 = (LinkedHashMap) r27;
        String r112 = (String) r28.get(new r0(r20, r111));
        if (r112 != null) goto L55;
    L65:
        String r1 = TalkRoomLogUtils.d;
        if (r1 == null) goto L69;
        r5.put("source", r1);
    L69:
        if (r15 == false) goto L76;
        com.bytedance.android.livesdk.log.filter.t r29 = r13;
        if (r29.getMap().containsKey("enter_from") == false) goto L76;
        if (TextUtils.equals((CharSequence) r29.getMap().get("enter_from"), "chat_match") == false) goto L76;
        r5.put("source", "chat_match");
    L76:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L78;
        r8 = "1";
    L78:
        r5.put("is_invite_only", r8);
        if (vm2.d.v0() == true) goto L81;
    L83:
        if (r25 == null) goto L85;
        r5.put("layout_type", r25);
    L85:
        com.bytedance.android.livesdk.log.filter.o r2 = j0.l().c(am2.x.class);
        if (r2 == null) goto L90;
        Map r3 = r2.getMap();
        if (r3 == null) goto L90;
        String r4 = (String) r3.get("enter_from");
    L92:
        if (Intrinsics.areEqual(r4, "group_live") == false) goto L95;
        r5.put("source", "group_live");
    L95:
        if (r2.a(TalkRoomLogUtils.n) == false) goto L97;
        r5.put("source", TalkRoomLogUtils.n);
        r5.put("game_id", TalkRoomLogUtils.o);
        r5.put("game_name", TalkRoomLogUtils.p);
        TalkRoomLogUtils.n1();
    L97:
        String r30 = qi0.c.b;
        qi0.c.k("source", r5);
        j0 r31 = j0.l();
        am2.x r32 = new am2.x();
        r32.b = "live_detail";
        r32.a = "live";
        r32.e = "click";
        r31.sendLog("anchor_audience_connection_over", r5, new Object[]{r32, IRoom.class, am2.x.class});
        return;
    L90:
        r4 = null;
        goto L92
    L81:
        if (TextUtils.isEmpty(r24) == true) goto L83;
        Intrinsics.checkNotNull(r24);
        r5.put("function_type", r24);
        r5.put("function_type2", r24);
        goto L83
    L55:
        if (r2.a(r112) != true) goto L65;
        if (r21 == null) goto L59;
        int r33 = r21.intValue();
    L60:
        String r34 = (String) r28.get(new r0(r20, r33));
        if (r34 == null) goto L64;
        r11 = r34;
    L64:
        r5.put("source", r11);
        goto L69
    L59:
        r33 = 0;
        goto L60
    L51:
        r111 = 0;
        goto L52
    L47:
        r9 = "off";
        goto L48
    L32:
        if (r13.j() == false) goto L34;
        r5.put("is_continue", "continue");
        goto L34
    L25:
        r10 = "off";
        goto L26
    L21:
        r7 = 0;
        goto L22
    }

    public final void q(HashMap<String, String> r6, long r7, int r9, Integer r10, String r11, ICircleInfo r12, boolean r13, li0.b.a r14) {
        Intrinsics.checkNotNullParameter(r6, "params");
        r6.put("duration", String.valueOf(r7));
        TalkRoomLogUtils.A0(r6, Integer.valueOf(r9), r10);
        if (vm2.d.v0() == false) goto L8;
        if (TextUtils.isEmpty(r11) == true) goto L8;
        Intrinsics.checkNotNull(r11);
        r6.put("function_type", r11);
        r6.put("function_type2", r11);
    L8:
        if (((Boolean) this.e.get("data_enter_room_is_quick_invite", Boolean.FALSE)).booleanValue() == false) goto L10;
        String r8 = "1";
    L11:
        r6.put("is_quick_invite", r8);
        TalkRoomLogUtils.Q0(r6);
        if (r13 == false) goto L14;
        ii0.a.a(r6);
    L14:
        if (r12 == null) goto L18;
        String r15 = r12.getCircleName();
        if (r15 == null) goto L18;
        r6.put("circle_name", r15);
    L18:
        com.bytedance.android.live.liveinteract.plantform.core.y r16 = (com.bytedance.android.live.liveinteract.plantform.core.y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r16 == null) goto L21;
        int r1 = r16.n();
    L22:
        if (r1 <= 0) goto L24;
        String r2 = "1";
    L25:
        r6.put("is_set_seat_name", r2);
        IRoom r3 = null;
        if (r16 == null) goto L28;
        Integer r17 = Integer.valueOf(r16.n());
    L29:
        r6.put("seat_num", String.valueOf(r17));
        if (e.a(false) == false) goto L32;
        r6.put("is_pre_link", "1");
    L33:
        String r18 = "off";
        r6.put("seat_fit_status", "off");
        if (r14 != null) goto L36;
    L38:
        com.bytedance.live.datacontext.m r19 = com.bytedance.android.live.liveinteract.api.utils.m.i().X1();
        if (r19 != null) goto L41;
    L42:
        com.bytedance.live.datacontext.m r20 = com.bytedance.android.live.liveinteract.api.utils.m.i().n2();
        if (r20 != null) goto L45;
    L47:
        r6.put("earphone_status", r18);
        r6.put("play_mode", u0.b());
        i0 r21 = TalkRoomLogUtils.a;
        r6.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        TalkRoomLogUtils.T0(r6, true);
        int r22 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.b.a(this.e, r6.get("function_type2"), "VoiceChatLogger#scene=" + r9 + ",ui_layout=" + r10) == false) goto L60;
        HashMap<String, String> r23 = new HashMap();
        r23.put("ui_widget_source", "FallbackLog on logger");
        if (vm2.h.R() == false) goto L56;
        DataCenter r24 = this.e;
        if (r24 == null) goto L54;
        r3 = a0.o(r24);
    L54:
        if (r3 == null) goto L56;
        r23.put("room_id", String.valueOf(r3.getId()));
        r23.put("anchor_id", String.valueOf(r3.getAnchorId()));
        LiveMode r25 = r3.getStreamType();
        int r110 = h1.a;
        r23.put("live_type", i1.a(r25));
    L56:
        if (r10 == null) goto L58;
        int r26 = r10.intValue();
    L59:
        o(r23, r9, r26, r12);
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.b(this.e, "VoiceChatLogger#scene=" + r9 + ",ui_layout=" + r10);
        goto L60
    L58:
        r26 = 0;
    L60:
        j0.l().sendLog("livesdk_voice_room_watch_duration", r6, new Object[]{IRoom.class, am2.x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L45:
        if (((Boolean) r20.getValue()).booleanValue() != true) goto L47;
    L46:
        r18 = "on";
        goto L47
    L41:
        if (((Boolean) r19.getValue()).booleanValue() == true) goto L46;
    L36:
        if (r9 != 5) goto L38;
        r6.put("grouppk_duration", String.valueOf(r14.a));
        r6.put("grouppk_stage", r14.b);
        goto L38
    L32:
        r6.put("is_pre_link", "0");
        goto L33
    L28:
        r17 = null;
        goto L29
    L24:
        r2 = "0";
        goto L25
    L21:
        r1 = 0;
        goto L22
    L10:
        r8 = "0";
        goto L11
    }

    public static void m(k r6, String r7, Integer r8, Integer r9, Integer r10, Integer r11, String r12, String r13, Map r14, int r15) {
        if ((r15 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r8 = null;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r9 = null;
    L12:
        if ((r15 & 16) == 0) goto L15;
        r10 = null;
    L15:
        if ((r15 & 32) == 0) goto L18;
        r11 = null;
    L18:
        if ((r15 & 64) == 0) goto L21;
        r12 = null;
    L21:
        if ((r15 & 128) == 0) goto L24;
        r13 = null;
    L24:
        if ((r15 & 256) == 0) goto L26;
        r14 = null;
    L26:
        HashMap r16 = new HashMap();
        if (r14 == null) goto L32;
        Iterator r17 = r14.entrySet().iterator();
    L30:
        if (r17.hasNext() == false) goto L32;
        Map.Entry r0 = (Map.Entry) r17.next();
        r16.put(r0.getKey(), r0.getValue());
    L32:
        TalkRoomLogUtils.u0(r16);
        TalkRoomLogUtils.J0(r16);
        TalkRoomLogUtils.B0(r16, null, null, 6);
        if (r7 == null) goto L35;
        r16.put("layout_type", r7);
    L35:
        r16.put("guess_cnt", String.valueOf(r9));
        r16.put("income_cnt", String.valueOf(r10));
        r16.put("user_id", String.valueOf(r12));
        if (r13 == null) goto L38;
        String r18 = (String) r16.put("user_type", r13);
    L38:
        if (r11 == null) goto L40;
        int r19 = r11.intValue();
        i0 r20 = TalkRoomLogUtils.a;
        String r21 = TalkRoomLogUtils.r1(r19);
    L41:
        if (r21 == null) goto L43;
        String r22 = (String) r16.put("result", r21);
    L43:
        Map<Integer, String> r23 = TalkRoomLogUtils.g;
        if (r8 == null) goto L46;
        int r110 = r8.intValue();
    L47:
        LinkedHashMap r24 = (LinkedHashMap) r23;
        if (TextUtils.isEmpty((CharSequence) r24.get(Integer.valueOf(r110))) == true) goto L56;
        if (r8 == null) goto L51;
        int r111 = r8.intValue();
    L52:
        String r25 = (String) r24.get(Integer.valueOf(r111));
        if (r25 != null) goto L55;
        r25 = "";
    L55:
        r16.put("source", r25);
        goto L56
    L51:
        r111 = 0;
    L56:
        r16.put("is_link_room", TalkRoomLogUtils.s);
        zi0.d.b(r16, true);
        if (r8 == null) goto L61;
        r16.put("play_mode", u0.k(r8.intValue()));
        Long r112 = (Long) ((LinkedHashMap) r6.d).get(r8);
        if (r112 == null) goto L79;
        r16.put("duration", String.valueOf((System.currentTimeMillis() - r112.longValue()) / ((long) 1000)));
        r6.d.put(r8, null);
        j0.l().sendLog("livesdk_anchor_playmode_over", r16, new Object[]{IRoom.class, am2.x.class});
        return;
    L79:
        return;
    L61:
        com.bytedance.live.datacontext.j r26 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r26 == null) goto L68;
        LivePlayModeLogContext r27 = (LivePlayModeLogContext) r26.getValue();
        if (r27 == null) goto L68;
        com.bytedance.live.datacontext.m r28 = r27.getPlayModes();
        if (r28 == null) goto L68;
        Set r29 = (Set) r28.getValue();
    L69:
        if (r29 == null) goto L88;
        Iterator r30 = r29.iterator();
    L73:
        if (r30.hasNext() == false) goto L89;
        int r1 = ((Number) r30.next()).intValue();
        if (TalkRoomLogUtils.t0(r1) == false) goto L73;
        r16.put("play_mode", u0.k(r1));
        Long r2 = (Long) ((LinkedHashMap) r6.d).get(Integer.valueOf(r1));
        if (r2 == null) goto L90;
        r16.put("duration", String.valueOf((System.currentTimeMillis() - r2.longValue()) / ((long) 1000)));
        r6.d.put(Integer.valueOf(r1), null);
        j0.l().sendLog("livesdk_anchor_playmode_over", r16, new Object[]{IRoom.class, am2.x.class});
        goto L73
    L90:
        return;
    L89:
        return;
    L88:
        return;
    L68:
        r29 = null;
        goto L69
    L46:
        r110 = 0;
        goto L47
    L40:
        r21 = null;
        goto L41
    }

    public final void A(String r19, boolean r20, String r21, int r22, List r23, String r24, boolean r25, boolean r26, ICircleInfo r27, Long r28, Long r29, Long r30, String r31, String r32, LinkApplyType r33, IMessageBoardInfo r34, String r35, String r36) {
        HashMap r8 = new HashMap();
        if (TextUtils.isEmpty(r19) == true) goto L55;
        int r7 = bh0.a.a;
        if (Intrinsics.areEqual(r19, String.valueOf(101)) == false) goto L8;
        r8.put("request_page", "seat");
    L68:
        if (tc0.c.h().I.booleanValue() == false) goto L71;
        r8.put("source", "pre_apply");
    L71:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L73;
        r8.put("request_page", tc0.c.h().L.getValue());
    L73:
        String r6 = tc0.c.h().M;
        String r9 = "1";
        if (TextUtils.isEmpty(r6) == true) goto L76;
        r8.put("is_task", "1");
        r8.put("activity_name", r6);
    L76:
        r8.put("is_priority_sing", "0");
        if (r21 != null) goto L79;
        String r10 = "";
    L80:
        r8.put("connect_type", r10);
        if (Intrinsics.areEqual(r21, "apply") == false) goto L87;
        if (r20 == false) goto L85;
        r8.put("is_approve_needed", "0");
        goto L87
    L85:
        r8.put("is_approve_needed", "1");
    L87:
        if (Intrinsics.areEqual(r21, "gift_message_invite") == false) goto L91;
        if (r34 == null) goto L91;
        r8.put("message_text", f0.a(r34));
        Unit r11 = Unit.INSTANCE;
    L91:
        String r15 = "off";
        if (((Boolean) this.e.get("data_audio_chat_support_send_gift_to_linker", Boolean.TRUE)).booleanValue() == false) goto L94;
        Object r12 = "on";
    L95:
        r8.put("gift_guest_switch_type", r12);
        List r13 = r23;
        if (r13 != null) goto L98;
    L101:
        boolean r17 = true;
    L102:
        if (r17 == true) goto L107;
        if (r24 != null) goto L105;
        String r14 = "";
    L106:
        r8.put("from_request_type", r14);
        i0 r16 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.a1(r8, r23);
    L108:
        int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r31 == null) goto L111;
        r8.put("function_type", r31);
    L112:
        Unit r4 = Unit.INSTANCE;
        if (r32 == null) goto L116;
        r8.put("layout_type", r32);
    L116:
        if (Intrinsics.areEqual((String) r8.get("request_page"), "live_song") == false) goto L118;
    L128:
        r8.put("guest_connection_type", "live_song");
    L129:
        if (r25 == false) goto L131;
        Object r5 = "1";
    L132:
        r8.put("is_candidate", r5);
        if (r26 == false) goto L135;
        Object r18 = "1";
    L136:
        r8.put("is_fans_guide", r18);
        if (r26 == false) goto L139;
        Object r37 = "1";
    L140:
        r8.put("is_full", r37);
        r8.put("link_cnt", String.valueOf(r22));
        com.bytedance.android.livesdk.log.filter.t r38 = j0.l().c(am2.x.class);
        if (r38 != null) goto L143;
    L156:
        i0 r39 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.y0(r8, true);
        if (((Boolean) this.e.get("data_link_mic_is_quick_invite", Boolean.FALSE)).booleanValue() == false) goto L159;
        Object r40 = "1";
    L160:
        r8.put("is_quick_invite", r40);
        gk0.a.b.getClass();
        r8.put("previous_page", gk0.a.C0214a.c());
        TalkRoomLogUtils.v0(r8);
        TalkRoomLogUtils.L0(r8);
        if (r27 == null) goto L165;
        String r41 = r27.getCircleName();
        if (r41 == null) goto L165;
        r8.put("circle_name", r41);
    L165:
        TalkRoomLogUtils.Z0(r8);
        TalkRoomLogUtils.N0(r8, r19, false);
        if (e.a(false) == false) goto L168;
        r8.put("is_pre_link", "1");
    L168:
        li0.b r1 = li0.b.b;
        li0.b.k(r8);
        TalkRoomLogUtils.T0(r8, false);
        r8.put("ordering_mode", TalkRoomLogUtils.v());
        n0 r2 = tc0.c.h().P;
        if (r2 == null) goto L193;
        String r42 = r2.getFanTicket();
        if (r42 != null) goto L173;
        r42 = "0";
    L173:
        r8.put("money", r42);
        long r43 = r2.getRank();
        if (r43 != 1) goto L177;
        String r44 = "top1";
    L183:
        r8.put("top_r", r44);
        IBaseUser r45 = r2.getUserFlex();
        if (r45 == null) goto L186;
        String r46 = r45.getRelationship();
    L187:
        r8.put("relationship", String.valueOf(r46));
        IBaseUser r47 = r2.getUserFlex();
        if (r47 == null) goto L190;
        Integer r48 = Integer.valueOf(r47.getLevel());
    L191:
        r8.put("contribution_level", String.valueOf(r48));
        r8.put("connect_order", String.valueOf(r2.getOffset()));
        goto L193
    L190:
        r48 = null;
        goto L191
    L186:
        r46 = null;
        goto L187
    L177:
        if (r43 != 2) goto L180;
        r44 = "top2";
        goto L183
    L180:
        if (r43 != 3) goto L182;
        r44 = "top3";
        goto L183
    L182:
        r44 = "null";
    L193:
        if (Intrinsics.areEqual(r21, "invite") == false) goto L195;
    L200:
        boolean r49 = true;
    L201:
        if (r49 == true) goto L203;
    L216:
        if (r28 == null) goto L220;
        long r50 = r28.longValue();
        if (r8.containsValue("invite_mutual") == true) goto L220;
        r8.put("wait_time", String.valueOf(r50));
    L220:
        if (r29 == null) goto L222;
        r8.put("watch_duration", String.valueOf(r29.longValue()));
    L222:
        String r51 = tc0.c.h().F;
        if (r51 != null) goto L225;
        r51 = "";
    L225:
        r8.put("apply_reason", r51);
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == true) goto L228;
    L230:
        Object r52 = r7;
    L231:
        r8.put("is_rechargeble", r52);
        r8.put("play_mode", u0.b());
        b1 r53 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        fj0.a r54 = fj0.b.a;
        r8.put("rechargeable_label", fj0.b.i(r53.getSavedTagInfos()));
        r8.put("rechargeable_intro", r53.getSavedDesc());
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L279;
        fj0.a r55 = fj0.b.a;
        if (r55.b == false) goto L236;
        r8.put("recharge_mode", "normal");
    L236:
        int r56 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().a;
        r8.put("recharge_price", String.valueOf(r56));
        r8.put("time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.f()));
        com.bytedance.android.livesdk.chatroom.o r57 = this.f;
        if (r57 == null) goto L241;
        com.bytedance.live.datacontext.m r58 = r57.getRoom();
        if (r58 == null) goto L241;
        IRoom r59 = (IRoom) r58.getValue();
    L243:
        if (fj0.e.g(r59) == false) goto L254;
        n0 r60 = tc0.c.h().P;
        if (r60 == null) goto L247;
        long r110 = r60.getPaidAmount();
    L248:
        long r111 = r110 - ((long) r56);
        if (r111 < 0) goto L251;
        String r61 = String.valueOf(r111);
    L252:
        r8.put("add_price", r61);
        goto L254
    L251:
        r61 = String.valueOf(r55.f);
        goto L252
    L247:
        r110 = 0;
    L254:
        if (fj0.e.d() == false) goto L256;
        r8.put("anonymous_switch", "on");
    L257:
        PaidLinkMicContext r62 = PaidLinkMicContext.Companion.getContext();
        if (r62 == null) goto L264;
        com.bytedance.live.datacontext.m<Integer> r63 = r62.getDiscountMode();
        if (r63 == null) goto L264;
        Integer r65 = (Integer) r63.getValue();
        if (r65 == null) goto L264;
        int r66 = r65.intValue();
    L266:
        if (r66 != 1) goto L268;
        String r112 = "vip";
    L275:
        r8.put("discount_type", r112);
        E(r8, r56, r66);
        if (r55.g == false) goto L279;
        r8.put("is_vip_recharge_privilege", "1");
        goto L279
    L268:
        if (r66 != 2) goto L270;
        r112 = "activity";
        goto L275
    L270:
        if (r66 == 3) goto L272;
        r112 = "";
        goto L275
    L272:
        r112 = "strategy";
    L264:
        r66 = 0;
        goto L266
    L256:
        r8.put("anonymous_switch", r15);
    L241:
        r59 = null;
    L279:
        if (g1.b() == false) goto L281;
        Object r67 = "1";
    L282:
        r8.put("is_priority_queue", r67);
        if (g1.b() == false) goto L289;
        n0 r68 = tc0.c.h().P;
        if (r68 == null) goto L287;
        long r69 = r68.getPaidAmount();
    L288:
        String r70 = String.valueOf(r69);
    L290:
        r8.put("pay_amt", r70);
        if (r30 == null) goto L295;
        long r71 = r30.longValue();
        if (r71 <= 0) goto L295;
        r8.put("tag_type", String.valueOf(r71));
    L295:
        String r72 = tc0.c.h().H;
        if (r72 != null) goto L298;
    L301:
        boolean r73 = true;
    L302:
        if (r73 == true) goto L304;
        Object r74 = "connect_type";
        r8.put(r74, tc0.c.h().H);
    L305:
        InteractiveSongLoggerKt.b(r8);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L308;
        Object r75 = "1";
    L309:
        r8.put("is_invite_only", r75);
        TalkRoomLogUtils.E0(r8);
        ii0.a.c(r8, true);
        com.bytedance.live.datacontext.m r76 = com.bytedance.android.live.liveinteract.api.utils.m.i().getEnterRoomParams();
        if (r76 == null) goto L324;
        Map r77 = (Map) r76.getValue();
        if (r77 == null) goto L324;
        if (r77.containsKey("enter_source") != true) goto L324;
        com.bytedance.live.datacontext.m r78 = com.bytedance.android.live.liveinteract.api.utils.m.i().getEnterRoomParams();
        if (r78 == null) goto L324;
        Map r79 = (Map) r78.getValue();
        if (r79 == null) goto L324;
        String r80 = (String) r79.get("enter_source");
        if (r80 == null) goto L324;
        if (StringsKt.contains$default(r80, "chat_match", false, 2, null) != true) goto L324;
        r8.put(r74, "chat_match");
    L324:
        li0.b.i(r8);
        if (jc0.a.a == false) goto L327;
        Object r81 = "1";
    L328:
        r8.put("is_lead_singer", r81);
        if (jc0.a.b == false) goto L331;
        Object r82 = "1";
    L332:
        r8.put("is_setting_lead", r82);
        if (b() == true) goto L336;
        r9 = r7;
    L336:
        r8.put("is_fixed_guest", r9);
        r8.put("current_enlarge_user_type", TalkRoomLogUtils.o(Integer.valueOf(TalkRoomLogUtils.b.a)));
        IInteractService r83 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r83 == null) goto L341;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r84 = r83.getLinkUserInfoCenter();
        if (r84 == null) goto L341;
        TalkRoomLogUtils.G0(r84.O4(je0.d.b0()), r8);
    L341:
        String r85 = qi0.c.b;
        qi0.c.k("request_page", r8);
        String r86 = qi0.a.a;
        qi0.a.i = System.currentTimeMillis();
        j0.l().sendLog("livesdk_guest_connection_success", r8, new Object[]{IRoom.class, am2.x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L331:
        r82 = r7;
        goto L332
    L327:
        r81 = r7;
        goto L328
    L308:
        r75 = r7;
        goto L309
    L304:
        r74 = "connect_type";
        goto L305
    L298:
        if (StringsKt.isBlank(r72) == true) goto L301;
        r73 = false;
        goto L302
    L287:
        r69 = 0;
        goto L288
    L289:
        r70 = r7;
        goto L290
    L281:
        r67 = r7;
        goto L282
    L228:
        if (fj0.b.a.b == false) goto L230;
        r52 = "1";
        goto L231
    L203:
        if (r2.a(r35) == false) goto L216;
        if (r8.get("from_user_id") != null) goto L216;
        r8.put("from_user_id", String.valueOf(r35));
        com.bytedance.live.datacontext.m r87 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r87 == null) goto L211;
        IRoom r88 = (IRoom) r87.getValue();
        if (r88 == null) goto L211;
        String r89 = r88.getOwnerUserIdString();
    L213:
        if (Intrinsics.areEqual(r35, r89) == false) goto L215;
        r8.put("from_user_type", "anchor");
        goto L216
    L215:
        r8.put("from_user_type", "admin");
    L211:
        r89 = null;
        goto L213
    L195:
        if (Intrinsics.areEqual(r21, "game_invite") == true) goto L200;
        if (Intrinsics.areEqual(r21, "gift_message_invite") == true) goto L200;
        r49 = false;
        goto L201
    L159:
        r40 = r7;
        goto L160
    L143:
        if ((r38 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L156;
        com.bytedance.android.livesdk.log.filter.t r90 = r38;
        String r91 = r90.b();
        if (r91 != null) goto L147;
    L150:
        boolean r92 = true;
    L151:
        if (r92 == true) goto L156;
        String r93 = r90.b();
        if (r93 != null) goto L155;
        r93 = "";
    L155:
        r8.put("previous_page", r93);
        goto L156
    L147:
        if (r91.length() == 0) goto L150;
        r92 = false;
        goto L151
    L139:
        r37 = r7;
        goto L140
    L135:
        r18 = r7;
        goto L136
    L131:
        r5 = r7;
        goto L132
    L118:
        if (Intrinsics.areEqual((String) r8.get("request_page"), "live_chorus") == true) goto L128;
        Integer r94 = Integer.valueOf(r3);
        if (r13 != null) goto L123;
    L126:
        boolean r95 = true;
    L127:
        TalkRoomLogUtils.D0(r8, r94, !r95);
        goto L129
    L123:
        if (r13.isEmpty() == true) goto L126;
        r95 = false;
        goto L127
    L111:
        TalkRoomLogUtils.B0(r8, null, null, 6);
        goto L112
    L105:
        r14 = r24;
        goto L106
    L107:
        r15 = "off";
        goto L108
    L98:
        if (r13.isEmpty() == true) goto L101;
        r17 = false;
        goto L102
    L94:
        r12 = "off";
        goto L95
    L79:
        r10 = r21;
        goto L80
    L8:
        if (Intrinsics.areEqual(r19, String.valueOf(102)) == false) goto L11;
        r8.put("request_page", "bottom");
        goto L68
    L11:
        if (Intrinsics.areEqual(r19, String.valueOf(103)) == false) goto L14;
        r8.put("request_page", "popup");
        goto L68
    L14:
        if (Intrinsics.areEqual(r19, String.valueOf(104)) == false) goto L17;
        r8.put("request_page", "seat_popup");
        goto L68
    L17:
        if (Intrinsics.areEqual(r19, String.valueOf(109)) == false) goto L20;
        r8.put("request_page", "emoji_panel");
        goto L68
    L20:
        if (Intrinsics.areEqual(r19, String.valueOf(108)) == false) goto L23;
        r8.put("request_page", "pre_link_seat");
        goto L68
    L23:
        if (Intrinsics.areEqual(r19, String.valueOf(110)) == false) goto L26;
        r8.put("request_page", "task");
        goto L68
    L26:
        if (Intrinsics.areEqual(r19, String.valueOf(112)) == false) goto L29;
        r8.put("request_page", "apply_panel");
        goto L68
    L29:
        if (Intrinsics.areEqual(r19, String.valueOf(113)) == false) goto L32;
        r8.put("request_page", "card");
        goto L68
    L32:
        if (Intrinsics.areEqual(r19, String.valueOf(115)) == false) goto L35;
        r8.put("request_page", "associated_apply");
        goto L68
    L35:
        if (Intrinsics.areEqual(r19, String.valueOf(114)) == false) goto L42;
        if (r33 != LinkApplyType.KTV_MULTI_CHORUS) goto L39;
        Object r96 = "live_chorus";
    L40:
        r8.put("request_page", r96);
        goto L68
    L39:
        r96 = "live_song";
        goto L40
    L42:
        if (Intrinsics.areEqual(r19, String.valueOf(118)) == false) goto L45;
        r8.put("request_page", "preview_theme_promote_link");
        goto L68
    L45:
        if (Intrinsics.areEqual(r19, String.valueOf(119)) == false) goto L48;
        r8.put("request_page", "preview_game_promote_link");
        goto L68
    L48:
        if (tc0.c.h().J == 114) goto L51;
        Intrinsics.checkNotNull(r19);
        r8.put("request_page", r19);
        goto L68
    L51:
        if (r33 != LinkApplyType.KTV_MULTI_CHORUS) goto L53;
        Object r97 = "live_chorus";
    L54:
        r8.put("request_page", r97);
        goto L68
    L53:
        r97 = "live_song";
        goto L54
    L55:
        if (r36 == null) goto L60;
        if (TextUtils.isEmpty(r36) == true) goto L60;
        r8.put("request_page", r36);
    L60:
        if (tc0.c.h().J == 114) goto L63;
        r8.put("request_page", "");
        goto L68
    L63:
        if (r33 != LinkApplyType.KTV_MULTI_CHORUS) goto L65;
        Object r98 = "live_chorus";
    L66:
        r8.put("request_page", r98);
        goto L68
    L65:
        r98 = "live_song";
        goto L66
    }

    public final void C(int r18, String r19, int r20, boolean r21, String r22, String r23, long r24, Long r26, Long r27, List r28, boolean r29, long r30, ICircleInfo r32, Long r33, String r34, String r35, LinkApplyType r36, IMessageBoardInfo r37, com.bytedance.android.live.liveinteract.videotalk.utils.a r38, oe0.b r39, String r40, String r41) {
        Intrinsics.checkNotNullParameter(r23, "overType");
        Intrinsics.checkNotNullParameter(r28, "songList");
        HashMap r10 = new HashMap();
        String r9 = "";
        if (TextUtils.isEmpty(r19) == true) goto L50;
        int r11 = bh0.a.a;
        if (Intrinsics.areEqual(r19, String.valueOf(101)) == false) goto L8;
        r10.put("request_page", "seat");
    L31:
        Object r16 = "live_chorus";
    L61:
        if (tc0.c.h().I.booleanValue() == false) goto L64;
        r10.put("source", "pre_apply");
    L64:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L66;
        r10.put("request_page", tc0.c.h().L.getValue());
    L66:
        r10.put("talk_duration", String.valueOf(r30));
        r10.put("live_type", "voice_live");
        String r8 = tc0.c.h().M;
        String r15 = "1";
        if (TextUtils.isEmpty(r8) == true) goto L69;
        r10.put("is_task", "1");
        r10.put("activity_name", r8);
    L69:
        r10.put("is_priority_sing", "0");
        if (r20 != 201) goto L72;
        r10.put("break_page", "seat");
    L76:
        if (r22 != null) goto L78;
        String r1 = "";
    L79:
        String r2 = "connect_type";
        r10.put("connect_type", r1);
        r10.put("over_type", r23);
        if (r24 >= 0) goto L82;
        r10.put("duration", "0");
    L83:
        r10.put("camera_duration", "");
        if (Intrinsics.areEqual(r22, "apply") == false) goto L90;
        if (r21 == false) goto L88;
        r10.put("is_approve_needed", "0");
        goto L90
    L88:
        r10.put("is_approve_needed", "1");
    L90:
        if (Intrinsics.areEqual(r22, "gift_message_invite") == false) goto L93;
        if (r37 == null) goto L93;
        r10.put("message_text", f0.a(r37));
        Unit r3 = Unit.INSTANCE;
    L93:
        gk0.a.b.getClass();
        r10.put("previous_page", gk0.a.C0214a.c());
        if (((Boolean) this.e.get("data_audio_chat_support_send_gift_to_linker", Boolean.TRUE)).booleanValue() == false) goto L96;
        Object r4 = "on";
    L97:
        r10.put("gift_guest_switch_type", r4);
        if (r34 == null) goto L100;
        r10.put("function_type", r34);
        r10.put("function_type2", r34);
    L101:
        Unit r6 = Unit.INSTANCE;
        if (r35 == null) goto L105;
        r10.put("layout_type", r35);
    L105:
        if (Intrinsics.areEqual((String) r10.get("request_page"), "live_song") == false) goto L107;
    L110:
        List r5 = r28;
        r10.put("guest_connection_type", "live_song");
    L111:
        if (r18 != 0) goto L113;
    L115:
        com.bytedance.android.livesdk.log.filter.t r7 = j0.l().c(am2.x.class);
        if (r7 != null) goto L118;
    L131:
        int r12 = LinkDistributeSettingDialog.i;
        r10.put("distribute_status", LinkDistributeSettingDialog.a.a());
        DataCenter r13 = this.e;
        Boolean r14 = Boolean.FALSE;
        if (((Boolean) r13.get("data_link_mic_is_quick_invite", r14)).booleanValue() == false) goto L134;
        Object r17 = "1";
    L135:
        r10.put("is_quick_invite", r17);
        this.e.put("data_link_mic_is_quick_invite", r14);
        TalkRoomLogUtils.L0(r10);
        i0 r25 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.y0(r10, true);
        com.bytedance.android.livesdk.log.filter.o r31 = j0.l().c(am2.x.class);
        if ((r31 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L138;
        r31 = null;
    L138:
        com.bytedance.android.livesdk.log.filter.t r42 = (com.bytedance.android.livesdk.log.filter.t) r31;
        if (r42 == null) goto L141;
        r42.F(null);
    L141:
        if (r29 == false) goto L143;
        Object r43 = "1";
    L144:
        r10.put("is_avatar_used", r43);
        if (r32 == null) goto L149;
        String r44 = r32.getCircleName();
        if (r44 == null) goto L149;
        r10.put("circle_name", r44);
    L149:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r45 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if ((r45 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == false) goto L168;
        r10.put("seat_num", String.valueOf(((com.bytedance.android.live.liveinteract.plantform.core.y) r45).n()));
        int r46 = r45.O4(je0.d.b0());
        Iterator<LinkmicPositionItem> r47 = ((com.bytedance.android.live.liveinteract.plantform.core.y) r45).e.iterator();
    L153:
        if (r47.hasNext() == false) goto L161;
        LinkmicPositionItem r48 = r47.next();
        String r210 = r2;
        if (((int) r48.getPosition()) != r46) goto L157;
        boolean r49 = true;
    L158:
        if (r49 == true) goto L162;
        r2 = r210;
    L162:
        LinkmicPositionItem r50 = r48;
        if (r50 == null) goto L166;
        String r51 = r50.getActiveName();
        if (r51 == null) goto L166;
    L167:
        r10.put("seat_name", r51);
    L169:
        r10.put("guest_connection_type", "live_chat");
        TalkRoomLogUtils.N0(r10, r19, true);
        if (e.a(false) == false) goto L172;
        r10.put("is_pre_link", "1");
    L172:
        li0.b r52 = li0.b.b;
        li0.b.k(r10);
        TalkRoomLogUtils.T0(r10, false);
        n0 r53 = tc0.c.h().P;
        if (r53 == null) goto L196;
        i0 r54 = TalkRoomLogUtils.a;
        r10.put("ordering_mode", TalkRoomLogUtils.v());
        String r55 = r53.getFanTicket();
        if (r55 != null) goto L177;
        r55 = "0";
    L177:
        r10.put("money", r55);
        long r56 = r53.getRank();
        if (r56 != 1) goto L181;
        String r57 = "top1";
    L187:
        r10.put("top_r", r57);
        IBaseUser r58 = r53.getUserFlex();
        if (r58 == null) goto L190;
        String r59 = r58.getRelationship();
    L191:
        r10.put("relationship", String.valueOf(r59));
        IBaseUser r60 = r53.getUserFlex();
        if (r60 == null) goto L194;
        Integer r61 = Integer.valueOf(r60.getLevel());
    L195:
        r10.put("contribution_level", String.valueOf(r61));
        Unit r62 = Unit.INSTANCE;
        goto L196
    L194:
        r61 = null;
        goto L195
    L190:
        r59 = null;
        goto L191
    L181:
        if (r56 != 2) goto L184;
        r57 = "top2";
        goto L187
    L184:
        if (r56 != 3) goto L186;
        r57 = "top3";
        goto L187
    L186:
        r57 = "null";
    L196:
        if (r26 == null) goto L201;
        long r63 = r26.longValue();
        if (r10.containsValue("invite_mutual") == true) goto L200;
        r10.put("wait_time", String.valueOf(r63));
    L200:
        Unit r65 = Unit.INSTANCE;
    L201:
        if (r27 == null) goto L203;
        r10.put("watch_duration", String.valueOf(r27.longValue()));
        Unit r66 = Unit.INSTANCE;
    L203:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == true) goto L206;
    L208:
        Object r67 = "0";
    L209:
        r10.put("is_rechargeble", r67);
        r10.put("play_mode", u0.b());
        b1 r68 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        fj0.a r69 = fj0.b.a;
        r10.put("rechargeable_label", fj0.b.i(r68.getSavedTagInfos()));
        r10.put("rechargeable_intro", r68.getSavedDesc());
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L256;
        fj0.a r70 = fj0.b.a;
        if (r70.b == false) goto L214;
        r10.put("recharge_mode", "normal");
    L214:
        int r71 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().a;
        r10.put("recharge_price", String.valueOf(r71));
        r10.put("time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.f()));
        com.bytedance.android.livesdk.chatroom.o r72 = this.f;
        if (r72 == null) goto L219;
        com.bytedance.live.datacontext.m r73 = r72.getRoom();
        if (r73 == null) goto L219;
        IRoom r74 = (IRoom) r73.getValue();
    L221:
        if (fj0.e.g(r74) == false) goto L232;
        n0 r75 = tc0.c.h().P;
        if (r75 == null) goto L225;
        long r110 = r75.getPaidAmount();
    L226:
        long r111 = r110 - ((long) r71);
        if (r111 >= 0) goto L230;
        r111 = r70.f;
    L230:
        r10.put("add_price", String.valueOf(r111));
        r70.f = 0;
        goto L232
    L225:
        r110 = 0;
    L232:
        if (fj0.e.d() == false) goto L234;
        r10.put("anonymous_switch", "on");
    L235:
        PaidLinkMicContext r76 = PaidLinkMicContext.Companion.getContext();
        if (r76 == null) goto L242;
        com.bytedance.live.datacontext.m<Integer> r77 = r76.getDiscountMode();
        if (r77 == null) goto L242;
        Integer r78 = (Integer) r77.getValue();
        if (r78 == null) goto L242;
        int r79 = r78.intValue();
    L243:
        if (r79 != 1) goto L245;
        String r80 = "vip";
    L252:
        r10.put("discount_type", r80);
        E(r10, r71, r79);
        if (r70.g == false) goto L256;
        r10.put("is_vip_recharge_privilege", "1");
        goto L256
    L245:
        if (r79 != 2) goto L247;
        r80 = "activity";
        goto L252
    L247:
        if (r79 == 3) goto L249;
        r80 = "";
        goto L252
    L249:
        r80 = "strategy";
    L242:
        r79 = 0;
        goto L243
    L234:
        r10.put("anonymous_switch", "off");
    L219:
        r74 = null;
    L256:
        if (g1.b() == false) goto L258;
        Object r81 = "1";
    L259:
        r10.put("is_priority_queue", r81);
        if (g1.b() == false) goto L266;
        n0 r82 = tc0.c.h().P;
        if (r82 == null) goto L264;
        long r83 = r82.getPaidAmount();
    L265:
        String r84 = String.valueOf(r83);
    L267:
        r10.put("pay_amt", r84);
        String r85 = tc0.c.h().F;
        if (r85 == null) goto L271;
        r9 = r85;
    L271:
        r10.put("apply_reason", r9);
        if (r33 != null) goto L274;
    L277:
        String r86 = tc0.c.h().H;
        if (r86 != null) goto L280;
    L283:
        boolean r87 = true;
    L284:
        if (r87 == true) goto L286;
        String r88 = r210;
        r10.put(r88, tc0.c.h().H);
    L288:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L290;
        Object r89 = "1";
    L291:
        r10.put("is_invite_only", r89);
        InteractiveSongLoggerKt.b(r10);
        ii0.a.c(r10, true);
        TalkRoomLogUtils.v0(r10);
        if (r38 != null) goto L294;
    L304:
        if (r39 == null) goto L306;
        r10.put("double_enlarge_duration", String.valueOf((r39.b() + ((long) 500)) / ((long) 1000)));
        Unit r90 = Unit.INSTANCE;
    L306:
        com.bytedance.live.datacontext.m r91 = com.bytedance.android.live.liveinteract.api.utils.m.i().getEnterRoomParams();
        if (r91 == null) goto L321;
        Map r92 = (Map) r91.getValue();
        if (r92 == null) goto L321;
        if (r92.containsKey("enter_source") != true) goto L321;
        com.bytedance.live.datacontext.m r93 = com.bytedance.android.live.liveinteract.api.utils.m.i().getEnterRoomParams();
        if (r93 == null) goto L321;
        Map r94 = (Map) r93.getValue();
        if (r94 == null) goto L321;
        String r95 = (String) r94.get("enter_source");
        if (r95 == null) goto L321;
        String r96 = null;
        if (StringsKt.contains$default(r95, "chat_match", false, 2, null) != true) goto L322;
        r10.put(r88, "chat_match");
    L322:
        li0.b.i(r10);
        if (jc0.a.a == false) goto L325;
        Object r97 = "1";
    L326:
        r10.put("is_lead_singer", r97);
        if (jc0.a.b == false) goto L329;
        Object r98 = "1";
    L330:
        r10.put("is_setting_lead", r98);
        i0 r99 = TalkRoomLogUtils.a;
        r10.put("current_enlarge_user_type", TalkRoomLogUtils.o(Integer.valueOf(TalkRoomLogUtils.b.b)));
        if (b() == true) goto L334;
        r15 = "0";
    L334:
        r10.put("is_fixed_guest", r15);
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r100 == null) goto L339;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r101 = r100.getLinkUserInfoCenter();
        if (r101 == null) goto L339;
        TalkRoomLogUtils.G0(r101.O4(je0.d.b0()), r10);
        Unit r102 = Unit.INSTANCE;
    L339:
        if (r41 != null) goto L341;
    L348:
        String r103 = qi0.c.b;
        qi0.c.k("request_page", r10);
        j0.l().sendLog("livesdk_guest_connection_over", r10, new Object[]{IRoom.class, am2.x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L341:
        if (r41.length() <= 0) goto L343;
        boolean r104 = true;
    L344:
        if (r104 == false) goto L346;
        r96 = r41;
    L346:
        if (r96 == null) goto L348;
        r10.put("connection_over_type_detail", r96);
        Unit r105 = Unit.INSTANCE;
        goto L348
    L343:
        r104 = false;
        goto L344
    L329:
        r98 = "0";
        goto L330
    L325:
        r97 = "0";
    L321:
        r96 = null;
        goto L322
    L294:
        if (r38.e == false) goto L296;
        Object r106 = "1";
    L297:
        r10.put("is_guest_enlarged_before", r106);
        if (r38.h == true) goto L300;
    L302:
        long r107 = r38.d;
    L303:
        r10.put("enlarge_duration", String.valueOf((r107 + ((long) 500)) / ((long) 1000)));
        Unit r108 = Unit.INSTANCE;
        goto L304
    L300:
        if (r38.c <= 0) goto L302;
        r107 = r38.d + (SystemClock.elapsedRealtime() - r38.c);
        goto L303
    L296:
        r106 = "0";
        goto L297
    L290:
        r89 = "0";
        goto L291
    L286:
        r88 = r210;
        goto L288
    L280:
        if (StringsKt.isBlank(r86) == true) goto L283;
        r87 = false;
        goto L284
    L274:
        if (r33.longValue() <= 0) goto L276;
        r10.put("tag_type", String.valueOf(r33));
    L276:
        Unit r109 = Unit.INSTANCE;
        goto L277
    L264:
        r83 = 0;
        goto L265
    L266:
        r84 = "0";
        goto L267
    L258:
        r81 = "0";
        goto L259
    L206:
        if (fj0.b.a.b == false) goto L208;
        r67 = "1";
    L166:
        r51 = "";
        goto L167
    L157:
        r49 = false;
        goto L158
    L161:
        r210 = r2;
        r48 = null;
        goto L162
    L168:
        r210 = "connect_type";
        goto L169
    L143:
        r43 = "0";
        goto L144
    L134:
        r17 = "0";
        goto L135
    L118:
        if ((r7 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L131;
        com.bytedance.android.livesdk.log.filter.t r112 = r7;
        String r113 = r112.b();
        if (r113 != null) goto L122;
    L125:
        boolean r114 = true;
    L126:
        if (r114 == true) goto L131;
        String r115 = r112.b();
        if (r115 != null) goto L130;
        r115 = "";
    L130:
        r10.put("previous_page", r115);
        goto L131
    L122:
        if (r113.length() == 0) goto L125;
        r114 = false;
        goto L126
    L113:
        if (r5.isEmpty() == true) goto L115;
        i0 r116 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.a1(r10, r5);
        goto L115
    L107:
        if (Intrinsics.areEqual((String) r10.get("request_page"), r16) == true) goto L110;
        r5 = r28;
        TalkRoomLogUtils.D0(r10, Integer.valueOf(r18), !r5.isEmpty());
        goto L111
    L100:
        TalkRoomLogUtils.B0(r10, null, null, 6);
        goto L101
    L96:
        r4 = "off";
        goto L97
    L82:
        r10.put("duration", String.valueOf(r24));
        goto L83
    L78:
        r1 = r22;
        goto L79
    L72:
        if (r20 != 202) goto L76;
        r10.put("break_page", "bottom");
        goto L76
    L8:
        if (Intrinsics.areEqual(r19, String.valueOf(102)) == false) goto L11;
        r10.put("request_page", "bottom");
        goto L31
    L11:
        if (Intrinsics.areEqual(r19, String.valueOf(103)) == false) goto L14;
        r10.put("request_page", "popup");
        goto L31
    L14:
        if (Intrinsics.areEqual(r19, String.valueOf(104)) == false) goto L17;
        r10.put("request_page", "seat_popup");
        goto L31
    L17:
        if (Intrinsics.areEqual(r19, String.valueOf(109)) == false) goto L20;
        r10.put("request_page", "emoji_panel");
        goto L31
    L20:
        if (Intrinsics.areEqual(r19, String.valueOf(108)) == false) goto L23;
        r10.put("request_page", "pre_link_seat");
        goto L31
    L23:
        if (Intrinsics.areEqual(r19, String.valueOf(110)) == false) goto L26;
        r10.put("request_page", "task");
        goto L31
    L26:
        if (Intrinsics.areEqual(r19, String.valueOf(112)) == false) goto L29;
        r10.put("request_page", "apply_panel");
        goto L31
    L29:
        if (Intrinsics.areEqual(r19, String.valueOf(113)) == false) goto L32;
        r10.put("request_page", "card");
        goto L31
    L32:
        r16 = "live_chorus";
        if (Intrinsics.areEqual(r19, String.valueOf(114)) == false) goto L40;
        if (r36 != LinkApplyType.KTV_MULTI_CHORUS) goto L37;
        Object r117 = r16;
    L38:
        r10.put("request_page", r117);
        goto L61
    L37:
        r117 = "live_song";
        goto L38
    L40:
        if (Intrinsics.areEqual(r19, String.valueOf(115)) == false) goto L43;
        r10.put("request_page", "associated_apply");
        goto L61
    L43:
        if (tc0.c.h().J == 114) goto L46;
        Intrinsics.checkNotNull(r19);
        r10.put("request_page", r19);
        goto L61
    L46:
        if (r36 != LinkApplyType.KTV_MULTI_CHORUS) goto L48;
        Object r118 = r16;
    L49:
        r10.put("request_page", r118);
        goto L61
    L48:
        r118 = "live_song";
        goto L49
    L50:
        r16 = "live_chorus";
        if (TextUtils.isEmpty(r40) == true) goto L57;
        if (r40 != null) goto L54;
        String r119 = "";
    L55:
        r10.put("request_page", r119);
        goto L61
    L54:
        r119 = r40;
        goto L55
    L57:
        if (tc0.c.h().J == 114) goto L59;
        r10.put("request_page", "");
        goto L61
    L59:
        r10.put("request_page", "live_song");
        goto L61
    }
}

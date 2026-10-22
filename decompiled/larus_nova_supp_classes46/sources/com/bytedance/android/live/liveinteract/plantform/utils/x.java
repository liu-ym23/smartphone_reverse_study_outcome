package com.bytedance.android.live.liveinteract.plantform.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x {
    public static final /* synthetic */ int a = 0;

    public x() {
    }

    @JvmStatic
    public static final void J() {
        t0("start_capture_audio_when_pause", new LinkedHashMap());
    }

    @JvmStatic
    public static final void L() {
        t0("check_link_permission_success", new LinkedHashMap());
    }

    @JvmStatic
    public static final void M() {
        t0("silence_by_anchor_on_background", new LinkedHashMap());
    }

    @JvmStatic
    public static final void j0() {
        t0("rtc_not_release", new HashMap());
    }

    static {
    }

    @JvmStatic
    public static final void C0(TalkRoomOperate r3) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("operation", r3.getOperate());
        r1.put("talk_room_admin_enable", Boolean.valueOf(vm2.d.x0()));
        com.bytedance.android.livesdk.sharedpref.e r4 = b6.i;
        r1.put("video_talk_admin_support", r4.getValue());
        r1.put("audio_talk_admin_support", r4.getValue());
        r1.put("intimate_chat_admin_support", r4.getValue());
        t0("talk_room_admin_operate_exception", r1);
    }

    public static void G(String r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("activity", r2);
        t0("dialog_exception", r1);
    }

    @JvmStatic
    public static final void K(BaseCheckException r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("operate_type", r5.getOperateType());
        r0.put("check_type", r5.getCheckType().name());
        String r1 = r5.getMessage();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("error_msg", r1);
        CustomApiServerException r6 = r5.getCause();
        if (r6 != null) goto L8;
    L20:
        t0("check_link_permission_failed", r0);
        return;
    L8:
        if ((r6 instanceof CustomApiServerException) == false) goto L11;
        CustomApiServerException r3 = r6;
        r0.put("url", r3.getUrl());
        r0.put("xTtLogId", r3.getXTtLogId());
    L11:
        if ((r6 instanceof ApiServerException) == false) goto L18;
        String r4 = r6.getMessage();
        if (r4 == null) goto L16;
        r2 = r4;
    L16:
        r0.put("cause_msg", r2);
    L18:
        if ((r6 instanceof ApiException) == false) goto L20;
        r0.put("error_code", Integer.valueOf(((ApiException) r6).getErrorCode()));
        goto L20
    }

    @JvmStatic
    public static final void O(boolean r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("use_single_view", Boolean.valueOf(r2));
        t0("live_core_single_view", r0);
    }

    @JvmStatic
    public static final void R(int r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("list_status", Integer.valueOf(r2));
        t0("on_pause_mute_error", r0);
    }

    @JvmStatic
    public static final void a(Map<String, Object> r5) {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L30;
        int r1 = r0.getLinkMode();
        if (r1 != 0) goto L7;
        String r2 = "none";
    L29:
        r5.put("link_type", r2);
        goto L30
    L7:
        if (r1 != 2) goto L9;
        ((com.bytedance.android.live.liveinteract.service.f) r0.getInteractAudienceService()).getClass();
        com.bytedance.android.live.liveinteract.api.data.a r3 = com.bytedance.android.live.liveinteract.api.data.a.a();
        if (r3.c == false) goto L27;
        r5.put("paid_count", Integer.valueOf(r3.a));
        r5.put("limit_time", Integer.valueOf(r3.b));
    L27:
        r2 = "video_audience";
        goto L29
    L9:
        if (r1 != 4) goto L11;
        r2 = "cross_room";
        goto L29
    L11:
        if (r1 != 8) goto L13;
        r2 = "audio_talk";
        goto L29
    L13:
        if (r1 != 32) goto L15;
        com.bytedance.android.live.liveinteract.api.data.a r4 = r0.getVideoTalkService().j();
        if (r4.c == false) goto L21;
        r5.put("paid_count", Integer.valueOf(r4.a));
        r5.put("limit_time", Integer.valueOf(r4.b));
    L21:
        r2 = "video_talk";
        goto L29
    L15:
        if (r1 == 64) goto L17;
        r2 = "other:" + r0.getLinkMode();
        goto L29
    L17:
        r2 = "multi_anchor";
    L30:
        String r6 = jc1.k.n(IMiddlewareUserService.class).user().n();
        com.bytedance.live.datacontext.m r7 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r7 == null) goto L35;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L35;
        String r9 = r8.getOwnerUserIdString();
    L36:
        boolean r10 = jc1.k.n(IMiddlewareUserService.class).user().c();
        boolean r11 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        if (Intrinsics.areEqual(r6, r9) == false) goto L39;
        String r12 = "anchor";
    L44:
        r5.put("role", r12);
        r5.put("self_id", r6);
        r5.put("scene", Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        Object r13 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentPlayModes();
        if (r13 != null) goto L47;
        r13 = "null";
    L47:
        r5.put("play_modes", r13);
        return;
    L39:
        if (r10 == false) goto L41;
        r12 = "talkRoomAdmin";
        goto L44
    L41:
        if (r11 == false) goto L43;
        r12 = "admin";
        goto L44
    L43:
        r12 = "guest";
    L35:
        r9 = null;
        goto L36
    }

    public static void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("reason", r2);
        t0("digit_avatar_recognition_fail", r1);
    }

    @JvmStatic
    public static final void m0(tf0.i r3) {
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        HashMap r0 = new HashMap();
        if ((r3 instanceof tc0.c) == false) goto L9;
        hd0.c r1 = hd0.c.f();
        if (r1 == null) goto L7;
        int r2 = r1.g;
    L8:
        r0.put("link_mode", Integer.valueOf(r2));
        goto L9
    L7:
        r2 = 0;
    L9:
        u0("rtc_turn_on", r0, r3);
    }

    @JvmStatic
    public static final void w(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("target_user_id", r2);
        t0("kickout_when_rtc_user_lost", r0);
    }

    @JvmStatic
    public static final void z0(long r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Long.valueOf(r2));
        t0("start_link_mic_success", r0);
    }

    @JvmStatic
    public static final void A(tc0.c r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        Intrinsics.checkNotNullParameter(r3, "reason");
        HashMap r1 = new HashMap();
        r1.put("reason", r3);
        u0("livecore_stop", r1, r2);
    }

    @JvmStatic
    public static final void B(int r1, long r2) {
        int r3 = r1 + 10;
        if (vm2.g.a() == false) goto L5;
        r3 = r3 + 100;
    L5:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_link_first_frame_status", r3, r2);
    }

    @JvmStatic
    public static final void C(Throwable r1, boolean r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        a(r0);
        X(r1, r0);
        if (r2 == false) goto L6;
        t0("audience_link_settings_error", r0);
        return;
    L6:
        r0.put("event_name", "audience_link_settings_error");
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r0);
    }

    @JvmStatic
    public static final void I(int r1, long r2) {
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_link_first_frame_status", r1, r2);
    }

    @JvmStatic
    public static final void P(Integer r2, String r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 == null) goto L5;
        int r4 = r2.intValue();
    L6:
        r0.put("open_panel_type", Integer.valueOf(r4));
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.put("platform_activity_id", r3);
        t0("open_panel_for_schema", r0);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    @JvmStatic
    public static final void X(Throwable r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof CustomApiServerException) == false) goto L8;
        CustomApiServerException r0 = (CustomApiServerException) r4;
        r5.put("url", r0.getUrl());
        r5.put("xTtLogId", r0.getXTtLogId());
    L8:
        if ((r4 instanceof ApiServerException) == false) goto L16;
        ApiServerException r1 = (ApiServerException) r4;
        if (TextUtils.isEmpty(r1.getErrorMsg()) == true) goto L16;
        r5.put("error_code", Integer.valueOf(r1.getErrorCode()));
        String r6 = r1.getErrorMsg();
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r5.put("error_msg", r6);
        return;
    L16:
        if ((r4 instanceof ApiException) == false) goto L21;
        r5.put("error_code", Integer.valueOf(((ApiException) r4).getErrorCode()));
        String r7 = r4.getMessage();
        if (r7 == null) goto L29;
        r5.put("error_msg", r7);
        return;
    L29:
        return;
    L21:
        if ((r4 instanceof Exception) == false) goto L25;
        r5.put("error_code", -1);
        String r8 = r4.getMessage();
        if (r8 == null) goto L31;
        r5.put("error_msg", r8);
        return;
    L31:
        return;
    L25:
        r5.put("error_code", -1);
        r5.put("error_msg", r4.toString());
    }

    @JvmStatic
    public static final void Y(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("target_user_id", r2);
        r0.put("duration", Long.valueOf(r3));
        t0("permit_audience_success", r0);
    }

    @JvmStatic
    public static final void a0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        Intrinsics.checkNotNullParameter(r3, "traceStr");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("operation", r2);
        r1.put("trace", r3);
        v0("other_thread_invocation", r1);
    }

    @JvmStatic
    public static final void b(long r2, int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", Long.valueOf(r2));
        r0.put("reply_type", Integer.valueOf(r4));
        t0("anchor_receive_reply_msg", r0);
    }

    @JvmStatic
    public static final void c(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "fromUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", Long.valueOf(r3));
        r0.put("from_user_id", r2);
        t0("anchor_receive_auto_join_msg", r0);
    }

    @JvmStatic
    public static final void e0(tf0.i r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "dataHolder");
        HashMap r0 = new HashMap();
        a(r0);
        if (r6 <= 0) goto L6;
        long r1 = System.currentTimeMillis() - r6;
        r0.put("duration", Long.valueOf(r1));
        com.bytedance.android.live.liveinteract.api.utils.g.m("rtc_turn_off_success", r0, r5, r1);
        return;
    L6:
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_turn_off_success", r0, r5, false);
    }

    @JvmStatic
    public static final void f(long r2, String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Long.valueOf(r2));
        if (r4 == null) goto L5;
        r0.put("req_from", r4);
    L5:
        t0("cancel_apply_success", r0);
    }

    public static void i(String r2, Exception r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "e");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("mode", r2);
        r1.put("exception", r3.toString());
        t0("digit_avatar_video_show_mode_switch_fail", r1);
    }

    public static void i0(tf0.i r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        HashMap r0 = new HashMap();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("reason", r3);
        u0("rtc_mute_local_video", r0, r2);
    }

    @JvmStatic
    public static final void j(Throwable r1, boolean r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        X(r1, r0);
        if (r2 == false) goto L5;
        v0("fetch_interact_emoji_list_failed", r0);
        return;
    L5:
        v0("fetch_emoji_list_failed", r0);
    }

    @JvmStatic
    public static final void l(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Long.valueOf(r2));
        r0.put("req_from", r4);
        t0("finish_link_mic_success", r0);
    }

    @JvmStatic
    public static final void n(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "fromUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", Long.valueOf(r2));
        r0.put("from_user_id", r4);
        t0("guest_receive_invite_msg", r0);
    }

    @JvmStatic
    public static final void o(long r2, int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", Long.valueOf(r2));
        r0.put("control_type", Integer.valueOf(r4));
        t0("guest_receive_kickout_msg", r0);
    }

    @JvmStatic
    public static final void p(long r2, String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", Long.valueOf(r2));
        if (r4 != null) goto L5;
        String r3 = "null";
    L6:
        r0.put("rtc_ext_info", r3);
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        t0("guest_receive_permit_msg_error", r0);
        return;
    L16:
        t0("guest_receive_permit_msg", r0);
        return;
    L9:
        if (r4.length() == 0) goto L12;
        r5 = false;
        goto L13
    L5:
        r3 = r4;
        goto L6
    }

    @JvmStatic
    public static final void p0(String r2, tf0.i r3) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("guest_linkmic_id", r2);
        a(r0);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_user_join", r0, r3, false);
    }

    @JvmStatic
    public static final void q0(String r2, tf0.i r3) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("guest_linkmic_id", r2);
        a(r0);
        com.bytedance.android.live.liveinteract.api.utils.g.o("rtc_user_leave", r0, r3);
    }

    @JvmStatic
    public static final void r0(Throwable r1, boolean r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        X(r1, r0);
        if (r2 == false) goto L5;
        v0("send_interact_emoji_failed", r0);
        return;
    L5:
        v0("send_emoji_failed", r0);
    }

    @JvmStatic
    public static final void s0(long r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", Long.valueOf(r2));
        r0.put("emoji_id", Long.valueOf(r4.getEmojiId()));
        r0.put("is_random_emoji", Boolean.valueOf(r4.isRandomEmoji()));
        if (r4.isInteractEmoji() == false) goto L7;
        v0("send_interact_emoji_success", r0);
        return;
    L7:
        v0("send_emoji_success", r0);
    }

    public static void t0(String r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "extra");
        a(r3);
        com.bytedance.android.live.liveinteract.api.utils.g.n(r2, r3, tc0.c.h(), false);
    }

    @JvmStatic
    public static final void u(Throwable r1, long r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        X(r1, r0);
        r0.put("duration", Long.valueOf(r2));
        t0("join_channel_failed", r0);
    }

    @JvmStatic
    public static final void v0(String r3, Map<String, Object> r4) {
        a(r4);
        tc0.c r0 = tc0.c.h();
        String r1 = com.bytedance.android.live.liveinteract.api.utils.g.a;
        r4.put("event", r3);
        r4.put("channel_id", Long.valueOf(r0.getChannelId()));
        r4.put("interact_id", r0.f);
        com.bytedance.android.livesdk.user.e r5 = jc1.k.f(IMiddlewareUserService.class).user();
        Room r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r2 == null) goto L6;
        if (r5 == null) goto L6;
        r4.put("room_id", r2.getIdStr());
        r4.put("anchor_id", r2.getOwnerUserIdString());
    L6:
        LiveSlardarMonitor.monitorStatus("ttlive_interact_other_event_api_all", 0, r4);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r4);
    }

    @JvmStatic
    public static final void x(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "singerId");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("singerId", r3);
        if (r2 == false) goto L5;
        t0("ktv_stop_capture_on_start", r1);
        return;
    L5:
        t0("ktv_stop_capture_on_start_failed", r1);
    }

    @JvmStatic
    public static final void y0(Throwable r2, long r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Long.valueOf(r3));
        X(r2, r0);
        t0("start_link_mic_failed", r0);
    }

    @JvmStatic
    public static final void z(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Long.valueOf(r2));
        r0.put("req_from", r4);
        t0("leave_channel_success", r0);
    }

    public static void D(String r2, boolean r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "toUid");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("toUid", r2.toString());
        r1.put("isEnlarge", String.valueOf(r3));
        if (r4 == null) goto L5;
        X(r4, r1);
        t0("c_position_invite_error", r1);
        return;
    L5:
        t0("c_position_invite_success", r1);
    }

    public static void E(String r2, boolean r3, Throwable r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("toUid", String.valueOf(r2));
        r0.put("agree", String.valueOf(r3));
        if (r4 == null) goto L5;
        X(r4, r0);
        t0("c_position_reply_error", r0);
        return;
    L5:
        t0("c_position_reply_success", r0);
    }

    @JvmStatic
    public static final void E0(String r3, Throwable r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        Intrinsics.checkNotNullParameter(r5, "reason");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("target_user_id", r3);
        r1.put("reason", r5);
        X(r4, r1);
        t0("unsilence_audience_failed", r1);
    }

    @JvmStatic
    public static final void F(Throwable r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("room_id", Long.valueOf(r3));
        r0.put("anchor_id", r5);
        X(r2, r0);
        t0("check_apply_failed", r0);
    }

    public static void F0(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "serverState");
        Intrinsics.checkNotNullParameter(r3, "uiState");
        Intrinsics.checkNotNullParameter(r4, "switchInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("current_server_state", r2);
        r0.put("current_ui_state", r3);
        r0.put("switch_info", r4);
        t0("video_talk_layout_switch_error", r0);
    }

    @JvmStatic
    public static final void H(Throwable r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("room_id", Long.valueOf(r3));
        r0.put("anchor_id", r5);
        X(r2, r0);
        t0("fetch_list_failed", r0);
    }

    @JvmStatic
    public static final void Q(long r2, boolean r4, boolean r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        a(r0);
        r0.put("is_attach", Boolean.valueOf(r4));
        r0.put("is_panel_fetch", Boolean.valueOf(r5));
        r0.put("list_size", Long.valueOf(r2));
        r0.put("event_name", "waiting_list_request");
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r0);
    }

    @JvmStatic
    public static final void Z(String r2, Throwable r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("target_user_id", r2);
        r0.put("duration", Long.valueOf(r4));
        X(r3, r0);
        t0("permit_audience_failed", r0);
    }

    @JvmStatic
    public static final void c0(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("target_user_id", r2);
        if (r3 == null) goto L5;
        r0.put("list_data", r3);
    L5:
        if (r4 == false) goto L7;
        String r5 = "resume_last_silence_success_but_unSilence";
    L8:
        t0(r5, r0);
        return;
    L7:
        r5 = "resume_last_silence_success";
        goto L8
    }

    @JvmStatic
    public static final void d0(long r2, String r4, tf0.i r5) {
        Intrinsics.checkNotNullParameter(r5, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("error_code", Long.valueOf(r2));
        if (r4 == null) goto L5;
        r0.put("error_msg", r4);
    L5:
        a(r0);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_turn_off_failed", r0, r5, true);
    }

    @JvmStatic
    public static final void e(Throwable r2, long r3, String r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Long.valueOf(r3));
        if (r5 == null) goto L5;
        r0.put("req_from", r5);
    L5:
        X(r2, r0);
        t0("cancel_apply_failed", r0);
    }

    @JvmStatic
    public static final void f0(long r2, String r4, tf0.i r5) {
        Intrinsics.checkNotNullParameter(r5, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("error_code", Long.valueOf(r2));
        if (r4 == null) goto L5;
        r0.put("error_msg", r4);
    L5:
        a(r0);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_on_error", r0, r5, true);
    }

    @JvmStatic
    public static final void g0(String r4, tf0.i r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "linkmicId");
        Intrinsics.checkNotNullParameter(r5, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("guest_linkmic_id", r4);
        if (r6 <= 0) goto L5;
        com.bytedance.android.live.liveinteract.api.utils.g.m("rtc_first_audio_frame", r0, r5, System.currentTimeMillis() - r6);
        return;
    L5:
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_first_audio_frame", r0, r5, false);
    }

    public static void h(boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "extraInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("support", Boolean.valueOf(r2));
        r0.put("is_anchor", Boolean.valueOf(r3));
        r0.put("extra_info", r4);
        t0("digit_avatar_support_video_avatar", r0);
    }

    @JvmStatic
    public static final void k(Throwable r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        X(r1, r0);
        r0.put("duration", Long.valueOf(r2));
        r0.put("req_from", r4);
        t0("finish_link_mic_failed", r0);
    }

    @JvmStatic
    public static final void k0(String r2, tf0.i r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("guest_linkmic_id", r2);
        if (r4 == null) goto L6;
        String r5 = String.valueOf(r4.booleanValue());
        if (r5 == null) goto L6;
    L7:
        r0.put("mute", r5);
        a(r0);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_remote_mute_audio", r0, r3, true);
        return;
    L6:
        r5 = "";
        goto L7
    }

    @JvmStatic
    public static final void l0(String r2, tf0.i r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("guest_linkmic_id", r2);
        if (r4 == null) goto L6;
        String r5 = String.valueOf(r4.booleanValue());
        if (r5 == null) goto L6;
    L7:
        r0.put("mute", r5);
        a(r0);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_remote_mute_video", r0, r3, true);
        return;
    L6:
        r5 = "";
        goto L7
    }

    @JvmStatic
    public static final void n0(long r2, String r4, tf0.i r5) {
        Intrinsics.checkNotNullParameter(r5, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("error_code", Long.valueOf(r2));
        if (r4 == null) goto L5;
        r0.put("error_msg", r4);
    L5:
        a(r0);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_turn_on_failed", r0, r5, true);
    }

    @JvmStatic
    public static final void o0(tf0.i r4, long r5, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "dataHolder");
        HashMap r0 = new HashMap();
        r0.put("is_background", Boolean.valueOf(!r7));
        a(r0);
        if (r5 <= 0) goto L6;
        long r1 = System.currentTimeMillis() - r5;
        r0.put("duration", Long.valueOf(r1));
        com.bytedance.android.live.liveinteract.api.utils.g.m("rtc_turn_on_success", r0, r4, r1);
        return;
    L6:
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_turn_on_success", r0, r4, false);
    }

    @JvmStatic
    public static final void q(String r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "invitorUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("invitor_user_id", r2);
        if (r3 != ReplyType.Agree.ordinal()) goto L6;
        String r5 = "agree";
    L9:
        r0.put("reply_type", r5);
        r0.put("duration", Long.valueOf(r4));
        t0("guest_reply_success", r0);
        return;
    L6:
        if (r3 != ReplyType.Reject.ordinal()) goto L8;
        r5 = "reject";
        goto L9
    L8:
        r5 = "none";
        goto L9
    }

    @JvmStatic
    public static final void s(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("target_user_id", r2);
        r0.put("duration", Long.valueOf(r3));
        if (r5 == null) goto L5;
        r0.put("request_params", r5);
    L5:
        t0("invite_audience_success", r0);
    }

    public static void u0(String r1, Map r2, tf0.i r3) {
        a(r2);
        com.bytedance.android.live.liveinteract.api.utils.g.n(r1, r2, r3, true);
    }

    @JvmStatic
    public static final void x0(String r3, Throwable r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        Intrinsics.checkNotNullParameter(r5, "reason");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("target_user_id", r3);
        r1.put("reason", r5);
        X(r4, r1);
        t0("silence_audience_failed", r1);
    }

    @JvmStatic
    public static final void A0(int r1, int r2, Throwable r3, Integer r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        X(r3, r0);
        r0.put("from_scene", Integer.valueOf(r1));
        r0.put("to_scene", Integer.valueOf(r2));
        if (r4 == null) goto L5;
        r0.put("to_play_mode", Integer.valueOf(r4.intValue()));
    L5:
        t0("switch_scene_failed", r0);
    }

    @JvmStatic
    public static final void B0(int r2, int r3, Integer r4, List<Integer> r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("from_scene", Integer.valueOf(r2));
        r0.put("to_scene", Integer.valueOf(r3));
        if (r4 == null) goto L5;
        r0.put("to_play_mode", Integer.valueOf(r4.intValue()));
    L5:
        if (r5 == null) goto L7;
        r0.put("new_play_modes", r5.toString());
    L7:
        t0("switch_scene_success", r0);
    }

    @JvmStatic
    public static final void D0(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        Intrinsics.checkNotNullParameter(r4, "reason");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("target_user_id", r3.toString());
        r1.put("reason", r4);
        if (r5 == null) goto L5;
        r1.put("list_data", r5);
    L5:
        if (r6 == null) goto L7;
        r1.put("list_data_link_room_fight", r6);
    L7:
        t0("unsilence_audience_success", r1);
    }

    @JvmStatic
    public static final void N(boolean r2, long r3, long r5, Throwable r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("success", Boolean.valueOf(r2));
        r0.put("to_position", Long.valueOf(r3));
        r0.put("duration", Long.valueOf(r5));
        if (r7 == null) goto L5;
        X(r7, r0);
    L5:
        t0("update_linker_position", r0);
    }

    @JvmStatic
    public static final void V(Long r3, String r4, String r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("event_name", "linker_update_msg");
        r0.put("msg_id", String.valueOf(r3));
        r0.put("target_user_id", r4);
        if (r5 == null) goto L5;
        r0.put("msg_content", r5);
    L5:
        if (r6 == null) goto L7;
        r0.put("list_size", Integer.valueOf(r6.intValue()));
    L7:
        a(r0);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r0);
    }

    @JvmStatic
    public static final void h0(String r4, tf0.i r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r4, "linkmicId");
        Intrinsics.checkNotNullParameter(r5, "dataHolder");
        Intrinsics.checkNotNullParameter(r8, "viewInfo");
        HashMap r1 = new HashMap();
        r1.put("guest_linkmic_id", r4);
        r1.put("viewInfo", r8);
        a(r1);
        if (r6 <= 0) goto L5;
        com.bytedance.android.live.liveinteract.api.utils.g.m("rtc_first_frame", r1, r5, System.currentTimeMillis() - r6);
        return;
    L5:
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_first_frame", r1, r5, false);
    }

    @JvmStatic
    public static final void r(String r2, int r3, Throwable r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "invitorUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("invitor_user_id", r2);
        if (r3 != ReplyType.Agree.ordinal()) goto L6;
        String r6 = "agree";
    L9:
        r0.put("reply_type", r6);
        r0.put("duration", Long.valueOf(r5));
        X(r4, r0);
        t0("guest_reply_failed", r0);
        return;
    L6:
        if (r3 != ReplyType.Reject.ordinal()) goto L8;
        r6 = "reject";
        goto L9
    L8:
        r6 = "none";
        goto L9
    }

    @JvmStatic
    public static final void t(String r2, Throwable r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("target_user_id", r2);
        r0.put("duration", Long.valueOf(r4));
        if (r6 == null) goto L5;
        r0.put("request_params", r6);
    L5:
        X(r3, r0);
        t0("invite_audience_failed", r0);
    }

    @JvmStatic
    public static final void v(long r2, String r4, Long r5, String r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Long.valueOf(r2));
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put("token", r4);
        if (r5 == null) goto L8;
        long r3 = r5.longValue();
    L9:
        r0.put("VERSION", Long.valueOf(r3));
        if (r6 == null) goto L12;
        r0.put("list_data", r6);
    L12:
        t0("join_channel_success", r0);
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("interact_emoji_enable", Boolean.valueOf(!((Boolean) vm2.d.y.getValue(null, vm2.d.a[22])).booleanValue()));
        com.bytedance.tools.kcp.spongepreference.runtime.a r8 = com.bytedance.android.livesdk.sharedpref.d.n;
        KProperty[] r9 = com.bytedance.android.livesdk.sharedpref.d.a;
        r7.put("video_talk_support", Boolean.valueOf(((Boolean) r8.getValue(null, r9[12])).booleanValue()));
        r7.put("audio_talk_support", Boolean.valueOf(((Boolean) com.bytedance.android.livesdk.sharedpref.d.o.getValue(null, r9[13])).booleanValue()));
        v0("update_dynamic_emoji_switch", r7);
        return;
    L8:
        r3 = -1;
        goto L9
    }

    @JvmStatic
    public static final void w0(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        Intrinsics.checkNotNullParameter(r4, "reason");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("target_user_id", r3);
        r1.put("reason", r4);
        if (r5 == null) goto L5;
        r1.put("list_data", r5);
    L5:
        if (r6 == null) goto L7;
        r1.put("list_data_link_room_fight", r6);
    L7:
        t0("silence_audience_success", r1);
    }

    @JvmStatic
    public static final void y(Throwable r1, long r2, String r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        X(r1, r0);
        r0.put("duration", Long.valueOf(r2));
        r0.put("req_from", r4);
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L5;
        r0.put("is_rtc_error", r5);
    L5:
        t0("leave_channel_failed", r0);
    }

    public static void S(Long r2, String r3, Integer r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "subffix");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 == false) goto L5;
        StringBuilder r7 = new StringBuilder("timer_push_msg");
    L6:
        r7.append(r6);
        r0.put("event_name", r7.toString());
        r0.put("msg_id", String.valueOf(r2));
        if (r3 != null) goto L9;
        r3 = "null";
    L9:
        r0.put("msg_content", r3);
        Object r8 = r4;
        if (r4 != null) goto L12;
        r8 = "0";
    L12:
        r0.put("list_size", r8);
        a(r0);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r0);
        return;
    L5:
        r7 = new StringBuilder("linked_list_change_msg");
        goto L6
    }

    @JvmStatic
    public static final void T(Long r2, String r3, String r4, String r5, Integer r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", String.valueOf(r2));
        r0.put("target_user_id", r3);
        if (r4 == null) goto L5;
        r0.put("msg_content", r4);
    L5:
        if (r6 == null) goto L7;
        r0.put("list_size", Integer.valueOf(r6.intValue()));
    L7:
        if (r5 == null) goto L11;
        r0.put("error_msg", r5);
        t0("linker_enter_msg_error", r0);
        return;
    L11:
        if (r7 == false) goto L13;
        t0("linker_enter_msg", r0);
        return;
    L13:
        r0.put("event_name", "linker_enter_msg");
        a(r0);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r0);
    }

    public static void d(boolean r2, String r3, long r4, long r6, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r3, "refreshInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("refresh_info", r3);
        r0.put("msg_elapse", Long.valueOf(r4));
        r0.put("request_elapse", Long.valueOf(r6));
        r0.put("mute_elapse", Long.valueOf(r8));
        r0.put("background_elapse", Long.valueOf(r10));
        if (r2 == false) goto L5;
        t0("auto_silence_when_mute", r0);
        return;
    L5:
        t0("auto_silence_when_mute_failed", r0);
    }

    public static void W(Long r2, String r3, String r4, String r5, Integer r6, boolean r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r8 & 8) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 16) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 32) == 0) goto L14;
        r7 = false;
    L14:
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("msg_id", String.valueOf(r2));
        r9.put("target_user_id", r3);
        if (r5 == null) goto L17;
        r9.put("msg_content", r5);
    L17:
        if (r6 == null) goto L19;
        r9.put("list_size", Integer.valueOf(r6.intValue()));
    L19:
        r9.put("error_msg", r4);
        if (r7 == false) goto L22;
        a(r9);
        r9.put("event_name", "linker_update_msg_error");
        com.bytedance.android.livesdk.log.b0.o().f("ttlive_link", r9);
        return;
    L22:
        t0("linker_update_msg_error", r9);
    }

    public static void b0(boolean r2, int r3, long r4, long r6, long r8, long r10, boolean r12) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("list_status", Integer.valueOf(r3));
        r0.put("msg_elapse", Long.valueOf(r4));
        r0.put("request_elapse", Long.valueOf(r6));
        r0.put("mute_elapse", Long.valueOf(r8));
        r0.put("background_elapse", Long.valueOf(r10));
        if (r2 == false) goto L7;
        if (r12 == false) goto L6;
        t0("reset_mute_when_version_list_silence", r0);
        return;
    L6:
        t0("reset_mute_when_list_silence", r0);
        return;
    L7:
        t0("reset_mute_when_list_silence_failed", r0);
    }

    @JvmStatic
    public static final void m(long r2, int r4, int r5, int r6, int r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "fromSource");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("silence_stats", Integer.valueOf(r4));
        r0.put("duration", Long.valueOf(r2));
        r0.put("link_type", Integer.valueOf(r5));
        r0.put("position", Integer.valueOf(r6));
        r0.put("apply_source", String.valueOf(r7));
        r0.put("apply_type", Integer.valueOf(r8));
        r0.put("apply_from_source", r9);
        t0("guest_apply_success", r0);
    }

    public static void U(Long r3, String r4, String r5, String r6, Integer r7, boolean r8, String r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r4 = "";
    L6:
        if ((r10 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r7 = null;
    L15:
        if ((r10 & 32) == 0) goto L18;
        r8 = false;
    L18:
        if ((r10 & 64) == 0) goto L20;
        r9 = "";
    L20:
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r9, "subffix");
        LinkedHashMap r11 = new LinkedHashMap();
        if (r3 == null) goto L23;
        long r0 = r3.longValue();
    L24:
        r11.put("msg_id", Long.valueOf(r0));
        r11.put("target_user_id", r4);
        if (r5 == null) goto L27;
        r11.put("msg_content", r5);
    L27:
        if (r7 == null) goto L30;
        r11.put("list_size", Integer.valueOf(r7.intValue()));
    L30:
        if (r6 == null) goto L35;
        r11.put("error_msg", r6);
        if (r8 == false) goto L34;
        r11.put("event_name", "linker_leave_msg" + r9);
        a(r11);
        com.bytedance.android.livesdk.log.b0.o().f("ttlive_link", r11);
        return;
    L34:
        t0("linker_leave_msg_error" + r9, r11);
        return;
    L35:
        r11.put("event_name", "linker_leave_msg");
        a(r11);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r11);
        return;
    L23:
        r0 = 0;
        goto L24
    }
}

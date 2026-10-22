package com.bytedance.android.live.liveinteract.api.fulllink;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.multianchor.model.b;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.j;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.u5;
import com.bytedance.android.livesdk.message.linker.g;
import com.bytedance.android.livesdk.message.linker.k;
import com.bytedance.android.livesdk.message.linker.l;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import nd0.c;
import nd0.e;
import nd0.f;
import org.json.JSONObject;
import r27.a;
import yh6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TalkRoomBusinessFullLinkMonitor {
    public static final TalkRoomBusinessFullLinkMonitor a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/fulllink/TalkRoomBusinessFullLinkMonitor$WrdsStatusType;", "", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "Success", "BackLog", "Timeout", "Exception", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum WrdsStatusType extends Enum<WrdsStatusType> {
        public static final WrdsStatusType BackLog = null;
        public static final WrdsStatusType Exception = null;
        public static final WrdsStatusType Success = null;
        public static final WrdsStatusType Timeout = null;
        public static final /* synthetic */ WrdsStatusType[] a = null;
        private final int code;
        private final String msg;

        static {
            WrdsStatusType r1 = new WrdsStatusType("Success", 0, 0, "check wrds success");
            Success = r1;
            WrdsStatusType r2 = new WrdsStatusType("BackLog", 1, 1, "message backlog");
            BackLog = r2;
            WrdsStatusType r3 = new WrdsStatusType("Timeout", 2, 2, "waiting timeout");
            Timeout = r3;
            WrdsStatusType r4 = new WrdsStatusType("Exception", 3, 3, "something exception");
            Exception = r4;
            a = new WrdsStatusType[]{r1, r2, r3, r4};
        }

        public static WrdsStatusType valueOf(String r1) {
            return (WrdsStatusType) a.a(WrdsStatusType.class, r1);
        }

        public static WrdsStatusType[] values() {
            return (WrdsStatusType[]) a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public WrdsStatusType(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.code = r3;
            this.msg = r4;
        }
    }

    public TalkRoomBusinessFullLinkMonitor() {
    }

    static {
        a = new TalkRoomBusinessFullLinkMonitor();
    }

    public static void V() {
        JSONObject r2 = new JSONObject();
        c.o(c.a, LinkMonitorData.LinkPermissionCheckMonitorData, r2, 0, null, false, 28);
    }

    public static void h0() {
        JSONObject r2 = new JSONObject();
        r2.put("exception_msg", ExceptionsKt.stackTraceToString(new Exception()));
        c.o(c.a, LinkMonitorData.RealOnCreateException, r2, 0, null, false, 28);
    }

    public static void R(boolean r8) {
        if (r8 == false) goto L4;
        int r4 = 1;
    L5:
        JSONObject r3 = new JSONObject();
        r3.put("show_notification", r8);
        c.o(c.a, LinkMonitorData.LinkOnlineFloatWindowStatusBarNotification, r3, r4, null, false, 24);
        return;
    L4:
        r4 = 2;
        goto L5
    }

    public static void U(BaseCheckException r8) {
        Intrinsics.checkNotNullParameter(r8, "exception");
        JSONObject r3 = new JSONObject();
        switch(f.a[r8.getOperateType().ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        String r0 = "universal_anim_for_saas";
    L14:
        r3.put("operate_type", r0);
        int r1 = f.b[r8.getCheckType().ordinal()];
        if (r1 != 1) goto L17;
        String r2 = "login_check";
    L30:
        r3.put("check_type", r2);
        c r4 = c.a;
        Throwable r9 = r8.getCause();
        r4.getClass();
        Pair r10 = c.t(r9, r3);
        c.o(r4, LinkMonitorData.LinkPermissionCheckMonitorData, r3, ((Number) r10.getFirst()).intValue(), (String) r10.getSecond(), false, 16);
        return;
    L17:
        if (r1 != 2) goto L19;
        r2 = "android_permission_check";
        goto L30
    L19:
        if (r1 != 3) goto L21;
        r2 = "video_short_plugin_check";
        goto L30
    L21:
        if (r1 != 4) goto L23;
        r2 = "interact_plugin_check";
        goto L30
    L23:
        if (r1 == 5) goto L25;
        r2 = "unknown: " + r8.getCheckType();
        goto L30
    L25:
        r2 = "server_permission_check";
        goto L30
    L7:
        r0 = "midi";
        goto L14
    L8:
        r0 = "pre_reply";
        goto L14
    L9:
        r0 = "join";
        goto L14
    L10:
        r0 = "resume";
        goto L14
    L11:
        r0 = "pre_apply";
        goto L14
    L12:
        r0 = "reply";
        goto L14
    L13:
        r0 = "apply";
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void a0(Map r8) {
        Intrinsics.checkNotNullParameter(r8, "extraParams");
        JSONObject r3 = new JSONObject();
        Iterator r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r9.next();
        r3.put((String) r0.getKey(), r0.getValue());
        goto L4
    L6:
        c.o(c.a, LinkMonitorData.BusinessPanelAction, r3, 0, null, false, 28);
    }

    public static void b0(HashMap r8) {
        Intrinsics.checkNotNullParameter(r8, "logMap");
        JSONObject r3 = new JSONObject();
        Iterator r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r9.next();
        r3.put((String) r0.getKey(), r0.getValue());
        goto L4
    L6:
        c.o(c.a, LinkMonitorData.MultiLinkScopeError, r3, 0, null, true, 12);
    }

    public static void e(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sei");
        JSONObject r3 = new JSONObject();
        r3.put("sei", r8);
        c.o(c.a, LinkMonitorData.AudioSubtitleSeiErrorMonitorData, r3, 0, null, false, 28);
    }

    public static void g0(String r8) {
        Intrinsics.checkNotNullParameter(r8, "failReason");
        JSONObject r3 = new JSONObject();
        r3.put("success", 0);
        r3.put("reason", r8);
        c.o(c.a, LinkMonitorData.AnchorPreCheckActionMonitorData, r3, 1, r8, false, 16);
    }

    public static long h(long r5) {
        if (r5 <= 0) goto L8;
        i97.a r2 = i97.a.a;
        if (r5 < System.currentTimeMillis()) goto L7;
        return 0;
    L7:
        return System.currentTimeMillis() - r5;
    L8:
        return 0;
    }

    public static void i0(h1 r8) {
        Intrinsics.checkNotNullParameter(r8, "linkerMessage");
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "$this$messageId");
        r3.put("msg_id", r8.getMessageId3());
        r3.put("big_event_type", "switch_backup_stream");
        u5 r9 = r8.getAnchorStreamSwitchContent();
        if (r9 == null) goto L5;
        r3.put("is_use_backup_stream", r9.isUseBackUp());
    L5:
        c.o(c.a, LinkMonitorData.ReceiveBigEventMsgMonitorData, r3, 0, null, false, 28);
    }

    public static void k(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        JSONObject r3 = new JSONObject();
        r3.put("reason", r8);
        c.o(c.a, LinkMonitorData.AvatarRecognitionFailMonitorData, r3, 0, null, false, 28);
    }

    public static void l0(b r7) {
        JSONObject r2 = new JSONObject();
        String r0 = null;
        if (r7 == null) goto L5;
        Long r1 = d.a(r7);
    L6:
        r2.put("msg_id", r1);
        if (r7 == null) goto L9;
        Intrinsics.checkNotNullParameter(r7, "$this$fromUserId");
        r0 = r7.get_fromUserId();
    L9:
        r2.put("from_user_id", r0);
        c.o(c.a, LinkMonitorData.ReceiveInviteMsgMonitorData, r2, 0, null, false, 28);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void m(List r8) {
        Intrinsics.checkNotNullParameter(r8, "modes");
        JSONObject r3 = new JSONObject();
        r3.put("modes", r8.toString());
        c.o(c.a, LinkMonitorData.AvatarSupportedVideoShowModeMonitorData, r3, 0, null, false, 28);
    }

    public static void m0(long r7) {
        JSONObject r2 = new JSONObject();
        r2.put("msg_id", r7);
        r2.put("banner_type", "guest_kick_out");
        c.o(c.a, LinkMonitorData.BannerMsgMonitorData, r2, 0, null, false, 28);
    }

    public static void n0(b r7) {
        JSONObject r2 = new JSONObject();
        if (r7 == null) goto L5;
        Long r8 = d.a(r7);
    L6:
        r2.put("msg_id", r8);
        c.o(c.a, LinkMonitorData.ReceivePermitMsgMonitorData, r2, 0, null, false, 28);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public static void o0(z0 r7) {
        JSONObject r2 = new JSONObject();
        if (r7 == null) goto L5;
        Intrinsics.checkNotNullParameter(r7, "$this$messageIdExt");
        long r0 = r7.getMessageId2();
    L6:
        r2.put("msg_id", r0);
        pd0.b r1 = pd0.b.a;
        if (r7 == null) goto L9;
        int r3 = r7.getReplyType();
    L10:
        r2.put("reply_type", pd0.b.i(r3));
        if (r7 == null) goto L14;
        String r8 = r7.getReplyPrompts();
        if (r8 == null) goto L14;
    L15:
        r2.put("reply_prompts", r8);
        c.o(c.a, LinkMonitorData.ReceiveReplyMsgMonitorData, r2, 0, null, false, 28);
        return;
    L14:
        r8 = "";
        goto L15
    L9:
        r3 = 0;
        goto L10
    L5:
        r0 = 0;
        goto L6
    }

    public static void p(String r8) {
        Intrinsics.checkNotNullParameter(r8, "kickOutUserIds");
        JSONObject r3 = new JSONObject();
        r3.put("kick_out_user_ids", r8);
        c.o(c.a, LinkMonitorData.EnlargeCloseStartApiMonitorData, r3, 0, null, false, 28);
    }

    public static void p0(long r7) {
        JSONObject r2 = new JSONObject();
        r2.put("msg_id", r7);
        r2.put("banner_type", "guest_sys_kick_out");
        c.o(c.a, LinkMonitorData.BannerMsgMonitorData, r2, 0, null, false, 28);
    }

    public static void r0(int r7) {
        JSONObject r2 = new JSONObject();
        r2.put("status_code", r7);
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r0 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        String r1 = "";
        if (r0 == null) goto L8;
        Map r4 = r0.getMap();
        if (r4 == null) goto L8;
        String r5 = (String) r4.get("enter_from_merge");
        if (r5 == null) goto L8;
    L9:
        r2.put("enter_from_merge", r5);
        if (r0 == null) goto L17;
        Map r3 = r0.getMap();
        if (r3 == null) goto L17;
        String r6 = (String) r3.get("enter_method");
        if (r6 == null) goto L17;
        r1 = r6;
    L17:
        r2.put("enter_method", r1);
        c.o(c.a, LinkMonitorData.InnerDrawWRDSPreloadMonitorData, r2, r7, null, false, 24);
        return;
    L8:
        r5 = "";
        goto L9
    }

    public static void x(String r8) {
        Intrinsics.checkNotNullParameter(r8, "requestPage");
        JSONObject r3 = new JSONObject();
        r3.put("request_page", r8);
        c.o(c.a, LinkMonitorData.FastMatchActionMonitorData, r3, 0, null, false, 28);
    }

    public static void x0(long r7) {
        JSONObject r2 = new JSONObject();
        r2.put("status", "open");
        r2.put("source_room_id", r7);
        c.o(c.a, LinkMonitorData.LinkmicApplyFloatWindowData, r2, 0, null, false, 28);
    }

    public static void C(long r2, Throwable r4) {
        JSONObject r0 = new JSONObject();
        Y(LinkMonitorData.InviteListApiMonitorData, h(r2), r4, r0);
    }

    public static void D(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "logId");
        JSONObject r0 = new JSONObject();
        Z(LinkMonitorData.InviteListApiMonitorData, h(r2), r4, r0);
    }

    public static void E(long r2, Throwable r4) {
        JSONObject r0 = new JSONObject();
        Y(LinkMonitorData.WaitingListApiMonitorData, h(r2), r4, r0);
    }

    public static void F(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "logId");
        JSONObject r0 = new JSONObject();
        Z(LinkMonitorData.WaitingListApiMonitorData, h(r2), r4, r0);
    }

    public static void M(Throwable r2, long r3) {
        JSONObject r0 = new JSONObject();
        Y(LinkMonitorData.JoinChannelApiMonitorData, h(r3), r2, r0);
    }

    public static void N(ExtraResponse r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "response");
        JSONObject r0 = new JSONObject();
        Z(LinkMonitorData.JoinChannelApiMonitorData, h(r3), r2.logId, r0);
    }

    public static void Q(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "settingContent");
        Intrinsics.checkNotNullParameter(r9, "source");
        JSONObject r3 = new JSONObject();
        r3.put("setting_content", r8);
        r3.put("source", r9);
        c.o(c.a, LinkMonitorData.LinkMicSettingUpdateMonitorData, r3, 0, null, false, 28);
    }

    public static void T(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "statusMsg");
        JSONObject r3 = new JSONObject();
        r3.put("reason", r8);
        c.o(c.a, LinkMonitorData.LinkOnlineFloatWindowStatusChanged, r3, r9, r8, false, 16);
    }

    public static void a(long r8, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "extra");
        r10.put("msg_id", r8);
        c.o(c.a, LinkMonitorData.AnchorReceiveEnlargeGuestUiChangeMessage, r10, 0, null, false, 28);
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "receiveEnlargeGuestUIChangeMessage", 0, null, r10, 88);
    }

    public static void e0(boolean r7, boolean r8) {
        JSONObject r2 = new JSONObject();
        r2.put("is_paidlive", r7);
        r2.put("has_ticket", r8);
        c.o(c.a, LinkMonitorData.PaidLiveApplyNoTicketMonitorData, r2, 0, null, false, 28);
    }

    public static void f(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "interactId");
        JSONObject r3 = new JSONObject();
        r3.put("interactId", r8);
        r3.put("duration", h(r9));
        c.o(c.a, LinkMonitorData.AutoJoinChannelData, r3, 0, null, false, 28);
    }

    public static void g(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        JSONObject r4 = new JSONObject();
        r4.put("tag", r9);
        r4.put("msg", r10);
        c.o(c.a, LinkMonitorData.AVSecurityMonitorData, r4, 0, null, false, 28);
    }

    public static void j(boolean r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "extra");
        if (r8 == false) goto L5;
        String r10 = "anchor";
    L6:
        r9.put("role", r10);
        c.o(c.a, LinkMonitorData.CommonWMUpdateLiveCoreAndRtcInfo, r9, 0, null, false, 28);
        return;
    L5:
        r10 = "guest";
        goto L6
    }

    public static void j0(long r8, k r10) {
        JSONObject r7 = new JSONObject();
        r7.put("msg_id", r8);
        if (r10 == null) goto L5;
        String r9 = l.a(r10);
    L6:
        r7.put("from_user_id", r9);
        int r11 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "receiveEnlargeGuestInviteMessage", 0, null, r7, 88);
        c.o(c.a, LinkMonitorData.ReceiveEnlargeInviteMsgMonitorData, r7, 0, null, false, 28);
        return;
    L5:
        r9 = null;
        goto L6
    }

    public static void k0(long r8, g r10) {
        Intrinsics.checkNotNullParameter(r10, "enlargeReplyContent");
        JSONObject r3 = new JSONObject();
        r3.put("msg_id", r8);
        pd0.b r9 = pd0.b.a;
        r3.put("reply_type", pd0.b.i(r10.getReplyType()));
        r3.put("reply_prompts", r10.getReplyPrompts());
        c.o(c.a, LinkMonitorData.ReceiveEnlargeReplyMsgMonitorData, r3, 0, null, false, 28);
    }

    public static void n(String r9, Exception r10) {
        Intrinsics.checkNotNullParameter(r9, "mode");
        Intrinsics.checkNotNullParameter(r10, "e");
        JSONObject r4 = new JSONObject();
        r4.put("mode", r9);
        r4.put("exception", r10.toString());
        c.o(c.a, LinkMonitorData.AvatarVideoShowModeSwitchFailMonitorData, r4, 0, null, false, 28);
    }

    public static void s0(long r7, int r9) {
        JSONObject r2 = new JSONObject();
        r2.put("duration", r7);
        c.o(c.a, LinkMonitorData.ANCHOR_ZERO_LINK_DURATION_WHEN_CONNECTION_OVER, r2, r9, null, false, 24);
    }

    public static void v(String r7, boolean r8) {
        JSONObject r2 = new JSONObject();
        r2.put("target_user_id", r7);
        if (r8 == false) goto L5;
        String r9 = "accept";
    L6:
        r2.put("reply_type", r9);
        c.o(c.a, LinkMonitorData.EnlargeReplyStartApiMonitorData, r2, 0, null, false, 28);
        return;
    L5:
        r9 = "reject";
        goto L6
    }

    public static void z(long r2, Throwable r4) {
        JSONObject r0 = new JSONObject();
        Y(LinkMonitorData.InteractListApiMonitorData, h(r2), r4, r0);
    }

    public static void A(long r2, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        JSONObject r0 = new JSONObject();
        r0.put("req_from", r4);
        Y(LinkMonitorData.FinishApiMonitorData, h(r2), r5, r0);
    }

    public static void B(long r2, String r4, ExtraResponse r5) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        Intrinsics.checkNotNullParameter(r5, "response");
        JSONObject r0 = new JSONObject();
        r0.put("req_from", r4);
        Z(LinkMonitorData.FinishApiMonitorData, h(r2), r5.logId, r0);
    }

    public static void B0(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "targetLayoutConfig");
        Intrinsics.checkNotNullParameter(r9, "switchType");
        if (e.b() != true) goto L5;
    L8:
        JSONObject r2 = new JSONObject();
        r2.put("target_layout_config", r7);
        r2.put("origin_layout_config", r8);
        r2.put("switch_type", r9);
        c.o(c.a, LinkMonitorData.CommonWindowSwitchUILayout, r2, 0, null, false, 28);
        return;
    L5:
        if (e.c() == true) goto L8;
        jy0.b.d("ttlive_link", "trySwitchLayout, targetLayoutConfig = " + r7 + ", originLayoutConfig = " + r8 + ", switchType = " + r9);
    }

    public static void D0(long r2, long r4, Throwable r6) {
        JSONObject r0 = new JSONObject();
        r0.put("target_position", r2);
        Y(LinkMonitorData.UpdatePositionApiMonitorData, h(r4), r6, r0);
    }

    public static void E0(long r2, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("target_position", r2);
        Z(LinkMonitorData.UpdatePositionApiMonitorData, h(r4), r6, r0);
    }

    public static void b(int r2, long r3, Throwable r5) {
        JSONObject r0 = new JSONObject();
        r0.put("action", r2);
        Y(LinkMonitorData.ApplyStashData, h(r3), r5, r0);
    }

    public static void c0(String r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "openSource");
        JSONObject r0 = new JSONObject();
        r0.put("open_source", r8);
        pd0.b r11 = pd0.b.a;
        r0.put("target_scene", pd0.b.e(r9));
        r0.put("target_ui_layout", pd0.b.f(r10));
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenChatRoom, "openAction", 0, null, r0, 88);
        c.o(c.a, LinkMonitorData.OpenChatRoomActionMonitorData, r0, 0, null, false, 28);
    }

    public static void l(boolean r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "extraInfo");
        JSONObject r3 = new JSONObject();
        r3.put("support", r8);
        r3.put("is_anchor", r9);
        r3.put("extra_info", r10);
        c.o(c.a, LinkMonitorData.AvatarSupportVideoAvatarMonitorData, r3, 0, null, false, 28);
    }

    public static void o(String r2, long r3, Throwable r5) {
        Intrinsics.checkNotNullParameter(r2, "kickOutUserIds");
        JSONObject r0 = new JSONObject();
        r0.put("kick_out_user_ids", r2);
        Y(LinkMonitorData.EnlargeCloseApiMonitorData, h(r3), r5, r0);
    }

    public static void q(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "kickOutUserIds");
        Intrinsics.checkNotNullParameter(r5, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("kick_out_user_ids", r2);
        Z(LinkMonitorData.EnlargeCloseApiMonitorData, h(r3), r5, r0);
    }

    public static void q0(int r8, long r9, String r11) {
        Intrinsics.checkNotNullParameter(r11, "actionType");
        JSONObject r3 = new JSONObject();
        r3.put("duration", r9);
        r3.put("status_code", r8);
        r3.put("action_type", r11);
        c.o(c.a, LinkMonitorData.BackendSpendTimeMonitorData, r3, r8, null, false, 24);
    }

    public static void s(String r8, boolean r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "targetUserId");
        JSONObject r3 = new JSONObject();
        r3.put("target_user_id", r8);
        if (r9 == false) goto L5;
        String r11 = "enlarge";
    L6:
        r3.put("invite_type", r11);
        r3.put("operate_type", r10);
        c.o(c.a, LinkMonitorData.EnlargeInviteStartApiMonitorData, r3, 0, null, false, 28);
        return;
    L5:
        r11 = "reduce";
        goto L6
    }

    public static void A0(h1 r8, long r9, long r11, WrdsStatusType r13) {
        Intrinsics.checkNotNullParameter(r8, "linkerMessage");
        Intrinsics.checkNotNullParameter(r13, "wrdsStatusType");
        if (e.b() == true) goto L7;
        if (e.c() == true) goto L7;
        return;
    L7:
        if (r13 == WrdsStatusType.Success) goto L11;
        JSONObject r3 = new JSONObject();
        r3.put("duration", h(r11));
        Intrinsics.checkNotNullParameter(r8, "$this$messageId");
        r3.put("msg_id", r8.getMessageId3());
        r3.put("wrds_version", r9);
        r3.put("msg_type", r8.getType2());
        r3.put("from_source", "for_linker_msg");
        c.o(c.a, LinkMonitorData.WRDSForMsgMonitorData, r3, r13.getCode(), r13.getMsg(), false, 16);
        return;
    }

    public static void C0(String r2, int r3, long r4, Throwable r6) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        JSONObject r0 = new JSONObject();
        r0.put("to_user_id", r2);
        pd0.b r5 = pd0.b.a;
        r0.put("target_link_type", pd0.b.g(r3));
        Y(LinkMonitorData.UpdateLinkTypeApplyApiMonitorData, h(r4), r6, r0);
    }

    public static void K(String r2, String r3, Throwable r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r3, "secToUserId");
        JSONObject r0 = new JSONObject();
        r0.put("to_user_id", r2);
        r0.put("sec_to_user_id", r3);
        Y(LinkMonitorData.InviteApiMonitorData, h(r5), r4, r0);
    }

    public static void L(String r2, String r3, ExtraResponse r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r3, "secToUserId");
        Intrinsics.checkNotNullParameter(r4, "response");
        JSONObject r0 = new JSONObject();
        r0.put("to_user_id", r2);
        r0.put("sec_to_user_id", r3);
        Z(LinkMonitorData.InviteApiMonitorData, h(r5), r4.logId, r0);
    }

    public static void O(String r2, String r3, long r4, Throwable r6) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        JSONObject r0 = new JSONObject();
        r0.put("user_id", r2);
        r0.put("sec_user_id", r3);
        Y(LinkMonitorData.KickOutApiMonitorData, h(r4), r6, r0);
    }

    public static void P(String r2, String r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r6, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("user_id", r2);
        r0.put("sec_user_id", r3);
        Z(LinkMonitorData.KickOutApiMonitorData, h(r4), r6, r0);
    }

    public static void S(int r8, String r9, boolean r10, Exception r11) {
        Intrinsics.checkNotNullParameter(r9, "statusMsg");
        JSONObject r3 = new JSONObject();
        r3.put("is_setting_open", r10);
        if (r11 == null) goto L5;
        r3.put("exception_msg", r11.getMessage());
    L5:
        c.o(c.a, LinkMonitorData.LinkOnlineFloatWindowRTCBackUpEvent, r3, r8, r9, false, 16);
    }

    public static void W(long r2, int r4, long r5, Throwable r7) {
        JSONObject r0 = new JSONObject();
        r0.put("target_position", r2);
        pd0.b r3 = pd0.b.a;
        r0.put("position_status", pd0.b.h(r4));
        Y(LinkMonitorData.LockPositionApiMonitorData, h(r5), r7, r0);
    }

    public static void X(long r2, int r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("target_position", r2);
        pd0.b r3 = pd0.b.a;
        r0.put("position_status", pd0.b.h(r4));
        Z(LinkMonitorData.LockPositionApiMonitorData, h(r5), r7, r0);
    }

    public static void Y(LinkMonitorData r9, long r10, Throwable r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r9, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r13, "extra");
        c.r(c.a, r9, null, r10, r12, r13, 34);
    }

    public static void Z(LinkMonitorData r9, long r10, String r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r9, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r12, "logId");
        Intrinsics.checkNotNullParameter(r13, "extra");
        c.s(c.a, r9, null, r10, r12, r13, 98);
    }

    public static void c(int r2, long r3, ExtraResponse r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("action", r2);
        LinkMonitorData r4 = LinkMonitorData.ApplyStashData;
        long r7 = h(r3);
        if (r5 == null) goto L8;
        String r8 = r5.logId;
        if (r8 == null) goto L8;
        r6 = r8;
    L8:
        Z(r4, r7, r6, r0);
    }

    public static /* synthetic */ void d(TalkRoomBusinessFullLinkMonitor r0, int r1, long r2, ExtraResponse r4) {
        r0.getClass();
        c(r1, r2, r4, "");
    }

    public static void f0(String r2, String r3, long r4, ExtraResponse r6) {
        Intrinsics.checkNotNullParameter(r6, "response");
        JSONObject r0 = new JSONObject();
        r0.put("target_user_id", r2);
        r0.put("target_sec_user_id", r3);
        Z(LinkMonitorData.PermitApiMonitorData, h(r4), r6.logId, r0);
    }

    public static void i(int r8, long r9, h r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "request");
        JSONObject r0 = new JSONObject();
        r0.put("duration", r9);
        r0.put("ui_layout", r11.a);
        r0.put("to_ui_layout", r11.a);
        if (r12 != null) goto L5;
    L6:
        j r10 = r11.c;
        Intrinsics.checkNotNullParameter(r10, "$this$sbToString");
        r0.put("trace_info", r10.a.toString());
    L8:
        if (r8 != (-1)) goto L10;
    L11:
        c.o(c.a, LinkMonitorData.CommonWMLayoutConfigLoadMonitorData, r0, r8, null, false, 24);
    L13:
        if (e.b() != true) goto L15;
        return;
    L15:
        if (e.c() == true) goto L19;
        c.o(c.a, LinkMonitorData.CommonWMLayoutConfigLoadMonitorDataWithSampling, r0, r8, null, false, 24);
        return;
    L19:
        return;
    L10:
        if (r8 != 101) goto L13;
    L5:
        if (r0.put("trace_info", r12) != null) goto L8;
        goto L6
    }

    public static void t0(long r2, int r4, long r5, Throwable r7) {
        JSONObject r0 = new JSONObject();
        r0.put("emoji_id", r2);
        pd0.b r3 = pd0.b.a;
        r0.put("emoji_type", pd0.b.b(r4));
        Y(LinkMonitorData.SendEmojiApiMonitorData, h(r5), r7, r0);
    }

    public static void u(String r8, boolean r9, long r10, Throwable r12) {
        Intrinsics.checkNotNullParameter(r8, "targetUserId");
        JSONObject r0 = new JSONObject();
        r0.put("target_user_id", r8);
        if (r9 == false) goto L5;
        String r11 = "accept";
    L6:
        r0.put("reply_type", r11);
        c.a.getClass();
        Pair r13 = c.t(r12, r0);
        int r14 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "replyEnlargeGuest", ((Number) r13.getFirst()).intValue(), (String) r13.getSecond(), r0, 64);
        Y(LinkMonitorData.EnlargeReplyApiMonitorData, h(r10), r12, r0);
        return;
    L5:
        r11 = "reject";
        goto L6
    }

    public static void u0(long r2, int r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("emoji_id", r2);
        pd0.b r3 = pd0.b.a;
        r0.put("emoji_type", pd0.b.b(r4));
        Z(LinkMonitorData.SendEmojiApiMonitorData, h(r5), r7, r0);
    }

    public static void v0(long r2, String r4, long r5, Throwable r7) {
        Intrinsics.checkNotNullParameter(r4, "positionName");
        JSONObject r0 = new JSONObject();
        r0.put("target_position", r2);
        r0.put("target_position_name", r4);
        Y(LinkMonitorData.SetPositionAttributeApiMonitorData, h(r5), r7, r0);
    }

    public static void w(String r8, boolean r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r8, "targetUserId");
        Intrinsics.checkNotNullParameter(r12, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("target_user_id", r8);
        if (r9 == false) goto L5;
        String r11 = "accept";
    L6:
        r0.put("reply_type", r11);
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "replyEnlargeGuest", 0, null, r0, 88);
        Z(LinkMonitorData.EnlargeReplyApiMonitorData, h(r10), r12, r0);
        return;
    L5:
        r11 = "reject";
        goto L6
    }

    public static void w0(long r2, String r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r4, "positionName");
        Intrinsics.checkNotNullParameter(r7, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("target_position", r2);
        r0.put("target_position_name", r4);
        Z(LinkMonitorData.SetPositionAttributeApiMonitorData, h(r5), r7, r0);
    }

    public static void G(int r2, LinkApplyType r3, int r4, Throwable r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "applyType");
        JSONObject r0 = new JSONObject();
        r0.put("apply_position", r2);
        pd0.b r7 = pd0.b.a;
        r0.put("apply_type", pd0.b.d(r3));
        r0.put("target_link_type", pd0.b.g(r4));
        Y(LinkMonitorData.ApplyApiMonitorData, h(r6), r5, r0);
    }

    public static void H(int r2, LinkApplyType r3, int r4, ExtraResponse r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "applyType");
        Intrinsics.checkNotNullParameter(r5, "response");
        JSONObject r0 = new JSONObject();
        r0.put("position", r2);
        pd0.b r7 = pd0.b.a;
        r0.put("apply_type", pd0.b.d(r3));
        r0.put("target_link_type", pd0.b.g(r4));
        Z(LinkMonitorData.ApplyApiMonitorData, h(r6), r5.logId, r0);
    }

    public static void I(String r2, int r3, int r4, Throwable r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "secToUserId");
        JSONObject r0 = new JSONObject();
        r0.put("sec_to_user_id", r2);
        pd0.b r7 = pd0.b.a;
        r0.put("target_reply_type", pd0.b.i(r3));
        r0.put("target_link_type", pd0.b.g(r4));
        Y(LinkMonitorData.ReplyApiMonitorData, h(r6), r5, r0);
    }

    public static void J(String r2, int r3, int r4, ExtraResponse r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "secToUserId");
        Intrinsics.checkNotNullParameter(r5, "response");
        JSONObject r0 = new JSONObject();
        r0.put("sec_to_user_id", r2);
        pd0.b r7 = pd0.b.a;
        r0.put("target_reply_type", pd0.b.i(r3));
        r0.put("target_link_type", pd0.b.g(r4));
        Z(LinkMonitorData.ReplyApiMonitorData, h(r6), r5.logId, r0);
    }

    public static void d0(String r8, Map r9, Throwable r10, Integer r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "step");
        Intrinsics.checkNotNullParameter(r9, "extraParams");
        JSONObject r6 = new JSONObject();
        Iterator r13 = r9.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r13.next();
        r6.put((String) r0.getKey(), r0.getValue());
        goto L4
    L6:
        c.a.getClass();
        Pair r14 = c.t(r10, r6);
        if (r11 == null) goto L9;
        int r15 = r11.intValue();
    L10:
        int r4 = r15;
        if (r12 != null) goto L13;
        r12 = (String) r14.getSecond();
    L13:
        int r16 = rd0.a.a;
        MultiTraceData$TraceBusiness r1 = MultiTraceData$TraceBusiness.ChatRoom;
        MultiTraceData$TraceEvent r2 = MultiTraceData$TraceEvent.OPEN_LINKED_PANEL;
        rd0.a.b(r1, r2, r8, r4, r12, r6, 64);
        return;
    L9:
        r15 = ((Number) r14.getFirst()).intValue();
        goto L10
    }

    public static void r(String r8, boolean r9, long r10, long r12, Throwable r14) {
        Intrinsics.checkNotNullParameter(r8, "targetUserId");
        JSONObject r0 = new JSONObject();
        r0.put("target_user_id", r8);
        if (r9 == false) goto L5;
        String r11 = "enlarge";
    L6:
        r0.put("invite_type", r11);
        r0.put("operate_type", r10);
        c.a.getClass();
        Pair r13 = c.t(r14, r0);
        int r15 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "enlargeGuestInvite", ((Number) r13.getFirst()).intValue(), (String) r13.getSecond(), r0, 64);
        Y(LinkMonitorData.EnlargeInviteApiMonitorData, h(r12), r14, r0);
        return;
    L5:
        r11 = "reduce";
        goto L6
    }

    public static void t(String r8, boolean r9, long r10, long r12, String r14) {
        Intrinsics.checkNotNullParameter(r8, "targetUserId");
        Intrinsics.checkNotNullParameter(r14, "logId");
        JSONObject r0 = new JSONObject();
        r0.put("target_user_id", r8);
        if (r9 == false) goto L5;
        String r11 = "enlarge";
    L6:
        r0.put("invite_type", r11);
        r0.put("operate_type", r10);
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "enlargeGuestInvite", 0, null, r0, 88);
        Z(LinkMonitorData.EnlargeInviteApiMonitorData, h(r12), r14, r0);
        return;
    L5:
        r11 = "reduce";
        goto L6
    }

    public static void y(int r2, int r3, int r4, long r5, Throwable r7) {
        JSONObject r0 = new JSONObject();
        r0.put("target_scene", r2);
        pd0.b r6 = pd0.b.a;
        r0.put("emoji_type", pd0.b.b(r3));
        r0.put("category", pd0.b.a(r4));
        Y(LinkMonitorData.ListEmojisApiMonitorData, h(r5), r7, r0);
    }

    public static void z0(int r9, int r10, int r11, long r12, ExtraResponse r14) {
        Intrinsics.checkNotNullParameter(r14, "response");
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout();
        JSONObject r8 = new JSONObject();
        pd0.b r1 = pd0.b.a;
        r8.put("from_scene", pd0.b.e(r9));
        r8.put("to_scene", pd0.b.e(r10));
        r8.put("from_ui_layout", pd0.b.f(r0));
        r8.put("to_ui_layout", pd0.b.f(r11));
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.SwitchScene, "switchScene", 0, null, r8, 88);
        TalkRoomBusinessFullLinkMonitor r15 = a;
        LinkMonitorData r16 = LinkMonitorData.SwitchSceneApiMonitorData;
        r15.getClass();
        Z(r16, h(r12), r14.logId, r8);
        InteractLinkFullLinkMonitor.t0("switch_scene_success", ((v1) r14.data).getLiveCoreExtInfo(), ((v1) r14.data).getRtcExtInfo(), ((v1) r14.data).getMultiLiveCoreInfo(), ((v1) r14.data).getMultiRtcInfo());
    }

    public static void y0(int r8, int r9, int r10, String r11, long r12, Throwable r14) {
        Intrinsics.checkNotNullParameter(r11, "reason");
        int r13 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout();
        JSONObject r7 = new JSONObject();
        pd0.b r0 = pd0.b.a;
        r7.put("from_scene", pd0.b.e(r8));
        r7.put("to_scene", pd0.b.e(r9));
        r7.put("from_ui_layout", pd0.b.f(r13));
        r7.put("to_ui_layout", pd0.b.f(r10));
        c.a.getClass();
        Pair r15 = c.t(r14, r7);
        int r16 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.SwitchScene, "switchScene", ((Number) r15.getFirst()).intValue(), (String) r15.getSecond(), r7, 64);
        Y(LinkMonitorData.SwitchSceneApiMonitorData, h(r12), r14, r7);
    }
}

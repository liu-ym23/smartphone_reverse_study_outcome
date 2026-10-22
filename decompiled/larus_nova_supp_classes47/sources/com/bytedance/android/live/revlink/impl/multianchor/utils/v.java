package com.bytedance.android.live.revlink.impl.multianchor.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.livesdk.link.model.ILinkerCloseContent;
import com.bytedance.android.livesdk.link.model.IListUserLinkmicContent;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.v6;
import com.bytedance.android.livesdk.link.model.w6;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v extends e {
    public static long h;
    public static final /* synthetic */ int i = 0;
    public boolean e;
    public final List<String> f;
    public long g;

    public static final class a {
    }

    static {
    }

    public final void J() {
        Intrinsics.checkNotNullParameter("linking_invite", "panelType");
        Map<String, Object> r0 = new LinkedHashMap();
        r0.put("panel_type", "linking_invite");
        Object r1 = "";
        if ("".length() != 0) goto L5;
        int r2 = 1;
    L6:
        r0.put("error_code", Integer.valueOf(r2 ^ 1));
        r0.put("error_msg", "");
        com.bytedance.android.live.revlink.impl.global.c r3 = this.d;
        com.bytedance.android.live.revenuelink.rtc.f r4 = null;
        if (r3 == null) goto L9;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r5 = r3.Ig();
    L10:
        if (r5 == null) goto L17;
        PkBaseStateMachine.c r6 = r5.getCurPKBaseState();
        if (r6 == null) goto L17;
        Object r7 = r6.c;
        if (r7 == null) goto L17;
        r1 = r7;
    L17:
        r0.put("pk_stage", r1);
        com.bytedance.android.live.revlink.impl.global.c r8 = this.d;
        if (r8 == null) goto L20;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r9 = r8.Ig();
    L21:
        if (r9 == null) goto L25;
        LiveData<Long> r10 = r9.getBaseTimeLeft();
        if (r10 == null) goto L25;
        Long r12 = (Long) r10.getValue();
    L26:
        r0.put("pk_time_left", String.valueOf(r12));
        com.bytedance.android.live.revlink.impl.global.c r13 = this.d;
        if (r13 == null) goto L29;
        r4 = r13.m0();
    L29:
        if (r4 == null) goto L41;
        com.bytedance.android.live.revenuelink.rtc.i r14 = r4.getRtcManager();
        if (r14 == null) goto L41;
        com.bytedance.android.live.revenuelink.rtc.p r15 = r14.L();
        if (r15 == null) goto L41;
        List<com.bytedance.android.live.revenuelink.rtc.o> r16 = r15.l();
        if (r16 == null) goto L41;
        List<com.bytedance.android.live.revenuelink.rtc.o> r17 = r16;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L38:
        if (r19.hasNext() == false) goto L40;
        r18.add(Boolean.valueOf(((com.bytedance.android.live.revenuelink.rtc.o) r19.next()).g));
        goto L38
    L40:
        r0.put("mute_list", r18);
    L41:
        D("show_link_invite_panel", com.bytedance.android.live.revlink.impl.utils.t.a(0), r0);
        return;
    L25:
        r12 = null;
        goto L26
    L20:
        r9 = null;
        goto L21
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final or2.d r() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(or2.d.class);
        Intrinsics.checkNotNull(r0);
        return (com.bytedance.live.kmp.core.c) r0;
    }

    public final d31.f s() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.y2();
    }

    public final void A(i6 r4) {
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", String.valueOf(qj.a(r4)));
        Intrinsics.checkNotNullParameter(r4, "$this$sceneExt");
        r0.put("msg_scene", Long.valueOf(r4.getScene()));
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        r0.put("msg_linker_id", Long.valueOf(r4.getLinkerId()));
        ILinkerCloseContent r5 = r4.getClose();
        if (r5 == null) goto L6;
        r0.put("source", Integer.valueOf(r5.getSource()));
        r0.put("reason", Integer.valueOf(r5.getReason()));
    L6:
        if (k() == false) goto L8;
        b(r0);
        H("receive_linker_close_msg", r0);
        return;
    L8:
        d(r0);
        int r6 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link", "receive_linker_close_msg " + r0, null);
    }

    public final void B(i6 r7) {
        Intrinsics.checkNotNullParameter(r7, Constants.OperatorKey.MSG);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", String.valueOf(qj.a(r7)));
        Intrinsics.checkNotNullParameter(r7, "$this$sceneExt");
        r0.put("msg_scene", Long.valueOf(r7.getScene()));
        Intrinsics.checkNotNullParameter(r7, "$this$linkerIdExt");
        r0.put("msg_linker_id", Long.valueOf(r7.getLinkerId()));
        g6 r1 = j6.c(r7);
        if (r1 == null) goto L26;
        b7 r2 = r1.getMultiChannelInfo();
        String r3 = "";
        if (r2 == null) goto L8;
        String r4 = c7.a(r2);
        if (r4 == null) goto L8;
    L9:
        r0.put("multi_channel_info", r4);
        b2 r5 = r1.getPreRtcInfo();
        if (r5 == null) goto L13;
        String r6 = c2.a(r5);
        if (r6 == null) goto L13;
    L14:
        r0.put("pre_rtc_info", r6);
        r0.put("list_version", Long.valueOf(r1.getVersion()));
        String r8 = ILinkerLeaveContentBridgeKt.getUserIdEx(r1);
        if (r8 == null) goto L18;
        r3 = r8;
    L18:
        r0.put("leave_uid", r3);
        List r9 = r1.getLinkUsers();
        if (r9 == null) goto L24;
        List r10 = CollectionsKt.toList(r9);
        if (r10 == null) goto L24;
        String r12 = i11.a.c(r10);
        if (r12 == null) goto L24;
    L25:
        r0.put("list_user", r12);
    L24:
        r12 = "null";
    L13:
        r6 = "";
    L8:
        r4 = "";
    L26:
        g6 r13 = j6.c(r7);
        if (r13 == null) goto L31;
        List r14 = r13.getLinkUsers();
        if (r14 == null) goto L31;
        List r15 = CollectionsKt.toList(r14);
    L32:
        y(r0, r15);
        if (k() == false) goto L35;
        b(r0);
        H("receive_linker_leave_msg", r0);
        return;
    L35:
        d(r0);
        int r16 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.h("ttlive_anchor_link", "receive_linker_leave_msg " + r0);
        return;
    L31:
        r15 = null;
        goto L32
    }

    public final void q(ExtraResponse<bf2.a, Extra> r5) {
        Intrinsics.checkNotNullParameter(r5, "resp");
        JSONObject r1 = new JSONObject();
        y50.b.a.d(r1, "log_id", r5.logId);
        y50.b.a.d(r1, "resp", ef2.a.c((vh7.c) r5.data));
        I("get_ban_record_success", r1, false);
    }

    public static void m(i6 r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r4, "extra");
        y50.b.a.d(r4, "msg_id", String.valueOf(qj.a(r3)));
        Intrinsics.checkNotNullParameter(r3, "$this$sceneExt");
        y50.b.a.c(r4, "msg_scene", r3.getScene());
        Intrinsics.checkNotNullParameter(r3, "$this$linkerIdExt");
        y50.b.a.c(r4, "msg_linker_id", r3.getLinkerId());
    }

    public static void y(Map r5, List r6) {
        String r0 = null;
        if (r6 == null) goto L14;
        Iterator r7 = r6.iterator();
        com.bytedance.android.livesdk.link.model.p r1 = null;
    L6:
        if (r7.hasNext() == false) goto L15;
        com.bytedance.android.livesdk.link.model.p r2 = (com.bytedance.android.livesdk.link.model.p) r7.next();
        v6 r3 = com.bytedance.android.livesdk.link.model.q.c(r2);
        if (r3 == null) goto L6;
        IListUserLinkmicContent r4 = w6.a(r3);
        if (r4 == null) goto L6;
        if (r4.getAnchorAuthRole() != IListUserLinkmicContent.IAnchorAuthRole.AnchorAuthRoleOrganizer.ordinal()) goto L6;
        r1 = r2;
    L15:
        if (r1 == null) goto L17;
        boolean r8 = true;
    L18:
        r5.put("has_organizer", Boolean.valueOf(r8));
        if (r1 == null) goto L23;
        IBaseUser r9 = r1.getUser();
        if (r9 == null) goto L23;
        r0 = r9.getIdString();
    L23:
        if (r0 != null) goto L25;
        r0 = "";
    L25:
        r5.put("organizer_id", r0);
        return;
    L17:
        r8 = false;
        goto L18
    L14:
        r1 = null;
        goto L15
    }

    public final void H(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "params");
        I(r2, new JSONObject(r3), false);
    }

    public final void n(i6 r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r13, "reason");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", String.valueOf(qj.a(r12)));
        Intrinsics.checkNotNullParameter(r12, "$this$linkerIdExt");
        r0.put("msg_linker_id", Long.valueOf(r12.getLinkerId()));
        g1 r14 = r12.getInvite();
        if (r14 == null) goto L8;
        g1 r1 = r14;
        Intrinsics.checkNotNullParameter(r1, "$this$fromUid");
        String r2 = r1.get_fromUid();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r0.put("invite_from_user", r2);
        r0.put("invite_from_room", Long.valueOf(r14.getFromRoomId()));
    L8:
        r0.put("error_msg", r13);
        f(r0);
        b(r0);
        H("auto_reject_link_apply", r0);
        d31.f r3 = s();
        if (r3 == null) goto L12;
        d31.f.f(r3, "auto_reject_link_apply", 0, null, 0, 0, null, null, null, 254);
        return;
    }

    public v(ld.a r2, com.bytedance.android.livesdk.revenue.service.room.c r3, LinkFakeGlobalService r4) {
        super(r2, r3, r4);
        this.f = CollectionsKt.listOf(new String[]{"show_in_link_invite_dialog", "show_link_list_dialog", "show_multi_pk_mode_panel", "multi_anchor_link_widget_create"});
    }

    public final void D(String r2, long r3, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r5, "params");
        E(r2, r3, new JSONObject(r5));
    }

    public final void E(String r12, long r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r14, "params");
        g(r14);
        y50.b.a.d(r14, "event", r12);
        y50.b.a.c(r14, Constants.Keys.duration, r13);
        int r1 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_anchor_link", "event: " + r12 + " duration=" + r13 + " params=" + r14);
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        r9.put(Constants.Keys.duration, r13);
        w(r12, r14, r14.optInt("error_code"), r14.optString("error_msg"), r8, r9);
    }

    public final void I(String r8, JSONObject r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r10 == false) goto L5;
        c(r9);
    L5:
        g(r9);
        y50.b.a.d(r9, "event", r8);
        int r12 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_anchor_link", "event: " + r8 + " params=" + r9);
        x(this, r8, r9, r9.optInt("error_code"), r9.optString("error_msg"), null, 48);
    }

    public final void p(String r20, int r22, long r23) {
        Intrinsics.checkNotNullParameter(r20, "panelType");
        JSONObject r1 = new JSONObject();
        y50.b.a.d(r1, "panel_type", r20 + '_' + r22);
        c(r1);
        E("fetch_recommend_list_success", r23, r1);
        d31.f r13 = s();
        if (r13 == null) goto L6;
        r13.e("battle/rivals/recommend", new d31.a(0, 0, 0, 0, null, r22, 0, r20, null, null, null, 3935), r23);
        return;
    }

    public final void t(i6 r12, String r13, Long r14) {
        Intrinsics.checkNotNullParameter(r12, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r13, "source");
        JSONObject r0 = new JSONObject();
        k6 r1 = r12.getReply();
        if (r1 == null) goto L16;
        y50.b.a.c(r0, "reply_status", r1.getReplyStatus());
        j5 r2 = r1.getFromLinkmicInfo();
        if (r2 == null) goto L7;
        String r3 = r2.getInteractIdStr();
    L8:
        y50.b.a.d(r0, "interact_id", r3);
        String r4 = r1.getFromUid();
        String r5 = "";
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        y50.b.a.d(r0, "from_user", r4);
        y50.b.a.c(r0, "from_room", r1.getFromRoomId());
        String r6 = r1.getToUid();
        if (r6 == null) goto L15;
        r5 = r6;
    L15:
        y50.b.a.d(r0, "to_user", r5);
        y50.b.a.b(r0, "msg_multi_pk_mode", r1.getMultiPkMode());
        goto L16
    L7:
        r3 = null;
    L16:
        if (r14 == null) goto L18;
        y50.b.a.c(r0, "cur_channel_id", r14.longValue());
    L18:
        y50.b.a.d(r0, "error_msg", r13);
        y50.b.a.b(r0, "error_code", r13.length());
        m(r12, r0);
        c(r0);
        I("multi_ignore_reply_msg", r0, false);
        d31.f r7 = s();
        if (r7 == null) goto L22;
        d31.f.f(r7, "multi_ignore_reply_msg", 0, r13, 0, 0, null, null, null, 250);
        return;
    }

    public final void F(String r2, long r3, Throwable r5, Map<String, Object> r6) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r6, "params");
        G(r2, r5, new JSONObject(r6), Long.valueOf(r3));
    }

    public final void G(String r12, Throwable r13, JSONObject r14, Long r15) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r13 == null) goto L5;
        e.l(r13, r14);
    L5:
        g(r14);
        c(r14);
        int r0 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link", "event: " + r12 + " duration=" + r15 + " params=" + r14, null);
        if (r15 == null) goto L8;
        y50.b.a.c(r14, Constants.Keys.duration, r15.longValue());
    L8:
        boolean r1 = r13 instanceof ApiServerException;
        if (r1 == true) goto L11;
        Throwable r3 = null;
    L12:
        ApiServerException r4 = (ApiServerException) r3;
        if (r4 == null) goto L15;
        int r7 = r4.getErrorCode();
    L16:
        if (r1 == true) goto L18;
        r13 = null;
    L18:
        ApiServerException r16 = (ApiServerException) r13;
        if (r16 == null) goto L22;
        String r17 = r16.getErrorMsg();
        if (r17 == null) goto L22;
    L23:
        JSONObject r9 = new JSONObject();
        r9.put(Constants.Keys.duration, r15);
        x(this, r12, r14, r7, r17, r9, 16);
        return;
    L22:
        r17 = "";
        goto L23
    L15:
        r7 = -1;
        goto L16
    L11:
        r3 = r13;
        goto L12
    }

    public final void o(String r19, int r20, long r22, Throwable r23) {
        Intrinsics.checkNotNullParameter(r19, "panelType");
        JSONObject r1 = new JSONObject();
        y50.b.a.d(r1, "panel_type", r19);
        y50.b.a.b(r1, "tab_type", r20);
        c(r1);
        G("fetch_recommend_list_failed", r23, r1, Long.valueOf(r22));
        d31.f r15 = s();
        if (r15 == null) goto L6;
        r15.c("battle/rivals/recommend", new d31.a(0, 0, 0, 0, null, r20, 0, r19, null, null, null, 3935), r23, r22);
        return;
    }

    public final void u(long r7, int r9, long r10, Throwable r12) {
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("req_channel_id", Long.valueOf(r7));
        r5.put("match_type", Integer.valueOf(r9));
        b(r5);
        F("anchor_join_channel_failed", r10, r12, r5);
    }

    public final void C(String r3, String r4, boolean r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "linkMicIdInfo");
        Intrinsics.checkNotNullParameter(r4, "linkUserStr");
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("link_mic_info", r3);
        r0.put("link_user", r4);
        r0.put("use_backup", Boolean.valueOf(r5));
        r0.put("manual_mute_remote", Boolean.valueOf(r6));
        r0.put("req_src", r7);
        b(r0);
        H("select_target_remote_stream", r0);
    }

    public final void v(String r3, int r4, int r5, int r6, long r7) {
        Intrinsics.checkNotNullParameter(r3, "panelType");
        JSONObject r0 = new JSONObject();
        y50.b.a.d(r0, "panel_type", r3);
        y50.b.a.b(r0, "match_type", r4);
        y50.b.a.b(r0, "invite_source", r5);
        y50.b.a.b(r0, "invite_type", r6);
        y50.b.a.c(r0, "invite_room_id", r7);
        c(r0);
        I("linking_invite", r0, false);
    }

    public final void z(int r18, long r19, String r22, long r23, Throwable r24) {
        Intrinsics.checkNotNullParameter(r22, "reqSrc");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("req_channel_id", Long.valueOf(r19));
        r0.put("req_from", r22);
        r0.put("req_scene", Integer.valueOf(r18));
        b(r0);
        if (Intrinsics.areEqual(r22, "show_in_link_invite_dialog") == false) goto L6;
        F("link_invite_panel_query_list_failed", r23, r24, r0);
    L8:
        F("query_list_failed", r23, r24, r0);
        d31.f r14 = s();
        if (r14 == null) goto L12;
        r14.c("linkmic/list", new d31.a(0, 0, 0, r18, r22, 0, 0, null, Long.valueOf(r19), null, null, 3559), r24, r23);
        return;
    L12:
        return;
    L6:
        if (Intrinsics.areEqual(r22, "request_failed_retry") == false) goto L8;
        F("retry_query_list_failed", r23, r24, r0);
        goto L8
    }

    public final void w(String r12, JSONObject r13, int r14, String r15, JSONObject r16, JSONObject r17) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "extra");
        HashMap r6 = new HashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.d;
        if (r1 == null) goto L5;
        w r2 = r1.getMultiLinkUtil();
    L6:
        if (r2 != null) goto L8;
    L10:
        LiveTracingMonitorKt.EventModule r3 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
    L11:
        LiveTracingMonitorKt.EventModule r4 = r3;
        r6.put("android_event_key", r12);
        com.bytedance.android.live.revlink.impl.global.c r5 = this.d;
        if (r5 == null) goto L14;
        com.bytedance.android.live.revenuelink.f r7 = r5.getRevenueLinkTraceMonitor();
    L15:
        if (r7 == null) goto L18;
        r7.Y(r12, r4, r14, r15, r6, r13, r16, r17);
        return;
    L18:
        return;
    L14:
        r7 = null;
        goto L15
    L8:
        if (r2.e() != true) goto L10;
        r3 = LiveTracingMonitorKt.EventModule.PK;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static /* synthetic */ void x(v r7, String r8, JSONObject r9, int r10, String r12, JSONObject r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r14 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r14 & 32) == 0) goto L13;
        JSONObject r6 = null;
    L14:
        r7.w(r8, r9, r3, r4, null, r6);
        return;
    L13:
        r6 = r13;
        goto L14
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}

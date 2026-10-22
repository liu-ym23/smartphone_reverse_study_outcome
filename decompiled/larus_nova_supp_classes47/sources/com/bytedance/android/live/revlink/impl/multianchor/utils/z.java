package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.d3;
import com.bytedance.android.livesdk.link.model.i3;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z extends e {
    public static long e;
    public static final /* synthetic */ int f = 0;

    public static final class a {
    }

    static {
    }

    public final b0 q() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Tj();
    }

    public final String r() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r0.Ig();
    L7:
        if (r2 == null) goto L15;
        IBaseBattleSetting r3 = r2.getBattleSettings();
        if (r3 == null) goto L15;
        IBattleConfigSetting r4 = r3.getBattleConfigSetting();
        if (r4 == null) goto L15;
        v2 r5 = r4.getSelfSettingRate();
        if (r5 == null) goto L15;
        long r6 = r5.getPkValueType();
    L17:
        if (r6 <= 0) goto L19;
        boolean r7 = true;
    L20:
        com.bytedance.android.live.revlink.impl.global.c r8 = this.d;
        if (r8 == null) goto L23;
        r1 = r8.Ig();
    L23:
        if (r1 != null) goto L25;
    L27:
        if (r7 == false) goto L29;
        return "customize_pk";
    L29:
        return "routine_pk";
    L25:
        if (r1.isInVote() != true) goto L27;
        return "vote";
    L19:
        r7 = false;
    L15:
        r6 = 0;
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    public final d31.f s() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.y2();
    }

    public final void u(String r14) {
        Intrinsics.checkNotNullParameter(r14, "type");
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.d;
        if (r1 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r2 = r1.getMultiAnchorLinkContextObj();
    L6:
        if (r2 == null) goto L8;
        int r8 = r2.d();
    L9:
        r0.put("match_type", Integer.valueOf(r8));
        r0.put("pk_mode", r14);
        r0.put("mode_type", r());
        b0 r3 = q();
        if (r3 == null) goto L17;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r4 = r3.b();
        if (r4 == null) goto L14;
        IBaseBattleSetting r5 = r4.getBattleSettings();
    L15:
        if (r5 == null) goto L17;
        Object r6 = Long.valueOf(r5.getDuration());
    L18:
        r0.put("pk_duration", r6);
        b0 r7 = q();
        if (r7 == null) goto L22;
        PkBaseStateMachine.c r9 = r7.e();
        if (r9 == null) goto L22;
    L23:
        r0.put("error_code", r9);
        r0.put("error_msg", r());
        b0 r10 = q();
        if (r10 == null) goto L26;
        long r12 = r10.c();
    L27:
        r0.put("pk_id", Long.valueOf(r12));
        if (k() == false) goto L40;
        d31.f r13 = s();
        if (r13 == null) goto L39;
        b0 r15 = q();
        if (r15 == null) goto L37;
        PkBaseStateMachine.c r16 = r15.e();
        if (r16 == null) goto L37;
        String r17 = r16.c;
        if (r17 == null) goto L37;
    L38:
        d31.f.f(r13, "multi_pk_end", 0, r17, 0, r8, r14, null, r(), 74);
    L37:
        r17 = "";
    L39:
        y(this, "multi_pk_end", r0, null, 12);
        return;
    L40:
        d(r0);
        int r18 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_anchor_link_multi_pk", "multi_pk_end " + r14 + " params=" + r0);
        return;
    L26:
        r12 = 0;
    L22:
        r9 = "";
        goto L23
    L14:
        r5 = null;
    L17:
        r6 = "null";
        goto L18
    L8:
        r8 = 0;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final void v(String r14) {
        Intrinsics.checkNotNullParameter(r14, "type");
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.d;
        if (r1 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r2 = r1.getMultiAnchorLinkContextObj();
    L6:
        if (r2 == null) goto L8;
        int r8 = r2.d();
    L9:
        r0.put("match_type", Integer.valueOf(r8));
        r0.put("pk_mode", r14);
        r0.put("mode_type", r());
        b0 r3 = q();
        if (r3 == null) goto L17;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r4 = r3.b();
        if (r4 == null) goto L14;
        IBaseBattleSetting r5 = r4.getBattleSettings();
    L15:
        if (r5 == null) goto L17;
        Object r6 = Long.valueOf(r5.getDuration());
    L18:
        r0.put("pk_duration", r6);
        b0 r7 = q();
        if (r7 == null) goto L21;
        long r9 = r7.c();
    L22:
        r0.put("pk_id", Long.valueOf(r9));
        if (k() == false) goto L28;
        d31.f r10 = s();
        if (r10 == null) goto L27;
        d31.f.f(r10, "multi_pk_start", 0, r(), 0, r8, r14, null, null, 202);
    L27:
        y(this, "multi_pk_start", r0, null, 12);
        return;
    L28:
        d(r0);
        int r12 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_anchor_link_multi_pk", "multi_pk_start " + r14 + " params=" + r0);
        return;
    L21:
        r9 = 0;
        goto L22
    L14:
        r5 = null;
    L17:
        r6 = "null";
        goto L18
    L8:
        r8 = 0;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final void w(a5 r10) {
        Intrinsics.checkNotNullParameter(r10, Constants.OperatorKey.MSG);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_id", String.valueOf(qj.a(r10)));
        int r1 = r10.getEndReason();
        String r4 = "";
        if (r1 != 0) goto L5;
        String r2 = "TimeUp";
    L42:
        r0.put("end_reason", r2);
        Map r3 = r10.getBattleUserInfoMap();
        if (r3 == null) goto L49;
        r0.put("pk_user_cnt", Integer.valueOf(r3.size()));
        StringBuilder r6 = new StringBuilder("{");
        Iterator r5 = MapsKt.toMap(r3).entrySet().iterator();
    L46:
        if (r5.hasNext() == false) goto L48;
        Map.Entry r7 = (Map.Entry) r5.next();
        r6.append((String) r7.getKey());
        r6.append(':');
        r6.append(i3.a((IBattleUserInfo) r7.getValue()));
        r6.append(';');
        goto L46
    L48:
        r6.append('}');
        r0.put("battle_user_info", r6.toString());
    L49:
        u1 r8 = r10.getBattleSetting();
        if (r8 == null) goto L52;
        r0.put("pk_id", Long.valueOf(r8.getBattleId()));
        r0.put("pk_channel_id", Long.valueOf(r8.getChannelId()));
        r0.put("pk_duration", Long.valueOf(r8.getDuration()));
        r0.put("pk_start_time", Long.valueOf(r8.getStartTimeMs()));
        r0.put("pk_punish_duration", Long.valueOf(r8.getPunishDuration()));
        r0.put("pk_punish_start_time", Long.valueOf(r8.getPunishStartTimeMs()));
        r0.put("battle_type", Integer.valueOf(r8.getBattleType()));
    L52:
        b0 r9 = q();
        if (r9 == null) goto L55;
        PlayMode r12 = r9.d();
    L56:
        r0.put("pk_mode", String.valueOf(r12));
        b0 r13 = q();
        if (r13 == null) goto L64;
        PkBaseStateMachine.c r14 = r13.e();
        if (r14 == null) goto L64;
        String r15 = r14.c;
        if (r15 == null) goto L64;
        r4 = r15;
    L64:
        r0.put("pk_state", r4);
        if (r10.getEndReason() == 6) goto L67;
    L69:
        com.bytedance.android.live.revlink.impl.global.c r16 = this.d;
        if (r16 == null) goto L72;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r17 = r16.getLinkPlayHelper();
    L73:
        if (r17 == null) goto L80;
        if (r17.g() != true) goto L80;
        if (r10.getEndReason() != 12) goto L80;
        y(this, "unexpected_multi_pk_finish", r0, null, 12);
    L80:
        if (k() == false) goto L103;
        y(this, "receive_battle_finish_msg", r0, null, 12);
        com.bytedance.android.live.revlink.impl.global.c r18 = this.d;
        if (r18 == null) goto L84;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r19 = r18.getLinkPlayHelper();
    L85:
        if (r19 != null) goto L87;
        return;
    L87:
        if (r19.g() != true) goto L107;
        u1 r110 = r10.getBattleSetting();
        if (r110 == null) goto L91;
        Long r111 = Long.valueOf(r110.getBattleId());
    L92:
        b0 r20 = q();
        if (r20 == null) goto L95;
        Long r22 = Long.valueOf(r20.c());
    L97:
        if ((!Intrinsics.areEqual(r111, r22)) == false) goto L108;
        b0 r112 = q();
        if (r112 == null) goto L101;
        long r23 = r112.c();
    L102:
        r0.put("local_pk_id", Long.valueOf(r23));
        y(this, "battle_finish_msg_pk_id_mismatch", r0, null, 12);
        return;
    L101:
        r23 = 0;
        goto L102
    L108:
        return;
    L95:
        r22 = null;
        goto L97
    L91:
        r111 = null;
        goto L92
    L107:
        return;
    L84:
        r19 = null;
        goto L85
    L103:
        d(r0);
        int r113 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_anchor_link_multi_pk", "receive_battle_finish_msg params=" + r0);
        return;
    L72:
        r17 = null;
        goto L73
    L67:
        if (k() == false) goto L69;
        y(this, "battle_finish_by_instant_kill", r0, null, 12);
        goto L69
    L55:
        r12 = null;
        goto L56
    L5:
        if (1 != r1) goto L8;
        r2 = "CutShort";
        goto L42
    L8:
        if (2 != r1) goto L11;
        r2 = "ModeWin";
        goto L42
    L11:
        if (3 != r1) goto L14;
        r2 = "StartPkGame";
        goto L42
    L14:
        if (4 != r1) goto L17;
        r2 = "InBattleRestart";
        goto L42
    L17:
        if (5 != r1) goto L19;
        r2 = "MultipleMatches3";
        goto L42
    L19:
        if (6 != r1) goto L22;
        r2 = "SecKill";
        goto L42
    L22:
        if (7 != r1) goto L25;
        r2 = "ScoreControl";
        goto L42
    L25:
        if (8 != r1) goto L28;
        r2 = "GuestRtcOffline";
        goto L42
    L28:
        if (11 != r1) goto L30;
        r2 = "RoomClose";
        goto L42
    L30:
        if (12 != r1) goto L33;
        r2 = "NormalToMultiple";
        goto L42
    L33:
        if (13 != r1) goto L36;
        r2 = "MultipleInvite";
        goto L42
    L36:
        if (14 != r1) goto L39;
        r2 = "ChangeMode";
        goto L42
    L39:
        if (16 != r1) goto L41;
        r2 = "StartOpenGame";
        goto L42
    L41:
        r2 = "";
        goto L42
    }

    public final void n(long r3, Throwable r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("req_channel_id", Long.valueOf(r3));
        if (r5 == null) goto L6;
        x(this, "change_pk_team_failed", r5, r0);
        return;
    L6:
        y(this, "change_pk_team_success", r0, null, 12);
    }

    public z(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, LinkFakeGlobalService r3) {
        super(r1, r2, r3);
    }

    public final void m(long r3, String r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r5, "mode");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("req_channel_id", Long.valueOf(r3));
        r0.put("target_mode", r5);
        if (r6 == null) goto L6;
        x(this, "change_pk_mode_failed", r6, r0);
        return;
    L6:
        y(this, "change_pk_mode_success", r0, null, 12);
    }

    public static void x(z r12, String r13, Throwable r14, Map r15) {
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "event");
        Intrinsics.checkNotNullParameter(r15, "params");
        r12.f(r15);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(new JSONObject(new HashMap(r15)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        JSONObject r2 = (JSONObject) r1;
        if (r2 != null) goto L13;
        r2 = new JSONObject();
    L13:
        JSONObject r5 = r2;
        if (r14 == null) goto L16;
        e.l(r14, r5);
    L16:
        int r3 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link_multi_pk", "event: " + r13 + " params=" + r15, null);
        boolean r16 = r14 instanceof ApiServerException;
        if (r16 == true) goto L19;
        Throwable r4 = null;
    L20:
        ApiServerException r6 = (ApiServerException) r4;
        if (r6 == null) goto L23;
        int r7 = r6.getErrorCode();
    L24:
        if (r16 == true) goto L26;
        r14 = null;
    L26:
        ApiServerException r17 = (ApiServerException) r14;
        if (r17 == null) goto L30;
        String r18 = r17.getErrorMsg();
        if (r18 == null) goto L30;
    L31:
        t(r12, r13, r5, r7, r18, null, null, 80);
        return;
    L30:
        r18 = "";
        goto L31
    L23:
        r7 = -1;
        goto L24
    L19:
        r4 = r14;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static void y(z r8, String r9, Map r10, HashMap r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r12 = null;
    L5:
        HashMap r6 = r12;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "event");
        Intrinsics.checkNotNullParameter(r10, "params");
        r8.f(r10);
        r8.b(r10);
        int r14 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_anchor_link_multi_pk", "event: " + r9 + " params=" + r10);
        t(r8, r9, new JSONObject(new HashMap(r10)), 0, null, null, r6, 52);
    }

    public static /* synthetic */ void p(z r8, int r9, long r10, ExtraResponse r12, String r13, String r14) {
        r8.o(r9, r10, r12, r13, r14, null);
    }

    public final void o(int r32, long r33, ExtraResponse<com.bytedance.android.livesdk.link.model.r, Extra> r35, String r36, String r37, Throwable r38) {
        Intrinsics.checkNotNullParameter(r36, "from");
        Intrinsics.checkNotNullParameter(r37, "reqSrc");
        if (k() == false) goto L5;
    L9:
        LinkedHashMap r10 = new LinkedHashMap();
        if (r35 == null) goto L12;
        com.bytedance.android.livesdk.link.model.r r2 = (com.bytedance.android.livesdk.link.model.r) r35.data;
    L13:
        r10.put("req_from", r36);
        r10.put("req_scene", Integer.valueOf(r32));
        if (r35 == null) goto L16;
        String r3 = r35.logId;
    L17:
        r10.put("log_id", String.valueOf(r3));
        r10.put("status_msg", r37);
        String r4 = "";
        if (r2 == null) goto L23;
        c3 r5 = r2.getBattleStatsMeta();
        if (r5 == null) goto L23;
        String r6 = d3.a(r5);
        if (r6 == null) goto L23;
    L24:
        r10.put("battle_data", r6);
        if (r35 == null) goto L34;
        com.bytedance.android.livesdk.link.model.r r1 = (com.bytedance.android.livesdk.link.model.r) r35.data;
        if (r1 == null) goto L34;
        List r7 = r1.getLinkUsers();
        if (r7 == null) goto L34;
        String r8 = i11.a.d(r7);
        if (r8 == null) goto L34;
        r4 = r8;
    L34:
        r10.put("link_users", r4);
        h(r10);
        if (k() == true) goto L38;
        d(r10);
    L38:
        if (r38 == null) goto L46;
        d31.f r16 = s();
        if (r16 == null) goto L43;
        r16.c("linkmic/list", new d31.a(0, 0, 0, r32, r37, 0, 0, r36, Long.valueOf(r33), null, null, 3431), r38, 0);
    L43:
        x(this, "get_battle_stats_failed", r38, r10);
        return;
    L46:
        if (r2 == null) goto L48;
        c3 r9 = r2.getBattleStatsMeta();
    L49:
        if (r9 != null) goto L57;
        d31.f r17 = s();
        if (r17 == null) goto L53;
        String r15 = "battle stats is null";
        r17.c("linkmic/list", new d31.a(0, 0, 0, r32, r37, 0, 0, r36, Long.valueOf(r33), null, null, 3431), new Throwable(r15), 0);
    L54:
        x(this, "get_battle_stats_failed", new Throwable(r15), r10);
        return;
    L53:
        r15 = "battle stats is null";
        goto L54
    L57:
        if (k() == false) goto L64;
        d31.f r12 = s();
        if (r12 == null) goto L62;
        r12.e("linkmic/list", new d31.a(0, 0, 0, r32, r37, 0, 0, r36, Long.valueOf(r33), null, null, 3431), 0);
    L62:
        y(this, "get_battle_stats_success", r10, null, 12);
        return;
    L64:
        if (d51.c.A0.h() == false) goto L69;
        e++;
        d31.f r13 = s();
        if (r13 == null) goto L69;
        r13.e("linkmic/list", new d31.a(0, 0, 0, r32, r37, 0, 0, r36, Long.valueOf(r33), null, null, 3431), 0);
    L69:
        jy0.b.d("ttlive_anchor_link_multi_pk", "getBattleStats success " + r36 + ' ' + r37 + ' ' + r10);
        return;
    L48:
        r9 = null;
    L23:
        r6 = "";
        goto L24
    L16:
        r3 = null;
        goto L17
    L12:
        r2 = null;
        goto L13
    L5:
        if (d51.c.A0.h() == false) goto L9;
        if ((e % ((long) 10)) == 0) goto L9;
    }

    public static void t(z r9, String r10, JSONObject r12, int r13, String r14, JSONObject r15, HashMap r16, int r17) {
        if ((r17 & 4) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r17 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        JSONObject r8 = null;
    L15:
        if ((r17 & 64) == 0) goto L17;
        HashMap r0 = null;
    L18:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r12, "extra");
        if (r0 != null) goto L22;
        r0 = new HashMap();
    L22:
        HashMap r5 = r0;
        r5.put("android_event_key", r10);
        com.bytedance.android.live.revlink.impl.global.c r1 = r9.d;
        if (r1 == null) goto L25;
        com.bytedance.android.live.revenuelink.f r2 = r1.getRevenueLinkTraceMonitor();
    L26:
        if (r2 == null) goto L29;
        r2.Y(r10, LiveTracingMonitorKt.EventModule.MULTI_LINKER, r3, r4, r5, r12, null, r8);
        return;
    L29:
        return;
    L25:
        r2 = null;
        goto L26
    L17:
        r0 = r16;
        goto L18
    L13:
        r8 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }
}

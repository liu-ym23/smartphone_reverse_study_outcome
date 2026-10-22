package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public static void k() {
        LinkedHashMap r0 = new LinkedHashMap();
        mz0.n r1 = new mz0.n();
        Map<String, String> r2 = r1.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r2.putAll(r0);
        mz0.m r3 = new mz0.m();
        r3.b(LogCommon.ROOM);
        List<Object> r4 = r1.b;
        ArrayList r5 = (ArrayList) r4;
        r5.addAll(r3.a);
        cy0.e.a.getClass();
        cy0.j r6 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r7 = com.bytedance.android.scope.m.b(r6).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r7);
        ((mz0.i) ((f80.a) r7)).w3("livesdk_random_npk_matching_speedup_show", r1.a, r1.b);
    }

    public final String c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        a r1 = r0.Mf();
    L7:
        if (r1 == null) goto L9;
        long r3 = r1.Bj();
    L11:
        if (r3 > 0) goto L13;
        return DataType.FALSE;
    L13:
        return String.valueOf(t.a(r3) / ((long) WebcastRedirectException.UNKNOWN));
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public final MultiPkMatchContext d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.gf();
    }

    public final String e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        a r1 = r0.Mf();
    L7:
        if (r1 == null) goto L9;
        long r3 = r1.hj();
    L11:
        if (r3 > 0) goto L13;
        return DataType.FALSE;
    L13:
        return String.valueOf(t.a(r3) / ((long) WebcastRedirectException.UNKNOWN));
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public final String l() {
        if (e.a(d()).c == false) goto L5;
        return "2";
    L5:
        return DataType.TRUE;
    }

    public f(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final void a(int r6) {
        mz0.n r0 = new mz0.n();
        mz0.o r1 = new mz0.o(r0.a);
        r1.a("is_reinvite", DataType.FALSE);
        r1.a("match_time", c());
        r1.a("speedup_status", l());
        r1.a("match_type", x.f(r6));
        com.bytedance.android.live.revlink.impl.global.c r7 = this.a;
        d31.d r2 = null;
        if (r7 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r8 = r7.getLinkOptLogContext();
    L6:
        String r3 = "";
        if (r8 == null) goto L10;
        String r9 = r8.a;
        if (r9 == null) goto L10;
    L11:
        r1.a("source", r9);
        r1.a("anchor_connect_status", "2");
        com.bytedance.android.live.revlink.impl.global.c r10 = this.a;
        if (r10 == null) goto L14;
        r2 = r10.getRevLinkLogHelper();
    L14:
        if (r2 == null) goto L16;
        r3 = r2.s();
    L16:
        r1.a("room_status", r3);
        MultiPkMatchContext r12 = d();
        if (r12 == null) goto L25;
        com.bytedance.live.datacontext.j<a> r13 = r12.getService();
        if (r13 == null) goto L25;
        a r14 = (a) r13.getValue();
        if (r14 == null) goto L25;
        Map<String, String> r15 = r14.bb();
        if (r15 == null) goto L25;
        r1.b(r15);
    L25:
        e21.c.d(r1, d());
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.h r4 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r4, "linkInfoLog");
        am2.m r5 = r4.a;
        r5.i = 300;
        ((ArrayList) r16.a).add(r5);
        ((ArrayList) r0.b).addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_match_cancel_click", r0.a, r0.b);
        return;
    L10:
        r9 = "";
        goto L11
    L5:
        r8 = null;
        goto L6
    }

    public final void b(int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("speedup_status", l());
        c r1 = e.a(d());
        if (r1.a == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        String r3 = "inviter";
    L14:
        r0.put("anchor_type", r3);
        if (x.d(r4) == false) goto L18;
        String r5 = "team_double";
    L21:
        r0.put("match_type", r5);
        r0.put("match_time", c());
        r0.put("speedup_time", e());
        mz0.n r6 = new mz0.n();
        Map<String, String> r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        List<Object> r9 = r6.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_random_npk_matching_cancel", r6.a, r6.b);
        return;
    L18:
        if (x.a(r4) == false) goto L20;
        r5 = "triple";
        goto L21
    L20:
        r5 = "link_double";
        goto L21
    L11:
        if ((r1 instanceof c.d) == false) goto L13;
        r3 = "follow";
        goto L14
    L13:
        r3 = "";
        goto L14
    L5:
        if (r1.d == true) goto L7;
        r2 = true;
        goto L8
    }

    public final String i(boolean r1) {
        if (r1 == true) goto L5;
        return DataType.FALSE;
    L5:
        com.bytedance.android.live.revlink.impl.global.c r2 = this.a;
        if (r2 == null) goto L8;
        a r3 = r2.Mf();
    L10:
        if (b.a(r3) == false) goto L13;
        return "2";
    L13:
        return DataType.TRUE;
    L8:
        r3 = null;
        goto L10
    }

    public final void j(int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (x.d(r4) == false) goto L5;
        String r5 = "team_double";
    L6:
        r0.put("match_type", r5);
        r0.put("match_time", c());
        mz0.n r6 = new mz0.n();
        Map<String, String> r1 = r6.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r1.putAll(r0);
        mz0.m r2 = new mz0.m();
        r2.b(LogCommon.ROOM);
        List<Object> r3 = r6.b;
        ArrayList r7 = (ArrayList) r3;
        r7.addAll(r2.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((mz0.i) ((f80.a) r9)).w3("livesdk_random_npk_matching_speedup", r6.a, r6.b);
        return;
    L5:
        r5 = "link_double";
        goto L6
    }

    public final void g(int r5, boolean r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.a;
        if (r1 == null) goto L5;
        q r2 = r1.getMultiAnchorLinkLogUtils();
    L6:
        String r3 = "";
        if (r2 == null) goto L9;
        String r4 = r2.d();
    L10:
        r0.put("follow_anchor_id", r4);
        c r7 = e.a(d());
        if (r7.a == true) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L19;
        r3 = "inviter";
    L21:
        r0.put("anchor_type", r3);
        if (x.d(r5) == false) goto L25;
        String r9 = "team_double";
    L28:
        r0.put("match_type", r9);
        r0.put("match_time", c());
        r0.put("speedup_time", e());
        if (r6 == false) goto L31;
        String r10 = "2";
    L32:
        r0.put("speedup_status", r10);
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r13.putAll(r0);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        List<Object> r15 = r12.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_random_npk_matching_failure", r12.a, r12.b);
        return;
    L31:
        r10 = DataType.TRUE;
        goto L32
    L25:
        if (x.a(r5) == false) goto L27;
        r9 = "triple";
        goto L28
    L27:
        r9 = "link_double";
        goto L28
    L19:
        if ((r7 instanceof c.d) == false) goto L21;
        r3 = "follow";
        goto L21
    L13:
        if (r7.d == true) goto L15;
        r8 = true;
        goto L16
    L9:
        r4 = "";
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void h(int r6, AutoMatchSource r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("match_type", x.f(r6));
        r0.put("match_time", c());
        com.bytedance.android.live.revlink.impl.global.c r1 = this.a;
        if (r1 == null) goto L5;
        d31.d r2 = r1.getRevLinkLogHelper();
    L6:
        if (r2 == null) goto L8;
        String r3 = r2.s();
    L9:
        r0.put("room_status", r3);
        r0.put("speedup_status", l());
        if (x.a(r6) == false) goto L12;
        String r4 = DataType.FALSE;
    L13:
        r0.put("anchor_connect_status", r4);
        if (r6 != 11) goto L16;
        r0.put("room_status", "nlink_waiting");
        r0.put("match_type", "nlink_waiting");
    L16:
        r0.put("reason", com.bytedance.android.live.revlink.impl.pk.utils.b.a(r7));
        mz0.n r8 = new mz0.n();
        mz0.o r9 = new mz0.o(r8.a);
        MultiPkMatchContext r5 = d();
        if (r5 == null) goto L25;
        com.bytedance.live.datacontext.j<a> r10 = r5.getService();
        if (r10 == null) goto L25;
        a r12 = (a) r10.getValue();
        if (r12 == null) goto L25;
        Map<String, String> r13 = r12.bb();
        if (r13 == null) goto L25;
        r9.b(r13);
    L25:
        e21.c.d(r9, d());
        r9.b(r0);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        List<Object> r15 = r8.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_pk_match_fail_toast_show", r8.a, r8.b);
        return;
    L12:
        r4 = "2";
        goto L13
    L8:
        r3 = "";
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public static void f(f r8, int r9, String r10, boolean r12, boolean r13, boolean r14, p0 r15, int r16) {
        if ((r16 & 8) == 0) goto L6;
        r13 = false;
    L6:
        if ((r16 & 16) == 0) goto L8;
        r14 = false;
    L8:
        com.bytedance.android.live.revlink.impl.control.d r0 = null;
        if ((r16 & 32) == 0) goto L11;
        r15 = null;
    L11:
        Intrinsics.checkNotNullParameter(r10, "anchorType");
        LinkedHashMap r17 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = r8.a;
        if (r1 == null) goto L14;
        w r2 = r1.getMultiLinkUtil();
    L15:
        String r3 = "connection";
        if (r2 != null) goto L18;
    L20:
        com.bytedance.android.live.revlink.impl.global.c r4 = r8.a;
        if (r4 == null) goto L23;
        w r5 = r4.getMultiLinkUtil();
    L24:
        if (r5 != null) goto L26;
    L28:
        String r6 = "live";
    L29:
        r17.put("from_room_status", r6);
        String r7 = DataType.FALSE;
        if (r14 == false) goto L32;
        Object r18 = DataType.TRUE;
    L33:
        r17.put("if_strategy_invite", r18);
        r17.put("anchor_type", r10);
        if (x.d(r9) == false) goto L37;
        String r19 = "team_double";
    L46:
        r17.put("match_type", r19);
        if (r9 == 10) goto L52;
        if (r9 == 9) goto L52;
        if (r9 != 11) goto L53;
        r17.put("success_type", "2v2");
    L53:
        r17.put("match_time", r8.c());
        if (r12 == false) goto L56;
        String r110 = "2";
    L57:
        r17.put("speedup_status", r110);
        r17.put("speedup_time", r8.e());
        if (r13 == false) goto L60;
        r7 = DataType.TRUE;
    L60:
        r17.put("trigger_source", r7);
        com.bytedance.android.live.revlink.impl.global.c r111 = r8.a;
        if (r111 == null) goto L63;
        d31.d r112 = r111.getRevLinkLogHelper();
    L64:
        if (r112 == null) goto L66;
        String r113 = r112.c();
    L67:
        String r114 = "";
        if (r9 == 9) goto L78;
        if (r9 == 4) goto L78;
        if (r9 == 10) goto L78;
        if (r113 != null) goto L74;
    L76:
        if (r113 != null) goto L79;
        r113 = "";
    L79:
        r17.put("connection_type", r113);
        if (r9 != 1) goto L82;
    L91:
        r114 = "random_pk";
    L92:
        r17.put("connection_sub_type", r114);
        if (r9 == 4) goto L97;
        if (r9 == 6) goto L96;
        r3 = "routine_pk";
        goto L97
    L96:
        r3 = "team_pk";
    L97:
        r17.put("invite_mode", r3);
        r17.put("invitee_list", "random");
        com.bytedance.android.live.revlink.impl.global.c r20 = r8.a;
        if (r20 == null) goto L100;
        r0 = r20.Rc();
    L100:
        if (r0 == null) goto L104;
        String r22 = r0.getRequestId();
        if (r22 == null) goto L104;
        r17.put("request_id", r22);
    L104:
        mz0.n r23 = new mz0.n();
        mz0.o r24 = new mz0.o(r23.a);
        r24.b(r17);
        e21.c.e(r24, r15);
        mz0.m r25 = new mz0.m();
        r25.b(LogCommon.ROOM);
        ((ArrayList) r23.b).addAll(r25.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((mz0.i) ((f80.a) r27)).w3("livesdk_random_match_success", r23.a, r23.b);
        return;
    L82:
        if (r9 == 3) goto L91;
        if (r9 == 4) goto L90;
        if (r9 != 6) goto L86;
        r114 = "random_npk";
        goto L92
    L86:
        if (r9 != 7) goto L92;
        r114 = "random_individual";
        goto L92
    L90:
        r114 = "random_nlink";
        goto L92
    L74:
        if (StringsKt.isBlank(r113) != true) goto L76;
        r113 = "random_pk";
    L78:
        r113 = "random_link";
        goto L79
    L66:
        r113 = null;
        goto L67
    L63:
        r112 = null;
        goto L64
    L56:
        r110 = DataType.TRUE;
    L52:
        r17.put("success_type", "1v1");
        goto L53
    L37:
        if (x.a(r9) == false) goto L39;
        r19 = "triple";
        goto L46
    L39:
        if (r9 != 9) goto L41;
        r19 = "single_link";
        goto L46
    L41:
        if (r9 == 10) goto L45;
        if (r9 == 11) goto L45;
        r19 = "link_double";
    L45:
        r19 = "triple_link";
        goto L46
    L32:
        r18 = DataType.FALSE;
        goto L33
    L26:
        if (r5.d() != true) goto L28;
        r6 = "connection";
        goto L29
    L23:
        r5 = null;
        goto L24
    L18:
        if (r2.e() != true) goto L20;
        r6 = "pk";
        goto L29
    L14:
        r2 = null;
        goto L15
    }
}

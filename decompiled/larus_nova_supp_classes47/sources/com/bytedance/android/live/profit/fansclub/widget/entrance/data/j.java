package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.GuardStatus;
import com.bytedance.android.live.profit.fansclub.l;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.profit.fansclub.r;
import com.bytedance.android.live.profit.fansclub.s;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static HashMap a(DataCenter r3) {
        HashMap r0 = new HashMap();
        i r4 = fu0.b.a(r3);
        if (r4 != null) goto L5;
        return r0;
    L5:
        o r5 = yt0.d.a(r4.f).a();
        if (r5 == null) goto L10;
        m<? extends r> r6 = r5.getShopFansClubData();
        if (r6 == null) goto L10;
        r r7 = (r) r6.getValue();
    L11:
        if (r7 == null) goto L15;
        s r8 = r7.userData;
        if (r8 == null) goto L15;
        int r9 = r8.level;
    L16:
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r0.put("fans_club_type", "ecom_fans_club");
        r0.put("fans_club_channel", "liveroom");
        if (r9 == 0) goto L19;
        String r10 = "level_" + r9;
    L20:
        r0.put("ecom_fans_status", r10);
        mz0.c r12 = (mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class);
        LogCommon r1 = LogCommon.PAGE_SOURCE_LOG;
        r12.W2(r1);
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r13 = ((mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class)).W2(r1);
        if (r13 == null) goto L27;
        Map<String, String> r14 = r13.getMap();
        if (r14 == null) goto L27;
        String r15 = r14.get("video_id");
        if (r15 == null) goto L27;
    L28:
        r0.put("group_id", r15);
        r0.put("ecom_group_type", "live");
        return r0;
    L27:
        r15 = "";
        goto L28
    L19:
        r10 = "not_in";
    L15:
        r9 = 0;
    L10:
        r7 = null;
        goto L11
    }

    public static HashMap b(DataCenter r7) {
        HashMap r0 = new HashMap();
        i r8 = fu0.b.a(r7);
        if (r8 != null) goto L5;
        return r0;
    L5:
        n01.a r1 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        String r3 = DataType.FALSE;
        if (r1 != null) goto L8;
    L9:
        if (r1 != null) goto L11;
    L13:
        Object r2 = DataType.FALSE;
    L14:
        r0.put("is_vs", r2);
        if (r8.A() == false) goto L17;
        Object r4 = DataType.TRUE;
    L18:
        r0.put("is_anchor", r4);
        if (r8.j().a == FansClubUserStatus.Unknown) goto L21;
        Object r5 = DataType.TRUE;
    L22:
        r0.put("is_fans", r5);
        r0.put("anchor_id", r8.f());
        r0.put("user_id", r8.n().getCurrentUserId());
        r0.put("room_id", String.valueOf(r8.k()));
        if (r8.A() == false) goto L25;
        String r6 = "3";
    L26:
        r0.put("fansclub_status", r6);
        com.bytedance.android.live.profit.fansclub.b r9 = r8.i();
        l r10 = null;
        if (r9 == null) goto L29;
        com.bytedance.android.live.profit.fansclub.m r12 = r9.e;
    L30:
        if (r12 == null) goto L32;
        String r13 = r12.a();
    L33:
        r0.put("star_status", r13);
        com.bytedance.android.live.profit.fansclub.b r14 = r8.i();
        if (r14 == null) goto L36;
        com.bytedance.android.live.profit.fansclub.m r15 = r14.e;
    L37:
        if (r15 == null) goto L39;
        Long r16 = Long.valueOf(r15.d);
    L40:
        r0.put("star_expire_date", String.valueOf(r16));
        if (r8.getRoom().isMergeVSRoom() == false) goto L47;
        r0.put("vs_fanclub_position", "top_left");
        if (r8.A() == true) goto L46;
        r3 = DataType.TRUE;
    L46:
        r0.put("vs_is_audience", r3);
    L49:
        if (iy0.e.b(r8.getRoom()) == false) goto L64;
        o r17 = yt0.d.a(r8.f).a();
        if (r17 == null) goto L55;
        m<? extends l> r18 = r17.getFansGroupInfo();
        if (r18 == null) goto L55;
        r10 = (l) r18.getValue();
    L55:
        if (r10 == null) goto L58;
        String r19 = r10.b;
        if (r19 == null) goto L58;
    L60:
        if (Intrinsics.areEqual(r8.f(), r19) == false) goto L62;
        String r20 = "group";
    L63:
        r0.put("fansclub_type", r20);
        r0.put("member_id", r19);
        goto L64
    L62:
        r20 = "member";
    L58:
        r19 = r8.f();
    L64:
        return r0;
    L47:
        r0.put("fanclub_position", "top_left");
        goto L49
    L39:
        r16 = null;
        goto L40
    L36:
        r15 = null;
        goto L37
    L32:
        r13 = "nonactivated";
        goto L33
    L29:
        r12 = null;
        goto L30
    L25:
        r6 = String.valueOf(r8.j().a.getValue());
        goto L26
    L21:
        r5 = DataType.FALSE;
        goto L22
    L17:
        r4 = DataType.FALSE;
        goto L18
    L11:
        if (r1.i3() != true) goto L13;
    L12:
        r2 = DataType.TRUE;
        goto L14
    L8:
        if (r1.p4() == true) goto L12;
        goto L9
    }

    public static String c(DataCenter r12) {
        i r13 = fu0.b.a(r12);
        if (r13 != null) goto L5;
        return "";
    L5:
        long r1 = System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN);
        long r3 = r13.o();
        boolean r9 = false;
        if ((r3 - r1) <= 604800) goto L8;
        boolean r5 = true;
    L9:
        long r6 = 1209600;
        long r2 = r1 - r3;
        if (1 <= r2) goto L13;
    L15:
        int r14 = r13.s();
        if (r14 == 0) goto L27;
        if (r14 != 1) goto L19;
        if (r5 == false) goto L26;
        return "activated_over_7d";
    L26:
        return "activated_in_7d";
    L19:
        if (r14 != 2) goto L33;
        if (r9 == false) goto L23;
        return "expired_in_14d";
    L23:
        return "expired_out_14d";
    L33:
        return "";
    L27:
        return "nonactivated";
    L13:
        if (r6 <= r2) goto L15;
        r9 = true;
        goto L15
    L8:
        r5 = false;
        goto L9
    }

    public static void e(DataCenter r6) {
        HashMap r0 = new HashMap();
        i r7 = fu0.b.a(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        boolean r1 = r7.A();
        String r2 = DataType.TRUE;
        if (r1 == false) goto L8;
        Object r3 = DataType.TRUE;
    L9:
        r0.put("is_anchor", r3);
        r0.put("member_type", String.valueOf(r7.h()));
        com.bytedance.android.live.base.model.user.j r4 = r7.g();
        if (r4 == null) goto L14;
        boolean r5 = true;
        if (r4.isMember() != true) goto L14;
    L15:
        if (r5 == true) goto L18;
        r2 = DataType.FALSE;
    L18:
        r0.put("is_member", r2);
        String r8 = r7.getRoom().getAnchorId();
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        r0.put("anchor_id", r8);
        com.bytedance.android.live.base.model.user.j r9 = r7.g();
        if (r9 == null) goto L24;
        Map r10 = r9.getTrackingParams();
    L25:
        if (r10 == null) goto L27;
        r0.putAll(r10);
    L27:
        n r12 = new n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r13.putAll(r0);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        r14.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r15 = r12.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_member_entrance_click", r12.a, r12.b);
        return;
    L24:
        r10 = null;
    L14:
        r5 = false;
        goto L15
    L8:
        r3 = DataType.FALSE;
        goto L9
    }

    public static void f(DataCenter r3) {
        HashMap r4 = a(r3);
        n r0 = new n();
        Map<String, String> r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.ROOM);
        r5.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r2 = r0.b;
        ArrayList r6 = (ArrayList) r2;
        r6.addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_ecom_fans_club_entrance_click", r0.a, r0.b);
    }

    public static void g(DataCenter r3) {
        HashMap r4 = a(r3);
        n r0 = new n();
        Map<String, String> r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.ROOM);
        r5.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r2 = r0.b;
        ArrayList r6 = (ArrayList) r2;
        r6.addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_ecom_fans_club_icon_show", r0.a, r0.b);
    }

    public static void h(com.bytedance.android.live.profit.fansclub.b r4) {
        Pair[] r0 = new Pair[2];
        Integer r1 = null;
        if (r4 == null) goto L9;
        com.bytedance.android.live.profit.fansclub.j r2 = r4.c;
        if (r2 == null) goto L9;
        GuardStatus r3 = r2.b;
        if (r3 == null) goto L9;
        Integer r5 = Integer.valueOf(r3.getValue());
    L10:
        r0[0] = TuplesKt.to("guard_status", String.valueOf(r5));
        if (r4 == null) goto L17;
        com.bytedance.android.live.profit.fansclub.j r6 = r4.c;
        if (r6 == null) goto L17;
        FansClubUserStatus r7 = r6.a;
        if (r7 == null) goto L17;
        r1 = Integer.valueOf(r7.getValue());
    L17:
        r0[1] = TuplesKt.to("fans_club_status", String.valueOf(r1));
        Map<? extends String, ? extends String> r8 = MapsKt.mutableMapOf(r0);
        n r9 = new n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r10.putAll(r8);
        mz0.m r12 = new mz0.m();
        r12.b(LogCommon.ROOM);
        r12.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r9.b).addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_user_fansclub_status_rd", r9.a, r9.b);
        return;
    L9:
        r5 = null;
        goto L10
    }

    public static void i(DataCenter r4) {
        HashMap r0 = b(r4);
        if (d("livesdk_fans_club_entrance_click", r4) == false) goto L5;
        String r5 = DataType.TRUE;
    L6:
        r0.put("if_animation", r5);
        n r6 = new n();
        Map<String, String> r2 = r6.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r2.putAll(r0);
        mz0.m r1 = new mz0.m();
        r1.b(LogCommon.ROOM);
        r1.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r3 = r6.b;
        ArrayList r7 = (ArrayList) r3;
        r7.addAll(r1.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((mz0.i) ((f80.a) r9)).w3("livesdk_fans_club_entrance_click", r6.a, r6.b);
        n r10 = new n();
        Object r12 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3("livesdk_fans_club_audience_open", r10.a, r10.b);
        return;
    L5:
        r5 = DataType.FALSE;
        goto L6
    }

    public static void j(DataCenter r3) {
        n r0 = new n();
        Map<String, String> r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        HashMap r4 = b(r3);
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.ROOM);
        r5.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r2 = r0.b;
        ArrayList r6 = (ArrayList) r2;
        r6.addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_fanclub_guide_info_show", r0.a, r0.b);
    }

    public static void k(DataCenter r4) {
        HashMap r0 = b(r4);
        if (d("livesdk_fans_club_icon_show", r4) == false) goto L5;
        String r5 = DataType.TRUE;
    L6:
        r0.put("if_animation", r5);
        n r6 = new n();
        Map<String, String> r2 = r6.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r2.putAll(r0);
        mz0.m r1 = new mz0.m();
        r1.b(LogCommon.ROOM);
        r1.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r3 = r6.b;
        ArrayList r7 = (ArrayList) r3;
        r7.addAll(r1.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((mz0.i) ((f80.a) r9)).w3("livesdk_fans_club_icon_show", r6.a, r6.b);
        return;
    L5:
        r5 = DataType.FALSE;
        goto L6
    }

    public static void l(DataCenter r6) {
        HashMap r0 = new HashMap();
        i r1 = fu0.b.a(r6);
        if (r1 != null) goto L5;
        return;
    L5:
        boolean r2 = r1.A();
        String r3 = DataType.TRUE;
        if (r2 == false) goto L8;
        Object r4 = DataType.TRUE;
    L9:
        r0.put("is_anchor", r4);
        r0.put("livevip_status", c(r6));
        if (r1.A() == true) goto L12;
    L16:
        n r7 = new n();
        Map<String, String> r5 = r7.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r5.putAll(r0);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        r8.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r9 = r7.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_livevip_entrance_click", r7.a, r7.b);
        return;
    L12:
        if (r1.N() == true) goto L15;
        r3 = DataType.FALSE;
    L15:
        r0.put("is_open_livevip", r3);
        goto L16
    L8:
        r4 = DataType.FALSE;
        goto L9
    }

    public static void m(DataCenter r6) {
        HashMap r0 = new HashMap();
        i r1 = fu0.b.a(r6);
        if (r1 != null) goto L5;
        return;
    L5:
        boolean r2 = r1.A();
        String r3 = DataType.TRUE;
        if (r2 == false) goto L8;
        Object r4 = DataType.TRUE;
    L9:
        r0.put("is_anchor", r4);
        r0.put("livevip_status", c(r6));
        if (r1.A() == true) goto L12;
    L16:
        r0.put("room_id", String.valueOf(r1.k()));
        String r7 = r1.getRoom().getAnchorId();
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        r0.put("anchor_id", r7);
        n r8 = new n();
        Map<String, String> r5 = r8.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r5.putAll(r0);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r10 = r8.b;
        ArrayList r12 = (ArrayList) r10;
        r12.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_livevip_icon_show", r8.a, r8.b);
        return;
    L12:
        if (r1.N() == true) goto L15;
        r3 = DataType.FALSE;
    L15:
        r0.put("is_open_livevip", r3);
        goto L16
    L8:
        r4 = DataType.FALSE;
        goto L9
    }

    public static boolean d(String r7, DataCenter r8) {
        i r9 = fu0.b.a(r8);
        if (r9 != null) goto L5;
        return false;
    L5:
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = com.bytedance.android.live.profit.fansclub.f.b;
        KProperty[] r2 = com.bytedance.android.live.profit.fansclub.f.a;
        HashMap r3 = (HashMap) r1.getValue(null, r2[0]);
        String r10 = String.valueOf(r9.k());
        if (r3.containsKey(r7) == true) goto L8;
    L11:
        return false;
    L8:
        if (Intrinsics.areEqual((String) r3.get(r7), r10) == false) goto L11;
        r3.put(r7, DataType.FALSE);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.setValue(null, r2[0], r3);
        return true;
    }
}

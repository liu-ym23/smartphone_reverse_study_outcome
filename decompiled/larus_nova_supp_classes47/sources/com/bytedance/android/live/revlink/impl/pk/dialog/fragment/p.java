package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.text.TextUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.pk.utils.t;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.k8;
import com.bytedance.android.livesdk.link.model.l8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public final DataCenter a;

    public p(DataCenter r1) {
        this.a = r1;
    }

    public static void b(long r3) {
        HashMap r0 = new HashMap();
        LinkRevPanelDataContext r1 = LinkRevPanelDataContext.Companion.getContext();
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r2 = r1.getRecImplId();
        if (r2 == null) goto L8;
        String r4 = (String) r2.getValue();
        if (r4 == null) goto L8;
    L9:
        r0.put("request_id", r4);
        r0.put("show_time", String.valueOf(System.currentTimeMillis() - r3));
        mz0.n r5 = new mz0.n();
        Map<String, String> r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        List<Object> r8 = r5.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3("livesdk_pk_page_close", r5.a, r5.b);
        return;
    L8:
        r4 = "";
        goto L9
    }

    public static void c(String r4, int r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "source");
        if ((!Intrinsics.areEqual(r4, "init")) == true) goto L5;
    L7:
        d31.e r0 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r0 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r4, "cache") == false) goto L12;
        long r7 = 0;
    L13:
        Intrinsics.areEqual(r4, "cache");
        r0.d(0, r5, r7);
        return;
    L12:
        r7 = System.currentTimeMillis() - r6;
        goto L13
    L5:
        if ((!Intrinsics.areEqual(r4, "cache")) == false) goto L7;
    }

    public final void a(IRivalRankRecommendResponse r16, boolean r17, int r18, String r19, String r20, boolean r22, String r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r19, "guideType");
        Intrinsics.checkNotNullParameter(r20, "toUserGroup");
        Intrinsics.checkNotNullParameter(r23, "source");
        if (r16 != null) goto L5;
        return;
    L5:
        HashMap r4 = new HashMap();
        String r6 = DataType.FALSE;
        r4.put("is_on_ranklist", DataType.FALSE);
        String r8 = "";
        r4.put("ranklist_type", "");
        l8 r9 = r16.getSearchBar();
        boolean r10 = false;
        Long r13 = null;
        if (r9 == null) goto L42;
        String r12 = r9.getTabName();
        if (r12 == null) goto L42;
        if (r12.length() <= 0) goto L12;
        boolean r14 = true;
    L13:
        if (r14 != true) goto L42;
        if (com.bytedance.android.live.revlink.impl.pk.utils.c.a(this.a) == false) goto L42;
        KmpEnv r15 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L19;
    L20:
        r4.put("is_on_ranklist", DataType.TRUE);
        l8 r5 = r16.getSearchBar();
        if (r5 == null) goto L23;
        String r7 = r5.getTabName();
    L25:
        if (TextUtils.equals(r7, "hourly_rank_global") == false) goto L27;
        r4.put("ranklist_type", "hourly_rank");
        goto L42
    L27:
        l8 r25 = r16.getSearchBar();
        if (r25 == null) goto L30;
        String r26 = r25.getTabName();
    L32:
        if (TextUtils.equals(r26, "hourly_rank_region") == false) goto L34;
        r4.put("ranklist_type", "regional_rank");
        goto L42
    L34:
        l8 r27 = r16.getSearchBar();
        if (r27 == null) goto L37;
        String r28 = r27.getTabName();
    L39:
        if (TextUtils.equals(r28, "popularity_rank") == false) goto L42;
        r4.put("ranklist_type", "popularity_rank");
        goto L42
    L37:
        r28 = null;
        goto L39
    L30:
        r26 = null;
        goto L32
    L23:
        r7 = null;
        goto L25
    L19:
        if (KmpEnv.c() == false) goto L42;
    L12:
        r14 = false;
    L42:
        r4.put("pk_description", "routine");
        j8 r29 = r16.getAutoMatchInfo();
        if (r29 == null) goto L45;
        k8 r30 = r29.getConfig();
    L46:
        if (r30 == null) goto L53;
        j8 r32 = r16.getAutoMatchInfo();
        if (r32 == null) goto L52;
        k8 r33 = r32.getConfig();
        if (r33 == null) goto L52;
        r13 = Long.valueOf(r33.getPkAutoMatchIndex());
    L52:
        r4.put("pk_automatch_type", String.valueOf(r13));
    L53:
        r4.put("source", "live_pk_icon");
        if (r19.length() <= 0) goto L56;
        boolean r34 = true;
    L57:
        if (r34 == false) goto L60;
        r4.put("guide_type", r19);
        r4.put("source", "guide");
    L81:
        if (r20.length() <= 0) goto L83;
        r10 = true;
    L83:
        if (r10 == false) goto L85;
        r4.put("to_user_group", r20);
    L85:
        r4.put("room_status", "live");
        r4.put("anchor_connect_status", DataType.FALSE);
        r4.put("audience_connect_cnt", String.valueOf(r18));
        r4.put("total_friends_num", String.valueOf(t.c(r16)));
        if (r17 == false) goto L88;
        Object r0 = DataType.TRUE;
    L89:
        r4.put("is_switch", r0);
        if (r24 == false) goto L92;
        Object r1 = DataType.TRUE;
    L93:
        r4.put("is_rank", r1);
        r4.put("if_multi_match", DataType.FALSE);
        if (r22 == false) goto L96;
        r6 = DataType.TRUE;
    L96:
        r4.put("if_mutual_online", r6);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r2 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r2 == null) goto L102;
        String r3 = r2.b;
        if (r3 == null) goto L102;
        r8 = r3;
    L102:
        r4.put("from_page", r8);
        mz0.n r35 = new mz0.n();
        Map<String, String> r36 = r35.a;
        Intrinsics.checkNotNullParameter(r36, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r36.putAll(r4);
        mz0.m r37 = new mz0.m();
        r37.b(LogCommon.ROOM);
        ((ArrayList) r35.b).addAll(r37.a);
        cy0.e.a.getClass();
        cy0.j r38 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r39 = com.bytedance.android.scope.m.b(r38).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r39);
        ((mz0.i) ((f80.a) r39)).w3("livesdk_pk_tab_show", r35.a, r35.b);
        return;
    L92:
        r1 = DataType.FALSE;
        goto L93
    L88:
        r0 = DataType.FALSE;
        goto L89
    L60:
        if (r23.length() <= 0) goto L62;
        boolean r40 = true;
    L63:
        if (r40 == false) goto L65;
        r4.put("source", r23);
        goto L81
    L65:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r42 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r42 == null) goto L81;
        String r43 = r42.b;
        if (r43 == null) goto L81;
        if (r43.length() <= 0) goto L72;
        boolean r44 = true;
    L73:
        if (r44 != true) goto L81;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r45 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r45 == null) goto L78;
        String r46 = r45.b;
        if (r46 == null) goto L78;
    L79:
        r4.put("source", r46);
    L78:
        r46 = "";
        goto L79
    L72:
        r44 = false;
        goto L73
    L62:
        r40 = false;
        goto L63
    L56:
        r34 = false;
        goto L57
    L45:
        r30 = null;
        goto L46
    }
}

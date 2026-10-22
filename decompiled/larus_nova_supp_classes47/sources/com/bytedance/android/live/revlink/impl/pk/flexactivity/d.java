package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.pk.ui.TouchConflictPkExposeRecyclerView;
import com.bytedance.android.livesdk.link.model.IPanelArea;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.a4;
import com.bytedance.android.livesdk.link.model.k7;
import com.bytedance.android.livesdk.link.model.l7;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.t8;
import com.bytedance.android.livesdk.link.model.v9;
import com.bytedance.android.livesdk.link.model.z9;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;
import mz0.i;
import mz0.m;
import mz0.n;
import y31.f;
import y31.g;
import y31.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public String a;
    public List<? extends IPanelArea> b;
    public View c;
    public MultiTypeAdapter d;
    public Integer e;

    public d() {
        this.a = "";
    }

    public final void update(String r14, List<? extends IPanelArea> r15) {
        Intrinsics.checkNotNullParameter(r14, "activityId");
        Intrinsics.checkNotNullParameter(r15, "areas");
        this.a = r14;
        this.b = r15;
        View r16 = this.c;
        if (r16 == null) goto L5;
        Object r17 = r16.findViewById(2131384076);
    L6:
        TouchConflictPkExposeRecyclerView r18 = (TouchConflictPkExposeRecyclerView) r17;
        if (r18 == null) goto L9;
        r18.r();
    L9:
        MultiTypeAdapter r19 = this.d;
        if (r19 == null) goto L109;
        ArrayList r1 = new ArrayList();
        Iterator<T> r110 = r15.iterator();
        boolean r3 = false;
    L13:
        if (r110.hasNext() == false) goto L108;
        IPanelArea r4 = (IPanelArea) r110.next();
        Integer r5 = r4.getUiType();
        int r6 = IPanelArea.UIType.Content.ordinal();
        if (r5 == null) goto L22;
        if (r5.intValue() != r6) goto L22;
        a4 r7 = r4.getContent();
        if (r7 == null) goto L13;
        r1.add(new ActContentAreaViewBinder.a(r7));
    L22:
        int r8 = IPanelArea.UIType.Rivals.ordinal();
        String r9 = "";
        if (r5 == null) goto L67;
        if (r5.intValue() != r8) goto L67;
        t8 r10 = r4.getRivals();
        if (r10 == null) goto L30;
        List r12 = r10.getRivals();
    L31:
        List r13 = r12;
        if (r13 != null) goto L34;
    L37:
        boolean r20 = true;
    L38:
        if (r20 == false) goto L41;
        if (r3 == true) goto L41;
        r1.add(new f.a(""));
    L104:
        r3 = true;
    L41:
        if (r12 == null) goto L13;
        t8 r22 = r4.getRivals();
        if (r22 == null) goto L45;
        String r23 = r22.getName();
    L46:
        if (r23 != null) goto L48;
    L51:
        boolean r24 = true;
    L52:
        if (r24 == true) goto L54;
        FlexActivityTitleViewBinder.a r25 = new FlexActivityTitleViewBinder.a();
        r25.a = r23;
        r25.b = "#80161823";
        Unit r26 = Unit.INSTANCE;
        r1.add(r25);
    L54:
        Iterator r27 = r12.iterator();
        int r28 = 0;
    L56:
        if (r27.hasNext() == false) goto L13;
        m2 r29 = (m2) r27.next();
        k r111 = new k();
        r111.b = r29.getRoom();
        Integer r112 = this.e;
        if (r112 == null) goto L60;
        int r113 = r112.intValue();
    L61:
        r111.e = r113;
        String r114 = this.a;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r111.p = r114;
        r111.f = r29.getRivalExtraInfo();
        t8 r115 = r4.getRivals();
        if (r115 == null) goto L65;
        String r116 = r115.getImprId();
        if (r116 == null) goto L65;
    L66:
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r111.i = r116;
        r111.d = false;
        r111.h = r29.getBattleRivalTagList();
        r111.a = r29;
        r111.j = false;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r111.k = "";
        r111.l = null;
        r111.n = 1;
        r111.g = 2;
        r111.r = r28;
        r1.add(r111);
        r28 = r28 + 1;
    L65:
        r116 = "";
        goto L66
    L60:
        r113 = r29.getServerInviteType();
        goto L61
    L48:
        if (StringsKt.isBlank(r23) == true) goto L51;
        r24 = false;
        goto L52
    L45:
        r23 = null;
        goto L46
    L34:
        if (r13.isEmpty() == true) goto L37;
        r20 = false;
        goto L38
    L30:
        r12 = null;
    L67:
        int r30 = IPanelArea.UIType.UserList.ordinal();
        if (r5 == null) goto L75;
        if (r5.intValue() != r30) goto L75;
        z9 r32 = r4.getUserList();
        if (r32 == null) goto L13;
        r1.add(new g.a(r32));
    L75:
        int r33 = IPanelArea.UIType.PKRecordList.ordinal();
        if (r5 == null) goto L105;
        if (r5.intValue() != r33) goto L105;
        l7 r34 = r4.getRecordList();
        if (r34 == null) goto L83;
        List r35 = r34.getRecords();
    L84:
        List r36 = r35;
        if (r36 != null) goto L87;
    L90:
        boolean r37 = true;
    L91:
        if (r37 == true) goto L102;
        FlexActivityTitleViewBinder.a r38 = new FlexActivityTitleViewBinder.a();
        l7 r39 = r4.getRecordList();
        if (r39 == null) goto L98;
        String r40 = r39.getName();
        if (r40 == null) goto L98;
        r9 = r40;
    L98:
        r38.a = r9;
        r38.b = "#161823";
        Unit r42 = Unit.INSTANCE;
        r1.add(r38);
        Iterator r43 = r35.iterator();
    L100:
        if (r43.hasNext() == false) goto L13;
        r1.add(new a.C0171a((k7) r43.next()));
        goto L100
    L102:
        if (r3 == true) goto L13;
        r1.add(new f.a(s1.B(2131916666)));
        goto L104
    L87:
        if (r36.isEmpty() == true) goto L90;
        r37 = false;
        goto L91
    L83:
        r35 = null;
    L105:
        v9 r44 = r4.getTitle();
        if (r44 == null) goto L13;
        r1.add(new y31.e.a(this.a, r44));
        goto L13
    L108:
        r19.a = r1;
    L109:
        MultiTypeAdapter r117 = this.d;
        if (r117 == null) goto L112;
        r117.notifyDataSetChanged();
    L112:
        HashMap r118 = new HashMap();
        r118.put("show_type", b.a());
        r118.put("flex_activity_id", this.a);
        r118.put("room_status", "live");
        com.bytedance.android.live.revlink.impl.control.dialog.e r119 = LinkRevPanelDataContext.Companion.a(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), this.a);
        if (r119 == null) goto L117;
        Map<String, String> r120 = r119.f;
        if (r120 == null) goto L117;
        r118.putAll(r120);
    L117:
        n r121 = new n();
        Map<String, String> r0 = r121.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Intrinsics.checkNotNullParameter(r118, "map");
        r0.putAll(r118);
        m r122 = new m();
        r122.b(LogCommon.PAGE_SOURCE_LOG);
        r122.b(LogCommon.ROOM);
        ((ArrayList) r121.b).addAll(r122.a);
        cy0.e.a.getClass();
        j r123 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r124 = com.bytedance.android.scope.m.b(r123).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r124);
        ((i) ((f80.a) r124)).w3("livesdk_flexible_match_show", r121.a, r121.b);
        return;
    L5:
        r17 = null;
        goto L6
    }
}

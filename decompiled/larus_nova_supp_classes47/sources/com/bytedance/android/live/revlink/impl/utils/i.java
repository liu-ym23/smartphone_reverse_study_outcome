package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.multianchor.utils.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public final List<Integer> a;
    public final Map<Integer, k> b;
    public final com.bytedance.android.live.revlink.impl.global.c c;
    public final j d;

    public i(com.bytedance.android.live.revlink.impl.global.c r9, j r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.c = r9;
        this.d = r10;
        this.a = CollectionsKt.listOf(new Integer[]{4, 64, 128});
        this.b = MapsKt.mapOf(new Pair[]{TuplesKt.to(4, new m(new int[]{2})), TuplesKt.to(64, new m(new int[]{2})), TuplesKt.to(128, new m(new int[]{2})), TuplesKt.to(2, new l(new int[0]))});
    }

    public final void a(int r9, int r10) {
        if (r10 != 32) goto L5;
        StringBuilder r1 = new StringBuilder("MultiLinkLoadWidget#ModeHelper#autoUnloadWidget, currentMode = ");
        r1.append(r9);
        r1.append(", targetMode = ");
        r1.append(r10);
        r1.append(", isDynamicFromAudience = ");
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r2 = com.bytedance.android.scope.m.b(r3).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r2);
        r1.append(((com.bytedance.live.kmp.core.c) r2).dynamicFromAudience());
        r1.append(", setting = ");
        r1.append(u41.b.i.a());
        jy0.b.d("ttlive_link", r1.toString());
    L5:
        if (r10 != 32) goto L11;
        cy0.e.a.getClass();
        cy0.j r4 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r4).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r0);
        if (((com.bytedance.live.kmp.core.c) r0).dynamicFromAudience() == false) goto L11;
        if (u41.b.i.a() == false) goto L11;
        r10 = 2;
    L11:
        k r5 = this.b.get(Integer.valueOf(r10));
        if (r5 != null) goto L14;
        r5 = new m(new int[0]);
    L14:
        ArrayList r6 = new ArrayList();
        Iterator<Integer> r7 = this.a.iterator();
    L15:
        com.bytedance.android.live.revenuelink.f r8 = null;
        if (r7.hasNext() == false) goto L23;
        int r12 = r7.next().intValue();
        if (com.bytedance.android.live.utils.c.a(r9, r12) == false) goto L15;
        if (r5.a(r12) == true) goto L15;
        jy0.b.c("ttlive_anchor_link", "auto load widget current=" + r9 + " target=" + r10 + " unload=" + r12, null, 4);
        this.d.K4(r12);
        r6.add(Integer.valueOf(r12));
        goto L15
    L23:
        if (r6.size() <= 0) goto L45;
        com.bytedance.android.live.revlink.impl.global.c r13 = this.c;
        if (r13 == null) goto L27;
        f0 r14 = r13.mo512if();
    L28:
        if (r14 == null) goto L46;
        Intrinsics.checkNotNullParameter(r6, "autoUnloadMode");
        u41.d r15 = u41.d.n;
        r15.getClass();
        if (((Boolean) u41.d.i.getValue(r15, u41.d.a[7])).booleanValue() == false) goto L48;
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("target_mode", Integer.valueOf(r10));
        r16.put("current_mode", Integer.valueOf(r9));
        r16.put("auto_unload", r6);
        r14.b(r16);
        r14.b(r16);
        com.bytedance.android.live.revlink.impl.global.c r17 = r14.c;
        if (r17 == null) goto L35;
        r8 = r17.getRevenueLinkTraceMonitor();
    L35:
        if (r8 == null) goto L47;
        r8.b0("rev_control_widget_auto_unload", LiveTracingMonitorKt.EventModule.PK, new JSONObject(r16));
        return;
    L47:
        return;
    L48:
        return;
    L46:
        return;
    L27:
        r14 = null;
        goto L28
    }
}

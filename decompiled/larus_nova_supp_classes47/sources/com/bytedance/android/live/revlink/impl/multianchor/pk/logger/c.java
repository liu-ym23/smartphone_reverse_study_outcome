package com.bytedance.android.live.revlink.impl.multianchor.pk.logger;

import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.e;
import cy0.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final a a;
    public boolean b;
    public final com.bytedance.android.livesdk.revenue.service.room.c c;
    public final com.bytedance.android.live.revlink.impl.global.c d;

    public final Map<String, String> a() {
        Map<String, String> r0 = this.a.a();
        r0.put("battle_mode", "team_pk");
        com.bytedance.android.live.revlink.impl.global.c r1 = this.d;
        String r2 = null;
        if (r1 == null) goto L5;
        MultiCommonPkDataContext r3 = r1.uk();
    L6:
        if (r3 == null) goto L11;
        j31.a r4 = r3.getStartParam();
        if (r4 == null) goto L11;
        Map<String, Long> r5 = r4.j;
        if (r5 == null) goto L11;
    L12:
        int r6 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a;
        com.bytedance.android.live.revlink.impl.global.c r7 = this.d;
        if (r7 == null) goto L15;
        s r8 = r7.getRevLinkCommonUtil();
    L16:
        if (r8 == null) goto L18;
        r2 = r8.e();
    L18:
        Pair r9 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a(r2, r5);
        List r10 = (List) r9.component1();
        List r12 = (List) r9.component2();
        StringBuilder r13 = new StringBuilder();
        r13.append(r10.size());
        r13.append('V');
        r13.append(r12.size());
        r0.put("team_type", r13.toString());
        return r0;
    L15:
        r8 = null;
    L11:
        r5 = MapsKt.emptyMap();
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public final void b(boolean r4) {
        if (r4 == true) goto L4;
        return;
    L4:
        if (this.b == true) goto L25;
        this.b = true;
        LinkedHashMap r5 = new LinkedHashMap();
        r5.putAll(this.a.c());
        r5.putAll(a());
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L9;
        MultiCommonPkDataContext r2 = r0.uk();
    L10:
        if (r2 == null) goto L15;
        j31.a r3 = r2.getStartParam();
        if (r3 == null) goto L15;
        Map<String, Long> r6 = r3.j;
        if (r6 == null) goto L15;
    L16:
        int r7 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.d;
        if (r8 == null) goto L19;
        s r9 = r8.getRevLinkCommonUtil();
    L20:
        if (r9 == null) goto L22;
        r1 = r9.e();
    L22:
        Pair r10 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a(r1, r6);
        List r12 = (List) r10.component1();
        List r13 = (List) r10.component2();
        r5.put("team_pk_a_anchor_cnt", String.valueOf(r12.size()));
        r5.put("team_pk_b_anchor_cnt", String.valueOf(r13.size()));
        n r14 = new n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r15.putAll(r5);
        m r16 = new m();
        r16.b(LogCommon.ROOM);
        ((ArrayList) r14.b).addAll(r16.a);
        e.a.getClass();
        j r17 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r18);
        ((i) ((f80.a) r18)).w3("livesdk_pk_end", r14.a, r14.b);
        return;
    L19:
        r9 = null;
    L15:
        r6 = MapsKt.emptyMap();
        goto L16
    L9:
        r2 = null;
        goto L10
    }

    public c(com.bytedance.android.livesdk.revenue.service.room.c r2, d r3) {
        this.c = r2;
        this.d = r3;
        this.a = new a(r2, r3);
    }
}

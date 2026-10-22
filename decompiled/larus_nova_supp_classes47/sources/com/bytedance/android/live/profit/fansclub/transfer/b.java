package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final px0.a a;

    public static final class a {
    }

    static {
    }

    public b(px0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "roomOrEpisode");
        this.a = r2;
    }

    public final void a(boolean r4, int r5) {
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("room_id", String.valueOf(this.a.b()));
        r0[1] = TuplesKt.to("anchor_id", this.a.a());
        if (r4 == false) goto L5;
        String r6 = DataType.TRUE;
    L6:
        r0[2] = TuplesKt.to("is_ecom_fansclub", r6);
        Map<? extends String, ? extends String> r7 = MapsKt.mutableMapOf(r0);
        if (r5 <= 0) goto L9;
        r7.put("source", String.valueOf(r5));
    L9:
        mz0.n r8 = new mz0.n();
        Map<String, String> r1 = r8.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r1.putAll(r7);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r2 = r8.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3("livesdk_fansclub_api_call_rd", r8.a, r8.b);
        return;
    L5:
        r6 = DataType.FALSE;
        goto L6
    }
}

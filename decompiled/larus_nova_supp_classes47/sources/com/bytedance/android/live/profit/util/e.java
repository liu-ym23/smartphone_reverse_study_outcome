package com.bytedance.android.live.profit.util;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final Map<Integer, String> a = null;

    static {
        int r1 = m.a;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(m.a), "福袋"), TuplesKt.to(Integer.valueOf(m.b), "红包")});
    }

    public static final void a(cy0.f r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        com.bytedance.android.livesdk.revenue.service.sti.a r5 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.e.d(r3, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.f() == true) goto L8;
        return;
    L8:
        Iterator r0 = r5.X8().getIcons().iterator();
    L10:
        if (r0.hasNext() == false) goto L17;
        Object r1 = r0.next();
        if (((xr2.i) r1).a != r4) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L10;
    L18:
        xr2.i r6 = (xr2.i) r1;
        if (r6 == null) goto L30;
        String r7 = a.get(Integer.valueOf(r6.a));
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        r5.Bl(String.valueOf(r4), r7);
        return;
    L30:
        return;
    L14:
        r2 = false;
        goto L15
    L17:
        r1 = null;
        goto L18
    }

    public static final void b(cy0.f r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        com.bytedance.android.livesdk.revenue.service.sti.a r5 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.e.d(r3, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.f() == true) goto L8;
        return;
    L8:
        Iterator r0 = r5.X8().getIcons().iterator();
    L10:
        if (r0.hasNext() == false) goto L17;
        Object r1 = r0.next();
        if (((xr2.i) r1).a != r4) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L10;
    L18:
        xr2.i r6 = (xr2.i) r1;
        if (r6 == null) goto L30;
        String r7 = a.get(Integer.valueOf(r6.a));
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        r5.Zg(String.valueOf(r4), r7);
        return;
    L30:
        return;
    L14:
        r2 = false;
        goto L15
    L17:
        r1 = null;
        goto L18
    }

    public static final void c(cy0.f r7, int r8, String r9, long r10, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r9, "strategyId");
        Intrinsics.checkNotNullParameter(r12, "benefit");
        Intrinsics.checkNotNullParameter(r13, "extraMessage");
        com.bytedance.android.livesdk.revenue.service.sti.a r0 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.e.d(r7, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.f() == true) goto L8;
        return;
    L8:
        Iterator r14 = r0.X8().getIcons().iterator();
    L10:
        if (r14.hasNext() == false) goto L17;
        Object r1 = r14.next();
        if (((xr2.i) r1).a != r8) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L10;
    L18:
        xr2.i r2 = (xr2.i) r1;
        if (r2 == null) goto L30;
        String r15 = a.get(Integer.valueOf(r2.a));
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        String r3 = r15;
        r0.I2(String.valueOf(r8), r3, r9, r10 / ((long) WebcastRedirectException.UNKNOWN), MapsKt.mutableMapOf(new Pair[]{new Pair("temp_benefit", r12), new Pair("temp_extra_message", r13)}));
        return;
    L30:
        return;
    L14:
        r4 = false;
        goto L15
    L17:
        r1 = null;
        goto L18
    }
}

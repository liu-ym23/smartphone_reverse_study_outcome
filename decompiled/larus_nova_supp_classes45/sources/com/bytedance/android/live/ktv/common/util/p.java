package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.ktv.common.model.api.q0;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public static final Map<String, q0> a = null;
    public static final Map<String, q0> b = null;
    public static final Map<String, Integer> c = null;

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("Perfect", new q0(100L, 40L)), TuplesKt.to("Great", new q0(40L, 20L)), TuplesKt.to("Good", new q0(20L, 0L))});
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("Perfect", new q0(100L, 90L)), TuplesKt.to("Great", new q0(90L, 80L)), TuplesKt.to("Good", new q0(80L, 60L))});
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("Perfect", 2131252092), TuplesKt.to("Great", 2131252091), TuplesKt.to("Good", 2131252090)});
    }

    public static final int a(Map<String, q0> r8, float r9) {
        if (KtvSettingHelper.z() == false) goto L5;
        boolean r0 = ((Boolean) KtvSettingHelper.L0.getValue()).booleanValue();
    L6:
        if (r0 == true) goto L9;
        if (r8 != null) goto L10;
        r8 = b;
    L10:
        Iterator<Map.Entry<String, q0>> r11 = r8.entrySet().iterator();
    L12:
        if (r11.hasNext() == false) goto L42;
        Map.Entry<String, q0> r1 = r11.next();
        Long r2 = r1.getValue().a();
        Long r3 = r1.getValue().b();
        if (r2 == null) goto L12;
        if (r3 == null) goto L12;
        if (Intrinsics.areEqual(r1.getKey(), "Perfect") == false) goto L23;
        if (r9 < r3.longValue()) goto L23;
        return 3;
    L23:
        if (r9 > r2.longValue()) goto L12;
        if (r9 < r3.longValue()) goto L12;
        String r12 = r1.getKey();
        int r13 = r12.hashCode();
        if (r13 == 2225373) goto L40;
        if (r13 == 69066349) goto L37;
        if (r13 != 985815021) goto L42;
        if (r12.equals("Perfect") == false) goto L42;
        return 3;
    L37:
        if (r12.equals("Great") == false) goto L42;
        return 2;
    L40:
        if (r12.equals("Good") == false) goto L42;
        return 1;
    L42:
        return -1;
    L9:
        r8 = a;
        goto L10
    L5:
        r0 = ((Boolean) vm2.h.O2.getValue(null, vm2.h.a[195(0xc3, float:2.73E-43)])).booleanValue();
        goto L6
    }
}

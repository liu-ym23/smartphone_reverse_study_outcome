package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public final String[] a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public static r11.l d() {
        v41.a r0 = v41.a.m;
        r0.getClass();
        return (r11.l) v41.a.j.getValue(r0, v41.a.a[8]);
    }

    public static void f() {
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = l51.a.u0;
        KProperty[] r1 = l51.a.a;
        List r3 = (List) r0.getValue(null, r1[82]);
        i97.a r5 = i97.a.a;
        r3.add(Double.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.setValue(null, r1[82], r3);
    }

    public j(LinkFakeGlobalService r3) {
        this.b = r3;
        this.a = new String[]{"manual_pk", "random_pk", "non_connection_screen"};
    }

    public static boolean b(int r10) {
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = l51.a.s0;
        KProperty[] r1 = l51.a.a;
        Map r3 = (Map) r0.getValue(null, r1[80]);
        i97.a r5 = i97.a.a;
        Calendar r6 = Calendar.getInstance();
        Intrinsics.checkNotNullParameter(r6, "origin");
        int r7 = r6.get(6);
        if (r3.get(String.valueOf(r10)) != null) goto L5;
        ArrayList r8 = new ArrayList();
        r8.add(String.valueOf(r7));
        r3.put(String.valueOf(r10), r8);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.setValue(null, r1[80], r3);
        return true;
    L5:
        List r12 = (List) r3.get(String.valueOf(r10));
        Intrinsics.checkNotNull(r12);
        if (r12.size() <= 3) goto L9;
        return false;
    L9:
        if (r12.contains(String.valueOf(r7)) == false) goto L11;
        return false;
    L11:
        r12.add(String.valueOf(r7));
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.setValue(null, r1[80], r3);
        return true;
    }

    public final boolean a(String r12, int r13) {
        if (d().P7() == true) goto L5;
        return true;
    L5:
        List r0 = (List) ((Map) l51.a.v0.getValue(null, l51.a.a[83])).get(r12);
        if (r0 != null) goto L8;
        return true;
    L8:
        if (r0.size() >= d().l2()) goto L10;
        return true;
    L10:
        if (d().l2() <= 0) goto L19;
        double r2 = ((Number) ListProtector.get(r0, r0.size() - d().l2())).doubleValue();
        double r4 = ((Number) ListProtector.get(r0, r0.size() - 1)).doubleValue();
        i97.a r1 = i97.a.a;
        if ((System.currentTimeMillis() - r4) < d().Y()) goto L14;
        return true;
    L14:
        if ((r4 - r2) >= d().T4()) goto L21;
        int r3 = ToastUtil.a;
        int r5 = w11.a.a;
        ToastUtil.a(2131917975, 0);
        e("rejection_control", r13, r12, 0);
        return false;
    L21:
        return true;
    L19:
        return true;
    }

    public final boolean c(int r13, String r14, int r15) {
        if (d().P7() == true) goto L5;
        return true;
    L5:
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = l51.a.t0;
        KProperty[] r2 = l51.a.a;
        long r6 = ((Number) r0.getValue(null, r2[81])).longValue();
        v41.a r1 = v41.a.m;
        r1.getClass();
        if (((Boolean) v41.a.i.getValue(r1, v41.a.a[7])).booleanValue() == false) goto L8;
    L11:
        List r3 = (List) l51.a.u0.getValue(null, r2[82]);
        if (r3 != null) goto L24;
    L21:
        l51.a.t0.setValue(null, l51.a.a[81], Long.valueOf(com.bytedance.live.kmp.util.e.b()));
        return true;
    L24:
        if (r3.size() < d().c7()) goto L21;
        double r7 = ((Number) ListProtector.get(r3, r3.size() - d().c7())).doubleValue();     // Catch: Throwable -> L23
        double r8 = ((Number) ListProtector.get(r3, r3.size() - 1)).doubleValue();     // Catch: Throwable -> L23
        if ((r8 - r7) >= d().A0()) goto L21;
        i97.a r4 = i97.a.a;     // Catch: Throwable -> L23
        if ((System.currentTimeMillis() - r8) >= d().A0()) goto L21;
        int r5 = ToastUtil.a;     // Catch: Throwable -> L23
        int r9 = w11.a.a;     // Catch: Throwable -> L23
        ToastUtil.a(2131917826, 0);     // Catch: Throwable -> L23
        e("times_control", r13, r14, r15);     // Catch: Throwable -> L23
        return false;
    L8:
        if ((com.bytedance.live.kmp.util.e.b() - r6) >= d().R3()) goto L11;
        int r10 = ToastUtil.a;
        int r12 = w11.a.a;
        ToastUtil.a(2131917867, 0);
        e("10s_control", r13, r14, r15);
        return false;
    }

    public final void e(String r5, int r6, String r7, int r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("control_type", r5);
        long r1 = 0;
        if (r6 < 0) goto L5;
        r1 = r6;
    L5:
        LinkCrossRoomDataHolder r9 = null;
        if (r7 == null) goto L9;
        r7 = null;
    L9:
        String[] r10 = this.a;
        if (r8 >= r10.length) goto L13;
        if (r8 < 0) goto L13;
        r0.put("connection_type", r10[r8]);
    L13:
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r13.putAll(r0);
        mz0.m r14 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r2 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r2, "linkInfoLog");
        r2.c(r1);
        r2.f(r7);
        ((ArrayList) r14.a).add(r2.a);
        com.bytedance.android.live.revlink.impl.global.c r15 = this.b;
        if (r15 == null) goto L16;
        r9 = r15.getLinkCrossRoomDataHolder();
    L16:
        if (r9 == null) goto L18;
        r9.m(r14);
    L18:
        r14.b(LogCommon.ROOM);
        ((ArrayList) r12.b).addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_pk_frequency_control_toast_show", r12.a, r12.b);
    }
}

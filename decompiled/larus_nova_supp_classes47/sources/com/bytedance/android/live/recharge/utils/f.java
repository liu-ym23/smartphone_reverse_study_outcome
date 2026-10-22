package com.bytedance.android.live.recharge.utils;

import am2.x;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> a = null;

    static {
        a = new HashMap();
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        mz0.n r0 = new mz0.n();
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r2 = com.bytedance.android.scope.m.b(r1).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r2);
        ((mz0.i) ((f80.a) r2)).w3(r3, r0.a, r0.b);
    }

    public static void c(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "extra");
        mz0.n r0 = new mz0.n();
        Map<String, String> r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r6);
        ((mz0.i) ((f80.a) r6)).w3(r3, r0.a, r0.b);
    }

    public static void a(Map r1, Set r2, Class r3) {
        com.bytedance.android.livesdk.revenue.log.d<?> r0 = a.get(r3);
        if (r0 == null) goto L7;
        r0.a(r1);
        return;
    L7:
        if (Intrinsics.areEqual(r3, IRoom.class) == false) goto L10;
        LogCommon r4 = LogCommon.ROOM;
    L13:
        if (r4 == null) goto L17;
        r2.add(r4);
        return;
    L17:
        throw new IllegalArgumentException("Unidentified filter class " + r3);
    L10:
        if (Intrinsics.areEqual(r3, x.class) == false) goto L12;
        r4 = LogCommon.PAGE_SOURCE_LOG;
        goto L13
    L12:
        r4 = null;
        goto L13
    }

    public static void d(String r5, Map r6, Class... r7) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r7, "logClasses");
        LinkedHashMap r0 = new LinkedHashMap();
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        a(r0, r1, r7[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        if (r6 == null) goto L7;
        r0.putAll(r6);
    L7:
        mz0.n r8 = new mz0.n();
        Map<String, String> r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r9.putAll(r0);
        mz0.m r10 = new mz0.m();
        Iterator r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        r10.b((LogCommon) r4.next());
        goto L9
    L11:
        List<Object> r12 = r8.b;
        ArrayList r13 = (ArrayList) r12;
        r13.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3(r5, r8.a, r8.b);
    }
}

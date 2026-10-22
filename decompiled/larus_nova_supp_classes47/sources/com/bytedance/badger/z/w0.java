package com.bytedance.badger.z;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;

    static {
        a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(w0.class, "badger-core_release"), "internalModules", "getInternalModules()Ljava/util/Map;"))};
        b = LazyKt.lazy(n.a);
    }

    public static final void b() {
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.m r0 = com.bytedance.badger.v.d.k;
        KProperty r1 = com.bytedance.badger.v.d.a[10];
        Collection r2 = (Collection) r0.a();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Integer r5 = StringsKt.toIntOrNull((String) r4.next());
        if (r5 == null) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Lazy r6 = b;
        KProperty r7 = a[0];
        Iterator r8 = ((Map) r6.getValue()).entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L16;
        Map.Entry r9 = (Map.Entry) r8.next();
        int r10 = ((Number) r9.getKey()).intValue();
        u0 r12 = (u0) r9.getValue();
        if (r3.contains(Integer.valueOf(r10)) == true) goto L13;
        if (r12 == null) goto L10;
        r r13 = new r(r10);
        com.bytedance.badger.t.c r14 = new com.bytedance.badger.t.c(901594402);
        r13.invoke(r14);
        r14.a(r12);
        goto L10
    L13:
        com.bytedance.badger.e.g("BadgerModules", "registerModules: " + r10 + " is disabled");
        goto L10
    }

    public static final Pair a(int r1, u0 r2) {
        if (r1 > 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L11;
        return new Pair(Integer.valueOf(r1), r2);
    L11:
        throw new IllegalArgumentException("FeatureID must be in range of Short".toString());
    L4:
        if (r1 > 65535) goto L6;
        r0 = true;
        goto L7
    }
}

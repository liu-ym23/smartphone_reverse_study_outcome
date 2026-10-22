package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.m;
import com.bytedance.android.scope.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final void a(Class r12, cy0.e r13) {
        Intrinsics.checkNotNullParameter(r12, "serviceCls");
        Intrinsics.checkNotNullParameter(r13, "scope");
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L20
        r1.append("Service not found: ");     // Catch: Throwable -> L20
        r1.append(r12);     // Catch: Throwable -> L20
        r1.append('\n');     // Catch: Throwable -> L20
        r1.append("Scope: ");     // Catch: Throwable -> L20
        r1.append(r13);     // Catch: Throwable -> L20
        r1.append('\n');     // Catch: Throwable -> L20
        r1.append("Scope valid: ");     // Catch: Throwable -> L20
        r1.append(com.bytedance.android.scope.l.b(r13));     // Catch: Throwable -> L20
        m.e.getClass();     // Catch: Throwable -> L20
        q r14 = m.b;     // Catch: Throwable -> L20
        r1.append('\n');     // Catch: Throwable -> L20
        r1.append("Registered services: ");     // Catch: Throwable -> L20
        r1.append('\n');     // Catch: Throwable -> L20
        Collection r3 = r14.a();     // Catch: Throwable -> L20
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L20
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L20
    L5:
        if (r5.hasNext() == false) goto L17;
        KClass r6 = (KClass) r5.next();     // Catch: Throwable -> L20
        Collection r7 = r14.b(r6);     // Catch: Throwable -> L20
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L20
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L20
    L8:
        if (r9.hasNext() == false) goto L12;
        Object r10 = r9.next();     // Catch: Throwable -> L20
        if (((e33.l) r10).b.contains(JvmClassMappingKt.getKotlinClass(r12)) == false) goto L8;
        r8.add(r10);     // Catch: Throwable -> L20
        goto L8
    L12:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));     // Catch: Throwable -> L20
        Iterator r16 = r8.iterator();     // Catch: Throwable -> L20
    L14:
        if (r16.hasNext() == false) goto L16;
        r15.add("  Scope = " + Reflection.getOrCreateKotlinClass(r6.getClass()) + " Service = " + ((e33.l) r16.next()));     // Catch: Throwable -> L20
        goto L14
    L16:
        CollectionsKt.addAll(r4, r15);     // Catch: Throwable -> L20
        goto L5
    L17:
        r1.append(r4);     // Catch: Throwable -> L20
        throw new IllegalArgumentException(r1.toString());
    L20:
        th = move-exception;
        throw new IllegalArgumentException("Service not found: " + r12 + ", diagnostics not available", th);
    }
}

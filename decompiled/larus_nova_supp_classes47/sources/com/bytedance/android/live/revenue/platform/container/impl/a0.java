package com.bytedance.android.live.revenue.platform.container.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 implements com.bytedance.android.scope.f, com.bytedance.android.scope.o {
    public static final Set<KClass<? extends com.bytedance.android.scope.j>> c = null;
    public final s a;
    public final com.bytedance.android.scope.j b;

    public static final class a {
    }

    public final boolean c(com.bytedance.android.scope.j r2, com.bytedance.android.scope.j r3) {
        Intrinsics.checkNotNullParameter(r2, "parentScope");
        Intrinsics.checkNotNullParameter(r3, "childScope");
        return true;
    }

    static {
        c = new LinkedHashSet();
    }

    public final void onStart() {
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.q r0 = com.bytedance.android.scope.m.b;
        Iterator r1 = r0.a().iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        KClass r2 = (KClass) r1.next();
        Iterator r3 = r0.b(r2).iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        e33.l r4 = (e33.l) r3.next();
        Iterator r5 = r4.b.iterator();
    L10:
        if (r5.hasNext() == false) goto L7;
        KClass r6 = (KClass) r5.next();
        if (uh7.a.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(r6)) == false) goto L10;
        if (JvmClassMappingKt.getJavaClass(r6).isInterface() == false) goto L10;
        Objects.toString(JvmClassMappingKt.getJavaClass(r6));
        v0 r7 = new v0(JvmClassMappingKt.getJavaClass(r2), r4);
        this.a.a(r7, r2);
        goto L10
    }

    public final void onStop() {
        this.a.f(this.b);
    }

    public a0(s r2, com.bytedance.android.scope.j r3) {
        Intrinsics.checkNotNullParameter(r2, "nativeDriver");
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a = r2;
        this.b = r3;
    }

    public final void f(com.bytedance.android.scope.j r2, com.bytedance.android.scope.j r3) {
        Intrinsics.checkNotNullParameter(r2, "parentScope");
        Intrinsics.checkNotNullParameter(r3, "childScope");
        c.add(Reflection.getOrCreateKotlinClass(r3.getClass()));
    }

    public final void h(com.bytedance.android.scope.j r2, com.bytedance.android.scope.j r3) {
        Intrinsics.checkNotNullParameter(r2, "parentScope");
        Intrinsics.checkNotNullParameter(r3, "childScope");
        this.a.f(r3);
    }

    public final void j(com.bytedance.android.scope.j r3, com.bytedance.android.scope.o r4, e33.l r5) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "service");
        Intrinsics.checkNotNullParameter(r5, "serviceDesc");
        if ((r4 instanceof uh7.a) == false) goto L6;
        s r0 = this.a;
        Intrinsics.checkNotNullParameter(r5, "$this$serviceCls");
        KClass r6 = (KClass) CollectionsKt.firstOrNull(r5.b);
        Intrinsics.checkNotNull(r6);
        r0.h(r4, JvmClassMappingKt.getJavaClass(r6), r3);
        return;
    }

    public final void k(com.bytedance.android.scope.j r4, com.bytedance.android.scope.o r5, e33.l r6) {
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "service");
        Intrinsics.checkNotNullParameter(r6, "serviceDesc");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "service");
        Intrinsics.checkNotNullParameter(r6, "serviceDesc");
    }
}

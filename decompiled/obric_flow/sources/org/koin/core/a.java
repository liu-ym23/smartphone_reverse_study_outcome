package org.koin.core;

import ai.j0;
import av.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.error.ScopeAlreadyCreatedException;
import org.koin.core.instance.e;
import org.koin.core.logger.Level;
import wu.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.koin.core.registry.a f20999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.a f21000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public um.a f21001c;

    public a() {
        this.f20999a = new org.koin.core.registry.a(this);
        this.f21000b = new i4.a(this);
        Intrinsics.checkNotNullParameter(this, "_koin");
        new ConcurrentHashMap();
        Intrinsics.checkNotNullParameter(this, "_koin");
        new HashMap();
        this.f21001c = new ru.b(Level.NONE, 1);
    }

    public final void a() {
        this.f21001c.o("Create eager instances ...");
        long r5 = System.nanoTime();
        i4.a r10 = this.f21000b;
        HashMap r11 = (HashMap) r10.f17503c;
        e[] r12 = (e[]) r11.values().toArray(new e[0]);
        ArrayList r13 = CollectionsKt.arrayListOf(Arrays.copyOf(r12, r12.length));
        r11.clear();
        a r14 = (a) r10.f17502b;
        org.koin.core.instance.b r15 = new org.koin.core.instance.b(r14.f21001c, r14.f20999a.d, null);
        Iterator r16 = r13.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        ((e) r16.next()).b(r15);
        goto L4
    L6:
        double r17 = ((Number) new Pair(Unit.INSTANCE, Double.valueOf((System.nanoTime() - r5) / 1000000.0d)).getSecond()).doubleValue();
        this.f21001c.o("Created eager instances in " + r17 + " ms");
    }

    public final org.koin.core.scope.a b(String r10, c r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "scopeId");
        Intrinsics.checkNotNullParameter(r11, "qualifier");
        org.koin.core.registry.a r5 = this.f20999a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "scopeId");
        Intrinsics.checkNotNullParameter(r11, "qualifier");
        a r13 = r5.f21020a;
        r13.f21001c.o("|- (+) Scope - id:'" + r10 + "' q:" + r11);
        HashSet r14 = r5.f21021b;
        if (r14.contains(r11) == true) goto L5;
        r13.f21001c.o("| Scope '" + r11 + "' not defined. Creating it ...");
        r14.add(r11);
    L5:
        ConcurrentHashMap r15 = r5.f21022c;
        if (r15.containsKey(r10) == true) goto L13;
        org.koin.core.scope.a r16 = new org.koin.core.scope.a(r11, r10, false, r13);
        if (r12 == null) goto L10;
        r13.f21001c.o("|- Scope source set id:'" + r10 + "' -> " + r12);
        r16.f = r12;
    L10:
        org.koin.core.scope.a[] r17 = {r5.d};
        Intrinsics.checkNotNullParameter(r17, "scopes");
        CollectionsKt.c(r16.e, r17);
        r15.put(r10, r16);
        return r16;
    L13:
        throw new ScopeAlreadyCreatedException(j0.k("Scope with id '", r10, "' is already created"));
    }

    public final org.koin.core.scope.a c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "scopeId");
        org.koin.core.registry.a r10 = this.f20999a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "scopeId");
        return (org.koin.core.scope.a) r10.f21022c.get(r5);
    }

    public final void d(List r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "modules");
        Intrinsics.checkNotNullParameter(r10, "modules");
        LinkedHashSet r5 = new LinkedHashSet();
        i.o(r10, r5);
        i4.a r13 = this.f21000b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "modules");
        Iterator r14 = r5.iterator();
    L4:
        if (r14.hasNext() == false) goto L13;
        uu.a r15 = (uu.a) r14.next();
        Iterator r16 = r15.d.entrySet().iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        Map.Entry r17 = (Map.Entry) r16.next();
        i4.a.x(r13, r11, (String) r17.getKey(), (org.koin.core.instance.c) r17.getValue());
        goto L7
    L9:
        Iterator r18 = r15.f22469c.iterator();
    L11:
        if (r18.hasNext() == false) goto L4;
        e r19 = (e) r18.next();
        ((HashMap) r13.f17503c).put(Integer.valueOf(r19.f21015a.hashCode()), r19);
        goto L11
    L13:
        org.koin.core.registry.a r20 = this.f20999a;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r5, "modules");
        Iterator r21 = r5.iterator();
    L15:
        if (r21.hasNext() == false) goto L17;
        uu.a r22 = (uu.a) r21.next();
        r20.f21021b.addAll(r22.e);
        goto L15
    L17:
        if (r12 == false) goto L24;
        a();
        return;
    }
}

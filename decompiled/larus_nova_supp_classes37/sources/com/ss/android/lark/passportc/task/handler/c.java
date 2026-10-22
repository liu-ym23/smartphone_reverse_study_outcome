package com.ss.android.lark.passportc.task.handler;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.task.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import l0c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class c implements a {
    public final Set<f> a;
    public final List<j0c.b> b;
    public final d c;
    public final Function1<j0c.a, Unit> d;
    public final Map<String, f> e;
    public final AtomicBoolean f;
    public final List<j0c.c> g;
    public final List<j0c.c> h;

    public final boolean b(j0c.c r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "taskResult");
        if (this.f.get() == false) goto L5;
        return true;
    L5:
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L7:
        if (r17.b == false) goto L9;
        ((ArrayList) this.g).add(r17);     // Catch: Throwable -> L34
    L10:
        f r6 = (f) ((LinkedHashMap) this.e).get(r17.a.a);     // Catch: Throwable -> L34
        if (r6 == null) goto L13;
        boolean r7 = r6.G();     // Catch: Throwable -> L34
    L14:
        int r10 = ((ArrayList) this.g).size() + ((ArrayList) this.h).size();     // Catch: Throwable -> L34
        Log.i("ComponentTask", "execute task chain finish size = " + r10 + " , total size = " + r18);     // Catch: Throwable -> L34
        if (r7 == true) goto L17;
    L24:
        if (r10 != r18) goto L31;
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L34
        r13.addAll(this.g);     // Catch: Throwable -> L34
        ((ArrayList) this.g).clear();     // Catch: Throwable -> L34
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L34
        r14.addAll(this.h);     // Catch: Throwable -> L34
        ((ArrayList) this.h).clear();     // Catch: Throwable -> L34
        j0c.a r0 = new j0c.a(true, "", r13, r14, 16);     // Catch: Throwable -> L34
        Function1<j0c.a, Unit> r4 = this.d;     // Catch: Throwable -> L34
        if (r4 == null) goto L28;
        r4.invoke(r0);     // Catch: Throwable -> L34
    L28:
        this.f.set(true);     // Catch: Throwable -> L34
        Log.i("ComponentTask", "execute task chain success , task size = " + r18);     // Catch: Throwable -> L34
        monitor-exit(this);
        return true;
    L31:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(this);
        return false;
    L17:
        if (r17.b == true) goto L24;
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L34
        r5.addAll(this.g);     // Catch: Throwable -> L34
        ((ArrayList) this.g).clear();     // Catch: Throwable -> L34
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L34
        r8.addAll(this.h);     // Catch: Throwable -> L34
        ((ArrayList) this.h).clear();     // Catch: Throwable -> L34
        j0c.a r11 = new j0c.a(false, "execute block task failed : task name = " + r17.a.a, r5, r8, r17);     // Catch: Throwable -> L34
        Function1<j0c.a, Unit> r2 = this.d;     // Catch: Throwable -> L34
        if (r2 == null) goto L21;
        r2.invoke(r11);     // Catch: Throwable -> L34
    L21:
        this.f.set(true);     // Catch: Throwable -> L34
        Log.i("ComponentTask", "execute task chain failed , block task [" + r17.a.a + "] failed, message:" + r17.d);     // Catch: Throwable -> L34
        monitor-exit(this);
        return true;
    L13:
        r7 = false;
        goto L14
    L9:
        ((ArrayList) this.h).add(r17);     // Catch: Throwable -> L34
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Set<? extends f> r2, List<j0c.b> r3, d r4, Function1<? super j0c.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "taskSet");
        Intrinsics.checkNotNullParameter(r3, "orderList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        Set<? extends f> r6 = r2;
        LinkedHashMap r7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Object r9 = r8.next();
        r7.put(((f) r9).F().a, r9);
        goto L4
    L6:
        this.e = r7;
        this.f = new AtomicBoolean(false);
        this.g = new ArrayList();
        this.h = new ArrayList();
    }

    public static List c(Set r6, List r7, d r8, Map r9) {
        Intrinsics.checkNotNullParameter(r6, "taskSet");
        Intrinsics.checkNotNullParameter(r7, "orderList");
        ArrayList r0 = new ArrayList();
        Set r10 = r6;
        Iterator r1 = r10.iterator();
    L3:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L17;
        f r2 = (f) r1.next();
        if (r9 == null) goto L8;
        j0c.c r4 = (j0c.c) r9.get(r2.F().a);
    L9:
        int r5 = r7.indexOf(r2.F());
        if (r5 >= 0) goto L13;
        r3 = false;
    L13:
        if (r3 == false) goto L16;
        r0.add(new k0c.a(r2, r5, r4, r8));
        goto L3
    L16:
        throw new IllegalStateException(("task [" + r2.F().a + "] order not defined ").toString());
    L8:
        r4 = null;
        goto L9
    L17:
        LinkedHashMap r11 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r12 = r0.iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        Object r13 = r12.next();
        r11.put(((k0c.d) r13).c().a, r13);
        goto L19
    L21:
        Iterator r14 = r10.iterator();
    L23:
        if (r14.hasNext() == false) goto L36;
        f r15 = (f) r14.next();
        if ((!r15.dependencies().isEmpty()) == false) goto L23;
        Iterator<T> r16 = r15.dependencies().iterator();
    L28:
        if (r16.hasNext() == false) goto L23;
        j0c.b r17 = (j0c.b) r16.next();
        k0c.d r18 = (k0c.d) r11.get(r17.a);
        if (r18 == null) goto L35;
        k0c.d r19 = (k0c.d) r11.get(r15.F().a);
        if (r19 == null) goto L28;
        r19.d(r18);
        goto L28
    L35:
        throw new IllegalStateException(("can not find task [" + r15.F().a + "] dependency task [" + r17.a + ']').toString());
    L36:
        Iterator r20 = r0.iterator();
    L38:
        if (r20.hasNext() == false) goto L45;
        k0c.d r21 = (k0c.d) r20.next();
        if ((!r21.parents().isEmpty()) == false) goto L38;
        Iterator<T> r22 = r21.parents().iterator();
    L43:
        if (r22.hasNext() == false) goto L38;
        ((k0c.d) r22.next()).b(r21);
        goto L43
    L45:
        return r0;
    }
}

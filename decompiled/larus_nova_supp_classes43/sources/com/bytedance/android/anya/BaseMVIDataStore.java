package com.bytedance.android.anya;

import com.bytedance.android.anya.BaseMVIDataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseMVIDataStore<STORE extends BaseMVIDataStore<STORE>> {
    public final Lock a;
    public final List<Function2<Map<Object, ? extends j<?>>, lb.e, Unit>> b;
    public final List<f0> c;
    public final Map<Object, Object> d;

    public boolean f() {
        return false;
    }

    public BaseMVIDataStore() {
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock(false);
        r0.readLock();
        this.a = r0.writeLock();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ConcurrentHashMap();
    }

    public final com.bytedance.android.anya.internal.g i(Object r10) {
        return new com.bytedance.android.anya.internal.g(new com.bytedance.android.anya.internal.n(this, r10, true));
    }

    public final com.bytedance.android.anya.internal.g j(Object r10) {
        return new com.bytedance.android.anya.internal.g(new com.bytedance.android.anya.internal.n(this, r10, false));
    }

    public final void d(final Object r12, final Map<Object, ? extends j<?>> r13) {
        if (f() == true) goto L9;
        Iterator r0 = ((ArrayList) this.c).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        final f0 r1 = (f0) r0.next();
        r1.a.R(new BaseMVIDataStore$commitChangesToExecutor$$inlined$forEach$lambda$1(r1, r12, r13));
        goto L6
    L8:
        return;
    L9:
        List<f0> r10 = this.c;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r14 = ((ArrayList) r10).iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        r11.add(((f0) r14.next()).a);
        goto L11
    L13:
        Iterator r15 = CollectionsKt.toSet(r11).iterator();
    L15:
        if (r15.hasNext() == false) goto L27;
        com.bytedance.android.anya.internal.b r16 = (com.bytedance.android.anya.internal.b) r15.next();
        r16.getClass();
        final com.bytedance.android.anya.internal.b.c r17 = new com.bytedance.android.anya.internal.b.c(r16);
        List<f0> r18 = this.c;
        ArrayList r19 = new ArrayList();
        Iterator r20 = ((ArrayList) r18).iterator();
    L18:
        if (r20.hasNext() == false) goto L22;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((f0) r21).a, r16) == false) goto L18;
        r19.add(r21);
        goto L18
    L22:
        Iterator r22 = r19.iterator();
    L24:
        if (r22.hasNext() == false) goto L26;
        final f0 r23 = (f0) r22.next();
        Function0<Unit> r110 = new BaseMVIDataStore$commitChangesToExecutor$$inlined$forEach$lambda$2(r23, r17, this, r12, r13);
        r17.a.add(r110);
        r17.b = r23.c;
        goto L24
    L26:
        r17.a();
        goto L15
    }

    public final void g(Object r10, Function1<? super n<STORE>, Unit> r11) {
        com.bytedance.android.anya.internal.f r1 = new com.bytedance.android.anya.internal.f();
        Lock r12 = this.a;
        r12.lock();
        mb.c r13 = mb.a.a;     // Catch: Throwable -> L6
        String r0 = "mutateExternal source=" + r10;     // Catch: Throwable -> L6
        mb.c r14 = mb.a.a;     // Catch: Throwable -> L6
        if (r14 == null) goto L8;
        r14.logD("ttlive_anya_ds", r0);     // Catch: Throwable -> L6
    L8:
        r11.invoke(r1);     // Catch: Throwable -> L6
        r1.b = true;     // Catch: Throwable -> L33
        Map<com.bytedance.android.anya.internal.n<?, ?>, Object> r15 = r1.a;     // Catch: Throwable -> L33
        LinkedHashMap r16 = new LinkedHashMap(MapsKt.mapCapacity(r15.size()));     // Catch: Throwable -> L33
        Iterator r17 = ((LinkedHashMap) r15).entrySet().iterator();     // Catch: Throwable -> L33
    L11:
        if (r17.hasNext() == false) goto L14;
        Object r18 = r17.next();     // Catch: Throwable -> L33
        Object r19 = ((Map.Entry) r18).getKey();     // Catch: Throwable -> L33
        Map.Entry r20 = (Map.Entry) r18;     // Catch: Throwable -> L33
        r16.put(r19, new j(r20.getValue(), ((com.bytedance.android.anya.internal.n) r20.getKey()).a(), true));     // Catch: Throwable -> L33
        goto L11
    L14:
        if (q0.f == true) goto L17;
        d(r10, r16);     // Catch: Throwable -> L33
        r16 = null;
    L17:
        ((LinkedHashMap) r1.a).clear();     // Catch: Throwable -> L33
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r12.unlock();
        if (q0.f == false) goto L40;
        if (r16 == null) goto L41;
        d(r10, r16);
        return;
    L41:
        return;
    L40:
        return;
    L6:
        th = move-exception;
        r1.b = true;     // Catch: Throwable -> L33
        Map<com.bytedance.android.anya.internal.n<?, ?>, Object> r21 = r1.a;     // Catch: Throwable -> L33
        LinkedHashMap r22 = new LinkedHashMap(MapsKt.mapCapacity(r21.size()));     // Catch: Throwable -> L33
        Iterator r23 = ((LinkedHashMap) r21).entrySet().iterator();     // Catch: Throwable -> L33
    L25:
        if (r23.hasNext() == false) goto L28;
        Object r24 = r23.next();     // Catch: Throwable -> L33
        Object r25 = ((Map.Entry) r24).getKey();     // Catch: Throwable -> L33
        Map.Entry r26 = (Map.Entry) r24;     // Catch: Throwable -> L33
        r22.put(r25, new j(r26.getValue(), ((com.bytedance.android.anya.internal.n) r26.getKey()).a(), true));     // Catch: Throwable -> L33
        goto L25
    L28:
        if (q0.f == true) goto L31;
        d(r10, r22);     // Catch: Throwable -> L33
    L31:
        ((LinkedHashMap) r1.a).clear();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r12.unlock();
        throw th;
    }
}

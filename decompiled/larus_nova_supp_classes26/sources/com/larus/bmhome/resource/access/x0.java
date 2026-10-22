package com.larus.bmhome.resource.access;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x0 {
    public static final x0 a = null;
    public static final CoroutineScope b = null;
    public static final ConcurrentHashMap<String, f> c = null;
    public static final ConcurrentHashMap<r0, f> d = null;
    public static final ConcurrentHashMap<String, ConcurrentHashMap<r0, f>> e = null;
    public static final Object f = null;

    public static final class a {
        public final f a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "SubmitResult(task=" + this.a + ", created=" + this.b + ')';
        }

        public a(f r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "task");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((f) r3).g), Long.valueOf(((f) r4).g));
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            Integer r0 = 0;
            if (((f) r3).c() == false) goto L5;
            Integer r5 = r0;
        L7:
            if (((f) r4).c() == true) goto L11;
            r0 = 1;
        L11:
            return ComparisonsKt.compareValues(r5, r0);
        L5:
            r5 = 1;
            goto L7
        }
    }

    public static final class d<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public d(c r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r0 = this.a.compare(r3, r4);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(((f) r3).f), Long.valueOf(((f) r4).f));
        }
    }

    public x0() {
    }

    static {
        a = new x0();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new Object();
    }

    public static void a() {
        if (c.isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = f;
        monitor-enter(r0);
        b();     // Catch: Throwable -> L10
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void b() {
        ConcurrentHashMap<String, f> r0 = c;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis();
        List r2 = SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(r0.values()), new w0()));
        LinkedHashSet r3 = new LinkedHashSet();
        List r4 = r2;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L6:
        boolean r7 = true;
        if (r6.hasNext() == false) goto L14;
        Object r8 = r6.next();
        if ((r1 - ((f) r8).g) > 600000) goto L12;
        r7 = false;
    L12:
        if (r7 == false) goto L6;
        r5.add(r8);
        goto L6
    L14:
        Iterator r9 = r5.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r3.add((f) r9.next());
        goto L16
    L18:
        int r10 = RangesKt.coerceAtLeast(c.size() - 256, 0);
        if (r10 <= 0) goto L24;
        Iterator r11 = CollectionsKt.take(CollectionsKt.sortedWith(r4, new b()), r10).iterator();
    L22:
        if (r11.hasNext() == false) goto L24;
        r3.add((f) r11.next());
    L24:
        Iterator r12 = r3.iterator();
    L26:
        if (r12.hasNext() == false) goto L37;
        f r13 = (f) r12.next();
        c.remove(r13.a, r13);
        d.remove(r13.b, r13);
        String r14 = r13.c.d.a;
        if (r14.length() <= 0) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == false) goto L26;
        ConcurrentHashMap<String, ConcurrentHashMap<r0, f>> r16 = e;
        ConcurrentHashMap<r0, f> r17 = r16.get(r14);
        if (r17 == null) goto L26;
        r17.remove(r13.b, r13);
        if (r17.isEmpty() == false) goto L26;
        r16.remove(r14, r17);
        goto L26
    L30:
        r15 = false;
        goto L31
    }

    public final z query(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        f r3 = c.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.snapshot();
    }

    public static f c(final y0 r2, final boolean r3) {
        ConcurrentHashMap<r0, f> r0 = e.get(r2.a);
        if (r0 == null) goto L9;
        Collection<f> r1 = r0.values();
        if (r1 != null) goto L8;
        return null;
    L8:
        return (f) SequencesKt.maxWithOrNull(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r1), new s0(r3)), new t0(r2)), new u0(r2)), new v0(r2)), new d(new c()));
    L9:
        return null;
    }

    public static void d(f r34, ResourceTraceResult r35, String r36) {
        long r2 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r34.f, 0);
        Map r6 = MapsKt.toMap(r34.i);
        ResourceTraceResult r7 = ResourceTraceResult.CANCELLED;
        if (r35 != r7) goto L5;
        Map r8 = MapsKt.mapOf(TuplesKt.to("e2e_cost_ms", String.valueOf(r2)));
    L6:
        u r9 = u.a;
        String r11 = r34.a;
        w r10 = r34.c;
        x r12 = r10.a;
        ResourceInputType r13 = r10.b.getType();
        w r0 = r34.c;
        ResourceMediaType r14 = r0.c;
        String r15 = r0.d.a;
        String r17 = ResourceTraceStage.TASK_LIFECYCLE.getValue();
        if (r35 != r7) goto L9;
        long r18 = r2;
    L10:
        String r20 = r35.getValue();
        String r22 = (String) r6.get("remote_policy_version");
        String r23 = (String) r6.get("route_decision");
        String r24 = (String) r6.get("route_reason");
        String r1 = (String) r6.get("cache_hit");
        if (r1 != null) goto L13;
        r1 = (String) r6.get("cache_stage");
    L13:
        String r25 = r1;
        String r26 = (String) r6.get("sdk_route");
        String r27 = (String) r6.get("remote_resolve");
        if (r35 != ResourceTraceResult.REUSE_ACTIVE) goto L16;
        boolean r3 = true;
    L17:
        t r33 = new t(r11, r12, r13, r14, r15, "task_manager", r17, r18, r20, r36, r22, r23, r24, r25, r26, r27, Boolean.valueOf(r3), null, null, MapsKt.plus(MapsKt.plus(r6, MapsKt.mapOf(TuplesKt.to("task_age_ms", String.valueOf(r2)))), r8), 393216);
        r9.getClass();
        u.b(r33);
        return;
    L16:
        r3 = false;
        goto L17
    L9:
        r18 = 0;
        goto L10
    L5:
        r8 = MapsKt.emptyMap();
        goto L6
    }
}

package com.ss.android.lark.passportc.task.handler;

import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.TaskType;
import com.ss.android.lark.passportc.task.f;
import j0c.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import l0c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NormalTaskHandler extends c {
    public final Set<f> i;
    public final TaskType j;
    public final List<j0c.b> k;
    public final t l;
    public final d m;
    public final l0c.c n;
    public final Function1<j0c.a, Unit> o;
    public final Set<k0c.d> p;
    public final Lazy q;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((k0c.d) r1).getOrder()), Integer.valueOf(((k0c.d) r2).getOrder()));
        }
    }

    @Override // com.ss.android.lark.passportc.task.handler.a
    public final void a(e r4, ExecuteStrategy r5, j0c.a r6) {
        Intrinsics.checkNotNullParameter(r4, "userContext");
        Intrinsics.checkNotNullParameter(r5, "executeStrategy");
        if (r6 == null) goto L10;
        List<j0c.c> r7 = r6.c;
        if (r7 == null) goto L10;
        List<j0c.c> r8 = r7;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L11;
        Object r0 = r9.next();
        r1.put(((j0c.c) r0).a.a, r0);
    L11:
        List r10 = CollectionsKt.sortedWith(c.c(this.i, this.k, this.m, r1), new a());
        ArrayList r2 = new ArrayList();
        Iterator r11 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L17;
        Object r3 = r11.next();
        if (((k0c.d) r3).parents().isEmpty() == false) goto L13;
        r2.add(r3);
        goto L13
    L17:
        Iterator r12 = r2.iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        k0c.d r13 = (k0c.d) r12.next();
        ((k0c.e) this.q.getValue()).a(r13);
        goto L19
    L21:
        ((k0c.e) this.q.getValue()).b(r4, r5);
        return;
    L10:
        r1 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NormalTaskHandler(Set<? extends f> r2, TaskType r3, List<j0c.b> r4, t r5, d r6, l0c.c r7, Function1<? super j0c.a, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "taskSet");
        Intrinsics.checkNotNullParameter(r3, "taskType");
        Intrinsics.checkNotNullParameter(r4, "orderList");
        Intrinsics.checkNotNullParameter(r5, "passportExecutors");
        super(r2, r4, r6, r8);
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.o = r8;
        this.p = new LinkedHashSet();
        this.q = LazyKt.lazy(new NormalTaskHandler$taskExecutor$2(this));
    }
}

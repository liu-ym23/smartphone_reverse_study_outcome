package com.ss.android.lark.passportc.task.handler;

import com.larksuite.framework.utils.p;
import com.ss.android.lark.log.Log;
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
public final class RollbackTaskHandler extends c {
    public final Set<f> i;
    public final TaskType j;
    public final List<j0c.b> k;
    public final t l;
    public final d m;
    public final l0c.c n;
    public final Function1<j0c.a, Unit> o;
    public final List<k0c.d> p;
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
    public final void a(e r8, ExecuteStrategy r9, j0c.a r10) {
        Intrinsics.checkNotNullParameter(r8, "userContext");
        Intrinsics.checkNotNullParameter(r9, "executeStrategy");
        j0c.b r3 = null;
        List r0 = CollectionsKt.sortedWith(c.c(this.i, this.k, this.m, null), new a());
        if (r10 == null) goto L8;
        j0c.c r11 = r10.e;
        if (r11 == null) goto L8;
        r3 = r11.a;
    L8:
        if (r3 == null) goto L17;
        List r1 = r0;
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        Object r5 = r2.next();
        r4.put(((k0c.d) r5).c().a, r5);
        goto L11
    L13:
        k0c.d r6 = (k0c.d) r4.get(r3.a);
        if (r6 == null) goto L16;
        int r7 = r0.indexOf(r6);
        ((ArrayList) this.p).addAll(p.a(r0.subList(0, r7 + 1)));
    L18:
        Log.i("ComponentTask", "rollback execute task list : " + this.p);
        Iterator r12 = ((ArrayList) this.p).iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        ((k0c.e) this.q.getValue()).a((k0c.d) r12.next());
        goto L20
    L22:
        ((k0c.e) this.q.getValue()).b(r8, r9);
        return;
    L16:
        Log.e("ComponentTask", "roll back not find pre block task ");
        ((ArrayList) this.p).addAll(p.a(r1));
        goto L18
    L17:
        Log.w("ComponentTask", "roll back miss pre block task result");
        ((ArrayList) this.p).addAll(p.a(r0));
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RollbackTaskHandler(Set<? extends f> r2, TaskType r3, List<j0c.b> r4, t r5, d r6, l0c.c r7, Function1<? super j0c.a, Unit> r8) {
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
        new LinkedHashSet();
        this.p = new ArrayList();
        this.q = LazyKt.lazy(new RollbackTaskHandler$taskExecutor$2(this));
    }
}

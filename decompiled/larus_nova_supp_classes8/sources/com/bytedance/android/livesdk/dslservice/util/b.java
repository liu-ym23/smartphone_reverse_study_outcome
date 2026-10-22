package com.bytedance.android.livesdk.dslservice.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import yt1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T extends yt1.k> {
    public final ConcurrentHashMap<yt1.q, ArrayList<WeakReference<T>>> a;
    public final DSLMonitor b;

    public b(DSLMonitor r2) {
        Intrinsics.checkNotNullParameter(r2, "monitor");
        this.b = r2;
        this.a = new ConcurrentHashMap();
    }

    public final void c(Function1<? super T, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "function");
        Iterator<Map.Entry<yt1.q, ArrayList<WeakReference<T>>>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Iterator<T> r1 = r0.next().getValue().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        yt1.k r2 = (yt1.k) ((WeakReference) r1.next()).get();
        if (r2 == null) goto L7;
        r4.invoke(r2);
        goto L7
    }

    public final void a(yt1.q r3, com.bytedance.android.livesdk.dslservice.a r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "component");
        WeakReference<T> r0 = new WeakReference(r4);
        if (this.a.get(r3) != null) goto L5;
        this.a.put(r3, new ArrayList());
    L5:
        ArrayList<WeakReference<T>> r5 = this.a.get(r3);
        if (r5 == null) goto L9;
        r5.add(r0);
        return;
    }

    public final void b(yt1.q r5, T r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        ArrayList<WeakReference<T>> r0 = this.a.get(r5);
        Object r1 = null;
        if (r0 == null) goto L11;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (Intrinsics.areEqual((yt1.k) ((WeakReference) r3).get(), r6) == false) goto L6;
        r1 = r3;
    L10:
        r1 = (WeakReference) r1;
    L11:
        ArrayList<WeakReference<T>> r7 = this.a.get(r5);
        if (r7 == null) goto L18;
        TypeIntrinsics.asMutableCollection(r7).remove(r1);
        return;
    }

    public final void d(yt1.q r4, Function1<? super T, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "function");
        StringBuilder r0 = new StringBuilder("refreshTemplate ");
        r0.append(r4.a);
        r0.append(' ');
        ArrayList<WeakReference<T>> r1 = this.a.get(r4);
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.size());
    L6:
        r0.append(r2);
        final String r3 = r0.toString();
        this.b.d(new ComponentShowingMapManager$log$1(r3));
        ArrayList<WeakReference<T>> r6 = this.a.get(r4);
        if (r6 == null) goto L14;
        Iterator<T> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L20;
        yt1.k r8 = (yt1.k) ((WeakReference) r7.next()).get();
        if (r8 == null) goto L10;
        r5.invoke(r8);
        goto L10
    L20:
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }
}

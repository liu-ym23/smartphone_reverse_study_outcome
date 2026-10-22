package com.ss.android.lark.platform.dispatcher;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements com.ss.android.lark.platform.dispatcher.a {
    public final CopyOnWriteArrayList<d> a;
    public final CopyOnWriteArrayList<f> b;
    public final CopyOnWriteArrayList<h> c;
    public final CopyOnWriteArrayList<i> d;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            ((f) r1).getPriority();
            ((f) r2).getPriority();
            return ComparisonsKt.compareValues(0, 0);
        }
    }

    public final boolean f() {
        List r0 = CollectionsKt.sortedWith(this.b, new a());
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((f) r1.next()).onBackPressed() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public b() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.lark.platform.dispatcher.c
    public final void a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a.addIfAbsent(r2);
    }

    @Override // com.ss.android.lark.platform.dispatcher.g
    public final void b(com.ss.android.lark.chat.component.c r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.c.addIfAbsent(r2);
    }

    @Override // com.ss.android.lark.platform.dispatcher.g
    public final void c(h r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.c.remove(r2);
    }

    @Override // com.ss.android.lark.platform.dispatcher.c
    public final void d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a.remove(r2);
    }

    @Override // com.ss.android.lark.platform.dispatcher.e
    public final void e(com.ss.android.lark.chat.component.b r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.b.addIfAbsent(r2);
    }
}

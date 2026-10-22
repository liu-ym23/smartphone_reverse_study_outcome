package com.larus.bmhome.view.actionbar.api;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ss8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final CopyOnWriteArrayList<IActionBarFilter> a = null;
    public static final CopyOnWriteArrayList<Function0<Unit>> b = null;

    static {
        a = new CopyOnWriteArrayList();
        b = new CopyOnWriteArrayList();
    }

    public static void a(final IActionBarFilter r2) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        CopyOnWriteArrayList<IActionBarFilter> r0 = a;
        CollectionsKt.removeAll(r0, new b(r2));
        r0.add(r2);
        Iterator<Function0<Unit>> r3 = b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().invoke();
        goto L4
    }

    public static void b(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "filterId");
        CollectionsKt.removeAll(a, new ss8.a(r2));
        Iterator<Function0<Unit>> r3 = b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().invoke();
        goto L4
    }
}

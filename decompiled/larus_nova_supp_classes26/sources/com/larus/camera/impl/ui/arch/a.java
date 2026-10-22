package com.larus.camera.impl.ui.arch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final List<d> a;
    public final List<d> b;
    public final List<d> c;

    public final void a() {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
    }

    public final List<d> c() {
        return CollectionsKt.plus(CollectionsKt.plus(this.a, this.b), this.c);
    }

    public a() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final List<d> b(List<? extends d> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        a();
        Iterator<? extends d> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        d r0 = r5.next();
        c r1 = r0.getPriority();
        if (Intrinsics.areEqual(r1, c.b) == true) goto L7;
        if (Intrinsics.areEqual(r1, c.a) == true) goto L10;
        if (Intrinsics.areEqual(r1, c.c) == false) goto L4;
        ((ArrayList) this.a).add(r0);
        goto L4
    L10:
        ((ArrayList) this.c).add(r0);
        goto L4
    L7:
        ((ArrayList) this.b).add(r0);
        goto L4
    L15:
        return c();
    }
}

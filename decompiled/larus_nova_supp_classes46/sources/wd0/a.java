package wd0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final List<c> a;

    public a() {
        ArrayList r0 = new ArrayList();
        r0.add(new d());
        Unit r1 = Unit.INSTANCE;
        this.a = r0;
    }

    public final void a(b r3, List<xd0.a> r4, xd0.b r5) {
        Intrinsics.checkNotNullParameter(r3, "renderContext");
        Intrinsics.checkNotNullParameter(r4, "layers");
        Intrinsics.checkNotNullParameter(r5, "shadowLayer");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).a(r3, r4, r5);
        goto L4
    }
}

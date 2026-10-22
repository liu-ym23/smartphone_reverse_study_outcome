package ue8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements i {
    public a() {
    }

    public final c a(List<j> r5, Set<String> r6) {
        Intrinsics.checkNotNullParameter(r5, "currentlyVisible");
        Intrinsics.checkNotNullParameter(r6, "previouslyExposed");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r1 = r5.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(((j) r1.next()).a);
        goto L4
    L6:
        Set r2 = CollectionsKt.toSet(r0);
        ArrayList r3 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        Object r4 = r7.next();
        if ((!((j) r4).d) == false) goto L8;
        r3.add(r4);
        goto L8
    L12:
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r6.iterator();
    L14:
        if (r9.hasNext() == false) goto L19;
        Object r10 = r9.next();
        if ((!r2.contains((String) r10)) == false) goto L14;
        r8.add(r10);
        goto L14
    L19:
        return new c(r3, r8);
    }
}

package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
final class ay {
    public static <E> Comparator<? super E> a(SortedSet<E> r2) {
        Comparator<? super E> r3 = ((SortedSet) ZeusTransformUtils.wrapperContextForParams(r2, SortedSet.class, "com.obric.memorydata.plugin")).comparator();
        if (r3 == null) goto L5;
        return r3;
    L5:
        return Ordering.natural();
    }

    public static boolean a(Comparator<?> r2, Iterable<?> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        if (ZeusTransformUtils.instanceOf(r5, SortedSet.class) == false) goto L6;
        Comparator r6 = a((SortedSet) ZeusTransformUtils.preCheckCast(r5, SortedSet.class, "com.obric.memorydata.plugin"));
    L9:
        return r4.equals(r6);
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ax.class) == false) goto L10;
        r6 = ((ax) ZeusTransformUtils.preCheckCast(r5, ax.class, "com.obric.memorydata.plugin")).comparator();
        goto L9
    L10:
        return false;
    }
}

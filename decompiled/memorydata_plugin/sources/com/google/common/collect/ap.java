package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class ap {
    static Object a(Object r2, int r3) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException("at index " + r3);
    }

    private static Object[] a(Iterable<?> r3, Object[] r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r4[r0] = r5.next();
        r0 = r0 + 1;
        goto L4
    L6:
        return r4;
    }

    static Object[] a(Collection<?> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        return a(r3, new Object[r3.size()]);
    }

    static <T> T[] a(Collection<?> r2, T[] r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        int r0 = r4.size();
        if (r3.length >= r0) goto L5;
        r3 = (T[]) a(r3, r0);
    L5:
        a(r4, r3);
        if (r3.length <= r0) goto L8;
        r3[r0] = null;
    L8:
        return r3;
    }

    static Object[] a(Object... r1) {
        return b(r1, r1.length);
    }

    public static <T> T[] a(T[] r0, int r1) {
        return (T[]) ar.a(r0, r1);
    }

    static Object[] a(Object[] r2, int r3, int r4) {
        com.google.common.base.n.a(r3, r3 + r4, r2.length);
        if (r4 == 0) goto L5;
        Object[] r1 = new Object[r4];
        System.arraycopy(r2, r3, r1, 0, r4);
        return r1;
    L5:
        return new Object[0];
    }

    static <T> T[] a(Object[] r2, int r3, int r4, T[] r5) {
        com.google.common.base.n.a(r3, r3 + r4, r2.length);
        if (r5.length >= r4) goto L6;
        r5 = (T[]) a(r5, r4);
    L8:
        System.arraycopy(r2, r3, r5, 0, r4);
        return r5;
    L6:
        if (r5.length <= r4) goto L8;
        r5[r4] = null;
        goto L8
    }

    static Object[] b(Object[] r2, int r3) {
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L5;
        a(r2[r0], r0);
        r0 = r0 + 1;
        goto L3
    L5:
        return r2;
    }
}

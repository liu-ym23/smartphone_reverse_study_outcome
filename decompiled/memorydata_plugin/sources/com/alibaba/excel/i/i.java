package com.alibaba.excel.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.compress.utils.Iterators;

/* JADX INFO: loaded from: classes.dex */
public class i {
    static int a(int r2, String r3) {
        if (r2 < 0) goto L5;
        return r2;
    L5:
        throw new IllegalArgumentException(r3 + " cannot be negative but was: " + r2);
    }

    public static <T> T a(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    public static <E> ArrayList<E> a() {
        return new ArrayList();
    }

    public static <E> ArrayList<E> a(int r1) {
        return new ArrayList(b(r1));
    }

    public static <E> ArrayList<E> a(Iterable<? extends E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        a(r4);
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L6;
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
    L6:
        return a(r4.iterator());
    }

    public static <E> ArrayList<E> a(Iterator<? extends E> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        ArrayList<E> r0 = a();
        Iterators.addAll(r0, r3);
        return r0;
    }

    static int b(int r4) {
        a(r4, "arraySize");
        return h.a((((long) r4) + 5) + ((long) (r4 / 10)));
    }
}

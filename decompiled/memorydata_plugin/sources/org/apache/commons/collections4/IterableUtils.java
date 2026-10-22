package org.apache.commons.collections4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class IterableUtils {
    static final FluentIterable EMPTY_ITERABLE = null;

    static {
        EMPTY_ITERABLE = new AnonymousClass1();
    }

    static void checkNotNull(Iterable<?> r2) {
        Objects.requireNonNull((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), "Iterable must not be null.");
    }

    private static <E> Iterator<E> emptyIteratorIfNull(Iterable<E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        return r3.iterator();
    L6:
        return IteratorUtils.emptyIterator();
    }

    public static int size(Iterable<?> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L7;
        return ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).size();
    L7:
        return IteratorUtils.size(emptyIteratorIfNull(r3));
    }

    public static <E> String toString(Iterable<E> r2) {
        return IteratorUtils.toString(emptyIteratorIfNull((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")));
    }

    public static <I, O> Iterable<O> transformedIterable(Iterable<I> r2, Transformer<? super I, ? extends O> r3) {
        final Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        final Transformer r5 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        checkNotNull(r4);
        Objects.requireNonNull(r5, "Transformer must not be null.");
        return new AnonymousClass10(r4, r5);
    }
}

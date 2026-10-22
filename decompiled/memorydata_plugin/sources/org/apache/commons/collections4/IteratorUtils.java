package org.apache.commons.collections4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyListIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.iterators.TransformIterator;

/* JADX INFO: loaded from: classes6.dex */
public class IteratorUtils {
    public static final ResettableIterator EMPTY_ITERATOR = null;
    public static final ResettableListIterator EMPTY_LIST_ITERATOR = null;
    public static final MapIterator EMPTY_MAP_ITERATOR = null;
    public static final OrderedIterator EMPTY_ORDERED_ITERATOR = null;
    public static final OrderedMapIterator EMPTY_ORDERED_MAP_ITERATOR = null;

    static {
        EMPTY_ITERATOR = EmptyIterator.RESETTABLE_INSTANCE;
        EMPTY_LIST_ITERATOR = EmptyListIterator.RESETTABLE_INSTANCE;
        EMPTY_ORDERED_ITERATOR = EmptyOrderedIterator.INSTANCE;
        EMPTY_MAP_ITERATOR = EmptyMapIterator.INSTANCE;
        EMPTY_ORDERED_MAP_ITERATOR = EmptyOrderedMapIterator.INSTANCE;
    }

    public static <E> ResettableIterator<E> emptyIterator() {
        return EmptyIterator.resettableEmptyIterator();
    }

    public static int size(Iterator<?> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r3 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r3.hasNext() == false) goto L7;
        r3.next();
        r0 = r0 + 1;
        goto L5
    }

    public static <E> String toString(Iterator<E> r4) {
        return toString((Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin"), TransformerUtils.stringValueTransformer(), ", ", "[", "]");
    }

    public static <E> String toString(Iterator<E> r4, Transformer<? super E, String> r5, String r6, String r7, String r8) {
        Iterator r9 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
        Transformer r10 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r5, Transformer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r10, "transformer may not be null");
        Objects.requireNonNull(r6, "delimiter may not be null");
        Objects.requireNonNull(r7, "prefix may not be null");
        Objects.requireNonNull(r8, "suffix may not be null");
        StringBuilder r0 = new StringBuilder(r7);
        if (r9 != null) goto L5;
    L10:
        r0.append(r8);
        return r0.toString();
    L5:
        if (r9.hasNext() == false) goto L8;
        r0.append((String) ZeusTransformUtils.preCheckCast(r10.transform(r9.next()), String.class, "com.obric.memorydata.plugin"));
        r0.append(r6);
        goto L5
    L8:
        if (r0.length() <= r7.length()) goto L10;
        r0.setLength(r0.length() - r6.length());
        goto L10
    }

    public static <I, O> Iterator<O> transformedIterator(Iterator<? extends I> r2, Transformer<? super I, ? extends O> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        Transformer r5 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Iterator must not be null");
        Objects.requireNonNull(r5, "Transformer must not be null");
        return new TransformIterator(r4, r5);
    }
}

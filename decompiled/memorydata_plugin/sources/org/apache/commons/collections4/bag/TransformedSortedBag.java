package org.apache.commons.collections4.bag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedSortedBag<E> extends TransformedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = -251737742649401930L;

    public TransformedSortedBag(SortedBag<E> r3, Transformer<? super E, ? extends E> r4) {
        super((SortedBag) ZeusTransformUtils.wrapperContextForParams(r3, SortedBag.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> TransformedSortedBag<E> transformedSortedBag(SortedBag<E> r5, Transformer<? super E, ? extends E> r6) {
        SortedBag r7 = (SortedBag) ZeusTransformUtils.wrapperContextForParams(r5, SortedBag.class, "com.obric.memorydata.plugin");
        Transformer r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r6, Transformer.class, "com.obric.memorydata.plugin");
        TransformedSortedBag<E> r0 = new TransformedSortedBag(r7, r8);
        if (r7.size() <= 0) goto L7;
        Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(r7.toArray(), Object[].class, "com.obric.memorydata.plugin");
        r7.clear();
        int r9 = r1.length;
        int r2 = 0;
    L5:
        if (r2 >= r9) goto L7;
        Object r3 = r1[r2];
        r0.decorated().add(r8.transform(r3));
        r2 = r2 + 1;
    L7:
        return r0;
    }

    public static <E> TransformedSortedBag<E> transformingSortedBag(SortedBag<E> r2, Transformer<? super E, ? extends E> r3) {
        return new TransformedSortedBag((SortedBag) ZeusTransformUtils.wrapperContextForParams(r2, SortedBag.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.SortedBag
    public Comparator<? super E> comparator() {
        return getSortedBag().comparator();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E first() {
        return getSortedBag().first();
    }

    public SortedBag<E> getSortedBag() {
        return (SortedBag) ZeusTransformUtils.preCheckCast(decorated(), SortedBag.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E last() {
        return getSortedBag().last();
    }
}

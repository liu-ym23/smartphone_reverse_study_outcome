package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedSortedSet<E> extends TransformedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -1675486811351124386L;

    public TransformedSortedSet(SortedSet<E> r3, Transformer<? super E, ? extends E> r4) {
        super((SortedSet) ZeusTransformUtils.wrapperContextForParams(r3, SortedSet.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> TransformedSortedSet<E> transformedSortedSet(SortedSet<E> r5, Transformer<? super E, ? extends E> r6) {
        SortedSet r7 = (SortedSet) ZeusTransformUtils.wrapperContextForParams(r5, SortedSet.class, "com.obric.memorydata.plugin");
        Transformer r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r6, Transformer.class, "com.obric.memorydata.plugin");
        TransformedSortedSet<E> r0 = new TransformedSortedSet(r7, r8);
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

    public static <E> TransformedSortedSet<E> transformingSortedSet(SortedSet<E> r2, Transformer<? super E, ? extends E> r3) {
        return new TransformedSortedSet((SortedSet) ZeusTransformUtils.wrapperContextForParams(r2, SortedSet.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return getSortedSet().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return getSortedSet().first();
    }

    public SortedSet<E> getSortedSet() {
        return (SortedSet) ZeusTransformUtils.preCheckCast(decorated(), SortedSet.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E r2) {
        return new TransformedSortedSet(getSortedSet().headSet(r2), this.transformer);
    }

    @Override // java.util.SortedSet
    public E last() {
        return getSortedSet().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E r2, E r3) {
        return new TransformedSortedSet(getSortedSet().subSet(r2, r3), this.transformer);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E r2) {
        return new TransformedSortedSet(getSortedSet().tailSet(r2), this.transformer);
    }
}

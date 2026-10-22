package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedNavigableSet<E> extends TransformedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    public TransformedNavigableSet(NavigableSet<E> r3, Transformer<? super E, ? extends E> r4) {
        super((NavigableSet) ZeusTransformUtils.wrapperContextForParams(r3, NavigableSet.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    public static <E> TransformedNavigableSet<E> transformedNavigableSet(NavigableSet<E> r5, Transformer<? super E, ? extends E> r6) {
        NavigableSet r7 = (NavigableSet) ZeusTransformUtils.wrapperContextForParams(r5, NavigableSet.class, "com.obric.memorydata.plugin");
        Transformer r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r6, Transformer.class, "com.obric.memorydata.plugin");
        TransformedNavigableSet<E> r0 = new TransformedNavigableSet(r7, r8);
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

    public static <E> TransformedNavigableSet<E> transformingNavigableSet(NavigableSet<E> r2, Transformer<? super E, ? extends E> r3) {
        return new TransformedNavigableSet((NavigableSet) ZeusTransformUtils.wrapperContextForParams(r2, NavigableSet.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.NavigableSet
    public E ceiling(E r1) {
        return decorated().ceiling(r1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) ZeusTransformUtils.preCheckCast(super.decorated(), NavigableSet.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return decorated().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return transformingNavigableSet(decorated().descendingSet(), this.transformer);
    }

    @Override // java.util.NavigableSet
    public E floor(E r1) {
        return decorated().floor(r1);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E r2, boolean r3) {
        return transformingNavigableSet(decorated().headSet(r2, r3), this.transformer);
    }

    @Override // java.util.NavigableSet
    public E higher(E r1) {
        return decorated().higher(r1);
    }

    @Override // java.util.NavigableSet
    public E lower(E r1) {
        return decorated().lower(r1);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return decorated().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return decorated().pollLast();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E r2, boolean r3, E r4, boolean r5) {
        return transformingNavigableSet(decorated().subSet(r2, r3, r4, r5), this.transformer);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E r2, boolean r3) {
        return transformingNavigableSet(decorated().tailSet(r2, r3), this.transformer);
    }
}

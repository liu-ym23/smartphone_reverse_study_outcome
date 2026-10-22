package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSortedSetDecorator<E> extends AbstractSetDecorator<E> implements SortedSet<E> {
    private static final long serialVersionUID = -3462240946294214398L;

    public AbstractSortedSetDecorator() {
    }

    public AbstractSortedSetDecorator(Set<E> r3) {
        super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }

    @Override // org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Set decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public SortedSet<E> decorated() {
        return (SortedSet) ZeusTransformUtils.preCheckCast(super.decorated(), SortedSet.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedSet
    public E first() {
        return decorated().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E r1) {
        return decorated().headSet(r1);
    }

    @Override // java.util.SortedSet
    public E last() {
        return decorated().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E r1, E r2) {
        return decorated().subSet(r1, r2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E r1) {
        return decorated().tailSet(r1);
    }
}

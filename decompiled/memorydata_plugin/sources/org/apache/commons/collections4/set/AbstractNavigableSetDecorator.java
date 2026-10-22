package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractNavigableSetDecorator<E> extends AbstractSortedSetDecorator<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    public AbstractNavigableSetDecorator() {
    }

    public AbstractNavigableSetDecorator(NavigableSet<E> r3) {
        super((NavigableSet) ZeusTransformUtils.wrapperContextForParams(r3, NavigableSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.NavigableSet
    public E ceiling(E r1) {
        return decorated().ceiling(r1);
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) ZeusTransformUtils.preCheckCast(super.decorated(), NavigableSet.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Set decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ SortedSet decorated() {
        return decorated();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return decorated().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return decorated().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E r1) {
        return decorated().floor(r1);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E r1, boolean r2) {
        return decorated().headSet(r1, r2);
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
    public NavigableSet<E> subSet(E r1, boolean r2, E r3, boolean r4) {
        return decorated().subSet(r1, r2, r3, r4);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E r1, boolean r2) {
        return decorated().tailSet(r1, r2);
    }
}

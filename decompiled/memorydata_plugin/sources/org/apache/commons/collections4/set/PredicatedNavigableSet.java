package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class PredicatedNavigableSet<E> extends PredicatedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    public PredicatedNavigableSet(NavigableSet<E> r3, Predicate<? super E> r4) {
        super((NavigableSet) ZeusTransformUtils.wrapperContextForParams(r3, NavigableSet.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin"));
    }

    public static <E> PredicatedNavigableSet<E> predicatedNavigableSet(NavigableSet<E> r2, Predicate<? super E> r3) {
        return new PredicatedNavigableSet((NavigableSet) ZeusTransformUtils.wrapperContextForParams(r2, NavigableSet.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.NavigableSet
    public E ceiling(E r1) {
        return decorated().ceiling(r1);
    }

    @Override // org.apache.commons.collections4.set.PredicatedSortedSet, org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.set.PredicatedSortedSet, org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) ZeusTransformUtils.preCheckCast(super.decorated(), NavigableSet.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.set.PredicatedSortedSet, org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Set decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.set.PredicatedSortedSet, org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ SortedSet decorated() {
        return decorated();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return decorated().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return predicatedNavigableSet(decorated().descendingSet(), this.predicate);
    }

    @Override // java.util.NavigableSet
    public E floor(E r1) {
        return decorated().floor(r1);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E r2, boolean r3) {
        return predicatedNavigableSet(decorated().headSet(r2, r3), this.predicate);
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
        return predicatedNavigableSet(decorated().subSet(r2, r3, r4, r5), this.predicate);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E r2, boolean r3) {
        return predicatedNavigableSet(decorated().tailSet(r2, r3), this.predicate);
    }
}

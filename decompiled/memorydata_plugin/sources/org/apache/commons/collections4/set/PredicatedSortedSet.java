package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class PredicatedSortedSet<E> extends PredicatedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -9110948148132275052L;

    public PredicatedSortedSet(SortedSet<E> r3, Predicate<? super E> r4) {
        super((SortedSet) ZeusTransformUtils.wrapperContextForParams(r3, SortedSet.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin"));
    }

    public static <E> PredicatedSortedSet<E> predicatedSortedSet(SortedSet<E> r2, Predicate<? super E> r3) {
        return new PredicatedSortedSet((SortedSet) ZeusTransformUtils.wrapperContextForParams(r2, SortedSet.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }

    @Override // org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Set decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public SortedSet<E> decorated() {
        return (SortedSet) ZeusTransformUtils.preCheckCast(super.decorated(), SortedSet.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedSet
    public E first() {
        return decorated().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E r2) {
        return new PredicatedSortedSet(decorated().headSet(r2), this.predicate);
    }

    @Override // java.util.SortedSet
    public E last() {
        return decorated().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E r2, E r3) {
        return new PredicatedSortedSet(decorated().subSet(r2, r3), this.predicate);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E r2) {
        return new PredicatedSortedSet(decorated().tailSet(r2), this.predicate);
    }
}

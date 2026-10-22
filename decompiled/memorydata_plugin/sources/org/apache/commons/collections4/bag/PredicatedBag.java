package org.apache.commons.collections4.bag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

/* JADX INFO: loaded from: classes6.dex */
public class PredicatedBag<E> extends PredicatedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = -2575833140344736876L;

    public PredicatedBag(Bag<E> r3, Predicate<? super E> r4) {
        super((Bag) ZeusTransformUtils.wrapperContextForParams(r3, Bag.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin"));
    }

    public static <E> PredicatedBag<E> predicatedBag(Bag<E> r2, Predicate<? super E> r3) {
        return new PredicatedBag((Bag) ZeusTransformUtils.wrapperContextForParams(r2, Bag.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E r1, int r2) {
        validate(r1);
        return decorated().add(r1, r2);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Bag<E> decorated() {
        return (Bag) ZeusTransformUtils.preCheckCast(super.decorated(), Bag.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Collection
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (decorated().equals(r1) == true) goto L7;
        return false;
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object r1) {
        return decorated().getCount(r1);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object r1, int r2) {
        return decorated().remove(r1, r2);
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }
}

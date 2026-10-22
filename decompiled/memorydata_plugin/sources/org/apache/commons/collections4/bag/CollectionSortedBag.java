package org.apache.commons.collections4.bag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: loaded from: classes6.dex */
public final class CollectionSortedBag<E> extends AbstractSortedBagDecorator<E> {
    private static final long serialVersionUID = -2560033712679053143L;

    public CollectionSortedBag(SortedBag<E> r3) {
        super((SortedBag) ZeusTransformUtils.wrapperContextForParams(r3, SortedBag.class, "com.obric.memorydata.plugin"));
    }

    public static <E> SortedBag<E> collectionSortedBag(SortedBag<E> r2) {
        return new CollectionSortedBag((SortedBag) ZeusTransformUtils.wrapperContextForParams(r2, SortedBag.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        setCollection((Collection) ZeusTransformUtils.preCheckCast(r3.readObject(), Collection.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean add(E r2) {
        return add(r2, 1);
    }

    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.Bag
    public boolean add(E r1, int r2) {
        decorated().add(r1, r2);
        return true;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> r5) {
        Iterator<E> r6 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r1 = false;
    L5:
        if (r6.hasNext() == false) goto L10;
        boolean r2 = add(r6.next(), 1);
        if (r1 == true) goto L9;
        if (r2 == false) goto L3;
    L9:
        r1 = true;
        goto L5
    L10:
        return r1;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Iterator<E> r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        if (contains(r4.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean remove(Object r2) {
        return remove(r2, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L14;
        Iterator<E> r7 = r6.iterator();
    L5:
        boolean r1 = false;
    L7:
        if (r7.hasNext() == false) goto L12;
        E r2 = r7.next();
        boolean r3 = remove(r2, getCount(r2));
        if (r1 == true) goto L11;
        if (r3 == false) goto L5;
    L11:
        r1 = true;
        goto L7
    L12:
        return r1;
    L14:
        return decorated().removeAll(null);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        boolean r0 = false;
        Iterator<E> r2 = iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        if (r4.contains(r2.next()) == true) goto L6;
        r2.remove();
        r0 = true;
        goto L6
    L10:
        return r0;
    L12:
        return decorated().retainAll(null);
    }
}

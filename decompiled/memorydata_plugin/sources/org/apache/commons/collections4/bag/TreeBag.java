package org.apache.commons.collections4.bag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: loaded from: classes6.dex */
public class TreeBag<E> extends AbstractMapBag<E> implements Serializable, SortedBag<E> {
    private static final long serialVersionUID = -7740146511091606676L;

    public TreeBag() {
        super(new TreeMap());
    }

    public TreeBag(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this();
        addAll(r4);
    }

    public TreeBag(Comparator<? super E> r3) {
        super(new TreeMap((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin")));
    }

    private void readObject(ObjectInputStream r4) {
        r4.defaultReadObject();
        super.doReadObject(new TreeMap((Comparator) ZeusTransformUtils.preCheckCast(r4.readObject(), Comparator.class, "com.obric.memorydata.plugin")), r4);
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(comparator());
        super.doWriteObject(r2);
    }

    @Override // org.apache.commons.collections4.bag.AbstractMapBag, java.util.Collection
    public boolean add(E r3) {
        if (comparator() != null) goto L9;
        if (ZeusTransformUtils.instanceOf(r3, Comparable.class) == true) goto L9;
        Objects.requireNonNull(r3);
        throw new IllegalArgumentException("Objects of type " + r3.getClass() + " cannot be added to a naturally ordered TreeBag as it does not implement Comparable");
    L9:
        return super.add(r3);
    }

    @Override // org.apache.commons.collections4.SortedBag
    public Comparator<? super E> comparator() {
        return getMap().comparator();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E first() {
        return getMap().firstKey();
    }

    @Override // org.apache.commons.collections4.bag.AbstractMapBag
    public /* bridge */ /* synthetic */ Map getMap() {
        return getMap();
    }

    @Override // org.apache.commons.collections4.bag.AbstractMapBag
    public SortedMap<E, AbstractMapBag.MutableInteger> getMap() {
        return (SortedMap) ZeusTransformUtils.preCheckCast(super.getMap(), SortedMap.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E last() {
        return getMap().lastKey();
    }
}

package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class MapBackedSet<E, V> implements Serializable, Set<E> {
    private static final long serialVersionUID = 6723912213766056587L;
    private final V dummyValue;
    private final Map<E, ? super V> map;

    private MapBackedSet(Map<E, ? super V> r3, V r4) {
        Map<E, ? super V> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "The map must not be null");
        this.map = r5;
        this.dummyValue = r4;
    }

    public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> r2) {
        return mapBackedSet((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), null);
    }

    public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> r2, V r3) {
        return new MapBackedSet((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E r4) {
        int r0 = this.map.size();
        this.map.put(r4, this.dummyValue);
        if (this.map.size() == r0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        int r0 = this.map.size();
        Iterator<E> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        E r1 = r7.next();
        this.map.put(r1, this.dummyValue);
        goto L4
    L7:
        if (this.map.size() == r0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.map.keySet().containsAll(r4);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object r1) {
        return this.map.keySet().equals(r1);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.map.keySet().hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r3) {
        int r0 = this.map.size();
        this.map.remove(r3);
        if (this.map.size() == r0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.map.keySet().removeAll(r4);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> r3) {
        Predicate<? super E> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        return this.map.keySet().removeIf(r4);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.map.keySet().retainAll(r4);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.map.keySet().toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r1) {
        return (T[]) this.map.keySet().toArray(r1);
    }
}

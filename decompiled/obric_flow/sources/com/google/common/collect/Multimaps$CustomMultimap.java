package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
class Multimaps$CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
    private static final long serialVersionUID = 0;
    transient com.google.common.base.e0 factory;

    public Multimaps$CustomMultimap(Map<K, Collection<V>> r5, com.google.common.base.e0 r10) {
        super(r5);
        r10.getClass();
        this.factory = r10;
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        this.factory = (com.google.common.base.e0) r5.readObject();
        setMap((Map) r5.readObject());
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(this.factory);
        r5.writeObject(backingMap());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Map<K, Collection<V>> createAsMap() {
        return createMaybeNavigableAsMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection() {
        return (Collection) this.factory.get();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r5) {
        if ((r5 instanceof NavigableSet) == false) goto L7;
        return p7.x0((NavigableSet) r5);
    L7:
        if ((r5 instanceof SortedSet) == false) goto L11;
        return Collections.unmodifiableSortedSet((SortedSet) r5);
    L11:
        if ((r5 instanceof Set) == false) goto L15;
        return Collections.unmodifiableSet((Set) r5);
    L15:
        if ((r5 instanceof List) == false) goto L19;
        return Collections.unmodifiableList((List) r5);
    L19:
        return Collections.unmodifiableCollection(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K r5, Collection<V> r10) {
        if ((r10 instanceof List) == false) goto L7;
        return wrapList(r5, (List) r10, null);
    L7:
        if ((r10 instanceof NavigableSet) == false) goto L11;
        return new x(this, r5, (NavigableSet) r10, null);
    L11:
        if ((r10 instanceof SortedSet) == false) goto L15;
        return new z(this, r5, (SortedSet) r10, null);
    L15:
        if ((r10 instanceof Set) == false) goto L19;
        return new y(this, r5, (Set) r10);
    L19:
        return new u(this, r5, r10, null);
    }
}

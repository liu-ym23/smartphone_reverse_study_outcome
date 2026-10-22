package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMultimap<K, V> extends b1 implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> r5) {
            this.multimap = r5;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            if ((r5 instanceof Map.Entry) == false) goto L6;
            Map.Entry r10 = (Map.Entry) r5;
            return this.multimap.containsEntry(r10.getKey(), r10.getValue());
        L6:
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public ga iterator() {
            return this.multimap.entryIterator();
        }
    }

    public class Keys extends ImmutableMultiset<K> {
        final /* synthetic */ ImmutableMultimap this$0;

        public Keys(ImmutableMultimap r5) {
            this.this$0 = r5;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            return this.this$0.containsKey(r5);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
        public int count(Object r5) {
            ImmutableCollection<V> r10 = this.this$0.map.get(r5);
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
        public /* bridge */ /* synthetic */ Set elementSet() {
            return elementSet();
        }

        @Override // com.google.common.collect.ImmutableMultiset, java.lang.Iterable, com.google.common.collect.z7
        public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
            super.forEach(r5);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
        public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
            super.forEachEntry(r5);
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public y7 getEntry(int r5) {
            Map.Entry<K, ? extends ImmutableCollection<V>> r10 = this.this$0.map.entrySet().asList().get(r5);
            K r11 = r10.getKey();
            return p7.K(r10.getValue().size(), r11);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new KeysSerializedForm(this.this$0);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
        public ImmutableSet<K> elementSet() {
            return this.this$0.keySet();
        }
    }

    public static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> r5) {
            this.multimap = r5;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient ImmutableMultimap f8828b;

        public Values(ImmutableMultimap<K, V> r5) {
            this.f8828b = r5;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            return this.f8828b.containsValue(r5);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] r5, int r10) {
            ga r11 = this.f8828b.map.values().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            r10 = ((ImmutableCollection) r11.next()).copyIntoArray(r5, r10);
            goto L4
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f8828b.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public ga iterator() {
            return this.f8828b.valueIterator();
        }
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> r5, int r10) {
        this.map = r5;
        this.size = r10;
    }

    public static <K, V> e4 builder() {
        return new e4();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(q7 r5) {
        if ((r5 instanceof ImmutableMultimap) == false) goto L8;
        ImmutableMultimap<K, V> r10 = (ImmutableMultimap) r5;
        if (r10.isPartialView() == true) goto L8;
        return r10;
    L8:
        return ImmutableListMultimap.copyOf(r5);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.q7
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean containsEntry(Object r5, Object r10) {
        return super.containsEntry(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public boolean containsKey(Object r5) {
        return this.map.containsKey(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean containsValue(Object r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r5) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.g0
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    /* JADX INFO: renamed from: createEntries, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Collection m91createEntries() {
        return createEntries();
    }

    @Override // com.google.common.collect.g0
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.g0
    public /* bridge */ /* synthetic */ z7 createKeys() {
        return createKeys();
    }

    @Override // com.google.common.collect.g0
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.g0
    public /* bridge */ /* synthetic */ Iterator entryIterator() {
        return entryIterator();
    }

    @Override // com.google.common.collect.g0
    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return p7.D(asMap().entrySet().spliterator(), new h(21), (this instanceof s8 ? 1 : 0) | 64, size());
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    @Override // com.google.common.collect.q7
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        r5.getClass();
        asMap().forEach(new h3(r5, 2));
    }

    @Override // com.google.common.collect.q7
    public abstract ImmutableCollection<V> get(K r5);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ z7 keys() {
        return keys();
    }

    @Override // com.google.common.collect.q7
    @Deprecated
    public final boolean put(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    @Deprecated
    public final boolean putAll(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    @Deprecated
    public final boolean remove(Object r5, Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.g0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.g0
    public /* bridge */ /* synthetic */ Iterator valueIterator() {
        return valueIterator();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r5, V r10) {
        return ImmutableListMultimap.of(r5, r10);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.g0
    public ImmutableMultiset<K> createKeys() {
        return new Keys(this);
    }

    @Override // com.google.common.collect.g0
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.q7
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        Collection r5 = this.f8983a;
        if (r5 != null) goto L6;
        r5 = m91createEntries();
        this.f8983a = r5;
    L6:
        return (ImmutableCollection) r5;
    }

    @Override // com.google.common.collect.g0
    public ga entryIterator() {
        return new c4(this);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    @Deprecated
    public final boolean putAll(q7 r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q7
    @Deprecated
    public ImmutableCollection<V> removeAll(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q7
    @Deprecated
    public ImmutableCollection<V> replaceValues(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.g0
    public ga valueIterator() {
        return new d4(this);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r5, V r10, K r11, V r12) {
        return ImmutableListMultimap.of(r5, r10, r11, r12);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14) {
        return ImmutableListMultimap.of(r5, r10, r11, r12, r13, r14);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r5) {
        return ImmutableListMultimap.copyOf(r5);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16) {
        return ImmutableListMultimap.of(r5, r10, r11, r12, r13, r14, r15, r16);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        return ImmutableListMultimap.of(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }
}

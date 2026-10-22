package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient ValueEntry f8844h;
    transient int valueSetCapacity;

    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements p5 {
        ValueEntry<K, V> nextInValueBucket;
        ValueEntry<K, V> predecessorInMultimap;
        p5 predecessorInValueSet;
        final int smearedValueHash;
        ValueEntry<K, V> successorInMultimap;
        p5 successorInValueSet;

        public ValueEntry(K r5, V r10, int r11, ValueEntry<K, V> r12) {
            super(r5, r10);
            this.smearedValueHash = r11;
            this.nextInValueBucket = r12;
        }

        public static <K, V> ValueEntry<K, V> newHeader() {
            return new ValueEntry(null, null, 0, null);
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            ValueEntry<K, V> r5 = this.predecessorInMultimap;
            Objects.requireNonNull(r5);
            return r5;
        }

        @Override // com.google.common.collect.p5
        public p5 getPredecessorInValueSet() {
            p5 r5 = this.predecessorInValueSet;
            Objects.requireNonNull(r5);
            return r5;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            ValueEntry<K, V> r5 = this.successorInMultimap;
            Objects.requireNonNull(r5);
            return r5;
        }

        @Override // com.google.common.collect.p5
        public p5 getSuccessorInValueSet() {
            p5 r5 = this.successorInValueSet;
            Objects.requireNonNull(r5);
            return r5;
        }

        public boolean matchesValue(Object r5, int r10) {
            if (this.smearedValueHash == r10) goto L5;
        L7:
            return false;
        L5:
            if (com.google.common.base.b0.w(getValue(), r5) == false) goto L7;
            return true;
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> r5) {
            this.predecessorInMultimap = r5;
        }

        @Override // com.google.common.collect.p5
        public void setPredecessorInValueSet(p5 r5) {
            this.predecessorInValueSet = r5;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> r5) {
            this.successorInMultimap = r5;
        }

        @Override // com.google.common.collect.p5
        public void setSuccessorInValueSet(p5 r5) {
            this.successorInValueSet = r5;
        }
    }

    public LinkedHashMultimap(int r5, int r10) {
        int r11 = h8.f9015a;
        super(p7.a0(r5));
        this.valueSetCapacity = 2;
        p7.q(r10, "expectedValuesPerKey");
        this.valueSetCapacity = r10;
        ValueEntry<K, V> r12 = ValueEntry.newHeader();
        this.f8844h = r12;
        r12.setSuccessorInMultimap(r12);
        r12.setPredecessorInMultimap(r12);
    }

    public static void access$200(p5 r5, p5 r10) {
        r5.setSuccessorInValueSet(r10);
        r10.setPredecessorInValueSet(r5);
    }

    public static /* synthetic */ ValueEntry access$300(LinkedHashMultimap r5) {
        return r5.f8844h;
    }

    public static void access$400(ValueEntry r5, ValueEntry r10) {
        r5.setSuccessorInMultimap(r10);
        r10.setPredecessorInMultimap(r5);
    }

    public static void access$500(p5 r5) {
        p5 r10 = r5.getPredecessorInValueSet();
        p5 r11 = r5.getSuccessorInValueSet();
        r10.setSuccessorInValueSet(r11);
        r11.setPredecessorInValueSet(r10);
    }

    public static void access$600(ValueEntry r5) {
        ValueEntry<K, V> r10 = r5.getPredecessorInMultimap();
        ValueEntry<K, V> r11 = r5.getSuccessorInMultimap();
        r10.setSuccessorInMultimap(r11);
        r11.setPredecessorInMultimap(r10);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap(16, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        ValueEntry<K, V> r5 = ValueEntry.newHeader();
        this.f8844h = r5;
        r5.setSuccessorInMultimap(r5);
        r5.setPredecessorInMultimap(r5);
        this.valueSetCapacity = 2;
        int r11 = r10.readInt();
        int r12 = h8.f9015a;
        LinkedHashMap r13 = p7.a0(12);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r11) goto L5;
        Object r16 = r10.readObject();
        r13.put(r16, createCollection(r16));
        r15 = r15 + 1;
        goto L3
    L5:
        int r17 = r10.readInt();
    L6:
        if (r14 >= r17) goto L8;
        Object r18 = r10.readObject();
        Object r19 = r10.readObject();
        Collection r20 = (Collection) r13.get(r18);
        Objects.requireNonNull(r20);
        r20.add(r19);
        r14 = r14 + 1;
        goto L6
    L8:
        setMap(r13);
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeInt(keySet().size());
        Iterator<K> r10 = keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.writeObject(r10.next());
        goto L4
    L6:
        r5.writeInt(size());
        Iterator<Map.Entry<K, V>> r11 = entries().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<K, V> r12 = r11.next();
        r5.writeObject(r12.getKey());
        r5.writeObject(r12.getValue());
        goto L8
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public void clear() {
        super.clear();
        ValueEntry<K, V> r5 = this.f8844h;
        r5.setSuccessorInMultimap(r5);
        r5.setPredecessorInMultimap(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean containsEntry(Object r5, Object r10) {
        return super.containsEntry(r5, r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean containsKey(Object r5) {
        return super.containsKey(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean containsValue(Object r5) {
        return super.containsValue(r5);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new m5(this);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return Spliterators.spliterator(entries(), 17);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ void forEach(BiConsumer r5) {
        super.forEach(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set get(Object r5) {
        return super.get(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public Set<K> keySet() {
        return (Set<K>) super.keySet();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ z7 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean put(Object r5, Object r10) {
        return super.put(r5, r10);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean putAll(q7 r5) {
        return super.putAll(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean remove(Object r5, Object r10) {
        return super.remove(r5, r10);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set removeAll(Object r5) {
        return super.removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.g0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Iterator<V> valueIterator() {
        return new q0(entryIterator(), 1);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Spliterator<V> valueSpliterator() {
        return p7.R(entrySpliterator(), new h(20));
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int r5, int r10) {
        return new LinkedHashMultimap(p7.n(r5), p7.n(r10));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        int r5 = this.valueSetCapacity;
        int r10 = h8.f9015a;
        return new LinkedHashSet(p7.n(r5));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean putAll(Object r5, Iterable r10) {
        return super.putAll(r5, r10);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public Set<V> replaceValues(K r5, Iterable<? extends V> r10) {
        return super.replaceValues(r5, r10);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(q7 r5) {
        LinkedHashMultimap<K, V> r10 = create(r5.keySet().size(), 2);
        r10.putAll(r5);
        return r10;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K r5) {
        return new o5(this, r5, this.valueSetCapacity);
    }
}

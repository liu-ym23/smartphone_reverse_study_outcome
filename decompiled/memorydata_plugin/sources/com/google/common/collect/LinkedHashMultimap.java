package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;
    private transient ValueEntry<K, V> multimapHeaderEntry;
    transient int valueSetCapacity;

    static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements b<K, V> {
        ValueEntry<K, V> nextInValueBucket;
        ValueEntry<K, V> predecessorInMultimap;
        b<K, V> predecessorInValueSet;
        final int smearedValueHash;
        ValueEntry<K, V> successorInMultimap;
        b<K, V> successorInValueSet;

        ValueEntry(K r1, V r2, int r3, ValueEntry<K, V> r4) {
            super(r1, r2);
            this.smearedValueHash = r3;
            this.nextInValueBucket = r4;
        }

        static <K, V> ValueEntry<K, V> newHeader() {
            return new ValueEntry(null, null, 0, null);
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return (ValueEntry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.predecessorInMultimap), ValueEntry.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> getPredecessorInValueSet() {
            return (b) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.predecessorInValueSet), b.class, "com.obric.memorydata.plugin");
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return (ValueEntry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.successorInMultimap), ValueEntry.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> getSuccessorInValueSet() {
            return (b) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.successorInValueSet), b.class, "com.obric.memorydata.plugin");
        }

        boolean matchesValue(Object r2, int r3) {
            if (this.smearedValueHash == r3) goto L5;
        L7:
            return false;
        L5:
            if (com.google.common.base.k.a(getValue(), r2) == false) goto L7;
            return true;
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> r1) {
            this.predecessorInMultimap = r1;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void setPredecessorInValueSet(b<K, V> r3) {
            this.predecessorInValueSet = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> r1) {
            this.successorInMultimap = r1;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void setSuccessorInValueSet(b<K, V> r3) {
            this.successorInValueSet = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }
    }

    final class a extends Sets.b<V> implements b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ValueEntry<K, V>[] f4495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinkedHashMultimap f4496b;
        private final K c;
        private int d;
        private int e;
        private b<K, V> f;
        private b<K, V> g;

        a(LinkedHashMultimap r1, K r2, int r3) {
            this.f4496b = r1;
            this.d = 0;
            this.e = 0;
            this.c = r2;
            this.f = this;
            this.g = this;
            this.f4495a = new ValueEntry[ai.a(r3, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)];
        }

        private int a() {
            return this.f4495a.length - 1;
        }

        static /* synthetic */ b a(a r0) {
            return r0.f;
        }

        static /* synthetic */ int b(a r0) {
            return r0.e;
        }

        private void b() {
            if (ai.a(this.d, this.f4495a.length, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) == false) goto L7;
            int r0 = this.f4495a.length * 2;
            ValueEntry<K, V>[] r1 = new ValueEntry[r0];
            this.f4495a = r1;
            int r2 = r0 - 1;
            b<K, V> r3 = this.f;
        L5:
            if (r3 == this) goto L9;
            ValueEntry<K, V> r4 = (ValueEntry) ZeusTransformUtils.preCheckCast(r3, ValueEntry.class, "com.obric.memorydata.plugin");
            int r5 = r4.smearedValueHash & r2;
            r4.nextInValueBucket = r1[r5];
            r1[r5] = r4;
            r3 = r3.getSuccessorInValueSet();
            goto L5
        L9:
            return;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V r6) {
            int r0 = ai.a(r6);
            int r1 = a() & r0;
            ValueEntry<K, V> r2 = this.f4495a[r1];
            ValueEntry<K, V> r3 = r2;
        L3:
            if (r3 == null) goto L9;
            if (r3.matchesValue(r6, r0) == true) goto L6;
            r3 = r3.nextInValueBucket;
            goto L3
        L6:
            return false;
        L9:
            ValueEntry<K, V> r4 = new ValueEntry(this.c, r6, r0, r2);
            LinkedHashMultimap.access$200(this.g, r4);
            LinkedHashMultimap.access$200(r4, this);
            LinkedHashMultimap.access$400(LinkedHashMultimap.access$300(this.f4496b).getPredecessorInMultimap(), r4);
            LinkedHashMultimap.access$400(r4, LinkedHashMultimap.access$300(this.f4496b));
            this.f4495a[r1] = r4;
            this.d++;
            this.e++;
            b();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f4495a, null);
            this.d = 0;
            b<K, V> r0 = this.f;
        L3:
            if (r0 == this) goto L5;
            LinkedHashMultimap.access$600((ValueEntry) ZeusTransformUtils.preCheckCast(r0, ValueEntry.class, "com.obric.memorydata.plugin"));
            r0 = r0.getSuccessorInValueSet();
            goto L3
        L5:
            LinkedHashMultimap.access$200(this, this);
            this.e++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r3) {
            int r0 = ai.a(r3);
            ValueEntry<K, V> r2 = this.f4495a[a() & r0];
        L3:
            if (r2 == null) goto L9;
            if (r2.matchesValue(r3, r0) == true) goto L6;
            r2 = r2.nextInValueBucket;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> r4) {
            Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r5);
            b<K, V> r0 = this.f;
        L3:
            if (r0 == this) goto L5;
            r5.accept(((ValueEntry) ZeusTransformUtils.preCheckCast(r0, ValueEntry.class, "com.obric.memorydata.plugin")).getValue());
            r0 = r0.getSuccessorInValueSet();
            goto L3
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> getPredecessorInValueSet() {
            return this.g;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> getSuccessorInValueSet() {
            return this.f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r7) {
            int r0 = ai.a(r7);
            int r1 = a() & r0;
            ValueEntry<K, V> r2 = this.f4495a[r1];
            ValueEntry<K, V> r3 = null;
        L3:
            if (r2 == null) goto L12;
            if (r2.matchesValue(r7, r0) == true) goto L6;
            r3 = r2;
            r2 = r2.nextInValueBucket;
            goto L3
        L6:
            if (r3 != null) goto L8;
            this.f4495a[r1] = r2.nextInValueBucket;
        L9:
            LinkedHashMultimap.access$500(r2);
            LinkedHashMultimap.access$600(r2);
            this.d--;
            this.e++;
            return true;
        L8:
            r3.nextInValueBucket = r2.nextInValueBucket;
            goto L9
        L12:
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void setPredecessorInValueSet(b<K, V> r3) {
            this.g = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void setSuccessorInValueSet(b<K, V> r3) {
            this.f = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.d;
        }
    }

    private interface b<K, V> {
        b<K, V> getPredecessorInValueSet();

        b<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(b<K, V> r1);

        void setSuccessorInValueSet(b<K, V> r1);
    }

    private LinkedHashMultimap(int r1, int r2) {
        super(ar.b(r1));
        this.valueSetCapacity = 2;
        o.a(r2, "expectedValuesPerKey");
        this.valueSetCapacity = r2;
        ValueEntry<K, V> r3 = ValueEntry.newHeader();
        this.multimapHeaderEntry = r3;
        succeedsInMultimap(r3, r3);
    }

    static /* synthetic */ void access$200(b r2, b r3) {
        succeedsInValueSet((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ ValueEntry access$300(LinkedHashMultimap r0) {
        return r0.multimapHeaderEntry;
    }

    static /* synthetic */ void access$400(ValueEntry r0, ValueEntry r1) {
        succeedsInMultimap(r0, r1);
    }

    static /* synthetic */ void access$500(b r2) {
        deleteFromValueSet((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$600(ValueEntry r0) {
        deleteFromMultimap(r0);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int r1, int r2) {
        return new LinkedHashMultimap(Maps.b(r1), Maps.b(r2));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(am<? extends K, ? extends V> r2) {
        am r3 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin");
        LinkedHashMultimap<K, V> r0 = create(r3.keySet().size(), 2);
        r0.putAll(r3);
        return r0;
    }

    private static <K, V> void deleteFromMultimap(ValueEntry<K, V> r1) {
        succeedsInMultimap(r1.getPredecessorInMultimap(), r1.getSuccessorInMultimap());
    }

    private static <K, V> void deleteFromValueSet(b<K, V> r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        succeedsInValueSet(r3.getPredecessorInValueSet(), r3.getSuccessorInValueSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r8) {
        r8.defaultReadObject();
        ValueEntry<K, V> r0 = ValueEntry.newHeader();
        this.multimapHeaderEntry = r0;
        succeedsInMultimap(r0, r0);
        this.valueSetCapacity = 2;
        int r1 = r8.readInt();
        Map r2 = ar.b(12);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        Object r5 = r8.readObject();
        r2.put(r5, createCollection(r5));
        r4 = r4 + 1;
        goto L3
    L5:
        int r6 = r8.readInt();
    L6:
        if (r3 >= r6) goto L8;
        Object r7 = r8.readObject();
        ((Collection) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Collection) ZeusTransformUtils.preCheckCast(r2.get(r7), Collection.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).add(r8.readObject());
        r3 = r3 + 1;
        goto L6
    L8:
        setMap(r2);
    }

    private static <K, V> void succeedsInMultimap(ValueEntry<K, V> r0, ValueEntry<K, V> r1) {
        r0.setSuccessorInMultimap(r1);
        r1.setPredecessorInMultimap(r0);
    }

    private static <K, V> void succeedsInValueSet(b<K, V> r2, b<K, V> r3) {
        b<K, V> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        b<K, V> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        r4.setSuccessorInValueSet(r5);
        r5.setPredecessorInValueSet(r4);
    }

    private void writeObject(ObjectOutputStream r4) {
        r4.defaultWriteObject();
        r4.writeInt(keySet().size());
        Iterator<K> r0 = keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r4.writeObject(r0.next());
        goto L4
    L6:
        r4.writeInt(size());
        Iterator<Map.Entry<K, V>> r3 = entries().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r1.getKey());
        r4.writeObject(r1.getValue());
        goto L8
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public void clear() {
        super.clear();
        ValueEntry<K, V> r0 = this.multimapHeaderEntry;
        succeedsInMultimap(r0, r0);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean containsEntry(Object r1, Object r2) {
        return super.containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean containsKey(Object r1) {
        return super.containsKey(r1);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean containsValue(Object r1) {
        return super.containsValue(r1);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    Collection<V> createCollection(K r3) {
        return new a(this, r3, this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    Set<V> createCollection() {
        return ar.d(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return Spliterators.spliterator(entries(), 17);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public /* synthetic */ void forEach(BiConsumer r3) {
        super.forEach((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Set get(Object r1) {
        return super.get(r1);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ an keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean put(Object r1, Object r2) {
        return super.put(r1, r2);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* synthetic */ boolean putAll(am r3) {
        return super.putAll((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* synthetic */ boolean putAll(Object r3, Iterable r4) {
        return super.putAll(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean remove(Object r1, Object r2) {
        return super.remove(r1, r2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Set removeAll(Object r1) {
        return super.removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public Set<V> replaceValues(K r3, Iterable<? extends V> r4) {
        return super.replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    Iterator<V> valueIterator() {
        return Maps.b(entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    Spliterator<V> valueSpliterator() {
        return p.a(entrySpliterator(), $$Lambda$kPj8Ioh2qrHaOpflIdB8Zk2L0PY.INSTANCE);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public Collection<V> values() {
        return super.values();
    }
}

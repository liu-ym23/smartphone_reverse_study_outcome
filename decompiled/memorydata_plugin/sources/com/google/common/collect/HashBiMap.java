package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
public final class HashBiMap<K, V> extends Maps.d<K, V> implements k<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 0;
    private transient BiEntry<K, V> firstInKeyInsertionOrder;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    private transient k<V, K> inverse;
    private transient BiEntry<K, V> lastInKeyInsertionOrder;
    private transient int mask;
    private transient int modCount;
    private transient int size;

    private static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;
        BiEntry<K, V> nextInKToVBucket;
        BiEntry<K, V> nextInKeyInsertionOrder;
        BiEntry<K, V> nextInVToKBucket;
        BiEntry<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        BiEntry(K r1, int r2, V r3, int r4) {
            super(r1, r3);
            this.keyHash = r2;
            this.valueHash = r4;
        }
    }

    private final class Inverse extends Maps.d<V, K> implements k<V, K>, Serializable {
        final /* synthetic */ HashBiMap this$0;

        private final class a extends Maps.e<V, K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Inverse f4439a;

            a(Inverse r1) {
                this.f4439a = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new AnonymousClass1(this);
            }

            @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r3) {
                BiEntry r4 = HashBiMap.access$400(this.f4439a.this$0, r3, ai.a(r3));
                if (r4 != null) goto L6;
                return false;
            L6:
                HashBiMap.access$200(this.f4439a.this$0, r4);
                return true;
            }
        }

        private Inverse(HashBiMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Inverse(HashBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void lambda$forEach$0(BiConsumer r2, Object r3, Object r4) {
            ((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r2, BiConsumer.class, "com.obric.memorydata.plugin")).accept(r4, r3);
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("Use InverseSerializedForm");
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public void clear() {
            forward().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return forward().containsValue(r1);
        }

        @Override // com.google.common.collect.Maps.d
        Iterator<Map.Entry<V, K>> entryIterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super V, ? super K> r3) {
            final BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            this.this$0.forEach(new $$Lambda$HashBiMap$Inverse$4w97n6nJfhrvpPcRbCQHqjvEQA(r4));
        }

        @Override // com.google.common.collect.k
        public K forcePut(V r2, K r3) {
            return (K) HashBiMap.access$800(this.this$0, r2, r3, true);
        }

        k<K, V> forward() {
            return this.this$0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object r2) {
            return (K) Maps.b(HashBiMap.access$400(this.this$0, r2, ai.a(r2)));
        }

        @Override // com.google.common.collect.k
        public k<K, V> inverse() {
            return forward();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new a(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V r2, K r3) {
            return (K) HashBiMap.access$800(this.this$0, r2, r3, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object r3) {
            BiEntry r4 = HashBiMap.access$400(this.this$0, r3, ai.a(r3));
            if (r4 != null) goto L5;
            return null;
        L5:
            HashBiMap.access$200(this.this$0, r4);
            r4.prevInKeyInsertionOrder = null;
            r4.nextInKeyInsertionOrder = null;
            return r4.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void replaceAll(BiFunction<? super V, ? super K, ? extends K> r5) {
            BiFunction r6 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r5, BiFunction.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r6);
            BiEntry<K, V> r0 = HashBiMap.access$000(this.this$0);
            clear();
        L3:
            if (r0 == null) goto L5;
            put(r0.value, r6.apply(r0.value, r0.key));
            r0 = r0.nextInKeyInsertionOrder;
            goto L3
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.access$700(this.this$0);
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.k
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.k
        public Set<K> values() {
            return forward().keySet();
        }

        Object writeReplace() {
            return new InverseSerializedForm(this.this$0);
        }
    }

    private static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> r1) {
            this.bimap = r1;
        }

        Object readResolve() {
            return this.bimap.inverse();
        }
    }

    abstract class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        BiEntry<K, V> f4440b;
        BiEntry<K, V> c;
        int d;
        int e;
        final /* synthetic */ HashBiMap f;

        a(HashBiMap r2) {
            this.f = r2;
            this.f4440b = HashBiMap.access$000(r2);
            this.c = null;
            this.d = HashBiMap.access$100(r2);
            this.e = r2.size();
        }

        abstract T b(BiEntry<K, V> r1);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (HashBiMap.access$100(this.f) != this.d) goto L12;
            if (this.f4440b != null) goto L7;
        L9:
            return false;
        L7:
            if (this.e <= 0) goto L9;
            return true;
        L12:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            BiEntry<K, V> r0 = (BiEntry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f4440b), BiEntry.class, "com.obric.memorydata.plugin");
            this.f4440b = r0.nextInKeyInsertionOrder;
            this.c = r0;
            this.e--;
            return b(r0);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (HashBiMap.access$100(this.f) != this.d) goto L11;
            BiEntry<K, V> r0 = this.c;
            if (r0 == null) goto L9;
            HashBiMap.access$200(this.f, r0);
            this.d = HashBiMap.access$100(this.f);
            this.c = null;
            return;
        L9:
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        L11:
            throw new ConcurrentModificationException();
        }
    }

    private final class b extends Maps.e<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashBiMap f4441a;

        b(HashBiMap r1) {
            this.f4441a = r1;
            super(r1);
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            BiEntry r4 = HashBiMap.access$300(this.f4441a, r3, ai.a(r3));
            if (r4 != null) goto L6;
            return false;
        L6:
            HashBiMap.access$200(this.f4441a, r4);
            r4.prevInKeyInsertionOrder = null;
            r4.nextInKeyInsertionOrder = null;
            return true;
        }
    }

    private HashBiMap(int r1) {
        init(r1);
    }

    static /* synthetic */ BiEntry access$000(HashBiMap r0) {
        return r0.firstInKeyInsertionOrder;
    }

    static /* synthetic */ int access$100(HashBiMap r0) {
        return r0.modCount;
    }

    static /* synthetic */ void access$200(HashBiMap r0, BiEntry r1) {
        r0.delete(r1);
    }

    static /* synthetic */ BiEntry access$300(HashBiMap r0, Object r1, int r2) {
        return r0.seekByKey(r1, r2);
    }

    static /* synthetic */ BiEntry access$400(HashBiMap r0, Object r1, int r2) {
        return r0.seekByValue(r1, r2);
    }

    static /* synthetic */ void access$500(HashBiMap r0, BiEntry r1, BiEntry r2) {
        r0.insert(r1, r2);
    }

    static /* synthetic */ int access$700(HashBiMap r0) {
        return r0.size;
    }

    static /* synthetic */ Object access$800(HashBiMap r0, Object r1, Object r2, boolean r3) {
        return r0.putInverse(r1, r2, r3);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int r1) {
        return new HashBiMap(r1);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        HashBiMap<K, V> r0 = create(r3.size());
        r0.putAll(r3);
        return r0;
    }

    private BiEntry<K, V>[] createTable(int r1) {
        return new BiEntry[r1];
    }

    private void delete(BiEntry<K, V> r6) {
        int r0 = r6.keyHash & this.mask;
        BiEntry<K, V> r1 = this.hashTableKToV[r0];
        BiEntry<K, V> r2 = null;
        BiEntry<K, V> r3 = null;
    L3:
        if (r1 == r6) goto L4;
        r3 = r1;
        r1 = r1.nextInKToVBucket;
        goto L3
    L4:
        if (r3 != null) goto L6;
        this.hashTableKToV[r0] = r6.nextInKToVBucket;
    L7:
        int r4 = r6.valueHash & this.mask;
        BiEntry<K, V> r5 = this.hashTableVToK[r4];
    L8:
        BiEntry<K, V> r7 = r2;
        r2 = r5;
        if (r2 == r6) goto L10;
        r5 = r2.nextInVToKBucket;
        goto L8
    L10:
        if (r7 != null) goto L12;
        this.hashTableVToK[r4] = r6.nextInVToKBucket;
    L14:
        if (r6.prevInKeyInsertionOrder != null) goto L16;
        this.firstInKeyInsertionOrder = r6.nextInKeyInsertionOrder;
    L18:
        if (r6.nextInKeyInsertionOrder != null) goto L20;
        this.lastInKeyInsertionOrder = r6.prevInKeyInsertionOrder;
    L21:
        this.size--;
        this.modCount++;
        return;
    L20:
        r6.nextInKeyInsertionOrder.prevInKeyInsertionOrder = r6.prevInKeyInsertionOrder;
        goto L21
    L16:
        r6.prevInKeyInsertionOrder.nextInKeyInsertionOrder = r6.nextInKeyInsertionOrder;
        goto L18
    L12:
        r7.nextInVToKBucket = r6.nextInVToKBucket;
        goto L14
    L6:
        r3.nextInKToVBucket = r6.nextInKToVBucket;
        goto L7
    }

    private void init(int r3) {
        o.a(r3, "expectedSize");
        int r4 = ai.a(r3, LOAD_FACTOR);
        this.hashTableKToV = createTable(r4);
        this.hashTableVToK = createTable(r4);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = r4 - 1;
        this.modCount = 0;
    }

    private void insert(BiEntry<K, V> r3, BiEntry<K, V> r4) {
        int r0 = r3.keyHash & this.mask;
        r3.nextInKToVBucket = this.hashTableKToV[r0];
        this.hashTableKToV[r0] = r3;
        int r1 = r3.valueHash & this.mask;
        r3.nextInVToKBucket = this.hashTableVToK[r1];
        this.hashTableVToK[r1] = r3;
        if (r4 != null) goto L9;
        r3.prevInKeyInsertionOrder = this.lastInKeyInsertionOrder;
        r3.nextInKeyInsertionOrder = null;
        BiEntry<K, V> r5 = this.lastInKeyInsertionOrder;
        if (r5 != null) goto L7;
        this.firstInKeyInsertionOrder = r3;
    L8:
        this.lastInKeyInsertionOrder = r3;
    L17:
        this.size++;
        this.modCount++;
        return;
    L7:
        r5.nextInKeyInsertionOrder = r3;
        goto L8
    L9:
        r3.prevInKeyInsertionOrder = r4.prevInKeyInsertionOrder;
        if (r3.prevInKeyInsertionOrder != null) goto L12;
        this.firstInKeyInsertionOrder = r3;
    L13:
        r3.nextInKeyInsertionOrder = r4.nextInKeyInsertionOrder;
        if (r3.nextInKeyInsertionOrder == null) goto L8;
        r3.nextInKeyInsertionOrder.prevInKeyInsertionOrder = r3;
        goto L17
    L12:
        r3.prevInKeyInsertionOrder.nextInKeyInsertionOrder = r3;
        goto L13
    }

    private V put(K r5, V r6, boolean r7) {
        int r0 = ai.a(r5);
        int r1 = ai.a(r6);
        BiEntry<K, V> r2 = seekByKey(r5, r0);
        if (r2 != null) goto L5;
    L9:
        BiEntry<K, V> r3 = seekByValue(r6, r1);
        if (r3 == null) goto L15;
        if (r7 == false) goto L14;
        delete(r3);
        goto L15
    L14:
        throw new IllegalArgumentException("value already present: " + r6);
    L15:
        BiEntry<K, V> r8 = new BiEntry(r5, r0, r6, r1);
        if (r2 == null) goto L19;
        delete(r2);
        insert(r8, r2);
        r2.prevInKeyInsertionOrder = null;
        r2.nextInKeyInsertionOrder = null;
        return r2.value;
    L19:
        insert(r8, null);
        rehashIfNecessary();
        return null;
    L5:
        if (r1 != r2.valueHash) goto L9;
        if (com.google.common.base.k.a(r6, r2.value) == false) goto L9;
        return r6;
    }

    private K putInverse(V r6, K r7, boolean r8) {
        int r0 = ai.a(r6);
        int r1 = ai.a(r7);
        BiEntry<K, V> r2 = seekByValue(r6, r0);
        BiEntry<K, V> r3 = seekByKey(r7, r1);
        if (r2 != null) goto L5;
    L9:
        if (r3 == null) goto L14;
        if (r8 == true) goto L14;
        throw new IllegalArgumentException("key already present: " + r7);
    L14:
        if (r2 == null) goto L16;
        delete(r2);
    L16:
        if (r3 == null) goto L18;
        delete(r3);
    L18:
        insert(new BiEntry(r7, r1, r6, r0), r3);
        if (r3 == null) goto L21;
        r3.prevInKeyInsertionOrder = null;
        r3.nextInKeyInsertionOrder = null;
    L21:
        if (r2 == null) goto L23;
        r2.prevInKeyInsertionOrder = null;
        r2.nextInKeyInsertionOrder = null;
    L23:
        rehashIfNecessary();
        return (K) Maps.b(r2);
    L5:
        if (r1 != r2.keyHash) goto L9;
        if (com.google.common.base.k.a(r7, r2.key) == false) goto L9;
        return r7;
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        int r0 = av.a(r3);
        init(16);
        av.a(this, r3, r0);
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] r0 = this.hashTableKToV;
        if (ai.a(this.size, r0.length, LOAD_FACTOR) == false) goto L10;
        int r1 = r0.length * 2;
        this.hashTableKToV = createTable(r1);
        this.hashTableVToK = createTable(r1);
        this.mask = r1 - 1;
        this.size = 0;
        BiEntry<K, V> r2 = this.firstInKeyInsertionOrder;
    L5:
        if (r2 == null) goto L7;
        insert(r2, r2);
        r2 = r2.nextInKeyInsertionOrder;
        goto L5
    L7:
        this.modCount++;
        return;
    }

    private BiEntry<K, V> seekByKey(Object r2, int r3) {
        BiEntry<K, V> r1 = this.hashTableKToV[this.mask & r3];
    L3:
        if (r1 == null) goto L10;
        if (r3 != r1.keyHash) goto L9;
        if (com.google.common.base.k.a(r2, r1.key) == false) goto L9;
        return r1;
    L9:
        r1 = r1.nextInKToVBucket;
        goto L3
    L10:
        return null;
    }

    private BiEntry<K, V> seekByValue(Object r2, int r3) {
        BiEntry<K, V> r1 = this.hashTableVToK[this.mask & r3];
    L3:
        if (r1 == null) goto L10;
        if (r3 != r1.valueHash) goto L9;
        if (com.google.common.base.k.a(r2, r1.value) == false) goto L9;
        return r1;
    L9:
        r1 = r1.nextInVToKBucket;
        goto L3
    L10:
        return null;
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        av.a(this, r1);
    }

    @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, null);
        Arrays.fill(this.hashTableVToK, null);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r2) {
        if (seekByKey(r2, ai.a(r2)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r2) {
        if (seekByValue(r2, ai.a(r2)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.Maps.d
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r3) {
        BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        BiEntry<K, V> r2 = this.firstInKeyInsertionOrder;
    L3:
        if (r2 == null) goto L5;
        r4.accept(r2.key, r2.value);
        r2 = r2.nextInKeyInsertionOrder;
        goto L3
    }

    @Override // com.google.common.collect.k
    public V forcePut(K r2, V r3) {
        return put(r2, r3, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        return (V) Maps.c(seekByKey(r2, ai.a(r2)));
    }

    @Override // com.google.common.collect.k
    public k<V, K> inverse() {
        k<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        Inverse r1 = new Inverse(this, null);
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new b(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r2, V r3) {
        return put(r2, r3, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r2) {
        BiEntry<K, V> r3 = seekByKey(r2, ai.a(r2));
        if (r3 != null) goto L5;
        return null;
    L5:
        delete(r3);
        r3.prevInKeyInsertionOrder = null;
        r3.nextInKeyInsertionOrder = null;
        return r3.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r5) {
        BiFunction r6 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r5, BiFunction.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        BiEntry<K, V> r0 = this.firstInKeyInsertionOrder;
        clear();
    L3:
        if (r0 == null) goto L5;
        put(r0.key, r6.apply(r0.key, r0.value));
        r0 = r0.nextInKeyInsertionOrder;
        goto L3
    }

    @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.k
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.k
    public Set<V> values() {
        return inverse().keySet();
    }
}

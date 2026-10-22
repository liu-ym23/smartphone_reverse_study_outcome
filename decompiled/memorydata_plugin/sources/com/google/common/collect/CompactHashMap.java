package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND = null;
    transient int[] entries;
    private transient Set<Map.Entry<K, V>> entrySetView;
    private transient Set<K> keySetView;
    transient Object[] keys;
    private transient int metadata;
    private transient int size;
    private transient Object table;
    transient Object[] values;
    private transient Collection<V> valuesView;

    class a extends Maps.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompactHashMap f4410a;

        a(CompactHashMap r1) {
            this.f4410a = r1;
        }

        private /* synthetic */ Map.Entry a(int r2) {
            return new d(this.f4410a, r2);
        }

        public static /* synthetic */ Map.Entry lambda$MoNBgIItNMY1mQdL8ApAw9n5Wg4(a r0, int r1) {
            return r0.a(r1);
        }

        @Override // com.google.common.collect.Maps.b
        Map<K, V> a() {
            return this.f4410a;
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            Map<K, V> r0 = this.f4410a.delegateOrNull();
            if (r0 == null) goto L7;
            return r0.entrySet().contains(r4);
        L7:
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L14;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            int r1 = CompactHashMap.access$700(this.f4410a, r5.getKey());
            if (r1 != (-1)) goto L11;
            return false;
        L11:
            if (com.google.common.base.k.a(CompactHashMap.access$800(this.f4410a, r1), r5.getValue()) == false) goto L16;
            return true;
        L16:
            return false;
        L14:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.f4410a.entrySetIterator();
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            Map<K, V> r0 = this.f4410a.delegateOrNull();
            if (r0 == null) goto L7;
            return r0.entrySet().remove(r10);
        L7:
            if (ZeusTransformUtils.instanceOf(r10, Map.Entry.class) == false) goto L16;
            Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.memorydata.plugin");
            if (this.f4410a.needsAllocArrays() == false) goto L11;
            return false;
        L11:
            int r1 = CompactHashMap.access$900(this.f4410a);
            int r12 = r.a(r11.getKey(), r11.getValue(), r1, CompactHashMap.access$1000(this.f4410a), CompactHashMap.access$1100(this.f4410a), CompactHashMap.access$200(this.f4410a), CompactHashMap.access$1200(this.f4410a));
            if (r12 != (-1)) goto L14;
            return false;
        L14:
            this.f4410a.moveLastEntry(r12, r1);
            CompactHashMap.access$310(this.f4410a);
            this.f4410a.incrementModCount();
            return true;
        L16:
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<K, V>> spliterator() {
            Map<K, V> r0 = this.f4410a.delegateOrNull();
            if (r0 == null) goto L6;
            return r0.entrySet().spliterator();
        L6:
            return p.a(CompactHashMap.access$300(this.f4410a), 17, new $$Lambda$CompactHashMap$a$MoNBgIItNMY1mQdL8ApAw9n5Wg4(this));
        }
    }

    private abstract class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4411b;
        int c;
        int d;
        final /* synthetic */ CompactHashMap e;

        private b(CompactHashMap r2) {
            this.e = r2;
            this.f4411b = CompactHashMap.access$000(r2);
            this.c = r2.firstEntryIndex();
            this.d = -1;
        }

        /* synthetic */ b(CompactHashMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void b() {
            if (CompactHashMap.access$000(this.e) != this.f4411b) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        abstract T a(int r1);

        void a() {
            this.f4411b += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            b();
            if (hasNext() == false) goto L7;
            int r0 = this.c;
            this.d = r0;
            T r1 = a(r0);
            this.c = this.e.getSuccessor(this.c);
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            b();
            if (this.d < 0) goto L5;
            boolean r0 = true;
        L6:
            o.a(r0);
            a();
            CompactHashMap r1 = this.e;
            r1.remove(CompactHashMap.access$100(r1, this.d));
            this.c = this.e.adjustAfterRemove(this.c, this.d);
            this.d = -1;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    class c extends Maps.e<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompactHashMap f4412a;

        c(CompactHashMap r1) {
            this.f4412a = r1;
            super(r1);
        }

        @Override // com.google.common.collect.Maps.e, java.lang.Iterable
        public void forEach(Consumer<? super K> r3) {
            Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            Map<K, V> r0 = this.f4412a.delegateOrNull();
            if (r0 == null) goto L5;
            r0.keySet().forEach(r4);
            return;
        L5:
            int r1 = this.f4412a.firstEntryIndex();
        L6:
            if (r1 < 0) goto L10;
            r4.accept(CompactHashMap.access$100(this.f4412a, r1));
            r1 = this.f4412a.getSuccessor(r1);
            goto L6
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return this.f4412a.keySetIterator();
        }

        @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            Map<K, V> r0 = this.f4412a.delegateOrNull();
            if (r0 == null) goto L6;
            return r0.keySet().remove(r2);
        L6:
            if (CompactHashMap.access$400(this.f4412a, r2) == CompactHashMap.access$500()) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            if (this.f4412a.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.f4412a.delegateOrNull();
            if (r0 == null) goto L10;
            return r0.keySet().spliterator();
        L10:
            return Spliterators.spliterator(CompactHashMap.access$200(this.f4412a), 0, CompactHashMap.access$300(this.f4412a), 17);
        L5:
            return Spliterators.spliterator(new Object[0], 17);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            if (this.f4412a.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.f4412a.delegateOrNull();
            if (r0 == null) goto L10;
            return r0.keySet().toArray();
        L10:
            return ap.a(CompactHashMap.access$200(this.f4412a), 0, CompactHashMap.access$300(this.f4412a));
        L5:
            return new Object[0];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r3) {
            if (this.f4412a.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.f4412a.delegateOrNull();
            if (r0 == null) goto L12;
            return (T[]) r0.keySet().toArray(r3);
        L12:
            return (T[]) ap.a(CompactHashMap.access$200(this.f4412a), 0, CompactHashMap.access$300(this.f4412a), r3);
        L5:
            if (r3.length <= 0) goto L7;
            r3[0] = null;
        L7:
            return r3;
        }
    }

    final class d extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompactHashMap f4413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final K f4414b;
        private int c;

        d(CompactHashMap r1, int r2) {
            this.f4413a = r1;
            this.f4414b = (K) CompactHashMap.access$100(r1, r2);
            this.c = r2;
        }

        private void a() {
            int r0 = this.c;
            if (r0 != (-1)) goto L5;
        L8:
            this.c = CompactHashMap.access$700(this.f4413a, this.f4414b);
            return;
        L5:
            if (r0 >= this.f4413a.size()) goto L8;
            if (com.google.common.base.k.a(this.f4414b, CompactHashMap.access$100(this.f4413a, this.c)) == false) goto L8;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f4414b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            Map<K, V> r0 = this.f4413a.delegateOrNull();
            if (r0 != null) goto L5;
            a();
            int r1 = this.c;
            if (r1 != (-1)) goto L10;
            return (V) ao.a();
        L10:
            return (V) CompactHashMap.access$800(this.f4413a, r1);
        L5:
            return (V) ao.a(r0.get(this.f4414b));
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V r3) {
            Map<K, V> r0 = this.f4413a.delegateOrNull();
            if (r0 != null) goto L5;
            a();
            int r1 = this.c;
            if (r1 != (-1)) goto L10;
            this.f4413a.put(this.f4414b, r3);
            return (V) ao.a();
        L10:
            V r2 = (V) CompactHashMap.access$800(this.f4413a, r1);
            CompactHashMap.access$1300(this.f4413a, this.c, r3);
            return r2;
        L5:
            return (V) ao.a(r0.put(this.f4414b, r3));
        }
    }

    class e extends Maps.l<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompactHashMap f4415a;

        e(CompactHashMap r1) {
            this.f4415a = r1;
            super(r1);
        }

        @Override // com.google.common.collect.Maps.l, java.lang.Iterable
        public void forEach(Consumer<? super V> r3) {
            Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            Map<K, V> r0 = this.f4415a.delegateOrNull();
            if (r0 == null) goto L5;
            r0.values().forEach(r4);
            return;
        L5:
            int r1 = this.f4415a.firstEntryIndex();
        L6:
            if (r1 < 0) goto L10;
            r4.accept(CompactHashMap.access$800(this.f4415a, r1));
            r1 = this.f4415a.getSuccessor(r1);
            goto L6
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.f4415a.valuesIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            if (this.f4415a.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.f4415a.delegateOrNull();
            if (r0 == null) goto L10;
            return r0.values().spliterator();
        L10:
            return Spliterators.spliterator(CompactHashMap.access$1200(this.f4415a), 0, CompactHashMap.access$300(this.f4415a), 16);
        L5:
            return Spliterators.spliterator(new Object[0], 16);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            if (this.f4415a.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.f4415a.delegateOrNull();
            if (r0 == null) goto L10;
            return r0.values().toArray();
        L10:
            return ap.a(CompactHashMap.access$1200(this.f4415a), 0, CompactHashMap.access$300(this.f4415a));
        L5:
            return new Object[0];
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r3) {
            if (this.f4415a.needsAllocArrays() == true) goto L5;
            Map<K, V> r0 = this.f4415a.delegateOrNull();
            if (r0 == null) goto L12;
            return (T[]) r0.values().toArray(r3);
        L12:
            return (T[]) ap.a(CompactHashMap.access$1200(this.f4415a), 0, CompactHashMap.access$300(this.f4415a), r3);
        L5:
            if (r3.length <= 0) goto L7;
            r3[0] = null;
        L7:
            return r3;
        }
    }

    static {
        NOT_FOUND = new Object();
    }

    CompactHashMap() {
        init(3);
    }

    CompactHashMap(int r1) {
        init(r1);
    }

    static /* synthetic */ int access$000(CompactHashMap r0) {
        return r0.metadata;
    }

    static /* synthetic */ Object access$100(CompactHashMap r0, int r1) {
        return r0.key(r1);
    }

    static /* synthetic */ Object access$1000(CompactHashMap r0) {
        return r0.requireTable();
    }

    static /* synthetic */ int[] access$1100(CompactHashMap r0) {
        return r0.requireEntries();
    }

    static /* synthetic */ Object[] access$1200(CompactHashMap r0) {
        return r0.requireValues();
    }

    static /* synthetic */ void access$1300(CompactHashMap r0, int r1, Object r2) {
        r0.setValue(r1, r2);
    }

    static /* synthetic */ Object[] access$200(CompactHashMap r0) {
        return r0.requireKeys();
    }

    static /* synthetic */ int access$300(CompactHashMap r0) {
        return r0.size;
    }

    static /* synthetic */ int access$310(CompactHashMap r2) {
        int r0 = r2.size;
        r2.size = r0 - 1;
        return r0;
    }

    static /* synthetic */ Object access$400(CompactHashMap r0, Object r1) {
        return r0.removeHelper(r1);
    }

    static /* synthetic */ Object access$500() {
        return NOT_FOUND;
    }

    static /* synthetic */ int access$700(CompactHashMap r0, Object r1) {
        return r0.indexOf(r1);
    }

    static /* synthetic */ Object access$800(CompactHashMap r0, int r1) {
        return r0.value(r1);
    }

    static /* synthetic */ int access$900(CompactHashMap r0) {
        return r0.hashTableMask();
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int r1) {
        return new CompactHashMap(r1);
    }

    private int entry(int r1) {
        return requireEntries()[r1];
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    private int indexOf(Object r7) {
        if (needsAllocArrays() == false) goto L5;
        return -1;
    L5:
        int r0 = ai.a(r7);
        int r2 = hashTableMask();
        int r3 = r.a(requireTable(), r0 & r2);
        if (r3 != 0) goto L8;
        return -1;
    L8:
        int r1 = r.a(r0, r2);
    L9:
        int r4 = r3 - 1;
        int r5 = entry(r4);
        if (r.a(r5, r2) == r1) goto L12;
    L14:
        r3 = r.b(r5, r2);
        if (r3 != 0) goto L9;
        return -1;
    L12:
        if (com.google.common.base.k.a(r7, key(r4)) == false) goto L14;
        return r4;
    }

    private K key(int r1) {
        return (K) requireKeys()[r1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r5) {
        r5.defaultReadObject();
        int r0 = r5.readInt();
        if (r0 < 0) goto L9;
        init(r0);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        put(r5.readObject(), r5.readObject());
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException("Invalid size: " + r0);
    }

    private Object removeHelper(Object r9) {
        if (needsAllocArrays() == true) goto L5;
        int r7 = hashTableMask();
        int r10 = r.a(r9, null, r7, requireTable(), requireEntries(), requireKeys(), null);
        if (r10 == (-1)) goto L9;
        V r0 = value(r10);
        moveLastEntry(r10, r7);
        this.size--;
        incrementModCount();
        return r0;
    L9:
        return NOT_FOUND;
    L5:
        return NOT_FOUND;
    }

    private int[] requireEntries() {
        return (int[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.entries), int[].class, "com.obric.memorydata.plugin");
    }

    private Object[] requireKeys() {
        return (Object[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.keys), Object[].class, "com.obric.memorydata.plugin");
    }

    private Object requireTable() {
        return Objects.requireNonNull(this.table);
    }

    private Object[] requireValues() {
        return (Object[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.values), Object[].class, "com.obric.memorydata.plugin");
    }

    private void resizeMeMaybe(int r4) {
        int r0 = requireEntries().length;
        if (r4 <= r0) goto L8;
        int r5 = Math.min(1073741823, (Math.max(1, r0 >>> 1) + r0) | 1);
        if (r5 == r0) goto L9;
        resizeEntries(r5);
        return;
    L9:
        return;
    }

    private int resizeTable(int r9, int r10, int r11, int r12) {
        Object r0 = r.b(r10);
        int r13 = r10 - 1;
        if (r12 == 0) goto L5;
        r.a(r0, r11 & r13, r12 + 1);
    L5:
        Object r14 = requireTable();
        int[] r15 = requireEntries();
        int r1 = 0;
    L6:
        if (r1 > r9) goto L11;
        int r2 = r.a(r14, r1);
    L8:
        if (r2 == 0) goto L10;
        int r3 = r2 - 1;
        int r4 = r15[r3];
        int r5 = r.a(r4, r9) | r1;
        int r6 = r5 & r13;
        int r7 = r.a(r0, r6);
        r.a(r0, r6, r2);
        r15[r3] = r.a(r5, r7, r13);
        r2 = r.b(r4, r9);
        goto L8
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        this.table = r0;
        setHashTableMask(r13);
        return r13;
    }

    private void setEntry(int r1, int r2) {
        requireEntries()[r1] = r2;
    }

    private void setHashTableMask(int r3) {
        int r4 = 32 - Integer.numberOfLeadingZeros(r3);
        this.metadata = r.a(this.metadata, r4, 31);
    }

    private void setKey(int r1, K r2) {
        requireKeys()[r1] = r2;
    }

    private void setValue(int r1, V r2) {
        requireValues()[r1] = r2;
    }

    private V value(int r1) {
        return (V) requireValues()[r1];
    }

    private void writeObject(ObjectOutputStream r4) {
        r4.defaultWriteObject();
        r4.writeInt(size());
        Iterator<Map.Entry<K, V>> r3 = entrySetIterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getKey());
        r4.writeObject(r0.getValue());
        goto L4
    }

    void accessEntry(int r1) {
    }

    int adjustAfterRemove(int r1, int r2) {
        return r1 - 1;
    }

    int allocArrays() {
        com.google.common.base.n.b(needsAllocArrays(), "Arrays already allocated");
        int r0 = this.metadata;
        int r1 = r.a(r0);
        this.table = r.b(r1);
        setHashTableMask(r1 - 1);
        this.entries = new int[r0];
        this.keys = new Object[r0];
        this.values = new Object[r0];
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        incrementModCount();
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L8;
        this.metadata = Ints.a(size(), 3, 1073741823);
        r0.clear();
        this.table = null;
    L9:
        this.size = 0;
        return;
    L8:
        Arrays.fill(requireKeys(), 0, this.size, null);
        Arrays.fill(requireValues(), 0, this.size, null);
        r.a(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        goto L9
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r2) {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L6;
        return r0.containsKey(r2);
    L6:
        if (indexOf(r2) == (-1)) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r4) {
        Map<K, V> r0 = delegateOrNull();
        if (r0 != null) goto L5;
        int r1 = 0;
    L8:
        if (r1 >= this.size) goto L14;
        if (com.google.common.base.k.a(r4, value(r1)) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    L5:
        return r0.containsValue(r4);
    }

    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> r0 = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int r1 = firstEntryIndex();
    L3:
        if (r1 < 0) goto L5;
        r0.put(key(r1), value(r1));
        r1 = getSuccessor(r1);
        goto L3
    L5:
        this.table = r0;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return r0;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new a(this);
    }

    Map<K, V> createHashFloodingResistantDelegate(int r2) {
        return new LinkedHashMap(r2, 1.0f);
    }

    Set<K> createKeySet() {
        return new c(this);
    }

    Collection<V> createValues() {
        return new e(this);
    }

    Map<K, V> delegateOrNull() {
        if (ZeusTransformUtils.instanceOf(this.table, Map.class) == true) goto L5;
        return null;
    L5:
        return (Map) ZeusTransformUtils.preCheckCast(this.table, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r0 = this.entrySetView;
        if (r0 != null) goto L6;
        Set<Map.Entry<K, V>> r1 = createEntrySet();
        this.entrySetView = r1;
        return r1;
    L6:
        return r0;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L7;
        return r0.entrySet().iterator();
    L7:
        return new AnonymousClass2(this);
    }

    int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r4) {
        BiConsumer<? super K, ? super V> r5 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r4, BiConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L5;
        r0.forEach(r5);
        return;
    L5:
        int r1 = firstEntryIndex();
    L6:
        if (r1 < 0) goto L10;
        r5.accept(key(r1), value(r1));
        r1 = getSuccessor(r1);
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        Map<K, V> r0 = delegateOrNull();
        if (r0 != null) goto L5;
        int r3 = indexOf(r2);
        if (r3 != (-1)) goto L10;
        return null;
    L10:
        accessEntry(r3);
        return value(r3);
    L5:
        return r0.get(r2);
    }

    int getSuccessor(int r1) {
        int r2 = r1 + 1;
        if (r2 < this.size) goto L7;
        return -1;
    L7:
        return r2;
    }

    void incrementModCount() {
        this.metadata += 32;
    }

    void init(int r4) {
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        com.google.common.base.n.a(r1, "Expected size must be >= 0");
        this.metadata = Ints.a(r4, 1, 1073741823);
        return;
    L5:
        r1 = false;
        goto L6
    }

    void insertEntry(int r2, K r3, V r4, int r5, int r6) {
        setEntry(r2, r.a(r5, 0, r6));
        setKey(r2, r3);
        setValue(r2, r4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r0 = this.keySetView;
        if (r0 != null) goto L6;
        Set<K> r1 = createKeySet();
        this.keySetView = r1;
        return r1;
    L6:
        return r0;
    }

    Iterator<K> keySetIterator() {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L7;
        return r0.keySet().iterator();
    L7:
        return new AnonymousClass1(this);
    }

    void moveLastEntry(int r9, int r10) {
        Object r0 = requireTable();
        int[] r1 = requireEntries();
        Object[] r2 = requireKeys();
        Object[] r3 = requireValues();
        int r8 = size() - 1;
        if (r9 >= r8) goto L11;
        Object r6 = r2[r8];
        r2[r9] = r6;
        r3[r9] = r3[r8];
        r2[r8] = null;
        r3[r8] = null;
        r1[r9] = r1[r8];
        r1[r8] = 0;
        int r4 = ai.a(r6) & r10;
        int r5 = r.a(r0, r4);
        int r11 = r8 + 1;
        if (r5 != r11) goto L7;
        r.a(r0, r4, r9 + 1);
        return;
    L7:
        int r7 = r5 - 1;
        int r12 = r1[r7];
        int r13 = r.b(r12, r10);
        if (r13 == r11) goto L9;
        r5 = r13;
        goto L7
    L9:
        r1[r7] = r.a(r12, r9 + 1, r10);
        return;
    L11:
        r2[r9] = null;
        r3[r9] = null;
        r1[r9] = 0;
    }

    boolean needsAllocArrays() {
        if (this.table != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r13, V r14) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        Map<K, V> r0 = delegateOrNull();
        if (r0 != null) goto L8;
        int[] r1 = requireEntries();
        Object[] r2 = requireKeys();
        Object[] r3 = requireValues();
        int r4 = this.size;
        int r9 = r4 + 1;
        int r7 = ai.a(r13);
        int r5 = hashTableMask();
        int r6 = r7 & r5;
        int r8 = r.a(requireTable(), r6);
        if (r8 != 0) goto L14;
        if (r9 <= r5) goto L13;
    L12:
        int r10 = resizeTable(r5, r.c(r5), r7, r4);
    L31:
        resizeMeMaybe(r9);
        insertEntry(r4, r13, r14, r7, r10);
        this.size = r9;
        incrementModCount();
        return null;
    L13:
        r.a(requireTable(), r6, r9);
    L30:
        r10 = r5;
        goto L31
    L14:
        int r11 = r.a(r7, r5);
        int r12 = 0;
    L15:
        int r15 = r8 - 1;
        int r16 = r1[r15];
        if (r.a(r16, r5) == r11) goto L18;
    L21:
        int r17 = r.b(r16, r5);
        r12 = r12 + 1;
        if (r17 == 0) goto L24;
        r8 = r17;
        goto L15
    L24:
        if (r12 >= 9) goto L26;
        if (r9 > r5) goto L12;
        r1[r15] = r.a(r16, r9, r5);
        goto L30
    L26:
        return convertToHashFloodingResistantImplementation().put(r13, r14);
    L18:
        if (com.google.common.base.k.a(r13, r2[r15]) == false) goto L21;
        V r18 = (V) r3[r15];
        r3[r15] = r14;
        accessEntry(r15);
        return r18;
    L8:
        return r0.put(r13, r14);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r2) {
        Map<K, V> r0 = delegateOrNull();
        if (r0 != null) goto L5;
        V r1 = (V) removeHelper(r2);
        if (r1 != NOT_FOUND) goto L10;
        return null;
    L10:
        return r1;
    L5:
        return r0.remove(r2);
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r4) {
        BiFunction<? super K, ? super V, ? extends V> r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r4, BiFunction.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L5;
        r0.replaceAll(r5);
        return;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.size) goto L11;
        setValue(r1, r5.apply(key(r1), value(r1)));
        r1 = r1 + 1;
        goto L7
    }

    void resizeEntries(int r2) {
        this.entries = Arrays.copyOf(requireEntries(), r2);
        this.keys = Arrays.copyOf(requireKeys(), r2);
        this.values = Arrays.copyOf(requireValues(), r2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L6;
        return r0.size();
    L6:
        return this.size;
    }

    public void trimToSize() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L9;
        Map<K, V> r1 = createHashFloodingResistantDelegate(size());
        r1.putAll(r0);
        this.table = r1;
        return;
    L9:
        int r2 = this.size;
        if (r2 >= requireEntries().length) goto L12;
        resizeEntries(r2);
    L12:
        int r3 = r.a(r2);
        int r4 = hashTableMask();
        if (r3 >= r4) goto L16;
        resizeTable(r4, r3, 0, 0);
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r0 = this.valuesView;
        if (r0 != null) goto L6;
        Collection<V> r1 = createValues();
        this.valuesView = r1;
        return r1;
    L6:
        return r0;
    }

    Iterator<V> valuesIterator() {
        Map<K, V> r0 = delegateOrNull();
        if (r0 == null) goto L7;
        return r0.values().iterator();
    L7:
        return new AnonymousClass3(this);
    }
}

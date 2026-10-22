package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    class a implements Comparator<Comparable> {
        a() {
        }

        public int a(Comparable r10, Comparable r11) {
            return r10.compareTo(r11);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Comparable r10, Comparable r11) {
            return a(r10, r11);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinkedTreeMap f4215c;

        class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            a(b r10) {
                super(r10.f4215c);
            }

            public Map.Entry<K, V> b() {
                return a();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return b();
            }
        }

        b(LinkedTreeMap r10) {
            this.f4215c = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4215c.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            if ((r10 instanceof Map.Entry) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f4215c.findByEntry((Map.Entry) r10) == null) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if ((r10 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            e<K, V> r11 = this.f4215c.findByEntry((Map.Entry) r10);
            if (r11 != null) goto L8;
            return false;
        L8:
            this.f4215c.removeInternal(r11, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4215c.size;
        }
    }

    final class c extends AbstractSet<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinkedTreeMap f4216c;

        class a extends LinkedTreeMap<K, V>.d<K> {
            a(c r10) {
                super(r10.f4216c);
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f4226k;
            }
        }

        c(LinkedTreeMap r10) {
            this.f4216c = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4216c.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return this.f4216c.containsKey(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (this.f4216c.removeInternalByKey(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4216c.size;
        }
    }

    private abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e<K, V> f4217c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        e<K, V> f4218g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f4219h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ LinkedTreeMap f4220i;

        d(LinkedTreeMap r10) {
            this.f4220i = r10;
            this.f4217c = r10.header.f4224i;
            this.f4218g = null;
            this.f4219h = r10.modCount;
        }

        final e<K, V> a() {
            e<K, V> r10 = this.f4217c;
            LinkedTreeMap r11 = this.f4220i;
            if (r10 == r11.header) goto L11;
            if (r11.modCount != this.f4219h) goto L9;
            this.f4217c = r10.f4224i;
            this.f4218g = r10;
            return r10;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f4217c == this.f4220i.header) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> r10 = this.f4218g;
            if (r10 == null) goto L7;
            this.f4220i.removeInternal(r10, true);
            this.f4218g = null;
            this.f4219h = this.f4220i.modCount;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e<K, V> f4221c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        e<K, V> f4222g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        e<K, V> f4223h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        e<K, V> f4224i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        e<K, V> f4225j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final K f4226k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final boolean f4227l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        V f4228m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f4229n;

        e(boolean r10) {
            this.f4226k = null;
            this.f4227l = r10;
            this.f4225j = this;
            this.f4224i = this;
        }

        e(boolean r10, e<K, V> r11, K r12, e<K, V> r13, e<K, V> r14) {
            this.f4221c = r11;
            this.f4226k = r12;
            this.f4227l = r10;
            this.f4229n = 1;
            this.f4224i = r13;
            this.f4225j = r14;
            r14.f4224i = this;
            r13.f4225j = this;
        }

        public e<K, V> a() {
        L2:
            e<K, V> r10 = this;
            e<K, V> this = this.f4222g;
            if (this != null) goto L2;
            return r10;
        }

        public e<K, V> b() {
        L2:
            e<K, V> r10 = this;
            e<K, V> this = this.f4223h;
            if (this != null) goto L2;
            return r10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L20;
            Map.Entry r11 = (Map.Entry) r10;
            K r12 = this.f4226k;
            if (r12 != null) goto L10;
            if (r11.getKey() != null) goto L21;
        L11:
            V r13 = this.f4228m;
            if (r13 != null) goto L17;
            if (r11.getValue() != null) goto L23;
        L18:
            return true;
        L23:
            return false;
        L17:
            if (r13.equals(r11.getValue()) == true) goto L18;
            return false;
        L21:
            return false;
        L10:
            if (r12.equals(r11.getKey()) == true) goto L11;
            return false;
        L20:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4226k;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4228m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r10 = this.f4226k;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            V r13 = this.f4228m;
            if (r13 == null) goto L11;
            r11 = r13.hashCode();
        L11:
            return r12 ^ r11;
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            if (r10 == null) goto L4;
        L8:
            V r11 = this.f4228m;
            this.f4228m = r10;
            return r11;
        L4:
            if (this.f4227l == true) goto L8;
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.f4226k + "=" + this.f4228m;
        }
    }

    static {
        NATURAL_ORDER = new a();
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER, true);
    }

    public LinkedTreeMap(Comparator<? super K> r10, boolean r11) {
        this.size = 0;
        this.modCount = 0;
        if (r10 != null) goto L6;
        r10 = NATURAL_ORDER;
    L6:
        this.comparator = r10;
        this.allowNullValues = r11;
        this.header = new e(r11);
    }

    public LinkedTreeMap(boolean r10) {
        this(NATURAL_ORDER, r10);
    }

    private boolean equal(Object r10, Object r11) {
        return Objects.equals(r10, r11);
    }

    private void readObject(ObjectInputStream r10) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(e<K, V> r10, boolean r11) {
    L2:
        if (r10 == null) goto L52;
        e<K, V> r12 = r10.f4222g;
        e<K, V> r13 = r10.f4223h;
        int r14 = 0;
        if (r12 == null) goto L6;
        int r15 = r12.f4229n;
    L7:
        if (r13 == null) goto L9;
        int r16 = r13.f4229n;
    L10:
        int r17 = r15 - r16;
        if (r17 != (-2)) goto L28;
        e<K, V> r18 = r13.f4222g;
        e<K, V> r19 = r13.f4223h;
        if (r19 == null) goto L15;
        int r20 = r19.f4229n;
    L16:
        if (r18 == null) goto L18;
        r14 = r18.f4229n;
    L18:
        int r21 = r14 - r20;
        if (r21 == (-1)) goto L24;
        if (r21 != 0) goto L23;
        if (r11 == false) goto L24;
    L23:
        rotateRight(r13);
    L24:
        rotateLeft(r10);
        if (r11 == false) goto L51;
        return;
    L51:
        r10 = r10.f4221c;
        goto L2
    L15:
        r20 = 0;
        goto L16
    L28:
        if (r17 != 2) goto L44;
        e<K, V> r22 = r12.f4222g;
        e<K, V> r23 = r12.f4223h;
        if (r23 == null) goto L32;
        int r24 = r23.f4229n;
    L33:
        if (r22 == null) goto L35;
        r14 = r22.f4229n;
    L35:
        int r25 = r14 - r24;
        if (r25 == 1) goto L41;
        if (r25 != 0) goto L40;
        if (r11 == false) goto L41;
    L40:
        rotateLeft(r12);
    L41:
        rotateRight(r10);
        if (r11 == false) goto L51;
        return;
    L32:
        r24 = 0;
        goto L33
    L44:
        if (r17 != 0) goto L48;
        r10.f4229n = r15 + 1;
        if (r11 == false) goto L51;
        return;
    L48:
        r10.f4229n = Math.max(r15, r16) + 1;
        if (r11 == true) goto L51;
        return;
    L9:
        r16 = 0;
        goto L10
    L6:
        r15 = 0;
        goto L7
    }

    private void replaceInParent(e<K, V> r10, e<K, V> r11) {
        e<K, V> r12 = r10.f4221c;
        r10.f4221c = null;
        if (r11 == null) goto L5;
        r11.f4221c = r12;
    L5:
        if (r12 != null) goto L7;
        this.root = r11;
        return;
    L7:
        if (r12.f4222g != r10) goto L9;
        r12.f4222g = r11;
        return;
    L9:
        r12.f4223h = r11;
    }

    private void rotateLeft(e<K, V> r10) {
        e<K, V> r11 = r10.f4222g;
        e<K, V> r12 = r10.f4223h;
        e<K, V> r13 = r12.f4222g;
        e<K, V> r14 = r12.f4223h;
        r10.f4223h = r13;
        if (r13 == null) goto L5;
        r13.f4221c = r10;
    L5:
        replaceInParent(r10, r12);
        r12.f4222g = r10;
        r10.f4221c = r12;
        int r15 = 0;
        if (r11 == null) goto L8;
        int r16 = r11.f4229n;
    L9:
        if (r13 == null) goto L11;
        int r17 = r13.f4229n;
    L12:
        int r18 = Math.max(r16, r17) + 1;
        r10.f4229n = r18;
        if (r14 == null) goto L15;
        r15 = r14.f4229n;
    L15:
        r12.f4229n = Math.max(r18, r15) + 1;
        return;
    L11:
        r17 = 0;
        goto L12
    L8:
        r16 = 0;
        goto L9
    }

    private void rotateRight(e<K, V> r10) {
        e<K, V> r11 = r10.f4222g;
        e<K, V> r12 = r10.f4223h;
        e<K, V> r13 = r11.f4222g;
        e<K, V> r14 = r11.f4223h;
        r10.f4222g = r14;
        if (r14 == null) goto L5;
        r14.f4221c = r10;
    L5:
        replaceInParent(r10, r11);
        r11.f4223h = r10;
        r10.f4221c = r11;
        int r15 = 0;
        if (r12 == null) goto L8;
        int r16 = r12.f4229n;
    L9:
        if (r14 == null) goto L11;
        int r17 = r14.f4229n;
    L12:
        int r18 = Math.max(r16, r17) + 1;
        r10.f4229n = r18;
        if (r13 == null) goto L15;
        r15 = r13.f4229n;
    L15:
        r11.f4229n = Math.max(r18, r15) + 1;
        return;
    L11:
        r17 = 0;
        goto L12
    L8:
        r16 = 0;
        goto L9
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> r10 = this.header;
        r10.f4225j = r10;
        r10.f4224i = r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r10) {
        if (findByObject(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b r10 = this.entrySet;
        if (r10 != null) goto L7;
        LinkedTreeMap<K, V>.b r11 = new b(this);
        this.entrySet = r11;
        return r11;
    L7:
        return r10;
    }

    e<K, V> find(K r12, boolean r13) {
        Comparator<? super K> r10 = this.comparator;
        e<K, V> r11 = this.root;
        if (r11 != null) goto L5;
        int r14 = 0;
    L21:
        if (r13 == true) goto L23;
        return null;
    L23:
        e<K, V> r15 = this.header;
        if (r11 == null) goto L26;
        e<K, V> r16 = new e(this.allowNullValues, r11, r12, r15, r15.f4225j);
        if (r14 >= 0) goto L36;
        r11.f4222g = r16;
    L37:
        rebalance(r11, true);
    L38:
        this.size++;
        this.modCount++;
        return r16;
    L36:
        r11.f4223h = r16;
        goto L37
    L26:
        if (r10 == NATURAL_ORDER) goto L28;
    L32:
        r16 = new e(this.allowNullValues, r11, r12, r15, r15.f4225j);
        this.root = r16;
        goto L38
    L28:
        if ((r12 instanceof Comparable) == true) goto L32;
        throw new ClassCastException(r12.getClass().getName() + " is not Comparable");
    L5:
        if (r10 != NATURAL_ORDER) goto L7;
        Comparable r17 = (Comparable) r12;
    L8:
        K r18 = r11.f4226k;
        if (r17 == null) goto L11;
        r14 = r17.compareTo(r18);
    L12:
        if (r14 == 0) goto L13;
        if (r14 >= 0) goto L16;
        e<K, V> r19 = r11.f4222g;
    L17:
        if (r19 == null) goto L21;
        r11 = r19;
        goto L8
    L16:
        r19 = r11.f4223h;
        goto L17
    L13:
        return r11;
    L11:
        r14 = r10.compare(r12, r18);
        goto L12
    L7:
        r17 = null;
        goto L8
    }

    e<K, V> findByEntry(Map.Entry<?, ?> r10) {
        e<K, V> r11 = findByObject(r10.getKey());
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == true) goto L12;
        return null;
    L12:
        return r11;
    L5:
        if (equal(r11.f4228m, r10.getValue()) == false) goto L7;
        r12 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> findByObject(Object r10) {
        if (r10 != 0) goto L8;
        return null;
    L8:
        return find(r10, false);
    L11:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r10) {
        e<K, V> r11 = findByObject(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.f4228m;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c r10 = this.keySet;
        if (r10 != null) goto L7;
        LinkedTreeMap<K, V>.c r11 = new c(this);
        this.keySet = r11;
        return r11;
    L7:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r10, V r11) {
        Objects.requireNonNull(r10, "key == null");
        if (r11 == null) goto L5;
    L9:
        e<K, V> r12 = find(r10, true);
        V r13 = r12.f4228m;
        r12.f4228m = r11;
        return r13;
    L5:
        if (this.allowNullValues == true) goto L9;
        throw new NullPointerException("value == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r10) {
        e<K, V> r11 = removeInternalByKey(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.f4228m;
    }

    void removeInternal(e<K, V> r10, boolean r11) {
        if (r11 == false) goto L4;
        e<K, V> r12 = r10.f4225j;
        r12.f4224i = r10.f4224i;
        r10.f4224i.f4225j = r12;
    L4:
        e<K, V> r13 = r10.f4222g;
        e<K, V> r14 = r10.f4223h;
        e<K, V> r15 = r10.f4221c;
        int r16 = 0;
        if (r13 == null) goto L20;
        if (r14 == null) goto L20;
        if (r13.f4229n <= r14.f4229n) goto L10;
        e<K, V> r17 = r13.b();
    L11:
        removeInternal(r17, false);
        e<K, V> r18 = r10.f4222g;
        if (r18 == null) goto L14;
        int r19 = r18.f4229n;
        r17.f4222g = r18;
        r18.f4221c = r17;
        r10.f4222g = null;
    L15:
        e<K, V> r20 = r10.f4223h;
        if (r20 == null) goto L18;
        r16 = r20.f4229n;
        r17.f4223h = r20;
        r20.f4221c = r17;
        r10.f4223h = null;
    L18:
        r17.f4229n = Math.max(r19, r16) + 1;
        replaceInParent(r10, r17);
        return;
    L14:
        r19 = 0;
        goto L15
    L10:
        r17 = r14.a();
    L20:
        if (r13 == null) goto L22;
        replaceInParent(r10, r13);
        r10.f4222g = null;
    L25:
        rebalance(r15, false);
        this.size--;
        this.modCount++;
        return;
    L22:
        if (r14 == null) goto L24;
        replaceInParent(r10, r14);
        r10.f4223h = null;
        goto L25
    L24:
        replaceInParent(r10, null);
        goto L25
    }

    e<K, V> removeInternalByKey(Object r10) {
        e<K, V> r11 = findByObject(r10);
        if (r11 == null) goto L5;
        removeInternal(r11, true);
    L5:
        return r11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }
}

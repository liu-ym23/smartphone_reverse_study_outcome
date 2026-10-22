package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
public final class HashBiMap<K, V> extends h7 implements c1, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient BiEntry[] f8810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient BiEntry[] f8811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient BiEntry f8812c;
    public transient BiEntry d;
    public transient int e;
    public transient int f;
    public transient int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient c1 f8813h;

    public static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;
        BiEntry<K, V> nextInKToVBucket;
        BiEntry<K, V> nextInKeyInsertionOrder;
        BiEntry<K, V> nextInVToKBucket;
        BiEntry<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        public BiEntry(K r5, int r10, V r11, int r12) {
            super(r5, r11);
            this.keyHash = r10;
            this.valueHash = r12;
        }
    }

    public final class Inverse extends h7 implements c1, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f8814a = 0;
        final /* synthetic */ HashBiMap this$0;

        public Inverse(HashBiMap r5, g3 r10) {
            this.this$0 = r5;
        }

        @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
        public void clear() {
            forward().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r5) {
            return forward().containsValue(r5);
        }

        @Override // com.google.common.collect.h7
        public Iterator<Map.Entry<V, K>> entryIterator() {
            return new j3(this);
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super V, ? super K> r5) {
            r5.getClass();
            this.this$0.forEach(new h3(r5, 0));
        }

        @Override // com.google.common.collect.c1
        public K forcePut(V r5, K r10) {
            return (K) HashBiMap.access$800(this.this$0, r5, r10, true);
        }

        public c1 forward() {
            return this.this$0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object r5) {
            return (K) p7.P(HashBiMap.access$400(this.this$0, r5, p7.o0(r5)));
        }

        @Override // com.google.common.collect.c1
        public c1 inverse() {
            return forward();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new l3(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V r5, K r10) {
            return (K) HashBiMap.access$800(this.this$0, r5, r10, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object r5) {
            BiEntry r10 = HashBiMap.access$400(this.this$0, r5, p7.o0(r5));
            if (r10 != null) goto L5;
            return null;
        L5:
            HashBiMap.access$200(this.this$0, r10);
            r10.prevInKeyInsertionOrder = null;
            r10.nextInKeyInsertionOrder = null;
            return r10.key;
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super V, ? super K, ? extends K> r5) {
            r5.getClass();
            BiEntry<K, V> r10 = HashBiMap.access$000(this.this$0);
            clear();
        L3:
            if (r10 == null) goto L5;
            V r11 = r10.value;
            put(r11, r5.apply(r11, r10.key));
            r10 = r10.nextInKeyInsertionOrder;
            goto L3
        }

        @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.access$700(this.this$0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        public Object writeReplace() {
            return new InverseSerializedForm(this.this$0);
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.c1
        public Set<K> values() {
            return forward().keySet();
        }
    }

    public static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        public InverseSerializedForm(HashBiMap<K, V> r5) {
            this.bimap = r5;
        }

        public Object readResolve() {
            return this.bimap.inverse();
        }
    }

    public static /* synthetic */ BiEntry access$000(HashBiMap r5) {
        return r5.f8812c;
    }

    public static /* synthetic */ int access$100(HashBiMap r5) {
        return r5.g;
    }

    public static /* synthetic */ void access$200(HashBiMap r5, BiEntry r10) {
        r5.a(r10);
    }

    public static /* synthetic */ BiEntry access$300(HashBiMap r5, Object r10, int r11) {
        return r5.f(r11, r10);
    }

    public static /* synthetic */ BiEntry access$400(HashBiMap r5, Object r10, int r11) {
        return r5.g(r11, r10);
    }

    public static /* synthetic */ void access$500(HashBiMap r5, BiEntry r10, BiEntry r11) {
        r5.c(r10, r11);
    }

    public static /* synthetic */ int access$700(HashBiMap r5) {
        return r5.e;
    }

    public static Object access$800(HashBiMap r5, Object r10, Object r11, boolean r12) {
        r5.getClass();
        int r13 = p7.o0(r10);
        int r14 = p7.o0(r11);
        BiEntry r15 = r5.g(r13, r10);
        BiEntry r16 = r5.f(r14, r11);
        if (r15 != null) goto L5;
    L9:
        if (r16 == null) goto L14;
        if (r12 == true) goto L14;
        String r17 = String.valueOf(r11);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.l(r17.length() + 21, "key already present: ", r17));
    L14:
        if (r15 == null) goto L16;
        r5.a(r15);
    L16:
        if (r16 == null) goto L18;
        r5.a(r16);
    L18:
        r5.c(new BiEntry(r11, r14, r10, r13), r16);
        if (r16 == null) goto L21;
        r16.prevInKeyInsertionOrder = null;
        r16.nextInKeyInsertionOrder = null;
    L21:
        if (r15 == null) goto L23;
        r15.prevInKeyInsertionOrder = null;
        r15.nextInKeyInsertionOrder = null;
    L23:
        r5.e();
        return p7.P(r15);
    L5:
        if (r14 != r15.keyHash) goto L9;
        if (com.google.common.base.b0.w(r11, r15.key) == false) goto L9;
        return r11;
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        int r10 = r5.readInt();
        b(16);
        p7.d0(this, r5, r10);
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        p7.y0(this, r5);
    }

    public final void a(BiEntry r10) {
        int r5 = r10.keyHash & this.f;
        BiEntry<K, V> r11 = this.f8810a[r5];
        BiEntry<K, V> r12 = null;
        BiEntry<K, V> r13 = null;
    L3:
        if (r11 == r10) goto L4;
        r13 = r11;
        r11 = r11.nextInKToVBucket;
        goto L3
    L4:
        if (r13 != null) goto L6;
        this.f8810a[r5] = r10.nextInKToVBucket;
    L7:
        int r14 = r10.valueHash & this.f;
        BiEntry<K, V> r15 = this.f8811b[r14];
    L8:
        BiEntry<K, V> r16 = r12;
        r12 = r15;
        if (r12 == r10) goto L10;
        r15 = r12.nextInVToKBucket;
        goto L8
    L10:
        if (r16 != null) goto L12;
        this.f8811b[r14] = r10.nextInVToKBucket;
    L13:
        BiEntry<K, V> r17 = r10.prevInKeyInsertionOrder;
        if (r17 != null) goto L16;
        this.f8812c = r10.nextInKeyInsertionOrder;
    L17:
        BiEntry<K, V> r18 = r10.nextInKeyInsertionOrder;
        if (r18 != null) goto L20;
        this.d = r17;
    L21:
        this.e--;
        this.g++;
        return;
    L20:
        r18.prevInKeyInsertionOrder = r17;
        goto L21
    L16:
        r17.nextInKeyInsertionOrder = r10.nextInKeyInsertionOrder;
        goto L17
    L12:
        r16.nextInVToKBucket = r10.nextInVToKBucket;
        goto L13
    L6:
        r13.nextInKToVBucket = r10.nextInKToVBucket;
        goto L7
    }

    public final void b(int r5) {
        p7.q(r5, "expectedSize");
        int r10 = p7.v(1.0d, r5);
        this.f8810a = new BiEntry[r10];
        this.f8811b = new BiEntry[r10];
        this.f8812c = null;
        this.d = null;
        this.e = 0;
        this.f = r10 - 1;
        this.g = 0;
    }

    public final void c(BiEntry r5, BiEntry r10) {
        int r11 = r5.keyHash;
        int r12 = this.f;
        int r13 = r11 & r12;
        BiEntry[] r14 = this.f8810a;
        r5.nextInKToVBucket = r14[r13];
        r14[r13] = r5;
        int r15 = r5.valueHash & r12;
        BiEntry[] r16 = this.f8811b;
        r5.nextInVToKBucket = r16[r15];
        r16[r15] = r5;
        if (r10 != null) goto L9;
        BiEntry<K, V> r17 = this.d;
        r5.prevInKeyInsertionOrder = r17;
        r5.nextInKeyInsertionOrder = null;
        if (r17 != null) goto L7;
        this.f8812c = r5;
    L8:
        this.d = r5;
    L17:
        this.e++;
        this.g++;
        return;
    L7:
        r17.nextInKeyInsertionOrder = r5;
        goto L8
    L9:
        BiEntry<K, V> r18 = r10.prevInKeyInsertionOrder;
        r5.prevInKeyInsertionOrder = r18;
        if (r18 != null) goto L12;
        this.f8812c = r5;
    L13:
        BiEntry<K, V> r19 = r10.nextInKeyInsertionOrder;
        r5.nextInKeyInsertionOrder = r19;
        if (r19 != null) goto L16;
        this.d = r5;
        goto L17
    L16:
        r19.prevInKeyInsertionOrder = r5;
        goto L17
    L12:
        r18.nextInKeyInsertionOrder = r5;
        goto L13
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.e = 0;
        Arrays.fill(this.f8810a, null);
        Arrays.fill(this.f8811b, null);
        this.f8812c = null;
        this.d = null;
        this.g++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r5) {
        if (f(p7.o0(r5), r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r5) {
        if (g(p7.o0(r5), r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Object d(Object r5, Object r10, boolean r11) {
        int r12 = p7.o0(r5);
        int r13 = p7.o0(r10);
        BiEntry r14 = f(r12, r5);
        if (r14 != null) goto L5;
    L9:
        BiEntry r15 = g(r13, r10);
        if (r15 == null) goto L15;
        if (r11 == false) goto L13;
        a(r15);
        goto L15
    L13:
        String r16 = String.valueOf(r10);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.l(r16.length() + 23, "value already present: ", r16));
    L15:
        BiEntry r17 = new BiEntry(r5, r12, r10, r13);
        if (r14 == null) goto L19;
        a(r14);
        c(r17, r14);
        r14.prevInKeyInsertionOrder = null;
        r14.nextInKeyInsertionOrder = null;
        return r14.value;
    L19:
        c(r17, null);
        e();
        return null;
    L5:
        if (r13 != r14.valueHash) goto L9;
        if (com.google.common.base.b0.w(r10, r14.value) == false) goto L9;
        return r10;
    }

    public final void e() {
        BiEntry[] r5 = this.f8810a;
        int r10 = this.e;
        int r11 = r5.length;
        if (r10 > (1.0d * ((double) r11))) goto L5;
        return;
    L5:
        if (r11 >= 1073741824) goto L13;
        int r12 = r5.length * 2;
        this.f8810a = new BiEntry[r12];
        this.f8811b = new BiEntry[r12];
        this.f = r12 - 1;
        this.e = 0;
        BiEntry<K, V> r13 = this.f8812c;
    L7:
        if (r13 == null) goto L9;
        c(r13, r13);
        r13 = r13.nextInKeyInsertionOrder;
        goto L7
    L9:
        this.g++;
        return;
    }

    @Override // com.google.common.collect.h7
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new g3(this);
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public final BiEntry f(int r5, Object r10) {
        BiEntry<K, V> r11 = this.f8810a[this.f & r5];
    L3:
        if (r11 == null) goto L10;
        if (r5 != r11.keyHash) goto L9;
        if (com.google.common.base.b0.w(r10, r11.key) == false) goto L9;
        return r11;
    L9:
        r11 = r11.nextInKToVBucket;
        goto L3
    L10:
        return null;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        r5.getClass();
        BiEntry<K, V> r10 = this.f8812c;
    L3:
        if (r10 == null) goto L5;
        r5.accept(r10.key, r10.value);
        r10 = r10.nextInKeyInsertionOrder;
        goto L3
    }

    @Override // com.google.common.collect.c1
    public V forcePut(K r5, V r10) {
        return (V) d(r5, r10, true);
    }

    public final BiEntry g(int r5, Object r10) {
        BiEntry<K, V> r11 = this.f8811b[this.f & r5];
    L3:
        if (r11 == null) goto L10;
        if (r5 != r11.valueHash) goto L9;
        if (com.google.common.base.b0.w(r10, r11.value) == false) goto L9;
        return r11;
    L9:
        r11 = r11.nextInVToKBucket;
        goto L3
    L10:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r5) {
        BiEntry r10 = f(p7.o0(r5), r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return (V) r10.getValue();
    }

    @Override // com.google.common.collect.c1
    public c1 inverse() {
        c1 r5 = this.f8813h;
        if (r5 != null) goto L6;
        Inverse r10 = new Inverse(this, null);
        this.f8813h = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new o3(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r5, V r10) {
        return (V) d(r5, r10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r5) {
        BiEntry r10 = f(p7.o0(r5), r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        a(r10);
        r10.prevInKeyInsertionOrder = null;
        r10.nextInKeyInsertionOrder = null;
        return r10.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r5) {
        r5.getClass();
        BiEntry<K, V> r10 = this.f8812c;
        clear();
    L3:
        if (r10 == null) goto L5;
        K r11 = r10.key;
        put(r11, r5.apply(r11, r10.value));
        r10 = r10.nextInKeyInsertionOrder;
        goto L3
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> HashBiMap<K, V> create(int r5) {
        HashBiMap<K, V> r10 = new HashBiMap();
        r10.b(r5);
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.c1
    public Set<V> values() {
        return inverse().keySet();
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> r5) {
        HashBiMap<K, V> r10 = create(r5.size());
        r10.putAll(r5);
        return r10;
    }
}

package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    public static final Object g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f8791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f8792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f8793c;
    public transient Set d;
    public transient Set e;
    transient int[] entries;
    public transient Collection f;
    transient Object[] keys;
    transient Object[] values;

    static {
        g = new Object();
    }

    public CompactHashMap() {
        init(3);
    }

    public static /* synthetic */ int access$000(CompactHashMap r5) {
        return r5.f8792b;
    }

    public static Object access$100(CompactHashMap r5, int r10) {
        return r5.e()[r10];
    }

    public static Object access$1000(CompactHashMap r5) {
        Object r10 = r5.f8791a;
        Objects.requireNonNull(r10);
        return r10;
    }

    public static /* synthetic */ int[] access$1100(CompactHashMap r5) {
        return r5.d();
    }

    public static /* synthetic */ Object[] access$1200(CompactHashMap r5) {
        return r5.f();
    }

    public static void access$1300(CompactHashMap r5, int r10, Object r11) {
        r5.f()[r10] = r11;
    }

    public static /* synthetic */ Object[] access$200(CompactHashMap r5) {
        return r5.e();
    }

    public static /* synthetic */ int access$300(CompactHashMap r5) {
        return r5.f8793c;
    }

    public static /* synthetic */ int access$310(CompactHashMap r5) {
        int r10 = r5.f8793c;
        r5.f8793c = r10 - 1;
        return r10;
    }

    public static /* synthetic */ Object access$400(CompactHashMap r5, Object r10) {
        return r5.c(r10);
    }

    public static /* synthetic */ Object access$500() {
        return g;
    }

    public static /* synthetic */ int access$700(CompactHashMap r5, Object r10) {
        return r5.b(r10);
    }

    public static Object access$800(CompactHashMap r5, int r10) {
        return r5.f()[r10];
    }

    public static /* synthetic */ int access$900(CompactHashMap r5) {
        return r5.a();
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int r5) {
        return new CompactHashMap(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        int r10 = r5.readInt();
        if (r10 < 0) goto L9;
        init(r10);
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L7;
        put(r5.readObject(), r5.readObject());
        r11 = r11 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException(androidx.constraintlayout.motion.widget.a.i(25, "Invalid size: ", r10));
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeInt(size());
        Iterator<Map.Entry<K, V>> r10 = entrySetIterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<K, V> r11 = r10.next();
        r5.writeObject(r11.getKey());
        r5.writeObject(r11.getValue());
        goto L4
    }

    public final int a() {
        return (1 << (this.f8792b & 31)) - 1;
    }

    public void accessEntry(int r5) {
    }

    public int adjustAfterRemove(int r5, int r10) {
        return r5 - 1;
    }

    public int allocArrays() {
        com.google.common.base.b0.u(needsAllocArrays(), "Arrays already allocated");
        int r5 = this.f8792b;
        int r10 = p7.r0(r5);
        this.f8791a = p7.y(r10);
        this.f8792b = p7.S(this.f8792b, 32 - Integer.numberOfLeadingZeros(r10 - 1), 31);
        this.entries = new int[r5];
        this.keys = new Object[r5];
        this.values = new Object[r5];
        return r5;
    }

    public final int b(Object r10) {
        if (needsAllocArrays() == false) goto L5;
        return -1;
    L5:
        int r5 = p7.o0(r10);
        int r11 = a();
        Object r12 = this.f8791a;
        Objects.requireNonNull(r12);
        int r13 = p7.p0(r5 & r11, r12);
        if (r13 != 0) goto L8;
        return -1;
    L8:
        int r14 = ~r11;
        int r15 = r5 & r14;
    L9:
        int r16 = r13 - 1;
        int r17 = d()[r16];
        if ((r17 & r14) == r15) goto L12;
    L14:
        r13 = r17 & r11;
        if (r13 != 0) goto L9;
        return -1;
    L12:
        if (com.google.common.base.b0.w(r10, e()[r16]) == false) goto L14;
        return r16;
    }

    public final Object c(Object r10) {
        boolean r5 = needsAllocArrays();
        Object r11 = g;
        if (r5 == false) goto L5;
        return r11;
    L5:
        int r12 = a();
        Object r13 = this.f8791a;
        Objects.requireNonNull(r13);
        int r14 = p7.g0(r10, null, r12, r13, d(), e(), null);
        if (r14 != (-1)) goto L8;
        return r11;
    L8:
        Object r15 = f()[r14];
        moveLastEntry(r14, r12);
        this.f8793c--;
        incrementModCount();
        return r15;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        incrementModCount();
        Map<K, V> r5 = delegateOrNull();
        if (r5 == null) goto L8;
        this.f8792b = dn.a.P(size(), 3);
        r5.clear();
        this.f8791a = null;
        this.f8793c = 0;
        return;
    L8:
        Arrays.fill(e(), 0, this.f8793c, null);
        Arrays.fill(f(), 0, this.f8793c, null);
        Object r10 = this.f8791a;
        Objects.requireNonNull(r10);
        if ((r10 instanceof byte[]) == false) goto L12;
        Arrays.fill((byte[]) r10, (byte) 0);
    L15:
        Arrays.fill(d(), 0, this.f8793c, 0);
        this.f8793c = 0;
        return;
    L12:
        if ((r10 instanceof short[]) == false) goto L14;
        Arrays.fill((short[]) r10, 0);
        goto L15
    L14:
        Arrays.fill((int[]) r10, 0);
        goto L15
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r5) {
        Map<K, V> r10 = delegateOrNull();
        if (r10 == null) goto L6;
        return r10.containsKey(r5);
    L6:
        if (b(r5) == (-1)) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r5) {
        Map<K, V> r10 = delegateOrNull();
        if (r10 != null) goto L5;
        int r11 = 0;
    L8:
        if (r11 >= this.f8793c) goto L14;
        if (com.google.common.base.b0.w(r5, f()[r11]) == true) goto L11;
        r11 = r11 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    L5:
        return r10.containsValue(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> r5 = createHashFloodingResistantDelegate(a() + 1);
        int r10 = firstEntryIndex();
    L3:
        if (r10 < 0) goto L5;
        r5.put(e()[r10], f()[r10]);
        r10 = getSuccessor(r10);
        goto L3
    L5:
        this.f8791a = r5;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return r5;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new l(1, this);
    }

    public Map<K, V> createHashFloodingResistantDelegate(int r5) {
        return new LinkedHashMap(r5, 1.0f);
    }

    public Set<K> createKeySet() {
        return new o(this, 1);
    }

    public Collection<V> createValues() {
        return new y1(this, 0);
    }

    public final int[] d() {
        int[] r5 = this.entries;
        Objects.requireNonNull(r5);
        return r5;
    }

    public Map<K, V> delegateOrNull() {
        Object r5 = this.f8791a;
        if ((r5 instanceof Map) == true) goto L5;
        return null;
    L5:
        return (Map) r5;
    }

    public final Object[] e() {
        Object[] r5 = this.keys;
        Objects.requireNonNull(r5);
        return r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r5 = this.e;
        if (r5 != null) goto L6;
        Set<Map.Entry<K, V>> r10 = createEntrySet();
        this.e = r10;
        return r10;
    L6:
        return r5;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> r5 = delegateOrNull();
        if (r5 == null) goto L7;
        return r5.entrySet().iterator();
    L7:
        return new v1(this, 1);
    }

    public final Object[] f() {
        Object[] r5 = this.values;
        Objects.requireNonNull(r5);
        return r5;
    }

    public int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        r5.getClass();
        Map<K, V> r10 = delegateOrNull();
        if (r10 == null) goto L5;
        r10.forEach(r5);
        return;
    L5:
        int r11 = firstEntryIndex();
    L6:
        if (r11 < 0) goto L10;
        r5.accept(e()[r11], f()[r11]);
        r11 = getSuccessor(r11);
        goto L6
    }

    public final int g(int r10, int r11, int r12, int r13) {
        Object r5 = p7.y(r11);
        int r14 = r11 - 1;
        if (r13 == 0) goto L5;
        p7.q0(r12 & r14, r13 + 1, r5);
    L5:
        Object r15 = this.f8791a;
        Objects.requireNonNull(r15);
        int[] r16 = d();
        int r17 = 0;
    L6:
        if (r17 > r10) goto L11;
        int r18 = p7.p0(r17, r15);
    L8:
        if (r18 == 0) goto L10;
        int r19 = r18 - 1;
        int r20 = r16[r19];
        int r21 = ((~r10) & r20) | r17;
        int r22 = r21 & r14;
        int r23 = p7.p0(r22, r5);
        p7.q0(r22, r18, r5);
        r16[r19] = p7.S(r21, r23, r14);
        r18 = r20 & r10;
        goto L8
    L10:
        r17 = r17 + 1;
        goto L6
    L11:
        this.f8791a = r5;
        this.f8792b = p7.S(this.f8792b, 32 - Integer.numberOfLeadingZeros(r14), 31);
        return r14;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r5) {
        Map<K, V> r10 = delegateOrNull();
        if (r10 != null) goto L5;
        int r11 = b(r5);
        if (r11 != (-1)) goto L10;
        return null;
    L10:
        accessEntry(r11);
        return (V) f()[r11];
    L5:
        return r10.get(r5);
    }

    public int getSuccessor(int r5) {
        int r10 = r5 + 1;
        if (r10 < this.f8793c) goto L7;
        return -1;
    L7:
        return r10;
    }

    public void incrementModCount() {
        this.f8792b += 32;
    }

    public void init(int r5) {
        if (r5 < 0) goto L5;
        boolean r10 = true;
    L6:
        com.google.common.base.b0.g("Expected size must be >= 0", r10);
        this.f8792b = dn.a.P(r5, 1);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public void insertEntry(int r5, K r10, V r11, int r12, int r13) {
        int r14 = p7.S(r12, 0, r13);
        d()[r5] = r14;
        e()[r5] = r10;
        f()[r5] = r11;
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
        Set<K> r5 = this.d;
        if (r5 != null) goto L6;
        Set<K> r10 = createKeySet();
        this.d = r10;
        return r10;
    L6:
        return r5;
    }

    public Iterator<K> keySetIterator() {
        Map<K, V> r5 = delegateOrNull();
        if (r5 == null) goto L7;
        return r5.keySet().iterator();
    L7:
        return new v1(this, 0);
    }

    public void moveLastEntry(int r10, int r11) {
        Object r5 = this.f8791a;
        Objects.requireNonNull(r5);
        int[] r12 = d();
        Object[] r13 = e();
        Object[] r14 = f();
        int r15 = size();
        int r16 = r15 - 1;
        if (r10 >= r16) goto L11;
        Object r17 = r13[r16];
        r13[r10] = r17;
        r14[r10] = r14[r16];
        r13[r16] = null;
        r14[r16] = null;
        r12[r10] = r12[r16];
        r12[r16] = 0;
        int r18 = p7.o0(r17) & r11;
        int r19 = p7.p0(r18, r5);
        if (r19 != r15) goto L7;
        p7.q0(r18, r10 + 1, r5);
        return;
    L7:
        int r20 = r19 - 1;
        int r21 = r12[r20];
        int r22 = r21 & r11;
        if (r22 == r15) goto L9;
        r19 = r22;
        goto L7
    L9:
        r12[r20] = p7.S(r21, r10 + 1, r11);
        return;
    L11:
        r13[r10] = null;
        r14[r10] = null;
        r12[r10] = 0;
    }

    public boolean needsAllocArrays() {
        if (this.f8791a != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r18, V r19) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        Map<K, V> r5 = delegateOrNull();
        if (r5 != null) goto L8;
        int[] r10 = d();
        Object[] r11 = e();
        Object[] r12 = f();
        int r13 = this.f8793c;
        int r14 = r13 + 1;
        int r15 = p7.o0(r18);
        int r16 = a();
        int r17 = r15 & r16;
        Object r110 = this.f8791a;
        Objects.requireNonNull(r110);
        int r111 = p7.p0(r17, r110);
        int r112 = 1;
        if (r111 != 0) goto L15;
        if (r14 <= r16) goto L14;
        int r20 = g(r16, p7.W(r16), r15, r13);
    L13:
        r16 = r20;
    L31:
        int r21 = d().length;
        if (r14 <= r21) goto L36;
        int r22 = Math.min(1073741823, (Math.max(1, r21 >>> 1) + r21) | 1);
        if (r22 == r21) goto L36;
        resizeEntries(r22);
    L36:
        insertEntry(r13, r18, r19, r15, r16);
        this.f8793c = r14;
        incrementModCount();
        return null;
    L14:
        Object r23 = this.f8791a;
        Objects.requireNonNull(r23);
        p7.q0(r17, r14, r23);
        goto L31
    L15:
        int r113 = ~r16;
        int r114 = r15 & r113;
        int r115 = 0;
    L16:
        int r116 = r111 - r112;
        int r117 = r10[r116];
        if ((r117 & r113) == r114) goto L19;
    L22:
        int r118 = r117 & r16;
        r115 = r115 + 1;
        if (r118 == 0) goto L25;
        r111 = r118;
        r112 = 1;
        goto L16
    L25:
        if (r115 >= 9) goto L27;
        if (r14 <= r16) goto L30;
        r20 = g(r16, p7.W(r16), r15, r13);
        goto L13
    L30:
        r10[r116] = p7.S(r117, r14, r16);
        goto L31
    L27:
        return convertToHashFloodingResistantImplementation().put(r18, r19);
    L19:
        if (com.google.common.base.b0.w(r18, r11[r116]) == false) goto L22;
        V r24 = (V) r12[r116];
        r12[r116] = r19;
        accessEntry(r116);
        return r24;
    L8:
        return r5.put(r18, r19);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r5) {
        Map<K, V> r10 = delegateOrNull();
        if (r10 != null) goto L5;
        V r11 = (V) c(r5);
        if (r11 != g) goto L10;
        return null;
    L10:
        return r11;
    L5:
        return r10.remove(r5);
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r5) {
        r5.getClass();
        Map<K, V> r10 = delegateOrNull();
        if (r10 == null) goto L5;
        r10.replaceAll(r5);
        return;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.f8793c) goto L11;
        V r12 = r5.apply(e()[r11], f()[r11]);
        f()[r11] = r12;
        r11 = r11 + 1;
        goto L7
    }

    public void resizeEntries(int r5) {
        this.entries = Arrays.copyOf(d(), r5);
        this.keys = Arrays.copyOf(e(), r5);
        this.values = Arrays.copyOf(f(), r5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> r5 = delegateOrNull();
        if (r5 == null) goto L6;
        return r5.size();
    L6:
        return this.f8793c;
    }

    public void trimToSize() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        Map<K, V> r5 = delegateOrNull();
        if (r5 == null) goto L9;
        Map<K, V> r10 = createHashFloodingResistantDelegate(size());
        r10.putAll(r5);
        this.f8791a = r10;
        return;
    L9:
        int r11 = this.f8793c;
        if (r11 >= d().length) goto L12;
        resizeEntries(r11);
    L12:
        int r12 = p7.r0(r11);
        int r13 = a();
        if (r12 >= r13) goto L16;
        g(r13, r12, 0, 0);
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r5 = this.f;
        if (r5 != null) goto L6;
        Collection<V> r10 = createValues();
        this.f = r10;
        return r10;
    L6:
        return r5;
    }

    public Iterator<V> valuesIterator() {
        Map<K, V> r5 = delegateOrNull();
        if (r5 == null) goto L7;
        return r5.values().iterator();
    L7:
        return new v1(this, 2);
    }

    public CompactHashMap(int r5) {
        init(r5);
    }
}

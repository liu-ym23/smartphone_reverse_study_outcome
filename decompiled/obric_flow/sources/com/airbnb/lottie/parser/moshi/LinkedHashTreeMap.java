package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ca.d f1302a = null;
    Comparator<? super K> comparator;
    private e entrySet;
    final g header;
    private f keySet;
    int modCount;
    int size;
    g[] table;
    int threshold;

    static {
        f1302a = new ca.d(1);
    }

    public LinkedHashTreeMap() {
        this(null);
    }

    public static <K, V> g[] doubleCapacity(g[] r14) {
        int r5 = r14.length;
        g[] r10 = new g[r5 * 2];
        c r11 = new c();
        c r12 = new c();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L54;
        g r15 = r14[r13];
        if (r15 == null) goto L53;
        g r16 = null;
        g r17 = r15;
        g r18 = null;
    L8:
        if (r17 == null) goto L10;
        r17.f1321a = r18;
        r18 = r17;
        r17 = r17.f1322b;
        goto L8
    L10:
        int r19 = 0;
        int r110 = 0;
    L11:
        if (r18 != null) goto L13;
        g r111 = r18;
        r18 = null;
    L17:
        if (r18 == null) goto L23;
        if ((r18.g & r5) != 0) goto L22;
        r19 = r19 + 1;
    L21:
        r18 = r111;
        goto L11
    L22:
        r110 = r110 + 1;
        goto L21
    L23:
        r11.f1313a = ((Integer.highestOneBit(r19) * 2) - 1) - r19;
        r11.f1315c = 0;
        r11.f1314b = 0;
        r11.d = null;
        r12.f1313a = ((Integer.highestOneBit(r110) * 2) - 1) - r110;
        r12.f1315c = 0;
        r12.f1314b = 0;
        r12.d = null;
        g r20 = null;
    L24:
        if (r15 == null) goto L26;
        r15.f1321a = r20;
        r20 = r15;
        r15 = r15.f1322b;
    L26:
        if (r20 != null) goto L28;
        g r112 = r20;
        r20 = null;
    L32:
        if (r20 == null) goto L38;
        if ((r20.g & r5) != 0) goto L37;
        r11.c(r20);
    L36:
        r20 = r112;
        goto L26
    L37:
        r12.c(r20);
        goto L36
    L38:
        if (r19 <= 0) goto L44;
        g r21 = (g) r11.d;
        if (r21.f1321a != null) goto L43;
    L45:
        r10[r13] = r21;
        int r22 = r13 + r5;
        if (r110 <= 0) goto L52;
        r16 = (g) r12.d;
        if (r16.f1321a == null) goto L52;
        throw new IllegalStateException();
    L52:
        r10[r22] = r16;
        goto L53
    L43:
        throw new IllegalStateException();
    L44:
        r21 = null;
        goto L45
    L28:
        g r23 = r20.f1321a;
        r20.f1321a = null;
        g r113 = r20.f1323c;
    L29:
        g r114 = r113;
        r112 = r23;
        r23 = r114;
        if (r23 == null) goto L32;
        r23.f1321a = r112;
        r113 = r23.f1322b;
        goto L29
    L13:
        g r115 = r18.f1321a;
        r18.f1321a = null;
        g r116 = r18.f1323c;
    L14:
        g r117 = r116;
        r111 = r115;
        r115 = r117;
        if (r115 == null) goto L17;
        r115.f1321a = r111;
        r116 = r115.f1322b;
    L53:
        r13 = r13 + 1;
        goto L3
    L54:
        return r10;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public final void a(g r10, boolean r11) {
    L2:
        if (r10 == null) goto L52;
        g r5 = r10.f1322b;
        g r12 = r10.f1323c;
        int r13 = 0;
        if (r5 == null) goto L6;
        int r14 = r5.f1325i;
    L7:
        if (r12 == null) goto L9;
        int r15 = r12.f1325i;
    L10:
        int r16 = r14 - r15;
        if (r16 != (-2)) goto L28;
        g r17 = r12.f1322b;
        g r18 = r12.f1323c;
        if (r18 == null) goto L15;
        int r19 = r18.f1325i;
    L16:
        if (r17 == null) goto L18;
        r13 = r17.f1325i;
    L18:
        int r20 = r13 - r19;
        if (r20 == (-1)) goto L24;
        if (r20 != 0) goto L23;
        if (r11 == false) goto L24;
    L23:
        d(r12);
        c(r10);
    L25:
        if (r11 == false) goto L51;
        return;
    L51:
        r10 = r10.f1321a;
    L24:
        c(r10);
        goto L25
    L15:
        r19 = 0;
        goto L16
    L28:
        if (r16 != 2) goto L44;
        g r21 = r5.f1322b;
        g r22 = r5.f1323c;
        if (r22 == null) goto L32;
        int r23 = r22.f1325i;
    L33:
        if (r21 == null) goto L35;
        r13 = r21.f1325i;
    L35:
        int r24 = r13 - r23;
        if (r24 == 1) goto L41;
        if (r24 != 0) goto L40;
        if (r11 == false) goto L41;
    L40:
        c(r5);
        d(r10);
    L42:
        if (r11 == false) goto L51;
        return;
    L41:
        d(r10);
        goto L42
    L32:
        r23 = 0;
        goto L33
    L44:
        if (r16 != 0) goto L48;
        r10.f1325i = r14 + 1;
        if (r11 == false) goto L51;
        return;
    L48:
        r10.f1325i = Math.max(r14, r15) + 1;
        if (r11 == true) goto L51;
        return;
    L9:
        r15 = 0;
        goto L10
    L6:
        r14 = 0;
        goto L7
    }

    public final void b(g r5, g r10) {
        g r11 = r5.f1321a;
        r5.f1321a = null;
        if (r10 == null) goto L5;
        r10.f1321a = r11;
    L5:
        if (r11 != null) goto L7;
        g[] r12 = this.table;
        r12[r5.g & (r12.length - 1)] = r10;
        return;
    L7:
        if (r11.f1322b != r5) goto L9;
        r11.f1322b = r10;
        return;
    L9:
        r11.f1323c = r10;
    }

    public final void c(g r5) {
        g r10 = r5.f1322b;
        g r11 = r5.f1323c;
        g r12 = r11.f1322b;
        g r13 = r11.f1323c;
        r5.f1323c = r12;
        if (r12 == null) goto L5;
        r12.f1321a = r5;
    L5:
        b(r5, r11);
        r11.f1322b = r5;
        r5.f1321a = r11;
        int r14 = 0;
        if (r10 == null) goto L8;
        int r15 = r10.f1325i;
    L9:
        if (r12 == null) goto L11;
        int r16 = r12.f1325i;
    L12:
        int r17 = Math.max(r15, r16) + 1;
        r5.f1325i = r17;
        if (r13 == null) goto L15;
        r14 = r13.f1325i;
    L15:
        r11.f1325i = Math.max(r17, r14) + 1;
        return;
    L11:
        r16 = 0;
        goto L12
    L8:
        r15 = 0;
        goto L9
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        this.modCount++;
        g r5 = this.header;
        g r10 = r5.d;
    L3:
        if (r10 == r5) goto L5;
        g r11 = r10.d;
        r10.e = null;
        r10.d = null;
        r10 = r11;
        goto L3
    L5:
        r5.e = r5;
        r5.d = r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r5) {
        if (findByObject(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(g r5) {
        g r10 = r5.f1322b;
        g r11 = r5.f1323c;
        g r12 = r10.f1322b;
        g r13 = r10.f1323c;
        r5.f1322b = r13;
        if (r13 == null) goto L5;
        r13.f1321a = r5;
    L5:
        b(r5, r10);
        r10.f1323c = r5;
        r5.f1321a = r10;
        int r14 = 0;
        if (r11 == null) goto L8;
        int r15 = r11.f1325i;
    L9:
        if (r13 == null) goto L11;
        int r16 = r13.f1325i;
    L12:
        int r17 = Math.max(r15, r16) + 1;
        r5.f1325i = r17;
        if (r12 == null) goto L15;
        r14 = r12.f1325i;
    L15:
        r10.f1325i = Math.max(r17, r14) + 1;
        return;
    L11:
        r16 = 0;
        goto L12
    L8:
        r15 = 0;
        goto L9
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        e r5 = this.entrySet;
        if (r5 != null) goto L7;
        e r10 = new e(this);
        this.entrySet = r10;
        return r10;
    L7:
        return r5;
    }

    public g find(K r13, boolean r14) {
        Comparator<? super K> r5 = this.comparator;
        g[] r10 = this.table;
        int r11 = r13.hashCode();
        int r12 = r11 ^ ((r11 >>> 20) ^ (r11 >>> 12));
        int r15 = ((r12 >>> 7) ^ r12) ^ (r12 >>> 4);
        int r16 = (r10.length - 1) & r15;
        g r17 = r10[r16];
        ca.d r18 = f1302a;
        if (r17 == null) goto L19;
        if (r5 != r18) goto L6;
        Comparable r19 = (Comparable) r13;
    L7:
        a1.b r20 = (Object) r17.f;
        if (r19 == null) goto L10;
        int r21 = r19.compareTo(r20);
    L11:
        if (r21 == 0) goto L12;
        if (r21 >= 0) goto L15;
        g r110 = r17.f1322b;
    L16:
        if (r110 == null) goto L17;
        r17 = r110;
    L17:
        g r111 = r17;
        int r112 = r21;
        if (r14 == true) goto L22;
        return null;
    L22:
        g r22 = this.header;
        if (r111 != null) goto L31;
        if (r5 == r18) goto L26;
    L30:
        g r113 = new g(r111, r13, r15, r22, r22.e);
        r10[r16] = r113;
    L36:
        int r114 = this.size;
        this.size = r114 + 1;
        if (r114 <= this.threshold) goto L39;
        g[] r115 = doubleCapacity(this.table);
        this.table = r115;
        this.threshold = (r115.length / 4) + (r115.length / 2);
    L39:
        this.modCount++;
        return r113;
    L26:
        if ((r13 instanceof Comparable) == true) goto L30;
        throw new ClassCastException(r13.getClass().getName().concat(" is not Comparable"));
    L31:
        r113 = new g(r111, r13, r15, r22, r22.e);
        if (r112 >= 0) goto L34;
        r111.f1322b = r113;
    L35:
        a(r111, true);
        goto L36
    L34:
        r111.f1323c = r113;
        goto L35
    L15:
        r110 = r17.f1323c;
        goto L16
    L12:
        return r17;
    L10:
        r21 = r5.compare(r13, r20);
        goto L11
    L6:
        r19 = null;
        goto L7
    L19:
        r21 = 0;
        goto L17
    }

    public g findByEntry(Map.Entry<?, ?> r5) {
        g r10 = findByObject(r5.getKey());
        if (r10 == null) goto L10;
        Object r11 = r10.f1324h;
        Object r12 = r5.getValue();
        if (r11 == r12) goto L12;
        if (r11 == null) goto L10;
        if (r11.equals(r12) == false) goto L10;
        return r10;
    L12:
        return r10;
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g findByObject(Object r5) {
        if (r5 != 0) goto L8;
        return null;
    L8:
        return find(r5, false);
    L11:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r5) {
        g r10 = findByObject(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return (V) r10.f1324h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        f r5 = this.keySet;
        if (r5 != null) goto L7;
        f r10 = new f(this);
        this.keySet = r10;
        return r10;
    L7:
        return r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r5, V r10) {
        if (r5 == null) goto L6;
        g r11 = find(r5, true);
        V r12 = (V) r11.f1324h;
        r11.f1324h = r10;
        return r12;
    L6:
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r5) {
        g r10 = removeInternalByKey(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return (V) r10.f1324h;
    }

    public void removeInternal(g r10, boolean r11) {
        if (r11 == false) goto L5;
        g r12 = r10.e;
        r12.d = r10.d;
        r10.d.e = r12;
        r10.e = null;
        r10.d = null;
    L5:
        g r13 = r10.f1322b;
        g r5 = r10.f1323c;
        g r14 = r10.f1321a;
        int r15 = 0;
        if (r13 == null) goto L28;
        if (r5 == null) goto L28;
        if (r13.f1325i <= r5.f1325i) goto L14;
        g r16 = r13.f1323c;
    L11:
        g r17 = r16;
        g r18 = r13;
        r13 = r17;
        if (r13 == null) goto L19;
        r16 = r13.f1323c;
    L19:
        removeInternal(r18, false);
        g r19 = r10.f1322b;
        if (r19 == null) goto L22;
        int r20 = r19.f1325i;
        r18.f1322b = r19;
        r19.f1321a = r18;
        r10.f1322b = null;
    L23:
        g r21 = r10.f1323c;
        if (r21 == null) goto L26;
        r15 = r21.f1325i;
        r18.f1323c = r21;
        r21.f1321a = r18;
        r10.f1323c = null;
    L26:
        r18.f1325i = Math.max(r20, r15) + 1;
        b(r10, r18);
        return;
    L22:
        r20 = 0;
        goto L23
    L14:
        g r22 = r5.f1322b;
    L15:
        g r23 = r5;
        r5 = r22;
        if (r5 == null) goto L18;
        r22 = r5.f1322b;
        goto L15
    L18:
        r18 = r23;
    L28:
        if (r13 == null) goto L30;
        b(r10, r13);
        r10.f1322b = null;
    L33:
        a(r14, false);
        this.size--;
        this.modCount++;
        return;
    L30:
        if (r5 == null) goto L32;
        b(r10, r5);
        r10.f1323c = null;
        goto L33
    L32:
        b(r10, null);
        goto L33
    }

    public g removeInternalByKey(Object r5) {
        g r10 = findByObject(r5);
        if (r10 == null) goto L5;
        removeInternal(r10, true);
    L5:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> r5) {
        this.size = 0;
        this.modCount = 0;
        if (r5 != null) goto L6;
        r5 = f1302a;
    L6:
        this.comparator = r5;
        this.header = new g();
        this.table = new g[16];
        this.threshold = 12;
    }
}

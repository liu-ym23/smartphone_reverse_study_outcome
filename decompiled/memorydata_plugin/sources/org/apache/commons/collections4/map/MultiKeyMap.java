package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;

/* JADX INFO: loaded from: classes6.dex */
public class MultiKeyMap<K, V> extends AbstractMapDecorator<MultiKey<? extends K>, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public MultiKeyMap() {
        this(new HashedMap());
    }

    public MultiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> r1) {
        super(r1);
        this.map = r1;
    }

    public static <K, V> MultiKeyMap<K, V> multiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> r1) {
        Objects.requireNonNull(r1, "Map must not be null");
        if (r1.size() > 0) goto L7;
        return new MultiKeyMap(r1);
    L7:
        throw new IllegalArgumentException("Map must be empty");
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.map);
    }

    public void checkKey(MultiKey<?> r1) {
        Objects.requireNonNull(r1, "Key must not be null");
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m3071clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public MultiKeyMap<K, V> m3071clone() {
        return (MultiKeyMap) ZeusTransformUtils.preCheckCast(super.clone(), MultiKeyMap.class, "com.obric.memorydata.plugin");
    L5:
        throw new InternalError();
    }

    public boolean containsKey(Object r5, Object r6) {
        int r0 = hash(r5, r6);
        AbstractHashedMap.HashEntry<K, V> r1 = decorated().data[decorated().hashIndex(r0, decorated().data.length)];
    L3:
        if (r1 == null) goto L11;
        if (r1.hashCode != r0) goto L10;
        if (isEqualKey(r1, r5, r6) == false) goto L10;
        return true;
    L10:
        r1 = r1.next;
        goto L3
    L11:
        return false;
    }

    public boolean containsKey(Object r5, Object r6, Object r7) {
        int r0 = hash(r5, r6, r7);
        AbstractHashedMap.HashEntry<K, V> r1 = decorated().data[decorated().hashIndex(r0, decorated().data.length)];
    L3:
        if (r1 == null) goto L11;
        if (r1.hashCode != r0) goto L10;
        if (isEqualKey(r1, r5, r6, r7) == false) goto L10;
        return true;
    L10:
        r1 = r1.next;
        goto L3
    L11:
        return false;
    }

    public boolean containsKey(Object r9, Object r10, Object r11, Object r12) {
        int r0 = hash(r9, r10, r11, r12);
        AbstractHashedMap.HashEntry<K, V> r1 = decorated().data[decorated().hashIndex(r0, decorated().data.length)];
    L3:
        if (r1 == null) goto L11;
        if (r1.hashCode != r0) goto L10;
        if (isEqualKey(r1, r9, r10, r11, r12) == false) goto L10;
        return true;
    L10:
        r1 = r1.next;
        goto L3
    L11:
        return false;
    }

    public boolean containsKey(Object r10, Object r11, Object r12, Object r13, Object r14) {
        int r0 = hash(r10, r11, r12, r13, r14);
        AbstractHashedMap.HashEntry<K, V> r1 = decorated().data[decorated().hashIndex(r0, decorated().data.length)];
    L3:
        if (r1 == null) goto L11;
        if (r1.hashCode != r0) goto L10;
        if (isEqualKey(r1, r10, r11, r12, r13, r14) == false) goto L10;
        return true;
    L10:
        r1 = r1.next;
        goto L3
    L11:
        return false;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public /* bridge */ /* synthetic */ Map decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public AbstractHashedMap<MultiKey<? extends K>, V> decorated() {
        return (AbstractHashedMap) ZeusTransformUtils.preCheckCast(super.decorated(), AbstractHashedMap.class, "com.obric.memorydata.plugin");
    }

    public V get(Object r5, Object r6) {
        int r0 = hash(r5, r6);
        AbstractHashedMap.HashEntry<K, V> r1 = decorated().data[decorated().hashIndex(r0, decorated().data.length)];
    L3:
        if (r1 == null) goto L11;
        if (r1.hashCode != r0) goto L10;
        if (isEqualKey(r1, r5, r6) == false) goto L10;
        return r1.getValue();
    L10:
        r1 = r1.next;
        goto L3
    L11:
        return null;
    }

    public V get(Object r5, Object r6, Object r7) {
        int r0 = hash(r5, r6, r7);
        AbstractHashedMap.HashEntry<K, V> r1 = decorated().data[decorated().hashIndex(r0, decorated().data.length)];
    L3:
        if (r1 == null) goto L11;
        if (r1.hashCode != r0) goto L10;
        if (isEqualKey(r1, r5, r6, r7) == false) goto L10;
        return r1.getValue();
    L10:
        r1 = r1.next;
        goto L3
    L11:
        return null;
    }

    public V get(Object r9, Object r10, Object r11, Object r12) {
        int r0 = hash(r9, r10, r11, r12);
        AbstractHashedMap.HashEntry<K, V> r1 = decorated().data[decorated().hashIndex(r0, decorated().data.length)];
    L3:
        if (r1 == null) goto L11;
        if (r1.hashCode != r0) goto L10;
        if (isEqualKey(r1, r9, r10, r11, r12) == false) goto L10;
        return r1.getValue();
    L10:
        r1 = r1.next;
        goto L3
    L11:
        return null;
    }

    public V get(Object r10, Object r11, Object r12, Object r13, Object r14) {
        int r0 = hash(r10, r11, r12, r13, r14);
        AbstractHashedMap.HashEntry<K, V> r1 = decorated().data[decorated().hashIndex(r0, decorated().data.length)];
    L3:
        if (r1 == null) goto L11;
        if (r1.hashCode != r0) goto L10;
        if (isEqualKey(r1, r10, r11, r12, r13, r14) == false) goto L10;
        return r1.getValue();
    L10:
        r1 = r1.next;
        goto L3
    L11:
        return null;
    }

    public int hash(Object r1, Object r2) {
        int r0 = 0;
        if (r1 == null) goto L5;
        r0 = 0 ^ r1.hashCode();
    L5:
        if (r2 == null) goto L7;
        r0 = r0 ^ r2.hashCode();
    L7:
        int r3 = r0 + (~(r0 << 9));
        int r4 = r3 ^ (r3 >>> 14);
        int r5 = r4 + (r4 << 4);
        return r5 ^ (r5 >>> 10);
    }

    public int hash(Object r1, Object r2, Object r3) {
        int r0 = 0;
        if (r1 == null) goto L5;
        r0 = 0 ^ r1.hashCode();
    L5:
        if (r2 == null) goto L7;
        r0 = r0 ^ r2.hashCode();
    L7:
        if (r3 == null) goto L9;
        r0 = r0 ^ r3.hashCode();
    L9:
        int r4 = r0 + (~(r0 << 9));
        int r5 = r4 ^ (r4 >>> 14);
        int r6 = r5 + (r5 << 4);
        return r6 ^ (r6 >>> 10);
    }

    public int hash(Object r1, Object r2, Object r3, Object r4) {
        int r0 = 0;
        if (r1 == null) goto L5;
        r0 = 0 ^ r1.hashCode();
    L5:
        if (r2 == null) goto L7;
        r0 = r0 ^ r2.hashCode();
    L7:
        if (r3 == null) goto L9;
        r0 = r0 ^ r3.hashCode();
    L9:
        if (r4 == null) goto L11;
        r0 = r0 ^ r4.hashCode();
    L11:
        int r5 = r0 + (~(r0 << 9));
        int r6 = r5 ^ (r5 >>> 14);
        int r7 = r6 + (r6 << 4);
        return r7 ^ (r7 >>> 10);
    }

    public int hash(Object r1, Object r2, Object r3, Object r4, Object r5) {
        int r0 = 0;
        if (r1 == null) goto L5;
        r0 = 0 ^ r1.hashCode();
    L5:
        if (r2 == null) goto L7;
        r0 = r0 ^ r2.hashCode();
    L7:
        if (r3 == null) goto L9;
        r0 = r0 ^ r3.hashCode();
    L9:
        if (r4 == null) goto L11;
        r0 = r0 ^ r4.hashCode();
    L11:
        if (r5 == null) goto L13;
        r0 = r0 ^ r5.hashCode();
    L13:
        int r6 = r0 + (~(r0 << 9));
        int r7 = r6 ^ (r6 >>> 14);
        int r8 = r7 + (r7 << 4);
        return r8 ^ (r8 >>> 10);
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> r4, Object r5, Object r6) {
        MultiKey r3 = (MultiKey) ZeusTransformUtils.preCheckCast(r4.getKey(), MultiKey.class, "com.obric.memorydata.plugin");
        if (r3.size() != 2) goto L16;
        if (r5 == r3.getKey(0)) goto L10;
        if (r5 == null) goto L16;
        if (r5.equals(r3.getKey(0)) == false) goto L16;
    L10:
        if (r6 == r3.getKey(1)) goto L17;
        if (r6 == null) goto L16;
        if (r6.equals(r3.getKey(1)) == false) goto L16;
        return true;
    L17:
        return true;
    L16:
        return false;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> r4, Object r5, Object r6, Object r7) {
        MultiKey r3 = (MultiKey) ZeusTransformUtils.preCheckCast(r4.getKey(), MultiKey.class, "com.obric.memorydata.plugin");
        if (r3.size() != 3) goto L21;
        if (r5 == r3.getKey(0)) goto L10;
        if (r5 == null) goto L21;
        if (r5.equals(r3.getKey(0)) == false) goto L21;
    L10:
        if (r6 == r3.getKey(1)) goto L15;
        if (r6 == null) goto L21;
        if (r6.equals(r3.getKey(1)) == false) goto L21;
    L15:
        if (r7 == r3.getKey(2)) goto L22;
        if (r7 == null) goto L21;
        if (r7.equals(r3.getKey(2)) == false) goto L21;
        return true;
    L22:
        return true;
    L21:
        return false;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> r4, Object r5, Object r6, Object r7, Object r8) {
        MultiKey r3 = (MultiKey) ZeusTransformUtils.preCheckCast(r4.getKey(), MultiKey.class, "com.obric.memorydata.plugin");
        if (r3.size() != 4) goto L26;
        if (r5 == r3.getKey(0)) goto L10;
        if (r5 == null) goto L26;
        if (r5.equals(r3.getKey(0)) == false) goto L26;
    L10:
        if (r6 == r3.getKey(1)) goto L15;
        if (r6 == null) goto L26;
        if (r6.equals(r3.getKey(1)) == false) goto L26;
    L15:
        if (r7 == r3.getKey(2)) goto L20;
        if (r7 == null) goto L26;
        if (r7.equals(r3.getKey(2)) == false) goto L26;
    L20:
        if (r8 == r3.getKey(3)) goto L27;
        if (r8 == null) goto L26;
        if (r8.equals(r3.getKey(3)) == false) goto L26;
        return true;
    L27:
        return true;
    L26:
        return false;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        MultiKey r3 = (MultiKey) ZeusTransformUtils.preCheckCast(r4.getKey(), MultiKey.class, "com.obric.memorydata.plugin");
        if (r3.size() != 5) goto L31;
        if (r5 == r3.getKey(0)) goto L10;
        if (r5 == null) goto L31;
        if (r5.equals(r3.getKey(0)) == false) goto L31;
    L10:
        if (r6 == r3.getKey(1)) goto L15;
        if (r6 == null) goto L31;
        if (r6.equals(r3.getKey(1)) == false) goto L31;
    L15:
        if (r7 == r3.getKey(2)) goto L20;
        if (r7 == null) goto L31;
        if (r7.equals(r3.getKey(2)) == false) goto L31;
    L20:
        if (r8 == r3.getKey(3)) goto L25;
        if (r8 == null) goto L31;
        if (r8.equals(r3.getKey(3)) == false) goto L31;
    L25:
        if (r9 == r3.getKey(4)) goto L32;
        if (r9 == null) goto L31;
        if (r9.equals(r3.getKey(4)) == false) goto L31;
        return true;
    L32:
        return true;
    L31:
        return false;
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public MapIterator<MultiKey<? extends K>, V> mapIterator() {
        return decorated().mapIterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public /* synthetic */ Object put(Object r3, Object r4) {
        return put((MultiKey) ZeusTransformUtils.preCheckCast(r3, MultiKey.class, "com.obric.memorydata.plugin"), r4);
    }

    public V put(K r5, K r6, V r7) {
        int r0 = hash(r5, r6);
        int r1 = decorated().hashIndex(r0, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> r2 = decorated().data[r1];
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r2, r5, r6) == false) goto L10;
        V r8 = r2.getValue();
        decorated().updateEntry(r2, r7);
        return r8;
    L10:
        r2 = r2.next;
        goto L3
    L11:
        decorated().addMapping(r1, r0, new MultiKey(r5, r6), r7);
        return null;
    }

    public V put(K r5, K r6, K r7, V r8) {
        int r0 = hash(r5, r6, r7);
        int r1 = decorated().hashIndex(r0, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> r2 = decorated().data[r1];
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r2, r5, r6, r7) == false) goto L10;
        V r9 = r2.getValue();
        decorated().updateEntry(r2, r8);
        return r9;
    L10:
        r2 = r2.next;
        goto L3
    L11:
        decorated().addMapping(r1, r0, new MultiKey(r5, r6, r7), r8);
        return null;
    }

    public V put(K r10, K r11, K r12, K r13, V r14) {
        int r0 = hash(r10, r11, r12, r13);
        int r1 = decorated().hashIndex(r0, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> r2 = decorated().data[r1];
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r2, r10, r11, r12, r13) == false) goto L10;
        V r15 = r2.getValue();
        decorated().updateEntry(r2, r14);
        return r15;
    L10:
        r2 = r2.next;
        goto L3
    L11:
        decorated().addMapping(r1, r0, new MultiKey(r10, r11, r12, r13), r14);
        return null;
    }

    public V put(K r12, K r13, K r14, K r15, K r16, V r17) {
        int r1 = hash(r12, r13, r14, r15, r16);
        int r2 = decorated().hashIndex(r1, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> r3 = decorated().data[r2];
    L3:
        if (r3 == null) goto L11;
        if (r3.hashCode != r1) goto L10;
        if (isEqualKey(r3, r12, r13, r14, r15, r16) == false) goto L10;
        V r4 = r3.getValue();
        decorated().updateEntry(r3, r17);
        return r4;
    L10:
        r3 = r3.next;
        goto L3
    L11:
        decorated().addMapping(r2, r1, new MultiKey(r12, r13, r14, r15, r16), r17);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V put(MultiKey<? extends K> r1, V r2) {
        checkKey(r1);
        return (V) super.put(r1, r2);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends MultiKey<? extends K>, ? extends V> r5) {
        Map<? extends K, ? extends V> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Iterator<? extends K> r0 = r6.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        checkKey((MultiKey) ZeusTransformUtils.preCheckCast(r0.next(), MultiKey.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        super.putAll(r6);
    }

    public boolean removeAll(Object r6) {
        MapIterator<MultiKey<? extends K>, V> r5 = mapIterator();
        boolean r1 = false;
    L4:
        if (r5.hasNext() == false) goto L14;
        MultiKey r2 = (MultiKey) ZeusTransformUtils.preCheckCast(r5.next(), MultiKey.class, "com.obric.memorydata.plugin");
        if (r2.size() < 1) goto L4;
        Object r3 = r2.getKey(0);
        if (r6 == null) goto L9;
        if (r6.equals(r3) == false) goto L4;
    L13:
        r5.remove();
        r1 = true;
        goto L4
    L9:
        if (r3 != null) goto L4;
    L14:
        return r1;
    }

    public boolean removeAll(Object r7, Object r8) {
        MapIterator<MultiKey<? extends K>, V> r6 = mapIterator();
        boolean r1 = false;
    L4:
        if (r6.hasNext() == false) goto L20;
        MultiKey r2 = (MultiKey) ZeusTransformUtils.preCheckCast(r6.next(), MultiKey.class, "com.obric.memorydata.plugin");
        if (r2.size() < 2) goto L4;
        Object r3 = r2.getKey(0);
        if (r7 == null) goto L9;
        if (r7.equals(r3) == false) goto L4;
    L13:
        Object r4 = r2.getKey(1);
        if (r8 == null) goto L15;
        if (r8.equals(r4) == false) goto L4;
    L19:
        r6.remove();
        r1 = true;
        goto L4
    L15:
        if (r4 != null) goto L4;
    L9:
        if (r3 != null) goto L4;
    L20:
        return r1;
    }

    public boolean removeAll(Object r7, Object r8, Object r9) {
        MapIterator<MultiKey<? extends K>, V> r6 = mapIterator();
        boolean r1 = false;
    L4:
        if (r6.hasNext() == false) goto L26;
        MultiKey r2 = (MultiKey) ZeusTransformUtils.preCheckCast(r6.next(), MultiKey.class, "com.obric.memorydata.plugin");
        if (r2.size() < 3) goto L4;
        Object r3 = r2.getKey(0);
        if (r7 == null) goto L9;
        if (r7.equals(r3) == false) goto L4;
    L13:
        Object r4 = r2.getKey(1);
        if (r8 == null) goto L15;
        if (r8.equals(r4) == false) goto L4;
    L19:
        Object r5 = r2.getKey(2);
        if (r9 == null) goto L21;
        if (r9.equals(r5) == false) goto L4;
    L25:
        r6.remove();
        r1 = true;
        goto L4
    L21:
        if (r5 != null) goto L4;
    L15:
        if (r4 != null) goto L4;
    L9:
        if (r3 != null) goto L4;
    L26:
        return r1;
    }

    public boolean removeAll(Object r7, Object r8, Object r9, Object r10) {
        MapIterator<MultiKey<? extends K>, V> r6 = mapIterator();
        boolean r1 = false;
    L4:
        if (r6.hasNext() == false) goto L32;
        MultiKey r2 = (MultiKey) ZeusTransformUtils.preCheckCast(r6.next(), MultiKey.class, "com.obric.memorydata.plugin");
        if (r2.size() < 4) goto L4;
        Object r3 = r2.getKey(0);
        if (r7 == null) goto L9;
        if (r7.equals(r3) == false) goto L4;
    L13:
        Object r4 = r2.getKey(1);
        if (r8 == null) goto L15;
        if (r8.equals(r4) == false) goto L4;
    L19:
        Object r5 = r2.getKey(2);
        if (r9 == null) goto L21;
        if (r9.equals(r5) == false) goto L4;
    L25:
        Object r11 = r2.getKey(3);
        if (r10 == null) goto L27;
        if (r10.equals(r11) == false) goto L4;
    L31:
        r6.remove();
        r1 = true;
        goto L4
    L27:
        if (r11 != null) goto L4;
    L21:
        if (r5 != null) goto L4;
    L15:
        if (r4 != null) goto L4;
    L9:
        if (r3 != null) goto L4;
    L32:
        return r1;
    }

    public V removeMultiKey(Object r8, Object r9) {
        int r0 = hash(r8, r9);
        int r1 = decorated().hashIndex(r0, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> r2 = decorated().data[r1];
        AbstractHashedMap.HashEntry<K, V> r4 = null;
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r2, r8, r9) == false) goto L10;
        V r10 = r2.getValue();
        decorated().removeMapping(r2, r1, r4);
        return r10;
    L10:
        r4 = r2;
        r2 = r2.next;
        goto L3
    L11:
        return null;
    }

    public V removeMultiKey(Object r8, Object r9, Object r10) {
        int r0 = hash(r8, r9, r10);
        int r1 = decorated().hashIndex(r0, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> r2 = decorated().data[r1];
        AbstractHashedMap.HashEntry<K, V> r4 = null;
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r2, r8, r9, r10) == false) goto L10;
        V r11 = r2.getValue();
        decorated().removeMapping(r2, r1, r4);
        return r11;
    L10:
        r4 = r2;
        r2 = r2.next;
        goto L3
    L11:
        return null;
    }

    public V removeMultiKey(Object r12, Object r13, Object r14, Object r15) {
        int r0 = hash(r12, r13, r14, r15);
        int r1 = decorated().hashIndex(r0, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> r2 = decorated().data[r1];
        AbstractHashedMap.HashEntry<K, V> r10 = null;
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r2, r12, r13, r14, r15) == false) goto L10;
        V r16 = r2.getValue();
        decorated().removeMapping(r2, r1, r10);
        return r16;
    L10:
        r10 = r2;
        r2 = r2.next;
        goto L3
    L11:
        return null;
    }

    public V removeMultiKey(Object r13, Object r14, Object r15, Object r16, Object r17) {
        int r0 = hash(r13, r14, r15, r16, r17);
        int r1 = decorated().hashIndex(r0, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> r2 = decorated().data[r1];
        AbstractHashedMap.HashEntry<K, V> r11 = null;
    L3:
        if (r2 == null) goto L11;
        if (r2.hashCode != r0) goto L10;
        if (isEqualKey(r2, r13, r14, r15, r16, r17) == false) goto L10;
        V r3 = r2.getValue();
        decorated().removeMapping(r2, r1, r11);
        return r3;
    L10:
        r11 = r2;
        r2 = r2.next;
        goto L3
    L11:
        return null;
    }
}

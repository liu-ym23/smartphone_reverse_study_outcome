package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public class LinkedListMultimap<K, V> extends g0 implements x5, Serializable {
    private static final long serialVersionUID = 0;
    public transient u5 f;
    public transient u5 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient HashMap f8845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient int f8846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient int f8847j;

    public LinkedListMultimap() {
        this(12);
    }

    public static /* synthetic */ int access$000(LinkedListMultimap r5) {
        return r5.f8847j;
    }

    public static /* synthetic */ u5 access$100(LinkedListMultimap r5) {
        return r5.g;
    }

    public static /* synthetic */ u5 access$200(LinkedListMultimap r5) {
        return r5.f;
    }

    public static void access$300(LinkedListMultimap r5, u5 r10) {
        r5.getClass();
        u5 r11 = r10.d;
        if (r11 == null) goto L5;
        r11.f9184c = r10.f9184c;
    L6:
        u5 r12 = r10.f9184c;
        if (r12 == null) goto L9;
        r12.d = r11;
    L10:
        u5 r13 = r10.f;
        Object r14 = r10.f9182a;
        if (r13 == null) goto L13;
    L15:
        t5 r15 = (t5) r5.f8845h.get(r14);
        Objects.requireNonNull(r15);
        r15.f9168c--;
        u5 r16 = r10.f;
        if (r16 != null) goto L18;
        u5 r17 = r10.e;
        Objects.requireNonNull(r17);
        r15.f9166a = r17;
    L19:
        u5 r18 = r10.e;
        if (r18 != null) goto L22;
        u5 r19 = r10.f;
        Objects.requireNonNull(r19);
        r15.f9167b = r19;
    L23:
        r5.f8846i--;
        return;
    L22:
        r18.f = r10.f;
        goto L23
    L18:
        r16.e = r10.e;
        goto L19
    L13:
        if (r10.e != null) goto L15;
        t5 r20 = (t5) r5.f8845h.remove(r14);
        Objects.requireNonNull(r20);
        r20.f9168c = 0;
        r5.f8847j++;
        goto L23
    L9:
        r5.g = r11;
        goto L10
    L5:
        r5.f = r10.f9184c;
        goto L6
    }

    public static void access$400(LinkedListMultimap r5, Object r10) {
        r5.getClass();
        p7.u(new w5(r5, r10));
    }

    public static /* synthetic */ Map access$500(LinkedListMultimap r5) {
        return r5.f8845h;
    }

    public static /* synthetic */ u5 access$600(LinkedListMultimap r5, Object r10, Object r11, u5 r12) {
        return r5.a(r10, r11, r12);
    }

    public static /* synthetic */ int access$800(LinkedListMultimap r5) {
        return r5.f8846i;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        this.f8845h = new LinkedHashMap();
        int r10 = r5.readInt();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        put(r5.readObject(), r5.readObject());
        r11 = r11 + 1;
        goto L3
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeInt(size());
        Iterator<Map.Entry<K, V>> r10 = entries().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<K, V> r11 = r10.next();
        r5.writeObject(r11.getKey());
        r5.writeObject(r11.getValue());
        goto L4
    }

    public final u5 a(Object r5, Object r10, u5 r11) {
        u5 r12 = new u5(r5, r10);
        if (this.f != null) goto L5;
        this.g = r12;
        this.f = r12;
        this.f8845h.put(r5, new t5(r12));
        this.f8847j++;
    L19:
        this.f8846i++;
        return r12;
    L5:
        if (r11 != null) goto L10;
        u5 r13 = this.g;
        Objects.requireNonNull(r13);
        r13.f9184c = r12;
        r12.d = this.g;
        this.g = r12;
        t5 r14 = (t5) this.f8845h.get(r5);
        if (r14 != null) goto L9;
        this.f8845h.put(r5, new t5(r12));
        this.f8847j++;
        goto L19
    L9:
        r14.f9168c++;
        u5 r15 = r14.f9167b;
        r15.e = r12;
        r12.f = r15;
        r14.f9167b = r12;
        goto L19
    L10:
        t5 r16 = (t5) this.f8845h.get(r5);
        Objects.requireNonNull(r16);
        r16.f9168c++;
        r12.d = r11.d;
        r12.f = r11.f;
        r12.f9184c = r11;
        r12.e = r11;
        u5 r17 = r11.f;
        if (r17 != null) goto L13;
        r16.f9166a = r12;
    L14:
        u5 r18 = r11.d;
        if (r18 != null) goto L17;
        this.f = r12;
    L18:
        r11.d = r12;
        r11.f = r12;
        goto L19
    L17:
        r18.f9184c = r12;
        goto L18
    L13:
        r17.e = r12;
        goto L14
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.q7
    public void clear() {
        this.f = null;
        this.g = null;
        this.f8845h.clear();
        this.f8846i = 0;
        this.f8847j++;
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean containsEntry(Object r5, Object r10) {
        return super.containsEntry(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public boolean containsKey(Object r5) {
        return this.f8845h.containsKey(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean containsValue(Object r5) {
        return values().contains(r5);
    }

    @Override // com.google.common.collect.g0
    public Map<K, Collection<V>> createAsMap() {
        return new f9(this);
    }

    public /* bridge */ /* synthetic */ Collection createEntries() {
        return m96createEntries();
    }

    @Override // com.google.common.collect.g0
    public Set<K> createKeySet() {
        return new a9(this, 1);
    }

    @Override // com.google.common.collect.g0
    public z7 createKeys() {
        return new v7(this);
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
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    @Override // com.google.common.collect.q7
    public void forEach(BiConsumer r5) {
        r5.getClass();
        entries().forEach(new l5(r5, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean isEmpty() {
        if (this.f != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ z7 keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.q7
    public boolean put(K r5, V r10) {
        a(r5, r10, null);
        return true;
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean putAll(q7 r5) {
        return super.putAll(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean remove(Object r5, Object r10) {
        return super.remove(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public int size() {
        return this.f8846i;
    }

    @Override // com.google.common.collect.g0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public LinkedListMultimap(int r5) {
        int r10 = h8.f9015a;
        this.f8845h = p7.X(r5);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int r5) {
        return new LinkedListMultimap(r5);
    }

    /* JADX INFO: renamed from: createEntries, reason: collision with other method in class */
    public List<Map.Entry<K, V>> m96createEntries() {
        return new r5(this, 0);
    }

    @Override // com.google.common.collect.g0
    public List<V> createValues() {
        return new r5(this, 1);
    }

    @Override // com.google.common.collect.q7
    public List<Map.Entry<K, V>> entries() {
        Collection r5 = this.f8983a;
        if (r5 != null) goto L6;
        r5 = createEntries();
        this.f8983a = r5;
    L6:
        return (List) r5;
    }

    @Override // com.google.common.collect.q7
    public List<V> get(K r5) {
        return new q5(this, r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean putAll(Object r5, Iterable r10) {
        return super.putAll(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public List<V> removeAll(Object r5) {
        List<V> r10 = Collections.unmodifiableList(p7.V(new w5(this, r5)));
        p7.u(new w5(this, r5));
        return r10;
    }

    @Override // com.google.common.collect.q7
    public List<V> replaceValues(K r5, Iterable<? extends V> r10) {
        List<V> r11 = Collections.unmodifiableList(p7.V(new w5(this, r5)));
        w5 r12 = new w5(this, r5);
        Iterator<? extends V> r13 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r13.hasNext() == false) goto L9;
        r12.next();
        r12.set(r13.next());
    L9:
        if (r12.hasNext() == false) goto L12;
        r12.next();
        r12.remove();
    L12:
        if (r13.hasNext() == false) goto L14;
        r12.add(r13.next());
        goto L12
    L14:
        return r11;
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(q7 r5) {
        LinkedListMultimap<K, V> r10 = new LinkedListMultimap(r5.keySet().size());
        r10.putAll(r5);
        return r10;
    }
}

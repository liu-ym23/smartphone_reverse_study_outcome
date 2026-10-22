package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
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
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedTreeMap<K, V>.KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ LinkedTreeMap this$0;

        public EntrySet(LinkedTreeMap r5) {
            this.this$0 = r5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            if ((r5 instanceof Map.Entry) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.findByEntry((Map.Entry) r5) == null) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r5) {
            if ((r5 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Node<K, V> r10 = this.this$0.findByEntry((Map.Entry) r5);
            if (r10 != null) goto L8;
            return false;
        L8:
            this.this$0.removeInternal(r10, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }
    }

    public final class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedTreeMap this$0;

        public KeySet(LinkedTreeMap r5) {
            this.this$0 = r5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            return this.this$0.containsKey(r5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r5) {
            if (this.this$0.removeInternalByKey(r5) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned;
        Node<K, V> next;
        final /* synthetic */ LinkedTreeMap this$0;

        public LinkedTreeMapIterator(LinkedTreeMap r5) {
            this.this$0 = r5;
            this.next = r5.header.next;
            this.lastReturned = null;
            this.expectedModCount = r5.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next == this.this$0.header) goto L5;
            return true;
        L5:
            return false;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> r5 = this.next;
            LinkedTreeMap r10 = this.this$0;
            if (r5 == r10.header) goto L11;
            if (r10.modCount != this.expectedModCount) goto L9;
            this.next = r5.next;
            this.lastReturned = r5;
            return r5;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> r5 = this.lastReturned;
            if (r5 == null) goto L7;
            this.this$0.removeInternal(r5, true);
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {
        final boolean allowNullValue;
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        public Node(boolean r5) {
            this.key = null;
            this.allowNullValue = r5;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if ((r5 instanceof Map.Entry) == false) goto L20;
            Map.Entry r10 = (Map.Entry) r5;
            K r11 = this.key;
            if (r11 != null) goto L10;
            if (r10.getKey() != null) goto L21;
        L11:
            V r12 = this.value;
            if (r12 != null) goto L17;
            if (r10.getValue() != null) goto L23;
        L18:
            return true;
        L23:
            return false;
        L17:
            if (r12.equals(r10.getValue()) == true) goto L18;
            return false;
        L21:
            return false;
        L10:
            if (r11.equals(r10.getKey()) == true) goto L11;
            return false;
        L20:
            return false;
        }

        public Node<K, V> first() {
            Node<K, V> r5 = this.left;
        L3:
            Node<K, V> r10 = r5;
            Node<K, V> r11 = this;
            Node<K, V> this = r10;
            if (this == null) goto L6;
            r5 = this.left;
            goto L3
        L6:
            return r11;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r5 = this.key;
            int r10 = 0;
            if (r5 != null) goto L5;
            int r11 = 0;
        L6:
            V r12 = this.value;
            if (r12 == null) goto L11;
            r10 = r12.hashCode();
        L11:
            return r11 ^ r10;
        L5:
            r11 = r5.hashCode();
            goto L6
        }

        public Node<K, V> last() {
            Node<K, V> r5 = this.right;
        L3:
            Node<K, V> r10 = r5;
            Node<K, V> r11 = this;
            Node<K, V> this = r10;
            if (this == null) goto L6;
            r5 = this.right;
            goto L3
        L6:
            return r11;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r5) {
            if (r5 == null) goto L4;
        L8:
            V r10 = this.value;
            this.value = r5;
            return r10;
        L4:
            if (this.allowNullValue == true) goto L8;
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node(boolean r5, Node<K, V> r10, K r11, Node<K, V> r12, Node<K, V> r13) {
            this.parent = r10;
            this.key = r11;
            this.allowNullValue = r5;
            this.height = 1;
            this.next = r12;
            this.prev = r13;
            r13.next = this;
            r12.prev = this;
        }
    }

    static {
        NATURAL_ORDER = new AnonymousClass1();
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER, true);
    }

    private static boolean equal(Object r5, Object r10) {
        return Objects.equals(r5, r10);
    }

    private void readObject(ObjectInputStream r5) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(Node<K, V> r10, boolean r11) {
    L2:
        if (r10 == null) goto L52;
        Node<K, V> r5 = r10.left;
        Node<K, V> r12 = r10.right;
        int r13 = 0;
        if (r5 == null) goto L6;
        int r14 = r5.height;
    L7:
        if (r12 == null) goto L9;
        int r15 = r12.height;
    L10:
        int r16 = r14 - r15;
        if (r16 != (-2)) goto L28;
        Node<K, V> r17 = r12.left;
        Node<K, V> r18 = r12.right;
        if (r18 == null) goto L15;
        int r19 = r18.height;
    L16:
        if (r17 == null) goto L18;
        r13 = r17.height;
    L18:
        int r20 = r13 - r19;
        if (r20 == (-1)) goto L24;
        if (r20 != 0) goto L23;
        if (r11 == false) goto L24;
    L23:
        rotateRight(r12);
        rotateLeft(r10);
    L25:
        if (r11 == false) goto L51;
        return;
    L51:
        r10 = r10.parent;
    L24:
        rotateLeft(r10);
        goto L25
    L15:
        r19 = 0;
        goto L16
    L28:
        if (r16 != 2) goto L44;
        Node<K, V> r21 = r5.left;
        Node<K, V> r22 = r5.right;
        if (r22 == null) goto L32;
        int r23 = r22.height;
    L33:
        if (r21 == null) goto L35;
        r13 = r21.height;
    L35:
        int r24 = r13 - r23;
        if (r24 == 1) goto L41;
        if (r24 != 0) goto L40;
        if (r11 == false) goto L41;
    L40:
        rotateLeft(r5);
        rotateRight(r10);
    L42:
        if (r11 == false) goto L51;
        return;
    L41:
        rotateRight(r10);
        goto L42
    L32:
        r23 = 0;
        goto L33
    L44:
        if (r16 != 0) goto L48;
        r10.height = r14 + 1;
        if (r11 == false) goto L51;
        return;
    L48:
        r10.height = Math.max(r14, r15) + 1;
        if (r11 == true) goto L51;
        return;
    L9:
        r15 = 0;
        goto L10
    L6:
        r14 = 0;
        goto L7
    }

    private void replaceInParent(Node<K, V> r5, Node<K, V> r10) {
        Node<K, V> r11 = r5.parent;
        r5.parent = null;
        if (r10 == null) goto L5;
        r10.parent = r11;
    L5:
        if (r11 != null) goto L7;
        this.root = r10;
        return;
    L7:
        if (r11.left != r5) goto L9;
        r11.left = r10;
        return;
    L9:
        r11.right = r10;
    }

    private void rotateLeft(Node<K, V> r5) {
        Node<K, V> r10 = r5.left;
        Node<K, V> r11 = r5.right;
        Node<K, V> r12 = r11.left;
        Node<K, V> r13 = r11.right;
        r5.right = r12;
        if (r12 == null) goto L5;
        r12.parent = r5;
    L5:
        replaceInParent(r5, r11);
        r11.left = r5;
        r5.parent = r11;
        int r14 = 0;
        if (r10 == null) goto L8;
        int r15 = r10.height;
    L9:
        if (r12 == null) goto L11;
        int r16 = r12.height;
    L12:
        int r17 = Math.max(r15, r16) + 1;
        r5.height = r17;
        if (r13 == null) goto L15;
        r14 = r13.height;
    L15:
        r11.height = Math.max(r17, r14) + 1;
        return;
    L11:
        r16 = 0;
        goto L12
    L8:
        r15 = 0;
        goto L9
    }

    private void rotateRight(Node<K, V> r5) {
        Node<K, V> r10 = r5.left;
        Node<K, V> r11 = r5.right;
        Node<K, V> r12 = r10.left;
        Node<K, V> r13 = r10.right;
        r5.left = r13;
        if (r13 == null) goto L5;
        r13.parent = r5;
    L5:
        replaceInParent(r5, r10);
        r10.right = r5;
        r5.parent = r10;
        int r14 = 0;
        if (r11 == null) goto L8;
        int r15 = r11.height;
    L9:
        if (r13 == null) goto L11;
        int r16 = r13.height;
    L12:
        int r17 = Math.max(r15, r16) + 1;
        r5.height = r17;
        if (r12 == null) goto L15;
        r14 = r12.height;
    L15:
        r10.height = Math.max(r17, r14) + 1;
        return;
    L11:
        r16 = 0;
        goto L12
    L8:
        r15 = 0;
        goto L9
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> r5 = this.header;
        r5.prev = r5;
        r5.next = r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r5) {
        if (findByObject(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet r5 = this.entrySet;
        if (r5 != null) goto L6;
        LinkedTreeMap<K, V>.EntrySet r10 = new EntrySet(this);
        this.entrySet = r10;
        return r10;
    L6:
        return r5;
    }

    public Node<K, V> find(K r12, boolean r13) {
        Comparator<? super K> r5 = this.comparator;
        Node<K, V> r10 = this.root;
        if (r10 != null) goto L5;
        int r11 = 0;
    L20:
        if (r13 == true) goto L22;
        return null;
    L22:
        Node<K, V> r14 = this.header;
        if (r10 == null) goto L25;
        Node<K, V> r15 = new Node(this.allowNullValues, r10, r12, r14, r14.prev);
        if (r11 >= 0) goto L35;
        r10.left = r15;
    L36:
        rebalance(r10, true);
    L37:
        this.size++;
        this.modCount++;
        return r15;
    L35:
        r10.right = r15;
        goto L36
    L25:
        if (r5 == NATURAL_ORDER) goto L27;
    L31:
        r15 = new Node(this.allowNullValues, r10, r12, r14, r14.prev);
        this.root = r15;
        goto L37
    L27:
        if ((r12 instanceof Comparable) == true) goto L31;
        throw new ClassCastException(r12.getClass().getName().concat(" is not Comparable"));
    L5:
        if (r5 != NATURAL_ORDER) goto L7;
        Comparable r16 = (Comparable) r12;
    L8:
        if (r16 == null) goto L10;
        r11 = r16.compareTo(r10.key);
    L11:
        if (r11 == 0) goto L12;
        if (r11 >= 0) goto L15;
        Node<K, V> r17 = r10.left;
    L16:
        if (r17 == null) goto L20;
        r10 = r17;
        goto L8
    L15:
        r17 = r10.right;
        goto L16
    L12:
        return r10;
    L10:
        r11 = r5.compare(r12, r10.key);
        goto L11
    L7:
        r16 = null;
        goto L8
    }

    public Node<K, V> findByEntry(Map.Entry<?, ?> r5) {
        Node<K, V> r10 = findByObject(r5.getKey());
        if (r10 != null) goto L5;
    L7:
        return null;
    L5:
        if (equal(r10.value, r5.getValue()) == false) goto L7;
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node<K, V> findByObject(Object r5) {
        if (r5 != 0) goto L8;
        return null;
    L8:
        return find(r5, false);
    L11:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r5) {
        Node<K, V> r10 = findByObject(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet r5 = this.keySet;
        if (r5 != null) goto L6;
        LinkedTreeMap<K, V>.KeySet r10 = new KeySet(this);
        this.keySet = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r5, V r10) {
        if (r5 == null) goto L12;
        if (r10 == null) goto L5;
    L9:
        Node<K, V> r11 = find(r5, true);
        V r12 = r11.value;
        r11.value = r10;
        return r12;
    L5:
        if (this.allowNullValues == true) goto L9;
        throw new NullPointerException("value == null");
    L12:
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r5) {
        Node<K, V> r10 = removeInternalByKey(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.value;
    }

    public void removeInternal(Node<K, V> r10, boolean r11) {
        if (r11 == false) goto L4;
        Node<K, V> r12 = r10.prev;
        r12.next = r10.next;
        r10.next.prev = r12;
    L4:
        Node<K, V> r13 = r10.left;
        Node<K, V> r5 = r10.right;
        Node<K, V> r14 = r10.parent;
        int r15 = 0;
        if (r13 == null) goto L20;
        if (r5 == null) goto L20;
        if (r13.height <= r5.height) goto L10;
        Node<K, V> r16 = r13.last();
    L11:
        removeInternal(r16, false);
        Node<K, V> r17 = r10.left;
        if (r17 == null) goto L14;
        int r18 = r17.height;
        r16.left = r17;
        r17.parent = r16;
        r10.left = null;
    L15:
        Node<K, V> r19 = r10.right;
        if (r19 == null) goto L18;
        r15 = r19.height;
        r16.right = r19;
        r19.parent = r16;
        r10.right = null;
    L18:
        r16.height = Math.max(r18, r15) + 1;
        replaceInParent(r10, r16);
        return;
    L14:
        r18 = 0;
        goto L15
    L10:
        r16 = r5.first();
    L20:
        if (r13 == null) goto L22;
        replaceInParent(r10, r13);
        r10.left = null;
    L25:
        rebalance(r14, false);
        this.size--;
        this.modCount++;
        return;
    L22:
        if (r5 == null) goto L24;
        replaceInParent(r10, r5);
        r10.right = null;
        goto L25
    L24:
        replaceInParent(r10, null);
        goto L25
    }

    public Node<K, V> removeInternalByKey(Object r5) {
        Node<K, V> r10 = findByObject(r5);
        if (r10 == null) goto L5;
        removeInternal(r10, true);
    L5:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(boolean r5) {
        this(NATURAL_ORDER, r5);
    }

    public LinkedTreeMap(Comparator<? super K> r5, boolean r10) {
        this.size = 0;
        this.modCount = 0;
        if (r5 != null) goto L6;
        r5 = NATURAL_ORDER;
    L6:
        this.comparator = r5;
        this.allowNullValues = r10;
        this.header = new Node(r10);
    }
}

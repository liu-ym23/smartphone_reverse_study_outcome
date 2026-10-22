package org.apache.commons.collections4.bidimap;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;

/* JADX INFO: loaded from: classes6.dex */
public class TreeBidiMap<K extends Comparable<K>, V extends Comparable<V>> implements Serializable, OrderedBidiMap<K, V> {
    private static final long serialVersionUID = 721969328361807L;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient TreeBidiMap<K, V>.Inverse inverse;
    private transient Set<K> keySet;
    private transient int modifications;
    private transient int nodeCount;
    private transient Node<K, V>[] rootNode;
    private transient Set<V> valuesSet;

    /* JADX INFO: renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement = null;

        static {
            int[] r0 = new int[DataElement.values().length];
            $SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement = r0;
            r0[DataElement.KEY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement[DataElement.VALUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static final enum DataElement extends Enum<DataElement> {
        private static final /* synthetic */ DataElement[] $VALUES = null;
        public static final DataElement KEY = null;
        public static final DataElement VALUE = null;
        private final String description;

        static {
            DataElement r0 = new DataElement("KEY", 0, "key");
            KEY = r0;
            DataElement r1 = new DataElement("VALUE", 1, EventBody.KEY_VALUE);
            VALUE = r1;
            $VALUES = new DataElement[]{r0, r1};
        }

        private DataElement(String r1, int r2, String r3) {
            super(r1, r2);
            this.description = r3;
        }

        public static DataElement valueOf(String r2) {
            return (DataElement) ZeusTransformUtils.preCheckCast(Enum.valueOf(DataElement.class, r2), DataElement.class, "com.obric.memorydata.plugin");
        }

        public static DataElement[] values() {
            return (DataElement[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DataElement[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    class EntryView extends TreeBidiMap<K, V>.View<Map.Entry<K, V>> {
        final /* synthetic */ TreeBidiMap this$0;

        EntryView(TreeBidiMap r2) {
            this.this$0 = r2;
            super(r2, DataElement.KEY);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getValue();
            Node r3 = TreeBidiMap.access$1600(this.this$0, r5.getKey());
            if (r3 != null) goto L8;
            return false;
        L8:
            if (r3.getValue().equals(r0) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new ViewMapEntryIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getValue();
            Node r6 = TreeBidiMap.access$1600(this.this$0, r5.getKey());
            if (r6 != null) goto L8;
        L11:
            return false;
        L8:
            if (r6.getValue().equals(r0) == false) goto L11;
            TreeBidiMap.access$2000(this.this$0, r6);
            return true;
        }
    }

    class Inverse implements OrderedBidiMap<V, K> {
        private Set<Map.Entry<V, K>> inverseEntrySet;
        private Set<V> inverseKeySet;
        private Set<K> inverseValuesSet;
        final /* synthetic */ TreeBidiMap this$0;

        Inverse(TreeBidiMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.Map
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object r1) {
            return this.this$0.containsValue(r1);
        }

        @Override // java.util.Map
        public boolean containsValue(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            if (this.inverseEntrySet != null) goto L6;
            this.inverseEntrySet = new InverseEntryView(this.this$0);
        L6:
            return this.inverseEntrySet;
        }

        @Override // java.util.Map
        public boolean equals(Object r2) {
            return TreeBidiMap.access$3100(this.this$0, r2, DataElement.VALUE);
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V firstKey() {
            if (TreeBidiMap.access$2700(this.this$0) == 0) goto L7;
            TreeBidiMap r2 = this.this$0;
            return (V) TreeBidiMap.access$2300(r2, TreeBidiMap.access$2200(r2)[DataElement.VALUE.ordinal()], DataElement.VALUE).getValue();
        L7:
            throw new NoSuchElementException("Map is empty");
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public /* bridge */ /* synthetic */ Object firstKey() {
            return firstKey();
        }

        @Override // java.util.Map
        public K get(Object r1) {
            return (K) this.this$0.getKey(r1);
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r1) {
            return get(r1);
        }

        @Override // java.util.Map
        public int hashCode() {
            return TreeBidiMap.access$3200(this.this$0, DataElement.VALUE);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.Map
        public Set<V> keySet() {
            if (this.inverseKeySet != null) goto L6;
            this.inverseKeySet = new ValueView(this.this$0, DataElement.VALUE);
        L6:
            return this.inverseKeySet;
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V lastKey() {
            if (TreeBidiMap.access$2700(this.this$0) == 0) goto L7;
            TreeBidiMap r2 = this.this$0;
            return (V) TreeBidiMap.access$2600(r2, TreeBidiMap.access$2200(r2)[DataElement.VALUE.ordinal()], DataElement.VALUE).getValue();
        L7:
            throw new NoSuchElementException("Map is empty");
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public /* bridge */ /* synthetic */ Object lastKey() {
            return lastKey();
        }

        @Override // org.apache.commons.collections4.IterableGet
        public /* bridge */ /* synthetic */ MapIterator mapIterator() {
            return mapIterator();
        }

        @Override // org.apache.commons.collections4.IterableGet
        public OrderedMapIterator<V, K> mapIterator() {
            if (isEmpty() == false) goto L7;
            return EmptyOrderedMapIterator.emptyOrderedMapIterator();
        L7:
            return new InverseViewMapIterator(this.this$0, DataElement.VALUE);
        }

        public V nextKey(V r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            TreeBidiMap.access$2800(r4);
            TreeBidiMap r2 = this.this$0;
            Node r5 = TreeBidiMap.access$2400(r2, TreeBidiMap.access$2900(r2, r4, DataElement.VALUE), DataElement.VALUE);
            if (r5 != null) goto L6;
            return null;
        L6:
            return (V) r5.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.OrderedMap
        public /* synthetic */ Object nextKey(Object r3) {
            return nextKey((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
        }

        public V previousKey(V r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            TreeBidiMap.access$2800(r4);
            TreeBidiMap r2 = this.this$0;
            Node r5 = TreeBidiMap.access$2500(r2, TreeBidiMap.access$2900(r2, r4, DataElement.VALUE), DataElement.VALUE);
            if (r5 != null) goto L6;
            return null;
        L6:
            return (V) r5.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.OrderedMap
        public /* synthetic */ Object previousKey(Object r3) {
            return previousKey((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
        }

        public K put(V r3, K r4) {
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            K r0 = (K) get(r5);
            TreeBidiMap.access$3000(this.this$0, r6, r5);
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* synthetic */ Object put(Object r3, Object r4) {
            return put((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void putAll(Map<? extends V, ? extends K> r5) {
            Iterator r6 = ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            put((Comparable) ZeusTransformUtils.preCheckCast(r0.getKey(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r0.getValue(), Comparable.class, "com.obric.memorydata.plugin"));
            goto L4
        }

        @Override // java.util.Map
        public K remove(Object r1) {
            return (K) this.this$0.removeValue(r1);
        }

        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object remove(Object r1) {
            return remove(r1);
        }

        @Override // java.util.Map
        public int size() {
            return this.this$0.size();
        }

        public String toString() {
            return TreeBidiMap.access$3300(this.this$0, DataElement.VALUE);
        }

        @Override // org.apache.commons.collections4.BidiMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        @Override // org.apache.commons.collections4.BidiMap, java.util.Map
        public Set<K> values() {
            if (this.inverseValuesSet != null) goto L6;
            this.inverseValuesSet = new KeyView(this.this$0, DataElement.VALUE);
        L6:
            return this.inverseValuesSet;
        }
    }

    class InverseEntryView extends TreeBidiMap<K, V>.View<Map.Entry<V, K>> {
        final /* synthetic */ TreeBidiMap this$0;

        InverseEntryView(TreeBidiMap r2) {
            this.this$0 = r2;
            super(r2, DataElement.VALUE);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getValue();
            Node r3 = TreeBidiMap.access$1800(this.this$0, r5.getKey());
            if (r3 != null) goto L8;
            return false;
        L8:
            if (r3.getKey().equals(r0) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<V, K>> iterator() {
            return new InverseViewMapEntryIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getValue();
            Node r6 = TreeBidiMap.access$1800(this.this$0, r5.getKey());
            if (r6 != null) goto L8;
        L11:
            return false;
        L8:
            if (r6.getKey().equals(r0) == false) goto L11;
            TreeBidiMap.access$2000(this.this$0, r6);
            return true;
        }
    }

    class InverseViewMapEntryIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedIterator<Map.Entry<V, K>> {
        final /* synthetic */ TreeBidiMap this$0;

        InverseViewMapEntryIterator(TreeBidiMap r2) {
            this.this$0 = r2;
            super(r2, DataElement.VALUE);
        }

        private Map.Entry<V, K> createEntry(Node<K, V> r2) {
            return new UnmodifiableMapEntry(r2.getValue(), r2.getKey());
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<V, K> next() {
            return createEntry(navigateNext());
        }
    }

    class InverseViewMapIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedMapIterator<V, K> {
        final /* synthetic */ TreeBidiMap this$0;

        public InverseViewMapIterator(TreeBidiMap r1, DataElement r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getValue() {
            if (this.lastReturnedNode == null) goto L7;
            return (K) this.lastReturnedNode.getKey();
        L7:
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public /* bridge */ /* synthetic */ Object getValue() {
            return getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public V next() {
            return (V) navigateNext().getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }
    }

    class KeyView extends TreeBidiMap<K, V>.View<K> {
        final /* synthetic */ TreeBidiMap this$0;

        public KeyView(TreeBidiMap r1, DataElement r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            TreeBidiMap.access$1500(r2, DataElement.KEY);
            if (TreeBidiMap.access$1600(this.this$0, r2) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new ViewMapIterator(this.this$0, this.orderType);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (TreeBidiMap.access$1700(this.this$0, r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static class Node<K extends Comparable<K>, V extends Comparable<V>> implements Map.Entry<K, V>, KeyValue<K, V> {
        private final boolean[] blackColor;
        private boolean calculatedHashCode;
        private int hashcodeValue;
        private final K key;
        private final Node<K, V>[] leftNode;
        private final Node<K, V>[] parentNode;
        private final Node<K, V>[] rightNode;
        private final V value;

        Node(K r3, V r4) {
            K r5 = (K) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            V r6 = (V) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            this.key = r5;
            this.value = r6;
            this.leftNode = new Node[2];
            this.rightNode = new Node[2];
            this.parentNode = new Node[2];
            this.blackColor = new boolean[]{true, true};
            this.calculatedHashCode = false;
        }

        static /* synthetic */ Node access$000(Node r0, DataElement r1) {
            return r0.getLeft(r1);
        }

        static /* synthetic */ void access$100(Node r0, Node r1, DataElement r2) {
            r0.setLeft(r1, r2);
        }

        static /* synthetic */ boolean access$1000(Node r0, DataElement r1) {
            return r0.isBlack(r1);
        }

        static /* synthetic */ void access$1100(Node r0, DataElement r1) {
            r0.setRed(r1);
        }

        static /* synthetic */ boolean access$1200(Node r0, DataElement r1) {
            return r0.isLeftChild(r1);
        }

        static /* synthetic */ boolean access$1300(Node r0, DataElement r1) {
            return r0.isRightChild(r1);
        }

        static /* synthetic */ void access$1400(Node r0, Node r1, DataElement r2) {
            r0.swapColors(r1, r2);
        }

        static /* synthetic */ void access$200(Node r0, Node r1, DataElement r2) {
            r0.setParent(r1, r2);
        }

        static /* synthetic */ Node access$300(Node r0, DataElement r1) {
            return r0.getRight(r1);
        }

        static /* synthetic */ void access$400(Node r0, Node r1, DataElement r2) {
            r0.setRight(r1, r2);
        }

        static /* synthetic */ Object access$500(Node r0, DataElement r1) {
            return r0.getData(r1);
        }

        static /* synthetic */ Node access$600(Node r0, DataElement r1) {
            return r0.getParent(r1);
        }

        static /* synthetic */ void access$700(Node r0, DataElement r1) {
            r0.setBlack(r1);
        }

        static /* synthetic */ void access$800(Node r0, Node r1, DataElement r2) {
            r0.copyColor(r1, r2);
        }

        static /* synthetic */ boolean access$900(Node r0, DataElement r1) {
            return r0.isRed(r1);
        }

        private void copyColor(Node<K, V> r2, DataElement r3) {
            this.blackColor[r3.ordinal()] = r2.blackColor[r3.ordinal()];
        }

        private Object getData(DataElement r2) {
            int r3 = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement[r2.ordinal()];
            if (r3 == 1) goto L11;
            if (r3 != 2) goto L9;
            return getValue();
        L9:
            throw new IllegalArgumentException();
        L11:
            return getKey();
        }

        private Node<K, V> getLeft(DataElement r1) {
            return this.leftNode[r1.ordinal()];
        }

        private Node<K, V> getParent(DataElement r1) {
            return this.parentNode[r1.ordinal()];
        }

        private Node<K, V> getRight(DataElement r1) {
            return this.rightNode[r1.ordinal()];
        }

        private boolean isBlack(DataElement r1) {
            return this.blackColor[r1.ordinal()];
        }

        private boolean isLeftChild(DataElement r3) {
            if (this.parentNode[r3.ordinal()] != null) goto L5;
        L7:
            return false;
        L5:
            if (this.parentNode[r3.ordinal()].leftNode[r3.ordinal()] != this) goto L7;
            return true;
        }

        private boolean isRed(DataElement r1) {
            return !this.blackColor[r1.ordinal()];
        }

        private boolean isRightChild(DataElement r3) {
            if (this.parentNode[r3.ordinal()] != null) goto L5;
        L7:
            return false;
        L5:
            if (this.parentNode[r3.ordinal()].rightNode[r3.ordinal()] != this) goto L7;
            return true;
        }

        private void setBlack(DataElement r2) {
            this.blackColor[r2.ordinal()] = true;
        }

        private void setLeft(Node<K, V> r1, DataElement r2) {
            this.leftNode[r2.ordinal()] = r1;
        }

        private void setParent(Node<K, V> r1, DataElement r2) {
            this.parentNode[r2.ordinal()] = r1;
        }

        private void setRed(DataElement r2) {
            this.blackColor[r2.ordinal()] = false;
        }

        private void setRight(Node<K, V> r1, DataElement r2) {
            this.rightNode[r2.ordinal()] = r1;
        }

        private void swapColors(Node<K, V> r6, DataElement r7) {
            boolean[] r0 = this.blackColor;
            int r1 = r7.ordinal();
            r0[r1] = r0[r1] ^ r6.blackColor[r7.ordinal()];
            boolean[] r2 = r6.blackColor;
            int r3 = r7.ordinal();
            r2[r3] = r2[r3] ^ this.blackColor[r7.ordinal()];
            boolean[] r5 = this.blackColor;
            int r4 = r7.ordinal();
            boolean r8 = r5[r4];
            r5[r4] = r6.blackColor[r7.ordinal()] ^ r8;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L8;
            return false;
        L8:
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin");
            if (getKey().equals(r6.getKey()) == false) goto L14;
            if (getValue().equals(r6.getValue()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public /* bridge */ /* synthetic */ Object getValue() {
            return getValue();
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.calculatedHashCode == true) goto L6;
            this.hashcodeValue = getKey().hashCode() ^ getValue().hashCode();
            this.calculatedHashCode = true;
        L6:
            return this.hashcodeValue;
        }

        public V setValue(V r2) {
            Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }

        @Override // java.util.Map.Entry
        public /* synthetic */ Object setValue(Object r3) {
            return setValue((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    class ValueView extends TreeBidiMap<K, V>.View<V> {
        final /* synthetic */ TreeBidiMap this$0;

        public ValueView(TreeBidiMap r1, DataElement r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            TreeBidiMap.access$1500(r2, DataElement.VALUE);
            if (TreeBidiMap.access$1800(this.this$0, r2) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new InverseViewMapIterator(this.this$0, this.orderType);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (TreeBidiMap.access$1900(this.this$0, r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    abstract class View<E> extends AbstractSet<E> {
        final DataElement orderType;
        final /* synthetic */ TreeBidiMap this$0;

        View(TreeBidiMap r1, DataElement r2) {
            this.this$0 = r1;
            this.orderType = r2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    abstract class ViewIterator {
        private int expectedModifications;
        Node<K, V> lastReturnedNode;
        private Node<K, V> nextNode;
        private final DataElement orderType;
        private Node<K, V> previousNode;
        final /* synthetic */ TreeBidiMap this$0;

        ViewIterator(TreeBidiMap r3, DataElement r4) {
            this.this$0 = r3;
            this.orderType = r4;
            this.expectedModifications = TreeBidiMap.access$2100(r3);
            this.nextNode = TreeBidiMap.access$2300(r3, TreeBidiMap.access$2200(r3)[r4.ordinal()], r4);
            this.lastReturnedNode = null;
            this.previousNode = null;
        }

        public final boolean hasNext() {
            if (this.nextNode == null) goto L5;
            return true;
        L5:
            return false;
        }

        public Node<K, V> navigateNext() {
            if (this.nextNode == null) goto L11;
            if (TreeBidiMap.access$2100(this.this$0) != this.expectedModifications) goto L9;
            Node<K, V> r0 = this.nextNode;
            this.lastReturnedNode = r0;
            this.previousNode = r0;
            this.nextNode = TreeBidiMap.access$2400(this.this$0, r0, this.orderType);
            return this.lastReturnedNode;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.lastReturnedNode == null) goto L15;
            if (TreeBidiMap.access$2100(this.this$0) != this.expectedModifications) goto L13;
            TreeBidiMap.access$2000(this.this$0, this.lastReturnedNode);
            this.expectedModifications++;
            this.lastReturnedNode = null;
            Node<K, V> r0 = this.nextNode;
            if (r0 != null) goto L9;
            TreeBidiMap r1 = this.this$0;
            Node<K, V> r2 = TreeBidiMap.access$2600(r1, TreeBidiMap.access$2200(r1)[this.orderType.ordinal()], this.orderType);
        L10:
            this.previousNode = r2;
            return;
        L9:
            r2 = TreeBidiMap.access$2500(this.this$0, r0, this.orderType);
            goto L10
        L13:
            throw new ConcurrentModificationException();
        L15:
            throw new IllegalStateException();
        }
    }

    class ViewMapEntryIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedIterator<Map.Entry<K, V>> {
        final /* synthetic */ TreeBidiMap this$0;

        ViewMapEntryIterator(TreeBidiMap r2) {
            this.this$0 = r2;
            super(r2, DataElement.KEY);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return navigateNext();
        }
    }

    class ViewMapIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedMapIterator<K, V> {
        final /* synthetic */ TreeBidiMap this$0;

        ViewMapIterator(TreeBidiMap r1, DataElement r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.lastReturnedNode == null) goto L7;
            return (V) this.lastReturnedNode.getValue();
        L7:
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public /* bridge */ /* synthetic */ Object getValue() {
            return getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return (K) navigateNext().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }
    }

    public TreeBidiMap() {
        this.nodeCount = 0;
        this.modifications = 0;
        this.inverse = null;
        this.rootNode = new Node[2];
    }

    public TreeBidiMap(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this();
        putAll(r4);
    }

    static /* synthetic */ void access$1500(Object r0, DataElement r1) {
        checkNonNullComparable(r0, r1);
    }

    static /* synthetic */ Node access$1600(TreeBidiMap r0, Object r1) {
        return r0.lookupKey(r1);
    }

    static /* synthetic */ Comparable access$1700(TreeBidiMap r0, Object r1) {
        return r0.doRemoveKey(r1);
    }

    static /* synthetic */ Node access$1800(TreeBidiMap r0, Object r1) {
        return r0.lookupValue(r1);
    }

    static /* synthetic */ Comparable access$1900(TreeBidiMap r0, Object r1) {
        return r0.doRemoveValue(r1);
    }

    static /* synthetic */ void access$2000(TreeBidiMap r0, Node r1) {
        r0.doRedBlackDelete(r1);
    }

    static /* synthetic */ int access$2100(TreeBidiMap r0) {
        return r0.modifications;
    }

    static /* synthetic */ Node[] access$2200(TreeBidiMap r0) {
        return r0.rootNode;
    }

    static /* synthetic */ Node access$2300(TreeBidiMap r0, Node r1, DataElement r2) {
        return r0.leastNode(r1, r2);
    }

    static /* synthetic */ Node access$2400(TreeBidiMap r0, Node r1, DataElement r2) {
        return r0.nextGreater(r1, r2);
    }

    static /* synthetic */ Node access$2500(TreeBidiMap r0, Node r1, DataElement r2) {
        return r0.nextSmaller(r1, r2);
    }

    static /* synthetic */ Node access$2600(TreeBidiMap r0, Node r1, DataElement r2) {
        return r0.greatestNode(r1, r2);
    }

    static /* synthetic */ int access$2700(TreeBidiMap r0) {
        return r0.nodeCount;
    }

    static /* synthetic */ void access$2800(Object r0) {
        checkKey(r0);
    }

    static /* synthetic */ Node access$2900(TreeBidiMap r0, Object r1, DataElement r2) {
        return r0.lookup(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void access$3000(TreeBidiMap r2, Comparable r3, Comparable r4) {
        r2.doPut((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean access$3100(TreeBidiMap r0, Object r1, DataElement r2) {
        return r0.doEquals(r1, r2);
    }

    static /* synthetic */ int access$3200(TreeBidiMap r0, DataElement r1) {
        return r0.doHashCode(r1);
    }

    static /* synthetic */ String access$3300(TreeBidiMap r0, DataElement r1) {
        return r0.doToString(r1);
    }

    private static void checkKey(Object r1) {
        checkNonNullComparable(r1, DataElement.KEY);
    }

    private static void checkKeyAndValue(Object r0, Object r1) {
        checkKey(r0);
        checkValue(r1);
    }

    private static void checkNonNullComparable(Object r1, DataElement r2) {
        if (r1 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r1, Comparable.class) == false) goto L7;
        return;
    L7:
        throw new ClassCastException(r2 + " must be Comparable");
    L9:
        throw new NullPointerException(r2 + " cannot be null");
    }

    private static void checkValue(Object r1) {
        checkNonNullComparable(r1, DataElement.VALUE);
    }

    private static <T extends Comparable<T>> int compare(T r2, T r3) {
        return ((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    private void copyColor(Node<K, V> r1, Node<K, V> r2, DataElement r3) {
        if (r2 == null) goto L7;
        if (r1 != null) goto L5;
        Node.access$700(r2, r3);
        return;
    L5:
        Node.access$800(r2, r1, r3);
        return;
    }

    private boolean doEquals(Object r5, DataElement r6) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == true) goto L8;
        return false;
    L8:
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        if (r7.size() == size()) goto L12;
        return false;
    L12:
        if (this.nodeCount > 0) goto L21;
    L19:
        return true;
    L21:
        MapIterator<?, ?> r4 = getMapIterator(r6);     // Catch: Throwable -> L20
    L15:
        if (r4.hasNext() == false) goto L19;
        Object r8 = r4.next();     // Catch: Throwable -> L20
        if (r4.getValue().equals(r7.get(r8)) == true) goto L15;
    L18:
        return false;
    }

    private int doHashCode(DataElement r3) {
        int r1 = 0;
        if (this.nodeCount <= 0) goto L8;
        MapIterator<?, ?> r2 = getMapIterator(r3);
    L6:
        if (r2.hasNext() == false) goto L8;
        Object r4 = r2.next();
        Object r0 = r2.getValue();
        r1 = r1 + (r4.hashCode() ^ r0.hashCode());
    L8:
        return r1;
    }

    private void doPut(K r3, V r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        checkKeyAndValue(r5, r6);
        doRemoveKey(r5);
        doRemoveValue(r6);
        Node<K, V> r0 = this.rootNode[DataElement.KEY.ordinal()];
        if (r0 != null) goto L6;
        Node<K, V> r1 = new Node(r5, r6);
        this.rootNode[DataElement.KEY.ordinal()] = r1;
        this.rootNode[DataElement.VALUE.ordinal()] = r1;
    L5:
        grow();
        return;
    L6:
        int r2 = compare(r5, r0.getKey());
        if (r2 == 0) goto L20;
        if (r2 < 0) goto L10;
        if (Node.access$300(r0, DataElement.KEY) == null) goto L16;
        r0 = Node.access$300(r0, DataElement.KEY);
        goto L6
    L16:
        Node<K, V> r7 = new Node(r5, r6);
        insertValue(r7);
        Node.access$400(r0, r7, DataElement.KEY);
    L17:
        Node.access$200(r7, r0, DataElement.KEY);
        doRedBlackInsert(r7, DataElement.KEY);
        goto L5
    L10:
        if (Node.access$000(r0, DataElement.KEY) == null) goto L12;
        r0 = Node.access$000(r0, DataElement.KEY);
        goto L6
    L12:
        r7 = new Node(r5, r6);
        insertValue(r7);
        Node.access$100(r0, r7, DataElement.KEY);
        goto L17
    L20:
        throw new IllegalArgumentException("Cannot store a duplicate key (\"" + r5 + "\") in this Map");
    }

    private void doRedBlackDelete(Node<K, V> r9) {
        DataElement[] r0 = DataElement.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L39;
        DataElement r3 = r0[r2];
        if (Node.access$000(r9, r3) == null) goto L10;
        if (Node.access$300(r9, r3) == null) goto L10;
        swapPosition(nextGreater(r9, r3), r9, r3);
    L10:
        if (Node.access$000(r9, r3) == null) goto L12;
        Node<K, V> r4 = Node.access$000(r9, r3);
    L14:
        if (r4 == null) goto L26;
        Node.access$200(r4, Node.access$600(r9, r3), r3);
        if (Node.access$600(r9, r3) != null) goto L19;
        this.rootNode[r3.ordinal()] = r4;
    L22:
        Node.access$100(r9, null, r3);
        Node.access$400(r9, null, r3);
        Node.access$200(r9, null, r3);
        if (isBlack(r9, r3) == false) goto L38;
        doRedBlackDeleteFixup(r4, r3);
    L38:
        r2 = r2 + 1;
        goto L3
    L19:
        if (r9 != Node.access$000(Node.access$600(r9, r3), r3)) goto L21;
        Node.access$100(Node.access$600(r9, r3), r4, r3);
        goto L22
    L21:
        Node.access$400(Node.access$600(r9, r3), r4, r3);
        goto L22
    L26:
        if (Node.access$600(r9, r3) != null) goto L29;
        this.rootNode[r3.ordinal()] = null;
        goto L38
    L29:
        if (isBlack(r9, r3) == false) goto L32;
        doRedBlackDeleteFixup(r9, r3);
    L32:
        if (Node.access$600(r9, r3) == null) goto L38;
        if (r9 != Node.access$000(Node.access$600(r9, r3), r3)) goto L36;
        Node.access$100(Node.access$600(r9, r3), null, r3);
    L37:
        Node.access$200(r9, null, r3);
        goto L38
    L36:
        Node.access$400(Node.access$600(r9, r3), null, r3);
        goto L37
    L12:
        r4 = Node.access$300(r9, r3);
        goto L14
    L39:
        shrink();
    }

    private void doRedBlackDeleteFixup(Node<K, V> r3, DataElement r4) {
    L3:
        if (r3 == this.rootNode[r4.ordinal()]) goto L32;
        if (isBlack(r3, r4) == false) goto L32;
        if (Node.access$1200(r3, r4) == true) goto L8;
        Node<K, V> r0 = getLeftChild(getParent(r3, r4), r4);
        if (isRed(r0, r4) == false) goto L24;
        makeBlack(r0, r4);
        makeRed(getParent(r3, r4), r4);
        rotateRight(getParent(r3, r4), r4);
        r0 = getLeftChild(getParent(r3, r4), r4);
    L24:
        if (isBlack(getRightChild(r0, r4), r4) == false) goto L29;
        if (isBlack(getLeftChild(r0, r4), r4) == false) goto L29;
    L15:
        makeRed(r0, r4);
        r3 = getParent(r3, r4);
    L29:
        if (isBlack(getLeftChild(r0, r4), r4) == false) goto L31;
        makeBlack(getRightChild(r0, r4), r4);
        makeRed(r0, r4);
        rotateLeft(r0, r4);
        r0 = getLeftChild(getParent(r3, r4), r4);
    L31:
        copyColor(getParent(r3, r4), r0, r4);
        makeBlack(getParent(r3, r4), r4);
        makeBlack(getLeftChild(r0, r4), r4);
        rotateRight(getParent(r3, r4), r4);
        r3 = this.rootNode[r4.ordinal()];
        goto L3
    L8:
        r0 = getRightChild(getParent(r3, r4), r4);
        if (isRed(r0, r4) == false) goto L12;
        makeBlack(r0, r4);
        makeRed(getParent(r3, r4), r4);
        rotateLeft(getParent(r3, r4), r4);
        r0 = getRightChild(getParent(r3, r4), r4);
    L12:
        if (isBlack(getLeftChild(r0, r4), r4) == false) goto L17;
        if (isBlack(getRightChild(r0, r4), r4) == true) goto L15;
    L17:
        if (isBlack(getRightChild(r0, r4), r4) == false) goto L19;
        makeBlack(getLeftChild(r0, r4), r4);
        makeRed(r0, r4);
        rotateRight(r0, r4);
        r0 = getRightChild(getParent(r3, r4), r4);
    L19:
        copyColor(getParent(r3, r4), r0, r4);
        makeBlack(getParent(r3, r4), r4);
        makeBlack(getRightChild(r0, r4), r4);
        rotateLeft(getParent(r3, r4), r4);
        r3 = this.rootNode[r4.ordinal()];
    L32:
        makeBlack(r3, r4);
    }

    private void doRedBlackInsert(Node<K, V> r3, DataElement r4) {
        makeRed(r3, r4);
    L3:
        if (r3 == null) goto L28;
        if (r3 == this.rootNode[r4.ordinal()]) goto L28;
        if (isRed(Node.access$600(r3, r4), r4) == false) goto L28;
        if (Node.access$1200(r3, r4) == true) goto L10;
        Node<K, V> r0 = getLeftChild(getGrandParent(r3, r4), r4);
        if (isRed(r0, r4) == true) goto L12;
        if (Node.access$1200(r3, r4) == false) goto L25;
        r3 = getParent(r3, r4);
        rotateRight(r3, r4);
    L25:
        makeBlack(getParent(r3, r4), r4);
        makeRed(getGrandParent(r3, r4), r4);
        if (getGrandParent(r3, r4) == null) goto L3;
        rotateLeft(getGrandParent(r3, r4), r4);
    L12:
        makeBlack(getParent(r3, r4), r4);
        makeBlack(r0, r4);
        makeRed(getGrandParent(r3, r4), r4);
        r3 = getGrandParent(r3, r4);
        goto L3
    L10:
        r0 = getRightChild(getGrandParent(r3, r4), r4);
        if (isRed(r0, r4) == true) goto L12;
        if (Node.access$1300(r3, r4) == false) goto L16;
        r3 = getParent(r3, r4);
        rotateLeft(r3, r4);
    L16:
        makeBlack(getParent(r3, r4), r4);
        makeRed(getGrandParent(r3, r4), r4);
        if (getGrandParent(r3, r4) == null) goto L3;
        rotateRight(getGrandParent(r3, r4), r4);
    L28:
        makeBlack(this.rootNode[r4.ordinal()], r4);
    }

    private V doRemoveKey(Object r1) {
        Node<K, V> r2 = lookupKey(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        doRedBlackDelete(r2);
        return (V) r2.getValue();
    }

    private K doRemoveValue(Object r1) {
        Node<K, V> r2 = lookupValue(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        doRedBlackDelete(r2);
        return (K) r2.getKey();
    }

    private String doToString(DataElement r6) {
        if (this.nodeCount != 0) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(this.nodeCount * 32);
        r0.append('{');
        MapIterator<?, ?> r7 = getMapIterator(r6);
        boolean r1 = r7.hasNext();
    L7:
        if (r1 == false) goto L17;
        Object r2 = r7.next();
        Object r3 = r7.getValue();
        if (r2 != this) goto L11;
        r2 = "(this Map)";
    L11:
        StringBuilder r4 = r0.append(r2).append('=');
        if (r3 != this) goto L14;
        r3 = "(this Map)";
    L14:
        r4.append(r3);
        r1 = r7.hasNext();
        if (r1 == false) goto L7;
        r0.append(", ");
        goto L7
    L17:
        r0.append('}');
        return r0.toString();
    }

    private Node<K, V> getGrandParent(Node<K, V> r1, DataElement r2) {
        return getParent(getParent(r1, r2), r2);
    }

    private Node<K, V> getLeftChild(Node<K, V> r1, DataElement r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return Node.access$000(r1, r2);
    }

    private MapIterator<?, ?> getMapIterator(DataElement r2) {
        int r3 = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement[r2.ordinal()];
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L9;
        return new InverseViewMapIterator(this, DataElement.VALUE);
    L9:
        throw new IllegalArgumentException();
    L11:
        return new ViewMapIterator(this, DataElement.KEY);
    }

    private Node<K, V> getParent(Node<K, V> r1, DataElement r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return Node.access$600(r1, r2);
    }

    private Node<K, V> getRightChild(Node<K, V> r1, DataElement r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return Node.access$300(r1, r2);
    }

    private Node<K, V> greatestNode(Node<K, V> r1, DataElement r2) {
        if (r1 != null) goto L4;
    L6:
        return r1;
    L4:
        if (Node.access$300(r1, r2) == null) goto L6;
        r1 = Node.access$300(r1, r2);
        goto L4
    }

    private void grow() {
        modify();
        this.nodeCount++;
    }

    private void insertValue(Node<K, V> r4) {
        Node<K, V> r0 = this.rootNode[DataElement.VALUE.ordinal()];
    L3:
        int r1 = compare(r4.getValue(), r0.getValue());
        if (r1 == 0) goto L17;
        if (r1 < 0) goto L7;
        if (Node.access$300(r0, DataElement.VALUE) == null) goto L13;
        r0 = Node.access$300(r0, DataElement.VALUE);
        goto L3
    L13:
        Node.access$400(r0, r4, DataElement.VALUE);
    L14:
        Node.access$200(r4, r0, DataElement.VALUE);
        doRedBlackInsert(r4, DataElement.VALUE);
        return;
    L7:
        if (Node.access$000(r0, DataElement.VALUE) == null) goto L9;
        r0 = Node.access$000(r0, DataElement.VALUE);
        goto L3
    L9:
        Node.access$100(r0, r4, DataElement.VALUE);
        goto L14
    L17:
        throw new IllegalArgumentException("Cannot store a duplicate value (\"" + Node.access$500(r4, DataElement.VALUE) + "\") in this Map");
    }

    private static boolean isBlack(Node<?, ?> r0, DataElement r1) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (Node.access$1000(r0, r1) == true) goto L7;
        return false;
    }

    private static boolean isRed(Node<?, ?> r0, DataElement r1) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (Node.access$900(r0, r1) == false) goto L6;
        return true;
    }

    private Node<K, V> leastNode(Node<K, V> r1, DataElement r2) {
        if (r1 != null) goto L4;
    L6:
        return r1;
    L4:
        if (Node.access$000(r1, r2) == null) goto L6;
        r1 = Node.access$000(r1, r2);
        goto L4
    }

    private <T extends Comparable<T>> Node<K, V> lookup(Object r5, DataElement r6) {
        Node<K, V> r4 = this.rootNode[r6.ordinal()];
    L3:
        if (r4 == null) goto L10;
        int r0 = compare((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Node.access$500(r4, r6), Comparable.class, "com.obric.memorydata.plugin"));
        if (r0 == 0) goto L19;
        if (r0 < 0) goto L8;
        r4 = Node.access$300(r4, r6);
        goto L3
    L8:
        r4 = Node.access$000(r4, r6);
        goto L3
    L19:
        return r4;
    L10:
        return null;
    }

    private Node<K, V> lookupKey(Object r2) {
        return lookup(r2, DataElement.KEY);
    }

    private Node<K, V> lookupValue(Object r2) {
        return lookup(r2, DataElement.VALUE);
    }

    private static void makeBlack(Node<?, ?> r0, DataElement r1) {
        if (r0 == null) goto L5;
        Node.access$700(r0, r1);
        return;
    }

    private static void makeRed(Node<?, ?> r0, DataElement r1) {
        if (r0 == null) goto L5;
        Node.access$1100(r0, r1);
        return;
    }

    private void modify() {
        this.modifications++;
    }

    private Node<K, V> nextGreater(Node<K, V> r3, DataElement r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (Node.access$300(r3, r4) != null) goto L18;
    L7:
        Node<K, V> r1 = r3;
        r3 = Node.access$600(r3, r4);
        if (r3 == null) goto L13;
        if (r1 == Node.access$300(r3, r4)) goto L7;
    L13:
        return r3;
    L18:
        return leastNode(Node.access$300(r3, r4), r4);
    }

    private Node<K, V> nextSmaller(Node<K, V> r3, DataElement r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (Node.access$000(r3, r4) != null) goto L18;
    L7:
        Node<K, V> r1 = r3;
        r3 = Node.access$600(r3, r4);
        if (r3 == null) goto L13;
        if (r1 == Node.access$000(r3, r4)) goto L7;
    L13:
        return r3;
    L18:
        return greatestNode(Node.access$000(r3, r4), r4);
    }

    private void readObject(ObjectInputStream r7) {
        r7.defaultReadObject();
        this.rootNode = new Node[2];
        int r0 = r7.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        put((Comparable) ZeusTransformUtils.preCheckCast(r7.readObject(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r7.readObject(), Comparable.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L3
    }

    private void rotateLeft(Node<K, V> r3, DataElement r4) {
        Node<K, V> r0 = Node.access$300(r3, r4);
        Node.access$400(r3, Node.access$000(r0, r4), r4);
        if (Node.access$000(r0, r4) == null) goto L5;
        Node.access$200(Node.access$000(r0, r4), r3, r4);
    L5:
        Node.access$200(r0, Node.access$600(r3, r4), r4);
        if (Node.access$600(r3, r4) != null) goto L9;
        this.rootNode[r4.ordinal()] = r0;
    L12:
        Node.access$100(r0, r3, r4);
        Node.access$200(r3, r0, r4);
        return;
    L9:
        if (Node.access$000(Node.access$600(r3, r4), r4) != r3) goto L11;
        Node.access$100(Node.access$600(r3, r4), r0, r4);
        goto L12
    L11:
        Node.access$400(Node.access$600(r3, r4), r0, r4);
        goto L12
    }

    private void rotateRight(Node<K, V> r3, DataElement r4) {
        Node<K, V> r0 = Node.access$000(r3, r4);
        Node.access$100(r3, Node.access$300(r0, r4), r4);
        if (Node.access$300(r0, r4) == null) goto L5;
        Node.access$200(Node.access$300(r0, r4), r3, r4);
    L5:
        Node.access$200(r0, Node.access$600(r3, r4), r4);
        if (Node.access$600(r3, r4) != null) goto L9;
        this.rootNode[r4.ordinal()] = r0;
    L12:
        Node.access$400(r0, r3, r4);
        Node.access$200(r3, r0, r4);
        return;
    L9:
        if (Node.access$300(Node.access$600(r3, r4), r4) != r3) goto L11;
        Node.access$400(Node.access$600(r3, r4), r0, r4);
        goto L12
    L11:
        Node.access$100(Node.access$600(r3, r4), r0, r4);
        goto L12
    }

    private void shrink() {
        modify();
        this.nodeCount--;
    }

    private void swapPosition(Node<K, V> r11, Node<K, V> r12, DataElement r13) {
        Node<K, V> r0 = Node.access$600(r11, r13);
        Node r1 = Node.access$000(r11, r13);
        Node r2 = Node.access$300(r11, r13);
        Node<K, V> r3 = Node.access$600(r12, r13);
        Node r4 = Node.access$000(r12, r13);
        Node r5 = Node.access$300(r12, r13);
        boolean r7 = true;
        if (Node.access$600(r11, r13) != null) goto L5;
    L7:
        boolean r6 = false;
    L9:
        if (Node.access$600(r12, r13) != null) goto L11;
    L13:
        r7 = false;
    L14:
        if (r11 != r3) goto L19;
        Node.access$200(r11, r12, r13);
        if (r7 == false) goto L18;
        Node.access$100(r12, r11, r13);
    L25:
        Node.access$400(r12, r2, r13);
    L26:
        if (r12 != r0) goto L31;
        Node.access$200(r12, r11, r13);
        if (r6 == false) goto L30;
        Node.access$100(r11, r12, r13);
    L37:
        Node.access$400(r11, r5, r13);
    L39:
        if (Node.access$000(r11, r13) == null) goto L42;
        Node.access$200(Node.access$000(r11, r13), r11, r13);
    L42:
        if (Node.access$300(r11, r13) == null) goto L45;
        Node.access$200(Node.access$300(r11, r13), r11, r13);
    L45:
        if (Node.access$000(r12, r13) == null) goto L48;
        Node.access$200(Node.access$000(r12, r13), r12, r13);
    L48:
        if (Node.access$300(r12, r13) == null) goto L50;
        Node.access$200(Node.access$300(r12, r13), r12, r13);
    L50:
        Node.access$1400(r11, r12, r13);
        if (this.rootNode[r13.ordinal()] != r11) goto L54;
        this.rootNode[r13.ordinal()] = r12;
        return;
    L54:
        if (this.rootNode[r13.ordinal()] != r12) goto L58;
        this.rootNode[r13.ordinal()] = r11;
        return;
    L58:
        return;
    L30:
        Node.access$400(r11, r12, r13);
        Node.access$100(r11, r4, r13);
        goto L39
    L31:
        Node.access$200(r12, r0, r13);
        if (r0 == null) goto L36;
        if (r6 == false) goto L35;
        Node.access$100(r0, r12, r13);
        goto L36
    L35:
        Node.access$400(r0, r12, r13);
    L36:
        Node.access$100(r11, r4, r13);
        goto L37
    L18:
        Node.access$400(r12, r11, r13);
        Node.access$100(r12, r1, r13);
        goto L26
    L19:
        Node.access$200(r11, r3, r13);
        if (r3 == null) goto L24;
        if (r7 == false) goto L23;
        Node.access$100(r3, r11, r13);
        goto L24
    L23:
        Node.access$400(r3, r11, r13);
    L24:
        Node.access$100(r12, r1, r13);
        goto L25
    L11:
        if (r12 != Node.access$000(Node.access$600(r12, r13), r13)) goto L13;
    L5:
        if (r11 != Node.access$000(Node.access$600(r11, r13), r13)) goto L7;
        r6 = true;
        goto L9
    }

    private void writeObject(ObjectOutputStream r4) {
        r4.defaultWriteObject();
        r4.writeInt(size());
        Iterator<Map.Entry<K, V>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getKey());
        r4.writeObject(r0.getValue());
        goto L4
    }

    @Override // java.util.Map
    public void clear() {
        modify();
        this.nodeCount = 0;
        this.rootNode[DataElement.KEY.ordinal()] = null;
        this.rootNode[DataElement.VALUE.ordinal()] = null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        checkKey(r1);
        if (lookupKey(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        checkValue(r1);
        if (lookupValue(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet != null) goto L6;
        this.entrySet = new EntryView(this);
    L6:
        return this.entrySet;
    }

    @Override // java.util.Map
    public boolean equals(Object r2) {
        return doEquals(r2, DataElement.KEY);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.nodeCount == 0) goto L7;
        return (K) leastNode(this.rootNode[DataElement.KEY.ordinal()], DataElement.KEY).getKey();
    L7:
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public /* bridge */ /* synthetic */ Object firstKey() {
        return firstKey();
    }

    @Override // java.util.Map
    public V get(Object r1) {
        checkKey(r1);
        Node<K, V> r0 = lookupKey(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return (V) r0.getValue();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object get(Object r1) {
        return get(r1);
    }

    public K getKey(Object r1) {
        checkValue(r1);
        Node<K, V> r0 = lookupValue(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return (K) r0.getKey();
    }

    /* JADX INFO: renamed from: getKey, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3067getKey(Object r1) {
        return getKey(r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return doHashCode(DataElement.KEY);
    }

    public /* bridge */ /* synthetic */ BidiMap inverseBidiMap() {
        return m3068inverseBidiMap();
    }

    /* JADX INFO: renamed from: inverseBidiMap, reason: collision with other method in class */
    public OrderedBidiMap<V, K> m3068inverseBidiMap() {
        if (this.inverse != null) goto L6;
        this.inverse = new Inverse(this);
    L6:
        return this.inverse;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (this.nodeCount != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        if (this.keySet != null) goto L6;
        this.keySet = new KeyView(this, DataElement.KEY);
    L6:
        return this.keySet;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.nodeCount == 0) goto L7;
        return (K) greatestNode(this.rootNode[DataElement.KEY.ordinal()], DataElement.KEY).getKey();
    L7:
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public /* bridge */ /* synthetic */ Object lastKey() {
        return lastKey();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        if (isEmpty() == false) goto L7;
        return EmptyOrderedMapIterator.emptyOrderedMapIterator();
    L7:
        return new ViewMapIterator(this, DataElement.KEY);
    }

    public K nextKey(K r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        checkKey(r4);
        Node<K, V> r2 = nextGreater(lookupKey(r4), DataElement.KEY);
        if (r2 != null) goto L6;
        return null;
    L6:
        return (K) r2.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public /* synthetic */ Object nextKey(Object r3) {
        return nextKey((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public K previousKey(K r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        checkKey(r4);
        Node<K, V> r2 = nextSmaller(lookupKey(r4), DataElement.KEY);
        if (r2 != null) goto L6;
        return null;
    L6:
        return (K) r2.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public /* synthetic */ Object previousKey(Object r3) {
        return previousKey((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public V put(K r3, V r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        V r0 = (V) get(r5);
        doPut(r5, r6);
        return r0;
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(Object r3, Object r4) {
        return put((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        Iterator r6 = ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put((Comparable) ZeusTransformUtils.preCheckCast(r0.getKey(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r0.getValue(), Comparable.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    @Override // java.util.Map
    public V remove(Object r1) {
        return (V) doRemoveKey(r1);
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object r1) {
        return remove(r1);
    }

    public K removeValue(Object r1) {
        return (K) doRemoveValue(r1);
    }

    /* JADX INFO: renamed from: removeValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3069removeValue(Object r1) {
        return removeValue(r1);
    }

    @Override // java.util.Map
    public int size() {
        return this.nodeCount;
    }

    public String toString() {
        return doToString(DataElement.KEY);
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map
    public Set<V> values() {
        if (this.valuesSet != null) goto L6;
        this.valuesSet = new ValueView(this, DataElement.KEY);
    L6:
        return this.valuesSet;
    }
}

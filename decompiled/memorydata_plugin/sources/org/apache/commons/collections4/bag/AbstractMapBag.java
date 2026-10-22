package org.apache.commons.collections4.bag;

import com.bytedance.crash.AppDataCenter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMapBag<E> implements Bag<E> {
    private transient Map<E, MutableInteger> map;
    private transient int modCount;
    private int size;
    private transient Set<E> uniqueSet;

    static class BagIterator<E> implements Iterator<E> {
        private boolean canRemove;
        private Map.Entry<E, MutableInteger> current;
        private final Iterator<Map.Entry<E, MutableInteger>> entryIterator;
        private int itemCount;
        private final int mods;
        private final AbstractMapBag<E> parent;

        public BagIterator(AbstractMapBag<E> r2) {
            this.parent = r2;
            this.entryIterator = AbstractMapBag.access$000(r2).entrySet().iterator();
            this.current = null;
            this.mods = AbstractMapBag.access$100(r2);
            this.canRemove = false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.itemCount <= 0) goto L5;
        L8:
            return true;
        L5:
            if (this.entryIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (AbstractMapBag.access$100(this.parent) != this.mods) goto L10;
            if (this.itemCount != 0) goto L7;
            Map.Entry<E, MutableInteger> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.entryIterator.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.current = r0;
            this.itemCount = ((MutableInteger) ZeusTransformUtils.preCheckCast(r0.getValue(), MutableInteger.class, "com.obric.memorydata.plugin")).value;
        L7:
            this.canRemove = true;
            this.itemCount--;
            return this.current.getKey();
        L10:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (AbstractMapBag.access$100(this.parent) != this.mods) goto L15;
            if (this.canRemove == false) goto L13;
            MutableInteger r0 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.current.getValue(), MutableInteger.class, "com.obric.memorydata.plugin");
            if (r0.value <= 1) goto L9;
            r0.value--;
        L10:
            AbstractMapBag.access$210(this.parent);
            this.canRemove = false;
            return;
        L9:
            this.entryIterator.remove();
            goto L10
        L13:
            throw new IllegalStateException();
        L15:
            throw new ConcurrentModificationException();
        }
    }

    protected static class MutableInteger {
        protected int value;

        MutableInteger(int r1) {
            this.value = r1;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, MutableInteger.class) == true) goto L6;
            return false;
        L6:
            if (((MutableInteger) ZeusTransformUtils.preCheckCast(r4, MutableInteger.class, "com.obric.memorydata.plugin")).value != this.value) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.value;
        }
    }

    public AbstractMapBag() {
    }

    public AbstractMapBag(Map<E, MutableInteger> r3) {
        this.map = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Map access$000(AbstractMapBag r0) {
        return r0.map;
    }

    static /* synthetic */ int access$100(AbstractMapBag r0) {
        return r0.modCount;
    }

    static /* synthetic */ int access$210(AbstractMapBag r2) {
        int r0 = r2.size;
        r2.size = r0 - 1;
        return r0;
    }

    @Override // java.util.Collection
    public boolean add(E r2) {
        return add(r2, 1);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E r6, int r7) {
        this.modCount++;
        if (r7 <= 0) goto L9;
        MutableInteger r2 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.map.get(r6), MutableInteger.class, "com.obric.memorydata.plugin");
        this.size += r7;
        if (r2 != null) goto L8;
        this.map.put(r6, new MutableInteger(r7));
        return true;
    L8:
        r2.value += r7;
    L9:
        return false;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> r4) {
        Iterator<E> r5 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r1 = false;
    L5:
        if (r5.hasNext() == false) goto L10;
        boolean r2 = add(r5.next());
        if (r1 == true) goto L9;
        if (r2 == false) goto L3;
    L9:
        r1 = true;
        goto L5
    L10:
        return r1;
    }

    @Override // java.util.Collection
    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Bag.class) == false) goto L7;
        return containsAll((Bag) ZeusTransformUtils.preCheckCast(r4, Bag.class, "com.obric.memorydata.plugin"));
    L7:
        return containsAll(new HashBag(r4));
    }

    boolean containsAll(Bag<?> r4) {
        Bag r5 = (Bag) ZeusTransformUtils.wrapperContextForParams(r4, Bag.class, "com.obric.memorydata.plugin");
        Iterator<E> r0 = r5.uniqueSet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        E r1 = r0.next();
        if (getCount(r1) >= r5.getCount(r1)) goto L4;
        return false;
    L9:
        return true;
    }

    public void doReadObject(Map<E, MutableInteger> r6, ObjectInputStream r7) {
        AppDataCenter r8 = (Map<E, MutableInteger>) ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        this.map = r8;
        int r0 = r7.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Object r2 = r7.readObject();
        int r3 = r7.readInt();
        r8.put(r2, new MutableInteger(r3));
        this.size += r3;
        r1 = r1 + 1;
        goto L3
    }

    public void doWriteObject(ObjectOutputStream r4) {
        r4.writeInt(this.map.size());
        Iterator<Map.Entry<E, MutableInteger>> r3 = this.map.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getKey());
        r4.writeInt(((MutableInteger) ZeusTransformUtils.preCheckCast(r0.getValue(), MutableInteger.class, "com.obric.memorydata.plugin")).value);
        goto L4
    }

    @Override // java.util.Collection
    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, Bag.class) == true) goto L8;
        return false;
    L8:
        Bag r7 = (Bag) ZeusTransformUtils.preCheckCast(r6, Bag.class, "com.obric.memorydata.plugin");
        if (r7.size() == size()) goto L11;
        return false;
    L11:
        Iterator<E> r1 = this.map.keySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        E r3 = r1.next();
        if (r7.getCount(r3) == getCount(r3)) goto L13;
        return false;
    L17:
        return true;
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object r2) {
        MutableInteger r1 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.map.get(r2), MutableInteger.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.value;
    }

    public Map<E, MutableInteger> getMap() {
        return this.map;
    }

    @Override // java.util.Collection
    public int hashCode() {
        Iterator<Map.Entry<E, MutableInteger>> r6 = this.map.entrySet().iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r3 = r2.getKey();
        MutableInteger r4 = (MutableInteger) ZeusTransformUtils.preCheckCast(r2.getValue(), MutableInteger.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        int r5 = 0;
    L9:
        r1 = r1 + (r4.value ^ r5);
        goto L4
    L8:
        r5 = r3.hashCode();
        goto L9
    L10:
        return r1;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new BagIterator(this);
    }

    @Override // java.util.Collection
    public boolean remove(Object r4) {
        MutableInteger r0 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.map.get(r4), MutableInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return false;
    L6:
        this.modCount++;
        this.map.remove(r4);
        this.size -= r0.value;
        return true;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object r4, int r5) {
        MutableInteger r0 = (MutableInteger) ZeusTransformUtils.preCheckCast(this.map.get(r4), MutableInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r5 > 0) goto L7;
        return false;
    L7:
        this.modCount++;
        if (r5 >= r0.value) goto L10;
        r0.value -= r5;
        int r6 = this.size;
    L11:
        this.size = r6 - r5;
        return true;
    L10:
        this.map.remove(r4);
        r6 = this.size;
        r5 = r0.value;
        goto L11
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L18;
        Iterator<E> r7 = r6.iterator();
    L5:
        boolean r1 = false;
    L7:
        if (r7.hasNext() == false) goto L13;
        boolean r2 = remove(r7.next(), 1);
        if (r1 == true) goto L11;
        if (r2 == false) goto L5;
    L11:
        r1 = true;
        goto L7
    L13:
        return r1;
    L18:
        return false;
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean retainAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Bag.class) == false) goto L7;
        return retainAll((Bag) ZeusTransformUtils.preCheckCast(r4, Bag.class, "com.obric.memorydata.plugin"));
    L7:
        return retainAll(new HashBag(r4));
    }

    boolean retainAll(Bag<?> r7) {
        Bag r8 = (Bag) ZeusTransformUtils.wrapperContextForParams(r7, Bag.class, "com.obric.memorydata.plugin");
        HashBag r0 = new HashBag();
        Iterator<E> r1 = uniqueSet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        E r2 = r1.next();
        int r3 = getCount(r2);
        int r4 = r8.getCount(r2);
        if (1 > r4) goto L9;
        if (r4 > r3) goto L9;
        r3 = r3 - r4;
    L9:
        r0.add(r2, r3);
        goto L4
    L11:
        if (r0.isEmpty() == false) goto L19;
        return false;
    L19:
        return removeAll(r0);
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] r0 = new Object[size()];
        Iterator<E> r1 = this.map.keySet().iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L8;
        E r3 = r1.next();
        int r4 = getCount(r3);
    L6:
        if (r4 <= 0) goto L4;
        r0[r2] = r3;
        r4 = r4 - 1;
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r6) {
        int r0 = size();
        if (r6.length >= r0) goto L5;
        r6 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r6.getClass().getComponentType(), r0), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
    L5:
        int r1 = 0;
        Iterator<E> r2 = this.map.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        E r3 = r2.next();
        int r4 = getCount(r3);
    L9:
        if (r4 <= 0) goto L7;
        r6[r1] = r3;
        r4 = r4 - 1;
        r1 = r1 + 1;
    L12:
        if (r1 >= r6.length) goto L14;
        r6[r1] = null;
        r1 = r1 + 1;
        goto L12
    L14:
        return r6;
    }

    public String toString() {
        if (size() != 0) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append('[');
        Iterator<E> r1 = uniqueSet().iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        E r2 = r1.next();
        r0.append(getCount(r2));
        r0.append(':');
        r0.append(r2);
        if (r1.hasNext() == false) goto L8;
        r0.append(',');
        goto L8
    L12:
        r0.append(']');
        return r0.toString();
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        if (this.uniqueSet != null) goto L6;
        this.uniqueSet = UnmodifiableSet.unmodifiableSet(this.map.keySet());
    L6:
        return this.uniqueSet;
    }
}

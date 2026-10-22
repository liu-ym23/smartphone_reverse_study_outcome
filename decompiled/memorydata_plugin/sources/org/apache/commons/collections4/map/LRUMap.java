package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.BoundedMap;

/* JADX INFO: loaded from: classes6.dex */
public class LRUMap<K, V> extends AbstractLinkedMap<K, V> implements Serializable, Cloneable, BoundedMap<K, V> {
    protected static final int DEFAULT_MAX_SIZE = 100;
    private static final long serialVersionUID = -612114643488955218L;
    private transient int maxSize;
    private boolean scanUntilRemovable;

    public LRUMap() {
        this(100, 0.75f, false);
    }

    public LRUMap(int r2) {
        this(r2, 0.75f);
    }

    public LRUMap(int r2, float r3) {
        this(r2, r3, false);
    }

    public LRUMap(int r1, float r2, boolean r3) {
        this(r1, r1, r2, r3);
    }

    public LRUMap(int r2, int r3) {
        this(r2, r3, 0.75f);
    }

    public LRUMap(int r2, int r3, float r4) {
        this(r2, r3, r4, false);
    }

    public LRUMap(int r1, int r2, float r3, boolean r4) {
        super(r2, r3);
        if (r1 < 1) goto L10;
        if (r2 > r1) goto L8;
        this.maxSize = r1;
        this.scanUntilRemovable = r4;
        return;
    L8:
        throw new IllegalArgumentException("LRUMap initial size must not be greather than max size");
    L10:
        throw new IllegalArgumentException("LRUMap max size must be greater than 0");
    }

    public LRUMap(int r2, boolean r3) {
        this(r2, 0.75f, r3);
    }

    public LRUMap(Map<? extends K, ? extends V> r3) {
        this((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), false);
    }

    public LRUMap(Map<? extends K, ? extends V> r3, boolean r4) {
        Map<? extends K, ? extends V> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this(r5.size(), 0.75f, r4);
        putAll(r5);
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        doReadObject(r1);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        doWriteObject(r1);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void addMapping(int r13, int r14, K r15, V r16) {
        if (isFull() == false) goto L23;
        AbstractLinkedMap.LinkEntry<K, V> r1 = this.header.after;
        boolean r2 = false;
        if (this.scanUntilRemovable == true) goto L7;
        r2 = removeLRU(r1);
    L18:
        if (r2 == false) goto L23;
        if (r1 == null) goto L22;
        reuseMapping(r1, r13, r14, r15, r16);
        return;
    L22:
        throw new IllegalStateException("reuse=null, header.after=" + this.header.after + " header.before=" + this.header.before + " key=" + r15 + " value=" + r16 + " size=" + this.size + " maxSize=" + this.maxSize + " This should not occur if your keys are immutable, and you have used synchronization properly.");
    L7:
        if (r1 == this.header) goto L13;
        if (r1 == null) goto L13;
        if (removeLRU(r1) == true) goto L11;
        r1 = r1.after;
        goto L7
    L11:
        r2 = true;
    L13:
        if (r1 != null) goto L18;
        throw new IllegalStateException("Entry.after=null, header.after=" + this.header.after + " header.before=" + this.header.before + " key=" + r15 + " value=" + r16 + " size=" + this.size + " maxSize=" + this.maxSize + " This should not occur if your keys are immutable, and you have used synchronization properly.");
    L23:
        super.addMapping(r13, r14, r15, r16);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public /* bridge */ /* synthetic */ AbstractHashedMap clone() {
        return clone();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public LRUMap<K, V> clone() {
        return (LRUMap) ZeusTransformUtils.preCheckCast(super.clone(), LRUMap.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void doReadObject(ObjectInputStream r2) {
        this.maxSize = r2.readInt();
        super.doReadObject(r2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void doWriteObject(ObjectOutputStream r2) {
        r2.writeInt(this.maxSize);
        super.doWriteObject(r2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        return get(r2, true);
    }

    public V get(Object r1, boolean r2) {
        AbstractLinkedMap.LinkEntry<K, V> r3 = getEntry(r1);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r2 == false) goto L9;
        moveToMRU(r3);
    L9:
        return r3.getValue();
    }

    public boolean isFull() {
        if (this.size < this.maxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isScanUntilRemovable() {
        return this.scanUntilRemovable;
    }

    public int maxSize() {
        return this.maxSize;
    }

    public void moveToMRU(AbstractLinkedMap.LinkEntry<K, V> r3) {
        if (r3.after == this.header) goto L10;
        this.modCount++;
        if (r3.before == null) goto L8;
        r3.before.after = r3.after;
        r3.after.before = r3.before;
        r3.after = this.header;
        r3.before = this.header.before;
        this.header.before.after = r3;
        this.header.before = r3;
        return;
    L8:
        throw new IllegalStateException("Entry.before is null. This should not occur if your keys are immutable, and you have used synchronization properly.");
    L10:
        if (r3 == this.header) goto L13;
        return;
    L13:
        throw new IllegalStateException("Can't move header to MRU This should not occur if your keys are immutable, and you have used synchronization properly.");
    }

    public boolean removeLRU(AbstractLinkedMap.LinkEntry<K, V> r1) {
        return true;
    }

    public void reuseMapping(AbstractLinkedMap.LinkEntry<K, V> r11, int r12, int r13, K r14, V r15) {
        boolean r5 = true;
        int r6 = hashIndex(r11.hashCode, this.data.length);     // Catch: NullPointerException -> L12
        AbstractHashedMap.HashEntry<K, V> r7 = this.data[r6];     // Catch: NullPointerException -> L12
        AbstractHashedMap.HashEntry<K, V> r8 = null;
    L4:
        if (r7 == r11) goto L7;
        if (r7 == null) goto L7;
        r8 = r7;
        r7 = r7.next;     // Catch: NullPointerException -> L12
    L7:
        if (r7 == null) goto L11;
        this.modCount++;     // Catch: NullPointerException -> L12
        removeEntry(r11, r6, r8);     // Catch: NullPointerException -> L12
        reuseEntry(r11, r12, r13, r14, r15);     // Catch: NullPointerException -> L12
        addEntry(r11, r12);     // Catch: NullPointerException -> L12
        return;
    L11:
        throw new IllegalStateException("Entry.next=null, data[removeIndex]=" + this.data[r6] + " previous=" + r8 + " key=" + r14 + " value=" + r15 + " size=" + this.size + " maxSize=" + this.maxSize + " This should not occur if your keys are immutable, and you have used synchronization properly.");     // Catch: NullPointerException -> L12
    L12:
        StringBuilder r16 = new StringBuilder().append("NPE, entry=").append(r11).append(" entryIsHeader=");
        if (r11 == this.header) goto L17;
        r5 = false;
    L17:
        throw new IllegalStateException(r16.append(r5).append(" key=").append(r14).append(" value=").append(r15).append(" size=").append(this.size).append(" maxSize=").append(this.maxSize).append(" This should not occur if your keys are immutable, and you have used synchronization properly.").toString());
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void updateEntry(AbstractHashedMap.HashEntry<K, V> r3, V r4) {
        moveToMRU((AbstractLinkedMap.LinkEntry) ZeusTransformUtils.preCheckCast(r3, AbstractLinkedMap.LinkEntry.class, "com.obric.memorydata.plugin"));
        r3.setValue(r4);
    }
}

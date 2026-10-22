package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

/* JADX INFO: loaded from: classes6.dex */
public class CompositeMap<K, V> extends AbstractIterableMap<K, V> implements Serializable {
    private static final long serialVersionUID = -6096931280583808322L;
    private Map<K, V>[] composite;
    private MapMutator<K, V> mutator;

    public interface MapMutator<K, V> extends Serializable {
        V put(CompositeMap<K, V> r1, Map<K, V>[] r2, K r3, V r4);

        void putAll(CompositeMap<K, V> r1, Map<K, V>[] r2, Map<? extends K, ? extends V> r3);

        void resolveCollision(CompositeMap<K, V> r1, Map<K, V> r2, Map<K, V> r3, Collection<K> r4);
    }

    public CompositeMap() {
        this(new Map[0], null);
    }

    public CompositeMap(Map<K, V> r3, Map<K, V> r4) {
        this(new Map[]{(Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")}, null);
    }

    public CompositeMap(Map<K, V> r3, Map<K, V> r4, MapMutator<K, V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map[] r0 = {r6, r7};
        this(r0, (MapMutator) ZeusTransformUtils.wrapperContextForParams(r5, MapMutator.class, "com.obric.memorydata.plugin"));
    }

    public CompositeMap(Map<K, V>... r2) {
        this(r2, null);
    }

    public CompositeMap(Map<K, V>[] r3, MapMutator<K, V> r4) {
        this.mutator = (MapMutator) ZeusTransformUtils.wrapperContextForParams(r4, MapMutator.class, "com.obric.memorydata.plugin");
        this.composite = new Map[0];
        int r5 = r3.length - 1;
    L3:
        if (r5 < 0) goto L5;
        addComposited(r3[r5]);
        r5 = r5 - 1;
        goto L3
    }

    public synchronized void addComposited(Map<K, V> r6) {
        monitor-enter(this);
        Map<K, V> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r7 == null) goto L16;
        int r0 = this.composite.length - 1;     // Catch: Throwable -> L18
    L6:
        if (r0 < 0) goto L15;
        Collection<K> r1 = CollectionUtils.intersection(this.composite[r0].keySet(), r7.keySet());     // Catch: Throwable -> L18
        if (r1.size() == 0) goto L14;
        MapMutator<K, V> r2 = this.mutator;     // Catch: Throwable -> L18
        if (r2 == null) goto L13;
        r2.resolveCollision(this, this.composite[r0], r7, r1);     // Catch: Throwable -> L18
        goto L14
    L13:
        throw new IllegalArgumentException("Key collision adding Map to CompositeMap");     // Catch: Throwable -> L18
    L14:
        r0 = r0 - 1;     // Catch: Throwable -> L18
        goto L6
    L15:
        Map<K, V>[] r3 = this.composite;     // Catch: Throwable -> L18
        int r4 = r3.length + 1;     // Catch: Throwable -> L18
        Map<K, V>[] r5 = new Map[r4];     // Catch: Throwable -> L18
        System.arraycopy(r3, 0, r5, 0, r3.length);     // Catch: Throwable -> L18
        r5[r4 - 1] = r7;     // Catch: Throwable -> L18
        this.composite = r5;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public void clear() {
        int r0 = this.composite.length - 1;
    L3:
        if (r0 < 0) goto L5;
        this.composite[r0].clear();
        r0 = r0 - 1;
        goto L3
    }

    @Override // java.util.Map
    public boolean containsKey(Object r4) {
        int r0 = this.composite.length - 1;
    L3:
        if (r0 < 0) goto L8;
        if (this.composite[r0].containsKey(r4) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r4) {
        int r0 = this.composite.length - 1;
    L3:
        if (r0 < 0) goto L8;
        if (this.composite[r0].containsValue(r4) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        CompositeSet r0 = new CompositeSet();
        int r1 = this.composite.length - 1;
    L3:
        if (r1 < 0) goto L5;
        r0.addComposited(this.composite[r1].entrySet());
        r1 = r1 - 1;
        goto L3
    L5:
        return r0;
    }

    @Override // java.util.Map
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Map.class) == false) goto L6;
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        return entrySet().equals(r4.entrySet());
    L6:
        return false;
    }

    @Override // java.util.Map
    public V get(Object r3) {
        int r0 = this.composite.length - 1;
    L3:
        if (r0 < 0) goto L9;
        if (this.composite[r0].containsKey(r3) == true) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return this.composite[r0].get(r3);
    L9:
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        Iterator<Map.Entry<K, V>> r4 = entrySet().iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).hashCode();
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        int r0 = this.composite.length - 1;
    L3:
        if (r0 < 0) goto L9;
        if (this.composite[r0].isEmpty() == false) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        CompositeSet r0 = new CompositeSet();
        int r1 = this.composite.length - 1;
    L3:
        if (r1 < 0) goto L5;
        r0.addComposited(this.composite[r1].keySet());
        r1 = r1 - 1;
        goto L3
    L5:
        return r0;
    }

    @Override // java.util.Map
    public V put(K r3, V r4) {
        MapMutator<K, V> r0 = this.mutator;
        if (r0 == null) goto L7;
        return r0.put(this, this.composite, r3, r4);
    L7:
        throw new UnsupportedOperationException("No mutator specified");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        MapMutator<K, V> r0 = this.mutator;
        if (r0 == null) goto L7;
        r0.putAll(this, this.composite, r4);
        return;
    L7:
        throw new UnsupportedOperationException("No mutator specified");
    }

    @Override // java.util.Map
    public V remove(Object r3) {
        int r0 = this.composite.length - 1;
    L3:
        if (r0 < 0) goto L9;
        if (this.composite[r0].containsKey(r3) == true) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return this.composite[r0].remove(r3);
    L9:
        return null;
    }

    public synchronized Map<K, V> removeComposited(Map<K, V> r6) {
        monitor-enter(this);
        Map<K, V> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        int r0 = this.composite.length;     // Catch: Throwable -> L14
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L12;
        if (this.composite[r2].equals(r7) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        Map<K, V>[] r3 = new Map[r0 - 1];     // Catch: Throwable -> L14
        System.arraycopy(this.composite, 0, r3, 0, r2);     // Catch: Throwable -> L14
        System.arraycopy(this.composite, r2 + 1, r3, r2, (r0 - r2) - 1);     // Catch: Throwable -> L14
        this.composite = r3;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r7;
    L12:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public void setMutator(MapMutator<K, V> r3) {
        this.mutator = (MapMutator) ZeusTransformUtils.wrapperContextForParams(r3, MapMutator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Map
    public int size() {
        int r0 = this.composite.length - 1;
        int r1 = 0;
    L3:
        if (r0 < 0) goto L5;
        r1 = r1 + this.composite[r0].size();
        r0 = r0 - 1;
        goto L3
    L5:
        return r1;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        CompositeCollection r0 = new CompositeCollection();
        int r1 = this.composite.length - 1;
    L3:
        if (r1 < 0) goto L5;
        r0.addComposited(this.composite[r1].values());
        r1 = r1 - 1;
        goto L3
    L5:
        return r0;
    }
}

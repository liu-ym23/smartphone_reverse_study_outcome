package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: classes6.dex */
public class EntrySetToMapIteratorAdapter<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
    transient Map.Entry<K, V> entry;
    Set<Map.Entry<K, V>> entrySet;
    transient Iterator<Map.Entry<K, V>> iterator;

    public EntrySetToMapIteratorAdapter(Set<Map.Entry<K, V>> r3) {
        this.entrySet = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        reset();
    }

    public synchronized Map.Entry<K, V> current() {
        monitor-enter(this);
        Map.Entry<K, V> r0 = this.entry;     // Catch: Throwable -> L9
        if (r0 == null) goto L8;
        monitor-exit(this);
        return r0;
    L8:
        throw new IllegalStateException();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public K getKey() {
        return current().getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        return current().getValue();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        this.entry = (Map.Entry) ZeusTransformUtils.preCheckCast(this.iterator.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        return getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
        this.entry = null;
    }

    public synchronized void reset() {
        monitor-enter(this);
        this.iterator = this.entrySet.iterator();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

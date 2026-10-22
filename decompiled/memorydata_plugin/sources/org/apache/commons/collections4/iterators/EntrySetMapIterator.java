package org.apache.commons.collections4.iterators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: classes6.dex */
public class EntrySetMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
    private boolean canRemove;
    private Iterator<Map.Entry<K, V>> iterator;
    private Map.Entry<K, V> last;
    private final Map<K, V> map;

    public EntrySetMapIterator(Map<K, V> r3) {
        Map<K, V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.canRemove = false;
        this.map = r4;
        this.iterator = r4.entrySet().iterator();
    }

    public K getKey() {
        Map.Entry<K, V> r1 = this.last;
        if (r1 == null) goto L7;
        return r1.getKey();
    L7:
        throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        Map.Entry<K, V> r1 = this.last;
        if (r1 == null) goto L7;
        return r1.getValue();
    L7:
        throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        Map.Entry<K, V> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.iterator.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.last = r0;
        this.canRemove = true;
        return r0.getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        if (this.canRemove == false) goto L7;
        this.iterator.remove();
        this.last = null;
        this.canRemove = false;
        return;
    L7:
        throw new IllegalStateException("Iterator remove() can only be called once after next()");
    }

    public String toString() {
        if (this.last != null) goto L5;
        return "MapIterator[]";
    L5:
        return "MapIterator[" + getKey() + "=" + getValue() + "]";
    }
}

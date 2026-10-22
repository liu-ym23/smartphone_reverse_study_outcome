package org.apache.commons.collections4.multimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MultiValuedMap;

/* JADX INFO: loaded from: classes6.dex */
public class ArrayListValuedHashMap<K, V> extends AbstractListValuedMap<K, V> implements Serializable {
    private static final int DEFAULT_INITIAL_LIST_CAPACITY = 3;
    private static final int DEFAULT_INITIAL_MAP_CAPACITY = 16;
    private static final long serialVersionUID = 20151118;
    private final int initialListCapacity;

    public ArrayListValuedHashMap() {
        this(16, 3);
    }

    public ArrayListValuedHashMap(int r2) {
        this(16, r2);
    }

    public ArrayListValuedHashMap(int r2, int r3) {
        super(new HashMap(r2));
        this.initialListCapacity = r3;
    }

    public ArrayListValuedHashMap(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this(r4.size(), 3);
        super.putAll(r4);
    }

    public ArrayListValuedHashMap(MultiValuedMap<? extends K, ? extends V> r3) {
        MultiValuedMap<? extends K, ? extends V> r4 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r3, MultiValuedMap.class, "com.obric.memorydata.plugin");
        this(r4.size(), 3);
        super.putAll(r4);
    }

    private void readObject(ObjectInputStream r2) {
        r2.defaultReadObject();
        setMap(new HashMap());
        doReadObject(r2);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        doWriteObject(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractListValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public ArrayList<V> createCollection() {
        return new ArrayList(this.initialListCapacity);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractListValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractListValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public /* bridge */ /* synthetic */ List createCollection() {
        return createCollection();
    }

    public void trimToSize() {
        Iterator<List<V>> r3 = getMap().values().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ArrayList) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.preCheckCast(r3.next(), Collection.class, "com.obric.memorydata.plugin"), ArrayList.class, "com.obric.memorydata.plugin")).trimToSize();
        goto L4
    }
}

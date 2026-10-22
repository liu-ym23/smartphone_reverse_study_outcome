package org.apache.commons.collections4.multimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MultiValuedMap;

/* JADX INFO: loaded from: classes6.dex */
public class HashSetValuedHashMap<K, V> extends AbstractSetValuedMap<K, V> implements Serializable {
    private static final int DEFAULT_INITIAL_MAP_CAPACITY = 16;
    private static final int DEFAULT_INITIAL_SET_CAPACITY = 3;
    private static final long serialVersionUID = 20151118;
    private final int initialSetCapacity;

    public HashSetValuedHashMap() {
        this(16, 3);
    }

    public HashSetValuedHashMap(int r2) {
        this(16, r2);
    }

    public HashSetValuedHashMap(int r2, int r3) {
        super(new HashMap(r2));
        this.initialSetCapacity = r3;
    }

    public HashSetValuedHashMap(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this(r4.size(), 3);
        super.putAll(r4);
    }

    public HashSetValuedHashMap(MultiValuedMap<? extends K, ? extends V> r3) {
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

    @Override // org.apache.commons.collections4.multimap.AbstractSetValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractSetValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public HashSet<V> createCollection() {
        return new HashSet(this.initialSetCapacity);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractSetValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public /* bridge */ /* synthetic */ Set createCollection() {
        return createCollection();
    }
}

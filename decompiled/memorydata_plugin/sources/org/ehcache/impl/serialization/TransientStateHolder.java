package org.ehcache.impl.serialization;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import org.ehcache.impl.internal.concurrent.ConcurrentHashMap;
import org.ehcache.spi.b.b;

/* JADX INFO: loaded from: classes7.dex */
public class TransientStateHolder<K, V> implements Serializable, b<K, V> {
    private static final long serialVersionUID = -6350493651462112289L;
    private final ConcurrentMap<K, V> map;

    public TransientStateHolder() {
        this.map = new ConcurrentHashMap();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.map.entrySet();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() != r3.getClass()) goto L13;
        TransientStateHolder r4 = (TransientStateHolder) ZeusTransformUtils.preCheckCast(r3, TransientStateHolder.class, "com.obric.memorydata.plugin");
        return this.map.equals(r4.map);
    L13:
        return false;
    }

    public V get(K r1) {
        return this.map.get(r1);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public V putIfAbsent(K r1, V r2) {
        return this.map.putIfAbsent(r1, r2);
    }
}

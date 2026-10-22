package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class HashedMap<K, V> extends AbstractHashedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public HashedMap() {
        super(16, 0.75f, 12);
    }

    public HashedMap(int r1) {
        super(r1);
    }

    public HashedMap(int r1, float r2) {
        super(r1, r2);
    }

    public HashedMap(Map<? extends K, ? extends V> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        doReadObject(r1);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        doWriteObject(r1);
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
    public HashedMap<K, V> clone() {
        return (HashedMap) ZeusTransformUtils.preCheckCast(super.clone(), HashedMap.class, "com.obric.memorydata.plugin");
    }
}

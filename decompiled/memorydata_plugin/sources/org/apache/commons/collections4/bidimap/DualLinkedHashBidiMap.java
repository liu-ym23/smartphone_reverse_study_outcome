package org.apache.commons.collections4.bidimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.collections4.BidiMap;

/* JADX INFO: loaded from: classes6.dex */
public class DualLinkedHashBidiMap<K, V> extends AbstractDualBidiMap<K, V> implements Serializable {
    private static final long serialVersionUID = 721969328361810L;

    public DualLinkedHashBidiMap() {
        super(new LinkedHashMap(), new LinkedHashMap());
    }

    public DualLinkedHashBidiMap(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        super(new LinkedHashMap(), new LinkedHashMap());
        putAll(r4);
    }

    public DualLinkedHashBidiMap(Map<K, V> r3, Map<V, K> r4, BidiMap<V, K> r5) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), (BidiMap) ZeusTransformUtils.wrapperContextForParams(r5, BidiMap.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.normalMap = new LinkedHashMap();
        this.reverseMap = new LinkedHashMap();
        putAll((Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.normalMap);
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    public BidiMap<V, K> createBidiMap(Map<V, K> r2, Map<K, V> r3, BidiMap<K, V> r4) {
        return new DualLinkedHashBidiMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (BidiMap) ZeusTransformUtils.wrapperContextForParams(r4, BidiMap.class, "com.obric.memorydata.plugin"));
    }
}

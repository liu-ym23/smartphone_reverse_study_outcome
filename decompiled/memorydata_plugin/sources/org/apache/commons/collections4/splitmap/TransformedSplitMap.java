package org.apache.commons.collections4.splitmap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.LinkedMap;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedSplitMap<J, K, U, V> extends AbstractIterableGetMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 5966875321133456994L;
    private final Transformer<? super J, ? extends K> keyTransformer;
    private final Transformer<? super U, ? extends V> valueTransformer;

    public TransformedSplitMap(Map<K, V> r3, Transformer<? super J, ? extends K> r4, Transformer<? super U, ? extends V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Transformer<? super J, ? extends K> r7 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        Transformer<? super U, ? extends V> r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r5, Transformer.class, "com.obric.memorydata.plugin");
        super(r6);
        Objects.requireNonNull(r7, "KeyTransformer must not be null.");
        this.keyTransformer = r7;
        Objects.requireNonNull(r8, "ValueTransformer must not be null.");
        this.valueTransformer = r8;
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    public static <J, K, U, V> TransformedSplitMap<J, K, U, V> transformingMap(Map<K, V> r2, Transformer<? super J, ? extends K> r3, Transformer<? super U, ? extends V> r4) {
        return new TransformedSplitMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(decorated());
    }

    public V checkSetValue(U r1) {
        return this.valueTransformer.transform(r1);
    }

    public void clear() {
        decorated().clear();
    }

    public V put(J r2, U r3) {
        return decorated().put(transformKey(r2), transformValue(r3));
    }

    public void putAll(Map<? extends J, ? extends U> r3) {
        Map<? extends J, ? extends U> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        decorated().putAll(transformMap(r4));
    }

    public K transformKey(J r1) {
        return this.keyTransformer.transform(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<K, V> transformMap(Map<? extends J, ? extends U> r5) {
        Map<K, V> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L5;
        return r6;
    L5:
        LinkedMap r0 = new LinkedMap(r6.size());
        Iterator<Map.Entry<K, V>> r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put(transformKey(r2.getKey()), transformValue(r2.getValue()));
        goto L7
    L9:
        return r0;
    }

    public V transformValue(U r1) {
        return this.valueTransformer.transform(r1);
    }
}

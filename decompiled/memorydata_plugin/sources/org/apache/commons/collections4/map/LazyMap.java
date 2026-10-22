package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

/* JADX INFO: loaded from: classes6.dex */
public class LazyMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7990956402564206740L;
    protected final Transformer<? super K, ? extends V> factory;

    public LazyMap(Map<K, V> r3, Factory<? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Factory r6 = (Factory) ZeusTransformUtils.wrapperContextForParams(r4, Factory.class, "com.obric.memorydata.plugin");
        super(r5);
        Objects.requireNonNull(r6, "Factory must not be null");
        this.factory = FactoryTransformer.factoryTransformer(r6);
    }

    public LazyMap(Map<K, V> r3, Transformer<? super K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Transformer<? super K, ? extends V> r6 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        super(r5);
        Objects.requireNonNull(r6, "Factory must not be null");
        this.factory = r6;
    }

    public static <K, V> LazyMap<K, V> lazyMap(Map<K, V> r2, Factory<? extends V> r3) {
        return new LazyMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Factory) ZeusTransformUtils.wrapperContextForParams(r3, Factory.class, "com.obric.memorydata.plugin"));
    }

    public static <V, K> LazyMap<K, V> lazyMap(Map<K, V> r2, Transformer<? super K, ? extends V> r3) {
        return new LazyMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V get(Object r2) {
        if (this.map.containsKey(r2) == true) goto L7;
        V r0 = this.factory.transform(r2);
        this.map.put(r2, r0);
        return r0;
    L7:
        return this.map.get(r2);
    }
}

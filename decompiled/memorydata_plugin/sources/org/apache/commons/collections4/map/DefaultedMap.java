package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 19698628745827L;
    private final Transformer<? super K, ? extends V> value;

    public DefaultedMap(V r1) {
        this(ConstantTransformer.constantTransformer(r1));
    }

    public DefaultedMap(Map<K, V> r3, Transformer<? super K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Transformer<? super K, ? extends V> r6 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        super(r5);
        Objects.requireNonNull(r6, "Transformer must not be null.");
        this.value = r6;
    }

    public DefaultedMap(Transformer<? super K, ? extends V> r3) {
        Transformer r4 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        this(new HashMap(), r4);
    }

    public static <K, V> Map<K, V> defaultedMap(Map<K, V> r2, Transformer<? super K, ? extends V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Transformer r5 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        return new DefaultedMap(r4, r5);
    L7:
        throw new IllegalArgumentException("Transformer must not be null");
    }

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> r2, V r3) {
        return new DefaultedMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), ConstantTransformer.constantTransformer(r3));
    }

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> r2, Factory<? extends V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Factory r5 = (Factory) ZeusTransformUtils.wrapperContextForParams(r3, Factory.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        return new DefaultedMap(r4, FactoryTransformer.factoryTransformer(r5));
    L7:
        throw new IllegalArgumentException("Factory must not be null");
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
    public V get(Object r3) {
        V r0 = this.map.get(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (this.map.containsKey(r3) == false) goto L8;
        return r0;
    L8:
        return this.value.transform(r3);
    }
}

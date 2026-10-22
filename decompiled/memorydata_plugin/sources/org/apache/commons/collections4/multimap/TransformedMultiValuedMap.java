package org.apache.commons.collections4.multimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedMultiValuedMap<K, V> extends AbstractMultiValuedMapDecorator<K, V> {
    private static final long serialVersionUID = 20150612;
    private final Transformer<? super K, ? extends K> keyTransformer;
    private final Transformer<? super V, ? extends V> valueTransformer;

    public TransformedMultiValuedMap(MultiValuedMap<K, V> r3, Transformer<? super K, ? extends K> r4, Transformer<? super V, ? extends V> r5) {
        MultiValuedMap r6 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r3, MultiValuedMap.class, "com.obric.memorydata.plugin");
        Transformer<? super K, ? extends K> r7 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        Transformer<? super V, ? extends V> r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r5, Transformer.class, "com.obric.memorydata.plugin");
        super(r6);
        this.keyTransformer = r7;
        this.valueTransformer = r8;
    }

    public static <K, V> TransformedMultiValuedMap<K, V> transformedMap(MultiValuedMap<K, V> r2, Transformer<? super K, ? extends K> r3, Transformer<? super V, ? extends V> r4) {
        MultiValuedMap r5 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r2, MultiValuedMap.class, "com.obric.memorydata.plugin");
        TransformedMultiValuedMap<K, V> r0 = new TransformedMultiValuedMap(r5, (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
        if (r5.isEmpty() == true) goto L5;
        ArrayListValuedHashMap r6 = new ArrayListValuedHashMap(r5);
        r0.clear();
        r0.putAll(r6);
    L5:
        return r0;
    }

    public static <K, V> TransformedMultiValuedMap<K, V> transformingMap(MultiValuedMap<K, V> r2, Transformer<? super K, ? extends K> r3, Transformer<? super V, ? extends V> r4) {
        return new TransformedMultiValuedMap((MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r2, MultiValuedMap.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean put(K r2, V r3) {
        return decorated().put(transformKey(r2), transformValue(r3));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K r3, Iterable<? extends V> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "Values must not be null.");
        Iterator<E> r6 = FluentIterable.of(r5).transform(this.valueTransformer).iterator();
        if (r6.hasNext() == true) goto L5;
    L7:
        return false;
    L5:
        if (CollectionUtils.addAll(decorated().get(transformKey(r3)), r6) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6, "Map must not be null.");
        boolean r0 = false;
        Iterator<Map.Entry<K, V>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0 = r0 | put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> r5) {
        MultiValuedMap r6 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r5, MultiValuedMap.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6, "Map must not be null.");
        boolean r0 = false;
        Iterator<Map.Entry<K, V>> r7 = r6.entries().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0 = r0 | put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        return r0;
    }

    public K transformKey(K r1) {
        Transformer<? super K, ? extends K> r0 = this.keyTransformer;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return r0.transform(r1);
    }

    public V transformValue(V r1) {
        Transformer<? super V, ? extends V> r0 = this.valueTransformer;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return r0.transform(r1);
    }
}

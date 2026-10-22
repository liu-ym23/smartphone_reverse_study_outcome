package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedMap<K, V> extends AbstractInputCheckedMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7023152376788900464L;
    protected final Transformer<? super K, ? extends K> keyTransformer;
    protected final Transformer<? super V, ? extends V> valueTransformer;

    public TransformedMap(Map<K, V> r3, Transformer<? super K, ? extends K> r4, Transformer<? super V, ? extends V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Transformer<? super K, ? extends K> r7 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        Transformer<? super V, ? extends V> r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r5, Transformer.class, "com.obric.memorydata.plugin");
        super(r6);
        this.keyTransformer = r7;
        this.valueTransformer = r8;
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    public static <K, V> TransformedMap<K, V> transformedMap(Map<K, V> r2, Transformer<? super K, ? extends K> r3, Transformer<? super V, ? extends V> r4) {
        Map<? extends K, ? extends V> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        TransformedMap<K, V> r0 = new TransformedMap(r5, (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
        if (r5.size() <= 0) goto L5;
        Map<K, V> r6 = r0.transformMap(r5);
        r0.clear();
        r0.decorated().putAll(r6);
    L5:
        return r0;
    }

    public static <K, V> TransformedMap<K, V> transformingMap(Map<K, V> r2, Transformer<? super K, ? extends K> r3, Transformer<? super V, ? extends V> r4) {
        return new TransformedMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    public V checkSetValue(V r1) {
        return this.valueTransformer.transform(r1);
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    public boolean isSetValueChecking() {
        if (this.valueTransformer == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K r1, V r2) {
        K r3 = transformKey(r1);
        V r4 = transformValue(r2);
        return decorated().put(r3, r4);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        Map<K, V> r4 = transformMap((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
        decorated().putAll(r4);
    }

    public K transformKey(K r1) {
        Transformer<? super K, ? extends K> r0 = this.keyTransformer;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return r0.transform(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<K, V> transformMap(Map<? extends K, ? extends V> r5) {
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

    public V transformValue(V r1) {
        Transformer<? super V, ? extends V> r0 = this.valueTransformer;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return r0.transform(r1);
    }
}

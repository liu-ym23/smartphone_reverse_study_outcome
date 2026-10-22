package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class PredicatedMap<K, V> extends AbstractInputCheckedMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7412622456128415156L;
    protected final Predicate<? super K> keyPredicate;
    protected final Predicate<? super V> valuePredicate;

    /* JADX WARN: Multi-variable type inference failed */
    public PredicatedMap(Map<K, V> r3, Predicate<? super K> r4, Predicate<? super V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Predicate<? super K> r7 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin");
        Predicate<? super V> r8 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r5, Predicate.class, "com.obric.memorydata.plugin");
        super(r6);
        this.keyPredicate = r7;
        this.valuePredicate = r8;
        Iterator<Map.Entry<K, V>> r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        validate(r10.getKey(), r10.getValue());
        goto L4
    }

    public static <K, V> PredicatedMap<K, V> predicatedMap(Map<K, V> r2, Predicate<? super K> r3, Predicate<? super V> r4) {
        return new PredicatedMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    public V checkSetValue(V r1) {
        if (this.valuePredicate.evaluate(r1) == false) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    public boolean isSetValueChecking() {
        if (this.valuePredicate == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K r1, V r2) {
        validate(r1, r2);
        return this.map.put(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<K, V>> r0 = r6.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        validate(r2.getKey(), r2.getValue());
        goto L4
    L6:
        super.putAll(r6);
    }

    public void validate(K r2, V r3) {
        Predicate<? super K> r0 = this.keyPredicate;
        if (r0 != null) goto L5;
    L9:
        Predicate<? super V> r1 = this.valuePredicate;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.evaluate(r3) == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
    L5:
        if (r0.evaluate(r2) == true) goto L9;
        throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
    }
}

package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    transient Class<K> keyTypeOrObjectUnderJ2cl;

    private EnumHashBiMap(Class<K> r3) {
        super(new EnumMap(r3), new HashMap());
        this.keyTypeOrObjectUnderJ2cl = r3;
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> r1) {
        return new EnumHashBiMap(r1);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        EnumHashBiMap<K, V> r0 = create(EnumBiMap.inferKeyTypeOrObjectUnderJ2cl(r3));
        r0.putAll(r3);
        return r0;
    }

    private void readObject(ObjectInputStream r4) {
        r4.defaultReadObject();
        this.keyTypeOrObjectUnderJ2cl = (Class) ZeusTransformUtils.preCheckCast(r4.readObject(), Class.class, "com.obric.memorydata.plugin");
        setDelegates(new EnumMap(this.keyTypeOrObjectUnderJ2cl), new HashMap());
        av.a(this, r4);
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(this.keyTypeOrObjectUnderJ2cl);
        av.a(this, r2);
    }

    K checkKey(K r2) {
        return (K) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r2), Enum.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.AbstractBiMap
    /* synthetic */ Object checkKey(Object r3) {
        return checkKey((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object r1) {
        return super.containsValue(r1);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public V forcePut(K r1, V r2) {
        return (V) super.forcePut(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k
    public /* synthetic */ Object forcePut(Object r3, Object r4) {
        return forcePut((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k
    public /* bridge */ /* synthetic */ k inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.keyTypeOrObjectUnderJ2cl;
    }

    public V put(K r1, V r2) {
        return (V) super.put(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map
    public /* synthetic */ Object put(Object r3, Object r4) {
        return put((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map
    public /* synthetic */ void putAll(Map r3) {
        super.putAll((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object r1) {
        return super.remove(r1);
    }

    @Override // com.google.common.collect.AbstractBiMap, java.util.Map
    public /* synthetic */ void replaceAll(BiFunction r3) {
        super.replaceAll((BiFunction) ZeusTransformUtils.wrapperContextForParams(r3, BiFunction.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map, com.google.common.collect.k
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }
}

package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    transient Class<K> keyTypeOrObjectUnderJ2cl;
    transient Class<V> valueTypeOrObjectUnderJ2cl;

    private EnumBiMap(Class<K> r3, Class<V> r4) {
        super(new EnumMap(r3), new EnumMap(r4));
        this.keyTypeOrObjectUnderJ2cl = r3;
        this.valueTypeOrObjectUnderJ2cl = r4;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> r1, Class<V> r2) {
        return new EnumBiMap(r1, r2);
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        EnumBiMap<K, V> r0 = create(inferKeyTypeOrObjectUnderJ2cl(r3), inferValueTypeOrObjectUnderJ2cl(r3));
        r0.putAll(r3);
        return r0;
    }

    static <K extends Enum<K>> Class<K> inferKeyTypeOrObjectUnderJ2cl(Map<K, ?> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, EnumBiMap.class) == false) goto L7;
        return ((EnumBiMap) ZeusTransformUtils.preCheckCast(r4, EnumBiMap.class, "com.obric.memorydata.plugin")).keyTypeOrObjectUnderJ2cl;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, EnumHashBiMap.class) == true) goto L9;
        com.google.common.base.n.a(!r4.isEmpty());
        return ar.a((Enum) ZeusTransformUtils.preCheckCast(r4.keySet().iterator().next(), Enum.class, "com.obric.memorydata.plugin"));
    L9:
        return ((EnumHashBiMap) ZeusTransformUtils.preCheckCast(r4, EnumHashBiMap.class, "com.obric.memorydata.plugin")).keyTypeOrObjectUnderJ2cl;
    }

    private static <V extends Enum<V>> Class<V> inferValueTypeOrObjectUnderJ2cl(Map<?, V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, EnumBiMap.class) == true) goto L5;
        com.google.common.base.n.a(!r4.isEmpty());
        return ar.a((Enum) ZeusTransformUtils.preCheckCast(r4.values().iterator().next(), Enum.class, "com.obric.memorydata.plugin"));
    L5:
        return ((EnumBiMap) ZeusTransformUtils.preCheckCast(r4, EnumBiMap.class, "com.obric.memorydata.plugin")).valueTypeOrObjectUnderJ2cl;
    }

    private void readObject(ObjectInputStream r4) {
        r4.defaultReadObject();
        this.keyTypeOrObjectUnderJ2cl = (Class) ZeusTransformUtils.preCheckCast(r4.readObject(), Class.class, "com.obric.memorydata.plugin");
        this.valueTypeOrObjectUnderJ2cl = (Class) ZeusTransformUtils.preCheckCast(r4.readObject(), Class.class, "com.obric.memorydata.plugin");
        setDelegates(new EnumMap(this.keyTypeOrObjectUnderJ2cl), new EnumMap(this.valueTypeOrObjectUnderJ2cl));
        av.a(this, r4);
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(this.keyTypeOrObjectUnderJ2cl);
        r2.writeObject(this.valueTypeOrObjectUnderJ2cl);
        av.a(this, r2);
    }

    K checkKey(K r2) {
        return (K) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r2), Enum.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.AbstractBiMap
    /* synthetic */ Object checkKey(Object r3) {
        return checkKey((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"));
    }

    V checkValue(V r2) {
        return (V) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r2), Enum.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.AbstractBiMap
    /* synthetic */ Object checkValue(Object r3) {
        return checkValue((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"));
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k
    public /* bridge */ /* synthetic */ Object forcePut(Object r1, Object r2) {
        return super.forcePut(r1, r2);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
        return super.put(r1, r2);
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

    public Class<V> valueType() {
        return this.valueTypeOrObjectUnderJ2cl;
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map, com.google.common.collect.k
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }
}

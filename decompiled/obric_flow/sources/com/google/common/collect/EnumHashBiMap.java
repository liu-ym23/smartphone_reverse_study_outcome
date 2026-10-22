package com.google.common.collect;

import java.io.IOException;
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
    public transient Class e;

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> r5) {
        EnumHashBiMap<K, V> r10 = new EnumHashBiMap(new EnumMap(r5), p7.X(r5.getEnumConstants().length));
        r10.e = r5;
        return r10;
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        this.e = (Class) r5.readObject();
        setDelegates(new EnumMap(this.e), new HashMap((((Enum[]) this.e.getEnumConstants()).length * 3) / 2));
        p7.d0(this, r5, r5.readInt());
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(this.e);
        p7.y0(this, r5);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkKey(Object r5) {
        return checkKey((Enum) r5);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object r5) {
        return super.containsValue(r5);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.c1
    public /* bridge */ /* synthetic */ Object forcePut(Object r5, Object r10) {
        return forcePut((Enum) r5, r10);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.c1
    public /* bridge */ /* synthetic */ c1 inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r5, Object r10) {
        return put((Enum) r5, r10);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map r5) {
        super.putAll(r5);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object r5) {
        return super.remove(r5);
    }

    @Override // com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ void replaceAll(BiFunction r5) {
        super.replaceAll(r5);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public K checkKey(K r5) {
        r5.getClass();
        return r5;
    }

    public V forcePut(K r5, V r10) {
        return (V) super.forcePut(r5, r10);
    }

    public V put(K r5, V r10) {
        return (V) super.put(r5, r10);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> r5) {
        EnumHashBiMap<K, V> r10 = create(EnumBiMap.inferKeyType(r5));
        r10.putAll(r5);
        return r10;
    }
}

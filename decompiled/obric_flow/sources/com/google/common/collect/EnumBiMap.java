package com.google.common.collect;

import java.io.IOException;
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
    public transient Class e;
    public transient Class f;

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> r5, Class<V> r10) {
        EnumBiMap<K, V> r11 = new EnumBiMap(new EnumMap(r5), new EnumMap(r10));
        r11.e = r5;
        r11.f = r10;
        return r11;
    }

    public static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> r5) {
        if ((r5 instanceof EnumBiMap) == false) goto L7;
        return ((EnumBiMap) r5).keyType();
    L7:
        if ((r5 instanceof EnumHashBiMap) == true) goto L9;
        com.google.common.base.b0.i(!r5.isEmpty());
        return r5.keySet().iterator().next().getDeclaringClass();
    L9:
        return ((EnumHashBiMap) r5).keyType();
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        this.e = (Class) r5.readObject();
        this.f = (Class) r5.readObject();
        setDelegates(new EnumMap(this.e), new EnumMap(this.f));
        p7.d0(this, r5, r5.readInt());
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(this.e);
        r5.writeObject(this.f);
        p7.y0(this, r5);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkKey(Object r5) {
        return checkKey((Enum) r5);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkValue(Object r5) {
        return checkValue((Enum) r5);
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
        return super.forcePut(r5, r10);
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
        return super.put(r5, r10);
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

    public Class<V> valueType() {
        return this.f;
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public K checkKey(K r5) {
        r5.getClass();
        return r5;
    }

    public V checkValue(V r5) {
        r5.getClass();
        return r5;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> r5) {
        Class r10 = inferKeyType(r5);
        if ((r5 instanceof EnumBiMap) == false) goto L5;
        Class r11 = ((EnumBiMap) r5).f;
    L6:
        EnumBiMap<K, V> r12 = create(r10, r11);
        r12.putAll(r5);
        return r12;
    L5:
        com.google.common.base.b0.i(!r5.isEmpty());
        r11 = r5.values().iterator().next().getDeclaringClass();
        goto L6
    }
}

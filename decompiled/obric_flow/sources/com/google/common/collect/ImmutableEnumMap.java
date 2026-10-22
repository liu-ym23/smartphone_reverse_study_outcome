package com.google.common.collect;

import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    public final transient EnumMap e;

    public static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        public EnumSerializedForm(EnumMap<K, V> r5) {
            this.delegate = r5;
        }

        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate, null);
        }
    }

    public /* synthetic */ ImmutableEnumMap(EnumMap r5, s3 r10) {
        this(r5);
    }

    public static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> r5) {
        int r10 = r5.size();
        if (r10 == 0) goto L11;
        if (r10 != 1) goto L7;
        Map.Entry r11 = (Map.Entry) p7.H(r5.entrySet());
        return ImmutableMap.of((Enum) r11.getKey(), r11.getValue());
    L7:
        return new ImmutableEnumMap(r5);
    L11:
        return ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object r5) {
        return this.e.containsKey(r5);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public ga entryIterator() {
        return new d5(this.e.entrySet().iterator(), 1);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return p7.R(this.e.entrySet().spliterator(), new h(18));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImmutableEnumMap) == false) goto L9;
        r5 = ((ImmutableEnumMap) r5).e;
    L9:
        return this.e.equals(r5);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        this.e.forEach(r5);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r5) {
        return (V) this.e.get(r5);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ga keyIterator() {
        return p7.w0(this.e.keySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap
    public Spliterator<K> keySpliterator() {
        return this.e.keySet().spliterator();
    }

    @Override // java.util.Map
    public int size() {
        return this.e.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new EnumSerializedForm(this.e);
    }

    public ImmutableEnumMap(EnumMap r5) {
        this.e = r5;
        com.google.common.base.b0.i(!r5.isEmpty());
    }
}

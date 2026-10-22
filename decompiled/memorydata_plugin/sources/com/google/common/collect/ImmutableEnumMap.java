package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final transient EnumMap<K, V> delegate;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableEnumMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        EnumSerializedForm(EnumMap<K, V> r1) {
            this.delegate = r1;
        }

        Object readResolve() {
            return new ImmutableEnumMap(this.delegate, null);
        }
    }

    private ImmutableEnumMap(EnumMap<K, V> r1) {
        this.delegate = r1;
        com.google.common.base.n.a(!r1.isEmpty());
    }

    /* synthetic */ ImmutableEnumMap(EnumMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> r3) {
        int r0 = r3.size();
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L7;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(aj.b(r3.entrySet()), Map.Entry.class, "com.obric.memorydata.plugin");
        return ImmutableMap.of((Enum) ZeusTransformUtils.preCheckCast(r4.getKey(), Enum.class, "com.obric.memorydata.plugin"), r4.getValue());
    L7:
        return new ImmutableEnumMap(r3);
    L11:
        return ImmutableMap.of();
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use EnumSerializedForm");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object r1) {
        return this.delegate.containsKey(r1);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    bj<Map.Entry<K, V>> entryIterator() {
        return Maps.c(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return p.a(this.delegate.entrySet().spliterator(), $$Lambda$r4GDw1bKmisfpffuYWONftUGQUA.INSTANCE);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ImmutableEnumMap.class) == false) goto L10;
        r3 = ((ImmutableEnumMap) ZeusTransformUtils.preCheckCast(r3, ImmutableEnumMap.class, "com.obric.memorydata.plugin")).delegate;
    L10:
        return this.delegate.equals(r3);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r3) {
        BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
        this.delegate.forEach(r4);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r1) {
        return this.delegate.get(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    bj<K> keyIterator() {
        return Iterators.a(this.delegate.keySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap
    Spliterator<K> keySpliterator() {
        return this.delegate.keySet().spliterator();
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }
}

package com.google.common.collect;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class JdkBackedImmutableMap<K, V> extends ImmutableMap<K, V> {
    public final transient Map e;
    public final transient ImmutableList f;

    public JdkBackedImmutableMap(Map<K, V> r5, ImmutableList<Map.Entry<K, V>> r10) {
        this.e = r5;
        this.f = r10;
    }

    public static <K, V> ImmutableMap<K, V> create(int r10, Map.Entry<K, V>[] r11, boolean r12) {
        HashMap r5 = p7.X(r10);
        int r13 = 0;
        HashMap r14 = null;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r10) goto L13;
        Map.Entry<K, V> r17 = r11[r15];
        Objects.requireNonNull(r17);
        ImmutableMapEntry r18 = RegularImmutableMap.makeImmutable(r17);
        r11[r15] = r18;
        K r19 = r18.getKey();
        V r20 = r11[r15].getValue();
        Object r21 = r5.put(r19, r20);
        if (r21 == null) goto L12;
        if (r12 == true) goto L10;
        if (r14 != null) goto L9;
        r14 = new HashMap();
    L9:
        r14.put(r19, r20);
        r16 = r16 + 1;
        goto L12
    L10:
        Map.Entry<K, V> r22 = r11[r15];
        String r110 = String.valueOf(r22.getKey());
        String r111 = String.valueOf(r21);
        throw ImmutableMap.conflictException(STGroup.DICT_KEY, r22, androidx.room.jarjarred.org.antlr.runtime.a.m(r111.length() + (r110.length() + 1), r110, "=", r111));
    L12:
        r15 = r15 + 1;
        goto L3
    L13:
        if (r14 == null) goto L26;
        Map.Entry<K, V>[] r112 = new Map.Entry[r10 - r16];
        int r23 = 0;
    L15:
        if (r13 >= r10) goto L24;
        Map.Entry<K, V> r24 = r11[r13];
        Objects.requireNonNull(r24);
        Map.Entry<K, V> r25 = r24;
        K r26 = r25.getKey();
        if (r14.containsKey(r26) == false) goto L22;
        Object r27 = r14.get(r26);
        if (r27 == null) goto L23;
        ImmutableMapEntry r28 = new ImmutableMapEntry(r26, r27);
        r14.put(r26, null);
        r25 = r28;
    L23:
        r13 = r13 + 1;
    L22:
        r112[r23] = r25;
        r23 = r23 + 1;
        goto L23
    L24:
        r11 = r112;
    L26:
        return new JdkBackedImmutableMap(r5, ImmutableList.asImmutableList(r11, r10));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new ImmutableMapValues(this);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        r5.getClass();
        l5 r10 = new l5(r5, 0);
        this.f.forEach(r10);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r5) {
        return (V) this.e.get(r5);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f.size();
    }
}

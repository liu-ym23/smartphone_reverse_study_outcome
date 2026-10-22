package com.google.common.collect;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class JdkBackedImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    private final Map<V, K> backwardDelegate;
    public final transient ImmutableList e;
    public transient JdkBackedImmutableBiMap f;
    private final Map<K, V> forwardDelegate;

    public final class InverseEntries extends ImmutableList<Map.Entry<V, K>> {
        final /* synthetic */ JdkBackedImmutableBiMap this$0;

        public InverseEntries(JdkBackedImmutableBiMap r5, k5 r10) {
            this.this$0 = r5;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r5) {
            return get(r5);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return JdkBackedImmutableBiMap.access$100(this.this$0).size();
        }

        @Override // java.util.List
        public Map.Entry<V, K> get(int r5) {
            Map.Entry r10 = (Map.Entry) JdkBackedImmutableBiMap.access$100(this.this$0).get(r5);
            return p7.L(r10.getValue(), r10.getKey());
        }
    }

    public JdkBackedImmutableBiMap(ImmutableList r5, Map r10, Map r11) {
        this.e = r5;
        this.forwardDelegate = r10;
        this.backwardDelegate = r11;
    }

    public static /* synthetic */ ImmutableList access$100(JdkBackedImmutableBiMap r5) {
        return r5.e;
    }

    public static <K, V> ImmutableBiMap<K, V> create(int r10, Map.Entry<K, V>[] r11) {
        HashMap r5 = p7.X(r10);
        HashMap r12 = p7.X(r10);
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L14;
        Map.Entry<K, V> r14 = r11[r13];
        Objects.requireNonNull(r14);
        ImmutableMapEntry r15 = RegularImmutableMap.makeImmutable(r14);
        r11[r13] = r15;
        Object r16 = r5.putIfAbsent(r15.getKey(), r15.getValue());
        if (r16 != null) goto L11;
        Object r17 = r12.putIfAbsent(r15.getValue(), r15.getKey());
        if (r17 != null) goto L9;
        r13 = r13 + 1;
        goto L3
    L9:
        String r18 = String.valueOf(r17);
        String r19 = String.valueOf(r15.getValue());
        int r20 = r18.length() + 1;
        throw ImmutableMap.conflictException("value", androidx.room.jarjarred.org.antlr.runtime.a.m(r19.length() + r20, r18, "=", r19), r11[r13]);
    L11:
        String r21 = String.valueOf(r15.getKey());
        String r22 = String.valueOf(r16);
        int r23 = r21.length() + 1;
        throw ImmutableMap.conflictException(STGroup.DICT_KEY, androidx.room.jarjarred.org.antlr.runtime.a.m(r22.length() + r23, r21, "=", r22), r11[r13]);
    L14:
        return new JdkBackedImmutableBiMap(ImmutableList.asImmutableList(r11, r10), r5, r12);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.e);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r5) {
        return this.forwardDelegate.get(r5);
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.c1
    public /* bridge */ /* synthetic */ c1 inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.e.size();
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.c1
    public ImmutableBiMap<V, K> inverse() {
        JdkBackedImmutableBiMap r5 = this.f;
        if (r5 != null) goto L6;
        JdkBackedImmutableBiMap r10 = new JdkBackedImmutableBiMap(new InverseEntries(this, null), this.backwardDelegate, this.forwardDelegate);
        this.f = r10;
        r10.f = this;
        return r10;
    L6:
        return r5;
    }
}

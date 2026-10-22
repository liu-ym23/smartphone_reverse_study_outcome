package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class Multimaps$UnmodifiableSetMultimap<K, V> extends Multimaps$UnmodifiableMultimap<K, V> implements s8 {
    private static final long serialVersionUID = 0;

    public Multimaps$UnmodifiableSetMultimap(s8 r5) {
        super(r5);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.x2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ q7 delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public Set<Map.Entry<K, V>> entries() {
        return new n7(Collections.unmodifiableSet(delegate().entries()));
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public Set<V> get(K r5) {
        return Collections.unmodifiableSet(delegate().get(r5));
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public Set<V> removeAll(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public Set<V> replaceValues(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.x2, com.google.common.collect.z2
    public s8 delegate() {
        return (s8) super.delegate();
    }
}

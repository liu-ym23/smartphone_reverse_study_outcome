package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class Multimaps$UnmodifiableListMultimap<K, V> extends Multimaps$UnmodifiableMultimap<K, V> implements x5 {
    private static final long serialVersionUID = 0;

    public Multimaps$UnmodifiableListMultimap(x5 r5) {
        super(r5);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.x2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ q7 delegate() {
        return delegate();
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
    public List<V> get(K r5) {
        return Collections.unmodifiableList(delegate().get(r5));
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public List<V> removeAll(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.q7
    public List<V> replaceValues(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, com.google.common.collect.x2, com.google.common.collect.z2
    public x5 delegate() {
        return (x5) super.delegate();
    }
}

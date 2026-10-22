package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> r1) {
            this.map = r1;
        }

        Object readResolve() {
            return this.map.values();
        }
    }

    ImmutableMapValues(ImmutableMap<K, V> r1) {
        this.map = r1;
    }

    static /* synthetic */ ImmutableMap access$000(ImmutableMapValues r0) {
        return r0.map;
    }

    static /* synthetic */ void lambda$forEach$0(Consumer r1, Object r2, Object r3) {
        ((Consumer) ZeusTransformUtils.wrapperContextForParams(r1, Consumer.class, "com.obric.memorydata.plugin")).accept(r3);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        final ImmutableList<Map.Entry<K, V>> r0 = this.map.entrySet().asList();
        return new AnonymousClass2(this, r0);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (Iterators.a(iterator(), r1) == false) goto L6;
        return true;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super V> r3) {
        final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        this.map.forEach(new $$Lambda$ImmutableMapValues$uQ2dXKWiTIQ6CSy7IcVv7zBRQ0U(r4));
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public bj<V> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<V> spliterator() {
        return p.a(this.map.entrySet().spliterator(), $$Lambda$kPj8Ioh2qrHaOpflIdB8Zk2L0PY.INSTANCE);
    }
}

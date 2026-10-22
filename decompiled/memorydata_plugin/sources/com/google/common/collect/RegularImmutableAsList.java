package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ListIterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    RegularImmutableAsList(ImmutableCollection<E> r1, ImmutableList<? extends E> r2) {
        this.delegate = r1;
        this.delegateList = r2;
    }

    RegularImmutableAsList(ImmutableCollection<E> r1, Object[] r2) {
        this(r1, ImmutableList.asImmutableList(r2));
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r1, int r2) {
        return this.delegateList.copyIntoArray(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableAsList
    ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // com.google.common.collect.ImmutableList, java.lang.Iterable
    public void forEach(Consumer<? super E> r3) {
        Consumer<? super Object> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        this.delegateList.forEach(r4);
    }

    @Override // java.util.List
    public E get(int r1) {
        return this.delegateList.get(r1);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public bk<E> listIterator(int r1) {
        return this.delegateList.listIterator(r1);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
        return listIterator(r1);
    }
}

package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final enum Iterators$EmptyModifiableIterator extends Enum<Iterators$EmptyModifiableIterator> implements Iterator<Object> {
    public static final Iterators$EmptyModifiableIterator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Iterators$EmptyModifiableIterator[] f8843a = null;

    static {
        Iterators$EmptyModifiableIterator r5 = new Iterators$EmptyModifiableIterator("INSTANCE", 0);
        INSTANCE = r5;
        f8843a = new Iterators$EmptyModifiableIterator[]{r5};
    }

    public static Iterators$EmptyModifiableIterator valueOf(String r5) {
        return (Iterators$EmptyModifiableIterator) Enum.valueOf(Iterators$EmptyModifiableIterator.class, r5);
    }

    public static Iterators$EmptyModifiableIterator[] values() {
        return (Iterators$EmptyModifiableIterator[]) f8843a.clone();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        p7.t(false);
    }
}

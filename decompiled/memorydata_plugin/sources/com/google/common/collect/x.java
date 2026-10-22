package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x<T> extends ac implements Iterator<T> {
    public x() {
    }

    public abstract Iterator<T> a();

    @Override // com.google.common.collect.ac
    public /* synthetic */ Object delegate() {
        return a();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return a().hasNext();
    }

    public T next() {
        return a().next();
    }

    public void remove() {
        a().remove();
    }
}

package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<T> extends bj<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f4679a;

    public g(T r1) {
        this.f4679a = r1;
    }

    public abstract T a(T r1);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f4679a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        T r0 = this.f4679a;
        if (r0 == null) goto L7;
        this.f4679a = a(r0);
        return r0;
    L7:
        throw new NoSuchElementException();
    }
}

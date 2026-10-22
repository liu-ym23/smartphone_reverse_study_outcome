package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n0 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9083a;

    public n0(Object r5) {
        this.f9083a = r5;
    }

    public abstract Object a(Object r5);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9083a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object r5 = this.f9083a;
        if (r5 == null) goto L7;
        this.f9083a = a(r5);
        return r5;
    L7:
        throw new NoSuchElementException();
    }
}

package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s9 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f9159a;

    public s9(Iterator r5) {
        r5.getClass();
        this.f9159a = r5;
    }

    public abstract Object a(Object r5);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9159a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f9159a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f9159a.remove();
    }
}

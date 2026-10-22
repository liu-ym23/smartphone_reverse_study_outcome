package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b5 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f8907b;

    public b5(Iterator r5) {
        this.f8907b = r5;
        this.f8906a = true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8907b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object r5 = this.f8907b.next();
        this.f8906a = false;
        return r5;
    }

    @Override // java.util.Iterator
    public final void remove() {
        p7.t(!this.f8906a);
        this.f8907b.remove();
    }
}

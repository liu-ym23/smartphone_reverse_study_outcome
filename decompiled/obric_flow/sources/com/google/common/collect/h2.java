package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h2 extends z2 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y7 f9004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2 f9005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMultiset f9006c;

    public h2(ConcurrentHashMultiset r5, g2 r10) {
        this.f9006c = r5;
        this.f9005b = r10;
    }

    @Override // com.google.common.collect.z2
    public final Object delegate() {
        return this.f9005b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9005b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        y7 r5 = (y7) this.f9005b.next();
        this.f9004a = r5;
        return r5;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f9004a == null) goto L5;
        boolean r5 = true;
    L6:
        com.google.common.base.b0.u(r5, "no calls to next() since the last call to remove()");
        this.f9006c.setCount(this.f9004a.getElement(), 0);
        this.f9004a = null;
        return;
    L5:
        r5 = false;
        goto L6
    }
}

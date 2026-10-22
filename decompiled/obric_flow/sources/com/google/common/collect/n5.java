package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class n5 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p5 f9089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMultimap.ValueEntry f9090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9091c;
    public final /* synthetic */ o5 d;

    public n5(o5 r5) {
        this.d = r5;
        this.f9089a = r5.f;
        this.f9091c = r5.e;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        o5 r5 = this.d;
        if (r5.e != this.f9091c) goto L10;
        if (this.f9089a == r5) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        LinkedHashMultimap.ValueEntry r5 = (LinkedHashMultimap.ValueEntry) this.f9089a;
        V r10 = r5.getValue();
        this.f9090b = r5;
        this.f9089a = r5.getSuccessorInValueSet();
        return r10;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        o5 r5 = this.d;
        if (r5.e != this.f9091c) goto L11;
        if (this.f9090b == null) goto L7;
        boolean r10 = true;
    L8:
        com.google.common.base.b0.u(r10, "no calls to next() since the last call to remove()");
        r5.remove(this.f9090b.getValue());
        this.f9091c = r5.e;
        this.f9090b = null;
        return;
    L7:
        r10 = false;
        goto L8
    L11:
        throw new ConcurrentModificationException();
    }
}

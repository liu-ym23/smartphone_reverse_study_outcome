package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class w7 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x7 f9211b;

    public w7(x7 r5) {
        this.f9211b = r5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9210a != 0) goto L7;
        x7 r5 = this.f9211b;
        if (r5.f9225c.map.containsKey(r5.f9224b) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        this.f9210a++;
        x7 r5 = this.f9211b;
        return r5.f9225c.map.get(r5.f9224b);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean r5 = true;
        if (this.f9210a == 1) goto L6;
        r5 = false;
    L6:
        p7.t(r5);
        this.f9210a = -1;
        x7 r10 = this.f9211b;
        r10.f9225c.map.remove(r10.f9224b);
    }
}

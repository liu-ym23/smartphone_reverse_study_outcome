package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c8 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z7 f8926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator f8927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y7 f8928c;
    public int d;
    public int e;
    public boolean f;

    public c8(z7 r5, Iterator r10) {
        this.f8926a = r5;
        this.f8927b = r10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.d <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.f8927b.hasNext() == true) goto L8;
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L10;
        if (this.d != 0) goto L7;
        y7 r5 = (y7) this.f8927b.next();
        this.f8928c = r5;
        int r10 = r5.getCount();
        this.d = r10;
        this.e = r10;
    L7:
        this.d--;
        this.f = true;
        y7 r11 = this.f8928c;
        Objects.requireNonNull(r11);
        return r11.getElement();
    L10:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        p7.t(this.f);
        if (this.e != 1) goto L5;
        this.f8927b.remove();
    L6:
        this.e--;
        this.f = false;
        return;
    L5:
        y7 r5 = this.f8928c;
        Objects.requireNonNull(r5);
        this.f8926a.remove(r5.getElement());
        goto L6
    }
}

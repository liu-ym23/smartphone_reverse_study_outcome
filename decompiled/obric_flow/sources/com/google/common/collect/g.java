package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractIterator$State f8981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8982b;

    public g() {
        this.f8981a = AbstractIterator$State.NOT_READY;
    }

    public abstract Object a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        AbstractIterator$State r5 = this.f8981a;
        AbstractIterator$State r10 = AbstractIterator$State.FAILED;
        if (r5 == r10) goto L5;
        boolean r11 = true;
    L6:
        com.google.common.base.b0.t(r11);
        int r12 = f.f8963a[this.f8981a.ordinal()];
        if (r12 != 1) goto L9;
        return false;
    L9:
        if (r12 == 2) goto L14;
        this.f8981a = r10;
        this.f8982b = a();
        if (this.f8981a == AbstractIterator$State.DONE) goto L16;
        this.f8981a = AbstractIterator$State.READY;
        return true;
    L16:
        return false;
    L14:
        return true;
    L5:
        r11 = false;
        goto L6
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        this.f8981a = AbstractIterator$State.NOT_READY;
        Object r5 = this.f8982b;
        this.f8982b = null;
        return r5;
    L7:
        throw new NoSuchElementException();
    }
}

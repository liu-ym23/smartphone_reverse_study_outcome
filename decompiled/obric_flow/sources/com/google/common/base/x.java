package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractIterator$State f8674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator f8676c;

    public x(com.bumptech.glide.load.engine.v r5) {
        this.f8674a = AbstractIterator$State.NOT_READY;
        Iterator r10 = r5.f1567b.iterator();
        r10.getClass();
        this.f8676c = r10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        AbstractIterator$State r5 = this.f8674a;
        AbstractIterator$State r10 = AbstractIterator$State.FAILED;
        if (r5 == r10) goto L5;
        boolean r11 = true;
    L6:
        b0.t(r11);
        int r12 = a.f8647a[this.f8674a.ordinal()];
        if (r12 != 1) goto L9;
        return false;
    L9:
        if (r12 == 2) goto L21;
        this.f8674a = r10;
    L11:
        Iterator r13 = this.f8676c;
        if (r13.hasNext() == false) goto L16;
        Optional r14 = (Optional) r13.next();
        if (r14.isPresent() == false) goto L11;
        Object r15 = r14.get();
    L17:
        this.f8675b = r15;
        if (this.f8674a == AbstractIterator$State.DONE) goto L26;
        this.f8674a = AbstractIterator$State.READY;
        return true;
    L26:
        return false;
    L16:
        this.f8674a = AbstractIterator$State.DONE;
        r15 = null;
        goto L17
    L21:
        return true;
    L5:
        r11 = false;
        goto L6
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        this.f8674a = AbstractIterator$State.NOT_READY;
        Object r5 = this.f8675b;
        this.f8675b = null;
        return r5;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

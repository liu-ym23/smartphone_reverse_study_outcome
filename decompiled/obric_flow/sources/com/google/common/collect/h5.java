package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class h5 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f9012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Iterator f9013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f9014c;
    public ArrayDeque d;

    @Override // java.util.Iterator
    public final boolean hasNext() {
    L2:
        Iterator r5 = this.f9013b;
        r5.getClass();
        if (r5.hasNext() == true) goto L31;
    L4:
        Iterator r10 = this.f9014c;
        if (r10 != null) goto L7;
    L10:
        ArrayDeque r11 = this.d;
        if (r11 == null) goto L15;
        if (r11.isEmpty() == true) goto L15;
        this.f9014c = (Iterator) this.d.removeFirst();
    L15:
        Iterator r12 = null;
    L16:
        this.f9014c = r12;
        if (r12 == null) goto L18;
        Iterator r13 = (Iterator) r12.next();
        this.f9013b = r13;
        if ((r13 instanceof h5) == false) goto L2;
        h5 r14 = (h5) r13;
        this.f9013b = r14.f9013b;
        if (this.d != null) goto L25;
        this.d = new ArrayDeque();
    L25:
        this.d.addFirst(this.f9014c);
        if (r14.d != null) goto L28;
    L30:
        this.f9014c = r14.f9014c;
    L28:
        if (r14.d.isEmpty() == true) goto L30;
        this.d.addFirst((Iterator) r14.d.removeLast());
        goto L28
    L18:
        return false;
    L7:
        if (r10.hasNext() == false) goto L10;
        r12 = this.f9014c;
        goto L16
    L31:
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        Iterator r5 = this.f9013b;
        this.f9012a = r5;
        return r5.next();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        Iterator r5 = this.f9012a;
        if (r5 == null) goto L7;
        r5.remove();
        this.f9012a = null;
        return;
    L7:
        throw new IllegalStateException("no calls to next() since the last call to remove()");
    }
}

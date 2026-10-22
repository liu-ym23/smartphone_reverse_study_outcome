package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class s5 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f9156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u5 f9157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u5 f9158c;
    public int d;
    public final /* synthetic */ LinkedListMultimap e;

    public s5(LinkedListMultimap r5) {
        this.e = r5;
        this.f9156a = p7.Y(r5.keySet().size());
        this.f9157b = LinkedListMultimap.access$200(r5);
        this.d = LinkedListMultimap.access$000(r5);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (LinkedListMultimap.access$000(this.e) != this.d) goto L10;
        if (this.f9157b == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (LinkedListMultimap.access$000(this.e) != this.d) goto L16;
        u5 r5 = this.f9157b;
        if (r5 == null) goto L14;
        this.f9158c = r5;
        HashSet r10 = this.f9156a;
        r10.add(r5.f9182a);
    L7:
        u5 r11 = this.f9157b.f9184c;
        this.f9157b = r11;
        if (r11 == null) goto L12;
        if (r10.add(r11.f9182a) == false) goto L7;
    L12:
        return this.f9158c.f9182a;
    L14:
        throw new NoSuchElementException();
    L16:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        LinkedListMultimap r5 = this.e;
        if (LinkedListMultimap.access$000(r5) != this.d) goto L11;
        if (this.f9158c == null) goto L7;
        boolean r10 = true;
    L8:
        com.google.common.base.b0.u(r10, "no calls to next() since the last call to remove()");
        LinkedListMultimap.access$400(r5, this.f9158c.f9182a);
        this.f9158c = null;
        this.d = LinkedListMultimap.access$000(r5);
        return;
    L7:
        r10 = false;
        goto L8
    L11:
        throw new ConcurrentModificationException();
    }
}

package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class v5 implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u5 f9195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u5 f9196c;
    public u5 d;
    public int e;
    public final /* synthetic */ LinkedListMultimap f;

    public v5(LinkedListMultimap r5, int r10) {
        this.f = r5;
        this.e = LinkedListMultimap.access$000(r5);
        int r11 = r5.size();
        com.google.common.base.b0.o(r10, r11);
        if (r10 < (r11 / 2)) goto L12;
        this.d = LinkedListMultimap.access$100(r5);
        this.f9194a = r11;
    L5:
        int r12 = r10 + 1;
        if (r10 >= r11) goto L20;
        a();
        u5 r13 = this.d;
        if (r13 == null) goto L11;
        this.f9196c = r13;
        this.f9195b = r13;
        this.d = r13.d;
        this.f9194a--;
        r10 = r12;
        goto L5
    L11:
        throw new NoSuchElementException();
    L20:
        this.f9196c = null;
        return;
    L12:
        this.f9195b = LinkedListMultimap.access$200(r5);
    L13:
        int r14 = r10 - 1;
        if (r10 <= 0) goto L20;
        a();
        u5 r15 = this.f9195b;
        if (r15 == null) goto L19;
        this.f9196c = r15;
        this.d = r15;
        this.f9195b = r15.f9184c;
        this.f9194a++;
        r10 = r14;
        goto L13
    L19:
        throw new NoSuchElementException();
    }

    public final void a() {
        if (LinkedListMultimap.access$000(this.f) != this.e) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.ListIterator
    public final void add(Object r5) {
        Map.Entry r10 = (Map.Entry) r5;
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        a();
        if (this.f9195b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        if (this.d == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        a();
        u5 r5 = this.f9195b;
        if (r5 == null) goto L7;
        this.f9196c = r5;
        this.d = r5;
        this.f9195b = r5.f9184c;
        this.f9194a++;
        return r5;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9194a;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        u5 r5 = this.d;
        if (r5 == null) goto L7;
        this.f9196c = r5;
        this.f9195b = r5;
        this.d = r5.d;
        this.f9194a--;
        return r5;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9194a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        a();
        if (this.f9196c == null) goto L5;
        boolean r5 = true;
    L6:
        com.google.common.base.b0.u(r5, "no calls to next() since the last call to remove()");
        u5 r10 = this.f9196c;
        if (r10 == this.f9195b) goto L9;
        this.d = r10.d;
        this.f9194a--;
    L10:
        LinkedListMultimap r11 = this.f;
        LinkedListMultimap.access$300(r11, r10);
        this.f9196c = null;
        this.e = LinkedListMultimap.access$000(r11);
        return;
    L9:
        this.f9195b = r10.f9184c;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    @Override // java.util.ListIterator
    public final void set(Object r5) {
        Map.Entry r10 = (Map.Entry) r5;
        throw new UnsupportedOperationException();
    }
}

package com.google.common.collect;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class w5 implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u5 f9208c;
    public u5 d;
    public u5 e;
    public final /* synthetic */ LinkedListMultimap f;

    public w5(LinkedListMultimap r5, Object r10) {
        this.f = r5;
        this.f9206a = r10;
        t5 r11 = (t5) LinkedListMultimap.access$500(r5).get(r10);
        if (r11 != null) goto L5;
        u5 r12 = null;
    L6:
        this.f9208c = r12;
        return;
    L5:
        r12 = r11.f9166a;
        goto L6
    }

    @Override // java.util.ListIterator
    public final void add(Object r5) {
        this.e = LinkedListMultimap.access$600(this.f, this.f9206a, r5, this.f9208c);
        this.f9207b++;
        this.d = null;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        if (this.f9208c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.e == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        u5 r5 = this.f9208c;
        if (r5 == null) goto L7;
        this.d = r5;
        this.e = r5;
        this.f9208c = r5.e;
        this.f9207b++;
        return r5.f9183b;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9207b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        u5 r5 = this.e;
        if (r5 == null) goto L7;
        this.d = r5;
        this.f9208c = r5;
        this.e = r5.f;
        this.f9207b--;
        return r5.f9183b;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9207b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        if (this.d == null) goto L5;
        boolean r5 = true;
    L6:
        com.google.common.base.b0.u(r5, "no calls to next() since the last call to remove()");
        u5 r10 = this.d;
        if (r10 == this.f9208c) goto L9;
        this.e = r10.f;
        this.f9207b--;
    L10:
        LinkedListMultimap.access$300(this.f, r10);
        this.d = null;
        return;
    L9:
        this.f9208c = r10.e;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    @Override // java.util.ListIterator
    public final void set(Object r5) {
        if (this.d == null) goto L5;
        boolean r10 = true;
    L6:
        com.google.common.base.b0.t(r10);
        this.d.f9183b = r5;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public w5(LinkedListMultimap r5, Object r10, int r11) {
        this.f = r5;
        t5 r12 = (t5) LinkedListMultimap.access$500(r5).get(r10);
        if (r12 != null) goto L5;
        int r13 = 0;
    L6:
        com.google.common.base.b0.o(r11, r13);
        if (r11 < (r13 / 2)) goto L15;
        if (r12 != null) goto L10;
        u5 r14 = null;
    L11:
        this.e = r14;
        this.f9207b = r13;
    L12:
        int r15 = r11 + 1;
        if (r11 >= r13) goto L22;
        previous();
        r11 = r15;
    L22:
        this.f9206a = r10;
        this.d = null;
        return;
    L10:
        r14 = r12.f9167b;
        goto L11
    L15:
        if (r12 != null) goto L17;
        u5 r16 = null;
    L18:
        this.f9208c = r16;
    L19:
        int r17 = r11 - 1;
        if (r11 <= 0) goto L22;
        next();
        r11 = r17;
        goto L19
    L17:
        r16 = r12.f9166a;
        goto L18
    L5:
        r13 = r12.f9168c;
        goto L6
    }
}

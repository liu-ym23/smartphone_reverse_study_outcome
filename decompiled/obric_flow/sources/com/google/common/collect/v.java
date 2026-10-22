package com.google.common.collect;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends m implements ListIterator {
    public final /* synthetic */ w e;

    public v(w r5) {
        this.e = r5;
        super(r5);
    }

    @Override // java.util.ListIterator
    public final void add(Object r5) {
        w r10 = this.e;
        boolean r11 = r10.isEmpty();
        b().add(r5);
        AbstractMapBasedMultimap.access$208(r10.f);
        if (r11 == false) goto L6;
        r10.b();
        return;
    }

    public final ListIterator b() {
        a();
        return (ListIterator) this.f9064b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return b().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object r5) {
        b().set(r5);
    }

    public v(w r5, int r10) {
        this.e = r5;
        super(r5, ((List) r5.f9173b).listIterator(r10));
    }
}

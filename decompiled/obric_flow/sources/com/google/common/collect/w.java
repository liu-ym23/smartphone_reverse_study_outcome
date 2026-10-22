package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class w extends u implements List {
    public final /* synthetic */ AbstractMapBasedMultimap f;

    public w(AbstractMapBasedMultimap r5, Object r10, List r11, u r12) {
        this.f = r5;
        super(r5, r10, r11, r12);
    }

    @Override // java.util.List
    public final void add(int r5, Object r10) {
        c();
        boolean r11 = this.f9173b.isEmpty();
        ((List) this.f9173b).add(r5, r10);
        AbstractMapBasedMultimap.access$208(this.f);
        if (r11 == false) goto L6;
        b();
        return;
    }

    @Override // java.util.List
    public final boolean addAll(int r5, Collection r10) {
        if (r10.isEmpty() == false) goto L6;
        return false;
    L6:
        int r11 = size();
        boolean r12 = ((List) this.f9173b).addAll(r5, r10);
        if (r12 == false) goto L11;
        int r13 = this.f9173b.size();
        AbstractMapBasedMultimap.access$212(this.f, r13 - r11);
        if (r11 != 0) goto L11;
        b();
    L11:
        return r12;
    }

    @Override // java.util.List
    public final Object get(int r5) {
        c();
        return ((List) this.f9173b).get(r5);
    }

    @Override // java.util.List
    public final int indexOf(Object r5) {
        c();
        return ((List) this.f9173b).indexOf(r5);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r5) {
        c();
        return ((List) this.f9173b).lastIndexOf(r5);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        c();
        return new v(this);
    }

    @Override // java.util.List
    public final Object remove(int r5) {
        c();
        Object r10 = ((List) this.f9173b).remove(r5);
        AbstractMapBasedMultimap.access$210(this.f);
        d();
        return r10;
    }

    @Override // java.util.List
    public final Object set(int r5, Object r10) {
        c();
        return ((List) this.f9173b).set(r5, r10);
    }

    @Override // java.util.List
    public final List subList(int r5, int r10) {
        c();
        List r11 = ((List) this.f9173b).subList(r5, r10);
        u r12 = this.f9174c;
        if (r12 != null) goto L6;
        r12 = this;
    L6:
        return this.f.wrapList(this.f9172a, r11, r12);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int r5) {
        c();
        return new v(this, r5);
    }
}

package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public class z extends u implements SortedSet {
    public final /* synthetic */ AbstractMapBasedMultimap f;

    public z(AbstractMapBasedMultimap r5, Object r10, SortedSet r11, u r12) {
        this.f = r5;
        super(r5, r10, r11, r12);
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return e().comparator();
    }

    public SortedSet e() {
        return (SortedSet) this.f9173b;
    }

    @Override // java.util.SortedSet
    public final Object first() {
        c();
        return e().first();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object r5) {
        c();
        SortedSet r10 = e().headSet(r5);
        u r11 = this.f9174c;
        if (r11 != null) goto L6;
        r11 = this;
    L6:
        return new z(this.f, this.f9172a, r10, r11);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        c();
        return e().last();
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object r5, Object r10) {
        c();
        SortedSet r11 = e().subSet(r5, r10);
        u r12 = this.f9174c;
        if (r12 != null) goto L6;
        r12 = this;
    L6:
        return new z(this.f, this.f9172a, r11, r12);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object r5) {
        c();
        SortedSet r10 = e().tailSet(r5);
        u r11 = this.f9174c;
        if (r11 != null) goto L6;
        r11 = this;
    L6:
        return new z(this.f, this.f9172a, r10, r11);
    }
}

package com.google.common.collect;

import java.util.AbstractList;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class z5 extends s9 implements ListIterator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9246c;

    public /* synthetic */ z5(AbstractList r5, ListIterator r10, int r11) {
        this.f9245b = r11;
        this.f9246c = r5;
        super(r10);
    }

    @Override // com.google.common.collect.s9
    public final Object a(Object r5) {
        switch(this.f9245b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return ((Map.Entry) r5).getValue();
    L7:
        return ((Lists$TransformingSequentialList) this.f9246c).function.apply(r5);
    L9:
        return ((Lists$TransformingRandomAccessList) this.f9246c).function.apply(r5);
    }

    @Override // java.util.ListIterator
    public final void add(Object r5) {
        throw new UnsupportedOperationException();
    }

    public final void b(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.f9159a).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.f9159a).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return a(((ListIterator) this.f9159a).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.f9159a).previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(Object r5) {
        switch(this.f9245b) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        b(r5);
        return;
    L6:
        v5 r10 = (v5) this.f9246c;
        if (r10.f9196c == null) goto L9;
        boolean r11 = true;
    L10:
        com.google.common.base.b0.t(r11);
        r10.f9196c.f9183b = r5;
        return;
    L9:
        r11 = false;
        goto L10
    }

    public z5(v5 r5, v5 r10) {
        this.f9245b = 2;
        this.f9246c = r10;
        super(r5);
    }
}

package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class p2 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EnumMultiset f9118c;
    public final /* synthetic */ int d;
    public final /* synthetic */ EnumMultiset e;

    public p2(EnumMultiset r5, int r10) {
        this.d = r10;
        this.e = r5;
        this.f9118c = r5;
        this.f9116a = 0;
        this.f9117b = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
    L2:
        int r5 = this.f9116a;
        EnumMultiset r10 = this.f9118c;
        if (r5 >= EnumMultiset.access$000(r10).length) goto L9;
        int[] r11 = EnumMultiset.access$100(r10);
        int r12 = this.f9116a;
        if (r11[r12] > 0) goto L6;
        this.f9116a = r12 + 1;
        goto L2
    L6:
        return true;
    L9:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L11;
        int r5 = this.f9116a;
        switch(this.d) {
            case 0: goto L7;
            default: goto L6;
        };
    L6:
        Object r10 = new q2(this, r5);
    L8:
        int r11 = this.f9116a;
        this.f9117b = r11;
        this.f9116a = r11 + 1;
        return r10;
    L7:
        r10 = EnumMultiset.access$000(this.e)[r5];
        goto L8
    L11:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f9117b < 0) goto L5;
        boolean r5 = true;
    L6:
        p7.t(r5);
        EnumMultiset r10 = this.f9118c;
        if (EnumMultiset.access$100(r10)[this.f9117b] <= 0) goto L9;
        EnumMultiset.access$210(r10);
        EnumMultiset.access$322(r10, EnumMultiset.access$100(r10)[this.f9117b]);
        EnumMultiset.access$100(r10)[this.f9117b] = 0;
    L9:
        this.f9117b = -1;
        return;
    L5:
        r5 = false;
        goto L6
    }
}

package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class w9 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y9 f9214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y7 f9215c;
    public final /* synthetic */ TreeMultiset d;

    public w9(TreeMultiset r5, int r10) {
        this.f9213a = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.d = r5;
        this.f9214b = TreeMultiset.access$1300(r5);
        return;
    L6:
        this.d = r5;
        this.f9214b = TreeMultiset.access$1700(r5);
        this.f9215c = null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch(this.f9213a) {
            case 0: goto L13;
            default: goto L5;
        };
    L5:
        if (this.f9214b != null) goto L8;
        return false;
    L8:
        if (TreeMultiset.access$1400(this.d).tooLow(this.f9214b.f9233a) == false) goto L10;
        this.f9214b = null;
        return false;
    L10:
        return true;
    L13:
        if (this.f9214b != null) goto L16;
        return false;
    L16:
        if (TreeMultiset.access$1400(this.d).tooHigh(this.f9214b.f9233a) == false) goto L18;
        this.f9214b = null;
        return false;
    L18:
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch(this.f9213a) {
            case 0: goto L14;
            default: goto L5;
        };
    L5:
        if (hasNext() == false) goto L12;
        Objects.requireNonNull(this.f9214b);
        y9 r5 = this.f9214b;
        TreeMultiset r10 = this.d;
        y7 r11 = TreeMultiset.access$1500(r10, r5);
        this.f9215c = r11;
        y9 r12 = this.f9214b.f9236h;
        Objects.requireNonNull(r12);
        if (r12 != TreeMultiset.access$1600(r10)) goto L9;
        this.f9214b = null;
    L10:
        return r11;
    L9:
        y9 r13 = this.f9214b.f9236h;
        Objects.requireNonNull(r13);
        this.f9214b = r13;
        goto L10
    L12:
        throw new NoSuchElementException();
    L14:
        if (hasNext() == false) goto L21;
        y9 r14 = this.f9214b;
        Objects.requireNonNull(r14);
        TreeMultiset r15 = this.d;
        y7 r16 = TreeMultiset.access$1500(r15, r14);
        this.f9215c = r16;
        y9 r17 = this.f9214b.f9237i;
        Objects.requireNonNull(r17);
        if (r17 != TreeMultiset.access$1600(r15)) goto L18;
        this.f9214b = null;
    L19:
        return r16;
    L18:
        y9 r18 = this.f9214b.f9237i;
        Objects.requireNonNull(r18);
        this.f9214b = r18;
        goto L19
    L21:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch(this.f9213a) {
            case 0: goto L11;
            default: goto L5;
        };
    L5:
        if (this.f9215c == null) goto L7;
        boolean r5 = true;
    L8:
        com.google.common.base.b0.u(r5, "no calls to next() since the last call to remove()");
        this.d.setCount(this.f9215c.getElement(), 0);
        this.f9215c = null;
        return;
    L7:
        r5 = false;
        goto L8
    L11:
        if (this.f9215c == null) goto L13;
        boolean r10 = true;
    L14:
        com.google.common.base.b0.u(r10, "no calls to next() since the last call to remove()");
        this.d.setCount(this.f9215c.getElement(), 0);
        this.f9215c = null;
        return;
    L13:
        r10 = false;
        goto L14
    }
}

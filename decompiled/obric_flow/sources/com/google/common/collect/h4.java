package com.google.common.collect;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class h4 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ga f9011c;

    public h4(ga r5) {
        this.f9011c = r5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9009a <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.f9011c.hasNext() == true) goto L8;
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f9009a > 0) goto L5;
        y7 r5 = (y7) this.f9011c.next();
        this.f9010b = r5.getElement();
        this.f9009a = r5.getCount();
    L5:
        this.f9009a--;
        Object r10 = this.f9010b;
        Objects.requireNonNull(r10);
        return r10;
    }
}

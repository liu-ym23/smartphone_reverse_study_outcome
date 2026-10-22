package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class j5 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f9037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9039c;

    public j5(Iterator r5) {
        r5.getClass();
        this.f9037a = r5;
    }

    public final Object a() {
        if (this.f9038b == true) goto L6;
        this.f9039c = this.f9037a.next();
        this.f9038b = true;
    L6:
        return this.f9039c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9038b == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f9037a.hasNext() == true) goto L8;
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f9038b == false) goto L5;
        Object r5 = this.f9039c;
        this.f9038b = false;
        this.f9039c = null;
        return r5;
    L5:
        return this.f9037a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        com.google.common.base.b0.u(!this.f9038b, "Can't remove after you've peeked at next");
        this.f9037a.remove();
    }
}

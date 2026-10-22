package com.airbnb.lottie.parser.moshi;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f1316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f1317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1318c;
    public final /* synthetic */ LinkedHashTreeMap d;
    public final /* synthetic */ int e;

    public d(LinkedHashTreeMap r5, int r10) {
        this.e = r10;
        this.d = r5;
        this.f1316a = r5.header.d;
        this.f1317b = null;
        this.f1318c = r5.modCount;
    }

    public final Object a() {
        return b();
    }

    public final g b() {
        g r5 = this.f1316a;
        LinkedHashTreeMap r10 = this.d;
        if (r5 == r10.header) goto L11;
        if (r10.modCount != this.f1318c) goto L9;
        this.f1316a = r5.d;
        this.f1317b = r5;
        return r5;
    L9:
        throw new ConcurrentModificationException();
    L11:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1316a == this.d.header) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch(this.e) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return a();
    L7:
        return b().f;
    }

    @Override // java.util.Iterator
    public final void remove() {
        g r5 = this.f1317b;
        if (r5 == null) goto L7;
        LinkedHashTreeMap r10 = this.d;
        r10.removeInternal(r5, true);
        this.f1317b = null;
        this.f1318c = r10.modCount;
        return;
    L7:
        throw new IllegalStateException();
    }
}

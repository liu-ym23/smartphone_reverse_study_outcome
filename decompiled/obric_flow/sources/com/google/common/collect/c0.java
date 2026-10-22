package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f8915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map.Entry f8916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8917c;
    public boolean d;
    public final /* synthetic */ AbstractMapBasedMultiset e;

    public c0(AbstractMapBasedMultiset r5) {
        this.e = r5;
        this.f8915a = AbstractMapBasedMultiset.access$100(r5).entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8917c <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.f8915a.hasNext() == true) goto L8;
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8917c != 0) goto L5;
        Map.Entry r5 = (Map.Entry) this.f8915a.next();
        this.f8916b = r5;
        this.f8917c = ((Count) r5.getValue()).get();
    L5:
        this.f8917c--;
        this.d = true;
        Map.Entry r10 = this.f8916b;
        Objects.requireNonNull(r10);
        return r10.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        p7.t(this.d);
        Map.Entry r5 = this.f8916b;
        Objects.requireNonNull(r5);
        if (((Count) r5.getValue()).get() <= 0) goto L10;
        if (((Count) this.f8916b.getValue()).addAndGet(-1) != 0) goto L7;
        this.f8915a.remove();
    L7:
        AbstractMapBasedMultiset.access$010(this.e);
        this.d = false;
        return;
    L10:
        throw new ConcurrentModificationException();
    }
}

package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map.Entry f8878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f8879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractBiMap f8880c;

    public a(AbstractBiMap r5, Iterator r10) {
        this.f8880c = r5;
        this.f8879b = r10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8879b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry r5 = (Map.Entry) this.f8879b.next();
        this.f8878a = r5;
        return new b(this.f8880c, r5, 0);
    }

    @Override // java.util.Iterator
    public final void remove() {
        Map.Entry r5 = this.f8878a;
        if (r5 == null) goto L7;
        Object r10 = r5.getValue();
        this.f8879b.remove();
        AbstractBiMap.access$600(this.f8880c, r10);
        this.f8878a = null;
        return;
    L7:
        throw new IllegalStateException("no calls to next() since the last call to remove()");
    }
}

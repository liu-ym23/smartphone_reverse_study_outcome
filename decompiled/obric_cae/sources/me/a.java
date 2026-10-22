package me;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<b<T>> f9351a;

    public a(d r8) {
        this.f9351a = new AtomicReference(r8);
    }

    @Override // me.b
    public final Iterator<T> iterator() {
        b<T> r8 = this.f9351a.getAndSet(null);
        if (r8 == null) goto L7;
        return r8.iterator();
    L7:
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}

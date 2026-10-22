package org.ehcache.shadow.org.terracotta.a.b;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
class g<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<T> f18109a;

    public g(T r2) {
        this.f18109a = new WeakReference(r2);
    }

    @Override // org.ehcache.shadow.org.terracotta.a.b.a
    public T a() {
        return this.f18109a.get();
    }
}

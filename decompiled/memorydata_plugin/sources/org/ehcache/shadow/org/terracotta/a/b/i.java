package org.ehcache.shadow.org.terracotta.a.b;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes7.dex */
class i<T> extends e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Object> f18111a;

    i(Object r1, Method r2) {
        super(r2);
        this.f18111a = new WeakReference(r1);
    }

    @Override // org.ehcache.shadow.org.terracotta.a.b.e
    Object b() {
        return this.f18111a.get();
    }
}

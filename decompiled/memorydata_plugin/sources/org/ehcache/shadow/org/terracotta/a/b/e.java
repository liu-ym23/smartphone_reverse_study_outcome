package org.ehcache.shadow.org.terracotta.a.b;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes7.dex */
abstract class e<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f18108a;

    e(Method r2) {
        r2.setAccessible(true);
        this.f18108a = r2;
    }

    @Override // org.ehcache.shadow.org.terracotta.a.b.a
    public T a() {
        return (T) this.f18108a.invoke(b(), new Object[0]);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    abstract Object b();
}

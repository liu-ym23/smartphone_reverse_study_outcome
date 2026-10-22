package org.ehcache.shadow.org.terracotta.a.b;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes7.dex */
abstract class c<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f18105a;

    c(Field r2) {
        r2.setAccessible(true);
        this.f18105a = r2;
    }

    @Override // org.ehcache.shadow.org.terracotta.a.b.a
    public T a() {
        return (T) this.f18105a.get(b());
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    abstract Object b();
}

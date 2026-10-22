package org.ehcache.shadow.org.terracotta.a.b;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes7.dex */
public class h<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Object> f18110a;

    public h(Object r1, Field r2) {
        super(r2);
        this.f18110a = new WeakReference(r1);
    }

    @Override // org.ehcache.shadow.org.terracotta.a.b.c, org.ehcache.shadow.org.terracotta.a.b.a
    public /* bridge */ /* synthetic */ Object a() {
        return super.a();
    }

    @Override // org.ehcache.shadow.org.terracotta.a.b.c
    Object b() {
        return this.f18110a.get();
    }
}

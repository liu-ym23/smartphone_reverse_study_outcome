package org.ehcache.shadow.org.terracotta.a;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes7.dex */
class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<d> f18117a;

    g() {
        this.f18117a = new CopyOnWriteArrayList();
    }

    @Override // org.ehcache.shadow.org.terracotta.a.a
    Set<a> b() {
        return Collections.emptySet();
    }

    @Override // org.ehcache.shadow.org.terracotta.a.a
    Collection<d> c() {
        return Collections.unmodifiableCollection(this.f18117a);
    }

    @Override // org.ehcache.shadow.org.terracotta.a.a
    void c(a r1) {
        throw new IllegalStateException();
    }

    @Override // org.ehcache.shadow.org.terracotta.a.a
    void d(a r1) {
        throw new IllegalStateException();
    }

    @Override // org.ehcache.shadow.org.terracotta.a.h
    public c getContext() {
        throw new IllegalStateException();
    }
}

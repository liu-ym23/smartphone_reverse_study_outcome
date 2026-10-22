package org.ehcache.shadow.org.terracotta.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes7.dex */
abstract class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<a> f18103a;

    a() {
        this.f18103a = new CopyOnWriteArraySet();
    }

    public Set<? extends a> a() {
        return Collections.unmodifiableSet(this.f18103a);
    }

    public boolean a(a r6) {
        monitor-enter(this);
        HashSet r0 = new HashSet(b());     // Catch: Throwable -> L18
        r0.removeAll(r6.b());     // Catch: Throwable -> L18
        if (this.f18103a.add(r6) == false) goto L16;
        r6.c(this);     // Catch: Throwable -> L18
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L18
    L7:
        if (r1.hasNext() == false) goto L13;
        Iterator<d> r2 = ((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin")).c().iterator();     // Catch: Throwable -> L18
    L10:
        if (r2.hasNext() == false) goto L7;
        ((d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin")).a(this, r6);     // Catch: Throwable -> L18
        goto L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L18
        return true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    abstract Set<a> b();

    public boolean b(a r6) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f18103a.remove(r6) == false) goto L16;
        r6.d(this);     // Catch: Throwable -> L18
        HashSet r0 = new HashSet(b());     // Catch: Throwable -> L18
        r0.removeAll(r6.b());     // Catch: Throwable -> L18
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L18
    L7:
        if (r1.hasNext() == false) goto L13;
        Iterator<d> r2 = ((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin")).c().iterator();     // Catch: Throwable -> L18
    L10:
        if (r2.hasNext() == false) goto L7;
        ((d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin")).b(this, r6);     // Catch: Throwable -> L18
        goto L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L18
        return true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return false;
    }

    abstract Collection<d> c();

    abstract void c(a r1);

    @Override // org.ehcache.shadow.org.terracotta.a.i.a
    public void d() {
        Iterator<? extends a> r1 = a().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        b((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterator<a> r2 = b().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin")).b(this);
        goto L8
    }

    abstract void d(a r1);
}

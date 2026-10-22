package org.ehcache.shadow.org.terracotta.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes7.dex */
class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<a> f18115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f18116b;

    public f(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f18115a = new CopyOnWriteArraySet();
        this.f18116b = r4;
    }

    @Override // org.ehcache.shadow.org.terracotta.a.a
    Set<a> b() {
        Set r0 = Collections.newSetFromMap(new IdentityHashMap());
        r0.addAll(this.f18115a);
        Iterator<a> r4 = this.f18115a.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.addAll(((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin")).b());
        goto L4
    L7:
        return Collections.unmodifiableSet(r0);
    }

    @Override // org.ehcache.shadow.org.terracotta.a.a
    public Collection<d> c() {
        return Collections.emptyList();
    }

    @Override // org.ehcache.shadow.org.terracotta.a.a
    void c(a r1) {
        this.f18115a.add(r1);
    }

    @Override // org.ehcache.shadow.org.terracotta.a.a
    void d(a r1) {
        this.f18115a.remove(r1);
    }

    @Override // org.ehcache.shadow.org.terracotta.a.h
    public c getContext() {
        return this.f18116b;
    }

    public String toString() {
        return "{" + this.f18116b + "}";
    }
}

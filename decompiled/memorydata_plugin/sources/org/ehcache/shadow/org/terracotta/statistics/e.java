package org.ehcache.shadow.org.terracotta.statistics;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes7.dex */
@org.ehcache.shadow.org.terracotta.a.a.a(a = "this")
class e<T extends Serializable> implements l<T> {
    private static final org.ehcache.shadow.org.terracotta.a.i<Object, Collection<e<? extends Serializable>>> e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @org.ehcache.shadow.org.terracotta.a.a.a(a = ActivityLifecycle.NAME)
    public final String f18151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @org.ehcache.shadow.org.terracotta.a.a.a(a = "tags")
    public final Set<String> f18152b;

    @org.ehcache.shadow.org.terracotta.a.a.a(a = "properties")
    public final Map<String, Object> c;

    @org.ehcache.shadow.org.terracotta.a.a.a(a = "type")
    public final StatisticType d;
    private final l<T> f;

    static {
        e = new org.ehcache.shadow.org.terracotta.a.i();
    }

    public e(Object r3, String r4, Set<String> r5, Map<String, ? extends Object> r6, l<T> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        l<T> r10 = (l) ZeusTransformUtils.wrapperContextForParams(r7, l.class, "com.obric.memorydata.plugin");
        this.f18151a = r4;
        this.f18152b = Collections.unmodifiableSet(new HashSet(r8));
        this.c = Collections.unmodifiableMap(new HashMap(r9));
        this.f = r10;
        this.d = r10.type();
        a(this, r3);
    }

    private static void a(e<? extends Serializable> r4, Object r5) {
        org.ehcache.shadow.org.terracotta.a.i<Object, Collection<e<? extends Serializable>>> r0 = e;
        Collection<e<? extends Serializable>> r1 = (Collection) ZeusTransformUtils.preCheckCast(r0.a(r5), Collection.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        r1 = new CopyOnWriteArrayList();
        Collection<e<? extends Serializable>> r6 = (Collection) ZeusTransformUtils.preCheckCast(r0.a(r5, r1), Collection.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L7;
        r1 = r6;
    L7:
        r1.add(r4);
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public StatisticType type() {
        return this.d;
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public T value() {
        return (T) this.f.value();
    }
}

package org.ehcache.shadow.org.terracotta.statistics;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Enum;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
@org.ehcache.shadow.org.terracotta.a.a.a(a = "this")
public abstract class a<T extends Enum<T>> extends b<org.ehcache.shadow.org.terracotta.statistics.a.a<? super T>> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @org.ehcache.shadow.org.terracotta.a.a.a(a = ActivityLifecycle.NAME)
    public final String f18147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @org.ehcache.shadow.org.terracotta.a.a.a(a = "tags")
    public final Set<String> f18148b;

    @org.ehcache.shadow.org.terracotta.a.a.a(a = "properties")
    public final Map<String, Object> c;

    @org.ehcache.shadow.org.terracotta.a.a.a(a = "type")
    public final Class<T> d;
    private final ThreadLocal<Long> f;

    a(String r3, Set<String> r4, Map<String, ? extends Object> r5, Class<T> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.f = new ThreadLocal();
        this.f18147a = r3;
        this.f18148b = Collections.unmodifiableSet(new HashSet(r7));
        this.c = Collections.unmodifiableMap(new HashMap(r8));
        this.d = r6;
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.a.b
    public void a() {
        if (this.e.isEmpty() == true) goto L8;
        long r0 = k.a();
        this.f.set(Long.valueOf(r0));
        Iterator<T> r5 = this.e.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ((org.ehcache.shadow.org.terracotta.statistics.a.a) ZeusTransformUtils.preCheckCast(r5.next(), org.ehcache.shadow.org.terracotta.statistics.a.a.class, "com.obric.memorydata.plugin")).a(r0);
        goto L6
    L10:
        return;
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.a.b
    public void a(T r13) {
        if (this.e.isEmpty() == true) goto L8;
        long r7 = k.a();
        long r10 = r7 - ((Long) ZeusTransformUtils.preCheckCast(this.f.get(), Long.class, "com.obric.memorydata.plugin")).longValue();
        Iterator<T> r12 = this.e.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        ((org.ehcache.shadow.org.terracotta.statistics.a.a) ZeusTransformUtils.preCheckCast(r12.next(), org.ehcache.shadow.org.terracotta.statistics.a.a.class, "com.obric.memorydata.plugin")).a(r7, r10, r13);
        goto L6
    L10:
        return;
    }
}

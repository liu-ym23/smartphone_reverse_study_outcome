package org.ehcache.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.ehcache.config.c;
import org.ehcache.config.d;
import org.ehcache.spi.service.e;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, org.ehcache.config.b<?, ?>> f18007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<e<?, ?>> f18008b;
    private final ClassLoader c;

    public b(Map<String, org.ehcache.config.b<?, ?>> r3, ClassLoader r4, e<?, ?>... r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.f18008b = Collections.unmodifiableCollection(Arrays.asList(r5));
        this.f18007a = new ConcurrentHashMap(r6);
        if (r4 != null) goto L5;
        r4 = org.ehcache.core.f.a.a();
    L5:
        this.c = r4;
    }

    public b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4.c());
        this.f18007a = new ConcurrentHashMap(r4.a());
        this.f18008b = Collections.unmodifiableCollection(r4.b());
        this.c = r4.c();
    }

    @Override // org.ehcache.config.d
    public Map<String, org.ehcache.config.b<?, ?>> a() {
        return Collections.unmodifiableMap(this.f18007a);
    }

    public void a(String r1) {
        this.f18007a.remove(r1);
    }

    public void a(String r3, org.ehcache.config.b<?, ?> r4) {
        if (this.f18007a.put(r3, (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r4, org.ehcache.config.b.class, "com.obric.memorydata.plugin")) != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cache '" + r3 + "' already present!");
    }

    public <K, V> void a(String r3, org.ehcache.config.b<K, V> r4, c<K, V> r5) {
        org.ehcache.config.b<?, ?> r6 = (org.ehcache.config.b) ZeusTransformUtils.wrapperContextForParams(r4, org.ehcache.config.b.class, "com.obric.memorydata.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        if (this.f18007a.replace(r3, r6, r7) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("The expected configuration doesn't match!");
    }

    @Override // org.ehcache.config.d
    public Collection<e<?, ?>> b() {
        return this.f18008b;
    }

    @Override // org.ehcache.config.d
    public ClassLoader c() {
        return this.c;
    }
}

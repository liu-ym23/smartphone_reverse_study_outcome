package org.ehcache.config.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.ehcache.config.ResourceType;
import org.ehcache.config.h;
import org.ehcache.config.i;
import org.ehcache.config.j;
import org.ehcache.config.k;
import org.ehcache.config.units.MemoryUnit;

/* JADX INFO: loaded from: classes7.dex */
public class e implements org.ehcache.config.a<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<ResourceType<?>, h> f17999a;

    private e() {
        this(Collections.emptyMap());
    }

    private e(Map<ResourceType<?>, h> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        org.ehcache.impl.config.c.a(r4.values());
        this.f17999a = Collections.unmodifiableMap(r4);
    }

    public static e b() {
        return new e();
    }

    @Override // org.ehcache.config.a
    public /* synthetic */ i a() {
        return c();
    }

    public e a(long r7, j r9) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r9, j.class, "com.obric.memorydata.plugin");
        return a(ResourceType.Core.HEAP, r7, r4, false);
    }

    public e a(long r2, MemoryUnit r4) {
        return a(r2, r4, false);
    }

    public e a(long r7, MemoryUnit r9, boolean r10) {
        return a(ResourceType.Core.DISK, r7, r9, r10);
    }

    public e a(ResourceType<k> r9, long r10, j r12, boolean r13) {
        return a(new org.ehcache.impl.config.d((ResourceType) ZeusTransformUtils.wrapperContextForParams(r9, ResourceType.class, "com.obric.memorydata.plugin"), r10, (j) ZeusTransformUtils.wrapperContextForParams(r12, j.class, "com.obric.memorydata.plugin"), r13));
    }

    public e a(h r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        ResourceType<?> r0 = r6.getType();
        h r1 = (h) ZeusTransformUtils.preCheckCast(this.f17999a.get(r0), h.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        HashMap r2 = new HashMap(this.f17999a);
        r2.put(r0, r6);
        return new e(r2);
    L7:
        throw new IllegalArgumentException("Can not add '" + r6 + "'; configuration already contains '" + r1 + "'");
    }

    public i c() {
        return new org.ehcache.impl.config.c(this.f17999a);
    }
}

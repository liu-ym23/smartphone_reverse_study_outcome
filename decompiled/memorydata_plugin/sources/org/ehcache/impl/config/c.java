package org.ehcache.impl.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.ehcache.config.ResourceType;
import org.ehcache.config.h;
import org.ehcache.config.i;
import org.ehcache.config.k;

/* JADX INFO: loaded from: classes7.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<ResourceType<?>, h> f18069a;

    public c(Map<ResourceType<?>, h> r3) {
        Map<ResourceType<?>, h> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == true) goto L7;
        a(r4.values());
        this.f18069a = r4;
        return;
    L7:
        throw new IllegalArgumentException("No resource pools defined");
    }

    private static /* synthetic */ int a(k r2, k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        int r0 = r5.getType().getTierHeight() - r4.getType().getTierHeight();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return r4.toString().compareTo(r5.toString());
    }

    public static void a(Collection<? extends h> r15) {
        Collection r16 = (Collection) ZeusTransformUtils.wrapperContextForParams(r15, Collection.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(r16.size());
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L8;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r17.next(), h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L4;
        r0.add((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        r0.sort($$Lambda$c$JTD84MKYa7QVEXCVDsjuvIOXiFs.INSTANCE);
        int r3 = 0;
    L10:
        if (r3 >= r0.size()) goto L34;
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L33;
        k r5 = (k) ZeusTransformUtils.preCheckCast(r0.get(r4), k.class, "com.obric.memorydata.plugin");
        k r6 = (k) ZeusTransformUtils.preCheckCast(r0.get(r3), k.class, "com.obric.memorydata.plugin");
        boolean r8 = true;
        if (r5.getType().getTierHeight() != r6.getType().getTierHeight()) goto L17;
        boolean r7 = true;
    L19:
        if (r5.c().compareTo(r5.b(), r6.b(), r6.c()) >= 0) goto L26;
        if (r6.c().compareTo(r6.b(), r5.b(), r5.c()) <= 0) goto L26;
        r8 = false;
    L26:
        if (r7 == true) goto L32;
        if (r8 == true) goto L30;
        r4 = r4 + 1;
        goto L12
    L30:
        throw new IllegalArgumentException("Tiering Inversion: '" + r5 + "' is not smaller than '" + r6 + "'");
    L32:
        throw new IllegalArgumentException("Tiering Ambiguity: '" + r5 + "' has the same tier height as '" + r6 + "'");
    L17:
        r7 = false;
    L24:
        r7 = false;
        r8 = false;
        goto L26
    L33:
        r3 = r3 + 1;
        goto L10
    }

    public static /* synthetic */ int lambda$JTD84MKYa7QVEXCVDsjuvIOXiFs(k r0, k r1) {
        return a(r0, r1);
    }

    @Override // org.ehcache.config.i
    public Set<ResourceType<?>> a() {
        return this.f18069a.keySet();
    }

    @Override // org.ehcache.config.i
    public <P extends h> P a(ResourceType<P> r3) {
        ResourceType r4 = (ResourceType) ZeusTransformUtils.wrapperContextForParams(r3, ResourceType.class, "com.obric.memorydata.plugin");
        return (P) ZeusTransformUtils.preCheckCast(r4.getResourcePoolClass().cast(this.f18069a.get(r4)), h.class, "com.obric.memorydata.plugin");
    }
}

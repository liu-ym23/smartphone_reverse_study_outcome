package org.ehcache.shadow.org.terracotta.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
class d implements org.ehcache.shadow.org.terracotta.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f18106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<? extends String, a<Object>> f18107b;

    public d(Class<?> r3, Map<? extends String, a<Object>> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.f18106a = r3;
        this.f18107b = new HashMap(r5);
    }

    public Class<?> a() {
        return this.f18106a;
    }

    public Map<String, Object> b() {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<? extends String, a<Object>>> r5 = this.f18107b.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put(r1.getKey(), ((a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L7:
        return Collections.unmodifiableMap(r0);
    }

    public String toString() {
        return a() + " " + b();
    }
}

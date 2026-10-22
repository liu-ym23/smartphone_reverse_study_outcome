package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.logging.log4j.spi.c;

/* JADX INFO: loaded from: classes6.dex */
public class h<T extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f17904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<T> f17905b;
    private final Map<String, Map<String, T>> c;

    public static class a<T extends c> implements b<T> {
        public a() {
        }

        @Override // org.apache.logging.log4j.spi.h.b
        public Map<String, T> a() {
            return new ConcurrentHashMap();
        }

        @Override // org.apache.logging.log4j.spi.h.b
        public void a(Map<String, T> r2, String r3, T r4) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            ((ConcurrentMap) ZeusTransformUtils.preCheckCast(r1, ConcurrentMap.class, "com.obric.memorydata.plugin")).putIfAbsent(r3, r5);
        }

        @Override // org.apache.logging.log4j.spi.h.b
        public Map<String, Map<String, T>> b() {
            return new ConcurrentHashMap();
        }
    }

    public interface b<T extends c> {
        Map<String, T> a();

        void a(Map<String, T> r1, String r2, T r3);

        Map<String, Map<String, T>> b();
    }

    static {
        f17904a = AbstractLogger.DEFAULT_MESSAGE_FACTORY_CLASS.getName();
    }

    public h() {
        this(new a());
    }

    public h(b<T> r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        this.f17905b = (b) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r5, "factory"), b.class, "com.obric.memorydata.plugin");
        this.c = r5.b();
    }

    private static String a(org.apache.logging.log4j.message.d r2) {
        org.apache.logging.log4j.message.d r3 = (org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r2, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return f17904a;
    L6:
        return r3.getClass().getName();
    }

    private Map<String, T> a(String r4) {
        Map<String, T> r0 = (Map) ZeusTransformUtils.preCheckCast(this.c.get(r4), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        Map<String, T> r1 = this.f17905b.a();
        this.c.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    public T a(String r3, org.apache.logging.log4j.message.d r4) {
        return (T) ZeusTransformUtils.preCheckCast(a(a((org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r4, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin"))).get(r3), c.class, "com.obric.memorydata.plugin");
    }

    public void a(String r3, org.apache.logging.log4j.message.d r4, T r5) {
        org.apache.logging.log4j.message.d r6 = (org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r4, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        this.f17905b.a(a(a(r6)), r3, r7);
    }
}

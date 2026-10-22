package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.apache.logging.log4j.c f17909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f17910b;
    private static String c;

    static {
        f17909a = StatusLogger.getLogger();
        c();
    }

    public static void a() {
        b.a();
        d.a();
        DefaultThreadContextMap.init();
        c();
    }

    public static n b() {
        ClassLoader r0 = org.apache.logging.log4j.util.m.d();
        String r1 = c;
        n r3 = null;
        if (r1 != null) goto L32;
    L11:
        if (r3 == null) goto L13;
    L27:
        if (r3 == null) goto L29;
        return r3;
    L29:
        return d();
    L13:
        if (org.apache.logging.log4j.util.m.b() == false) goto L27;
        if (org.apache.logging.log4j.b.a() == null) goto L27;
        String r2 = org.apache.logging.log4j.b.a().getClass().getName();
        Iterator<l> r4 = org.apache.logging.log4j.util.m.a().iterator();
    L18:
        if (r4.hasNext() == false) goto L27;
        l r5 = (l) ZeusTransformUtils.preCheckCast(r4.next(), l.class, "com.obric.memorydata.plugin");
        if (r2.equals(r5.c()) == false) goto L18;
        Class<? extends n> r6 = r5.f();
        if (r6 == null) goto L18;
        r3 = (n) ZeusTransformUtils.preCheckCast(r6.newInstance(), n.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25
    L25:
        e = move-exception;
        f17909a.error("Unable to locate or load configured ThreadContextMap {}", r5.e(), e);
        r3 = d();
        goto L18
    L32:
        Class<?> r7 = r0.loadClass(r1);     // Catch: Exception -> L8 ClassNotFoundException -> L10
        if (n.class.isAssignableFrom(r7) == false) goto L11;
        r3 = (n) ZeusTransformUtils.preCheckCast(r7.newInstance(), n.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L8 ClassNotFoundException -> L10
        goto L11
    L10:
        f17909a.error("Unable to locate configured ThreadContextMap {}", c);
    L8:
        e = move-exception;
        f17909a.error("Unable to create configured ThreadContextMap {}", c, e);
        goto L11
    }

    private static void c() {
        PropertiesUtil r0 = PropertiesUtil.a();
        c = r0.b("log4j2.threadContextMap");
        f17910b = r0.a("log4j2.garbagefree.threadContextMap");
    }

    private static n d() {
        if (org.apache.logging.log4j.util.c.f17920b == false) goto L11;
        if (f17910b == false) goto L9;
        return new d();
    L9:
        return new b();
    L11:
        return new DefaultThreadContextMap(true);
    }
}

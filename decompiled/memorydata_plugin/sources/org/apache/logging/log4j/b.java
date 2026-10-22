package org.apache.logging.log4j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.spi.f;
import org.apache.logging.log4j.spi.g;
import org.apache.logging.log4j.spi.l;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.m;
import org.apache.logging.log4j.util.p;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f17886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17887b = null;
    private static volatile g c;

    static {
        f17886a = StatusLogger.getLogger();
        f17887b = b.class.getName();
        String r0 = PropertiesUtil.a().b("log4j2.loggerContextFactory");
        if (r0 == null) goto L10;
        c = (g) ZeusTransformUtils.preCheckCast(org.apache.logging.log4j.util.g.a(r0, g.class), g.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L6 ClassNotFoundException -> L8
    L8:
        f17886a.error("Unable to locate configured LoggerContextFactory {}", r0);
    L6:
        e = move-exception;
        f17886a.error("Unable to create configured LoggerContextFactory {}", r0, e);
    L10:
        if (c != null) goto L35;
        TreeMap r1 = new TreeMap();
        if (m.b() == false) goto L33;
        Iterator<l> r3 = m.a().iterator();
    L15:
        if (r3.hasNext() == false) goto L23;
        l r5 = (l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin");
        Class<? extends g> r6 = r5.d();
        if (r6 == null) goto L15;
        r1.put(r5.b(), r6.newInstance());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        f17886a.error("Unable to create class {} specified in provider URL {}", r6.getName(), r5.g(), e);
        goto L15
    L23:
        if (r1.isEmpty() == true) goto L33;
        if (r1.size() != 1) goto L28;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r1.get(r1.lastKey()), g.class, "com.obric.memorydata.plugin");
    L34:
        c = r2;
        goto L35
    L28:
        StringBuilder r4 = new StringBuilder("Multiple logging implementations found: \n");
        Iterator r7 = r1.entrySet().iterator();
    L30:
        if (r7.hasNext() == false) goto L32;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.append("Factory: ").append(((g) ZeusTransformUtils.preCheckCast(r8.getValue(), g.class, "com.obric.memorydata.plugin")).getClass().getName());
        r4.append(", Weighting: ").append(r8.getKey()).append('\n');
        goto L30
    L32:
        c = (g) ZeusTransformUtils.preCheckCast(r1.get(r1.lastKey()), g.class, "com.obric.memorydata.plugin");
        r4.append("Using factory: ").append(c.getClass().getName());
        f17886a.warn(r4.toString());
    L33:
        f17886a.error("Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...");
        r2 = org.apache.logging.log4j.simple.b.f17893a;
    L35:
        org.apache.logging.log4j.a.b.a(true);
    }

    public b() {
    }

    public static c a(Class<?> r2) {
        Class<?> r3 = b(r2);
        return getContext(r3.getClassLoader(), false).a(r3);
    }

    public static g a() {
        return c;
    }

    private static Class<?> b(Class<?> r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        Class<?> r2 = p.a(3);
        if (r2 == null) goto L8;
        return r2;
    L8:
        throw new UnsupportedOperationException("No class provided, and an appropriate one cannot be found.");
    }

    public static f getContext() {
        return c.getContext(f17887b, null, null, true);
    L5:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(f17887b, null, null, true);
    }

    public static f getContext(ClassLoader r4, boolean r5) {
        return c.getContext(f17887b, r4, null, r5);
    L5:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(f17887b, r4, null, r5);
    }

    public static f getContext(ClassLoader r3, boolean r4, Object r5) {
        return c.getContext(f17887b, r3, r5, r4);
    L4:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(f17887b, r3, r5, r4);
    }

    public static f getContext(ClassLoader r9, boolean r10, Object r11, URI r12) {
        return c.getContext(f17887b, r9, r11, r10, r12, null);
    L4:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(f17887b, r9, r11, r10, r12, null);
    }

    public static f getContext(ClassLoader r9, boolean r10, Object r11, URI r12, String r13) {
        return c.getContext(f17887b, r9, r11, r10, r12, r13);
    L4:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(f17887b, r9, r11, r10, r12, r13);
    }

    public static f getContext(ClassLoader r9, boolean r10, URI r11) {
        return c.getContext(f17887b, r9, null, r10, r11, null);
    L4:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(f17887b, r9, null, r10, r11, null);
    }

    public static f getContext(String r4, ClassLoader r5, boolean r6) {
        return c.getContext(r4, r5, null, r6);
    L5:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(r4, r5, null, r6);
    }

    public static f getContext(String r7, ClassLoader r8, boolean r9, URI r10, String r11) {
        return c.getContext(r7, r8, null, r9, r10, r11);
    L4:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(r7, r8, null, r9);
    }

    public static f getContext(String r4, boolean r5) {
        return c.getContext(r4, null, null, r5);
    L5:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(r4, null, null, r5);
    }

    public static f getContext(boolean r9) {
        return c.getContext(f17887b, null, null, r9, null, null);
    L4:
        e = move-exception;
        f17886a.warn(e.getMessage() + " Using SimpleLogger");
        return org.apache.logging.log4j.simple.b.f17893a.getContext(f17887b, null, null, r9, null, null);
    }
}

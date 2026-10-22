package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Collection<org.apache.logging.log4j.spi.l> f17931a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Lock f17932b = null;
    private static final String[] c = null;
    private static final org.apache.logging.log4j.c d = null;
    private static volatile m e;

    static {
        f17931a = new HashSet();
        f17932b = new ReentrantLock();
        c = new String[]{"2.6.0"};
        d = StatusLogger.getLogger();
    }

    private m() {
        Stream r3 = n.a(org.apache.logging.log4j.spi.l.class, MethodHandles.lookup(), false).filter($$Lambda$m$V9lWGIPVrjDeucUFFUSp82SQcZ4.INSTANCE);
        final Collection<org.apache.logging.log4j.spi.l> r0 = f17931a;
        r0.getClass();
        r3.forEach(new $$Lambda$BSPEEi0YTid0m94FWvbJ2qKFU(r0));
        Iterator<g.b> r4 = g.b("META-INF/log4j-provider.properties", false).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        g.b r1 = (g.b) ZeusTransformUtils.preCheckCast(r4.next(), g.b.class, "com.obric.memorydata.plugin");
        a(r1.b(), r1.a());
        goto L4
    }

    public static Iterable<org.apache.logging.log4j.spi.l> a() {
        c();
        return f17931a;
    }

    public static void a(URL r2, ClassLoader r3) {
        Properties r0 = PropertiesUtil.a(r2.openStream(), r2);     // Catch: IOException -> L6
        if (a(r0.getProperty("Log4jAPIVersion")) == false) goto L11;
        org.apache.logging.log4j.spi.l r1 = new org.apache.logging.log4j.spi.l(r0, r2, r3);     // Catch: IOException -> L6
        f17931a.add(r1);     // Catch: IOException -> L6
        d.debug("Loaded Provider {}", r1);     // Catch: IOException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        d.error("Unable to open {}", r2, e);
    }

    private static boolean a(String r5) {
        String[] r0 = c;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r5.startsWith(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static /* synthetic */ boolean a(org.apache.logging.log4j.spi.l r0) {
        return a(r0.a());
    }

    public static boolean b() {
        c();
        return !f17931a.isEmpty();
    }

    public static void c() {
        if (e != null) goto L18;
        Lock r0 = f17932b;     // Catch: InterruptedException -> L12
        r0.lockInterruptibly();     // Catch: InterruptedException -> L12
    L9:
        th = move-exception;
        f17932b.unlock();     // Catch: InterruptedException -> L12
        throw th;     // Catch: InterruptedException -> L12
    L6:
        if (e != null) goto L8;
        e = new m();     // Catch: Throwable -> L9
    L8:
        r0.unlock();     // Catch: InterruptedException -> L12
        return;
    L12:
        e = move-exception;
        d.fatal("Interrupted before Log4j Providers could be loaded.", e);
        Thread.currentThread().interrupt();
        return;
    }

    public static ClassLoader d() {
        return g.a();
    }

    public static /* synthetic */ boolean lambda$V9lWGIPVrjDeucUFFUSp82SQcZ4(org.apache.logging.log4j.spi.l r0) {
        return a(r0);
    }
}

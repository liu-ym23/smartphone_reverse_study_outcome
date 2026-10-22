package org.slf4j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.f;
import org.slf4j.helpers.h;
import org.slf4j.helpers.j;
import org.slf4j.helpers.l;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile int f20260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final j f20261b = null;
    static final f c = null;
    static boolean d;
    static volatile org.slf4j.a.b e;
    private static final String[] f = null;

    static {
        f20261b = new j();
        c = new f();
        d = l.b("slf4j.detectLoggerNameMismatch");
        f = new String[]{"2.0"};
    }

    private d() {
    }

    static List<org.slf4j.a.b> a() {
        ServiceLoader<org.slf4j.a.b> r0 = a(d.class.getClassLoader());
        ArrayList r1 = new ArrayList();
        Iterator<org.slf4j.a.b> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        a(r1, r2);
        goto L4
    L6:
        return r1;
    }

    private static ServiceLoader<org.slf4j.a.b> a(final ClassLoader r2) {
        if (System.getSecurityManager() != null) goto L6;
        return ServiceLoader.load(org.slf4j.a.b.class, r2);
    L6:
        return (ServiceLoader) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new $$Lambda$d$Sh_vbE7GXcPspttxm17xLWwQO4(r2)), ServiceLoader.class, "com.obric.memorydata.plugin");
    }

    public static c a(Class<?> r4) {
        c r0 = a(r4.getName());
        if (d == false) goto L9;
        Class<?> r1 = l.a();
        if (r1 == null) goto L9;
        if (a(r4, r1) == false) goto L9;
        l.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[]{r0.getName(), r1.getName()}));
        l.c("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
    L9:
        return r0;
    }

    public static c a(String r1) {
        return c().a(r1);
    }

    private static void a(int r2) {
        l.c("A number (" + r2 + ") of logging calls during the initialization phase have been intercepted and are");
        l.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        l.c("See also https://www.slf4j.org/codes.html#replay");
    }

    static void a(Throwable r1) {
        f20260a = 2;
        l.a("Failed to instantiate SLF4J LoggerFactory", r1);
    }

    private static void a(List<org.slf4j.a.b> r2, Iterator<org.slf4j.a.b> r3) {
        ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).add((org.slf4j.a.b) ZeusTransformUtils.preCheckCast(((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin")).next(), org.slf4j.a.b.class, "com.obric.memorydata.plugin"));     // Catch: ServiceConfigurationError -> L5
        return;
    L5:
        e = move-exception;
        l.c("A SLF4J service provider failed to instantiate:\n" + e.getMessage());
    }

    private static void a(Set<URL> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        l.c("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        l.c("Ignoring binding found at [" + ((URL) ZeusTransformUtils.preCheckCast(r6.next(), URL.class, "com.obric.memorydata.plugin")) + "]");
        goto L7
    L9:
        l.c("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    private static void a(org.slf4j.event.b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        h r0 = r3.b();
        String r1 = r0.getName();
        if (r0.c() == true) goto L17;
        if (r0.d() == false) goto L10;
        return;
    L10:
        if (r0.b() == true) goto L12;
        l.c(r1);
        return;
    L12:
        if (r0.a(r3.a()) == false) goto L18;
        r0.a(r3);
        return;
    L18:
        return;
    L17:
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
    }

    private static void a(org.slf4j.event.b r1, int r2) {
        if (r1.b().b() == false) goto L6;
        a(r2);
        return;
    L6:
        if (r1.b().d() == true) goto L11;
        j();
        return;
    }

    private static boolean a(Class<?> r0, Class<?> r1) {
        return !r1.isAssignableFrom(r0);
    }

    private static boolean a(List<org.slf4j.a.b> r2) {
        if (((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static /* synthetic */ ServiceLoader b(ClassLoader r1) {
        return ServiceLoader.load(org.slf4j.a.b.class, r1);
    }

    static Set<URL> b() {
        LinkedHashSet r0 = new LinkedHashSet();
        ClassLoader r1 = d.class.getClassLoader();     // Catch: IOException -> L12
        if (r1 != null) goto L7;
        Enumeration<URL> r2 = ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class");     // Catch: IOException -> L12
    L8:
        if (r2.hasMoreElements() == false) goto L14;
        r0.add((URL) ZeusTransformUtils.preCheckCast(r2.nextElement(), URL.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L12
    L14:
        return r0;
    L7:
        r2 = r1.getResources("org/slf4j/impl/StaticLoggerBinder.class");     // Catch: IOException -> L12
    L12:
        e = move-exception;
        l.a("Error getting resources from path", e);
        goto L14
    }

    private static void b(List<org.slf4j.a.b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (a(r5) == false) goto L11;
        l.c("Class path contains multiple SLF4J providers.");
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        l.c("Found provider [" + ((org.slf4j.a.b) ZeusTransformUtils.preCheckCast(r6.next(), org.slf4j.a.b.class, "com.obric.memorydata.plugin")) + "]");
        goto L6
    L8:
        l.c("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        return;
    }

    public static a c() {
        return d().a();
    }

    private static void c(List<org.slf4j.a.b> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        if (a(r3) == false) goto L9;
        l.c("Actual provider is of type [" + r3.get(0) + "]");
        return;
    }

    static org.slf4j.a.b d() {
        if (f20260a == 0) goto L5;
    L14:
        int r0 = f20260a;
        if (r0 == 1) goto L31;
        if (r0 == 2) goto L29;
        if (r0 == 3) goto L27;
        if (r0 != 4) goto L25;
        return c;
    L25:
        throw new IllegalStateException("Unreachable code");
    L27:
        return e;
    L29:
        throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
    L31:
        return f20261b;
    L5:
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f20260a != 0) goto L9;
        f20260a = 1;     // Catch: Throwable -> L11
        e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
        goto L14
    }

    private static final void e() {
        f();
        if (f20260a != 3) goto L6;
        k();
        return;
    }

    private static final void f() {
        List<org.slf4j.a.b> r0 = a();     // Catch: Exception -> L10
        b(r0);     // Catch: Exception -> L10
        if (r0 != null) goto L5;
    L7:
        f20260a = 4;     // Catch: Exception -> L10
        l.c("No SLF4J providers were found.");     // Catch: Exception -> L10
        l.c("Defaulting to no-operation (NOP) logger implementation");     // Catch: Exception -> L10
        l.c("See https://www.slf4j.org/codes.html#noProviders for further details.");     // Catch: Exception -> L10
        a(b());     // Catch: Exception -> L10
    L8:
        g();     // Catch: Exception -> L10
        return;
    L5:
        if (r0.isEmpty() == true) goto L7;
        e = (org.slf4j.a.b) ZeusTransformUtils.preCheckCast(r0.get(0), org.slf4j.a.b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        e.c();     // Catch: Exception -> L10
        f20260a = 3;     // Catch: Exception -> L10
        c(r0);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        a(e);
        throw new IllegalStateException("Unexpected initialization failure", e);
    }

    private static void g() {
        h();
        i();
        f20261b.d().d();
    }

    private static void h() {
        j r0 = f20261b;
        monitor-enter(r0);
        r0.d().c();     // Catch: Throwable -> L10
        Iterator<h> r1 = r0.d().a().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r1.next(), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        r2.a(a(r2.getName()));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static void i() {
        LinkedBlockingQueue<org.slf4j.event.b> r0 = f20261b.d().b();
        int r1 = r0.size();
        ArrayList r2 = new ArrayList(128);
        int r4 = 0;
    L4:
        if (r0.drainTo(r2, 128) == 0) goto L5;
        Iterator r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        org.slf4j.event.b r6 = (org.slf4j.event.b) ZeusTransformUtils.preCheckCast(r5.next(), org.slf4j.event.b.class, "com.obric.memorydata.plugin");
        a(r6);
        int r7 = r4 + 1;
        if (r4 != 0) goto L12;
        a(r6, r1);
    L12:
        r4 = r7;
        goto L8
    L13:
        r2.clear();
        goto L4
    }

    private static void j() {
        l.c("The following set of substitute loggers may have been accessed");
        l.c("during the initialization phase. Logging calls during this");
        l.c("phase were not honored. However, subsequent logging calls to these");
        l.c("loggers will work as normally expected.");
        l.c("See also https://www.slf4j.org/codes.html#substituteLogger");
    }

    private static final void k() {
        String r0 = e.b();     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        String[] r1 = f;     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        int r2 = r1.length;     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r2) goto L8;
        if (r0.startsWith(r1[r3]) == false) goto L7;
        r4 = true;
    L7:
        r3 = r3 + 1;     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        goto L3
    L8:
        if (r4 == true) goto L20;
        l.c("The requested version " + r0 + " by your slf4j binding is not compatible with " + Arrays.asList(f).toString());     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        l.c("See https://www.slf4j.org/codes.html#version_mismatch for further details.");     // Catch: Throwable -> L11 NoSuchFieldError -> L14
        goto L22
    L21:
        return;
    L20:
        return;
    L11:
        th = move-exception;
        l.a("Unexpected problem occured during version sanity check", th);
        return;
    }

    /* JADX INFO: renamed from: lambda$Sh_vbE7-GXcPspttxm17xLWwQO4, reason: not valid java name */
    public static /* synthetic */ ServiceLoader m3209lambda$Sh_vbE7GXcPspttxm17xLWwQO4(ClassLoader r0) {
        return b(r0);
    }
}

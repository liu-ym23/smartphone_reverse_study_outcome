package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ClassLoader[] f17923a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SecurityManager f17924b = null;
    private static Boolean c;
    private static final boolean d = false;
    private static final PrivilegedAction<ClassLoader> e = null;

    /* JADX INFO: renamed from: org.apache.logging.log4j.util.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements PrivilegedAction<ClassLoader> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public ClassLoader a() {
            ClassLoader r1 = Thread.currentThread().getContextClassLoader();
            if (r1 == null) goto L5;
            return r1;
        L5:
            ClassLoader r2 = g.class.getClassLoader();
            if (r2 == null) goto L8;
            return r2;
        L8:
            if (g.b() == false) goto L10;
            return r2;
        L10:
            return ClassLoader.getSystemClassLoader();
        }

        @Override // java.security.PrivilegedAction
        public /* synthetic */ ClassLoader run() {
            return a();
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ClassLoader f17925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final URL f17926b;

        b(ClassLoader r1, URL r2) {
            this.f17925a = r1;
            this.f17926b = r2;
        }

        public ClassLoader a() {
            return this.f17925a;
        }

        public URL b() {
            return this.f17926b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L27:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L27;
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            ClassLoader r2 = this.f17925a;
            if (r2 == null) goto L16;
            if (r2.equals(r6.f17925a) == false) goto L17;
        L18:
            URL r4 = this.f17926b;
            if (r4 == null) goto L24;
            if (r4.equals(r6.f17926b) == false) goto L25;
        L26:
            return true;
        L25:
            return false;
        L24:
            if (r6.f17926b == null) goto L26;
        L17:
            return false;
        L16:
            if (r6.f17925a == null) goto L18;
            goto L17
        }

        public int hashCode() {
            return Objects.hashCode(this.f17925a) + Objects.hashCode(this.f17926b);
        }
    }

    static {
        boolean r0 = false;
        f17923a = new ClassLoader[0];
        SecurityManager r1 = System.getSecurityManager();
        f17924b = r1;
        e = new a(null);
        if (r1 != null) goto L9;
    L7:
        d = r0;
        return;
    L9:
        r1.checkPermission(new RuntimePermission("getClassLoader"));     // Catch: SecurityException -> L6
    L6:
        r0 = true;
        goto L7
    }

    private g() {
    }

    public static Class<?> a(String r2) {
        if (c() == true) goto L5;
        ClassLoader r0 = a();     // Catch: Throwable -> L12
        if (r0 == null) goto L11;
        return r0.loadClass(r2);
    L11:
        return ZeusTransformUtils.forName(r2, "com.obric.memorydata.plugin");
    L5:
        return ZeusTransformUtils.forName(r2, "com.obric.memorydata.plugin");
    }

    public static ClassLoader a() {
        if (d == false) goto L7;
        return g.class.getClassLoader();
    L7:
        if (f17924b != null) goto L9;
        Object r0 = e.run();
    L11:
        return (ClassLoader) ZeusTransformUtils.preCheckCast(r0, ClassLoader.class, "com.obric.memorydata.plugin");
    L9:
        r0 = AccessController.doPrivileged(e);
        goto L11
    }

    public static <T> T a(Class<T> r2) {
        return r2.getConstructor(new Class[0]).newInstance(new Object[0]);
    L6:
        return r2.newInstance();
    }

    public static <T> T a(String r0, Class<T> r1) {
        return r1.cast(b(r0));
    }

    static Collection<URL> a(String r3, boolean r4) {
        Collection<b> r5 = b(r3, r4);
        LinkedHashSet r6 = new LinkedHashSet(r5.size());
        Iterator<b> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.add(((b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.memorydata.plugin")).b());
        goto L4
    L6:
        return r6;
    }

    public static <T> T b(String r0) {
        return (T) a(a(r0));
    }

    static Collection<b> b(String r9, boolean r10) {
        ClassLoader[] r1 = new ClassLoader[3];
        ClassLoader r2 = null;
        if (r10 == false) goto L5;
        ClassLoader r11 = a();
    L6:
        int r3 = 0;
        r1[0] = r11;
        r1[1] = g.class.getClassLoader();
        if (d == true) goto L10;
        r2 = ClassLoader.getSystemClassLoader();
    L10:
        r1[2] = r2;
        LinkedHashSet r12 = new LinkedHashSet();
    L11:
        if (r3 >= 3) goto L22;
        ClassLoader r4 = r1[r3];
        if (r4 == null) goto L21;
        Enumeration<URL> r5 = r4.getResources(r9);     // Catch: IOException -> L19
    L16:
        if (r5.hasMoreElements() == false) goto L21;
        r12.add(new b(r4, (URL) ZeusTransformUtils.preCheckCast(r5.nextElement(), URL.class, "com.obric.memorydata.plugin")));     // Catch: IOException -> L19
    L19:
        e = move-exception;
        h.a(e);
    L21:
        r3 = r3 + 1;
        goto L11
    L22:
        return r12;
    L5:
        r11 = null;
        goto L6
    }

    static /* synthetic */ boolean b() {
        return d;
    }

    private static boolean c() {
        if (c != null) goto L12;
        String r0 = PropertiesUtil.a().a("log4j.ignoreTCL", null);
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        c = Boolean.valueOf(r1);
        goto L12
    L7:
        if ("false".equalsIgnoreCase(r0.trim()) == true) goto L9;
        r1 = true;
    L12:
        return c.booleanValue();
    }
}

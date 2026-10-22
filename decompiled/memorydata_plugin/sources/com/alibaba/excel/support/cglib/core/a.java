package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f353a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Map<ClassLoader, C0050a> f354b;
    private static final boolean c = false;
    private q d;
    private z e;
    private b f;
    private ClassLoader g;
    private Class h;
    private String i;
    private Object j;
    private boolean k;
    private String l;
    private boolean m;

    /* JADX INFO: renamed from: com.alibaba.excel.support.cglib.core.a$a, reason: collision with other inner class name */
    protected static class C0050a {
        private static final com.alibaba.excel.support.cglib.core.a.b<a, Object> e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.alibaba.excel.support.cglib.core.a.c<a, Object, Object> f356b;
        private final WeakReference<ClassLoader> c;
        private final ab d;

        static {
            e = new AnonymousClass2();
        }

        public C0050a(ClassLoader r3) {
            this.f355a = new HashSet();
            this.d = new AnonymousClass1(this);
            if (r3 == null) goto L7;
            this.c = new WeakReference(r3);
            com.alibaba.excel.support.cglib.core.a.b<a, Object> r4 = new AnonymousClass3(this);
            this.f356b = new com.alibaba.excel.support.cglib.core.a.c(e, r4);
            return;
        L7:
            throw new IllegalArgumentException("classLoader == null is not yet supported");
        }

        static /* synthetic */ Set a(C0050a r0) {
            return r0.f355a;
        }

        public ClassLoader a() {
            return (ClassLoader) ZeusTransformUtils.preCheckCast(this.c.get(), ClassLoader.class, "com.obric.memorydata.plugin");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object a(a r1, boolean r2) {
            if (r2 == true) goto L6;
            return r1.a(this);
        L6:
            return r1.c(this.f356b.a(r1));
        }

        public void a(String r1) {
            this.f355a.add(r1);
        }

        public ab b() {
            return this.d;
        }
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f359a;

        public b(String r1) {
            this.f359a = r1;
        }
    }

    static {
        f353a = new ThreadLocal();
        f354b = new WeakHashMap();
        c = Boolean.parseBoolean(System.getProperty("cglib.useCache", "true"));
    }

    public a(b r2) {
        this.d = l.f391a;
        this.e = m.f392a;
        this.k = c;
        this.f = r2;
    }

    static /* synthetic */ Object a(a r0) {
        return r0.j;
    }

    private String a(ab r4) {
        ab r5 = (ab) ZeusTransformUtils.wrapperContextForParams(r4, ab.class, "com.obric.memorydata.plugin");
        return this.e.a(this.i, this.f.f359a, this.j, r5);
    }

    private void b(String r1) {
        this.l = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Class a(C0050a r5) {
        ThreadLocal r0 = f353a;
        Object r1 = r0.get();
        r0.set(this);
        ClassLoader r2 = r5.a();     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32
        if (r2 == null) goto L26;
        monitor-enter(r2);     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32
        String r3 = a(r5.b());     // Catch: Throwable -> L22
        r5.a(r3);     // Catch: Throwable -> L22
        b(r3);     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Throwable -> L22
        if (this.m == true) goto L42;
    L13:
        byte[] r6 = this.d.a(this);     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32 Throwable -> L32
        String r4 = ClassNameReader.a(new com.alibaba.excel.support.asm.e(r6));     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32 Throwable -> L32
        ProtectionDomain r7 = b();     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32 Throwable -> L32
        monitor-enter(r2);     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32 Throwable -> L32
        Class r8 = ae.a(r4, r6, r2, r7, this.h);     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        f353a.set(r1);
        return r8;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32 Throwable -> L32
    L42:
        Class<?> r9 = r2.loadClass(d());     // Catch: ClassNotFoundException -> L36 Throwable -> L27 Exception -> L29 Throwable -> L32 Throwable -> L32
        r0.set(r1);
        return r9;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32 Throwable -> L32
    L26:
        throw new IllegalStateException("ClassLoader is null while trying to define class " + d() + ". It seems that the loader has been expired from a weak reference somehow. Please file an issue at cglib's issue tracker.");     // Catch: Throwable -> L27 Exception -> L29 Throwable -> L32 Throwable -> L32
    L29:
        e = move-exception;
        throw new CodeGenerationException(e);     // Catch: Throwable -> L27
    L32:
        e = move-exception;
        throw e;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        f353a.set(r1);
        throw th;
    }

    public abstract ClassLoader a();

    public abstract Object a(Class r1);

    public void a(z r3) {
        z r4 = (z) ZeusTransformUtils.wrapperContextForParams(r3, z.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r4 = m.f392a;
    L5:
        this.e = r4;
    }

    public void a(ClassLoader r1) {
        this.g = r1;
    }

    public void a(String r1) {
        this.i = r1;
    }

    public T b(Class r1) {
        return (T) new WeakReference(r1);
    }

    public abstract Object b(Object r1);

    public ProtectionDomain b() {
        return null;
    }

    public Object c(T r2) {
        return ((WeakReference) ZeusTransformUtils.preCheckCast(r2, WeakReference.class, "com.obric.memorydata.plugin")).get();
    }

    public void c(Class r1) {
        this.h = r1;
    }

    public Object d(Object r7) {
        ClassLoader r0 = f();     // Catch: Exception -> L21 Throwable -> L24
        C0050a r1 = (C0050a) ZeusTransformUtils.preCheckCast(f354b.get(r0), C0050a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21 Throwable -> L24
        if (r1 == null) goto L5;
    L15:
        this.j = r7;     // Catch: Exception -> L21 Throwable -> L24 Throwable -> L24
        Object r8 = r1.a(this, e());     // Catch: Exception -> L21 Throwable -> L24 Throwable -> L24
        if (ZeusTransformUtils.instanceOf(r8, Class.class) == false) goto L20;
        return a((Class) ZeusTransformUtils.preCheckCast(r8, Class.class, "com.obric.memorydata.plugin"));
    L20:
        return b(r8);
    L5:
        monitor-enter(a.class);     // Catch: Exception -> L21 Throwable -> L24
        Map<ClassLoader, C0050a> r2 = f354b;     // Catch: Throwable -> L12
        C0050a r3 = (C0050a) ZeusTransformUtils.preCheckCast(r2.get(r0), C0050a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 != null) goto L9;
        WeakHashMap r4 = new WeakHashMap(r2);     // Catch: Throwable -> L12
        C0050a r5 = new C0050a(r0);     // Catch: Throwable -> L12
        r4.put(r0, r5);     // Catch: Throwable -> L12
        f354b = r4;     // Catch: Throwable -> L12
    L10:
        monitor-exit(a.class);     // Catch: Throwable -> L12
        r1 = r5;
        goto L15
    L9:
        r5 = r3;
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L21 Throwable -> L24 Throwable -> L24
    L24:
        e = move-exception;
        throw e;
    L21:
        e = move-exception;
        throw new CodeGenerationException(e);
    }

    public final String d() {
        return this.l;
    }

    public boolean e() {
        return this.k;
    }

    public ClassLoader f() {
        ClassLoader r0 = this.g;
        if (r0 != null) goto L5;
        r0 = a();
    L5:
        if (r0 != null) goto L7;
        r0 = getClass().getClassLoader();
    L7:
        if (r0 != null) goto L9;
        r0 = Thread.currentThread().getContextClassLoader();
    L9:
        if (r0 == null) goto L12;
        return r0;
    L12:
        throw new IllegalStateException("Cannot determine classloader");
    }
}

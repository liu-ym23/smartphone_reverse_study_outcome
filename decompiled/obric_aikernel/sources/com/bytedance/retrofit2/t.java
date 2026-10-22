package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<q4.a> f2699l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Method, w<?>> f2700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Method, Object> f2701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n4.a.InterfaceC0245a f2702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f2703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<f.a> f2704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<c.a> f2705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f2706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f2707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f2708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<q4.a> f2709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final m4.a f2710k;

    class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f2711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object[] f2712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f2713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ t f2714d;

        a(t r10, Class r11) {
            this.f2714d = r10;
            this.f2713c = r11;
            this.f2711a = q.g();
            this.f2712b = new Object[0];
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) {
            if (r11.getDeclaringClass() != Object.class) goto L7;
            return r11.invoke(this, r12);
        L7:
            if (this.f2711a.i(r11) == true) goto L9;
            w<?> r13 = this.f2714d.j(r11);
            if (r12 != null) goto L15;
            r12 = this.f2712b;
        L15:
            return r13.a(r12);
        L9:
            return this.f2711a.h(r11, this.f2713c, r10, r12);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f2715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private n4.a.InterfaceC0245a f2716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h f2717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<q4.a> f2718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<f.a> f2719e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<c.a> f2720f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Executor f2721g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Executor f2722h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f2723i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private m4.a f2724j;

        static {
        }

        public b() {
            this(q.g());
        }

        b(q r10) {
            this.f2718d = new CopyOnWriteArrayList();
            this.f2719e = new ArrayList();
            this.f2720f = new ArrayList();
            this.f2715a = r10;
        }

        public b a(c.a r10) {
            this.f2720f.add((c.a) c0.a(r10, "factory == null"));
            return this;
        }

        public b b(f.a r10) {
            this.f2719e.add((f.a) c0.a(r10, "factory == null"));
            return this;
        }

        public b c(q4.a r10) {
            q4.a r11 = (q4.a) c0.a(r10, "interceptor == null");
            this.f2718d.add(r11);
            return this;
        }

        public t d() {
            if (this.f2717c == null) goto L26;
            if (this.f2716b == null) goto L24;
            if (this.f2721g == null) goto L22;
            Executor r10 = this.f2722h;
            if (r10 != null) goto L11;
            r10 = this.f2715a.b();
        L11:
            Executor r11 = r10;
            ArrayList r12 = new ArrayList(this.f2720f);
            r12.addAll(this.f2715a.a(r11));
            ArrayList r13 = new ArrayList((this.f2719e.size() + 1) + this.f2715a.d());
            r13.add(new com.bytedance.retrofit2.a());
            r13.addAll(this.f2719e);
            r13.addAll(this.f2715a.c());
            if (t.a() == null) goto L20;
            Iterator r14 = t.a().iterator();
        L15:
            if (r14.hasNext() == false) goto L20;
            q4.a r15 = (q4.a) r14.next();
            if (this.f2718d.contains(r15) == true) goto L15;
            this.f2718d.add(r15);
        L20:
            return new t(this.f2717c, this.f2716b, this.f2718d, r13, r12, this.f2721g, r11, this.f2723i, this.f2724j);
        L22:
            throw new IllegalStateException("HttpExecutor may not be null.");
        L24:
            throw new IllegalStateException("ClientProvider may not be null.");
        L26:
            throw new IllegalStateException("Endpoint may not be null.");
        }

        public b e(n4.a.InterfaceC0245a r10) {
            return g((n4.a.InterfaceC0245a) c0.a(r10, "provider == null"));
        }

        public b f(Executor r10) {
            this.f2721g = (Executor) c0.a(r10, "httpExecutor == null");
            return this;
        }

        public b g(n4.a.InterfaceC0245a r10) {
            this.f2716b = (n4.a.InterfaceC0245a) c0.a(r10, "provider == null");
            return this;
        }

        public b h(String r10) {
            if (r10 == null) goto L8;
            if (r10.trim().length() == 0) goto L8;
            this.f2717c = i.a(r10);
            return this;
        L8:
            throw new NullPointerException("Endpoint may not be blank.");
        }
    }

    t(h r10, n4.a.InterfaceC0245a r11, List<q4.a> r12, List<f.a> r13, List<c.a> r14, Executor r15, Executor r16, boolean r17, m4.a r18) {
        this.f2700a = new ConcurrentHashMap();
        this.f2701b = new ConcurrentHashMap();
        this.f2703d = r10;
        this.f2702c = r11;
        this.f2709j = r12;
        this.f2704e = Collections.unmodifiableList(r13);
        this.f2705f = Collections.unmodifiableList(r14);
        this.f2708i = r15;
        this.f2706g = r16;
        this.f2707h = r17;
        this.f2710k = r18;
    }

    static /* synthetic */ CopyOnWriteArrayList a() {
        return f2699l;
    }

    private void f(Class<?> r10) {
        q r11 = q.g();
        Method[] r12 = r10.getDeclaredMethods();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L10;
        Method r15 = r12[r14];
        if (r11.i(r15) == true) goto L9;
        if (Modifier.isStatic(r15.getModifiers()) == true) goto L9;
        j(r15);
    L9:
        r14 = r14 + 1;
        goto L3
    }

    public static void s(CopyOnWriteArrayList<q4.a> r10) {
        f2699l = r10;
    }

    public m4.a b() {
        return this.f2710k;
    }

    public c<?, ?> c(Type r10, Annotation[] r11) {
        return l(null, r10, r11);
    }

    public n4.a.InterfaceC0245a d() {
        return this.f2702c;
    }

    public <T> T e(Class<T> r10) {
        c0.x(r10);
        if (this.f2707h == false) goto L6;
        f(r10);
    L6:
        return (T) Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new a(this, r10));
    }

    public <T> f<T, n4.b> g(Type r10, Annotation[] r11) {
        c0.a(r10, "type == null");
        c0.a(r11, "annotations == null");
        int r12 = this.f2704e.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        f<T, n4.b> r14 = (f<T, n4.b>) this.f2704e.get(r13).a(r10, r11, this);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new IllegalArgumentException("Could not locate header converter");
    }

    public Executor h() {
        return this.f2708i;
    }

    public List<q4.a> i() {
        return this.f2709j;
    }

    w<?> j(Method r10) {
        if (u.a() == true) goto L5;
        w<?> r11 = this.f2700a.get(r10);
        if (r11 != null) goto L9;
        Map<Method, w<?>> r12 = this.f2700a;
        monitor-enter(r12);
        w<?> r13 = this.f2700a.get(r10);     // Catch: Throwable -> L19
        if (r13 != null) goto L17;
        r13 = w.b(this, r10, new RetrofitMetrics(false));     // Catch: Throwable -> L19
        this.f2700a.put(r10, r13);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r12);     // Catch: Throwable -> L19
        return r13;
    L19:
        th = move-exception;
        throw th;
    L9:
        if ((r11 instanceof l) == false) goto L11;
        ((l) r11).f2523a.c(new RetrofitMetrics(true));
    L11:
        return r11;
    L5:
        return k(r10);
    }

    w<?> k(Method r10) {
        Object r11 = this.f2701b.get(r10);
        if ((r11 instanceof w) == true) goto L5;
        if (r11 != null) goto L22;
        Object r12 = new Object();
        monitor-enter(r12);
        r11 = this.f2701b.putIfAbsent(r10, r12);     // Catch: Throwable -> L19
        if (r11 != null) goto L17;
        w<?> r13 = w.b(this, r10, new RetrofitMetrics(false));     // Catch: Throwable -> L19
        this.f2701b.put(r10, r13);     // Catch: Throwable -> L19
        monitor-exit(r12);     // Catch: Throwable -> L19
        return r13;
    L17:
        monitor-exit(r12);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        monitor-enter(r11);
        w<?> r14 = (w) this.f2701b.get(r10);     // Catch: Throwable -> L26
        monitor-exit(r11);     // Catch: Throwable -> L26
        return r14;
    L26:
        th = move-exception;
        throw th;
    L5:
        if ((r11 instanceof l) == false) goto L8;
        ((l) r11).f2523a.c(new RetrofitMetrics(true));
    L8:
        return (w) r11;
    }

    public c<?, ?> l(c.a r10, Type r11, Annotation[] r12) {
        c0.a(r11, "returnType == null");
        c0.a(r12, "annotations == null");
        int r13 = this.f2705f.indexOf(r10) + 1;
        int r14 = this.f2705f.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        c<?, ?> r16 = this.f2705f.get(r15).a(r11, r12, this);
        if (r16 != null) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        StringBuilder r17 = new StringBuilder("Could not locate call adapter for ");
        r17.append(r11);
        r17.append(".\n");
        if (r10 == null) goto L14;
        r17.append("  Skipped:");
        int r18 = 0;
    L11:
        if (r18 >= r13) goto L13;
        r17.append("\n   * ");
        r17.append(this.f2705f.get(r18).getClass().getName());
        r18 = r18 + 1;
        goto L11
    L13:
        r17.append('\n');
    L14:
        r17.append("  Tried:");
        int r19 = this.f2705f.size();
    L15:
        if (r13 >= r19) goto L18;
        r17.append("\n   * ");
        r17.append(this.f2705f.get(r13).getClass().getName());
        r13 = r13 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r17.toString());
    }

    public <T> f<T, r4.f> m(f.a r10, Type r11, Annotation[] r12, Annotation[] r13) {
        c0.a(r11, "type == null");
        c0.a(r12, "parameterAnnotations == null");
        c0.a(r13, "methodAnnotations == null");
        int r14 = this.f2704e.indexOf(r10) + 1;
        int r15 = this.f2704e.size();
        int r16 = r14;
    L3:
        if (r16 >= r15) goto L8;
        f<T, r4.f> r17 = (f<T, r4.f>) this.f2704e.get(r16).c(r11, r12, r13, this);
        if (r17 != null) goto L6;
        r16 = r16 + 1;
        goto L3
    L6:
        return r17;
    L8:
        StringBuilder r18 = new StringBuilder("Could not locate RequestBody converter for ");
        r18.append(r11);
        r18.append(".\n");
        if (r10 == null) goto L14;
        r18.append("  Skipped:");
        int r19 = 0;
    L11:
        if (r19 >= r14) goto L13;
        r18.append("\n   * ");
        r18.append(this.f2704e.get(r19).getClass().getName());
        r19 = r19 + 1;
        goto L11
    L13:
        r18.append('\n');
    L14:
        r18.append("  Tried:");
        int r20 = this.f2704e.size();
    L15:
        if (r14 >= r20) goto L18;
        r18.append("\n   * ");
        r18.append(this.f2704e.get(r14).getClass().getName());
        r14 = r14 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r18.toString());
    }

    public <T> f<r4.e, T> n(f.a r10, Type r11, Annotation[] r12) {
        c0.a(r11, "type == null");
        c0.a(r12, "annotations == null");
        int r13 = this.f2704e.indexOf(r10) + 1;
        int r14 = this.f2704e.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        f<r4.e, T> r16 = (f<r4.e, T>) this.f2704e.get(r15).d(r11, r12, this);
        if (r16 != null) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        StringBuilder r17 = new StringBuilder("Could not locate TypedInput converter for ");
        r17.append(r11);
        r17.append(".\n");
        if (r10 == null) goto L14;
        r17.append("  Skipped:");
        int r18 = 0;
    L11:
        if (r18 >= r13) goto L13;
        r17.append("\n   * ");
        r17.append(this.f2704e.get(r18).getClass().getName());
        r18 = r18 + 1;
        goto L11
    L13:
        r17.append('\n');
    L14:
        r17.append("  Tried:");
        int r19 = this.f2704e.size();
    L15:
        if (r13 >= r19) goto L18;
        r17.append("\n   * ");
        r17.append(this.f2704e.get(r13).getClass().getName());
        r13 = r13 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r17.toString());
    }

    public <T> f<T, Object> o(Type r10, Annotation[] r11) {
        c0.a(r10, "type == null");
        c0.a(r11, "annotations == null");
        int r12 = this.f2704e.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        f<T, Object> r14 = (f<T, Object>) this.f2704e.get(r13).b(r10, r11, this);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new IllegalArgumentException("Could not locate object converter");
    }

    public <T> f<T, r4.f> p(Type r10, Annotation[] r11, Annotation[] r12) {
        return m(null, r10, r11, r12);
    }

    public <T> f<r4.e, T> q(Type r10, Annotation[] r11) {
        return n(null, r10, r11);
    }

    public h r() {
        return this.f2703d;
    }

    public <T> f<T, String> t(Type r10, Annotation[] r11) {
        c0.a(r10, "type == null");
        c0.a(r11, "annotations == null");
        int r12 = this.f2704e.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        f<T, String> r14 = (f<T, String>) this.f2704e.get(r13).e(r10, r11, this);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        return com.bytedance.retrofit2.a.h.f2488a;
    }
}

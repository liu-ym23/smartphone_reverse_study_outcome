package com.bumptech.glide.load.a;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o<Object, Object> f633b = null;
    private final List<b<?, ?>> c;
    private final c d;
    private final Set<b<?, ?>> e;
    private final Pools.Pool<List<Throwable>> f;

    private static class a implements o<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.a.o
        public o.a<Object> a(Object r1, int r2, int r3, com.bumptech.glide.load.e r4) {
            return null;
        }

        @Override // com.bumptech.glide.load.a.o
        public boolean a(Object r1) {
            return false;
        }
    }

    private static class b<Model, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<Data> f634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final p<? extends Model, ? extends Data> f635b;
        private final Class<Model> c;

        public b(Class<Model> r3, Class<Data> r4, p<? extends Model, ? extends Data> r5) {
            p<? extends Model, ? extends Data> r6 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.f634a = r4;
            this.f635b = r6;
        }

        public boolean a(Class<?> r1) {
            return this.c.isAssignableFrom(r1);
        }

        public boolean a(Class<?> r1, Class<?> r2) {
            if (a(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f634a.isAssignableFrom(r2) == false) goto L7;
            return true;
        }
    }

    static class c {
        c() {
        }

        public <Model, Data> r<Model, Data> a(List<o<Model, Data>> r2, Pools.Pool<List<Throwable>> r3) {
            return new r((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r3, Pools.Pool.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f632a = new c();
        f633b = new a();
    }

    public s(Pools.Pool<List<Throwable>> r3) {
        this((Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r3, Pools.Pool.class, "com.obric.memorydata.plugin"), f632a);
    }

    s(Pools.Pool<List<Throwable>> r3, c r4) {
        Pools.Pool<List<Throwable>> r5 = (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r3, Pools.Pool.class, "com.obric.memorydata.plugin");
        this.c = new ArrayList();
        this.e = new HashSet();
        this.f = r5;
        this.d = r4;
    }

    private static <Model, Data> o<Model, Data> a() {
        return (o<Model, Data>) f633b;
    }

    private <Model, Data> o<Model, Data> a(b<?, ?> r2) {
        return (o) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r2.f635b.a(this)), o.class, "com.obric.memorydata.plugin");
    }

    private <Model, Data> void a(Class<Model> r3, Class<Data> r4, p<? extends Model, ? extends Data> r5, boolean r6) {
        b<?, ?> r0 = new b(r3, r4, (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.memorydata.plugin"));
        List<b<?, ?>> r2 = this.c;
        if (r6 == false) goto L5;
        int r7 = r2.size();
    L6:
        r2.add(r7, r0);
        return;
    L5:
        r7 = 0;
        goto L6
    }

    public synchronized <Model, Data> o<Model, Data> a(Class<Model> r9, Class<Data> r10) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L28
        Iterator<b<?, ?>> r1 = this.c.iterator();     // Catch: Throwable -> L28
        boolean r4 = false;
    L5:
        if (r1.hasNext() == false) goto L13;
        b<?, ?> r5 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (this.e.contains(r5) == true) goto L8;
        if (r5.a(r9, r10) == false) goto L5;
        this.e.add(r5);     // Catch: Throwable -> L28
        r0.add(a(r5));     // Catch: Throwable -> L28
        this.e.remove(r5);     // Catch: Throwable -> L28
        goto L5
    L8:
        r4 = true;
        goto L5
    L13:
        if (r0.size() <= 1) goto L18;
        r<Model, Data> r11 = this.d.a(r0, this.f);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r11;
    L18:
        if (r0.size() != 1) goto L22;
        o<Model, Data> r12 = (o) ZeusTransformUtils.preCheckCast(r0.get(0), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        monitor-exit(this);
        return r12;
    L22:
        if (r4 == false) goto L27;
        o<Model, Data> r13 = a();     // Catch: Throwable -> L28
        monitor-exit(this);
        return r13;
    L27:
        throw new Registry.NoModelLoaderAvailableException(r9, r10);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.e.clear();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    synchronized <Model> List<o<Model, ?>> a(Class<Model> r6) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<b<?, ?>> r1 = this.c.iterator();     // Catch: Throwable -> L15
    L5:
        if (r1.hasNext() == false) goto L13;
        b<?, ?> r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (this.e.contains(r2) == true) goto L5;
        if (r2.a(r6) == false) goto L5;
        this.e.add(r2);     // Catch: Throwable -> L15
        r0.add(a(r2));     // Catch: Throwable -> L15
        this.e.remove(r2);     // Catch: Throwable -> L15
        goto L5
    L13:
        monitor-exit(this);
        return r0;
    L15:
        th = move-exception;
        this.e.clear();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    synchronized <Model, Data> void a(Class<Model> r3, Class<Data> r4, p<? extends Model, ? extends Data> r5) {
        monitor-enter(this);
        a(r3, r4, (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.memorydata.plugin"), true);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized List<Class<?>> b(Class<?> r6) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<b<?, ?>> r1 = this.c.iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L12;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r0.contains(r2.f634a) == true) goto L5;
        if (r2.a(r6) == false) goto L5;
        r0.add(r2.f634a);     // Catch: Throwable -> L14
        goto L5
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }
}

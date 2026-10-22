package com.bumptech.glide.load.a;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f625b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0061a<?>> f626a;

        /* JADX INFO: renamed from: com.bumptech.glide.load.a.q$a$a, reason: collision with other inner class name */
        private static class C0061a<Model> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final List<o<Model, ?>> f627a;

            public C0061a(List<o<Model, ?>> r3) {
                this.f627a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            }
        }

        a() {
            this.f626a = new HashMap();
        }

        public <Model> List<o<Model, ?>> a(Class<Model> r2) {
            C0061a r1 = (C0061a) ZeusTransformUtils.preCheckCast(this.f626a.get(r2), C0061a.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L6;
            return null;
        L6:
            return r1.f627a;
        }

        public void a() {
            this.f626a.clear();
        }

        public <Model> void a(Class<Model> r3, List<o<Model, ?>> r4) {
            if (((C0061a) ZeusTransformUtils.preCheckCast(this.f626a.put(r3, new C0061a((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"))), C0061a.class, "com.obric.memorydata.plugin")) != null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already cached loaders for model: " + r3);
        }
    }

    public q(Pools.Pool<List<Throwable>> r3) {
        this(new s((Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r3, Pools.Pool.class, "com.obric.memorydata.plugin")));
    }

    private q(s r2) {
        this.f625b = new a();
        this.f624a = r2;
    }

    private static <A> Class<A> b(A r0) {
        return (Class<A>) r0.getClass();
    }

    private synchronized <A> List<o<A, ?>> b(Class<A> r3) {
        monitor-enter(this);
        List<o<A, ?>> r0 = this.f625b.a(r3);     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = Collections.unmodifiableList(this.f624a.a(r3));     // Catch: Throwable -> L8
        this.f625b.a(r3, r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized List<Class<?>> a(Class<?> r2) {
        monitor-enter(this);
        List<Class<?>> r3 = this.f624a.b(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public <A> List<o<A, ?>> a(A r9) {
        List<o<A, ?>> r8 = b(b(r9));
        if (r8.isEmpty() == true) goto L18;
        int r0 = r8.size();
        List<o<A, ?>> r1 = Collections.emptyList();
        boolean r3 = true;
        int r4 = 0;
    L5:
        if (r4 >= r0) goto L13;
        o<A, ?> r5 = (o) ZeusTransformUtils.preCheckCast(r8.get(r4), o.class, "com.obric.memorydata.plugin");
        if (r5.a(r9) == false) goto L11;
        if (r3 == false) goto L10;
        r1 = new ArrayList(r0 - r4);
        r3 = false;
    L10:
        r1.add(r5);
    L11:
        r4 = r4 + 1;
        goto L5
    L13:
        if (r1.isEmpty() == true) goto L16;
        return r1;
    L16:
        throw new Registry.NoModelLoaderAvailableException(r9, r8);
    L18:
        throw new Registry.NoModelLoaderAvailableException(r9);
    }

    public synchronized <Model, Data> void a(Class<Model> r3, Class<Data> r4, p<? extends Model, ? extends Data> r5) {
        monitor-enter(this);
        p<? extends Model, ? extends Data> r6 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f624a.a(r3, r4, r6);     // Catch: Throwable -> L6
        this.f625b.a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

package com.bumptech.glide.d;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.util.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q<?, ?, ?> f536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap<i, q<?, ?, ?>> f537b;
    private final AtomicReference<i> c;

    static {
        f536a = new q(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new com.bumptech.glide.load.resource.d.g(), null)), null);
    }

    public c() {
        this.f537b = new ArrayMap();
        this.c = new AtomicReference();
    }

    private i b(Class<?> r3, Class<?> r4, Class<?> r5) {
        i r2 = (i) ZeusTransformUtils.preCheckCast(this.c.getAndSet(null), i.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        r2 = new i();
    L5:
        r2.a(r3, r4, r5);
        return r2;
    }

    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> r3, Class<TResource> r4, Class<Transcode> r5) {
        i r6 = b(r3, r4, r5);
        ArrayMap<i, q<?, ?, ?>> r7 = this.f537b;
        monitor-enter(r7);
        q<Data, TResource, Transcode> r8 = (q) ZeusTransformUtils.preCheckCast(this.f537b.get(r6), q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        monitor-exit(r7);     // Catch: Throwable -> L8
        this.c.set(r6);
        return r8;
    L8:
        th = move-exception;
        throw th;
    }

    public void a(Class<?> r3, Class<?> r4, Class<?> r5, q<?, ?, ?> r6) {
        ArrayMap<i, q<?, ?, ?>> r0 = this.f537b;
        monitor-enter(r0);
        ArrayMap<i, q<?, ?, ?>> r2 = this.f537b;     // Catch: Throwable -> L11
        i r1 = new i(r3, r4, r5);     // Catch: Throwable -> L11
        if (r6 != null) goto L8;
        r6 = f536a;     // Catch: Throwable -> L11
    L8:
        r2.put(r1, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean a(q<?, ?, ?> r1) {
        return f536a.equals(r1);
    }
}

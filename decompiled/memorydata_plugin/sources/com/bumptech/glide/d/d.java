package com.bumptech.glide.d;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<i> f538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap<i, List<Class<?>>> f539b;

    public d() {
        this.f538a = new AtomicReference();
        this.f539b = new ArrayMap();
    }

    public List<Class<?>> a(Class<?> r4, Class<?> r5, Class<?> r6) {
        i r0 = (i) ZeusTransformUtils.preCheckCast(this.f538a.getAndSet(null), i.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new i(r4, r5, r6);
    L6:
        ArrayMap<i, List<Class<?>>> r7 = this.f539b;
        monitor-enter(r7);
        List<Class<?>> r8 = (List) ZeusTransformUtils.preCheckCast(this.f539b.get(r0), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        monitor-exit(r7);     // Catch: Throwable -> L12
        this.f538a.set(r0);
        return r8;
    L12:
        th = move-exception;
        throw th;
    L5:
        r0.a(r4, r5, r6);
        goto L6
    }

    public void a(Class<?> r3, Class<?> r4, Class<?> r5, List<Class<?>> r6) {
        List<Class<?>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        ArrayMap<i, List<Class<?>>> r0 = this.f539b;
        monitor-enter(r0);
        this.f539b.put(new i(r3, r4, r5), r7);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}

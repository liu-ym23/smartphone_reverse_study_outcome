package com.bumptech.glide.load.resource.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f893a;

    private static final class a<Z, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<Z> f894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<R> f895b;
        final e<Z, R> c;

        a(Class<Z> r3, Class<R> r4, e<Z, R> r5) {
            e<Z, R> r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
            this.f894a = r3;
            this.f895b = r4;
            this.c = r6;
        }

        public boolean a(Class<?> r2, Class<?> r3) {
            if (this.f894a.isAssignableFrom(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (r3.isAssignableFrom(this.f895b) == false) goto L7;
            return true;
        }
    }

    public f() {
        this.f893a = new ArrayList();
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> r5, Class<R> r6) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (r6.isAssignableFrom(r5) == false) goto L8;
        e<Z, R> r7 = g.a();     // Catch: Throwable -> L18
        monitor-exit(this);
        return r7;
    L8:
        Iterator<a<?, ?>> r0 = this.f893a.iterator();     // Catch: Throwable -> L18
    L10:
        if (r0.hasNext() == false) goto L17;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r1.a(r5, r6) == false) goto L10;
        e<Z, R> r8 = r1.c;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r8;
    L17:
        throw new IllegalArgumentException("No transcoder registered to transcode from " + r5 + " to " + r6);     // Catch: Throwable -> L18
    }

    public synchronized <Z, R> void a(Class<Z> r3, Class<R> r4, e<Z, R> r5) {
        monitor-enter(this);
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f893a.add(new a(r3, r4, r6));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> r6, Class<R> r7) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L19
        if (r7.isAssignableFrom(r6) == false) goto L8;
        r0.add(r7);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r0;
    L8:
        Iterator<a<?, ?>> r1 = this.f893a.iterator();     // Catch: Throwable -> L19
    L10:
        if (r1.hasNext() == false) goto L17;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r2.a(r6, r7) == false) goto L10;
        if (r0.contains(r2.f895b) == true) goto L10;
        r0.add(r2.f895b);     // Catch: Throwable -> L19
        goto L10
    L17:
        monitor-exit(this);
        return r0;
    L19:
        th = move-exception;
        throw th;
    }
}

package com.bumptech.glide.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<C0056a<?>> f532a;

    /* JADX INFO: renamed from: com.bumptech.glide.d.a$a, reason: collision with other inner class name */
    private static final class C0056a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.a<T> f533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f534b;

        C0056a(Class<T> r3, com.bumptech.glide.load.a<T> r4) {
            com.bumptech.glide.load.a<T> r5 = (com.bumptech.glide.load.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.a.class, "com.obric.memorydata.plugin");
            this.f534b = r3;
            this.f533a = r5;
        }

        boolean a(Class<?> r1) {
            return this.f534b.isAssignableFrom(r1);
        }
    }

    public a() {
        this.f532a = new ArrayList();
    }

    public synchronized <T> com.bumptech.glide.load.a<T> a(Class<T> r5) {
        monitor-enter(this);
        Iterator<C0056a<?>> r0 = this.f532a.iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L12;
        C0056a r1 = (C0056a) ZeusTransformUtils.preCheckCast(r0.next(), C0056a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1.a(r5) == false) goto L5;
        com.bumptech.glide.load.a<T> r6 = r1.f533a;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r6;
    L12:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized <T> void a(Class<T> r3, com.bumptech.glide.load.a<T> r4) {
        monitor-enter(this);
        com.bumptech.glide.load.a r5 = (com.bumptech.glide.load.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f532a.add(new C0056a(r3, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

package com.bumptech.glide.d;

import com.bumptech.glide.load.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?>> f544a;

    private static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g<T> f545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f546b;

        a(Class<T> r3, g<T> r4) {
            g<T> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            this.f546b = r3;
            this.f545a = r5;
        }

        boolean a(Class<?> r1) {
            return this.f546b.isAssignableFrom(r1);
        }
    }

    public f() {
        this.f544a = new ArrayList();
    }

    public synchronized <Z> g<Z> a(Class<Z> r6) {
        monitor-enter(this);
        int r0 = 0;
        int r1 = this.f544a.size();     // Catch: Throwable -> L15
    L5:
        if (r0 >= r1) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f544a.get(r0), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r2.a(r6) == true) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        g<Z> r7 = (g<Z>) r2.f545a;
        monitor-exit(this);
        return r7;
    L13:
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized <Z> void a(Class<Z> r3, g<Z> r4) {
        monitor-enter(this);
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f544a.add(new a(r3, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

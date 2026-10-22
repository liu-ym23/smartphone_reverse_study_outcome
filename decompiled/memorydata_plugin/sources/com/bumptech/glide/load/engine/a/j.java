package com.bumptech.glide.load.engine.a;

import androidx.core.util.Pools;
import com.bumptech.glide.util.k;
import com.bumptech.glide.util.pool.FactoryPools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.g<com.bumptech.glide.load.c, String> f733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<a> f734b;

    private static final class a implements FactoryPools.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageDigest f736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.util.pool.b f737b;

        a(MessageDigest r2) {
            this.f737b = com.bumptech.glide.util.pool.b.a();
            this.f736a = r2;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.b
        public com.bumptech.glide.util.pool.b a_() {
            return this.f737b;
        }
    }

    public j() {
        this.f733a = new com.bumptech.glide.util.g(1000);
        this.f734b = FactoryPools.a(10, new AnonymousClass1(this));
    }

    private String b(com.bumptech.glide.load.c r4) {
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(this.f734b.acquire()), a.class, "com.obric.memorydata.plugin");
        r5.a(r0.f736a);     // Catch: Throwable -> L6
        String r6 = k.a(r0.f736a.digest());     // Catch: Throwable -> L6
        this.f734b.release(r0);
        return r6;
    L6:
        th = move-exception;
        this.f734b.release(r0);
        throw th;
    }

    public String a(com.bumptech.glide.load.c r5) {
        com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.util.g<com.bumptech.glide.load.c, String> r0 = this.f733a;
        monitor-enter(r0);
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f733a.b(r6), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (r1 != null) goto L8;
        r1 = b(r6);
    L8:
        com.bumptech.glide.util.g<com.bumptech.glide.load.c, String> r2 = this.f733a;
        monitor-enter(r2);
        this.f733a.b(r6, r1);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }
}

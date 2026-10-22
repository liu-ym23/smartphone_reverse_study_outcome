package com.bytedance.ies.bullet.pool;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.bullet.pool.impl.a f5806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final we.a f5807c;
    public final e d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f5808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f5809i;

    public d(f r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r10, "bid");
        this.f5805a = r10;
        this.f5806b = new com.bytedance.ies.bullet.pool.impl.a();
        this.f5807c = new we.a(4);
        this.d = f.f5810a;
        this.e = LazyKt.lazy(PoolKit$mainHandler$2.f5782a);
        this.f = LazyKt.lazy(PoolKit$enableBulletPrerenderGovern$2.f5781a);
        this.g = LazyKt.lazy(PoolKit$preRenderMinFreeMemory$2.f5784a);
        this.f5808h = LazyKt.lazy(PoolKit$preRenderMaxCacheTime$2.f5783a);
        this.f5809i = LazyKt.lazy(PoolKit$enableBulletPrerenderCallMonitor$2.f5780a);
    }
}

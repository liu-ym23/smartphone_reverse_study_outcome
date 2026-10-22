package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.MemoryCacheHitTracker;

/* JADX INFO: loaded from: classes2.dex */
public class InstrumentedMemoryCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountingMemoryCache f8034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryCacheTracker f8035b;

    public InstrumentedMemoryCache(CountingMemoryCache r5, MemoryCacheTracker r10) {
        this.f8034a = r5;
        this.f8035b = r10;
    }

    public final CloseableReference a(CacheKey r5) {
        CloseableReference r10 = this.f8034a.a(r5);
        if (r10 != null) goto L6;
        this.f8035b.c(r5);
        return r10;
    L6:
        this.f8035b.a(r5);
        monitor-enter(r10);
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        if ((r11 instanceof MemoryCacheHitTracker) == false) goto L13;
        ((MemoryCacheHitTracker) r11).b();
    L13:
        return r10;
    L14:
        th = move-exception;
        throw th;
    }
}

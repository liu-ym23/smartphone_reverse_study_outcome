package com.facebook.cache.common;

import com.facebook.cache.disk.SettableCacheEvent;

/* JADX INFO: loaded from: classes2.dex */
public class NoOpCacheEventListener implements CacheEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NoOpCacheEventListener f7578a;

    public NoOpCacheEventListener() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void a(SettableCacheEvent r5) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void b(SettableCacheEvent r5) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void c(SettableCacheEvent r5) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void d(SettableCacheEvent r5) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void e(SettableCacheEvent r5) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void f(SettableCacheEvent r5) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void g(SettableCacheEvent r5) {
    }

    public static synchronized NoOpCacheEventListener a() {
        monitor-enter(NoOpCacheEventListener.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f7578a != null) goto L9;
        f7578a = new NoOpCacheEventListener();     // Catch: Throwable -> L7
    L9:
        NoOpCacheEventListener r5 = f7578a;     // Catch: Throwable -> L7
        monitor-exit(NoOpCacheEventListener.class);
        return r5;
    }
}

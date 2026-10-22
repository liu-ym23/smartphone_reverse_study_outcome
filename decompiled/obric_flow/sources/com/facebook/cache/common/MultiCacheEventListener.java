package com.facebook.cache.common;

import com.facebook.cache.disk.SettableCacheEvent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MultiCacheEventListener implements CacheEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f7575a;

    public MultiCacheEventListener() {
        this.f7575a = new CopyOnWriteArrayList();
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void a(SettableCacheEvent r5) {
        Iterator r10 = this.f7575a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((CacheEventListener) r10.next()).a(r5);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void b(SettableCacheEvent r5) {
        Iterator r10 = this.f7575a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((CacheEventListener) r10.next()).b(r5);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void c(SettableCacheEvent r5) {
        Iterator r10 = this.f7575a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((CacheEventListener) r10.next()).c(r5);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void d(SettableCacheEvent r5) {
        Iterator r10 = this.f7575a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((CacheEventListener) r10.next()).d(r5);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void e(SettableCacheEvent r5) {
        Iterator r10 = this.f7575a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((CacheEventListener) r10.next()).e(r5);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void f(SettableCacheEvent r5) {
        Iterator r10 = this.f7575a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((CacheEventListener) r10.next()).f(r5);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void g(SettableCacheEvent r5) {
        Iterator r10 = this.f7575a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((CacheEventListener) r10.next()).g(r5);
        goto L4
    }
}

package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CountingLruMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueDescriptor f8017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f8018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8019c;

    public CountingLruMap(ValueDescriptor r5) {
        this.f8018b = new LinkedHashMap();
        this.f8019c = 0;
        this.f8017a = r5;
    }

    public final synchronized int a() {
        monitor-enter(this);
        int r5 = this.f8018b.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Object b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f8018b.isEmpty() == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        K r5 = this.f8018b.keySet().iterator().next();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r5;
    }

    public final synchronized int c() {
        monitor-enter(this);
        int r5 = this.f8019c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Object a(CacheKey r5) {
        monitor-enter(this);
        Object r10 = this.f8018b.get(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(CacheKey r5, CountingMemoryCache.Entry r10) {
        monitor-enter(this);
        Object r11 = this.f8018b.remove(r5);     // Catch: Throwable -> L10
        int r12 = this.f8019c;     // Catch: Throwable -> L10
        if (r11 != null) goto L6;
        int r13 = 0;
    L7:
        this.f8019c = r12 - r13;     // Catch: Throwable -> L10
        this.f8018b.put(r5, r10);     // Catch: Throwable -> L10
        int r14 = this.f8019c;     // Catch: Throwable -> L10
        this.f8019c = ((CountingMemoryCache.AnonymousClass1) this.f8017a).a(r10) + r14;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r13 = ((CountingMemoryCache.AnonymousClass1) this.f8017a).a(r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized Object a(Object r5) {
        monitor-enter(this);
        Object r10 = this.f8018b.remove(r5);     // Catch: Throwable -> L10
        int r11 = this.f8019c;     // Catch: Throwable -> L10
        if (r10 != null) goto L6;
        int r12 = 0;
    L7:
        this.f8019c = r11 - r12;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r10;
    L6:
        r12 = ((CountingMemoryCache.AnonymousClass1) this.f8017a).a(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}

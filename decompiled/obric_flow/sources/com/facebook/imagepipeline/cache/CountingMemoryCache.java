package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CountingMemoryCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountingLruMap f8020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountingLruMap f8021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ValueDescriptor f8022c;
    public final Supplier d;
    public MemoryCacheParams e;
    public long f;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.cache.CountingMemoryCache$1, reason: invalid class name */
    class AnonymousClass1 implements ValueDescriptor<Entry<Object, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueDescriptor f8023a;

        public AnonymousClass1(ValueDescriptor r5) {
            this.f8023a = r5;
        }

        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        public final int a(Object r5) {
            ValueDescriptor r10 = this.f8023a;
            CloseableReference r11 = ((Entry) r5).f8027b;
            monitor-enter(r11);
            Object r12 = r11.f7671b.d();     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            return r10.a(r12);
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static class Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CacheKey f8026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CloseableReference f8027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8028c;
        public boolean d;

        public Entry(CacheKey r5, CloseableReference r10) {
            this.f8026a = r5;
            if (r10 == null) goto L5;
            CloseableReference r11 = r10.b();
        L6:
            r11.getClass();
            this.f8027b = r11;
            this.f8028c = 0;
            this.d = false;
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    public CountingMemoryCache(ValueDescriptor r5, Supplier r10) {
        new WeakHashMap();
        this.f8022c = r5;
        this.f8020a = new CountingLruMap(new AnonymousClass1(r5));
        this.f8021b = new CountingLruMap(new AnonymousClass1(r5));
        this.d = r10;
        this.e = (MemoryCacheParams) r10.get();
        this.f = SystemClock.uptimeMillis();
    }

    public final synchronized boolean a(Object r5) {
        monitor-enter(this);
        int r10 = this.f8022c.a(r5);     // Catch: Throwable -> L12
        if (r10 <= this.e.d) goto L6;
    L14:
        monitor-exit(this);
        return false;
    L6:
        if (a() > (this.e.f8037b - 1)) goto L14;
        if (b() > (this.e.f8036a - r10)) goto L14;
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Entry r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r5.d == true) goto L11;
        r5.f8028c++;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }

    public final void c() {
        monitor-enter(this);
        this.e.getClass();     // Catch: Throwable -> L6
        int r5 = Math.min(Integer.MAX_VALUE, this.e.f8037b - a());     // Catch: Throwable -> L6
        MemoryCacheParams r10 = this.e;     // Catch: Throwable -> L6
        a(r5, Math.min(r10.f8038c, r10.f8036a - b()));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(Entry r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r5.d == false) goto L6;
    L12:
        monitor-exit(this);
        return;
    L6:
        if (r5.f8028c != 0) goto L12;
        this.f8020a.a(r5.f8026a, r5);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized DefaultCloseableReference e(final Entry r5) {
        monitor-enter(this);
        b(r5);     // Catch: Throwable -> L6
        DefaultCloseableReference r10 = CloseableReference.a(r5.f8027b.c(), new AnonymousClass2(this, r5), CloseableReference.f);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized CloseableReference f(Entry r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r5.d == true) goto L6;
    L12:
        monitor-exit(this);
        return null;
    L6:
        if (r5.f8028c != 0) goto L12;
        CloseableReference r10 = r5.f8027b;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r10;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((this.f + this.e.e) <= SystemClock.uptimeMillis()) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.e = (MemoryCacheParams) this.d.get();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final synchronized int b() {
        monitor-enter(this);
        int r5 = this.f8021b.c() - this.f8020a.c();
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public final CloseableReference a(CacheKey r5, CloseableReference r10) {
        r10.getClass();
        d();
        monitor-enter(this);
        Entry r11 = (Entry) this.f8020a.a(r5);     // Catch: Throwable -> L7
        Entry r12 = (Entry) this.f8021b.a(r5);     // Catch: Throwable -> L7
        DefaultCloseableReference r13 = null;
        if (r12 == null) goto L9;
        c(r12);     // Catch: Throwable -> L7
        CloseableReference r14 = f(r12);     // Catch: Throwable -> L7
    L11:
        if (a(r10.c()) == false) goto L13;
        Entry r15 = new Entry(r5, r10);     // Catch: Throwable -> L7
        this.f8021b.a(r5, r15);     // Catch: Throwable -> L7
        r13 = e(r15);     // Catch: Throwable -> L7
    L13:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r14 == null) goto L16;
        r14.close();
    L16:
        c();
        return r13;
    L9:
        r14 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(Entry r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r5.d == true) goto L11;
        r5.d = true;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }

    public final CloseableReference a(CacheKey r5) {
        r5.getClass();
        monitor-enter(this);
        Entry r10 = (Entry) this.f8020a.a(r5);     // Catch: Throwable -> L7
        Entry r11 = (Entry) this.f8021b.a(r5);     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        DefaultCloseableReference r12 = e(r11);     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        d();
        c();
        return r12;
    L9:
        r12 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(int r5, int r10) {
        monitor-enter(this);
        int r11 = Math.max(r5, 0);     // Catch: Throwable -> L9
        int r12 = Math.max(r10, 0);     // Catch: Throwable -> L9
        if (this.f8020a.a() > r11) goto L11;
        if (this.f8020a.c() > r12) goto L11;
    L17:
        monitor-exit(this);
        return;
    L11:
        if (this.f8020a.a() <= r11) goto L14;
    L15:
        Object r13 = this.f8020a.b();     // Catch: Throwable -> L9
        if (r13 == null) goto L17;
        this.f8020a.a(r13);     // Catch: Throwable -> L9
        Entry r14 = (Entry) this.f8021b.a(r13);     // Catch: Throwable -> L9
        if (r14 == null) goto L11;
        c(r14);     // Catch: Throwable -> L9
        CloseableReference r15 = f(r14);     // Catch: Throwable -> L9
        if (r15 == null) goto L11;
        r15.close();     // Catch: Throwable -> L9
        goto L11
    L14:
        if (this.f8020a.c() <= r12) goto L17;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(Entry r5) {
        monitor-enter(this);
        int r10 = r5.f8028c;     // Catch: Throwable -> L8
        if (r10 <= 0) goto L11;
        r5.f8028c = r10 - 1;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized int a() {
        monitor-enter(this);
        int r5 = this.f8021b.a() - this.f8020a.a();
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }
}

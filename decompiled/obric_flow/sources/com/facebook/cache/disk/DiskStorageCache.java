package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.MultiCacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DiskStorageCache implements FileCache {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f7617n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f7618o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7621c;
    public final MultiCacheEventListener d;
    public final HashSet e;
    public long f;
    public final StatFsHelper g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DynamicDefaultDiskStorage f7622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DefaultEntryEvictionComparatorSupplier f7623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NoOpCacheErrorLogger f7624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CacheStats f7625k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SystemClock f7626l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f7627m;

    public static class CacheStats {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7630c;

        public CacheStats() {
            this.f7628a = false;
            this.f7629b = -1;
            this.f7630c = -1;
        }

        public final synchronized void a(long r5, long r10) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.f7628a == false) goto L10;
            this.f7629b += r5;     // Catch: Throwable -> L8
            this.f7630c += r10;     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L10:
            monitor-exit(this);
        }

        public final synchronized void b() {
            monitor-enter(this);
            this.f7628a = false;     // Catch: Throwable -> L7
            this.f7630c = -1;     // Catch: Throwable -> L7
            this.f7629b = -1;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final synchronized long a() {
            monitor-enter(this);
            long r5 = this.f7629b;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r5;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void b(long r5, long r10) {
            monitor-enter(this);
            this.f7630c = r10;     // Catch: Throwable -> L6
            this.f7629b = r5;     // Catch: Throwable -> L6
            this.f7628a = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static class Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f7631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7632b;

        public Params(long r5, long r10, long r11) {
            this.f7631a = r10;
            this.f7632b = r11;
        }
    }

    static {
        f7617n = TimeUnit.HOURS.toMillis(2);
        f7618o = TimeUnit.MINUTES.toMillis(30);
    }

    public DiskStorageCache(DynamicDefaultDiskStorage r5, DefaultEntryEvictionComparatorSupplier r10, Params r11, NoOpCacheEventListener r12, NoOpCacheErrorLogger r13, ExecutorService r14) {
        this.f7627m = new Object();
        this.f7619a = r11.f7631a;
        long r15 = r11.f7632b;
        this.f7620b = r15;
        this.f7621c = r15;
        monitor-enter(StatFsHelper.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (StatFsHelper.f7679h != null) goto L9;
        StatFsHelper.f7679h = new StatFsHelper();     // Catch: Throwable -> L7
    L9:
        StatFsHelper r16 = StatFsHelper.f7679h;     // Catch: Throwable -> L7
        monitor-exit(StatFsHelper.class);     // Catch: Throwable -> L7
        this.g = r16;
        this.f7622h = r5;
        this.f7623i = r10;
        this.f = -1;
        MultiCacheEventListener r17 = new MultiCacheEventListener();
        this.d = r17;
        r17.f7575a.add(r12);
        this.f7624j = r13;
        this.f7625k = new CacheStats();
        this.f7626l = SystemClock.f7693a;
        this.e = new HashSet();
        new CountDownLatch(0);
    }

    public final BinaryResource a(SimpleCacheKey r10) {
        SettableCacheEvent r5 = SettableCacheEvent.a();
        Object r11 = this.f7627m;     // Catch: Throwable -> L22 IOException -> L24
        monitor-enter(r11);     // Catch: Throwable -> L22 IOException -> L24
        ArrayList r12 = CacheKeyUtil.a(r10);     // Catch: Throwable -> L12
        int r13 = 0;
        String r14 = null;
        BinaryResource r15 = null;
    L7:
        if (r13 >= r12.size()) goto L14;
        r14 = (String) r12.get(r13);     // Catch: Throwable -> L12
        r15 = ((DefaultDiskStorage) this.f7622h.a()).a(r14, r10);     // Catch: Throwable -> L12
        if (r15 != null) goto L14;
        r13 = r13 + 1;     // Catch: Throwable -> L12
    L14:
        if (r15 != null) goto L16;
        this.d.a(r5);     // Catch: Throwable -> L12
        this.e.remove(r14);     // Catch: Throwable -> L12
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L12
        r5.b();
        return r15;
    L16:
        this.d.c(r5);     // Catch: Throwable -> L12
        this.e.add(r14);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22 IOException -> L24
    L24:
        this.f7624j.getClass();     // Catch: Throwable -> L22
        this.d.d(r5);     // Catch: Throwable -> L22
        r5.b();
        return null;
    L22:
        th = move-exception;
        r5.b();
        throw th;
    }

    public final Map b(SimpleCacheKey r5) {
        ArrayList r10 = CacheKeyUtil.a(r5);
        if (r10.size() <= 0) goto L6;
        String r11 = (String) r10.get(0);
        return ((DefaultDiskStorage) this.f7622h.a()).b(r11, r5);
    L6:
        return null;
    }

    public final void c() {
        Object r5 = this.f7627m;
        monitor-enter(r5);
        Collection r10 = ((DefaultDiskStorage) this.f7622h.a()).a();     // Catch: Throwable -> L11 IOException -> L13
        List r11 = ((DefaultDiskStorage) this.f7622h.a()).b();     // Catch: Throwable -> L11 IOException -> L13
        if (r10.size() <= r11.size()) goto L14;
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L11 IOException -> L13
    L8:
        if (r12.hasNext() == false) goto L14;
        a(((DefaultDiskStorage.EntryImpl) ((DiskStorage.Entry) r12.next())).f7591a, r11);     // Catch: Throwable -> L11 IOException -> L13
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L13:
        FLog.a(DiskStorageCache.class, "remove config file failed");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (this.f7622h.b() == false) goto L5;
        StatFsHelper.StorageType r5 = StatFsHelper.StorageType.f7685b;
    L6:
        StatFsHelper r10 = this.g;
        long r11 = this.f7620b;
        CacheStats r12 = this.f7625k;
        monitor-enter(r12);
        long r13 = r12.f7629b;     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
        if (r10.a(r5, r11 - r13) == false) goto L14;
        this.f7621c = this.f7619a;
        return;
    L14:
        this.f7621c = this.f7620b;
        return;
    L16:
        th = move-exception;
        throw th;
    L5:
        r5 = StatFsHelper.StorageType.f7684a;
        goto L6
    }

    public final boolean b() {
        DiskStorageCache r5 = this;
        r5.f7626l.getClass();
        long r10 = System.currentTimeMillis();
        long r11 = f7617n + r10;
        Iterator r12 = ((DefaultDiskStorage) r5.f7622h.a()).c().iterator();     // Catch: IOException -> L24
        long r13 = -1;
        boolean r14 = false;
        int r15 = 0;
        long r16 = 0;
    L6:
        if (r12.hasNext() == false) goto L21;
        r15 = r15 + 1;     // Catch: IOException -> L10
        DefaultDiskStorage.EntryImpl r17 = (DefaultDiskStorage.EntryImpl) ((DiskStorage.Entry) r12.next());     // Catch: IOException -> L10
        Iterator r18 = r12;
        if (r17.f7593c >= 0) goto L12;
        r17.f7593c = r17.f7592b.f7574a.length();     // Catch: IOException -> L10
    L12:
        r16 = r16 + r17.f7593c;     // Catch: IOException -> L10
        if (r17.a() <= r11) goto L19;
        if (r17.f7593c >= 0) goto L17;
        r17.f7593c = r17.f7592b.f7574a.length();     // Catch: IOException -> L10
    L17:
        r13 = Math.max(r17.a() - r10, r13);     // Catch: IOException -> L10
        r14 = true;
    L19:
        r12 = r18;
    L10:
        e = e;
        r5 = this;
    L42:
        NoOpCacheErrorLogger r19 = r5.f7624j;
        e.getMessage();
        r19.getClass();
        return false;
    L21:
        if (r14 == false) goto L26;
        r5 = this;
        r5.f7624j.getClass();     // Catch: IOException -> L24
    L27:
        CacheStats r20 = r5.f7625k;     // Catch: IOException -> L24
        monitor-enter(r20);     // Catch: IOException -> L24
        long r21 = r20.f7630c;     // Catch: Throwable -> L39
        monitor-exit(r20);     // Catch: Throwable -> L39
        long r22 = r15;
        if (r21 == r22) goto L34;
    L35:
        r5.f7625k.b(r16, r22);     // Catch: IOException -> L24
    L36:
        c();     // Catch: IOException -> L24
        r5.f = r10;
        return true;
    L34:
        if (r5.f7625k.a() == r16) goto L36;
    L39:
        th = move-exception;
        throw th;     // Catch: IOException -> L24
    L26:
        r5 = this;
    L24:
        e = e;
        goto L42
    }

    public final FileBinaryResource a(DiskStorage.Inserter r5, CacheKey r10, String r11) {
        Object r12 = this.f7627m;
        monitor-enter(r12);
        FileBinaryResource r13 = ((DefaultDiskStorage.InserterImpl) r5).a();     // Catch: Throwable -> L7
        this.e.add(r11);     // Catch: Throwable -> L7
        this.f7625k.a(r13.f7574a.length(), 1);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    public final FileBinaryResource a(CacheKey r5, WriterCallback r10) {
        SettableCacheEvent r11 = SettableCacheEvent.a();
        this.d.b(r11);
        Object r12 = this.f7627m;
        monitor-enter(r12);
        String r13 = CacheKeyUtil.a(r5);     // Catch: Throwable -> L35
        monitor-exit(r12);     // Catch: Throwable -> L35
        DiskStorage.Inserter r14 = a(r13, r5);     // Catch: Throwable -> L15 IOException -> L17
        DefaultDiskStorage.InserterImpl r15 = (DefaultDiskStorage.InserterImpl) r14;     // Catch: Throwable -> L21
        r15.a(r10);     // Catch: Throwable -> L21
        FileBinaryResource r16 = a(r15, r5, r13);     // Catch: Throwable -> L21
        r16.f7574a.length();     // Catch: Throwable -> L21
        this.f7625k.a();     // Catch: Throwable -> L21
        this.d.f(r11);     // Catch: Throwable -> L21
        if (r15.f7600b.exists() == true) goto L11;
    L19:
        r11.b();
        return r16;
    L11:
        if (r15.f7600b.delete() == true) goto L19;
        FLog.a(DiskStorageCache.class, "Failed to delete temp file");     // Catch: Throwable -> L15 IOException -> L17
    L21:
        th = move-exception;
        DefaultDiskStorage.InserterImpl r17 = (DefaultDiskStorage.InserterImpl) r14;     // Catch: Throwable -> L15 IOException -> L17
        if (r17.f7600b.exists() == true) goto L25;
    L28:
        throw th;     // Catch: Throwable -> L15 IOException -> L17
    L25:
        if (r17.f7600b.delete() == true) goto L28;
        FLog.a(DiskStorageCache.class, "Failed to delete temp file");     // Catch: Throwable -> L15 IOException -> L17
    L17:
        e = move-exception;
        this.d.e(r11);     // Catch: Throwable -> L15
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L32;
        FLogDefaultLoggingDelegate.a(6, "DiskStorageCache", "Failed inserting a file into the cache", e);     // Catch: Throwable -> L15
    L32:
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r11.b();
        throw th;
    L35:
        th = move-exception;
        throw th;
    }

    public final DiskStorage.Inserter a(String r10, CacheKey r11) {
        Object r5 = this.f7627m;
        monitor-enter(r5);
        boolean r12 = a();     // Catch: Throwable -> L8
        d();     // Catch: Throwable -> L8
        long r13 = this.f7625k.a();     // Catch: Throwable -> L8
        if (r13 <= this.f7621c) goto L10;
        if (r12 == true) goto L10;
        this.f7625k.b();     // Catch: Throwable -> L8
        a();     // Catch: Throwable -> L8
    L10:
        long r14 = this.f7621c;     // Catch: Throwable -> L8
        if (r13 <= r14) goto L13;
        a((r14 * 9) / 10);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r5);     // Catch: Throwable -> L8
        return ((DefaultDiskStorage) this.f7622h.a()).c(r10, r11);
    L8:
        th = move-exception;
        throw th;
    }

    public final void a(long r12) {
        ArrayList r5 = a(((DefaultDiskStorage) this.f7622h.a()).c());     // Catch: IOException -> L21
        CacheStats r10 = this.f7625k;
        monitor-enter(r10);
        long r11 = r10.f7629b;     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        long r13 = r11 - r12;
        Iterator r14 = r5.iterator();
        int r15 = 0;
        long r16 = 0;
    L9:
        if (r14.hasNext() == false) goto L16;
        DiskStorage.Entry r17 = (DiskStorage.Entry) r14.next();
        if (r16 > r13) goto L16;
        long r18 = ((DefaultDiskStorage) this.f7622h.a()).a(r17);
        DefaultDiskStorage.EntryImpl r19 = (DefaultDiskStorage.EntryImpl) r17;
        this.e.remove(r19.f7591a);
        DynamicDefaultDiskStorage r20 = this.f7622h;
        ((DefaultDiskStorage) r20.a()).c(r19.f7591a);
        if (r18 <= 0) goto L9;
        r15 = r15 + 1;
        r16 = r16 + r18;
        SettableCacheEvent r21 = SettableCacheEvent.a();
        this.d.g(r21);
        r21.b();
    L16:
        this.f7625k.a(-r16, -r15);
        this.f7622h.c();
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        e = move-exception;
        NoOpCacheErrorLogger r110 = this.f7624j;
        e.getMessage();
        r110.getClass();
        throw e;
    }

    public final ArrayList a(Collection r10) {
        this.f7626l.getClass();
        long r5 = System.currentTimeMillis() + f7617n;
        ArrayList r11 = new ArrayList(r10.size());
        ArrayList r12 = new ArrayList(r10.size());
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        DefaultDiskStorage.EntryImpl r14 = (DefaultDiskStorage.EntryImpl) ((DiskStorage.Entry) r13.next());
        if (r14.a() > r5) goto L7;
        r12.add(r14);
        goto L4
    L7:
        r11.add(r14);
        goto L4
    L9:
        this.f7623i.getClass();
        Collections.sort(r12, new DefaultEntryEvictionComparatorSupplier.AnonymousClass1());
        r11.addAll(r12);
        return r11;
    }

    public final boolean a() {
        this.f7626l.getClass();
        long r5 = System.currentTimeMillis();
        CacheStats r10 = this.f7625k;
        monitor-enter(r10);
        boolean r11 = r10.f7628a;     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        if (r11 == false) goto L15;
        long r12 = this.f;
        if (r12 == (-1)) goto L15;
        if ((r5 - r12) > f7618o) goto L15;
        return false;
    L15:
        return b();
    L16:
        th = move-exception;
        throw th;
    }

    public final void a(String r5, List r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r5.equals(((DefaultDiskStorage.EntryImpl) ((DiskStorage.Entry) r11.next())).f7591a) == false) goto L4;
        return;
    L8:
        ((DefaultDiskStorage) this.f7622h.a()).c(r5);
    }
}

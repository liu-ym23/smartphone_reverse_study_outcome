package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class DiskCacheConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Supplier f7606c;
    public final long d;
    public final long e;
    public final long f;
    public final DefaultEntryEvictionComparatorSupplier g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NoOpCacheErrorLogger f7607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final NoOpCacheEventListener f7608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f7609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f7610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Supplier f7611l;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Supplier f7613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DefaultEntryEvictionComparatorSupplier f7614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Supplier f7615c;
        public final Context d;

        public Builder(Context r5) {
            this.f7614b = new DefaultEntryEvictionComparatorSupplier();
            this.d = r5;
        }

        public final DiskCacheConfig a() {
            Supplier r5 = this.f7613a;
            if (r5 == null) goto L5;
        L8:
            boolean r10 = true;
        L9:
            if (r10 == false) goto L22;
            if (r5 != null) goto L15;
            if (this.d == null) goto L15;
            this.f7613a = new AnonymousClass1(this);
        L15:
            if (this.f7615c != null) goto L20;
            if (this.d == null) goto L20;
            this.f7615c = this.f7613a;
        L20:
            return new DiskCacheConfig(this);
        L22:
            throw new IllegalStateException("Either a non-null context or a base directory path or supplier must be provided.");
        L5:
            if (this.d != null) goto L8;
            r10 = false;
            goto L9
        }
    }

    public DiskCacheConfig(Builder r10) {
        Context r5 = r10.d;
        this.f7609j = r5;
        Supplier r11 = r10.f7613a;
        if (r11 != null) goto L7;
        if (r5 != null) goto L7;
        boolean r12 = false;
    L9:
        if (r12 == false) goto L27;
        if (r11 != null) goto L13;
        if (r5 == null) goto L13;
        r10.f7613a = new AnonymousClass1(this);
    L13:
        this.f7604a = 1;
        this.f7605b = "image_cache";
        Supplier r13 = r10.f7613a;
        r13.getClass();
        this.f7606c = r13;
        this.d = 41943040;
        this.e = 10485760;
        this.f = 2097152;
        this.g = r10.f7614b;
        monitor-enter(NoOpCacheErrorLogger.class);
    L18:
        th = move-exception;
        throw th;
    L16:
        if (NoOpCacheErrorLogger.f7577a != null) goto L20;
        NoOpCacheErrorLogger.f7577a = new NoOpCacheErrorLogger();     // Catch: Throwable -> L18
    L20:
        NoOpCacheErrorLogger r14 = NoOpCacheErrorLogger.f7577a;     // Catch: Throwable -> L18
        monitor-exit(NoOpCacheErrorLogger.class);     // Catch: Throwable -> L18
        this.f7607h = r14;
        this.f7608i = NoOpCacheEventListener.a();
        NoOpDiskTrimmableRegistry.a();
        this.f7610k = "image_config";
        this.f7611l = r10.f7615c;
        return;
    L27:
        throw new IllegalStateException("Either a non-null context or a base directory path or supplier must be provided.");
    L7:
        r12 = true;
        goto L9
    }
}

package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePipelineConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultBitmapMemoryCacheParamsSupplier f8071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitmapMemoryCacheTrimStrategy f8072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DefaultCacheKeyFactory f8073c;
    public final Context d;
    public final DiskStorageCacheFactory e;
    public final DefaultEncodedMemoryCacheParamsSupplier f;
    public final DefaultExecutorSupplier g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NoOpImageCacheStatsTracker f8074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Supplier f8075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DiskCacheConfig f8076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final NoOpMemoryTrimmableRegistry f8077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HttpUrlConnectionNetworkFetcher f8078l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PoolFactory f8079m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SimpleProgressiveJpegConfig f8080n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashSet f8081o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashSet f8082p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f8083q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DiskCacheConfig f8084r;
    public final HashMap s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImagePipelineExperiments f8085t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f8086u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final NoOpCloseableReferenceLeakTracker f8087v;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f8088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImagePipelineExperiments.Builder f8089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8090c;
        public final NoOpCloseableReferenceLeakTracker d;

        public Builder(Context r5) {
            this.f8089b = new ImagePipelineExperiments.Builder();
            this.f8090c = true;
            this.d = new NoOpCloseableReferenceLeakTracker();
            r5.getClass();
            this.f8088a = r5;
        }
    }

    public ImagePipelineConfig(Builder r5) {
        FrescoSystrace.a().getClass();
        ImagePipelineExperiments.Builder r10 = r5.f8089b;
        r10.getClass();
        this.f8085t = new ImagePipelineExperiments(r10);
        this.f8071a = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) r5.f8088a.getSystemService("activity"));
        this.f8072b = new BitmapMemoryCacheTrimStrategy();
        Bitmap.Config r11 = Bitmap.Config.ARGB_8888;
        this.f8073c = DefaultCacheKeyFactory.a();
        Context r12 = r5.f8088a;
        r12.getClass();
        this.d = r12;
        this.e = new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory());
        this.f = new DefaultEncodedMemoryCacheParamsSupplier();
        monitor-enter(NoOpImageCacheStatsTracker.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (NoOpImageCacheStatsTracker.f8039a != null) goto L9;
        NoOpImageCacheStatsTracker.f8039a = new NoOpImageCacheStatsTracker();     // Catch: Throwable -> L7
    L9:
        NoOpImageCacheStatsTracker r13 = NoOpImageCacheStatsTracker.f8039a;     // Catch: Throwable -> L7
        monitor-exit(NoOpImageCacheStatsTracker.class);     // Catch: Throwable -> L7
        this.f8074h = r13;
        this.f8075i = new AnonymousClass1();
        Context r14 = r5.f8088a;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L20
        DiskCacheConfig r15 = new DiskCacheConfig.Builder(r14).a();     // Catch: Throwable -> L20
        FrescoSystrace.a().getClass();
        this.f8076j = r15;
        this.f8077k = NoOpMemoryTrimmableRegistry.a();
        FrescoSystrace.a().getClass();
        this.f8078l = new HttpUrlConnectionNetworkFetcher();
        FrescoSystrace.a().getClass();
        PoolConfig r16 = new PoolConfig(new PoolConfig.Builder());
        this.f8079m = new PoolFactory(r16);
        this.f8080n = new SimpleProgressiveJpegConfig();
        this.f8081o = new HashSet();
        this.f8082p = new HashSet();
        this.f8083q = true;
        this.f8084r = r15;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L17
        HashMap r17 = new HashMap();     // Catch: Throwable -> L17
        FrescoSystrace.a().getClass();
        this.s = r17;
        this.g = new DefaultExecutorSupplier(r16.f8238c.d);
        this.f8086u = r5.f8090c;
        this.f8087v = r5.d;
        FrescoSystrace.a().getClass();
        return;
    L17:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    L20:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }
}

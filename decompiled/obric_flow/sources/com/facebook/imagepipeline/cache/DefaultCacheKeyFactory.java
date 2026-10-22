package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultCacheKeyFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DefaultCacheKeyFactory f8031a;

    public DefaultCacheKeyFactory() {
    }

    public static synchronized DefaultCacheKeyFactory a() {
        monitor-enter(DefaultCacheKeyFactory.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f8031a != null) goto L9;
        f8031a = new DefaultCacheKeyFactory();     // Catch: Throwable -> L7
    L9:
        DefaultCacheKeyFactory r5 = f8031a;     // Catch: Throwable -> L7
        monitor-exit(DefaultCacheKeyFactory.class);
        return r5;
    }

    public final BitmapMemoryCacheKey b(ImageRequest r10, Object r11) {
        Postprocessor r12 = r10.f8422m;
        if (r12 == null) goto L5;
        CacheKey r5 = r12.a();
        String r13 = r12.getClass().getName();
        CacheKey r14 = r5;
    L7:
        return new BitmapMemoryCacheKey(r10.f8415b.toString(), r10.g, r10.f8417h, r10.f, r14, r13, r11);
    L5:
        r14 = null;
        r13 = null;
        goto L7
    }

    public final BitmapMemoryCacheKey a(ImageRequest r10, Object r11) {
        return new BitmapMemoryCacheKey(r10.f8415b.toString(), r10.g, r10.f8417h, r10.f, null, null, r11);
    }

    public final SimpleCacheKey a(Uri r5) {
        return new SimpleCacheKey(r5.toString());
    }
}

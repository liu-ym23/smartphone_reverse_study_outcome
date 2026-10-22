package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, String>, CloseableReference<CloseableImage>> {
    public final DefaultCacheKeyFactory e;

    public BitmapMemoryCacheKeyMultiplexProducer(DefaultCacheKeyFactory r5, BitmapMemoryCacheProducer r10) {
        super(r10, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.e = r5;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final Closeable a(Closeable r5) {
        CloseableReference r10 = (CloseableReference) r5;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.b();
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final Closeable b(Closeable r5) {
        CloseableReference r10 = (CloseableReference) r5;
        if (r10 == null) goto L13;
        monitor-enter(r10);
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        if (r11 == null) goto L13;
        ((CloseableImage) r10.c()).getClass();
        return CloseableReference.a(null, CloseableReference.e, CloseableReference.f);
    L10:
        th = move-exception;
        throw th;
    L13:
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final ImageFormat c(Closeable r5) {
        CloseableReference r10 = (CloseableReference) r5;
        if (r10 == null) goto L15;
        monitor-enter(r10);
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L20;
        ImageFormat r12 = ((CloseableImage) r10.c()).f8168a;
        if (r12 == null) goto L11;
        return r12;
    L11:
        return ImageFormat.f7971c;
    L20:
        return null;
    L12:
        th = move-exception;
        throw th;
    L15:
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final Object a(ProducerContext r5) {
        BaseProducerContext r10 = (BaseProducerContext) r5;
        BitmapMemoryCacheKey r11 = this.e.a(r10.f8257a, r10.e);
        if (r10.f8257a.f8425p == true) goto L5;
        String r12 = r10.f8258b;
    L7:
        return Pair.create(r11, r12);
    L5:
        r12 = String.valueOf(r10.f.f8433a);
        goto L7
    }
}

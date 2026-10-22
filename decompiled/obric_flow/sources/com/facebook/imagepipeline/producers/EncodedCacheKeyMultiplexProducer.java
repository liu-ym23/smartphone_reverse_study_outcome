package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, String>, EncodedImage> {
    public final DefaultCacheKeyFactory e;

    public EncodedCacheKeyMultiplexProducer(DefaultCacheKeyFactory r5, Producer r10) {
        super(r10, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt");
        this.e = r5;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final Closeable a(Closeable r5) {
        return EncodedImage.a((EncodedImage) r5);
    }

    public Pair b(ProducerContext r5) {
        DefaultCacheKeyFactory r10 = this.e;
        BaseProducerContext r11 = (BaseProducerContext) r5;
        ImageRequest r12 = r11.f8257a;
        r10.getClass();
        SimpleCacheKey r13 = r10.a(r12.f8415b);
        if (r11.f8257a.f8425p == true) goto L5;
        String r14 = r11.f8258b;
    L7:
        return Pair.create(r13, r14);
    L5:
        r14 = String.valueOf(r11.f.f8433a);
        goto L7
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final ImageFormat c(Closeable r5) {
        EncodedImage r10 = (EncodedImage) r5;
        if (r10 == null) goto L6;
        r10.g();
        return r10.f8178b;
    L6:
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ Object a(ProducerContext r5) {
        return b(r5);
    }
}

package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import h.f;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class DiskCacheReadProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedDiskCache f8288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache f8289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f8290c;
    public final DefaultCacheKeyFactory d;
    public final Producer e;

    public DiskCacheReadProducer(BufferedDiskCache r5, BufferedDiskCache r10, HashMap r11, DefaultCacheKeyFactory r12, Producer r13, PooledByteBufferFactory r14) {
        this.f8288a = r5;
        this.f8289b = r10;
        this.f8290c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(final Consumer r10, final ProducerContext r11) {
        BaseProducerContext r5 = (BaseProducerContext) r11;
        ImageRequest r12 = r5.f8257a;
        BufferedDiskCache r13 = null;
        boolean r14 = true;
        if (a(r11) == false) goto L5;
        r5.f8259c.a(r11, "DiskCacheProducer");
        DefaultCacheKeyFactory r15 = this.d;
        r15.getClass();
        SimpleCacheKey r16 = r15.a(r12.f8415b);
        r5.f8259c.a(r11, "DiskCacheProducer");
        ImageRequest.CacheChoice r17 = r12.f8414a;
        if (r17 != ImageRequest.CacheChoice.f8429b) goto L13;
        boolean r18 = true;
    L15:
        if (r17 == ImageRequest.CacheChoice.f8428a) goto L18;
        r14 = false;
    L18:
        if (r14 == false) goto L20;
        r13 = (BufferedDiskCache) this.f8290c.get(r12.f8424o);
    L20:
        if (r13 != null) goto L24;
        if (r18 == false) goto L23;
        r13 = this.f8289b;
        goto L24
    L23:
        r13 = this.f8288a;
    L24:
        final AtomicBoolean r19 = new AtomicBoolean(false);
        f r20 = r13.a(r16, r19);
        final InternalRequestListener r21 = r5.f8259c;
        r20.a(new AnonymousClass1(this, r21, r11, r10));
        r5.a(new AnonymousClass2(r19));
        return;
    L13:
        r18 = false;
        goto L15
    L5:
        if (r5.f.f8433a < 2) goto L8;
        r5.a("disk", "nil-result_read");
        ((BaseConsumer) r10).a(null, 1);
        return;
    L8:
        this.e.a(r10, r11);
    }

    public boolean a(ProducerContext r5) {
        return ((BaseProducerContext) r5).f8257a.f8420k;
    }
}

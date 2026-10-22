package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InstrumentedMemoryCache f8301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DefaultCacheKeyFactory f8302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Producer f8303c;

    public static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InstrumentedMemoryCache f8304c;
        public final SimpleCacheKey d;
        public final boolean e;
        public final boolean f;

        public EncodedMemoryCacheConsumer(Consumer r5, InstrumentedMemoryCache r10, SimpleCacheKey r11, boolean r12, boolean r13) {
            super(r5);
            this.f8304c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            EncodedImage r11 = (EncodedImage) r5;
            FrescoSystrace.a().getClass();     // Catch: Throwable -> L16
            if (BaseConsumer.a(r10) == false) goto L47;
            if (r11 == null) goto L47;
            if ((r10 & 10) != 0) goto L47;
            r11.g();     // Catch: Throwable -> L16
            if (r11.f8178b == ImageFormat.f7971c) goto L47;
            CloseableReference r12 = r11.f8177a;     // Catch: Throwable -> L16
            CloseableReference r13 = null;
            if (r12 == null) goto L18;
            CloseableReference r14 = r12.b();     // Catch: Throwable -> L16
        L19:
            if (r14 != null) goto L54;
        L44:
            ((BaseConsumer) this.f8287b).a(r11, r10);     // Catch: Throwable -> L16
            FrescoSystrace.a().getClass();
            return;
        L54:
        L26:
            th = move-exception;
            r14.close();     // Catch: Throwable -> L16
            throw th;     // Catch: Throwable -> L16
        L21:
            if (this.f == true) goto L23;
        L28:
            r14.close();     // Catch: Throwable -> L16
            if (r13 == null) goto L44;
            EncodedImage r15 = new EncodedImage(r13);     // Catch: Throwable -> L39
            r15.b(r11);     // Catch: Throwable -> L39
            r13.close();     // Catch: Throwable -> L16
            ((BaseConsumer) this.f8287b).a(1.0f);     // Catch: Throwable -> L36
            ((BaseConsumer) this.f8287b).a(r15, r10);     // Catch: Throwable -> L36
            r15.close();     // Catch: Throwable -> L16
            FrescoSystrace.a().getClass();
            return;
        L36:
            th = move-exception;
            r15.close();     // Catch: Throwable -> L16
            throw th;     // Catch: Throwable -> L16
        L39:
            th = move-exception;
            r13.close();     // Catch: Throwable -> L16
            throw th;     // Catch: Throwable -> L16
        L23:
            if (this.e == false) goto L28;
            InstrumentedMemoryCache r16 = this.f8304c;     // Catch: Throwable -> L26
            SimpleCacheKey r17 = this.d;     // Catch: Throwable -> L26
            r16.f8035b.b(r17);     // Catch: Throwable -> L26
            r13 = r16.f8034a.a(r17, r14);     // Catch: Throwable -> L26
        L18:
            r14 = null;
        L47:
            ((BaseConsumer) this.f8287b).a(r11, r10);     // Catch: Throwable -> L16
            FrescoSystrace.a().getClass();
            return;
        L16:
            th = move-exception;
            FrescoSystrace.a().getClass();
            throw th;
        }
    }

    public EncodedMemoryCacheProducer(InstrumentedMemoryCache r5, DefaultCacheKeyFactory r10, Producer r11) {
        this.f8301a = r5;
        this.f8302b = r10;
        this.f8303c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r14, ProducerContext r15) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L17
        InternalRequestListener r5 = ((BaseProducerContext) r15).f8259c;     // Catch: Throwable -> L17
        r5.a(r15, "EncodedMemoryCacheProducer");     // Catch: Throwable -> L17
        ImageRequest r10 = ((BaseProducerContext) r15).f8257a;     // Catch: Throwable -> L17
        DefaultCacheKeyFactory r11 = this.f8302b;     // Catch: Throwable -> L17
        Object r12 = ((BaseProducerContext) r15).e;     // Catch: Throwable -> L17
        r11.getClass();     // Catch: Throwable -> L17
        SimpleCacheKey r13 = r11.a(r10.f8415b);     // Catch: Throwable -> L17
        CloseableReference r16 = this.f8301a.a(r13);     // Catch: Throwable -> L17
        Map r17 = null;
        if (r16 == null) goto L25;
        EncodedImage r18 = new EncodedImage(r16);     // Catch: Throwable -> L19
    L10:
        th = move-exception;
        r18.close();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L8:
        if (r5.b(r15, "EncodedMemoryCacheProducer") == false) goto L12;
        r17 = ImmutableMap.a("cached_value_found", "true");     // Catch: Throwable -> L10
    L12:
        r5.a(r15, "EncodedMemoryCacheProducer", r17);     // Catch: Throwable -> L10
        r5.a(r15, "EncodedMemoryCacheProducer", true);     // Catch: Throwable -> L10
        ((BaseProducerContext) r15).a("memory_encoded", "default");     // Catch: Throwable -> L10
        BaseConsumer r19 = (BaseConsumer) r14;     // Catch: Throwable -> L10
        r19.a(1.0f);     // Catch: Throwable -> L10
        r19.a(r18, 1);     // Catch: Throwable -> L10
        r18.close();     // Catch: Throwable -> L19
        r16.close();     // Catch: Throwable -> L17
        FrescoSystrace.a().getClass();
        return;
    L25:
        if (((BaseProducerContext) r15).f.f8433a >= 3) goto L27;
        EncodedMemoryCacheConsumer r20 = new EncodedMemoryCacheConsumer(r14, this.f8301a, r13, ((BaseProducerContext) r15).f8257a.f8421l, ((BaseProducerContext) r15).f8265m.f8085t.f8093c);     // Catch: Throwable -> L19
        if (r5.b(r15, "EncodedMemoryCacheProducer") == false) goto L38;
        r17 = ImmutableMap.a("cached_value_found", "false");     // Catch: Throwable -> L19
    L38:
        r5.a(r15, "EncodedMemoryCacheProducer", r17);     // Catch: Throwable -> L19
        this.f8303c.a(r20, r15);     // Catch: Throwable -> L19
        if (r16 == null) goto L41;
        r16.close();     // Catch: Throwable -> L17
    L41:
        FrescoSystrace.a().getClass();
        return;
    L27:
        if (r5.b(r15, "EncodedMemoryCacheProducer") == false) goto L29;
        Map r110 = ImmutableMap.a("cached_value_found", "false");     // Catch: Throwable -> L19
    L30:
        r5.a(r15, "EncodedMemoryCacheProducer", r110);     // Catch: Throwable -> L19
        r5.a(r15, "EncodedMemoryCacheProducer", false);     // Catch: Throwable -> L19
        ((BaseProducerContext) r15).a("memory_encoded", "nil-result");     // Catch: Throwable -> L19
        ((BaseConsumer) r14).a(null, 1);     // Catch: Throwable -> L19
        if (r16 == null) goto L33;
        r16.close();     // Catch: Throwable -> L17
    L33:
        FrescoSystrace.a().getClass();
        return;
    L29:
        r110 = null;
    L19:
        th = move-exception;
        if (r16 == null) goto L45;
        r16.close();     // Catch: Throwable -> L17
    L45:
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }
}

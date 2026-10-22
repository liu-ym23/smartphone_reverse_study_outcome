package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InstrumentedMemoryCache f8365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DefaultCacheKeyFactory f8366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PostprocessorProducer f8367c;

    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BitmapMemoryCacheKey f8368c;
        public final InstrumentedMemoryCache d;
        public final boolean e;

        public CachedPostprocessorConsumer(Consumer r5, BitmapMemoryCacheKey r10, InstrumentedMemoryCache r11, boolean r12) {
            super(r5);
            this.f8368c = r10;
            this.d = r11;
            this.e = r12;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            CloseableReference r11 = (CloseableReference) r5;
            CloseableReference r12 = null;
            if (r11 != null) goto L9;
            if (BaseConsumer.a(r10) == false) goto L27;
            ((BaseConsumer) this.f8287b).a(null, r10);
            return;
        L27:
            return;
        L9:
            if (BaseConsumer.a(r10) == true) goto L12;
            return;
        L12:
            if (this.e == false) goto L25;
            InstrumentedMemoryCache r13 = this.d;
            BitmapMemoryCacheKey r14 = this.f8368c;
            r13.f8035b.b(r14);
            r12 = r13.f8034a.a(r14, r11);
        L25:
            ((BaseConsumer) this.f8287b).a(1.0f);     // Catch: Throwable -> L21
            Consumer r15 = this.f8287b;     // Catch: Throwable -> L21
            if (r12 == null) goto L17;
            r11 = r12;
        L17:
            ((BaseConsumer) r15).a(r11, r10);     // Catch: Throwable -> L21
            if (r12 == null) goto L28;
            r12.close();
            return;
        L28:
            return;
        L21:
            th = move-exception;
            if (r12 == null) goto L24;
            r12.close();
        L24:
            throw th;
        }
    }

    public PostprocessedBitmapMemoryCacheProducer(InstrumentedMemoryCache r5, DefaultCacheKeyFactory r10, PostprocessorProducer r11) {
        this.f8365a = r5;
        this.f8366b = r10;
        this.f8367c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r10, ProducerContext r11) {
        BaseProducerContext r5 = (BaseProducerContext) r11;
        InternalRequestListener r12 = r5.f8259c;
        ImageRequest r13 = r5.f8257a;
        Object r14 = r5.e;
        Postprocessor r15 = r13.f8422m;
        if (r15 != null) goto L5;
    L19:
        this.f8367c.a(r10, r11);
        return;
    L5:
        if (r15.a() == null) goto L19;
        r12.a(r11, "PostprocessedBitmapMemoryCacheProducer");
        BitmapMemoryCacheKey r16 = this.f8366b.b(r13, r14);
        CloseableReference r17 = this.f8365a.a(r16);
        Map r18 = null;
        if (r17 != null) goto L10;
        boolean r19 = r5.f8257a.f8421l;
        CachedPostprocessorConsumer r20 = new CachedPostprocessorConsumer(r10, r16, this.f8365a, r19);
        if (r12.b(r11, "PostprocessedBitmapMemoryCacheProducer") == false) goto L17;
        r18 = ImmutableMap.a("cached_value_found", "false");
    L17:
        r12.a(r11, "PostprocessedBitmapMemoryCacheProducer", r18);
        this.f8367c.a(r20, r11);
        return;
    L10:
        if (r12.b(r11, "PostprocessedBitmapMemoryCacheProducer") == false) goto L12;
        r18 = ImmutableMap.a("cached_value_found", "true");
    L12:
        r12.a(r11, "PostprocessedBitmapMemoryCacheProducer", r18);
        r12.a(r11, "PostprocessedBitmapMemoryCacheProducer", true);
        r5.a("memory_bitmap", "postprocessed");
        BaseConsumer r21 = (BaseConsumer) r10;
        r21.a(1.0f);
        r21.a(r17, 1);
        r17.close();
    }
}

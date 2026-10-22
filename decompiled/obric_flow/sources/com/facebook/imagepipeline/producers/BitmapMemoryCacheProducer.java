package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.HasImageMetadata;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InstrumentedMemoryCache f8266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DefaultCacheKeyFactory f8267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Producer f8268c;

    public BitmapMemoryCacheProducer(InstrumentedMemoryCache r5, DefaultCacheKeyFactory r10, Producer r11) {
        this.f8266a = r5;
        this.f8267b = r10;
        this.f8268c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r11, ProducerContext r12) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L14
        InternalRequestListener r5 = ((BaseProducerContext) r12).f8259c;     // Catch: Throwable -> L14
        r5.a(r12, b());     // Catch: Throwable -> L14
        BitmapMemoryCacheKey r10 = this.f8267b.a(((BaseProducerContext) r12).f8257a, ((BaseProducerContext) r12).e);     // Catch: Throwable -> L14
        CloseableReference r13 = this.f8266a.a(r10);     // Catch: Throwable -> L14
        Map r14 = null;
        if (r13 == null) goto L34;
        monitor-enter(r13);     // Catch: Throwable -> L14
        Object r15 = r13.f7671b.d();     // Catch: Throwable -> L30
        monitor-exit(r13);     // Catch: Throwable -> L30
        HashMap r16 = ((CloseableImage) ((HasImageMetadata) r15)).f8169b;     // Catch: Throwable -> L14
        BaseProducerContext r17 = (BaseProducerContext) r12;     // Catch: Throwable -> L14
        r17.getClass();     // Catch: Throwable -> L14
        if (r16 == null) goto L17;
        Iterator r18 = r16.entrySet().iterator();     // Catch: Throwable -> L14
    L12:
        if (r18.hasNext() == false) goto L17;
        Map.Entry r19 = (Map.Entry) r18.next();     // Catch: Throwable -> L14
        r17.a((String) r19.getKey(), r19.getValue());     // Catch: Throwable -> L14
    L17:
        if (((ImmutableQualityInfo) ((CloseableImage) r13.c()).c()).f8193c == false) goto L19;
        ((CloseableImage) r13.c()).getClass();     // Catch: Throwable -> L14
        int r20 = 1;
    L20:
        if (r20 == 0) goto L26;
        String r21 = b();     // Catch: Throwable -> L14
        if (r5.b(r12, b()) == false) goto L24;
        Map r22 = ImmutableMap.a("cached_value_found", "true");     // Catch: Throwable -> L14
    L25:
        r5.a(r12, r21, r22);     // Catch: Throwable -> L14
        r5.a(r12, b(), true);     // Catch: Throwable -> L14
        ((BaseProducerContext) r12).a("memory_bitmap", a());     // Catch: Throwable -> L14
        ((BaseConsumer) r11).a(1.0f);     // Catch: Throwable -> L14
        goto L26
    L24:
        r22 = null;
    L26:
        ((BaseConsumer) r11).a(r13, r20);     // Catch: Throwable -> L14
        r13.close();     // Catch: Throwable -> L14
        if (r20 == 0) goto L34;
        FrescoSystrace.a().getClass();
        return;
    L19:
        r20 = 0;
        goto L20
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L34:
        if (((BaseProducerContext) r12).f.f8433a < 4) goto L42;
        String r23 = b();     // Catch: Throwable -> L14
        if (r5.b(r12, b()) == false) goto L38;
        Map r24 = ImmutableMap.a("cached_value_found", "false");     // Catch: Throwable -> L14
    L39:
        r5.a(r12, r23, r24);     // Catch: Throwable -> L14
        r5.a(r12, b(), false);     // Catch: Throwable -> L14
        ((BaseProducerContext) r12).a("memory_bitmap", a());     // Catch: Throwable -> L14
        ((BaseConsumer) r11).a(null, 1);     // Catch: Throwable -> L14
        FrescoSystrace.a().getClass();
        return;
    L38:
        r24 = null;
        goto L39
    L42:
        Consumer r110 = a(r11, r10, ((BaseProducerContext) r12).f8257a.f8421l);     // Catch: Throwable -> L14
        String r25 = b();     // Catch: Throwable -> L14
        if (r5.b(r12, b()) == false) goto L45;
        r14 = ImmutableMap.a("cached_value_found", "false");     // Catch: Throwable -> L14
    L45:
        r5.a(r12, r25, r14);     // Catch: Throwable -> L14
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L14
        this.f8268c.a(r110, r12);     // Catch: Throwable -> L14
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L14
        FrescoSystrace.a().getClass();
        return;
    L14:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public String b() {
        return "BitmapMemoryCacheProducer";
    }

    public Consumer a(final Consumer r5, final BitmapMemoryCacheKey r10, final boolean r11) {
        return new AnonymousClass1(this, r5, r10, r11);
    }

    public String a() {
        return "pipe_bg";
    }
}

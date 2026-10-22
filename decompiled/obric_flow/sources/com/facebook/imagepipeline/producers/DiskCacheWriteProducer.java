package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DiskCacheWriteProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedDiskCache f8295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache f8296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f8297c;
    public final DefaultCacheKeyFactory d;
    public final Producer e;
    public final PooledByteBufferFactory f;

    public static class DiskCacheWriteConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ProducerContext f8298c;
        public final BufferedDiskCache d;
        public final BufferedDiskCache e;
        public final HashMap f;
        public final DefaultCacheKeyFactory g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f8299h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f8300i;

        public DiskCacheWriteConsumer(Consumer r5, ProducerContext r10, BufferedDiskCache r11, BufferedDiskCache r12, HashMap r13, DefaultCacheKeyFactory r14, boolean r15, PooledByteBufferFactory r16) {
            super(r5);
            this.f8298c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            this.g = r14;
            this.f8299h = r15;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r10, int r11) {
            EncodedImage r12 = (EncodedImage) r10;
            ProducerContext r5 = this.f8298c;
            ((BaseProducerContext) r5).f8259c.a(r5, "DiskCacheWriteProducer");
            Map r13 = null;
            if (BaseConsumer.a(r11) == false) goto L46;
            if (r12 == null) goto L46;
            if ((r11 & 10) != 0) goto L46;
            ProducerContext r14 = this.f8298c;
            ((BaseProducerContext) r14).f8259c.a(r14, "DiskCacheWriteProducer");
            r12.g();
            this.f8300i = r12.f8178b.f7973b;
            ForwardingRequestListener r15 = ((BaseProducerContext) this.f8298c).d;
            r12.c();
            int r16 = r15.f8194a.size();
            int r17 = 0;
        L9:
            if (r17 >= r16) goto L48;
            r15.f8194a.get(r17);
            r17 = r17 + 1;
            goto L9
        L48:
            r12.g();     // Catch: Throwable -> L16
            this.f8300i = r12.f8178b.f7973b;     // Catch: Throwable -> L16
            r12.g();     // Catch: Throwable -> L16
            if (r12.f8178b != ImageFormat.f7971c) goto L20;
            ((BaseConsumer) this.f8287b).a(r12, r11);     // Catch: Throwable -> L16
            r12.close();
            return;
        L20:
            if (this.f8299h == true) goto L28;
            ProducerContext r18 = this.f8298c;     // Catch: Throwable -> L16
            InternalRequestListener r19 = ((BaseProducerContext) r18).f8259c;     // Catch: Throwable -> L16
            InternalRequestListener r20 = ((BaseProducerContext) r18).f8259c;     // Catch: Throwable -> L16
            String r21 = this.f8300i;     // Catch: Throwable -> L16
            if (r19.b(r18, "DiskCacheWriteProducer") == false) goto L25;
            r13 = ImmutableMap.a("imageType", r21);     // Catch: Throwable -> L16
        L25:
            r20.a(r18, "DiskCacheWriteProducer", r13);     // Catch: Throwable -> L16
            ((BaseConsumer) this.f8287b).a(r12, r11);     // Catch: Throwable -> L16
            r12.close();
            return;
        L28:
            ProducerContext r22 = this.f8298c;     // Catch: Throwable -> L16
            ImageRequest r23 = ((BaseProducerContext) r22).f8257a;     // Catch: Throwable -> L16
            DefaultCacheKeyFactory r24 = this.g;     // Catch: Throwable -> L16
            Object r25 = ((BaseProducerContext) r22).e;     // Catch: Throwable -> L16
            r24.getClass();     // Catch: Throwable -> L16
            SimpleCacheKey r26 = r24.a(r23.f8415b);     // Catch: Throwable -> L16
            ImageRequest.CacheChoice r27 = r23.f8414a;     // Catch: Throwable -> L16
            if (r27 != ImageRequest.CacheChoice.f8429b) goto L32;
            this.e.b(r26, r12);     // Catch: Throwable -> L16
        L37:
            ProducerContext r28 = this.f8298c;     // Catch: Throwable -> L16
            InternalRequestListener r29 = ((BaseProducerContext) r28).f8259c;     // Catch: Throwable -> L16
            InternalRequestListener r30 = ((BaseProducerContext) r28).f8259c;     // Catch: Throwable -> L16
            String r31 = this.f8300i;     // Catch: Throwable -> L16
            if (r29.b(r28, "DiskCacheWriteProducer") == false) goto L41;
            r13 = ImmutableMap.a("imageType", r31);     // Catch: Throwable -> L16
        L41:
            r30.a(r28, "DiskCacheWriteProducer", r13);     // Catch: Throwable -> L16
            ((BaseConsumer) this.f8287b).a(r12, r11);     // Catch: Throwable -> L16
            r12.close();
            return;
        L32:
            if (r27 != ImageRequest.CacheChoice.f8428a) goto L36;
            BufferedDiskCache r32 = (BufferedDiskCache) this.f.get(r23.f8424o);     // Catch: Throwable -> L16
            if (r32 == null) goto L37;
            r32.b(r26, r12);     // Catch: Throwable -> L16
            goto L37
        L36:
            this.d.b(r26, r12);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            r12.close();
            throw th;
        L46:
            ProducerContext r33 = this.f8298c;
            ((BaseProducerContext) r33).f8259c.a(r33, "DiskCacheWriteProducer", null);
            ((BaseConsumer) this.f8287b).a(r12, r11);
        }
    }

    public DiskCacheWriteProducer(BufferedDiskCache r5, BufferedDiskCache r10, HashMap r11, DefaultCacheKeyFactory r12, Producer r13, PooledByteBufferFactory r14) {
        this.f8295a = r5;
        this.f8296b = r10;
        this.f8297c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r11, ProducerContext r12) {
        BaseProducerContext r5 = (BaseProducerContext) r12;
        if (r5.f.f8433a < 2) goto L6;
        r5.a("disk", "nil-result_write");
        ((BaseConsumer) r11).a(null, 1);
        return;
    L6:
        boolean r10 = r5.f8257a.f8420k;
        if (r10 == false) goto L9;
        r11 = new DiskCacheWriteConsumer(r11, r12, this.f8295a, this.f8296b, this.f8297c, this.d, r10, this.f);
    L9:
        this.e.a(r11, r12);
    }
}

package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferFactory;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkFetchProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PooledByteBufferFactory f8360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteArrayPool f8361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpUrlConnectionNetworkFetcher f8362c;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.NetworkFetchProducer$1, reason: invalid class name */
    class AnonymousClass1 implements NetworkFetcher$Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState f8363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NetworkFetchProducer f8364b;

        public AnonymousClass1(NetworkFetchProducer r5, HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState r10) {
            this.f8364b = r5;
            this.f8363a = r10;
        }

        public final void a(IOException r5) {
            NetworkFetchProducer r10 = this.f8364b;
            HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState r11 = this.f8363a;
            HashMap r12 = r10.a(r11, -1);
            if (r12 != null) goto L6;
            r12 = new HashMap(1);
        L6:
            if (r10.f8362c != null) goto L8;
            String r13 = "null";
        L9:
            r12.put("NetworkFetcher", r13);
            ((InternalProducerListener) r11.a()).a(r11.f8306b, "NetworkFetchProducer", r5, r12);
            ((InternalProducerListener) r11.a()).a(r11.f8306b, "NetworkFetchProducer", false);
            ((BaseProducerContext) r11.f8306b).a("network", "default");
            ((BaseConsumer) r11.f8305a).a(r5);
            return;
        L8:
            r13 = r10.f8362c.getClass().getName() + ", " + r10.f8362c.toString();
            goto L9
        }

        public final void a(InputStream r10) {
            FrescoSystrace.a().getClass();
            NetworkFetchProducer r5 = this.f8364b;
            HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState r11 = this.f8363a;
            r5.getClass();
            ImageRequest r12 = ((BaseProducerContext) r11.f8306b).f8257a;
            ImageRequest.CacheChoice r13 = r12.f8414a;
            if (r13 != ImageRequest.CacheChoice.f8429b) goto L6;
            ((ImagePipelineFactory) Preconditions.a(ImagePipelineFactory.f8097u, "ImagePipelineFactory was not initialized!")).i().getClass();
        L10:
            if ("http".equals(((BaseProducerContext) r11.f8306b).f8257a.f8415b.getScheme()) == true) goto L37;
        L14:
            MessageDigest r14 = null;
        L15:
            MemoryPooledByteBufferFactory r15 = (MemoryPooledByteBufferFactory) r5.f8360a;
            r15.getClass();
            MemoryPooledByteBufferOutputStream r16 = new MemoryPooledByteBufferOutputStream(r15.f8231b);
            byte[] r17 = (byte[]) ((BasePool) r5.f8361b).get(16384);
        L35:
            int r18 = r10.read(r17);     // Catch: Throwable -> L22
            int r19 = 0;
            if (r18 < 0) goto L25;
            if (r18 <= 0) goto L35;
            r16.write(r17, 0, r18);     // Catch: Throwable -> L22
            if (r14 == null) goto L24;
            r14.update(r17, 0, r18);     // Catch: Throwable -> L22
        L24:
            r5.b(r16, r11);     // Catch: Throwable -> L22
            float r20 = 1.0f - ((float) Math.exp(((double) (-r16.f8234c)) / 50000.0d));     // Catch: Throwable -> L22
            ((BaseConsumer) r11.f8305a).a(r20);     // Catch: Throwable -> L22
            goto L35
        L25:
            if (r14 == null) goto L29;
            byte[] r21 = r14.digest();     // Catch: Throwable -> L22
            int r22 = r21.length;     // Catch: Throwable -> L22
        L27:
            if (r19 >= r22) goto L29;
            Integer.toHexString(r21[r19] & UByte.MAX_VALUE);     // Catch: Throwable -> L22
            r19 = r19 + 1;     // Catch: Throwable -> L22
        L29:
            HttpUrlConnectionNetworkFetcher r23 = r5.f8362c;     // Catch: Throwable -> L22
            r23.getClass();     // Catch: Throwable -> L22
            r11.f = r23.f8310c.now();     // Catch: Throwable -> L22
            r5.a(r16, r11);     // Catch: Throwable -> L22
            ((BasePool) r5.f8361b).release(r17);
            r16.close();
            FrescoSystrace.a().getClass();
            return;
        L22:
            th = move-exception;
            ((BasePool) r5.f8361b).release(r17);
            r16.close();
            throw th;
        L37:
            r14 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L34
        L6:
            if (r13 != ImageRequest.CacheChoice.f8428a) goto L8;
            ((BufferedDiskCache) ((ImagePipelineFactory) Preconditions.a(ImagePipelineFactory.f8097u, "ImagePipelineFactory was not initialized!")).d().get(r12.f8424o)).getClass();
            goto L10
        L8:
            ((ImagePipelineFactory) Preconditions.a(ImagePipelineFactory.f8097u, "ImagePipelineFactory was not initialized!")).f().getClass();
            goto L10
        }
    }

    public NetworkFetchProducer(PooledByteBufferFactory r5, ByteArrayPool r10, HttpUrlConnectionNetworkFetcher r11) {
        this.f8360a = r5;
        this.f8361b = r10;
        this.f8362c = r11;
    }

    public static void a(MemoryPooledByteBufferOutputStream r5, int r10, Consumer r11, Map r12) {
        DefaultCloseableReference r13 = CloseableReference.a(r5.b(), CloseableReference.e, CloseableReference.f);
        EncodedImage r14 = new EncodedImage(r13);     // Catch: Throwable -> L9
        r14.a(r12);     // Catch: Throwable -> L7
        r14.f();     // Catch: Throwable -> L7
        r14.f8186n = false;     // Catch: Throwable -> L7
        r14.f8185m = false;     // Catch: Throwable -> L7
        ((BaseConsumer) r11).a(r14, r10);     // Catch: Throwable -> L7
        r14.close();
        r13.close();
        return;
    L7:
        th = th;
    L11:
        if (r14 == null) goto L13;
        r14.close();
    L13:
        if (r13 == null) goto L15;
        r13.close();
    L15:
        throw th;
    L9:
        th = th;
        r14 = null;
        goto L11
    }

    public final void b(MemoryPooledByteBufferOutputStream r10, HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState r11) {
        long r5 = SystemClock.uptimeMillis();
        BaseProducerContext r12 = (BaseProducerContext) r11.f8306b;
        ImageRequest r13 = r12.f8257a;
        monitor-enter(r12);
        boolean r14 = r12.f8262j;     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
        if (r14 == false) goto L22;
        this.f8362c.getClass();
        long r15 = r5 - r11.f8307c;
        if (r13.f8427r == false) goto L11;
        long r16 = 10;
    L13:
        if (r15 < r16) goto L21;
        r11.f8307c = r5;
        ProducerListener2 r17 = r11.a();
        InternalProducerListener r18 = (InternalProducerListener) r17;
        r18.b(r11.f8306b);
        a(r10, 0, r11.f8305a, null);
        return;
    L21:
        return;
    L11:
        r16 = 100;
        goto L13
    L22:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r5, ProducerContext r10) {
        BaseProducerContext r11 = (BaseProducerContext) r10;
        r11.f8259c.a(r10, "NetworkFetchProducer");
        this.f8362c.getClass();
        final HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState r12 = new HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState(r5, r10);
        final HttpUrlConnectionNetworkFetcher r13 = this.f8362c;
        final AnonymousClass1 r14 = new AnonymousClass1(this, r12);
        r13.getClass();
        r12.d = r13.f8310c.now();
        final Future<?> r15 = r13.f8309b.submit(new HttpUrlConnectionNetworkFetcher.AnonymousClass1(r13, r12, r14));
        r11.a(new HttpUrlConnectionNetworkFetcher.AnonymousClass2(r15, r14));
    }

    public final void a(MemoryPooledByteBufferOutputStream r5, HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState r10) {
        HashMap r11 = a(r10, r5.f8234c);
        ProducerListener2 r12 = r10.a();
        InternalProducerListener r13 = (InternalProducerListener) r12;
        r13.a(r10.f8306b, "NetworkFetchProducer", r11);
        r13.a(r10.f8306b, "NetworkFetchProducer", true);
        ((BaseProducerContext) r10.f8306b).a("network", "default");
        a(r5, 1, r10.f8305a, null);
    }

    public final HashMap a(HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState r5, int r10) {
        ProducerListener2 r11 = r5.a();
        InternalProducerListener r12 = (InternalProducerListener) r11;
        if (r12.b(r5.f8306b, "NetworkFetchProducer") == true) goto L6;
        return null;
    L6:
        this.f8362c.getClass();
        HashMap r13 = new HashMap(4);
        r13.put("queue_time", Long.toString(r5.e - r5.d));
        r13.put("fetch_time", Long.toString(r5.f - r5.e));
        r13.put(ICronetClient.KEY_TOTAL_TIME, Long.toString(r5.f - r5.d));
        r13.put("image_size", Integer.toString(r10));
        return r13;
    }
}

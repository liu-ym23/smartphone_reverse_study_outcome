package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBuffer;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferFactory;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LocalFetchProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f8338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f8339b;

    public LocalFetchProducer(ExecutorService r5, PooledByteBufferFactory r10) {
        this.f8338a = r5;
        this.f8339b = r10;
    }

    public abstract EncodedImage a(ImageRequest r5);

    public abstract String a();

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(final Consumer r12, final ProducerContext r13) {
        BaseProducerContext r5 = (BaseProducerContext) r13;
        final InternalRequestListener r10 = r5.f8259c;
        final ImageRequest r11 = r5.f8257a;
        r5.a("local", "fetch");
        final String r14 = a();
        final StatefulProducerRunnable<EncodedImage> r15 = new AnonymousClass1(this, r12, r10, r13, r14, r11, r10, r13);
        r5.a(new AnonymousClass2(r15));
        this.f8338a.execute(r15);
    }

    public final EncodedImage a(InputStream r5, int r10) {
        AutoCloseable r11 = null;
        if (r10 > 0) goto L13;
        MemoryPooledByteBufferFactory r12 = (MemoryPooledByteBufferFactory) this.f8339b;     // Catch: Throwable -> L8
        r12.getClass();     // Catch: Throwable -> L8
        MemoryPooledByteBufferOutputStream r13 = new MemoryPooledByteBufferOutputStream(r12.f8231b);     // Catch: Throwable -> L8
        r12.f8230a.a(r5, r13);     // Catch: Throwable -> L10
        MemoryPooledByteBuffer r14 = r13.b();     // Catch: Throwable -> L10
        r13.close();     // Catch: Throwable -> L8
        DefaultCloseableReference r15 = CloseableReference.a(r14, CloseableReference.e, CloseableReference.f);     // Catch: Throwable -> L8
    L7:
        DefaultCloseableReference r16 = r15;
        EncodedImage r17 = new EncodedImage(r16);     // Catch: Throwable -> L8
        Closeables.a(r5);
        r16.close();
        return r17;
    L10:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L13:
        MemoryPooledByteBufferFactory r18 = (MemoryPooledByteBufferFactory) this.f8339b;     // Catch: Throwable -> L8
        r18.getClass();     // Catch: Throwable -> L8
        MemoryPooledByteBufferOutputStream r19 = new MemoryPooledByteBufferOutputStream(r18.f8231b, r10);     // Catch: Throwable -> L8
        r18.f8230a.a(r5, r19);     // Catch: Throwable -> L19
        MemoryPooledByteBuffer r20 = r19.b();     // Catch: Throwable -> L19
        r19.close();     // Catch: Throwable -> L8
        r15 = CloseableReference.a(r20, CloseableReference.e, CloseableReference.f);     // Catch: Throwable -> L8
        goto L7
    L19:
        th = move-exception;
        r19.close();     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Closeables.a(r5);
        if (0 == 0) goto L25;
        r11.close();
    L25:
        throw th;
    }
}

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class WebpTranscodeProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f8408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f8409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Producer f8410c;

    public class WebpTranscodeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ProducerContext f8411c;
        public TriState d;
        public final /* synthetic */ WebpTranscodeProducer e;

        public WebpTranscodeConsumer(WebpTranscodeProducer r5, Consumer r10, ProducerContext r11) {
            this.e = r5;
            super(r10);
            this.f8411c = r11;
            this.d = TriState.f7698c;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r10, int r11) {
            EncodedImage r12 = (EncodedImage) r10;
            TriState r5 = this.d;
            TriState r13 = TriState.f7698c;
            if (r5 != r13) goto L19;
            if (r12 == null) goto L19;
            ImageFormat r14 = ImageFormatChecker.a(r12.c());     // Catch: IOException -> L15
            if (DefaultImageFormats.b(r14) == false) goto L11;
            int r15 = WebpTranscoderFactory.f8250a;
            r13 = TriState.f7697b;
        L14:
            this.d = r13;
            goto L19
        L11:
            if (r14 == ImageFormat.f7971c) goto L14;
            r13 = TriState.f7697b;
        L15:
            e = move-exception;
            Throwables.a(e, Error.class);
            Throwables.a(e, RuntimeException.class);
            throw new RuntimeException(e);
        L19:
            if (this.d != TriState.f7697b) goto L23;
            ((BaseConsumer) this.f8287b).a(r12, r11);
            return;
        L23:
            if (BaseConsumer.a(r11) == true) goto L25;
            return;
        L25:
            if (this.d != TriState.f7696a) goto L36;
            if (r12 == null) goto L36;
            final WebpTranscodeProducer r16 = this.e;
            final Consumer r17 = this.f8287b;
            final ProducerContext r18 = this.f8411c;
            r16.getClass();
            final EncodedImage r19 = EncodedImage.a(r12);
            BaseProducerContext r20 = (BaseProducerContext) r18;
            final InternalRequestListener r21 = r20.f8259c;
            monitor-enter(r20);
            Priority r22 = r20.f8261i;     // Catch: Throwable -> L33
            monitor-exit(r20);     // Catch: Throwable -> L33
            r22.ordinal();
            StatefulPriorityProducerRunnable<EncodedImage> r23 = new AnonymousClass1(r16, r17, r21, r18, r19);
            r16.f8408a.execute(r23);
            return;
        L33:
            th = move-exception;
            throw th;
        L36:
            ((BaseConsumer) this.f8287b).a(r12, r11);
        }
    }

    public WebpTranscodeProducer(ExecutorService r5, PooledByteBufferFactory r10, Producer r11) {
        r5.getClass();
        this.f8408a = r5;
        r10.getClass();
        this.f8409b = r10;
        this.f8410c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r5, ProducerContext r10) {
        this.f8410c.a(new WebpTranscodeConsumer(this, r5, r10), r10);
    }
}

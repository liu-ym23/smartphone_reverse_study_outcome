package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes2.dex */
public class RemoveImageTransformMetaDataProducer implements Producer<CloseableReference<PooledByteBuffer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer f8380a;

    public class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>> {
        public RemoveImageTransformMetaDataConsumer(Consumer r5) {
            super(r5);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            EncodedImage r11 = (EncodedImage) r5;
            CloseableReference r12 = null;
        L8:
            th = move-exception;
            if (r12 == null) goto L16;
            r12.close();
        L16:
            throw th;
        L4:
            if (EncodedImage.c(r11) == false) goto L10;
            CloseableReference r13 = r11.f8177a;     // Catch: Throwable -> L8
            if (r13 == null) goto L10;
            r12 = r13.b();     // Catch: Throwable -> L8
        L10:
            ((BaseConsumer) this.f8287b).a(r12, r10);     // Catch: Throwable -> L8
            if (r12 == null) goto L19;
            r12.close();
            return;
        }
    }

    public RemoveImageTransformMetaDataProducer(Producer r5) {
        this.f8380a = r5;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r5, ProducerContext r10) {
        this.f8380a.a(new RemoveImageTransformMetaDataConsumer(r5), r10);
    }
}

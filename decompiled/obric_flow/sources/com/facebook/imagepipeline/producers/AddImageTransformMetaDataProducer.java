package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes2.dex */
public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer f8254a;

    public static class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public AddImageTransformMetaDataConsumer(Consumer r5) {
            super(r5);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            EncodedImage r11 = (EncodedImage) r5;
            if (r11 != null) goto L7;
            ((BaseConsumer) this.f8287b).a(null, r10);
            return;
        L7:
            if (r11.f8179c >= 0) goto L9;
        L13:
            r11.f();
        L14:
            ((BaseConsumer) this.f8287b).a(r11, r10);
            return;
        L9:
            if (r11.e < 0) goto L13;
            if (r11.f < 0) goto L13;
            goto L13
        }
    }

    public AddImageTransformMetaDataProducer(Producer r5) {
        this.f8254a = r5;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r5, ProducerContext r10) {
        this.f8254a.a(new AddImageTransformMetaDataConsumer(r5), r10);
    }
}

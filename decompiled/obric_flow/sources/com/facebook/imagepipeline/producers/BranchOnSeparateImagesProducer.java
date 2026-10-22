package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes2.dex */
public class BranchOnSeparateImagesProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer f8270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThrottlingProducer f8271b;

    public class OnFirstImageConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ProducerContext f8272c;
        public final /* synthetic */ BranchOnSeparateImagesProducer d;

        public OnFirstImageConsumer(BranchOnSeparateImagesProducer r5, Consumer r10, ProducerContext r11) {
            this.d = r5;
            super(r10);
            this.f8272c = r11;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            EncodedImage r11 = (EncodedImage) r5;
            ImageRequest r12 = ((BaseProducerContext) this.f8272c).f8257a;
            boolean r13 = BaseConsumer.a(r10);
            ResizeOptions r14 = r12.g;
            if (r11 != null) goto L5;
            boolean r15 = false;
        L11:
            if (r11 == null) goto L18;
            if (r15 == false) goto L18;
            if (r13 == false) goto L17;
            if (r15 == false) goto L17;
            ((BaseConsumer) this.f8287b).a(r11, r10);
        L17:
            BaseConsumer r16 = (BaseConsumer) this.f8287b;
            r16.a(r11, r10 & (-2));
        L18:
            if (r13 == false) goto L24;
            if (r15 == true) goto L25;
            if (r11 == null) goto L22;
            r11.close();
        L22:
            this.d.f8271b.a(this.f8287b, this.f8272c);
            return;
        L25:
            return;
        L24:
            return;
        L5:
            r11.g();
            int r17 = r11.f8179c;
            if (r17 != 90) goto L8;
        L10:
            r11.g();
            int r18 = r11.f;
            r11.g();
            r15 = ThumbnailSizeChecker.a(r18, r11.e, r14);
            goto L11
        L8:
            if (r17 == 270) goto L10;
            r11.g();
            int r19 = r11.e;
            r11.g();
            r15 = ThumbnailSizeChecker.a(r19, r11.f, r14);
            goto L11
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Throwable r5) {
            this.d.f8271b.a(this.f8287b, this.f8272c);
        }
    }

    public BranchOnSeparateImagesProducer(Producer r5, ThrottlingProducer r10) {
        this.f8270a = r5;
        this.f8271b = r10;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r5, ProducerContext r10) {
        OnFirstImageConsumer r11 = new OnFirstImageConsumer(this, r5, r10);
        this.f8270a.a(r11, r10);
    }
}

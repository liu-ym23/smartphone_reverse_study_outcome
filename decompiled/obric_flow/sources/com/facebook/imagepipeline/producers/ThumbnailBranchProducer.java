package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.lynx.jsbridge.a;

/* JADX INFO: loaded from: classes2.dex */
public class ThumbnailBranchProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThumbnailProducer[] f8406a;

    public class ThumbnailConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ProducerContext f8407c;
        public final int d;
        public final ResizeOptions e;
        public final /* synthetic */ ThumbnailBranchProducer f;

        public ThumbnailConsumer(ThumbnailBranchProducer r5, Consumer r10, ProducerContext r11, int r12) {
            this.f = r5;
            super(r10);
            this.f8407c = r11;
            this.d = r12;
            this.e = ((BaseProducerContext) r11).f8257a.g;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            EncodedImage r11 = (EncodedImage) r5;
            if (r11 == null) goto L16;
            if (BaseConsumer.a(r10) == false) goto L13;
            ResizeOptions r12 = this.e;
            r11.g();
            int r13 = r11.f8179c;
            if (r13 != 90) goto L9;
        L11:
            r11.g();
            int r14 = r11.f;
            r11.g();
            boolean r15 = ThumbnailSizeChecker.a(r14, r11.e, r12);
        L12:
            if (r15 == false) goto L16;
        L9:
            if (r13 == 270) goto L11;
            r11.g();
            int r16 = r11.e;
            r11.g();
            r15 = ThumbnailSizeChecker.a(r16, r11.f, r12);
        L13:
            ((BaseConsumer) this.f8287b).a(r11, r10);
            return;
        L16:
            if (BaseConsumer.a(r10) == false) goto L23;
            if (r11 == null) goto L20;
            r11.close();
        L20:
            if (this.f.a(this.d + 1, this.f8287b, this.f8407c) == true) goto L24;
            ((BaseConsumer) this.f8287b).a(null, 1);
            return;
        L24:
            return;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Throwable r5) {
            if (this.f.a(this.d + 1, this.f8287b, this.f8407c) == true) goto L6;
            ((BaseConsumer) this.f8287b).a(r5);
            return;
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer... r10) {
        ThumbnailProducer[] r11 = r10;
        this.f8406a = r11;
        int r12 = r11.length;
        if (r12 <= 0) goto L5;
        return;
    L5:
        if (r12 < 0) goto L22;
        int r5 = 0;
        Object[] r13 = {"index", 0, Integer.valueOf(r12)};
        StringBuilder r14 = new StringBuilder(83);
        int r15 = 0;
    L8:
        if (r5 >= 3) goto L13;
        int r16 = "%s (%s) must be less than size (%s)".indexOf("%s", r15);
        if (r16 == (-1)) goto L13;
        r14.append("%s (%s) must be less than size (%s)".substring(r15, r16));
        r14.append(r13[r5]);
        r15 = r16 + 2;
        r5 = r5 + 1;
    L13:
        r14.append("%s (%s) must be less than size (%s)".substring(r15));
        if (r5 >= 3) goto L20;
        r14.append(" [");
        int r17 = r5 + 1;
        r14.append(r13[r5]);
    L16:
        if (r17 >= 3) goto L18;
        r14.append(", ");
        r14.append(r13[r17]);
        r17 = r17 + 1;
        goto L16
    L18:
        r14.append(']');
    L20:
        throw new IndexOutOfBoundsException(r14.toString());
    L22:
        throw new IllegalArgumentException(a.d(r12, "negative size: "));
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r5, ProducerContext r10) {
        if (((BaseProducerContext) r10).f8257a.g != null) goto L7;
        ((BaseConsumer) r5).a(null, 1);
        return;
    L7:
        if (a(0, r5, r10) == true) goto L10;
        ((BaseConsumer) r5).a(null, 1);
        return;
    }

    public final boolean a(int r5, Consumer r10, ProducerContext r11) {
        ResizeOptions r12 = ((BaseProducerContext) r11).f8257a.g;
    L3:
        ThumbnailProducer[] r13 = this.f8406a;
        if (r5 >= r13.length) goto L9;
        if (r13[r5].a(r12) == true) goto L10;
        r5 = r5 + 1;
    L10:
        if (r5 != (-1)) goto L13;
        return false;
    L13:
        this.f8406a[r5].a(new ThumbnailConsumer(this, r10, r11, r5), r11);
        return true;
    L9:
        r5 = -1;
        goto L10
    }
}

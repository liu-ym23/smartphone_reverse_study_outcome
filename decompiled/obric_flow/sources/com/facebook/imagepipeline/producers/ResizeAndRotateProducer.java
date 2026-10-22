package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoder;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class ResizeAndRotateProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f8381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f8382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Producer f8383c;
    public final boolean d;
    public final MultiImageTranscoderFactory e;

    public class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8384c;
        public final MultiImageTranscoderFactory d;
        public final ProducerContext e;
        public boolean f;
        public final JobScheduler g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ResizeAndRotateProducer f8385h;

        public TransformingConsumer(ResizeAndRotateProducer r5, final Consumer r10, ProducerContext r11, boolean r12, MultiImageTranscoderFactory r13) {
            this.f8385h = r5;
            super(r10);
            this.f = false;
            this.e = r11;
            BaseProducerContext r14 = (BaseProducerContext) r11;
            r14.f8257a.getClass();
            this.f8384c = r12;
            this.d = r13;
            monitor-enter(r14);
            final Priority r15 = r14.f8261i;     // Catch: Throwable -> L8
            monitor-exit(r14);     // Catch: Throwable -> L8
            JobScheduler.PriorityJobRunnable r16 = new AnonymousClass1(this, r15);
            this.g = new JobScheduler(r5.f8381a, r16);
            r14.a(new AnonymousClass2(this, r10));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public final ImmutableMap a(EncodedImage r10, ResizeOptions r11, ImageTranscodeResult r12) {
            ProducerContext r5 = this.e;
            if (((BaseProducerContext) r5).f8259c.b(r5, "ResizeAndRotateProducer") == true) goto L6;
            return null;
        L6:
            StringBuilder r13 = new StringBuilder();
            r10.g();
            r13.append(r10.e);
            r13.append("x");
            r10.g();
            r13.append(r10.f);
            String r14 = r13.toString();
            if (r11 == null) goto L9;
            String r15 = r11.f8051a + "x" + r11.f8052b;
        L10:
            HashMap r16 = new HashMap();
            r10.g();
            r16.put("Image format", String.valueOf(r10.f8178b));
            r16.put("Original size", r14);
            r16.put("Requested size", r15);
            JobScheduler r17 = this.g;
            monitor-enter(r17);
            long r18 = r17.f8323i - r17.f8322h;
            monitor-exit(r17);
            r16.put("queueTime", String.valueOf(r18));
            r16.put("Transcoder id", "SimpleImageTranscoder");
            r16.put("Transcoding result", String.valueOf(r12));
            return new ImmutableMap(r16);
        L17:
            th = move-exception;
            throw th;
        L9:
            r15 = "Unspecified";
            goto L10
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r10, int r11) {
            EncodedImage r12 = (EncodedImage) r10;
            if (this.f == true) goto L95;
            boolean r5 = BaseConsumer.a(r11);
            boolean r13 = true;
            if (r12 != null) goto L10;
            if (r5 == false) goto L86;
            ((BaseConsumer) this.f8287b).a(null, 1);
            return;
        L86:
            return;
        L10:
            r12.g();
            ImageFormat r14 = r12.f8178b;
            ImageRequest r15 = ((BaseProducerContext) this.e).f8257a;
            ImageTranscoder r16 = this.d.b(r14, this.f8384c);
            r12.g();
            if (r12.f8178b != ImageFormat.f7971c) goto L13;
            TriState r17 = TriState.f7698c;
        L39:
            if (r5 == true) goto L44;
            if (r17 != TriState.f7698c) goto L44;
            return;
        L44:
            if (r17 == TriState.f7696a) goto L77;
            if (r14 == DefaultImageFormats.f7962a) goto L66;
            if (r14 == DefaultImageFormats.f7968k) goto L66;
            int r18 = ((BaseProducerContext) this.e).f8257a.f8417h.f8055a;
            if (r18 != (-1)) goto L53;
            boolean r19 = true;
        L54:
            if (r19 == true) goto L74;
            if (r18 != (-2)) goto L58;
            r13 = false;
        L58:
            if (r13 == false) goto L74;
            if (r18 == (-1)) goto L64;
            r12 = EncodedImage.a(r12);
            if (r12 == null) goto L74;
            r12.f8179c = r18;
            goto L74
        L64:
            throw new IllegalStateException("Rotation is set to use EXIF");
        L74:
            ((BaseConsumer) this.f8287b).a(r12, r11);
            return;
        L53:
            r19 = false;
        L66:
            if (((BaseProducerContext) this.e).f8257a.f8417h.f8056b == true) goto L74;
            r12.g();
            if (r12.f8179c == 0) goto L74;
            r12.g();
            if (r12.f8179c == (-1)) goto L74;
            r12 = EncodedImage.a(r12);
            if (r12 == null) goto L74;
            r12.f8179c = 0;
            goto L74
        L77:
            if (this.g.a(r12, r11) == false) goto L97;
            if (r5 == true) goto L90;
            BaseProducerContext r110 = (BaseProducerContext) this.e;
            monitor-enter(r110);
            boolean r111 = r110.f8262j;     // Catch: Throwable -> L87
            monitor-exit(r110);     // Catch: Throwable -> L87
            if (r111 == true) goto L90;
            return;
        L87:
            th = move-exception;
            throw th;
        L90:
            this.g.d();
            return;
        L97:
            return;
        L13:
            r12.g();
            ImageFormat r20 = r12.f8178b;
            SimpleImageTranscoder r21 = (SimpleImageTranscoder) r16;
            if (r20 != DefaultImageFormats.f7968k) goto L16;
        L19:
            RotationOptions r22 = r15.f8417h;
            if (r22.f8056b == false) goto L22;
        L32:
            boolean r23 = false;
        L33:
            if (r23 == true) goto L35;
            r21.getClass();
            boolean r24 = false;
        L36:
            if (r24 == false) goto L38;
            r17 = TriState.f7696a;
            goto L39
        L38:
            r17 = TriState.f7697b;
            goto L39
        L35:
            r24 = true;
            goto L36
        L22:
            if (JpegTranscoderUtils.a(r22, r12) == 0) goto L24;
        L31:
            r23 = true;
            goto L33
        L24:
            if (r22.f8055a != (-2)) goto L26;
        L29:
            r12.d = 0;
            boolean r25 = false;
        L30:
            if (r25 == false) goto L32;
        L26:
            if (r22.f8056b == true) goto L29;
            ImmutableList r26 = JpegTranscoderUtils.f8446a;
            r12.g();
            r25 = r26.contains(Integer.valueOf(r12.d));
            goto L30
        L16:
            if (r20 == DefaultImageFormats.f7962a) goto L19;
            r17 = TriState.f7697b;
            goto L39
        }
    }

    public ResizeAndRotateProducer(ExecutorService r5, PooledByteBufferFactory r10, Producer r11, boolean r12, MultiImageTranscoderFactory r13) {
        r5.getClass();
        this.f8381a = r5;
        r10.getClass();
        this.f8382b = r10;
        this.f8383c = r11;
        r13.getClass();
        this.e = r13;
        this.d = r12;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r10, ProducerContext r11) {
        this.f8383c.a(new TransformingConsumer(this, r10, r11, this.d, this.e), r11);
    }
}

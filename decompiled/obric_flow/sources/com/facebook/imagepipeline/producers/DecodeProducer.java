package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.StreamUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveAwebpParser;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.BitmapUtil;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayPool f8273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f8274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DefaultImageDecoder f8275c;
    public final SimpleProgressiveJpegConfig d;
    public final Producer e;
    public final int f;
    public final CloseableReferenceFactory g;

    public class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public LocalImagesProgressiveDecoder(DecodeProducer r5, Consumer r10, ProducerContext r11, int r12) {
            super(r5, r10, r11, r12);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final synchronized boolean a(EncodedImage r5, int r10) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (BaseConsumer.a(r10) == true) goto L8;
            monitor-exit(this);
            return false;
        L8:
            boolean r11 = this.f8282h.a(r5, r10);     // Catch: Throwable -> L11
            monitor-exit(this);
            return r11;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final ImmutableQualityInfo c() {
            return new ImmutableQualityInfo(0, false, false);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final int a(EncodedImage r5) {
            return r5.d();
        }
    }

    public class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ProgressiveJpegParser f8276j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SimpleProgressiveJpegConfig f8277k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final ProgressiveAwebpParser f8278l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final ProducerContext f8279m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f8280n;

        public NetworkImagesProgressiveDecoder(DecodeProducer r5, Consumer r10, ProducerContext r11, ProgressiveJpegParser r12, SimpleProgressiveJpegConfig r13, ProgressiveAwebpParser r14, int r15) {
            super(r5, r10, r11, r15);
            this.f8276j = r12;
            r13.getClass();
            this.f8277k = r13;
            this.f8278l = r14;
            this.f8279m = r11;
            this.f8280n = 0;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final int a(EncodedImage r5) {
            r5.g();
            if (r5.f8178b == DefaultImageFormats.f7962a) goto L5;
            r5.g();
            if (r5.f8178b != DefaultImageFormats.f7967j) goto L9;
            this.f8278l.getClass();
        L9:
            return 0;
        L5:
            return this.f8276j.f;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final ImmutableQualityInfo c() {
            SimpleProgressiveJpegConfig r5 = this.f8277k;
            int r10 = this.f8276j.e;
            SimpleProgressiveJpegConfig.DynamicValueConfig r11 = r5.f8167a;
            if (r10 < 0) goto L5;
            boolean r12 = true;
        L7:
            return new ImmutableQualityInfo(r10, r12, false);
        L5:
            r12 = false;
            goto L7
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final synchronized boolean a(EncodedImage r10, int r11) {
            monitor-enter(this);
            boolean r5 = this.f8282h.a(r10, r11);     // Catch: Throwable -> L8
            if (BaseConsumer.a(r11) == false) goto L11;
            if (BaseConsumer.a(r11, 8) == true) goto L11;
        L62:
            monitor-exit(this);
            return r5;
        L11:
            if (BaseConsumer.a(r11, 4) == true) goto L62;
            if (EncodedImage.c(r10) == false) goto L62;
            r10.g();     // Catch: Throwable -> L8
            if (r10.f8178b == DefaultImageFormats.f7962a) goto L17;
            r10.g();     // Catch: Throwable -> L8
            if (r10.f8178b != DefaultImageFormats.f7967j) goto L57;
            ((BaseProducerContext) this.f8279m).f8257a.getClass();     // Catch: Throwable -> L8
            monitor-exit(this);
            return false;
        L57:
            r10.g();     // Catch: Throwable -> L8
            if (DefaultImageFormats.a(r10.f8178b) == false) goto L62;
            ((BaseProducerContext) this.f8279m).f8257a.getClass();     // Catch: Throwable -> L8
            monitor-exit(this);
            return false;
        L17:
            if (((BaseProducerContext) this.f8279m).f8257a.e == true) goto L20;
            monitor-exit(this);
            return false;
        L20:
            ProgressiveJpegParser r12 = this.f8276j;     // Catch: Throwable -> L8
            if (r12.f8163a != 6) goto L24;
        L25:
            boolean r13 = false;
        L29:
            if (r13 == true) goto L32;
            monitor-exit(this);
            return false;
        L32:
            int r14 = this.f8276j.e;     // Catch: Throwable -> L8
            int r15 = this.f8280n;     // Catch: Throwable -> L8
            if (r14 > r15) goto L37;
            monitor-exit(this);
            return false;
        L37:
            if (r14 < this.f8277k.a(r15)) goto L39;
        L42:
            this.f8280n = r14;     // Catch: Throwable -> L8
            monitor-exit(this);
            return r5;
        L39:
            if (this.f8276j.g == true) goto L42;
            monitor-exit(this);
            return false;
        L24:
            if (r10.d() <= r12.f8165c) goto L25;
            PooledByteArrayBufferedInputStream r16 = new PooledByteArrayBufferedInputStream(r10.c(), (byte[]) ((BasePool) r12.f8166h).get(16384), r12.f8166h);     // Catch: Throwable -> L8
            StreamUtil.a(r16, r12.f8165c);     // Catch: Throwable -> L45 IOException -> L47
            r13 = r12.a(r16);     // Catch: Throwable -> L45 IOException -> L47
            Closeables.a(r16);     // Catch: Throwable -> L8
            goto L29
        L45:
            th = move-exception;
            Closeables.a(r16);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L47:
            e = move-exception;
            Throwables.a(e, Error.class);     // Catch: Throwable -> L45
            Throwables.a(e, RuntimeException.class);     // Catch: Throwable -> L45
            throw new RuntimeException(e);     // Catch: Throwable -> L45
        L8:
            th = move-exception;
            throw th;
        }
    }

    public abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ProducerContext f8281c;
        public final InternalRequestListener d;
        public final ImageDecodeOptions e;
        public boolean f;
        public final AtomicBoolean g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final JobScheduler f8282h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ DecodeProducer f8283i;

        public ProgressiveDecoder(DecodeProducer r5, Consumer r10, final ProducerContext r11, final int r12) {
            this.f8283i = r5;
            super(r10);
            this.g = new AtomicBoolean(true);
            this.f8281c = r11;
            BaseProducerContext r13 = (BaseProducerContext) r11;
            this.d = r13.f8259c;
            ImageDecodeOptions r14 = r13.f8257a.f;
            this.e = r14;
            this.f = false;
            monitor-enter(r13);
            final Priority r15 = r13.f8261i;     // Catch: Throwable -> L8
            monitor-exit(r13);     // Catch: Throwable -> L8
            JobScheduler.PriorityJobRunnable r16 = new AnonymousClass1(this, r15, r11, r12);
            ExecutorService r17 = r5.f8274b;
            r14.getClass();
            this.f8282h = new JobScheduler(r17, r16);
            r13.a(new AnonymousClass2(this));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public abstract int a(EncodedImage r5);

        public final CloseableImage a(EncodedImage r5, int r10, QualityInfo r11) {
            this.f8283i.getClass();
            CloseableImage r12 = this.f8283i.f8275c.a(r5, r10, r11, this.e);
            if (r5 == null) goto L14;
            ProducerContext r13 = this.f8281c;
            r5.g();
            BaseProducerContext r14 = (BaseProducerContext) r13;
            r14.a("encoded_width", Integer.valueOf(r5.e));
            ProducerContext r15 = this.f8281c;
            r5.g();
            BaseProducerContext r16 = (BaseProducerContext) r15;
            r16.a("encoded_height", Integer.valueOf(r5.f));
            ProducerContext r17 = this.f8281c;
            BaseProducerContext r18 = (BaseProducerContext) r17;
            r18.a("encoded_size", Integer.valueOf(r5.d()));
            if ((r12 instanceof CloseableBitmap) == false) goto L12;
            Bitmap r19 = ((CloseableStaticBitmap) ((CloseableBitmap) r12)).g;
            if (r19 != null) goto L10;
            Bitmap.Config r20 = null;
        L11:
            ProducerContext r21 = this.f8281c;
            BaseProducerContext r22 = (BaseProducerContext) r21;
            r22.a("bitmap_config", String.valueOf(r20));
            goto L12
        L10:
            r20 = r19.getConfig();
        L12:
            if (r12 == null) goto L14;
            r12.a(((BaseProducerContext) this.f8281c).g);
        L14:
            return r12;
        }

        public abstract boolean a(EncodedImage r5, int r10);

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(float r5) {
            BaseConsumer r10 = (BaseConsumer) this.f8287b;
            r10.a(r5 * 0.99f);
        }

        public abstract ImmutableQualityInfo c();

        public final void c(Throwable r5) {
            a(true);
            ((BaseConsumer) this.f8287b).a(r5);
        }

        public final void d() {
            a(true);
            ((BaseConsumer) this.f8287b).a();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Object r5, int r10) {
            EncodedImage r11 = (EncodedImage) r5;
            FrescoSystrace.a().getClass();     // Catch: Throwable -> L9
            boolean r12 = BaseConsumer.a(r10);     // Catch: Throwable -> L9
            if (r12 == false) goto L17;
            if (r11 != null) goto L12;
            c(new ExceptionWithNoStacktrace("Encoded image is null."));     // Catch: Throwable -> L9
            FrescoSystrace.a().getClass();
            return;
        L12:
            if (r11.e() == true) goto L17;
            c(new ExceptionWithNoStacktrace("Encoded image is not valid."));     // Catch: Throwable -> L9
            FrescoSystrace.a().getClass();
            return;
        L17:
            if (a(r11, r10) == true) goto L21;
            FrescoSystrace.a().getClass();
            return;
        L21:
            boolean r13 = BaseConsumer.a(r10, 4);     // Catch: Throwable -> L9
            if (r12 == true) goto L33;
            if (r13 == true) goto L33;
            BaseProducerContext r14 = (BaseProducerContext) this.f8281c;     // Catch: Throwable -> L9
            monitor-enter(r14);     // Catch: Throwable -> L9
            boolean r15 = r14.f8262j;     // Catch: Throwable -> L30
            monitor-exit(r14);     // Catch: Throwable -> L30
            if (r15 == true) goto L33;
        L34:
            FrescoSystrace.a().getClass();
            return;
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L9
        L33:
            this.f8282h.d();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            FrescoSystrace.a().getClass();
            throw th;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b(Throwable r5) {
            c(r5);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void b() {
            d();
        }

        public final ImmutableMap a(CloseableImage r19, long r20, QualityInfo r22, boolean r23, String r24, String r25, String r26, String r27, boolean r28, Rect r29, long r30) {
            if (this.d.b(this.f8281c, "DecodeProducer") == true) goto L6;
            return null;
        L6:
            String r5 = String.valueOf(r20);
            String r10 = String.valueOf(((ImmutableQualityInfo) r22).f8192b);
            String r11 = String.valueOf(r23);
            if ((r19 instanceof CloseableStaticBitmap) == false) goto L45;
            CloseableStaticBitmap r12 = (CloseableStaticBitmap) r19;
            Bitmap r13 = r12.g;
            String r14 = r13.getWidth() + "x" + r13.getHeight();
            HashMap r15 = new HashMap(20);
            r15.put("bitmapSize", r14);
            r15.put("queueTime", r5);
            r15.put("hasGoodQuality", r10);
            r15.put("isFinal", r11);
            r15.put("encodedImageSize", r25);
            r15.put("imageFormat", r24);
            r15.put("requestedImageSize", r26);
            r15.put("sampleSize", r27);
            r15.put("byteCount", r13.getByteCount() + "");
            r15.put("bitmapRamSize", String.valueOf(BitmapUtil.a(r13)));
            if (r28 == false) goto L11;
            Object r16 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        L12:
            r15.put("isCrop", r16);
            if (r13.getConfig() != null) goto L15;
            String r17 = "unkown";
        L16:
            r15.put("extra_bitmap_config", r17);
            r15.put("heic_sys_first", "0");
            int r18 = 0;
            r15.put("heic_custom_decoder", String.valueOf(0));
            if (r29 == null) goto L19;
            r15.put("regionToDecode", r29.flattenToString());
        L19:
            r12.getClass();
            r15.put("imageCount", String.valueOf(1));
            int r21 = r13.getWidth();
            int r31 = r13.getHeight();
            ArrayList r32 = new ArrayList();
            Random r33 = new Random();
            Random r34 = new Random();
            FrescoSystrace.a().getClass();
        L21:
            if (r18 >= 30) goto L23;
            r32.add(Integer.valueOf(r13.getPixel(r33.nextInt(r21), r34.nextInt(r31))));
            r18 = r18 + 1;
            goto L21
        L23:
            FrescoSystrace.a().getClass();
            Iterator r35 = r32.iterator();
        L25:
            if (r35.hasNext() == false) goto L42;
            if (((Integer) r35.next()).intValue() == (-1)) goto L25;
            Iterator r36 = r32.iterator();
        L30:
            if (r36.hasNext() == false) goto L41;
            if (((Integer) r36.next()).intValue() == (-16777216)) goto L30;
            Iterator r37 = r32.iterator();
        L35:
            if (r37.hasNext() == false) goto L40;
            if (((Integer) r37.next()).intValue() == 0) goto L35;
            String r38 = "normal";
        L43:
            r15.put("imageQuality", r38);
            return new ImmutableMap(r15);
        L40:
            r38 = "transparent_suspected";
            goto L43
        L41:
            r38 = "black_suspected";
            goto L43
        L42:
            r38 = "white_suspected";
            goto L43
        L15:
            r17 = r13.getConfig().name();
            goto L16
        L11:
            r16 = "0";
            goto L12
        L45:
            HashMap r39 = new HashMap(11);
            r39.put("queueTime", r5);
            r39.put("hasGoodQuality", r10);
            r39.put("isFinal", r11);
            r39.put("encodedImageSize", r25);
            r39.put("imageFormat", r24);
            r39.put("requestedImageSize", r26);
            r39.put("sampleSize", r27);
            if (r28 == false) goto L48;
            Object r110 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        L49:
            r39.put("isCrop", r110);
            if (r29 == null) goto L52;
            r39.put("regionToDecode", r29.flattenToString());
        L52:
            if (r19 != null) goto L55;
            String r40 = "-1";
        L56:
            r39.put("imageCount", r40);
            r39.put("imageQuality", "not_static_image");
            return new ImmutableMap(r39);
        L55:
            r40 = String.valueOf(1);
            goto L56
        L48:
            r110 = "0";
            goto L49
        }

        public final void a(boolean r5) {
            monitor-enter(this);
            if (r5 == true) goto L17;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L17:
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f == true) goto L13;
            ((BaseConsumer) this.f8287b).a(1.0f);     // Catch: Throwable -> L11
            this.f = true;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            this.f8282h.a();
        }
    }

    public DecodeProducer(ByteArrayPool r5, ExecutorService r10, DefaultImageDecoder r11, SimpleProgressiveJpegConfig r12, boolean r13, Producer r14, int r15, CloseableReferenceFactory r16) {
        r5.getClass();
        this.f8273a = r5;
        r10.getClass();
        this.f8274b = r10;
        r11.getClass();
        this.f8275c = r11;
        r12.getClass();
        this.d = r12;
        r14.getClass();
        this.e = r14;
        this.f = r15;
        this.g = r16;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(Consumer r10, ProducerContext r11) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L5
        if (UriUtil.b(((BaseProducerContext) r11).f8257a.f8415b) == true) goto L7;
        Consumer r5 = new LocalImagesProgressiveDecoder(this, r10, r11, this.f);     // Catch: Throwable -> L5
    L8:
        this.e.a(r5, r11);     // Catch: Throwable -> L5
        FrescoSystrace.a().getClass();
        return;
    L7:
        ProgressiveJpegParser r12 = new ProgressiveJpegParser(this.f8273a);     // Catch: Throwable -> L5
        ProgressiveAwebpParser r13 = new ProgressiveAwebpParser(this.f8273a);     // Catch: Throwable -> L5
        r5 = new NetworkImagesProgressiveDecoder(this, r10, r11, r12, this.d, r13, this.f);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }
}

package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AsyncLoadImage {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public static final class AsyncLoadImageDataSourceHandler implements com.bytedance.android.ec.core.imagex.common.j {
        public volatile ImageRequest[] a;
        public ImageRequest b;
        public t0.b c;
        public final Lazy d;
        public final b e;

        @Override // com.bytedance.android.ec.core.imagex.common.i
        public final void b(AbstractDraweeController r10) {
            Intrinsics.checkNotNullParameter(r10, "controller");
            this.e.b(r10);
        }

        @Override // com.bytedance.android.ec.core.imagex.common.j
        public final Supplier<DataSource<CloseableReference<CloseableImage>>> c(ImageRequest[] r10, ImageRequest r11) {
            return this.e.c(r10, r11);
        }

        @Override // com.bytedance.android.ec.core.imagex.common.j
        public final RequestListener d() {
            return this.e.d();
        }

        @Override // com.bytedance.android.ec.core.imagex.common.j
        public final String e() {
            return this.e.e();
        }

        @Override // com.bytedance.android.ec.core.imagex.common.j
        public final boolean f() {
            return this.e.f();
        }

        @Override // com.bytedance.android.ec.core.imagex.common.j
        public final ImageRequest getImageRequest() {
            return this.e.getImageRequest();
        }

        @Override // com.bytedance.android.ec.core.imagex.common.k
        public final ImageRequest a() {
            return this.e.d;
        }

        @Override // com.bytedance.android.ec.core.imagex.common.k
        public final ImageRequest[] g() {
            return this.e.c;
        }

        @Override // com.bytedance.android.ec.core.imagex.common.k
        public final Object getCallerContext() {
            return this.e.b;
        }

        public AsyncLoadImageDataSourceHandler(b r10) {
            Intrinsics.checkNotNullParameter(r10, "supplierContext");
            this.e = r10;
            this.a = r10.c;
            this.d = LazyKt.lazy(AsyncLoadImage$AsyncLoadImageDataSourceHandler$placeholderRequest$2.INSTANCE);
        }
    }

    public static final class BitmapCacheReuseProducer implements Producer<CloseableReference<CloseableImage>> {
        public final Producer<CloseableReference<CloseableImage>> a;

        public BitmapCacheReuseProducer(BitmapReuseProducer r10) {
            Intrinsics.checkNotNullParameter(r10, "inputProducer");
            this.a = r10;
        }

        public final void produceResults(Consumer<CloseableReference<CloseableImage>> r10, ProducerContext r11) {
            boolean r0 = r11 instanceof h;
            final Object r1 = null;
            if (r0 == true) goto L5;
            ProducerContext r12 = null;
        L6:
            h r13 = (h) r12;
            int r14 = 0;
            if (r13 == null) goto L10;
            ImageRequest[] r15 = r13.b;
            if (r15 == null) goto L10;
        L15:
            if (r11 == null) goto L17;
            r1 = r11.getCallerContext();
        L17:
            if (r15 == null) goto L37;
            int r16 = r15.length;
        L19:
            if (r14 >= r16) goto L37;
            final ImageRequest r17 = r15[r14];
            if (r0 == false) goto L25;
            h r18 = (h) r11;
            Function0<CacheKey> r19 = new AsyncLoadImage$BitmapCacheReuseProducer$produceResults$cacheKey$1(r17, r1);
            r18.getClass();
            Intrinsics.checkNotNullParameter(r19, "getCacheKey");
            CacheKey r20 = r18.a.get(r14);
            if (r20 != null) goto L26;
            r20 = (CacheKey) r19.invoke();
            r18.a.put(r14, r20);
        L26:
            Lazy r21 = AsyncLoadImage.a;
            CloseableReference r22 = Fresco.getImagePipelineFactory().getImagePipeline().getCachedImage(r20);
            if (CloseableReference.isValid(r22) == true) goto L28;
            r14 = r14 + 1;
            goto L19
        L28:
            if (r10 != null) goto L39;
        L34:
            CloseableReference.closeSafely(r22);
            return;
        L39:
            r10.onNewResult(r22, 1);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            CloseableReference.closeSafely(r22);
            throw th;
        L25:
            r20 = AsyncLoadImage.a(r17, r1);
        L37:
            this.a.produceResults(r10, r11);
            return;
        L10:
            if (r11 == null) goto L14;
            ImageRequest r23 = r11.getImageRequest();
            if (r23 == null) goto L14;
            r15 = new ImageRequest[]{r23};
        L14:
            r15 = null;
            goto L15
        L5:
            r12 = r11;
            goto L6
        }
    }

    public static final class BitmapReuseProducer implements Producer<CloseableReference<CloseableImage>> {
        public final Producer<CloseableReference<CloseableImage>> a;

        public BitmapReuseProducer(ThreadHandoffProducer r10) {
            Intrinsics.checkNotNullParameter(r10, "inputProducer");
            this.a = r10;
        }

        public final void produceResults(Consumer<CloseableReference<CloseableImage>> r10, final ProducerContext r11) {
            CloseableReference<CloseableImage> r0 = null;
        L16:
            th = move-exception;
            com.bytedance.crash.d.c(th);     // Catch: Throwable -> L33
        L31:
            CloseableReference.closeSafely(r0);
            return;
        L33:
            th = move-exception;
            CloseableReference.closeSafely(r0);
            throw th;
        L4:
            if ((r11 instanceof h) == true) goto L6;
            ProducerContext r1 = null;
        L7:
            final h r12 = (h) r1;     // Catch: Throwable -> L16
            if (r12 == null) goto L22;
            ImageRequest[] r13 = r12.b;     // Catch: Throwable -> L16
            if (r13 == null) goto L18;
            final ImageRequest r14 = (ImageRequest) ArraysKt.firstOrNull(r13);     // Catch: Throwable -> L16
            if (r14 == null) goto L18;
            Function0<CacheKey> r15 = new AsyncLoadImage$BitmapReuseProducer$produceResults$$inlined$run$lambda$1(r14, r12, r11);     // Catch: Throwable -> L16
            Intrinsics.checkNotNullParameter(r15, "getCacheKey");     // Catch: Throwable -> L16
            CacheKey r16 = r12.a.get(0);     // Catch: Throwable -> L16
            if (r16 != null) goto L19;
            r16 = (CacheKey) r15.invoke();     // Catch: Throwable -> L16
            r12.a.put(0, r16);     // Catch: Throwable -> L16
        L19:
            CloseableStaticBitmap r17 = (CloseableStaticBitmap) r12.c.invoke(r16);     // Catch: Throwable -> L16
            if (r17 == null) goto L22;
            r0 = i.b(r17);     // Catch: Throwable -> L16
        L18:
            r16 = null;
        L22:
            if (r0 != null) goto L24;
        L27:
            this.a.produceResults(r10, r11);     // Catch: Throwable -> L16
        L28:
            this.a.produceResults(r10, r11);     // Catch: Throwable -> L16
            goto L31
        L24:
            if (r0.isValid() != true) goto L27;
            if (r10 == null) goto L28;
            r10.onNewResult(r0, 1);     // Catch: Throwable -> L16
            goto L28
        L6:
            r1 = r11;
            goto L7
        }
    }

    public static final class a implements Producer<CloseableReference<CloseableImage>> {
        public a() {
        }

        public final void produceResults(Consumer<CloseableReference<CloseableImage>> r10, ProducerContext r11) {
            Function0<Unit> r1 = null;
            if ((r11 instanceof h) == true) goto L5;
            r11 = null;
        L5:
            h r12 = (h) r11;
            if (r12 == null) goto L8;
            r1 = r12.d;
        L8:
            if (r1 == null) goto L10;
            Unit r13 = (Unit) r1.invoke();
        L10:
            if (r10 == null) goto L13;
            r10.onFailure(new NullPointerException("AsyncBuildImageRequestProducer: onNext"));
            return;
        }
    }

    public static final class b extends com.bytedance.android.ec.core.imagex.common.f {
        public final t0.d e;

        public b(Object r10, ImageRequest[] r11, ImageRequest r12, t0.d r13) {
            Intrinsics.checkNotNullParameter(r13, "lazyImageRequestBuilder");
            super(r10, r11, r12);
            this.e = r13;
        }
    }

    public AsyncLoadImage() {
    }

    static {
        a = LazyKt.lazy(AsyncLoadImage$abValue$2.INSTANCE);
        b = LazyKt.lazy(AsyncLoadImage$enableOpt$2.INSTANCE);
        c = LazyKt.lazy(AsyncLoadImage$urlHandleAsyncOpt$2.INSTANCE);
        d = LazyKt.lazy(AsyncLoadImage$mImagePipeline$2.INSTANCE);
        e = LazyKt.lazy(AsyncLoadImage$threadHandoffProducerQueue$2.INSTANCE);
        f = LazyKt.lazy(AsyncLoadImage$cacheOrWithAsyncSupplierProducer$2.INSTANCE);
    }

    public static final CacheKey a(ImageRequest r10, Object r11) {
        CacheKeyFactory r0 = ((ImagePipeline) d.getValue()).getCacheKeyFactory();
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getPostprocessor() == null) goto L11;
        return r0.getPostprocessedBitmapCacheKey(r10, r11);
    L11:
        return r0.getBitmapCacheKey(r10, r11);
    }
}

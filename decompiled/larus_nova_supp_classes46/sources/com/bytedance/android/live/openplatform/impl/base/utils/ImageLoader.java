package com.bytedance.android.live.openplatform.impl.base.utils;

import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.datasource.BaseBooleanSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ImageLoader implements mo0.a {
    public static final ImageLoader a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/utils/ImageLoader$ImageFromSource;", "", "UNKNOWN", "NETWORK", "MEMORY_CACHE", "DISK_CACHE", "LOCAL", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ImageFromSource extends Enum<ImageFromSource> {
        public static final ImageFromSource DISK_CACHE = null;
        public static final ImageFromSource LOCAL = null;
        public static final ImageFromSource MEMORY_CACHE = null;
        public static final ImageFromSource NETWORK = null;
        public static final ImageFromSource UNKNOWN = null;
        public static final /* synthetic */ ImageFromSource[] a = null;

        static {
            ImageFromSource r1 = new ImageFromSource("UNKNOWN", 0);
            UNKNOWN = r1;
            ImageFromSource r2 = new ImageFromSource("NETWORK", 1);
            NETWORK = r2;
            ImageFromSource r3 = new ImageFromSource("MEMORY_CACHE", 2);
            MEMORY_CACHE = r3;
            ImageFromSource r4 = new ImageFromSource("DISK_CACHE", 3);
            DISK_CACHE = r4;
            ImageFromSource r5 = new ImageFromSource("LOCAL", 4);
            LOCAL = r5;
            a = new ImageFromSource[]{r1, r2, r3, r4, r5};
        }

        public static ImageFromSource valueOf(String r1) {
            return (ImageFromSource) r27.a.a(ImageFromSource.class, r1);
        }

        public static ImageFromSource[] values() {
            return (ImageFromSource[]) a.clone();
        }

        public ImageFromSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements ControllerListener<ImageInfo> {
        public final SimpleDraweeView a;
        public final BaseControllerListener<ImageInfo> b;
        public final String c;
        public final mo0.b d;

        public final void onIntermediateImageFailed(String r2, Throwable r3) {
            this.b.onIntermediateImageFailed(r2, r3);
        }

        public final void onRelease(String r2) {
            this.b.onRelease(r2);
        }

        public final void onSubmit(String r2, Object r3) {
            this.b.onSubmit(r2, r3);
        }

        public final void onFailure(String r2, Throwable r3) {
            if (this.d.c == false) goto L9;
            AbstractDraweeController r0 = this.a.getController();
            if (r0 == null) goto L8;
            r0.removeControllerListener(this);
            goto L9
        L8:
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, com.facebook.imagepipeline.image.ImageInfo>");
        L9:
            this.b.onFailure(r2, r3);
        }

        public final void onIntermediateImageSet(String r2, Object r3) {
            BaseControllerListener<ImageInfo> r0 = this.b;
            r0.onIntermediateImageSet(r2, (ImageInfo) r3);
        }

        public final void onFinalImageSet(String r6, Object r7, Animatable r8) {
            ImageInfo r9 = (ImageInfo) r7;
            if (this.d.c == false) goto L9;
            AbstractDraweeController r0 = this.a.getController();
            if (r0 == null) goto L8;
            r0.removeControllerListener(this);
            goto L9
        L8:
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, com.facebook.imagepipeline.image.ImageInfo>");
        L9:
            mo0.b r1 = this.d;
            ImageTag r2 = r1.a;
            if (r1.d == false) goto L27;
            String r3 = this.c;
            if ((r8 instanceof AnimatedDrawable2) == false) goto L27;
            AnimationBackend r4 = ((AnimatedDrawable2) r8).getAnimationBackend();
            AnimationBackend r5 = null;
            if ((r4 instanceof AnimationBackendDelegate) == true) goto L16;
            r4 = null;
        L16:
            AnimationBackendDelegate r10 = (AnimationBackendDelegate) r4;
            if (r10 == null) goto L19;
            AnimationBackend r11 = r10.getAnimationBackend();
        L21:
            if ((r11 instanceof BitmapAnimationBackend) == false) goto L24;
            r5 = r11;
        L24:
            BitmapAnimationBackend r12 = (BitmapAnimationBackend) r5;
            if (r12 == null) goto L27;
            r12.setFrameListener(new f(r2, r3));
            goto L27
        L19:
            r11 = null;
        L27:
            this.b.onFinalImageSet(r6, r9, r8);
        }

        public a(SimpleDraweeView r2, BaseControllerListener<ImageInfo> r3, String r4, mo0.b r5) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "listener");
            Intrinsics.checkNotNullParameter(r4, "url");
            Intrinsics.checkNotNullParameter(r5, "config");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b extends BaseBooleanSubscriber {
        public final /* synthetic */ ImageRequest a;

        public b(ImageRequest r1) {
            this.a = r1;
        }

        public final void onFailureImpl(DataSource<Boolean> r3) {
            Fresco.getImagePipeline().prefetchToDiskCache(this.a, s1.getContext());
        }

        public final void onNewResultImpl(boolean r3) {
            if (r3 == true) goto L5;
            Fresco.getImagePipeline().prefetchToDiskCache(this.a, s1.getContext());
            return;
        }
    }

    public static final class c implements Executor {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r1) {
            if (r1 == null) goto L5;
            r1.run();
            return;
        }
    }

    public ImageLoader() {
    }

    static {
        a = new ImageLoader();
    }

    public static void d(String r2) {
        if (((wc1) de0.a.getValue()).k() == 0) goto L16;
        if (r2 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L18;
        ImageRequest r3 = ImageRequest.fromUri(r2);
        if (Fresco.getImagePipeline().isInBitmapMemoryCache(r3) == true) goto L17;
        Fresco.getImagePipeline().prefetchToBitmapCache(r3, s1.getContext());
        return;
    L17:
        return;
    L18:
        return;
    L6:
        if (r2.length() == 0) goto L9;
        r0 = false;
        goto L10
    }

    public static void e(String r2) {
        if (((wc1) de0.a.getValue()).k() != 0) goto L5;
        return;
    L5:
        if (r2.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        ImageRequest r3 = ImageRequest.fromUri(r2);
        Fresco.getImagePipeline().isInDiskCache(r3).subscribe(new b(r3), c.a);
        return;
    L13:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public static void c(SimpleDraweeView r3, ImageRequestBuilder r4, mo0.b r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        ImageTag r0 = r5.a;
        if (r0 != null) goto L7;
        r0 = ImageTag.UNKNOWN;
    L7:
        r4.setRequestListener(new g(r0, r4.getSourceUri().toString()));
        PipelineDraweeControllerBuilder r1 = Fresco.newDraweeControllerBuilder().setOldController(r3.getController()).setImageRequest(r4.build());
        BaseControllerListener<ImageInfo> r2 = r5.b;
        if (r2 == null) goto L10;
        r1.setControllerListener(new a(r3, r2, r4.getSourceUri().toString(), r5));
    L10:
        r3.setController(r1.build());
    }

    @Override // mo0.a
    public final void a(HSImageView r1, int r2, mo0.b r3) {
        c(r1, ImageRequestBuilder.newBuilderWithResourceId(r2), r3);
    }

    @Override // mo0.a
    public final void b(SimpleDraweeView r2, String r3, mo0.b r4) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        c(r2, ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3)), r4);
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void f(long r7, String r9, String r10, String r11, int r12, String r13, ImageFromSource r14) {
        long r2 = 0;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        Boolean r3 = (Boolean) r1.getValue();
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        if (r4 == false) goto L13;
        return;
    L13:
        if (r7 == (-1)) goto L15;
        r2 = SystemClock.uptimeMillis() - r7;
    L15:
        com.bytedance.android.livesdk.log.u.l().e("mp_live_audience_image_monitor", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("_param_for_special", "micro_app"), TuplesKt.to("image_id", r9), TuplesKt.to("image_url", r10), TuplesKt.to("scene", r11), TuplesKt.to("load_status", String.valueOf(r12)), TuplesKt.to("load_status_desc", String.valueOf(r13)), TuplesKt.to("from_source", String.valueOf(r14.ordinal())), TuplesKt.to("duration", String.valueOf(r2))}), new Object[]{Room.class});
        return;
    L9:
        r4 = false;
        goto L10
    }
}

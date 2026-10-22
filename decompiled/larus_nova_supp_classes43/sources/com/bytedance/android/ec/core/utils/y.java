package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "USE ImageHelper OR RemoteImage, @kepan.me")
public final class y {

    public class a extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        public int a;
        public final /* synthetic */ b b;
        public final /* synthetic */ ImagePipeline c;
        public final /* synthetic */ ImageRequest[] d;

        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r10) {
            Throwable r11 = r10.getFailureCause();
            ImagePipeline r0 = this.c;
            ImageRequest[] r1 = this.d;
            int r12 = this.a;
            this.a = r12 + 1;
            if (y.i(r0, r1, r12, this) == true) goto L6;
            b r13 = this.b;
            new RuntimeException(r11);
            r13.onFailure();
            return;
        }

        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r10) {
            this.b.onSuccess(r10);
        }

        public a(b r1, ImagePipeline r10, ImageRequest[] r11) {
            this.b = r1;
            this.c = r10;
            this.d = r11;
            this.a = 1;
        }
    }

    public interface b {
        void onFailure();

        void onSuccess(DataSource<CloseableReference<CloseableImage>> r1);
    }

    public interface c<T> {
        void accept(T r1);
    }

    public static abstract class d implements ControllerListener<ImageInfo> {
        public d() {
        }

        public void a(String r1, ImageInfo r10, Animatable r11) {
        }

        public final void onIntermediateImageFailed(String r1, Throwable r10) {
        }

        public final void onRelease(String r1) {
        }

        public final void onSubmit(String r1, Object r10) {
        }

        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r10) {
            ImageInfo r11 = (ImageInfo) r10;
        }

        public /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r10, Animatable r11) {
            a(r1, (ImageInfo) r10, r11);
        }
    }

    public static boolean m() {
        return ((Boolean) ImageSettings.a.getValue()).booleanValue();
    }

    public static com.bytedance.android.ec.core.imagex.r j(GenericDraweeView r10) {
        if (r10 == null) goto L4;
        com.bytedance.android.ec.core.imagex.r r0 = ImageExtensionsKt.j(r10);
        if (r0 != null) goto L9;
        com.bytedance.android.ec.core.imagex.r r1 = com.bytedance.android.ec.core.imagex.t.a;
        r0 = com.bytedance.android.ec.core.imagex.t.a(r10.getContext());
    L9:
        if ((r0 instanceof com.bytedance.android.ec.core.imagex.r) == false) goto L12;
        com.bytedance.android.ec.core.imagex.u r11 = new com.bytedance.android.ec.core.imagex.u(r0);
        r11.B();
        r11.A(r10.getContext());
        r11.D(r10);
        return r11;
    L12:
        return r0;
    L4:
        return com.bytedance.android.ec.core.imagex.t.a(null);
    }

    public static boolean k(Uri r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        ImageRequest r11 = ImageRequest.fromUri(r10);
        CacheKey r12 = Fresco.getImagePipeline().getCacheKeyFactory().getEncodedCacheKey(r11, null);
        return ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r12);
    }

    public static void a(GenericDraweeView r10, ECUrlModel r11) {
        c(r10, r11, -1, -1, null);
    }

    public static void d(GenericDraweeView r10, String r11) {
        e(r10, r11, -1, -1, null);
    }

    public static ImageRequest[] h(ECUrlModel r10, ResizeOptions r11) {
        if (r10 == null) goto L48;
        if (r10.getUrlList() == null) goto L48;
        if (r10.getUrlList().size() == 0) goto L48;
        if (m() == false) goto L31;
        ImageExperiments.G.getClass();
        if (ImageExperiments.c() == false) goto L31;
        KProperty[] r1 = ImageExtensionsKt.a;
        Intrinsics.checkNotNullParameter(r10, "urlModel");
        List r12 = r10.getUrlList();
        List r13 = r12;
        if (r13 != null) goto L16;
    L19:
        boolean r14 = true;
    L20:
        Pair<List<ImageRequest>, com.bytedance.android.ec.core.imagex.r> r15 = null;
        if (r14 == true) goto L24;
        r15 = ImageExtensionsKt.m(r12, null, null, null, null);
    L24:
        if (r15 == null) goto L31;
        if (r15.getFirst() == null) goto L31;
        if (((List) r15.getFirst()).isEmpty() == true) goto L31;
        return (ImageRequest[]) ((List) r15.getFirst()).toArray(new ImageRequest[0]);
    L16:
        if (r13.isEmpty() == true) goto L19;
        r14 = false;
    L31:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r10.getUrlList().iterator();
    L33:
        if (r17.hasNext() == false) goto L42;
        String r18 = (String) r17.next();
        if (StringUtils.isEmpty(r18) == true) goto L33;
        ImageRequestBuilder r19 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r18));
        if (r11 == null) goto L40;
        r19.setResizeOptions(r11);
    L40:
        r16.add(r19.build());
        goto L33
    L42:
        if (r16.size() != 0) goto L46;
        return new ImageRequest[0];
    L46:
        return (ImageRequest[]) r16.toArray(new ImageRequest[r16.size()]);
    L48:
        return new ImageRequest[0];
    }

    public static void n(ECUrlModel r10, b r11) {
        ImageRequest[] r12 = h(r10, null);
        ImagePipeline r0 = Fresco.getImagePipeline();
        i(r0, r12, 0, new a(r11, r0, r12));
    }

    public static void b(GenericDraweeView r1, ECUrlModel r10, int r11, int r12) {
        c(r1, r10, r11, r12, null);
    }

    public static void g(GenericDraweeView r10, String r11, int r12, int r13) {
        int r0 = -2;
        if (r12 > 0) goto L6;
        if (r13 > 0) goto L6;
        r12 = -2;
        int r14 = 33;
    L12:
        if (r10.getLayoutParams() == null) goto L14;
        r10.getLayoutParams().width = r12;
        r10.getLayoutParams().height = r0;
    L15:
        if (r14 != 0) goto L17;
    L19:
        e(r10, r11, -1, -1, null);
        return;
    L17:
        if ((r10 instanceof ECDraweeView) == false) goto L19;
        ((ECDraweeView) r10).setAdjustMode(r14);
        goto L19
    L14:
        r10.setLayoutParams(new ViewGroup.LayoutParams(r12, r0));
    L6:
        if (r12 > 0) goto L8;
        r0 = r13;
        r12 = -2;
        r14 = 1;
        goto L12
    L8:
        if (r13 > 0) goto L10;
        r14 = 2;
        goto L12
    L10:
        r0 = r13;
        r14 = 0;
        goto L12
    }

    public static boolean i(ImagePipeline r10, ImageRequest[] r11, int r12, DataSubscriber<CloseableReference<CloseableImage>> r13) {
        if (r12 < r11.length) goto L6;
        return false;
    L6:
        com.bytedance.android.ec.core.imagex.r r1 = null;
        if (m() == false) goto L11;
        ImageExperiments.G.getClass();
        if (ImageExperiments.c() == false) goto L11;
        r1 = com.bytedance.android.ec.core.imagex.t.a(null);
    L11:
        r10.fetchDecodedImage(r11[r12], r1).subscribe(r13, UiThreadImmediateExecutorService.getInstance());
        return true;
    }

    public static void l(ECUrlModel r10, int r11, int r12, final c<Bitmap> r13) {
        ImageExperiments.G.getClass();
        ResizeOptions r1 = null;
        if (ImageExperiments.c() == false) goto L5;
        com.bytedance.android.ec.core.imagex.r r14 = com.bytedance.android.ec.core.imagex.t.a(null);
    L7:
        if (m() == false) goto L20;
        if (r10 == null) goto L20;
        if ((r14 instanceof com.bytedance.android.ec.core.imagex.r) == false) goto L20;
        Integer r15 = Integer.valueOf(r11);
        Integer r16 = Integer.valueOf(r12);
        Function1 r17 = new x(r13);
        KProperty[] r18 = ImageExtensionsKt.a;
        Intrinsics.checkNotNullParameter(r10, "$this$fetchImage");
        List r19 = r10.getUrlList();
        if (r19 != null) goto L14;
        return;
    L14:
        if ((!r19.isEmpty()) == false) goto L16;
        List r20 = r19;
    L17:
        if (r20 == null) goto L38;
        ImageExtensionsKt.g(r20, r14, r15, r16, null, r17);
        return;
    L38:
        return;
    L16:
        r20 = null;
    L20:
        if ((r14 instanceof com.bytedance.android.ec.core.imagex.r) == false) goto L22;
        com.bytedance.android.ec.core.imagex.u r0 = new com.bytedance.android.ec.core.imagex.u(r14);
        r14 = r0;
    L23:
        if (r0 == null) goto L25;
        r0.B();
    L25:
        ImagePipeline r21 = ImagePipelineFactory.getInstance().getImagePipeline();
        if (r11 <= 0) goto L29;
        if (r12 <= 0) goto L29;
        r1 = new ResizeOptions(r11, r12);
    L29:
        ImageRequest[] r22 = h(r10, r1);
        if (r22.length == 0) goto L40;
        DataSource r23 = r21.fetchDecodedImage(r22[0], r14);
        if (r0 == null) goto L35;
        r0.C(r1);
        r0.k();
    L35:
        r23.subscribe(new z(r23, r13), CallerThreadExecutor.getInstance());
        return;
    L40:
        return;
    L22:
        r0 = null;
        goto L23
    L5:
        r14 = null;
        goto L7
    }

    public static void c(GenericDraweeView r16, ECUrlModel r17, int r18, int r19, z53.a r20) {
        if (r16 == null) goto L32;
        if (r17 != null) goto L6;
        return;
    L6:
        if (r17.getUrlList() != null) goto L8;
        return;
    L8:
        if (r17.getUrlList().size() != 0) goto L11;
        return;
    L11:
        if (m() == false) goto L14;
        ImageExtensionsKt.r(r16, r17, null, null, Integer.valueOf(r18), Integer.valueOf(r19), null, null, r20, true, null, null, null, null);
        return;
    L14:
        com.bytedance.android.ec.core.imagex.r r10 = j(r16);
        if (r18 <= 0) goto L18;
        if (r19 <= 0) goto L18;
        ResizeOptions r11 = new ResizeOptions(r18, r19);
    L19:
        ImageRequest[] r1 = h(r17, r11);
        if (r1 != null) goto L22;
        return;
    L22:
        if (r1.length == 0) goto L37;
        PipelineDraweeControllerBuilder r12 = Fresco.newDraweeControllerBuilder().setOldController(r16.getController()).setFirstAvailableImageRequests(r1);
        if (r20 == null) goto L27;
        r12.setControllerListener(r20);
    L27:
        AbstractDraweeController r13 = r12.setCallerContext(r10).build();
        if ((r10 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L30;
        com.bytedance.android.ec.core.imagex.u r14 = (com.bytedance.android.ec.core.imagex.u) r10;
        r14.C(r11);
        r14.k();
    L30:
        r16.setController(r13);
        return;
    L37:
        return;
    L18:
        r11 = null;
        goto L19
    }

    public static void e(GenericDraweeView r14, String r15, int r16, int r17, w r18) {
        if (r14 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r15) == true) goto L36;
        ControllerListener<? super ImageInfo> r10 = null;
        if (m() == false) goto L14;
        if (r18 == null) goto L11;
        ControllerListener<? super ImageInfo> r11 = r18.a;
        Function1<? super DraweeController, Unit> r12 = r18.b;
        ControllerListener<? super ImageInfo> r13 = r11;
    L12:
        ImageExtensionsKt.s(r14, r15, null, null, Integer.valueOf(r16), Integer.valueOf(r17), null, null, r13, true, null, r12, null);
        return;
    L11:
        r13 = null;
        r12 = null;
        goto L12
    L14:
        com.bytedance.android.ec.core.imagex.r r19 = j(r14);
        if (r16 <= 0) goto L18;
        if (r17 <= 0) goto L18;
        ResizeOptions r20 = new ResizeOptions(r16, r17);
    L19:
        ImageRequestBuilder r1 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r15));
        if (r20 == null) goto L22;
        r1.setResizeOptions(r20);
    L22:
        PipelineDraweeControllerBuilder r21 = Fresco.newDraweeControllerBuilder().setOldController(r14.getController()).setImageRequest(r1.build()).setCallerContext(r19);
        if (r18 == null) goto L25;
        r10 = r18.a;
    L25:
        AbstractDraweeController r22 = r21.setControllerListener(r10).build();
        if (r18 == null) goto L31;
        Function1<? super DraweeController, Unit> r23 = r18.b;
        if (r23 == null) goto L31;
        r23.invoke(r22);
    L31:
        if ((r19 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L33;
        com.bytedance.android.ec.core.imagex.u r24 = (com.bytedance.android.ec.core.imagex.u) r19;
        r24.C(r20);
        r24.k();
    L33:
        r14.setController(r22);
        return;
    L18:
        r20 = null;
        goto L19
    }

    public static void f(GenericDraweeView r13, String r14, int r15, int r16, ControllerListener r17) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r14) == false) goto L8;
        return;
    L8:
        if (m() == false) goto L11;
        ImageExtensionsKt.s(r13, r14, null, null, Integer.valueOf(r15), Integer.valueOf(r16), null, null, r17, true, null, null, null);
        return;
    L11:
        com.bytedance.android.ec.core.imagex.r r10 = j(r13);
        if (r15 <= 0) goto L15;
        if (r16 <= 0) goto L15;
        ResizeOptions r11 = new ResizeOptions(r15, r16);
    L16:
        ImageRequestBuilder r1 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r14));
        if (r11 == null) goto L19;
        r1.setResizeOptions(r11);
    L19:
        ImageRequest r12 = r1.build();
        AbstractDraweeController r18 = Fresco.newDraweeControllerBuilder().setOldController(r13.getController()).setControllerListener(r17).setImageRequest(r12).setCallerContext(r10).build();
        if ((r10 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L22;
        com.bytedance.android.ec.core.imagex.u r19 = (com.bytedance.android.ec.core.imagex.u) r10;
        r19.C(r11);
        r19.k();
    L22:
        r13.setController(r18);
        return;
    L15:
        r11 = null;
        goto L16
    }
}

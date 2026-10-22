package com.bytedance.android.ec.core.utils;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.android.ec.core.widget.ECLiveExplainWaveView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.core.widget.ECPromotionImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotionBottomBanner;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECLiveImageUtils {

    public static class ECNetImageInfo implements Serializable {
        public static final int WRAP_IMAGE = -3;
        public boolean autoPlayAnimations;
        public boolean autoScaleOneSide;
        public boolean disableFade;
        public boolean disablePlaceholder;
        public int height;
        public int placeholderImage;
        public int roundDp;
        public String url;
        public int width;

        public ECNetImageInfo() {
            this.width = -3;
            this.height = -3;
            this.roundDp = 0;
            this.placeholderImage = 0;
            this.autoPlayAnimations = false;
            this.disableFade = false;
            this.disablePlaceholder = false;
        }
    }

    public class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ SimpleDraweeView d;
        public final /* synthetic */ ECUrlModel e;

        public final void onIntermediateImageSet(String r10, Object r11) {
            ImageInfo r12 = (ImageInfo) r11;
            if (this.a == true) goto L5;
        L9:
            ECLiveImageUtils.a(this.d, r12);
        L10:
            this.d.setTag(2131368899, this.e.getUri());
            return;
        L5:
            if (this.b <= 0) goto L9;
            if (this.c <= 0) goto L9;
            ECNetImageInfo r13 = new ECNetImageInfo();
            r13.width = this.b;
            r13.height = this.c;
            ECLiveImageUtils.l(this.d, r12, r13);
            goto L10
        }

        public final void onFinalImageSet(String r1, Object r10, Animatable r11) {
            ImageInfo r12 = (ImageInfo) r10;
            if (this.a == true) goto L5;
        L9:
            ECLiveImageUtils.a(this.d, r12);
        L10:
            this.d.setTag(2131368899, this.e.getUri());
            return;
        L5:
            if (this.b <= 0) goto L9;
            if (this.c <= 0) goto L9;
            ECNetImageInfo r13 = new ECNetImageInfo();
            r13.width = this.b;
            r13.height = this.c;
            ECLiveImageUtils.l(this.d, r12, r13);
            goto L10
        }

        public a(boolean r1, int r10, int r11, SimpleDraweeView r12, ECUrlModel r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }
    }

    public class b implements Function1<DraweeController, Unit> {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            DraweeController r11 = (DraweeController) r10;
            Function1 r0 = this.a;
            if (r0 == null) goto L7;
            r0.invoke(r11);
            return null;
        L7:
            return null;
        }
    }

    public class c extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ SimpleDraweeView d;
        public final /* synthetic */ ECUrlModel e;

        public final void onIntermediateImageSet(String r10, Object r11) {
            ImageInfo r12 = (ImageInfo) r11;
            if (this.a == true) goto L5;
        L9:
            ECLiveImageUtils.a(this.d, r12);
        L10:
            this.d.setTag(2131368899, this.e.getUri());
            return;
        L5:
            if (this.b <= 0) goto L9;
            if (this.c <= 0) goto L9;
            ECNetImageInfo r13 = new ECNetImageInfo();
            r13.width = this.b;
            r13.height = this.c;
            ECLiveImageUtils.l(this.d, r12, r13);
            goto L10
        }

        public final void onFinalImageSet(String r1, Object r10, Animatable r11) {
            ImageInfo r12 = (ImageInfo) r10;
            if (this.a == true) goto L5;
        L9:
            ECLiveImageUtils.a(this.d, r12);
        L10:
            this.d.setTag(2131368899, this.e.getUri());
            return;
        L5:
            if (this.b <= 0) goto L9;
            if (this.c <= 0) goto L9;
            ECNetImageInfo r13 = new ECNetImageInfo();
            r13.width = this.b;
            r13.height = this.c;
            ECLiveImageUtils.l(this.d, r12, r13);
            goto L10
        }

        public c(boolean r1, int r10, int r11, SimpleDraweeView r12, ECUrlModel r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }
    }

    public static boolean k() {
        if (((Boolean) ImageSettings.a.getValue()).booleanValue() == false) goto L7;
        ImageExperiments.G.getClass();
        if (ImageExperiments.c() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static com.bytedance.android.ec.core.imagex.r e(GenericDraweeView r10) {
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

    public static void a(SimpleDraweeView r10, ImageInfo r11) {
        if (r11 == null) goto L5;
        r10.getLayoutParams().width = r11.getWidth();
        r10.getLayoutParams().height = -2;
        r10.setAspectRatio(r11.getWidth() / r11.getHeight());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(final ECNetImageView r16, final ECNetImageInfo r17) {
        if (r16 == 0) goto L34;
        if (r17 == null) goto L37;
        PipelineDraweeControllerBuilder r0 = Fresco.newDraweeControllerBuilder();
        e0 r10 = new e0();
        Context r15 = r16.getContext();
        if (r17.width > 0) goto L9;
    L11:
        r10.a = new d0(r16, r17);
        if (k() == true) goto L14;
    L16:
        r0.setControllerListener(r10);
        String r1 = r17.url;
        if (r1 == null) goto L19;
        r0.setUri(UriProtector.parse(r1));
    L19:
        r0.setAutoPlayAnimations(r17.autoPlayAnimations);
        r0.setCallerContext(e(r16));
        r16.setController(r0.build());
    L20:
        GenericDraweeHierarchy r11 = r16.getHierarchy();
        if (r15 == null) goto L35;
        if (r11 != null) goto L24;
        return;
    L24:
        if (r17.disableFade == false) goto L27;
        r11.setFadeDuration(0);
    L27:
        if (r17.disablePlaceholder == true) goto L32;
        int r12 = r17.placeholderImage;
        if (r12 == 0) goto L31;
        r11.setPlaceholderImage(r12);
        goto L32
    L31:
        r11.setPlaceholderImage(2131234648);
    L32:
        RoundingParams r13 = new RoundingParams();
        r13.setCornersRadius(d(r15, r17.roundDp));
        r11.setRoundingParams(r13);
        return;
    L35:
        return;
    L14:
        if (r17.url == null) goto L16;
        ImageExtensionsKt.s(r16, r17.url, null, null, null, null, null, null, r10, true, null, null, null);
        goto L20
    L9:
        if (r17.height <= 0) goto L11;
        r16.getLayoutParams().width = d(r15, r17.width);
        r16.getLayoutParams().height = d(r15, r17.height);
        goto L11
    L37:
        return;
    }

    public static int d(Context r1, float r10) {
        Resources r11 = r1.getResources();
        return (int) ((r10 * WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density) + 0.5f);
    }

    public static void f(String r10, o r11) {
        ImagePipeline r0 = ImagePipelineFactory.getInstance().getImagePipeline();
        Priority r1 = Priority.MEDIUM;
        Bitmap.Config r12 = Bitmap.Config.RGB_565;
        if (k() == true) goto L5;
    L13:
        ImageDecodeOptionsBuilder r13 = new ImageDecodeOptionsBuilder();
        r13.setBitmapConfig(r12);
        r13.setPreDecodeFrameCount(1);
        r13.setDecodeAllFrames(false);
        ImageDecodeOptions r14 = new ImageDecodeOptions(r13);
        ImageRequest r15 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r10)).setRequestPriority(r1).setImageDecodeOptions(r14).build();
    L14:
        DataSource r16 = r0.fetchDecodedImage(r15, null);
        r16.subscribe(new f0(r16, r11), CallerThreadExecutor.getInstance());
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        ArrayList r17 = new ArrayList();
        r17.add(r10);
        Pair<List<ImageRequest>, com.bytedance.android.ec.core.imagex.r> r18 = ImageExtensionsKt.m(r17, -1, -1, null, null);
        if (r18 == null) goto L13;
        if (r18.getFirst() == null) goto L13;
        if (((List) r18.getFirst()).isEmpty() == true) goto L13;
        r15 = (ImageRequest) ListProtector.get((List) r18.getFirst(), 0);
        goto L14
    }

    public static void g(ECPromotionImageView r10, String r11) {
        r10.getClass();
        if (TextUtils.isEmpty(r11) == true) goto L5;
        r10.d.setVisibility(0);
        i(r10.d, r11, r10.getImageRadius(), R.color.transparent);
        return;
    L5:
        SimpleDraweeView r12 = r10.d;
        if (r12 == null) goto L10;
        r12.setVisibility(8);
        return;
    }

    public static void j(SimpleDraweeView r14, String r15) {
        if (r14 == null) goto L11;
        if (r15 != null) goto L6;
        return;
    L6:
        if (k() == false) goto L9;
        ImageExtensionsKt.s(r14, r15, null, null, null, null, null, null, null, true, null, null, null);
        return;
    L9:
        r14.setController(Fresco.newDraweeControllerBuilder().setOldController(r14.getController()).setCallerContext(e(r14)).setUri(UriProtector.parse(r15)).build());
        return;
    }

    public static void l(SimpleDraweeView r10, ImageInfo r11, ECNetImageInfo r12) {
        if (r11 == null) goto L22;
        int r0 = r12.width;
        if (r0 != (-3)) goto L6;
        r0 = r11.getWidth();
    L6:
        int r13 = r12.height;
        if (r13 != (-3)) goto L10;
        r13 = r11.getHeight();
    L10:
        if (r12.autoScaleOneSide == false) goto L19;
        ViewGroup.LayoutParams r1 = r10.getLayoutParams();
        int r14 = r12.width;
        int r15 = -2;
        if (r14 != (-3)) goto L14;
        r14 = -2;
    L14:
        r1.width = r14;
        ViewGroup.LayoutParams r16 = r10.getLayoutParams();
        int r17 = r12.height;
        if (r17 == (-3)) goto L18;
        r15 = r17;
    L18:
        r16.height = r15;
    L20:
        r10.setAspectRatio(r11.getWidth() / r11.getHeight());
        return;
    L19:
        r10.getLayoutParams().width = r0;
        r10.getLayoutParams().height = r13;
        goto L20
    }

    public static void c(SimpleDraweeView r16, ECUrlModel r17, boolean r18, Function1<DraweeController, Unit> r19) {
        if (r16 == null) goto L29;
        if (r17 != null) goto L6;
        return;
    L6:
        if (r17.getUrlList() != null) goto L8;
        return;
    L8:
        if (r17.getUrlList().isEmpty() == true) goto L33;
        int r10 = d(r16.getContext(), r17.getWidth());
        int r11 = d(r16.getContext(), r17.getHeight());
        if (r10 <= 0) goto L14;
        if (r11 <= 0) goto L14;
        ResizeOptions r0 = new ResizeOptions(r10, r11);
    L15:
        String r1 = (String) ListProtector.get(r17.getUrlList(), 0);
        if (r1 != null) goto L18;
        r1 = "";
    L18:
        String r12 = r1;
        if (k() == false) goto L21;
        ImageExtensionsKt.s(r16, r12, null, null, Integer.valueOf(r10), Integer.valueOf(r11), null, null, new a(r18, r10, r11, r16, r17), true, null, new b(r19), null);
        return;
    L21:
        ImageRequestBuilder r13 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r12));
        if (r0 == null) goto L24;
        r13.setResizeOptions(r0);
    L24:
        AbstractDraweeController r14 = Fresco.newDraweeControllerBuilder().setControllerListener(new c(r18, r10, r11, r16, r17)).setOldController(r16.getController()).setImageRequest(r13.build()).setCallerContext(e(r16)).build();
        if (r19 == null) goto L27;
        r19.invoke(r14);
    L27:
        r16.setController(r14);
        return;
    L14:
        r0 = null;
        goto L15
    L33:
        return;
    }

    public static void i(SimpleDraweeView r15, String r16, int r17, int r18) {
        if (r15 == null) goto L18;
        if (r16 != null) goto L7;
        return;
    L7:
        if (k() == false) goto L9;
        ImageExtensionsKt.s(r15, r16, null, null, null, null, null, null, null, true, null, null, null);
    L10:
        Context r0 = r15.getContext();
        GenericDraweeHierarchy r1 = r15.getHierarchy();
        if (r0 == null) goto L19;
        if (r1 == null) goto L20;
        if (r18 == 0) goto L15;
        r1.setPlaceholderImage(r18);
    L16:
        RoundingParams r10 = new RoundingParams();
        r10.setCornersRadius(d(r0, r17));
        r1.setRoundingParams(r10);
        return;
    L15:
        r1.setPlaceholderImage(2131234648);
        goto L16
    L20:
        return;
    L19:
        return;
    L9:
        PipelineDraweeControllerBuilder r11 = Fresco.newDraweeControllerBuilder();
        r11.setUri(UriProtector.parse(r16));
        r11.setCallerContext(e(r15));
        r15.setController(r11.build());
        goto L10
    }

    public static void h(ECPromotionImageView r10, ECUIPromotion r11, int r12, boolean r13, boolean r14) {
        String r0 = r11.getImageUrl();
        String r1 = r11.soldHint;
        ECPromotionBottomBanner r15 = r11.bottomBanner;
        if (r12 != 1) goto L6;
        r10.B(r0);
    L34:
        if (r13 == false) goto L42;
        r10.getClass();
        if (ECAppInfoService.h() == false) goto L41;
        r10.i.setVisibility(0);
        if (r14 == false) goto L40;
        r10.h.setVisibility(8);
        r10.h.clearAnimation();
        goto L42
    L40:
        r10.h.setVisibility(0);
        r10.h.setAnimation(r10.n);
        r10.h.playAnimation();
        r10.h.loop(true);
        goto L42
    L41:
        r10.f.setVisibility(0);
        ECLiveExplainWaveView r16 = r10.g.a;
        r16.k = true;
        r16.invalidate();
    L42:
        r10.getClass();
        if (r13 == false) goto L46;
        if (r15 == null) goto L46;
        r10.l.setVisibility(0);
        r10.k.setText(r15.getText());
        c(r10.l, r15.getRightIcon(), true, null);
        return;
    L46:
        r10.l.setVisibility(8);
        TextView r17 = r10.k;
        r17.setText(th.a.g(r17.getContext(), 2131896484));
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r10.getClass();
        if (TextUtils.isEmpty(r1) == false) goto L10;
        r10.B(r0);
        r10.e.setText(2131896833);
        r10.e.setVisibility(0);
        goto L34
    L10:
        r10.B(r0);
        TextView r18 = r10.e;
        r18.setText(r18.getContext().getString(2131896832, new Object[]{r1}));
        r10.e.setVisibility(0);
        goto L34
    L12:
        if (r12 != 4) goto L14;
    L32:
        r10.B(r0);
        r10.e.setText(2131896833);
        r10.e.setVisibility(0);
        goto L34
    L14:
        if (r12 == 3) goto L32;
        if (r12 != 5) goto L20;
        r10.B(r0);
        r10.e.setText(2131896917);
        r10.e.setVisibility(0);
        goto L34
    L20:
        if (r12 != 2) goto L23;
        r10.B(r0);
        r10.e.setText(2131896740);
        r10.e.setVisibility(0);
        goto L34
    L23:
        if (r12 != 7000) goto L26;
        r10.B(r0);
        goto L34
    L26:
        if (r12 != 8000) goto L28;
    L31:
        r10.B(r0);
        goto L34
    L28:
        if (r12 == 9000) goto L31;
        r10.B(r0);
        r10.e.setText(2131896740);
        r10.e.setVisibility(0);
        goto L34
    }
}

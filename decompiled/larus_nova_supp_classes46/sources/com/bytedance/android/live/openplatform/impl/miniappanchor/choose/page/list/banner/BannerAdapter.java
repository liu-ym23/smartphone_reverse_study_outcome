package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/banner/BannerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerAdapter extends PagerAdapter {
    public List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> a;
    public final lp0.a b;
    public final a c;

    public interface a {
        void a(com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a r1);
    }

    public static final class b implements ImageOriginListener {
        public b() {
        }

        public final void onImageLoaded(String r2, int r3, boolean r4) {
            int r5 = qo0.a.a;
            qo0.a.c("choose_list", "on banner image loaded, origin: " + r3 + ", successful: " + r4);
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ String a;

        public c(String r1) {
            this.a = r1;
        }

        public final void onFailure(String r2, Throwable r3) {
            qo0.a.b("choose_list", "on banner image load fail", r3);
        }

        public final void onSubmit(String r1, Object r2) {
            int r3 = qo0.a.a;
            qo0.a.c("choose_list", "on banner image loaded, url: " + this.a);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            qo0.a.c("choose_list", "on banner image load success");
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ BannerAdapter a;
        public final /* synthetic */ int b;

        public d(BannerAdapter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            BannerAdapter r4 = this.a;
            r4.c.a((com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a) ListProtector.get(r4.a, this.b));
        }
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "object");
        if (r2 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getCount() {
        return this.a.size();
    }

    public BannerAdapter(lp0.a r2, com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.c r3) {
        Intrinsics.checkNotNullParameter(r3, "clickCallback");
        this.b = r2;
        this.c = r3;
        this.a = CollectionsKt.emptyList();
    }

    public final Object instantiateItem(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "container");
        SimpleDraweeView r0 = new SimpleDraweeView(r9.getContext());
        GenericDraweeHierarchy r1 = r0.getHierarchy();
        r1.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r1.setRoundingParams(RoundingParams.fromCornersRadius(UtilityKotlinExtentionsKt.h(2)));
        r1.setFailureImage(new ColorDrawable(-3355444));
        ImageModel r2 = ((com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a) ListProtector.get(this.a, r10)).imageUrl;
        Object r3 = null;
        if (r2 == null) goto L7;
        List r4 = r2.getUrls();
        if (r4 == null) goto L7;
        String r5 = (String) CollectionsKt.firstOrNull(r4);
    L9:
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L51;
        ViewGroup.LayoutParams r7 = r9.getLayoutParams();
        ViewParent r8 = r9.getParent();
        if ((r8 instanceof View) == false) goto L20;
        r3 = r8;
    L20:
        View r11 = (View) r3;
        if (r11 == null) goto L24;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L24;
    L26:
        if (r9.getWidth() > 0) goto L28;
    L30:
        boolean r13 = false;
    L31:
        if (true != r13) goto L33;
        Pair r14 = TuplesKt.to(Integer.valueOf(r9.getWidth()), Integer.valueOf(r9.getHeight()));
    L50:
        r0.setController(Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r5)).enableResizedImageDiskCache(true).setResizeOptions(ResizeOptions.forDimensions(((Number) r14.getFirst()).intValue(), ((Number) r14.getSecond()).intValue())).build()).setImageOriginListener(new b()).setControllerListener(new c(r5)).build());
        goto L51
    L33:
        int r15 = r7.width;
        if (r15 > 0) goto L36;
    L38:
        boolean r16 = false;
    L39:
        if (true != r16) goto L41;
        r14 = TuplesKt.to(Integer.valueOf(r15), Integer.valueOf(r7.height));
        goto L50
    L41:
        int r17 = r12.width;
        if (r17 > 0) goto L44;
    L46:
        boolean r18 = false;
    L47:
        if (true != r18) goto L49;
        r14 = TuplesKt.to(Integer.valueOf(r17), Integer.valueOf(r12.height));
        goto L50
    L49:
        r14 = TuplesKt.to(0, 0);
        goto L50
    L44:
        if (r12.height <= 0) goto L46;
        r18 = true;
        goto L47
    L36:
        if (r7.height <= 0) goto L38;
        r16 = true;
        goto L39
    L28:
        if (r9.getHeight() <= 0) goto L30;
        r13 = true;
    L24:
        r12 = new ViewGroup.LayoutParams(-1, -2);
    L51:
        r0.setOnClickListener(new d(this, r10));
        r9.addView(r0);
        return r0;
    L11:
        if (r5.length() == 0) goto L14;
        r6 = false;
    L7:
        r5 = null;
        goto L9
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "object");
        r1.removeView((View) r3);
    }
}

package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a.\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/facebook/drawee/controller/AbstractDraweeController;", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LikeEggView$prepareToActiveController$2 extends Lambda implements Function0<AbstractDraweeController<Object, Object>> {
    final /* synthetic */ Context $context;
    final /* synthetic */ LikeEggView this$0;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ LikeEggView$prepareToActiveController$2 a;

        public a(LikeEggView$prepareToActiveController$2 r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
            r3 = null;
        L5:
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            if (r5 == null) goto L9;
            com.bytedance.android.live.core.utils.fresco.c.c(r5);
            r5.setAnimationListener(new i(this));
            return;
        }
    }

    public LikeEggView$prepareToActiveController$2(LikeEggView r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    public final AbstractDraweeController<Object, Object> invoke() {
        ImageDecodeOptionsBuilder r0 = new ImageDecodeOptionsBuilder().setDecodeAllFrames(false);
        PipelineDraweeControllerBuilder r1 = Fresco.newDraweeControllerBuilder();
        String r2 = LikeEggHelper.c;
        PipelineDraweeController r3 = r1.setImageRequest(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r2)).setImageDecodeOptions(r0.build()).build()).setAutoPlayAnimations(true).setControllerListener(new a(this)).build();
        if ((r3 instanceof PipelineDraweeController) == true) goto L5;
        PipelineDraweeController r4 = null;
    L6:
        PipelineDraweeController r5 = r4;
        if (r5 == null) goto L9;
        com.bytedance.android.live.core.utils.fresco.c.a(r5, this.$context, r2);
    L9:
        return r3;
    L5:
        r4 = r3;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m884invoke() {
        return invoke();
    }
}

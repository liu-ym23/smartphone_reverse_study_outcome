package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.c5;
import com.bytedance.android.livesdk.d5;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.ui.image.FrescoImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013BE\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0018\u0010\t\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/MultiLinkCustomFrescoImageView;", "Lcom/lynx/tasm/ui/image/FrescoImageView;", "Lcom/facebook/drawee/interfaces/DraweeController;", "draweeController", "", "setController", "Landroid/content/Context;", "context", "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;", "draweeControllerBuilder", "Lcom/lynx/tasm/ui/image/e;", "globalImageLoadListener", "", "callerContext", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "lynxBaseUI", "<init>", "(Landroid/content/Context;Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;Lcom/lynx/tasm/ui/image/e;Ljava/lang/Object;Lcom/lynx/tasm/behavior/ui/LynxBaseUI;)V", "Companion", "b", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkCustomFrescoImageView extends FrescoImageView {
    public static final b Companion = null;
    public static final String TAG = "MultiLinkCustomFrescoImageView";

    public static final class a extends BaseControllerListener<ImageInfo> {
        public a() {
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            ImageInfo r5 = (ImageInfo) r3;
            if ((r4 instanceof AnimatedDrawable2) == true) goto L5;
            return;
        L5:
            if ((r5 instanceof CloseableAnimatedImage) == true) goto L7;
            return;
        L7:
            if (((Boolean) d5.a.getValue()).booleanValue() == false) goto L15;
            AnimatedDrawable2 r6 = (AnimatedDrawable2) r4;
            AnimationBackend r7 = r6.getAnimationBackend();
            if (r7 == null) goto L11;
            r6.setAnimationBackend(new n(r7, r6.getLoopCount()));
        L11:
            r6.setPrivateFrameSchedulerFactory(new com.bytedance.android.live.h());
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        x6a.d.a(this, r1, r2);
    }

    public /* bridge */ /* synthetic */ void applyRendererOpacity(float r1) {
        x6a.d.b(this, r1);
    }

    public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r1) {
        x6a.d.c(this, r1);
    }

    public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return x6a.d.d(this, r1);
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public /* bridge */ /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setController(DraweeController r5) {
        if (r5 != null) goto L4;
    L6:
        super/*com.facebook.drawee.view.DraweeView*/.setController(r5);
        return;
    L4:
        if (((Boolean) c5.a.getValue()).booleanValue() == false) goto L6;
        PipelineDraweeController r0 = (PipelineDraweeController) r5;
        String r1 = r0.getImageRequest().getSourceUri().toString();
        com.bytedance.android.live.core.utils.fresco.e.a(getContext(), r0, r1, true);
        goto L6
    }

    public MultiLinkCustomFrescoImageView(Context r2, AbstractDraweeControllerBuilder<?, ?, ?, ?> r3, com.lynx.tasm.ui.image.e r4, Object r5, LynxBaseUI r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "lynxBaseUI");
        super(r2, r3, r4, r5, r6);
        setControllerListener(new a());
    }
}

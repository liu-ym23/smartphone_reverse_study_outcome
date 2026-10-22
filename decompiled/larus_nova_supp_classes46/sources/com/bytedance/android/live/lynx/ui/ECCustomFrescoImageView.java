package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.ui.image.FrescoImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/ECCustomFrescoImageView;", "Lcom/lynx/tasm/ui/image/FrescoImageView;", "Landroid/content/Context;", "context", "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;", "draweeControllerBuilder", "Lcom/lynx/tasm/ui/image/e;", "globalImageLoadListener", "", "callerContext", "<init>", "(Landroid/content/Context;Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;Lcom/lynx/tasm/ui/image/e;Ljava/lang/Object;)V", "Companion", "b", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCustomFrescoImageView extends FrescoImageView {
    public static final b Companion = null;
    public static final String TAG = "ECCustomImageView";

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ ECCustomFrescoImageView a;

        public a(ECCustomFrescoImageView r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            CloseableAnimatedImage r5 = (ImageInfo) r3;
            if ((r4 instanceof AnimatedDrawable2) == true) goto L5;
            return;
        L5:
            if ((r5 instanceof CloseableAnimatedImage) == false) goto L14;
            AnimatedImage r6 = r5.getImage();
            if (r6 == null) goto L15;
            int r7 = r6.getLoopCount();
            if (ECCustomFrescoImageView.access$getLoopCount(this.a) <= 0) goto L11;
            r7 = ECCustomFrescoImageView.access$getLoopCount(this.a);
        L11:
            AnimatedDrawable2 r8 = (AnimatedDrawable2) r4;
            r8.setAnimationBackend(new l8a.b(r8.getAnimationBackend(), r7));
            m8a.e.c(r8);
            return;
        L15:
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

    public static final /* synthetic */ int access$getLoopCount(ECCustomFrescoImageView r0) {
        return r0.getLoopCount();
    }

    public ECCustomFrescoImageView(Context r2, AbstractDraweeControllerBuilder<?, ?, ?, ?> r3, com.lynx.tasm.ui.image.e r4, Object r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
        setControllerListener(new a(this));
    }
}

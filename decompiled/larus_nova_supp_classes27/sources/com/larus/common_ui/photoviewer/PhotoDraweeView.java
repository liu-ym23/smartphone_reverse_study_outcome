package com.larus.common_ui.photoviewer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.ScrollingView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import j19.h;
import j19.l;
import k19.c;
import k19.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001cH\u0004J\u0010\u0010E\u001a\u00020C2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J\u001a\u0010F\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010G\u001a\u00020C2\b\u0010H\u001a\u0004\u0018\u00010\fH\u0004J\u0010\u0010I\u001a\u00020C2\u0006\u0010H\u001a\u00020\fH\u0004J\u000e\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020*J\u0012\u0010P\u001a\u00020C2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010S\u001a\u00020C2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\u0012\u0010T\u001a\u00020C2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\u0010\u0010U\u001a\u00020C2\u0006\u0010V\u001a\u00020WH\u0014J\u0010\u0010X\u001a\u00020*2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020\bH\u0016J\b\u0010^\u001a\u00020\bH\u0016J\b\u0010_\u001a\u00020\bH\u0016J\b\u0010`\u001a\u00020\bH\u0016J\b\u0010a\u001a\u00020\bH\u0016J\b\u0010b\u001a\u00020\bH\u0016J\b\u0010c\u001a\u00020CH\u0016J0\u0010d\u001a\u00020C2\u0006\u0010e\u001a\u00020*2\u0006\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\b2\u0006\u0010i\u001a\u00020\bH\u0014J\b\u0010j\u001a\u00020CH\u0002J\b\u0010k\u001a\u00020CH\u0002J\b\u0010l\u001a\u00020CH\u0004R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010$8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010+\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u00100\u001a\u00020/2\u0006\u0010\u001d\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R&\u00105\u001a\u00020/2\u0006\u0010\u001d\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R&\u00109\u001a\u0002082\u0006\u0010\u001d\u001a\u0002088F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00160?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010L\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020*@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010,\"\u0004\bM\u0010.R$\u0010N\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020*@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010,\"\u0004\bO\u0010.¨\u0006m"}, d2 = {"Lcom/larus/common_ui/photoviewer/PhotoDraweeView;", "Lcom/facebook/drawee/view/GenericDraweeView;", "Landroidx/core/view/ScrollingView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageBounds", "Landroid/graphics/RectF;", "viewBounds", "zoomableController", "Lcom/larus/common_ui/photoviewer/ZoomableControllerImp;", "gestureDetector", "Landroid/view/GestureDetector;", "tapListenerWrapper", "Lcom/larus/common_ui/photoviewer/gestures/GestureListenerWrapper;", "controllerListener", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "getControllerListener", "()Lcom/facebook/drawee/controller/BaseControllerListener;", "setControllerListener", "(Lcom/facebook/drawee/controller/BaseControllerListener;)V", "defaultGestureHandler", "Lcom/larus/common_ui/photoviewer/gestures/DefaultGestureHandler;", "value", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "tapListener", "getTapListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "setTapListener", "(Landroid/view/GestureDetector$SimpleOnGestureListener;)V", "Lcom/larus/common_ui/photoviewer/ScaleFactorRetriever;", "scaleFactorRetriever", "getScaleFactorRetriever", "()Lcom/larus/common_ui/photoviewer/ScaleFactorRetriever;", "setScaleFactorRetriever", "(Lcom/larus/common_ui/photoviewer/ScaleFactorRetriever;)V", "", "isDoubleClickScaleEnabled", "()Z", "setDoubleClickScaleEnabled", "(Z)V", "", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "", "animationDuration", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "controllerListenerInternal", "Lcom/facebook/drawee/controller/ControllerListener;", "zoomableListener", "Lcom/larus/common_ui/photoviewer/ZoomableController$Listener;", "setGestureHandler", "", "gestureHandler", "setZoomableControllerImp", "inflateHierarchy", "getImageBounds", "outBounds", "getLimitBounds", "setHorizontalNestedScrollEnabled", "enabled", "isScaleEnabled", "setScaleEnabled", "isTranslationEnabled", "setTranslationEnabled", "setController", "controller", "Lcom/facebook/drawee/interfaces/DraweeController;", "removeControllerListener", "addControllerListener", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "canScrollVertically", "direction", "computeHorizontalScrollRange", "computeHorizontalScrollOffset", "computeHorizontalScrollExtent", "computeVerticalScrollRange", "computeVerticalScrollOffset", "computeVerticalScrollExtent", "computeScroll", "onLayout", "changed", "left", "top", "right", "bottom", "onFinalImageSet", "onRelease", "updateZoomableControllerBounds", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PhotoDraweeView extends GenericDraweeView implements ScrollingView {
    public static final /* synthetic */ int k = 0;
    public final RectF a;
    public final RectF b;
    public ZoomableControllerImp c;
    public GestureDetector d;
    public c e;
    public BaseControllerListener<Object> f;
    public k19.a g;
    public l h;
    public final a i;
    public final h j;

    public static final class a extends BaseControllerListener<Object> {
        public final /* synthetic */ PhotoDraweeView a;

        public a(PhotoDraweeView r1) {
            this.a = r1;
        }

        public final void onRelease(String r3) {
            Intrinsics.checkNotNullParameter(r3, "id");
            ZoomableControllerImp r0 = this.a.c;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
            r0 = null;
        L5:
            r0.f(false);
            BaseControllerListener<Object> r1 = this.a.getControllerListener();
            if (r1 == null) goto L9;
            r1.onRelease(r3);
            return;
        }

        public final void onFailure(String r2, Throwable r3) {
            super.onFailure(r2, r3);
            BaseControllerListener<Object> r0 = this.a.getControllerListener();
            if (r0 == null) goto L6;
            r0.onFailure(r2, r3);
            return;
        }

        public final void onIntermediateImageFailed(String r2, Throwable r3) {
            super.onIntermediateImageFailed(r2, r3);
            BaseControllerListener<Object> r0 = this.a.getControllerListener();
            if (r0 == null) goto L6;
            r0.onIntermediateImageFailed(r2, r3);
            return;
        }

        public final void onIntermediateImageSet(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            super.onIntermediateImageSet(r2, r3);
            BaseControllerListener<Object> r0 = this.a.getControllerListener();
            if (r0 == null) goto L6;
            r0.onIntermediateImageSet(r2, r3);
            return;
        }

        public final void onSubmit(String r2, Object r3) {
            super.onSubmit(r2, r3);
            BaseControllerListener<Object> r0 = this.a.getControllerListener();
            if (r0 == null) goto L6;
            r0.onSubmit(r2, r3);
            return;
        }

        public final void onFinalImageSet(String r5, Object r6, Animatable r7) {
            Intrinsics.checkNotNullParameter(r5, "id");
            PhotoDraweeView r0 = this.a;
            ZoomableControllerImp r1 = r0.c;
            ZoomableControllerImp r2 = null;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
            r1 = null;
        L6:
            if (r1.c == true) goto L12;
            ZoomableControllerImp r3 = r0.c;
            if (r3 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        L11:
            r2.f(true);
            r0.updateZoomableControllerBounds();
            goto L12
        L10:
            r2 = r3;
        L12:
            BaseControllerListener<Object> r4 = this.a.getControllerListener();
            if (r4 == null) goto L16;
            r4.onFinalImageSet(r5, r6, r7);
            return;
        }
    }

    public PhotoDraweeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PhotoDraweeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int computeHorizontalScrollExtent() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        return (int) r0.i.width();
    }

    public final int computeHorizontalScrollOffset() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        return (int) (r0.i.left - r0.k.left);
    }

    public final int computeHorizontalScrollRange() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        return (int) r0.k.width();
    }

    public final void computeScroll() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        if (r0.z.computeScrollOffset() == false) goto L9;
        int r1 = r0.z.getCurrX();
        int r2 = r0.z.getCurrY();
        r0.r.set(r0.t);
        Matrix r3 = r0.r;
        r3.postTranslate(r1, r2);
        r0.p(r3);
        r0.v(r0.r);
        return;
    }

    public final int computeVerticalScrollExtent() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        return (int) r0.i.height();
    }

    public final int computeVerticalScrollOffset() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        return (int) (r0.i.top - r0.k.top);
    }

    public final int computeVerticalScrollRange() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        return (int) r0.k.height();
    }

    public final long getAnimationDuration() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        return r0.x;
    }

    public final float getMaxScaleFactor() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L5:
        float r1 = r0.g;
        if (r1 == 0.0f) goto L8;
        return r1;
    L8:
        return r0.h;
    }

    public final float getMinScaleFactor() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        return r0.f;
    }

    public final GestureDetector.SimpleOnGestureListener getTapListener() {
        c r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
        r0 = null;
    L6:
        return r0.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateZoomableControllerBounds() {
        getHierarchy().getActualImageBounds(this.a);
        RectF r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "outBounds");
        r0.set(0.0f, 0.0f, getWidth(), getHeight());
        ZoomableControllerImp r1 = this.c;
        ZoomableControllerImp r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r1 = null;
    L5:
        RectF r3 = this.a;
        if (r3.equals(r1.j) == true) goto L8;
        r1.l.reset();
        r1.j.set(r3);
        r1.i();
        r1.d();
    L8:
        ZoomableControllerImp r4 = this.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L12:
        r2.h(this.b);
        return;
    L11:
        r2 = r4;
        goto L12
    }

    public final BaseControllerListener<Object> getControllerListener() {
        return this.f;
    }

    public final l getScaleFactorRetriever() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r1) {
        return super/*android.widget.ImageView*/.canScrollVertically(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        int r0 = r3.save();
        ZoomableControllerImp r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r1 = null;
    L5:
        r3.concat(r1.l);
        super/*android.widget.ImageView*/.onDraw(r3);
        r3.restoreToCount(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        super/*com.facebook.drawee.view.DraweeView*/.onTouchEvent(r6);
        GestureDetector r0 = this.d;
        ZoomableControllerImp r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        r0 = null;
    L5:
        r0.onTouchEvent(r6);
        ZoomableControllerImp r1 = this.c;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r1 = null;
    L9:
        if (r1.t(r6) == false) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        getParent().requestDisallowInterceptTouchEvent(false);
        MotionEvent r7 = MotionEvent.obtain(r6);
        r7.setAction(3);
        GestureDetector r3 = this.d;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        r3 = null;
    L15:
        r3.onTouchEvent(r7);
        ZoomableControllerImp r4 = this.c;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L19:
        r2.t(r7);
        r7.recycle();
        return false;
    L18:
        r2 = r4;
        goto L19
    }

    public final void setAnimationDuration(long r2) {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L5:
        r0.x = r2;
    }

    public void setController(DraweeController r3) {
        AbstractDraweeController r0 = getController();
        if ((r0 instanceof AbstractDraweeController) == false) goto L6;
        r0.removeControllerListener(this.i);
    L6:
        if ((r3 instanceof AbstractDraweeController) == false) goto L8;
        ((AbstractDraweeController) r3).addControllerListener(this.i);
    L8:
        super/*com.facebook.drawee.view.DraweeView*/.setController(r3);
    }

    public final void setControllerListener(BaseControllerListener<Object> r1) {
        this.f = r1;
    }

    public final void setDoubleClickScaleEnabled(boolean r2) {
        k19.a r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
        r0 = null;
    L5:
        r0.d = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setGestureHandler(k19.a r5) {
        Intrinsics.checkNotNullParameter(r5, "gestureHandler");
        this.g = r5;
        k19.a r1 = this.g;
        c r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
        r1 = null;
    L5:
        this.e = new c(r1);
        Context r3 = getContext();
        c r4 = this.e;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L9:
        GestureDetector r0 = new GestureDetector(r3, r2);
        this.d = r0;
        r0.setIsLongpressEnabled(true);
        r5.c = getScaleFactorRetriever();
        return;
    L8:
        r2 = r4;
        goto L9
    }

    public final void setHorizontalNestedScrollEnabled(boolean r2) {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L5:
        r0.v = r2;
    }

    public final void setMaxScaleFactor(float r2) {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L5:
        r0.g(r2);
    }

    public final void setMinScaleFactor(float r3) {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L6:
        if (r3 >= 1.0f) goto L8;
        r0.getClass();
        return;
    L8:
        if (r3 > r0.g) goto L14;
        r0.f = r3;
        return;
    }

    public final void setScaleEnabled(boolean r2) {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L5:
        r0.d = r2;
    }

    public final void setScaleFactorRetriever(l r2) {
        this.h = r2;
        k19.a r0 = this.g;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
        r0 = null;
    L6:
        r0.c = r2;
        return;
    }

    public final void setTapListener(GestureDetector.SimpleOnGestureListener r2) {
        c r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
        r0 = null;
    L5:
        r0.b = r2;
    }

    public final void setTranslationEnabled(boolean r2) {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        r0 = null;
    L5:
        r0.e = r2;
    }

    public final void setZoomableControllerImp(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zoomableController");
        this.c = r2;
        r2.b = this.j;
        setScaleFactorRetriever(new j19.a(r2));
    }

    public final void inflateHierarchy(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        GenericDraweeHierarchyBuilder r0 = new GenericDraweeHierarchyBuilder(r3.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchyInflater.updateBuilder(r0, r3, r4);
        setAspectRatio(r0.getDesiredAspectRatio());
        setHierarchy(r0.build());
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [j19.h] */
    public PhotoDraweeView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new RectF();
        this.b = new RectF();
        this.i = new a(this);
        this.j = new h(this);
        ZoomableControllerImp r4 = new ZoomableControllerImp(new e(), r1);
        setZoomableControllerImp(r4);
        setGestureHandler(new k19.a(r4));
    }

    public /* synthetic */ PhotoDraweeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.ImageView*/.onLayout(r1, r2, r3, r4, r5);
        updateZoomableControllerBounds();
    }
}

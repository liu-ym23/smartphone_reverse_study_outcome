package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ScrollingView;
import com.bytedance.bdlocation.BuildConfig;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0004J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0004J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\rR*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010 \u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020!8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/PhotoDraweeView;", "Lcom/facebook/drawee/view/GenericDraweeView;", "Landroidx/core/view/ScrollingView;", "Lba2/a;", "gestureHandler", BuildConfig.FLAVOR, "setGestureHandler", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/ZoomableControllerImp;", "zoomableController", "setZoomableControllerImp", "Lcom/facebook/drawee/interfaces/DraweeController;", "controller", "setController", "Landroid/graphics/RectF;", "getAvailableImageBounds", "Lcom/facebook/drawee/controller/BaseControllerListener;", BuildConfig.FLAVOR, "f", "Lcom/facebook/drawee/controller/BaseControllerListener;", "getControllerListener", "()Lcom/facebook/drawee/controller/BaseControllerListener;", "setControllerListener", "(Lcom/facebook/drawee/controller/BaseControllerListener;)V", "controllerListener", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/e;", "value", "h", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/e;", "getScaleFactorRetriever", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/e;", "setScaleFactorRetriever", "(Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/e;)V", "scaleFactorRetriever", BuildConfig.FLAVOR, "isDoubleClickScaleEnabled", "Z", "()Z", "setDoubleClickScaleEnabled", "(Z)V", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/d;", "callback", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/d;", "getCallback", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/d;", "setCallback", "(Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/d;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoDraweeView extends GenericDraweeView implements ScrollingView {
    public final RectF a;
    public final RectF b;
    public ZoomableControllerImp c;
    public GestureDetector d;
    public ba2.c e;
    public BaseControllerListener<Object> f;
    public ba2.a g;
    public e h;
    public final a i;
    public final b j;
    public boolean k;
    public final RectF l;
    public final Set<Function2<View, RectF, Unit>> m;

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
        L5:
            r0.b(false);
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
            r0.k = true;
            ZoomableControllerImp r2 = r0.c;
            if (r2 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        L6:
            if (r2.c == true) goto L11;
            ZoomableControllerImp r3 = r0.c;
            if (r3 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        L10:
            r3.b(true);
            r0.updateZoomableControllerBounds();
        L11:
            BaseControllerListener<Object> r1 = this.a.getControllerListener();
            if (r1 == null) goto L15;
            r1.onFinalImageSet(r5, r6, r7);
            return;
        }
    }

    public static final class b implements f {
        public final /* synthetic */ PhotoDraweeView a;

        public b(PhotoDraweeView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.publicscreen.preview.f
        public final void a() {
            this.a.invalidate();
        }
    }

    public PhotoDraweeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PhotoDraweeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final d getCallback() {
        return null;
    }

    public final void setCallback(d r1) {
    }

    public final int computeHorizontalScrollExtent() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) r0.e.width();
    }

    public final int computeHorizontalScrollOffset() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) (r0.e.left - r0.g.left);
    }

    public final int computeHorizontalScrollRange() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) r0.g.width();
    }

    public final void computeScroll() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        if (r0.t.computeScrollOffset() == false) goto L12;
        int r1 = r0.t.getCurrX();
        int r2 = r0.t.getCurrY();
        r0.n.set(r0.p);
        Matrix r3 = r0.n;
        r3.postTranslate(r1, r2);
        r0.e(r3);
        Matrix r4 = r0.n;
        if (r0.q.isRunning() == false) goto L10;
        r0.j();
    L10:
        r0.o.set(r4);
        r0.h.set(r4);
        r0.a();
        return;
    }

    public final int computeVerticalScrollExtent() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) r0.e.height();
    }

    public final int computeVerticalScrollOffset() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) (r0.e.top - r0.g.top);
    }

    public final int computeVerticalScrollRange() {
        ZoomableControllerImp r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) r0.g.height();
    }

    public final RectF getAvailableImageBounds() {
        if (this.k == true) goto L7;
        return null;
    L7:
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateZoomableControllerBounds() {
        getHierarchy().getActualImageBounds(this.a);
        RectF r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "outBounds");
        r0.set(0.0f, 0.0f, getWidth(), getHeight());
        d.a.getClass();
        d.a.a.set(this.a);
        ZoomableControllerImp r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        RectF r2 = this.a;
        if (r2 != null) goto L9;
        r1.getClass();
    L11:
        ZoomableControllerImp r3 = this.c;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L14:
        r3.e.set(this.b);
        r3.c();
        if ((!Intrinsics.areEqual(this.l, this.a)) == false) goto L22;
        this.l.set(this.a);
        if (this.k == false) goto L24;
        Iterator<T> r4 = this.m.iterator();
    L20:
        if (r4.hasNext() == false) goto L25;
        ((Function2) r4.next()).invoke(this, this.a);
        goto L20
    L25:
        return;
    L24:
        return;
    L22:
        return;
    L9:
        if (r2.equals(r1.f) == true) goto L11;
        r1.f.set(r2);
        r1.c();
        r1.a();
        goto L11
    }

    public final BaseControllerListener<Object> getControllerListener() {
        return this.f;
    }

    public final e getScaleFactorRetriever() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r1) {
        return super/*android.widget.ImageView*/.canScrollVertically(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        int r0 = r4.save();
        ZoomableControllerImp r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r4.concat(r1.h);
        super/*android.widget.ImageView*/.onDraw(r4);
        r4.restoreToCount(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        super/*com.facebook.drawee.view.DraweeView*/.onTouchEvent(r5);
        GestureDetector r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L5:
        r0.onTouchEvent(r5);
        ZoomableControllerImp r1 = this.c;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L9:
        if (r1.h(r5) == false) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        getParent().requestDisallowInterceptTouchEvent(false);
        MotionEvent r6 = MotionEvent.obtain(r5);
        r6.setAction(3);
        GestureDetector r2 = this.d;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L15:
        r2.onTouchEvent(r6);
        ZoomableControllerImp r3 = this.c;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L18:
        r3.h(r6);
        r6.recycle();
        return false;
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

    public final void setDoubleClickScaleEnabled(boolean r3) {
        ba2.a r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        r0.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setGestureHandler(ba2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "gestureHandler");
        this.g = r5;
        ba2.a r1 = this.g;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        this.e = new ba2.c(r1);
        Context r2 = getContext();
        ba2.c r3 = this.e;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L8:
        GestureDetector r0 = new GestureDetector(r2, r3);
        this.d = r0;
        r0.setIsLongpressEnabled(true);
        r5.b = getScaleFactorRetriever();
    }

    public final void setScaleFactorRetriever(e r3) {
        this.h = r3;
        ba2.a r0 = this.g;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L6:
        r0.b = r3;
        return;
    }

    public final void setZoomableControllerImp(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zoomableController");
        this.c = r2;
        r2.b = this.j;
        setScaleFactorRetriever(new com.bytedance.android.livesdk.interactivity.publicscreen.preview.b(r2));
    }

    public final void inflateHierarchy(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        GenericDraweeHierarchyBuilder r0 = new GenericDraweeHierarchyBuilder(r3.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchyInflater.updateBuilder(r0, r3, r4);
        setAspectRatio(r0.getDesiredAspectRatio());
        setHierarchy(r0.build());
    }

    public PhotoDraweeView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new RectF();
        this.b = new RectF();
        this.i = new a(this);
        this.j = new b(this);
        this.l = new RectF();
        this.m = new LinkedHashSet();
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

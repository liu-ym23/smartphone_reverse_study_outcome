package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.e;
import com.lynx.tasm.utils.BlurUtils;
import java.lang.ref.WeakReference;
import x6a.d;
import x6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a extends ViewGroup implements IDrawChildHook.IDrawChildHookBinding, e.a, x6a.e {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private Bitmap mBlurBitmap;
    private Canvas mBlurCanvas;
    private float mBlurRadius;
    private int mBlurSampling;
    private boolean mConsumeHoverEvent;
    protected IDrawChildHook mDrawChildHook;
    private boolean mEnableBlurAutoUpdate;
    private WeakReference<q7a.b> mGestureArenaManager;
    private boolean mHasSetPanInterceptAncestors;
    private String mImpressionId;
    private Boolean mInterceptGesture;
    private boolean mIsAttachToWindow;
    private boolean mNeedUsePreDrawListener;
    private boolean mPanInterceptAncestors;
    private boolean mPanInterceptDescendants;
    private boolean mPanInterceptSelf;
    private final ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private boolean mPreDrawListenerAdded;
    private i mRenderer;
    private boolean nativeInteractionEnabled;

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.view.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnPreDrawListenerC0056a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ a a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            TraceEvent.beginSection("AndroidView:blur");
            a.access$000(this.a);
            TraceEvent.endSection("AndroidView:blur");
            if (a.access$100(this.a) == true) goto L7;
            this.a.getViewTreeObserver().removeOnPreDrawListener(a.access$200(this.a));
            a.access$302(this.a, false);
            return true;
        L7:
            return true;
        }

        public ViewTreeObserverOnPreDrawListenerC0056a(a r1) {
            this.a = r1;
        }
    }

    public /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        d.a(this, r1, r2);
    }

    public /* synthetic */ void applyRendererOpacity(float r1) {
        d.b(this, r1);
    }

    public /* synthetic */ void applyRendererTransform(float[] r1) {
        d.c(this, r1);
    }

    public /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return d.d(this, r1);
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    public /* synthetic */ void invalidateForRenderer() {
        d.i(this);
    }

    public /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    public void removeBlur() {
        this.mBlurRadius = 0.0f;
        if (BlurUtils.removeEffect(this) == false) goto L5;
        return;
    L5:
        this.mNeedUsePreDrawListener = false;
        if (this.mPreDrawListenerAdded == true) goto L8;
        return;
    L8:
        if (this.mIsAttachToWindow == false) goto L10;
        getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = false;
    L10:
        this.mBlurBitmap = null;
        this.mBlurCanvas = null;
    }

    public /* synthetic */ void requestLayoutForRenderer() {
        d.j(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        d.l(this, r1);
    }

    private boolean isInterceptGestureNotNull() {
        if (this.mInterceptGesture == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        IDrawChildHook r0 = this.mDrawChildHook;
        if (r0 == null) goto L7;
        return r0.hasOverlappingRendering();
    L7:
        return super.hasOverlappingRendering();
    }

    private boolean isNeedInterceptGesture() {
        if (isInterceptGestureNotNull() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mInterceptGesture.booleanValue() == false) goto L7;
        return true;
    }

    private void updateBlur() {
        int r2 = getWidth();
        int r3 = getHeight();
        if (r2 <= 0) goto L19;
        if (r3 <= 0) goto L19;
        if (((r2 * r3) * 4) < MAX_BITMAP_SIZE) goto L10;
        LLog.e("AndroidView", "Skip blur bitmap creation: w=" + r2 + " h=" + r3 + " exceeds limit maxPixels=104857600");
        this.mBlurBitmap = null;
        return;
    L10:
        Bitmap r0 = this.mBlurBitmap;
        if (r0 != null) goto L13;
    L16:
        this.mBlurBitmap = Bitmap.createBitmap(r2, r3, Bitmap.Config.ARGB_8888);
        this.mBlurCanvas = new Canvas(this.mBlurBitmap);
    L17:
        this.mBlurBitmap.eraseColor(0);
        this.mBlurCanvas.save();
        super.draw(this.mBlurCanvas);
        this.mBlurCanvas.restore();
        Bitmap r1 = BlurUtils.blur(getContext(), this.mBlurBitmap, r2, r3, this.mBlurRadius, this.mBlurSampling);
        this.mBlurBitmap = r1;
        this.mBlurCanvas.setBitmap(r1);
        return;
    L13:
        if (r0.getWidth() != r2) goto L16;
        if (this.mBlurBitmap.getHeight() == r3) goto L17;
    L19:
        this.mBlurBitmap = null;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        WeakReference<q7a.b> r0 = this.mGestureArenaManager;
        if (r0 == null) goto L8;
        q7a.b r1 = r0.get();
        if (r1 == null) goto L9;
        r1.b();
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.e.a
    public void invalidateMeaningfulPaintingArea() {
        if ((getContext() instanceof LynxContext) == false) goto L8;
        UIBody.UIBodyView r0 = ((LynxContext) getContext()).getUIBodyView();
        if (r0 == null) goto L9;
        r0.invalidateMeaningfulPaintingArea();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachToWindow = true;
        if (this.mNeedUsePreDrawListener == true) goto L5;
        return;
    L5:
        if (this.mPreDrawListenerAdded == true) goto L9;
        getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachToWindow = false;
        if (this.mPreDrawListenerAdded == false) goto L6;
        getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.e.a
    public IDrawChildHook getDrawChildHook() {
        return this.mDrawChildHook;
    }

    public String getImpressionId() {
        return this.mImpressionId;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.mRenderer;
    }

    public a(Context r3) {
        super(r3);
        this.mBlurRadius = 0.0f;
        this.mPreDrawListenerAdded = false;
        this.mNeedUsePreDrawListener = false;
        this.mIsAttachToWindow = false;
        this.mEnableBlurAutoUpdate = true;
        this.mInterceptGesture = null;
        this.mBlurSampling = 1;
        this.mPreDrawListener = new ViewTreeObserverOnPreDrawListenerC0056a(this);
        this.mConsumeHoverEvent = false;
        this.nativeInteractionEnabled = false;
        this.mPanInterceptSelf = false;
        this.mPanInterceptAncestors = false;
        this.mHasSetPanInterceptAncestors = false;
        this.mPanInterceptDescendants = false;
    }

    public static /* synthetic */ void access$000(a r0) {
        r0.updateBlur();
    }

    public static /* synthetic */ boolean access$100(a r0) {
        return r0.mEnableBlurAutoUpdate;
    }

    public static /* synthetic */ ViewTreeObserver.OnPreDrawListener access$200(a r0) {
        return r0.mPreDrawListener;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook r1) {
        this.mDrawChildHook = r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r2) {
        IDrawChildHook r0 = this.mDrawChildHook;
        if (r0 == null) goto L5;
        r0.beforeDispatchDraw(r2);
    L5:
        super.dispatchDraw(r2);
        IDrawChildHook r1 = this.mDrawChildHook;
        if (r1 == null) goto L8;
        r1.afterDispatchDraw(r2);
    L8:
        i r3 = this.mRenderer;
        if (r3 == null) goto L12;
        r3.a(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (this.mPanInterceptAncestors == false) goto L6;
        getParent().requestDisallowInterceptTouchEvent(true);
    L9:
        return super.dispatchTouchEvent(r3);
    L6:
        if (this.mHasSetPanInterceptAncestors == false) goto L9;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L9
    }

    @Override // android.view.View
    public void draw(Canvas r4) {
        IDrawChildHook r0 = this.mDrawChildHook;
        if (r0 == null) goto L6;
        r0.beforeDraw(r4);
    L6:
        if (this.mBlurRadius == 0.0f) goto L10;
        Bitmap r1 = this.mBlurBitmap;
        if (r1 == null) goto L10;
        r4.drawBitmap(r1, 0.0f, 0.0f, null);
    L11:
        IDrawChildHook r2 = this.mDrawChildHook;
        if (r2 == null) goto L15;
        r2.afterDraw(r4);
        return;
    L15:
        return;
    L10:
        super.draw(r4);
        goto L11
    }

    public void interceptGesture(boolean r1) {
        this.mInterceptGesture = Boolean.valueOf(r1);
    }

    @Override // android.view.View
    public void onDraw(Canvas r2) {
        if (this.mRenderer == null) goto L6;
        this.mRenderer.g(r2);
        return;
    L6:
        super.onDraw(r2);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r1) {
        if (super.onHoverEvent(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mConsumeHoverEvent == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.mPanInterceptDescendants == false) goto L7;
        return true;
    L7:
        if (isNeedInterceptGesture() == false) goto L11;
        return this.mInterceptGesture.booleanValue();
    L11:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        if (this.mPanInterceptAncestors == false) goto L6;
        return true;
    L6:
        if (this.mPanInterceptSelf == false) goto L10;
        return false;
    L10:
        if (this.nativeInteractionEnabled == false) goto L13;
        return true;
    L13:
        if (isInterceptGestureNotNull() == false) goto L31;
        if (r4.getActionMasked() != 0) goto L19;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L19:
        if (r4.getActionMasked() != 2) goto L25;
        getParent().requestDisallowInterceptTouchEvent(this.mInterceptGesture.booleanValue());
        boolean r0 = this.mInterceptGesture.booleanValue();
        if (this.mInterceptGesture.booleanValue() == false) goto L23;
        return r0;
    L23:
        return super.onTouchEvent(r4);
    L25:
        if (r4.getActionMasked() != 1) goto L27;
    L28:
        this.mInterceptGesture = null;
        return true;
    L27:
        if (r4.getActionMasked() == 3) goto L28;
    L31:
        return super.onTouchEvent(r4);
    }

    public void setBlur(float r3) {
        if (r3 >= 0.0f) goto L5;
        r3 = 0.0f;
    L5:
        this.mBlurRadius = r3;
        if (BlurUtils.createEffect(this, r3) == false) goto L9;
        return;
    L9:
        if (r3 != 0.0f) goto L12;
        removeBlur();
        return;
    L12:
        this.mNeedUsePreDrawListener = true;
        if (this.mIsAttachToWindow == true) goto L15;
        return;
    L15:
        if (this.mPreDrawListenerAdded == true) goto L19;
        getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        setBackgroundColor(0);
        this.mPreDrawListenerAdded = true;
        return;
    }

    public void setBlurAutoUpdate(boolean r2) {
        this.mEnableBlurAutoUpdate = r2;
        if (r2 == true) goto L5;
    L11:
        invalidate();
        return;
    L5:
        if (this.mNeedUsePreDrawListener == false) goto L11;
        if (this.mIsAttachToWindow == false) goto L11;
        if (this.mPreDrawListenerAdded == true) goto L11;
        getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = true;
        goto L11
    }

    public void setBlurSampling(int r1) {
        this.mBlurSampling = r1;
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawingOrderEnabled(boolean r1) {
        super.setChildrenDrawingOrderEnabled(r1);
    }

    public void setConsumeHoverEvent(boolean r1) {
        this.mConsumeHoverEvent = r1;
    }

    public void setGestureManager(q7a.b r2) {
        this.mGestureArenaManager = new WeakReference(r2);
    }

    public void setImpressionId(String r1) {
        this.mImpressionId = r1;
    }

    public void setNativeInteractionEnabled(boolean r1) {
        this.nativeInteractionEnabled = r1;
    }

    public void setPanInterceptAncestors(boolean r1) {
        this.mPanInterceptAncestors = r1;
        if (r1 == false) goto L6;
        this.mHasSetPanInterceptAncestors = true;
        return;
    }

    public void setPanInterceptDescendants(boolean r1) {
        this.mPanInterceptDescendants = r1;
    }

    public void setPanInterceptSelf(boolean r1) {
        this.mPanInterceptSelf = r1;
    }

    @Override // x6a.e
    public void setRenderer(i r1) {
        this.mRenderer = r1;
    }

    public static /* synthetic */ boolean access$302(a r0, boolean r1) {
        r0.mPreDrawListenerAdded = r1;
        return r1;
    }

    @Override // x6a.e
    public i createRenderer(PlatformRendererContext r2, int r3) {
        return new i(r2, r3);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r2, int r3) {
        IDrawChildHook r0 = this.mDrawChildHook;
        if (r0 == null) goto L7;
        return r0.getChildDrawingOrder(r2, r3);
    L7:
        return super.getChildDrawingOrder(r2, r3);
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        i r0 = this.mRenderer;
        if (r0 == null) goto L5;
        Rect r4 = r0.a;
        setMeasuredDimension(r4.width(), r4.height());
        this.mRenderer.i();
    L7:
        if (getRootView().isLayoutRequested() == true) goto L12;
        IDrawChildHook r5 = this.mDrawChildHook;
        if (r5 == null) goto L13;
        r5.performMeasureChildrenUI();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        setMeasuredDimension(View.MeasureSpec.getSize(r2), View.MeasureSpec.getSize(r3));
        goto L7
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r3, View r4, long r5) {
        i r0 = this.mRenderer;
        if (r0 == null) goto L5;
        r0.b(r3, r4);
    L5:
        IDrawChildHook r1 = this.mDrawChildHook;
        if (r1 == null) goto L8;
        Rect r2 = r1.beforeDrawChild(r3, r4, r5);
    L9:
        if (r2 == null) goto L11;
        r3.save();
        r3.clipRect(r2);
        boolean r6 = super.drawChild(r3, r4, r5);
        r3.restore();
    L12:
        IDrawChildHook r7 = this.mDrawChildHook;
        if (r7 == null) goto L15;
        r7.afterDrawChild(r3, r4, r5);
    L15:
        i r8 = this.mRenderer;
        if (r8 == null) goto L18;
        r8.getClass();
        r3.restore();
    L18:
        return r6;
    L11:
        r6 = super.drawChild(r3, r4, r5);
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        i r6 = this.mRenderer;
        if (r6 == null) goto L6;
        r6.h();
    L6:
        if (getRootView().isLayoutRequested() == true) goto L11;
        IDrawChildHook r7 = this.mDrawChildHook;
        if (r7 == null) goto L12;
        r7.performLayoutChildrenUI();
        return;
    L12:
        return;
    }
}

package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.o;
import com.lynx.tasm.utils.BlurUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class b extends ViewGroup implements com.lynx.tasm.behavior.ui.a, o {
    private Bitmap mBlurBitmap;
    private Canvas mBlurCanvas;
    private float mBlurRadius;
    private int mBlurSampling;
    private boolean mConsumeHoverEvent;
    protected com.lynx.tasm.behavior.ui.b mDrawChildHook;
    private WeakReference<sn.a> mGestureArenaManager;
    private String mImpressionId;
    private Boolean mInterceptGesture;
    private boolean mIsAttachToWindow;
    private boolean mNeedUsePreDrawListener;
    private final ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private boolean mPreDrawListenerAdded;
    private boolean nativeInteractionEnabled;

    public b(Context r5) {
        super(r5);
        this.mBlurRadius = 0.0f;
        this.mPreDrawListenerAdded = false;
        this.mNeedUsePreDrawListener = false;
        this.mIsAttachToWindow = false;
        this.mInterceptGesture = null;
        this.mBlurSampling = 1;
        this.mPreDrawListener = new a(this);
        this.mConsumeHoverEvent = false;
        this.nativeInteractionEnabled = false;
    }

    public final boolean a() {
        int r5 = getWidth();
        int r10 = getHeight();
        if (r5 <= 0) goto L14;
        if (r10 <= 0) goto L14;
        Bitmap r11 = this.mBlurBitmap;
        if (r11 != null) goto L9;
    L12:
        this.mBlurBitmap = Bitmap.createBitmap(r5, r10, Bitmap.Config.ARGB_8888);
        this.mBlurCanvas = new Canvas(this.mBlurBitmap);
    L13:
        this.mBlurBitmap.eraseColor(0);
        this.mBlurCanvas.save();
        super.draw(this.mBlurCanvas);
        this.mBlurCanvas.restore();
        Bitmap r12 = BlurUtils.blur(getContext(), this.mBlurBitmap, r5, r10, this.mBlurRadius, this.mBlurSampling);
        this.mBlurBitmap = r12;
        this.mBlurCanvas.setBitmap(r12);
        return true;
    L9:
        if (r11.getWidth() != r5) goto L12;
        if (this.mBlurBitmap.getHeight() == r10) goto L13;
    L14:
        this.mBlurBitmap = null;
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void bindDrawChildHook(com.lynx.tasm.behavior.ui.b r5) {
        this.mDrawChildHook = r5;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        WeakReference<sn.a> r5 = this.mGestureArenaManager;
        if (r5 == null) goto L8;
        sn.a r10 = r5.get();
        if (r10 == null) goto L9;
        r10.a();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        com.lynx.tasm.behavior.ui.b r10 = this.mDrawChildHook;
        if (r10 == null) goto L5;
        r10.beforeDispatchDraw(r5);
    L5:
        super.dispatchDraw(r5);
        com.lynx.tasm.behavior.ui.b r11 = this.mDrawChildHook;
        if (r11 == null) goto L9;
        r11.afterDispatchDraw(r5);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r5) {
        com.lynx.tasm.behavior.ui.b r10 = this.mDrawChildHook;
        if (r10 == null) goto L6;
        r10.beforeDraw(r5);
    L6:
        if (this.mBlurRadius == 0.0f) goto L10;
        Bitmap r11 = this.mBlurBitmap;
        if (r11 == null) goto L10;
        r5.drawBitmap(r11, 0.0f, 0.0f, null);
    L11:
        com.lynx.tasm.behavior.ui.b r12 = this.mDrawChildHook;
        if (r12 == null) goto L15;
        r12.afterDraw(r5);
        return;
    L15:
        return;
    L10:
        super.draw(r5);
        goto L11
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r5, View r10, long r11) {
        com.lynx.tasm.behavior.ui.b r12 = this.mDrawChildHook;
        if (r12 == null) goto L5;
        Rect r13 = r12.beforeDrawChild(r5, r10, r11);
    L6:
        if (r13 == null) goto L8;
        r5.save();
        r5.clipRect(r13);
        boolean r14 = super.drawChild(r5, r10, r11);
        r5.restore();
    L9:
        com.lynx.tasm.behavior.ui.b r15 = this.mDrawChildHook;
        if (r15 == null) goto L12;
        r15.afterDrawChild(r5, r10, r11);
    L12:
        return r14;
    L8:
        r14 = super.drawChild(r5, r10, r11);
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r5, int r10) {
        com.lynx.tasm.behavior.ui.b r11 = this.mDrawChildHook;
        if (r11 == null) goto L7;
        return r11.getChildDrawingOrder(r5, r10);
    L7:
        return super.getChildDrawingOrder(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.o
    public com.lynx.tasm.behavior.ui.b getDrawChildHook() {
        return this.mDrawChildHook;
    }

    public String getImpressionId() {
        return this.mImpressionId;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        com.lynx.tasm.behavior.ui.b r5 = this.mDrawChildHook;
        if (r5 == null) goto L7;
        return r5.hasOverlappingRendering();
    L7:
        return super.hasOverlappingRendering();
    }

    public void interceptGesture(boolean r5) {
        this.mInterceptGesture = Boolean.valueOf(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.o
    public void invalidateMeaningfulPaintingArea() {
        if ((getContext() instanceof LynxContext) == false) goto L8;
        UIBody.UIBodyView r5 = ((LynxContext) getContext()).l();
        if (r5 == null) goto L9;
        r5.invalidateMeaningfulPaintingArea();
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

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r5) {
        if (super.onHoverEvent(r5) == false) goto L5;
        return true;
    L5:
        if (this.mConsumeHoverEvent == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        Boolean r10 = this.mInterceptGesture;
        if (r10 == null) goto L9;
        if (r10.booleanValue() == false) goto L9;
        return this.mInterceptGesture.booleanValue();
    L9:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        if (getRootView().isLayoutRequested() == true) goto L8;
        com.lynx.tasm.behavior.ui.b r14 = this.mDrawChildHook;
        if (r14 == null) goto L9;
        r14.performLayoutChildrenUI();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        setMeasuredDimension(View.MeasureSpec.getSize(r5), View.MeasureSpec.getSize(r10));
        if (getRootView().isLayoutRequested() == true) goto L8;
        com.lynx.tasm.behavior.ui.b r11 = this.mDrawChildHook;
        if (r11 == null) goto L9;
        r11.performMeasureChildrenUI();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (this.nativeInteractionEnabled == false) goto L6;
        return true;
    L6:
        if (this.mInterceptGesture == null) goto L25;
        if (r5.getActionMasked() != 0) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        if (r5.getActionMasked() != 2) goto L19;
        getParent().requestDisallowInterceptTouchEvent(this.mInterceptGesture.booleanValue());
        boolean r10 = this.mInterceptGesture.booleanValue();
        if (this.mInterceptGesture.booleanValue() == false) goto L16;
        return r10;
    L16:
        return super.onTouchEvent(r5);
    L19:
        if (r5.getActionMasked() != 1) goto L21;
    L22:
        this.mInterceptGesture = null;
        return true;
    L21:
        if (r5.getActionMasked() == 3) goto L22;
    L25:
        return super.onTouchEvent(r5);
    }

    public void removeBlur() {
        this.mBlurRadius = 0.0f;
        if (BlurUtils.removeEffect(this) == true) goto L13;
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
        return;
    }

    public void setBlur(float r5) {
        if (r5 >= 0.0f) goto L5;
        r5 = 0.0f;
    L5:
        this.mBlurRadius = r5;
        if (BlurUtils.createEffect(this, r5) == false) goto L9;
        return;
    L9:
        if (r5 != 0.0f) goto L12;
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

    public void setBlurSampling(int r5) {
        this.mBlurSampling = r5;
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawingOrderEnabled(boolean r5) {
        super.setChildrenDrawingOrderEnabled(r5);
    }

    public void setConsumeHoverEvent(boolean r5) {
        this.mConsumeHoverEvent = r5;
    }

    public void setGestureManager(sn.a r5) {
        this.mGestureArenaManager = new WeakReference(r5);
    }

    public void setImpressionId(String r5) {
        this.mImpressionId = r5;
    }

    public void setNativeInteractionEnabled(boolean r5) {
        this.nativeInteractionEnabled = r5;
    }
}

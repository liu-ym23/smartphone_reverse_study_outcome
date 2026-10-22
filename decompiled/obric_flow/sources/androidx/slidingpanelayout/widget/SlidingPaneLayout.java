package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ SlidingPaneLayout this$0;

        public AccessibilityDelegate(SlidingPaneLayout r5) {
            this.this$0 = r5;
            this.mTmpRect = new Rect();
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r5, AccessibilityNodeInfoCompat r10) {
            Rect r11 = this.mTmpRect;
            r10.getBoundsInParent(r11);
            r5.setBoundsInParent(r11);
            r10.getBoundsInScreen(r11);
            r5.setBoundsInScreen(r11);
            r5.setVisibleToUser(r10.isVisibleToUser());
            r5.setPackageName(r10.getPackageName());
            r5.setClassName(r10.getClassName());
            r5.setContentDescription(r10.getContentDescription());
            r5.setEnabled(r10.isEnabled());
            r5.setClickable(r10.isClickable());
            r5.setFocusable(r10.isFocusable());
            r5.setFocused(r10.isFocused());
            r5.setAccessibilityFocused(r10.isAccessibilityFocused());
            r5.setSelected(r10.isSelected());
            r5.setLongClickable(r10.isLongClickable());
            r5.addAction(r10.getActions());
            r5.setMovementGranularities(r10.getMovementGranularities());
        }

        public boolean filter(View r5) {
            return this.this$0.isDimmed(r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r5, r10);
            r10.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
            AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.obtain(r10);
            super.onInitializeAccessibilityNodeInfo(r5, r11);
            copyNodeInfoNoChildren(r10, r11);
            r11.recycle();
            r10.setClassName(SlidingPaneLayout.class.getName());
            r10.setSource(r5);
            Object r12 = ViewCompat.getParentForAccessibility(r5);
            if ((r12 instanceof View) == false) goto L5;
            r10.setParent((View) r12);
        L5:
            int r13 = this.this$0.getChildCount();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L13;
            View r15 = this.this$0.getChildAt(r14);
            if (filter(r15) == true) goto L12;
            if (r15.getVisibility() != 0) goto L12;
            ViewCompat.setImportantForAccessibility(r15, 1);
            r10.addChild(r15);
        L12:
            r14 = r14 + 1;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r5, View r10, AccessibilityEvent r11) {
            if (filter(r10) == false) goto L5;
            return false;
        L5:
            return super.onRequestSendAccessibilityEvent(r5, r10, r11);
        }
    }

    public class DisableLayerRunnable implements Runnable {
        final View mChildView;
        final /* synthetic */ SlidingPaneLayout this$0;

        public DisableLayerRunnable(SlidingPaneLayout r5, View r10) {
            this.this$0 = r5;
            this.mChildView = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() != this.this$0) goto L5;
            this.mChildView.setLayerType(0, null);
            this.this$0.invalidateChildRegion(this.mChildView);
        L5:
            this.this$0.mPostedRunnables.remove(this);
        }
    }

    public class DragHelperCallback extends ViewDragHelper.Callback {
        final /* synthetic */ SlidingPaneLayout this$0;

        public DragHelperCallback(SlidingPaneLayout r5) {
            this.this$0 = r5;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r5, int r10, int r11) {
            LayoutParams r12 = (LayoutParams) this.this$0.mSlideableView.getLayoutParams();
            if (this.this$0.isLayoutRtlSupport() == false) goto L5;
            int r13 = this.this$0.getWidth();
            int r14 = this.this$0.getPaddingRight() + ((ViewGroup.MarginLayoutParams) r12).rightMargin;
            int r15 = r13 - (this.this$0.mSlideableView.getWidth() + r14);
            int r16 = r15 - this.this$0.mSlideRange;
            return Math.max(Math.min(r10, r15), r16);
        L5:
            int r17 = this.this$0.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r12).leftMargin;
            int r18 = this.this$0.mSlideRange + r17;
            return Math.min(Math.max(r10, r17), r18);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r5, int r10, int r11) {
            return r5.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r5) {
            return this.this$0.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r5, int r10) {
            SlidingPaneLayout r11 = this.this$0;
            r11.mDragHelper.captureChildView(r11.mSlideableView, r10);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r5, int r10) {
            this.this$0.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r5) {
            if (this.this$0.mDragHelper.getViewDragState() != 0) goto L9;
            SlidingPaneLayout r10 = this.this$0;
            if (r10.mSlideOffset != 0.0f) goto L7;
            r10.updateObscuredViewsVisibility(r10.mSlideableView);
            SlidingPaneLayout r11 = this.this$0;
            r11.dispatchOnPanelClosed(r11.mSlideableView);
            this.this$0.mPreservedOpenState = false;
            return;
        L7:
            r10.dispatchOnPanelOpened(r10.mSlideableView);
            this.this$0.mPreservedOpenState = true;
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r5, int r10, int r11, int r12, int r13) {
            this.this$0.onPanelDragged(r10);
            this.this$0.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r5, float r10, float r11) {
            LayoutParams r12 = (LayoutParams) r5.getLayoutParams();
            if (this.this$0.isLayoutRtlSupport() == false) goto L12;
            int r13 = this.this$0.getPaddingRight() + ((ViewGroup.MarginLayoutParams) r12).rightMargin;
            if (r10 >= 0.0f) goto L7;
        L10:
            r13 = r13 + this.this$0.mSlideRange;
        L11:
            int r14 = this.this$0.mSlideableView.getWidth();
            int r15 = (this.this$0.getWidth() - r13) - r14;
        L18:
            this.this$0.mDragHelper.settleCapturedViewAt(r15, r5.getTop());
            this.this$0.invalidate();
            return;
        L7:
            if (r10 != 0.0f) goto L11;
            if (this.this$0.mSlideOffset <= 0.5f) goto L11;
        L12:
            int r16 = this.this$0.getPaddingLeft();
            r15 = ((ViewGroup.MarginLayoutParams) r12).leftMargin + r16;
            if (r10 > 0.0f) goto L17;
            if (r10 != 0.0f) goto L18;
            if (this.this$0.mSlideOffset <= 0.5f) goto L18;
        L17:
            r15 = r15 + this.this$0.mSlideRange;
            goto L18
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r5, int r10) {
            if (this.this$0.mIsUnableToDrag == false) goto L7;
            return false;
        L7:
            return ((LayoutParams) r5.getLayoutParams()).slideable;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = null;
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        static {
            ATTRS = new int[]{R.attr.layout_weight};
        }

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r5) {
            super(r5);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull LayoutParams r5) {
            super(r5);
            this.weight = 0.0f;
            this.weight = r5.weight;
        }

        public LayoutParams(@NonNull Context r5, @Nullable AttributeSet r10) {
            super(r5, r10);
            this.weight = 0.0f;
            TypedArray r11 = r5.obtainStyledAttributes(r10, ATTRS);
            this.weight = r11.getFloat(0, 0.0f);
            r11.recycle();
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View r5);

        void onPanelOpened(@NonNull View r5);

        void onPanelSlide(@NonNull View r5, float r10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isOpen;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.isOpen ? 1 : 0);
        }

        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            if (r5.readInt() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.isOpen = r11;
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public SimplePanelSlideListener() {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View r5) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View r5) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View r5, float r10) {
        }
    }

    public SlidingPaneLayout(@NonNull Context r5) {
        this(r5, null);
    }

    private boolean closePane(View r5, int r10) {
        if (this.mFirstLayout == false) goto L5;
    L8:
        this.mPreservedOpenState = false;
        return true;
    L5:
        if (smoothSlideTo(0.0f, r10) == true) goto L8;
        return false;
    }

    private void dimChildView(View r5, float r10, int r11) {
        LayoutParams r12 = (LayoutParams) r5.getLayoutParams();
        if (r10 <= 0.0f) goto L13;
        if (r11 == 0) goto L13;
        int r13 = (((int) ((((-16777216) & r11) >>> 24) * r10)) << 24) | (r11 & ViewCompat.MEASURED_SIZE_MASK);
        if (r12.dimPaint != null) goto L8;
        r12.dimPaint = new Paint();
    L8:
        r12.dimPaint.setColorFilter(new PorterDuffColorFilter(r13, PorterDuff.Mode.SRC_OVER));
        if (r5.getLayerType() == 2) goto L11;
        r5.setLayerType(2, r12.dimPaint);
    L11:
        invalidateChildRegion(r5);
        return;
    L13:
        if (r5.getLayerType() == 0) goto L20;
        Paint r14 = r12.dimPaint;
        if (r14 == null) goto L17;
        r14.setColorFilter(null);
    L17:
        DisableLayerRunnable r15 = new DisableLayerRunnable(this, r5);
        this.mPostedRunnables.add(r15);
        ViewCompat.postOnAnimation(this, r15);
        return;
    }

    private boolean openPane(View r5, int r10) {
        if (this.mFirstLayout == false) goto L5;
    L9:
        this.mPreservedOpenState = true;
        return true;
    L5:
        if (smoothSlideTo(1.0f, r10) == true) goto L9;
        return false;
    }

    private void parallaxOtherViews(float r10) {
        boolean r5 = isLayoutRtlSupport();
        LayoutParams r11 = (LayoutParams) this.mSlideableView.getLayoutParams();
        int r12 = 0;
        if (r11.dimWhenOffset == false) goto L9;
        if (r5 == false) goto L6;
        int r13 = ((ViewGroup.MarginLayoutParams) r11).rightMargin;
    L7:
        if (r13 > 0) goto L9;
        boolean r14 = true;
    L10:
        int r15 = getChildCount();
    L11:
        if (r12 >= r15) goto L26;
        View r16 = getChildAt(r12);
        if (r16 == this.mSlideableView) goto L25;
        float r17 = 1.0f - this.mParallaxOffset;
        int r18 = this.mParallaxBy;
        this.mParallaxOffset = r10;
        int r19 = ((int) (r17 * r18)) - ((int) ((1.0f - r10) * r18));
        if (r5 == false) goto L18;
        r19 = -r19;
    L18:
        r16.offsetLeftAndRight(r19);
        if (r14 == false) goto L25;
        float r20 = this.mParallaxOffset;
        if (r5 == false) goto L23;
        float r21 = r20 - 1.0f;
    L24:
        dimChildView(r16, r21, this.mCoveredFadeColor);
        goto L25
    L23:
        r21 = 1.0f - r20;
    L25:
        r12 = r12 + 1;
        goto L11
    L26:
        return;
    L6:
        r13 = ((ViewGroup.MarginLayoutParams) r11).leftMargin;
    L9:
        r14 = false;
        goto L10
    }

    private static boolean viewIsOpaque(View r5) {
        if (r5.isOpaque() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean canScroll(View r13, boolean r14, int r15, int r16, int r17) {
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r5 = (ViewGroup) r13;
        int r10 = r13.getScrollX();
        int r11 = r13.getScrollY();
        int r12 = r5.getChildCount() - 1;
    L5:
        if (r12 < 0) goto L18;
        View r18 = r5.getChildAt(r12);
        int r19 = r16 + r10;
        if (r19 < r18.getLeft()) goto L17;
        if (r19 >= r18.getRight()) goto L17;
        int r20 = r17 + r11;
        if (r20 < r18.getTop()) goto L17;
        if (r20 >= r18.getBottom()) goto L17;
        if (canScroll(r18, true, r15, r19 - r18.getLeft(), r20 - r18.getTop()) == false) goto L17;
        return true;
    L17:
        r12 = r12 - 1;
    L18:
        if (r14 == true) goto L20;
    L26:
        return false;
    L20:
        if (isLayoutRtlSupport() == false) goto L22;
        int r21 = r15;
    L24:
        if (r13.canScrollHorizontally(r21) == false) goto L26;
        return true;
    L22:
        r21 = -r15;
        goto L24
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r5) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true) == true) goto L5;
        return;
    L5:
        if (this.mCanSlide == true) goto L8;
        this.mDragHelper.abort();
        return;
    L8:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void dispatchOnPanelClosed(View r5) {
        PanelSlideListener r10 = this.mPanelSlideListener;
        if (r10 == null) goto L5;
        r10.onPanelClosed(r5);
    L5:
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(View r5) {
        PanelSlideListener r10 = this.mPanelSlideListener;
        if (r10 == null) goto L5;
        r10.onPanelOpened(r5);
    L5:
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(View r5) {
        PanelSlideListener r10 = this.mPanelSlideListener;
        if (r10 == null) goto L6;
        r10.onPanelSlide(r5, this.mSlideOffset);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        if (isLayoutRtlSupport() == false) goto L5;
        Drawable r5 = this.mShadowDrawableRight;
    L7:
        if (getChildCount() <= 1) goto L9;
        View r11 = getChildAt(1);
    L10:
        if (r11 == null) goto L19;
        if (r5 == null) goto L20;
        int r12 = r11.getTop();
        int r13 = r11.getBottom();
        int r14 = r5.getIntrinsicWidth();
        if (isLayoutRtlSupport() == false) goto L16;
        int r15 = r11.getRight();
        int r16 = r14 + r15;
    L17:
        r5.setBounds(r15, r12, r16, r13);
        r5.draw(r10);
        return;
    L16:
        int r17 = r11.getLeft();
        int r18 = r17 - r14;
        r16 = r17;
        r15 = r18;
        goto L17
    L20:
        return;
    L19:
        return;
    L9:
        r11 = null;
        goto L10
    L5:
        r5 = this.mShadowDrawableLeft;
        goto L7
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r5, View r10, long r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        int r13 = r5.save();
        if (this.mCanSlide == true) goto L5;
    L13:
        boolean r14 = super.drawChild(r5, r10, r11);
        r5.restoreToCount(r13);
        return r14;
    L5:
        if (r12.slideable == true) goto L13;
        if (this.mSlideableView == null) goto L13;
        r5.getClipBounds(this.mTmpRect);
        if (isLayoutRtlSupport() == false) goto L11;
        Rect r15 = this.mTmpRect;
        r15.left = Math.max(r15.left, this.mSlideableView.getRight());
    L12:
        r5.clipRect(this.mTmpRect);
        goto L13
    L11:
        Rect r16 = this.mTmpRect;
        r16.right = Math.min(r16.right, this.mSlideableView.getLeft());
        goto L12
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
    L6:
        return new LayoutParams(r5);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    @Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void invalidateChildRegion(View r5) {
        ViewCompat.setLayerPaint(r5, ((LayoutParams) r5.getLayoutParams()).dimPaint);
    }

    public boolean isDimmed(View r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        LayoutParams r10 = (LayoutParams) r5.getLayoutParams();
        if (this.mCanSlide == true) goto L8;
        return false;
    L8:
        if (r10.dimWhenOffset == true) goto L10;
        return false;
    L10:
        if (this.mSlideOffset <= 0.0f) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean isLayoutRtlSupport() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isOpen() {
        if (this.mCanSlide == true) goto L5;
    L8:
        return true;
    L5:
        if (this.mSlideOffset == 1.0f) goto L8;
        return false;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int r5 = this.mPostedRunnables.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        this.mPostedRunnables.get(r10).run();
        r10 = r10 + 1;
        goto L3
    L5:
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r5 = r10.getActionMasked();
        if (this.mCanSlide == true) goto L11;
        if (r5 != 0) goto L11;
        if (getChildCount() <= 1) goto L11;
        View r11 = getChildAt(1);
        if (r11 == null) goto L11;
        this.mPreservedOpenState = !this.mDragHelper.isViewUnder(r11, (int) r10.getX(), (int) r10.getY());
    L11:
        if (this.mCanSlide == true) goto L13;
    L44:
        this.mDragHelper.cancel();
        return super.onInterceptTouchEvent(r10);
    L13:
        if (this.mIsUnableToDrag == false) goto L17;
        if (r5 != 0) goto L44;
    L17:
        if (r5 == 3) goto L42;
        if (r5 == 1) goto L42;
        if (r5 != 0) goto L22;
        this.mIsUnableToDrag = false;
        float r12 = r10.getX();
        float r13 = r10.getY();
        this.mInitialMotionX = r12;
        this.mInitialMotionY = r13;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) r12, (int) r13) == true) goto L33;
    L35:
        boolean r14 = false;
    L37:
        if (this.mDragHelper.shouldInterceptTouchEvent(r10) == true) goto L46;
        if (r14 == false) goto L41;
        return true;
    L41:
        return false;
    L46:
        return true;
    L33:
        if (isDimmed(this.mSlideableView) == false) goto L35;
        r14 = true;
        goto L37
    L22:
        if (r5 != 2) goto L35;
        float r15 = r10.getX();
        float r16 = r10.getY();
        float r17 = Math.abs(r15 - this.mInitialMotionX);
        float r18 = Math.abs(r16 - this.mInitialMotionY);
        if (r17 <= this.mDragHelper.getTouchSlop()) goto L35;
        if (r18 <= r17) goto L35;
        this.mDragHelper.cancel();
        this.mIsUnableToDrag = true;
        return false;
    L42:
        this.mDragHelper.cancel();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        boolean r5 = isLayoutRtlSupport();
        if (r5 == false) goto L5;
        this.mDragHelper.setEdgeTrackingEnabled(2);
    L6:
        int r10 = r22 - r20;
        if (r5 == false) goto L9;
        int r11 = getPaddingRight();
    L10:
        if (r5 == false) goto L12;
        int r12 = getPaddingLeft();
    L13:
        int r13 = getPaddingTop();
        int r14 = getChildCount();
        if (this.mFirstLayout == true) goto L16;
    L22:
        int r15 = r11;
        int r16 = 0;
    L23:
        if (r16 >= r14) goto L50;
        View r17 = getChildAt(r16);
        if (r17.getVisibility() == 8) goto L48;
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        int r110 = r17.getMeasuredWidth();
        if (r18.slideable == false) goto L39;
        int r24 = r10 - r12;
        int r25 = (Math.min(r11, r24 - this.mOverhangSize) - r15) - (((ViewGroup.MarginLayoutParams) r18).leftMargin + ((ViewGroup.MarginLayoutParams) r18).rightMargin);
        this.mSlideRange = r25;
        if (r5 == false) goto L32;
        int r26 = ((ViewGroup.MarginLayoutParams) r18).rightMargin;
    L34:
        if (((r110 / 2) + ((r15 + r26) + r25)) <= r24) goto L36;
        boolean r27 = true;
    L37:
        r18.dimWhenOffset = r27;
        int r28 = (int) (r25 * this.mSlideOffset);
        int r29 = (r26 + r28) + r15;
        this.mSlideOffset = r28 / r25;
        int r30 = 0;
    L44:
        if (r5 == false) goto L46;
        int r111 = (r10 - r29) + r30;
        int r31 = r111 - r110;
    L47:
        r17.layout(r31, r13, r111, r17.getMeasuredHeight() + r13);
        r15 = r29;
        r11 = r17.getWidth() + r11;
        goto L48
    L46:
        r31 = r29 - r30;
        r111 = r31 + r110;
        goto L47
    L36:
        r27 = false;
        goto L37
    L32:
        r26 = ((ViewGroup.MarginLayoutParams) r18).leftMargin;
        goto L34
    L39:
        if (this.mCanSlide == false) goto L43;
        int r32 = this.mParallaxBy;
        if (r32 == 0) goto L43;
        r30 = (int) ((1.0f - this.mSlideOffset) * r32);
        r29 = r11;
    L43:
        r29 = r11;
        r30 = 0;
    L48:
        r16 = r16 + 1;
        goto L23
    L50:
        if (this.mFirstLayout == true) goto L52;
    L63:
        this.mFirstLayout = false;
        return;
    L52:
        if (this.mCanSlide == true) goto L54;
        int r33 = 0;
    L60:
        if (r33 >= r14) goto L62;
        dimChildView(getChildAt(r33), 0.0f, this.mSliderFadeColor);
        r33 = r33 + 1;
    L62:
        updateObscuredViewsVisibility(this.mSlideableView);
        goto L63
    L54:
        if (this.mParallaxBy == 0) goto L57;
        parallaxOtherViews(this.mSlideOffset);
    L57:
        if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset == false) goto L62;
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        goto L62
    L16:
        if (this.mCanSlide == true) goto L18;
    L20:
        float r34 = 0.0f;
    L21:
        this.mSlideOffset = r34;
        goto L22
    L18:
        if (this.mPreservedOpenState == false) goto L20;
        r34 = 1.0f;
        goto L21
    L12:
        r12 = getPaddingRight();
        goto L13
    L9:
        r11 = getPaddingLeft();
        goto L10
    L5:
        this.mDragHelper.setEdgeTrackingEnabled(1);
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r21, int r22) {
        int r5 = View.MeasureSpec.getMode(r21);
        int r10 = View.MeasureSpec.getSize(r21);
        int r11 = View.MeasureSpec.getMode(r22);
        int r12 = View.MeasureSpec.getSize(r22);
        if (r5 != 1073741824) goto L5;
        if (r11 == 0) goto L14;
    L19:
        boolean r13 = false;
        if (r11 == Integer.MIN_VALUE) goto L25;
        if (r11 == 1073741824) goto L24;
        int r14 = 0;
    L23:
        int r15 = r14;
    L26:
        int r16 = (r10 - getPaddingLeft()) - getPaddingRight();
        int r17 = getChildCount();
        if (r17 <= 2) goto L29;
        Log.e(TAG, "onMeasure: More than two child views are not supported.");
    L29:
        this.mSlideableView = null;
        int r18 = 0;
        boolean r19 = false;
        int r110 = r16;
        float r111 = 0.0f;
    L30:
        int r112 = 8;
        if (r18 >= r17) goto L66;
        View r20 = getChildAt(r18);
        LayoutParams r23 = (LayoutParams) r20.getLayoutParams();
        if (r20.getVisibility() != 8) goto L35;
        r23.dimWhenOffset = r13;
    L65:
        r18 = r18 + 1;
        r13 = false;
        goto L30
    L35:
        float r113 = r23.weight;
        if (r113 <= 0.0f) goto L40;
        r111 = r111 + r113;
        if (((ViewGroup.MarginLayoutParams) r23).width == 0) goto L65;
    L40:
        int r114 = ((ViewGroup.MarginLayoutParams) r23).leftMargin + ((ViewGroup.MarginLayoutParams) r23).rightMargin;
        int r115 = ((ViewGroup.MarginLayoutParams) r23).width;
        if (r115 != (-2)) goto L44;
        int r116 = View.MeasureSpec.makeMeasureSpec(r16 - r114, Integer.MIN_VALUE);
    L47:
        int r117 = ((ViewGroup.MarginLayoutParams) r23).height;
        if (r117 != (-2)) goto L51;
        int r118 = View.MeasureSpec.makeMeasureSpec(r15, Integer.MIN_VALUE);
    L54:
        r20.measure(r116, r118);
        int r24 = r20.getMeasuredWidth();
        int r119 = r20.getMeasuredHeight();
        if (r11 != Integer.MIN_VALUE) goto L58;
        if (r119 <= r14) goto L58;
        r14 = Math.min(r119, r15);
    L58:
        r110 = r110 - r24;
        if (r110 >= 0) goto L61;
        boolean r25 = true;
    L62:
        r23.slideable = r25;
        r19 = r19 | r25;
        if (r25 == false) goto L65;
        this.mSlideableView = r20;
        goto L65
    L61:
        r25 = false;
        goto L62
    L51:
        if (r117 != (-1)) goto L53;
        r118 = View.MeasureSpec.makeMeasureSpec(r15, BasicMeasure.EXACTLY);
        goto L54
    L53:
        r118 = View.MeasureSpec.makeMeasureSpec(r117, BasicMeasure.EXACTLY);
        goto L54
    L44:
        if (r115 != (-1)) goto L46;
        r116 = View.MeasureSpec.makeMeasureSpec(r16 - r114, BasicMeasure.EXACTLY);
        goto L47
    L46:
        r116 = View.MeasureSpec.makeMeasureSpec(r115, BasicMeasure.EXACTLY);
        goto L47
    L66:
        if (r19 == false) goto L68;
    L69:
        int r26 = r16 - this.mOverhangSize;
        int r27 = 0;
    L70:
        if (r27 >= r17) goto L123;
        View r28 = getChildAt(r27);
        if (r28.getVisibility() != r112) goto L75;
    L73:
        int r120 = r26;
    L122:
        r27 = r27 + 1;
        r26 = r120;
        r112 = 8;
        goto L70
    L75:
        LayoutParams r29 = (LayoutParams) r28.getLayoutParams();
        if (r28.getVisibility() == r112) goto L73;
        if (((ViewGroup.MarginLayoutParams) r29).width == 0) goto L81;
    L83:
        boolean r121 = false;
    L84:
        if (r121 == false) goto L86;
        int r122 = 0;
    L87:
        if (r19 == false) goto L106;
        if (r28 == this.mSlideableView) goto L106;
        if (((ViewGroup.MarginLayoutParams) r29).width >= 0) goto L73;
        if (r122 <= r26) goto L94;
    L95:
        if (r121 == false) goto L103;
        int r30 = ((ViewGroup.MarginLayoutParams) r29).height;
        if (r30 != (-2)) goto L100;
        int r31 = View.MeasureSpec.makeMeasureSpec(r15, Integer.MIN_VALUE);
        int r123 = BasicMeasure.EXACTLY;
    L104:
        r28.measure(View.MeasureSpec.makeMeasureSpec(r26, r123), r31);
        goto L73
    L100:
        if (r30 != (-1)) goto L102;
        r123 = BasicMeasure.EXACTLY;
        r31 = View.MeasureSpec.makeMeasureSpec(r15, BasicMeasure.EXACTLY);
        goto L104
    L102:
        r123 = BasicMeasure.EXACTLY;
        r31 = View.MeasureSpec.makeMeasureSpec(r30, BasicMeasure.EXACTLY);
        goto L104
    L103:
        r123 = BasicMeasure.EXACTLY;
        r31 = View.MeasureSpec.makeMeasureSpec(r28.getMeasuredHeight(), BasicMeasure.EXACTLY);
        goto L104
    L94:
        if (r29.weight <= 0.0f) goto L73;
    L106:
        if (r29.weight <= 0.0f) goto L73;
        if (((ViewGroup.MarginLayoutParams) r29).width != 0) goto L116;
        int r124 = ((ViewGroup.MarginLayoutParams) r29).height;
        if (r124 != (-2)) goto L113;
        int r125 = View.MeasureSpec.makeMeasureSpec(r15, Integer.MIN_VALUE);
    L117:
        if (r19 == false) goto L121;
        int r32 = r16 - (((ViewGroup.MarginLayoutParams) r29).leftMargin + ((ViewGroup.MarginLayoutParams) r29).rightMargin);
        r120 = r26;
        int r33 = View.MeasureSpec.makeMeasureSpec(r32, BasicMeasure.EXACTLY);
        if (r122 == r32) goto L122;
        r28.measure(r33, r125);
        goto L122
    L121:
        r120 = r26;
        r28.measure(View.MeasureSpec.makeMeasureSpec(r122 + ((int) ((r29.weight * Math.max(0, r110)) / r111)), BasicMeasure.EXACTLY), r125);
        goto L122
    L113:
        if (r124 != (-1)) goto L115;
        r125 = View.MeasureSpec.makeMeasureSpec(r15, BasicMeasure.EXACTLY);
        goto L117
    L115:
        r125 = View.MeasureSpec.makeMeasureSpec(r124, BasicMeasure.EXACTLY);
        goto L117
    L116:
        r125 = View.MeasureSpec.makeMeasureSpec(r28.getMeasuredHeight(), BasicMeasure.EXACTLY);
        goto L117
    L86:
        r122 = r28.getMeasuredWidth();
        goto L87
    L81:
        if (r29.weight <= 0.0f) goto L83;
        r121 = true;
    L123:
        setMeasuredDimension(r10, getPaddingBottom() + (getPaddingTop() + r14));
        this.mCanSlide = r19;
        if (this.mDragHelper.getViewDragState() == 0) goto L136;
        if (r19 == true) goto L137;
        this.mDragHelper.abort();
        return;
    L137:
        return;
    L136:
        return;
    L68:
        if (r111 <= 0.0f) goto L123;
    L24:
        r14 = (r12 - getPaddingTop()) - getPaddingBottom();
        goto L23
    L25:
        r15 = (r12 - getPaddingTop()) - getPaddingBottom();
        r14 = 0;
        goto L26
    L14:
        if (isInEditMode() == false) goto L18;
        if (r11 != 0) goto L19;
        r12 = 300;
        r11 = Integer.MIN_VALUE;
        goto L19
    L18:
        throw new IllegalStateException("Height must not be UNSPECIFIED");
    L5:
        if (isInEditMode() == false) goto L11;
        if (r5 == Integer.MIN_VALUE) goto L19;
        if (r5 != 0) goto L19;
        r10 = 300;
        goto L19
    L11:
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    }

    public void onPanelDragged(int r5) {
        if (this.mSlideableView != null) goto L6;
        this.mSlideOffset = 0.0f;
        return;
    L6:
        boolean r10 = isLayoutRtlSupport();
        LayoutParams r11 = (LayoutParams) this.mSlideableView.getLayoutParams();
        int r12 = this.mSlideableView.getWidth();
        if (r10 == false) goto L9;
        r5 = (getWidth() - r5) - r12;
    L9:
        if (r10 == false) goto L11;
        int r13 = getPaddingRight();
    L12:
        if (r10 == false) goto L14;
        int r14 = ((ViewGroup.MarginLayoutParams) r11).rightMargin;
    L15:
        float r15 = (r5 - (r13 + r14)) / this.mSlideRange;
        this.mSlideOffset = r15;
        if (this.mParallaxBy == 0) goto L19;
        parallaxOtherViews(r15);
    L19:
        if (r11.dimWhenOffset == false) goto L21;
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
    L21:
        dispatchOnPanelSlide(this.mSlideableView);
        return;
    L14:
        r14 = ((ViewGroup.MarginLayoutParams) r11).leftMargin;
        goto L15
    L11:
        r13 = getPaddingLeft();
        goto L12
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        if (r10.isOpen == false) goto L9;
        openPane();
    L10:
        this.mPreservedOpenState = r10.isOpen;
        return;
    L9:
        closePane();
        goto L10
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        if (isSlideable() == false) goto L5;
        boolean r10 = isOpen();
    L6:
        r5.isOpen = r10;
        return r5;
    L5:
        r10 = this.mPreservedOpenState;
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (r5 == r11) goto L6;
        this.mFirstLayout = true;
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mCanSlide == false) goto L5;
        this.mDragHelper.processTouchEvent(r10);
        int r5 = r10.getActionMasked();
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L11;
    L18:
        return true;
    L11:
        if (isDimmed(this.mSlideableView) == false) goto L18;
        float r11 = r10.getX();
        float r12 = r10.getY();
        float r13 = r11 - this.mInitialMotionX;
        float r14 = r12 - this.mInitialMotionY;
        int r15 = this.mDragHelper.getTouchSlop();
        if (((r14 * r14) + (r13 * r13)) >= (r15 * r15)) goto L18;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) r11, (int) r12) == false) goto L18;
        closePane(this.mSlideableView, 0);
        goto L18
    L17:
        float r16 = r10.getX();
        float r17 = r10.getY();
        this.mInitialMotionX = r16;
        this.mInitialMotionY = r17;
        goto L18
    L5:
        return super.onTouchEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r5, View r10) {
        super.requestChildFocus(r5, r10);
        if (isInTouchMode() == false) goto L5;
        return;
    L5:
        if (this.mCanSlide == false) goto L7;
        return;
    L7:
        if (r5 != this.mSlideableView) goto L9;
        boolean r11 = true;
    L10:
        this.mPreservedOpenState = r11;
        return;
    L9:
        r11 = false;
        goto L10
    }

    public void setAllChildrenVisible() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        View r11 = getChildAt(r10);
        if (r11.getVisibility() != 4) goto L7;
        r11.setVisibility(0);
    L7:
        r10 = r10 + 1;
        goto L3
    }

    public void setCoveredFadeColor(@ColorInt int r5) {
        this.mCoveredFadeColor = r5;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener r5) {
        this.mPanelSlideListener = r5;
    }

    public void setParallaxDistance(@Px int r5) {
        this.mParallaxBy = r5;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable r5) {
        setShadowDrawableLeft(r5);
    }

    public void setShadowDrawableLeft(@Nullable Drawable r5) {
        this.mShadowDrawableLeft = r5;
    }

    public void setShadowDrawableRight(@Nullable Drawable r5) {
        this.mShadowDrawableRight = r5;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int r5) {
        setShadowDrawable(getResources().getDrawable(r5));
    }

    public void setShadowResourceLeft(int r5) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), r5));
    }

    public void setShadowResourceRight(int r5) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), r5));
    }

    public void setSliderFadeColor(@ColorInt int r5) {
        this.mSliderFadeColor = r5;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean smoothSlideTo(float r5, int r10) {
        if (this.mCanSlide == true) goto L5;
        return false;
    L5:
        boolean r11 = isLayoutRtlSupport();
        LayoutParams r12 = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (r11 == false) goto L8;
        int r13 = getPaddingRight() + ((ViewGroup.MarginLayoutParams) r12).rightMargin;
        int r14 = this.mSlideableView.getWidth();
        int r15 = (int) (getWidth() - (((r5 * this.mSlideRange) + r13) + r14));
    L9:
        ViewDragHelper r16 = this.mDragHelper;
        View r17 = this.mSlideableView;
        if (r16.smoothSlideViewTo(r17, r15, r17.getTop()) == false) goto L13;
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    L13:
        return false;
    L8:
        r15 = (int) ((r5 * this.mSlideRange) + (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r12).leftMargin));
        goto L9
    }

    public void updateObscuredViewsVisibility(View r18) {
        View r5 = r18;
        boolean r10 = isLayoutRtlSupport();
        if (r10 == false) goto L5;
        int r11 = getWidth() - getPaddingRight();
    L6:
        if (r10 == false) goto L8;
        int r12 = getPaddingLeft();
    L9:
        int r13 = getPaddingTop();
        int r14 = getHeight() - getPaddingBottom();
        if (r5 != null) goto L12;
    L14:
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r19 = 0;
    L15:
        int r110 = getChildCount();
        int r111 = 0;
    L16:
        if (r111 >= r110) goto L39;
        View r112 = getChildAt(r111);
        if (r112 == r5) goto L44;
        if (r112.getVisibility() == 8) goto L38;
        if (r10 == false) goto L25;
        int r20 = r12;
    L26:
        int r21 = Math.max(r20, r112.getLeft());
        int r113 = Math.max(r13, r112.getTop());
        if (r10 == false) goto L29;
        int r22 = r11;
    L30:
        int r23 = Math.min(r22, r112.getRight());
        int r24 = Math.min(r14, r112.getBottom());
        if (r21 < r15) goto L36;
        if (r113 < r17) goto L36;
        if (r23 > r16) goto L36;
        if (r24 > r19) goto L36;
        int r25 = 4;
    L37:
        r112.setVisibility(r25);
    L36:
        r25 = 0;
        goto L37
    L29:
        r22 = r12;
        goto L30
    L25:
        r20 = r11;
    L38:
        r111 = r111 + 1;
        r5 = r18;
        r10 = r10;
        goto L16
    L44:
        return;
    L39:
        return;
    L12:
        if (viewIsOpaque(r18) == false) goto L14;
        r15 = r18.getLeft();
        r16 = r18.getRight();
        r17 = r18.getTop();
        r19 = r18.getBottom();
        goto L15
    L8:
        r12 = getWidth() - getPaddingRight();
        goto L9
    L5:
        r11 = getPaddingLeft();
        goto L6
    }

    public SlidingPaneLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    public SlidingPaneLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList();
        float r12 = r5.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * r12) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper r13 = ViewDragHelper.create(this, 0.5f, new DragHelperCallback(this));
        this.mDragHelper = r13;
        r13.setMinVelocity(r12 * 400.0f);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }
}

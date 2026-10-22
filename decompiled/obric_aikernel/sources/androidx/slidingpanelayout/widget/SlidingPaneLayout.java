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
import android.os.Build;
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

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ SlidingPaneLayout this$0;

        AccessibilityDelegate(SlidingPaneLayout r10) {
            this.this$0 = r10;
            this.mTmpRect = new Rect();
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r10, AccessibilityNodeInfoCompat r11) {
            Rect r12 = this.mTmpRect;
            r11.getBoundsInParent(r12);
            r10.setBoundsInParent(r12);
            r11.getBoundsInScreen(r12);
            r10.setBoundsInScreen(r12);
            r10.setVisibleToUser(r11.isVisibleToUser());
            r10.setPackageName(r11.getPackageName());
            r10.setClassName(r11.getClassName());
            r10.setContentDescription(r11.getContentDescription());
            r10.setEnabled(r11.isEnabled());
            r10.setClickable(r11.isClickable());
            r10.setFocusable(r11.isFocusable());
            r10.setFocused(r11.isFocused());
            r10.setAccessibilityFocused(r11.isAccessibilityFocused());
            r10.setSelected(r11.isSelected());
            r10.setLongClickable(r11.isLongClickable());
            r10.addAction(r11.getActions());
            r10.setMovementGranularities(r11.getMovementGranularities());
        }

        public boolean filter(View r10) {
            return this.this$0.isDimmed(r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            r11.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.obtain(r11);
            super.onInitializeAccessibilityNodeInfo(r10, r12);
            copyNodeInfoNoChildren(r11, r12);
            r12.recycle();
            r11.setClassName(SlidingPaneLayout.class.getName());
            r11.setSource(r10);
            Object r13 = ViewCompat.getParentForAccessibility(r10);
            if ((r13 instanceof View) == false) goto L5;
            r11.setParent((View) r13);
        L5:
            int r14 = this.this$0.getChildCount();
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L13;
            View r16 = this.this$0.getChildAt(r15);
            if (filter(r16) == true) goto L12;
            if (r16.getVisibility() != 0) goto L12;
            ViewCompat.setImportantForAccessibility(r16, 1);
            r11.addChild(r16);
        L12:
            r15 = r15 + 1;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
            if (filter(r11) == false) goto L5;
            return false;
        L5:
            return super.onRequestSendAccessibilityEvent(r10, r11, r12);
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View mChildView;
        final /* synthetic */ SlidingPaneLayout this$0;

        DisableLayerRunnable(SlidingPaneLayout r10, View r11) {
            this.this$0 = r10;
            this.mChildView = r11;
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

    private class DragHelperCallback extends ViewDragHelper.Callback {
        final /* synthetic */ SlidingPaneLayout this$0;

        DragHelperCallback(SlidingPaneLayout r10) {
            this.this$0 = r10;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r10, int r11, int r12) {
            LayoutParams r13 = (LayoutParams) this.this$0.mSlideableView.getLayoutParams();
            if (this.this$0.isLayoutRtlSupport() == false) goto L5;
            int r14 = this.this$0.getWidth() - ((this.this$0.getPaddingRight() + ((ViewGroup.MarginLayoutParams) r13).rightMargin) + this.this$0.mSlideableView.getWidth());
            int r15 = r14 - this.this$0.mSlideRange;
            return Math.max(Math.min(r11, r14), r15);
        L5:
            int r16 = this.this$0.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r13).leftMargin;
            int r17 = this.this$0.mSlideRange + r16;
            return Math.min(Math.max(r11, r16), r17);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r10, int r11, int r12) {
            return r10.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r10) {
            return this.this$0.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r10, int r11) {
            SlidingPaneLayout r12 = this.this$0;
            r12.mDragHelper.captureChildView(r12.mSlideableView, r11);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r10, int r11) {
            this.this$0.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r10) {
            if (this.this$0.mDragHelper.getViewDragState() != 0) goto L10;
            SlidingPaneLayout r11 = this.this$0;
            if (r11.mSlideOffset != 0.0f) goto L7;
            r11.updateObscuredViewsVisibility(r11.mSlideableView);
            SlidingPaneLayout r12 = this.this$0;
            r12.dispatchOnPanelClosed(r12.mSlideableView);
            SlidingPaneLayout r13 = this.this$0;
            boolean r14 = false;
        L8:
            r13.mPreservedOpenState = r14;
            return;
        L7:
            r11.dispatchOnPanelOpened(r11.mSlideableView);
            r13 = this.this$0;
            r14 = true;
            goto L8
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r10, int r11, int r12, int r13, int r14) {
            this.this$0.onPanelDragged(r11);
            this.this$0.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r10, float r11, float r12) {
            LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
            if (this.this$0.isLayoutRtlSupport() == false) goto L12;
            int r14 = this.this$0.getPaddingRight() + ((ViewGroup.MarginLayoutParams) r13).rightMargin;
            if (r11 >= 0.0f) goto L7;
        L10:
            r14 = r14 + this.this$0.mSlideRange;
        L11:
            int r15 = this.this$0.mSlideableView.getWidth();
            int r16 = (this.this$0.getWidth() - r14) - r15;
        L18:
            this.this$0.mDragHelper.settleCapturedViewAt(r16, r10.getTop());
            this.this$0.invalidate();
            return;
        L7:
            if (r11 != 0.0f) goto L11;
            if (this.this$0.mSlideOffset <= 0.5f) goto L11;
        L12:
            int r17 = this.this$0.getPaddingLeft();
            r16 = ((ViewGroup.MarginLayoutParams) r13).leftMargin + r17;
            if (r11 > 0.0f) goto L17;
            if (r11 != 0.0f) goto L18;
            if (this.this$0.mSlideOffset <= 0.5f) goto L18;
        L17:
            r16 = r16 + this.this$0.mSlideRange;
            goto L18
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r10, int r11) {
            if (this.this$0.mIsUnableToDrag == false) goto L7;
            return false;
        L7:
            return ((LayoutParams) r10.getLayoutParams()).slideable;
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

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull Context r10, @Nullable AttributeSet r11) {
            super(r10, r11);
            this.weight = 0.0f;
            TypedArray r12 = r10.obtainStyledAttributes(r11, ATTRS);
            this.weight = r12.getFloat(0, 0.0f);
            r12.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r10) {
            super(r10);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull LayoutParams r10) {
            super(r10);
            this.weight = 0.0f;
            this.weight = r10.weight;
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View r10);

        void onPanelOpened(@NonNull View r10);

        void onPanelSlide(@NonNull View r10, float r11);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isOpen;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r10.readInt() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.isOpen = r12;
            return;
        L5:
            r12 = false;
            goto L6
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.isOpen ? 1 : 0);
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public SimplePanelSlideListener() {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View r10) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View r10) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View r10, float r11) {
        }
    }

    public SlidingPaneLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public SlidingPaneLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public SlidingPaneLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList();
        float r13 = r10.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * r13) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper r14 = ViewDragHelper.create(this, 0.5f, new DragHelperCallback(this));
        this.mDragHelper = r14;
        r14.setMinVelocity(r13 * 400.0f);
    }

    private boolean closePane(View r10, int r11) {
        if (this.mFirstLayout == false) goto L5;
    L8:
        this.mPreservedOpenState = false;
        return true;
    L5:
        if (smoothSlideTo(0.0f, r11) == true) goto L8;
        return false;
    }

    private void dimChildView(View r10, float r11, int r12) {
        LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
        if (r11 <= 0.0f) goto L13;
        if (r12 == 0) goto L13;
        int r14 = (((int) ((((-16777216) & r12) >>> 24) * r11)) << 24) | (r12 & ViewCompat.MEASURED_SIZE_MASK);
        if (r13.dimPaint != null) goto L8;
        r13.dimPaint = new Paint();
    L8:
        r13.dimPaint.setColorFilter(new PorterDuffColorFilter(r14, PorterDuff.Mode.SRC_OVER));
        if (r10.getLayerType() == 2) goto L11;
        r10.setLayerType(2, r13.dimPaint);
    L11:
        invalidateChildRegion(r10);
        return;
    L13:
        if (r10.getLayerType() == 0) goto L20;
        Paint r15 = r13.dimPaint;
        if (r15 == null) goto L17;
        r15.setColorFilter(null);
    L17:
        DisableLayerRunnable r16 = new DisableLayerRunnable(this, r10);
        this.mPostedRunnables.add(r16);
        ViewCompat.postOnAnimation(this, r16);
        return;
    }

    private boolean openPane(View r10, int r11) {
        if (this.mFirstLayout == false) goto L5;
    L9:
        this.mPreservedOpenState = true;
        return true;
    L5:
        if (smoothSlideTo(1.0f, r11) == true) goto L9;
        return false;
    }

    private void parallaxOtherViews(float r10) {
        boolean r11 = isLayoutRtlSupport();
        LayoutParams r12 = (LayoutParams) this.mSlideableView.getLayoutParams();
        int r13 = 0;
        if (r12.dimWhenOffset == false) goto L9;
        if (r11 == false) goto L6;
        int r14 = ((ViewGroup.MarginLayoutParams) r12).rightMargin;
    L7:
        if (r14 > 0) goto L9;
        boolean r15 = true;
    L10:
        int r16 = getChildCount();
    L11:
        if (r13 >= r16) goto L26;
        View r17 = getChildAt(r13);
        if (r17 == this.mSlideableView) goto L25;
        float r18 = 1.0f - this.mParallaxOffset;
        int r19 = this.mParallaxBy;
        this.mParallaxOffset = r10;
        int r20 = ((int) (r18 * r19)) - ((int) ((1.0f - r10) * r19));
        if (r11 == false) goto L18;
        r20 = -r20;
    L18:
        r17.offsetLeftAndRight(r20);
        if (r15 == false) goto L25;
        float r21 = this.mParallaxOffset;
        if (r11 == false) goto L23;
        float r22 = r21 - 1.0f;
    L24:
        dimChildView(r17, r22, this.mCoveredFadeColor);
        goto L25
    L23:
        r22 = 1.0f - r21;
    L25:
        r13 = r13 + 1;
        goto L11
    L26:
        return;
    L6:
        r14 = ((ViewGroup.MarginLayoutParams) r12).leftMargin;
    L9:
        r15 = false;
        goto L10
    }

    private static boolean viewIsOpaque(View r10) {
        if (r10.isOpaque() == false) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return false;
    L8:
        Drawable r11 = r10.getBackground();
        if (r11 != null) goto L11;
        return false;
    L11:
        if (r11.getOpacity() != (-1)) goto L14;
        return true;
    L14:
        return false;
    }

    protected boolean canScroll(View r13, boolean r14, int r15, int r16, int r17) {
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r10 = (ViewGroup) r13;
        int r11 = r13.getScrollX();
        int r12 = r13.getScrollY();
        int r18 = r10.getChildCount() - 1;
    L5:
        if (r18 < 0) goto L18;
        View r19 = r10.getChildAt(r18);
        int r20 = r16 + r11;
        if (r20 < r19.getLeft()) goto L17;
        if (r20 >= r19.getRight()) goto L17;
        int r21 = r17 + r12;
        if (r21 < r19.getTop()) goto L17;
        if (r21 >= r19.getBottom()) goto L17;
        if (canScroll(r19, true, r15, r20 - r19.getLeft(), r21 - r19.getTop()) == false) goto L17;
        return true;
    L17:
        r18 = r18 - 1;
    L18:
        if (r14 == true) goto L20;
    L26:
        return false;
    L20:
        if (isLayoutRtlSupport() == false) goto L22;
        int r22 = r15;
    L24:
        if (r13.canScrollHorizontally(r22) == false) goto L26;
        return true;
    L22:
        r22 = -r15;
        goto L24
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r10) == false) goto L7;
        return true;
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
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

    void dispatchOnPanelClosed(View r10) {
        PanelSlideListener r11 = this.mPanelSlideListener;
        if (r11 == null) goto L5;
        r11.onPanelClosed(r10);
    L5:
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelOpened(View r10) {
        PanelSlideListener r11 = this.mPanelSlideListener;
        if (r11 == null) goto L5;
        r11.onPanelOpened(r10);
    L5:
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelSlide(View r10) {
        PanelSlideListener r11 = this.mPanelSlideListener;
        if (r11 == null) goto L6;
        r11.onPanelSlide(r10, this.mSlideOffset);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        if (isLayoutRtlSupport() == false) goto L5;
        Drawable r11 = this.mShadowDrawableRight;
    L7:
        if (getChildCount() <= 1) goto L9;
        View r12 = getChildAt(1);
    L10:
        if (r12 == null) goto L19;
        if (r11 == null) goto L20;
        int r13 = r12.getTop();
        int r14 = r12.getBottom();
        int r15 = r11.getIntrinsicWidth();
        if (isLayoutRtlSupport() == false) goto L16;
        int r16 = r12.getRight();
        int r17 = r15 + r16;
    L17:
        r11.setBounds(r16, r13, r17, r14);
        r11.draw(r10);
        return;
    L16:
        int r18 = r12.getLeft();
        int r19 = r18 - r15;
        r17 = r18;
        r16 = r19;
        goto L17
    L20:
        return;
    L19:
        return;
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = this.mShadowDrawableLeft;
        goto L7
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas r10, View r11, long r12) {
        LayoutParams r13 = (LayoutParams) r11.getLayoutParams();
        int r14 = r10.save();
        if (this.mCanSlide == true) goto L5;
    L13:
        boolean r15 = super.drawChild(r10, r11, r12);
        r10.restoreToCount(r14);
        return r15;
    L5:
        if (r13.slideable == true) goto L13;
        if (this.mSlideableView == null) goto L13;
        r10.getClipBounds(this.mTmpRect);
        if (isLayoutRtlSupport() == false) goto L11;
        Rect r16 = this.mTmpRect;
        r16.left = Math.max(r16.left, this.mSlideableView.getRight());
    L12:
        r10.clipRect(this.mTmpRect);
        goto L13
    L11:
        Rect r17 = this.mTmpRect;
        r17.right = Math.min(r17.right, this.mSlideableView.getLeft());
        goto L12
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L6:
        return new LayoutParams(r10);
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

    void invalidateChildRegion(View r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 17) goto L7;
        ViewCompat.setLayerPaint(r10, ((LayoutParams) r10.getLayoutParams()).dimPaint);
        return;
    L7:
        if (r11 >= 16) goto L9;
    L30:
        ViewCompat.postInvalidateOnAnimation(this, r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
        return;
    L9:
        if (this.mDisplayListReflectionLoaded == true) goto L20;
        this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);     // Catch: NoSuchMethodException -> L12
    L34:
        Field r12 = View.class.getDeclaredField("mRecreateDisplayList");     // Catch: NoSuchFieldException -> L16
        this.mRecreateDisplayList = r12;     // Catch: NoSuchFieldException -> L16
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L16
    L18:
        this.mDisplayListReflectionLoaded = true;
    L16:
        e = move-exception;
        Log.e(TAG, "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e);
    L12:
        e = move-exception;
        Log.e(TAG, "Couldn't fetch getDisplayList method; dimming won't work right.", e);
    L20:
        if (this.mGetDisplayList == null) goto L28;
        Field r13 = this.mRecreateDisplayList;
        if (r13 == null) goto L28;
        r13.setBoolean(r10, true);     // Catch: Exception -> L26
        this.mGetDisplayList.invoke(r10, null);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "Error refreshing display list state", e);
    L28:
        r10.invalidate();
    }

    boolean isDimmed(View r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if (this.mCanSlide == true) goto L8;
        return false;
    L8:
        if (r11.dimWhenOffset == true) goto L10;
        return false;
    L10:
        if (this.mSlideOffset <= 0.0f) goto L15;
        return true;
    L15:
        return false;
    }

    boolean isLayoutRtlSupport() {
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
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int r10 = this.mPostedRunnables.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mPostedRunnables.get(r11).run();
        r11 = r11 + 1;
        goto L3
    L5:
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (this.mCanSlide == true) goto L11;
        if (r11 != 0) goto L11;
        if (getChildCount() <= 1) goto L11;
        View r12 = getChildAt(1);
        if (r12 == null) goto L11;
        this.mPreservedOpenState = !this.mDragHelper.isViewUnder(r12, (int) r10.getX(), (int) r10.getY());
    L11:
        if (this.mCanSlide == true) goto L13;
    L44:
        this.mDragHelper.cancel();
        return super.onInterceptTouchEvent(r10);
    L13:
        if (this.mIsUnableToDrag == false) goto L17;
        if (r11 != 0) goto L44;
    L17:
        if (r11 == 3) goto L42;
        if (r11 == 1) goto L42;
        if (r11 != 0) goto L22;
        this.mIsUnableToDrag = false;
        float r13 = r10.getX();
        float r14 = r10.getY();
        this.mInitialMotionX = r13;
        this.mInitialMotionY = r14;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) r13, (int) r14) == true) goto L33;
    L35:
        boolean r15 = false;
    L37:
        if (this.mDragHelper.shouldInterceptTouchEvent(r10) == true) goto L46;
        if (r15 == false) goto L41;
        return true;
    L41:
        return false;
    L46:
        return true;
    L33:
        if (isDimmed(this.mSlideableView) == false) goto L35;
        r15 = true;
        goto L37
    L22:
        if (r11 != 2) goto L35;
        float r16 = r10.getX();
        float r17 = r10.getY();
        float r18 = Math.abs(r16 - this.mInitialMotionX);
        float r19 = Math.abs(r17 - this.mInitialMotionY);
        if (r18 <= this.mDragHelper.getTouchSlop()) goto L35;
        if (r19 <= r18) goto L35;
        this.mDragHelper.cancel();
        this.mIsUnableToDrag = true;
        return false;
    L42:
        this.mDragHelper.cancel();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        boolean r10 = isLayoutRtlSupport();
        ViewDragHelper r11 = this.mDragHelper;
        if (r10 == false) goto L5;
        r11.setEdgeTrackingEnabled(2);
    L6:
        int r12 = r22 - r20;
        if (r10 == false) goto L9;
        int r13 = getPaddingRight();
    L10:
        if (r10 == false) goto L12;
        int r14 = getPaddingLeft();
    L13:
        int r15 = getPaddingTop();
        int r16 = getChildCount();
        if (this.mFirstLayout == true) goto L16;
    L22:
        int r17 = r13;
        int r18 = 0;
    L23:
        if (r18 >= r16) goto L50;
        View r110 = getChildAt(r18);
        if (r110.getVisibility() == 8) goto L48;
        LayoutParams r111 = (LayoutParams) r110.getLayoutParams();
        int r112 = r110.getMeasuredWidth();
        if (r111.slideable == false) goto L39;
        int r24 = r12 - r14;
        int r113 = (Math.min(r13, r24 - this.mOverhangSize) - r17) - (((ViewGroup.MarginLayoutParams) r111).leftMargin + ((ViewGroup.MarginLayoutParams) r111).rightMargin);
        this.mSlideRange = r113;
        if (r10 == false) goto L32;
        int r25 = ((ViewGroup.MarginLayoutParams) r111).rightMargin;
    L34:
        if ((((r17 + r25) + r113) + (r112 / 2)) <= r24) goto L36;
        boolean r26 = true;
    L37:
        r111.dimWhenOffset = r26;
        int r27 = (int) (r113 * this.mSlideOffset);
        r17 = r17 + (r25 + r27);
        this.mSlideOffset = r27 / r113;
        int r28 = 0;
    L44:
        if (r10 == false) goto L46;
        int r29 = (r12 - r17) + r28;
        int r30 = r29 - r112;
    L47:
        r110.layout(r30, r15, r29, r110.getMeasuredHeight() + r15);
        r13 = r13 + r110.getWidth();
        goto L48
    L46:
        r30 = r17 - r28;
        r29 = r30 + r112;
        goto L47
    L36:
        r26 = false;
        goto L37
    L32:
        r25 = ((ViewGroup.MarginLayoutParams) r111).leftMargin;
        goto L34
    L39:
        if (this.mCanSlide == false) goto L43;
        int r31 = this.mParallaxBy;
        if (r31 == 0) goto L43;
        r28 = (int) ((1.0f - this.mSlideOffset) * r31);
        r17 = r13;
    L43:
        r17 = r13;
        r28 = 0;
    L48:
        r18 = r18 + 1;
        goto L23
    L50:
        if (this.mFirstLayout == true) goto L52;
    L63:
        this.mFirstLayout = false;
        return;
    L52:
        if (this.mCanSlide == true) goto L54;
        int r32 = 0;
    L60:
        if (r32 >= r16) goto L62;
        dimChildView(getChildAt(r32), 0.0f, this.mSliderFadeColor);
        r32 = r32 + 1;
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
        float r33 = 0.0f;
    L21:
        this.mSlideOffset = r33;
        goto L22
    L18:
        if (this.mPreservedOpenState == false) goto L20;
        r33 = 1.0f;
        goto L21
    L12:
        r14 = getPaddingRight();
        goto L13
    L9:
        r13 = getPaddingLeft();
        goto L10
    L5:
        r11.setEdgeTrackingEnabled(1);
        goto L6
    }

    @Override // android.view.View
    protected void onMeasure(int r21, int r22) {
        int r10 = View.MeasureSpec.getMode(r21);
        int r11 = View.MeasureSpec.getSize(r21);
        int r12 = View.MeasureSpec.getMode(r22);
        int r13 = View.MeasureSpec.getSize(r22);
        if (r10 != 1073741824) goto L5;
        if (r12 == 0) goto L14;
    L19:
        boolean r14 = false;
        if (r12 == Integer.MIN_VALUE) goto L25;
        if (r12 == 1073741824) goto L24;
        int r15 = 0;
    L23:
        int r16 = r15;
    L26:
        int r17 = (r11 - getPaddingLeft()) - getPaddingRight();
        int r18 = getChildCount();
        if (r18 <= 2) goto L29;
        Log.e(TAG, "onMeasure: More than two child views are not supported.");
    L29:
        this.mSlideableView = null;
        int r19 = 0;
        boolean r110 = false;
        int r111 = r17;
        float r112 = 0.0f;
    L30:
        int r113 = 8;
        if (r19 >= r18) goto L69;
        View r20 = getChildAt(r19);
        LayoutParams r23 = (LayoutParams) r20.getLayoutParams();
        if (r20.getVisibility() != 8) goto L35;
        r23.dimWhenOffset = r14;
    L68:
        r19 = r19 + 1;
        r14 = false;
        goto L30
    L35:
        float r114 = r23.weight;
        if (r114 <= 0.0f) goto L40;
        r112 = r112 + r114;
        if (((ViewGroup.MarginLayoutParams) r23).width == 0) goto L68;
    L40:
        int r115 = ((ViewGroup.MarginLayoutParams) r23).leftMargin + ((ViewGroup.MarginLayoutParams) r23).rightMargin;
        int r116 = ((ViewGroup.MarginLayoutParams) r23).width;
        if (r116 != (-2)) goto L44;
        int r117 = View.MeasureSpec.makeMeasureSpec(r17 - r115, Integer.MIN_VALUE);
        float r24 = r112;
        int r118 = Integer.MIN_VALUE;
    L43:
        int r119 = r117;
    L48:
        int r120 = ((ViewGroup.MarginLayoutParams) r23).height;
        if (r120 != (-2)) goto L52;
        int r25 = View.MeasureSpec.makeMeasureSpec(r16, r118);
    L56:
        r20.measure(r119, r25);
        int r26 = r20.getMeasuredWidth();
        int r121 = r20.getMeasuredHeight();
        if (r12 != r118) goto L60;
        if (r121 <= r15) goto L60;
        r15 = Math.min(r121, r16);
    L60:
        r111 = r111 - r26;
        if (r111 >= 0) goto L63;
        boolean r27 = true;
    L64:
        r23.slideable = r27;
        r110 = r110 | r27;
        if (r27 == false) goto L67;
        this.mSlideableView = r20;
    L67:
        r112 = r24;
        goto L68
    L63:
        r27 = false;
        goto L64
    L52:
        if (r120 != (-1)) goto L54;
        int r122 = View.MeasureSpec.makeMeasureSpec(r16, 1073741824);
    L55:
        r25 = r122;
        goto L56
    L54:
        r122 = View.MeasureSpec.makeMeasureSpec(r120, 1073741824);
        goto L55
    L44:
        r24 = r112;
        r118 = Integer.MIN_VALUE;
        if (r116 != (-1)) goto L47;
        r117 = View.MeasureSpec.makeMeasureSpec(r17 - r115, 1073741824);
        goto L43
    L47:
        r119 = View.MeasureSpec.makeMeasureSpec(r116, 1073741824);
        goto L48
    L69:
        if (r110 == false) goto L71;
    L72:
        int r28 = r17 - this.mOverhangSize;
        int r29 = 0;
    L73:
        if (r29 >= r18) goto L128;
        View r30 = getChildAt(r29);
        if (r30.getVisibility() != r113) goto L78;
    L76:
        int r123 = r28;
    L127:
        r29 = r29 + 1;
        r28 = r123;
        r113 = 8;
        goto L73
    L78:
        LayoutParams r31 = (LayoutParams) r30.getLayoutParams();
        if (r30.getVisibility() == r113) goto L76;
        if (((ViewGroup.MarginLayoutParams) r31).width == 0) goto L84;
    L86:
        boolean r124 = false;
    L87:
        if (r124 == false) goto L89;
        int r125 = 0;
    L90:
        if (r110 == false) goto L110;
        if (r30 == this.mSlideableView) goto L110;
        if (((ViewGroup.MarginLayoutParams) r31).width >= 0) goto L76;
        if (r125 <= r28) goto L97;
    L98:
        if (r124 == false) goto L106;
        int r32 = ((ViewGroup.MarginLayoutParams) r31).height;
        if (r32 != (-2)) goto L103;
        int r33 = View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE);
        int r126 = 1073741824;
    L108:
        r30.measure(View.MeasureSpec.makeMeasureSpec(r28, r126), r33);
        goto L76
    L103:
        if (r32 != (-1)) goto L105;
        r126 = 1073741824;
        r33 = View.MeasureSpec.makeMeasureSpec(r16, 1073741824);
        goto L108
    L105:
        r126 = 1073741824;
    L107:
        r33 = View.MeasureSpec.makeMeasureSpec(r32, r126);
        goto L108
    L106:
        r126 = 1073741824;
        r32 = r30.getMeasuredHeight();
        goto L107
    L97:
        if (r31.weight <= 0.0f) goto L76;
    L110:
        if (r31.weight <= 0.0f) goto L76;
        if (((ViewGroup.MarginLayoutParams) r31).width != 0) goto L120;
        int r127 = ((ViewGroup.MarginLayoutParams) r31).height;
        if (r127 != (-2)) goto L117;
        int r128 = View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE);
    L122:
        if (r110 == false) goto L126;
        int r34 = r17 - (((ViewGroup.MarginLayoutParams) r31).leftMargin + ((ViewGroup.MarginLayoutParams) r31).rightMargin);
        r123 = r28;
        int r35 = View.MeasureSpec.makeMeasureSpec(r34, 1073741824);
        if (r125 == r34) goto L127;
        r30.measure(r35, r128);
        goto L127
    L126:
        r123 = r28;
        r30.measure(View.MeasureSpec.makeMeasureSpec(r125 + ((int) ((r31.weight * Math.max(0, r111)) / r112)), 1073741824), r128);
        goto L127
    L117:
        if (r127 != (-1)) goto L119;
        r128 = View.MeasureSpec.makeMeasureSpec(r16, 1073741824);
        goto L122
    L119:
        int r129 = 1073741824;
    L121:
        r128 = View.MeasureSpec.makeMeasureSpec(r127, r129);
        goto L122
    L120:
        r129 = 1073741824;
        r127 = r30.getMeasuredHeight();
        goto L121
    L89:
        r125 = r30.getMeasuredWidth();
        goto L90
    L84:
        if (r31.weight <= 0.0f) goto L86;
        r124 = true;
    L128:
        setMeasuredDimension(r11, (r15 + getPaddingTop()) + getPaddingBottom());
        this.mCanSlide = r110;
        if (this.mDragHelper.getViewDragState() == 0) goto L140;
        if (r110 == true) goto L141;
        this.mDragHelper.abort();
        return;
    L141:
        return;
    L140:
        return;
    L71:
        if (r112 <= 0.0f) goto L128;
    L24:
        r15 = (r13 - getPaddingTop()) - getPaddingBottom();
        goto L23
    L25:
        r16 = (r13 - getPaddingTop()) - getPaddingBottom();
        r15 = 0;
        goto L26
    L14:
        if (isInEditMode() == false) goto L18;
        if (r12 != 0) goto L19;
        r13 = 300;
        r12 = Integer.MIN_VALUE;
        goto L19
    L18:
        throw new IllegalStateException("Height must not be UNSPECIFIED");
    L5:
        if (isInEditMode() == false) goto L11;
        if (r10 == Integer.MIN_VALUE) goto L19;
        if (r10 != 0) goto L19;
        r11 = 300;
        goto L19
    L11:
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    }

    void onPanelDragged(int r10) {
        if (this.mSlideableView != null) goto L6;
        this.mSlideOffset = 0.0f;
        return;
    L6:
        boolean r11 = isLayoutRtlSupport();
        LayoutParams r12 = (LayoutParams) this.mSlideableView.getLayoutParams();
        int r13 = this.mSlideableView.getWidth();
        if (r11 == false) goto L9;
        r10 = (getWidth() - r10) - r13;
    L9:
        if (r11 == false) goto L11;
        int r14 = getPaddingRight();
    L12:
        if (r11 == false) goto L14;
        int r15 = ((ViewGroup.MarginLayoutParams) r12).rightMargin;
    L15:
        float r16 = (r10 - (r14 + r15)) / this.mSlideRange;
        this.mSlideOffset = r16;
        if (this.mParallaxBy == 0) goto L19;
        parallaxOtherViews(r16);
    L19:
        if (r12.dimWhenOffset == false) goto L21;
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
    L21:
        dispatchOnPanelSlide(this.mSlideableView);
        return;
    L14:
        r15 = ((ViewGroup.MarginLayoutParams) r12).leftMargin;
        goto L15
    L11:
        r14 = getPaddingLeft();
        goto L12
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        if (r11.isOpen == false) goto L9;
        openPane();
    L10:
        this.mPreservedOpenState = r11.isOpen;
        return;
    L9:
        closePane();
        goto L10
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        if (isSlideable() == false) goto L5;
        boolean r11 = isOpen();
    L6:
        r10.isOpen = r11;
        return r10;
    L5:
        r11 = this.mPreservedOpenState;
        goto L6
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 == r12) goto L6;
        this.mFirstLayout = true;
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mCanSlide == false) goto L5;
        this.mDragHelper.processTouchEvent(r10);
        int r11 = r10.getActionMasked();
        if (r11 == 0) goto L17;
        if (r11 == 1) goto L11;
    L18:
        return true;
    L11:
        if (isDimmed(this.mSlideableView) == false) goto L18;
        float r12 = r10.getX();
        float r13 = r10.getY();
        float r14 = r12 - this.mInitialMotionX;
        float r15 = r13 - this.mInitialMotionY;
        int r16 = this.mDragHelper.getTouchSlop();
        if (((r14 * r14) + (r15 * r15)) >= (r16 * r16)) goto L18;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) r12, (int) r13) == false) goto L18;
        closePane(this.mSlideableView, 0);
        goto L18
    L17:
        float r17 = r10.getX();
        float r18 = r10.getY();
        this.mInitialMotionX = r17;
        this.mInitialMotionY = r18;
        goto L18
    L5:
        return super.onTouchEvent(r10);
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r10, View r11) {
        super.requestChildFocus(r10, r11);
        if (isInTouchMode() == false) goto L5;
        return;
    L5:
        if (this.mCanSlide == false) goto L7;
        return;
    L7:
        if (r10 != this.mSlideableView) goto L9;
        boolean r12 = true;
    L10:
        this.mPreservedOpenState = r12;
        return;
    L9:
        r12 = false;
        goto L10
    }

    void setAllChildrenVisible() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() != 4) goto L7;
        r12.setVisibility(0);
    L7:
        r11 = r11 + 1;
        goto L3
    }

    public void setCoveredFadeColor(@ColorInt int r10) {
        this.mCoveredFadeColor = r10;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener r10) {
        this.mPanelSlideListener = r10;
    }

    public void setParallaxDistance(@Px int r10) {
        this.mParallaxBy = r10;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable r10) {
        setShadowDrawableLeft(r10);
    }

    public void setShadowDrawableLeft(@Nullable Drawable r10) {
        this.mShadowDrawableLeft = r10;
    }

    public void setShadowDrawableRight(@Nullable Drawable r10) {
        this.mShadowDrawableRight = r10;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int r10) {
        setShadowDrawable(getResources().getDrawable(r10));
    }

    public void setShadowResourceLeft(int r10) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), r10));
    }

    public void setShadowResourceRight(int r10) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), r10));
    }

    public void setSliderFadeColor(@ColorInt int r10) {
        this.mSliderFadeColor = r10;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    boolean smoothSlideTo(float r10, int r11) {
        if (this.mCanSlide == true) goto L5;
        return false;
    L5:
        boolean r12 = isLayoutRtlSupport();
        LayoutParams r13 = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (r12 == false) goto L8;
        int r14 = getPaddingRight() + ((ViewGroup.MarginLayoutParams) r13).rightMargin;
        int r15 = (int) (getWidth() - ((r14 + (r10 * this.mSlideRange)) + this.mSlideableView.getWidth()));
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
        r15 = (int) ((getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r13).leftMargin) + (r10 * this.mSlideRange));
        goto L9
    }

    void updateObscuredViewsVisibility(View r18) {
        View r10 = r18;
        boolean r11 = isLayoutRtlSupport();
        if (r11 == false) goto L5;
        int r12 = getWidth() - getPaddingRight();
    L6:
        if (r11 == false) goto L8;
        int r13 = getPaddingLeft();
    L9:
        int r14 = getPaddingTop();
        int r15 = getHeight() - getPaddingBottom();
        if (r10 != null) goto L12;
    L14:
        int r16 = 0;
        int r17 = 0;
        int r19 = 0;
        int r110 = 0;
    L15:
        int r111 = getChildCount();
        int r112 = 0;
    L16:
        if (r112 >= r111) goto L39;
        View r113 = getChildAt(r112);
        if (r113 == r10) goto L44;
        if (r113.getVisibility() == 8) goto L38;
        if (r11 == false) goto L25;
        int r20 = r13;
    L26:
        int r21 = Math.max(r20, r113.getLeft());
        int r114 = Math.max(r14, r113.getTop());
        if (r11 == false) goto L29;
        int r22 = r12;
    L30:
        int r23 = Math.min(r22, r113.getRight());
        int r24 = Math.min(r15, r113.getBottom());
        if (r21 < r16) goto L36;
        if (r114 < r19) goto L36;
        if (r23 > r17) goto L36;
        if (r24 > r110) goto L36;
        int r25 = 4;
    L37:
        r113.setVisibility(r25);
    L36:
        r25 = 0;
        goto L37
    L29:
        r22 = r13;
        goto L30
    L25:
        r20 = r12;
    L38:
        r112 = r112 + 1;
        r10 = r18;
        r11 = r11;
        goto L16
    L44:
        return;
    L39:
        return;
    L12:
        if (viewIsOpaque(r18) == false) goto L14;
        r16 = r18.getLeft();
        r17 = r18.getRight();
        r19 = r18.getTop();
        r110 = r18.getBottom();
        goto L15
    L8:
        r13 = getWidth() - getPaddingRight();
        goto L9
    L5:
        r12 = getPaddingLeft();
        goto L6
    }
}

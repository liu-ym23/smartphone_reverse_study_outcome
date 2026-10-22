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
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        AccessibilityDelegate(SlidingPaneLayout r1) {
            this.this$0 = r1;
            this.mTmpRect = new Rect();
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r1, AccessibilityNodeInfoCompat r2) {
            Rect r0 = this.mTmpRect;
            r2.getBoundsInParent(r0);
            r1.setBoundsInParent(r0);
            r2.getBoundsInScreen(r0);
            r1.setBoundsInScreen(r0);
            r1.setVisibleToUser(r2.isVisibleToUser());
            r1.setPackageName(r2.getPackageName());
            r1.setClassName(r2.getClassName());
            r1.setContentDescription(r2.getContentDescription());
            r1.setEnabled(r2.isEnabled());
            r1.setClickable(r2.isClickable());
            r1.setFocusable(r2.isFocusable());
            r1.setFocused(r2.isFocused());
            r1.setAccessibilityFocused(r2.isAccessibilityFocused());
            r1.setSelected(r2.isSelected());
            r1.setLongClickable(r2.isLongClickable());
            r1.addAction(r2.getActions());
            r1.setMovementGranularities(r2.getMovementGranularities());
        }

        public boolean filter(View r1) {
            return this.this$0.isDimmed(r1);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r1, r2);
            r2.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r4, AccessibilityNodeInfoCompat r5) {
            AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.obtain(r5);
            super.onInitializeAccessibilityNodeInfo(r4, r0);
            copyNodeInfoNoChildren(r5, r0);
            r0.recycle();
            r5.setClassName(SlidingPaneLayout.class.getName());
            r5.setSource(r4);
            ViewParent r6 = ViewCompat.getParentForAccessibility(r4);
            if (ZeusTransformUtils.instanceOf(r6, View.class) == false) goto L5;
            r5.setParent((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        L5:
            int r7 = this.this$0.getChildCount();
            int r1 = 0;
        L6:
            if (r1 >= r7) goto L13;
            View r2 = this.this$0.getChildAt(r1);
            if (filter(r2) == true) goto L12;
            if (r2.getVisibility() != 0) goto L12;
            ViewCompat.setImportantForAccessibility(r2, 1);
            r5.addChild(r2);
        L12:
            r1 = r1 + 1;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r2, View r3, AccessibilityEvent r4) {
            if (filter(r3) == false) goto L5;
            return false;
        L5:
            return super.onRequestSendAccessibilityEvent(r2, r3, r4);
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View mChildView;
        final /* synthetic */ SlidingPaneLayout this$0;

        DisableLayerRunnable(SlidingPaneLayout r1, View r2) {
            this.this$0 = r1;
            this.mChildView = r2;
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

        DragHelperCallback(SlidingPaneLayout r1) {
            this.this$0 = r1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r2, int r3, int r4) {
            LayoutParams r5 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.this$0.mSlideableView.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            if (this.this$0.isLayoutRtlSupport() == false) goto L5;
            int r6 = this.this$0.getWidth() - ((this.this$0.getPaddingRight() + r5.rightMargin) + this.this$0.mSlideableView.getWidth());
            int r1 = r6 - this.this$0.mSlideRange;
            return Math.max(Math.min(r3, r6), r1);
        L5:
            int r7 = this.this$0.getPaddingLeft() + r5.leftMargin;
            int r8 = this.this$0.mSlideRange + r7;
            return Math.min(Math.max(r3, r7), r8);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r1, int r2, int r3) {
            return r1.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r1) {
            return this.this$0.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r1, int r2) {
            this.this$0.mDragHelper.captureChildView(this.this$0.mSlideableView, r2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r1, int r2) {
            this.this$0.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r2) {
            if (this.this$0.mDragHelper.getViewDragState() == 0) goto L5;
            return;
        L5:
            if (this.this$0.mSlideOffset != 0.0f) goto L7;
            SlidingPaneLayout r3 = this.this$0;
            r3.updateObscuredViewsVisibility(r3.mSlideableView);
            SlidingPaneLayout r4 = this.this$0;
            r4.dispatchOnPanelClosed(r4.mSlideableView);
            SlidingPaneLayout r1 = this.this$0;
            boolean r5 = false;
        L8:
            r1.mPreservedOpenState = r5;
            return;
        L7:
            SlidingPaneLayout r6 = this.this$0;
            r6.dispatchOnPanelOpened(r6.mSlideableView);
            r1 = this.this$0;
            r5 = true;
            goto L8
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r1, int r2, int r3, int r4, int r5) {
            this.this$0.onPanelDragged(r2);
            this.this$0.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r4, float r5, float r6) {
            LayoutParams r7 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            if (this.this$0.isLayoutRtlSupport() == false) goto L12;
            int r0 = this.this$0.getPaddingRight() + r7.rightMargin;
            if (r5 >= 0.0f) goto L7;
        L10:
            r0 = r0 + this.this$0.mSlideRange;
        L11:
            int r8 = this.this$0.mSlideableView.getWidth();
            int r9 = (this.this$0.getWidth() - r0) - r8;
        L18:
            this.this$0.mDragHelper.settleCapturedViewAt(r9, r4.getTop());
            this.this$0.invalidate();
            return;
        L7:
            if (r5 != 0.0f) goto L11;
            if (this.this$0.mSlideOffset <= 0.5f) goto L11;
        L12:
            int r1 = this.this$0.getPaddingLeft();
            r9 = r7.leftMargin + r1;
            if (r5 > 0.0f) goto L17;
            if (r5 != 0.0f) goto L18;
            if (this.this$0.mSlideOffset <= 0.5f) goto L18;
        L17:
            r9 = r9 + this.this$0.mSlideRange;
            goto L18
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r1, int r2) {
            if (this.this$0.mIsUnableToDrag == false) goto L7;
            return false;
        L7:
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).slideable;
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

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.weight = 0.0f;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r5, r6);
            this.weight = 0.0f;
            TypedArray r7 = r5.obtainStyledAttributes(r6, ATTRS);
            this.weight = r7.getFloat(0, 0.0f);
            r7.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.weight = 0.0f;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.weight = 0.0f;
            this.weight = r2.weight;
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(View r1);

        void onPanelOpened(View r1);

        void onPanelSlide(View r1, float r2);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isOpen;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r1.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.isOpen = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.isOpen ? 1 : 0);
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public SimplePanelSlideListener() {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View r1) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View r1) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View r1, float r2) {
        }
    }

    public SlidingPaneLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public SlidingPaneLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public SlidingPaneLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r6, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList();
        float r7 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * r7) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper r8 = ViewDragHelper.create(this, 0.5f, new DragHelperCallback(this));
        this.mDragHelper = r8;
        r8.setMinVelocity(r7 * 400.0f);
    }

    private boolean closePane(View r2, int r3) {
        if (this.mFirstLayout == false) goto L5;
    L8:
        this.mPreservedOpenState = false;
        return true;
    L5:
        if (smoothSlideTo(0.0f, r3) == true) goto L8;
        return false;
    }

    private void dimChildView(View r4, float r5, int r6) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r5 <= 0.0f) goto L13;
        if (r6 == 0) goto L13;
        int r7 = (((int) ((((-16777216) & r6) >>> 24) * r5)) << 24) | (r6 & ViewCompat.MEASURED_SIZE_MASK);
        if (r0.dimPaint != null) goto L8;
        r0.dimPaint = new Paint();
    L8:
        r0.dimPaint.setColorFilter(new PorterDuffColorFilter(r7, PorterDuff.Mode.SRC_OVER));
        if (r4.getLayerType() == 2) goto L11;
        r4.setLayerType(2, r0.dimPaint);
    L11:
        invalidateChildRegion(r4);
        return;
    L13:
        if (r4.getLayerType() != 0) goto L15;
        return;
    L15:
        if (r0.dimPaint == null) goto L17;
        r0.dimPaint.setColorFilter(null);
    L17:
        DisableLayerRunnable r8 = new DisableLayerRunnable(this, r4);
        this.mPostedRunnables.add(r8);
        ViewCompat.postOnAnimation(this, r8);
    }

    private boolean openPane(View r1, int r2) {
        if (this.mFirstLayout == false) goto L5;
    L9:
        this.mPreservedOpenState = true;
        return true;
    L5:
        if (smoothSlideTo(1.0f, r2) == true) goto L9;
        return false;
    }

    private void parallaxOtherViews(float r10) {
        boolean r0 = isLayoutRtlSupport();
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mSlideableView.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        if (r1.dimWhenOffset == false) goto L9;
        if (r0 == false) goto L6;
        int r2 = r1.rightMargin;
    L7:
        if (r2 > 0) goto L9;
        boolean r4 = true;
    L10:
        int r5 = getChildCount();
    L11:
        if (r3 >= r5) goto L26;
        View r6 = getChildAt(r3);
        if (r6 == this.mSlideableView) goto L25;
        float r7 = 1.0f - this.mParallaxOffset;
        int r8 = this.mParallaxBy;
        this.mParallaxOffset = r10;
        int r9 = ((int) (r7 * r8)) - ((int) ((1.0f - r10) * r8));
        if (r0 == false) goto L18;
        r9 = -r9;
    L18:
        r6.offsetLeftAndRight(r9);
        if (r4 == false) goto L25;
        float r11 = this.mParallaxOffset;
        if (r0 == false) goto L23;
        float r12 = r11 - 1.0f;
    L24:
        dimChildView(r6, r12, this.mCoveredFadeColor);
        goto L25
    L23:
        r12 = 1.0f - r11;
    L25:
        r3 = r3 + 1;
        goto L11
    L26:
        return;
    L6:
        r2 = r1.leftMargin;
    L9:
        r4 = false;
        goto L10
    }

    private static boolean viewIsOpaque(View r4) {
        if (r4.isOpaque() == false) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return false;
    L8:
        Drawable r5 = r4.getBackground();
        if (r5 != null) goto L11;
        return false;
    L11:
        if (r5.getOpacity() != (-1)) goto L14;
        return true;
    L14:
        return false;
    }

    public boolean canScroll(View r13, boolean r14, int r15, int r16, int r17) {
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.class) == false) goto L18;
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r13, ViewGroup.class, "com.obric.memorydata.plugin");
        int r3 = r13.getScrollX();
        int r4 = r13.getScrollY();
        int r5 = r1.getChildCount() - 1;
    L5:
        if (r5 < 0) goto L18;
        View r7 = r1.getChildAt(r5);
        int r6 = r16 + r3;
        if (r6 < r7.getLeft()) goto L17;
        if (r6 >= r7.getRight()) goto L17;
        int r8 = r17 + r4;
        if (r8 < r7.getTop()) goto L17;
        if (r8 >= r7.getBottom()) goto L17;
        if (canScroll(r7, true, r15, r6 - r7.getLeft(), r8 - r7.getTop()) == false) goto L17;
        return true;
    L17:
        r5 = r5 - 1;
    L18:
        if (r14 == true) goto L20;
    L26:
        return false;
    L20:
        if (isLayoutRtlSupport() == false) goto L22;
        int r2 = r15;
    L24:
        if (r13.canScrollHorizontally(r2) == false) goto L26;
        return true;
    L22:
        r2 = -r15;
        goto L24
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if (ZeusTransformUtils.instanceOf(r2, LayoutParams.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r2) == false) goto L7;
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

    void dispatchOnPanelClosed(View r2) {
        PanelSlideListener r0 = this.mPanelSlideListener;
        if (r0 == null) goto L5;
        r0.onPanelClosed(r2);
    L5:
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelOpened(View r2) {
        PanelSlideListener r0 = this.mPanelSlideListener;
        if (r0 == null) goto L5;
        r0.onPanelOpened(r2);
    L5:
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelSlide(View r2) {
        PanelSlideListener r0 = this.mPanelSlideListener;
        if (r0 == null) goto L6;
        r0.onPanelSlide(r2, this.mSlideOffset);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r6) {
        super.draw(r6);
        if (isLayoutRtlSupport() == false) goto L5;
        Drawable r0 = this.mShadowDrawableRight;
    L7:
        if (getChildCount() <= 1) goto L9;
        View r1 = getChildAt(1);
    L10:
        if (r1 == null) goto L19;
        if (r0 == null) goto L20;
        int r2 = r1.getTop();
        int r3 = r1.getBottom();
        int r4 = r0.getIntrinsicWidth();
        if (isLayoutRtlSupport() == false) goto L16;
        int r5 = r1.getRight();
        int r7 = r4 + r5;
    L17:
        r0.setBounds(r5, r2, r7, r3);
        r0.draw(r6);
        return;
    L16:
        int r8 = r1.getLeft();
        int r9 = r8 - r4;
        r7 = r8;
        r5 = r9;
        goto L17
    L20:
        return;
    L19:
        return;
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = this.mShadowDrawableLeft;
        goto L7
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r5, View r6, long r7) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r1 = r5.save();
        if (this.mCanSlide == true) goto L5;
    L13:
        boolean r4 = super.drawChild(r5, r6, r7);
        r5.restoreToCount(r1);
        return r4;
    L5:
        if (r0.slideable == true) goto L13;
        if (this.mSlideableView == null) goto L13;
        r5.getClipBounds(this.mTmpRect);
        if (isLayoutRtlSupport() == false) goto L11;
        Rect r2 = this.mTmpRect;
        r2.left = Math.max(r2.left, this.mSlideableView.getRight());
    L12:
        r5.clipRect(this.mTmpRect);
        goto L13
    L11:
        Rect r3 = this.mTmpRect;
        r3.right = Math.min(r3.right, this.mSlideableView.getLeft());
        goto L12
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L6:
        return new LayoutParams(r3);
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    void invalidateChildRegion(View r8) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        ViewCompat.setLayerPaint(r8, ((LayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).dimPaint);
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
    L30:
        ViewCompat.postInvalidateOnAnimation(this, r8.getLeft(), r8.getTop(), r8.getRight(), r8.getBottom());
        return;
    L9:
        if (this.mDisplayListReflectionLoaded == true) goto L20;
        this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[]) ZeusTransformUtils.preCheckCast(null, Class[].class, "com.obric.memorydata.plugin"));     // Catch: NoSuchMethodException -> L12
    L34:
        Field r0 = View.class.getDeclaredField("mRecreateDisplayList");     // Catch: NoSuchFieldException -> L16
        this.mRecreateDisplayList = r0;     // Catch: NoSuchFieldException -> L16
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L16
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
        Field r1 = this.mRecreateDisplayList;
        if (r1 == null) goto L28;
        r1.setBoolean(r8, true);     // Catch: Exception -> L26
        this.mGetDisplayList.invoke(r8, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "Error refreshing display list state", e);
    L28:
        r8.invalidate();
    }

    boolean isDimmed(View r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        LayoutParams r5 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (this.mCanSlide == true) goto L8;
        return false;
    L8:
        if (r5.dimWhenOffset == true) goto L10;
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
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int r0 = this.mPostedRunnables.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((DisableLayerRunnable) ZeusTransformUtils.preCheckCast(this.mPostedRunnables.get(r1), DisableLayerRunnable.class, "com.obric.memorydata.plugin")).run();
        r1 = r1 + 1;
        goto L3
    L5:
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        int r0 = r7.getActionMasked();
        if (this.mCanSlide == true) goto L11;
        if (r0 != 0) goto L11;
        if (getChildCount() <= 1) goto L11;
        View r1 = getChildAt(1);
        if (r1 == null) goto L11;
        this.mPreservedOpenState = !this.mDragHelper.isViewUnder(r1, (int) r7.getX(), (int) r7.getY());
    L11:
        if (this.mCanSlide == true) goto L13;
    L44:
        this.mDragHelper.cancel();
        return super.onInterceptTouchEvent(r7);
    L13:
        if (this.mIsUnableToDrag == false) goto L17;
        if (r0 != 0) goto L44;
    L17:
        if (r0 == 3) goto L42;
        if (r0 == 1) goto L42;
        if (r0 != 0) goto L22;
        this.mIsUnableToDrag = false;
        float r2 = r7.getX();
        float r3 = r7.getY();
        this.mInitialMotionX = r2;
        this.mInitialMotionY = r3;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) r2, (int) r3) == true) goto L33;
    L35:
        boolean r4 = false;
    L37:
        if (this.mDragHelper.shouldInterceptTouchEvent(r7) == true) goto L46;
        if (r4 == false) goto L41;
        return true;
    L41:
        return false;
    L46:
        return true;
    L33:
        if (isDimmed(this.mSlideableView) == false) goto L35;
        r4 = true;
        goto L37
    L22:
        if (r0 != 2) goto L35;
        float r5 = r7.getX();
        float r6 = r7.getY();
        float r8 = Math.abs(r5 - this.mInitialMotionX);
        float r9 = Math.abs(r6 - this.mInitialMotionY);
        if (r8 <= this.mDragHelper.getTouchSlop()) goto L35;
        if (r9 <= r8) goto L35;
        this.mDragHelper.cancel();
        this.mIsUnableToDrag = true;
        return false;
    L42:
        this.mDragHelper.cancel();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        boolean r1 = isLayoutRtlSupport();
        ViewDragHelper r3 = this.mDragHelper;
        if (r1 == false) goto L5;
        r3.setEdgeTrackingEnabled(2);
    L6:
        int r4 = r22 - r20;
        if (r1 == false) goto L9;
        int r5 = getPaddingRight();
    L10:
        if (r1 == false) goto L12;
        int r6 = getPaddingLeft();
    L13:
        int r7 = getPaddingTop();
        int r8 = getChildCount();
        if (this.mFirstLayout == true) goto L16;
    L22:
        int r11 = r5;
        int r12 = 0;
    L24:
        if (r12 >= r8) goto L51;
        View r14 = getChildAt(r12);
        if (r14.getVisibility() == 8) goto L49;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r14.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r13 = r14.getMeasuredWidth();
        if (r2.slideable == false) goto L40;
        int r9 = r4 - r6;
        int r10 = (Math.min(r5, r9 - this.mOverhangSize) - r11) - (r2.leftMargin + r2.rightMargin);
        this.mSlideRange = r10;
        if (r1 == false) goto L33;
        int r15 = r2.rightMargin;
    L35:
        if ((((r11 + r15) + r10) + (r13 / 2)) <= r9) goto L37;
        boolean r16 = true;
    L38:
        r2.dimWhenOffset = r16;
        int r17 = (int) (r10 * this.mSlideOffset);
        r11 = r11 + (r15 + r17);
        this.mSlideOffset = r17 / this.mSlideRange;
        int r18 = 0;
    L45:
        if (r1 == false) goto L47;
        int r24 = (r4 - r11) + r18;
        int r25 = r24 - r13;
    L48:
        r14.layout(r25, r7, r24, r14.getMeasuredHeight() + r7);
        r5 = r5 + r14.getWidth();
        goto L49
    L47:
        r25 = r11 - r18;
        r24 = r25 + r13;
        goto L48
    L37:
        r16 = false;
        goto L38
    L33:
        r15 = r2.leftMargin;
        goto L35
    L40:
        if (this.mCanSlide == false) goto L44;
        int r26 = this.mParallaxBy;
        if (r26 == 0) goto L44;
        r18 = (int) ((1.0f - this.mSlideOffset) * r26);
        r11 = r5;
    L44:
        r11 = r5;
        r18 = 0;
    L49:
        r12 = r12 + 1;
        goto L24
    L51:
        if (this.mFirstLayout == true) goto L53;
    L64:
        this.mFirstLayout = false;
        return;
    L53:
        if (this.mCanSlide == true) goto L55;
        int r27 = 0;
    L61:
        if (r27 >= r8) goto L63;
        dimChildView(getChildAt(r27), 0.0f, this.mSliderFadeColor);
        r27 = r27 + 1;
    L63:
        updateObscuredViewsVisibility(this.mSlideableView);
        goto L64
    L55:
        if (this.mParallaxBy == 0) goto L58;
        parallaxOtherViews(this.mSlideOffset);
    L58:
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(this.mSlideableView.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).dimWhenOffset == false) goto L63;
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        goto L63
    L16:
        if (this.mCanSlide == true) goto L18;
    L20:
        float r28 = 0.0f;
    L21:
        this.mSlideOffset = r28;
        goto L22
    L18:
        if (this.mPreservedOpenState == false) goto L20;
        r28 = 1.0f;
        goto L21
    L12:
        r6 = getPaddingRight();
        goto L13
    L9:
        r5 = getPaddingLeft();
        goto L10
    L5:
        r3.setEdgeTrackingEnabled(1);
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r23, int r24) {
        int r1 = View.MeasureSpec.getMode(r23);
        int r2 = View.MeasureSpec.getSize(r23);
        int r3 = View.MeasureSpec.getMode(r24);
        int r4 = View.MeasureSpec.getSize(r24);
        if (r1 != 1073741824) goto L5;
        if (r3 == 0) goto L14;
    L19:
        if (r3 == Integer.MIN_VALUE) goto L23;
        if (r3 == 1073741824) goto L22;
        int r5 = 0;
        int r6 = 0;
    L24:
        int r8 = (r2 - getPaddingLeft()) - getPaddingRight();
        int r9 = getChildCount();
        if (r9 <= 2) goto L27;
        Log.e(TAG, "onMeasure: More than two child views are not supported.");
    L27:
        this.mSlideableView = null;
        int r14 = r8;
        int r11 = 0;
        boolean r12 = false;
        float r13 = 0.0f;
    L28:
        int r7 = 8;
        if (r11 >= r9) goto L66;
        View r10 = getChildAt(r11);
        LayoutParams r15 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r10.getVisibility() != 8) goto L34;
        r15.dimWhenOffset = false;
    L65:
        r11 = r11 + 1;
        goto L28
    L34:
        if (r15.weight <= 0.0f) goto L38;
        r13 = r13 + r15.weight;
        if (r15.width == 0) goto L65;
    L38:
        int r16 = r15.leftMargin + r15.rightMargin;
        if (r15.width != (-2)) goto L42;
        int r17 = View.MeasureSpec.makeMeasureSpec(r8 - r16, Integer.MIN_VALUE);
    L47:
        if (r15.height != (-2)) goto L51;
        int r18 = Integer.MIN_VALUE;
    L49:
        int r19 = View.MeasureSpec.makeMeasureSpec(r6, r18);
    L54:
        r10.measure(r17, r19);
        int r20 = r10.getMeasuredWidth();
        int r110 = r10.getMeasuredHeight();
        if (r3 != Integer.MIN_VALUE) goto L58;
        if (r110 <= r5) goto L58;
        r5 = Math.min(r110, r6);
    L58:
        r14 = r14 - r20;
        if (r14 >= 0) goto L61;
        boolean r21 = true;
    L62:
        r15.slideable = r21;
        r12 = r12 | r21;
        if (r15.slideable == false) goto L65;
        this.mSlideableView = r10;
        goto L65
    L61:
        r21 = false;
        goto L62
    L51:
        if (r15.height != (-1)) goto L53;
        r18 = 1073741824;
        goto L49
    L53:
        r19 = View.MeasureSpec.makeMeasureSpec(r15.height, 1073741824);
        goto L54
    L42:
        if (r15.width != (-1)) goto L44;
        int r22 = r8 - r16;
        int r111 = 1073741824;
    L45:
        r17 = View.MeasureSpec.makeMeasureSpec(r22, r111);
        goto L47
    L44:
        r111 = 1073741824;
        r22 = r15.width;
        goto L45
    L66:
        if (r12 == false) goto L68;
    L69:
        int r25 = r8 - this.mOverhangSize;
        int r26 = 0;
    L70:
        if (r26 >= r9) goto L127;
        View r27 = getChildAt(r26);
        if (r27.getVisibility() != r7) goto L75;
    L73:
        int r28 = r25;
        int r29 = r9;
    L126:
        r26 = r26 + 1;
        r9 = r29;
        r25 = r28;
        r7 = 8;
        goto L70
    L75:
        LayoutParams r112 = (LayoutParams) ZeusTransformUtils.preCheckCast(r27.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r27.getVisibility() == r7) goto L73;
        if (r112.width == 0) goto L81;
    L83:
        boolean r113 = false;
    L84:
        if (r113 == false) goto L86;
        int r30 = 0;
    L87:
        r29 = r9;
        if (r12 == false) goto L108;
        if (r27 == this.mSlideableView) goto L108;
        if (r112.width >= 0) goto L125;
        if (r30 <= r25) goto L95;
    L96:
        if (r113 == true) goto L98;
        int r31 = 1073741824;
        int r32 = r27.getMeasuredHeight();
    L105:
        int r33 = View.MeasureSpec.makeMeasureSpec(r32, r31);
    L106:
        r27.measure(View.MeasureSpec.makeMeasureSpec(r25, r31), r33);
        goto L125
    L98:
        if (r112.height != (-2)) goto L101;
        r33 = View.MeasureSpec.makeMeasureSpec(r6, Integer.MIN_VALUE);
        r31 = 1073741824;
        goto L106
    L101:
        if (r112.height != (-1)) goto L103;
        r31 = 1073741824;
        r33 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
        goto L106
    L103:
        r31 = 1073741824;
        r32 = r112.height;
        goto L105
    L95:
        if (r112.weight > 0.0f) goto L96;
    L125:
        r28 = r25;
    L108:
        if (r112.weight <= 0.0f) goto L125;
        if (r112.width == 0) goto L112;
        int r34 = 1073741824;
        int r114 = r27.getMeasuredHeight();
    L119:
        int r115 = View.MeasureSpec.makeMeasureSpec(r114, r34);
    L120:
        if (r12 == false) goto L124;
        int r35 = r8 - (r112.leftMargin + r112.rightMargin);
        r28 = r25;
        int r36 = View.MeasureSpec.makeMeasureSpec(r35, 1073741824);
        if (r30 == r35) goto L126;
        r27.measure(r36, r115);
        goto L126
    L124:
        r28 = r25;
        r27.measure(View.MeasureSpec.makeMeasureSpec(r30 + ((int) ((r112.weight * Math.max(0, r14)) / r13)), 1073741824), r115);
        goto L126
    L112:
        if (r112.height != (-2)) goto L115;
        r115 = View.MeasureSpec.makeMeasureSpec(r6, Integer.MIN_VALUE);
        goto L120
    L115:
        if (r112.height != (-1)) goto L117;
        r115 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
        goto L120
    L117:
        r34 = 1073741824;
        r114 = r112.height;
        goto L119
    L86:
        r30 = r27.getMeasuredWidth();
        goto L87
    L81:
        if (r112.weight <= 0.0f) goto L83;
        r113 = true;
    L127:
        setMeasuredDimension(r2, (r5 + getPaddingTop()) + getPaddingBottom());
        this.mCanSlide = r12;
        if (this.mDragHelper.getViewDragState() == 0) goto L140;
        if (r12 == true) goto L141;
        this.mDragHelper.abort();
        return;
    L141:
        return;
    L140:
        return;
    L68:
        if (r13 <= 0.0f) goto L127;
    L22:
        r5 = (r4 - getPaddingTop()) - getPaddingBottom();
        r6 = r5;
        goto L24
    L23:
        r6 = (r4 - getPaddingTop()) - getPaddingBottom();
        r5 = 0;
        goto L24
    L14:
        if (isInEditMode() == false) goto L18;
        if (r3 != 0) goto L19;
        r4 = 300;
        r3 = Integer.MIN_VALUE;
        goto L19
    L18:
        throw new IllegalStateException("Height must not be UNSPECIFIED");
    L5:
        if (isInEditMode() == false) goto L11;
        if (r1 == Integer.MIN_VALUE) goto L19;
        if (r1 != 0) goto L19;
        r2 = 300;
        goto L19
    L11:
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    }

    void onPanelDragged(int r5) {
        if (this.mSlideableView != null) goto L6;
        this.mSlideOffset = 0.0f;
        return;
    L6:
        boolean r0 = isLayoutRtlSupport();
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mSlideableView.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r2 = this.mSlideableView.getWidth();
        if (r0 == false) goto L9;
        r5 = (getWidth() - r5) - r2;
    L9:
        if (r0 == false) goto L11;
        int r3 = getPaddingRight();
    L12:
        if (r0 == false) goto L14;
        int r4 = r1.rightMargin;
    L15:
        float r6 = (r5 - (r3 + r4)) / this.mSlideRange;
        this.mSlideOffset = r6;
        if (this.mParallaxBy == 0) goto L19;
        parallaxOtherViews(r6);
    L19:
        if (r1.dimWhenOffset == false) goto L21;
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
    L21:
        dispatchOnPanelSlide(this.mSlideableView);
        return;
    L14:
        r4 = r1.leftMargin;
        goto L15
    L11:
        r3 = getPaddingLeft();
        goto L12
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        if (r5.isOpen == false) goto L9;
        openPane();
    L10:
        this.mPreservedOpenState = r5.isOpen;
        return;
    L9:
        closePane();
        goto L10
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        if (isSlideable() == false) goto L5;
        boolean r2 = isOpen();
    L6:
        r1.isOpen = r2;
        return r1;
    L5:
        r2 = this.mPreservedOpenState;
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        this.mFirstLayout = true;
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        if (this.mCanSlide == false) goto L5;
        this.mDragHelper.processTouchEvent(r6);
        int r0 = r6.getActionMasked();
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L11;
    L18:
        return true;
    L11:
        if (isDimmed(this.mSlideableView) == false) goto L18;
        float r1 = r6.getX();
        float r7 = r6.getY();
        float r2 = r1 - this.mInitialMotionX;
        float r3 = r7 - this.mInitialMotionY;
        int r4 = this.mDragHelper.getTouchSlop();
        if (((r2 * r2) + (r3 * r3)) >= (r4 * r4)) goto L18;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) r1, (int) r7) == false) goto L18;
        closePane(this.mSlideableView, 0);
        goto L18
    L17:
        float r5 = r6.getX();
        float r8 = r6.getY();
        this.mInitialMotionX = r5;
        this.mInitialMotionY = r8;
        goto L18
    L5:
        return super.onTouchEvent(r6);
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r1, View r2) {
        super.requestChildFocus(r1, r2);
        if (isInTouchMode() == false) goto L5;
        return;
    L5:
        if (this.mCanSlide == false) goto L7;
        return;
    L7:
        if (r1 != this.mSlideableView) goto L9;
        boolean r3 = true;
    L10:
        this.mPreservedOpenState = r3;
        return;
    L9:
        r3 = false;
        goto L10
    }

    void setAllChildrenVisible() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 4) goto L7;
        r3.setVisibility(0);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    public void setCoveredFadeColor(int r1) {
        this.mCoveredFadeColor = r1;
    }

    public void setPanelSlideListener(PanelSlideListener r3) {
        this.mPanelSlideListener = (PanelSlideListener) ZeusTransformUtils.wrapperContextForParams(r3, PanelSlideListener.class, "com.obric.memorydata.plugin");
    }

    public void setParallaxDistance(int r1) {
        this.mParallaxBy = r1;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable r1) {
        setShadowDrawableLeft(r1);
    }

    public void setShadowDrawableLeft(Drawable r1) {
        this.mShadowDrawableLeft = r1;
    }

    public void setShadowDrawableRight(Drawable r1) {
        this.mShadowDrawableRight = r1;
    }

    @Deprecated
    public void setShadowResource(int r2) {
        setShadowDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(r2));
    }

    public void setShadowResourceLeft(int r4) {
        setShadowDrawableLeft(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setShadowResourceRight(int r4) {
        setShadowDrawableRight(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setSliderFadeColor(int r1) {
        this.mSliderFadeColor = r1;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    boolean smoothSlideTo(float r5, int r6) {
        if (this.mCanSlide == true) goto L5;
        return false;
    L5:
        boolean r7 = isLayoutRtlSupport();
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mSlideableView.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        int r8 = getPaddingRight() + r1.rightMargin;
        int r9 = (int) (getWidth() - ((r8 + (r5 * this.mSlideRange)) + this.mSlideableView.getWidth()));
    L9:
        ViewDragHelper r10 = this.mDragHelper;
        View r2 = this.mSlideableView;
        if (r10.smoothSlideViewTo(r2, r9, r2.getTop()) == false) goto L13;
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    L13:
        return false;
    L8:
        r9 = (int) ((getPaddingLeft() + r1.leftMargin) + (r5 * this.mSlideRange));
        goto L9
    }

    void updateObscuredViewsVisibility(View r18) {
        View r0 = r18;
        boolean r1 = isLayoutRtlSupport();
        if (r1 == false) goto L5;
        int r2 = getWidth() - getPaddingRight();
    L6:
        if (r1 == false) goto L8;
        int r3 = getPaddingLeft();
    L9:
        int r4 = getPaddingTop();
        int r5 = getHeight() - getPaddingBottom();
        if (r0 != null) goto L12;
    L14:
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L15:
        int r11 = getChildCount();
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L39;
        View r14 = getChildAt(r12);
        if (r14 == r0) goto L44;
        if (r14.getVisibility() == 8) goto L38;
        if (r1 == false) goto L25;
        int r6 = r3;
    L26:
        int r13 = Math.max(r6, r14.getLeft());
        int r15 = Math.max(r4, r14.getTop());
        if (r1 == false) goto L29;
        int r16 = r2;
    L30:
        int r17 = Math.min(r16, r14.getRight());
        int r19 = Math.min(r5, r14.getBottom());
        if (r13 < r7) goto L36;
        if (r15 < r9) goto L36;
        if (r17 > r8) goto L36;
        if (r19 > r10) goto L36;
        int r20 = 4;
    L37:
        r14.setVisibility(r20);
    L36:
        r20 = 0;
        goto L37
    L29:
        r16 = r3;
        goto L30
    L25:
        r6 = r2;
    L38:
        r12 = r12 + 1;
        r0 = r18;
        r1 = r1;
        goto L16
    L44:
        return;
    L39:
        return;
    L12:
        if (viewIsOpaque(r18) == false) goto L14;
        r7 = r18.getLeft();
        r8 = r18.getRight();
        r9 = r18.getTop();
        r10 = r18.getBottom();
        goto L15
    L8:
        r3 = getWidth() - getPaddingRight();
        goto L9
    L5:
        r2 = getPaddingLeft();
        goto L6
    }
}

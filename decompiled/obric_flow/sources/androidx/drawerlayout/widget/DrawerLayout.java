package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    static final int[] LAYOUT_ATTRS = null;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS = null;
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private final AccessibilityViewCommand mActionDismiss;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;

    @Nullable
    private DrawerListener mListener;
    private List<DrawerListener> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ DrawerLayout this$0;

        public AccessibilityDelegate(DrawerLayout r5) {
            this.this$0 = r5;
            this.mTmpRect = new Rect();
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat r5, ViewGroup r10) {
            int r11 = r10.getChildCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L8;
            View r13 = r10.getChildAt(r12);
            if (DrawerLayout.includeChildForAccessibility(r13) == false) goto L7;
            r5.addChild(r13);
        L7:
            r12 = r12 + 1;
            goto L3
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r5, AccessibilityNodeInfoCompat r10) {
            Rect r11 = this.mTmpRect;
            r10.getBoundsInScreen(r11);
            r5.setBoundsInScreen(r11);
            r5.setVisibleToUser(r10.isVisibleToUser());
            r5.setPackageName(r10.getPackageName());
            r5.setClassName(r10.getClassName());
            r5.setContentDescription(r10.getContentDescription());
            r5.setEnabled(r10.isEnabled());
            r5.setFocused(r10.isFocused());
            r5.setAccessibilityFocused(r10.isAccessibilityFocused());
            r5.setSelected(r10.isSelected());
            r5.addAction(r10.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View r5, AccessibilityEvent r10) {
            if (r10.getEventType() != 32) goto L12;
            List<CharSequence> r11 = r10.getText();
            View r12 = this.this$0.findVisibleDrawer();
            if (r12 == null) goto L13;
            int r13 = this.this$0.getDrawerViewAbsoluteGravity(r12);
            CharSequence r14 = this.this$0.getDrawerTitle(r13);
            if (r14 == null) goto L14;
            r11.add(r14);
            return DrawerLayout.CHILDREN_DISALLOW_INTERCEPT;
        L14:
            return DrawerLayout.CHILDREN_DISALLOW_INTERCEPT;
        L13:
            return DrawerLayout.CHILDREN_DISALLOW_INTERCEPT;
        L12:
            return super.dispatchPopulateAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r5, r10);
            r10.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == false) goto L5;
            super.onInitializeAccessibilityNodeInfo(r5, r10);
        L9:
            r10.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
            r10.setFocusable(false);
            r10.setFocused(false);
            r10.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            r10.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
            return;
        L5:
            AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.obtain(r10);
            super.onInitializeAccessibilityNodeInfo(r5, r11);
            r10.setSource(r5);
            Object r12 = ViewCompat.getParentForAccessibility(r5);
            if ((r12 instanceof View) == false) goto L8;
            r10.setParent((View) r12);
        L8:
            copyNodeInfoNoChildren(r10, r11);
            r11.recycle();
            addChildrenForAccessibility(r10, (ViewGroup) r5);
            goto L9
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r5, View r10, AccessibilityEvent r11) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == true) goto L10;
            if (DrawerLayout.includeChildForAccessibility(r10) == true) goto L10;
            return false;
        L10:
            return super.onRequestSendAccessibilityEvent(r5, r10, r11);
        }
    }

    public static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        public ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
            super.onInitializeAccessibilityNodeInfo(r5, r10);
            if (DrawerLayout.includeChildForAccessibility(r5) == true) goto L6;
            r10.setParent(null);
            return;
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(@NonNull View r5);

        void onDrawerOpened(@NonNull View r5);

        void onDrawerSlide(@NonNull View r5, float r10);

        void onDrawerStateChanged(int r5);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;
        public int gravity;
        boolean isPeeking;
        float onScreen;
        int openState;

        public LayoutParams(@NonNull Context r5, @Nullable AttributeSet r10) {
            super(r5, r10);
            this.gravity = 0;
            TypedArray r11 = r5.obtainStyledAttributes(r10, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = r11.getInt(0, 0);
            r11.recycle();
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.gravity = 0;
        }

        public LayoutParams(int r5, int r10, int r11) {
            this(r5, r10);
            this.gravity = r11;
        }

        public LayoutParams(@NonNull LayoutParams r5) {
            super(r5);
            this.gravity = 0;
            this.gravity = r5.gravity;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r5) {
            super(r5);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.gravity = 0;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r5, @Nullable ClassLoader r10) {
            super(r5, r10);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = r5.readInt();
            this.lockModeLeft = r5.readInt();
            this.lockModeRight = r5.readInt();
            this.lockModeStart = r5.readInt();
            this.lockModeEnd = r5.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.openDrawerGravity);
            r5.writeInt(this.lockModeLeft);
            r5.writeInt(this.lockModeRight);
            r5.writeInt(this.lockModeStart);
            r5.writeInt(this.lockModeEnd);
        }

        public SavedState(@NonNull Parcelable r5) {
            super(r5);
            this.openDrawerGravity = 0;
        }
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public SimpleDrawerListener() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View r5) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View r5) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View r5, float r10) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int r5) {
        }
    }

    public class ViewDragCallback extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;
        final /* synthetic */ DrawerLayout this$0;

        public ViewDragCallback(DrawerLayout r5, int r10) {
            this.this$0 = r5;
            this.mPeekRunnable = new AnonymousClass1(this);
            this.mAbsGravity = r10;
        }

        private void closeOtherDrawer() {
            int r5 = 3;
            if (this.mAbsGravity != 3) goto L5;
            r5 = 5;
        L5:
            View r10 = this.this$0.findDrawerWithGravity(r5);
            if (r10 == null) goto L9;
            this.this$0.closeDrawer(r10);
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r5, int r10, int r11) {
            if (this.this$0.checkDrawerViewAbsoluteGravity(r5, 3) == true) goto L5;
            int r12 = this.this$0.getWidth();
            return Math.max(r12 - r5.getWidth(), Math.min(r10, r12));
        L5:
            return Math.max(-r5.getWidth(), Math.min(r10, 0));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r5, int r10, int r11) {
            return r5.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r5) {
            if (this.this$0.isDrawerView(r5) == true) goto L7;
            return 0;
        L7:
            return r5.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r5, int r10) {
            if ((r5 & 1) != 1) goto L5;
            View r11 = this.this$0.findDrawerWithGravity(3);
        L6:
            if (r11 != null) goto L8;
            return;
        L8:
            if (this.this$0.getDrawerLockMode(r11) != 0) goto L12;
            this.mDragger.captureChildView(r11, r10);
            return;
        L12:
            return;
        L5:
            r11 = this.this$0.findDrawerWithGravity(5);
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int r5) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int r5, int r10) {
            this.this$0.postDelayed(this.mPeekRunnable, 160);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r5, int r10) {
            ((LayoutParams) r5.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r5) {
            this.this$0.updateDrawerState(r5, this.mDragger.getCapturedView());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r5, int r10, int r11, int r12, int r13) {
            int r14 = r5.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r5, 3) == false) goto L6;
            float r15 = r10 + r14;
        L5:
            float r16 = r15 / r14;
            this.this$0.setDrawerViewOffset(r5, r16);
            if (r16 != 0.0f) goto L10;
            int r17 = 4;
        L11:
            r5.setVisibility(r17);
            this.this$0.invalidate();
            return;
        L10:
            r17 = 0;
            goto L11
        L6:
            r15 = this.this$0.getWidth() - r10;
            goto L5
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r10, float r11, float r12) {
            float r13 = this.this$0.getDrawerViewOffset(r10);
            int r5 = r10.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r10, 3) == true) goto L5;
            int r14 = this.this$0.getWidth();
            if (r11 >= 0.0f) goto L15;
        L20:
            r14 = r14 - r5;
        L19:
            int r15 = r14;
        L21:
            this.mDragger.settleCapturedViewAt(r15, r10.getTop());
            this.this$0.invalidate();
            return;
        L15:
            if (r11 != 0.0f) goto L19;
            if (r13 <= 0.5f) goto L19;
        L5:
            if (r11 > 0.0f) goto L11;
            if (r11 == 0.0f) goto L8;
        L10:
            r15 = -r5;
            goto L21
        L8:
            if (r13 <= 0.5f) goto L10;
        L11:
            r15 = 0;
            goto L21
        }

        public void peekDrawer() {
            int r5 = this.mDragger.getEdgeSize();
            int r10 = 0;
            if (this.mAbsGravity != 3) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L11;
            View r12 = this.this$0.findDrawerWithGravity(3);
            if (r12 == null) goto L10;
            r10 = -r12.getWidth();
        L10:
            int r13 = r10 + r5;
        L12:
            if (r12 == null) goto L23;
            if (r11 == true) goto L15;
        L16:
            if (r11 == false) goto L18;
            return;
        L18:
            if (r12.getLeft() > r13) goto L20;
            return;
        L20:
            if (this.this$0.getDrawerLockMode(r12) != 0) goto L26;
            LayoutParams r14 = (LayoutParams) r12.getLayoutParams();
            this.mDragger.smoothSlideViewTo(r12, r13, r12.getTop());
            r14.isPeeking = DrawerLayout.CHILDREN_DISALLOW_INTERCEPT;
            this.this$0.invalidate();
            closeOtherDrawer();
            this.this$0.cancelChildViewTouch();
            return;
        L26:
            return;
        L15:
            if (r12.getLeft() < r13) goto L20;
        L23:
            return;
        L11:
            r12 = this.this$0.findDrawerWithGravity(5);
            r13 = this.this$0.getWidth() - r5;
            goto L12
        L5:
            r11 = false;
            goto L6
        }

        public void removeCallbacks() {
            this.this$0.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper r5) {
            this.mDragger = r5;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r5, int r10) {
            if (this.this$0.isDrawerView(r5) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.this$0.checkDrawerViewAbsoluteGravity(r5, this.mAbsGravity) == false) goto L9;
            if (this.this$0.getDrawerLockMode(r5) != 0) goto L9;
            return DrawerLayout.CHILDREN_DISALLOW_INTERCEPT;
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.colorPrimaryDark};
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        CAN_HIDE_DESCENDANTS = CHILDREN_DISALLOW_INTERCEPT;
        SET_DRAWER_SHADOW_FROM_ELEVATION = CHILDREN_DISALLOW_INTERCEPT;
        sEdgeSizeUsingSystemGestureInsets = CHILDREN_DISALLOW_INTERCEPT;
    }

    public DrawerLayout(@NonNull Context r5) {
        this(r5, null);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent r5, View r10) {
        if (r10.getMatrix().isIdentity() == true) goto L5;
        MotionEvent r11 = getTransformedMotionEvent(r5, r10);
        boolean r12 = r10.dispatchGenericMotionEvent(r11);
        r11.recycle();
        return r12;
    L5:
        float r13 = getScrollX() - r10.getLeft();
        float r14 = getScrollY() - r10.getTop();
        r5.offsetLocation(r13, r14);
        boolean r15 = r10.dispatchGenericMotionEvent(r5);
        r5.offsetLocation(-r13, -r14);
        return r15;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent r5, View r10) {
        float r11 = getScrollX() - r10.getLeft();
        float r12 = getScrollY() - r10.getTop();
        MotionEvent r13 = MotionEvent.obtain(r5);
        r13.offsetLocation(r11, r12);
        Matrix r14 = r10.getMatrix();
        if (r14.isIdentity() == false) goto L5;
    L8:
        return r13;
    L5:
        if (this.mChildInvertedMatrix != null) goto L7;
        this.mChildInvertedMatrix = new Matrix();
    L7:
        r14.invert(this.mChildInvertedMatrix);
        r13.transform(this.mChildInvertedMatrix);
        goto L8
    }

    public static String gravityToString(int r5) {
        if ((r5 & 3) != 3) goto L7;
        return "LEFT";
    L7:
        if ((r5 & 5) != 5) goto L11;
        return "RIGHT";
    L11:
        return Integer.toHexString(r5);
    }

    private static boolean hasOpaqueBackground(View r5) {
        Drawable r10 = r5.getBackground();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.getOpacity() != (-1)) goto L9;
        return CHILDREN_DISALLOW_INTERCEPT;
    L9:
        return false;
    }

    private boolean hasPeekingDrawer() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L9;
        if (((LayoutParams) getChildAt(r10).getLayoutParams()).isPeeking == true) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return CHILDREN_DISALLOW_INTERCEPT;
    L9:
        return false;
    }

    private boolean hasVisibleDrawer() {
        if (findVisibleDrawer() == null) goto L5;
        return CHILDREN_DISALLOW_INTERCEPT;
    L5:
        return false;
    }

    public static boolean includeChildForAccessibility(View r5) {
        if (ViewCompat.getImportantForAccessibility(r5) != 4) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.getImportantForAccessibility(r5) == 2) goto L7;
        return CHILDREN_DISALLOW_INTERCEPT;
    }

    private boolean isInBoundsOfChild(float r5, float r10, View r11) {
        if (this.mChildHitRect != null) goto L5;
        this.mChildHitRect = new Rect();
    L5:
        r11.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) r5, (int) r10);
    }

    private void mirror(Drawable r5, int r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (DrawableCompat.isAutoMirrored(r5) == false) goto L8;
        DrawableCompat.setLayoutDirection(r5, r10);
        return;
    }

    private Drawable resolveLeftShadow() {
        int r5 = ViewCompat.getLayoutDirection(this);
        if (r5 != 0) goto L8;
        Drawable r10 = this.mShadowStart;
        if (r10 == null) goto L13;
        mirror(r10, r5);
        return this.mShadowStart;
    L13:
        return this.mShadowLeft;
    L8:
        Drawable r11 = this.mShadowEnd;
        if (r11 == null) goto L13;
        mirror(r11, r5);
        return this.mShadowEnd;
    }

    private Drawable resolveRightShadow() {
        int r5 = ViewCompat.getLayoutDirection(this);
        if (r5 != 0) goto L8;
        Drawable r10 = this.mShadowEnd;
        if (r10 == null) goto L13;
        mirror(r10, r5);
        return this.mShadowEnd;
    L13:
        return this.mShadowRight;
    L8:
        Drawable r11 = this.mShadowStart;
        if (r11 == null) goto L13;
        mirror(r11, r5);
        return this.mShadowStart;
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L5;
        return;
    L5:
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    private void updateChildAccessibilityAction(View r5) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r10 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(r5, r10.getId());
        if (isDrawerOpen(r5) == true) goto L5;
        return;
    L5:
        if (getDrawerLockMode(r5) == 2) goto L9;
        ViewCompat.replaceAccessibilityAction(r5, r10, null, this.mActionDismiss);
        return;
    }

    private void updateChildrenImportantForAccessibility(View r5, boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L13;
        View r13 = getChildAt(r12);
        if (r10 == false) goto L7;
    L8:
        if (r10 == false) goto L11;
        if (r13 != r5) goto L11;
    L10:
        ViewCompat.setImportantForAccessibility(r13, 1);
    L12:
        r12 = r12 + 1;
    L11:
        ViewCompat.setImportantForAccessibility(r13, 4);
        goto L12
    L7:
        if (isDrawerView(r13) == false) goto L10;
    }

    public void addDrawerListener(@NonNull DrawerListener r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mListeners != null) goto L7;
        this.mListeners = new ArrayList();
    L7:
        this.mListeners.add(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r10, int r11, int r12) {
        if (getDescendantFocusability() != 393216) goto L5;
        return;
    L5:
        int r5 = getChildCount();
        int r13 = 0;
        int r14 = 0;
        boolean r15 = false;
    L6:
        if (r14 >= r5) goto L14;
        View r16 = getChildAt(r14);
        if (isDrawerView(r16) == true) goto L10;
        this.mNonDrawerViews.add(r16);
    L13:
        r14 = r14 + 1;
        goto L6
    L10:
        if (isDrawerOpen(r16) == false) goto L13;
        r16.addFocusables(r10, r11, r12);
        r15 = CHILDREN_DISALLOW_INTERCEPT;
        goto L13
    L14:
        if (r15 == true) goto L21;
        int r17 = this.mNonDrawerViews.size();
    L16:
        if (r13 >= r17) goto L21;
        View r18 = this.mNonDrawerViews.get(r13);
        if (r18.getVisibility() != 0) goto L20;
        r18.addFocusables(r10, r11, r12);
    L20:
        r13 = r13 + 1;
    L21:
        this.mNonDrawerViews.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        super.addView(r5, r10, r11);
        if (findOpenDrawer() == null) goto L5;
    L8:
        ViewCompat.setImportantForAccessibility(r5, 4);
    L10:
        if (CAN_HIDE_DESCENDANTS == true) goto L13;
        ViewCompat.setAccessibilityDelegate(r5, this.mChildAccessibilityDelegate);
        return;
    L13:
        return;
    L5:
        if (isDrawerView(r5) == true) goto L8;
        ViewCompat.setImportantForAccessibility(r5, 1);
        goto L10
    }

    public void cancelChildViewTouch() {
        if (this.mChildrenCanceledTouch == true) goto L10;
        long r5 = SystemClock.uptimeMillis();
        MotionEvent r10 = MotionEvent.obtain(r5, r5, 3, 0.0f, 0.0f, 0);
        int r11 = getChildCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        getChildAt(r12).dispatchTouchEvent(r10);
        r12 = r12 + 1;
        goto L5
    L7:
        r10.recycle();
        this.mChildrenCanceledTouch = CHILDREN_DISALLOW_INTERCEPT;
        return;
    }

    public boolean checkDrawerViewAbsoluteGravity(View r5, int r10) {
        if ((getDrawerViewAbsoluteGravity(r5) & r10) != r10) goto L5;
        return CHILDREN_DISALLOW_INTERCEPT;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r5) == false) goto L7;
        return CHILDREN_DISALLOW_INTERCEPT;
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        closeDrawer(GravityCompat.START);
    }

    public void closeDrawer(@NonNull View r5) {
        closeDrawer(r5, CHILDREN_DISALLOW_INTERCEPT);
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int r5 = getChildCount();
        float r10 = 0.0f;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r10 = Math.max(r10, ((LayoutParams) getChildAt(r11).getLayoutParams()).onScreen);
        r11 = r11 + 1;
        goto L3
    L5:
        this.mScrimOpacity = r10;
        boolean r12 = this.mLeftDragger.continueSettling(CHILDREN_DISALLOW_INTERCEPT);
        boolean r13 = this.mRightDragger.continueSettling(CHILDREN_DISALLOW_INTERCEPT);
        if (r12 == true) goto L8;
        if (r13 == true) goto L8;
        return;
    L8:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        if ((r10.getSource() & 2) == 0) goto L25;
        if (r10.getAction() == 10) goto L25;
        if (this.mScrimOpacity <= 0.0f) goto L25;
        int r5 = getChildCount();
        if (r5 == 0) goto L22;
        float r11 = r10.getX();
        float r12 = r10.getY();
        int r13 = r5 - 1;
    L12:
        if (r13 < 0) goto L31;
        View r14 = getChildAt(r13);
        if (isInBoundsOfChild(r11, r12, r14) == false) goto L21;
        if (isContentView(r14) == true) goto L21;
        if (dispatchTransformedGenericPointerEvent(r10, r14) == false) goto L21;
        return CHILDREN_DISALLOW_INTERCEPT;
    L21:
        r13 = r13 - 1;
        goto L12
    L31:
        return false;
    L22:
        return false;
    L25:
        return super.dispatchGenericMotionEvent(r10);
    }

    public void dispatchOnDrawerClosed(View r5) {
        LayoutParams r10 = (LayoutParams) r5.getLayoutParams();
        if ((r10.openState & 1) != 1) goto L16;
        r10.openState = 0;
        List<DrawerListener> r11 = this.mListeners;
        if (r11 == null) goto L9;
        int r12 = r11.size() - 1;
    L7:
        if (r12 < 0) goto L9;
        this.mListeners.get(r12).onDrawerClosed(r5);
        r12 = r12 - 1;
    L9:
        updateChildrenImportantForAccessibility(r5, false);
        updateChildAccessibilityAction(r5);
        if (hasWindowFocus() == false) goto L17;
        View r13 = getRootView();
        if (r13 == null) goto L18;
        r13.sendAccessibilityEvent(32);
        return;
    L18:
        return;
    L17:
        return;
    }

    public void dispatchOnDrawerOpened(View r5) {
        LayoutParams r10 = (LayoutParams) r5.getLayoutParams();
        if ((r10.openState & 1) != 0) goto L14;
        r10.openState = 1;
        List<DrawerListener> r11 = this.mListeners;
        if (r11 == null) goto L9;
        int r12 = r11.size() - 1;
    L7:
        if (r12 < 0) goto L9;
        this.mListeners.get(r12).onDrawerOpened(r5);
        r12 = r12 - 1;
    L9:
        updateChildrenImportantForAccessibility(r5, CHILDREN_DISALLOW_INTERCEPT);
        updateChildAccessibilityAction(r5);
        if (hasWindowFocus() == false) goto L15;
        sendAccessibilityEvent(32);
        return;
    L15:
        return;
    }

    public void dispatchOnDrawerSlide(View r5, float r10) {
        List<DrawerListener> r11 = this.mListeners;
        if (r11 == null) goto L7;
        int r12 = r11.size() - 1;
    L5:
        if (r12 < 0) goto L9;
        this.mListeners.get(r12).onDrawerSlide(r5, r10);
        r12 = r12 - 1;
        goto L5
    L9:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r15, View r16, long r17) {
        int r5 = getHeight();
        boolean r10 = isContentView(r16);
        int r11 = getWidth();
        int r12 = r15.save();
        int r13 = 0;
        if (r10 == false) goto L27;
        int r14 = getChildCount();
        int r18 = 0;
        int r19 = 0;
    L5:
        if (r18 >= r14) goto L26;
        View r110 = getChildAt(r18);
        if (r110 == r16) goto L25;
        if (r110.getVisibility() != 0) goto L25;
        if (hasOpaqueBackground(r110) == false) goto L25;
        if (isDrawerView(r110) == false) goto L25;
        if (r110.getHeight() < r5) goto L25;
        if (checkDrawerViewAbsoluteGravity(r110, 3) == false) goto L22;
        int r111 = r110.getRight();
        if (r111 <= r19) goto L25;
        r19 = r111;
        goto L25
    L22:
        int r112 = r110.getLeft();
        if (r112 >= r11) goto L25;
        r11 = r112;
    L25:
        r18 = r18 + 1;
        goto L5
    L26:
        r15.clipRect(r19, 0, r11, getHeight());
        r13 = r19;
    L27:
        boolean r20 = super.drawChild(r15, r16, r17);
        r15.restoreToCount(r12);
        float r21 = this.mScrimOpacity;
        if (r21 <= 0.0f) goto L32;
        if (r10 == false) goto L32;
        int r22 = this.mScrimColor;
        this.mScrimPaint.setColor((r22 & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((((-16777216) & r22) >>> 24) * r21)) << 24));
        r15.drawRect(r13, 0.0f, r11, getHeight(), this.mScrimPaint);
    L41:
        return r20;
    L32:
        if (this.mShadowLeftResolved == null) goto L37;
        if (checkDrawerViewAbsoluteGravity(r16, 3) == false) goto L37;
        int r23 = this.mShadowLeftResolved.getIntrinsicWidth();
        int r24 = r16.getRight();
        float r25 = Math.max(0.0f, Math.min(r24 / this.mLeftDragger.getEdgeSize(), 1.0f));
        this.mShadowLeftResolved.setBounds(r24, r16.getTop(), r23 + r24, r16.getBottom());
        this.mShadowLeftResolved.setAlpha((int) (r25 * 255.0f));
        this.mShadowLeftResolved.draw(r15);
    L37:
        if (this.mShadowRightResolved == null) goto L41;
        if (checkDrawerViewAbsoluteGravity(r16, 5) == false) goto L41;
        int r26 = this.mShadowRightResolved.getIntrinsicWidth();
        int r27 = r16.getLeft();
        float r28 = Math.max(0.0f, Math.min((getWidth() - r27) / this.mRightDragger.getEdgeSize(), 1.0f));
        this.mShadowRightResolved.setBounds(r27 - r26, r16.getTop(), r27, r16.getBottom());
        this.mShadowRightResolved.setAlpha((int) (r28 * 255.0f));
        this.mShadowRightResolved.draw(r15);
        goto L41
    }

    public View findDrawerWithGravity(int r5) {
        int r10 = GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this)) & 7;
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = getChildAt(r12);
        if ((getDrawerViewAbsoluteGravity(r13) & 7) == r10) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    public View findOpenDrawer() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        View r11 = getChildAt(r10);
        if ((((LayoutParams) r11.getLayoutParams()).openState & 1) == 1) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return null;
    }

    public View findVisibleDrawer() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L10;
        View r11 = getChildAt(r10);
        if (isDrawerView(r11) == false) goto L9;
        if (isDrawerVisible(r11) == false) goto L9;
        return r11;
    L9:
        r10 = r10 + 1;
        goto L3
    L10:
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((LayoutParams) r5);
    L6:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
    L9:
        return new LayoutParams(r5);
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == true) goto L5;
        return 0.0f;
    L5:
        return this.mDrawerElevation;
    }

    public int getDrawerLockMode(int r5) {
        int r10 = ViewCompat.getLayoutDirection(this);
        if (r5 != 3) goto L5;
        int r11 = this.mLockModeLeft;
        if (r11 == 3) goto L38;
        return r11;
    L38:
        if (r10 != 0) goto L40;
        int r12 = this.mLockModeStart;
    L41:
        if (r12 == 3) goto L47;
        return r12;
    L47:
        return 0;
    L40:
        r12 = this.mLockModeEnd;
        goto L41
    L5:
        if (r5 != 5) goto L7;
        int r13 = this.mLockModeRight;
        if (r13 == 3) goto L30;
        return r13;
    L30:
        if (r10 != 0) goto L32;
        int r14 = this.mLockModeEnd;
    L33:
        if (r14 == 3) goto L46;
        return r14;
    L46:
        return 0;
    L32:
        r14 = this.mLockModeStart;
        goto L33
    L7:
        if (r5 != 8388611) goto L9;
        int r15 = this.mLockModeStart;
        if (r15 == 3) goto L22;
        return r15;
    L22:
        if (r10 != 0) goto L24;
        int r16 = this.mLockModeLeft;
    L25:
        if (r16 == 3) goto L45;
        return r16;
    L45:
        return 0;
    L24:
        r16 = this.mLockModeRight;
        goto L25
    L9:
        if (r5 != 8388613) goto L48;
        int r17 = this.mLockModeEnd;
        if (r17 == 3) goto L14;
        return r17;
    L14:
        if (r10 != 0) goto L16;
        int r18 = this.mLockModeRight;
    L17:
        if (r18 == 3) goto L43;
        return r18;
    L43:
        return 0;
    L16:
        r18 = this.mLockModeLeft;
        goto L17
    L48:
        return 0;
    }

    @Nullable
    public CharSequence getDrawerTitle(int r5) {
        int r10 = GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this));
        if (r10 != 3) goto L7;
        return this.mTitleLeft;
    L7:
        if (r10 == 5) goto L9;
        return null;
    L9:
        return this.mTitleRight;
    }

    public int getDrawerViewAbsoluteGravity(View r5) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) r5.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    public float getDrawerViewOffset(View r5) {
        return ((LayoutParams) r5.getLayoutParams()).onScreen;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    public boolean isContentView(View r5) {
        if (((LayoutParams) r5.getLayoutParams()).gravity != 0) goto L5;
        return CHILDREN_DISALLOW_INTERCEPT;
    L5:
        return false;
    }

    public boolean isDrawerOpen(@NonNull View r5) {
        if (isDrawerView(r5) == false) goto L10;
        if ((((LayoutParams) r5.getLayoutParams()).openState & 1) == 1) goto L11;
        return false;
    L11:
        return CHILDREN_DISALLOW_INTERCEPT;
    L10:
        throw new IllegalArgumentException("View " + r5 + " is not a drawer");
    }

    public boolean isDrawerView(View r5) {
        int r10 = GravityCompat.getAbsoluteGravity(((LayoutParams) r5.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(r5));
        if ((r10 & 3) == 0) goto L6;
        return CHILDREN_DISALLOW_INTERCEPT;
    L6:
        if ((r10 & 5) == 0) goto L8;
        return CHILDREN_DISALLOW_INTERCEPT;
    L8:
        return false;
    }

    public boolean isDrawerVisible(@NonNull View r5) {
        if (isDrawerView(r5) == false) goto L10;
        if (((LayoutParams) r5.getLayoutParams()).onScreen <= 0.0f) goto L7;
        return CHILDREN_DISALLOW_INTERCEPT;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("View " + r5 + " is not a drawer");
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
    }

    public void moveDrawerToOffset(View r5, float r10) {
        float r11 = getDrawerViewOffset(r5);
        float r12 = r5.getWidth();
        int r13 = ((int) (r12 * r10)) - ((int) (r11 * r12));
        if (checkDrawerViewAbsoluteGravity(r5, 3) == true) goto L6;
        r13 = -r13;
    L6:
        r5.offsetLeftAndRight(r13);
        setDrawerViewOffset(r5, r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        Object r10 = this.mLastInsets;
        if (r10 == null) goto L9;
        int r11 = ((WindowInsets) r10).getSystemWindowInsetTop();
    L10:
        if (r11 <= 0) goto L15;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r11);
        this.mStatusBarBackground.draw(r5);
        return;
    L15:
        return;
    L9:
        r11 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r5 = r10.getActionMasked();
        boolean r11 = this.mLeftDragger.shouldInterceptTouchEvent(r10) | this.mRightDragger.shouldInterceptTouchEvent(r10);
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L6;
    L12:
        closeDrawers(CHILDREN_DISALLOW_INTERCEPT);
        this.mChildrenCanceledTouch = false;
    L13:
        boolean r12 = false;
    L23:
        if (r11 == true) goto L32;
        if (r12 == false) goto L26;
        return CHILDREN_DISALLOW_INTERCEPT;
    L26:
        if (hasPeekingDrawer() == false) goto L28;
        return CHILDREN_DISALLOW_INTERCEPT;
    L28:
        if (this.mChildrenCanceledTouch == false) goto L31;
        return CHILDREN_DISALLOW_INTERCEPT;
    L31:
        return false;
    L32:
        return CHILDREN_DISALLOW_INTERCEPT;
    L6:
        if (r5 == 2) goto L10;
        if (r5 == 3) goto L12;
    L10:
        if (this.mLeftDragger.checkTouchSlop(3) == false) goto L13;
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        goto L13
    L14:
        float r13 = r10.getX();
        float r14 = r10.getY();
        this.mInitialMotionX = r13;
        this.mInitialMotionY = r14;
        if (this.mScrimOpacity <= 0.0f) goto L21;
        View r15 = this.mLeftDragger.findTopChildUnder((int) r13, (int) r14);
        if (r15 == null) goto L21;
        if (isContentView(r15) == false) goto L21;
        r12 = true;
    L22:
        this.mChildrenCanceledTouch = false;
    L21:
        r12 = false;
        goto L22
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r5, KeyEvent r10) {
        if (r5 != 4) goto L9;
        if (hasVisibleDrawer() == false) goto L9;
        r10.startTracking();
        return CHILDREN_DISALLOW_INTERCEPT;
    L9:
        return super.onKeyDown(r5, r10);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r5, KeyEvent r10) {
        if (r5 != 4) goto L14;
        View r11 = findVisibleDrawer();
        if (r11 != null) goto L7;
    L9:
        if (r11 == null) goto L11;
        return CHILDREN_DISALLOW_INTERCEPT;
    L11:
        return false;
    L7:
        if (getDrawerLockMode(r11) != 0) goto L9;
        closeDrawers();
        goto L9
    L14:
        return super.onKeyUp(r5, r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        boolean r5 = CHILDREN_DISALLOW_INTERCEPT;
        this.mInLayout = CHILDREN_DISALLOW_INTERCEPT;
        int r10 = r20 - r18;
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L42;
        View r13 = getChildAt(r12);
        if (r13.getVisibility() == 8) goto L40;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (isContentView(r13) == false) goto L10;
        int r15 = ((ViewGroup.MarginLayoutParams) r14).leftMargin;
        r13.layout(r15, ((ViewGroup.MarginLayoutParams) r14).topMargin, r13.getMeasuredWidth() + r15, r13.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r14).topMargin);
        goto L40
    L10:
        int r16 = r13.getMeasuredWidth();
        int r22 = r13.getMeasuredHeight();
        if (checkDrawerViewAbsoluteGravity(r13, 3) == false) goto L13;
        float r110 = r16;
        int r111 = (-r16) + ((int) (r14.onScreen * r110));
        float r112 = (r16 + r111) / r110;
    L15:
        if (r112 == r14.onScreen) goto L17;
        boolean r113 = r5;
    L18:
        int r114 = r14.gravity & 112;
        if (r114 != 16) goto L21;
        int r115 = r21 - r19;
        int r116 = (r115 - r22) / 2;
        int r117 = ((ViewGroup.MarginLayoutParams) r14).topMargin;
        if (r116 >= r117) goto L27;
        r116 = r117;
    L30:
        r13.layout(r111, r116, r16 + r111, r22 + r116);
    L31:
        if (r113 == false) goto L34;
        setDrawerViewOffset(r13, r112);
    L34:
        if (r14.onScreen <= 0.0f) goto L36;
        int r23 = 0;
    L38:
        if (r13.getVisibility() == r23) goto L40;
        r13.setVisibility(r23);
        goto L40
    L36:
        r23 = 4;
        goto L38
    L27:
        int r118 = r116 + r22;
        int r24 = ((ViewGroup.MarginLayoutParams) r14).bottomMargin;
        if (r118 <= (r115 - r24)) goto L30;
        r116 = (r115 - r24) - r22;
        goto L30
    L21:
        if (r114 == 80) goto L23;
        int r119 = ((ViewGroup.MarginLayoutParams) r14).topMargin;
        r13.layout(r111, r119, r16 + r111, r22 + r119);
        goto L31
    L23:
        int r25 = r21 - r19;
        r13.layout(r111, (r25 - ((ViewGroup.MarginLayoutParams) r14).bottomMargin) - r13.getMeasuredHeight(), r16 + r111, r25 - ((ViewGroup.MarginLayoutParams) r14).bottomMargin);
        goto L31
    L17:
        r113 = false;
        goto L18
    L13:
        float r120 = r16;
        int r121 = r10 - ((int) (r14.onScreen * r120));
        r112 = (r10 - r121) / r120;
        r111 = r121;
    L40:
        r12 = r12 + 1;
        r5 = CHILDREN_DISALLOW_INTERCEPT;
        goto L3
    L42:
        if (sEdgeSizeUsingSystemGestureInsets == false) goto L46;
        WindowInsets r26 = getRootWindowInsets();
        if (r26 == null) goto L46;
        Insets r27 = WindowInsetsCompat.toWindowInsetsCompat(r26).getSystemGestureInsets();
        ViewDragHelper r28 = this.mLeftDragger;
        r28.setEdgeSize(Math.max(r28.getDefaultEdgeSize(), r27.left));
        ViewDragHelper r29 = this.mRightDragger;
        r29.setEdgeSize(Math.max(r29.getDefaultEdgeSize(), r27.right));
    L46:
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int r18, int r19) {
        int r5 = View.MeasureSpec.getMode(r18);
        int r10 = View.MeasureSpec.getMode(r19);
        int r11 = View.MeasureSpec.getSize(r18);
        int r12 = View.MeasureSpec.getSize(r19);
        if (r5 != 1073741824) goto L6;
        if (r10 != 1073741824) goto L6;
    L12:
        setMeasuredDimension(r11, r12);
        if (this.mLastInsets != null) goto L15;
    L17:
        boolean r13 = false;
    L18:
        int r14 = ViewCompat.getLayoutDirection(this);
        int r15 = getChildCount();
        int r16 = 0;
        boolean r17 = false;
        boolean r110 = false;
    L19:
        if (r16 >= r15) goto L68;
        View r111 = getChildAt(r16);
        if (r111.getVisibility() == 8) goto L65;
        LayoutParams r112 = (LayoutParams) r111.getLayoutParams();
        if (r13 == false) goto L40;
        int r113 = GravityCompat.getAbsoluteGravity(r112.gravity, r14);
        if (ViewCompat.getFitsSystemWindows(r111) == false) goto L33;
        WindowInsets r20 = (WindowInsets) this.mLastInsets;
        if (r113 != 3) goto L30;
        r20 = r20.replaceSystemWindowInsets(r20.getSystemWindowInsetLeft(), r20.getSystemWindowInsetTop(), 0, r20.getSystemWindowInsetBottom());
    L32:
        r111.dispatchApplyWindowInsets(r20);
        goto L40
    L30:
        if (r113 != 5) goto L32;
        r20 = r20.replaceSystemWindowInsets(0, r20.getSystemWindowInsetTop(), r20.getSystemWindowInsetRight(), r20.getSystemWindowInsetBottom());
        goto L32
    L33:
        WindowInsets r21 = (WindowInsets) this.mLastInsets;
        if (r113 != 3) goto L36;
        r21 = r21.replaceSystemWindowInsets(r21.getSystemWindowInsetLeft(), r21.getSystemWindowInsetTop(), 0, r21.getSystemWindowInsetBottom());
    L38:
        ((ViewGroup.MarginLayoutParams) r112).leftMargin = r21.getSystemWindowInsetLeft();
        ((ViewGroup.MarginLayoutParams) r112).topMargin = r21.getSystemWindowInsetTop();
        ((ViewGroup.MarginLayoutParams) r112).rightMargin = r21.getSystemWindowInsetRight();
        ((ViewGroup.MarginLayoutParams) r112).bottomMargin = r21.getSystemWindowInsetBottom();
        goto L40
    L36:
        if (r113 != 5) goto L38;
        r21 = r21.replaceSystemWindowInsets(0, r21.getSystemWindowInsetTop(), r21.getSystemWindowInsetRight(), r21.getSystemWindowInsetBottom());
    L40:
        if (isContentView(r111) == false) goto L44;
        r111.measure(View.MeasureSpec.makeMeasureSpec((r11 - ((ViewGroup.MarginLayoutParams) r112).leftMargin) - ((ViewGroup.MarginLayoutParams) r112).rightMargin, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((r12 - ((ViewGroup.MarginLayoutParams) r112).topMargin) - ((ViewGroup.MarginLayoutParams) r112).bottomMargin, BasicMeasure.EXACTLY));
        goto L65
    L44:
        if (isDrawerView(r111) == false) goto L67;
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L50;
        float r22 = ViewCompat.getElevation(r111);
        float r114 = this.mDrawerElevation;
        if (r22 == r114) goto L50;
        ViewCompat.setElevation(r111, r114);
    L50:
        int r23 = getDrawerViewAbsoluteGravity(r111) & 7;
        if (r23 != 3) goto L53;
        boolean r115 = CHILDREN_DISALLOW_INTERCEPT;
    L54:
        if (r115 == false) goto L56;
        if (r17 == false) goto L56;
    L60:
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(r23) + " but this DrawerLayout already has a drawer view along that edge");
    L56:
        if (r115 == true) goto L61;
        if (r110 == true) goto L60;
    L61:
        if (r115 == false) goto L63;
        r17 = CHILDREN_DISALLOW_INTERCEPT;
    L64:
        r111.measure(ViewGroup.getChildMeasureSpec(r18, (this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) r112).leftMargin) + ((ViewGroup.MarginLayoutParams) r112).rightMargin, ((ViewGroup.MarginLayoutParams) r112).width), ViewGroup.getChildMeasureSpec(r19, ((ViewGroup.MarginLayoutParams) r112).topMargin + ((ViewGroup.MarginLayoutParams) r112).bottomMargin, ((ViewGroup.MarginLayoutParams) r112).height));
        goto L65
    L63:
        r110 = CHILDREN_DISALLOW_INTERCEPT;
        goto L64
    L53:
        r115 = false;
        goto L54
    L67:
        throw new IllegalStateException("Child " + r111 + " at index " + r16 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
    L65:
        r16 = r16 + 1;
        goto L19
    L68:
        return;
    L15:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L17;
        r13 = CHILDREN_DISALLOW_INTERCEPT;
    L6:
        if (isInEditMode() == false) goto L70;
        if (r5 != 0) goto L10;
        r11 = 300;
    L10:
        if (r10 != 0) goto L12;
        r12 = 300;
        goto L12
    L70:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        int r11 = r10.openDrawerGravity;
        if (r11 == 0) goto L11;
        View r12 = findDrawerWithGravity(r11);
        if (r12 == null) goto L11;
        openDrawer(r12);
    L11:
        int r13 = r10.lockModeLeft;
        if (r13 == 3) goto L14;
        setDrawerLockMode(r13, 3);
    L14:
        int r14 = r10.lockModeRight;
        if (r14 == 3) goto L17;
        setDrawerLockMode(r14, 5);
    L17:
        int r15 = r10.lockModeStart;
        if (r15 == 3) goto L20;
        setDrawerLockMode(r15, GravityCompat.START);
    L20:
        int r16 = r10.lockModeEnd;
        if (r16 == 3) goto L24;
        setDrawerLockMode(r16, GravityCompat.END);
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r5) {
        resolveShadowDrawables();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L17;
        LayoutParams r12 = (LayoutParams) getChildAt(r11).getLayoutParams();
        int r13 = r12.openState;
        boolean r14 = CHILDREN_DISALLOW_INTERCEPT;
        if (r13 != 1) goto L7;
        boolean r15 = true;
    L9:
        if (r13 == 2) goto L12;
        r14 = false;
    L12:
        if (r15 == true) goto L16;
        if (r14 == true) goto L16;
        r11 = r11 + 1;
    L16:
        r5.openDrawerGravity = r12.gravity;
        goto L17
    L7:
        r15 = false;
    L17:
        r5.lockModeLeft = this.mLockModeLeft;
        r5.lockModeRight = this.mLockModeRight;
        r5.lockModeStart = this.mLockModeStart;
        r5.lockModeEnd = this.mLockModeEnd;
        return r5;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        this.mLeftDragger.processTouchEvent(r10);
        this.mRightDragger.processTouchEvent(r10);
        int r5 = r10.getAction() & 255;
        boolean r11 = false;
        if (r5 == 0) goto L21;
        if (r5 != 1) goto L6;
        float r12 = r10.getX();
        float r13 = r10.getY();
        View r14 = this.mLeftDragger.findTopChildUnder((int) r12, (int) r13);
        if (r14 != null) goto L12;
    L19:
        r11 = true;
    L20:
        closeDrawers(r11);
    L22:
        return CHILDREN_DISALLOW_INTERCEPT;
    L12:
        if (isContentView(r14) == false) goto L19;
        float r15 = r12 - this.mInitialMotionX;
        float r16 = r13 - this.mInitialMotionY;
        int r17 = this.mLeftDragger.getTouchSlop();
        if (((r16 * r16) + (r15 * r15)) >= (r17 * r17)) goto L19;
        View r18 = findOpenDrawer();
        if (r18 == null) goto L19;
        if (getDrawerLockMode(r18) != 2) goto L20;
    L6:
        if (r5 != 3) goto L22;
        closeDrawers(CHILDREN_DISALLOW_INTERCEPT);
        this.mChildrenCanceledTouch = false;
        goto L22
    L21:
        float r19 = r10.getX();
        float r20 = r10.getY();
        this.mInitialMotionX = r19;
        this.mInitialMotionY = r20;
        this.mChildrenCanceledTouch = false;
        goto L22
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openDrawer(GravityCompat.START);
    }

    public void openDrawer(@NonNull View r5) {
        openDrawer(r5, CHILDREN_DISALLOW_INTERCEPT);
    }

    public void removeDrawerListener(@NonNull DrawerListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        List<DrawerListener> r10 = this.mListeners;
        if (r10 != null) goto L7;
        return;
    L7:
        r10.remove(r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r5) {
        super.requestDisallowInterceptTouchEvent(r5);
        if (r5 == false) goto L6;
        closeDrawers(CHILDREN_DISALLOW_INTERCEPT);
        return;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout == true) goto L6;
        super.requestLayout();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setChildInsets(Object r5, boolean r10) {
        this.mLastInsets = r5;
        this.mDrawStatusBarBackground = r10;
        if (r10 == false) goto L5;
    L7:
        boolean r11 = false;
    L8:
        setWillNotDraw(r11);
        requestLayout();
        return;
    L5:
        if (getBackground() != null) goto L7;
        r11 = CHILDREN_DISALLOW_INTERCEPT;
        goto L8
    }

    public void setDrawerElevation(float r5) {
        this.mDrawerElevation = r5;
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        View r11 = getChildAt(r10);
        if (isDrawerView(r11) == false) goto L8;
        ViewCompat.setElevation(r11, this.mDrawerElevation);
    L8:
        r10 = r10 + 1;
        goto L4
    }

    @Deprecated
    public void setDrawerListener(DrawerListener r5) {
        DrawerListener r10 = this.mListener;
        if (r10 == null) goto L5;
        removeDrawerListener(r10);
    L5:
        if (r5 == null) goto L7;
        addDrawerListener(r5);
    L7:
        this.mListener = r5;
    }

    public void setDrawerLockMode(int r5) {
        setDrawerLockMode(r5, 3);
        setDrawerLockMode(r5, 5);
    }

    public void setDrawerShadow(Drawable r5, int r10) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L6;
        return;
    L6:
        if ((r10 & GravityCompat.START) != 8388611) goto L9;
        this.mShadowStart = r5;
    L17:
        resolveShadowDrawables();
        invalidate();
        return;
    L9:
        if ((r10 & GravityCompat.END) != 8388613) goto L12;
        this.mShadowEnd = r5;
        goto L17
    L12:
        if ((r10 & 3) != 3) goto L15;
        this.mShadowLeft = r5;
        goto L17
    L15:
        if ((r10 & 5) != 5) goto L19;
        this.mShadowRight = r5;
        goto L17
    }

    public void setDrawerTitle(int r5, @Nullable CharSequence r10) {
        int r11 = GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this));
        if (r11 != 3) goto L6;
        this.mTitleLeft = r10;
        return;
    L6:
        if (r11 != 5) goto L10;
        this.mTitleRight = r10;
        return;
    }

    public void setDrawerViewOffset(View r5, float r10) {
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        if (r10 != r11.onScreen) goto L5;
        return;
    L5:
        r11.onScreen = r10;
        dispatchOnDrawerSlide(r5, r10);
    }

    public void setScrimColor(@ColorInt int r5) {
        this.mScrimColor = r5;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable r5) {
        this.mStatusBarBackground = r5;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int r5) {
        this.mStatusBarBackground = new ColorDrawable(r5);
        invalidate();
    }

    public void updateDrawerState(int r5, View r10) {
        int r11 = this.mLeftDragger.getViewDragState();
        int r12 = this.mRightDragger.getViewDragState();
        if (r11 == 1) goto L11;
        if (r12 == 1) goto L11;
        int r13 = 2;
        if (r11 == 2) goto L12;
        if (r12 == 2) goto L12;
        r13 = 0;
    L12:
        if (r10 == null) goto L21;
        if (r5 != 0) goto L21;
        float r14 = ((LayoutParams) r10.getLayoutParams()).onScreen;
        if (r14 != 0.0f) goto L18;
        dispatchOnDrawerClosed(r10);
        goto L21
    L18:
        if (r14 != 1.0f) goto L21;
        dispatchOnDrawerOpened(r10);
    L21:
        if (r13 == this.mDrawerState) goto L27;
        this.mDrawerState = r13;
        List<DrawerListener> r15 = this.mListeners;
        if (r15 == null) goto L29;
        int r16 = r15.size() - 1;
    L25:
        if (r16 < 0) goto L30;
        this.mListeners.get(r16).onDrawerStateChanged(r13);
        r16 = r16 - 1;
        goto L25
    L30:
        return;
    L29:
        return;
    L27:
        return;
    L11:
        r13 = 1;
        goto L12
    }

    public DrawerLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public void closeDrawer(@NonNull View r5, boolean r10) {
        if (isDrawerView(r5) == false) goto L17;
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r11.onScreen = 0.0f;
        r11.openState = 0;
    L14:
        invalidate();
        return;
    L8:
        if (r10 == false) goto L13;
        r11.openState |= 4;
        if (checkDrawerViewAbsoluteGravity(r5, 3) == false) goto L12;
        this.mLeftDragger.smoothSlideViewTo(r5, -r5.getWidth(), r5.getTop());
        goto L14
    L12:
        this.mRightDragger.smoothSlideViewTo(r5, getWidth(), r5.getTop());
        goto L14
    L13:
        moveDrawerToOffset(r5, 0.0f);
        updateDrawerState(0, r5);
        r5.setVisibility(4);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r5 + " is not a sliding drawer");
    }

    public void closeDrawers(boolean r10) {
        int r5 = getChildCount();
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 >= r5) goto L17;
        View r13 = getChildAt(r11);
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (isDrawerView(r13) == false) goto L16;
        if (r10 == true) goto L8;
    L10:
        int r15 = r13.getWidth();
        if (checkDrawerViewAbsoluteGravity(r13, 3) == false) goto L14;
        boolean r16 = this.mLeftDragger.smoothSlideViewTo(r13, -r15, r13.getTop());
    L13:
        r12 = r12 | r16;
        r14.isPeeking = false;
        goto L16
    L14:
        r16 = this.mRightDragger.smoothSlideViewTo(r13, getWidth(), r13.getTop());
        goto L13
    L8:
        if (r14.isPeeking == true) goto L10;
    L16:
        r11 = r11 + 1;
        goto L3
    L17:
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (r12 == false) goto L25;
        invalidate();
        return;
    }

    public void openDrawer(@NonNull View r5, boolean r10) {
        if (isDrawerView(r5) == false) goto L17;
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r11.onScreen = 1.0f;
        r11.openState = 1;
        updateChildrenImportantForAccessibility(r5, CHILDREN_DISALLOW_INTERCEPT);
        updateChildAccessibilityAction(r5);
    L14:
        invalidate();
        return;
    L8:
        if (r10 == false) goto L13;
        r11.openState |= 2;
        if (checkDrawerViewAbsoluteGravity(r5, 3) == false) goto L12;
        this.mLeftDragger.smoothSlideViewTo(r5, 0, r5.getTop());
        goto L14
    L12:
        this.mRightDragger.smoothSlideViewTo(r5, getWidth() - r5.getWidth(), r5.getTop());
        goto L14
    L13:
        moveDrawerToOffset(r5, 1.0f);
        updateDrawerState(0, r5);
        r5.setVisibility(0);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r5 + " is not a sliding drawer");
    }

    public DrawerLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.mActionDismiss = new AnonymousClass1(this);
        setDescendantFocusability(262144);
        float r5 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * r5) + 0.5f);
        float r13 = r5 * 400.0f;
        ViewDragCallback r14 = new ViewDragCallback(this, 3);
        this.mLeftCallback = r14;
        ViewDragCallback r15 = new ViewDragCallback(this, 5);
        this.mRightCallback = r15;
        ViewDragHelper r16 = ViewDragHelper.create(this, 1.0f, r14);
        this.mLeftDragger = r16;
        r16.setEdgeTrackingEnabled(1);
        r16.setMinVelocity(r13);
        r14.setDragger(r16);
        ViewDragHelper r17 = ViewDragHelper.create(this, 1.0f, r15);
        this.mRightDragger = r17;
        r17.setEdgeTrackingEnabled(2);
        r17.setMinVelocity(r13);
        r15.setDragger(r17);
        setFocusableInTouchMode(CHILDREN_DISALLOW_INTERCEPT);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L10;
        setOnApplyWindowInsetsListener(new AnonymousClass2(this));
        setSystemUiVisibility(1280);
        TypedArray r18 = r10.obtainStyledAttributes(THEME_ATTRS);
        this.mStatusBarBackground = r18.getDrawable(0);     // Catch: Throwable -> L7
        r18.recycle();
    L7:
        th = move-exception;
        r18.recycle();
        throw th;
    L10:
        TypedArray r19 = r10.obtainStyledAttributes(r11, androidx.drawerlayout.R.styleable.DrawerLayout, r12, 0);
    L14:
        th = move-exception;
        r19.recycle();
        throw th;
    L12:
        if (r19.hasValue(androidx.drawerlayout.R.styleable.DrawerLayout_elevation) == false) goto L16;
        this.mDrawerElevation = r19.getDimension(androidx.drawerlayout.R.styleable.DrawerLayout_elevation, 0.0f);     // Catch: Throwable -> L14
    L17:
        r19.recycle();
        this.mNonDrawerViews = new ArrayList();
        return;
    L16:
        this.mDrawerElevation = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);     // Catch: Throwable -> L14
        goto L17
    }

    public void setDrawerLockMode(int r5, int r10) {
        int r11 = GravityCompat.getAbsoluteGravity(r10, ViewCompat.getLayoutDirection(this));
        if (r10 != 3) goto L5;
        this.mLockModeLeft = r5;
    L15:
        if (r5 == 0) goto L21;
        if (r11 != 3) goto L18;
        ViewDragHelper r12 = this.mLeftDragger;
    L19:
        r12.cancel();
        goto L21
    L18:
        r12 = this.mRightDragger;
    L21:
        if (r5 != 1) goto L23;
        View r13 = findDrawerWithGravity(r11);
        if (r13 == null) goto L34;
        closeDrawer(r13);
        return;
    L34:
        return;
    L23:
        if (r5 != 2) goto L35;
        View r14 = findDrawerWithGravity(r11);
        if (r14 == null) goto L32;
        openDrawer(r14);
        return;
    L32:
        return;
    L35:
        return;
    L5:
        if (r10 != 5) goto L7;
        this.mLockModeRight = r5;
        goto L15
    L7:
        if (r10 != 8388611) goto L9;
        this.mLockModeStart = r5;
        goto L15
    L9:
        if (r10 != 8388613) goto L15;
        this.mLockModeEnd = r5;
        goto L15
    }

    public void setStatusBarBackground(int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = ContextCompat.getDrawable(getContext(), r5);
    L5:
        this.mStatusBarBackground = r10;
        invalidate();
        return;
    L4:
        r10 = null;
        goto L5
    }

    public boolean isDrawerVisible(int r5) {
        View r10 = findDrawerWithGravity(r5);
        if (r10 != null) goto L5;
        return false;
    L5:
        return isDrawerVisible(r10);
    }

    public boolean isDrawerOpen(int r5) {
        View r10 = findDrawerWithGravity(r5);
        if (r10 != null) goto L5;
        return false;
    L5:
        return isDrawerOpen(r10);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    public void setDrawerShadow(@DrawableRes int r5, int r10) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), r5), r10);
    }

    public int getDrawerLockMode(@NonNull View r5) {
        if (isDrawerView(r5) == false) goto L7;
        return getDrawerLockMode(((LayoutParams) r5.getLayoutParams()).gravity);
    L7:
        throw new IllegalArgumentException("View " + r5 + " is not a drawer");
    }

    public void setDrawerLockMode(int r5, @NonNull View r10) {
        if (isDrawerView(r10) == false) goto L7;
        setDrawerLockMode(r5, ((LayoutParams) r10.getLayoutParams()).gravity);
        return;
    L7:
        throw new IllegalArgumentException("View " + r10 + " is not a drawer with appropriate layout_gravity");
    }

    public void closeDrawer(int r5) {
        closeDrawer(r5, CHILDREN_DISALLOW_INTERCEPT);
    }

    public void closeDrawer(int r5, boolean r10) {
        View r11 = findDrawerWithGravity(r5);
        if (r11 == null) goto L7;
        closeDrawer(r11, r10);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r5));
    }

    public void openDrawer(int r5) {
        openDrawer(r5, CHILDREN_DISALLOW_INTERCEPT);
    }

    public void openDrawer(int r5, boolean r10) {
        View r11 = findDrawerWithGravity(r5);
        if (r11 == null) goto L7;
        openDrawer(r11, r10);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r5));
    }
}

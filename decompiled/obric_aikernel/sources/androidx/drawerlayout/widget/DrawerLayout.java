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
import android.os.Build;
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

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ DrawerLayout this$0;

        AccessibilityDelegate(DrawerLayout r10) {
            this.this$0 = r10;
            this.mTmpRect = new Rect();
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat r10, ViewGroup r11) {
            int r12 = r11.getChildCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L8;
            View r14 = r11.getChildAt(r13);
            if (DrawerLayout.includeChildForAccessibility(r14) == false) goto L7;
            r10.addChild(r14);
        L7:
            r13 = r13 + 1;
            goto L3
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r10, AccessibilityNodeInfoCompat r11) {
            Rect r12 = this.mTmpRect;
            r11.getBoundsInScreen(r12);
            r10.setBoundsInScreen(r12);
            r10.setVisibleToUser(r11.isVisibleToUser());
            r10.setPackageName(r11.getPackageName());
            r10.setClassName(r11.getClassName());
            r10.setContentDescription(r11.getContentDescription());
            r10.setEnabled(r11.isEnabled());
            r10.setFocused(r11.isFocused());
            r10.setAccessibilityFocused(r11.isAccessibilityFocused());
            r10.setSelected(r11.isSelected());
            r10.addAction(r11.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            if (r11.getEventType() != 32) goto L12;
            List<CharSequence> r12 = r11.getText();
            View r13 = this.this$0.findVisibleDrawer();
            if (r13 == null) goto L13;
            int r14 = this.this$0.getDrawerViewAbsoluteGravity(r13);
            CharSequence r15 = this.this$0.getDrawerTitle(r14);
            if (r15 == null) goto L14;
            r12.add(r15);
            return true;
        L14:
            return true;
        L13:
            return true;
        L12:
            return super.dispatchPopulateAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            r11.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == false) goto L5;
            super.onInitializeAccessibilityNodeInfo(r10, r11);
        L9:
            r11.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
            r11.setFocusable(false);
            r11.setFocused(false);
            r11.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            r11.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
            return;
        L5:
            AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.obtain(r11);
            super.onInitializeAccessibilityNodeInfo(r10, r12);
            r11.setSource(r10);
            Object r13 = ViewCompat.getParentForAccessibility(r10);
            if ((r13 instanceof View) == false) goto L8;
            r11.setParent((View) r13);
        L8:
            copyNodeInfoNoChildren(r11, r12);
            r12.recycle();
            addChildrenForAccessibility(r11, (ViewGroup) r10);
            goto L9
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == true) goto L10;
            if (DrawerLayout.includeChildForAccessibility(r11) == true) goto L10;
            return false;
        L10:
            return super.onRequestSendAccessibilityEvent(r10, r11, r12);
        }
    }

    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            if (DrawerLayout.includeChildForAccessibility(r10) == true) goto L6;
            r11.setParent(null);
            return;
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(@NonNull View r10);

        void onDrawerOpened(@NonNull View r10);

        void onDrawerSlide(@NonNull View r10, float r11);

        void onDrawerStateChanged(int r10);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;
        public int gravity;
        boolean isPeeking;
        float onScreen;
        int openState;

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.gravity = 0;
        }

        public LayoutParams(int r10, int r11, int r12) {
            this(r10, r11);
            this.gravity = r12;
        }

        public LayoutParams(@NonNull Context r10, @Nullable AttributeSet r11) {
            super(r10, r11);
            this.gravity = 0;
            TypedArray r12 = r10.obtainStyledAttributes(r11, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = r12.getInt(0, 0);
            r12.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r10) {
            super(r10);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull LayoutParams r10) {
            super(r10);
            this.gravity = 0;
            this.gravity = r10.gravity;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r10, @Nullable ClassLoader r11) {
            super(r10, r11);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = r10.readInt();
            this.lockModeLeft = r10.readInt();
            this.lockModeRight = r10.readInt();
            this.lockModeStart = r10.readInt();
            this.lockModeEnd = r10.readInt();
        }

        public SavedState(@NonNull Parcelable r10) {
            super(r10);
            this.openDrawerGravity = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.openDrawerGravity);
            r10.writeInt(this.lockModeLeft);
            r10.writeInt(this.lockModeRight);
            r10.writeInt(this.lockModeStart);
            r10.writeInt(this.lockModeEnd);
        }
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public SimpleDrawerListener() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View r10) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View r10) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View r10, float r11) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int r10) {
        }
    }

    private class ViewDragCallback extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;
        final /* synthetic */ DrawerLayout this$0;

        ViewDragCallback(DrawerLayout r10, int r11) {
            this.this$0 = r10;
            this.mPeekRunnable = new AnonymousClass1(this);
            this.mAbsGravity = r11;
        }

        private void closeOtherDrawer() {
            int r10 = 3;
            if (this.mAbsGravity != 3) goto L5;
            r10 = 5;
        L5:
            View r11 = this.this$0.findDrawerWithGravity(r10);
            if (r11 == null) goto L9;
            this.this$0.closeDrawer(r11);
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r10, int r11, int r12) {
            if (this.this$0.checkDrawerViewAbsoluteGravity(r10, 3) == true) goto L5;
            int r13 = this.this$0.getWidth();
            return Math.max(r13 - r10.getWidth(), Math.min(r11, r13));
        L5:
            return Math.max(-r10.getWidth(), Math.min(r11, 0));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r10, int r11, int r12) {
            return r10.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r10) {
            if (this.this$0.isDrawerView(r10) == true) goto L7;
            return 0;
        L7:
            return r10.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r10, int r11) {
            if ((r10 & 1) != 1) goto L5;
            DrawerLayout r12 = this.this$0;
            int r13 = 3;
        L6:
            View r14 = r12.findDrawerWithGravity(r13);
            if (r14 != null) goto L9;
            return;
        L9:
            if (this.this$0.getDrawerLockMode(r14) != 0) goto L13;
            this.mDragger.captureChildView(r14, r11);
            return;
        L13:
            return;
        L5:
            r12 = this.this$0;
            r13 = 5;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int r10) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int r10, int r11) {
            this.this$0.postDelayed(this.mPeekRunnable, 160);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r10, int r11) {
            ((LayoutParams) r10.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r10) {
            this.this$0.updateDrawerState(r10, this.mDragger.getCapturedView());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r10, int r11, int r12, int r13, int r14) {
            int r15 = r10.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r10, 3) == false) goto L5;
            float r16 = r11 + r15;
        L6:
            float r17 = r16 / r15;
            this.this$0.setDrawerViewOffset(r10, r17);
            if (r17 != 0.0f) goto L9;
            int r18 = 4;
        L10:
            r10.setVisibility(r18);
            this.this$0.invalidate();
            return;
        L9:
            r18 = 0;
            goto L10
        L5:
            r16 = this.this$0.getWidth() - r11;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r10, float r11, float r12) {
            float r13 = this.this$0.getDrawerViewOffset(r10);
            int r14 = r10.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r10, 3) == true) goto L5;
            int r15 = this.this$0.getWidth();
            if (r11 >= 0.0f) goto L15;
        L18:
            r15 = r15 - r14;
        L19:
            int r16 = r15;
        L20:
            this.mDragger.settleCapturedViewAt(r16, r10.getTop());
            this.this$0.invalidate();
            return;
        L15:
            if (r11 != 0.0f) goto L19;
            if (r13 <= 0.5f) goto L19;
        L5:
            if (r11 > 0.0f) goto L11;
            if (r11 == 0.0f) goto L8;
        L10:
            r16 = -r14;
            goto L20
        L8:
            if (r13 <= 0.5f) goto L10;
        L11:
            r16 = 0;
            goto L20
        }

        void peekDrawer() {
            int r10 = this.mDragger.getEdgeSize();
            int r11 = 0;
            if (this.mAbsGravity != 3) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L11;
            View r13 = this.this$0.findDrawerWithGravity(3);
            if (r13 == null) goto L10;
            r11 = -r13.getWidth();
        L10:
            int r14 = r11 + r10;
        L12:
            if (r13 == null) goto L23;
            if (r12 == true) goto L15;
        L16:
            if (r12 == false) goto L18;
            return;
        L18:
            if (r13.getLeft() > r14) goto L20;
            return;
        L20:
            if (this.this$0.getDrawerLockMode(r13) != 0) goto L26;
            LayoutParams r15 = (LayoutParams) r13.getLayoutParams();
            this.mDragger.smoothSlideViewTo(r13, r14, r13.getTop());
            r15.isPeeking = true;
            this.this$0.invalidate();
            closeOtherDrawer();
            this.this$0.cancelChildViewTouch();
            return;
        L26:
            return;
        L15:
            if (r13.getLeft() < r14) goto L20;
        L23:
            return;
        L11:
            r13 = this.this$0.findDrawerWithGravity(5);
            r14 = this.this$0.getWidth() - r10;
            goto L12
        L5:
            r12 = false;
            goto L6
        }

        public void removeCallbacks() {
            this.this$0.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper r10) {
            this.mDragger = r10;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r10, int r11) {
            if (this.this$0.isDrawerView(r10) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.this$0.checkDrawerViewAbsoluteGravity(r10, this.mAbsGravity) == false) goto L9;
            if (this.this$0.getDrawerLockMode(r10) != 0) goto L9;
            return true;
        }
    }

    static {
        boolean r10 = true;
        THEME_ATTRS = new int[]{R.attr.colorPrimaryDark};
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 19) goto L5;
        boolean r12 = true;
    L6:
        CAN_HIDE_DESCENDANTS = r12;
        if (r11 < 21) goto L9;
        boolean r13 = true;
    L10:
        SET_DRAWER_SHADOW_FROM_ELEVATION = r13;
        if (r11 >= 29) goto L14;
        r10 = false;
    L14:
        sEdgeSizeUsingSystemGestureInsets = r10;
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public DrawerLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public DrawerLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public DrawerLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
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
        float r13 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * r13) + 0.5f);
        float r14 = r13 * 400.0f;
        ViewDragCallback r15 = new ViewDragCallback(this, 3);
        this.mLeftCallback = r15;
        ViewDragCallback r16 = new ViewDragCallback(this, 5);
        this.mRightCallback = r16;
        ViewDragHelper r17 = ViewDragHelper.create(this, 1.0f, r15);
        this.mLeftDragger = r17;
        r17.setEdgeTrackingEnabled(1);
        r17.setMinVelocity(r14);
        r15.setDragger(r17);
        ViewDragHelper r18 = ViewDragHelper.create(this, 1.0f, r16);
        this.mRightDragger = r18;
        r18.setEdgeTrackingEnabled(2);
        r18.setMinVelocity(r14);
        r16.setDragger(r18);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
    L13:
        TypedArray r19 = r10.obtainStyledAttributes(r11, androidx.drawerlayout.R.styleable.DrawerLayout, r12, 0);
        int r20 = androidx.drawerlayout.R.styleable.DrawerLayout_elevation;     // Catch: Throwable -> L22
        if (r19.hasValue(r20) == false) goto L18;
        float r21 = r19.getDimension(r20, 0.0f);     // Catch: Throwable -> L22
    L17:
        this.mDrawerElevation = r21;     // Catch: Throwable -> L22
        r19.recycle();
        this.mNonDrawerViews = new ArrayList();
        return;
    L18:
        r21 = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r19.recycle();
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        setOnApplyWindowInsetsListener(new AnonymousClass2(this));
        setSystemUiVisibility(1280);
        TypedArray r22 = r10.obtainStyledAttributes(THEME_ATTRS);
        this.mStatusBarBackground = r22.getDrawable(0);     // Catch: Throwable -> L9
        r22.recycle();
    L9:
        th = move-exception;
        r22.recycle();
        throw th;
    L12:
        this.mStatusBarBackground = null;
        goto L13
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent r10, View r11) {
        if (r11.getMatrix().isIdentity() == true) goto L5;
        MotionEvent r12 = getTransformedMotionEvent(r10, r11);
        boolean r13 = r11.dispatchGenericMotionEvent(r12);
        r12.recycle();
        return r13;
    L5:
        float r14 = getScrollX() - r11.getLeft();
        float r15 = getScrollY() - r11.getTop();
        r10.offsetLocation(r14, r15);
        boolean r16 = r11.dispatchGenericMotionEvent(r10);
        r10.offsetLocation(-r14, -r15);
        return r16;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent r10, View r11) {
        float r12 = getScrollX() - r11.getLeft();
        float r13 = getScrollY() - r11.getTop();
        MotionEvent r14 = MotionEvent.obtain(r10);
        r14.offsetLocation(r12, r13);
        Matrix r15 = r11.getMatrix();
        if (r15.isIdentity() == false) goto L5;
    L8:
        return r14;
    L5:
        if (this.mChildInvertedMatrix != null) goto L7;
        this.mChildInvertedMatrix = new Matrix();
    L7:
        r15.invert(this.mChildInvertedMatrix);
        r14.transform(this.mChildInvertedMatrix);
        goto L8
    }

    static String gravityToString(int r10) {
        if ((r10 & 3) != 3) goto L7;
        return "LEFT";
    L7:
        if ((r10 & 5) != 5) goto L11;
        return "RIGHT";
    L11:
        return Integer.toHexString(r10);
    }

    private static boolean hasOpaqueBackground(View r10) {
        Drawable r11 = r10.getBackground();
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.getOpacity() != (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean hasPeekingDrawer() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (((LayoutParams) getChildAt(r11).getLayoutParams()).isPeeking == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean hasVisibleDrawer() {
        if (findVisibleDrawer() == null) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean includeChildForAccessibility(View r10) {
        if (ViewCompat.getImportantForAccessibility(r10) != 4) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.getImportantForAccessibility(r10) == 2) goto L7;
        return true;
    }

    private boolean isInBoundsOfChild(float r10, float r11, View r12) {
        if (this.mChildHitRect != null) goto L5;
        this.mChildHitRect = new Rect();
    L5:
        r12.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) r10, (int) r11);
    }

    private void mirror(Drawable r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (DrawableCompat.isAutoMirrored(r10) == false) goto L8;
        DrawableCompat.setLayoutDirection(r10, r11);
        return;
    }

    private Drawable resolveLeftShadow() {
        int r10 = ViewCompat.getLayoutDirection(this);
        if (r10 != 0) goto L8;
        Drawable r11 = this.mShadowStart;
        if (r11 == null) goto L13;
        mirror(r11, r10);
        return this.mShadowStart;
    L13:
        return this.mShadowLeft;
    L8:
        Drawable r12 = this.mShadowEnd;
        if (r12 == null) goto L13;
        mirror(r12, r10);
        return this.mShadowEnd;
    }

    private Drawable resolveRightShadow() {
        int r10 = ViewCompat.getLayoutDirection(this);
        if (r10 != 0) goto L8;
        Drawable r11 = this.mShadowEnd;
        if (r11 == null) goto L13;
        mirror(r11, r10);
        return this.mShadowEnd;
    L13:
        return this.mShadowRight;
    L8:
        Drawable r12 = this.mShadowStart;
        if (r12 == null) goto L13;
        mirror(r12, r10);
        return this.mShadowStart;
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L5;
        return;
    L5:
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    private void updateChildAccessibilityAction(View r10) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r11 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(r10, r11.getId());
        if (isDrawerOpen(r10) == true) goto L5;
        return;
    L5:
        if (getDrawerLockMode(r10) == 2) goto L9;
        ViewCompat.replaceAccessibilityAction(r10, r11, null, this.mActionDismiss);
        return;
    }

    private void updateChildrenImportantForAccessibility(View r10, boolean r11) {
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        View r14 = getChildAt(r13);
        if (r11 == false) goto L7;
    L8:
        if (r11 == false) goto L11;
        if (r14 != r10) goto L11;
    L10:
        int r15 = 1;
    L12:
        ViewCompat.setImportantForAccessibility(r14, r15);
        r13 = r13 + 1;
    L11:
        r15 = 4;
        goto L12
    L7:
        if (isDrawerView(r14) == false) goto L10;
    }

    public void addDrawerListener(@NonNull DrawerListener r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mListeners != null) goto L7;
        this.mListeners = new ArrayList();
    L7:
        this.mListeners.add(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r10, int r11, int r12) {
        if (getDescendantFocusability() != 393216) goto L5;
        return;
    L5:
        int r13 = getChildCount();
        int r14 = 0;
        int r15 = 0;
        boolean r16 = false;
    L6:
        if (r15 >= r13) goto L14;
        View r17 = getChildAt(r15);
        if (isDrawerView(r17) == true) goto L10;
        this.mNonDrawerViews.add(r17);
    L13:
        r15 = r15 + 1;
        goto L6
    L10:
        if (isDrawerOpen(r17) == false) goto L13;
        r17.addFocusables(r10, r11, r12);
        r16 = true;
        goto L13
    L14:
        if (r16 == true) goto L21;
        int r18 = this.mNonDrawerViews.size();
    L16:
        if (r14 >= r18) goto L21;
        View r19 = this.mNonDrawerViews.get(r14);
        if (r19.getVisibility() != 0) goto L20;
        r19.addFocusables(r10, r11, r12);
    L20:
        r14 = r14 + 1;
    L21:
        this.mNonDrawerViews.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        super.addView(r10, r11, r12);
        if (findOpenDrawer() == null) goto L5;
    L8:
        int r13 = 4;
    L9:
        ViewCompat.setImportantForAccessibility(r10, r13);
        if (CAN_HIDE_DESCENDANTS == true) goto L13;
        ViewCompat.setAccessibilityDelegate(r10, this.mChildAccessibilityDelegate);
        return;
    L13:
        return;
    L5:
        if (isDrawerView(r10) == true) goto L8;
        r13 = 1;
        goto L9
    }

    void cancelChildViewTouch() {
        if (this.mChildrenCanceledTouch == true) goto L10;
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r11 = MotionEvent.obtain(r10, r10, 3, 0.0f, 0.0f, 0);
        int r12 = getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        getChildAt(r13).dispatchTouchEvent(r11);
        r13 = r13 + 1;
        goto L5
    L7:
        r11.recycle();
        this.mChildrenCanceledTouch = true;
        return;
    }

    boolean checkDrawerViewAbsoluteGravity(View r10, int r11) {
        if ((getDrawerViewAbsoluteGravity(r10) & r11) != r11) goto L5;
        return true;
    L5:
        return false;
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

    @Override // androidx.customview.widget.Openable
    public void close() {
        closeDrawer(GravityCompat.START);
    }

    public void closeDrawer(int r10) {
        closeDrawer(r10, true);
    }

    public void closeDrawer(int r10, boolean r11) {
        View r12 = findDrawerWithGravity(r10);
        if (r12 == null) goto L7;
        closeDrawer(r12, r11);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r10));
    }

    public void closeDrawer(@NonNull View r10) {
        closeDrawer(r10, true);
    }

    public void closeDrawer(@NonNull View r10, boolean r11) {
        if (isDrawerView(r10) == false) goto L18;
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r12.onScreen = 0.0f;
        r12.openState = 0;
    L15:
        invalidate();
        return;
    L8:
        if (r11 == false) goto L14;
        r12.openState |= 4;
        if (checkDrawerViewAbsoluteGravity(r10, 3) == false) goto L12;
        ViewDragHelper r13 = this.mLeftDragger;
        int r14 = -r10.getWidth();
    L13:
        r13.smoothSlideViewTo(r10, r14, r10.getTop());
        goto L15
    L12:
        r13 = this.mRightDragger;
        r14 = getWidth();
        goto L13
    L14:
        moveDrawerToOffset(r10, 0.0f);
        updateDrawerState(0, r10);
        r10.setVisibility(4);
        goto L15
    L18:
        throw new IllegalArgumentException("View " + r10 + " is not a sliding drawer");
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    void closeDrawers(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 >= r11) goto L16;
        View r14 = getChildAt(r12);
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (isDrawerView(r14) == false) goto L15;
        if (r10 == true) goto L8;
    L10:
        int r16 = r14.getWidth();
        if (checkDrawerViewAbsoluteGravity(r14, 3) == false) goto L13;
        boolean r17 = this.mLeftDragger.smoothSlideViewTo(r14, -r16, r14.getTop());
    L14:
        r13 = r13 | r17;
        r15.isPeeking = false;
        goto L15
    L13:
        r17 = this.mRightDragger.smoothSlideViewTo(r14, getWidth(), r14.getTop());
        goto L14
    L8:
        if (r15.isPeeking == true) goto L10;
    L15:
        r12 = r12 + 1;
        goto L3
    L16:
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (r13 == false) goto L24;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void computeScroll() {
        int r10 = getChildCount();
        float r11 = 0.0f;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11 = Math.max(r11, ((LayoutParams) getChildAt(r12).getLayoutParams()).onScreen);
        r12 = r12 + 1;
        goto L3
    L5:
        this.mScrimOpacity = r11;
        boolean r13 = this.mLeftDragger.continueSettling(true);
        boolean r14 = this.mRightDragger.continueSettling(true);
        if (r13 == true) goto L8;
        if (r14 == true) goto L8;
        return;
    L8:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        if ((r10.getSource() & 2) == 0) goto L25;
        if (r10.getAction() == 10) goto L25;
        if (this.mScrimOpacity <= 0.0f) goto L25;
        int r11 = getChildCount();
        if (r11 == 0) goto L22;
        float r12 = r10.getX();
        float r13 = r10.getY();
        int r14 = r11 - 1;
    L12:
        if (r14 < 0) goto L31;
        View r15 = getChildAt(r14);
        if (isInBoundsOfChild(r12, r13, r15) == false) goto L21;
        if (isContentView(r15) == true) goto L21;
        if (dispatchTransformedGenericPointerEvent(r10, r15) == false) goto L21;
        return true;
    L21:
        r14 = r14 - 1;
        goto L12
    L31:
        return false;
    L22:
        return false;
    L25:
        return super.dispatchGenericMotionEvent(r10);
    }

    void dispatchOnDrawerClosed(View r10) {
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if ((r11.openState & 1) != 1) goto L16;
        r11.openState = 0;
        List<DrawerListener> r12 = this.mListeners;
        if (r12 == null) goto L9;
        int r13 = r12.size() - 1;
    L7:
        if (r13 < 0) goto L9;
        this.mListeners.get(r13).onDrawerClosed(r10);
        r13 = r13 - 1;
    L9:
        updateChildrenImportantForAccessibility(r10, false);
        updateChildAccessibilityAction(r10);
        if (hasWindowFocus() == false) goto L17;
        View r14 = getRootView();
        if (r14 == null) goto L18;
        r14.sendAccessibilityEvent(32);
        return;
    L18:
        return;
    L17:
        return;
    }

    void dispatchOnDrawerOpened(View r10) {
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if ((r11.openState & 1) != 0) goto L14;
        r11.openState = 1;
        List<DrawerListener> r12 = this.mListeners;
        if (r12 == null) goto L9;
        int r13 = r12.size() - 1;
    L7:
        if (r13 < 0) goto L9;
        this.mListeners.get(r13).onDrawerOpened(r10);
        r13 = r13 - 1;
    L9:
        updateChildrenImportantForAccessibility(r10, true);
        updateChildAccessibilityAction(r10);
        if (hasWindowFocus() == false) goto L15;
        sendAccessibilityEvent(32);
        return;
    L15:
        return;
    }

    void dispatchOnDrawerSlide(View r10, float r11) {
        List<DrawerListener> r12 = this.mListeners;
        if (r12 == null) goto L7;
        int r13 = r12.size() - 1;
    L5:
        if (r13 < 0) goto L9;
        this.mListeners.get(r13).onDrawerSlide(r10, r11);
        r13 = r13 - 1;
        goto L5
    L9:
        return;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas r15, View r16, long r17) {
        int r10 = getHeight();
        boolean r11 = isContentView(r16);
        int r12 = getWidth();
        int r13 = r15.save();
        int r14 = 0;
        if (r11 == false) goto L27;
        int r18 = getChildCount();
        int r19 = 0;
        int r110 = 0;
    L5:
        if (r19 >= r18) goto L26;
        View r111 = getChildAt(r19);
        if (r111 == r16) goto L25;
        if (r111.getVisibility() != 0) goto L25;
        if (hasOpaqueBackground(r111) == false) goto L25;
        if (isDrawerView(r111) == false) goto L25;
        if (r111.getHeight() < r10) goto L25;
        if (checkDrawerViewAbsoluteGravity(r111, 3) == false) goto L22;
        int r112 = r111.getRight();
        if (r112 <= r110) goto L25;
        r110 = r112;
        goto L25
    L22:
        int r113 = r111.getLeft();
        if (r113 >= r12) goto L25;
        r12 = r113;
    L25:
        r19 = r19 + 1;
        goto L5
    L26:
        r15.clipRect(r110, 0, r12, getHeight());
        r14 = r110;
    L27:
        boolean r20 = super.drawChild(r15, r16, r17);
        r15.restoreToCount(r13);
        float r21 = this.mScrimOpacity;
        if (r21 <= 0.0f) goto L32;
        if (r11 == false) goto L32;
        int r22 = this.mScrimColor;
        this.mScrimPaint.setColor((r22 & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((((-16777216) & r22) >>> 24) * r21)) << 24));
        r15.drawRect(r14, 0.0f, r12, getHeight(), this.mScrimPaint);
    L42:
        return r20;
    L32:
        if (this.mShadowLeftResolved == null) goto L38;
        if (checkDrawerViewAbsoluteGravity(r16, 3) == false) goto L38;
        int r23 = this.mShadowLeftResolved.getIntrinsicWidth();
        int r24 = r16.getRight();
        float r25 = Math.max(0.0f, Math.min(r24 / this.mLeftDragger.getEdgeSize(), 1.0f));
        this.mShadowLeftResolved.setBounds(r24, r16.getTop(), r23 + r24, r16.getBottom());
        this.mShadowLeftResolved.setAlpha((int) (r25 * 255.0f));
        Drawable r26 = this.mShadowLeftResolved;
    L36:
        r26.draw(r15);
    L38:
        if (this.mShadowRightResolved == null) goto L42;
        if (checkDrawerViewAbsoluteGravity(r16, 5) == false) goto L42;
        int r27 = this.mShadowRightResolved.getIntrinsicWidth();
        int r28 = r16.getLeft();
        float r29 = Math.max(0.0f, Math.min((getWidth() - r28) / this.mRightDragger.getEdgeSize(), 1.0f));
        this.mShadowRightResolved.setBounds(r28 - r27, r16.getTop(), r28, r16.getBottom());
        this.mShadowRightResolved.setAlpha((int) (r29 * 255.0f));
        r26 = this.mShadowRightResolved;
        goto L36
    }

    View findDrawerWithGravity(int r10) {
        int r11 = GravityCompat.getAbsoluteGravity(r10, ViewCompat.getLayoutDirection(this)) & 7;
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        View r14 = getChildAt(r13);
        if ((getDrawerViewAbsoluteGravity(r14) & 7) == r11) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    View findOpenDrawer() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        View r12 = getChildAt(r11);
        if ((((LayoutParams) r12.getLayoutParams()).openState & 1) == 1) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return null;
    }

    View findVisibleDrawer() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        View r12 = getChildAt(r11);
        if (isDrawerView(r12) == false) goto L9;
        if (isDrawerVisible(r12) == false) goto L9;
        return r12;
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        return null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((LayoutParams) r10);
    L6:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L9:
        return new LayoutParams(r10);
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == true) goto L5;
        return 0.0f;
    L5:
        return this.mDrawerElevation;
    }

    public int getDrawerLockMode(int r10) {
        int r11 = ViewCompat.getLayoutDirection(this);
        if (r10 != 3) goto L5;
        int r12 = this.mLockModeLeft;
        if (r12 == 3) goto L38;
        return r12;
    L38:
        if (r11 != 0) goto L40;
        int r13 = this.mLockModeStart;
    L41:
        if (r13 == 3) goto L47;
        return r13;
    L47:
        return 0;
    L40:
        r13 = this.mLockModeEnd;
        goto L41
    L5:
        if (r10 != 5) goto L7;
        int r14 = this.mLockModeRight;
        if (r14 == 3) goto L30;
        return r14;
    L30:
        if (r11 != 0) goto L32;
        int r15 = this.mLockModeEnd;
    L33:
        if (r15 == 3) goto L46;
        return r15;
    L46:
        return 0;
    L32:
        r15 = this.mLockModeStart;
        goto L33
    L7:
        if (r10 != 8388611) goto L9;
        int r16 = this.mLockModeStart;
        if (r16 == 3) goto L22;
        return r16;
    L22:
        if (r11 != 0) goto L24;
        int r17 = this.mLockModeLeft;
    L25:
        if (r17 == 3) goto L45;
        return r17;
    L45:
        return 0;
    L24:
        r17 = this.mLockModeRight;
        goto L25
    L9:
        if (r10 != 8388613) goto L48;
        int r18 = this.mLockModeEnd;
        if (r18 == 3) goto L14;
        return r18;
    L14:
        if (r11 != 0) goto L16;
        int r19 = this.mLockModeRight;
    L17:
        if (r19 == 3) goto L43;
        return r19;
    L43:
        return 0;
    L16:
        r19 = this.mLockModeLeft;
        goto L17
    L48:
        return 0;
    }

    public int getDrawerLockMode(@NonNull View r10) {
        if (isDrawerView(r10) == false) goto L7;
        return getDrawerLockMode(((LayoutParams) r10.getLayoutParams()).gravity);
    L7:
        throw new IllegalArgumentException("View " + r10 + " is not a drawer");
    }

    @Nullable
    public CharSequence getDrawerTitle(int r10) {
        int r11 = GravityCompat.getAbsoluteGravity(r10, ViewCompat.getLayoutDirection(this));
        if (r11 != 3) goto L7;
        return this.mTitleLeft;
    L7:
        if (r11 == 5) goto L9;
        return null;
    L9:
        return this.mTitleRight;
    }

    int getDrawerViewAbsoluteGravity(View r10) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) r10.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    float getDrawerViewOffset(View r10) {
        return ((LayoutParams) r10.getLayoutParams()).onScreen;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    boolean isContentView(View r10) {
        if (((LayoutParams) r10.getLayoutParams()).gravity != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDrawerOpen(int r10) {
        View r11 = findDrawerWithGravity(r10);
        if (r11 != null) goto L5;
        return false;
    L5:
        return isDrawerOpen(r11);
    }

    public boolean isDrawerOpen(@NonNull View r10) {
        if (isDrawerView(r10) == false) goto L10;
        if ((((LayoutParams) r10.getLayoutParams()).openState & 1) == 1) goto L11;
        return false;
    L11:
        return true;
    L10:
        throw new IllegalArgumentException("View " + r10 + " is not a drawer");
    }

    boolean isDrawerView(View r10) {
        int r11 = GravityCompat.getAbsoluteGravity(((LayoutParams) r10.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(r10));
        if ((r11 & 3) == 0) goto L6;
        return true;
    L6:
        if ((r11 & 5) == 0) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isDrawerVisible(int r10) {
        View r11 = findDrawerWithGravity(r10);
        if (r11 != null) goto L5;
        return false;
    L5:
        return isDrawerVisible(r11);
    }

    public boolean isDrawerVisible(@NonNull View r10) {
        if (isDrawerView(r10) == false) goto L10;
        if (((LayoutParams) r10.getLayoutParams()).onScreen <= 0.0f) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("View " + r10 + " is not a drawer");
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
    }

    void moveDrawerToOffset(View r10, float r11) {
        float r12 = getDrawerViewOffset(r10);
        float r13 = r10.getWidth();
        int r14 = ((int) (r13 * r11)) - ((int) (r12 * r13));
        if (checkDrawerViewAbsoluteGravity(r10, 3) == true) goto L6;
        r14 = -r14;
    L6:
        r10.offsetLeftAndRight(r14);
        setDrawerViewOffset(r10, r11);
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
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        Object r11 = this.mLastInsets;
        if (r11 == null) goto L11;
        int r12 = ((WindowInsets) r11).getSystemWindowInsetTop();
    L12:
        if (r12 <= 0) goto L17;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r12);
        this.mStatusBarBackground.draw(r10);
        return;
    L17:
        return;
    L11:
        r12 = 0;
        goto L12
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        boolean r12 = this.mLeftDragger.shouldInterceptTouchEvent(r10) | this.mRightDragger.shouldInterceptTouchEvent(r10);
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L6;
    L12:
        closeDrawers(true);
        this.mChildrenCanceledTouch = false;
    L13:
        boolean r13 = false;
    L23:
        if (r12 == true) goto L32;
        if (r13 == false) goto L26;
        return true;
    L26:
        if (hasPeekingDrawer() == false) goto L28;
        return true;
    L28:
        if (this.mChildrenCanceledTouch == false) goto L31;
        return true;
    L31:
        return false;
    L32:
        return true;
    L6:
        if (r11 == 2) goto L10;
        if (r11 == 3) goto L12;
    L10:
        if (this.mLeftDragger.checkTouchSlop(3) == false) goto L13;
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        goto L13
    L14:
        float r14 = r10.getX();
        float r15 = r10.getY();
        this.mInitialMotionX = r14;
        this.mInitialMotionY = r15;
        if (this.mScrimOpacity <= 0.0f) goto L21;
        View r16 = this.mLeftDragger.findTopChildUnder((int) r14, (int) r15);
        if (r16 == null) goto L21;
        if (isContentView(r16) == false) goto L21;
        r13 = true;
    L22:
        this.mChildrenCanceledTouch = false;
    L21:
        r13 = false;
        goto L22
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (r10 != 4) goto L9;
        if (hasVisibleDrawer() == false) goto L9;
        r11.startTracking();
        return true;
    L9:
        return super.onKeyDown(r10, r11);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r10, KeyEvent r11) {
        if (r10 != 4) goto L14;
        View r12 = findVisibleDrawer();
        if (r12 != null) goto L7;
    L9:
        if (r12 == null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (getDrawerLockMode(r12) != 0) goto L9;
        closeDrawers();
        goto L9
    L14:
        return super.onKeyUp(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        boolean r10 = true;
        this.mInLayout = true;
        int r11 = r20 - r18;
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L43;
        View r14 = getChildAt(r13);
        if (r14.getVisibility() == 8) goto L41;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (isContentView(r14) == false) goto L10;
        int r16 = ((ViewGroup.MarginLayoutParams) r15).leftMargin;
        r14.layout(r16, ((ViewGroup.MarginLayoutParams) r15).topMargin, r14.getMeasuredWidth() + r16, ((ViewGroup.MarginLayoutParams) r15).topMargin + r14.getMeasuredHeight());
        goto L41
    L10:
        int r22 = r14.getMeasuredWidth();
        int r23 = r14.getMeasuredHeight();
        if (checkDrawerViewAbsoluteGravity(r14, 3) == false) goto L13;
        float r110 = r22;
        int r111 = (-r22) + ((int) (r15.onScreen * r110));
        float r112 = (r22 + r111) / r110;
    L15:
        if (r112 == r15.onScreen) goto L17;
        boolean r113 = r10;
    L18:
        int r114 = r15.gravity & 112;
        if (r114 != 16) goto L21;
        int r115 = r21 - r19;
        int r116 = (r115 - r23) / 2;
        int r117 = ((ViewGroup.MarginLayoutParams) r15).topMargin;
        if (r116 >= r117) goto L28;
        r116 = r117;
    L31:
        r14.layout(r111, r116, r22 + r111, r23 + r116);
    L32:
        if (r113 == false) goto L35;
        setDrawerViewOffset(r14, r112);
    L35:
        if (r15.onScreen <= 0.0f) goto L37;
        int r24 = 0;
    L39:
        if (r14.getVisibility() == r24) goto L41;
        r14.setVisibility(r24);
        goto L41
    L37:
        r24 = 4;
        goto L39
    L28:
        int r118 = r116 + r23;
        int r25 = ((ViewGroup.MarginLayoutParams) r15).bottomMargin;
        if (r118 <= (r115 - r25)) goto L31;
        r116 = (r115 - r25) - r23;
        goto L31
    L21:
        if (r114 == 80) goto L24;
        int r119 = ((ViewGroup.MarginLayoutParams) r15).topMargin;
        int r26 = r22 + r111;
        int r27 = r23 + r119;
    L23:
        r14.layout(r111, r119, r26, r27);
        goto L32
    L24:
        int r28 = r21 - r19;
        r119 = (r28 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - r14.getMeasuredHeight();
        r26 = r22 + r111;
        r27 = r28 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin;
        goto L23
    L17:
        r113 = false;
        goto L18
    L13:
        float r120 = r22;
        int r121 = r11 - ((int) (r15.onScreen * r120));
        r112 = (r11 - r121) / r120;
        r111 = r121;
    L41:
        r13 = r13 + 1;
        r10 = true;
        goto L3
    L43:
        if (sEdgeSizeUsingSystemGestureInsets == false) goto L47;
        WindowInsets r29 = getRootWindowInsets();
        if (r29 == null) goto L47;
        Insets r30 = WindowInsetsCompat.toWindowInsetsCompat(r29).getSystemGestureInsets();
        ViewDragHelper r31 = this.mLeftDragger;
        r31.setEdgeSize(Math.max(r31.getDefaultEdgeSize(), r30.left));
        ViewDragHelper r32 = this.mRightDragger;
        r32.setEdgeSize(Math.max(r32.getDefaultEdgeSize(), r30.right));
    L47:
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int r18, int r19) {
        int r10 = View.MeasureSpec.getMode(r18);
        int r11 = View.MeasureSpec.getMode(r19);
        int r12 = View.MeasureSpec.getSize(r18);
        int r13 = View.MeasureSpec.getSize(r19);
        if (r10 != 1073741824) goto L6;
        if (r11 != 1073741824) goto L6;
    L11:
        setMeasuredDimension(r12, r13);
        int r14 = 0;
        if (this.mLastInsets != null) goto L14;
    L16:
        boolean r15 = false;
    L17:
        int r16 = ViewCompat.getLayoutDirection(this);
        int r17 = getChildCount();
        int r20 = 0;
        boolean r110 = false;
        boolean r111 = false;
    L18:
        if (r20 >= r17) goto L71;
        View r112 = getChildAt(r20);
        if (r112.getVisibility() == 8) goto L68;
        LayoutParams r113 = (LayoutParams) r112.getLayoutParams();
        if (r15 == false) goto L43;
        int r114 = GravityCompat.getAbsoluteGravity(r113.gravity, r16);
        boolean r115 = ViewCompat.getFitsSystemWindows(r112);
        int r21 = Build.VERSION.SDK_INT;
        if (r115 == false) goto L34;
        if (r21 < 21) goto L43;
        WindowInsets r22 = (WindowInsets) this.mLastInsets;
        if (r114 != 3) goto L31;
        r22 = r22.replaceSystemWindowInsets(r22.getSystemWindowInsetLeft(), r22.getSystemWindowInsetTop(), r14, r22.getSystemWindowInsetBottom());
    L33:
        r112.dispatchApplyWindowInsets(r22);
        goto L43
    L31:
        if (r114 != 5) goto L33;
        r22 = r22.replaceSystemWindowInsets(r14, r22.getSystemWindowInsetTop(), r22.getSystemWindowInsetRight(), r22.getSystemWindowInsetBottom());
        goto L33
    L34:
        if (r21 < 21) goto L43;
        WindowInsets r23 = (WindowInsets) this.mLastInsets;
        if (r114 != 3) goto L39;
        r23 = r23.replaceSystemWindowInsets(r23.getSystemWindowInsetLeft(), r23.getSystemWindowInsetTop(), r14, r23.getSystemWindowInsetBottom());
    L41:
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = r23.getSystemWindowInsetLeft();
        ((ViewGroup.MarginLayoutParams) r113).topMargin = r23.getSystemWindowInsetTop();
        ((ViewGroup.MarginLayoutParams) r113).rightMargin = r23.getSystemWindowInsetRight();
        ((ViewGroup.MarginLayoutParams) r113).bottomMargin = r23.getSystemWindowInsetBottom();
        goto L43
    L39:
        if (r114 != 5) goto L41;
        r23 = r23.replaceSystemWindowInsets(r14, r23.getSystemWindowInsetTop(), r23.getSystemWindowInsetRight(), r23.getSystemWindowInsetBottom());
    L43:
        if (isContentView(r112) == false) goto L47;
        r112.measure(View.MeasureSpec.makeMeasureSpec((r12 - ((ViewGroup.MarginLayoutParams) r113).leftMargin) - ((ViewGroup.MarginLayoutParams) r113).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((r13 - ((ViewGroup.MarginLayoutParams) r113).topMargin) - ((ViewGroup.MarginLayoutParams) r113).bottomMargin, 1073741824));
        goto L68
    L47:
        if (isDrawerView(r112) == false) goto L70;
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L53;
        float r24 = ViewCompat.getElevation(r112);
        float r116 = this.mDrawerElevation;
        if (r24 == r116) goto L53;
        ViewCompat.setElevation(r112, r116);
    L53:
        int r25 = getDrawerViewAbsoluteGravity(r112) & 7;
        if (r25 != 3) goto L56;
        int r117 = 1;
    L57:
        if (r117 == 0) goto L59;
        if (r110 == false) goto L59;
    L63:
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(r25) + " but this " + TAG + " already has a drawer view along that edge");
    L59:
        if (r117 != 0) goto L64;
        if (r111 == true) goto L63;
    L64:
        if (r117 == 0) goto L66;
        r110 = true;
    L67:
        r112.measure(ViewGroup.getChildMeasureSpec(r18, (this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) r113).leftMargin) + ((ViewGroup.MarginLayoutParams) r113).rightMargin, ((ViewGroup.MarginLayoutParams) r113).width), ViewGroup.getChildMeasureSpec(r19, ((ViewGroup.MarginLayoutParams) r113).topMargin + ((ViewGroup.MarginLayoutParams) r113).bottomMargin, ((ViewGroup.MarginLayoutParams) r113).height));
        goto L68
    L66:
        r111 = true;
        goto L67
    L56:
        r117 = r14;
        goto L57
    L70:
        throw new IllegalStateException("Child " + r112 + " at index " + r20 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
    L68:
        r20 = r20 + 1;
        r14 = 0;
        goto L18
    L71:
        return;
    L14:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L16;
        r15 = true;
    L6:
        if (isInEditMode() == false) goto L73;
        if (r10 != 0) goto L9;
        r12 = 300;
    L9:
        if (r11 != 0) goto L11;
        r13 = 300;
        goto L11
    L73:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        int r12 = r11.openDrawerGravity;
        if (r12 == 0) goto L11;
        View r13 = findDrawerWithGravity(r12);
        if (r13 == null) goto L11;
        openDrawer(r13);
    L11:
        int r14 = r11.lockModeLeft;
        if (r14 == 3) goto L14;
        setDrawerLockMode(r14, 3);
    L14:
        int r15 = r11.lockModeRight;
        if (r15 == 3) goto L17;
        setDrawerLockMode(r15, 5);
    L17:
        int r16 = r11.lockModeStart;
        if (r16 == 3) goto L20;
        setDrawerLockMode(r16, GravityCompat.START);
    L20:
        int r17 = r11.lockModeEnd;
        if (r17 == 3) goto L24;
        setDrawerLockMode(r17, GravityCompat.END);
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r10) {
        resolveShadowDrawables();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        LayoutParams r13 = (LayoutParams) getChildAt(r12).getLayoutParams();
        int r14 = r13.openState;
        boolean r15 = true;
        if (r14 != 1) goto L7;
        boolean r16 = true;
    L9:
        if (r14 == 2) goto L12;
        r15 = false;
    L12:
        if (r16 == true) goto L16;
        if (r15 == true) goto L16;
        r12 = r12 + 1;
    L16:
        r10.openDrawerGravity = r13.gravity;
        goto L17
    L7:
        r16 = false;
    L17:
        r10.lockModeLeft = this.mLockModeLeft;
        r10.lockModeRight = this.mLockModeRight;
        r10.lockModeStart = this.mLockModeStart;
        r10.lockModeEnd = this.mLockModeEnd;
        return r10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        this.mLeftDragger.processTouchEvent(r10);
        this.mRightDragger.processTouchEvent(r10);
        int r11 = r10.getAction() & 255;
        boolean r12 = false;
        if (r11 == 0) goto L21;
        if (r11 != 1) goto L6;
        float r13 = r10.getX();
        float r14 = r10.getY();
        View r15 = this.mLeftDragger.findTopChildUnder((int) r13, (int) r14);
        if (r15 != null) goto L12;
    L19:
        r12 = true;
    L20:
        closeDrawers(r12);
    L23:
        return true;
    L12:
        if (isContentView(r15) == false) goto L19;
        float r16 = r13 - this.mInitialMotionX;
        float r17 = r14 - this.mInitialMotionY;
        int r18 = this.mLeftDragger.getTouchSlop();
        if (((r16 * r16) + (r17 * r17)) >= (r18 * r18)) goto L19;
        View r19 = findOpenDrawer();
        if (r19 == null) goto L19;
        if (getDrawerLockMode(r19) != 2) goto L20;
    L6:
        if (r11 != 3) goto L23;
        closeDrawers(true);
    L22:
        this.mChildrenCanceledTouch = false;
        goto L23
    L21:
        float r20 = r10.getX();
        float r21 = r10.getY();
        this.mInitialMotionX = r20;
        this.mInitialMotionY = r21;
        goto L22
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openDrawer(GravityCompat.START);
    }

    public void openDrawer(int r10) {
        openDrawer(r10, true);
    }

    public void openDrawer(int r10, boolean r11) {
        View r12 = findDrawerWithGravity(r10);
        if (r12 == null) goto L7;
        openDrawer(r12, r11);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r10));
    }

    public void openDrawer(@NonNull View r10) {
        openDrawer(r10, true);
    }

    public void openDrawer(@NonNull View r10, boolean r11) {
        if (isDrawerView(r10) == false) goto L17;
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        if (this.mFirstLayout == false) goto L8;
        r12.onScreen = 1.0f;
        r12.openState = 1;
        updateChildrenImportantForAccessibility(r10, true);
        updateChildAccessibilityAction(r10);
    L14:
        invalidate();
        return;
    L8:
        if (r11 == false) goto L13;
        r12.openState |= 2;
        if (checkDrawerViewAbsoluteGravity(r10, 3) == false) goto L12;
        this.mLeftDragger.smoothSlideViewTo(r10, 0, r10.getTop());
        goto L14
    L12:
        this.mRightDragger.smoothSlideViewTo(r10, getWidth() - r10.getWidth(), r10.getTop());
        goto L14
    L13:
        moveDrawerToOffset(r10, 1.0f);
        updateDrawerState(0, r10);
        r10.setVisibility(0);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r10 + " is not a sliding drawer");
    }

    public void removeDrawerListener(@NonNull DrawerListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List<DrawerListener> r11 = this.mListeners;
        if (r11 != null) goto L7;
        return;
    L7:
        r11.remove(r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        super.requestDisallowInterceptTouchEvent(r10);
        if (r10 == false) goto L6;
        closeDrawers(true);
        return;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout == true) goto L6;
        super.requestLayout();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setChildInsets(Object r10, boolean r11) {
        this.mLastInsets = r10;
        this.mDrawStatusBarBackground = r11;
        if (r11 == false) goto L5;
    L7:
        boolean r12 = false;
    L8:
        setWillNotDraw(r12);
        requestLayout();
        return;
    L5:
        if (getBackground() != null) goto L7;
        r12 = true;
        goto L8
    }

    public void setDrawerElevation(float r10) {
        this.mDrawerElevation = r10;
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L9;
        View r12 = getChildAt(r11);
        if (isDrawerView(r12) == false) goto L8;
        ViewCompat.setElevation(r12, this.mDrawerElevation);
    L8:
        r11 = r11 + 1;
        goto L4
    }

    @Deprecated
    public void setDrawerListener(DrawerListener r10) {
        DrawerListener r11 = this.mListener;
        if (r11 == null) goto L5;
        removeDrawerListener(r11);
    L5:
        if (r10 == null) goto L7;
        addDrawerListener(r10);
    L7:
        this.mListener = r10;
    }

    public void setDrawerLockMode(int r10) {
        setDrawerLockMode(r10, 3);
        setDrawerLockMode(r10, 5);
    }

    public void setDrawerLockMode(int r10, int r11) {
        int r12 = GravityCompat.getAbsoluteGravity(r11, ViewCompat.getLayoutDirection(this));
        if (r11 != 3) goto L5;
        this.mLockModeLeft = r10;
    L15:
        if (r10 == 0) goto L21;
        if (r12 != 3) goto L18;
        ViewDragHelper r13 = this.mLeftDragger;
    L19:
        r13.cancel();
        goto L21
    L18:
        r13 = this.mRightDragger;
    L21:
        if (r10 != 1) goto L23;
        View r14 = findDrawerWithGravity(r12);
        if (r14 == null) goto L34;
        closeDrawer(r14);
        return;
    L34:
        return;
    L23:
        if (r10 != 2) goto L35;
        View r15 = findDrawerWithGravity(r12);
        if (r15 == null) goto L32;
        openDrawer(r15);
        return;
    L32:
        return;
    L35:
        return;
    L5:
        if (r11 != 5) goto L7;
        this.mLockModeRight = r10;
        goto L15
    L7:
        if (r11 != 8388611) goto L9;
        this.mLockModeStart = r10;
        goto L15
    L9:
        if (r11 != 8388613) goto L15;
        this.mLockModeEnd = r10;
        goto L15
    }

    public void setDrawerLockMode(int r10, @NonNull View r11) {
        if (isDrawerView(r11) == false) goto L7;
        setDrawerLockMode(r10, ((LayoutParams) r11.getLayoutParams()).gravity);
        return;
    L7:
        throw new IllegalArgumentException("View " + r11 + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(@DrawableRes int r10, int r11) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), r10), r11);
    }

    public void setDrawerShadow(Drawable r10, int r11) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L6;
        return;
    L6:
        if ((r11 & GravityCompat.START) != 8388611) goto L9;
        this.mShadowStart = r10;
    L17:
        resolveShadowDrawables();
        invalidate();
        return;
    L9:
        if ((r11 & GravityCompat.END) != 8388613) goto L12;
        this.mShadowEnd = r10;
        goto L17
    L12:
        if ((r11 & 3) != 3) goto L15;
        this.mShadowLeft = r10;
        goto L17
    L15:
        if ((r11 & 5) != 5) goto L19;
        this.mShadowRight = r10;
        goto L17
    }

    public void setDrawerTitle(int r10, @Nullable CharSequence r11) {
        int r12 = GravityCompat.getAbsoluteGravity(r10, ViewCompat.getLayoutDirection(this));
        if (r12 != 3) goto L6;
        this.mTitleLeft = r11;
        return;
    L6:
        if (r12 != 5) goto L10;
        this.mTitleRight = r11;
        return;
    }

    void setDrawerViewOffset(View r10, float r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        if (r11 != r12.onScreen) goto L5;
        return;
    L5:
        r12.onScreen = r11;
        dispatchOnDrawerSlide(r10, r11);
    }

    public void setScrimColor(@ColorInt int r10) {
        this.mScrimColor = r10;
        invalidate();
    }

    public void setStatusBarBackground(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = ContextCompat.getDrawable(getContext(), r10);
    L5:
        this.mStatusBarBackground = r11;
        invalidate();
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setStatusBarBackground(@Nullable Drawable r10) {
        this.mStatusBarBackground = r10;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int r10) {
        this.mStatusBarBackground = new ColorDrawable(r10);
        invalidate();
    }

    void updateDrawerState(int r10, View r11) {
        int r12 = this.mLeftDragger.getViewDragState();
        int r13 = this.mRightDragger.getViewDragState();
        int r14 = 2;
        if (r12 == 1) goto L10;
        if (r13 == 1) goto L10;
        if (r12 == 2) goto L11;
        if (r13 == 2) goto L11;
        r14 = 0;
    L11:
        if (r11 == null) goto L20;
        if (r10 != 0) goto L20;
        float r15 = ((LayoutParams) r11.getLayoutParams()).onScreen;
        if (r15 != 0.0f) goto L17;
        dispatchOnDrawerClosed(r11);
        goto L20
    L17:
        if (r15 != 1.0f) goto L20;
        dispatchOnDrawerOpened(r11);
    L20:
        if (r14 == this.mDrawerState) goto L26;
        this.mDrawerState = r14;
        List<DrawerListener> r16 = this.mListeners;
        if (r16 == null) goto L28;
        int r17 = r16.size() - 1;
    L24:
        if (r17 < 0) goto L29;
        this.mListeners.get(r17).onDrawerStateChanged(r14);
        r17 = r17 - 1;
        goto L24
    L29:
        return;
    L28:
        return;
    L26:
        return;
    L10:
        r14 = 1;
        goto L11
    }
}

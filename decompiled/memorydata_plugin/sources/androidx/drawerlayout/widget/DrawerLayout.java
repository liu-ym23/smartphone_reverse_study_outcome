package androidx.drawerlayout.widget;

import android.R;
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
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.CharCompanionObject;

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

        AccessibilityDelegate(DrawerLayout r1) {
            this.this$0 = r1;
            this.mTmpRect = new Rect();
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat r4, ViewGroup r5) {
            int r3 = r5.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L8;
            View r1 = r5.getChildAt(r0);
            if (DrawerLayout.includeChildForAccessibility(r1) == false) goto L7;
            r4.addChild(r1);
        L7:
            r0 = r0 + 1;
            goto L3
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r1, AccessibilityNodeInfoCompat r2) {
            Rect r0 = this.mTmpRect;
            r2.getBoundsInScreen(r0);
            r1.setBoundsInScreen(r0);
            r1.setVisibleToUser(r2.isVisibleToUser());
            r1.setPackageName(r2.getPackageName());
            r1.setClassName(r2.getClassName());
            r1.setContentDescription(r2.getContentDescription());
            r1.setEnabled(r2.isEnabled());
            r1.setFocused(r2.isFocused());
            r1.setAccessibilityFocused(r2.isAccessibilityFocused());
            r1.setSelected(r2.isSelected());
            r1.addAction(r2.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View r3, AccessibilityEvent r4) {
            if (r4.getEventType() != 32) goto L12;
            List<CharSequence> r5 = r4.getText();
            View r6 = this.this$0.findVisibleDrawer();
            if (r6 == null) goto L13;
            int r7 = this.this$0.getDrawerViewAbsoluteGravity(r6);
            CharSequence r2 = this.this$0.getDrawerTitle(r7);
            if (r2 == null) goto L14;
            r5.add(r2);
            return true;
        L14:
            return true;
        L13:
            return true;
        L12:
            return super.dispatchPopulateAccessibilityEvent(r3, r4);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r1, r2);
            r2.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r6) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == false) goto L5;
            super.onInitializeAccessibilityNodeInfo(r5, r6);
        L9:
            r6.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
            r6.setFocusable(false);
            r6.setFocused(false);
            r6.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            r6.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
            return;
        L5:
            AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.obtain(r6);
            super.onInitializeAccessibilityNodeInfo(r5, r0);
            r6.setSource(r5);
            ViewParent r1 = ViewCompat.getParentForAccessibility(r5);
            if (ZeusTransformUtils.instanceOf(r1, View.class) == false) goto L8;
            r6.setParent((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"));
        L8:
            copyNodeInfoNoChildren(r6, r0);
            r0.recycle();
            addChildrenForAccessibility(r6, (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin"));
            goto L9
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r2, View r3, AccessibilityEvent r4) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS == true) goto L10;
            if (DrawerLayout.includeChildForAccessibility(r3) == true) goto L10;
            return false;
        L10:
            return super.onRequestSendAccessibilityEvent(r2, r3, r4);
        }
    }

    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            if (DrawerLayout.includeChildForAccessibility(r1) == true) goto L6;
            r2.setParent(null);
            return;
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(View r1);

        void onDrawerOpened(View r1);

        void onDrawerSlide(View r1, float r2);

        void onDrawerStateChanged(int r1);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;
        public int gravity;
        boolean isPeeking;
        float onScreen;
        int openState;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.gravity = 0;
        }

        public LayoutParams(int r1, int r2, int r3) {
            this(r1, r2);
            this.gravity = r3;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r5, r6);
            this.gravity = 0;
            TypedArray r7 = r5.obtainStyledAttributes(r6, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = r7.getInt(0, 0);
            r7.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.gravity = 0;
            this.gravity = r2.gravity;
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

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = r1.readInt();
            this.lockModeLeft = r1.readInt();
            this.lockModeRight = r1.readInt();
            this.lockModeStart = r1.readInt();
            this.lockModeEnd = r1.readInt();
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
            this.openDrawerGravity = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.openDrawerGravity);
            r1.writeInt(this.lockModeLeft);
            r1.writeInt(this.lockModeRight);
            r1.writeInt(this.lockModeStart);
            r1.writeInt(this.lockModeEnd);
        }
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public SimpleDrawerListener() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View r1) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View r1) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View r1, float r2) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int r1) {
        }
    }

    private class ViewDragCallback extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;
        final /* synthetic */ DrawerLayout this$0;

        ViewDragCallback(DrawerLayout r1, int r2) {
            this.this$0 = r1;
            this.mPeekRunnable = new AnonymousClass1(this);
            this.mAbsGravity = r2;
        }

        private void closeOtherDrawer() {
            int r1 = 3;
            if (this.mAbsGravity != 3) goto L5;
            r1 = 5;
        L5:
            View r0 = this.this$0.findDrawerWithGravity(r1);
            if (r0 == null) goto L9;
            this.this$0.closeDrawer(r0);
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r2, int r3, int r4) {
            if (this.this$0.checkDrawerViewAbsoluteGravity(r2, 3) == true) goto L5;
            int r1 = this.this$0.getWidth();
            return Math.max(r1 - r2.getWidth(), Math.min(r3, r1));
        L5:
            return Math.max(-r2.getWidth(), Math.min(r3, 0));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r1, int r2, int r3) {
            return r1.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r1) {
            if (this.this$0.isDrawerView(r1) == true) goto L7;
            return 0;
        L7:
            return r1.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r2, int r3) {
            if ((r2 & 1) != 1) goto L5;
            DrawerLayout r4 = this.this$0;
            int r0 = 3;
        L6:
            View r5 = r4.findDrawerWithGravity(r0);
            if (r5 != null) goto L9;
            return;
        L9:
            if (this.this$0.getDrawerLockMode(r5) != 0) goto L13;
            this.mDragger.captureChildView(r5, r3);
            return;
        L13:
            return;
        L5:
            r4 = this.this$0;
            r0 = 5;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int r1) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int r3, int r4) {
            this.this$0.postDelayed(this.mPeekRunnable, 160);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r2, int r3) {
            ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).isPeeking = false;
            closeOtherDrawer();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r2) {
            this.this$0.updateDrawerState(r2, this.mDragger.getCapturedView());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r1, int r2, int r3, int r4, int r5) {
            int r6 = r1.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r1, 3) == false) goto L5;
            float r7 = r2 + r6;
        L6:
            float r8 = r7 / r6;
            this.this$0.setDrawerViewOffset(r1, r8);
            if (r8 != 0.0f) goto L9;
            int r9 = 4;
        L10:
            r1.setVisibility(r9);
            this.this$0.invalidate();
            return;
        L9:
            r9 = 0;
            goto L10
        L5:
            r7 = this.this$0.getWidth() - r2;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r6, float r7, float r8) {
            float r9 = this.this$0.getDrawerViewOffset(r6);
            int r0 = r6.getWidth();
            if (this.this$0.checkDrawerViewAbsoluteGravity(r6, 3) == true) goto L5;
            int r1 = this.this$0.getWidth();
            if (r7 >= 0.0f) goto L15;
        L18:
            r1 = r1 - r0;
        L19:
            int r10 = r1;
        L20:
            this.mDragger.settleCapturedViewAt(r10, r6.getTop());
            this.this$0.invalidate();
            return;
        L15:
            if (r7 != 0.0f) goto L19;
            if (r9 <= 0.5f) goto L19;
        L5:
            if (r7 > 0.0f) goto L11;
            if (r7 == 0.0f) goto L8;
        L10:
            r10 = -r0;
            goto L20
        L8:
            if (r9 <= 0.5f) goto L10;
        L11:
            r10 = 0;
            goto L20
        }

        void peekDrawer() {
            int r0 = this.mDragger.getEdgeSize();
            int r3 = 0;
            if (this.mAbsGravity != 3) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L11;
            View r4 = this.this$0.findDrawerWithGravity(3);
            if (r4 == null) goto L10;
            r3 = -r4.getWidth();
        L10:
            int r5 = r3 + r0;
        L12:
            if (r4 == null) goto L23;
            if (r1 == true) goto L15;
        L16:
            if (r1 == false) goto L18;
            return;
        L18:
            if (r4.getLeft() > r5) goto L20;
            return;
        L20:
            if (this.this$0.getDrawerLockMode(r4) != 0) goto L26;
            LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            this.mDragger.smoothSlideViewTo(r4, r5, r4.getTop());
            r2.isPeeking = true;
            this.this$0.invalidate();
            closeOtherDrawer();
            this.this$0.cancelChildViewTouch();
            return;
        L26:
            return;
        L15:
            if (r4.getLeft() < r5) goto L20;
        L23:
            return;
        L11:
            r4 = this.this$0.findDrawerWithGravity(5);
            r5 = this.this$0.getWidth() - r0;
            goto L12
        L5:
            r1 = false;
            goto L6
        }

        public void removeCallbacks() {
            this.this$0.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper r1) {
            this.mDragger = r1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r2, int r3) {
            if (this.this$0.isDrawerView(r2) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.this$0.checkDrawerViewAbsoluteGravity(r2, this.mAbsGravity) == false) goto L9;
            if (this.this$0.getDrawerLockMode(r2) != 0) goto L9;
            return true;
        }
    }

    static {
        boolean r0 = true;
        THEME_ATTRS = new int[]{R.attr.colorPrimaryDark};
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        if (Build.VERSION.SDK_INT < 19) goto L5;
        boolean r1 = true;
    L6:
        CAN_HIDE_DESCENDANTS = r1;
        if (Build.VERSION.SDK_INT < 21) goto L9;
        boolean r2 = true;
    L10:
        SET_DRAWER_SHADOW_FROM_ELEVATION = r2;
        if (Build.VERSION.SDK_INT >= 29) goto L14;
        r0 = false;
    L14:
        sEdgeSizeUsingSystemGestureInsets = r0;
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public DrawerLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public DrawerLayout(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.drawerLayoutStyle, "attr", "drawerLayoutStyle"));
    }

    public DrawerLayout(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r14, r15, r13);
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
        float r6 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * r6) + 0.5f);
        float r7 = r6 * 400.0f;
        ViewDragCallback r8 = new ViewDragCallback(this, 3);
        this.mLeftCallback = r8;
        ViewDragCallback r4 = new ViewDragCallback(this, 5);
        this.mRightCallback = r4;
        ViewDragHelper r9 = ViewDragHelper.create(this, 1.0f, r8);
        this.mLeftDragger = r9;
        r9.setEdgeTrackingEnabled(1);
        r9.setMinVelocity(r7);
        r8.setDragger(r9);
        ViewDragHelper r10 = ViewDragHelper.create(this, 1.0f, r4);
        this.mRightDragger = r10;
        r10.setEdgeTrackingEnabled(2);
        r10.setMinVelocity(r7);
        r4.setDragger(r10);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
    L13:
        TypedArray r16 = r14.obtainStyledAttributes(r15, com.obric.memorydata.plugin.R.styleable.DrawerLayout, r13, 0);
    L22:
        th = move-exception;
        r16.recycle();
        throw th;
    L15:
        if (r16.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.DrawerLayout_elevation, "styleable", "DrawerLayout_elevation")) == false) goto L18;
        float r17 = r16.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.DrawerLayout_elevation, "styleable", "DrawerLayout_elevation"), 0.0f);     // Catch: Throwable -> L22
    L17:
        this.mDrawerElevation = r17;     // Catch: Throwable -> L22
        r16.recycle();
        this.mNonDrawerViews = new ArrayList();
        return;
    L18:
        r17 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.dimen.def_drawer_elevation, "dimen", "def_drawer_elevation"));     // Catch: Throwable -> L22
        goto L17
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        setOnApplyWindowInsetsListener(new AnonymousClass2(this));
        setSystemUiVisibility(1280);
        TypedArray r5 = r14.obtainStyledAttributes(THEME_ATTRS);
        this.mStatusBarBackground = r5.getDrawable(0);     // Catch: Throwable -> L9
        r5.recycle();
    L9:
        th = move-exception;
        r5.recycle();
        throw th;
    L12:
        this.mStatusBarBackground = null;
        goto L13
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent r3, View r4) {
        if (r4.getMatrix().isIdentity() == true) goto L5;
        MotionEvent r2 = getTransformedMotionEvent(r3, r4);
        boolean r5 = r4.dispatchGenericMotionEvent(r2);
        r2.recycle();
        return r5;
    L5:
        float r0 = getScrollX() - r4.getLeft();
        float r6 = getScrollY() - r4.getTop();
        r3.offsetLocation(r0, r6);
        boolean r7 = r4.dispatchGenericMotionEvent(r3);
        r3.offsetLocation(-r0, -r6);
        return r7;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent r4, View r5) {
        float r0 = getScrollX() - r5.getLeft();
        float r1 = getScrollY() - r5.getTop();
        MotionEvent r6 = MotionEvent.obtain(r4);
        r6.offsetLocation(r0, r1);
        Matrix r7 = r5.getMatrix();
        if (r7.isIdentity() == false) goto L5;
    L8:
        return r6;
    L5:
        if (this.mChildInvertedMatrix != null) goto L7;
        this.mChildInvertedMatrix = new Matrix();
    L7:
        r7.invert(this.mChildInvertedMatrix);
        r6.transform(this.mChildInvertedMatrix);
        goto L8
    }

    static String gravityToString(int r2) {
        if ((r2 & 3) != 3) goto L7;
        return "LEFT";
    L7:
        if ((r2 & 5) != 5) goto L11;
        return "RIGHT";
    L11:
        return Integer.toHexString(r2);
    }

    private static boolean hasOpaqueBackground(View r2) {
        Drawable r3 = r2.getBackground();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.getOpacity() != (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean hasPeekingDrawer() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r2).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).isPeeking == true) goto L6;
        r2 = r2 + 1;
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

    static boolean includeChildForAccessibility(View r2) {
        if (ViewCompat.getImportantForAccessibility(r2) != 4) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.getImportantForAccessibility(r2) == 2) goto L7;
        return true;
    }

    private boolean isInBoundsOfChild(float r2, float r3, View r4) {
        if (this.mChildHitRect != null) goto L5;
        this.mChildHitRect = new Rect();
    L5:
        r4.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) r2, (int) r3);
    }

    private void mirror(Drawable r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (DrawableCompat.isAutoMirrored(r1) == false) goto L8;
        DrawableCompat.setLayoutDirection(r1, r2);
        return;
    }

    private Drawable resolveLeftShadow() {
        int r0 = ViewCompat.getLayoutDirection(this);
        if (r0 != 0) goto L8;
        Drawable r1 = this.mShadowStart;
        if (r1 == null) goto L13;
        mirror(r1, r0);
        return this.mShadowStart;
    L13:
        return this.mShadowLeft;
    L8:
        Drawable r2 = this.mShadowEnd;
        if (r2 == null) goto L13;
        mirror(r2, r0);
        return this.mShadowEnd;
    }

    private Drawable resolveRightShadow() {
        int r0 = ViewCompat.getLayoutDirection(this);
        if (r0 != 0) goto L8;
        Drawable r1 = this.mShadowEnd;
        if (r1 == null) goto L13;
        mirror(r1, r0);
        return this.mShadowEnd;
    L13:
        return this.mShadowRight;
    L8:
        Drawable r2 = this.mShadowStart;
        if (r2 == null) goto L13;
        mirror(r2, r0);
        return this.mShadowStart;
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L5;
        return;
    L5:
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    private void updateChildAccessibilityAction(View r3) {
        ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS.getId());
        if (isDrawerOpen(r3) == true) goto L5;
        return;
    L5:
        if (getDrawerLockMode(r3) == 2) goto L9;
        ViewCompat.replaceAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, this.mActionDismiss);
        return;
    }

    private void updateChildrenImportantForAccessibility(View r5, boolean r6) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = getChildAt(r1);
        if (r6 == false) goto L7;
    L8:
        if (r6 == false) goto L11;
        if (r2 != r5) goto L11;
    L10:
        int r3 = 1;
    L12:
        ViewCompat.setImportantForAccessibility(r2, r3);
        r1 = r1 + 1;
    L11:
        r3 = 4;
        goto L12
    L7:
        if (isDrawerView(r2) == false) goto L10;
    }

    public void addDrawerListener(DrawerListener r3) {
        DrawerListener r4 = (DrawerListener) ZeusTransformUtils.wrapperContextForParams(r3, DrawerListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.mListeners != null) goto L8;
        this.mListeners = new ArrayList();
    L8:
        this.mListeners.add(r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r7, int r8, int r9) {
        if (getDescendantFocusability() != 393216) goto L5;
        return;
    L5:
        int r0 = getChildCount();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L6:
        if (r2 >= r0) goto L14;
        View r4 = getChildAt(r2);
        if (isDrawerView(r4) == true) goto L10;
        this.mNonDrawerViews.add(r4);
    L13:
        r2 = r2 + 1;
        goto L6
    L10:
        if (isDrawerOpen(r4) == false) goto L13;
        r4.addFocusables(r7, r8, r9);
        r3 = true;
        goto L13
    L14:
        if (r3 == true) goto L21;
        int r5 = this.mNonDrawerViews.size();
    L16:
        if (r1 >= r5) goto L21;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.mNonDrawerViews.get(r1), View.class, "com.obric.memorydata.plugin");
        if (r6.getVisibility() != 0) goto L20;
        r6.addFocusables(r7, r8, r9);
    L20:
        r1 = r1 + 1;
    L21:
        this.mNonDrawerViews.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        super.addView(r1, r2, r3);
        if (findOpenDrawer() == null) goto L5;
    L8:
        int r4 = 4;
    L9:
        ViewCompat.setImportantForAccessibility(r1, r4);
        if (CAN_HIDE_DESCENDANTS == true) goto L13;
        ViewCompat.setAccessibilityDelegate(r1, this.mChildAccessibilityDelegate);
        return;
    L13:
        return;
    L5:
        if (isDrawerView(r1) == true) goto L8;
        r4 = 1;
        goto L9
    }

    void cancelChildViewTouch() {
        if (this.mChildrenCanceledTouch == true) goto L10;
        long r3 = SystemClock.uptimeMillis();
        MotionEvent r0 = MotionEvent.obtain(r3, r3, 3, 0.0f, 0.0f, 0);
        int r1 = getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        getChildAt(r2).dispatchTouchEvent(r0);
        r2 = r2 + 1;
        goto L5
    L7:
        r0.recycle();
        this.mChildrenCanceledTouch = true;
        return;
    }

    boolean checkDrawerViewAbsoluteGravity(View r1, int r2) {
        if ((getDrawerViewAbsoluteGravity(r1) & r2) != r2) goto L5;
        return true;
    L5:
        return false;
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

    @Override // androidx.customview.widget.Openable
    public void close() {
        closeDrawer(GravityCompat.START);
    }

    public void closeDrawer(int r2) {
        closeDrawer(r2, true);
    }

    public void closeDrawer(int r2, boolean r3) {
        View r0 = findDrawerWithGravity(r2);
        if (r0 == null) goto L7;
        closeDrawer(r0, r3);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r2));
    }

    public void closeDrawer(View r2) {
        closeDrawer(r2, true);
    }

    public void closeDrawer(View r5, boolean r6) {
        if (isDrawerView(r5) == false) goto L18;
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (this.mFirstLayout == false) goto L8;
        r0.onScreen = 0.0f;
        r0.openState = 0;
    L15:
        invalidate();
        return;
    L8:
        if (r6 == false) goto L14;
        r0.openState |= 4;
        if (checkDrawerViewAbsoluteGravity(r5, 3) == false) goto L12;
        ViewDragHelper r7 = this.mLeftDragger;
        int r1 = -r5.getWidth();
    L13:
        r7.smoothSlideViewTo(r5, r1, r5.getTop());
        goto L15
    L12:
        r7 = this.mRightDragger;
        r1 = getWidth();
        goto L13
    L14:
        moveDrawerToOffset(r5, 0.0f);
        updateDrawerState(0, r5);
        r5.setVisibility(4);
        goto L15
    L18:
        throw new IllegalArgumentException("View " + r5 + " is not a sliding drawer");
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    void closeDrawers(boolean r10) {
        int r0 = getChildCount();
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L16;
        View r4 = getChildAt(r2);
        LayoutParams r5 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (isDrawerView(r4) == false) goto L15;
        if (r10 == true) goto L8;
    L10:
        int r6 = r4.getWidth();
        if (checkDrawerViewAbsoluteGravity(r4, 3) == false) goto L13;
        boolean r7 = this.mLeftDragger.smoothSlideViewTo(r4, -r6, r4.getTop());
    L14:
        r3 = r3 | r7;
        r5.isPeeking = false;
        goto L15
    L13:
        r7 = this.mRightDragger.smoothSlideViewTo(r4, getWidth(), r4.getTop());
        goto L14
    L8:
        if (r5.isPeeking == true) goto L10;
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (r3 == false) goto L24;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void computeScroll() {
        int r0 = getChildCount();
        float r1 = 0.0f;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = Math.max(r1, ((LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r2).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).onScreen);
        r2 = r2 + 1;
        goto L3
    L5:
        this.mScrimOpacity = r1;
        boolean r3 = this.mLeftDragger.continueSettling(true);
        boolean r4 = this.mRightDragger.continueSettling(true);
        if (r3 == true) goto L8;
        if (r4 == true) goto L8;
        return;
    L8:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r7) {
        if ((r7.getSource() & 2) == 0) goto L25;
        if (r7.getAction() == 10) goto L25;
        if (this.mScrimOpacity <= 0.0f) goto L25;
        int r0 = getChildCount();
        if (r0 == 0) goto L22;
        float r1 = r7.getX();
        float r2 = r7.getY();
        int r3 = r0 - 1;
    L12:
        if (r3 < 0) goto L31;
        View r4 = getChildAt(r3);
        if (isInBoundsOfChild(r1, r2, r4) == false) goto L21;
        if (isContentView(r4) == true) goto L21;
        if (dispatchTransformedGenericPointerEvent(r7, r4) == false) goto L21;
        return true;
    L21:
        r3 = r3 - 1;
        goto L12
    L31:
        return false;
    L22:
        return false;
    L25:
        return super.dispatchGenericMotionEvent(r7);
    }

    void dispatchOnDrawerClosed(View r6) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if ((r0.openState & 1) != 1) goto L16;
        r0.openState = 0;
        List<DrawerListener> r1 = this.mListeners;
        if (r1 == null) goto L9;
        int r2 = r1.size() - 1;
    L7:
        if (r2 < 0) goto L9;
        ((DrawerListener) ZeusTransformUtils.preCheckCast(this.mListeners.get(r2), DrawerListener.class, "com.obric.memorydata.plugin")).onDrawerClosed(r6);
        r2 = r2 - 1;
    L9:
        updateChildrenImportantForAccessibility(r6, false);
        updateChildAccessibilityAction(r6);
        if (hasWindowFocus() == false) goto L17;
        View r5 = getRootView();
        if (r5 == null) goto L18;
        r5.sendAccessibilityEvent(32);
        return;
    L18:
        return;
    L17:
        return;
    }

    void dispatchOnDrawerOpened(View r6) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if ((r0.openState & 1) != 0) goto L14;
        r0.openState = 1;
        List<DrawerListener> r1 = this.mListeners;
        if (r1 == null) goto L9;
        int r2 = r1.size() - 1;
    L7:
        if (r2 < 0) goto L9;
        ((DrawerListener) ZeusTransformUtils.preCheckCast(this.mListeners.get(r2), DrawerListener.class, "com.obric.memorydata.plugin")).onDrawerOpened(r6);
        r2 = r2 - 1;
    L9:
        updateChildrenImportantForAccessibility(r6, true);
        updateChildAccessibilityAction(r6);
        if (hasWindowFocus() == false) goto L15;
        sendAccessibilityEvent(32);
        return;
    L15:
        return;
    }

    void dispatchOnDrawerSlide(View r5, float r6) {
        List<DrawerListener> r0 = this.mListeners;
        if (r0 == null) goto L7;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L9;
        ((DrawerListener) ZeusTransformUtils.preCheckCast(this.mListeners.get(r1), DrawerListener.class, "com.obric.memorydata.plugin")).onDrawerSlide(r5, r6);
        r1 = r1 - 1;
        goto L5
    L9:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r15, View r16, long r17) {
        int r3 = getHeight();
        boolean r4 = isContentView(r16);
        int r5 = getWidth();
        int r6 = r15.save();
        int r8 = 0;
        if (r4 == false) goto L27;
        int r9 = getChildCount();
        int r10 = 0;
        int r11 = 0;
    L5:
        if (r10 >= r9) goto L26;
        View r12 = getChildAt(r10);
        if (r12 == r16) goto L25;
        if (r12.getVisibility() != 0) goto L25;
        if (hasOpaqueBackground(r12) == false) goto L25;
        if (isDrawerView(r12) == false) goto L25;
        if (r12.getHeight() < r3) goto L25;
        if (checkDrawerViewAbsoluteGravity(r12, 3) == false) goto L22;
        int r13 = r12.getRight();
        if (r13 <= r11) goto L25;
        r11 = r13;
        goto L25
    L22:
        int r14 = r12.getLeft();
        if (r14 >= r5) goto L25;
        r5 = r14;
    L25:
        r10 = r10 + 1;
        goto L5
    L26:
        r15.clipRect(r11, 0, r5, getHeight());
        r8 = r11;
    L27:
        boolean r18 = super.drawChild(r15, r16, r17);
        r15.restoreToCount(r6);
        float r7 = this.mScrimOpacity;
        if (r7 <= 0.0f) goto L32;
        if (r4 == false) goto L32;
        int r2 = this.mScrimColor;
        this.mScrimPaint.setColor((r2 & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((((-16777216) & r2) >>> 24) * r7)) << 24));
        r15.drawRect(r8, 0.0f, r5, getHeight(), this.mScrimPaint);
    L42:
        return r18;
    L32:
        if (this.mShadowLeftResolved == null) goto L38;
        if (checkDrawerViewAbsoluteGravity(r16, 3) == false) goto L38;
        int r19 = this.mShadowLeftResolved.getIntrinsicWidth();
        int r20 = r16.getRight();
        float r21 = Math.max(0.0f, Math.min(r20 / this.mLeftDragger.getEdgeSize(), 1.0f));
        this.mShadowLeftResolved.setBounds(r20, r16.getTop(), r19 + r20, r16.getBottom());
        this.mShadowLeftResolved.setAlpha((int) (r21 * 255.0f));
        Drawable r0 = this.mShadowLeftResolved;
    L36:
        r0.draw(r15);
    L38:
        if (this.mShadowRightResolved == null) goto L42;
        if (checkDrawerViewAbsoluteGravity(r16, 5) == false) goto L42;
        int r22 = this.mShadowRightResolved.getIntrinsicWidth();
        int r23 = r16.getLeft();
        float r24 = Math.max(0.0f, Math.min((getWidth() - r23) / this.mRightDragger.getEdgeSize(), 1.0f));
        this.mShadowRightResolved.setBounds(r23 - r22, r16.getTop(), r23, r16.getBottom());
        this.mShadowRightResolved.setAlpha((int) (r24 * 255.0f));
        r0 = this.mShadowRightResolved;
        goto L36
    }

    View findDrawerWithGravity(int r5) {
        int r6 = GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this)) & 7;
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = getChildAt(r1);
        if ((getDrawerViewAbsoluteGravity(r2) & 7) == r6) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    View findOpenDrawer() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = getChildAt(r1);
        if ((((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).openState & 1) == 1) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    View findVisibleDrawer() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = getChildAt(r1);
        if (isDrawerView(r2) == false) goto L9;
        if (isDrawerVisible(r2) == false) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, LayoutParams.class) == false) goto L6;
        return new LayoutParams((LayoutParams) ZeusTransformUtils.preCheckCast(r3, LayoutParams.class, "com.obric.memorydata.plugin"));
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L9:
        return new LayoutParams(r3);
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == true) goto L5;
        return 0.0f;
    L5:
        return this.mDrawerElevation;
    }

    public int getDrawerLockMode(int r4) {
        int r0 = ViewCompat.getLayoutDirection(this);
        if (r4 != 3) goto L5;
        int r5 = this.mLockModeLeft;
        if (r5 == 3) goto L38;
        return r5;
    L38:
        if (r0 != 0) goto L40;
        int r3 = this.mLockModeStart;
    L41:
        if (r3 == 3) goto L47;
        return r3;
    L47:
        return 0;
    L40:
        r3 = this.mLockModeEnd;
        goto L41
    L5:
        if (r4 != 5) goto L7;
        int r6 = this.mLockModeRight;
        if (r6 == 3) goto L30;
        return r6;
    L30:
        if (r0 != 0) goto L32;
        int r7 = this.mLockModeEnd;
    L33:
        if (r7 == 3) goto L46;
        return r7;
    L46:
        return 0;
    L32:
        r7 = this.mLockModeStart;
        goto L33
    L7:
        if (r4 != 8388611) goto L9;
        int r8 = this.mLockModeStart;
        if (r8 == 3) goto L22;
        return r8;
    L22:
        if (r0 != 0) goto L24;
        int r9 = this.mLockModeLeft;
    L25:
        if (r9 == 3) goto L45;
        return r9;
    L45:
        return 0;
    L24:
        r9 = this.mLockModeRight;
        goto L25
    L9:
        if (r4 != 8388613) goto L48;
        int r10 = this.mLockModeEnd;
        if (r10 == 3) goto L14;
        return r10;
    L14:
        if (r0 != 0) goto L16;
        int r11 = this.mLockModeRight;
    L17:
        if (r11 == 3) goto L43;
        return r11;
    L43:
        return 0;
    L16:
        r11 = this.mLockModeLeft;
        goto L17
    L48:
        return 0;
    }

    public int getDrawerLockMode(View r3) {
        if (isDrawerView(r3) == false) goto L7;
        return getDrawerLockMode(((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).gravity);
    L7:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
    }

    public CharSequence getDrawerTitle(int r2) {
        int r3 = GravityCompat.getAbsoluteGravity(r2, ViewCompat.getLayoutDirection(this));
        if (r3 != 3) goto L7;
        return this.mTitleLeft;
    L7:
        if (r3 == 5) goto L9;
        return null;
    L9:
        return this.mTitleRight;
    }

    int getDrawerViewAbsoluteGravity(View r3) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).gravity, ViewCompat.getLayoutDirection(this));
    }

    float getDrawerViewOffset(View r2) {
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).onScreen;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    boolean isContentView(View r2) {
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).gravity != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDrawerOpen(int r1) {
        View r2 = findDrawerWithGravity(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return isDrawerOpen(r2);
    }

    public boolean isDrawerOpen(View r3) {
        if (isDrawerView(r3) == false) goto L10;
        if ((((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).openState & 1) == 1) goto L11;
        return false;
    L11:
        return true;
    L10:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
    }

    boolean isDrawerView(View r3) {
        int r2 = GravityCompat.getAbsoluteGravity(((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).gravity, ViewCompat.getLayoutDirection(r3));
        if ((r2 & 3) == 0) goto L6;
        return true;
    L6:
        if ((r2 & 5) == 0) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isDrawerVisible(int r1) {
        View r2 = findDrawerWithGravity(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return isDrawerVisible(r2);
    }

    public boolean isDrawerVisible(View r3) {
        if (isDrawerView(r3) == false) goto L10;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).onScreen <= 0.0f) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("View " + r3 + " is not a drawer");
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
    }

    void moveDrawerToOffset(View r3, float r4) {
        float r0 = getDrawerViewOffset(r3);
        float r1 = r3.getWidth();
        int r2 = ((int) (r1 * r4)) - ((int) (r0 * r1));
        if (checkDrawerViewAbsoluteGravity(r3, 3) == true) goto L6;
        r2 = -r2;
    L6:
        r3.offsetLeftAndRight(r2);
        setDrawerViewOffset(r3, r4);
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
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        Object r0 = this.mLastInsets;
        if (r0 == null) goto L11;
        int r1 = ((WindowInsets) ZeusTransformUtils.preCheckCast(r0, WindowInsets.class, "com.obric.memorydata.plugin")).getSystemWindowInsetTop();
    L12:
        if (r1 <= 0) goto L17;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r1);
        this.mStatusBarBackground.draw(r5);
        return;
    L17:
        return;
    L11:
        r1 = 0;
        goto L12
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        int r0 = r7.getActionMasked();
        boolean r1 = this.mLeftDragger.shouldInterceptTouchEvent(r7) | this.mRightDragger.shouldInterceptTouchEvent(r7);
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L6;
    L12:
        closeDrawers(true);
        this.mChildrenCanceledTouch = false;
    L13:
        boolean r8 = false;
    L23:
        if (r1 == true) goto L32;
        if (r8 == false) goto L26;
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
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L12;
    L10:
        if (this.mLeftDragger.checkTouchSlop(3) == false) goto L13;
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        goto L13
    L14:
        float r2 = r7.getX();
        float r9 = r7.getY();
        this.mInitialMotionX = r2;
        this.mInitialMotionY = r9;
        if (this.mScrimOpacity <= 0.0f) goto L21;
        View r10 = this.mLeftDragger.findTopChildUnder((int) r2, (int) r9);
        if (r10 == null) goto L21;
        if (isContentView(r10) == false) goto L21;
        r8 = true;
    L22:
        this.mChildrenCanceledTouch = false;
    L21:
        r8 = false;
        goto L22
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L9;
        if (hasVisibleDrawer() == false) goto L9;
        r3.startTracking();
        return true;
    L9:
        return super.onKeyDown(r2, r3);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        if (r2 != 4) goto L14;
        View r4 = findVisibleDrawer();
        if (r4 != null) goto L7;
    L9:
        if (r4 == null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (getDrawerLockMode(r4) != 0) goto L9;
        closeDrawers();
        goto L9
    L14:
        return super.onKeyUp(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        boolean r1 = true;
        this.mInLayout = true;
        int r2 = r20 - r18;
        int r3 = getChildCount();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L42;
        View r6 = getChildAt(r5);
        if (r6.getVisibility() == 8) goto L40;
        LayoutParams r7 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (isContentView(r6) == false) goto L10;
        r6.layout(r7.leftMargin, r7.topMargin, r7.leftMargin + r6.getMeasuredWidth(), r7.topMargin + r6.getMeasuredHeight());
        goto L40
    L10:
        int r8 = r6.getMeasuredWidth();
        int r9 = r6.getMeasuredHeight();
        if (checkDrawerViewAbsoluteGravity(r6, 3) == false) goto L13;
        float r11 = r8;
        int r10 = (-r8) + ((int) (r7.onScreen * r11));
        float r12 = (r8 + r10) / r11;
    L15:
        if (r12 == r7.onScreen) goto L17;
        boolean r13 = r1;
    L18:
        int r14 = r7.gravity & 112;
        if (r14 != 16) goto L21;
        int r15 = r21 - r19;
        int r16 = (r15 - r9) / 2;
        if (r16 >= r7.topMargin) goto L28;
        r16 = r7.topMargin;
    L30:
        r6.layout(r10, r16, r8 + r10, r9 + r16);
    L31:
        if (r13 == false) goto L34;
        setDrawerViewOffset(r6, r12);
    L34:
        if (r7.onScreen <= 0.0f) goto L36;
        int r4 = 0;
    L38:
        if (r6.getVisibility() == r4) goto L40;
        r6.setVisibility(r4);
        goto L40
    L36:
        r4 = 4;
        goto L38
    L28:
        if ((r16 + r9) <= (r15 - r7.bottomMargin)) goto L30;
        r16 = (r15 - r7.bottomMargin) - r9;
        goto L30
    L21:
        if (r14 == 80) goto L23;
        r6.layout(r10, r7.topMargin, r8 + r10, r7.topMargin + r9);
        goto L31
    L23:
        int r22 = r21 - r19;
        r6.layout(r10, (r22 - r7.bottomMargin) - r6.getMeasuredHeight(), r8 + r10, r22 - r7.bottomMargin);
        goto L31
    L17:
        r13 = false;
        goto L18
    L13:
        float r110 = r8;
        int r111 = r2 - ((int) (r7.onScreen * r110));
        r12 = (r2 - r111) / r110;
        r10 = r111;
    L40:
        r5 = r5 + 1;
        r1 = true;
        goto L3
    L42:
        if (sEdgeSizeUsingSystemGestureInsets == false) goto L46;
        WindowInsets r23 = getRootWindowInsets();
        if (r23 == null) goto L46;
        Insets r24 = WindowInsetsCompat.toWindowInsetsCompat(r23).getSystemGestureInsets();
        ViewDragHelper r25 = this.mLeftDragger;
        r25.setEdgeSize(Math.max(r25.getDefaultEdgeSize(), r24.left));
        ViewDragHelper r26 = this.mRightDragger;
        r26.setEdgeSize(Math.max(r26.getDefaultEdgeSize(), r24.right));
    L46:
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    public void onMeasure(int r18, int r19) {
        int r1 = View.MeasureSpec.getMode(r18);
        int r2 = View.MeasureSpec.getMode(r19);
        int r3 = View.MeasureSpec.getSize(r18);
        int r4 = View.MeasureSpec.getSize(r19);
        char r6 = CharCompanionObject.MIN_VALUE;
        if (r1 != 1073741824) goto L6;
        if (r2 != 1073741824) goto L6;
    L11:
        setMeasuredDimension(r3, r4);
        if (this.mLastInsets != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        int r7 = ViewCompat.getLayoutDirection(this);
        int r8 = getChildCount();
        int r9 = 0;
        boolean r10 = false;
        boolean r11 = false;
    L18:
        if (r9 >= r8) goto L72;
        View r12 = getChildAt(r9);
        if (r12.getVisibility() == 8) goto L69;
        LayoutParams r13 = (LayoutParams) ZeusTransformUtils.preCheckCast(r12.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L42;
        int r14 = GravityCompat.getAbsoluteGravity(r13.gravity, r7);
        boolean r16 = ViewCompat.getFitsSystemWindows(r12);
        int r15 = Build.VERSION.SDK_INT;
        if (r16 == false) goto L34;
        if (r15 < 21) goto L42;
        WindowInsets r17 = (WindowInsets) ZeusTransformUtils.preCheckCast(this.mLastInsets, WindowInsets.class, "com.obric.memorydata.plugin");
        if (r14 != 3) goto L31;
        r17 = r17.replaceSystemWindowInsets(r17.getSystemWindowInsetLeft(), r17.getSystemWindowInsetTop(), 0, r17.getSystemWindowInsetBottom());
    L33:
        r12.dispatchApplyWindowInsets(r17);
        goto L42
    L31:
        if (r14 != 5) goto L33;
        r17 = r17.replaceSystemWindowInsets(0, r17.getSystemWindowInsetTop(), r17.getSystemWindowInsetRight(), r17.getSystemWindowInsetBottom());
        goto L33
    L34:
        if (r15 < 21) goto L42;
        WindowInsets r20 = (WindowInsets) ZeusTransformUtils.preCheckCast(this.mLastInsets, WindowInsets.class, "com.obric.memorydata.plugin");
        if (r14 != 3) goto L38;
        boolean r110 = false;
        r20 = r20.replaceSystemWindowInsets(r20.getSystemWindowInsetLeft(), r20.getSystemWindowInsetTop(), 0, r20.getSystemWindowInsetBottom());
    L41:
        r13.leftMargin = r20.getSystemWindowInsetLeft();
        r13.topMargin = r20.getSystemWindowInsetTop();
        r13.rightMargin = r20.getSystemWindowInsetRight();
        r13.bottomMargin = r20.getSystemWindowInsetBottom();
    L44:
        if (isContentView(r12) == false) goto L48;
        r12.measure(View.MeasureSpec.makeMeasureSpec((r3 - r13.leftMargin) - r13.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((r4 - r13.topMargin) - r13.bottomMargin, 1073741824));
        goto L69
    L48:
        if (isDrawerView(r12) == false) goto L71;
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L54;
        float r21 = ViewCompat.getElevation(r12);
        float r22 = this.mDrawerElevation;
        if (r21 == r22) goto L54;
        ViewCompat.setElevation(r12, r22);
    L54:
        int r23 = getDrawerViewAbsoluteGravity(r12) & 7;
        if (r23 != 3) goto L57;
        boolean r111 = true;
    L58:
        if (r111 == false) goto L60;
        if (r10 == false) goto L60;
    L64:
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(r23) + " but this " + TAG + " already has a drawer view along that edge");
    L60:
        if (r111 == true) goto L65;
        if (r11 == true) goto L64;
    L65:
        if (r111 == false) goto L67;
        r10 = true;
    L68:
        r12.measure(getChildMeasureSpec(r18, (this.mMinDrawerMargin + r13.leftMargin) + r13.rightMargin, r13.width), getChildMeasureSpec(r19, r13.topMargin + r13.bottomMargin, r13.height));
        goto L69
    L67:
        r11 = true;
        goto L68
    L57:
        r111 = r110;
        goto L58
    L71:
        throw new IllegalStateException("Child " + r12 + " at index " + r9 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
    L38:
        r110 = false;
        if (r14 != 5) goto L41;
        r20 = r20.replaceSystemWindowInsets(0, r20.getSystemWindowInsetTop(), r20.getSystemWindowInsetRight(), r20.getSystemWindowInsetBottom());
    L42:
        r110 = false;
    L69:
        r9 = r9 + 1;
        r6 = CharCompanionObject.MIN_VALUE;
        goto L18
    L72:
        return;
    L14:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L16;
        r5 = true;
    L6:
        if (isInEditMode() == false) goto L74;
        if (r1 != 0) goto L9;
        r3 = 300;
    L9:
        if (r2 != 0) goto L11;
        r4 = 300;
        goto L11
    L74:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r6 = (SavedState) ZeusTransformUtils.preCheckCast(r5, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r6.getSuperState());
        if (r6.openDrawerGravity == 0) goto L12;
        View r0 = findDrawerWithGravity(r6.openDrawerGravity);
        if (r0 == null) goto L12;
        openDrawer(r0);
    L12:
        if (r6.lockModeLeft == 3) goto L15;
        setDrawerLockMode(r6.lockModeLeft, 3);
    L15:
        if (r6.lockModeRight == 3) goto L18;
        setDrawerLockMode(r6.lockModeRight, 5);
    L18:
        if (r6.lockModeStart == 3) goto L21;
        setDrawerLockMode(r6.lockModeStart, GravityCompat.START);
    L21:
        if (r6.lockModeEnd == 3) goto L24;
        setDrawerLockMode(r6.lockModeEnd, GravityCompat.END);
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r1) {
        resolveShadowDrawables();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        int r0 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L17;
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r3).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        boolean r6 = true;
        if (r4.openState != 1) goto L7;
        boolean r5 = true;
    L9:
        if (r4.openState == 2) goto L12;
        r6 = false;
    L12:
        if (r5 == true) goto L16;
        if (r6 == true) goto L16;
        r3 = r3 + 1;
    L16:
        r1.openDrawerGravity = r4.gravity;
        goto L17
    L7:
        r5 = false;
    L17:
        r1.lockModeLeft = this.mLockModeLeft;
        r1.lockModeRight = this.mLockModeRight;
        r1.lockModeStart = this.mLockModeStart;
        r1.lockModeEnd = this.mLockModeEnd;
        return r1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        this.mLeftDragger.processTouchEvent(r7);
        this.mRightDragger.processTouchEvent(r7);
        int r0 = r7.getAction() & 255;
        boolean r1 = false;
        if (r0 == 0) goto L21;
        if (r0 != 1) goto L6;
        float r2 = r7.getX();
        float r8 = r7.getY();
        View r3 = this.mLeftDragger.findTopChildUnder((int) r2, (int) r8);
        if (r3 != null) goto L12;
    L19:
        r1 = true;
    L20:
        closeDrawers(r1);
    L23:
        return true;
    L12:
        if (isContentView(r3) == false) goto L19;
        float r4 = r2 - this.mInitialMotionX;
        float r9 = r8 - this.mInitialMotionY;
        int r5 = this.mLeftDragger.getTouchSlop();
        if (((r4 * r4) + (r9 * r9)) >= (r5 * r5)) goto L19;
        View r10 = findOpenDrawer();
        if (r10 == null) goto L19;
        if (getDrawerLockMode(r10) != 2) goto L20;
    L6:
        if (r0 != 3) goto L23;
        closeDrawers(true);
    L22:
        this.mChildrenCanceledTouch = false;
        goto L23
    L21:
        float r6 = r7.getX();
        float r11 = r7.getY();
        this.mInitialMotionX = r6;
        this.mInitialMotionY = r11;
        goto L22
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openDrawer(GravityCompat.START);
    }

    public void openDrawer(int r2) {
        openDrawer(r2, true);
    }

    public void openDrawer(int r2, boolean r3) {
        View r0 = findDrawerWithGravity(r2);
        if (r0 == null) goto L7;
        openDrawer(r0, r3);
        return;
    L7:
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(r2));
    }

    public void openDrawer(View r2) {
        openDrawer(r2, true);
    }

    public void openDrawer(View r4, boolean r5) {
        if (isDrawerView(r4) == false) goto L17;
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (this.mFirstLayout == false) goto L8;
        r0.onScreen = 1.0f;
        r0.openState = 1;
        updateChildrenImportantForAccessibility(r4, true);
        updateChildAccessibilityAction(r4);
    L14:
        invalidate();
        return;
    L8:
        if (r5 == false) goto L13;
        r0.openState |= 2;
        if (checkDrawerViewAbsoluteGravity(r4, 3) == false) goto L12;
        this.mLeftDragger.smoothSlideViewTo(r4, 0, r4.getTop());
        goto L14
    L12:
        this.mRightDragger.smoothSlideViewTo(r4, getWidth() - r4.getWidth(), r4.getTop());
        goto L14
    L13:
        moveDrawerToOffset(r4, 1.0f);
        updateDrawerState(0, r4);
        r4.setVisibility(0);
        goto L14
    L17:
        throw new IllegalArgumentException("View " + r4 + " is not a sliding drawer");
    }

    public void removeDrawerListener(DrawerListener r3) {
        DrawerListener r4 = (DrawerListener) ZeusTransformUtils.wrapperContextForParams(r3, DrawerListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<DrawerListener> r2 = this.mListeners;
        if (r2 != null) goto L8;
        return;
    L8:
        r2.remove(r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        if (r1 == false) goto L6;
        closeDrawers(true);
        return;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout == true) goto L6;
        super.requestLayout();
        return;
    }

    public void setChildInsets(Object r1, boolean r2) {
        this.mLastInsets = r1;
        this.mDrawStatusBarBackground = r2;
        if (r2 == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        setWillNotDraw(r3);
        requestLayout();
        return;
    L5:
        if (getBackground() != null) goto L7;
        r3 = true;
        goto L8
    }

    public void setDrawerElevation(float r3) {
        this.mDrawerElevation = r3;
        int r4 = 0;
    L4:
        if (r4 >= getChildCount()) goto L9;
        View r0 = getChildAt(r4);
        if (isDrawerView(r0) == false) goto L8;
        ViewCompat.setElevation(r0, this.mDrawerElevation);
    L8:
        r4 = r4 + 1;
        goto L4
    }

    @Deprecated
    public void setDrawerListener(DrawerListener r3) {
        DrawerListener r4 = (DrawerListener) ZeusTransformUtils.wrapperContextForParams(r3, DrawerListener.class, "com.obric.memorydata.plugin");
        DrawerListener r0 = this.mListener;
        if (r0 == null) goto L5;
        removeDrawerListener(r0);
    L5:
        if (r4 == null) goto L7;
        addDrawerListener(r4);
    L7:
        this.mListener = r4;
    }

    public void setDrawerLockMode(int r2) {
        setDrawerLockMode(r2, 3);
        setDrawerLockMode(r2, 5);
    }

    public void setDrawerLockMode(int r4, int r5) {
        int r0 = GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this));
        if (r5 != 3) goto L5;
        this.mLockModeLeft = r4;
    L15:
        if (r4 == 0) goto L21;
        if (r0 != 3) goto L18;
        ViewDragHelper r6 = this.mLeftDragger;
    L19:
        r6.cancel();
        goto L21
    L18:
        r6 = this.mRightDragger;
    L21:
        if (r4 != 1) goto L23;
        View r7 = findDrawerWithGravity(r0);
        if (r7 == null) goto L34;
        closeDrawer(r7);
        return;
    L34:
        return;
    L23:
        if (r4 != 2) goto L35;
        View r8 = findDrawerWithGravity(r0);
        if (r8 == null) goto L32;
        openDrawer(r8);
        return;
    L32:
        return;
    L35:
        return;
    L5:
        if (r5 != 5) goto L7;
        this.mLockModeRight = r4;
        goto L15
    L7:
        if (r5 != 8388611) goto L9;
        this.mLockModeStart = r4;
        goto L15
    L9:
        if (r5 != 8388613) goto L15;
        this.mLockModeEnd = r4;
        goto L15
    }

    public void setDrawerLockMode(int r3, View r4) {
        if (isDrawerView(r4) == false) goto L7;
        setDrawerLockMode(r3, ((LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).gravity);
        return;
    L7:
        throw new IllegalArgumentException("View " + r4 + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(int r4, int r5) {
        setDrawerShadow(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4), r5);
    }

    public void setDrawerShadow(Drawable r3, int r4) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION == false) goto L6;
        return;
    L6:
        if ((r4 & GravityCompat.START) != 8388611) goto L9;
        this.mShadowStart = r3;
    L17:
        resolveShadowDrawables();
        invalidate();
        return;
    L9:
        if ((r4 & GravityCompat.END) != 8388613) goto L12;
        this.mShadowEnd = r3;
        goto L17
    L12:
        if ((r4 & 3) != 3) goto L15;
        this.mShadowLeft = r3;
        goto L17
    L15:
        if ((r4 & 5) != 5) goto L19;
        this.mShadowRight = r3;
        goto L17
    }

    public void setDrawerTitle(int r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r6 = GravityCompat.getAbsoluteGravity(r3, ViewCompat.getLayoutDirection(this));
        if (r6 != 3) goto L6;
        this.mTitleLeft = r5;
        return;
    L6:
        if (r6 != 5) goto L10;
        this.mTitleRight = r5;
        return;
    }

    void setDrawerViewOffset(View r4, float r5) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r5 != r0.onScreen) goto L5;
        return;
    L5:
        r0.onScreen = r5;
        dispatchOnDrawerSlide(r4, r5);
    }

    public void setScrimColor(int r1) {
        this.mScrimColor = r1;
        invalidate();
    }

    public void setStatusBarBackground(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        this.mStatusBarBackground = r5;
        invalidate();
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setStatusBarBackground(Drawable r1) {
        this.mStatusBarBackground = r1;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int r2) {
        this.mStatusBarBackground = new ColorDrawable(r2);
        invalidate();
    }

    void updateDrawerState(int r6, View r7) {
        int r0 = this.mLeftDragger.getViewDragState();
        int r1 = this.mRightDragger.getViewDragState();
        int r2 = 2;
        if (r0 == 1) goto L10;
        if (r1 == 1) goto L10;
        if (r0 == 2) goto L12;
        if (r1 == 2) goto L12;
        r2 = 0;
    L12:
        if (r7 == null) goto L21;
        if (r6 != 0) goto L21;
        LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r8.onScreen != 0.0f) goto L18;
        dispatchOnDrawerClosed(r7);
        goto L21
    L18:
        if (r8.onScreen != 1.0f) goto L21;
        dispatchOnDrawerOpened(r7);
    L21:
        if (r2 == this.mDrawerState) goto L27;
        this.mDrawerState = r2;
        List<DrawerListener> r9 = this.mListeners;
        if (r9 == null) goto L29;
        int r10 = r9.size() - 1;
    L25:
        if (r10 < 0) goto L30;
        ((DrawerListener) ZeusTransformUtils.preCheckCast(this.mListeners.get(r10), DrawerListener.class, "com.obric.memorydata.plugin")).onDrawerStateChanged(r2);
        r10 = r10 - 1;
        goto L25
    L30:
        return;
    L29:
        return;
    L27:
        return;
    L10:
        r2 = 1;
        goto L12
    }
}

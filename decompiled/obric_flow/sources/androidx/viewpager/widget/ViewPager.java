package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = null;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = null;
    private static final ViewPositionComparator sPositionComparator = null;
    private int mActivePointerId;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        public ItemInfo() {
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0.0f;
        }

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.widthFactor = 0.0f;
            TypedArray r11 = r5.obtainStyledAttributes(r10, ViewPager.LAYOUT_ATTRS);
            this.gravity = r11.getInteger(0, 48);
            r11.recycle();
        }
    }

    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ ViewPager this$0;

        public MyAccessibilityDelegate(ViewPager r5) {
            this.this$0 = r5;
        }

        private boolean canScroll() {
            PagerAdapter r5 = this.this$0.mAdapter;
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (r5.getCount() <= 1) goto L7;
            return true;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r5, r10);
            r10.setClassName(ViewPager.class.getName());
            r10.setScrollable(canScroll());
            if (r10.getEventType() != 4096) goto L8;
            PagerAdapter r11 = this.this$0.mAdapter;
            if (r11 == null) goto L9;
            r10.setItemCount(r11.getCount());
            r10.setFromIndex(this.this$0.mCurItem);
            r10.setToIndex(this.this$0.mCurItem);
            return;
        L9:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
            super.onInitializeAccessibilityNodeInfo(r5, r10);
            r10.setClassName(ViewPager.class.getName());
            r10.setScrollable(canScroll());
            if (this.this$0.canScrollHorizontally(1) == false) goto L6;
            r10.addAction(4096);
        L6:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L9;
            r10.addAction(8192);
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r5, int r10, Bundle r11) {
            if (super.performAccessibilityAction(r5, r10, r11) == false) goto L6;
            return true;
        L6:
            if (r10 == 4096) goto L16;
            if (r10 == 8192) goto L11;
            return false;
        L11:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L14;
            ViewPager r12 = this.this$0;
            r12.setCurrentItem(r12.mCurItem - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.this$0.canScrollHorizontally(1) == false) goto L19;
            ViewPager r13 = this.this$0;
            r13.setCurrentItem(r13.mCurItem + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager r5, @Nullable PagerAdapter r10, @Nullable PagerAdapter r11);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int r5);

        void onPageScrolled(int r5, float r10, @Px int r11);

        void onPageSelected(int r5);
    }

    public interface PageTransformer {
        void transformPage(@NonNull View r5, float r10);
    }

    public class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager this$0;

        public PagerObserver(ViewPager r5) {
            this.this$0 = r5;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dataSetChanged();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcelable r5) {
            super(r5);
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("FragmentPager.SavedState{");
            r5.append(Integer.toHexString(System.identityHashCode(this)));
            r5.append(" position=");
            return a.s(r5, this.position, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.position);
            r5.writeParcelable(this.adapterState, r10);
        }

        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            if (r10 != null) goto L5;
            r10 = getClass().getClassLoader();
        L5:
            this.position = r5.readInt();
            this.adapterState = r5.readParcelable(r10);
            this.loader = r10;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public SimpleOnPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r5) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r5, float r10, int r11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r5) {
        }
    }

    public static class ViewPositionComparator implements Comparator<View> {
        public ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r5, View r10) {
            return compare2(r5, r10);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r5, View r10) {
            LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
            LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
            boolean r13 = r11.isDecor;
            if (r13 == r12.isDecor) goto L9;
            if (r13 == false) goto L6;
            return 1;
        L6:
            return -1;
        L9:
            return r11.position - r12.position;
        }
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        COMPARATOR = new AnonymousClass1();
        sInterpolator = new AnonymousClass2();
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(@NonNull Context r5) {
        super(r5);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new AnonymousClass3(this);
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo r11, int r12, ItemInfo r13) {
        int r5 = this.mAdapter.getCount();
        int r10 = getClientWidth();
        if (r10 <= 0) goto L5;
        float r14 = this.mPageMargin / r10;
    L7:
        if (r13 == null) goto L39;
        int r15 = r13.position;
        int r16 = r11.position;
        if (r15 >= r16) goto L25;
        float r17 = (r13.offset + r13.widthFactor) + r14;
        int r18 = r15 + 1;
        int r19 = 0;
    L12:
        if (r18 > r11.position) goto L39;
        if (r19 >= this.mItems.size()) goto L39;
        ItemInfo r20 = this.mItems.get(r19);
    L16:
        ItemInfo r21 = r20;
        if (r18 <= r21.position) goto L22;
        if (r19 >= (this.mItems.size() - 1)) goto L22;
        r19 = r19 + 1;
        r20 = this.mItems.get(r19);
    L22:
        if (r18 >= r21.position) goto L24;
        r17 = r17 + (this.mAdapter.getPageWidth(r18) + r14);
        r18 = r18 + 1;
        goto L22
    L24:
        r21.offset = r17;
        r17 = r17 + (r21.widthFactor + r14);
        r18 = r18 + 1;
        goto L12
    L25:
        if (r15 <= r16) goto L39;
        int r22 = this.mItems.size() - 1;
        float r110 = r13.offset;
    L27:
        r15 = r15 - 1;
        if (r15 < r11.position) goto L39;
        if (r22 < 0) goto L39;
        ItemInfo r23 = this.mItems.get(r22);
    L31:
        ItemInfo r24 = r23;
        if (r15 >= r24.position) goto L36;
        if (r22 <= 0) goto L36;
        r22 = r22 - 1;
        r23 = this.mItems.get(r22);
    L36:
        if (r15 <= r24.position) goto L38;
        r110 = r110 - (this.mAdapter.getPageWidth(r15) + r14);
        r15 = r15 - 1;
        goto L36
    L38:
        r110 = r110 - (r24.widthFactor + r14);
        r24.offset = r110;
    L39:
        int r111 = this.mItems.size();
        float r25 = r11.offset;
        int r26 = r11.position;
        int r27 = r26 - 1;
        if (r26 != 0) goto L42;
        float r28 = r25;
    L43:
        this.mFirstOffset = r28;
        int r29 = r5 - 1;
        if (r26 != r29) goto L46;
        float r30 = (r11.widthFactor + r25) - 1.0f;
    L47:
        this.mLastOffset = r30;
        int r31 = r12 - 1;
    L48:
        if (r31 < 0) goto L57;
        ItemInfo r32 = this.mItems.get(r31);
    L50:
        int r33 = r32.position;
        if (r27 <= r33) goto L53;
        r25 = r25 - (this.mAdapter.getPageWidth(r27) + r14);
        r27 = r27 - 1;
        goto L50
    L53:
        r25 = r25 - (r32.widthFactor + r14);
        r32.offset = r25;
        if (r33 != 0) goto L56;
        this.mFirstOffset = r25;
    L56:
        r31 = r31 - 1;
        r27 = r27 - 1;
        goto L48
    L57:
        float r34 = (r11.offset + r11.widthFactor) + r14;
        int r112 = r11.position + 1;
        int r113 = r12 + 1;
    L58:
        if (r113 >= r111) goto L66;
        ItemInfo r35 = this.mItems.get(r113);
    L60:
        int r36 = r35.position;
        if (r112 >= r36) goto L63;
        r34 = r34 + (this.mAdapter.getPageWidth(r112) + r14);
        r112 = r112 + 1;
        goto L60
    L63:
        if (r36 != r29) goto L65;
        this.mLastOffset = (r35.widthFactor + r34) - 1.0f;
    L65:
        r35.offset = r34;
        r34 = r34 + (r35.widthFactor + r14);
        r113 = r113 + 1;
        r112 = r112 + 1;
        goto L58
    L66:
        this.mNeedCalculatePageOffsets = false;
        return;
    L46:
        r30 = Float.MAX_VALUE;
        goto L47
    L42:
        r28 = -3.4028235E38f;
        goto L43
    L5:
        r14 = 0.0f;
        goto L7
    }

    private void completeScroll(boolean r10) {
        if (this.mScrollState != 2) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L15;
        setScrollingCacheEnabled(false);
        if (this.mScroller.isFinished() == true) goto L15;
        this.mScroller.abortAnimation();
        int r11 = getScrollX();
        int r12 = getScrollY();
        int r13 = this.mScroller.getCurrX();
        int r14 = this.mScroller.getCurrY();
        if (r11 != r13) goto L12;
        if (r12 == r14) goto L15;
    L12:
        scrollTo(r13, r14);
        if (r13 == r11) goto L15;
        pageScrolled(r13);
    L15:
        this.mPopulatePending = false;
        int r15 = 0;
    L17:
        if (r15 >= this.mItems.size()) goto L22;
        ItemInfo r16 = this.mItems.get(r15);
        if (r16.scrolling == false) goto L21;
        r16.scrolling = false;
        r5 = true;
    L21:
        r15 = r15 + 1;
        goto L17
    L22:
        if (r5 == false) goto L30;
        if (r10 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        return;
    L25:
        this.mEndScrollRunnable.run();
        return;
    L30:
        return;
    L5:
        r5 = false;
        goto L6
    }

    private int determineTargetPage(int r5, float r10, int r11, int r12) {
        if (Math.abs(r12) <= this.mFlingDistance) goto L10;
        if (Math.abs(r11) <= this.mMinimumVelocity) goto L10;
        if (r11 > 0) goto L15;
        r5 = r5 + 1;
    L15:
        if (this.mItems.size() <= 0) goto L18;
        ItemInfo r13 = this.mItems.get(0);
        ItemInfo r14 = (ItemInfo) a.h(this.mItems, 1);
        return Math.max(r13.position, Math.min(r5, r14.position));
    L18:
        return r5;
    L10:
        if (r5 < this.mCurItem) goto L12;
        float r15 = 0.4f;
    L13:
        r5 = r5 + ((int) (r10 + r15));
        goto L15
    L12:
        r15 = 0.6f;
        goto L13
    }

    private void dispatchOnPageScrolled(int r5, float r10, int r11) {
        OnPageChangeListener r12 = this.mOnPageChangeListener;
        if (r12 == null) goto L5;
        r12.onPageScrolled(r5, r10, r11);
    L5:
        List<OnPageChangeListener> r13 = this.mOnPageChangeListeners;
        if (r13 == null) goto L13;
        int r14 = r13.size();
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L13;
        OnPageChangeListener r16 = this.mOnPageChangeListeners.get(r15);
        if (r16 == null) goto L12;
        r16.onPageScrolled(r5, r10, r11);
    L12:
        r15 = r15 + 1;
    L13:
        OnPageChangeListener r17 = this.mInternalPageChangeListener;
        if (r17 == null) goto L20;
        r17.onPageScrolled(r5, r10, r11);
        return;
    }

    private void dispatchOnPageSelected(int r5) {
        OnPageChangeListener r10 = this.mOnPageChangeListener;
        if (r10 == null) goto L5;
        r10.onPageSelected(r5);
    L5:
        List<OnPageChangeListener> r11 = this.mOnPageChangeListeners;
        if (r11 == null) goto L13;
        int r12 = r11.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        OnPageChangeListener r14 = this.mOnPageChangeListeners.get(r13);
        if (r14 == null) goto L12;
        r14.onPageSelected(r5);
    L12:
        r13 = r13 + 1;
    L13:
        OnPageChangeListener r15 = this.mInternalPageChangeListener;
        if (r15 == null) goto L20;
        r15.onPageSelected(r5);
        return;
    }

    private void dispatchOnScrollStateChanged(int r5) {
        OnPageChangeListener r10 = this.mOnPageChangeListener;
        if (r10 == null) goto L5;
        r10.onPageScrollStateChanged(r5);
    L5:
        List<OnPageChangeListener> r11 = this.mOnPageChangeListeners;
        if (r11 == null) goto L13;
        int r12 = r11.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        OnPageChangeListener r14 = this.mOnPageChangeListeners.get(r13);
        if (r14 == null) goto L12;
        r14.onPageScrollStateChanged(r5);
    L12:
        r13 = r13 + 1;
    L13:
        OnPageChangeListener r15 = this.mInternalPageChangeListener;
        if (r15 == null) goto L20;
        r15.onPageScrollStateChanged(r5);
        return;
    }

    private void enableLayers(boolean r10) {
        int r5 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L8;
        if (r10 == false) goto L6;
        int r12 = this.mPageTransformerLayerType;
    L7:
        getChildAt(r11).setLayerType(r12, null);
        r11 = r11 + 1;
        goto L3
    L6:
        r12 = 0;
        goto L7
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 == null) goto L6;
        r5.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private Rect getChildRectInPagerCoordinates(Rect r5, View r10) {
        if (r5 != null) goto L4;
        r5 = new Rect();
    L4:
        if (r10 != null) goto L7;
        r5.set(0, 0, 0, 0);
        return r5;
    L7:
        r5.left = r10.getLeft();
        r5.right = r10.getRight();
        r5.top = r10.getTop();
        r5.bottom = r10.getBottom();
        ViewParent r11 = r10.getParent();
    L9:
        if ((r11 instanceof ViewGroup) == false) goto L12;
        if (r11 == this) goto L12;
        ViewGroup r12 = (ViewGroup) r11;
        int r13 = r5.left;
        r5.left = r12.getLeft() + r13;
        int r14 = r5.right;
        r5.right = r12.getRight() + r14;
        int r15 = r5.top;
        r5.top = r12.getTop() + r15;
        int r16 = r5.bottom;
        r5.bottom = r12.getBottom() + r16;
        r11 = r12.getParent();
    L12:
        return r5;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int r5 = getClientWidth();
        float r10 = 0.0f;
        if (r5 <= 0) goto L5;
        float r11 = getScrollX() / r5;
    L6:
        if (r5 <= 0) goto L8;
        float r12 = this.mPageMargin / r5;
    L9:
        int r13 = 0;
        boolean r14 = true;
        ItemInfo r15 = null;
        int r16 = -1;
        float r17 = 0.0f;
    L11:
        if (r13 >= this.mItems.size()) goto L30;
        ItemInfo r18 = this.mItems.get(r13);
        if (r14 == true) goto L17;
        int r19 = r16 + 1;
        if (r18.position == r19) goto L17;
        r18 = this.mTempItem;
        r18.offset = (r10 + r17) + r12;
        r18.position = r19;
        r18.widthFactor = this.mAdapter.getPageWidth(r19);
        r13 = r13 - 1;
    L17:
        ItemInfo r20 = r18;
        r10 = r20.offset;
        float r21 = (r20.widthFactor + r10) + r12;
        if (r14 == true) goto L24;
        if (r11 >= r10) goto L24;
        return r15;
    L24:
        if (r11 < r21) goto L29;
        if (r13 == (this.mItems.size() - 1)) goto L29;
        int r22 = r20.position;
        float r23 = r20.widthFactor;
        r13 = r13 + 1;
        r14 = false;
        r16 = r22;
        r17 = r23;
        r15 = r20;
    L29:
        return r20;
    L30:
        return r15;
    L8:
        r12 = 0.0f;
        goto L9
    L5:
        r11 = 0.0f;
        goto L6
    }

    private static boolean isDecorView(@NonNull View r5) {
        if (r5.getClass().getAnnotation(DecorView.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isGutterDrag(float r5, float r10) {
        if (r5 >= this.mGutterSize) goto L7;
        if (r10 <= 0.0f) goto L7;
    L10:
        return true;
    L7:
        if (r5 > (getWidth() - this.mGutterSize)) goto L9;
    L11:
        return false;
    L9:
        if (r10 >= 0.0f) goto L11;
        goto L10
    }

    private void onSecondaryPointerUp(MotionEvent r5) {
        int r10 = r5.getActionIndex();
        if (r5.getPointerId(r10) != this.mActivePointerId) goto L11;
        if (r10 != 0) goto L6;
        int r11 = 1;
    L7:
        this.mLastMotionX = r5.getX(r11);
        this.mActivePointerId = r5.getPointerId(r11);
        VelocityTracker r12 = this.mVelocityTracker;
        if (r12 == null) goto L12;
        r12.clear();
        return;
    L12:
        return;
    L6:
        r11 = 0;
        goto L7
    }

    private boolean pageScrolled(int r10) {
        if (this.mItems.size() == 0) goto L5;
        ItemInfo r5 = infoForCurrentScrollPosition();
        int r11 = getClientWidth();
        int r12 = this.mPageMargin;
        int r13 = r11 + r12;
        float r14 = r11;
        int r15 = r5.position;
        float r16 = ((r10 / r14) - r5.offset) / (r5.widthFactor + (r12 / r14));
        this.mCalledSuper = false;
        onPageScrolled(r15, r16, (int) (r13 * r16));
        if (this.mCalledSuper == false) goto L17;
        return true;
    L17:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.mFirstLayout == false) goto L7;
        return false;
    L7:
        this.mCalledSuper = false;
        onPageScrolled(0, 0.0f, 0);
        if (this.mCalledSuper == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float r10) {
        float r5 = this.mLastMotionX - r10;
        this.mLastMotionX = r10;
        float r11 = getScrollX() + r5;
        float r12 = getClientWidth();
        float r13 = this.mFirstOffset * r12;
        float r14 = this.mLastOffset * r12;
        boolean r15 = false;
        ItemInfo r16 = this.mItems.get(0);
        ItemInfo r17 = (ItemInfo) a.h(this.mItems, 1);
        if (r16.position == 0) goto L5;
        r13 = r16.offset * r12;
        boolean r18 = false;
    L7:
        if (r17.position == (this.mAdapter.getCount() - 1)) goto L9;
        r14 = r17.offset * r12;
        boolean r19 = false;
    L11:
        if (r11 >= r13) goto L16;
        if (r18 == false) goto L14;
        this.mLeftEdge.onPull(Math.abs(r13 - r11) / r12);
        r15 = true;
    L14:
        r11 = r13;
    L20:
        int r20 = (int) r11;
        this.mLastMotionX = (r11 - r20) + this.mLastMotionX;
        scrollTo(r20, getScrollY());
        pageScrolled(r20);
        return r15;
    L16:
        if (r11 <= r14) goto L20;
        if (r19 == false) goto L19;
        this.mRightEdge.onPull(Math.abs(r11 - r14) / r12);
        r15 = true;
    L19:
        r11 = r14;
        goto L20
    L9:
        r19 = true;
        goto L11
    L5:
        r18 = true;
        goto L7
    }

    private void recomputeScrollPosition(int r5, int r10, int r11, int r12) {
        if (r10 > 0) goto L4;
    L9:
        ItemInfo r13 = infoForPosition(this.mCurItem);
        if (r13 == null) goto L12;
        float r14 = Math.min(r13.offset, this.mLastOffset);
    L13:
        int r15 = (int) (r14 * ((r5 - getPaddingLeft()) - getPaddingRight()));
        if (r15 == getScrollX()) goto L19;
        completeScroll(false);
        scrollTo(r15, getScrollY());
        return;
    L19:
        return;
    L12:
        r14 = 0.0f;
        goto L13
    L4:
        if (this.mItems.isEmpty() == true) goto L9;
        if (this.mScroller.isFinished() == true) goto L8;
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r10 - getPaddingLeft()) - getPaddingRight()) + r12)) * (((r5 - getPaddingLeft()) - getPaddingRight()) + r11)), getScrollY());
    }

    private void removeNonDecorViews() {
        int r5 = 0;
    L4:
        if (r5 >= getChildCount()) goto L9;
        if (((LayoutParams) getChildAt(r5).getLayoutParams()).isDecor == true) goto L8;
        removeViewAt(r5);
        r5 = r5 - 1;
    L8:
        r5 = r5 + 1;
        goto L4
    }

    private void requestParentDisallowInterceptTouchEvent(boolean r5) {
        ViewParent r10 = getParent();
        if (r10 == null) goto L6;
        r10.requestDisallowInterceptTouchEvent(r5);
        return;
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (this.mLeftEdge.isFinished() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mRightEdge.isFinished() == true) goto L8;
        return false;
    }

    private void scrollToItem(int r10, boolean r11, int r12, boolean r13) {
        ItemInfo r5 = infoForPosition(r10);
        if (r5 == null) goto L5;
        int r14 = (int) (Math.max(this.mFirstOffset, Math.min(r5.offset, this.mLastOffset)) * getClientWidth());
    L6:
        if (r11 == false) goto L10;
        smoothScrollTo(r14, 0, r12);
        if (r13 == false) goto L14;
        dispatchOnPageSelected(r10);
        return;
    L14:
        return;
    L10:
        if (r13 == false) goto L12;
        dispatchOnPageSelected(r10);
    L12:
        completeScroll(false);
        scrollTo(r14, 0);
        pageScrolled(r14);
        return;
    L5:
        r14 = 0;
        goto L6
    }

    private void setScrollingCacheEnabled(boolean r5) {
        if (this.mScrollingCacheEnabled == r5) goto L6;
        this.mScrollingCacheEnabled = r5;
        return;
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder == 0) goto L14;
        ArrayList<View> r5 = this.mDrawingOrderedChildren;
        if (r5 != null) goto L7;
        this.mDrawingOrderedChildren = new ArrayList();
    L8:
        int r10 = getChildCount();
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L11;
        View r12 = getChildAt(r11);
        this.mDrawingOrderedChildren.add(r12);
        r11 = r11 + 1;
        goto L9
    L11:
        Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        return;
    L7:
        r5.clear();
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r10, int r11, int r12) {
        int r5 = r10.size();
        int r13 = getDescendantFocusability();
        if (r13 == 393216) goto L16;
        int r14 = 0;
    L6:
        if (r14 >= getChildCount()) goto L16;
        View r15 = getChildAt(r14);
        if (r15.getVisibility() != 0) goto L14;
        ItemInfo r16 = infoForChild(r15);
        if (r16 == null) goto L14;
        if (r16.position != this.mCurItem) goto L14;
        r15.addFocusables(r10, r11, r12);
    L14:
        r14 = r14 + 1;
    L16:
        if (r13 != 262144) goto L20;
        if (r5 == r10.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r12 & 1) == 1) goto L25;
    L29:
        r10.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    public ItemInfo addNewItem(int r5, int r10) {
        ItemInfo r11 = new ItemInfo();
        r11.position = r5;
        r11.object = this.mAdapter.instantiateItem(this, r5);
        r11.widthFactor = this.mAdapter.getPageWidth(r5);
        if (r10 >= 0) goto L5;
    L8:
        this.mItems.add(r11);
    L9:
        return r11;
    L5:
        if (r10 >= this.mItems.size()) goto L8;
        this.mItems.add(r10, r11);
        goto L9
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener r5) {
        if (this.mAdapterChangeListeners != null) goto L5;
        this.mAdapterChangeListeners = new ArrayList();
    L5:
        this.mAdapterChangeListeners.add(r5);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener r5) {
        if (this.mOnPageChangeListeners != null) goto L5;
        this.mOnPageChangeListeners = new ArrayList();
    L5:
        this.mOnPageChangeListeners.add(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> r5) {
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L13;
        View r11 = getChildAt(r10);
        if (r11.getVisibility() != 0) goto L12;
        ItemInfo r12 = infoForChild(r11);
        if (r12 == null) goto L12;
        if (r12.position != this.mCurItem) goto L12;
        r11.addTouchables(r5);
    L12:
        r10 = r10 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        if (checkLayoutParams(r11) == true) goto L5;
        r11 = generateLayoutParams(r11);
    L5:
        LayoutParams r12 = (LayoutParams) r11;
        boolean r13 = r12.isDecor | isDecorView(r5);
        r12.isDecor = r13;
        if (this.mInLayout == false) goto L11;
        if (r13 == true) goto L10;
        r12.needsMeasure = true;
        addViewInLayout(r5, r10, r11);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r5, r10, r11);
    }

    public boolean arrowScroll(int r5) {
        View r10 = findFocus();
        if (r10 != this) goto L5;
    L4:
        r10 = null;
    L17:
        View r11 = FocusFinder.getInstance().findNextFocus(this, r10, r5);
        if (r11 == null) goto L32;
        if (r11 == r10) goto L32;
        if (r5 != 17) goto L26;
        int r12 = getChildRectInPagerCoordinates(this.mTempRect, r11).left;
        int r13 = getChildRectInPagerCoordinates(this.mTempRect, r10).left;
        if (r10 == null) goto L25;
        if (r12 < r13) goto L25;
        boolean r14 = pageLeft();
    L43:
        if (r14 == false) goto L45;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r5));
    L45:
        return r14;
    L25:
        r14 = r11.requestFocus();
        goto L43
    L26:
        if (r5 != 66) goto L40;
        int r15 = getChildRectInPagerCoordinates(this.mTempRect, r11).left;
        int r16 = getChildRectInPagerCoordinates(this.mTempRect, r10).left;
        if (r10 == null) goto L31;
        if (r15 > r16) goto L31;
        r14 = pageRight();
    L31:
        r14 = r11.requestFocus();
    L40:
        r14 = false;
    L32:
        if (r5 != 17) goto L34;
    L42:
        r14 = pageLeft();
        goto L43
    L34:
        if (r5 == 1) goto L42;
        if (r5 != 66) goto L38;
    L41:
        r14 = pageRight();
        goto L43
    L38:
        if (r5 != 2) goto L40;
    L5:
        if (r10 == null) goto L17;
        ViewParent r17 = r10.getParent();
    L8:
        if ((r17 instanceof ViewGroup) == false) goto L12;
        if (r17 == this) goto L17;
        r17 = r17.getParent();
        goto L8
    L12:
        StringBuilder r18 = new StringBuilder();
        r18.append(r10.getClass().getSimpleName());
        ViewParent r19 = r10.getParent();
    L14:
        if ((r19 instanceof ViewGroup) == false) goto L16;
        r18.append(" => ");
        r18.append(r19.getClass().getSimpleName());
        r19 = r19.getParent();
        goto L14
    L16:
        Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + r18.toString());
        goto L4
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged == false) goto L6;
        return false;
    L6:
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 != null) goto L9;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r11 = MotionEvent.obtain(r10, r10, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(r11);
        r11.recycle();
        this.mFakeDragBeginTime = r10;
        return true;
    L9:
        r5.clear();
        goto L10
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
    L22:
        return false;
    L20:
        if (r13.canScrollHorizontally(-r15) == false) goto L22;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r5) {
        if (this.mAdapter != null) goto L5;
        return false;
    L5:
        int r10 = getClientWidth();
        int r11 = getScrollX();
        if (r5 < 0) goto L8;
        if (r5 > 0) goto L13;
        return false;
    L13:
        if (r11 < ((int) (r10 * this.mLastOffset))) goto L15;
        return false;
    L15:
        return true;
    L8:
        if (r11 > ((int) (r10 * this.mFirstOffset))) goto L10;
        return false;
    L10:
        return true;
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

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> r5 = this.mOnPageChangeListeners;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() == false) goto L5;
    L14:
        completeScroll(true);
        return;
    L5:
        if (this.mScroller.computeScrollOffset() == false) goto L14;
        int r5 = getScrollX();
        int r10 = getScrollY();
        int r11 = this.mScroller.getCurrX();
        int r12 = this.mScroller.getCurrY();
        if (r5 != r11) goto L9;
        if (r10 != r12) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r11, r12);
        if (pageScrolled(r11) == true) goto L12;
        this.mScroller.abortAnimation();
        scrollTo(0, r12);
        goto L12
    }

    public void dataSetChanged() {
        int r5 = this.mAdapter.getCount();
        this.mExpectedAdapterCount = r5;
        if (this.mItems.size() < ((this.mOffscreenPageLimit * 2) + 1)) goto L5;
    L7:
        boolean r10 = false;
    L8:
        int r11 = this.mCurItem;
        int r12 = 0;
        boolean r13 = false;
    L10:
        if (r12 >= this.mItems.size()) goto L30;
        ItemInfo r14 = this.mItems.get(r12);
        int r15 = this.mAdapter.getItemPosition(r14.object);
        if (r15 == (-1)) goto L29;
        if (r15 != (-2)) goto L23;
        this.mItems.remove(r12);
        r12 = r12 - 1;
        if (r13 == true) goto L19;
        this.mAdapter.startUpdate(this);
        r13 = true;
    L19:
        this.mAdapter.destroyItem(this, r14.position, r14.object);
        int r16 = this.mCurItem;
        if (r16 != r14.position) goto L22;
        r11 = Math.max(0, Math.min(r16, r5 - 1));
    L22:
        r10 = true;
        goto L29
    L23:
        int r17 = r14.position;
        if (r17 == r15) goto L29;
        if (r17 != this.mCurItem) goto L28;
        r11 = r15;
    L28:
        r14.position = r15;
    L29:
        r12 = r12 + 1;
        goto L10
    L30:
        if (r13 == false) goto L32;
        this.mAdapter.finishUpdate(this);
    L32:
        Collections.sort(this.mItems, COMPARATOR);
        if (r10 == false) goto L49;
        int r18 = getChildCount();
        int r19 = 0;
    L35:
        if (r19 >= r18) goto L40;
        LayoutParams r20 = (LayoutParams) getChildAt(r19).getLayoutParams();
        if (r20.isDecor == true) goto L39;
        r20.widthFactor = 0.0f;
    L39:
        r19 = r19 + 1;
        goto L35
    L40:
        setCurrentItemInternal(r11, false, true);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.mItems.size() >= r5) goto L7;
        r10 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r5) {
        if (super.dispatchKeyEvent(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r5) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        if (r10.getEventType() == 4096) goto L5;
        int r5 = getChildCount();
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L19;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() != 0) goto L18;
        ItemInfo r13 = infoForChild(r12);
        if (r13 == null) goto L18;
        if (r13.position != this.mCurItem) goto L18;
        if (r12.dispatchPopulateAccessibilityEvent(r10) == false) goto L18;
        return true;
    L18:
        r11 = r11 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r10);
    }

    public float distanceInfluenceForSnapDuration(float r5) {
        return (float) Math.sin((r5 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        int r5 = getOverScrollMode();
        boolean r11 = false;
        if (r5 == 0) goto L13;
        if (r5 != 1) goto L11;
        PagerAdapter r12 = this.mAdapter;
        if (r12 == null) goto L11;
        if (r12.getCount() > 1) goto L13;
    L11:
        this.mLeftEdge.finish();
        this.mRightEdge.finish();
    L18:
        if (r11 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.mLeftEdge.isFinished() == true) goto L16;
        int r13 = r10.save();
        int r14 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r15 = getWidth();
        r10.rotate(270.0f);
        r10.translate(getPaddingTop() + (-r14), this.mFirstOffset * r15);
        this.mLeftEdge.setSize(r14, r15);
        r11 = this.mLeftEdge.draw(r10);
        r10.restoreToCount(r13);
    L16:
        if (this.mRightEdge.isFinished() == true) goto L18;
        int r16 = r10.save();
        int r17 = getWidth();
        int r18 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r10.rotate(90.0f);
        r10.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * r17);
        this.mRightEdge.setSize(r18, r17);
        r11 = r11 | this.mRightEdge.draw(r10);
        r10.restoreToCount(r16);
        goto L18
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r5 = this.mMarginDrawable;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isStateful() == false) goto L9;
        r5.setState(getDrawableState());
        return;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging == false) goto L10;
        if (this.mAdapter == null) goto L7;
        VelocityTracker r5 = this.mVelocityTracker;
        r5.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r10 = (int) r5.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r11 = getClientWidth();
        int r12 = getScrollX();
        ItemInfo r13 = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(r13.position, ((r12 / r11) - r13.offset) / r13.widthFactor, r10, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, r10);
    L7:
        endDrag();
        this.mFakeDragging = false;
        return;
    L10:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent r5) {
        if (r5.getAction() != 0) goto L25;
        int r10 = r5.getKeyCode();
        if (r10 == 21) goto L22;
        if (r10 == 22) goto L18;
        if (r10 != 61) goto L25;
        if (r5.hasNoModifiers() == false) goto L15;
        return arrowScroll(2);
    L15:
        if (r5.hasModifiers(1) == false) goto L25;
        return arrowScroll(1);
    L18:
        if (r5.hasModifiers(2) == false) goto L30;
        return pageRight();
    L30:
        return arrowScroll(66);
    L22:
        if (r5.hasModifiers(2) == false) goto L32;
        return pageLeft();
    L32:
        return arrowScroll(17);
    L25:
        return false;
    }

    public void fakeDragBy(float r11) {
        if (this.mFakeDragging == false) goto L22;
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        this.mLastMotionX += r11;
        float r5 = getScrollX() - r11;
        float r12 = getClientWidth();
        float r10 = this.mFirstOffset * r12;
        float r13 = this.mLastOffset * r12;
        ItemInfo r14 = this.mItems.get(0);
        ItemInfo r15 = (ItemInfo) a.h(this.mItems, 1);
        if (r14.position == 0) goto L11;
        r10 = r14.offset * r12;
    L11:
        if (r15.position == (this.mAdapter.getCount() - 1)) goto L14;
        r13 = r15.offset * r12;
    L14:
        if (r5 >= r10) goto L17;
        r5 = r10;
    L19:
        int r16 = (int) r5;
        this.mLastMotionX = (r5 - r16) + this.mLastMotionX;
        scrollTo(r16, getScrollY());
        pageScrolled(r16);
        MotionEvent r17 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(r17);
        r17.recycle();
        return;
    L17:
        if (r5 <= r13) goto L19;
        r5 = r13;
        goto L19
    L22:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r5, int r10) {
        if (this.mDrawingOrder != 2) goto L6;
        r10 = (r5 - 1) - r10;
    L6:
        return ((LayoutParams) this.mDrawingOrderedChildren.get(r10).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public ItemInfo infoForAnyChild(View r5) {
    L2:
        Object r10 = r5.getParent();
        if (r10 == this) goto L12;
        if (r10 == null) goto L9;
        if ((r10 instanceof View) == false) goto L16;
        r5 = (View) r10;
        goto L2
    L16:
        return null;
    L9:
        return null;
    L12:
        return infoForChild(r5);
    }

    public ItemInfo infoForChild(View r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mItems.size()) goto L9;
        ItemInfo r11 = this.mItems.get(r10);
        if (this.mAdapter.isViewFromObject(r5, r11.object) == true) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return null;
    }

    public ItemInfo infoForPosition(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mItems.size()) goto L9;
        ItemInfo r11 = this.mItems.get(r10);
        if (r11.position == r5) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return null;
    }

    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r5 = getContext();
        this.mScroller = new Scroller(r5, sInterpolator);
        ViewConfiguration r10 = ViewConfiguration.get(r5);
        float r11 = r5.getResources().getDisplayMetrics().density;
        this.mTouchSlop = r10.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * r11);
        this.mMaximumVelocity = r10.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(r5);
        this.mRightEdge = new EdgeEffect(r5);
        this.mFlingDistance = (int) (25.0f * r11);
        this.mCloseEnough = (int) (2.0f * r11);
        this.mDefaultGutterSize = (int) (r11 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass4(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller r5 = this.mScroller;
        if (r5 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r5.isFinished() == true) goto L7;
        this.mScroller.abortAnimation();
        goto L7
    }

    @Override // android.view.View
    public void onDraw(Canvas r18) {
        super.onDraw(r18);
        if (this.mPageMargin > 0) goto L5;
        return;
    L5:
        if (this.mMarginDrawable != null) goto L7;
        return;
    L7:
        if (this.mItems.size() > 0) goto L9;
        return;
    L9:
        if (this.mAdapter == null) goto L34;
        int r5 = getScrollX();
        int r10 = getWidth();
        float r11 = r10;
        float r12 = this.mPageMargin / r11;
        int r13 = 0;
        ItemInfo r14 = this.mItems.get(0);
        float r15 = r14.offset;
        int r16 = this.mItems.size();
        int r17 = r14.position;
        int r19 = this.mItems.get(r16 - 1).position;
    L11:
        if (r17 >= r19) goto L35;
    L12:
        int r110 = r14.position;
        if (r17 <= r110) goto L16;
        if (r13 >= r16) goto L16;
        r13 = r13 + 1;
        r14 = this.mItems.get(r13);
    L16:
        if (r17 != r110) goto L18;
        float r20 = r14.offset;
        float r111 = r14.widthFactor;
        float r112 = (r20 + r111) * r11;
        r15 = (r20 + r111) + r12;
    L20:
        if ((this.mPageMargin + r112) <= r5) goto L24;
        this.mMarginDrawable.setBounds(Math.round(r112), this.mTopPageBounds, Math.round(this.mPageMargin + r112), this.mBottomPageBounds);
        this.mMarginDrawable.draw(r18);
    L24:
        if (r112 > (r5 + r10)) goto L36;
        r17 = r17 + 1;
        r12 = r12;
        goto L11
    L36:
        return;
    L18:
        float r113 = this.mAdapter.getPageWidth(r17);
        r112 = (r15 + r113) * r11;
        r15 = (r113 + r12) + r15;
        goto L20
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r16) {
        int r5 = r16.getAction() & 255;
        if (r5 != 3) goto L5;
    L60:
        resetTouch();
        return false;
    L5:
        if (r5 == 1) goto L60;
        if (r5 == 0) goto L15;
        if (this.mIsBeingDragged == false) goto L12;
        return true;
    L12:
        if (this.mIsUnableToDrag == false) goto L15;
        return false;
    L15:
        if (r5 == 0) goto L49;
        if (r5 != 2) goto L18;
        int r10 = this.mActivePointerId;
        if (r10 == (-1)) goto L56;
        int r11 = r16.findPointerIndex(r10);
        float r12 = r16.getX(r11);
        float r13 = r12 - this.mLastMotionX;
        float r14 = Math.abs(r13);
        float r15 = r16.getY(r11);
        float r17 = Math.abs(r15 - this.mInitialMotionY);
        if (r13 != 0.0f) goto L27;
    L32:
        int r18 = this.mTouchSlop;
        if (r14 <= r18) goto L42;
        if ((r14 * 0.5f) <= r17) goto L42;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        float r19 = this.mInitialMotionX;
        float r20 = this.mTouchSlop;
        if (r13 <= 0.0f) goto L39;
        float r21 = r19 + r20;
    L40:
        this.mLastMotionX = r21;
        this.mLastMotionY = r15;
        setScrollingCacheEnabled(true);
    L45:
        if (this.mIsBeingDragged == false) goto L56;
        if (performDrag(r12) == false) goto L56;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L56
    L39:
        r21 = r19 - r20;
    L42:
        if (r17 <= r18) goto L45;
        this.mIsUnableToDrag = true;
        goto L45
    L27:
        if (isGutterDrag(this.mLastMotionX, r13) == true) goto L32;
        if (canScroll(this, false, (int) r13, (int) r12, (int) r15) == false) goto L32;
        this.mLastMotionX = r12;
        this.mLastMotionY = r15;
        this.mIsUnableToDrag = true;
        return false;
    L56:
        if (this.mVelocityTracker != null) goto L58;
        this.mVelocityTracker = VelocityTracker.obtain();
    L58:
        this.mVelocityTracker.addMovement(r16);
        return this.mIsBeingDragged;
    L18:
        if (r5 != 6) goto L56;
        onSecondaryPointerUp(r16);
        goto L56
    L49:
        float r22 = r16.getX();
        this.mInitialMotionX = r22;
        this.mLastMotionX = r22;
        float r23 = r16.getY();
        this.mInitialMotionY = r23;
        this.mLastMotionY = r23;
        this.mActivePointerId = r16.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mIsScrollStarted = true;
        this.mScroller.computeScrollOffset();
        if (this.mScrollState == 2) goto L52;
    L54:
        completeScroll(false);
        this.mIsBeingDragged = false;
        goto L56
    L52:
        if (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) goto L54;
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        goto L56
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        int r5 = getChildCount();
        int r10 = r22 - r20;
        int r11 = r23 - r21;
        int r12 = getPaddingLeft();
        int r13 = getPaddingTop();
        int r14 = getPaddingRight();
        int r15 = getPaddingBottom();
        int r16 = getScrollX();
        int r17 = 0;
        int r18 = 0;
    L4:
        if (r17 >= r5) goto L33;
        View r110 = getChildAt(r17);
        if (r110.getVisibility() == 8) goto L32;
        LayoutParams r111 = (LayoutParams) r110.getLayoutParams();
        if (r111.isDecor == false) goto L32;
        int r112 = r111.gravity;
        int r113 = r112 & 7;
        int r114 = r112 & 112;
        if (r113 != 1) goto L12;
        int r115 = Math.max((r10 - r110.getMeasuredWidth()) / 2, r12);
    L17:
        int r116 = r115;
        int r117 = r12;
        r12 = r116;
    L21:
        if (r114 != 16) goto L23;
        int r118 = Math.max((r11 - r110.getMeasuredHeight()) / 2, r13);
    L28:
        int r119 = r118;
        int r120 = r13;
        r13 = r119;
    L31:
        int r24 = r12 + r16;
        r110.layout(r24, r13, r110.getMeasuredWidth() + r24, r110.getMeasuredHeight() + r13);
        r18 = r18 + 1;
        r13 = r120;
        r12 = r117;
        goto L32
    L23:
        if (r114 != 48) goto L25;
        r120 = r110.getMeasuredHeight() + r13;
        goto L31
    L25:
        if (r114 == 80) goto L27;
        r120 = r13;
        goto L31
    L27:
        r118 = (r11 - r15) - r110.getMeasuredHeight();
        r15 = r15 + r110.getMeasuredHeight();
        goto L28
    L12:
        if (r113 != 3) goto L14;
        r117 = r110.getMeasuredWidth() + r12;
        goto L21
    L14:
        if (r113 == 5) goto L16;
        r117 = r12;
        goto L21
    L16:
        r115 = (r10 - r14) - r110.getMeasuredWidth();
        r14 = r14 + r110.getMeasuredWidth();
    L32:
        r17 = r17 + 1;
        goto L4
    L33:
        int r25 = (r10 - r12) - r14;
        int r26 = 0;
    L34:
        if (r26 >= r5) goto L46;
        View r27 = getChildAt(r26);
        if (r27.getVisibility() == 8) goto L45;
        LayoutParams r28 = (LayoutParams) r27.getLayoutParams();
        if (r28.isDecor == true) goto L45;
        ItemInfo r121 = infoForChild(r27);
        if (r121 == null) goto L45;
        float r122 = r25;
        int r123 = ((int) (r121.offset * r122)) + r12;
        if (r28.needsMeasure == false) goto L44;
        r28.needsMeasure = false;
        r27.measure(View.MeasureSpec.makeMeasureSpec((int) (r122 * r28.widthFactor), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((r11 - r13) - r15, BasicMeasure.EXACTLY));
    L44:
        r27.layout(r123, r13, r27.getMeasuredWidth() + r123, r27.getMeasuredHeight() + r13);
    L45:
        r26 = r26 + 1;
        goto L34
    L46:
        this.mTopPageBounds = r13;
        this.mBottomPageBounds = r11 - r15;
        this.mDecorChildCount = r18;
        if (this.mFirstLayout == false) goto L49;
        boolean r29 = false;
        scrollToItem(this.mCurItem, false, 0, false);
    L50:
        this.mFirstLayout = r29;
        return;
    L49:
        r29 = false;
        goto L50
    }

    @Override // android.view.View
    public void onMeasure(int r14, int r15) {
        int r5 = 0;
        setMeasuredDimension(View.getDefaultSize(0, r14), View.getDefaultSize(0, r15));
        int r16 = getMeasuredWidth();
        this.mGutterSize = Math.min(r16 / 10, this.mDefaultGutterSize);
        int r17 = (r16 - getPaddingLeft()) - getPaddingRight();
        int r18 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        boolean r12 = true;
        int r13 = BasicMeasure.EXACTLY;
        if (r11 >= r10) goto L48;
        View r19 = getChildAt(r11);
        if (r19.getVisibility() == 8) goto L47;
        LayoutParams r20 = (LayoutParams) r19.getLayoutParams();
        if (r20 == null) goto L47;
        if (r20.isDecor == false) goto L47;
        int r21 = r20.gravity;
        int r22 = r21 & 7;
        int r23 = r21 & 112;
        if (r23 != 48) goto L14;
    L17:
        boolean r24 = true;
    L19:
        if (r22 != 3) goto L21;
    L24:
        int r25 = Integer.MIN_VALUE;
        if (r24 == false) goto L27;
        int r26 = Integer.MIN_VALUE;
        r25 = 1073741824;
    L30:
        int r110 = ((ViewGroup.LayoutParams) r20).width;
        if (r110 == (-2)) goto L35;
        if (r110 == (-1)) goto L34;
    L33:
        r25 = 1073741824;
    L36:
        int r27 = ((ViewGroup.LayoutParams) r20).height;
        if (r27 == (-2)) goto L41;
        if (r27 != (-1)) goto L42;
        r27 = r18;
    L42:
        r19.measure(View.MeasureSpec.makeMeasureSpec(r110, r25), View.MeasureSpec.makeMeasureSpec(r27, r13));
        if (r24 == false) goto L45;
        r18 = r18 - r19.getMeasuredHeight();
        goto L47
    L45:
        if (r12 == false) goto L47;
        r17 = r17 - r19.getMeasuredWidth();
        goto L47
    L41:
        r27 = r18;
        r13 = r26;
        goto L42
    L34:
        r110 = r17;
        goto L33
    L35:
        r110 = r17;
        goto L36
    L27:
        if (r12 == false) goto L29;
        r26 = 1073741824;
        goto L30
    L29:
        r26 = Integer.MIN_VALUE;
        goto L30
    L21:
        if (r22 == 5) goto L24;
        r12 = false;
        goto L24
    L14:
        if (r23 == 80) goto L17;
        r24 = false;
    L47:
        r11 = r11 + 1;
        goto L3
    L48:
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(r17, BasicMeasure.EXACTLY);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r18, BasicMeasure.EXACTLY);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int r111 = getChildCount();
    L49:
        if (r5 >= r111) goto L58;
        View r28 = getChildAt(r5);
        if (r28.getVisibility() == 8) goto L57;
        LayoutParams r29 = (LayoutParams) r28.getLayoutParams();
        if (r29 != null) goto L55;
    L56:
        r28.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r29.widthFactor), BasicMeasure.EXACTLY), this.mChildHeightMeasureSpec);
        goto L57
    L55:
        if (r29.isDecor == false) goto L56;
    L57:
        r5 = r5 + 1;
        goto L49
    }

    @CallSuper
    public void onPageScrolled(int r13, float r14, int r15) {
        int r5 = 0;
        if (this.mDecorChildCount <= 0) goto L25;
        int r10 = getScrollX();
        int r11 = getPaddingLeft();
        int r12 = getPaddingRight();
        int r16 = getWidth();
        int r17 = getChildCount();
        int r18 = 0;
    L5:
        if (r18 >= r17) goto L25;
        View r19 = getChildAt(r18);
        LayoutParams r20 = (LayoutParams) r19.getLayoutParams();
        if (r20.isDecor == false) goto L24;
        int r21 = r20.gravity & 7;
        if (r21 != 1) goto L12;
        int r22 = Math.max((r16 - r19.getMeasuredWidth()) / 2, r11);
    L17:
        int r110 = r22;
        int r23 = r11;
        r11 = r110;
    L20:
        int r24 = (r11 + r10) - r19.getLeft();
        if (r24 == 0) goto L23;
        r19.offsetLeftAndRight(r24);
    L23:
        r11 = r23;
        goto L24
    L12:
        if (r21 != 3) goto L14;
        r23 = r19.getWidth() + r11;
        goto L20
    L14:
        if (r21 == 5) goto L16;
        r23 = r11;
        goto L20
    L16:
        r22 = (r16 - r12) - r19.getMeasuredWidth();
        r12 = r12 + r19.getMeasuredWidth();
    L24:
        r18 = r18 + 1;
    L25:
        dispatchOnPageScrolled(r13, r14, r15);
        if (this.mPageTransformer == null) goto L34;
        int r111 = getScrollX();
        int r112 = getChildCount();
    L28:
        if (r5 >= r112) goto L34;
        View r113 = getChildAt(r5);
        if (((LayoutParams) r113.getLayoutParams()).isDecor == true) goto L33;
        this.mPageTransformer.transformPage(r113, (r113.getLeft() - r111) / getClientWidth());
    L33:
        r5 = r5 + 1;
    L34:
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r10, Rect r11) {
        int r5 = getChildCount();
        if ((r10 & 2) == 0) goto L5;
        int r12 = r5;
        int r13 = 0;
        int r14 = 1;
    L6:
        if (r13 == r12) goto L17;
        View r15 = getChildAt(r13);
        if (r15.getVisibility() != 0) goto L16;
        ItemInfo r16 = infoForChild(r15);
        if (r16 == null) goto L16;
        if (r16.position != this.mCurItem) goto L16;
        if (r15.requestFocus(r10, r11) == false) goto L16;
        return true;
    L16:
        r13 = r13 + r14;
        goto L6
    L17:
        return false;
    L5:
        r13 = r5 - 1;
        r12 = -1;
        r14 = -1;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        PagerAdapter r11 = this.mAdapter;
        if (r11 == null) goto L9;
        r11.restoreState(r10.adapterState, r10.loader);
        setCurrentItemInternal(r10.position, false, true);
        return;
    L9:
        this.mRestoredCurItem = r10.position;
        this.mRestoredAdapterState = r10.adapterState;
        this.mRestoredClassLoader = r10.loader;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.position = this.mCurItem;
        PagerAdapter r10 = this.mAdapter;
        if (r10 == null) goto L5;
        r5.adapterState = r10.saveState();
    L5:
        return r5;
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (r5 == r11) goto L6;
        int r13 = this.mPageMargin;
        recomputeScrollPosition(r5, r11, r13, r13);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mFakeDragging == false) goto L5;
        return true;
    L5:
        boolean r5 = false;
        if (r10.getAction() == 0) goto L8;
    L10:
        PagerAdapter r11 = this.mAdapter;
        if (r11 != null) goto L13;
    L61:
        return false;
    L13:
        if (r11.getCount() == 0) goto L61;
        if (this.mVelocityTracker != null) goto L18;
        this.mVelocityTracker = VelocityTracker.obtain();
    L18:
        this.mVelocityTracker.addMovement(r10);
        int r12 = r10.getAction() & 255;
        if (r12 == 0) goto L57;
        if (r12 == 1) goto L55;
        if (r12 == 2) goto L36;
        if (r12 == 3) goto L33;
        if (r12 != 5) goto L28;
        int r13 = r10.getActionIndex();
        this.mLastMotionX = r10.getX(r13);
        this.mActivePointerId = r10.getPointerId(r13);
    L58:
        if (r5 == false) goto L60;
        ViewCompat.postInvalidateOnAnimation(this);
    L60:
        return true;
    L28:
        if (r12 != 6) goto L58;
        onSecondaryPointerUp(r10);
        this.mLastMotionX = r10.getX(r10.findPointerIndex(this.mActivePointerId));
        goto L58
    L33:
        if (this.mIsBeingDragged == false) goto L58;
        scrollToItem(this.mCurItem, true, 0, false);
        r5 = resetTouch();
        goto L58
    L36:
        if (this.mIsBeingDragged == true) goto L52;
        int r14 = r10.findPointerIndex(this.mActivePointerId);
        if (r14 != (-1)) goto L40;
        r5 = resetTouch();
        goto L58
    L40:
        float r15 = r10.getX(r14);
        float r16 = Math.abs(r15 - this.mLastMotionX);
        float r17 = r10.getY(r14);
        float r18 = Math.abs(r17 - this.mLastMotionY);
        if (r16 <= this.mTouchSlop) goto L52;
        if (r16 <= r18) goto L52;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        float r19 = this.mInitialMotionX;
        if ((r15 - r19) <= 0.0f) goto L47;
        float r20 = r19 + this.mTouchSlop;
    L48:
        this.mLastMotionX = r20;
        this.mLastMotionY = r17;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r21 = getParent();
        if (r21 == null) goto L52;
        r21.requestDisallowInterceptTouchEvent(true);
        goto L52
    L47:
        r20 = r19 - this.mTouchSlop;
    L52:
        if (this.mIsBeingDragged == false) goto L58;
        r5 = performDrag(r10.getX(r10.findPointerIndex(this.mActivePointerId)));
        goto L58
    L55:
        if (this.mIsBeingDragged == false) goto L58;
        VelocityTracker r22 = this.mVelocityTracker;
        r22.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r23 = (int) r22.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r24 = getClientWidth();
        int r25 = getScrollX();
        ItemInfo r26 = infoForCurrentScrollPosition();
        float r27 = r24;
        setCurrentItemInternal(determineTargetPage(r26.position, ((r25 / r27) - r26.offset) / (r26.widthFactor + (this.mPageMargin / r27)), r23, (int) (r10.getX(r10.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, r23);
        r5 = resetTouch();
        goto L58
    L57:
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        float r28 = r10.getX();
        this.mInitialMotionX = r28;
        this.mLastMotionX = r28;
        float r29 = r10.getY();
        this.mInitialMotionY = r29;
        this.mLastMotionY = r29;
        this.mActivePointerId = r10.getPointerId(0);
        goto L58
    L8:
        if (r10.getEdgeFlags() == 0) goto L10;
        return false;
    }

    public boolean pageLeft() {
        int r5 = this.mCurItem;
        if (r5 <= 0) goto L6;
        setCurrentItem(r5 - 1, true);
        return true;
    L6:
        return false;
    }

    public boolean pageRight() {
        PagerAdapter r5 = this.mAdapter;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (this.mCurItem >= (r5.getCount() - 1)) goto L10;
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    L10:
        return false;
    }

    public void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener r5) {
        List<OnAdapterChangeListener> r10 = this.mAdapterChangeListeners;
        if (r10 == null) goto L6;
        r10.remove(r5);
        return;
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener r5) {
        List<OnPageChangeListener> r10 = this.mOnPageChangeListeners;
        if (r10 == null) goto L6;
        r10.remove(r5);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r5) {
        if (this.mInLayout == false) goto L5;
        removeViewInLayout(r5);
        return;
    L5:
        super.removeView(r5);
    }

    public void setAdapter(@Nullable PagerAdapter r10) {
        PagerAdapter r5 = this.mAdapter;
        int r11 = 0;
        if (r5 == null) goto L9;
        r5.setViewPagerObserver(null);
        this.mAdapter.startUpdate(this);
        int r12 = 0;
    L6:
        if (r12 >= this.mItems.size()) goto L8;
        ItemInfo r13 = this.mItems.get(r12);
        this.mAdapter.destroyItem(this, r13.position, r13.object);
        r12 = r12 + 1;
        goto L6
    L8:
        this.mAdapter.finishUpdate(this);
        this.mItems.clear();
        removeNonDecorViews();
        this.mCurItem = 0;
        scrollTo(0, 0);
    L9:
        PagerAdapter r14 = this.mAdapter;
        this.mAdapter = r10;
        this.mExpectedAdapterCount = 0;
        if (r10 != null) goto L12;
    L20:
        List<OnAdapterChangeListener> r15 = this.mAdapterChangeListeners;
        if (r15 != null) goto L23;
        return;
    L23:
        if (r15.isEmpty() == true) goto L30;
        int r16 = this.mAdapterChangeListeners.size();
    L25:
        if (r11 >= r16) goto L31;
        this.mAdapterChangeListeners.get(r11).onAdapterChanged(this, r14, r10);
        r11 = r11 + 1;
        goto L25
    L31:
        return;
    L30:
        return;
    L12:
        if (this.mObserver != null) goto L14;
        this.mObserver = new PagerObserver(this);
    L14:
        this.mAdapter.setViewPagerObserver(this.mObserver);
        this.mPopulatePending = false;
        boolean r17 = this.mFirstLayout;
        this.mFirstLayout = true;
        this.mExpectedAdapterCount = this.mAdapter.getCount();
        if (this.mRestoredCurItem < 0) goto L17;
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        goto L20
    L17:
        if (r17 == true) goto L19;
        populate();
        goto L20
    L19:
        requestLayout();
        goto L20
    }

    public void setCurrentItem(int r5) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r5, !this.mFirstLayout, false);
    }

    public void setCurrentItemInternal(int r5, boolean r10, boolean r11) {
        setCurrentItemInternal(r5, r10, r11, 0);
    }

    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener r5) {
        OnPageChangeListener r10 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = r5;
        return r10;
    }

    public void setOffscreenPageLimit(int r5) {
        if (r5 >= 1) goto L6;
        Log.w(TAG, "Requested offscreen page limit " + r5 + " too small; defaulting to 1");
        r5 = 1;
    L6:
        if (r5 == this.mOffscreenPageLimit) goto L9;
        this.mOffscreenPageLimit = r5;
        populate();
        return;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener r5) {
        this.mOnPageChangeListener = r5;
    }

    public void setPageMargin(int r5) {
        int r10 = this.mPageMargin;
        this.mPageMargin = r5;
        int r11 = getWidth();
        recomputeScrollPosition(r11, r11, r5, r10);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable r5) {
        this.mMarginDrawable = r5;
        if (r5 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r5 != null) goto L7;
        boolean r10 = true;
    L8:
        setWillNotDraw(r10);
        invalidate();
        return;
    L7:
        r10 = false;
        goto L8
    }

    public void setPageTransformer(boolean r5, @Nullable PageTransformer r10) {
        setPageTransformer(r5, r10, 2);
    }

    public void setScrollState(int r5) {
        if (this.mScrollState != r5) goto L5;
        return;
    L5:
        this.mScrollState = r5;
        if (this.mPageTransformer == null) goto L11;
        if (r5 == 0) goto L9;
        boolean r10 = true;
    L10:
        enableLayers(r10);
        goto L11
    L9:
        r10 = false;
    L11:
        dispatchOnScrollStateChanged(r5);
    }

    public void smoothScrollTo(int r5, int r10) {
        smoothScrollTo(r5, r10, 0);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r5) {
        if (super.verifyDrawable(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5 == this.mMarginDrawable) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    public void populate(int r18) {
        int r5 = this.mCurItem;
        if (r5 == r18) goto L5;
        ItemInfo r10 = infoForPosition(r5);
        this.mCurItem = r18;
    L7:
        if (this.mAdapter != null) goto L11;
        sortChildDrawingOrder();
        return;
    L11:
        if (this.mPopulatePending == false) goto L15;
        sortChildDrawingOrder();
        return;
    L15:
        if (getWindowToken() != null) goto L17;
        return;
    L17:
        this.mAdapter.startUpdate(this);
        int r11 = this.mOffscreenPageLimit;
        int r12 = Math.max(0, this.mCurItem - r11);
        int r13 = this.mAdapter.getCount();
        int r14 = Math.min(r13 - 1, this.mCurItem + r11);
        if (r13 != this.mExpectedAdapterCount) goto L139;
        int r15 = 0;
    L21:
        if (r15 >= this.mItems.size()) goto L27;
        ItemInfo r16 = this.mItems.get(r15);
        int r17 = r16.position;
        int r19 = this.mCurItem;
        if (r17 >= r19) goto L24;
        r15 = r15 + 1;
        goto L21
    L24:
        if (r17 != r19) goto L27;
    L28:
        if (r16 != null) goto L32;
        if (r13 <= 0) goto L32;
        r16 = addNewItem(this.mCurItem, r15);
    L32:
        if (r16 == null) goto L103;
        int r110 = r15 - 1;
        if (r110 < 0) goto L36;
        ItemInfo r111 = this.mItems.get(r110);
    L37:
        int r112 = getClientWidth();
        if (r112 > 0) goto L40;
        float r113 = 0.0f;
    L41:
        int r20 = this.mCurItem - 1;
        float r114 = 0.0f;
    L42:
        if (r20 < 0) goto L67;
        if (r114 < r113) goto L57;
        if (r20 >= r12) goto L57;
        if (r111 == null) goto L67;
        if (r20 != r111.position) goto L66;
        if (r111.scrolling == true) goto L66;
        this.mItems.remove(r110);
        this.mAdapter.destroyItem(this, r20, r111.object);
        r110 = r110 - 1;
        r15 = r15 - 1;
        if (r110 < 0) goto L55;
        ItemInfo r21 = this.mItems.get(r110);
    L56:
        r111 = r21;
    L55:
        r21 = null;
    L66:
        r20 = r20 - 1;
    L57:
        if (r111 != null) goto L59;
    L63:
        r114 = r114 + addNewItem(r20, r110 + 1).widthFactor;
        r15 = r15 + 1;
        if (r110 < 0) goto L55;
        r21 = this.mItems.get(r110);
        goto L56
    L59:
        if (r20 != r111.position) goto L63;
        r114 = r114 + r111.widthFactor;
        r110 = r110 - 1;
        if (r110 < 0) goto L55;
        r21 = this.mItems.get(r110);
    L67:
        float r22 = r16.widthFactor;
        int r23 = r15 + 1;
        if (r22 < 2.0f) goto L70;
    L102:
        calculatePageOffsets(r16, r15, r10);
        this.mAdapter.setPrimaryItem(this, this.mCurItem, r16.object);
        goto L103
    L70:
        if (r23 >= this.mItems.size()) goto L72;
        ItemInfo r24 = this.mItems.get(r23);
    L73:
        if (r112 > 0) goto L75;
        float r115 = 0.0f;
    L76:
        int r116 = this.mCurItem;
    L77:
        r116 = r116 + 1;
        if (r116 >= r13) goto L102;
        if (r22 < r115) goto L92;
        if (r116 <= r14) goto L92;
        if (r24 == null) goto L102;
        if (r116 != r24.position) goto L77;
        if (r24.scrolling == true) goto L77;
        this.mItems.remove(r23);
        this.mAdapter.destroyItem(this, r116, r24.object);
        if (r23 < this.mItems.size()) goto L90;
    L91:
        r24 = null;
        goto L77
    L90:
        r24 = this.mItems.get(r23);
    L92:
        if (r24 == null) goto L98;
        if (r116 != r24.position) goto L98;
        r22 = r22 + r24.widthFactor;
        r23 = r23 + 1;
        if (r23 >= this.mItems.size()) goto L91;
        r24 = this.mItems.get(r23);
    L98:
        ItemInfo r25 = addNewItem(r116, r23);
        r23 = r23 + 1;
        r22 = r22 + r25.widthFactor;
        if (r23 >= this.mItems.size()) goto L91;
        r24 = this.mItems.get(r23);
        goto L77
    L75:
        r115 = (getPaddingRight() / r112) + 2.0f;
        goto L76
    L72:
        r24 = null;
        goto L73
    L40:
        r113 = (getPaddingLeft() / r112) + (2.0f - r16.widthFactor);
        goto L41
    L36:
        r111 = null;
    L103:
        this.mAdapter.finishUpdate(this);
        int r26 = getChildCount();
        int r27 = 0;
    L104:
        if (r27 >= r26) goto L113;
        View r28 = getChildAt(r27);
        LayoutParams r29 = (LayoutParams) r28.getLayoutParams();
        r29.childIndex = r27;
        if (r29.isDecor == true) goto L112;
        if (r29.widthFactor != 0.0f) goto L112;
        ItemInfo r30 = infoForChild(r28);
        if (r30 == null) goto L112;
        r29.widthFactor = r30.widthFactor;
        r29.position = r30.position;
    L112:
        r27 = r27 + 1;
        goto L104
    L113:
        sortChildDrawingOrder();
        if (hasFocus() == false) goto L133;
        View r31 = findFocus();
        if (r31 == null) goto L118;
        ItemInfo r32 = infoForAnyChild(r31);
    L119:
        if (r32 != null) goto L121;
    L122:
        int r33 = 0;
    L124:
        if (r33 >= getChildCount()) goto L183;
        View r34 = getChildAt(r33);
        ItemInfo r35 = infoForChild(r34);
        if (r35 == null) goto L132;
        if (r35.position != this.mCurItem) goto L132;
        if (r34.requestFocus(2) == false) goto L132;
        return;
    L132:
        r33 = r33 + 1;
        goto L124
    L183:
        return;
    L121:
        if (r32.position != this.mCurItem) goto L122;
        return;
    L118:
        r32 = null;
        goto L119
    L133:
        return;
    L27:
        r16 = null;
        goto L28
    L139:
        String r36 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L136
    L137:
        StringBuilder r37 = new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r37, this.mExpectedAdapterCount, ", found: ", r13, " Pager id: ");
        r37.append(r36);
        r37.append(" Pager class: ");
        r37.append(getClass());
        r37.append(" Problematic adapter: ");
        r37.append(this.mAdapter.getClass());
        throw new IllegalStateException(r37.toString());
    L136:
        r36 = Integer.toHexString(getId());
        goto L137
    L5:
        r10 = null;
        goto L7
    }

    public void setCurrentItemInternal(int r5, boolean r10, boolean r11, int r12) {
        PagerAdapter r13 = this.mAdapter;
        boolean r14 = false;
        if (r13 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r13.getCount() <= 0) goto L39;
        if (r11 == true) goto L15;
        if (this.mCurItem != r5) goto L15;
        if (this.mItems.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r5 >= 0) goto L18;
        r5 = 0;
    L20:
        int r15 = this.mOffscreenPageLimit;
        int r16 = this.mCurItem;
        if (r5 <= (r16 + r15)) goto L23;
    L24:
        int r17 = 0;
    L26:
        if (r17 >= this.mItems.size()) goto L29;
        this.mItems.get(r17).scrolling = true;
        r17 = r17 + 1;
    L29:
        if (this.mCurItem == r5) goto L32;
        r14 = true;
    L32:
        if (this.mFirstLayout == false) goto L37;
        this.mCurItem = r5;
        if (r14 == false) goto L36;
        dispatchOnPageSelected(r5);
    L36:
        requestLayout();
        return;
    L37:
        populate(r5);
        scrollToItem(r5, r10, r12, r14);
        return;
    L23:
        if (r5 >= (r16 - r15)) goto L29;
    L18:
        if (r5 < this.mAdapter.getCount()) goto L20;
        r5 = this.mAdapter.getCount() - 1;
        goto L20
    }

    public void setPageTransformer(boolean r5, @Nullable PageTransformer r10, int r11) {
        int r12 = 1;
        if (r10 == null) goto L5;
        boolean r13 = true;
    L7:
        if (this.mPageTransformer == null) goto L9;
        boolean r14 = true;
    L10:
        if (r13 == r14) goto L12;
        boolean r15 = true;
    L13:
        this.mPageTransformer = r10;
        setChildrenDrawingOrderEnabled(r13);
        if (r13 == false) goto L18;
        if (r5 == false) goto L17;
        r12 = 2;
    L17:
        this.mDrawingOrder = r12;
        this.mPageTransformerLayerType = r11;
    L19:
        if (r15 == false) goto L22;
        populate();
        return;
    L22:
        return;
    L18:
        this.mDrawingOrder = 0;
        goto L19
    L12:
        r15 = false;
        goto L13
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L7
    }

    public void smoothScrollTo(int r10, int r11, int r12) {
        if (getChildCount() != 0) goto L6;
        setScrollingCacheEnabled(false);
        return;
    L6:
        Scroller r5 = this.mScroller;
        if (r5 != null) goto L9;
    L16:
        int r13 = getScrollX();
    L15:
        int r14 = r13;
        int r15 = getScrollY();
        int r16 = r10 - r14;
        int r17 = r11 - r15;
        if (r16 != 0) goto L22;
        if (r17 != 0) goto L22;
        completeScroll(false);
        populate();
        setScrollState(0);
        return;
    L22:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r18 = getClientWidth();
        int r19 = r18 / 2;
        float r20 = r18;
        float r110 = r19;
        float r21 = (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(r16) * 1.0f) / r20)) * r110) + r110;
        int r111 = Math.abs(r12);
        if (r111 <= 0) goto L25;
        int r22 = Math.round(Math.abs(r21 / r111) * 1000.0f) * 4;
    L26:
        int r23 = Math.min(r22, MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(r14, r15, r16, r17, r23);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L25:
        r22 = (int) (((Math.abs(r16) / ((this.mAdapter.getPageWidth(this.mCurItem) * r20) + this.mPageMargin)) + 1.0f) * 100.0f);
        goto L26
    L9:
        if (r5.isFinished() == true) goto L16;
        if (this.mIsScrollStarted == false) goto L13;
        r13 = this.mScroller.getCurrX();
    L14:
        this.mScroller.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L15
    L13:
        r13 = this.mScroller.getStartX();
        goto L14
    }

    public void setCurrentItem(int r5, boolean r10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r5, r10, false);
    }

    public void setPageMarginDrawable(@DrawableRes int r5) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r5));
    }

    public ViewPager(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new AnonymousClass3(this);
        this.mScrollState = 0;
        initViewPager();
    }
}

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

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
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

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.widthFactor = 0.0f;
            TypedArray r12 = r10.obtainStyledAttributes(r11, ViewPager.LAYOUT_ATTRS);
            this.gravity = r12.getInteger(0, 48);
            r12.recycle();
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ ViewPager this$0;

        MyAccessibilityDelegate(ViewPager r10) {
            this.this$0 = r10;
        }

        private boolean canScroll() {
            PagerAdapter r10 = this.this$0.mAdapter;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.getCount() <= 1) goto L7;
            return true;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            r11.setClassName(ViewPager.class.getName());
            r11.setScrollable(canScroll());
            if (r11.getEventType() != 4096) goto L8;
            PagerAdapter r12 = this.this$0.mAdapter;
            if (r12 == null) goto L9;
            r11.setItemCount(r12.getCount());
            r11.setFromIndex(this.this$0.mCurItem);
            r11.setToIndex(this.this$0.mCurItem);
            return;
        L9:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            r11.setClassName(ViewPager.class.getName());
            r11.setScrollable(canScroll());
            if (this.this$0.canScrollHorizontally(1) == false) goto L6;
            r11.addAction(4096);
        L6:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L9;
            r11.addAction(8192);
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (super.performAccessibilityAction(r10, r11, r12) == false) goto L6;
            return true;
        L6:
            if (r11 == 4096) goto L17;
            if (r11 == 8192) goto L11;
            return false;
        L11:
            if (this.this$0.canScrollHorizontally(-1) == false) goto L15;
            ViewPager r13 = this.this$0;
            int r14 = r13.mCurItem - 1;
        L13:
            r13.setCurrentItem(r14);
            return true;
        L15:
            return false;
        L17:
            if (this.this$0.canScrollHorizontally(1) == false) goto L19;
            r13 = this.this$0;
            r14 = r13.mCurItem + 1;
            goto L13
        L19:
            return false;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager r10, @Nullable PagerAdapter r11, @Nullable PagerAdapter r12);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int r10);

        void onPageScrolled(int r10, float r11, @Px int r12);

        void onPageSelected(int r10);
    }

    public interface PageTransformer {
        void transformPage(@NonNull View r10, float r11);
    }

    private class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager this$0;

        PagerObserver(ViewPager r10) {
            this.this$0 = r10;
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

        SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r11 != null) goto L5;
            r11 = getClass().getClassLoader();
        L5:
            this.position = r10.readInt();
            this.adapterState = r10.readParcelable(r11);
            this.loader = r11;
        }

        public SavedState(@NonNull Parcelable r10) {
            super(r10);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.position);
            r10.writeParcelable(this.adapterState, r11);
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public SimpleOnPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r10, View r11) {
            LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
            LayoutParams r13 = (LayoutParams) r11.getLayoutParams();
            boolean r14 = r12.isDecor;
            if (r14 == r13.isDecor) goto L9;
            if (r14 == false) goto L6;
            return 1;
        L6:
            return -1;
        L9:
            return r12.position - r13.position;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r10, View r11) {
            return compare2(r10, r11);
        }
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.layout_gravity};
        COMPARATOR = new AnonymousClass1();
        sInterpolator = new AnonymousClass2();
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(@NonNull Context r10) {
        super(r10);
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

    public ViewPager(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
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
        int r10 = this.mAdapter.getCount();
        int r14 = getClientWidth();
        if (r14 <= 0) goto L5;
        float r15 = this.mPageMargin / r14;
    L7:
        if (r13 == null) goto L37;
        int r16 = r13.position;
        int r17 = r11.position;
        if (r16 >= r17) goto L24;
        float r18 = (r13.offset + r13.widthFactor) + r15;
        int r19 = r16 + 1;
        int r110 = 0;
    L12:
        if (r19 > r11.position) goto L37;
        if (r110 >= this.mItems.size()) goto L37;
    L15:
        ItemInfo r20 = this.mItems.get(r110);
        if (r19 <= r20.position) goto L21;
        if (r110 >= (this.mItems.size() - 1)) goto L21;
        r110 = r110 + 1;
    L21:
        if (r19 >= r20.position) goto L23;
        r18 = r18 + (this.mAdapter.getPageWidth(r19) + r15);
        r19 = r19 + 1;
        goto L21
    L23:
        r20.offset = r18;
        r18 = r18 + (r20.widthFactor + r15);
        r19 = r19 + 1;
        goto L12
    L24:
        if (r16 <= r17) goto L37;
        int r21 = this.mItems.size() - 1;
        float r111 = r13.offset;
    L26:
        r16 = r16 - 1;
        if (r16 < r11.position) goto L37;
        if (r21 < 0) goto L37;
    L29:
        ItemInfo r22 = this.mItems.get(r21);
        if (r16 >= r22.position) goto L34;
        if (r21 <= 0) goto L34;
        r21 = r21 - 1;
    L34:
        if (r16 <= r22.position) goto L36;
        r111 = r111 - (this.mAdapter.getPageWidth(r16) + r15);
        r16 = r16 - 1;
        goto L34
    L36:
        r111 = r111 - (r22.widthFactor + r15);
        r22.offset = r111;
    L37:
        int r112 = this.mItems.size();
        float r23 = r11.offset;
        int r24 = r11.position;
        int r25 = r24 - 1;
        if (r24 != 0) goto L40;
        float r26 = r23;
    L41:
        this.mFirstOffset = r26;
        int r27 = r10 - 1;
        if (r24 != r27) goto L44;
        float r28 = (r11.widthFactor + r23) - 1.0f;
    L45:
        this.mLastOffset = r28;
        int r29 = r12 - 1;
    L46:
        if (r29 < 0) goto L55;
        ItemInfo r30 = this.mItems.get(r29);
    L48:
        int r31 = r30.position;
        if (r25 <= r31) goto L51;
        r23 = r23 - (this.mAdapter.getPageWidth(r25) + r15);
        r25 = r25 - 1;
        goto L48
    L51:
        r23 = r23 - (r30.widthFactor + r15);
        r30.offset = r23;
        if (r31 != 0) goto L54;
        this.mFirstOffset = r23;
    L54:
        r29 = r29 - 1;
        r25 = r25 - 1;
        goto L46
    L55:
        float r32 = (r11.offset + r11.widthFactor) + r15;
        int r113 = r11.position + 1;
        int r114 = r12 + 1;
    L56:
        if (r114 >= r112) goto L64;
        ItemInfo r33 = this.mItems.get(r114);
    L58:
        int r34 = r33.position;
        if (r113 >= r34) goto L61;
        r32 = r32 + (this.mAdapter.getPageWidth(r113) + r15);
        r113 = r113 + 1;
        goto L58
    L61:
        if (r34 != r27) goto L63;
        this.mLastOffset = (r33.widthFactor + r32) - 1.0f;
    L63:
        r33.offset = r32;
        r32 = r32 + (r33.widthFactor + r15);
        r114 = r114 + 1;
        r113 = r113 + 1;
        goto L56
    L64:
        this.mNeedCalculatePageOffsets = false;
        return;
    L44:
        r28 = Float.MAX_VALUE;
        goto L45
    L40:
        r26 = -3.4028235E38f;
        goto L41
    L5:
        r15 = 0.0f;
        goto L7
    }

    private void completeScroll(boolean r10) {
        if (this.mScrollState != 2) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.mScroller.isFinished()) == false) goto L15;
        this.mScroller.abortAnimation();
        int r12 = getScrollX();
        int r13 = getScrollY();
        int r14 = this.mScroller.getCurrX();
        int r15 = this.mScroller.getCurrY();
        if (r12 != r14) goto L12;
        if (r13 == r15) goto L15;
    L12:
        scrollTo(r14, r15);
        if (r14 == r12) goto L15;
        pageScrolled(r14);
    L15:
        this.mPopulatePending = false;
        int r16 = 0;
    L17:
        if (r16 >= this.mItems.size()) goto L22;
        ItemInfo r17 = this.mItems.get(r16);
        if (r17.scrolling == false) goto L21;
        r17.scrolling = false;
        r11 = true;
    L21:
        r16 = r16 + 1;
        goto L17
    L22:
        if (r11 == false) goto L30;
        if (r10 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        return;
    L25:
        this.mEndScrollRunnable.run();
        return;
    L30:
        return;
    L5:
        r11 = false;
        goto L6
    }

    private int determineTargetPage(int r10, float r11, int r12, int r13) {
        if (Math.abs(r13) <= this.mFlingDistance) goto L10;
        if (Math.abs(r12) <= this.mMinimumVelocity) goto L10;
        if (r12 > 0) goto L15;
        r10 = r10 + 1;
    L15:
        if (this.mItems.size() <= 0) goto L18;
        ItemInfo r14 = this.mItems.get(0);
        ArrayList<ItemInfo> r15 = this.mItems;
        return Math.max(r14.position, Math.min(r10, r15.get(r15.size() - 1).position));
    L18:
        return r10;
    L10:
        if (r10 < this.mCurItem) goto L12;
        float r16 = 0.4f;
    L13:
        r10 = r10 + ((int) (r11 + r16));
        goto L15
    L12:
        r16 = 0.6f;
        goto L13
    }

    private void dispatchOnPageScrolled(int r10, float r11, int r12) {
        OnPageChangeListener r13 = this.mOnPageChangeListener;
        if (r13 == null) goto L5;
        r13.onPageScrolled(r10, r11, r12);
    L5:
        List<OnPageChangeListener> r14 = this.mOnPageChangeListeners;
        if (r14 == null) goto L13;
        int r15 = 0;
        int r16 = r14.size();
    L8:
        if (r15 >= r16) goto L13;
        OnPageChangeListener r17 = this.mOnPageChangeListeners.get(r15);
        if (r17 == null) goto L12;
        r17.onPageScrolled(r10, r11, r12);
    L12:
        r15 = r15 + 1;
    L13:
        OnPageChangeListener r18 = this.mInternalPageChangeListener;
        if (r18 == null) goto L20;
        r18.onPageScrolled(r10, r11, r12);
        return;
    }

    private void dispatchOnPageSelected(int r10) {
        OnPageChangeListener r11 = this.mOnPageChangeListener;
        if (r11 == null) goto L5;
        r11.onPageSelected(r10);
    L5:
        List<OnPageChangeListener> r12 = this.mOnPageChangeListeners;
        if (r12 == null) goto L13;
        int r13 = 0;
        int r14 = r12.size();
    L8:
        if (r13 >= r14) goto L13;
        OnPageChangeListener r15 = this.mOnPageChangeListeners.get(r13);
        if (r15 == null) goto L12;
        r15.onPageSelected(r10);
    L12:
        r13 = r13 + 1;
    L13:
        OnPageChangeListener r16 = this.mInternalPageChangeListener;
        if (r16 == null) goto L20;
        r16.onPageSelected(r10);
        return;
    }

    private void dispatchOnScrollStateChanged(int r10) {
        OnPageChangeListener r11 = this.mOnPageChangeListener;
        if (r11 == null) goto L5;
        r11.onPageScrollStateChanged(r10);
    L5:
        List<OnPageChangeListener> r12 = this.mOnPageChangeListeners;
        if (r12 == null) goto L13;
        int r13 = 0;
        int r14 = r12.size();
    L8:
        if (r13 >= r14) goto L13;
        OnPageChangeListener r15 = this.mOnPageChangeListeners.get(r13);
        if (r15 == null) goto L12;
        r15.onPageScrollStateChanged(r10);
    L12:
        r13 = r13 + 1;
    L13:
        OnPageChangeListener r16 = this.mInternalPageChangeListener;
        if (r16 == null) goto L20;
        r16.onPageScrollStateChanged(r10);
        return;
    }

    private void enableLayers(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r10 == false) goto L6;
        int r13 = this.mPageTransformerLayerType;
    L7:
        getChildAt(r12).setLayerType(r13, null);
        r12 = r12 + 1;
        goto L3
    L6:
        r13 = 0;
        goto L7
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private Rect getChildRectInPagerCoordinates(Rect r10, View r11) {
        if (r10 != null) goto L4;
        r10 = new Rect();
    L4:
        if (r11 != null) goto L7;
        r10.set(0, 0, 0, 0);
        return r10;
    L7:
        r10.left = r11.getLeft();
        r10.right = r11.getRight();
        r10.top = r11.getTop();
        r10.bottom = r11.getBottom();
        ViewParent r12 = r11.getParent();
    L9:
        if ((r12 instanceof ViewGroup) == false) goto L12;
        if (r12 == this) goto L12;
        ViewGroup r13 = (ViewGroup) r12;
        r10.left += r13.getLeft();
        r10.right += r13.getRight();
        r10.top += r13.getTop();
        r10.bottom += r13.getBottom();
        r12 = r13.getParent();
    L12:
        return r10;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int r10 = getClientWidth();
        float r11 = 0.0f;
        if (r10 <= 0) goto L5;
        float r12 = getScrollX() / r10;
    L6:
        if (r10 <= 0) goto L8;
        float r13 = this.mPageMargin / r10;
    L9:
        ItemInfo r14 = null;
        int r15 = 0;
        int r16 = -1;
        boolean r17 = true;
        float r18 = 0.0f;
    L11:
        if (r15 >= this.mItems.size()) goto L30;
        ItemInfo r19 = this.mItems.get(r15);
        if (r17 == true) goto L17;
        int r20 = r16 + 1;
        if (r19.position == r20) goto L17;
        r19 = this.mTempItem;
        r19.offset = (r11 + r18) + r13;
        r19.position = r20;
        r19.widthFactor = this.mAdapter.getPageWidth(r20);
        r15 = r15 - 1;
    L17:
        r11 = r19.offset;
        float r21 = (r19.widthFactor + r11) + r13;
        if (r17 == true) goto L24;
        if (r12 >= r11) goto L24;
        return r14;
    L24:
        if (r12 < r21) goto L29;
        if (r15 == (this.mItems.size() - 1)) goto L29;
        r16 = r19.position;
        r18 = r19.widthFactor;
        r15 = r15 + 1;
        r17 = false;
        r14 = r19;
    L29:
        return r19;
    L30:
        return r14;
    L8:
        r13 = 0.0f;
        goto L9
    L5:
        r12 = 0.0f;
        goto L6
    }

    private static boolean isDecorView(@NonNull View r10) {
        if (r10.getClass().getAnnotation(DecorView.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isGutterDrag(float r10, float r11) {
        if (r10 >= this.mGutterSize) goto L7;
        if (r11 <= 0.0f) goto L7;
    L10:
        return true;
    L7:
        if (r10 > (getWidth() - this.mGutterSize)) goto L9;
    L11:
        return false;
    L9:
        if (r11 >= 0.0f) goto L11;
        goto L10
    }

    private void onSecondaryPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.mActivePointerId) goto L11;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.mLastMotionX = r10.getX(r12);
        this.mActivePointerId = r10.getPointerId(r12);
        VelocityTracker r13 = this.mVelocityTracker;
        if (r13 == null) goto L12;
        r13.clear();
        return;
    L12:
        return;
    L6:
        r12 = 0;
        goto L7
    }

    private boolean pageScrolled(int r10) {
        if (this.mItems.size() == 0) goto L5;
        ItemInfo r11 = infoForCurrentScrollPosition();
        int r12 = getClientWidth();
        int r13 = this.mPageMargin;
        int r14 = r12 + r13;
        float r15 = r12;
        int r16 = r11.position;
        float r17 = ((r10 / r15) - r11.offset) / (r11.widthFactor + (r13 / r15));
        this.mCalledSuper = false;
        onPageScrolled(r16, r17, (int) (r14 * r17));
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
        float r11 = this.mLastMotionX - r10;
        this.mLastMotionX = r10;
        float r12 = getScrollX() + r11;
        float r13 = getClientWidth();
        float r14 = this.mFirstOffset * r13;
        float r15 = this.mLastOffset * r13;
        boolean r16 = false;
        ItemInfo r17 = this.mItems.get(0);
        ArrayList<ItemInfo> r18 = this.mItems;
        ItemInfo r19 = r18.get(r18.size() - 1);
        if (r17.position == 0) goto L5;
        r14 = r17.offset * r13;
        boolean r20 = false;
    L7:
        if (r19.position == (this.mAdapter.getCount() - 1)) goto L9;
        r15 = r19.offset * r13;
        boolean r21 = false;
    L11:
        if (r12 >= r14) goto L16;
        if (r20 == false) goto L14;
        this.mLeftEdge.onPull(Math.abs(r14 - r12) / r13);
        r16 = true;
    L14:
        r12 = r14;
    L20:
        int r22 = (int) r12;
        this.mLastMotionX += r12 - r22;
        scrollTo(r22, getScrollY());
        pageScrolled(r22);
        return r16;
    L16:
        if (r12 <= r15) goto L20;
        if (r21 == false) goto L19;
        this.mRightEdge.onPull(Math.abs(r12 - r15) / r13);
        r16 = true;
    L19:
        r12 = r15;
        goto L20
    L9:
        r21 = true;
        goto L11
    L5:
        r20 = true;
        goto L7
    }

    private void recomputeScrollPosition(int r10, int r11, int r12, int r13) {
        if (r11 > 0) goto L4;
    L10:
        ItemInfo r14 = infoForPosition(this.mCurItem);
        if (r14 == null) goto L13;
        float r15 = Math.min(r14.offset, this.mLastOffset);
    L14:
        int r16 = (int) (r15 * ((r10 - getPaddingLeft()) - getPaddingRight()));
        if (r16 == getScrollX()) goto L19;
        completeScroll(false);
    L9:
        scrollTo(r16, getScrollY());
        return;
    L19:
        return;
    L13:
        r15 = 0.0f;
        goto L14
    L4:
        if (this.mItems.isEmpty() == true) goto L10;
        if (this.mScroller.isFinished() == true) goto L8;
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        r16 = (int) ((getScrollX() / (((r11 - getPaddingLeft()) - getPaddingRight()) + r13)) * (((r10 - getPaddingLeft()) - getPaddingRight()) + r12));
        goto L9
    }

    private void removeNonDecorViews() {
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L9;
        if (((LayoutParams) getChildAt(r10).getLayoutParams()).isDecor == true) goto L8;
        removeViewAt(r10);
        r10 = r10 - 1;
    L8:
        r10 = r10 + 1;
        goto L4
    }

    private void requestParentDisallowInterceptTouchEvent(boolean r10) {
        ViewParent r11 = getParent();
        if (r11 == null) goto L6;
        r11.requestDisallowInterceptTouchEvent(r10);
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
        ItemInfo r14 = infoForPosition(r10);
        if (r14 == null) goto L5;
        int r15 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(r14.offset, this.mLastOffset)));
    L6:
        if (r11 == false) goto L10;
        smoothScrollTo(r15, 0, r12);
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
        scrollTo(r15, 0);
        pageScrolled(r15);
        return;
    L5:
        r15 = 0;
        goto L6
    }

    private void setScrollingCacheEnabled(boolean r10) {
        if (this.mScrollingCacheEnabled == r10) goto L6;
        this.mScrollingCacheEnabled = r10;
        return;
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder == 0) goto L14;
        ArrayList<View> r10 = this.mDrawingOrderedChildren;
        if (r10 != null) goto L7;
        this.mDrawingOrderedChildren = new ArrayList();
    L8:
        int r11 = getChildCount();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        View r13 = getChildAt(r12);
        this.mDrawingOrderedChildren.add(r13);
        r12 = r12 + 1;
        goto L9
    L11:
        Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        return;
    L7:
        r10.clear();
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r10, int r11, int r12) {
        int r13 = r10.size();
        int r14 = getDescendantFocusability();
        if (r14 == 393216) goto L16;
        int r15 = 0;
    L6:
        if (r15 >= getChildCount()) goto L16;
        View r16 = getChildAt(r15);
        if (r16.getVisibility() != 0) goto L14;
        ItemInfo r17 = infoForChild(r16);
        if (r17 == null) goto L14;
        if (r17.position != this.mCurItem) goto L14;
        r16.addFocusables(r10, r11, r12);
    L14:
        r15 = r15 + 1;
    L16:
        if (r14 != 262144) goto L20;
        if (r13 == r10.size()) goto L20;
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

    ItemInfo addNewItem(int r10, int r11) {
        ItemInfo r12 = new ItemInfo();
        r12.position = r10;
        r12.object = this.mAdapter.instantiateItem(this, r10);
        r12.widthFactor = this.mAdapter.getPageWidth(r10);
        if (r11 >= 0) goto L5;
    L8:
        this.mItems.add(r12);
    L9:
        return r12;
    L5:
        if (r11 >= this.mItems.size()) goto L8;
        this.mItems.add(r11, r12);
        goto L9
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener r10) {
        if (this.mAdapterChangeListeners != null) goto L5;
        this.mAdapterChangeListeners = new ArrayList();
    L5:
        this.mAdapterChangeListeners.add(r10);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener r10) {
        if (this.mOnPageChangeListeners != null) goto L5;
        this.mOnPageChangeListeners = new ArrayList();
    L5:
        this.mOnPageChangeListeners.add(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> r10) {
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L13;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() != 0) goto L12;
        ItemInfo r13 = infoForChild(r12);
        if (r13 == null) goto L12;
        if (r13.position != this.mCurItem) goto L12;
        r12.addTouchables(r10);
    L12:
        r11 = r11 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if (checkLayoutParams(r12) == true) goto L5;
        r12 = generateLayoutParams(r12);
    L5:
        LayoutParams r13 = (LayoutParams) r12;
        boolean r14 = r13.isDecor | isDecorView(r10);
        r13.isDecor = r14;
        if (this.mInLayout == false) goto L11;
        if (r14 == true) goto L10;
        r13.needsMeasure = true;
        addViewInLayout(r10, r11, r12);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r10, r11, r12);
    }

    public boolean arrowScroll(int r10) {
        View r11 = findFocus();
        boolean r12 = false;
        if (r11 != this) goto L5;
    L4:
        r11 = null;
    L19:
        View r13 = FocusFinder.getInstance().findNextFocus(this, r11, r10);
        if (r13 == null) goto L34;
        if (r13 == r11) goto L34;
        if (r10 != 17) goto L29;
        int r14 = getChildRectInPagerCoordinates(this.mTempRect, r13).left;
        int r15 = getChildRectInPagerCoordinates(this.mTempRect, r11).left;
        if (r11 == null) goto L27;
        if (r14 < r15) goto L27;
        boolean r16 = pageLeft();
    L28:
        r12 = r16;
    L42:
        if (r12 == false) goto L44;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r10));
    L44:
        return r12;
    L27:
        r16 = r13.requestFocus();
        goto L28
    L29:
        if (r10 != 66) goto L42;
        int r17 = getChildRectInPagerCoordinates(this.mTempRect, r13).left;
        int r18 = getChildRectInPagerCoordinates(this.mTempRect, r11).left;
        if (r11 == null) goto L27;
        if (r17 > r18) goto L27;
        r16 = pageRight();
    L34:
        if (r10 == 17) goto L41;
        if (r10 == 1) goto L41;
        if (r10 != 66) goto L39;
    L40:
        r12 = pageRight();
        goto L42
    L39:
        if (r10 != 2) goto L42;
    L41:
        r12 = pageLeft();
        goto L42
    L5:
        if (r11 == null) goto L19;
        ViewParent r19 = r11.getParent();
    L8:
        if ((r19 instanceof ViewGroup) == false) goto L12;
        if (r19 == this) goto L10;
        r19 = r19.getParent();
        goto L8
    L10:
        boolean r20 = true;
    L13:
        if (r20 == true) goto L19;
        StringBuilder r21 = new StringBuilder();
        r21.append(r11.getClass().getSimpleName());
        ViewParent r22 = r11.getParent();
    L16:
        if ((r22 instanceof ViewGroup) == false) goto L18;
        r21.append(" => ");
        r21.append(r22.getClass().getSimpleName());
        r22 = r22.getParent();
        goto L16
    L18:
        Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + r21.toString());
        goto L4
    L12:
        r20 = false;
        goto L13
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged == false) goto L6;
        return false;
    L6:
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 != null) goto L9;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        long r11 = SystemClock.uptimeMillis();
        MotionEvent r12 = MotionEvent.obtain(r11, r11, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(r12);
        r12.recycle();
        this.mFakeDragBeginTime = r11;
        return true;
    L9:
        r10.clear();
        goto L10
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
    L22:
        return false;
    L20:
        if (r13.canScrollHorizontally(-r15) == false) goto L22;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r10) {
        if (this.mAdapter != null) goto L5;
        return false;
    L5:
        int r11 = getClientWidth();
        int r12 = getScrollX();
        if (r10 < 0) goto L8;
        if (r10 > 0) goto L13;
        return false;
    L13:
        if (r12 < ((int) (r11 * this.mLastOffset))) goto L15;
        return false;
    L15:
        return true;
    L8:
        if (r12 > ((int) (r11 * this.mFirstOffset))) goto L10;
        return false;
    L10:
        return true;
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

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> r10 = this.mOnPageChangeListeners;
        if (r10 == null) goto L6;
        r10.clear();
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
        int r10 = getScrollX();
        int r11 = getScrollY();
        int r12 = this.mScroller.getCurrX();
        int r13 = this.mScroller.getCurrY();
        if (r10 != r12) goto L9;
        if (r11 != r13) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r12, r13);
        if (pageScrolled(r12) == true) goto L12;
        this.mScroller.abortAnimation();
        scrollTo(0, r13);
        goto L12
    }

    void dataSetChanged() {
        int r10 = this.mAdapter.getCount();
        this.mExpectedAdapterCount = r10;
        if (this.mItems.size() < ((this.mOffscreenPageLimit * 2) + 1)) goto L5;
    L7:
        boolean r11 = false;
    L8:
        int r12 = this.mCurItem;
        int r13 = 0;
        boolean r14 = false;
    L10:
        if (r13 >= this.mItems.size()) goto L30;
        ItemInfo r15 = this.mItems.get(r13);
        int r16 = this.mAdapter.getItemPosition(r15.object);
        if (r16 == (-1)) goto L29;
        if (r16 != (-2)) goto L23;
        this.mItems.remove(r13);
        r13 = r13 - 1;
        if (r14 == true) goto L19;
        this.mAdapter.startUpdate(this);
        r14 = true;
    L19:
        this.mAdapter.destroyItem(this, r15.position, r15.object);
        int r17 = this.mCurItem;
        if (r17 != r15.position) goto L22;
        r12 = Math.max(0, Math.min(r17, r10 - 1));
    L22:
        r11 = true;
        goto L29
    L23:
        int r18 = r15.position;
        if (r18 == r16) goto L29;
        if (r18 != this.mCurItem) goto L28;
        r12 = r16;
    L28:
        r15.position = r16;
    L29:
        r13 = r13 + 1;
        goto L10
    L30:
        if (r14 == false) goto L32;
        this.mAdapter.finishUpdate(this);
    L32:
        Collections.sort(this.mItems, COMPARATOR);
        if (r11 == false) goto L49;
        int r19 = getChildCount();
        int r20 = 0;
    L35:
        if (r20 >= r19) goto L40;
        LayoutParams r21 = (LayoutParams) getChildAt(r20).getLayoutParams();
        if (r21.isDecor == true) goto L39;
        r21.widthFactor = 0.0f;
    L39:
        r20 = r20 + 1;
        goto L35
    L40:
        setCurrentItemInternal(r12, false, true);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.mItems.size() >= r10) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r10) {
        if (super.dispatchKeyEvent(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        if (r10.getEventType() == 4096) goto L5;
        int r11 = getChildCount();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L19;
        View r13 = getChildAt(r12);
        if (r13.getVisibility() != 0) goto L18;
        ItemInfo r14 = infoForChild(r13);
        if (r14 == null) goto L18;
        if (r14.position != this.mCurItem) goto L18;
        if (r13.dispatchPopulateAccessibilityEvent(r10) == false) goto L18;
        return true;
    L18:
        r12 = r12 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r10);
    }

    float distanceInfluenceForSnapDuration(float r10) {
        return (float) Math.sin((r10 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        int r11 = getOverScrollMode();
        boolean r12 = false;
        if (r11 == 0) goto L13;
        if (r11 != 1) goto L11;
        PagerAdapter r13 = this.mAdapter;
        if (r13 == null) goto L11;
        if (r13.getCount() > 1) goto L13;
    L11:
        this.mLeftEdge.finish();
        this.mRightEdge.finish();
    L18:
        if (r12 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.mLeftEdge.isFinished() == true) goto L16;
        int r14 = r10.save();
        int r15 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r16 = getWidth();
        r10.rotate(270.0f);
        r10.translate((-r15) + getPaddingTop(), this.mFirstOffset * r16);
        this.mLeftEdge.setSize(r15, r16);
        r12 = false | this.mLeftEdge.draw(r10);
        r10.restoreToCount(r14);
    L16:
        if (this.mRightEdge.isFinished() == true) goto L18;
        int r17 = r10.save();
        int r18 = getWidth();
        int r19 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r10.rotate(90.0f);
        r10.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * r18);
        this.mRightEdge.setSize(r19, r18);
        r12 = r12 | this.mRightEdge.draw(r10);
        r10.restoreToCount(r17);
        goto L18
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r10 = this.mMarginDrawable;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStateful() == false) goto L9;
        r10.setState(getDrawableState());
        return;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging == false) goto L10;
        if (this.mAdapter == null) goto L7;
        VelocityTracker r10 = this.mVelocityTracker;
        r10.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r11 = (int) r10.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r12 = getClientWidth();
        int r13 = getScrollX();
        ItemInfo r14 = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(r14.position, ((r13 / r12) - r14.offset) / r14.widthFactor, r11, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, r11);
    L7:
        endDrag();
        this.mFakeDragging = false;
        return;
    L10:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent r10) {
        if (r10.getAction() != 0) goto L26;
        int r11 = r10.getKeyCode();
        if (r11 == 21) goto L22;
        if (r11 == 22) goto L18;
        if (r11 != 61) goto L26;
        if (r10.hasNoModifiers() == false) goto L15;
        return arrowScroll(2);
    L15:
        if (r10.hasModifiers(1) == false) goto L26;
        return arrowScroll(1);
    L18:
        if (r10.hasModifiers(2) == true) goto L30;
        int r12 = 66;
    L32:
        return arrowScroll(r12);
    L30:
        return pageRight();
    L22:
        if (r10.hasModifiers(2) == true) goto L31;
        r12 = 17;
        goto L32
    L31:
        return pageLeft();
    L26:
        return false;
    }

    public void fakeDragBy(float r11) {
        if (this.mFakeDragging == false) goto L22;
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        this.mLastMotionX += r11;
        float r10 = getScrollX() - r11;
        float r12 = getClientWidth();
        float r13 = this.mFirstOffset * r12;
        float r14 = this.mLastOffset * r12;
        ItemInfo r15 = this.mItems.get(0);
        ArrayList<ItemInfo> r16 = this.mItems;
        ItemInfo r17 = r16.get(r16.size() - 1);
        if (r15.position == 0) goto L11;
        r13 = r15.offset * r12;
    L11:
        if (r17.position == (this.mAdapter.getCount() - 1)) goto L14;
        r14 = r17.offset * r12;
    L14:
        if (r10 >= r13) goto L17;
        r10 = r13;
    L19:
        int r18 = (int) r10;
        this.mLastMotionX += r10 - r18;
        scrollTo(r18, getScrollY());
        pageScrolled(r18);
        MotionEvent r19 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(r19);
        r19.recycle();
        return;
    L17:
        if (r10 <= r14) goto L19;
        r10 = r14;
        goto L19
    L22:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
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
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int r10, int r11) {
        if (this.mDrawingOrder != 2) goto L6;
        r11 = (r10 - 1) - r11;
    L6:
        return ((LayoutParams) this.mDrawingOrderedChildren.get(r11).getLayoutParams()).childIndex;
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

    ItemInfo infoForAnyChild(View r10) {
    L2:
        Object r11 = r10.getParent();
        if (r11 == this) goto L12;
        if (r11 == null) goto L9;
        if ((r11 instanceof View) == false) goto L16;
        r10 = (View) r11;
        goto L2
    L16:
        return null;
    L9:
        return null;
    L12:
        return infoForChild(r10);
    }

    ItemInfo infoForChild(View r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mItems.size()) goto L9;
        ItemInfo r12 = this.mItems.get(r11);
        if (this.mAdapter.isViewFromObject(r10, r12.object) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return null;
    }

    ItemInfo infoForPosition(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mItems.size()) goto L9;
        ItemInfo r12 = this.mItems.get(r11);
        if (r12.position == r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return null;
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r10 = getContext();
        this.mScroller = new Scroller(r10, sInterpolator);
        ViewConfiguration r11 = ViewConfiguration.get(r10);
        float r12 = r10.getResources().getDisplayMetrics().density;
        this.mTouchSlop = r11.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * r12);
        this.mMaximumVelocity = r11.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(r10);
        this.mRightEdge = new EdgeEffect(r10);
        this.mFlingDistance = (int) (25.0f * r12);
        this.mCloseEnough = (int) (2.0f * r12);
        this.mDefaultGutterSize = (int) (r12 * 16.0f);
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
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller r10 = this.mScroller;
        if (r10 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r10.isFinished() == true) goto L7;
        this.mScroller.abortAnimation();
        goto L7
    }

    @Override // android.view.View
    protected void onDraw(Canvas r18) {
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
        int r10 = getScrollX();
        int r11 = getWidth();
        float r12 = r11;
        float r13 = this.mPageMargin / r12;
        int r14 = 0;
        ItemInfo r15 = this.mItems.get(0);
        float r16 = r15.offset;
        int r17 = this.mItems.size();
        int r19 = r15.position;
        int r110 = this.mItems.get(r17 - 1).position;
    L11:
        if (r19 >= r110) goto L35;
    L12:
        int r111 = r15.position;
        if (r19 <= r111) goto L16;
        if (r14 >= r17) goto L16;
        r14 = r14 + 1;
        r15 = this.mItems.get(r14);
    L16:
        if (r19 != r111) goto L18;
        float r20 = r15.offset;
        float r112 = r15.widthFactor;
        float r113 = (r20 + r112) * r12;
        r16 = (r20 + r112) + r13;
    L20:
        if ((this.mPageMargin + r113) <= r10) goto L24;
        this.mMarginDrawable.setBounds(Math.round(r113), this.mTopPageBounds, Math.round(this.mPageMargin + r113), this.mBottomPageBounds);
        this.mMarginDrawable.draw(r18);
    L24:
        if (r113 > (r10 + r11)) goto L36;
        r19 = r19 + 1;
        r13 = r13;
        goto L11
    L36:
        return;
    L18:
        float r114 = this.mAdapter.getPageWidth(r19);
        r113 = (r16 + r114) * r12;
        r16 = r16 + (r114 + r13);
        goto L20
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r16) {
        int r10 = r16.getAction() & 255;
        if (r10 != 3) goto L5;
    L60:
        resetTouch();
        return false;
    L5:
        if (r10 == 1) goto L60;
        if (r10 == 0) goto L15;
        if (this.mIsBeingDragged == false) goto L12;
        return true;
    L12:
        if (this.mIsUnableToDrag == false) goto L15;
        return false;
    L15:
        if (r10 == 0) goto L49;
        if (r10 != 2) goto L18;
        int r11 = this.mActivePointerId;
        if (r11 == (-1)) goto L56;
        int r12 = r16.findPointerIndex(r11);
        float r13 = r16.getX(r12);
        float r14 = r13 - this.mLastMotionX;
        float r15 = Math.abs(r14);
        float r17 = r16.getY(r12);
        float r18 = Math.abs(r17 - this.mInitialMotionY);
        if (r14 != 0.0f) goto L27;
    L32:
        int r19 = this.mTouchSlop;
        if (r15 <= r19) goto L42;
        if ((r15 * 0.5f) <= r18) goto L42;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        float r20 = this.mInitialMotionX;
        float r21 = this.mTouchSlop;
        if (r14 <= 0.0f) goto L39;
        float r22 = r20 + r21;
    L40:
        this.mLastMotionX = r22;
        this.mLastMotionY = r17;
        setScrollingCacheEnabled(true);
    L45:
        if (this.mIsBeingDragged == false) goto L56;
        if (performDrag(r13) == false) goto L56;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L56
    L39:
        r22 = r20 - r21;
    L42:
        if (r18 <= r19) goto L45;
        this.mIsUnableToDrag = true;
        goto L45
    L27:
        if (isGutterDrag(this.mLastMotionX, r14) == true) goto L32;
        if (canScroll(this, false, (int) r14, (int) r13, (int) r17) == false) goto L32;
        this.mLastMotionX = r13;
        this.mLastMotionY = r17;
        this.mIsUnableToDrag = true;
        return false;
    L56:
        if (this.mVelocityTracker != null) goto L58;
        this.mVelocityTracker = VelocityTracker.obtain();
    L58:
        this.mVelocityTracker.addMovement(r16);
        return this.mIsBeingDragged;
    L18:
        if (r10 != 6) goto L56;
        onSecondaryPointerUp(r16);
        goto L56
    L49:
        float r23 = r16.getX();
        this.mInitialMotionX = r23;
        this.mLastMotionX = r23;
        float r24 = r16.getY();
        this.mInitialMotionY = r24;
        this.mLastMotionY = r24;
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
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        int r10 = getChildCount();
        int r11 = r22 - r20;
        int r12 = r23 - r21;
        int r13 = getPaddingLeft();
        int r14 = getPaddingTop();
        int r15 = getPaddingRight();
        int r16 = getPaddingBottom();
        int r17 = getScrollX();
        int r18 = 0;
        int r110 = 0;
    L4:
        if (r18 >= r10) goto L33;
        View r111 = getChildAt(r18);
        if (r111.getVisibility() == 8) goto L32;
        LayoutParams r112 = (LayoutParams) r111.getLayoutParams();
        if (r112.isDecor == false) goto L32;
        int r113 = r112.gravity;
        int r114 = r113 & 7;
        int r115 = r113 & 112;
        if (r114 != 1) goto L12;
        int r116 = Math.max((r11 - r111.getMeasuredWidth()) / 2, r13);
    L19:
        int r117 = r116;
        int r118 = r13;
        r13 = r117;
    L21:
        if (r115 != 16) goto L23;
        int r119 = Math.max((r12 - r111.getMeasuredHeight()) / 2, r14);
    L30:
        int r120 = r119;
        int r121 = r14;
        r14 = r120;
    L31:
        int r24 = r13 + r17;
        r111.layout(r24, r14, r111.getMeasuredWidth() + r24, r14 + r111.getMeasuredHeight());
        r110 = r110 + 1;
        r14 = r121;
        r13 = r118;
        goto L32
    L23:
        if (r115 != 48) goto L25;
        r121 = r111.getMeasuredHeight() + r14;
        goto L31
    L25:
        if (r115 == 80) goto L27;
        r121 = r14;
        goto L31
    L27:
        r119 = (r12 - r16) - r111.getMeasuredHeight();
        r16 = r16 + r111.getMeasuredHeight();
        goto L30
    L12:
        if (r114 != 3) goto L14;
        r118 = r111.getMeasuredWidth() + r13;
        goto L21
    L14:
        if (r114 == 5) goto L16;
        r118 = r13;
        goto L21
    L16:
        r116 = (r11 - r15) - r111.getMeasuredWidth();
        r15 = r15 + r111.getMeasuredWidth();
    L32:
        r18 = r18 + 1;
        goto L4
    L33:
        int r25 = (r11 - r13) - r15;
        int r26 = 0;
    L34:
        if (r26 >= r10) goto L46;
        View r27 = getChildAt(r26);
        if (r27.getVisibility() == 8) goto L45;
        LayoutParams r28 = (LayoutParams) r27.getLayoutParams();
        if (r28.isDecor == true) goto L45;
        ItemInfo r122 = infoForChild(r27);
        if (r122 == null) goto L45;
        float r123 = r25;
        int r124 = ((int) (r122.offset * r123)) + r13;
        if (r28.needsMeasure == false) goto L44;
        r28.needsMeasure = false;
        r27.measure(View.MeasureSpec.makeMeasureSpec((int) (r123 * r28.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((r12 - r14) - r16, 1073741824));
    L44:
        r27.layout(r124, r14, r27.getMeasuredWidth() + r124, r27.getMeasuredHeight() + r14);
    L45:
        r26 = r26 + 1;
        goto L34
    L46:
        this.mTopPageBounds = r14;
        this.mBottomPageBounds = r12 - r16;
        this.mDecorChildCount = r110;
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
    protected void onMeasure(int r14, int r15) {
        int r10 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r14), ViewGroup.getDefaultSize(0, r15));
        int r16 = getMeasuredWidth();
        this.mGutterSize = Math.min(r16 / 10, this.mDefaultGutterSize);
        int r17 = (r16 - getPaddingLeft()) - getPaddingRight();
        int r18 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        boolean r13 = true;
        int r19 = 1073741824;
        if (r12 >= r11) goto L49;
        View r20 = getChildAt(r12);
        if (r20.getVisibility() == 8) goto L48;
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21 == null) goto L48;
        if (r21.isDecor == false) goto L48;
        int r22 = r21.gravity;
        int r23 = r22 & 7;
        int r24 = r22 & 112;
        if (r24 != 48) goto L14;
    L17:
        boolean r25 = true;
    L19:
        if (r23 != 3) goto L21;
    L24:
        int r26 = Integer.MIN_VALUE;
        if (r25 == false) goto L27;
        int r27 = Integer.MIN_VALUE;
        r26 = 1073741824;
    L30:
        int r110 = ((ViewGroup.LayoutParams) r21).width;
        if (r110 == (-2)) goto L36;
        if (r110 != (-1)) goto L35;
        r110 = r17;
    L35:
        r26 = 1073741824;
    L37:
        int r28 = ((ViewGroup.LayoutParams) r21).height;
        if (r28 == (-2)) goto L42;
        if (r28 != (-1)) goto L43;
        r28 = r18;
    L43:
        r20.measure(View.MeasureSpec.makeMeasureSpec(r110, r26), View.MeasureSpec.makeMeasureSpec(r28, r19));
        if (r25 == false) goto L46;
        r18 = r18 - r20.getMeasuredHeight();
        goto L48
    L46:
        if (r13 == false) goto L48;
        r17 = r17 - r20.getMeasuredWidth();
        goto L48
    L42:
        r28 = r18;
        r19 = r27;
        goto L43
    L36:
        r110 = r17;
        goto L37
    L27:
        if (r13 == false) goto L29;
        r27 = 1073741824;
        goto L30
    L29:
        r27 = Integer.MIN_VALUE;
        goto L30
    L21:
        if (r23 == 5) goto L24;
        r13 = false;
        goto L24
    L14:
        if (r24 == 80) goto L17;
        r25 = false;
    L48:
        r12 = r12 + 1;
        goto L3
    L49:
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(r17, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int r111 = getChildCount();
    L50:
        if (r10 >= r111) goto L59;
        View r29 = getChildAt(r10);
        if (r29.getVisibility() == 8) goto L58;
        LayoutParams r30 = (LayoutParams) r29.getLayoutParams();
        if (r30 != null) goto L56;
    L57:
        r29.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r30.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
        goto L58
    L56:
        if (r30.isDecor == false) goto L57;
    L58:
        r10 = r10 + 1;
        goto L50
    }

    @CallSuper
    protected void onPageScrolled(int r13, float r14, int r15) {
        int r10 = 0;
        if (this.mDecorChildCount <= 0) goto L25;
        int r11 = getScrollX();
        int r12 = getPaddingLeft();
        int r16 = getPaddingRight();
        int r17 = getWidth();
        int r18 = getChildCount();
        int r19 = 0;
    L5:
        if (r19 >= r18) goto L25;
        View r20 = getChildAt(r19);
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21.isDecor == false) goto L24;
        int r22 = r21.gravity & 7;
        if (r22 != 1) goto L12;
        int r23 = Math.max((r17 - r20.getMeasuredWidth()) / 2, r12);
    L19:
        int r110 = r23;
        int r24 = r12;
        r12 = r110;
    L20:
        int r25 = (r12 + r11) - r20.getLeft();
        if (r25 == 0) goto L23;
        r20.offsetLeftAndRight(r25);
    L23:
        r12 = r24;
        goto L24
    L12:
        if (r22 != 3) goto L14;
        r24 = r20.getWidth() + r12;
        goto L20
    L14:
        if (r22 == 5) goto L16;
        r24 = r12;
        goto L20
    L16:
        r23 = (r17 - r16) - r20.getMeasuredWidth();
        r16 = r16 + r20.getMeasuredWidth();
    L24:
        r19 = r19 + 1;
    L25:
        dispatchOnPageScrolled(r13, r14, r15);
        if (this.mPageTransformer == null) goto L34;
        int r111 = getScrollX();
        int r112 = getChildCount();
    L28:
        if (r10 >= r112) goto L34;
        View r113 = getChildAt(r10);
        if (((LayoutParams) r113.getLayoutParams()).isDecor == true) goto L33;
        this.mPageTransformer.transformPage(r113, (r113.getLeft() - r111) / getClientWidth());
    L33:
        r10 = r10 + 1;
    L34:
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int r10, Rect r11) {
        int r12 = getChildCount();
        int r13 = -1;
        if ((r10 & 2) == 0) goto L5;
        r13 = r12;
        int r14 = 0;
        int r15 = 1;
    L6:
        if (r14 == r13) goto L17;
        View r16 = getChildAt(r14);
        if (r16.getVisibility() != 0) goto L16;
        ItemInfo r17 = infoForChild(r16);
        if (r17 == null) goto L16;
        if (r17.position != this.mCurItem) goto L16;
        if (r16.requestFocus(r10, r11) == false) goto L16;
        return true;
    L16:
        r14 = r14 + r15;
        goto L6
    L17:
        return false;
    L5:
        r14 = r12 - 1;
        r15 = -1;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        PagerAdapter r12 = this.mAdapter;
        if (r12 == null) goto L9;
        r12.restoreState(r11.adapterState, r11.loader);
        setCurrentItemInternal(r11.position, false, true);
        return;
    L9:
        this.mRestoredCurItem = r11.position;
        this.mRestoredAdapterState = r11.adapterState;
        this.mRestoredClassLoader = r11.loader;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.position = this.mCurItem;
        PagerAdapter r11 = this.mAdapter;
        if (r11 == null) goto L5;
        r10.adapterState = r11.saveState();
    L5:
        return r10;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 == r12) goto L6;
        int r14 = this.mPageMargin;
        recomputeScrollPosition(r10, r12, r14, r14);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mFakeDragging == false) goto L5;
        return true;
    L5:
        boolean r11 = false;
        if (r10.getAction() == 0) goto L8;
    L10:
        PagerAdapter r12 = this.mAdapter;
        if (r12 != null) goto L13;
    L63:
        return false;
    L13:
        if (r12.getCount() == 0) goto L63;
        if (this.mVelocityTracker != null) goto L18;
        this.mVelocityTracker = VelocityTracker.obtain();
    L18:
        this.mVelocityTracker.addMovement(r10);
        int r13 = r10.getAction() & 255;
        if (r13 == 0) goto L58;
        if (r13 == 1) goto L55;
        if (r13 == 2) goto L36;
        if (r13 == 3) goto L33;
        if (r13 != 5) goto L28;
        int r14 = r10.getActionIndex();
        this.mLastMotionX = r10.getX(r14);
        int r15 = r10.getPointerId(r14);
    L59:
        this.mActivePointerId = r15;
    L60:
        if (r11 == false) goto L62;
        ViewCompat.postInvalidateOnAnimation(this);
    L62:
        return true;
    L28:
        if (r13 != 6) goto L60;
        onSecondaryPointerUp(r10);
        this.mLastMotionX = r10.getX(r10.findPointerIndex(this.mActivePointerId));
        goto L60
    L33:
        if (this.mIsBeingDragged == false) goto L60;
        scrollToItem(this.mCurItem, true, 0, false);
    L57:
        r11 = resetTouch();
        goto L60
    L36:
        if (this.mIsBeingDragged == true) goto L52;
        int r16 = r10.findPointerIndex(this.mActivePointerId);
        if (r16 == (-1)) goto L57;
        float r17 = r10.getX(r16);
        float r18 = Math.abs(r17 - this.mLastMotionX);
        float r19 = r10.getY(r16);
        float r20 = Math.abs(r19 - this.mLastMotionY);
        if (r18 <= this.mTouchSlop) goto L52;
        if (r18 <= r20) goto L52;
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        float r21 = this.mInitialMotionX;
        if ((r17 - r21) <= 0.0f) goto L47;
        float r22 = r21 + this.mTouchSlop;
    L48:
        this.mLastMotionX = r22;
        this.mLastMotionY = r19;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r23 = getParent();
        if (r23 == null) goto L52;
        r23.requestDisallowInterceptTouchEvent(true);
        goto L52
    L47:
        r22 = r21 - this.mTouchSlop;
    L52:
        if (this.mIsBeingDragged == false) goto L60;
        r11 = false | performDrag(r10.getX(r10.findPointerIndex(this.mActivePointerId)));
        goto L60
    L55:
        if (this.mIsBeingDragged == false) goto L60;
        VelocityTracker r24 = this.mVelocityTracker;
        r24.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r25 = (int) r24.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int r26 = getClientWidth();
        int r27 = getScrollX();
        ItemInfo r28 = infoForCurrentScrollPosition();
        float r29 = r26;
        setCurrentItemInternal(determineTargetPage(r28.position, ((r27 / r29) - r28.offset) / (r28.widthFactor + (this.mPageMargin / r29)), r25, (int) (r10.getX(r10.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, r25);
        goto L57
    L58:
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        float r30 = r10.getX();
        this.mInitialMotionX = r30;
        this.mLastMotionX = r30;
        float r31 = r10.getY();
        this.mInitialMotionY = r31;
        this.mLastMotionY = r31;
        r15 = r10.getPointerId(0);
        goto L59
    L8:
        if (r10.getEdgeFlags() == 0) goto L10;
        return false;
    }

    boolean pageLeft() {
        int r10 = this.mCurItem;
        if (r10 <= 0) goto L6;
        setCurrentItem(r10 - 1, true);
        return true;
    L6:
        return false;
    }

    boolean pageRight() {
        PagerAdapter r10 = this.mAdapter;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (this.mCurItem >= (r10.getCount() - 1)) goto L10;
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    L10:
        return false;
    }

    void populate() {
        populate(this.mCurItem);
    }

    void populate(int r18) {
        int r10 = this.mCurItem;
        if (r10 == r18) goto L5;
        ItemInfo r11 = infoForPosition(r10);
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
        int r12 = this.mOffscreenPageLimit;
        int r13 = Math.max(0, this.mCurItem - r12);
        int r14 = this.mAdapter.getCount();
        int r15 = Math.min(r14 - 1, this.mCurItem + r12);
        if (r14 != this.mExpectedAdapterCount) goto L139;
        int r16 = 0;
    L21:
        if (r16 >= this.mItems.size()) goto L27;
        ItemInfo r17 = this.mItems.get(r16);
        int r19 = r17.position;
        int r110 = this.mCurItem;
        if (r19 >= r110) goto L24;
        r16 = r16 + 1;
        goto L21
    L24:
        if (r19 != r110) goto L27;
    L28:
        if (r17 != null) goto L32;
        if (r14 <= 0) goto L32;
        r17 = addNewItem(this.mCurItem, r16);
    L32:
        if (r17 == null) goto L103;
        int r111 = r16 - 1;
        if (r111 < 0) goto L36;
        ItemInfo r112 = this.mItems.get(r111);
    L37:
        int r113 = getClientWidth();
        if (r113 > 0) goto L40;
        float r114 = 0.0f;
    L41:
        int r20 = this.mCurItem - 1;
        float r115 = 0.0f;
    L42:
        if (r20 < 0) goto L67;
        if (r115 < r114) goto L55;
        if (r20 >= r13) goto L55;
        if (r112 == null) goto L67;
        if (r20 != r112.position) goto L66;
        if (r112.scrolling == true) goto L66;
        this.mItems.remove(r111);
        this.mAdapter.destroyItem(this, r20, r112.object);
        r111 = r111 - 1;
        r16 = r16 - 1;
        if (r111 >= 0) goto L63;
    L64:
        ItemInfo r21 = null;
    L65:
        r112 = r21;
    L63:
        r21 = this.mItems.get(r111);
    L66:
        r20 = r20 - 1;
    L55:
        if (r112 != null) goto L57;
    L61:
        r115 = r115 + addNewItem(r20, r111 + 1).widthFactor;
        r16 = r16 + 1;
        if (r111 < 0) goto L64;
    L57:
        if (r20 != r112.position) goto L61;
        r115 = r115 + r112.widthFactor;
        r111 = r111 - 1;
        if (r111 < 0) goto L64;
    L67:
        float r22 = r17.widthFactor;
        int r23 = r16 + 1;
        if (r22 < 2.0f) goto L70;
    L102:
        calculatePageOffsets(r17, r16, r11);
        this.mAdapter.setPrimaryItem(this, this.mCurItem, r17.object);
        goto L103
    L70:
        if (r23 >= this.mItems.size()) goto L72;
        ItemInfo r24 = this.mItems.get(r23);
    L73:
        if (r113 > 0) goto L75;
        float r116 = 0.0f;
    L76:
        int r117 = this.mCurItem;
    L77:
        r117 = r117 + 1;
        if (r117 >= r14) goto L102;
        if (r22 < r116) goto L92;
        if (r117 <= r15) goto L92;
        if (r24 == null) goto L102;
        if (r117 != r24.position) goto L77;
        if (r24.scrolling == true) goto L77;
        this.mItems.remove(r23);
        this.mAdapter.destroyItem(this, r117, r24.object);
        if (r23 < this.mItems.size()) goto L90;
    L91:
        r24 = null;
    L90:
        r24 = this.mItems.get(r23);
    L92:
        if (r24 != null) goto L94;
    L98:
        ItemInfo r25 = addNewItem(r117, r23);
        r23 = r23 + 1;
        r22 = r22 + r25.widthFactor;
        if (r23 >= this.mItems.size()) goto L91;
    L94:
        if (r117 != r24.position) goto L98;
        r22 = r22 + r24.widthFactor;
        r23 = r23 + 1;
        if (r23 >= this.mItems.size()) goto L91;
    L75:
        r116 = (getPaddingRight() / r113) + 2.0f;
        goto L76
    L72:
        r24 = null;
        goto L73
    L40:
        r114 = (2.0f - r17.widthFactor) + (getPaddingLeft() / r113);
        goto L41
    L36:
        r112 = null;
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
        if (r33 >= getChildCount()) goto L177;
        View r34 = getChildAt(r33);
        ItemInfo r35 = infoForChild(r34);
        if (r35 == null) goto L132;
        if (r35.position != this.mCurItem) goto L132;
        if (r34.requestFocus(2) == false) goto L132;
        return;
    L132:
        r33 = r33 + 1;
        goto L124
    L177:
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
        r17 = null;
        goto L28
    L139:
        String r36 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L136
    L138:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + r14 + " Pager id: " + r36 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    L136:
        r36 = Integer.toHexString(getId());
        goto L138
    L5:
        r11 = null;
        goto L7
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener r10) {
        List<OnAdapterChangeListener> r11 = this.mAdapterChangeListeners;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener r10) {
        List<OnPageChangeListener> r11 = this.mOnPageChangeListeners;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r10) {
        if (this.mInLayout == false) goto L5;
        removeViewInLayout(r10);
        return;
    L5:
        super.removeView(r10);
    }

    public void setAdapter(@Nullable PagerAdapter r10) {
        PagerAdapter r11 = this.mAdapter;
        int r12 = 0;
        if (r11 == null) goto L9;
        r11.setViewPagerObserver(null);
        this.mAdapter.startUpdate(this);
        int r13 = 0;
    L6:
        if (r13 >= this.mItems.size()) goto L8;
        ItemInfo r14 = this.mItems.get(r13);
        this.mAdapter.destroyItem(this, r14.position, r14.object);
        r13 = r13 + 1;
        goto L6
    L8:
        this.mAdapter.finishUpdate(this);
        this.mItems.clear();
        removeNonDecorViews();
        this.mCurItem = 0;
        scrollTo(0, 0);
    L9:
        PagerAdapter r15 = this.mAdapter;
        this.mAdapter = r10;
        this.mExpectedAdapterCount = 0;
        if (r10 != null) goto L12;
    L20:
        List<OnAdapterChangeListener> r16 = this.mAdapterChangeListeners;
        if (r16 != null) goto L23;
        return;
    L23:
        if (r16.isEmpty() == true) goto L30;
        int r17 = this.mAdapterChangeListeners.size();
    L25:
        if (r12 >= r17) goto L31;
        this.mAdapterChangeListeners.get(r12).onAdapterChanged(this, r15, r10);
        r12 = r12 + 1;
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
        boolean r18 = this.mFirstLayout;
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
        if (r18 == true) goto L19;
        populate();
        goto L20
    L19:
        requestLayout();
        goto L20
    }

    public void setCurrentItem(int r10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r10, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int r10, boolean r11) {
        this.mPopulatePending = false;
        setCurrentItemInternal(r10, r11, false);
    }

    void setCurrentItemInternal(int r10, boolean r11, boolean r12) {
        setCurrentItemInternal(r10, r11, r12, 0);
    }

    void setCurrentItemInternal(int r10, boolean r11, boolean r12, int r13) {
        PagerAdapter r14 = this.mAdapter;
        boolean r15 = false;
        if (r14 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r14.getCount() <= 0) goto L39;
        if (r12 == true) goto L15;
        if (this.mCurItem != r10) goto L15;
        if (this.mItems.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r10 >= 0) goto L18;
        r10 = 0;
    L20:
        int r16 = this.mOffscreenPageLimit;
        int r17 = this.mCurItem;
        if (r10 <= (r17 + r16)) goto L23;
    L24:
        int r18 = 0;
    L26:
        if (r18 >= this.mItems.size()) goto L29;
        this.mItems.get(r18).scrolling = true;
        r18 = r18 + 1;
    L29:
        if (this.mCurItem == r10) goto L32;
        r15 = true;
    L32:
        if (this.mFirstLayout == false) goto L37;
        this.mCurItem = r10;
        if (r15 == false) goto L36;
        dispatchOnPageSelected(r10);
    L36:
        requestLayout();
        return;
    L37:
        populate(r10);
        scrollToItem(r10, r11, r13, r15);
        return;
    L23:
        if (r10 >= (r17 - r16)) goto L29;
    L18:
        if (r10 < this.mAdapter.getCount()) goto L20;
        r10 = this.mAdapter.getCount() - 1;
        goto L20
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener r10) {
        OnPageChangeListener r11 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = r10;
        return r11;
    }

    public void setOffscreenPageLimit(int r10) {
        if (r10 >= 1) goto L6;
        Log.w(TAG, "Requested offscreen page limit " + r10 + " too small; defaulting to 1");
        r10 = 1;
    L6:
        if (r10 == this.mOffscreenPageLimit) goto L9;
        this.mOffscreenPageLimit = r10;
        populate();
        return;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener r10) {
        this.mOnPageChangeListener = r10;
    }

    public void setPageMargin(int r10) {
        int r11 = this.mPageMargin;
        this.mPageMargin = r10;
        int r12 = getWidth();
        recomputeScrollPosition(r12, r12, r10, r11);
        requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int r10) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r10));
    }

    public void setPageMarginDrawable(@Nullable Drawable r10) {
        this.mMarginDrawable = r10;
        if (r10 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r10 != null) goto L7;
        boolean r11 = true;
    L8:
        setWillNotDraw(r11);
        invalidate();
        return;
    L7:
        r11 = false;
        goto L8
    }

    public void setPageTransformer(boolean r10, @Nullable PageTransformer r11) {
        setPageTransformer(r10, r11, 2);
    }

    public void setPageTransformer(boolean r10, @Nullable PageTransformer r11, int r12) {
        int r13 = 1;
        if (r11 == null) goto L5;
        boolean r14 = true;
    L7:
        if (this.mPageTransformer == null) goto L9;
        boolean r15 = true;
    L10:
        if (r14 == r15) goto L12;
        boolean r16 = true;
    L13:
        this.mPageTransformer = r11;
        setChildrenDrawingOrderEnabled(r14);
        if (r14 == false) goto L18;
        if (r10 == false) goto L17;
        r13 = 2;
    L17:
        this.mDrawingOrder = r13;
        this.mPageTransformerLayerType = r12;
    L19:
        if (r16 == false) goto L22;
        populate();
        return;
    L22:
        return;
    L18:
        this.mDrawingOrder = 0;
        goto L19
    L12:
        r16 = false;
        goto L13
    L9:
        r15 = false;
        goto L10
    L5:
        r14 = false;
        goto L7
    }

    void setScrollState(int r10) {
        if (this.mScrollState != r10) goto L5;
        return;
    L5:
        this.mScrollState = r10;
        if (this.mPageTransformer == null) goto L11;
        if (r10 == 0) goto L9;
        boolean r11 = true;
    L10:
        enableLayers(r11);
        goto L11
    L9:
        r11 = false;
    L11:
        dispatchOnScrollStateChanged(r10);
    }

    void smoothScrollTo(int r10, int r11) {
        smoothScrollTo(r10, r11, 0);
    }

    void smoothScrollTo(int r10, int r11, int r12) {
        if (getChildCount() != 0) goto L6;
        setScrollingCacheEnabled(false);
        return;
    L6:
        Scroller r13 = this.mScroller;
        if (r13 != null) goto L9;
    L11:
        boolean r14 = false;
    L12:
        if (r14 == true) goto L14;
        int r15 = getScrollX();
    L19:
        int r16 = r15;
        int r17 = getScrollY();
        int r18 = r10 - r16;
        int r19 = r11 - r17;
        if (r18 != 0) goto L24;
        if (r19 != 0) goto L24;
        completeScroll(false);
        populate();
        setScrollState(0);
        return;
    L24:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r110 = getClientWidth();
        int r111 = r110 / 2;
        float r112 = r110;
        float r113 = r111;
        float r114 = r113 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(r18) * 1.0f) / r112)) * r113);
        int r115 = Math.abs(r12);
        if (r115 <= 0) goto L27;
        int r116 = Math.round(Math.abs(r114 / r115) * 1000.0f) * 4;
    L28:
        int r20 = Math.min(r116, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(r16, r17, r18, r19, r20);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L27:
        r116 = (int) (((Math.abs(r18) / ((r112 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        goto L28
    L14:
        if (this.mIsScrollStarted == false) goto L16;
        r15 = this.mScroller.getCurrX();
    L17:
        this.mScroller.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L19
    L16:
        r15 = this.mScroller.getStartX();
        goto L17
    L9:
        if (r13.isFinished() == true) goto L11;
        r14 = true;
        goto L12
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10 == this.mMarginDrawable) goto L8;
        return false;
    }
}

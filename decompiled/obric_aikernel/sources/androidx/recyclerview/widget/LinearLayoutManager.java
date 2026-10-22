package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    static class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        AnchorInfo() {
            reset();
        }

        void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r10 = this.mOrientationHelper.getEndAfterPadding();
        L6:
            this.mCoordinate = r10;
            return;
        L5:
            r10 = this.mOrientationHelper.getStartAfterPadding();
            goto L6
        }

        public void assignFromView(View r10, int r11) {
            if (this.mLayoutFromEnd == false) goto L5;
            int r12 = this.mOrientationHelper.getDecoratedEnd(r10) + this.mOrientationHelper.getTotalSpaceChange();
        L6:
            this.mCoordinate = r12;
            this.mPosition = r11;
            return;
        L5:
            r12 = this.mOrientationHelper.getDecoratedStart(r10);
            goto L6
        }

        public void assignFromViewAndKeepVisibleRect(View r10, int r11) {
            int r12 = this.mOrientationHelper.getTotalSpaceChange();
            if (r12 < 0) goto L6;
            assignFromView(r10, r11);
            return;
        L6:
            this.mPosition = r11;
            if (this.mLayoutFromEnd == false) goto L13;
            int r13 = (this.mOrientationHelper.getEndAfterPadding() - r12) - this.mOrientationHelper.getDecoratedEnd(r10);
            this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - r13;
            if (r13 <= 0) goto L19;
            int r14 = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(r10);
            int r15 = this.mOrientationHelper.getStartAfterPadding();
            int r16 = r14 - (r15 + Math.min(this.mOrientationHelper.getDecoratedStart(r10) - r15, 0));
            if (r16 >= 0) goto L20;
            this.mCoordinate += Math.min(r13, -r16);
            return;
        L20:
            return;
        L19:
            return;
        L13:
            int r17 = this.mOrientationHelper.getDecoratedStart(r10);
            int r18 = r17 - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = r17;
            if (r18 <= 0) goto L22;
            int r19 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - r12) - this.mOrientationHelper.getDecoratedEnd(r10))) - (r17 + this.mOrientationHelper.getDecoratedMeasurement(r10));
            if (r19 >= 0) goto L23;
            this.mCoordinate -= Math.min(r18, -r19);
            return;
        L23:
            return;
        }

        boolean isViewValidAsAnchor(View r10, RecyclerView.State r11) {
            RecyclerView.LayoutParams r12 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            if (r12.isItemRemoved() == false) goto L5;
        L9:
            return false;
        L5:
            if (r12.getViewLayoutPosition() < 0) goto L9;
            if (r12.getViewLayoutPosition() >= r11.getItemCount()) goto L9;
            return true;
        }

        void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
        }
    }

    protected static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtraFillSpace;
        boolean mInfinite;
        boolean mIsPreLayout;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mNoRecycleSpace;
        int mOffset;
        boolean mRecycle;
        List<RecyclerView.ViewHolder> mScrapList;
        int mScrollingOffset;

        LayoutState() {
            this.mRecycle = true;
            this.mExtraFillSpace = 0;
            this.mNoRecycleSpace = 0;
            this.mIsPreLayout = false;
            this.mScrapList = null;
        }

        private View nextViewFromScrapList() {
            int r10 = this.mScrapList.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L12;
            View r12 = this.mScrapList.get(r11).itemView;
            RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r12.getLayoutParams();
            if (r13.isItemRemoved() == true) goto L11;
            if (this.mCurrentPosition != r13.getViewLayoutPosition()) goto L11;
            assignPositionFromScrapList(r12);
            return r12;
        L11:
            r11 = r11 + 1;
            goto L3
        L12:
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        public void assignPositionFromScrapList(View r10) {
            View r11 = nextViewInLimitedList(r10);
            if (r11 != null) goto L5;
            int r12 = -1;
        L6:
            this.mCurrentPosition = r12;
            return;
        L5:
            r12 = ((RecyclerView.LayoutParams) r11.getLayoutParams()).getViewLayoutPosition();
            goto L6
        }

        boolean hasMore(RecyclerView.State r10) {
            int r11 = this.mCurrentPosition;
            if (r11 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r11 >= r10.getItemCount()) goto L7;
            return true;
        }

        void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        View next(RecyclerView.Recycler r10) {
            if (this.mScrapList != null) goto L5;
            View r11 = r10.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return r11;
        L5:
            return nextViewFromScrapList();
        }

        public View nextViewInLimitedList(View r10) {
            int r11 = this.mScrapList.size();
            View r12 = null;
            int r13 = Integer.MAX_VALUE;
            int r14 = 0;
        L3:
            if (r14 >= r11) goto L18;
            View r15 = this.mScrapList.get(r14).itemView;
            RecyclerView.LayoutParams r16 = (RecyclerView.LayoutParams) r15.getLayoutParams();
            if (r15 == r10) goto L17;
            if (r16.isItemRemoved() == true) goto L17;
            int r17 = (r16.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
            if (r17 < 0) goto L17;
            if (r17 >= r13) goto L17;
            r12 = r15;
            if (r17 == 0) goto L18;
            r13 = r17;
        L17:
            r14 = r14 + 1;
        L18:
            return r12;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        SavedState(Parcel r10) {
            this.mAnchorPosition = r10.readInt();
            this.mAnchorOffset = r10.readInt();
            boolean r11 = true;
            if (r10.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.mAnchorLayoutFromEnd = r11;
        }

        public SavedState(SavedState r10) {
            this.mAnchorPosition = r10.mAnchorPosition;
            this.mAnchorOffset = r10.mAnchorOffset;
            this.mAnchorLayoutFromEnd = r10.mAnchorLayoutFromEnd;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean hasValidAnchor() {
            if (this.mAnchorPosition < 0) goto L5;
            return true;
        L5:
            return false;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.mAnchorPosition);
            r10.writeInt(this.mAnchorOffset);
            r10.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context r10) {
        this(r10, 1, false);
    }

    public LinearLayoutManager(Context r10, int r11, boolean r12) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(r11);
        setReverseLayout(r12);
    }

    public LinearLayoutManager(Context r10, AttributeSet r11, int r12, int r13) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties r14 = RecyclerView.LayoutManager.getProperties(r10, r11, r12, r13);
        setOrientation(r14.orientation);
        setReverseLayout(r14.reverseLayout);
        setStackFromEnd(r14.stackFromEnd);
    }

    private int computeScrollExtent(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(r10, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(r10, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(r10, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.Recycler r10, RecyclerView.State r11) {
        return findReferenceChild(r10, r11, 0, getChildCount(), r11.getItemCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.Recycler r10, RecyclerView.State r11) {
        return findReferenceChild(r10, r11, getChildCount() - 1, -1, r11.getItemCount());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout == false) goto L6;
        return findFirstPartiallyOrCompletelyInvisibleChild();
    L6:
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout == false) goto L6;
        return findLastPartiallyOrCompletelyInvisibleChild();
    L6:
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mShouldReverseLayout == false) goto L6;
        return findFirstReferenceChild(r10, r11);
    L6:
        return findLastReferenceChild(r10, r11);
    }

    private View findReferenceChildClosestToStart(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mShouldReverseLayout == false) goto L6;
        return findLastReferenceChild(r10, r11);
    L6:
        return findFirstReferenceChild(r10, r11);
    }

    private int fixLayoutEndGap(int r10, RecyclerView.Recycler r11, RecyclerView.State r12, boolean r13) {
        int r14 = this.mOrientationHelper.getEndAfterPadding() - r10;
        if (r14 <= 0) goto L11;
        int r15 = -scrollBy(-r14, r11, r12);
        int r16 = r10 + r15;
        if (r13 == false) goto L10;
        int r17 = this.mOrientationHelper.getEndAfterPadding() - r16;
        if (r17 <= 0) goto L10;
        this.mOrientationHelper.offsetChildren(r17);
        return r17 + r15;
    L10:
        return r15;
    L11:
        return 0;
    }

    private int fixLayoutStartGap(int r10, RecyclerView.Recycler r11, RecyclerView.State r12, boolean r13) {
        int r14 = r10 - this.mOrientationHelper.getStartAfterPadding();
        if (r14 <= 0) goto L10;
        int r15 = -scrollBy(r14, r11, r12);
        int r16 = r10 + r15;
        if (r13 == false) goto L12;
        int r17 = r16 - this.mOrientationHelper.getStartAfterPadding();
        if (r17 <= 0) goto L13;
        this.mOrientationHelper.offsetChildren(-r17);
        return r15 - r17;
    L13:
        return r15;
    L12:
        return r15;
    L10:
        return 0;
    }

    private View getChildClosestToEnd() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r10 = 0;
    L7:
        return getChildAt(r10);
    L5:
        r10 = getChildCount() - 1;
        goto L7
    }

    private View getChildClosestToStart() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r10 = getChildCount() - 1;
    L7:
        return getChildAt(r10);
    L5:
        r10 = 0;
        goto L7
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler r16, RecyclerView.State r17, int r18, int r19) {
        if (r17.willRunPredictiveAnimations() == true) goto L5;
        return;
    L5:
        if (getChildCount() != 0) goto L7;
        return;
    L7:
        if (r17.isPreLayout() == false) goto L9;
        return;
    L9:
        if (supportsPredictiveItemAnimations() == false) goto L42;
        List<RecyclerView.ViewHolder> r10 = r16.getScrapList();
        int r11 = r10.size();
        int r12 = getPosition(getChildAt(0));
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L12:
        if (r13 >= r11) goto L28;
        RecyclerView.ViewHolder r110 = r10.get(r13);
        if (r110.isRemoved() == true) goto L27;
        byte r111 = 1;
        if (r110.getLayoutPosition() >= r12) goto L19;
        boolean r112 = true;
    L21:
        if (r112 == this.mShouldReverseLayout) goto L23;
        r111 = -1;
    L23:
        int r113 = this.mOrientationHelper.getDecoratedMeasurement(r110.itemView);
        if (r111 != (-1)) goto L26;
        r14 = r14 + r113;
        goto L27
    L26:
        r15 = r15 + r113;
        goto L27
    L19:
        r112 = false;
    L27:
        r13 = r13 + 1;
        goto L12
    L28:
        this.mLayoutState.mScrapList = r10;
        if (r14 <= 0) goto L31;
        updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), r18);
        LayoutState r20 = this.mLayoutState;
        r20.mExtraFillSpace = r14;
        r20.mAvailable = 0;
        r20.assignPositionFromScrapList();
        fill(r16, this.mLayoutState, r17, false);
    L31:
        if (r15 <= 0) goto L33;
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), r19);
        LayoutState r21 = this.mLayoutState;
        r21.mExtraFillSpace = r15;
        r21.mAvailable = 0;
        r21.assignPositionFromScrapList();
        fill(r16, this.mLayoutState, r17, false);
    L33:
        this.mLayoutState.mScrapList = null;
        return;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L6;
        View r11 = getChildAt(r10);
        Log.d(TAG, "item " + getPosition(r11) + ", coord:" + this.mOrientationHelper.getDecoratedStart(r11));
        r10 = r10 + 1;
        goto L4
    L6:
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler r10, LayoutState r11) {
        if (r11.mRecycle == true) goto L5;
        return;
    L5:
        if (r11.mInfinite == true) goto L14;
        int r12 = r11.mScrollingOffset;
        int r13 = r11.mNoRecycleSpace;
        if (r11.mLayoutDirection != (-1)) goto L10;
        recycleViewsFromEnd(r10, r12, r13);
        return;
    L10:
        recycleViewsFromStart(r10, r12, r13);
        return;
    }

    private void recycleChildren(RecyclerView.Recycler r10, int r11, int r12) {
        if (r11 != r12) goto L4;
        return;
    L4:
        if (r12 <= r11) goto L8;
        int r13 = r12 - 1;
    L6:
        if (r13 < r11) goto L10;
        removeAndRecycleViewAt(r13, r10);
        r13 = r13 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r11 <= r12) goto L13;
        removeAndRecycleViewAt(r11, r10);
        r11 = r11 - 1;
        goto L8
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler r10, int r11, int r12) {
        int r13 = getChildCount();
        if (r11 >= 0) goto L5;
        return;
    L5:
        int r14 = (this.mOrientationHelper.getEnd() - r11) + r12;
        if (this.mShouldReverseLayout == false) goto L17;
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L33;
        View r16 = getChildAt(r15);
        if (this.mOrientationHelper.getDecoratedStart(r16) < r14) goto L15;
        if (this.mOrientationHelper.getTransformedStartWithDecoration(r16) < r14) goto L15;
        r15 = r15 + 1;
    L15:
        recycleChildren(r10, 0, r15);
        return;
    L33:
        return;
    L17:
        int r17 = r13 - 1;
        int r18 = r17;
    L18:
        if (r18 < 0) goto L34;
        View r19 = getChildAt(r18);
        if (this.mOrientationHelper.getDecoratedStart(r19) < r14) goto L25;
        if (this.mOrientationHelper.getTransformedStartWithDecoration(r19) < r14) goto L25;
        r18 = r18 - 1;
    L25:
        recycleChildren(r10, r17, r18);
        return;
    }

    private void recycleViewsFromStart(RecyclerView.Recycler r10, int r11, int r12) {
        if (r11 >= 0) goto L4;
        return;
    L4:
        int r13 = r11 - r12;
        int r14 = getChildCount();
        if (this.mShouldReverseLayout == false) goto L16;
        int r15 = r14 - 1;
        int r16 = r15;
    L7:
        if (r16 < 0) goto L32;
        View r17 = getChildAt(r16);
        if (this.mOrientationHelper.getDecoratedEnd(r17) > r13) goto L14;
        if (this.mOrientationHelper.getTransformedEndWithDecoration(r17) > r13) goto L14;
        r16 = r16 - 1;
    L14:
        recycleChildren(r10, r15, r16);
        return;
    L32:
        return;
    L16:
        int r18 = 0;
    L17:
        if (r18 >= r14) goto L33;
        View r19 = getChildAt(r18);
        if (this.mOrientationHelper.getDecoratedEnd(r19) > r13) goto L24;
        if (this.mOrientationHelper.getTransformedEndWithDecoration(r19) > r13) goto L24;
        r18 = r18 + 1;
    L24:
        recycleChildren(r10, 0, r18);
        return;
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1) goto L5;
    L8:
        boolean r10 = this.mReverseLayout;
    L9:
        this.mShouldReverseLayout = r10;
        return;
    L5:
        if (isLayoutRTL() == false) goto L8;
        r10 = !this.mReverseLayout;
        goto L9
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler r10, RecyclerView.State r11, AnchorInfo r12) {
        boolean r13 = false;
        if (getChildCount() != 0) goto L5;
        return false;
    L5:
        View r14 = getFocusedChild();
        if (r14 == null) goto L12;
        if (r12.isViewValidAsAnchor(r14, r11) == false) goto L12;
        r12.assignFromViewAndKeepVisibleRect(r14, getPosition(r14));
        return true;
    L12:
        if (this.mLastStackFromEnd == this.mStackFromEnd) goto L15;
        return false;
    L15:
        if (r12.mLayoutFromEnd == false) goto L17;
        View r15 = findReferenceChildClosestToEnd(r10, r11);
    L18:
        if (r15 == null) goto L35;
        r12.assignFromView(r15, getPosition(r15));
        if (r11.isPreLayout() == false) goto L22;
    L34:
        return true;
    L22:
        if (supportsPredictiveItemAnimations() == false) goto L34;
        if (this.mOrientationHelper.getDecoratedStart(r15) < this.mOrientationHelper.getEndAfterPadding()) goto L26;
    L27:
        r13 = true;
    L28:
        if (r13 == false) goto L34;
        boolean r16 = r12.mLayoutFromEnd;
        OrientationHelper r17 = this.mOrientationHelper;
        if (r16 == false) goto L32;
        int r18 = r17.getEndAfterPadding();
    L33:
        r12.mCoordinate = r18;
        goto L34
    L32:
        r18 = r17.getStartAfterPadding();
        goto L33
    L26:
        if (this.mOrientationHelper.getDecoratedEnd(r15) >= this.mOrientationHelper.getStartAfterPadding()) goto L28;
    L35:
        return false;
    L17:
        r15 = findReferenceChildClosestToStart(r10, r11);
        goto L18
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State r10, AnchorInfo r11) {
        boolean r12 = false;
        if (r10.isPreLayout() == true) goto L62;
        int r13 = this.mPendingScrollPosition;
        if (r13 == (-1)) goto L62;
        if (r13 >= 0) goto L10;
    L61:
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        goto L62
    L10:
        if (r13 >= r10.getItemCount()) goto L61;
        r11.mPosition = this.mPendingScrollPosition;
        SavedState r14 = this.mPendingSavedState;
        if (r14 == null) goto L23;
        if (r14.hasValidAnchor() == false) goto L23;
        boolean r15 = this.mPendingSavedState.mAnchorLayoutFromEnd;
        r11.mLayoutFromEnd = r15;
        if (r15 == false) goto L19;
        int r16 = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
    L20:
        r11.mCoordinate = r16;
        return true;
    L19:
        r16 = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
    L23:
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) goto L55;
        View r17 = findViewByPosition(this.mPendingScrollPosition);
        if (r17 == null) goto L44;
        if (this.mOrientationHelper.getDecoratedMeasurement(r17) <= this.mOrientationHelper.getTotalSpace()) goto L31;
        r11.assignCoordinateFromPadding();
        return true;
    L31:
        if ((this.mOrientationHelper.getDecoratedStart(r17) - this.mOrientationHelper.getStartAfterPadding()) >= 0) goto L35;
        r11.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
        r11.mLayoutFromEnd = false;
        return true;
    L35:
        if ((this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r17)) >= 0) goto L39;
        r11.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
        r11.mLayoutFromEnd = true;
        return true;
    L39:
        if (r11.mLayoutFromEnd == false) goto L41;
        int r18 = this.mOrientationHelper.getDecoratedEnd(r17) + this.mOrientationHelper.getTotalSpaceChange();
    L42:
        r11.mCoordinate = r18;
    L54:
        return true;
    L41:
        r18 = this.mOrientationHelper.getDecoratedStart(r17);
        goto L42
    L44:
        if (getChildCount() > 0) goto L46;
    L53:
        r11.assignCoordinateFromPadding();
        goto L54
    L46:
        if (this.mPendingScrollPosition >= getPosition(getChildAt(0))) goto L48;
        boolean r19 = true;
    L50:
        if (r19 != this.mShouldReverseLayout) goto L52;
        r12 = true;
    L52:
        r11.mLayoutFromEnd = r12;
        goto L53
    L48:
        r19 = false;
        goto L50
    L55:
        boolean r20 = this.mShouldReverseLayout;
        r11.mLayoutFromEnd = r20;
        if (r20 == false) goto L58;
        int r21 = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
    L59:
        r11.mCoordinate = r21;
        return true;
    L58:
        r21 = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
    L62:
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler r10, RecyclerView.State r11, AnchorInfo r12) {
        if (updateAnchorFromPendingData(r11, r12) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildren(r10, r11, r12) == false) goto L8;
        return;
    L8:
        r12.assignCoordinateFromPadding();
        if (this.mStackFromEnd == false) goto L11;
        int r13 = r11.getItemCount() - 1;
    L12:
        r12.mPosition = r13;
        return;
    L11:
        r13 = 0;
        goto L12
    }

    private void updateLayoutState(int r10, int r11, boolean r12, RecyclerView.State r13) {
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = r10;
        int[] r14 = this.mReusableIntPair;
        boolean r15 = false;
        r14[0] = 0;
        int r16 = 1;
        r14[1] = 0;
        calculateExtraLayoutSpace(r13, r14);
        int r17 = Math.max(0, this.mReusableIntPair[0]);
        int r18 = Math.max(0, this.mReusableIntPair[1]);
        if (r10 != 1) goto L5;
        r15 = true;
    L5:
        LayoutState r19 = this.mLayoutState;
        if (r15 == false) goto L8;
        int r20 = r18;
    L9:
        r19.mExtraFillSpace = r20;
        if (r15 == true) goto L13;
        r17 = r18;
    L13:
        r19.mNoRecycleSpace = r17;
        if (r15 == false) goto L19;
        r19.mExtraFillSpace = r20 + this.mOrientationHelper.getEndPadding();
        View r21 = getChildClosestToEnd();
        LayoutState r22 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L18;
        r16 = -1;
    L18:
        r22.mItemDirection = r16;
        int r23 = getPosition(r21);
        LayoutState r24 = this.mLayoutState;
        r22.mCurrentPosition = r23 + r24.mItemDirection;
        r24.mOffset = this.mOrientationHelper.getDecoratedEnd(r21);
        int r25 = this.mOrientationHelper.getDecoratedEnd(r21) - this.mOrientationHelper.getEndAfterPadding();
    L24:
        LayoutState r26 = this.mLayoutState;
        r26.mAvailable = r11;
        if (r12 == false) goto L27;
        r26.mAvailable = r11 - r25;
    L27:
        r26.mScrollingOffset = r25;
        return;
    L19:
        View r27 = getChildClosestToStart();
        this.mLayoutState.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
        LayoutState r28 = this.mLayoutState;
        if (this.mShouldReverseLayout == true) goto L23;
        r16 = -1;
    L23:
        r28.mItemDirection = r16;
        int r29 = getPosition(r27);
        LayoutState r30 = this.mLayoutState;
        r28.mCurrentPosition = r29 + r30.mItemDirection;
        r30.mOffset = this.mOrientationHelper.getDecoratedStart(r27);
        r25 = (-this.mOrientationHelper.getDecoratedStart(r27)) + this.mOrientationHelper.getStartAfterPadding();
        goto L24
    L8:
        r20 = r17;
        goto L9
    }

    private void updateLayoutStateToFillEnd(int r10, int r11) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - r11;
        LayoutState r12 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L5;
        int r13 = -1;
    L6:
        r12.mItemDirection = r13;
        r12.mCurrentPosition = r10;
        r12.mLayoutDirection = 1;
        r12.mOffset = r11;
        r12.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r13 = 1;
        goto L6
    }

    private void updateLayoutStateToFillEnd(AnchorInfo r10) {
        updateLayoutStateToFillEnd(r10.mPosition, r10.mCoordinate);
    }

    private void updateLayoutStateToFillStart(int r10, int r11) {
        this.mLayoutState.mAvailable = r11 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState r12 = this.mLayoutState;
        r12.mCurrentPosition = r10;
        if (this.mShouldReverseLayout == false) goto L5;
        int r13 = 1;
    L6:
        r12.mItemDirection = r13;
        r12.mLayoutDirection = -1;
        r12.mOffset = r11;
        r12.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r13 = -1;
        goto L6
    }

    private void updateLayoutStateToFillStart(AnchorInfo r10) {
        updateLayoutStateToFillStart(r10.mPosition, r10.mCoordinate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r10) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r10);
        return;
    }

    protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State r10, @NonNull int[] r11) {
        int r12 = getExtraLayoutSpace(r10);
        if (this.mLayoutState.mLayoutDirection != (-1)) goto L5;
        int r13 = 0;
    L6:
        r11[0] = r12;
        r11[1] = r13;
        return;
    L5:
        r13 = r12;
        r12 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int r10, int r11, RecyclerView.State r12, RecyclerView.LayoutManager.LayoutPrefetchRegistry r13) {
        if (this.mOrientation == 0) goto L7;
        r10 = r11;
    L7:
        if (getChildCount() == 0) goto L16;
        if (r10 == 0) goto L17;
        ensureLayoutState();
        if (r10 <= 0) goto L13;
        int r14 = 1;
    L14:
        updateLayoutState(r14, Math.abs(r10), true, r12);
        collectPrefetchPositionsForLayoutState(r12, this.mLayoutState, r13);
        return;
    L13:
        r14 = -1;
        goto L14
    L17:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int r10, RecyclerView.LayoutManager.LayoutPrefetchRegistry r11) {
        SavedState r12 = this.mPendingSavedState;
        int r13 = -1;
        if (r12 != null) goto L5;
    L7:
        resolveShouldLayoutReverse();
        boolean r14 = this.mShouldReverseLayout;
        int r15 = this.mPendingScrollPosition;
        if (r15 != (-1)) goto L12;
        if (r14 == false) goto L11;
        r15 = r10 - 1;
        goto L12
    L11:
        r15 = 0;
    L12:
        if (r14 == true) goto L15;
        r13 = 1;
    L15:
        int r16 = 0;
    L17:
        if (r16 >= this.mInitialPrefetchItemCount) goto L21;
        if (r15 < 0) goto L25;
        if (r15 >= r10) goto L26;
        r11.addPosition(r15, 0);
        r15 = r15 + r13;
        r16 = r16 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        if (r12.hasValidAnchor() == false) goto L7;
        SavedState r17 = this.mPendingSavedState;
        r14 = r17.mAnchorLayoutFromEnd;
        r15 = r17.mAnchorPosition;
        goto L12
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.State r10, LayoutState r11, RecyclerView.LayoutManager.LayoutPrefetchRegistry r12) {
        int r13 = r11.mCurrentPosition;
        if (r13 >= 0) goto L5;
        return;
    L5:
        if (r13 >= r10.getItemCount()) goto L9;
        r12.addPosition(r13, Math.max(0, r11.mScrollingOffset));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State r10) {
        return computeScrollExtent(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r10) {
        return computeScrollOffset(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r10) {
        return computeScrollRange(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r10) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        boolean r11 = false;
        int r12 = 1;
        if (r10 >= getPosition(getChildAt(0))) goto L10;
        r11 = true;
    L10:
        if (r11 == this.mShouldReverseLayout) goto L13;
        r12 = -1;
    L13:
        if (this.mOrientation != 0) goto L17;
        return new PointF(r12, 0.0f);
    L17:
        return new PointF(0.0f, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State r10) {
        return computeScrollExtent(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r10) {
        return computeScrollOffset(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r10) {
        return computeScrollRange(r10);
    }

    int convertFocusDirectionToLayoutDirection(int r10) {
        if (r10 == 1) goto L43;
        if (r10 == 2) goto L36;
        if (r10 == 17) goto L31;
        if (r10 == 33) goto L26;
        if (r10 == 66) goto L21;
        if (r10 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.mOrientation != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.mOrientation != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.mOrientation != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.mOrientation != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.mOrientation != 1) goto L39;
        return 1;
    L39:
        if (isLayoutRTL() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.mOrientation != 1) goto L46;
        return -1;
    L46:
        if (isLayoutRTL() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    void ensureLayoutState() {
        if (this.mLayoutState != null) goto L6;
        this.mLayoutState = createLayoutState();
        return;
    }

    int fill(RecyclerView.Recycler r10, LayoutState r11, RecyclerView.State r12, boolean r13) {
        int r14 = r11.mAvailable;
        int r15 = r11.mScrollingOffset;
        if (r15 == Integer.MIN_VALUE) goto L7;
        if (r14 >= 0) goto L6;
        r11.mScrollingOffset = r15 + r14;
    L6:
        recycleByLayoutState(r10, r11);
    L7:
        int r16 = r11.mAvailable + r11.mExtraFillSpace;
        LayoutChunkResult r17 = this.mLayoutChunkResult;
    L9:
        if (r11.mInfinite == true) goto L12;
        if (r16 > 0) goto L12;
    L33:
        return r14 - r11.mAvailable;
    L12:
        if (r11.hasMore(r12) == false) goto L33;
        r17.resetInternal();
        layoutChunk(r10, r12, r11, r17);
        if (r17.mFinished == true) goto L33;
        r11.mOffset += r17.mConsumed * r11.mLayoutDirection;
        if (r17.mIgnoreConsumed == true) goto L19;
    L22:
        int r18 = r11.mAvailable;
        int r19 = r17.mConsumed;
        r11.mAvailable = r18 - r19;
        r16 = r16 - r19;
    L23:
        int r20 = r11.mScrollingOffset;
        if (r20 == Integer.MIN_VALUE) goto L29;
        int r21 = r20 + r17.mConsumed;
        r11.mScrollingOffset = r21;
        int r22 = r11.mAvailable;
        if (r22 >= 0) goto L28;
        r11.mScrollingOffset = r21 + r22;
    L28:
        recycleByLayoutState(r10, r11);
    L29:
        if (r13 == false) goto L9;
        if (r17.mFocusable == false) goto L9;
    L19:
        if (r11.mScrapList != null) goto L22;
        if (r12.isPreLayout() == true) goto L23;
        goto L22
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View r10 = findOneVisibleChild(0, getChildCount(), true, false);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return getPosition(r10);
    }

    View findFirstVisibleChildClosestToEnd(boolean r10, boolean r11) {
        if (this.mShouldReverseLayout == false) goto L7;
        int r12 = 0;
        int r13 = getChildCount();
    L6:
        return findOneVisibleChild(r12, r13, r10, r11);
    L7:
        r12 = getChildCount() - 1;
        r13 = -1;
        goto L6
    }

    View findFirstVisibleChildClosestToStart(boolean r10, boolean r11) {
        if (this.mShouldReverseLayout == false) goto L7;
        int r12 = getChildCount() - 1;
        int r13 = -1;
    L6:
        return findOneVisibleChild(r12, r13, r10, r11);
    L7:
        r12 = 0;
        r13 = getChildCount();
        goto L6
    }

    public int findFirstVisibleItemPosition() {
        View r10 = findOneVisibleChild(0, getChildCount(), false, true);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return getPosition(r10);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View r10 = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return getPosition(r10);
    }

    public int findLastVisibleItemPosition() {
        View r10 = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return getPosition(r10);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int r10, int r11) {
        ensureLayoutState();
        if (r11 <= r10) goto L5;
        byte r12 = 1;
    L8:
        if (r12 != 0) goto L12;
        return getChildAt(r10);
    L12:
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(r10)) >= this.mOrientationHelper.getStartAfterPadding()) goto L14;
        int r13 = 16644;
        int r14 = 16388;
    L16:
        if (this.mOrientation != 0) goto L18;
        ViewBoundsCheck r15 = this.mHorizontalBoundCheck;
    L20:
        return r15.findOneViewWithinBoundFlags(r10, r11, r13, r14);
    L18:
        r15 = this.mVerticalBoundCheck;
        goto L20
    L14:
        r13 = 4161;
        r14 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        goto L16
    L5:
        if (r11 >= r10) goto L7;
        r12 = -1;
        goto L8
    L7:
        r12 = 0;
        goto L8
    }

    View findOneVisibleChild(int r10, int r11, boolean r12, boolean r13) {
        ensureLayoutState();
        int r14 = 320;
        if (r12 == false) goto L5;
        int r15 = 24579;
    L6:
        if (r13 == true) goto L10;
        r14 = 0;
    L10:
        if (this.mOrientation != 0) goto L12;
        ViewBoundsCheck r16 = this.mHorizontalBoundCheck;
    L14:
        return r16.findOneViewWithinBoundFlags(r10, r11, r15, r14);
    L12:
        r16 = this.mVerticalBoundCheck;
        goto L14
    L5:
        r15 = 320;
        goto L6
    }

    View findReferenceChild(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14) {
        ensureLayoutState();
        int r15 = this.mOrientationHelper.getStartAfterPadding();
        int r16 = this.mOrientationHelper.getEndAfterPadding();
        if (r13 <= r12) goto L5;
        int r17 = 1;
    L6:
        View r18 = null;
        View r19 = null;
    L7:
        if (r12 == r13) goto L24;
        View r20 = getChildAt(r12);
        int r21 = getPosition(r20);
        if (r21 < 0) goto L23;
        if (r21 >= r14) goto L23;
        if (((RecyclerView.LayoutParams) r20.getLayoutParams()).isItemRemoved() == false) goto L16;
        if (r19 != null) goto L23;
        r19 = r20;
        goto L23
    L16:
        if (this.mOrientationHelper.getDecoratedStart(r20) < r16) goto L18;
    L21:
        if (r18 != null) goto L23;
        r18 = r20;
        goto L23
    L18:
        if (this.mOrientationHelper.getDecoratedEnd(r20) < r15) goto L21;
        return r20;
    L23:
        r12 = r12 + r17;
        goto L7
    L24:
        if (r18 == null) goto L27;
        return r18;
    L27:
        return r19;
    L5:
        r17 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int r10) {
        int r11 = getChildCount();
        if (r11 != 0) goto L6;
        return null;
    L6:
        int r12 = r10 - getPosition(getChildAt(0));
        if (r12 < 0) goto L13;
        if (r12 >= r11) goto L13;
        View r13 = getChildAt(r12);
        if (getPosition(r13) != r10) goto L13;
        return r13;
    L13:
        return super.findViewByPosition(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.State r10) {
        if (r10.hasTargetScrollPosition() == true) goto L5;
        return 0;
    L5:
        return this.mOrientationHelper.getTotalSpace();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    protected boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutState r12, LayoutChunkResult r13) {
        View r14 = r12.next(r10);
        if (r14 != null) goto L6;
        r13.mFinished = true;
        return;
    L6:
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r14.getLayoutParams();
        if (r12.mScrapList != null) goto L15;
        boolean r16 = this.mShouldReverseLayout;
        if (r12.mLayoutDirection != (-1)) goto L11;
        boolean r17 = true;
    L12:
        if (r16 != r17) goto L14;
        addView(r14);
    L22:
        measureChildWithMargins(r14, 0, 0);
        r13.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(r14);
        if (this.mOrientation == 1) goto L25;
        int r18 = getPaddingTop();
        int r19 = this.mOrientationHelper.getDecoratedMeasurementInOther(r14) + r18;
        int r20 = r12.mLayoutDirection;
        int r110 = r12.mOffset;
        if (r20 != (-1)) goto L35;
        int r21 = r110;
        int r22 = r18;
        int r23 = r19;
        int r24 = r110 - r13.mConsumed;
    L36:
        layoutDecoratedWithMargins(r14, r24, r22, r21, r23);
        if (r15.isItemRemoved() == false) goto L39;
    L40:
        r13.mIgnoreConsumed = true;
    L41:
        r13.mFocusable = r14.hasFocusable();
        return;
    L39:
        if (r15.isItemChanged() == false) goto L41;
    L35:
        r22 = r18;
        r21 = r13.mConsumed + r110;
        r23 = r19;
        r24 = r110;
        goto L36
    L25:
        if (isLayoutRTL() == false) goto L27;
        int r25 = getWidth() - getPaddingRight();
        r24 = r25 - this.mOrientationHelper.getDecoratedMeasurementInOther(r14);
    L28:
        int r26 = r12.mLayoutDirection;
        int r111 = r12.mOffset;
        if (r26 != (-1)) goto L31;
        r23 = r111;
        r21 = r25;
        r22 = r111 - r13.mConsumed;
        goto L36
    L31:
        r22 = r111;
        r21 = r25;
        r23 = r13.mConsumed + r111;
        goto L36
    L27:
        r24 = getPaddingLeft();
        r25 = this.mOrientationHelper.getDecoratedMeasurementInOther(r14) + r24;
        goto L28
    L14:
        addView(r14, 0);
        goto L22
    L11:
        r17 = false;
        goto L12
    L15:
        boolean r27 = this.mShouldReverseLayout;
        if (r12.mLayoutDirection != (-1)) goto L18;
        boolean r28 = true;
    L19:
        if (r27 != r28) goto L21;
        addDisappearingView(r14);
        goto L22
    L21:
        addDisappearingView(r14, 0);
        goto L22
    L18:
        r28 = false;
        goto L19
    }

    void onAnchorReady(RecyclerView.Recycler r10, RecyclerView.State r11, AnchorInfo r12, int r13) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r10, RecyclerView.Recycler r11) {
        super.onDetachedFromWindow(r10, r11);
        if (this.mRecycleChildrenOnDetach == false) goto L6;
        removeAndRecycleAllViews(r11);
        r11.clear();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r10, int r11, RecyclerView.Recycler r12, RecyclerView.State r13) {
        resolveShouldLayoutReverse();
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r14 = convertFocusDirectionToLayoutDirection(r11);
        if (r14 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        ensureLayoutState();
        updateLayoutState(r14, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, r13);
        LayoutState r15 = this.mLayoutState;
        r15.mScrollingOffset = Integer.MIN_VALUE;
        r15.mRecycle = false;
        fill(r12, r15, r13, true);
        if (r14 != (-1)) goto L11;
        View r16 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
    L12:
        if (r14 != (-1)) goto L14;
        View r17 = getChildClosestToStart();
    L16:
        if (r17.hasFocusable() == false) goto L20;
        if (r16 != null) goto L19;
        return null;
    L19:
        return r17;
    L20:
        return r16;
    L14:
        r17 = getChildClosestToEnd();
        goto L16
    L11:
        r16 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        if (getChildCount() <= 0) goto L6;
        r10.setFromIndex(findFirstVisibleItemPosition());
        r10.setToIndex(findLastVisibleItemPosition());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        int r12 = -1;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        SavedState r13 = this.mPendingSavedState;
        if (r13 != null) goto L13;
    L15:
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View r14 = getFocusedChild();
        AnchorInfo r15 = this.mAnchorInfo;
        if (r15.mValid == true) goto L18;
    L28:
        r15.reset();
        AnchorInfo r16 = this.mAnchorInfo;
        r16.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
        updateAnchorInfoForLayout(r10, r11, r16);
        this.mAnchorInfo.mValid = true;
    L29:
        LayoutState r17 = this.mLayoutState;
        if (r17.mLastScrollDelta < 0) goto L32;
        int r18 = 1;
    L33:
        r17.mLayoutDirection = r18;
        int[] r19 = this.mReusableIntPair;
        r19[0] = 0;
        r19[1] = 0;
        calculateExtraLayoutSpace(r11, r19);
        int r20 = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int r21 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        if (r11.isPreLayout() == false) goto L49;
        int r22 = this.mPendingScrollPosition;
        if (r22 == (-1)) goto L49;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L49;
        View r23 = findViewByPosition(r22);
        if (r23 == null) goto L49;
        if (this.mShouldReverseLayout == false) goto L44;
        int r24 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r23);
        int r25 = this.mPendingScrollPositionOffset;
    L45:
        int r26 = r24 - r25;
        if (r26 <= 0) goto L48;
        r20 = r20 + r26;
        goto L49
    L48:
        r21 = r21 - r26;
        goto L49
    L44:
        r25 = this.mOrientationHelper.getDecoratedStart(r23) - this.mOrientationHelper.getStartAfterPadding();
        r24 = this.mPendingScrollPositionOffset;
    L49:
        AnchorInfo r27 = this.mAnchorInfo;
        if (r27.mLayoutFromEnd == false) goto L55;
        if (this.mShouldReverseLayout == false) goto L56;
    L53:
        r12 = 1;
    L56:
        onAnchorReady(r10, r11, r27, r12);
        detachAndScrapAttachedViews(r10);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = r11.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo r28 = this.mAnchorInfo;
        if (r28.mLayoutFromEnd == false) goto L64;
        updateLayoutStateToFillStart(r28);
        LayoutState r29 = this.mLayoutState;
        r29.mExtraFillSpace = r20;
        fill(r10, r29, r11, false);
        LayoutState r30 = this.mLayoutState;
        int r31 = r30.mOffset;
        int r32 = r30.mCurrentPosition;
        int r33 = r30.mAvailable;
        if (r33 <= 0) goto L61;
        r21 = r21 + r33;
    L61:
        updateLayoutStateToFillEnd(this.mAnchorInfo);
        LayoutState r34 = this.mLayoutState;
        r34.mExtraFillSpace = r21;
        r34.mCurrentPosition += r34.mItemDirection;
        fill(r10, r34, r11, false);
        LayoutState r35 = this.mLayoutState;
        int r36 = r35.mOffset;
        int r37 = r35.mAvailable;
        if (r37 <= 0) goto L71;
        updateLayoutStateToFillStart(r32, r31);
        LayoutState r38 = this.mLayoutState;
        r38.mExtraFillSpace = r37;
        fill(r10, r38, r11, false);
        r31 = this.mLayoutState.mOffset;
    L71:
        if (getChildCount() > 0) goto L73;
    L77:
        layoutForPredictiveAnimations(r10, r11, r31, r36);
        if (r11.isPreLayout() == true) goto L80;
        this.mOrientationHelper.onLayoutComplete();
    L81:
        this.mLastStackFromEnd = this.mStackFromEnd;
        return;
    L80:
        this.mAnchorInfo.reset();
        goto L81
    L73:
        if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == false) goto L75;
        int r39 = fixLayoutEndGap(r36, r10, r11, true);
        int r40 = r31 + r39;
        int r41 = r36 + r39;
        int r42 = fixLayoutStartGap(r40, r10, r11, false);
    L76:
        r31 = r40 + r42;
        r36 = r41 + r42;
        goto L77
    L75:
        int r43 = fixLayoutStartGap(r31, r10, r11, true);
        r40 = r31 + r43;
        r41 = r36 + r43;
        r42 = fixLayoutEndGap(r41, r10, r11, false);
        goto L76
    L64:
        updateLayoutStateToFillEnd(r28);
        LayoutState r44 = this.mLayoutState;
        r44.mExtraFillSpace = r21;
        fill(r10, r44, r11, false);
        LayoutState r45 = this.mLayoutState;
        r36 = r45.mOffset;
        int r46 = r45.mCurrentPosition;
        int r47 = r45.mAvailable;
        if (r47 <= 0) goto L67;
        r20 = r20 + r47;
    L67:
        updateLayoutStateToFillStart(this.mAnchorInfo);
        LayoutState r48 = this.mLayoutState;
        r48.mExtraFillSpace = r20;
        r48.mCurrentPosition += r48.mItemDirection;
        fill(r10, r48, r11, false);
        LayoutState r49 = this.mLayoutState;
        r31 = r49.mOffset;
        int r50 = r49.mAvailable;
        if (r50 <= 0) goto L71;
        updateLayoutStateToFillEnd(r46, r36);
        LayoutState r51 = this.mLayoutState;
        r51.mExtraFillSpace = r50;
        fill(r10, r51, r11, false);
        r36 = this.mLayoutState.mOffset;
        goto L71
    L55:
        if (this.mShouldReverseLayout == false) goto L53;
    L32:
        r18 = -1;
        goto L33
    L18:
        if (this.mPendingScrollPosition != (-1)) goto L28;
        if (this.mPendingSavedState != null) goto L28;
        if (r14 == null) goto L29;
        if (this.mOrientationHelper.getDecoratedStart(r14) < this.mOrientationHelper.getEndAfterPadding()) goto L26;
    L27:
        this.mAnchorInfo.assignFromViewAndKeepVisibleRect(r14, getPosition(r14));
        goto L29
    L26:
        if (this.mOrientationHelper.getDecoratedEnd(r14) > this.mOrientationHelper.getStartAfterPadding()) goto L29;
    L13:
        if (r13.hasValidAnchor() == false) goto L15;
        this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    L7:
        if (r11.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r10) {
        super.onLayoutCompleted(r10);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == false) goto L6;
        this.mPendingSavedState = (SavedState) r10;
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) goto L5;
        SavedState r10 = new SavedState();
        if (getChildCount() <= 0) goto L12;
        ensureLayoutState();
        boolean r11 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
        r10.mAnchorLayoutFromEnd = r11;
        if (r11 == false) goto L11;
        View r12 = getChildClosestToEnd();
        r10.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r12);
        r10.mAnchorPosition = getPosition(r12);
    L13:
        return r10;
    L11:
        View r13 = getChildClosestToStart();
        r10.mAnchorPosition = getPosition(r13);
        r10.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(r13) - this.mOrientationHelper.getStartAfterPadding();
        goto L13
    L12:
        r10.invalidateAnchor();
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int r14 = getPosition(r10);
        int r15 = getPosition(r11);
        if (r14 >= r15) goto L5;
        byte r16 = 1;
    L7:
        if (this.mShouldReverseLayout == false) goto L11;
        if (r16 != 1) goto L10;
        scrollToPositionWithOffset(r15, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(r11) + this.mOrientationHelper.getDecoratedMeasurement(r10)));
        return;
    L10:
        int r17 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r11);
    L13:
        scrollToPositionWithOffset(r15, r17);
        return;
    L11:
        if (r16 != (-1)) goto L14;
        r17 = this.mOrientationHelper.getDecoratedStart(r11);
        goto L13
    L14:
        scrollToPositionWithOffset(r15, this.mOrientationHelper.getDecoratedEnd(r11) - this.mOrientationHelper.getDecoratedMeasurement(r10));
        return;
    L5:
        r16 = -1;
        goto L7
    }

    boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mOrientationHelper.getEnd() != 0) goto L7;
        return true;
    }

    int scrollBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getChildCount() == 0) goto L17;
        if (r10 == 0) goto L17;
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        if (r10 <= 0) goto L9;
        int r13 = 1;
    L10:
        int r14 = Math.abs(r10);
        updateLayoutState(r13, r14, true, r12);
        LayoutState r15 = this.mLayoutState;
        int r16 = r15.mScrollingOffset + fill(r11, r15, r12, false);
        if (r16 >= 0) goto L13;
        return 0;
    L13:
        if (r14 <= r16) goto L15;
        r10 = r13 * r16;
    L15:
        this.mOrientationHelper.offsetChildren(-r10);
        this.mLayoutState.mLastScrollDelta = r10;
        return r10;
    L9:
        r13 = -1;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (this.mOrientation != 1) goto L7;
        return 0;
    L7:
        return scrollBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r10) {
        this.mPendingScrollPosition = r10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState r11 = this.mPendingSavedState;
        if (r11 == null) goto L5;
        r11.invalidateAnchor();
    L5:
        requestLayout();
    }

    public void scrollToPositionWithOffset(int r10, int r11) {
        this.mPendingScrollPosition = r10;
        this.mPendingScrollPositionOffset = r11;
        SavedState r12 = this.mPendingSavedState;
        if (r12 == null) goto L5;
        r12.invalidateAnchor();
    L5:
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (this.mOrientation != 0) goto L7;
        return 0;
    L7:
        return scrollBy(r10, r11, r12);
    }

    public void setInitialPrefetchItemCount(int r10) {
        this.mInitialPrefetchItemCount = r10;
    }

    public void setOrientation(int r10) {
        if (r10 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r10 == this.mOrientation) goto L11;
    L12:
        OrientationHelper r11 = OrientationHelper.createOrientationHelper(this, r10);
        this.mOrientationHelper = r11;
        this.mAnchorInfo.mOrientationHelper = r11;
        this.mOrientation = r10;
        requestLayout();
        return;
    L11:
        if (this.mOrientationHelper == null) goto L12;
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation:" + r10);
    }

    public void setRecycleChildrenOnDetach(boolean r10) {
        this.mRecycleChildrenOnDetach = r10;
    }

    public void setReverseLayout(boolean r10) {
        assertNotInLayoutOrScroll(null);
        if (r10 != this.mReverseLayout) goto L5;
        return;
    L5:
        this.mReverseLayout = r10;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean r10) {
        this.mSmoothScrollbarEnabled = r10;
    }

    public void setStackFromEnd(boolean r10) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != r10) goto L5;
        return;
    L5:
        this.mStackFromEnd = r10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824) goto L5;
    L9:
        return false;
    L5:
        if (getWidthMode() == 1073741824) goto L9;
        if (hasFlexibleChildInBothOrientations() == false) goto L9;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r10, RecyclerView.State r11, int r12) {
        LinearSmoothScroller r13 = new LinearSmoothScroller(r10.getContext());
        r13.setTargetPosition(r12);
        startSmoothScroll(r13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastStackFromEnd != this.mStackFromEnd) goto L7;
        return true;
    }

    void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean r10 = true;
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        int r11 = getPosition(getChildAt(0));
        int r12 = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayout == false) goto L22;
        int r13 = 1;
    L9:
        if (r13 >= getChildCount()) goto L37;
        View r14 = getChildAt(r13);
        int r15 = getPosition(r14);
        int r16 = this.mOrientationHelper.getDecoratedStart(r14);
        if (r15 < r11) goto L12;
        if (r16 > r12) goto L20;
        r13 = r13 + 1;
        goto L9
    L20:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L12:
        logChildren();
        StringBuilder r17 = new StringBuilder();
        r17.append("detected invalid position. loc invalid? ");
        if (r16 < r12) goto L16;
        r10 = false;
    L16:
        r17.append(r10);
        throw new RuntimeException(r17.toString());
    L37:
        return;
    L22:
        int r18 = 1;
    L24:
        if (r18 >= getChildCount()) goto L44;
        View r19 = getChildAt(r18);
        int r20 = getPosition(r19);
        int r21 = this.mOrientationHelper.getDecoratedStart(r19);
        if (r20 < r11) goto L27;
        if (r21 < r12) goto L35;
        r18 = r18 + 1;
        goto L24
    L35:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L27:
        logChildren();
        StringBuilder r22 = new StringBuilder();
        r22.append("detected invalid position. loc invalid? ");
        if (r21 < r12) goto L31;
        r10 = false;
    L31:
        r22.append(r10);
        throw new RuntimeException(r22.toString());
    }
}

package androidx.recyclerview.widget;

import ai.j0;
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
import androidx.constraintlayout.motion.widget.a;
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

    public static class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r5 = this.mOrientationHelper.getEndAfterPadding();
        L6:
            this.mCoordinate = r5;
            return;
        L5:
            r5 = this.mOrientationHelper.getStartAfterPadding();
            goto L6
        }

        public void assignFromView(View r5, int r10) {
            if (this.mLayoutFromEnd == false) goto L5;
            int r11 = this.mOrientationHelper.getDecoratedEnd(r5);
            this.mCoordinate = this.mOrientationHelper.getTotalSpaceChange() + r11;
        L6:
            this.mPosition = r10;
            return;
        L5:
            this.mCoordinate = this.mOrientationHelper.getDecoratedStart(r5);
            goto L6
        }

        public void assignFromViewAndKeepVisibleRect(View r5, int r10) {
            int r11 = this.mOrientationHelper.getTotalSpaceChange();
            if (r11 < 0) goto L6;
            assignFromView(r5, r10);
            return;
        L6:
            this.mPosition = r10;
            if (this.mLayoutFromEnd == false) goto L13;
            int r12 = (this.mOrientationHelper.getEndAfterPadding() - r11) - this.mOrientationHelper.getDecoratedEnd(r5);
            this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - r12;
            if (r12 <= 0) goto L19;
            int r13 = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(r5);
            int r14 = this.mOrientationHelper.getStartAfterPadding();
            int r15 = r13 - (Math.min(this.mOrientationHelper.getDecoratedStart(r5) - r14, 0) + r14);
            if (r15 >= 0) goto L20;
            this.mCoordinate = Math.min(r12, -r15) + this.mCoordinate;
            return;
        L20:
            return;
        L19:
            return;
        L13:
            int r16 = this.mOrientationHelper.getDecoratedStart(r5);
            int r17 = r16 - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = r16;
            if (r17 <= 0) goto L22;
            int r18 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - r11) - this.mOrientationHelper.getDecoratedEnd(r5))) - (this.mOrientationHelper.getDecoratedMeasurement(r5) + r16);
            if (r18 >= 0) goto L23;
            this.mCoordinate -= Math.min(r17, -r18);
            return;
        L23:
            return;
        }

        public boolean isViewValidAsAnchor(View r5, RecyclerView.State r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r5.getLayoutParams();
            if (r11.isItemRemoved() == false) goto L5;
        L9:
            return false;
        L5:
            if (r11.getViewLayoutPosition() < 0) goto L9;
            if (r11.getViewLayoutPosition() >= r10.getItemCount()) goto L9;
            return true;
        }

        public void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("AnchorInfo{mPosition=");
            r5.append(this.mPosition);
            r5.append(", mCoordinate=");
            r5.append(this.mCoordinate);
            r5.append(", mLayoutFromEnd=");
            r5.append(this.mLayoutFromEnd);
            r5.append(", mValid=");
            return a.w(r5, this.mValid, '}');
        }
    }

    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        public LayoutChunkResult() {
        }

        public void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    public static class LayoutState {
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

        public LayoutState() {
            this.mRecycle = true;
            this.mExtraFillSpace = 0;
            this.mNoRecycleSpace = 0;
            this.mIsPreLayout = false;
            this.mScrapList = null;
        }

        private View nextViewFromScrapList() {
            int r5 = this.mScrapList.size();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L12;
            View r11 = this.mScrapList.get(r10).itemView;
            RecyclerView.LayoutParams r12 = (RecyclerView.LayoutParams) r11.getLayoutParams();
            if (r12.isItemRemoved() == true) goto L11;
            if (this.mCurrentPosition != r12.getViewLayoutPosition()) goto L11;
            assignPositionFromScrapList(r11);
            return r11;
        L11:
            r10 = r10 + 1;
            goto L3
        L12:
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        public boolean hasMore(RecyclerView.State r5) {
            int r10 = this.mCurrentPosition;
            if (r10 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r10 >= r5.getItemCount()) goto L7;
            return true;
        }

        public void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        public View next(RecyclerView.Recycler r5) {
            if (this.mScrapList != null) goto L5;
            View r10 = r5.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return r10;
        L5:
            return nextViewFromScrapList();
        }

        public View nextViewInLimitedList(View r10) {
            int r5 = this.mScrapList.size();
            View r11 = null;
            int r12 = Integer.MAX_VALUE;
            int r13 = 0;
        L3:
            if (r13 >= r5) goto L18;
            View r14 = this.mScrapList.get(r13).itemView;
            RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r14.getLayoutParams();
            if (r14 == r10) goto L17;
            if (r15.isItemRemoved() == true) goto L17;
            int r16 = (r15.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
            if (r16 < 0) goto L17;
            if (r16 >= r12) goto L17;
            r11 = r14;
            if (r16 == 0) goto L18;
            r12 = r16;
        L17:
            r13 = r13 + 1;
        L18:
            return r11;
        }

        public void assignPositionFromScrapList(View r5) {
            View r10 = nextViewInLimitedList(r5);
            if (r10 != null) goto L5;
            this.mCurrentPosition = -1;
            return;
        L5:
            this.mCurrentPosition = ((RecyclerView.LayoutParams) r10.getLayoutParams()).getViewLayoutPosition();
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

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean hasValidAnchor() {
            if (this.mAnchorPosition < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            r5.writeInt(this.mAnchorPosition);
            r5.writeInt(this.mAnchorOffset);
            r5.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        public SavedState(Parcel r5) {
            this.mAnchorPosition = r5.readInt();
            this.mAnchorOffset = r5.readInt();
            boolean r10 = true;
            if (r5.readInt() == 1) goto L6;
            r10 = false;
        L6:
            this.mAnchorLayoutFromEnd = r10;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState r5) {
            this.mAnchorPosition = r5.mAnchorPosition;
            this.mAnchorOffset = r5.mAnchorOffset;
            this.mAnchorLayoutFromEnd = r5.mAnchorLayoutFromEnd;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context r5) {
        this(r5, 1, false);
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

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
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

    private int fixLayoutEndGap(int r5, RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        int r13 = this.mOrientationHelper.getEndAfterPadding() - r5;
        if (r13 <= 0) goto L11;
        int r14 = -scrollBy(-r13, r10, r11);
        int r15 = r5 + r14;
        if (r12 == false) goto L10;
        int r16 = this.mOrientationHelper.getEndAfterPadding() - r15;
        if (r16 <= 0) goto L10;
        this.mOrientationHelper.offsetChildren(r16);
        return r16 + r14;
    L10:
        return r14;
    L11:
        return 0;
    }

    private int fixLayoutStartGap(int r5, RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        int r13 = r5 - this.mOrientationHelper.getStartAfterPadding();
        if (r13 <= 0) goto L10;
        int r14 = -scrollBy(r13, r10, r11);
        int r15 = r5 + r14;
        if (r12 == false) goto L12;
        int r16 = r15 - this.mOrientationHelper.getStartAfterPadding();
        if (r16 <= 0) goto L13;
        this.mOrientationHelper.offsetChildren(-r16);
        return r14 - r16;
    L13:
        return r14;
    L12:
        return r14;
    L10:
        return 0;
    }

    private View getChildClosestToEnd() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r5 = 0;
    L7:
        return getChildAt(r5);
    L5:
        r5 = getChildCount() - 1;
        goto L7
    }

    private View getChildClosestToStart() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r5 = getChildCount() - 1;
    L7:
        return getChildAt(r5);
    L5:
        r5 = 0;
        goto L7
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler r11, RecyclerView.State r12, int r13, int r14) {
        if (r12.willRunPredictiveAnimations() == true) goto L5;
        return;
    L5:
        if (getChildCount() != 0) goto L7;
        return;
    L7:
        if (r12.isPreLayout() == false) goto L9;
        return;
    L9:
        if (supportsPredictiveItemAnimations() == false) goto L39;
        List<RecyclerView.ViewHolder> r5 = r11.getScrapList();
        int r10 = r5.size();
        int r15 = getPosition(getChildAt(0));
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L12:
        if (r16 >= r10) goto L25;
        RecyclerView.ViewHolder r19 = r5.get(r16);
        if (r19.isRemoved() == true) goto L24;
        if (r19.getLayoutPosition() >= r15) goto L19;
        boolean r20 = true;
    L21:
        if (r20 == this.mShouldReverseLayout) goto L23;
        r17 = r17 + this.mOrientationHelper.getDecoratedMeasurement(r19.itemView);
        goto L24
    L23:
        r18 = r18 + this.mOrientationHelper.getDecoratedMeasurement(r19.itemView);
        goto L24
    L19:
        r20 = false;
    L24:
        r16 = r16 + 1;
        goto L12
    L25:
        this.mLayoutState.mScrapList = r5;
        if (r17 <= 0) goto L28;
        updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), r13);
        LayoutState r110 = this.mLayoutState;
        r110.mExtraFillSpace = r17;
        r110.mAvailable = 0;
        r110.assignPositionFromScrapList();
        fill(r11, this.mLayoutState, r12, false);
    L28:
        if (r18 <= 0) goto L30;
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), r14);
        LayoutState r111 = this.mLayoutState;
        r111.mExtraFillSpace = r18;
        r111.mAvailable = 0;
        r111.assignPositionFromScrapList();
        fill(r11, this.mLayoutState, r12, false);
    L30:
        this.mLayoutState.mScrapList = null;
        return;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        int r5 = 0;
    L4:
        if (r5 >= getChildCount()) goto L6;
        View r10 = getChildAt(r5);
        Log.d(TAG, "item " + getPosition(r10) + ", coord:" + this.mOrientationHelper.getDecoratedStart(r10));
        r5 = r5 + 1;
        goto L4
    L6:
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler r5, LayoutState r10) {
        if (r10.mRecycle == true) goto L5;
        return;
    L5:
        if (r10.mInfinite == true) goto L14;
        int r11 = r10.mScrollingOffset;
        int r12 = r10.mNoRecycleSpace;
        if (r10.mLayoutDirection != (-1)) goto L10;
        recycleViewsFromEnd(r5, r11, r12);
        return;
    L10:
        recycleViewsFromStart(r5, r11, r12);
        return;
    }

    private void recycleChildren(RecyclerView.Recycler r5, int r10, int r11) {
        if (r10 != r11) goto L4;
        return;
    L4:
        if (r11 <= r10) goto L8;
        int r12 = r11 - 1;
    L6:
        if (r12 < r10) goto L10;
        removeAndRecycleViewAt(r12, r5);
        r12 = r12 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r10 <= r11) goto L13;
        removeAndRecycleViewAt(r10, r5);
        r10 = r10 - 1;
        goto L8
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler r5, int r10, int r11) {
        int r12 = getChildCount();
        if (r10 >= 0) goto L5;
        return;
    L5:
        int r13 = (this.mOrientationHelper.getEnd() - r10) + r11;
        if (this.mShouldReverseLayout == false) goto L17;
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L33;
        View r15 = getChildAt(r14);
        if (this.mOrientationHelper.getDecoratedStart(r15) < r13) goto L15;
        if (this.mOrientationHelper.getTransformedStartWithDecoration(r15) < r13) goto L15;
        r14 = r14 + 1;
    L15:
        recycleChildren(r5, 0, r14);
        return;
    L33:
        return;
    L17:
        int r16 = r12 - 1;
        int r17 = r16;
    L18:
        if (r17 < 0) goto L34;
        View r18 = getChildAt(r17);
        if (this.mOrientationHelper.getDecoratedStart(r18) < r13) goto L25;
        if (this.mOrientationHelper.getTransformedStartWithDecoration(r18) < r13) goto L25;
        r17 = r17 - 1;
    L25:
        recycleChildren(r5, r16, r17);
        return;
    }

    private void recycleViewsFromStart(RecyclerView.Recycler r5, int r10, int r11) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        int r12 = r10 - r11;
        int r13 = getChildCount();
        if (this.mShouldReverseLayout == false) goto L16;
        int r14 = r13 - 1;
        int r15 = r14;
    L7:
        if (r15 < 0) goto L32;
        View r16 = getChildAt(r15);
        if (this.mOrientationHelper.getDecoratedEnd(r16) > r12) goto L14;
        if (this.mOrientationHelper.getTransformedEndWithDecoration(r16) > r12) goto L14;
        r15 = r15 - 1;
    L14:
        recycleChildren(r5, r14, r15);
        return;
    L32:
        return;
    L16:
        int r17 = 0;
    L17:
        if (r17 >= r13) goto L33;
        View r18 = getChildAt(r17);
        if (this.mOrientationHelper.getDecoratedEnd(r18) > r12) goto L24;
        if (this.mOrientationHelper.getTransformedEndWithDecoration(r18) > r12) goto L24;
        r17 = r17 + 1;
    L24:
        recycleChildren(r5, 0, r17);
        return;
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1) goto L5;
    L8:
        this.mShouldReverseLayout = this.mReverseLayout;
        return;
    L5:
        if (isLayoutRTL() == false) goto L8;
        this.mShouldReverseLayout = !this.mReverseLayout;
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler r5, RecyclerView.State r10, AnchorInfo r11) {
        boolean r12 = false;
        if (getChildCount() != 0) goto L5;
        return false;
    L5:
        View r13 = getFocusedChild();
        if (r13 != null) goto L8;
    L11:
        boolean r14 = this.mLastStackFromEnd;
        boolean r15 = this.mStackFromEnd;
        if (r14 == r15) goto L14;
        return false;
    L14:
        View r16 = findReferenceChild(r5, r10, r11.mLayoutFromEnd, r15);
        if (r16 == null) goto L35;
        r11.assignFromView(r16, getPosition(r16));
        if (r10.isPreLayout() == false) goto L19;
    L34:
        return true;
    L19:
        if (supportsPredictiveItemAnimations() == false) goto L34;
        int r17 = this.mOrientationHelper.getDecoratedStart(r16);
        int r18 = this.mOrientationHelper.getDecoratedEnd(r16);
        int r19 = this.mOrientationHelper.getStartAfterPadding();
        int r20 = this.mOrientationHelper.getEndAfterPadding();
        if (r18 > r19) goto L24;
        if (r17 >= r19) goto L24;
        boolean r21 = true;
    L25:
        if (r17 < r20) goto L28;
        if (r18 <= r20) goto L28;
        r12 = true;
    L28:
        if (r21 == true) goto L31;
        if (r12 == false) goto L34;
    L31:
        if (r11.mLayoutFromEnd == false) goto L33;
        r19 = r20;
    L33:
        r11.mCoordinate = r19;
    L24:
        r21 = false;
        goto L25
    L35:
        return false;
    L8:
        if (r11.isViewValidAsAnchor(r13, r10) == false) goto L11;
        r11.assignFromViewAndKeepVisibleRect(r13, getPosition(r13));
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State r5, AnchorInfo r10) {
        boolean r11 = false;
        if (r5.isPreLayout() == true) goto L60;
        int r12 = this.mPendingScrollPosition;
        if (r12 == (-1)) goto L60;
        if (r12 >= 0) goto L10;
    L59:
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r12 >= r5.getItemCount()) goto L59;
        r10.mPosition = this.mPendingScrollPosition;
        SavedState r13 = this.mPendingSavedState;
        if (r13 == null) goto L22;
        if (r13.hasValidAnchor() == false) goto L22;
        boolean r14 = this.mPendingSavedState.mAnchorLayoutFromEnd;
        r10.mLayoutFromEnd = r14;
        if (r14 == false) goto L19;
        r10.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
    L20:
        return true;
    L19:
        r10.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
    L22:
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) goto L54;
        View r15 = findViewByPosition(this.mPendingScrollPosition);
        if (r15 == null) goto L43;
        if (this.mOrientationHelper.getDecoratedMeasurement(r15) <= this.mOrientationHelper.getTotalSpace()) goto L30;
        r10.assignCoordinateFromPadding();
        return true;
    L30:
        if ((this.mOrientationHelper.getDecoratedStart(r15) - this.mOrientationHelper.getStartAfterPadding()) >= 0) goto L34;
        r10.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
        r10.mLayoutFromEnd = false;
        return true;
    L34:
        if ((this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r15)) >= 0) goto L38;
        r10.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
        r10.mLayoutFromEnd = true;
        return true;
    L38:
        if (r10.mLayoutFromEnd == false) goto L40;
        int r16 = this.mOrientationHelper.getTotalSpaceChange() + this.mOrientationHelper.getDecoratedEnd(r15);
    L41:
        r10.mCoordinate = r16;
    L53:
        return true;
    L40:
        r16 = this.mOrientationHelper.getDecoratedStart(r15);
        goto L41
    L43:
        if (getChildCount() > 0) goto L45;
    L52:
        r10.assignCoordinateFromPadding();
        goto L53
    L45:
        if (this.mPendingScrollPosition >= getPosition(getChildAt(0))) goto L47;
        boolean r17 = true;
    L49:
        if (r17 != this.mShouldReverseLayout) goto L51;
        r11 = true;
    L51:
        r10.mLayoutFromEnd = r11;
        goto L52
    L47:
        r17 = false;
        goto L49
    L54:
        boolean r18 = this.mShouldReverseLayout;
        r10.mLayoutFromEnd = r18;
        if (r18 == false) goto L57;
        r10.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
    L58:
        return true;
    L57:
        r10.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
    L60:
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler r5, RecyclerView.State r10, AnchorInfo r11) {
        if (updateAnchorFromPendingData(r10, r11) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildren(r5, r10, r11) == false) goto L8;
        return;
    L8:
        r11.assignCoordinateFromPadding();
        if (this.mStackFromEnd == false) goto L11;
        int r12 = r10.getItemCount() - 1;
    L12:
        r11.mPosition = r12;
        return;
    L11:
        r12 = 0;
        goto L12
    }

    private void updateLayoutState(int r5, int r10, boolean r11, RecyclerView.State r12) {
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = r5;
        int[] r13 = this.mReusableIntPair;
        boolean r14 = false;
        r13[0] = 0;
        int r15 = 1;
        r13[1] = 0;
        calculateExtraLayoutSpace(r12, r13);
        int r16 = Math.max(0, this.mReusableIntPair[0]);
        int r17 = Math.max(0, this.mReusableIntPair[1]);
        if (r5 != 1) goto L5;
        r14 = true;
    L5:
        LayoutState r18 = this.mLayoutState;
        if (r14 == false) goto L8;
        int r19 = r17;
    L9:
        r18.mExtraFillSpace = r19;
        if (r14 == true) goto L13;
        r16 = r17;
    L13:
        r18.mNoRecycleSpace = r16;
        if (r14 == false) goto L19;
        r18.mExtraFillSpace = this.mOrientationHelper.getEndPadding() + r19;
        View r20 = getChildClosestToEnd();
        LayoutState r21 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L18;
        r15 = -1;
    L18:
        r21.mItemDirection = r15;
        int r22 = getPosition(r20);
        LayoutState r23 = this.mLayoutState;
        r21.mCurrentPosition = r22 + r23.mItemDirection;
        r23.mOffset = this.mOrientationHelper.getDecoratedEnd(r20);
        int r24 = this.mOrientationHelper.getDecoratedEnd(r20) - this.mOrientationHelper.getEndAfterPadding();
    L24:
        LayoutState r25 = this.mLayoutState;
        r25.mAvailable = r10;
        if (r11 == false) goto L27;
        r25.mAvailable = r10 - r24;
    L27:
        r25.mScrollingOffset = r24;
        return;
    L19:
        View r26 = getChildClosestToStart();
        LayoutState r27 = this.mLayoutState;
        r27.mExtraFillSpace = this.mOrientationHelper.getStartAfterPadding() + r27.mExtraFillSpace;
        LayoutState r28 = this.mLayoutState;
        if (this.mShouldReverseLayout == true) goto L23;
        r15 = -1;
    L23:
        r28.mItemDirection = r15;
        int r29 = getPosition(r26);
        LayoutState r30 = this.mLayoutState;
        r28.mCurrentPosition = r29 + r30.mItemDirection;
        r30.mOffset = this.mOrientationHelper.getDecoratedStart(r26);
        r24 = (-this.mOrientationHelper.getDecoratedStart(r26)) + this.mOrientationHelper.getStartAfterPadding();
        goto L24
    L8:
        r19 = r16;
        goto L9
    }

    private void updateLayoutStateToFillEnd(AnchorInfo r5) {
        updateLayoutStateToFillEnd(r5.mPosition, r5.mCoordinate);
    }

    private void updateLayoutStateToFillStart(AnchorInfo r5) {
        updateLayoutStateToFillStart(r5.mPosition, r5.mCoordinate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String r5) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r5);
        return;
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State r5, @NonNull int[] r10) {
        int r11 = getExtraLayoutSpace(r5);
        if (this.mLayoutState.mLayoutDirection != (-1)) goto L5;
        int r12 = 0;
    L6:
        r10[0] = r11;
        r10[1] = r12;
        return;
    L5:
        r12 = r11;
        r11 = 0;
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
    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int r5, int r10, RecyclerView.State r11, RecyclerView.LayoutManager.LayoutPrefetchRegistry r12) {
        if (this.mOrientation == 0) goto L7;
        r5 = r10;
    L7:
        if (getChildCount() == 0) goto L16;
        if (r5 == 0) goto L17;
        ensureLayoutState();
        if (r5 <= 0) goto L13;
        int r13 = 1;
    L14:
        updateLayoutState(r13, Math.abs(r5), true, r11);
        collectPrefetchPositionsForLayoutState(r11, this.mLayoutState, r12);
        return;
    L13:
        r13 = -1;
        goto L14
    L17:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int r10, RecyclerView.LayoutManager.LayoutPrefetchRegistry r11) {
        SavedState r5 = this.mPendingSavedState;
        int r12 = -1;
        if (r5 != null) goto L5;
    L7:
        resolveShouldLayoutReverse();
        boolean r13 = this.mShouldReverseLayout;
        int r14 = this.mPendingScrollPosition;
        if (r14 != (-1)) goto L12;
        if (r13 == false) goto L11;
        r14 = r10 - 1;
        goto L12
    L11:
        r14 = 0;
    L12:
        if (r13 == true) goto L15;
        r12 = 1;
    L15:
        int r15 = 0;
    L17:
        if (r15 >= this.mInitialPrefetchItemCount) goto L21;
        if (r14 < 0) goto L25;
        if (r14 >= r10) goto L26;
        r11.addPosition(r14, 0);
        r14 = r14 + r12;
        r15 = r15 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        if (r5.hasValidAnchor() == false) goto L7;
        SavedState r16 = this.mPendingSavedState;
        r13 = r16.mAnchorLayoutFromEnd;
        r14 = r16.mAnchorPosition;
        goto L12
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State r5, LayoutState r10, RecyclerView.LayoutManager.LayoutPrefetchRegistry r11) {
        int r12 = r10.mCurrentPosition;
        if (r12 >= 0) goto L5;
        return;
    L5:
        if (r12 >= r5.getItemCount()) goto L9;
        r11.addPosition(r12, Math.max(0, r10.mScrollingOffset));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.State r5) {
        return computeScrollExtent(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.State r5) {
        return computeScrollOffset(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.State r5) {
        return computeScrollRange(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int r5) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        boolean r10 = false;
        int r11 = 1;
        if (r5 >= getPosition(getChildAt(0))) goto L10;
        r10 = true;
    L10:
        if (r10 == this.mShouldReverseLayout) goto L13;
        r11 = -1;
    L13:
        if (this.mOrientation != 0) goto L17;
        return new PointF(r11, 0.0f);
    L17:
        return new PointF(0.0f, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.State r5) {
        return computeScrollExtent(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.State r5) {
        return computeScrollOffset(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.State r5) {
        return computeScrollRange(r5);
    }

    public int convertFocusDirectionToLayoutDirection(int r5) {
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L36;
        if (r5 == 17) goto L31;
        if (r5 == 33) goto L26;
        if (r5 == 66) goto L21;
        if (r5 == 130) goto L16;
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

    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState != null) goto L6;
        this.mLayoutState = createLayoutState();
        return;
    }

    public int fill(RecyclerView.Recycler r10, LayoutState r11, RecyclerView.State r12, boolean r13) {
        int r5 = r11.mAvailable;
        int r14 = r11.mScrollingOffset;
        if (r14 == Integer.MIN_VALUE) goto L7;
        if (r5 >= 0) goto L6;
        r11.mScrollingOffset = r14 + r5;
    L6:
        recycleByLayoutState(r10, r11);
    L7:
        int r15 = r11.mAvailable + r11.mExtraFillSpace;
        LayoutChunkResult r16 = this.mLayoutChunkResult;
    L9:
        if (r11.mInfinite == true) goto L12;
        if (r15 > 0) goto L12;
    L33:
        return r5 - r11.mAvailable;
    L12:
        if (r11.hasMore(r12) == false) goto L33;
        r16.resetInternal();
        layoutChunk(r10, r12, r11, r16);
        if (r16.mFinished == true) goto L33;
        int r17 = r11.mOffset;
        r11.mOffset = (r16.mConsumed * r11.mLayoutDirection) + r17;
        if (r16.mIgnoreConsumed == true) goto L19;
    L22:
        int r18 = r11.mAvailable;
        int r19 = r16.mConsumed;
        r11.mAvailable = r18 - r19;
        r15 = r15 - r19;
    L23:
        int r20 = r11.mScrollingOffset;
        if (r20 == Integer.MIN_VALUE) goto L29;
        int r21 = r20 + r16.mConsumed;
        r11.mScrollingOffset = r21;
        int r22 = r11.mAvailable;
        if (r22 >= 0) goto L28;
        r11.mScrollingOffset = r21 + r22;
    L28:
        recycleByLayoutState(r10, r11);
    L29:
        if (r13 == false) goto L9;
        if (r16.mFocusable == false) goto L9;
    L19:
        if (r11.mScrapList != null) goto L22;
        if (r12.isPreLayout() == true) goto L23;
        goto L22
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View r5 = findOneVisibleChild(0, getChildCount(), true, false);
        if (r5 != null) goto L6;
        return -1;
    L6:
        return getPosition(r5);
    }

    public View findFirstVisibleChildClosestToEnd(boolean r5, boolean r10) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(0, getChildCount(), r5, r10);
    L7:
        return findOneVisibleChild(getChildCount() - 1, -1, r5, r10);
    }

    public View findFirstVisibleChildClosestToStart(boolean r5, boolean r10) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(getChildCount() - 1, -1, r5, r10);
    L7:
        return findOneVisibleChild(0, getChildCount(), r5, r10);
    }

    public int findFirstVisibleItemPosition() {
        View r5 = findOneVisibleChild(0, getChildCount(), false, true);
        if (r5 != null) goto L6;
        return -1;
    L6:
        return getPosition(r5);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View r5 = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (r5 != null) goto L6;
        return -1;
    L6:
        return getPosition(r5);
    }

    public int findLastVisibleItemPosition() {
        View r5 = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (r5 != null) goto L6;
        return -1;
    L6:
        return getPosition(r5);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int r5, int r10) {
        ensureLayoutState();
        if (r10 > r5) goto L7;
        if (r10 < r5) goto L7;
        return getChildAt(r5);
    L7:
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(r5)) >= this.mOrientationHelper.getStartAfterPadding()) goto L9;
        int r11 = 16644;
        int r12 = 16388;
    L11:
        if (this.mOrientation != 0) goto L14;
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(r5, r10, r11, r12);
    L14:
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(r5, r10, r11, r12);
    L9:
        r11 = 4161;
        r12 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        goto L11
    }

    public View findOneVisibleChild(int r5, int r10, boolean r11, boolean r12) {
        ensureLayoutState();
        int r13 = 320;
        if (r11 == false) goto L5;
        int r14 = 24579;
    L6:
        if (r12 == true) goto L10;
        r13 = 0;
    L10:
        if (this.mOrientation != 0) goto L13;
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(r5, r10, r14, r13);
    L13:
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(r5, r10, r14, r13);
    L5:
        r14 = 320;
        goto L6
    }

    public View findReferenceChild(RecyclerView.Recycler r17, RecyclerView.State r18, boolean r19, boolean r20) {
        ensureLayoutState();
        int r5 = getChildCount();
        if (r20 == false) goto L5;
        int r10 = getChildCount() - 1;
        int r11 = -1;
        int r12 = -1;
    L6:
        int r13 = r18.getItemCount();
        int r14 = this.mOrientationHelper.getStartAfterPadding();
        int r15 = this.mOrientationHelper.getEndAfterPadding();
        View r16 = null;
        View r110 = null;
        View r111 = null;
    L7:
        if (r10 == r11) goto L37;
        View r112 = getChildAt(r10);
        int r113 = getPosition(r112);
        int r114 = this.mOrientationHelper.getDecoratedStart(r112);
        int r115 = this.mOrientationHelper.getDecoratedEnd(r112);
        if (r113 < 0) goto L36;
        if (r113 >= r13) goto L36;
        if (((RecyclerView.LayoutParams) r112.getLayoutParams()).isItemRemoved() == false) goto L15;
        if (r111 != null) goto L36;
        r111 = r112;
        goto L36
    L15:
        if (r115 > r14) goto L18;
        if (r114 >= r14) goto L18;
        boolean r116 = true;
    L19:
        if (r114 < r15) goto L22;
        if (r115 <= r15) goto L22;
        boolean r117 = true;
    L23:
        if (r116 == true) goto L27;
        if (r117 == true) goto L27;
        return r112;
    L27:
        if (r19 == false) goto L32;
        if (r117 == true) goto L33;
        if (r16 != null) goto L36;
    L35:
        r16 = r112;
    L33:
        r110 = r112;
        goto L36
    L32:
        if (r116 == true) goto L33;
        if (r16 != null) goto L36;
    L22:
        r117 = false;
    L18:
        r116 = false;
    L36:
        r10 = r10 + r12;
        goto L7
    L37:
        if (r16 != null) goto L54;
        if (r110 == null) goto L42;
        return r110;
    L42:
        return r111;
    L54:
        return r16;
    L5:
        r11 = r5;
        r10 = 0;
        r12 = 1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int r5) {
        int r10 = getChildCount();
        if (r10 != 0) goto L6;
        return null;
    L6:
        int r11 = r5 - getPosition(getChildAt(0));
        if (r11 < 0) goto L13;
        if (r11 >= r10) goto L13;
        View r12 = getChildAt(r11);
        if (getPosition(r12) != r5) goto L13;
        return r12;
    L13:
        return super.findViewByPosition(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State r5) {
        if (r5.hasTargetScrollPosition() == true) goto L5;
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

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutState r12, LayoutChunkResult r13) {
        View r14 = r12.next(r10);
        if (r14 != null) goto L6;
        r13.mFinished = true;
        return;
    L6:
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r14.getLayoutParams();
        if (r12.mScrapList != null) goto L15;
        boolean r5 = this.mShouldReverseLayout;
        if (r12.mLayoutDirection != (-1)) goto L11;
        boolean r16 = true;
    L12:
        if (r5 != r16) goto L14;
        addView(r14);
    L22:
        measureChildWithMargins(r14, 0, 0);
        r13.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(r14);
        if (this.mOrientation == 1) goto L25;
        int r17 = getPaddingTop();
        int r18 = this.mOrientationHelper.getDecoratedMeasurementInOther(r14) + r17;
        if (r12.mLayoutDirection != (-1)) goto L35;
        int r19 = r12.mOffset;
        int r20 = r19;
        int r21 = r17;
        int r22 = r18;
        int r23 = r19 - r13.mConsumed;
    L36:
        layoutDecoratedWithMargins(r14, r23, r21, r20, r22);
        if (r15.isItemRemoved() == false) goto L39;
    L40:
        r13.mIgnoreConsumed = true;
    L41:
        r13.mFocusable = r14.hasFocusable();
        return;
    L39:
        if (r15.isItemChanged() == false) goto L41;
    L35:
        int r110 = r12.mOffset;
        r21 = r17;
        r20 = r13.mConsumed + r110;
        r22 = r18;
        r23 = r110;
        goto L36
    L25:
        if (isLayoutRTL() == false) goto L27;
        int r24 = getWidth() - getPaddingRight();
        r23 = r24 - this.mOrientationHelper.getDecoratedMeasurementInOther(r14);
    L29:
        if (r12.mLayoutDirection != (-1)) goto L31;
        int r111 = r12.mOffset;
        r22 = r111;
        r20 = r24;
        r21 = r111 - r13.mConsumed;
        goto L36
    L31:
        int r112 = r12.mOffset;
        r21 = r112;
        r20 = r24;
        r22 = r13.mConsumed + r112;
        goto L36
    L27:
        r23 = getPaddingLeft();
        r24 = this.mOrientationHelper.getDecoratedMeasurementInOther(r14) + r23;
        goto L29
    L14:
        addView(r14, 0);
        goto L22
    L11:
        r16 = false;
        goto L12
    L15:
        boolean r25 = this.mShouldReverseLayout;
        if (r12.mLayoutDirection != (-1)) goto L18;
        boolean r26 = true;
    L19:
        if (r25 != r26) goto L21;
        addDisappearingView(r14);
        goto L22
    L21:
        addDisappearingView(r14, 0);
        goto L22
    L18:
        r26 = false;
        goto L19
    }

    public void onAnchorReady(RecyclerView.Recycler r5, RecyclerView.State r10, AnchorInfo r11, int r12) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView r5, RecyclerView.Recycler r10) {
        super.onDetachedFromWindow(r5, r10);
        if (this.mRecycleChildrenOnDetach == false) goto L6;
        removeAndRecycleAllViews(r10);
        r10.clear();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View r5, int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        resolveShouldLayoutReverse();
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r13 = convertFocusDirectionToLayoutDirection(r10);
        if (r13 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        ensureLayoutState();
        updateLayoutState(r13, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, r12);
        LayoutState r14 = this.mLayoutState;
        r14.mScrollingOffset = Integer.MIN_VALUE;
        r14.mRecycle = false;
        fill(r11, r14, r12, true);
        if (r13 != (-1)) goto L11;
        View r15 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
    L12:
        if (r13 != (-1)) goto L14;
        View r16 = getChildClosestToStart();
    L16:
        if (r16.hasFocusable() == false) goto L20;
        if (r15 != null) goto L19;
        return null;
    L19:
        return r16;
    L20:
        return r15;
    L14:
        r16 = getChildClosestToEnd();
        goto L16
    L11:
        r15 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        if (getChildCount() <= 0) goto L6;
        r5.setFromIndex(findFirstVisibleItemPosition());
        r5.setToIndex(findLastVisibleItemPosition());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        int r5 = -1;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        SavedState r12 = this.mPendingSavedState;
        if (r12 != null) goto L13;
    L15:
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View r13 = getFocusedChild();
        AnchorInfo r14 = this.mAnchorInfo;
        if (r14.mValid == true) goto L18;
    L28:
        r14.reset();
        AnchorInfo r15 = this.mAnchorInfo;
        r15.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
        updateAnchorInfoForLayout(r10, r11, r15);
        this.mAnchorInfo.mValid = true;
    L29:
        LayoutState r16 = this.mLayoutState;
        if (r16.mLastScrollDelta < 0) goto L32;
        int r17 = 1;
    L33:
        r16.mLayoutDirection = r17;
        int[] r18 = this.mReusableIntPair;
        r18[0] = 0;
        r18[1] = 0;
        calculateExtraLayoutSpace(r11, r18);
        int r19 = this.mOrientationHelper.getStartAfterPadding() + Math.max(0, this.mReusableIntPair[0]);
        int r20 = this.mOrientationHelper.getEndPadding() + Math.max(0, this.mReusableIntPair[1]);
        if (r11.isPreLayout() == false) goto L49;
        int r21 = this.mPendingScrollPosition;
        if (r21 == (-1)) goto L49;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L49;
        View r22 = findViewByPosition(r21);
        if (r22 == null) goto L49;
        if (this.mShouldReverseLayout == false) goto L45;
        int r23 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r22);
        int r24 = this.mPendingScrollPositionOffset;
    L44:
        int r25 = r23 - r24;
        if (r25 <= 0) goto L48;
        r19 = r19 + r25;
        goto L49
    L48:
        r20 = r20 - r25;
        goto L49
    L45:
        r24 = this.mOrientationHelper.getDecoratedStart(r22) - this.mOrientationHelper.getStartAfterPadding();
        r23 = this.mPendingScrollPositionOffset;
    L49:
        AnchorInfo r26 = this.mAnchorInfo;
        if (r26.mLayoutFromEnd == false) goto L55;
        if (this.mShouldReverseLayout == false) goto L56;
    L53:
        r5 = 1;
    L56:
        onAnchorReady(r10, r11, r26, r5);
        detachAndScrapAttachedViews(r10);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = r11.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo r27 = this.mAnchorInfo;
        if (r27.mLayoutFromEnd == false) goto L64;
        updateLayoutStateToFillStart(r27);
        LayoutState r28 = this.mLayoutState;
        r28.mExtraFillSpace = r19;
        fill(r10, r28, r11, false);
        LayoutState r29 = this.mLayoutState;
        int r30 = r29.mOffset;
        int r31 = r29.mCurrentPosition;
        int r32 = r29.mAvailable;
        if (r32 <= 0) goto L61;
        r20 = r20 + r32;
    L61:
        updateLayoutStateToFillEnd(this.mAnchorInfo);
        LayoutState r33 = this.mLayoutState;
        r33.mExtraFillSpace = r20;
        r33.mCurrentPosition += r33.mItemDirection;
        fill(r10, r33, r11, false);
        LayoutState r34 = this.mLayoutState;
        int r35 = r34.mOffset;
        int r36 = r34.mAvailable;
        if (r36 <= 0) goto L72;
        updateLayoutStateToFillStart(r31, r30);
        LayoutState r37 = this.mLayoutState;
        r37.mExtraFillSpace = r36;
        fill(r10, r37, r11, false);
        r30 = this.mLayoutState.mOffset;
    L72:
        if (getChildCount() > 0) goto L74;
    L78:
        layoutForPredictiveAnimations(r10, r11, r30, r35);
        if (r11.isPreLayout() == true) goto L81;
        this.mOrientationHelper.onLayoutComplete();
    L82:
        this.mLastStackFromEnd = this.mStackFromEnd;
        return;
    L81:
        this.mAnchorInfo.reset();
        goto L82
    L74:
        if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == false) goto L77;
        int r38 = fixLayoutEndGap(r35, r10, r11, true);
        int r39 = r30 + r38;
        int r40 = r35 + r38;
        int r41 = fixLayoutStartGap(r39, r10, r11, false);
    L76:
        r30 = r39 + r41;
        r35 = r40 + r41;
        goto L78
    L77:
        int r42 = fixLayoutStartGap(r30, r10, r11, true);
        r39 = r30 + r42;
        r40 = r35 + r42;
        r41 = fixLayoutEndGap(r40, r10, r11, false);
        goto L76
    L64:
        updateLayoutStateToFillEnd(r27);
        LayoutState r43 = this.mLayoutState;
        r43.mExtraFillSpace = r20;
        fill(r10, r43, r11, false);
        LayoutState r44 = this.mLayoutState;
        r35 = r44.mOffset;
        int r45 = r44.mCurrentPosition;
        int r46 = r44.mAvailable;
        if (r46 <= 0) goto L67;
        r19 = r19 + r46;
    L67:
        updateLayoutStateToFillStart(this.mAnchorInfo);
        LayoutState r47 = this.mLayoutState;
        r47.mExtraFillSpace = r19;
        r47.mCurrentPosition += r47.mItemDirection;
        fill(r10, r47, r11, false);
        LayoutState r48 = this.mLayoutState;
        int r49 = r48.mOffset;
        int r50 = r48.mAvailable;
        if (r50 <= 0) goto L70;
        updateLayoutStateToFillEnd(r45, r35);
        LayoutState r51 = this.mLayoutState;
        r51.mExtraFillSpace = r50;
        fill(r10, r51, r11, false);
        r35 = this.mLayoutState.mOffset;
    L70:
        r30 = r49;
        goto L72
    L55:
        if (this.mShouldReverseLayout == false) goto L53;
    L32:
        r17 = -1;
        goto L33
    L18:
        if (this.mPendingScrollPosition != (-1)) goto L28;
        if (this.mPendingSavedState != null) goto L28;
        if (r13 == null) goto L29;
        if (this.mOrientationHelper.getDecoratedStart(r13) < this.mOrientationHelper.getEndAfterPadding()) goto L26;
    L27:
        this.mAnchorInfo.assignFromViewAndKeepVisibleRect(r13, getPosition(r13));
        goto L29
    L26:
        if (this.mOrientationHelper.getDecoratedEnd(r13) > this.mOrientationHelper.getStartAfterPadding()) goto L29;
    L13:
        if (r12.hasValidAnchor() == false) goto L15;
        this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    L7:
        if (r11.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.State r5) {
        super.onLayoutCompleted(r5);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == false) goto L9;
        SavedState r10 = (SavedState) r5;
        this.mPendingSavedState = r10;
        if (this.mPendingScrollPosition == (-1)) goto L7;
        r10.invalidateAnchor();
    L7:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) goto L5;
        SavedState r5 = new SavedState();
        if (getChildCount() <= 0) goto L12;
        ensureLayoutState();
        boolean r10 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
        r5.mAnchorLayoutFromEnd = r10;
        if (r10 == false) goto L11;
        View r11 = getChildClosestToEnd();
        r5.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r11);
        r5.mAnchorPosition = getPosition(r11);
    L13:
        return r5;
    L11:
        View r12 = getChildClosestToStart();
        r5.mAnchorPosition = getPosition(r12);
        r5.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(r12) - this.mOrientationHelper.getStartAfterPadding();
        goto L13
    L12:
        r5.invalidateAnchor();
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View r5, @NonNull View r10, int r11, int r12) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int r13 = getPosition(r5);
        int r14 = getPosition(r10);
        if (r13 >= r14) goto L5;
        byte r15 = 1;
    L7:
        if (this.mShouldReverseLayout == false) goto L11;
        if (r15 != 1) goto L10;
        scrollToPositionWithOffset(r14, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedMeasurement(r5) + this.mOrientationHelper.getDecoratedStart(r10)));
        return;
    L10:
        scrollToPositionWithOffset(r14, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r10));
        return;
    L11:
        if (r15 != (-1)) goto L13;
        scrollToPositionWithOffset(r14, this.mOrientationHelper.getDecoratedStart(r10));
        return;
    L13:
        scrollToPositionWithOffset(r14, this.mOrientationHelper.getDecoratedEnd(r10) - this.mOrientationHelper.getDecoratedMeasurement(r5));
        return;
    L5:
        r15 = -1;
        goto L7
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mOrientationHelper.getEnd() != 0) goto L7;
        return true;
    }

    public int scrollBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getChildCount() == 0) goto L17;
        if (r10 == 0) goto L17;
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        if (r10 <= 0) goto L9;
        int r5 = 1;
    L10:
        int r13 = Math.abs(r10);
        updateLayoutState(r5, r13, true, r12);
        LayoutState r14 = this.mLayoutState;
        int r15 = fill(r11, r14, r12, false) + r14.mScrollingOffset;
        if (r15 >= 0) goto L13;
        return 0;
    L13:
        if (r13 <= r15) goto L15;
        r10 = r5 * r15;
    L15:
        this.mOrientationHelper.offsetChildren(-r10);
        this.mLayoutState.mLastScrollDelta = r10;
        return r10;
    L9:
        r5 = -1;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mOrientation != 1) goto L7;
        return 0;
    L7:
        return scrollBy(r5, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r5) {
        this.mPendingScrollPosition = r5;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState r10 = this.mPendingSavedState;
        if (r10 == null) goto L5;
        r10.invalidateAnchor();
    L5:
        requestLayout();
    }

    public void scrollToPositionWithOffset(int r5, int r10) {
        this.mPendingScrollPosition = r5;
        this.mPendingScrollPositionOffset = r10;
        SavedState r11 = this.mPendingSavedState;
        if (r11 == null) goto L5;
        r11.invalidateAnchor();
    L5:
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mOrientation != 0) goto L7;
        return 0;
    L7:
        return scrollBy(r5, r10, r11);
    }

    public void setInitialPrefetchItemCount(int r5) {
        this.mInitialPrefetchItemCount = r5;
    }

    public void setOrientation(int r5) {
        if (r5 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r5 == this.mOrientation) goto L11;
    L12:
        OrientationHelper r10 = OrientationHelper.createOrientationHelper(this, r5);
        this.mOrientationHelper = r10;
        this.mAnchorInfo.mOrientationHelper = r10;
        this.mOrientation = r5;
        requestLayout();
        return;
    L11:
        if (this.mOrientationHelper == null) goto L12;
        return;
    L4:
        if (r5 == 1) goto L8;
        throw new IllegalArgumentException(j0.g(r5, "invalid orientation:"));
    }

    public void setRecycleChildrenOnDetach(boolean r5) {
        this.mRecycleChildrenOnDetach = r5;
    }

    public void setReverseLayout(boolean r5) {
        assertNotInLayoutOrScroll(null);
        if (r5 != this.mReverseLayout) goto L5;
        return;
    L5:
        this.mReverseLayout = r5;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean r5) {
        this.mSmoothScrollbarEnabled = r5;
    }

    public void setStackFromEnd(boolean r5) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != r5) goto L5;
        return;
    L5:
        this.mStackFromEnd = r5;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824) goto L5;
    L9:
        return false;
    L5:
        if (getWidthMode() == 1073741824) goto L9;
        if (hasFlexibleChildInBothOrientations() == false) goto L9;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView r5, RecyclerView.State r10, int r11) {
        LinearSmoothScroller r12 = new LinearSmoothScroller(r5.getContext());
        r12.setTargetPosition(r11);
        startSmoothScroll(r12);
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

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean r5 = true;
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        int r10 = getPosition(getChildAt(0));
        int r11 = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayout == false) goto L22;
        int r12 = 1;
    L9:
        if (r12 >= getChildCount()) goto L37;
        View r13 = getChildAt(r12);
        int r14 = getPosition(r13);
        int r15 = this.mOrientationHelper.getDecoratedStart(r13);
        if (r14 < r10) goto L12;
        if (r15 > r11) goto L20;
        r12 = r12 + 1;
        goto L9
    L20:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L12:
        logChildren();
        StringBuilder r16 = new StringBuilder("detected invalid position. loc invalid? ");
        if (r15 < r11) goto L16;
        r5 = false;
    L16:
        r16.append(r5);
        throw new RuntimeException(r16.toString());
    L37:
        return;
    L22:
        int r17 = 1;
    L24:
        if (r17 >= getChildCount()) goto L44;
        View r18 = getChildAt(r17);
        int r19 = getPosition(r18);
        int r20 = this.mOrientationHelper.getDecoratedStart(r18);
        if (r19 < r10) goto L27;
        if (r20 < r11) goto L35;
        r17 = r17 + 1;
        goto L24
    L35:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L27:
        logChildren();
        StringBuilder r21 = new StringBuilder("detected invalid position. loc invalid? ");
        if (r20 < r11) goto L31;
        r5 = false;
    L31:
        r21.append(r5);
        throw new RuntimeException(r21.toString());
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context r5, int r10, boolean r11) {
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
        setOrientation(r10);
        setReverseLayout(r11);
    }

    private void updateLayoutStateToFillEnd(int r5, int r10) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - r10;
        LayoutState r11 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L5;
        int r12 = -1;
    L6:
        r11.mItemDirection = r12;
        r11.mCurrentPosition = r5;
        r11.mLayoutDirection = 1;
        r11.mOffset = r10;
        r11.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r12 = 1;
        goto L6
    }

    private void updateLayoutStateToFillStart(int r5, int r10) {
        this.mLayoutState.mAvailable = r10 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState r11 = this.mLayoutState;
        r11.mCurrentPosition = r5;
        if (this.mShouldReverseLayout == false) goto L5;
        int r12 = 1;
    L6:
        r11.mItemDirection = r12;
        r11.mLayoutDirection = -1;
        r11.mOffset = r10;
        r11.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r12 = -1;
        goto L6
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context r5, AttributeSet r10, int r11, int r12) {
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
        RecyclerView.LayoutManager.Properties r13 = RecyclerView.LayoutManager.getProperties(r5, r10, r11, r12);
        setOrientation(r13.orientation);
        setReverseLayout(r13.reverseLayout);
        setStackFromEnd(r13.stackFromEnd);
    }
}

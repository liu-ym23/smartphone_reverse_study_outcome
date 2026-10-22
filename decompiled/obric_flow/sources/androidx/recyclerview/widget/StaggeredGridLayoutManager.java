package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo;
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy;
    private boolean mLaidOutInvalidFullSpan;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;

    @NonNull
    private final LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup;
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private int[] mPrefetchDistances;

    @NonNull
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout;

    @NonNull
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled;
    private int mSpanCount;
    Span[] mSpans;
    private final Rect mTmpRect;

    public class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;
        final /* synthetic */ StaggeredGridLayoutManager this$0;

        public AnchorInfo(StaggeredGridLayoutManager r5) {
            this.this$0 = r5;
            reset();
        }

        public void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r5 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
        L6:
            this.mOffset = r5;
            return;
        L5:
            r5 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
            goto L6
        }

        public void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] r5 = this.mSpanReferenceLines;
            if (r5 == null) goto L6;
            Arrays.fill(r5, -1);
            return;
        }

        public void saveSpanReferenceLines(Span[] r10) {
            int r5 = r10.length;
            int[] r11 = this.mSpanReferenceLines;
            if (r11 != null) goto L5;
        L6:
            this.mSpanReferenceLines = new int[this.this$0.mSpans.length];
        L7:
            int r12 = 0;
        L8:
            if (r12 >= r5) goto L10;
            this.mSpanReferenceLines[r12] = r10[r12].getStartLine(Integer.MIN_VALUE);
            r12 = r12 + 1;
            goto L8
        L10:
            return;
        L5:
            if (r11.length >= r5) goto L7;
            goto L6
        }

        public void assignCoordinateFromPadding(int r5) {
            if (this.mLayoutFromEnd == false) goto L5;
            this.mOffset = this.this$0.mPrimaryOrientation.getEndAfterPadding() - r5;
            return;
        L5:
            this.mOffset = this.this$0.mPrimaryOrientation.getStartAfterPadding() + r5;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
        }

        public final int getSpanIndex() {
            Span r5 = this.mSpan;
            if (r5 != null) goto L7;
            return -1;
        L7:
            return r5.mIndex;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean r5) {
            this.mFullSpan = r5;
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
        }

        public LayoutParams(RecyclerView.LayoutParams r5) {
            super(r5);
        }
    }

    public static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = null;
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            static {
                CREATOR = new AnonymousClass1();
            }

            public FullSpanItem(Parcel r5) {
                this.mPosition = r5.readInt();
                this.mGapDir = r5.readInt();
                boolean r10 = true;
                if (r5.readInt() == 1) goto L6;
                r10 = false;
            L6:
                this.mHasUnwantedGapAfter = r10;
                int r11 = r5.readInt();
                if (r11 <= 0) goto L10;
                int[] r12 = new int[r11];
                this.mGapPerSpan = r12;
                r5.readIntArray(r12);
                return;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int getGapForSpan(int r5) {
                int[] r10 = this.mGapPerSpan;
                if (r10 != null) goto L6;
                return 0;
            L6:
                return r10[r5];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r5, int r10) {
                r5.writeInt(this.mPosition);
                r5.writeInt(this.mGapDir);
                r5.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] r11 = this.mGapPerSpan;
                if (r11 != null) goto L5;
            L7:
                r5.writeInt(0);
                return;
            L5:
                if (r11.length <= 0) goto L7;
                r5.writeInt(r11.length);
                r5.writeIntArray(this.mGapPerSpan);
            }

            public FullSpanItem() {
            }
        }

        public LazySpanLookup() {
        }

        private int invalidateFullSpansAfter(int r5) {
            if (this.mFullSpanItems != null) goto L5;
            return -1;
        L5:
            FullSpanItem r10 = getFullSpanItem(r5);
            if (r10 == null) goto L8;
            this.mFullSpanItems.remove(r10);
        L8:
            int r11 = this.mFullSpanItems.size();
            int r12 = 0;
        L9:
            if (r12 >= r11) goto L14;
            if (this.mFullSpanItems.get(r12).mPosition >= r5) goto L15;
            r12 = r12 + 1;
        L15:
            if (r12 == (-1)) goto L18;
            FullSpanItem r13 = this.mFullSpanItems.get(r12);
            this.mFullSpanItems.remove(r12);
            return r13.mPosition;
        L18:
            return -1;
        L14:
            r12 = -1;
            goto L15
        }

        private void offsetFullSpansForAddition(int r5, int r10) {
            List<FullSpanItem> r11 = this.mFullSpanItems;
            if (r11 != null) goto L5;
            return;
        L5:
            int r12 = r11.size() - 1;
        L6:
            if (r12 < 0) goto L12;
            FullSpanItem r13 = this.mFullSpanItems.get(r12);
            int r14 = r13.mPosition;
            if (r14 < r5) goto L11;
            r13.mPosition = r14 + r10;
        L11:
            r12 = r12 - 1;
            goto L6
        }

        private void offsetFullSpansForRemoval(int r5, int r10) {
            List<FullSpanItem> r11 = this.mFullSpanItems;
            if (r11 != null) goto L5;
            return;
        L5:
            int r12 = r5 + r10;
            int r13 = r11.size() - 1;
        L6:
            if (r13 < 0) goto L14;
            FullSpanItem r14 = this.mFullSpanItems.get(r13);
            int r15 = r14.mPosition;
            if (r15 < r5) goto L13;
            if (r15 >= r12) goto L12;
            this.mFullSpanItems.remove(r13);
            goto L13
        L12:
            r14.mPosition = r15 - r10;
        L13:
            r13 = r13 - 1;
            goto L6
        }

        public void addFullSpanItem(FullSpanItem r10) {
            if (this.mFullSpanItems != null) goto L5;
            this.mFullSpanItems = new ArrayList();
        L5:
            int r5 = this.mFullSpanItems.size();
            int r11 = 0;
        L6:
            if (r11 >= r5) goto L15;
            FullSpanItem r12 = this.mFullSpanItems.get(r11);
            if (r12.mPosition != r10.mPosition) goto L11;
            this.mFullSpanItems.remove(r11);
        L11:
            if (r12.mPosition >= r10.mPosition) goto L12;
            r11 = r11 + 1;
            goto L6
        L12:
            this.mFullSpanItems.add(r11, r10);
            return;
        L15:
            this.mFullSpanItems.add(r10);
        }

        public void clear() {
            int[] r5 = this.mData;
            if (r5 == null) goto L5;
            Arrays.fill(r5, -1);
        L5:
            this.mFullSpanItems = null;
        }

        public void ensureSize(int r5) {
            int[] r10 = this.mData;
            if (r10 != null) goto L6;
            int[] r11 = new int[Math.max(r5, 10) + 1];
            this.mData = r11;
            Arrays.fill(r11, -1);
            return;
        L6:
            if (r5 < r10.length) goto L10;
            int[] r12 = new int[sizeForPosition(r5)];
            this.mData = r12;
            System.arraycopy(r10, 0, r12, 0, r10.length);
            int[] r13 = this.mData;
            Arrays.fill(r13, r10.length, r13.length, -1);
            return;
        }

        public int forceInvalidateAfter(int r5) {
            List<FullSpanItem> r10 = this.mFullSpanItems;
            if (r10 == null) goto L11;
            int r11 = r10.size() - 1;
        L5:
            if (r11 < 0) goto L11;
            if (this.mFullSpanItems.get(r11).mPosition < r5) goto L9;
            this.mFullSpanItems.remove(r11);
        L9:
            r11 = r11 - 1;
        L11:
            return invalidateAfter(r5);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int r10, int r11, int r12, boolean r13) {
            List<FullSpanItem> r5 = this.mFullSpanItems;
            if (r5 != null) goto L5;
            return null;
        L5:
            int r14 = r5.size();
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L19;
            FullSpanItem r16 = this.mFullSpanItems.get(r15);
            int r17 = r16.mPosition;
            if (r17 >= r11) goto L9;
            if (r17 < r10) goto L18;
            if (r12 == 0) goto L17;
            if (r16.mGapDir == r12) goto L17;
            if (r13 == false) goto L18;
            if (r16.mHasUnwantedGapAfter == false) goto L18;
        L17:
            return r16;
        L18:
            r15 = r15 + 1;
            goto L6
        L9:
            return null;
        L19:
            return null;
        }

        public FullSpanItem getFullSpanItem(int r5) {
            List<FullSpanItem> r10 = this.mFullSpanItems;
            if (r10 != null) goto L5;
            return null;
        L5:
            int r11 = r10.size() - 1;
        L6:
            if (r11 < 0) goto L11;
            FullSpanItem r12 = this.mFullSpanItems.get(r11);
            if (r12.mPosition == r5) goto L9;
            r11 = r11 - 1;
            goto L6
        L9:
            return r12;
        L11:
            return null;
        }

        public int getSpan(int r5) {
            int[] r10 = this.mData;
            if (r10 != null) goto L5;
            return -1;
        L5:
            if (r5 < r10.length) goto L8;
            return -1;
        L8:
            return r10[r5];
        }

        public int invalidateAfter(int r5) {
            int[] r10 = this.mData;
            if (r10 != null) goto L6;
            return -1;
        L6:
            if (r5 < r10.length) goto L8;
            return -1;
        L8:
            int r11 = invalidateFullSpansAfter(r5);
            if (r11 != (-1)) goto L12;
            int[] r12 = this.mData;
            Arrays.fill(r12, r5, r12.length, -1);
            return this.mData.length;
        L12:
            int r13 = Math.min(r11 + 1, this.mData.length);
            Arrays.fill(this.mData, r5, r13, -1);
            return r13;
        }

        public void offsetForAddition(int r5, int r10) {
            int[] r11 = this.mData;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r5 >= r11.length) goto L10;
            int r12 = r5 + r10;
            ensureSize(r12);
            int[] r13 = this.mData;
            System.arraycopy(r13, r5, r13, r12, (r13.length - r5) - r10);
            Arrays.fill(this.mData, r5, r12, -1);
            offsetFullSpansForAddition(r5, r10);
            return;
        }

        public void offsetForRemoval(int r5, int r10) {
            int[] r11 = this.mData;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r5 >= r11.length) goto L10;
            int r12 = r5 + r10;
            ensureSize(r12);
            int[] r13 = this.mData;
            System.arraycopy(r13, r12, r13, r5, (r13.length - r5) - r10);
            int[] r14 = this.mData;
            Arrays.fill(r14, r14.length - r10, r14.length, -1);
            offsetFullSpansForRemoval(r5, r10);
            return;
        }

        public void setSpan(int r5, Span r10) {
            ensureSize(r5);
            this.mData[r5] = r10.mIndex;
        }

        public int sizeForPosition(int r5) {
            int r10 = this.mData.length;
        L3:
            if (r10 > r5) goto L5;
            r10 = r10 * 2;
            goto L3
        L5:
            return r10;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            r5.writeInt(this.mAnchorPosition);
            r5.writeInt(this.mVisibleAnchorPosition);
            r5.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize <= 0) goto L5;
            r5.writeIntArray(this.mSpanOffsets);
        L5:
            r5.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize <= 0) goto L8;
            r5.writeIntArray(this.mSpanLookup);
        L8:
            r5.writeInt(this.mReverseLayout ? 1 : 0);
            r5.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            r5.writeInt(this.mLastLayoutRTL ? 1 : 0);
            r5.writeList(this.mFullSpanItems);
        }

        public SavedState(Parcel r5) {
            this.mAnchorPosition = r5.readInt();
            this.mVisibleAnchorPosition = r5.readInt();
            int r10 = r5.readInt();
            this.mSpanOffsetsSize = r10;
            if (r10 <= 0) goto L5;
            int[] r11 = new int[r10];
            this.mSpanOffsets = r11;
            r5.readIntArray(r11);
        L5:
            int r12 = r5.readInt();
            this.mSpanLookupSize = r12;
            if (r12 <= 0) goto L8;
            int[] r13 = new int[r12];
            this.mSpanLookup = r13;
            r5.readIntArray(r13);
        L8:
            boolean r14 = false;
            if (r5.readInt() != 1) goto L11;
            boolean r15 = true;
        L12:
            this.mReverseLayout = r15;
            if (r5.readInt() != 1) goto L15;
            boolean r16 = true;
        L16:
            this.mAnchorLayoutFromEnd = r16;
            if (r5.readInt() != 1) goto L19;
            r14 = true;
        L19:
            this.mLastLayoutRTL = r14;
            this.mFullSpanItems = r5.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
            return;
        L15:
            r16 = false;
            goto L16
        L11:
            r15 = false;
            goto L12
        }

        public SavedState(SavedState r5) {
            this.mSpanOffsetsSize = r5.mSpanOffsetsSize;
            this.mAnchorPosition = r5.mAnchorPosition;
            this.mVisibleAnchorPosition = r5.mVisibleAnchorPosition;
            this.mSpanOffsets = r5.mSpanOffsets;
            this.mSpanLookupSize = r5.mSpanLookupSize;
            this.mSpanLookup = r5.mSpanLookup;
            this.mReverseLayout = r5.mReverseLayout;
            this.mAnchorLayoutFromEnd = r5.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = r5.mLastLayoutRTL;
            this.mFullSpanItems = r5.mFullSpanItems;
        }
    }

    public class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        ArrayList<View> mViews;
        final /* synthetic */ StaggeredGridLayoutManager this$0;

        public Span(StaggeredGridLayoutManager r5, int r10) {
            this.this$0 = r5;
            this.mViews = new ArrayList();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mIndex = r10;
        }

        public void appendToSpan(View r5) {
            LayoutParams r10 = getLayoutParams(r5);
            r10.mSpan = this;
            this.mViews.add(r5);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedStart = Integer.MIN_VALUE;
        L6:
            if (r10.isItemRemoved() == false) goto L8;
        L9:
            int r11 = this.mDeletedSize;
            this.mDeletedSize = this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r5) + r11;
            return;
        L8:
            if (r10.isItemChanged() == true) goto L9;
        }

        public void cacheReferenceLineAndClear(boolean r5, int r10) {
            if (r5 == false) goto L5;
            int r11 = getEndLine(Integer.MIN_VALUE);
        L6:
            clear();
            if (r11 != Integer.MIN_VALUE) goto L9;
            return;
        L9:
            if (r5 == true) goto L11;
        L12:
            if (r5 == false) goto L14;
        L16:
            if (r10 == Integer.MIN_VALUE) goto L18;
            r11 = r11 + r10;
        L18:
            this.mCachedEnd = r11;
            this.mCachedStart = r11;
            return;
        L14:
            if (r11 <= this.this$0.mPrimaryOrientation.getStartAfterPadding()) goto L16;
            return;
        L11:
            if (r11 >= this.this$0.mPrimaryOrientation.getEndAfterPadding()) goto L12;
            return;
        L5:
            r11 = getStartLine(Integer.MIN_VALUE);
            goto L6
        }

        public void calculateCachedEnd() {
            View r5 = (View) a.h(this.mViews, 1);
            LayoutParams r10 = getLayoutParams(r5);
            this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(r5);
            if (r10.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r11 = this.this$0.mLazySpanLookup.getFullSpanItem(r10.getViewLayoutPosition());
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.mGapDir != 1) goto L12;
            this.mCachedEnd += r11.getGapForSpan(this.mIndex);
            return;
        L12:
            return;
        }

        public void calculateCachedStart() {
            View r5 = this.mViews.get(0);
            LayoutParams r10 = getLayoutParams(r5);
            this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(r5);
            if (r10.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r11 = this.this$0.mLazySpanLookup.getFullSpanItem(r10.getViewLayoutPosition());
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.mGapDir != (-1)) goto L12;
            this.mCachedStart -= r11.getGapForSpan(this.mIndex);
            return;
        L12:
            return;
        }

        public void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        L6:
            return findOneVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        L6:
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        L6:
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(0, this.mViews.size(), true);
        L6:
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        L6:
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(0, this.mViews.size(), false);
        L6:
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        public int findOnePartiallyOrCompletelyVisibleChild(int r11, int r12, boolean r13, boolean r14, boolean r15) {
            int r5 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
            int r10 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
            if (r12 <= r11) goto L5;
            int r16 = 1;
        L6:
            if (r11 == r12) goto L35;
            View r17 = this.mViews.get(r11);
            int r18 = this.this$0.mPrimaryOrientation.getDecoratedStart(r17);
            int r19 = this.this$0.mPrimaryOrientation.getDecoratedEnd(r17);
            boolean r20 = false;
            if (r15 == false) goto L12;
            if (r18 > r10) goto L11;
        L10:
            boolean r21 = true;
        L14:
            if (r15 == false) goto L17;
            if (r19 < r5) goto L19;
        L16:
            r20 = true;
        L19:
            if (r21 == false) goto L34;
            if (r20 == false) goto L34;
            if (r13 == false) goto L27;
            if (r14 == false) goto L27;
            if (r18 < r5) goto L34;
            if (r19 > r10) goto L34;
            return this.this$0.getPosition(r17);
        L27:
            if (r14 == true) goto L29;
            if (r18 < r5) goto L33;
            if (r19 <= r10) goto L34;
        L33:
            return this.this$0.getPosition(r17);
        L29:
            return this.this$0.getPosition(r17);
        L34:
            r11 = r11 + r16;
            goto L6
        L17:
            if (r19 <= r5) goto L19;
        L11:
            r21 = false;
            goto L14
        L12:
            if (r18 >= r10) goto L11;
        L35:
            return -1;
        L5:
            r16 = -1;
            goto L6
        }

        public int findOnePartiallyVisibleChild(int r10, int r11, boolean r12) {
            return findOnePartiallyOrCompletelyVisibleChild(r10, r11, false, false, r12);
        }

        public int findOneVisibleChild(int r10, int r11, boolean r12) {
            return findOnePartiallyOrCompletelyVisibleChild(r10, r11, r12, true, false);
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        public int getEndLine(int r5) {
            int r10 = this.mCachedEnd;
            if (r10 == Integer.MIN_VALUE) goto L6;
            return r10;
        L6:
            if (this.mViews.size() != 0) goto L8;
            return r5;
        L8:
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public View getFocusableViewAfter(int r10, int r11) {
            View r5 = null;
            if (r11 != (-1)) goto L18;
            int r12 = this.mViews.size();
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L32;
            View r14 = this.mViews.get(r13);
            StaggeredGridLayoutManager r15 = this.this$0;
            if (r15.mReverseLayout == true) goto L9;
        L10:
            StaggeredGridLayoutManager r16 = this.this$0;
            if (r16.mReverseLayout == true) goto L16;
            if (r16.getPosition(r14) >= r10) goto L32;
        L16:
            if (r14.hasFocusable() == false) goto L32;
            r13 = r13 + 1;
            r5 = r14;
            goto L5
        L9:
            if (r15.getPosition(r14) > r10) goto L10;
        L32:
            return r5;
        L18:
            int r17 = this.mViews.size() - 1;
        L19:
            if (r17 < 0) goto L32;
            View r18 = this.mViews.get(r17);
            StaggeredGridLayoutManager r19 = this.this$0;
            if (r19.mReverseLayout == true) goto L23;
        L24:
            StaggeredGridLayoutManager r20 = this.this$0;
            if (r20.mReverseLayout == true) goto L30;
            if (r20.getPosition(r18) <= r10) goto L32;
        L30:
            if (r18.hasFocusable() == false) goto L32;
            r17 = r17 - 1;
            r5 = r18;
            goto L19
        L23:
            if (r19.getPosition(r18) >= r10) goto L32;
            goto L24
        }

        public LayoutParams getLayoutParams(View r5) {
            return (LayoutParams) r5.getLayoutParams();
        }

        public int getStartLine(int r5) {
            int r10 = this.mCachedStart;
            if (r10 == Integer.MIN_VALUE) goto L6;
            return r10;
        L6:
            if (this.mViews.size() != 0) goto L8;
            return r5;
        L8:
            calculateCachedStart();
            return this.mCachedStart;
        }

        public void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        public void onOffset(int r5) {
            int r10 = this.mCachedStart;
            if (r10 == Integer.MIN_VALUE) goto L5;
            this.mCachedStart = r10 + r5;
        L5:
            int r11 = this.mCachedEnd;
            if (r11 == Integer.MIN_VALUE) goto L9;
            this.mCachedEnd = r11 + r5;
            return;
        }

        public void popEnd() {
            int r5 = this.mViews.size();
            View r10 = this.mViews.remove(r5 - 1);
            LayoutParams r11 = getLayoutParams(r10);
            r11.mSpan = null;
            if (r11.isItemRemoved() == false) goto L5;
        L6:
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r10);
        L8:
            if (r5 != 1) goto L10;
            this.mCachedStart = Integer.MIN_VALUE;
        L10:
            this.mCachedEnd = Integer.MIN_VALUE;
            return;
        L5:
            if (r11.isItemChanged() == false) goto L8;
            goto L6
        }

        public void popStart() {
            View r5 = this.mViews.remove(0);
            LayoutParams r10 = getLayoutParams(r5);
            r10.mSpan = null;
            if (this.mViews.size() != 0) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r10.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r5);
        L10:
            this.mCachedStart = Integer.MIN_VALUE;
            return;
        L8:
            if (r10.isItemChanged() == false) goto L10;
            goto L9
        }

        public void prependToSpan(View r5) {
            LayoutParams r10 = getLayoutParams(r5);
            r10.mSpan = this;
            this.mViews.add(0, r5);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r10.isItemRemoved() == false) goto L8;
        L9:
            int r11 = this.mDeletedSize;
            this.mDeletedSize = this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r5) + r11;
            return;
        L8:
            if (r10.isItemChanged() == true) goto L9;
        }

        public void setLine(int r5) {
            this.mCachedStart = r5;
            this.mCachedEnd = r5;
        }

        public int getEndLine() {
            int r5 = this.mCachedEnd;
            if (r5 == Integer.MIN_VALUE) goto L5;
            return r5;
        L5:
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public int getStartLine() {
            int r5 = this.mCachedStart;
            if (r5 == Integer.MIN_VALUE) goto L5;
            return r5;
        L5:
            calculateCachedStart();
            return this.mCachedStart;
        }
    }

    public StaggeredGridLayoutManager(Context r5, AttributeSet r10, int r11, int r12) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new AnonymousClass1(this);
        RecyclerView.LayoutManager.Properties r13 = RecyclerView.LayoutManager.getProperties(r5, r10, r11, r12);
        setOrientation(r13.orientation);
        setSpanCount(r13.spanCount);
        setReverseLayout(r13.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View r5) {
        int r10 = this.mSpanCount - 1;
    L3:
        if (r10 < 0) goto L5;
        this.mSpans[r10].appendToSpan(r5);
        r10 = r10 - 1;
        goto L3
    }

    private void applyPendingSavedState(AnchorInfo r5) {
        SavedState r10 = this.mPendingSavedState;
        int r11 = r10.mSpanOffsetsSize;
        if (r11 > 0) goto L5;
    L18:
        SavedState r12 = this.mPendingSavedState;
        this.mLastLayoutRTL = r12.mLastLayoutRTL;
        setReverseLayout(r12.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState r13 = this.mPendingSavedState;
        int r14 = r13.mAnchorPosition;
        if (r14 == (-1)) goto L21;
        this.mPendingScrollPosition = r14;
        r5.mLayoutFromEnd = r13.mAnchorLayoutFromEnd;
    L23:
        if (r13.mSpanLookupSize <= 1) goto L29;
        LazySpanLookup r15 = this.mLazySpanLookup;
        r15.mData = r13.mSpanLookup;
        r15.mFullSpanItems = r13.mFullSpanItems;
        return;
    L29:
        return;
    L21:
        r5.mLayoutFromEnd = this.mShouldReverseLayout;
        goto L23
    L5:
        if (r11 != this.mSpanCount) goto L17;
        int r16 = 0;
    L8:
        if (r16 >= this.mSpanCount) goto L18;
        this.mSpans[r16].clear();
        SavedState r17 = this.mPendingSavedState;
        int r18 = r17.mSpanOffsets[r16];
        if (r18 == Integer.MIN_VALUE) goto L16;
        if (r17.mAnchorLayoutFromEnd == false) goto L15;
        int r19 = this.mPrimaryOrientation.getEndAfterPadding();
    L14:
        r18 = r18 + r19;
        goto L16
    L15:
        r19 = this.mPrimaryOrientation.getStartAfterPadding();
    L16:
        this.mSpans[r16].setLine(r18);
        r16 = r16 + 1;
        goto L8
    L17:
        r10.invalidateSpanInfo();
        SavedState r20 = this.mPendingSavedState;
        r20.mAnchorPosition = r20.mVisibleAnchorPosition;
        goto L18
    }

    private void attachViewToSpans(View r5, LayoutParams r10, LayoutState r11) {
        if (r11.mLayoutDirection != 1) goto L9;
        if (r10.mFullSpan == false) goto L7;
        appendViewToAllSpans(r5);
        return;
    L7:
        r10.mSpan.appendToSpan(r5);
        return;
    L9:
        if (r10.mFullSpan == false) goto L11;
        prependViewToAllSpans(r5);
        return;
    L11:
        r10.mSpan.prependToSpan(r5);
    }

    private int calculateScrollDirectionForPosition(int r5) {
        if (getChildCount() != 0) goto L9;
        if (this.mShouldReverseLayout == true) goto L7;
        return -1;
    L7:
        return 1;
    L9:
        if (r5 >= getFirstChildPosition()) goto L11;
        boolean r10 = true;
    L13:
        if (r10 == this.mShouldReverseLayout) goto L16;
        return -1;
    L16:
        return 1;
    L11:
        r10 = false;
        goto L13
    }

    private boolean checkSpanForGap(Span r5) {
        if (this.mShouldReverseLayout == false) goto L9;
        if (r5.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) goto L7;
    L12:
        return false;
    L7:
        return !r5.getLayoutParams((View) a.h(r5.mViews, 1)).mFullSpan;
    L9:
        if (r5.getStartLine() <= this.mPrimaryOrientation.getStartAfterPadding()) goto L12;
        return !r5.getLayoutParams(r5.mViews.get(0)).mFullSpan;
    }

    private int computeScrollExtent(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollExtent(r10, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollOffset(r10, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollRange(r10, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int r5) {
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int r5) {
        LazySpanLookup.FullSpanItem r10 = new LazySpanLookup.FullSpanItem();
        r10.mGapPerSpan = new int[this.mSpanCount];
        int r11 = 0;
    L4:
        if (r11 >= this.mSpanCount) goto L6;
        r10.mGapPerSpan[r11] = r5 - this.mSpans[r11].getEndLine(r5);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int r5) {
        LazySpanLookup.FullSpanItem r10 = new LazySpanLookup.FullSpanItem();
        r10.mGapPerSpan = new int[this.mSpanCount];
        int r11 = 0;
    L4:
        if (r11 >= this.mSpanCount) goto L6;
        r10.mGapPerSpan[r11] = this.mSpans[r11].getStartLine(r5) - r5;
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.RecyclerView$LayoutManager, androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int fill(RecyclerView.Recycler r17, LayoutState r18, RecyclerView.State r19) {
        ?? r10 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite == false) goto L10;
        if (r18.mLayoutDirection != 1) goto L8;
        int r5 = Integer.MAX_VALUE;
    L7:
        int r11 = r5;
        updateAllRemainingSpans(r18.mLayoutDirection, r11);
        if (this.mShouldReverseLayout == false) goto L17;
        int r12 = this.mPrimaryOrientation.getEndAfterPadding();
    L16:
        int r13 = r12;
        ?? r14 = false;
    L20:
        if (r18.hasMore(r19) == false) goto L26;
        if (this.mLayoutState.mInfinite == false) goto L24;
    L27:
        View r15 = r18.next(r17);
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        int r20 = r16.getViewLayoutPosition();
        int r21 = this.mLazySpanLookup.getSpan(r20);
        if (r21 != (-1)) goto L30;
        ?? r22 = 1;
    L31:
        if (r22 != 0) goto L33;
        Span r23 = this.mSpans[r21];
    L37:
        Span r110 = r23;
        r16.mSpan = r110;
        if (r18.mLayoutDirection != 1) goto L42;
        addView(r15);
    L43:
        measureChildWithDecorationsAndMargin(r15, r16, r10);
        if (r18.mLayoutDirection != 1) goto L56;
        if (r16.mFullSpan == false) goto L48;
        int r24 = getMaxEnd(r13);
    L49:
        int r25 = this.mPrimaryOrientation.getDecoratedMeasurement(r15) + r24;
        if (r22 != 0) goto L52;
    L54:
        int r26 = r25;
        int r27 = r24;
    L66:
        if (r16.mFullSpan == true) goto L68;
    L81:
        attachViewToSpans(r15, r16, r18);
        if (isLayoutRTL() == false) goto L91;
        if (this.mOrientation != 1) goto L91;
        if (r16.mFullSpan == false) goto L88;
        int r28 = this.mSecondaryOrientation.getEndAfterPadding();
    L89:
        int r29 = r28;
        int r30 = r28 - this.mSecondaryOrientation.getDecoratedMeasurement(r15);
    L96:
        if (this.mOrientation != 1) goto L98;
        layoutDecoratedWithMargins(r15, r30, r27, r29, r26);
    L100:
        if (r16.mFullSpan == false) goto L102;
        updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, r11);
    L103:
        recycle(r17, this.mLayoutState);
        if (this.mLayoutState.mStopInFocusable == true) goto L106;
    L110:
        boolean r31 = false;
    L112:
        r10 = r31;
        r14 = true;
        goto L20
    L106:
        if (r15.hasFocusable() == false) goto L110;
        if (r16.mFullSpan == false) goto L111;
        this.mRemainingSpans.clear();
        goto L110
    L111:
        r31 = false;
        this.mRemainingSpans.set(r110.mIndex, false);
        goto L112
    L102:
        updateRemainingSpans(r110, this.mLayoutState.mLayoutDirection, r11);
        goto L103
    L98:
        layoutDecoratedWithMargins(r15, r27, r30, r26, r29);
        goto L100
    L88:
        r28 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - r110.mIndex) * this.mSizePerSpan);
    L91:
        if (r16.mFullSpan == false) goto L93;
        int r32 = this.mSecondaryOrientation.getStartAfterPadding();
    L94:
        r30 = r32;
        r29 = this.mSecondaryOrientation.getDecoratedMeasurement(r15) + r32;
        goto L96
    L93:
        r32 = (r110.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
        goto L94
    L68:
        if (r18.mItemDirection != (-1)) goto L81;
        if (r22 == 0) goto L72;
        this.mLaidOutInvalidFullSpan = true;
        goto L81
    L72:
        if (r18.mLayoutDirection != 1) goto L75;
        boolean r33 = areAllEndsEqual();
    L76:
        if ((!r33) == false) goto L81;
        LazySpanLookup.FullSpanItem r34 = this.mLazySpanLookup.getFullSpanItem(r20);
        if (r34 == null) goto L80;
        r34.mHasUnwantedGapAfter = true;
    L80:
        this.mLaidOutInvalidFullSpan = true;
        goto L81
    L75:
        r33 = areAllStartsEqual();
        goto L76
    L52:
        if (r16.mFullSpan == false) goto L54;
        LazySpanLookup.FullSpanItem r35 = createFullSpanItemFromEnd(r24);
        r35.mGapDir = -1;
        r35.mPosition = r20;
        this.mLazySpanLookup.addFullSpanItem(r35);
        goto L54
    L48:
        r24 = r110.getEndLine(r13);
        goto L49
    L56:
        if (r16.mFullSpan == false) goto L58;
        int r36 = getMinStart(r13);
    L59:
        r27 = r36 - this.mPrimaryOrientation.getDecoratedMeasurement(r15);
        if (r22 != 0) goto L62;
    L64:
        r26 = r36;
        goto L66
    L62:
        if (r16.mFullSpan == false) goto L64;
        LazySpanLookup.FullSpanItem r37 = createFullSpanItemFromStart(r36);
        r37.mGapDir = 1;
        r37.mPosition = r20;
        this.mLazySpanLookup.addFullSpanItem(r37);
        goto L64
    L58:
        r36 = r110.getStartLine(r13);
        goto L59
    L42:
        addView(r15, r10);
        goto L43
    L33:
        if (r16.mFullSpan == false) goto L35;
        r23 = this.mSpans[r10];
    L36:
        this.mLazySpanLookup.setSpan(r20, r23);
        goto L37
    L35:
        r23 = getNextSpan(r18);
        goto L36
    L30:
        r22 = r10;
        goto L31
    L24:
        if (this.mRemainingSpans.isEmpty() == false) goto L27;
    L26:
        ?? r38 = r10;
        if (r14 == true) goto L116;
        recycle(r17, this.mLayoutState);
    L116:
        if (this.mLayoutState.mLayoutDirection != (-1)) goto L118;
        int r39 = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
    L119:
        if (r39 <= 0) goto L122;
        return Math.min(r18.mAvailable, r39);
    L122:
        return r38 == true ? 1 : 0;
    L118:
        r39 = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        goto L119
    L17:
        r12 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L16
    L8:
        r5 = Integer.MIN_VALUE;
        goto L7
    L10:
        if (r18.mLayoutDirection != 1) goto L12;
        r5 = r18.mEndLine + r18.mAvailable;
        goto L7
    L12:
        r5 = r18.mStartLine - r18.mAvailable;
        goto L7
    }

    private int findFirstReferenceChildPosition(int r5) {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        int r12 = getPosition(getChildAt(r11));
        if (r12 < 0) goto L8;
        if (r12 >= r5) goto L8;
        return r12;
    L8:
        r11 = r11 + 1;
        goto L3
    L9:
        return 0;
    }

    private int findLastReferenceChildPosition(int r5) {
        int r10 = getChildCount() - 1;
    L3:
        if (r10 < 0) goto L9;
        int r11 = getPosition(getChildAt(r10));
        if (r11 < 0) goto L8;
        if (r11 >= r5) goto L8;
        return r11;
    L8:
        r10 = r10 - 1;
        goto L3
    L9:
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler r5, RecyclerView.State r10, boolean r11) {
        int r12 = getMaxEnd(Integer.MIN_VALUE);
        if (r12 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        int r13 = this.mPrimaryOrientation.getEndAfterPadding() - r12;
        if (r13 <= 0) goto L12;
        int r14 = r13 - (-scrollBy(-r13, r5, r10));
        if (r11 == false) goto L13;
        if (r14 <= 0) goto L14;
        this.mPrimaryOrientation.offsetChildren(r14);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void fixStartGap(RecyclerView.Recycler r5, RecyclerView.State r10, boolean r11) {
        int r12 = getMinStart(Integer.MAX_VALUE);
        if (r12 != Integer.MAX_VALUE) goto L5;
        return;
    L5:
        int r13 = r12 - this.mPrimaryOrientation.getStartAfterPadding();
        if (r13 <= 0) goto L12;
        int r14 = r13 - scrollBy(r13, r5, r10);
        if (r11 == false) goto L13;
        if (r14 <= 0) goto L14;
        this.mPrimaryOrientation.offsetChildren(-r14);
        return;
    L14:
        return;
    L13:
        return;
    }

    private int getMaxEnd(int r5) {
        int r10 = this.mSpans[0].getEndLine(r5);
        int r11 = 1;
    L4:
        if (r11 >= this.mSpanCount) goto L9;
        int r12 = this.mSpans[r11].getEndLine(r5);
        if (r12 <= r10) goto L8;
        r10 = r12;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    private int getMaxStart(int r5) {
        int r10 = this.mSpans[0].getStartLine(r5);
        int r11 = 1;
    L4:
        if (r11 >= this.mSpanCount) goto L9;
        int r12 = this.mSpans[r11].getStartLine(r5);
        if (r12 <= r10) goto L8;
        r10 = r12;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    private int getMinEnd(int r5) {
        int r10 = this.mSpans[0].getEndLine(r5);
        int r11 = 1;
    L4:
        if (r11 >= this.mSpanCount) goto L9;
        int r12 = this.mSpans[r11].getEndLine(r5);
        if (r12 >= r10) goto L8;
        r10 = r12;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    private int getMinStart(int r5) {
        int r10 = this.mSpans[0].getStartLine(r5);
        int r11 = 1;
    L4:
        if (r11 >= this.mSpanCount) goto L9;
        int r12 = this.mSpans[r11].getStartLine(r5);
        if (r12 >= r10) goto L8;
        r10 = r12;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    private Span getNextSpan(LayoutState r10) {
        if (preferLastSpan(r10.mLayoutDirection) == false) goto L5;
        int r5 = this.mSpanCount - 1;
        int r11 = -1;
        int r12 = -1;
    L6:
        Span r13 = null;
        if (r10.mLayoutDirection != 1) goto L15;
        int r14 = this.mPrimaryOrientation.getStartAfterPadding();
        int r15 = Integer.MAX_VALUE;
    L9:
        if (r5 == r11) goto L14;
        Span r16 = this.mSpans[r5];
        int r17 = r16.getEndLine(r14);
        if (r17 >= r15) goto L13;
        r13 = r16;
        r15 = r17;
    L13:
        r5 = r5 + r12;
        goto L9
    L14:
        return r13;
    L15:
        int r18 = this.mPrimaryOrientation.getEndAfterPadding();
        int r19 = Integer.MIN_VALUE;
    L16:
        if (r5 == r11) goto L21;
        Span r20 = this.mSpans[r5];
        int r21 = r20.getStartLine(r18);
        if (r21 <= r19) goto L20;
        r13 = r20;
        r19 = r21;
    L20:
        r5 = r5 + r12;
        goto L16
    L21:
        return r13;
    L5:
        r11 = this.mSpanCount;
        r5 = 0;
        r12 = 1;
        goto L6
    }

    private void handleUpdate(int r10, int r11, int r12) {
        if (this.mShouldReverseLayout == false) goto L5;
        int r5 = getLastChildPosition();
    L7:
        if (r12 != 8) goto L12;
        if (r10 >= r11) goto L11;
        int r13 = r11 + 1;
    L10:
        int r14 = r10;
    L13:
        this.mLazySpanLookup.invalidateAfter(r14);
        if (r12 != 1) goto L16;
        this.mLazySpanLookup.offsetForAddition(r10, r11);
    L22:
        if (r13 > r5) goto L25;
        return;
    L25:
        if (this.mShouldReverseLayout == false) goto L27;
        int r15 = getFirstChildPosition();
    L28:
        if (r14 > r15) goto L31;
        requestLayout();
        return;
    L31:
        return;
    L27:
        r15 = getLastChildPosition();
        goto L28
    L16:
        if (r12 == 2) goto L20;
        if (r12 != 8) goto L22;
        this.mLazySpanLookup.offsetForRemoval(r10, 1);
        this.mLazySpanLookup.offsetForAddition(r11, 1);
        goto L22
    L20:
        this.mLazySpanLookup.offsetForRemoval(r10, r11);
        goto L22
    L11:
        r13 = r10 + 1;
        r14 = r11;
        goto L13
    L12:
        r13 = r10 + r11;
        goto L10
    L5:
        r5 = getFirstChildPosition();
        goto L7
    }

    private void measureChildWithDecorationsAndMargin(View r10, LayoutParams r11, boolean r12) {
        if (r11.mFullSpan == false) goto L9;
        if (this.mOrientation != 1) goto L7;
        int r5 = this.mFullSizeSpec;
        int r13 = getHeight();
        int r14 = getHeightMode();
        int r15 = getPaddingTop();
        measureChildWithDecorationsAndMargin(r10, r5, RecyclerView.LayoutManager.getChildMeasureSpec(r13, r14, getPaddingBottom() + r15, ((ViewGroup.MarginLayoutParams) r11).height, true), r12);
        return;
    L7:
        int r16 = getWidth();
        int r17 = getWidthMode();
        int r18 = getPaddingLeft();
        measureChildWithDecorationsAndMargin(r10, RecyclerView.LayoutManager.getChildMeasureSpec(r16, r17, getPaddingRight() + r18, ((ViewGroup.MarginLayoutParams) r11).width, true), this.mFullSizeSpec, r12);
        return;
    L9:
        if (this.mOrientation != 1) goto L11;
        int r19 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) r11).width, false);
        int r20 = getHeight();
        int r21 = getHeightMode();
        int r22 = getPaddingTop();
        measureChildWithDecorationsAndMargin(r10, r19, RecyclerView.LayoutManager.getChildMeasureSpec(r20, r21, getPaddingBottom() + r22, ((ViewGroup.MarginLayoutParams) r11).height, true), r12);
        return;
    L11:
        int r23 = getWidth();
        int r24 = getWidthMode();
        int r25 = getPaddingLeft();
        measureChildWithDecorationsAndMargin(r10, RecyclerView.LayoutManager.getChildMeasureSpec(r23, r24, getPaddingRight() + r25, ((ViewGroup.MarginLayoutParams) r11).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) r11).height, false), r12);
    }

    private boolean preferLastSpan(int r5) {
        if (this.mOrientation != 0) goto L11;
        if (r5 != (-1)) goto L6;
        boolean r10 = true;
    L8:
        if (r10 != this.mShouldReverseLayout) goto L10;
        return false;
    L10:
        return true;
    L6:
        r10 = false;
        goto L8
    L11:
        if (r5 != (-1)) goto L13;
        boolean r11 = true;
    L15:
        if (r11 != this.mShouldReverseLayout) goto L17;
        boolean r12 = true;
    L19:
        if (r12 == isLayoutRTL()) goto L21;
        return false;
    L21:
        return true;
    L17:
        r12 = false;
        goto L19
    L13:
        r11 = false;
        goto L15
    }

    private void prependViewToAllSpans(View r5) {
        int r10 = this.mSpanCount - 1;
    L3:
        if (r10 < 0) goto L5;
        this.mSpans[r10].prependToSpan(r5);
        r10 = r10 - 1;
        goto L3
    }

    private void recycle(RecyclerView.Recycler r5, LayoutState r10) {
        if (r10.mRecycle == true) goto L5;
        return;
    L5:
        if (r10.mInfinite == false) goto L8;
        return;
    L8:
        if (r10.mAvailable != 0) goto L14;
        if (r10.mLayoutDirection != (-1)) goto L12;
        recycleFromEnd(r5, r10.mEndLine);
        return;
    L12:
        recycleFromStart(r5, r10.mStartLine);
        return;
    L14:
        if (r10.mLayoutDirection != (-1)) goto L20;
        int r11 = r10.mStartLine;
        int r12 = r11 - getMaxStart(r11);
        if (r12 >= 0) goto L18;
        int r13 = r10.mEndLine;
    L19:
        recycleFromEnd(r5, r13);
        return;
    L18:
        r13 = r10.mEndLine - Math.min(r12, r10.mAvailable);
        goto L19
    L20:
        int r14 = getMinEnd(r10.mEndLine) - r10.mEndLine;
        if (r14 >= 0) goto L23;
        int r15 = r10.mStartLine;
    L24:
        recycleFromStart(r5, r15);
        return;
    L23:
        int r16 = r10.mStartLine;
        r15 = Math.min(r14, r10.mAvailable) + r16;
        goto L24
    }

    private void recycleFromEnd(RecyclerView.Recycler r10, int r11) {
        int r5 = getChildCount() - 1;
    L3:
        if (r5 < 0) goto L25;
        View r12 = getChildAt(r5);
        if (this.mPrimaryOrientation.getDecoratedStart(r12) < r11) goto L34;
        if (this.mPrimaryOrientation.getTransformedStartWithDecoration(r12) < r11) goto L35;
        LayoutParams r13 = (LayoutParams) r12.getLayoutParams();
        if (r13.mFullSpan == false) goto L21;
        int r14 = 0;
        int r15 = 0;
    L12:
        if (r15 >= this.mSpanCount) goto L18;
        if (this.mSpans[r15].mViews.size() == 1) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r14 >= this.mSpanCount) goto L24;
        this.mSpans[r14].popEnd();
        r14 = r14 + 1;
    L24:
        removeAndRecycleView(r12, r10);
        r5 = r5 - 1;
        goto L3
    L21:
        if (r13.mSpan.mViews.size() == 1) goto L22;
        r13.mSpan.popEnd();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private void recycleFromStart(RecyclerView.Recycler r10, int r11) {
    L3:
        if (getChildCount() <= 0) goto L25;
        int r5 = 0;
        View r12 = getChildAt(0);
        if (this.mPrimaryOrientation.getDecoratedEnd(r12) > r11) goto L34;
        if (this.mPrimaryOrientation.getTransformedEndWithDecoration(r12) > r11) goto L35;
        LayoutParams r13 = (LayoutParams) r12.getLayoutParams();
        if (r13.mFullSpan == false) goto L21;
        int r14 = 0;
    L12:
        if (r14 >= this.mSpanCount) goto L18;
        if (this.mSpans[r14].mViews.size() == 1) goto L15;
        r14 = r14 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r5 >= this.mSpanCount) goto L24;
        this.mSpans[r5].popStart();
        r5 = r5 + 1;
    L24:
        removeAndRecycleView(r12, r10);
        goto L3
    L21:
        if (r13.mSpan.mViews.size() == 1) goto L22;
        r13.mSpan.popStart();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() != 1073741824) goto L5;
        return;
    L5:
        int r5 = getChildCount();
        int r10 = 0;
        float r11 = 0.0f;
        int r12 = 0;
    L6:
        if (r12 >= r5) goto L15;
        View r13 = getChildAt(r12);
        float r14 = this.mSecondaryOrientation.getDecoratedMeasurement(r13);
        if (r14 < r11) goto L14;
        if (((LayoutParams) r13.getLayoutParams()).isFullSpan() == false) goto L13;
        r14 = (r14 * 1.0f) / this.mSpanCount;
    L13:
        r11 = Math.max(r11, r14);
    L14:
        r12 = r12 + 1;
        goto L6
    L15:
        int r15 = this.mSizePerSpan;
        int r16 = Math.round(r11 * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() != Integer.MIN_VALUE) goto L18;
        r16 = Math.min(r16, this.mSecondaryOrientation.getTotalSpace());
    L18:
        updateMeasureSpecs(r16);
        if (this.mSizePerSpan != r15) goto L21;
        return;
    L21:
        if (r10 >= r5) goto L35;
        View r17 = getChildAt(r10);
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        if (r18.mFullSpan == true) goto L34;
        if (isLayoutRTL() == true) goto L28;
    L30:
        int r19 = r18.mSpan.mIndex;
        int r20 = this.mSizePerSpan * r19;
        int r21 = r19 * r15;
        if (this.mOrientation != 1) goto L33;
        r17.offsetLeftAndRight(r20 - r21);
        goto L34
    L33:
        r17.offsetTopAndBottom(r20 - r21);
        goto L34
    L28:
        if (this.mOrientation != 1) goto L30;
        int r22 = this.mSpanCount;
        int r23 = r18.mSpan.mIndex;
        r17.offsetLeftAndRight(((-((r22 - 1) - r23)) * this.mSizePerSpan) - ((-((r22 - 1) - r23)) * r15));
    L34:
        r10 = r10 + 1;
        goto L21
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

    private void setLayoutStateDirection(int r5) {
        LayoutState r10 = this.mLayoutState;
        r10.mLayoutDirection = r5;
        boolean r11 = this.mShouldReverseLayout;
        int r12 = 1;
        if (r5 != (-1)) goto L5;
        boolean r13 = true;
    L6:
        if (r11 == r13) goto L9;
        r12 = -1;
    L9:
        r10.mItemDirection = r12;
        return;
    L5:
        r13 = false;
        goto L6
    }

    private void updateAllRemainingSpans(int r5, int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mSpanCount) goto L10;
        if (this.mSpans[r11].mViews.isEmpty() == true) goto L9;
        updateRemainingSpans(this.mSpans[r11], r5, r10);
    L9:
        r11 = r11 + 1;
        goto L4
    }

    private boolean updateAnchorFromChildren(RecyclerView.State r5, AnchorInfo r10) {
        if (this.mLastLayoutFromEnd == false) goto L5;
        int r11 = findLastReferenceChildPosition(r5.getItemCount());
    L6:
        r10.mPosition = r11;
        r10.mOffset = Integer.MIN_VALUE;
        return true;
    L5:
        r11 = findFirstReferenceChildPosition(r5.getItemCount());
        goto L6
    }

    private void updateLayoutState(int r5, RecyclerView.State r10) {
        LayoutState r11 = this.mLayoutState;
        boolean r12 = false;
        r11.mAvailable = 0;
        r11.mCurrentPosition = r5;
        if (isSmoothScrolling() == false) goto L13;
        int r13 = r10.getTargetScrollPosition();
        if (r13 == (-1)) goto L13;
        boolean r14 = this.mShouldReverseLayout;
        if (r13 >= r5) goto L9;
        boolean r15 = true;
    L10:
        if (r14 != r15) goto L12;
        int r16 = this.mPrimaryOrientation.getTotalSpace();
        int r17 = 0;
    L15:
        if (getClipToPadding() == false) goto L17;
        this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - r17;
        this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + r16;
    L18:
        LayoutState r18 = this.mLayoutState;
        r18.mStopInFocusable = false;
        r18.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0) goto L21;
    L23:
        r18.mInfinite = r12;
        return;
    L21:
        if (this.mPrimaryOrientation.getEnd() != 0) goto L23;
        r12 = true;
        goto L23
    L17:
        this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + r16;
        this.mLayoutState.mStartLine = -r17;
        goto L18
    L12:
        r17 = this.mPrimaryOrientation.getTotalSpace();
        r16 = 0;
        goto L15
    L9:
        r15 = false;
    L13:
        r16 = 0;
        r17 = 0;
        goto L15
    }

    private void updateRemainingSpans(Span r5, int r10, int r11) {
        int r12 = r5.getDeletedSize();
        if (r10 != (-1)) goto L8;
        if ((r5.getStartLine() + r12) > r11) goto L11;
        this.mRemainingSpans.set(r5.mIndex, false);
        return;
    L11:
        return;
    L8:
        if ((r5.getEndLine() - r12) < r11) goto L13;
        this.mRemainingSpans.set(r5.mIndex, false);
        return;
    }

    private int updateSpecWithExtra(int r5, int r10, int r11) {
        if (r10 != 0) goto L5;
        if (r11 != 0) goto L5;
        return r5;
    L5:
        int r12 = View.MeasureSpec.getMode(r5);
        if (r12 == Integer.MIN_VALUE) goto L12;
        if (r12 == 1073741824) goto L12;
        return r5;
    L12:
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r5) - r10) - r11), r12);
    }

    public boolean areAllEndsEqual() {
        int r5 = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        int r10 = 1;
    L4:
        if (r10 >= this.mSpanCount) goto L9;
        if (this.mSpans[r10].getEndLine(Integer.MIN_VALUE) != r5) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public boolean areAllStartsEqual() {
        int r5 = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        int r10 = 1;
    L4:
        if (r10 >= this.mSpanCount) goto L9;
        if (this.mSpans[r10].getStartLine(Integer.MIN_VALUE) != r5) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r5) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r5);
        return;
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

    public boolean checkForGaps() {
        if (getChildCount() != 0) goto L5;
    L36:
        return false;
    L5:
        if (this.mGapStrategy == 0) goto L36;
        if (isAttachedToWindow() == false) goto L36;
        if (this.mShouldReverseLayout == false) goto L12;
        int r5 = getLastChildPosition();
        int r10 = getFirstChildPosition();
    L14:
        if (r5 != 0) goto L20;
        if (hasGapsToFix() == null) goto L20;
        this.mLazySpanLookup.clear();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L20:
        if (this.mLaidOutInvalidFullSpan == true) goto L23;
        return false;
    L23:
        if (this.mShouldReverseLayout == false) goto L25;
        int r11 = -1;
    L26:
        int r12 = r10 + 1;
        LazySpanLookup.FullSpanItem r13 = this.mLazySpanLookup.getFirstFullSpanItemInRange(r5, r12, r11, true);
        if (r13 != null) goto L30;
        this.mLaidOutInvalidFullSpan = false;
        this.mLazySpanLookup.forceInvalidateAfter(r12);
        return false;
    L30:
        LazySpanLookup.FullSpanItem r14 = this.mLazySpanLookup.getFirstFullSpanItemInRange(r5, r13.mPosition, r11 * (-1), true);
        if (r14 != null) goto L33;
        this.mLazySpanLookup.forceInvalidateAfter(r13.mPosition);
    L34:
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L33:
        this.mLazySpanLookup.forceInvalidateAfter(r14.mPosition + 1);
        goto L34
    L25:
        r11 = 1;
        goto L26
    L12:
        r5 = getFirstChildPosition();
        r10 = getLastChildPosition();
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int r5, int r10, RecyclerView.State r11, RecyclerView.LayoutManager.LayoutPrefetchRegistry r12) {
        if (this.mOrientation == 0) goto L7;
        r5 = r10;
    L7:
        if (getChildCount() == 0) goto L31;
        if (r5 == 0) goto L37;
        prepareLayoutStateForDelta(r5, r11);
        int[] r13 = this.mPrefetchDistances;
        if (r13 != null) goto L13;
    L14:
        this.mPrefetchDistances = new int[this.mSpanCount];
    L15:
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L17:
        if (r15 >= this.mSpanCount) goto L26;
        LayoutState r17 = this.mLayoutState;
        if (r17.mItemDirection != (-1)) goto L22;
        int r18 = r17.mStartLine;
        int r19 = this.mSpans[r15].getStartLine(r18);
    L21:
        int r20 = r18 - r19;
        if (r20 < 0) goto L25;
        this.mPrefetchDistances[r16] = r20;
        r16 = r16 + 1;
    L25:
        r15 = r15 + 1;
        goto L17
    L22:
        r18 = this.mSpans[r15].getEndLine(r17.mEndLine);
        r19 = this.mLayoutState.mEndLine;
        goto L21
    L26:
        Arrays.sort(this.mPrefetchDistances, 0, r16);
    L27:
        if (r14 >= r16) goto L38;
        if (this.mLayoutState.hasMore(r11) == false) goto L39;
        r12.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[r14]);
        LayoutState r21 = this.mLayoutState;
        r21.mCurrentPosition += r21.mItemDirection;
        r14 = r14 + 1;
        goto L27
    L39:
        return;
    L38:
        return;
    L13:
        if (r13.length >= this.mSpanCount) goto L15;
    L37:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State r5) {
        return computeScrollExtent(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r5) {
        return computeScrollOffset(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r5) {
        return computeScrollRange(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r5) {
        int r10 = calculateScrollDirectionForPosition(r5);
        PointF r11 = new PointF();
        if (r10 != 0) goto L7;
        return null;
    L7:
        if (this.mOrientation != 0) goto L9;
        r11.x = r10;
        r11.y = 0.0f;
    L10:
        return r11;
    L9:
        r11.x = 0.0f;
        r11.y = r10;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State r5) {
        return computeScrollExtent(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r5) {
        return computeScrollOffset(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r5) {
        return computeScrollRange(r5);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] r5) {
        if (r5 != null) goto L5;
        r5 = new int[this.mSpanCount];
    L6:
        int r10 = 0;
    L8:
        if (r10 >= this.mSpanCount) goto L10;
        r5[r10] = this.mSpans[r10].findFirstCompletelyVisibleItemPosition();
        r10 = r10 + 1;
        goto L8
    L10:
        return r5;
    L5:
        if (r5.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r5.length);
    }

    public View findFirstVisibleItemClosestToEnd(boolean r10) {
        int r5 = this.mPrimaryOrientation.getStartAfterPadding();
        int r11 = this.mPrimaryOrientation.getEndAfterPadding();
        int r12 = getChildCount() - 1;
        View r13 = null;
    L3:
        if (r12 < 0) goto L15;
        View r14 = getChildAt(r12);
        int r15 = this.mPrimaryOrientation.getDecoratedStart(r14);
        int r16 = this.mPrimaryOrientation.getDecoratedEnd(r14);
        if (r16 <= r5) goto L14;
        if (r15 >= r11) goto L14;
        if (r16 <= r11) goto L13;
        if (r10 == false) goto L13;
        if (r13 != null) goto L14;
        r13 = r14;
    L13:
        return r14;
    L14:
        r12 = r12 - 1;
        goto L3
    L15:
        return r13;
    }

    public View findFirstVisibleItemClosestToStart(boolean r10) {
        int r5 = this.mPrimaryOrientation.getStartAfterPadding();
        int r11 = this.mPrimaryOrientation.getEndAfterPadding();
        int r12 = getChildCount();
        View r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L15;
        View r15 = getChildAt(r14);
        int r16 = this.mPrimaryOrientation.getDecoratedStart(r15);
        if (this.mPrimaryOrientation.getDecoratedEnd(r15) <= r5) goto L14;
        if (r16 >= r11) goto L14;
        if (r16 >= r5) goto L13;
        if (r10 == false) goto L13;
        if (r13 != null) goto L14;
        r13 = r15;
    L13:
        return r15;
    L14:
        r14 = r14 + 1;
        goto L3
    L15:
        return r13;
    }

    public int findFirstVisibleItemPositionInt() {
        if (this.mShouldReverseLayout == false) goto L5;
        View r5 = findFirstVisibleItemClosestToEnd(true);
    L6:
        if (r5 != null) goto L9;
        return -1;
    L9:
        return getPosition(r5);
    L5:
        r5 = findFirstVisibleItemClosestToStart(true);
        goto L6
    }

    public int[] findFirstVisibleItemPositions(int[] r5) {
        if (r5 != null) goto L5;
        r5 = new int[this.mSpanCount];
    L6:
        int r10 = 0;
    L8:
        if (r10 >= this.mSpanCount) goto L10;
        r5[r10] = this.mSpans[r10].findFirstVisibleItemPosition();
        r10 = r10 + 1;
        goto L8
    L10:
        return r5;
    L5:
        if (r5.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r5.length);
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] r5) {
        if (r5 != null) goto L5;
        r5 = new int[this.mSpanCount];
    L6:
        int r10 = 0;
    L8:
        if (r10 >= this.mSpanCount) goto L10;
        r5[r10] = this.mSpans[r10].findLastCompletelyVisibleItemPosition();
        r10 = r10 + 1;
        goto L8
    L10:
        return r5;
    L5:
        if (r5.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r5.length);
    }

    public int[] findLastVisibleItemPositions(int[] r5) {
        if (r5 != null) goto L5;
        r5 = new int[this.mSpanCount];
    L6:
        int r10 = 0;
    L8:
        if (r10 >= this.mSpanCount) goto L10;
        r5[r10] = this.mSpans[r10].findLastVisibleItemPosition();
        r10 = r10 + 1;
        goto L8
    L10:
        return r5;
    L5:
        if (r5.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r5.length);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r5, AttributeSet r10) {
        return new LayoutParams(r5, r10);
    }

    public int getFirstChildPosition() {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(0));
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getLastChildPosition() {
        int r5 = getChildCount();
        if (r5 != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(r5 - 1));
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public View hasGapsToFix() {
        int r5 = getChildCount();
        int r10 = r5 - 1;
        BitSet r11 = new BitSet(this.mSpanCount);
        r11.set(0, this.mSpanCount, true);
        int r12 = -1;
        if (this.mOrientation == 1) goto L5;
    L7:
        byte r13 = -1;
    L9:
        if (this.mShouldReverseLayout == false) goto L11;
        r5 = -1;
    L12:
        if (r10 >= r5) goto L14;
        r12 = 1;
    L14:
        if (r10 == r5) goto L47;
        View r14 = getChildAt(r10);
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (r11.get(r15.mSpan.mIndex) == false) goto L22;
        if (checkSpanForGap(r15.mSpan) == true) goto L19;
        r11.clear(r15.mSpan.mIndex);
        goto L22
    L19:
        return r14;
    L22:
        if (r15.mFullSpan == true) goto L46;
        int r16 = r10 + r12;
        if (r16 == r5) goto L46;
        View r17 = getChildAt(r16);
        if (this.mShouldReverseLayout == false) goto L33;
        int r18 = this.mPrimaryOrientation.getDecoratedEnd(r14);
        int r19 = this.mPrimaryOrientation.getDecoratedEnd(r17);
        if (r18 < r19) goto L30;
        if (r18 != r19) goto L46;
    L38:
        if ((r15.mSpan.mIndex - ((LayoutParams) r17.getLayoutParams()).mSpan.mIndex) >= 0) goto L40;
        boolean r20 = true;
    L41:
        if (r13 >= 0) goto L43;
        boolean r21 = true;
    L44:
        if (r20 == r21) goto L46;
        return r14;
    L43:
        r21 = false;
        goto L44
    L40:
        r20 = false;
        goto L41
    L30:
        return r14;
    L33:
        int r110 = this.mPrimaryOrientation.getDecoratedStart(r14);
        int r111 = this.mPrimaryOrientation.getDecoratedStart(r17);
        if (r110 > r111) goto L35;
        if (r110 != r111) goto L46;
    L35:
        return r14;
    L46:
        r10 = r10 + r12;
        goto L14
    L47:
        return null;
    L11:
        r10 = 0;
        goto L12
    L5:
        if (isLayoutRTL() == false) goto L7;
        r13 = 1;
        goto L9
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        if (this.mGapStrategy == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int r5) {
        super.offsetChildrenHorizontal(r5);
        int r10 = 0;
    L4:
        if (r10 >= this.mSpanCount) goto L6;
        this.mSpans[r10].onOffset(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int r5) {
        super.offsetChildrenVertical(r5);
        int r10 = 0;
    L4:
        if (r10 >= this.mSpanCount) goto L6;
        this.mSpans[r10].onOffset(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(@Nullable RecyclerView.Adapter r5, @Nullable RecyclerView.Adapter r10) {
        this.mLazySpanLookup.clear();
        int r11 = 0;
    L4:
        if (r11 >= this.mSpanCount) goto L6;
        this.mSpans[r11].clear();
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r5, RecyclerView.Recycler r10) {
        super.onDetachedFromWindow(r5, r10);
        removeCallbacks(this.mCheckForGapsRunnable);
        int r11 = 0;
    L4:
        if (r11 >= this.mSpanCount) goto L6;
        this.mSpans[r11].clear();
        r11 = r11 + 1;
        goto L4
    L6:
        r5.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public View onFocusSearchFailed(View r10, int r11, RecyclerView.Recycler r12, RecyclerView.State r13) {
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        View r14 = findContainingItemView(r10);
        if (r14 != null) goto L8;
        return null;
    L8:
        resolveShouldLayoutReverse();
        int r15 = convertFocusDirectionToLayoutDirection(r11);
        if (r15 != Integer.MIN_VALUE) goto L11;
        return null;
    L11:
        LayoutParams r5 = (LayoutParams) r14.getLayoutParams();
        boolean r16 = r5.mFullSpan;
        Span r17 = r5.mSpan;
        if (r15 != 1) goto L14;
        int r18 = getLastChildPosition();
    L15:
        updateLayoutState(r18, r13);
        setLayoutStateDirection(r15);
        LayoutState r19 = this.mLayoutState;
        r19.mCurrentPosition = r19.mItemDirection + r18;
        r19.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * MAX_SCROLL_FACTOR);
        LayoutState r20 = this.mLayoutState;
        r20.mStopInFocusable = true;
        int r21 = 0;
        r20.mRecycle = false;
        fill(r12, r20, r13);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (r16 == true) goto L22;
        View r110 = r17.getFocusableViewAfter(r18, r15);
        if (r110 == null) goto L22;
        if (r110 == r14) goto L22;
        return r110;
    L22:
        if (preferLastSpan(r15) == false) goto L30;
        int r111 = this.mSpanCount - 1;
    L24:
        if (r111 < 0) goto L38;
        View r112 = this.mSpans[r111].getFocusableViewAfter(r18, r15);
        if (r112 == null) goto L29;
        if (r112 == r14) goto L29;
        return r112;
    L29:
        r111 = r111 - 1;
    L38:
        boolean r113 = !this.mReverseLayout;
        if (r15 != (-1)) goto L41;
        boolean r114 = true;
    L42:
        if (r113 != r114) goto L44;
        boolean r115 = true;
    L45:
        if (r16 == true) goto L54;
        if (r115 == false) goto L48;
        int r116 = r17.findFirstPartiallyVisibleItemPosition();
    L49:
        View r117 = findViewByPosition(r116);
        if (r117 == null) goto L54;
        if (r117 == r14) goto L54;
        return r117;
    L48:
        r116 = r17.findLastPartiallyVisibleItemPosition();
    L54:
        if (preferLastSpan(r15) == false) goto L69;
        int r118 = this.mSpanCount - 1;
    L56:
        if (r118 < 0) goto L78;
        if (r118 == r17.mIndex) goto L67;
        if (r115 == false) goto L62;
        int r119 = this.mSpans[r118].findFirstPartiallyVisibleItemPosition();
    L63:
        View r120 = findViewByPosition(r119);
        if (r120 == null) goto L67;
        if (r120 == r14) goto L67;
        return r120;
    L62:
        r119 = this.mSpans[r118].findLastPartiallyVisibleItemPosition();
    L67:
        r118 = r118 - 1;
    L78:
        return null;
    L69:
        if (r21 >= this.mSpanCount) goto L78;
        if (r115 == false) goto L72;
        int r121 = this.mSpans[r21].findFirstPartiallyVisibleItemPosition();
    L73:
        View r122 = findViewByPosition(r121);
        if (r122 == null) goto L77;
        if (r122 == r14) goto L77;
        return r122;
    L77:
        r21 = r21 + 1;
        goto L69
    L72:
        r121 = this.mSpans[r21].findLastPartiallyVisibleItemPosition();
        goto L73
    L44:
        r115 = false;
        goto L45
    L41:
        r114 = false;
        goto L42
    L30:
        int r123 = 0;
    L32:
        if (r123 >= this.mSpanCount) goto L38;
        View r124 = this.mSpans[r123].getFocusableViewAfter(r18, r15);
        if (r124 == null) goto L37;
        if (r124 == r14) goto L37;
        return r124;
    L37:
        r123 = r123 + 1;
        goto L32
    L14:
        r18 = getFirstChildPosition();
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        if (getChildCount() <= 0) goto L13;
        View r10 = findFirstVisibleItemClosestToStart(false);
        View r11 = findFirstVisibleItemClosestToEnd(false);
        if (r10 == null) goto L14;
        if (r11 == null) goto L16;
        int r12 = getPosition(r10);
        int r13 = getPosition(r11);
        if (r12 >= r13) goto L11;
        r5.setFromIndex(r12);
        r5.setToIndex(r13);
        return;
    L11:
        r5.setFromIndex(r13);
        r5.setToIndex(r12);
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r5, int r10, int r11) {
        handleUpdate(r10, r11, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r5) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r5, int r10, int r11, int r12) {
        handleUpdate(r10, r11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r5, int r10, int r11) {
        handleUpdate(r10, r11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r5, int r10, int r11, Object r12) {
        handleUpdate(r10, r11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r5, RecyclerView.State r10) {
        onLayoutChildren(r5, r10, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r5) {
        super.onLayoutCompleted(r5);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == false) goto L9;
        SavedState r10 = (SavedState) r5;
        this.mPendingSavedState = r10;
        if (this.mPendingScrollPosition == (-1)) goto L7;
        r10.invalidateAnchorPositionInfo();
        this.mPendingSavedState.invalidateSpanInfo();
    L7:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) goto L5;
        SavedState r5 = new SavedState();
        r5.mReverseLayout = this.mReverseLayout;
        r5.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        r5.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup r10 = this.mLazySpanLookup;
        int r11 = 0;
        if (r10 == null) goto L11;
        int[] r12 = r10.mData;
        if (r12 == null) goto L11;
        r5.mSpanLookup = r12;
        r5.mSpanLookupSize = r12.length;
        r5.mFullSpanItems = r10.mFullSpanItems;
    L13:
        if (getChildCount() > 0) goto L15;
        r5.mAnchorPosition = -1;
        r5.mVisibleAnchorPosition = -1;
        r5.mSpanOffsetsSize = 0;
    L32:
        return r5;
    L15:
        if (this.mLastLayoutFromEnd == false) goto L17;
        int r13 = getLastChildPosition();
    L18:
        r5.mAnchorPosition = r13;
        r5.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
        int r14 = this.mSpanCount;
        r5.mSpanOffsetsSize = r14;
        r5.mSpanOffsets = new int[r14];
    L20:
        if (r11 >= this.mSpanCount) goto L32;
        if (this.mLastLayoutFromEnd == false) goto L27;
        int r15 = this.mSpans[r11].getEndLine(Integer.MIN_VALUE);
        if (r15 == Integer.MIN_VALUE) goto L30;
        int r16 = this.mPrimaryOrientation.getEndAfterPadding();
    L26:
        r15 = r15 - r16;
    L30:
        r5.mSpanOffsets[r11] = r15;
        r11 = r11 + 1;
        goto L20
    L27:
        r15 = this.mSpans[r11].getStartLine(Integer.MIN_VALUE);
        if (r15 == Integer.MIN_VALUE) goto L30;
        r16 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L26
    L17:
        r13 = getFirstChildPosition();
    L11:
        r5.mSpanLookupSize = 0;
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int r5) {
        if (r5 != 0) goto L5;
        checkForGaps();
        return;
    }

    public void prepareLayoutStateForDelta(int r5, RecyclerView.State r10) {
        if (r5 <= 0) goto L5;
        int r11 = getLastChildPosition();
        int r12 = 1;
    L6:
        this.mLayoutState.mRecycle = true;
        updateLayoutState(r11, r10);
        setLayoutStateDirection(r12);
        LayoutState r13 = this.mLayoutState;
        r13.mCurrentPosition = r11 + r13.mItemDirection;
        r13.mAvailable = Math.abs(r5);
        return;
    L5:
        r11 = getFirstChildPosition();
        r12 = -1;
        goto L6
    }

    public int scrollBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (getChildCount() == 0) goto L14;
        if (r5 == 0) goto L14;
        prepareLayoutStateForDelta(r5, r11);
        int r12 = fill(r10, this.mLayoutState, r11);
        if (this.mLayoutState.mAvailable < r12) goto L12;
        if (r5 >= 0) goto L11;
        r5 = -r12;
        goto L12
    L11:
        r5 = r12;
    L12:
        this.mPrimaryOrientation.offsetChildren(-r5);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState r13 = this.mLayoutState;
        r13.mAvailable = 0;
        recycle(r10, r13);
        return r5;
    L14:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        return scrollBy(r5, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r5) {
        SavedState r10 = this.mPendingSavedState;
        if (r10 != null) goto L5;
    L7:
        this.mPendingScrollPosition = r5;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
        return;
    L5:
        if (r10.mAnchorPosition == r5) goto L7;
        r10.invalidateAnchorPositionInfo();
        goto L7
    }

    public void scrollToPositionWithOffset(int r5, int r10) {
        SavedState r11 = this.mPendingSavedState;
        if (r11 == null) goto L5;
        r11.invalidateAnchorPositionInfo();
    L5:
        this.mPendingScrollPosition = r5;
        this.mPendingScrollPositionOffset = r10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        return scrollBy(r5, r10, r11);
    }

    public void setGapStrategy(int r5) {
        assertNotInLayoutOrScroll(null);
        if (r5 != this.mGapStrategy) goto L5;
        return;
    L5:
        if (r5 != 0) goto L7;
    L11:
        this.mGapStrategy = r5;
        requestLayout();
        return;
    L7:
        if (r5 == 2) goto L11;
        throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r5, int r10, int r11) {
        int r12 = getPaddingLeft();
        int r13 = getPaddingRight() + r12;
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom() + r14;
        if (this.mOrientation != 1) goto L5;
        int r16 = RecyclerView.LayoutManager.chooseSize(r11, r5.height() + r15, getMinimumHeight());
        int r17 = RecyclerView.LayoutManager.chooseSize(r10, (this.mSizePerSpan * this.mSpanCount) + r13, getMinimumWidth());
    L6:
        setMeasuredDimension(r17, r16);
        return;
    L5:
        r17 = RecyclerView.LayoutManager.chooseSize(r10, r5.width() + r13, getMinimumWidth());
        r16 = RecyclerView.LayoutManager.chooseSize(r11, (this.mSizePerSpan * this.mSpanCount) + r15, getMinimumHeight());
        goto L6
    }

    public void setOrientation(int r5) {
        if (r5 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r5 != this.mOrientation) goto L11;
        return;
    L11:
        this.mOrientation = r5;
        OrientationHelper r10 = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = r10;
        requestLayout();
        return;
    L4:
        if (r5 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean r5) {
        assertNotInLayoutOrScroll(null);
        SavedState r10 = this.mPendingSavedState;
        if (r10 != null) goto L5;
    L7:
        this.mReverseLayout = r5;
        requestLayout();
        return;
    L5:
        if (r10.mReverseLayout == r5) goto L7;
        r10.mReverseLayout = r5;
        goto L7
    }

    public void setSpanCount(int r5) {
        assertNotInLayoutOrScroll(null);
        if (r5 == this.mSpanCount) goto L11;
        invalidateSpanAssignments();
        this.mSpanCount = r5;
        this.mRemainingSpans = new BitSet(this.mSpanCount);
        this.mSpans = new Span[this.mSpanCount];
        int r10 = 0;
    L6:
        if (r10 >= this.mSpanCount) goto L8;
        this.mSpans[r10] = new Span(this, r10);
        r10 = r10 + 1;
        goto L6
    L8:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r5, RecyclerView.State r10, int r11) {
        LinearSmoothScroller r12 = new LinearSmoothScroller(r5.getContext());
        r12.setTargetPosition(r11);
        startSmoothScroll(r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean updateAnchorFromPendingData(RecyclerView.State r10, AnchorInfo r11) {
        boolean r5 = false;
        if (r10.isPreLayout() == true) goto L60;
        int r12 = this.mPendingScrollPosition;
        if (r12 == (-1)) goto L60;
        if (r12 >= 0) goto L10;
    L59:
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r12 >= r10.getItemCount()) goto L59;
        SavedState r13 = this.mPendingSavedState;
        if (r13 != null) goto L15;
    L20:
        View r14 = findViewByPosition(this.mPendingScrollPosition);
        if (r14 != null) goto L23;
        int r15 = this.mPendingScrollPosition;
        r11.mPosition = r15;
        int r16 = this.mPendingScrollPositionOffset;
        if (r16 == Integer.MIN_VALUE) goto L53;
        r11.assignCoordinateFromPadding(r16);
    L57:
        r11.mInvalidateOffsets = true;
    L58:
        return true;
    L53:
        if (calculateScrollDirectionForPosition(r15) != 1) goto L55;
        r5 = true;
    L55:
        r11.mLayoutFromEnd = r5;
        r11.assignCoordinateFromPadding();
        goto L57
    L23:
        if (this.mShouldReverseLayout == false) goto L25;
        int r17 = getLastChildPosition();
    L26:
        r11.mPosition = r17;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L34;
        if (r11.mLayoutFromEnd == false) goto L31;
        r11.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(r14);
    L32:
        return true;
    L31:
        r11.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(r14);
        goto L32
    L34:
        if (this.mPrimaryOrientation.getDecoratedMeasurement(r14) > this.mPrimaryOrientation.getTotalSpace()) goto L36;
        int r18 = this.mPrimaryOrientation.getDecoratedStart(r14) - this.mPrimaryOrientation.getStartAfterPadding();
        if (r18 >= 0) goto L45;
        r11.mOffset = -r18;
        return true;
    L45:
        int r19 = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(r14);
        if (r19 >= 0) goto L49;
        r11.mOffset = r19;
        return true;
    L49:
        r11.mOffset = Integer.MIN_VALUE;
        goto L58
    L36:
        if (r11.mLayoutFromEnd == false) goto L38;
        int r20 = this.mPrimaryOrientation.getEndAfterPadding();
    L39:
        r11.mOffset = r20;
        return true;
    L38:
        r20 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L39
    L25:
        r17 = getFirstChildPosition();
        goto L26
    L15:
        if (r13.mAnchorPosition == (-1)) goto L20;
        if (r13.mSpanOffsetsSize < 1) goto L20;
        r11.mOffset = Integer.MIN_VALUE;
        r11.mPosition = this.mPendingScrollPosition;
    L60:
        return false;
    }

    public void updateAnchorInfoForLayout(RecyclerView.State r5, AnchorInfo r10) {
        if (updateAnchorFromPendingData(r5, r10) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildren(r5, r10) == false) goto L8;
        return;
    L8:
        r10.assignCoordinateFromPadding();
        r10.mPosition = 0;
    }

    public void updateMeasureSpecs(int r5) {
        this.mSizePerSpan = r5 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(r5, this.mSecondaryOrientation.getMode());
    }

    private void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        AnchorInfo r5 = this.mAnchorInfo;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        boolean r13 = true;
        if (r5.mValid == true) goto L13;
    L18:
        boolean r14 = true;
    L19:
        if (r14 == false) goto L26;
        r5.reset();
        if (this.mPendingSavedState == null) goto L23;
        applyPendingSavedState(r5);
    L24:
        updateAnchorInfoForLayout(r11, r5);
        r5.mValid = true;
        goto L26
    L23:
        resolveShouldLayoutReverse();
        r5.mLayoutFromEnd = this.mShouldReverseLayout;
    L26:
        if (this.mPendingSavedState != null) goto L35;
        if (this.mPendingScrollPosition != (-1)) goto L35;
        if (r5.mLayoutFromEnd == this.mLastLayoutFromEnd) goto L32;
    L33:
        this.mLazySpanLookup.clear();
        r5.mInvalidateOffsets = true;
        goto L35
    L32:
        if (isLayoutRTL() != this.mLastLayoutRTL) goto L33;
    L35:
        if (getChildCount() <= 0) goto L62;
        SavedState r15 = this.mPendingSavedState;
        if (r15 == null) goto L41;
        if (r15.mSpanOffsetsSize >= 1) goto L62;
    L41:
        if (r5.mInvalidateOffsets == false) goto L49;
        int r16 = 0;
    L44:
        if (r16 >= this.mSpanCount) goto L62;
        this.mSpans[r16].clear();
        int r17 = r5.mOffset;
        if (r17 == Integer.MIN_VALUE) goto L48;
        this.mSpans[r16].setLine(r17);
    L48:
        r16 = r16 + 1;
        goto L44
    L49:
        if (r14 == false) goto L51;
    L57:
        int r18 = 0;
    L59:
        if (r18 >= this.mSpanCount) goto L61;
        this.mSpans[r18].cacheReferenceLineAndClear(this.mShouldReverseLayout, r5.mOffset);
        r18 = r18 + 1;
        goto L59
    L61:
        this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
        goto L62
    L51:
        if (this.mAnchorInfo.mSpanReferenceLines == null) goto L57;
        int r19 = 0;
    L55:
        if (r19 >= this.mSpanCount) goto L62;
        Span r20 = this.mSpans[r19];
        r20.clear();
        r20.setLine(this.mAnchorInfo.mSpanReferenceLines[r19]);
        r19 = r19 + 1;
    L62:
        detachAndScrapAttachedViews(r10);
        this.mLayoutState.mRecycle = false;
        this.mLaidOutInvalidFullSpan = false;
        updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
        updateLayoutState(r5.mPosition, r11);
        if (r5.mLayoutFromEnd == false) goto L65;
        setLayoutStateDirection(-1);
        fill(r10, this.mLayoutState, r11);
        setLayoutStateDirection(1);
        LayoutState r21 = this.mLayoutState;
        r21.mCurrentPosition = r5.mPosition + r21.mItemDirection;
        fill(r10, r21, r11);
    L66:
        repositionToWrapContentIfNecessary();
        if (getChildCount() > 0) goto L69;
    L72:
        if (r12 == true) goto L74;
    L86:
        r13 = false;
    L88:
        if (r11.isPreLayout() == false) goto L90;
        this.mAnchorInfo.reset();
    L90:
        this.mLastLayoutFromEnd = r5.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        if (r13 == false) goto L99;
        this.mAnchorInfo.reset();
        onLayoutChildren(r10, r11, false);
        return;
    L99:
        return;
    L74:
        if (r11.isPreLayout() == true) goto L86;
        if (this.mGapStrategy == 0) goto L86;
        if (getChildCount() <= 0) goto L86;
        if (this.mLaidOutInvalidFullSpan == false) goto L82;
    L83:
        removeCallbacks(this.mCheckForGapsRunnable);
        if (checkForGaps() == false) goto L86;
    L82:
        if (hasGapsToFix() == null) goto L86;
    L69:
        if (this.mShouldReverseLayout == false) goto L71;
        fixEndGap(r10, r11, true);
        fixStartGap(r10, r11, false);
        goto L72
    L71:
        fixStartGap(r10, r11, true);
        fixEndGap(r10, r11, false);
        goto L72
    L65:
        setLayoutStateDirection(1);
        fill(r10, this.mLayoutState, r11);
        setLayoutStateDirection(-1);
        LayoutState r22 = this.mLayoutState;
        r22.mCurrentPosition = r5.mPosition + r22.mItemDirection;
        fill(r10, r22, r11);
        goto L66
    L13:
        if (this.mPendingScrollPosition != (-1)) goto L18;
        if (this.mPendingSavedState != null) goto L18;
        r14 = false;
    L7:
        if (r11.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r10);
        r5.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
    L7:
        return new LayoutParams(r5);
    }

    public StaggeredGridLayoutManager(int r5, int r10) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new AnonymousClass1(this);
        this.mOrientation = r10;
        setSpanCount(r5);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void measureChildWithDecorationsAndMargin(View r5, int r10, int r11, boolean r12) {
        calculateItemDecorationsForChild(r5, this.mTmpRect);
        LayoutParams r13 = (LayoutParams) r5.getLayoutParams();
        int r14 = ((ViewGroup.MarginLayoutParams) r13).leftMargin;
        Rect r15 = this.mTmpRect;
        int r16 = updateSpecWithExtra(r10, r14 + r15.left, ((ViewGroup.MarginLayoutParams) r13).rightMargin + r15.right);
        int r17 = ((ViewGroup.MarginLayoutParams) r13).topMargin;
        Rect r18 = this.mTmpRect;
        int r19 = updateSpecWithExtra(r11, r17 + r18.top, ((ViewGroup.MarginLayoutParams) r13).bottomMargin + r18.bottom);
        if (r12 == false) goto L5;
        boolean r20 = shouldReMeasureChild(r5, r16, r19, r13);
    L6:
        if (r20 == false) goto L9;
        r5.measure(r16, r19);
        return;
    L9:
        return;
    L5:
        r20 = shouldMeasureChild(r5, r16, r19, r13);
        goto L6
    }
}

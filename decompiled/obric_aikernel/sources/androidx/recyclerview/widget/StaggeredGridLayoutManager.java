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
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
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

    class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;
        final /* synthetic */ StaggeredGridLayoutManager this$0;

        AnchorInfo(StaggeredGridLayoutManager r10) {
            this.this$0 = r10;
            reset();
        }

        void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r10 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
        L6:
            this.mOffset = r10;
            return;
        L5:
            r10 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
            goto L6
        }

        void assignCoordinateFromPadding(int r10) {
            if (this.mLayoutFromEnd == false) goto L5;
            int r11 = this.this$0.mPrimaryOrientation.getEndAfterPadding() - r10;
        L6:
            this.mOffset = r11;
            return;
        L5:
            r11 = this.this$0.mPrimaryOrientation.getStartAfterPadding() + r10;
            goto L6
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] r10 = this.mSpanReferenceLines;
            if (r10 == null) goto L6;
            Arrays.fill(r10, -1);
            return;
        }

        void saveSpanReferenceLines(Span[] r10) {
            int r11 = r10.length;
            int[] r12 = this.mSpanReferenceLines;
            if (r12 != null) goto L5;
        L6:
            this.mSpanReferenceLines = new int[this.this$0.mSpans.length];
        L7:
            int r13 = 0;
        L8:
            if (r13 >= r11) goto L10;
            this.mSpanReferenceLines[r13] = r10[r13].getStartLine(Integer.MIN_VALUE);
            r13 = r13 + 1;
            goto L8
        L10:
            return;
        L5:
            if (r12.length >= r11) goto L7;
            goto L6
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
        }

        public LayoutParams(RecyclerView.LayoutParams r10) {
            super(r10);
        }

        public final int getSpanIndex() {
            Span r10 = this.mSpan;
            if (r10 != null) goto L7;
            return -1;
        L7:
            return r10.mIndex;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean r10) {
            this.mFullSpan = r10;
        }
    }

    static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = null;
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            static {
                CREATOR = new AnonymousClass1();
            }

            FullSpanItem() {
            }

            FullSpanItem(Parcel r10) {
                this.mPosition = r10.readInt();
                this.mGapDir = r10.readInt();
                boolean r11 = true;
                if (r10.readInt() == 1) goto L6;
                r11 = false;
            L6:
                this.mHasUnwantedGapAfter = r11;
                int r12 = r10.readInt();
                if (r12 <= 0) goto L10;
                int[] r13 = new int[r12];
                this.mGapPerSpan = r13;
                r10.readIntArray(r13);
                return;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            int getGapForSpan(int r10) {
                int[] r11 = this.mGapPerSpan;
                if (r11 != null) goto L6;
                return 0;
            L6:
                return r11[r10];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r10, int r11) {
                r10.writeInt(this.mPosition);
                r10.writeInt(this.mGapDir);
                r10.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] r12 = this.mGapPerSpan;
                if (r12 != null) goto L5;
            L7:
                r10.writeInt(0);
                return;
            L5:
                if (r12.length <= 0) goto L7;
                r10.writeInt(r12.length);
                r10.writeIntArray(this.mGapPerSpan);
            }
        }

        LazySpanLookup() {
        }

        private int invalidateFullSpansAfter(int r10) {
            if (this.mFullSpanItems != null) goto L5;
            return -1;
        L5:
            FullSpanItem r11 = getFullSpanItem(r10);
            if (r11 == null) goto L8;
            this.mFullSpanItems.remove(r11);
        L8:
            int r12 = this.mFullSpanItems.size();
            int r13 = 0;
        L9:
            if (r13 >= r12) goto L14;
            if (this.mFullSpanItems.get(r13).mPosition >= r10) goto L15;
            r13 = r13 + 1;
        L15:
            if (r13 == (-1)) goto L18;
            FullSpanItem r14 = this.mFullSpanItems.get(r13);
            this.mFullSpanItems.remove(r13);
            return r14.mPosition;
        L18:
            return -1;
        L14:
            r13 = -1;
            goto L15
        }

        private void offsetFullSpansForAddition(int r10, int r11) {
            List<FullSpanItem> r12 = this.mFullSpanItems;
            if (r12 != null) goto L5;
            return;
        L5:
            int r13 = r12.size() - 1;
        L6:
            if (r13 < 0) goto L12;
            FullSpanItem r14 = this.mFullSpanItems.get(r13);
            int r15 = r14.mPosition;
            if (r15 < r10) goto L11;
            r14.mPosition = r15 + r11;
        L11:
            r13 = r13 - 1;
            goto L6
        }

        private void offsetFullSpansForRemoval(int r10, int r11) {
            List<FullSpanItem> r12 = this.mFullSpanItems;
            if (r12 != null) goto L5;
            return;
        L5:
            int r13 = r10 + r11;
            int r14 = r12.size() - 1;
        L6:
            if (r14 < 0) goto L14;
            FullSpanItem r15 = this.mFullSpanItems.get(r14);
            int r16 = r15.mPosition;
            if (r16 < r10) goto L13;
            if (r16 >= r13) goto L12;
            this.mFullSpanItems.remove(r14);
            goto L13
        L12:
            r15.mPosition = r16 - r11;
        L13:
            r14 = r14 - 1;
            goto L6
        }

        public void addFullSpanItem(FullSpanItem r10) {
            if (this.mFullSpanItems != null) goto L5;
            this.mFullSpanItems = new ArrayList();
        L5:
            int r11 = this.mFullSpanItems.size();
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L15;
            FullSpanItem r13 = this.mFullSpanItems.get(r12);
            if (r13.mPosition != r10.mPosition) goto L11;
            this.mFullSpanItems.remove(r12);
        L11:
            if (r13.mPosition >= r10.mPosition) goto L12;
            r12 = r12 + 1;
            goto L6
        L12:
            this.mFullSpanItems.add(r12, r10);
            return;
        L15:
            this.mFullSpanItems.add(r10);
        }

        void clear() {
            int[] r10 = this.mData;
            if (r10 == null) goto L5;
            Arrays.fill(r10, -1);
        L5:
            this.mFullSpanItems = null;
        }

        void ensureSize(int r10) {
            int[] r11 = this.mData;
            if (r11 != null) goto L6;
            int[] r12 = new int[Math.max(r10, 10) + 1];
            this.mData = r12;
            Arrays.fill(r12, -1);
            return;
        L6:
            if (r10 < r11.length) goto L10;
            int[] r13 = new int[sizeForPosition(r10)];
            this.mData = r13;
            System.arraycopy(r11, 0, r13, 0, r11.length);
            int[] r14 = this.mData;
            Arrays.fill(r14, r11.length, r14.length, -1);
            return;
        }

        int forceInvalidateAfter(int r10) {
            List<FullSpanItem> r11 = this.mFullSpanItems;
            if (r11 == null) goto L11;
            int r12 = r11.size() - 1;
        L5:
            if (r12 < 0) goto L11;
            if (this.mFullSpanItems.get(r12).mPosition < r10) goto L9;
            this.mFullSpanItems.remove(r12);
        L9:
            r12 = r12 - 1;
        L11:
            return invalidateAfter(r10);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int r10, int r11, int r12, boolean r13) {
            List<FullSpanItem> r14 = this.mFullSpanItems;
            if (r14 != null) goto L5;
            return null;
        L5:
            int r15 = r14.size();
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L19;
            FullSpanItem r17 = this.mFullSpanItems.get(r16);
            int r18 = r17.mPosition;
            if (r18 >= r11) goto L9;
            if (r18 < r10) goto L18;
            if (r12 == 0) goto L17;
            if (r17.mGapDir == r12) goto L17;
            if (r13 == false) goto L18;
            if (r17.mHasUnwantedGapAfter == false) goto L18;
        L17:
            return r17;
        L18:
            r16 = r16 + 1;
            goto L6
        L9:
            return null;
        L19:
            return null;
        }

        public FullSpanItem getFullSpanItem(int r10) {
            List<FullSpanItem> r11 = this.mFullSpanItems;
            if (r11 != null) goto L5;
            return null;
        L5:
            int r12 = r11.size() - 1;
        L6:
            if (r12 < 0) goto L11;
            FullSpanItem r13 = this.mFullSpanItems.get(r12);
            if (r13.mPosition == r10) goto L9;
            r12 = r12 - 1;
            goto L6
        L9:
            return r13;
        L11:
            return null;
        }

        int getSpan(int r10) {
            int[] r11 = this.mData;
            if (r11 != null) goto L5;
            return -1;
        L5:
            if (r10 < r11.length) goto L8;
            return -1;
        L8:
            return r11[r10];
        }

        int invalidateAfter(int r10) {
            int[] r11 = this.mData;
            if (r11 != null) goto L6;
            return -1;
        L6:
            if (r10 < r11.length) goto L8;
            return -1;
        L8:
            int r12 = invalidateFullSpansAfter(r10);
            if (r12 != (-1)) goto L12;
            int[] r13 = this.mData;
            Arrays.fill(r13, r10, r13.length, -1);
            return this.mData.length;
        L12:
            int r14 = r12 + 1;
            Arrays.fill(this.mData, r10, r14, -1);
            return r14;
        }

        void offsetForAddition(int r10, int r11) {
            int[] r12 = this.mData;
            if (r12 != null) goto L5;
            return;
        L5:
            if (r10 >= r12.length) goto L10;
            int r13 = r10 + r11;
            ensureSize(r13);
            int[] r14 = this.mData;
            System.arraycopy(r14, r10, r14, r13, (r14.length - r10) - r11);
            Arrays.fill(this.mData, r10, r13, -1);
            offsetFullSpansForAddition(r10, r11);
            return;
        }

        void offsetForRemoval(int r10, int r11) {
            int[] r12 = this.mData;
            if (r12 != null) goto L5;
            return;
        L5:
            if (r10 >= r12.length) goto L10;
            int r13 = r10 + r11;
            ensureSize(r13);
            int[] r14 = this.mData;
            System.arraycopy(r14, r13, r14, r10, (r14.length - r10) - r11);
            int[] r15 = this.mData;
            Arrays.fill(r15, r15.length - r11, r15.length, -1);
            offsetFullSpansForRemoval(r10, r11);
            return;
        }

        void setSpan(int r10, Span r11) {
            ensureSize(r10);
            this.mData[r10] = r11.mIndex;
        }

        int sizeForPosition(int r10) {
            int r11 = this.mData.length;
        L3:
            if (r11 > r10) goto L5;
            r11 = r11 * 2;
            goto L3
        L5:
            return r11;
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

        SavedState(Parcel r10) {
            this.mAnchorPosition = r10.readInt();
            this.mVisibleAnchorPosition = r10.readInt();
            int r11 = r10.readInt();
            this.mSpanOffsetsSize = r11;
            if (r11 <= 0) goto L5;
            int[] r12 = new int[r11];
            this.mSpanOffsets = r12;
            r10.readIntArray(r12);
        L5:
            int r13 = r10.readInt();
            this.mSpanLookupSize = r13;
            if (r13 <= 0) goto L8;
            int[] r14 = new int[r13];
            this.mSpanLookup = r14;
            r10.readIntArray(r14);
        L8:
            boolean r15 = false;
            if (r10.readInt() != 1) goto L11;
            boolean r16 = true;
        L12:
            this.mReverseLayout = r16;
            if (r10.readInt() != 1) goto L15;
            boolean r17 = true;
        L16:
            this.mAnchorLayoutFromEnd = r17;
            if (r10.readInt() != 1) goto L19;
            r15 = true;
        L19:
            this.mLastLayoutRTL = r15;
            this.mFullSpanItems = r10.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
            return;
        L15:
            r17 = false;
            goto L16
        L11:
            r16 = false;
            goto L12
        }

        public SavedState(SavedState r10) {
            this.mSpanOffsetsSize = r10.mSpanOffsetsSize;
            this.mAnchorPosition = r10.mAnchorPosition;
            this.mVisibleAnchorPosition = r10.mVisibleAnchorPosition;
            this.mSpanOffsets = r10.mSpanOffsets;
            this.mSpanLookupSize = r10.mSpanLookupSize;
            this.mSpanLookup = r10.mSpanLookup;
            this.mReverseLayout = r10.mReverseLayout;
            this.mAnchorLayoutFromEnd = r10.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = r10.mLastLayoutRTL;
            this.mFullSpanItems = r10.mFullSpanItems;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.mAnchorPosition);
            r10.writeInt(this.mVisibleAnchorPosition);
            r10.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize <= 0) goto L5;
            r10.writeIntArray(this.mSpanOffsets);
        L5:
            r10.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize <= 0) goto L8;
            r10.writeIntArray(this.mSpanLookup);
        L8:
            r10.writeInt(this.mReverseLayout ? 1 : 0);
            r10.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            r10.writeInt(this.mLastLayoutRTL ? 1 : 0);
            r10.writeList(this.mFullSpanItems);
        }
    }

    class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        ArrayList<View> mViews;
        final /* synthetic */ StaggeredGridLayoutManager this$0;

        Span(StaggeredGridLayoutManager r10, int r11) {
            this.this$0 = r10;
            this.mViews = new ArrayList();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mIndex = r11;
        }

        void appendToSpan(View r10) {
            LayoutParams r11 = getLayoutParams(r10);
            r11.mSpan = this;
            this.mViews.add(r10);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedStart = Integer.MIN_VALUE;
        L6:
            if (r11.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r10);
            return;
        L8:
            if (r11.isItemChanged() == true) goto L9;
        }

        void cacheReferenceLineAndClear(boolean r10, int r11) {
            if (r10 == false) goto L5;
            int r12 = getEndLine(Integer.MIN_VALUE);
        L6:
            clear();
            if (r12 != Integer.MIN_VALUE) goto L9;
            return;
        L9:
            if (r10 == true) goto L11;
        L12:
            if (r10 == false) goto L14;
        L16:
            if (r11 == Integer.MIN_VALUE) goto L18;
            r12 = r12 + r11;
        L18:
            this.mCachedEnd = r12;
            this.mCachedStart = r12;
            return;
        L14:
            if (r12 <= this.this$0.mPrimaryOrientation.getStartAfterPadding()) goto L16;
            return;
        L11:
            if (r12 >= this.this$0.mPrimaryOrientation.getEndAfterPadding()) goto L12;
            return;
        L5:
            r12 = getStartLine(Integer.MIN_VALUE);
            goto L6
        }

        void calculateCachedEnd() {
            ArrayList<View> r10 = this.mViews;
            View r11 = r10.get(r10.size() - 1);
            LayoutParams r12 = getLayoutParams(r11);
            this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(r11);
            if (r12.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r13 = this.this$0.mLazySpanLookup.getFullSpanItem(r12.getViewLayoutPosition());
            if (r13 != null) goto L7;
            return;
        L7:
            if (r13.mGapDir != 1) goto L12;
            this.mCachedEnd += r13.getGapForSpan(this.mIndex);
            return;
        L12:
            return;
        }

        void calculateCachedStart() {
            View r10 = this.mViews.get(0);
            LayoutParams r11 = getLayoutParams(r10);
            this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(r10);
            if (r11.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r12 = this.this$0.mLazySpanLookup.getFullSpanItem(r11.getViewLayoutPosition());
            if (r12 != null) goto L7;
            return;
        L7:
            if (r12.mGapDir != (-1)) goto L12;
            this.mCachedStart -= r12.getGapForSpan(this.mIndex);
            return;
        L12:
            return;
        }

        void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L5;
            int r10 = this.mViews.size() - 1;
            int r11 = -1;
        L7:
            return findOneVisibleChild(r10, r11, true);
        L5:
            r10 = 0;
            r11 = this.mViews.size();
            goto L7
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L5;
            int r10 = this.mViews.size() - 1;
            int r11 = -1;
        L7:
            return findOnePartiallyVisibleChild(r10, r11, true);
        L5:
            r10 = 0;
            r11 = this.mViews.size();
            goto L7
        }

        public int findFirstVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        L6:
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L5;
            int r10 = 0;
            int r11 = this.mViews.size();
        L7:
            return findOneVisibleChild(r10, r11, true);
        L5:
            r10 = this.mViews.size() - 1;
            r11 = -1;
            goto L7
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L5;
            int r10 = 0;
            int r11 = this.mViews.size();
        L7:
            return findOnePartiallyVisibleChild(r10, r11, true);
        L5:
            r10 = this.mViews.size() - 1;
            r11 = -1;
            goto L7
        }

        public int findLastVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(0, this.mViews.size(), false);
        L6:
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        int findOnePartiallyOrCompletelyVisibleChild(int r11, int r12, boolean r13, boolean r14, boolean r15) {
            int r10 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
            int r16 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
            if (r12 <= r11) goto L5;
            int r17 = 1;
        L6:
            if (r11 == r12) goto L33;
            View r18 = this.mViews.get(r11);
            int r19 = this.this$0.mPrimaryOrientation.getDecoratedStart(r18);
            int r20 = this.this$0.mPrimaryOrientation.getDecoratedEnd(r18);
            boolean r21 = false;
            if (r15 == false) goto L11;
            if (r19 <= r16) goto L12;
        L13:
            boolean r22 = false;
        L14:
            if (r15 == false) goto L17;
            if (r20 >= r10) goto L18;
        L19:
            if (r22 == false) goto L32;
            if (r21 == false) goto L32;
            if (r13 == false) goto L27;
            if (r14 == false) goto L27;
            if (r19 < r10) goto L32;
            if (r20 > r16) goto L32;
        L26:
            return this.this$0.getPosition(r18);
        L27:
            if (r14 == true) goto L26;
            if (r19 < r10) goto L26;
            if (r20 > r16) goto L26;
        L32:
            r11 = r11 + r17;
        L18:
            r21 = true;
            goto L19
        L17:
            if (r20 <= r10) goto L19;
        L12:
            r22 = true;
            goto L14
        L11:
            if (r19 >= r16) goto L13;
        L33:
            return -1;
        L5:
            r17 = -1;
            goto L6
        }

        int findOnePartiallyVisibleChild(int r10, int r11, boolean r12) {
            return findOnePartiallyOrCompletelyVisibleChild(r10, r11, false, false, r12);
        }

        int findOneVisibleChild(int r10, int r11, boolean r12) {
            return findOnePartiallyOrCompletelyVisibleChild(r10, r11, r12, true, false);
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        int getEndLine() {
            int r10 = this.mCachedEnd;
            if (r10 == Integer.MIN_VALUE) goto L5;
            return r10;
        L5:
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        int getEndLine(int r10) {
            int r11 = this.mCachedEnd;
            if (r11 == Integer.MIN_VALUE) goto L6;
            return r11;
        L6:
            if (this.mViews.size() != 0) goto L8;
            return r10;
        L8:
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public View getFocusableViewAfter(int r10, int r11) {
            View r12 = null;
            if (r11 != (-1)) goto L18;
            int r13 = this.mViews.size();
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L32;
            View r15 = this.mViews.get(r14);
            StaggeredGridLayoutManager r16 = this.this$0;
            if (r16.mReverseLayout == true) goto L9;
        L10:
            StaggeredGridLayoutManager r17 = this.this$0;
            if (r17.mReverseLayout == true) goto L16;
            if (r17.getPosition(r15) >= r10) goto L32;
        L16:
            if (r15.hasFocusable() == false) goto L32;
            r14 = r14 + 1;
            r12 = r15;
            goto L5
        L9:
            if (r16.getPosition(r15) > r10) goto L10;
        L32:
            return r12;
        L18:
            int r18 = this.mViews.size() - 1;
        L19:
            if (r18 < 0) goto L32;
            View r19 = this.mViews.get(r18);
            StaggeredGridLayoutManager r20 = this.this$0;
            if (r20.mReverseLayout == true) goto L23;
        L24:
            StaggeredGridLayoutManager r21 = this.this$0;
            if (r21.mReverseLayout == true) goto L30;
            if (r21.getPosition(r19) <= r10) goto L32;
        L30:
            if (r19.hasFocusable() == false) goto L32;
            r18 = r18 - 1;
            r12 = r19;
            goto L19
        L23:
            if (r20.getPosition(r19) >= r10) goto L32;
            goto L24
        }

        LayoutParams getLayoutParams(View r10) {
            return (LayoutParams) r10.getLayoutParams();
        }

        int getStartLine() {
            int r10 = this.mCachedStart;
            if (r10 == Integer.MIN_VALUE) goto L5;
            return r10;
        L5:
            calculateCachedStart();
            return this.mCachedStart;
        }

        int getStartLine(int r10) {
            int r11 = this.mCachedStart;
            if (r11 == Integer.MIN_VALUE) goto L6;
            return r11;
        L6:
            if (this.mViews.size() != 0) goto L8;
            return r10;
        L8:
            calculateCachedStart();
            return this.mCachedStart;
        }

        void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        void onOffset(int r10) {
            int r11 = this.mCachedStart;
            if (r11 == Integer.MIN_VALUE) goto L5;
            this.mCachedStart = r11 + r10;
        L5:
            int r12 = this.mCachedEnd;
            if (r12 == Integer.MIN_VALUE) goto L9;
            this.mCachedEnd = r12 + r10;
            return;
        }

        void popEnd() {
            int r10 = this.mViews.size();
            View r11 = this.mViews.remove(r10 - 1);
            LayoutParams r12 = getLayoutParams(r11);
            r12.mSpan = null;
            if (r12.isItemRemoved() == false) goto L5;
        L6:
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r11);
        L8:
            if (r10 != 1) goto L10;
            this.mCachedStart = Integer.MIN_VALUE;
        L10:
            this.mCachedEnd = Integer.MIN_VALUE;
            return;
        L5:
            if (r12.isItemChanged() == false) goto L8;
            goto L6
        }

        void popStart() {
            View r10 = this.mViews.remove(0);
            LayoutParams r11 = getLayoutParams(r10);
            r11.mSpan = null;
            if (this.mViews.size() != 0) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r11.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r10);
        L10:
            this.mCachedStart = Integer.MIN_VALUE;
            return;
        L8:
            if (r11.isItemChanged() == false) goto L10;
            goto L9
        }

        void prependToSpan(View r10) {
            LayoutParams r11 = getLayoutParams(r10);
            r11.mSpan = this;
            this.mViews.add(0, r10);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r11.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r10);
            return;
        L8:
            if (r11.isItemChanged() == true) goto L9;
        }

        void setLine(int r10) {
            this.mCachedStart = r10;
            this.mCachedEnd = r10;
        }
    }

    public StaggeredGridLayoutManager(int r10, int r11) {
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
        this.mOrientation = r11;
        setSpanCount(r10);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    public StaggeredGridLayoutManager(Context r10, AttributeSet r11, int r12, int r13) {
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
        RecyclerView.LayoutManager.Properties r14 = RecyclerView.LayoutManager.getProperties(r10, r11, r12, r13);
        setOrientation(r14.orientation);
        setSpanCount(r14.spanCount);
        setReverseLayout(r14.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View r10) {
        int r11 = this.mSpanCount - 1;
    L3:
        if (r11 < 0) goto L5;
        this.mSpans[r11].appendToSpan(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void applyPendingSavedState(AnchorInfo r10) {
        SavedState r11 = this.mPendingSavedState;
        int r12 = r11.mSpanOffsetsSize;
        if (r12 > 0) goto L5;
    L18:
        SavedState r13 = this.mPendingSavedState;
        this.mLastLayoutRTL = r13.mLastLayoutRTL;
        setReverseLayout(r13.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState r14 = this.mPendingSavedState;
        int r15 = r14.mAnchorPosition;
        if (r15 == (-1)) goto L21;
        this.mPendingScrollPosition = r15;
        boolean r16 = r14.mAnchorLayoutFromEnd;
    L22:
        r10.mLayoutFromEnd = r16;
        if (r14.mSpanLookupSize <= 1) goto L29;
        LazySpanLookup r17 = this.mLazySpanLookup;
        r17.mData = r14.mSpanLookup;
        r17.mFullSpanItems = r14.mFullSpanItems;
        return;
    L29:
        return;
    L21:
        r16 = this.mShouldReverseLayout;
        goto L22
    L5:
        if (r12 != this.mSpanCount) goto L17;
        int r18 = 0;
    L8:
        if (r18 >= this.mSpanCount) goto L18;
        this.mSpans[r18].clear();
        SavedState r19 = this.mPendingSavedState;
        int r20 = r19.mSpanOffsets[r18];
        if (r20 == Integer.MIN_VALUE) goto L16;
        if (r19.mAnchorLayoutFromEnd == false) goto L14;
        int r21 = this.mPrimaryOrientation.getEndAfterPadding();
    L15:
        r20 = r20 + r21;
        goto L16
    L14:
        r21 = this.mPrimaryOrientation.getStartAfterPadding();
    L16:
        this.mSpans[r18].setLine(r20);
        r18 = r18 + 1;
        goto L8
    L17:
        r11.invalidateSpanInfo();
        SavedState r22 = this.mPendingSavedState;
        r22.mAnchorPosition = r22.mVisibleAnchorPosition;
        goto L18
    }

    private void attachViewToSpans(View r10, LayoutParams r11, LayoutState r12) {
        if (r12.mLayoutDirection != 1) goto L9;
        if (r11.mFullSpan == false) goto L7;
        appendViewToAllSpans(r10);
        return;
    L7:
        r11.mSpan.appendToSpan(r10);
        return;
    L9:
        if (r11.mFullSpan == false) goto L11;
        prependViewToAllSpans(r10);
        return;
    L11:
        r11.mSpan.prependToSpan(r10);
    }

    private int calculateScrollDirectionForPosition(int r10) {
        if (getChildCount() != 0) goto L9;
        if (this.mShouldReverseLayout == true) goto L7;
        return -1;
    L7:
        return 1;
    L9:
        if (r10 >= getFirstChildPosition()) goto L11;
        boolean r11 = true;
    L13:
        if (r11 == this.mShouldReverseLayout) goto L16;
        return -1;
    L16:
        return 1;
    L11:
        r11 = false;
        goto L13
    }

    private boolean checkSpanForGap(Span r10) {
        if (this.mShouldReverseLayout == false) goto L9;
        if (r10.getEndLine() >= this.mPrimaryOrientation.getEndAfterPadding()) goto L12;
        ArrayList<View> r11 = r10.mViews;
        return !r10.getLayoutParams(r11.get(r11.size() - 1)).mFullSpan;
    L12:
        return false;
    L9:
        if (r10.getStartLine() <= this.mPrimaryOrientation.getStartAfterPadding()) goto L12;
        return !r10.getLayoutParams(r10.mViews.get(0)).mFullSpan;
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

    private int convertFocusDirectionToLayoutDirection(int r10) {
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int r10) {
        LazySpanLookup.FullSpanItem r11 = new LazySpanLookup.FullSpanItem();
        r11.mGapPerSpan = new int[this.mSpanCount];
        int r12 = 0;
    L4:
        if (r12 >= this.mSpanCount) goto L6;
        r11.mGapPerSpan[r12] = r10 - this.mSpans[r12].getEndLine(r10);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int r10) {
        LazySpanLookup.FullSpanItem r11 = new LazySpanLookup.FullSpanItem();
        r11.mGapPerSpan = new int[this.mSpanCount];
        int r12 = 0;
    L4:
        if (r12 >= this.mSpanCount) goto L6;
        r11.mGapPerSpan[r12] = this.mSpans[r12].getStartLine(r10) - r10;
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.RecyclerView$LayoutManager, androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int fill(RecyclerView.Recycler r17, LayoutState r18, RecyclerView.State r19) {
        ?? r10 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite == false) goto L9;
        if (r18.mLayoutDirection != 1) goto L7;
        int r11 = Integer.MAX_VALUE;
    L12:
        int r12 = r11;
        updateAllRemainingSpans(r18.mLayoutDirection, r12);
        if (this.mShouldReverseLayout == false) goto L15;
        int r13 = this.mPrimaryOrientation.getEndAfterPadding();
    L16:
        int r14 = r13;
        ?? r15 = false;
    L18:
        if (r18.hasMore(r19) == false) goto L107;
        if (this.mLayoutState.mInfinite == false) goto L22;
    L23:
        View r16 = r18.next(r17);
        LayoutParams r110 = (LayoutParams) r16.getLayoutParams();
        int r20 = r110.getViewLayoutPosition();
        int r21 = this.mLazySpanLookup.getSpan(r20);
        if (r21 != (-1)) goto L26;
        ?? r22 = 1;
    L27:
        if (r22 != 0) goto L29;
        Span r23 = this.mSpans[r21];
    L34:
        Span r111 = r23;
        r110.mSpan = r111;
        if (r18.mLayoutDirection != 1) goto L37;
        addView(r16);
    L38:
        measureChildWithDecorationsAndMargin(r16, r110, r10);
        if (r18.mLayoutDirection != 1) goto L51;
        if (r110.mFullSpan == false) goto L43;
        int r24 = getMaxEnd(r14);
    L44:
        int r25 = this.mPrimaryOrientation.getDecoratedMeasurement(r16) + r24;
        if (r22 != 0) goto L47;
    L49:
        int r26 = r25;
        int r27 = r24;
    L61:
        if (r110.mFullSpan == true) goto L63;
    L75:
        attachViewToSpans(r16, r110, r18);
        if (isLayoutRTL() == false) goto L85;
        if (this.mOrientation != 1) goto L85;
        if (r110.mFullSpan == false) goto L82;
        int r28 = this.mSecondaryOrientation.getEndAfterPadding();
    L83:
        int r29 = r28;
        int r30 = r28 - this.mSecondaryOrientation.getDecoratedMeasurement(r16);
    L90:
        if (this.mOrientation != 1) goto L92;
        int r31 = r30;
        r30 = r27;
        int r32 = r29;
    L93:
        layoutDecoratedWithMargins(r16, r31, r30, r32, r26);
        if (r110.mFullSpan == false) goto L96;
        updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, r12);
    L97:
        recycle(r17, this.mLayoutState);
        if (this.mLayoutState.mStopInFocusable == true) goto L100;
    L105:
        boolean r33 = false;
    L106:
        r10 = r33;
        r15 = true;
        goto L18
    L100:
        if (r16.hasFocusable() == false) goto L105;
        if (r110.mFullSpan == false) goto L104;
        this.mRemainingSpans.clear();
        goto L105
    L104:
        r33 = false;
        this.mRemainingSpans.set(r111.mIndex, false);
        goto L106
    L96:
        updateRemainingSpans(r111, this.mLayoutState.mLayoutDirection, r12);
        goto L97
    L92:
        r31 = r27;
        r32 = r26;
        r26 = r29;
        goto L93
    L82:
        r28 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - r111.mIndex) * this.mSizePerSpan);
    L85:
        if (r110.mFullSpan == false) goto L87;
        int r34 = this.mSecondaryOrientation.getStartAfterPadding();
    L88:
        r30 = r34;
        r29 = this.mSecondaryOrientation.getDecoratedMeasurement(r16) + r34;
        goto L90
    L87:
        r34 = (r111.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
        goto L88
    L63:
        if (r18.mItemDirection != (-1)) goto L75;
        if (r22 == 0) goto L67;
    L65:
        this.mLaidOutInvalidFullSpan = true;
        goto L75
    L67:
        if (r18.mLayoutDirection != 1) goto L69;
        boolean r35 = areAllEndsEqual();
    L71:
        if ((!r35) == false) goto L75;
        LazySpanLookup.FullSpanItem r36 = this.mLazySpanLookup.getFullSpanItem(r20);
        if (r36 == null) goto L65;
        r36.mHasUnwantedGapAfter = true;
        goto L65
    L69:
        r35 = areAllStartsEqual();
        goto L71
    L47:
        if (r110.mFullSpan == false) goto L49;
        LazySpanLookup.FullSpanItem r37 = createFullSpanItemFromEnd(r24);
        r37.mGapDir = -1;
        r37.mPosition = r20;
        this.mLazySpanLookup.addFullSpanItem(r37);
        goto L49
    L43:
        r24 = r111.getEndLine(r14);
        goto L44
    L51:
        if (r110.mFullSpan == false) goto L53;
        int r38 = getMinStart(r14);
    L54:
        r27 = r38 - this.mPrimaryOrientation.getDecoratedMeasurement(r16);
        if (r22 != 0) goto L57;
    L59:
        r26 = r38;
        goto L61
    L57:
        if (r110.mFullSpan == false) goto L59;
        LazySpanLookup.FullSpanItem r39 = createFullSpanItemFromStart(r38);
        r39.mGapDir = 1;
        r39.mPosition = r20;
        this.mLazySpanLookup.addFullSpanItem(r39);
        goto L59
    L53:
        r38 = r111.getStartLine(r14);
        goto L54
    L37:
        addView(r16, r10);
        goto L38
    L29:
        if (r110.mFullSpan == false) goto L31;
        r23 = this.mSpans[r10];
    L32:
        this.mLazySpanLookup.setSpan(r20, r23);
        goto L34
    L31:
        r23 = getNextSpan(r18);
        goto L32
    L26:
        r22 = r10;
        goto L27
    L22:
        if (this.mRemainingSpans.isEmpty() == false) goto L23;
    L107:
        ?? r40 = r10;
        if (r15 == true) goto L111;
        recycle(r17, this.mLayoutState);
    L111:
        if (this.mLayoutState.mLayoutDirection != (-1)) goto L113;
        int r41 = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
    L114:
        if (r41 <= 0) goto L117;
        return Math.min(r18.mAvailable, r41);
    L117:
        return r40 == true ? 1 : 0;
    L113:
        r41 = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        goto L114
    L15:
        r13 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L16
    L7:
        r11 = Integer.MIN_VALUE;
        goto L12
    L9:
        if (r18.mLayoutDirection != 1) goto L11;
        r11 = r18.mEndLine + r18.mAvailable;
        goto L12
    L11:
        r11 = r18.mStartLine - r18.mAvailable;
        goto L12
    }

    private int findFirstReferenceChildPosition(int r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        int r13 = getPosition(getChildAt(r12));
        if (r13 < 0) goto L8;
        if (r13 >= r10) goto L8;
        return r13;
    L8:
        r12 = r12 + 1;
        goto L3
    L9:
        return 0;
    }

    private int findLastReferenceChildPosition(int r10) {
        int r11 = getChildCount() - 1;
    L3:
        if (r11 < 0) goto L9;
        int r12 = getPosition(getChildAt(r11));
        if (r12 < 0) goto L8;
        if (r12 >= r10) goto L8;
        return r12;
    L8:
        r11 = r11 - 1;
        goto L3
    L9:
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        int r13 = getMaxEnd(Integer.MIN_VALUE);
        if (r13 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        int r14 = this.mPrimaryOrientation.getEndAfterPadding() - r13;
        if (r14 <= 0) goto L12;
        int r15 = r14 - (-scrollBy(-r14, r10, r11));
        if (r12 == false) goto L13;
        if (r15 <= 0) goto L14;
        this.mPrimaryOrientation.offsetChildren(r15);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void fixStartGap(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        int r13 = getMinStart(Integer.MAX_VALUE);
        if (r13 != Integer.MAX_VALUE) goto L5;
        return;
    L5:
        int r14 = r13 - this.mPrimaryOrientation.getStartAfterPadding();
        if (r14 <= 0) goto L12;
        int r15 = r14 - scrollBy(r14, r10, r11);
        if (r12 == false) goto L13;
        if (r15 <= 0) goto L14;
        this.mPrimaryOrientation.offsetChildren(-r15);
        return;
    L14:
        return;
    L13:
        return;
    }

    private int getMaxEnd(int r10) {
        int r11 = this.mSpans[0].getEndLine(r10);
        int r12 = 1;
    L4:
        if (r12 >= this.mSpanCount) goto L9;
        int r13 = this.mSpans[r12].getEndLine(r10);
        if (r13 <= r11) goto L8;
        r11 = r13;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    private int getMaxStart(int r10) {
        int r11 = this.mSpans[0].getStartLine(r10);
        int r12 = 1;
    L4:
        if (r12 >= this.mSpanCount) goto L9;
        int r13 = this.mSpans[r12].getStartLine(r10);
        if (r13 <= r11) goto L8;
        r11 = r13;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    private int getMinEnd(int r10) {
        int r11 = this.mSpans[0].getEndLine(r10);
        int r12 = 1;
    L4:
        if (r12 >= this.mSpanCount) goto L9;
        int r13 = this.mSpans[r12].getEndLine(r10);
        if (r13 >= r11) goto L8;
        r11 = r13;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    private int getMinStart(int r10) {
        int r11 = this.mSpans[0].getStartLine(r10);
        int r12 = 1;
    L4:
        if (r12 >= this.mSpanCount) goto L9;
        int r13 = this.mSpans[r12].getStartLine(r10);
        if (r13 >= r11) goto L8;
        r11 = r13;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r11;
    }

    private Span getNextSpan(LayoutState r10) {
        int r11 = -1;
        if (preferLastSpan(r10.mLayoutDirection) == false) goto L5;
        int r12 = this.mSpanCount - 1;
        int r13 = -1;
    L6:
        Span r14 = null;
        if (r10.mLayoutDirection != 1) goto L15;
        int r15 = Integer.MAX_VALUE;
        int r16 = this.mPrimaryOrientation.getStartAfterPadding();
    L9:
        if (r12 == r11) goto L14;
        Span r17 = this.mSpans[r12];
        int r18 = r17.getEndLine(r16);
        if (r18 >= r15) goto L13;
        r14 = r17;
        r15 = r18;
    L13:
        r12 = r12 + r13;
        goto L9
    L14:
        return r14;
    L15:
        int r19 = Integer.MIN_VALUE;
        int r20 = this.mPrimaryOrientation.getEndAfterPadding();
    L16:
        if (r12 == r11) goto L21;
        Span r21 = this.mSpans[r12];
        int r22 = r21.getStartLine(r20);
        if (r22 <= r19) goto L20;
        r14 = r21;
        r19 = r22;
    L20:
        r12 = r12 + r13;
        goto L16
    L21:
        return r14;
    L5:
        r12 = 0;
        r11 = this.mSpanCount;
        r13 = 1;
        goto L6
    }

    private void handleUpdate(int r10, int r11, int r12) {
        if (this.mShouldReverseLayout == false) goto L5;
        int r13 = getLastChildPosition();
    L7:
        if (r12 != 8) goto L11;
        if (r10 >= r11) goto L10;
        int r14 = r11 + 1;
    L12:
        int r15 = r10;
    L13:
        this.mLazySpanLookup.invalidateAfter(r15);
        if (r12 != 1) goto L16;
        this.mLazySpanLookup.offsetForAddition(r10, r11);
    L22:
        if (r14 > r13) goto L25;
        return;
    L25:
        if (this.mShouldReverseLayout == false) goto L27;
        int r16 = getFirstChildPosition();
    L28:
        if (r15 > r16) goto L31;
        requestLayout();
        return;
    L31:
        return;
    L27:
        r16 = getLastChildPosition();
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
    L10:
        r14 = r10 + 1;
        r15 = r11;
        goto L13
    L11:
        r14 = r10 + r11;
        goto L12
    L5:
        r13 = getFirstChildPosition();
        goto L7
    }

    private void measureChildWithDecorationsAndMargin(View r10, int r11, int r12, boolean r13) {
        calculateItemDecorationsForChild(r10, this.mTmpRect);
        LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
        int r15 = ((ViewGroup.MarginLayoutParams) r14).leftMargin;
        Rect r16 = this.mTmpRect;
        int r17 = updateSpecWithExtra(r11, r15 + r16.left, ((ViewGroup.MarginLayoutParams) r14).rightMargin + r16.right);
        int r18 = ((ViewGroup.MarginLayoutParams) r14).topMargin;
        Rect r19 = this.mTmpRect;
        int r20 = updateSpecWithExtra(r12, r18 + r19.top, ((ViewGroup.MarginLayoutParams) r14).bottomMargin + r19.bottom);
        if (r13 == false) goto L5;
        boolean r21 = shouldReMeasureChild(r10, r17, r20, r14);
    L6:
        if (r21 == false) goto L9;
        r10.measure(r17, r20);
        return;
    L9:
        return;
    L5:
        r21 = shouldMeasureChild(r10, r17, r20, r14);
        goto L6
    }

    private void measureChildWithDecorationsAndMargin(View r10, LayoutParams r11, boolean r12) {
        if (r11.mFullSpan == false) goto L9;
        if (this.mOrientation != 1) goto L7;
        int r13 = this.mFullSizeSpec;
    L11:
        int r14 = RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r11).height, true);
    L13:
        measureChildWithDecorationsAndMargin(r10, r13, r14, r12);
        return;
    L7:
        measureChildWithDecorationsAndMargin(r10, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) r11).width, true), this.mFullSizeSpec, r12);
        return;
    L9:
        if (this.mOrientation != 1) goto L12;
        r13 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) r11).width, false);
        goto L11
    L12:
        r13 = RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) r11).width, true);
        r14 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) r11).height, false);
        goto L13
    }

    private void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12) {
        AnchorInfo r13 = this.mAnchorInfo;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        boolean r14 = true;
        if (r13.mValid == true) goto L13;
    L18:
        boolean r15 = true;
    L19:
        if (r15 == false) goto L26;
        r13.reset();
        if (this.mPendingSavedState == null) goto L23;
        applyPendingSavedState(r13);
    L24:
        updateAnchorInfoForLayout(r11, r13);
        r13.mValid = true;
        goto L26
    L23:
        resolveShouldLayoutReverse();
        r13.mLayoutFromEnd = this.mShouldReverseLayout;
    L26:
        if (this.mPendingSavedState != null) goto L35;
        if (this.mPendingScrollPosition != (-1)) goto L35;
        if (r13.mLayoutFromEnd == this.mLastLayoutFromEnd) goto L32;
    L33:
        this.mLazySpanLookup.clear();
        r13.mInvalidateOffsets = true;
        goto L35
    L32:
        if (isLayoutRTL() != this.mLastLayoutRTL) goto L33;
    L35:
        if (getChildCount() <= 0) goto L62;
        SavedState r16 = this.mPendingSavedState;
        if (r16 == null) goto L41;
        if (r16.mSpanOffsetsSize >= 1) goto L62;
    L41:
        if (r13.mInvalidateOffsets == false) goto L49;
        int r17 = 0;
    L44:
        if (r17 >= this.mSpanCount) goto L62;
        this.mSpans[r17].clear();
        int r18 = r13.mOffset;
        if (r18 == Integer.MIN_VALUE) goto L48;
        this.mSpans[r17].setLine(r18);
    L48:
        r17 = r17 + 1;
        goto L44
    L49:
        if (r15 == false) goto L51;
    L57:
        int r19 = 0;
    L59:
        if (r19 >= this.mSpanCount) goto L61;
        this.mSpans[r19].cacheReferenceLineAndClear(this.mShouldReverseLayout, r13.mOffset);
        r19 = r19 + 1;
        goto L59
    L61:
        this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
        goto L62
    L51:
        if (this.mAnchorInfo.mSpanReferenceLines == null) goto L57;
        int r20 = 0;
    L55:
        if (r20 >= this.mSpanCount) goto L62;
        Span r21 = this.mSpans[r20];
        r21.clear();
        r21.setLine(this.mAnchorInfo.mSpanReferenceLines[r20]);
        r20 = r20 + 1;
    L62:
        detachAndScrapAttachedViews(r10);
        this.mLayoutState.mRecycle = false;
        this.mLaidOutInvalidFullSpan = false;
        updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
        updateLayoutState(r13.mPosition, r11);
        if (r13.mLayoutFromEnd == false) goto L65;
        setLayoutStateDirection(-1);
        fill(r10, this.mLayoutState, r11);
        setLayoutStateDirection(1);
    L66:
        LayoutState r22 = this.mLayoutState;
        r22.mCurrentPosition = r13.mPosition + r22.mItemDirection;
        fill(r10, r22, r11);
        repositionToWrapContentIfNecessary();
        if (getChildCount() > 0) goto L69;
    L72:
        if (r12 == true) goto L74;
    L89:
        r14 = false;
    L91:
        if (r11.isPreLayout() == false) goto L93;
        this.mAnchorInfo.reset();
    L93:
        this.mLastLayoutFromEnd = r13.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        if (r14 == false) goto L102;
        this.mAnchorInfo.reset();
        onLayoutChildren(r10, r11, false);
        return;
    L102:
        return;
    L74:
        if (r11.isPreLayout() == true) goto L89;
        if (this.mGapStrategy != 0) goto L78;
    L84:
        boolean r110 = false;
    L85:
        if (r110 == false) goto L89;
        removeCallbacks(this.mCheckForGapsRunnable);
        if (checkForGaps() == false) goto L89;
    L78:
        if (getChildCount() <= 0) goto L84;
        if (this.mLaidOutInvalidFullSpan == false) goto L82;
    L83:
        r110 = true;
        goto L85
    L82:
        if (hasGapsToFix() == null) goto L84;
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
        goto L66
    L13:
        if (this.mPendingScrollPosition != (-1)) goto L18;
        if (this.mPendingSavedState != null) goto L18;
        r15 = false;
    L7:
        if (r11.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r10);
        r13.reset();
    }

    private boolean preferLastSpan(int r10) {
        if (this.mOrientation != 0) goto L12;
        if (r10 != (-1)) goto L6;
        boolean r11 = true;
    L8:
        if (r11 == this.mShouldReverseLayout) goto L11;
        return true;
    L11:
        return false;
    L6:
        r11 = false;
        goto L8
    L12:
        if (r10 != (-1)) goto L14;
        boolean r12 = true;
    L16:
        if (r12 != this.mShouldReverseLayout) goto L18;
        boolean r13 = true;
    L20:
        if (r13 != isLayoutRTL()) goto L23;
        return true;
    L23:
        return false;
    L18:
        r13 = false;
        goto L20
    L14:
        r12 = false;
        goto L16
    }

    private void prependViewToAllSpans(View r10) {
        int r11 = this.mSpanCount - 1;
    L3:
        if (r11 < 0) goto L5;
        this.mSpans[r11].prependToSpan(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void recycle(RecyclerView.Recycler r10, LayoutState r11) {
        if (r11.mRecycle == true) goto L5;
        return;
    L5:
        if (r11.mInfinite == false) goto L8;
        return;
    L8:
        if (r11.mAvailable != 0) goto L16;
        if (r11.mLayoutDirection != (-1)) goto L13;
    L11:
        int r12 = r11.mEndLine;
    L12:
        recycleFromEnd(r10, r12);
        return;
    L13:
        int r13 = r11.mStartLine;
    L14:
        recycleFromStart(r10, r13);
        return;
    L16:
        if (r11.mLayoutDirection != (-1)) goto L21;
        int r14 = r11.mStartLine;
        int r15 = r14 - getMaxStart(r14);
        if (r15 < 0) goto L11;
        r12 = r11.mEndLine - Math.min(r15, r11.mAvailable);
        goto L12
    L21:
        int r16 = getMinEnd(r11.mEndLine) - r11.mEndLine;
        if (r16 < 0) goto L13;
        int r17 = r11.mStartLine;
        r13 = Math.min(r16, r11.mAvailable) + r17;
        goto L14
    }

    private void recycleFromEnd(RecyclerView.Recycler r10, int r11) {
        int r12 = getChildCount() - 1;
    L3:
        if (r12 < 0) goto L25;
        View r13 = getChildAt(r12);
        if (this.mPrimaryOrientation.getDecoratedStart(r13) < r11) goto L34;
        if (this.mPrimaryOrientation.getTransformedStartWithDecoration(r13) < r11) goto L35;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (r14.mFullSpan == false) goto L21;
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r16 >= this.mSpanCount) goto L18;
        if (this.mSpans[r16].mViews.size() == 1) goto L15;
        r16 = r16 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r15 >= this.mSpanCount) goto L24;
        this.mSpans[r15].popEnd();
        r15 = r15 + 1;
    L24:
        removeAndRecycleView(r13, r10);
        r12 = r12 - 1;
        goto L3
    L21:
        if (r14.mSpan.mViews.size() == 1) goto L22;
        r14.mSpan.popEnd();
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
        int r12 = 0;
        View r13 = getChildAt(0);
        if (this.mPrimaryOrientation.getDecoratedEnd(r13) > r11) goto L34;
        if (this.mPrimaryOrientation.getTransformedEndWithDecoration(r13) > r11) goto L35;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (r14.mFullSpan == false) goto L21;
        int r15 = 0;
    L12:
        if (r15 >= this.mSpanCount) goto L18;
        if (this.mSpans[r15].mViews.size() == 1) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r12 >= this.mSpanCount) goto L24;
        this.mSpans[r12].popStart();
        r12 = r12 + 1;
    L24:
        removeAndRecycleView(r13, r10);
        goto L3
    L21:
        if (r14.mSpan.mViews.size() == 1) goto L22;
        r14.mSpan.popStart();
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
        float r10 = 0.0f;
        int r11 = getChildCount();
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r11) goto L15;
        View r14 = getChildAt(r13);
        float r15 = this.mSecondaryOrientation.getDecoratedMeasurement(r14);
        if (r15 < r10) goto L14;
        if (((LayoutParams) r14.getLayoutParams()).isFullSpan() == false) goto L13;
        r15 = (r15 * 1.0f) / this.mSpanCount;
    L13:
        r10 = Math.max(r10, r15);
    L14:
        r13 = r13 + 1;
        goto L6
    L15:
        int r16 = this.mSizePerSpan;
        int r17 = Math.round(r10 * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() != Integer.MIN_VALUE) goto L18;
        r17 = Math.min(r17, this.mSecondaryOrientation.getTotalSpace());
    L18:
        updateMeasureSpecs(r17);
        if (this.mSizePerSpan != r16) goto L21;
        return;
    L21:
        if (r12 >= r11) goto L35;
        View r18 = getChildAt(r12);
        LayoutParams r19 = (LayoutParams) r18.getLayoutParams();
        if (r19.mFullSpan == true) goto L34;
        if (isLayoutRTL() == true) goto L28;
    L30:
        int r20 = r19.mSpan.mIndex;
        int r21 = this.mOrientation;
        int r22 = (this.mSizePerSpan * r20) - (r20 * r16);
        if (r21 != 1) goto L33;
        r18.offsetLeftAndRight(r22);
        goto L34
    L33:
        r18.offsetTopAndBottom(r22);
        goto L34
    L28:
        if (this.mOrientation != 1) goto L30;
        int r23 = this.mSpanCount;
        int r24 = r19.mSpan.mIndex;
        r18.offsetLeftAndRight(((-((r23 - 1) - r24)) * this.mSizePerSpan) - ((-((r23 - 1) - r24)) * r16));
    L34:
        r12 = r12 + 1;
        goto L21
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

    private void setLayoutStateDirection(int r10) {
        LayoutState r11 = this.mLayoutState;
        r11.mLayoutDirection = r10;
        boolean r12 = this.mShouldReverseLayout;
        int r13 = 1;
        if (r10 != (-1)) goto L5;
        boolean r14 = true;
    L6:
        if (r12 == r14) goto L9;
        r13 = -1;
    L9:
        r11.mItemDirection = r13;
        return;
    L5:
        r14 = false;
        goto L6
    }

    private void updateAllRemainingSpans(int r10, int r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.mSpanCount) goto L10;
        if (this.mSpans[r12].mViews.isEmpty() == true) goto L9;
        updateRemainingSpans(this.mSpans[r12], r10, r11);
    L9:
        r12 = r12 + 1;
        goto L4
    }

    private boolean updateAnchorFromChildren(RecyclerView.State r10, AnchorInfo r11) {
        boolean r12 = this.mLastLayoutFromEnd;
        int r13 = r10.getItemCount();
        if (r12 == false) goto L5;
        int r14 = findLastReferenceChildPosition(r13);
    L6:
        r11.mPosition = r14;
        r11.mOffset = Integer.MIN_VALUE;
        return true;
    L5:
        r14 = findFirstReferenceChildPosition(r13);
        goto L6
    }

    private void updateLayoutState(int r10, RecyclerView.State r11) {
        LayoutState r12 = this.mLayoutState;
        boolean r13 = false;
        r12.mAvailable = 0;
        r12.mCurrentPosition = r10;
        if (isSmoothScrolling() == false) goto L13;
        int r14 = r11.getTargetScrollPosition();
        if (r14 == (-1)) goto L13;
        boolean r15 = this.mShouldReverseLayout;
        if (r14 >= r10) goto L9;
        boolean r16 = true;
    L10:
        if (r15 != r16) goto L12;
        int r17 = this.mPrimaryOrientation.getTotalSpace();
        int r18 = 0;
    L15:
        if (getClipToPadding() == false) goto L17;
        this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - r18;
        this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + r17;
    L18:
        LayoutState r19 = this.mLayoutState;
        r19.mStopInFocusable = false;
        r19.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0) goto L21;
    L23:
        r19.mInfinite = r13;
        return;
    L21:
        if (this.mPrimaryOrientation.getEnd() != 0) goto L23;
        r13 = true;
        goto L23
    L17:
        this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + r17;
        this.mLayoutState.mStartLine = -r18;
        goto L18
    L12:
        r18 = this.mPrimaryOrientation.getTotalSpace();
        r17 = 0;
        goto L15
    L9:
        r16 = false;
    L13:
        r17 = 0;
        r18 = 0;
        goto L15
    }

    private void updateRemainingSpans(Span r10, int r11, int r12) {
        int r13 = r10.getDeletedSize();
        if (r11 != (-1)) goto L8;
        if ((r10.getStartLine() + r13) > r12) goto L11;
    L9:
        this.mRemainingSpans.set(r10.mIndex, false);
        return;
    L11:
        return;
    L8:
        if ((r10.getEndLine() - r13) >= r12) goto L9;
    }

    private int updateSpecWithExtra(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        if (r12 != 0) goto L5;
        return r10;
    L5:
        int r13 = View.MeasureSpec.getMode(r10);
        if (r13 == Integer.MIN_VALUE) goto L12;
        if (r13 == 1073741824) goto L12;
        return r10;
    L12:
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r10) - r11) - r12), r13);
    }

    boolean areAllEndsEqual() {
        int r10 = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        int r11 = 1;
    L4:
        if (r11 >= this.mSpanCount) goto L9;
        if (this.mSpans[r11].getEndLine(Integer.MIN_VALUE) != r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    boolean areAllStartsEqual() {
        int r10 = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        int r11 = 1;
    L4:
        if (r11 >= this.mSpanCount) goto L9;
        if (this.mSpans[r11].getStartLine(Integer.MIN_VALUE) != r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r10) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r10);
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

    boolean checkForGaps() {
        if (getChildCount() != 0) goto L5;
    L35:
        return false;
    L5:
        if (this.mGapStrategy == 0) goto L35;
        if (isAttachedToWindow() == false) goto L35;
        if (this.mShouldReverseLayout == false) goto L12;
        int r10 = getLastChildPosition();
        int r11 = getFirstChildPosition();
    L14:
        if (r10 != 0) goto L21;
        if (hasGapsToFix() == null) goto L21;
        this.mLazySpanLookup.clear();
    L18:
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L21:
        if (this.mLaidOutInvalidFullSpan == true) goto L24;
        return false;
    L24:
        if (this.mShouldReverseLayout == false) goto L26;
        int r12 = -1;
    L27:
        int r13 = r11 + 1;
        LazySpanLookup.FullSpanItem r14 = this.mLazySpanLookup.getFirstFullSpanItemInRange(r10, r13, r12, true);
        if (r14 != null) goto L31;
        this.mLaidOutInvalidFullSpan = false;
        this.mLazySpanLookup.forceInvalidateAfter(r13);
        return false;
    L31:
        LazySpanLookup.FullSpanItem r15 = this.mLazySpanLookup.getFirstFullSpanItemInRange(r10, r14.mPosition, r12 * (-1), true);
        if (r15 != null) goto L34;
        this.mLazySpanLookup.forceInvalidateAfter(r14.mPosition);
        goto L18
    L34:
        this.mLazySpanLookup.forceInvalidateAfter(r15.mPosition + 1);
        goto L18
    L26:
        r12 = 1;
        goto L27
    L12:
        r10 = getFirstChildPosition();
        r11 = getLastChildPosition();
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int r10, int r11, RecyclerView.State r12, RecyclerView.LayoutManager.LayoutPrefetchRegistry r13) {
        if (this.mOrientation == 0) goto L7;
        r10 = r11;
    L7:
        if (getChildCount() == 0) goto L31;
        if (r10 == 0) goto L37;
        prepareLayoutStateForDelta(r10, r12);
        int[] r14 = this.mPrefetchDistances;
        if (r14 != null) goto L13;
    L14:
        this.mPrefetchDistances = new int[this.mSpanCount];
    L15:
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L17:
        if (r16 >= this.mSpanCount) goto L26;
        LayoutState r18 = this.mLayoutState;
        if (r18.mItemDirection != (-1)) goto L21;
        int r19 = r18.mStartLine;
        int r20 = this.mSpans[r16].getStartLine(r19);
    L22:
        int r21 = r19 - r20;
        if (r21 < 0) goto L25;
        this.mPrefetchDistances[r17] = r21;
        r17 = r17 + 1;
    L25:
        r16 = r16 + 1;
        goto L17
    L21:
        r19 = this.mSpans[r16].getEndLine(r18.mEndLine);
        r20 = this.mLayoutState.mEndLine;
        goto L22
    L26:
        Arrays.sort(this.mPrefetchDistances, 0, r17);
    L27:
        if (r15 >= r17) goto L38;
        if (this.mLayoutState.hasMore(r12) == false) goto L39;
        r13.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[r15]);
        LayoutState r22 = this.mLayoutState;
        r22.mCurrentPosition += r22.mItemDirection;
        r15 = r15 + 1;
        goto L27
    L39:
        return;
    L38:
        return;
    L13:
        if (r14.length >= this.mSpanCount) goto L15;
    L37:
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
        int r11 = calculateScrollDirectionForPosition(r10);
        PointF r12 = new PointF();
        if (r11 != 0) goto L7;
        return null;
    L7:
        if (this.mOrientation != 0) goto L9;
        r12.x = r11;
        r12.y = 0.0f;
    L10:
        return r12;
    L9:
        r12.x = 0.0f;
        r12.y = r11;
        goto L10
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

    public int[] findFirstCompletelyVisibleItemPositions(int[] r10) {
        if (r10 != null) goto L5;
        r10 = new int[this.mSpanCount];
    L6:
        int r11 = 0;
    L8:
        if (r11 >= this.mSpanCount) goto L10;
        r10[r11] = this.mSpans[r11].findFirstCompletelyVisibleItemPosition();
        r11 = r11 + 1;
        goto L8
    L10:
        return r10;
    L5:
        if (r10.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r10.length);
    }

    View findFirstVisibleItemClosestToEnd(boolean r10) {
        int r11 = this.mPrimaryOrientation.getStartAfterPadding();
        int r12 = this.mPrimaryOrientation.getEndAfterPadding();
        int r13 = getChildCount() - 1;
        View r14 = null;
    L3:
        if (r13 < 0) goto L15;
        View r15 = getChildAt(r13);
        int r16 = this.mPrimaryOrientation.getDecoratedStart(r15);
        int r17 = this.mPrimaryOrientation.getDecoratedEnd(r15);
        if (r17 <= r11) goto L14;
        if (r16 >= r12) goto L14;
        if (r17 <= r12) goto L13;
        if (r10 == false) goto L13;
        if (r14 != null) goto L14;
        r14 = r15;
    L13:
        return r15;
    L14:
        r13 = r13 - 1;
        goto L3
    L15:
        return r14;
    }

    View findFirstVisibleItemClosestToStart(boolean r10) {
        int r11 = this.mPrimaryOrientation.getStartAfterPadding();
        int r12 = this.mPrimaryOrientation.getEndAfterPadding();
        int r13 = getChildCount();
        View r14 = null;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L15;
        View r16 = getChildAt(r15);
        int r17 = this.mPrimaryOrientation.getDecoratedStart(r16);
        if (this.mPrimaryOrientation.getDecoratedEnd(r16) <= r11) goto L14;
        if (r17 >= r12) goto L14;
        if (r17 >= r11) goto L13;
        if (r10 == false) goto L13;
        if (r14 != null) goto L14;
        r14 = r16;
    L13:
        return r16;
    L14:
        r15 = r15 + 1;
        goto L3
    L15:
        return r14;
    }

    int findFirstVisibleItemPositionInt() {
        if (this.mShouldReverseLayout == false) goto L5;
        View r10 = findFirstVisibleItemClosestToEnd(true);
    L6:
        if (r10 != null) goto L9;
        return -1;
    L9:
        return getPosition(r10);
    L5:
        r10 = findFirstVisibleItemClosestToStart(true);
        goto L6
    }

    public int[] findFirstVisibleItemPositions(int[] r10) {
        if (r10 != null) goto L5;
        r10 = new int[this.mSpanCount];
    L6:
        int r11 = 0;
    L8:
        if (r11 >= this.mSpanCount) goto L10;
        r10[r11] = this.mSpans[r11].findFirstVisibleItemPosition();
        r11 = r11 + 1;
        goto L8
    L10:
        return r10;
    L5:
        if (r10.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r10.length);
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] r10) {
        if (r10 != null) goto L5;
        r10 = new int[this.mSpanCount];
    L6:
        int r11 = 0;
    L8:
        if (r11 >= this.mSpanCount) goto L10;
        r10[r11] = this.mSpans[r11].findLastCompletelyVisibleItemPosition();
        r11 = r11 + 1;
        goto L8
    L10:
        return r10;
    L5:
        if (r10.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r10.length);
    }

    public int[] findLastVisibleItemPositions(int[] r10) {
        if (r10 != null) goto L5;
        r10 = new int[this.mSpanCount];
    L6:
        int r11 = 0;
    L8:
        if (r11 >= this.mSpanCount) goto L10;
        r10[r11] = this.mSpans[r11].findLastVisibleItemPosition();
        r11 = r11 + 1;
        goto L8
    L10:
        return r10;
    L5:
        if (r10.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r10.length);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r10, AttributeSet r11) {
        return new LayoutParams(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L7:
        return new LayoutParams(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mOrientation != 1) goto L7;
        return this.mSpanCount;
    L7:
        return super.getColumnCountForAccessibility(r10, r11);
    }

    int getFirstChildPosition() {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(0));
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    int getLastChildPosition() {
        int r10 = getChildCount();
        if (r10 != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(r10 - 1));
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mOrientation != 0) goto L7;
        return this.mSpanCount;
    L7:
        return super.getRowCountForAccessibility(r10, r11);
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    View hasGapsToFix() {
        int r10 = getChildCount() - 1;
        BitSet r11 = new BitSet(this.mSpanCount);
        r11.set(0, this.mSpanCount, true);
        int r12 = -1;
        if (this.mOrientation == 1) goto L5;
    L7:
        byte r13 = -1;
    L9:
        if (this.mShouldReverseLayout == false) goto L11;
        int r14 = -1;
    L12:
        if (r10 >= r14) goto L14;
        r12 = 1;
    L14:
        if (r10 == r14) goto L50;
        View r15 = getChildAt(r10);
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        if (r11.get(r16.mSpan.mIndex) == false) goto L22;
        if (checkSpanForGap(r16.mSpan) == true) goto L19;
        r11.clear(r16.mSpan.mIndex);
        goto L22
    L19:
        return r15;
    L22:
        if (r16.mFullSpan == true) goto L49;
        int r17 = r10 + r12;
        if (r17 == r14) goto L49;
        View r18 = getChildAt(r17);
        if (this.mShouldReverseLayout == false) goto L33;
        int r19 = this.mPrimaryOrientation.getDecoratedEnd(r15);
        int r110 = this.mPrimaryOrientation.getDecoratedEnd(r18);
        if (r19 < r110) goto L30;
        if (r19 == r110) goto L37;
    L38:
        boolean r111 = false;
    L39:
        if (r111 == false) goto L49;
        if ((r16.mSpan.mIndex - ((LayoutParams) r18.getLayoutParams()).mSpan.mIndex) >= 0) goto L43;
        boolean r20 = true;
    L44:
        if (r13 >= 0) goto L46;
        boolean r21 = true;
    L47:
        if (r20 == r21) goto L49;
        return r15;
    L46:
        r21 = false;
        goto L47
    L43:
        r20 = false;
    L37:
        r111 = true;
        goto L39
    L30:
        return r15;
    L33:
        int r112 = this.mPrimaryOrientation.getDecoratedStart(r15);
        int r113 = this.mPrimaryOrientation.getDecoratedStart(r18);
        if (r112 > r113) goto L35;
        if (r112 != r113) goto L38;
    L35:
        return r15;
    L49:
        r10 = r10 + r12;
        goto L14
    L50:
        return null;
    L11:
        r14 = r10 + 1;
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

    boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int r10) {
        super.offsetChildrenHorizontal(r10);
        int r11 = 0;
    L4:
        if (r11 >= this.mSpanCount) goto L6;
        this.mSpans[r11].onOffset(r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int r10) {
        super.offsetChildrenVertical(r10);
        int r11 = 0;
    L4:
        if (r11 >= this.mSpanCount) goto L6;
        this.mSpans[r11].onOffset(r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r10, RecyclerView.Recycler r11) {
        super.onDetachedFromWindow(r10, r11);
        removeCallbacks(this.mCheckForGapsRunnable);
        int r12 = 0;
    L4:
        if (r12 >= this.mSpanCount) goto L6;
        this.mSpans[r12].clear();
        r12 = r12 + 1;
        goto L4
    L6:
        r10.requestLayout();
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
        LayoutParams r16 = (LayoutParams) r14.getLayoutParams();
        boolean r17 = r16.mFullSpan;
        Span r18 = r16.mSpan;
        if (r15 != 1) goto L14;
        int r19 = getLastChildPosition();
    L15:
        updateLayoutState(r19, r13);
        setLayoutStateDirection(r15);
        LayoutState r20 = this.mLayoutState;
        r20.mCurrentPosition = r20.mItemDirection + r19;
        r20.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * MAX_SCROLL_FACTOR);
        LayoutState r21 = this.mLayoutState;
        r21.mStopInFocusable = true;
        int r22 = 0;
        r21.mRecycle = false;
        fill(r12, r21, r13);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (r17 == true) goto L22;
        View r110 = r18.getFocusableViewAfter(r19, r15);
        if (r110 == null) goto L22;
        if (r110 == r14) goto L22;
        return r110;
    L22:
        if (preferLastSpan(r15) == false) goto L30;
        int r111 = this.mSpanCount - 1;
    L24:
        if (r111 < 0) goto L38;
        View r112 = this.mSpans[r111].getFocusableViewAfter(r19, r15);
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
        if (r17 == true) goto L54;
        if (r115 == false) goto L48;
        int r116 = r18.findFirstPartiallyVisibleItemPosition();
    L49:
        View r117 = findViewByPosition(r116);
        if (r117 == null) goto L54;
        if (r117 == r14) goto L54;
        return r117;
    L48:
        r116 = r18.findLastPartiallyVisibleItemPosition();
    L54:
        if (preferLastSpan(r15) == false) goto L70;
        int r118 = this.mSpanCount - 1;
    L56:
        if (r118 < 0) goto L80;
        if (r118 == r18.mIndex) goto L68;
        Span[] r119 = this.mSpans;
        if (r115 == false) goto L63;
        int r120 = r119[r118].findFirstPartiallyVisibleItemPosition();
    L64:
        View r121 = findViewByPosition(r120);
        if (r121 == null) goto L68;
        if (r121 == r14) goto L68;
        return r121;
    L63:
        r120 = r119[r118].findLastPartiallyVisibleItemPosition();
    L68:
        r118 = r118 - 1;
    L80:
        return null;
    L70:
        if (r22 >= this.mSpanCount) goto L80;
        Span[] r122 = this.mSpans;
        if (r115 == false) goto L74;
        int r123 = r122[r22].findFirstPartiallyVisibleItemPosition();
    L75:
        View r124 = findViewByPosition(r123);
        if (r124 == null) goto L79;
        if (r124 == r14) goto L79;
        return r124;
    L79:
        r22 = r22 + 1;
        goto L70
    L74:
        r123 = r122[r22].findLastPartiallyVisibleItemPosition();
        goto L75
    L44:
        r115 = false;
        goto L45
    L41:
        r114 = false;
        goto L42
    L30:
        int r125 = 0;
    L32:
        if (r125 >= this.mSpanCount) goto L38;
        View r126 = this.mSpans[r125].getFocusableViewAfter(r19, r15);
        if (r126 == null) goto L37;
        if (r126 == r14) goto L37;
        return r126;
    L37:
        r125 = r125 + 1;
        goto L32
    L14:
        r19 = getFirstChildPosition();
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        if (getChildCount() <= 0) goto L13;
        View r11 = findFirstVisibleItemClosestToStart(false);
        View r12 = findFirstVisibleItemClosestToEnd(false);
        if (r11 == null) goto L14;
        if (r12 == null) goto L16;
        int r13 = getPosition(r11);
        int r14 = getPosition(r12);
        if (r13 >= r14) goto L11;
        r10.setFromIndex(r13);
        r10.setToIndex(r14);
        return;
    L11:
        r10.setFromIndex(r14);
        r10.setToIndex(r13);
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler r10, RecyclerView.State r11, View r12, AccessibilityNodeInfoCompat r13) {
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if ((r14 instanceof LayoutParams) == true) goto L6;
        super.onInitializeAccessibilityNodeInfoForItem(r12, r13);
        return;
    L6:
        LayoutParams r15 = (LayoutParams) r14;
        int r16 = 1;
        if (this.mOrientation != 0) goto L12;
        int r17 = r15.getSpanIndex();
        if (r15.mFullSpan == false) goto L11;
        r16 = this.mSpanCount;
    L11:
        int r18 = r16;
        int r19 = -1;
        int r20 = -1;
    L16:
        r13.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r17, r18, r19, r20, false, false));
        return;
    L12:
        r17 = -1;
        r18 = -1;
        r19 = r15.getSpanIndex();
        if (r15.mFullSpan == false) goto L15;
        r16 = this.mSpanCount;
    L15:
        r20 = r16;
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r10, int r11, int r12) {
        handleUpdate(r11, r12, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r10) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r10, int r11, int r12, int r13) {
        handleUpdate(r11, r12, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r10, int r11, int r12) {
        handleUpdate(r11, r12, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r10, int r11, int r12, Object r13) {
        handleUpdate(r11, r12, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        onLayoutChildren(r10, r11, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r10) {
        super.onLayoutCompleted(r10);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
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
        r10.mReverseLayout = this.mReverseLayout;
        r10.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        r10.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup r11 = this.mLazySpanLookup;
        int r12 = 0;
        if (r11 == null) goto L11;
        int[] r13 = r11.mData;
        if (r13 == null) goto L11;
        r10.mSpanLookup = r13;
        r10.mSpanLookupSize = r13.length;
        r10.mFullSpanItems = r11.mFullSpanItems;
    L13:
        if (getChildCount() > 0) goto L15;
        r10.mAnchorPosition = -1;
        r10.mVisibleAnchorPosition = -1;
        r10.mSpanOffsetsSize = 0;
    L32:
        return r10;
    L15:
        if (this.mLastLayoutFromEnd == false) goto L17;
        int r14 = getLastChildPosition();
    L18:
        r10.mAnchorPosition = r14;
        r10.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
        int r15 = this.mSpanCount;
        r10.mSpanOffsetsSize = r15;
        r10.mSpanOffsets = new int[r15];
    L20:
        if (r12 >= this.mSpanCount) goto L32;
        if (this.mLastLayoutFromEnd == false) goto L26;
        int r16 = this.mSpans[r12].getEndLine(Integer.MIN_VALUE);
        if (r16 == Integer.MIN_VALUE) goto L30;
        int r17 = this.mPrimaryOrientation.getEndAfterPadding();
    L29:
        r16 = r16 - r17;
    L30:
        r10.mSpanOffsets[r12] = r16;
        r12 = r12 + 1;
        goto L20
    L26:
        r16 = this.mSpans[r12].getStartLine(Integer.MIN_VALUE);
        if (r16 == Integer.MIN_VALUE) goto L30;
        r17 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L29
    L17:
        r14 = getFirstChildPosition();
    L11:
        r10.mSpanLookupSize = 0;
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int r10) {
        if (r10 != 0) goto L5;
        checkForGaps();
        return;
    }

    void prepareLayoutStateForDelta(int r10, RecyclerView.State r11) {
        if (r10 <= 0) goto L5;
        int r12 = getLastChildPosition();
        int r13 = 1;
    L6:
        this.mLayoutState.mRecycle = true;
        updateLayoutState(r12, r11);
        setLayoutStateDirection(r13);
        LayoutState r14 = this.mLayoutState;
        r14.mCurrentPosition = r12 + r14.mItemDirection;
        r14.mAvailable = Math.abs(r10);
        return;
    L5:
        r13 = -1;
        r12 = getFirstChildPosition();
        goto L6
    }

    int scrollBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getChildCount() == 0) goto L14;
        if (r10 == 0) goto L14;
        prepareLayoutStateForDelta(r10, r12);
        int r13 = fill(r11, this.mLayoutState, r12);
        if (this.mLayoutState.mAvailable < r13) goto L12;
        if (r10 >= 0) goto L11;
        r10 = -r13;
        goto L12
    L11:
        r10 = r13;
    L12:
        this.mPrimaryOrientation.offsetChildren(-r10);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState r14 = this.mLayoutState;
        r14.mAvailable = 0;
        recycle(r11, r14);
        return r10;
    L14:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        return scrollBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r10) {
        SavedState r11 = this.mPendingSavedState;
        if (r11 != null) goto L5;
    L7:
        this.mPendingScrollPosition = r10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
        return;
    L5:
        if (r11.mAnchorPosition == r10) goto L7;
        r11.invalidateAnchorPositionInfo();
        goto L7
    }

    public void scrollToPositionWithOffset(int r10, int r11) {
        SavedState r12 = this.mPendingSavedState;
        if (r12 == null) goto L5;
        r12.invalidateAnchorPositionInfo();
    L5:
        this.mPendingScrollPosition = r10;
        this.mPendingScrollPositionOffset = r11;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        return scrollBy(r10, r11, r12);
    }

    public void setGapStrategy(int r10) {
        assertNotInLayoutOrScroll(null);
        if (r10 != this.mGapStrategy) goto L5;
        return;
    L5:
        if (r10 != 0) goto L7;
    L11:
        this.mGapStrategy = r10;
        requestLayout();
        return;
    L7:
        if (r10 == 2) goto L11;
        throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r10, int r11, int r12) {
        int r13 = getPaddingLeft() + getPaddingRight();
        int r14 = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation != 1) goto L5;
        int r15 = RecyclerView.LayoutManager.chooseSize(r12, r10.height() + r14, getMinimumHeight());
        int r16 = RecyclerView.LayoutManager.chooseSize(r11, (this.mSizePerSpan * this.mSpanCount) + r13, getMinimumWidth());
    L6:
        setMeasuredDimension(r16, r15);
        return;
    L5:
        r16 = RecyclerView.LayoutManager.chooseSize(r11, r10.width() + r13, getMinimumWidth());
        r15 = RecyclerView.LayoutManager.chooseSize(r12, (this.mSizePerSpan * this.mSpanCount) + r14, getMinimumHeight());
        goto L6
    }

    public void setOrientation(int r10) {
        if (r10 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r10 != this.mOrientation) goto L11;
        return;
    L11:
        this.mOrientation = r10;
        OrientationHelper r11 = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = r11;
        requestLayout();
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean r10) {
        assertNotInLayoutOrScroll(null);
        SavedState r11 = this.mPendingSavedState;
        if (r11 != null) goto L5;
    L7:
        this.mReverseLayout = r10;
        requestLayout();
        return;
    L5:
        if (r11.mReverseLayout == r10) goto L7;
        r11.mReverseLayout = r10;
        goto L7
    }

    public void setSpanCount(int r10) {
        assertNotInLayoutOrScroll(null);
        if (r10 == this.mSpanCount) goto L11;
        invalidateSpanAssignments();
        this.mSpanCount = r10;
        this.mRemainingSpans = new BitSet(this.mSpanCount);
        this.mSpans = new Span[this.mSpanCount];
        int r11 = 0;
    L6:
        if (r11 >= this.mSpanCount) goto L8;
        this.mSpans[r11] = new Span(this, r11);
        r11 = r11 + 1;
        goto L6
    L8:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r10, RecyclerView.State r11, int r12) {
        LinearSmoothScroller r13 = new LinearSmoothScroller(r10.getContext());
        r13.setTargetPosition(r12);
        startSmoothScroll(r13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean updateAnchorFromPendingData(RecyclerView.State r10, AnchorInfo r11) {
        boolean r12 = false;
        if (r10.isPreLayout() == true) goto L61;
        int r13 = this.mPendingScrollPosition;
        if (r13 == (-1)) goto L61;
        if (r13 >= 0) goto L10;
    L60:
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        goto L61
    L10:
        if (r13 >= r10.getItemCount()) goto L60;
        SavedState r14 = this.mPendingSavedState;
        if (r14 != null) goto L15;
    L20:
        View r15 = findViewByPosition(this.mPendingScrollPosition);
        if (r15 != null) goto L23;
        int r16 = this.mPendingScrollPosition;
        r11.mPosition = r16;
        int r17 = this.mPendingScrollPositionOffset;
        if (r17 == Integer.MIN_VALUE) goto L54;
        r11.assignCoordinateFromPadding(r17);
    L58:
        r11.mInvalidateOffsets = true;
    L59:
        return true;
    L54:
        if (calculateScrollDirectionForPosition(r16) != 1) goto L56;
        r12 = true;
    L56:
        r11.mLayoutFromEnd = r12;
        r11.assignCoordinateFromPadding();
        goto L58
    L23:
        if (this.mShouldReverseLayout == false) goto L25;
        int r18 = getLastChildPosition();
    L26:
        r11.mPosition = r18;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L35;
        if (r11.mLayoutFromEnd == false) goto L31;
        int r19 = this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset;
        int r20 = this.mPrimaryOrientation.getDecoratedEnd(r15);
    L32:
        r11.mOffset = r19 - r20;
        return true;
    L31:
        r19 = this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset;
        r20 = this.mPrimaryOrientation.getDecoratedStart(r15);
        goto L32
    L35:
        if (this.mPrimaryOrientation.getDecoratedMeasurement(r15) <= this.mPrimaryOrientation.getTotalSpace()) goto L42;
        boolean r21 = r11.mLayoutFromEnd;
        OrientationHelper r22 = this.mPrimaryOrientation;
        if (r21 == false) goto L39;
        int r23 = r22.getEndAfterPadding();
    L40:
        r11.mOffset = r23;
        return true;
    L39:
        r23 = r22.getStartAfterPadding();
        goto L40
    L42:
        int r24 = this.mPrimaryOrientation.getDecoratedStart(r15) - this.mPrimaryOrientation.getStartAfterPadding();
        if (r24 >= 0) goto L46;
        r11.mOffset = -r24;
        return true;
    L46:
        int r25 = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(r15);
        if (r25 >= 0) goto L50;
        r11.mOffset = r25;
        return true;
    L50:
        r11.mOffset = Integer.MIN_VALUE;
        goto L59
    L25:
        r18 = getFirstChildPosition();
        goto L26
    L15:
        if (r14.mAnchorPosition == (-1)) goto L20;
        if (r14.mSpanOffsetsSize < 1) goto L20;
        r11.mOffset = Integer.MIN_VALUE;
        r11.mPosition = this.mPendingScrollPosition;
    L61:
        return false;
    }

    void updateAnchorInfoForLayout(RecyclerView.State r10, AnchorInfo r11) {
        if (updateAnchorFromPendingData(r10, r11) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildren(r10, r11) == false) goto L8;
        return;
    L8:
        r11.assignCoordinateFromPadding();
        r11.mPosition = 0;
    }

    void updateMeasureSpecs(int r10) {
        this.mSizePerSpan = r10 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(r10, this.mSecondaryOrientation.getMode());
    }
}

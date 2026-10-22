package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2.OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;

    @NonNull
    private final LinearLayoutManager mLayoutManager;

    @NonNull
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;

    @NonNull
    private final ViewPager2 mViewPager;

    private static final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        ScrollEventValues() {
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }

    ScrollEventAdapter(@NonNull ViewPager2 r10) {
        this.mViewPager = r10;
        RecyclerView r11 = r10.mRecyclerView;
        this.mRecyclerView = r11;
        this.mLayoutManager = (LinearLayoutManager) r11.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int r10, float r11, int r12) {
        ViewPager2.OnPageChangeCallback r13 = this.mCallback;
        if (r13 == null) goto L6;
        r13.onPageScrolled(r10, r11, r12);
        return;
    }

    private void dispatchSelected(int r10) {
        ViewPager2.OnPageChangeCallback r11 = this.mCallback;
        if (r11 == null) goto L6;
        r11.onPageSelected(r10);
        return;
    }

    private void dispatchStateChanged(int r10) {
        if (this.mAdapterState != 3) goto L8;
        if (this.mScrollState != 0) goto L8;
        return;
    L8:
        if (this.mScrollState != r10) goto L10;
        return;
    L10:
        this.mScrollState = r10;
        ViewPager2.OnPageChangeCallback r11 = this.mCallback;
        if (r11 == null) goto L14;
        r11.onPageScrollStateChanged(r10);
        return;
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int r10 = this.mAdapterState;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean r10) {
        this.mFakeDragging = r10;
        if (r10 == false) goto L5;
        int r11 = 4;
    L6:
        this.mAdapterState = r11;
        int r12 = this.mTarget;
        if (r12 == (-1)) goto L10;
        this.mDragStartPosition = r12;
        this.mTarget = -1;
    L12:
        dispatchStateChanged(1);
        return;
    L10:
        if (this.mDragStartPosition != (-1)) goto L12;
        this.mDragStartPosition = getPosition();
        goto L12
    L5:
        r11 = 1;
        goto L6
    }

    private void updateScrollEventValues() {
        ScrollEventValues r10 = this.mScrollValues;
        int r11 = this.mLayoutManager.findFirstVisibleItemPosition();
        r10.mPosition = r11;
        if (r11 != (-1)) goto L6;
        r10.reset();
        return;
    L6:
        View r12 = this.mLayoutManager.findViewByPosition(r11);
        if (r12 != null) goto L10;
        r10.reset();
        return;
    L10:
        int r13 = this.mLayoutManager.getLeftDecorationWidth(r12);
        int r14 = this.mLayoutManager.getRightDecorationWidth(r12);
        int r15 = this.mLayoutManager.getTopDecorationHeight(r12);
        int r16 = this.mLayoutManager.getBottomDecorationHeight(r12);
        ViewGroup.LayoutParams r17 = r12.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        r13 = r13 + r18.leftMargin;
        r14 = r14 + r18.rightMargin;
        r15 = r15 + r18.topMargin;
        r16 = r16 + r18.bottomMargin;
    L13:
        int r19 = (r12.getHeight() + r15) + r16;
        int r20 = (r12.getWidth() + r13) + r14;
        if (this.mLayoutManager.getOrientation() != 0) goto L16;
        boolean r21 = true;
    L17:
        if (r21 == false) goto L22;
        int r22 = (r12.getLeft() - r13) - this.mRecyclerView.getPaddingLeft();
        if (this.mViewPager.isRtl() == false) goto L21;
        r22 = -r22;
    L21:
        r19 = r20;
    L23:
        int r23 = -r22;
        r10.mOffsetPx = r23;
        if (r23 < 0) goto L26;
        if (r19 != 0) goto L33;
        float r24 = 0.0f;
    L34:
        r10.mOffset = r24;
        return;
    L33:
        r24 = r23 / r19;
        goto L34
    L26:
        if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations() == false) goto L30;
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
    L30:
        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(r10.mOffsetPx)}));
    L22:
        r22 = (r12.getTop() - r15) - this.mRecyclerView.getPaddingTop();
        goto L23
    L16:
        r21 = false;
        goto L17
    }

    double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventValues r10 = this.mScrollValues;
        return ((double) r10.mPosition) + ((double) r10.mOffset);
    }

    int getScrollState() {
        return this.mScrollState;
    }

    boolean isDragging() {
        if (this.mScrollState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    boolean isIdle() {
        if (this.mScrollState != 0) goto L5;
        return true;
    L5:
        return false;
    }

    void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    void notifyEndFakeDrag() {
        if (isDragging() == true) goto L5;
    L7:
        this.mFakeDragging = false;
        updateScrollEventValues();
        ScrollEventValues r10 = this.mScrollValues;
        if (r10.mOffsetPx != 0) goto L13;
        int r11 = r10.mPosition;
        if (r11 == this.mDragStartPosition) goto L12;
        dispatchSelected(r11);
    L12:
        dispatchStateChanged(0);
        resetState();
        return;
    L13:
        dispatchStateChanged(2);
        return;
    L5:
        if (this.mFakeDragging == true) goto L7;
    }

    void notifyProgrammaticScroll(int r10, boolean r11) {
        if (r11 == false) goto L5;
        int r12 = 2;
    L6:
        this.mAdapterState = r12;
        boolean r13 = false;
        this.mFakeDragging = false;
        if (this.mTarget == r10) goto L9;
        r13 = true;
    L9:
        this.mTarget = r10;
        dispatchStateChanged(2);
        if (r13 == false) goto L13;
        dispatchSelected(r10);
        return;
    L13:
        return;
    L5:
        r12 = 3;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView r10, int r11) {
        boolean r12 = true;
        if (this.mAdapterState == 1) goto L5;
    L6:
        if (r11 != 1) goto L10;
        startDrag(false);
        return;
    L10:
        if (isInAnyDraggingState() == false) goto L17;
        if (r11 != 2) goto L17;
        if (this.mScrollHappened == false) goto L46;
        dispatchStateChanged(2);
        this.mDispatchSelected = true;
        return;
    L46:
        return;
    L17:
        if (isInAnyDraggingState() == false) goto L33;
        if (r11 != 0) goto L33;
        updateScrollEventValues();
        if (this.mScrollHappened == true) goto L24;
        int r13 = this.mScrollValues.mPosition;
        if (r13 == (-1)) goto L30;
        dispatchScrolled(r13, 0.0f, 0);
    L30:
        if (r12 == false) goto L33;
        dispatchStateChanged(0);
        resetState();
        goto L33
    L24:
        ScrollEventValues r14 = this.mScrollValues;
        if (r14.mOffsetPx != 0) goto L29;
        int r15 = this.mDragStartPosition;
        int r16 = r14.mPosition;
        if (r15 == r16) goto L30;
        dispatchSelected(r16);
        goto L30
    L29:
        r12 = false;
    L33:
        if (this.mAdapterState != 2) goto L47;
        if (r11 == 0) goto L36;
        return;
    L36:
        if (this.mDataSetChangeHappened == false) goto L49;
        updateScrollEventValues();
        ScrollEventValues r17 = this.mScrollValues;
        if (r17.mOffsetPx != 0) goto L50;
        int r18 = this.mTarget;
        int r19 = r17.mPosition;
        if (r18 == r19) goto L44;
        if (r19 != (-1)) goto L43;
        r19 = 0;
    L43:
        dispatchSelected(r19);
    L44:
        dispatchStateChanged(0);
        resetState();
        return;
    L50:
        return;
    L49:
        return;
    L47:
        return;
    L5:
        if (this.mScrollState == 1) goto L10;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView r10, int r11, int r12) {
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected == false) goto L24;
        this.mDispatchSelected = false;
        if (r12 > 0) goto L14;
        if (r12 != 0) goto L13;
        if (r11 >= 0) goto L9;
        boolean r13 = true;
    L11:
        if (r13 != this.mViewPager.isRtl()) goto L13;
    L9:
        r13 = false;
    L13:
        boolean r14 = false;
    L15:
        if (r14 == false) goto L19;
        ScrollEventValues r15 = this.mScrollValues;
        if (r15.mOffsetPx == 0) goto L19;
        int r16 = r15.mPosition + 1;
    L20:
        this.mTarget = r16;
        if (this.mDragStartPosition != r16) goto L28;
    L29:
        ScrollEventValues r17 = this.mScrollValues;
        int r18 = r17.mPosition;
        if (r18 != (-1)) goto L32;
        r18 = 0;
    L32:
        dispatchScrolled(r18, r17.mOffset, r17.mOffsetPx);
        ScrollEventValues r19 = this.mScrollValues;
        int r20 = r19.mPosition;
        int r21 = this.mTarget;
        if (r20 == r21) goto L36;
        if (r21 == (-1)) goto L36;
        return;
    L36:
        if (r19.mOffsetPx == 0) goto L38;
        return;
    L38:
        if (this.mScrollState == 1) goto L43;
        dispatchStateChanged(0);
        resetState();
        return;
    L43:
        return;
    L28:
        dispatchSelected(r16);
    L19:
        r16 = this.mScrollValues.mPosition;
    L14:
        r14 = true;
        goto L15
    L24:
        if (this.mAdapterState != 0) goto L29;
        r16 = this.mScrollValues.mPosition;
        if (r16 != (-1)) goto L28;
        r16 = 0;
        goto L28
    }

    void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback r10) {
        this.mCallback = r10;
    }
}

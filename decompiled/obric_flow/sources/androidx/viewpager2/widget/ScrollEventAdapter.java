package androidx.viewpager2.widget;

import ai.j0;
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

    public static final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        public ScrollEventValues() {
        }

        public void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 r5) {
        this.mViewPager = r5;
        RecyclerView r10 = r5.mRecyclerView;
        this.mRecyclerView = r10;
        this.mLayoutManager = (LinearLayoutManager) r10.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int r5, float r10, int r11) {
        ViewPager2.OnPageChangeCallback r12 = this.mCallback;
        if (r12 == null) goto L6;
        r12.onPageScrolled(r5, r10, r11);
        return;
    }

    private void dispatchSelected(int r5) {
        ViewPager2.OnPageChangeCallback r10 = this.mCallback;
        if (r10 == null) goto L6;
        r10.onPageSelected(r5);
        return;
    }

    private void dispatchStateChanged(int r5) {
        if (this.mAdapterState != 3) goto L8;
        if (this.mScrollState != 0) goto L8;
        return;
    L8:
        if (this.mScrollState != r5) goto L10;
        return;
    L10:
        this.mScrollState = r5;
        ViewPager2.OnPageChangeCallback r10 = this.mCallback;
        if (r10 == null) goto L14;
        r10.onPageScrollStateChanged(r5);
        return;
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int r5 = this.mAdapterState;
        if (r5 != 1) goto L5;
        return true;
    L5:
        if (r5 == 4) goto L10;
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

    private void startDrag(boolean r5) {
        this.mFakeDragging = r5;
        if (r5 == false) goto L5;
        int r10 = 4;
    L6:
        this.mAdapterState = r10;
        int r11 = this.mTarget;
        if (r11 == (-1)) goto L10;
        this.mDragStartPosition = r11;
        this.mTarget = -1;
    L12:
        dispatchStateChanged(1);
        return;
    L10:
        if (this.mDragStartPosition != (-1)) goto L12;
        this.mDragStartPosition = getPosition();
        goto L12
    L5:
        r10 = 1;
        goto L6
    }

    private void updateScrollEventValues() {
        ScrollEventValues r5 = this.mScrollValues;
        int r10 = this.mLayoutManager.findFirstVisibleItemPosition();
        r5.mPosition = r10;
        if (r10 != (-1)) goto L6;
        r5.reset();
        return;
    L6:
        View r11 = this.mLayoutManager.findViewByPosition(r10);
        if (r11 != null) goto L10;
        r5.reset();
        return;
    L10:
        int r12 = this.mLayoutManager.getLeftDecorationWidth(r11);
        int r13 = this.mLayoutManager.getRightDecorationWidth(r11);
        int r14 = this.mLayoutManager.getTopDecorationHeight(r11);
        int r15 = this.mLayoutManager.getBottomDecorationHeight(r11);
        ViewGroup.LayoutParams r16 = r11.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        r12 = r12 + r17.leftMargin;
        r13 = r13 + r17.rightMargin;
        r14 = r14 + r17.topMargin;
        r15 = r15 + r17.bottomMargin;
    L13:
        int r18 = (r11.getHeight() + r14) + r15;
        int r19 = (r11.getWidth() + r12) + r13;
        if (this.mLayoutManager.getOrientation() != 0) goto L19;
        int r20 = (r11.getLeft() - r12) - this.mRecyclerView.getPaddingLeft();
        if (this.mViewPager.isRtl() == false) goto L18;
        r20 = -r20;
    L18:
        r18 = r19;
    L20:
        int r21 = -r20;
        r5.mOffsetPx = r21;
        if (r21 < 0) goto L23;
        if (r18 != 0) goto L30;
        float r22 = 0.0f;
    L31:
        r5.mOffset = r22;
        return;
    L30:
        r22 = r21 / r18;
        goto L31
    L23:
        if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations() == true) goto L25;
        Locale r23 = Locale.US;
        throw new IllegalStateException(j0.g(r5.mOffsetPx, "Page can only be offset by a positive amount, not by "));
    L25:
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
    L19:
        r20 = (r11.getTop() - r14) - this.mRecyclerView.getPaddingTop();
        goto L20
    }

    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventValues r5 = this.mScrollValues;
        return ((double) r5.mPosition) + ((double) r5.mOffset);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isDragging() {
        if (this.mScrollState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public boolean isIdle() {
        if (this.mScrollState != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    public void notifyEndFakeDrag() {
        if (isDragging() == true) goto L5;
    L7:
        this.mFakeDragging = false;
        updateScrollEventValues();
        ScrollEventValues r5 = this.mScrollValues;
        if (r5.mOffsetPx != 0) goto L13;
        int r10 = r5.mPosition;
        if (r10 == this.mDragStartPosition) goto L12;
        dispatchSelected(r10);
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

    public void notifyProgrammaticScroll(int r5, boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 2;
    L6:
        this.mAdapterState = r11;
        boolean r12 = false;
        this.mFakeDragging = false;
        if (this.mTarget == r5) goto L9;
        r12 = true;
    L9:
        this.mTarget = r5;
        dispatchStateChanged(2);
        if (r12 == false) goto L13;
        dispatchSelected(r5);
        return;
    L13:
        return;
    L5:
        r11 = 3;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView r5, int r10) {
        if (this.mAdapterState == 1) goto L5;
    L6:
        if (r10 != 1) goto L10;
        startDrag(false);
        return;
    L10:
        if (isInAnyDraggingState() == false) goto L17;
        if (r10 != 2) goto L17;
        if (this.mScrollHappened == false) goto L44;
        dispatchStateChanged(2);
        this.mDispatchSelected = true;
        return;
    L44:
        return;
    L17:
        if (isInAnyDraggingState() == false) goto L31;
        if (r10 != 0) goto L31;
        updateScrollEventValues();
        if (this.mScrollHappened == true) goto L24;
        int r11 = this.mScrollValues.mPosition;
        if (r11 == (-1)) goto L29;
        dispatchScrolled(r11, 0.0f, 0);
    L29:
        dispatchStateChanged(0);
        resetState();
        goto L31
    L24:
        ScrollEventValues r12 = this.mScrollValues;
        if (r12.mOffsetPx != 0) goto L31;
        int r13 = this.mDragStartPosition;
        int r14 = r12.mPosition;
        if (r13 == r14) goto L29;
        dispatchSelected(r14);
    L31:
        if (this.mAdapterState != 2) goto L45;
        if (r10 == 0) goto L34;
        return;
    L34:
        if (this.mDataSetChangeHappened == false) goto L47;
        updateScrollEventValues();
        ScrollEventValues r15 = this.mScrollValues;
        if (r15.mOffsetPx != 0) goto L48;
        int r16 = this.mTarget;
        int r17 = r15.mPosition;
        if (r16 == r17) goto L42;
        if (r17 != (-1)) goto L41;
        r17 = 0;
    L41:
        dispatchSelected(r17);
    L42:
        dispatchStateChanged(0);
        resetState();
        return;
    L48:
        return;
    L47:
        return;
    L45:
        return;
    L5:
        if (this.mScrollState == 1) goto L10;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView r5, int r10, int r11) {
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected == false) goto L20;
        this.mDispatchSelected = false;
        if (r11 > 0) goto L12;
        if (r11 != 0) goto L15;
        if (r10 >= 0) goto L9;
        boolean r12 = true;
    L11:
        if (r12 != this.mViewPager.isRtl()) goto L15;
    L9:
        r12 = false;
    L15:
        int r13 = this.mScrollValues.mPosition;
    L16:
        this.mTarget = r13;
        if (this.mDragStartPosition == r13) goto L25;
        dispatchSelected(r13);
    L25:
        ScrollEventValues r14 = this.mScrollValues;
        int r15 = r14.mPosition;
        if (r15 != (-1)) goto L28;
        r15 = 0;
    L28:
        dispatchScrolled(r15, r14.mOffset, r14.mOffsetPx);
        ScrollEventValues r16 = this.mScrollValues;
        int r17 = r16.mPosition;
        int r18 = this.mTarget;
        if (r17 == r18) goto L32;
        if (r18 == (-1)) goto L32;
        return;
    L32:
        if (r16.mOffsetPx == 0) goto L34;
        return;
    L34:
        if (this.mScrollState == 1) goto L39;
        dispatchStateChanged(0);
        resetState();
        return;
    L39:
        return;
    L12:
        ScrollEventValues r19 = this.mScrollValues;
        if (r19.mOffsetPx == 0) goto L15;
        r13 = r19.mPosition + 1;
        goto L16
    L20:
        if (this.mAdapterState != 0) goto L25;
        int r20 = this.mScrollValues.mPosition;
        if (r20 != (-1)) goto L24;
        r20 = 0;
    L24:
        dispatchSelected(r20);
        goto L25
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback r5) {
        this.mCallback = r5;
    }
}

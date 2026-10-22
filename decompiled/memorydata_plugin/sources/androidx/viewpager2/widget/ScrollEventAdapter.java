package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private final LinearLayoutManager mLayoutManager;
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;
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

    ScrollEventAdapter(ViewPager2 r3) {
        this.mViewPager = r3;
        RecyclerView r4 = r3.mRecyclerView;
        this.mRecyclerView = r4;
        this.mLayoutManager = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r4.getLayoutManager(), LinearLayoutManager.class, "com.obric.memorydata.plugin");
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int r1, float r2, int r3) {
        ViewPager2.OnPageChangeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPageScrolled(r1, r2, r3);
        return;
    }

    private void dispatchSelected(int r1) {
        ViewPager2.OnPageChangeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPageSelected(r1);
        return;
    }

    private void dispatchStateChanged(int r3) {
        if (this.mAdapterState != 3) goto L8;
        if (this.mScrollState != 0) goto L8;
        return;
    L8:
        if (this.mScrollState != r3) goto L10;
        return;
    L10:
        this.mScrollState = r3;
        ViewPager2.OnPageChangeCallback r2 = this.mCallback;
        if (r2 == null) goto L14;
        r2.onPageScrollStateChanged(r3);
        return;
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int r2 = this.mAdapterState;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 4) goto L10;
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

    private void startDrag(boolean r3) {
        this.mFakeDragging = r3;
        if (r3 == false) goto L5;
        int r4 = 4;
    L6:
        this.mAdapterState = r4;
        int r5 = this.mTarget;
        if (r5 == (-1)) goto L10;
        this.mDragStartPosition = r5;
        this.mTarget = -1;
    L12:
        dispatchStateChanged(1);
        return;
    L10:
        if (this.mDragStartPosition != (-1)) goto L12;
        this.mDragStartPosition = getPosition();
        goto L12
    L5:
        r4 = 1;
        goto L6
    }

    private void updateScrollEventValues() {
        ScrollEventValues r0 = this.mScrollValues;
        r0.mPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        if (r0.mPosition != (-1)) goto L6;
        r0.reset();
        return;
    L6:
        View r1 = this.mLayoutManager.findViewByPosition(r0.mPosition);
        if (r1 != null) goto L10;
        r0.reset();
        return;
    L10:
        int r2 = this.mLayoutManager.getLeftDecorationWidth(r1);
        int r3 = this.mLayoutManager.getRightDecorationWidth(r1);
        int r4 = this.mLayoutManager.getTopDecorationHeight(r1);
        int r5 = this.mLayoutManager.getBottomDecorationHeight(r1);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L13;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r2 = r2 + r7.leftMargin;
        r3 = r3 + r7.rightMargin;
        r4 = r4 + r7.topMargin;
        r5 = r5 + r7.bottomMargin;
    L13:
        int r8 = (r1.getHeight() + r4) + r5;
        int r9 = (r1.getWidth() + r2) + r3;
        if (this.mLayoutManager.getOrientation() != 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L22;
        int r11 = (r1.getLeft() - r2) - this.mRecyclerView.getPaddingLeft();
        if (this.mViewPager.isRtl() == false) goto L21;
        r11 = -r11;
    L21:
        r8 = r9;
    L23:
        r0.mOffsetPx = -r11;
        if (r0.mOffsetPx < 0) goto L26;
        if (r8 != 0) goto L33;
        float r12 = 0.0f;
    L34:
        r0.mOffset = r12;
        return;
    L33:
        r12 = r0.mOffsetPx / r8;
        goto L34
    L26:
        if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations() == false) goto L30;
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
    L30:
        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(r0.mOffsetPx)}));
    L22:
        r11 = (r1.getTop() - r4) - this.mRecyclerView.getPaddingTop();
        goto L23
    L16:
        r10 = false;
        goto L17
    }

    double getRelativeScrollPosition() {
        updateScrollEventValues();
        return ((double) this.mScrollValues.mPosition) + ((double) this.mScrollValues.mOffset);
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
        if (this.mScrollValues.mOffsetPx == 0) goto L10;
        dispatchStateChanged(2);
        return;
    L10:
        if (this.mScrollValues.mPosition == this.mDragStartPosition) goto L12;
        dispatchSelected(this.mScrollValues.mPosition);
    L12:
        dispatchStateChanged(0);
        resetState();
        return;
    L5:
        if (this.mFakeDragging == true) goto L7;
    }

    void notifyProgrammaticScroll(int r3, boolean r4) {
        if (r4 == false) goto L5;
        int r5 = 2;
    L6:
        this.mAdapterState = r5;
        boolean r6 = false;
        this.mFakeDragging = false;
        if (this.mTarget == r3) goto L9;
        r6 = true;
    L9:
        this.mTarget = r3;
        dispatchStateChanged(2);
        if (r6 == false) goto L13;
        dispatchSelected(r3);
        return;
    L13:
        return;
    L5:
        r5 = 3;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r6, int r7) {
        boolean r1 = true;
        if (this.mAdapterState == 1) goto L5;
    L6:
        if (r7 != 1) goto L10;
        startDrag(false);
        return;
    L10:
        if (isInAnyDraggingState() == false) goto L17;
        if (r7 != 2) goto L17;
        if (this.mScrollHappened == false) goto L48;
        dispatchStateChanged(2);
        this.mDispatchSelected = true;
        return;
    L48:
        return;
    L17:
        if (isInAnyDraggingState() == false) goto L33;
        if (r7 != 0) goto L33;
        updateScrollEventValues();
        if (this.mScrollHappened == true) goto L25;
        if (this.mScrollValues.mPosition == (-1)) goto L30;
        dispatchScrolled(this.mScrollValues.mPosition, 0.0f, 0);
    L30:
        if (r1 == false) goto L33;
        dispatchStateChanged(0);
        resetState();
        goto L33
    L25:
        if (this.mScrollValues.mOffsetPx == 0) goto L27;
        r1 = false;
        goto L30
    L27:
        if (this.mDragStartPosition == this.mScrollValues.mPosition) goto L30;
        dispatchSelected(this.mScrollValues.mPosition);
    L33:
        if (this.mAdapterState != 2) goto L49;
        if (r7 == 0) goto L36;
        return;
    L36:
        if (this.mDataSetChangeHappened == false) goto L51;
        updateScrollEventValues();
        if (this.mScrollValues.mOffsetPx == 0) goto L40;
        return;
    L40:
        if (this.mTarget != this.mScrollValues.mPosition) goto L42;
    L46:
        dispatchStateChanged(0);
        resetState();
        return;
    L42:
        if (this.mScrollValues.mPosition != (-1)) goto L44;
        int r8 = 0;
    L45:
        dispatchSelected(r8);
        goto L46
    L44:
        r8 = this.mScrollValues.mPosition;
        goto L45
    L51:
        return;
    L49:
        return;
    L5:
        if (this.mScrollState == 1) goto L10;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r4, int r5, int r6) {
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected == false) goto L24;
        this.mDispatchSelected = false;
        if (r6 > 0) goto L14;
        if (r6 != 0) goto L13;
        if (r5 >= 0) goto L9;
        boolean r7 = true;
    L11:
        if (r7 != this.mViewPager.isRtl()) goto L13;
    L9:
        r7 = false;
    L13:
        boolean r8 = false;
    L15:
        if (r8 == true) goto L17;
    L19:
        int r9 = this.mScrollValues.mPosition;
    L20:
        this.mTarget = r9;
        if (this.mDragStartPosition == r9) goto L30;
    L28:
        dispatchSelected(r9);
    L30:
        if (this.mScrollValues.mPosition != (-1)) goto L32;
        int r10 = 0;
    L33:
        dispatchScrolled(r10, this.mScrollValues.mOffset, this.mScrollValues.mOffsetPx);
        int r11 = this.mScrollValues.mPosition;
        int r12 = this.mTarget;
        if (r11 == r12) goto L37;
        if (r12 == (-1)) goto L37;
        return;
    L37:
        if (this.mScrollValues.mOffsetPx == 0) goto L39;
        return;
    L39:
        if (this.mScrollState == 1) goto L44;
        dispatchStateChanged(0);
        resetState();
        return;
    L44:
        return;
    L32:
        r10 = this.mScrollValues.mPosition;
        goto L33
    L17:
        if (this.mScrollValues.mOffsetPx == 0) goto L19;
        r9 = this.mScrollValues.mPosition + 1;
    L14:
        r8 = true;
        goto L15
    L24:
        if (this.mAdapterState != 0) goto L30;
        r9 = this.mScrollValues.mPosition;
        if (r9 != (-1)) goto L28;
        r9 = 0;
        goto L28
    }

    void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback r1) {
        this.mCallback = r1;
    }
}

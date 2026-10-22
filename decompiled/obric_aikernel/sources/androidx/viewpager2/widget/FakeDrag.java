package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    FakeDrag(ViewPager2 r10, ScrollEventAdapter r11, RecyclerView r12) {
        this.mViewPager = r10;
        this.mScrollEventAdapter = r11;
        this.mRecyclerView = r12;
    }

    private void addFakeMotionEvent(long r10, int r11, float r12, float r13) {
        MotionEvent r14 = MotionEvent.obtain(this.mFakeDragBeginTime, r10, r11, r12, r13, 0);
        this.mVelocityTracker.addMovement(r14);
        r14.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
        return;
    L5:
        r10.clear();
    }

    @UiThread
    boolean beginFakeDrag() {
        if (this.mScrollEventAdapter.isDragging() == false) goto L5;
        return false;
    L5:
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if (this.mScrollEventAdapter.isIdle() == true) goto L8;
        this.mRecyclerView.stopScroll();
    L8:
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    boolean endFakeDrag() {
        if (this.mScrollEventAdapter.isFakeDragging() == true) goto L6;
        return false;
    L6:
        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker r10 = this.mVelocityTracker;
        r10.computeCurrentVelocity(1000, this.mMaximumVelocity);
        if (this.mRecyclerView.fling((int) r10.getXVelocity(), (int) r10.getYVelocity()) == true) goto L11;
        this.mViewPager.snapToPage();
        return true;
    L11:
        return true;
    }

    @UiThread
    boolean fakeDragBy(float r10) {
        int r11 = 0;
        if (this.mScrollEventAdapter.isFakeDragging() == true) goto L5;
        return false;
    L5:
        float r12 = this.mRequestedDragDistance - r10;
        this.mRequestedDragDistance = r12;
        int r13 = Math.round(r12 - this.mActualDraggedDistance);
        this.mActualDraggedDistance += r13;
        long r14 = SystemClock.uptimeMillis();
        if (this.mViewPager.getOrientation() != 0) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == false) goto L11;
        int r16 = r13;
    L12:
        if (r15 == true) goto L15;
        r11 = r13;
    L15:
        float r17 = 0.0f;
        if (r15 == false) goto L18;
        float r18 = this.mRequestedDragDistance;
    L19:
        if (r15 == true) goto L22;
        r17 = this.mRequestedDragDistance;
    L22:
        this.mRecyclerView.scrollBy(r16, r11);
        addFakeMotionEvent(r14, 2, r18, r17);
        return true;
    L18:
        r18 = 0.0f;
        goto L19
    L11:
        r16 = 0;
        goto L12
    L8:
        r15 = false;
        goto L9
    }

    boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}

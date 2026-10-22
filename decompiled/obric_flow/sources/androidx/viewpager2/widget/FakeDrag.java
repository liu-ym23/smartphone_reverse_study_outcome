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

    public FakeDrag(ViewPager2 r5, ScrollEventAdapter r10, RecyclerView r11) {
        this.mViewPager = r5;
        this.mScrollEventAdapter = r10;
        this.mRecyclerView = r11;
    }

    private void addFakeMotionEvent(long r10, int r11, float r12, float r13) {
        MotionEvent r14 = MotionEvent.obtain(this.mFakeDragBeginTime, r10, r11, r12, r13, 0);
        this.mVelocityTracker.addMovement(r14);
        r14.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
        return;
    L5:
        r5.clear();
    }

    @UiThread
    public boolean beginFakeDrag() {
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
    public boolean endFakeDrag() {
        if (this.mScrollEventAdapter.isFakeDragging() == true) goto L6;
        return false;
    L6:
        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker r5 = this.mVelocityTracker;
        r5.computeCurrentVelocity(1000, this.mMaximumVelocity);
        if (this.mRecyclerView.fling((int) r5.getXVelocity(), (int) r5.getYVelocity()) == true) goto L11;
        this.mViewPager.snapToPage();
        return true;
    L11:
        return true;
    }

    @UiThread
    public boolean fakeDragBy(float r10) {
        int r5 = 0;
        if (this.mScrollEventAdapter.isFakeDragging() == true) goto L5;
        return false;
    L5:
        float r11 = this.mRequestedDragDistance - r10;
        this.mRequestedDragDistance = r11;
        int r12 = Math.round(r11 - this.mActualDraggedDistance);
        this.mActualDraggedDistance += r12;
        long r13 = SystemClock.uptimeMillis();
        if (this.mViewPager.getOrientation() != 0) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L11;
        int r15 = r12;
    L12:
        if (r14 == true) goto L15;
        r5 = r12;
    L15:
        float r16 = 0.0f;
        if (r14 == false) goto L18;
        float r17 = this.mRequestedDragDistance;
    L19:
        if (r14 == false) goto L21;
    L20:
        float r18 = r16;
        this.mRecyclerView.scrollBy(r15, r5);
        addFakeMotionEvent(r13, 2, r17, r18);
        return true;
    L21:
        r16 = this.mRequestedDragDistance;
        goto L20
    L18:
        r17 = 0.0f;
        goto L19
    L11:
        r15 = 0;
        goto L12
    L8:
        r14 = false;
        goto L9
    }

    public boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}

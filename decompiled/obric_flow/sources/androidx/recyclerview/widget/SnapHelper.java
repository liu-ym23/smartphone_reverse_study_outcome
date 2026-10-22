package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public SnapHelper() {
        this.mScrollListener = new AnonymousClass1(this);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() != null) goto L7;
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
        return;
    L7:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean snapFromFling(@NonNull RecyclerView.LayoutManager r5, int r10, int r11) {
        if ((r5 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return false;
    L5:
        RecyclerView.SmoothScroller r12 = createScroller(r5);
        if (r12 != null) goto L8;
        return false;
    L8:
        int r13 = findTargetSnapPosition(r5, r10, r11);
        if (r13 != (-1)) goto L11;
        return false;
    L11:
        r12.setTargetPosition(r13);
        r5.startSmoothScroll(r12);
        return true;
    }

    public void attachToRecyclerView(@Nullable RecyclerView r5) throws IllegalStateException {
        RecyclerView r10 = this.mRecyclerView;
        if (r10 != r5) goto L5;
        return;
    L5:
        if (r10 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r5;
        if (r5 == null) goto L11;
        setupCallbacks();
        this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
        snapToTargetExistingView();
        return;
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager r5, @NonNull View r10);

    @SuppressLint({"UnknownNullness"})
    public int[] calculateScrollDistance(int r10, int r11) {
        this.mGravityScroller.fling(0, 0, r10, r11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    @Nullable
    public RecyclerView.SmoothScroller createScroller(@NonNull RecyclerView.LayoutManager r5) {
        return createSnapScroller(r5);
    }

    @Nullable
    @Deprecated
    public LinearSmoothScroller createSnapScroller(@NonNull RecyclerView.LayoutManager r5) {
        if ((r5 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L6;
        return null;
    L6:
        final Context r10 = this.mRecyclerView.getContext();
        return new AnonymousClass2(this, r10);
    }

    @Nullable
    @SuppressLint({"UnknownNullness"})
    public abstract View findSnapView(RecyclerView.LayoutManager r5);

    @SuppressLint({"UnknownNullness"})
    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager r5, int r10, int r11);

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int r5, int r10) {
        RecyclerView.LayoutManager r11 = this.mRecyclerView.getLayoutManager();
        if (r11 != null) goto L6;
        return false;
    L6:
        if (this.mRecyclerView.getAdapter() != null) goto L8;
        return false;
    L8:
        int r12 = this.mRecyclerView.getMinFlingVelocity();
        if (Math.abs(r10) > r12) goto L13;
        if (Math.abs(r5) > r12) goto L13;
        return false;
    L13:
        if (snapFromFling(r11, r5, r10) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public void snapToTargetExistingView() {
        RecyclerView r5 = this.mRecyclerView;
        if (r5 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r10 = r5.getLayoutManager();
        if (r10 != null) goto L8;
        return;
    L8:
        View r11 = findSnapView(r10);
        if (r11 != null) goto L11;
        return;
    L11:
        int[] r12 = calculateDistanceToFinalSnap(r10, r11);
        int r13 = r12[0];
        if (r13 == 0) goto L14;
    L15:
        this.mRecyclerView.smoothScrollBy(r13, r12[1]);
        return;
    L14:
        if (r12[1] != 0) goto L15;
    }
}

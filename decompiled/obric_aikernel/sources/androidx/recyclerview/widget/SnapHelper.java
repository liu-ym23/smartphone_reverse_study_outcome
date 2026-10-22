package androidx.recyclerview.widget;

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

    private void setupCallbacks() {
        if (this.mRecyclerView.getOnFlingListener() != null) goto L7;
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
        return;
    L7:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean snapFromFling(@NonNull RecyclerView.LayoutManager r10, int r11, int r12) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return false;
    L5:
        RecyclerView.SmoothScroller r13 = createScroller(r10);
        if (r13 != null) goto L8;
        return false;
    L8:
        int r14 = findTargetSnapPosition(r10, r11, r12);
        if (r14 != (-1)) goto L11;
        return false;
    L11:
        r13.setTargetPosition(r14);
        r10.startSmoothScroll(r13);
        return true;
    }

    public void attachToRecyclerView(@Nullable RecyclerView r10) {
        RecyclerView r11 = this.mRecyclerView;
        if (r11 != r10) goto L5;
        return;
    L5:
        if (r11 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r10;
        if (r10 == null) goto L11;
        setupCallbacks();
        this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
        snapToTargetExistingView();
        return;
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager r10, @NonNull View r11);

    public int[] calculateScrollDistance(int r11, int r12) {
        this.mGravityScroller.fling(0, 0, r11, r12, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    @Nullable
    protected RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager r10) {
        return createSnapScroller(r10);
    }

    @Nullable
    @Deprecated
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r10) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L6;
        return null;
    L6:
        final Context r11 = this.mRecyclerView.getContext();
        return new AnonymousClass2(this, r11);
    }

    @Nullable
    public abstract View findSnapView(RecyclerView.LayoutManager r10);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager r10, int r11, int r12);

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int r10, int r11) {
        RecyclerView.LayoutManager r12 = this.mRecyclerView.getLayoutManager();
        if (r12 != null) goto L6;
        return false;
    L6:
        if (this.mRecyclerView.getAdapter() != null) goto L8;
        return false;
    L8:
        int r13 = this.mRecyclerView.getMinFlingVelocity();
        if (Math.abs(r11) > r13) goto L13;
        if (Math.abs(r10) > r13) goto L13;
        return false;
    L13:
        if (snapFromFling(r12, r10, r11) == false) goto L17;
        return true;
    L17:
        return false;
    }

    void snapToTargetExistingView() {
        RecyclerView r10 = this.mRecyclerView;
        if (r10 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r11 = r10.getLayoutManager();
        if (r11 != null) goto L8;
        return;
    L8:
        View r12 = findSnapView(r11);
        if (r12 != null) goto L11;
        return;
    L11:
        int[] r13 = calculateDistanceToFinalSnap(r11, r12);
        if (r13[0] == 0) goto L14;
    L15:
        this.mRecyclerView.smoothScrollBy(r13[0], r13[1]);
        return;
    L14:
        if (r13[1] != 0) goto L15;
    }
}

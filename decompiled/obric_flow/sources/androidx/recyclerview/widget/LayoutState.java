package androidx.recyclerview.widget;

import ai.j0;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class LayoutState {
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    int mAvailable;
    int mCurrentPosition;
    int mEndLine;
    boolean mInfinite;
    int mItemDirection;
    int mLayoutDirection;
    boolean mRecycle;
    int mStartLine;
    boolean mStopInFocusable;

    public LayoutState() {
        this.mRecycle = true;
        this.mStartLine = 0;
        this.mEndLine = 0;
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

    public View next(RecyclerView.Recycler r5) {
        View r10 = r5.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return r10;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("LayoutState{mAvailable=");
        r5.append(this.mAvailable);
        r5.append(", mCurrentPosition=");
        r5.append(this.mCurrentPosition);
        r5.append(", mItemDirection=");
        r5.append(this.mItemDirection);
        r5.append(", mLayoutDirection=");
        r5.append(this.mLayoutDirection);
        r5.append(", mStartLine=");
        r5.append(this.mStartLine);
        r5.append(", mEndLine=");
        return j0.n(r5, this.mEndLine, '}');
    }
}

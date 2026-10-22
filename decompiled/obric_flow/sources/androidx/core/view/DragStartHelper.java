package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final OnDragStartListener mListener;
    private final View.OnLongClickListener mLongClickListener;
    private final View.OnTouchListener mTouchListener;
    private final View mView;

    public interface OnDragStartListener {
        boolean onDragStart(@NonNull View r5, @NonNull DragStartHelper r10);
    }

    public DragStartHelper(@NonNull View r5, @NonNull OnDragStartListener r10) {
        this.mLongClickListener = new c(this);
        this.mTouchListener = new d(this);
        this.mView = r5;
        this.mListener = r10;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(@NonNull Point r5) {
        r5.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(@NonNull View r5) {
        if (this.mDragging == false) goto L6;
        return true;
    L6:
        boolean r10 = this.mListener.onDragStart(r5, this);
        this.mDragging = r10;
        return r10;
    }

    public boolean onTouch(@NonNull View r10, @NonNull MotionEvent r11) {
        int r5 = (int) r11.getX();
        int r12 = (int) r11.getY();
        int r13 = r11.getAction();
        if (r13 != 0) goto L5;
        this.mLastTouchX = r5;
        this.mLastTouchY = r12;
    L28:
        return false;
    L5:
        if (r13 != 1) goto L7;
    L26:
        this.mDragging = false;
        goto L28
    L7:
        if (r13 == 2) goto L12;
        if (r13 == 3) goto L26;
    L12:
        if (MotionEventCompat.isFromSource(r11, 8194) == false) goto L28;
        if ((r11.getButtonState() & 1) == 0) goto L28;
        if (this.mDragging == true) goto L28;
        if (this.mLastTouchX == r5) goto L22;
    L24:
        this.mLastTouchX = r5;
        this.mLastTouchY = r12;
        boolean r14 = this.mListener.onDragStart(r10, this);
        this.mDragging = r14;
        return r14;
    L22:
        if (this.mLastTouchY != r12) goto L24;
        goto L24
    }
}

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
        boolean onDragStart(@NonNull View r10, @NonNull DragStartHelper r11);
    }

    public DragStartHelper(@NonNull View r10, @NonNull OnDragStartListener r11) {
        this.mLongClickListener = new b(this);
        this.mTouchListener = new c(this);
        this.mView = r10;
        this.mListener = r11;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(@NonNull Point r10) {
        r10.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(@NonNull View r10) {
        return this.mListener.onDragStart(r10, this);
    }

    public boolean onTouch(@NonNull View r10, @NonNull MotionEvent r11) {
        int r12 = (int) r11.getX();
        int r13 = (int) r11.getY();
        int r14 = r11.getAction();
        if (r14 != 0) goto L5;
        this.mLastTouchX = r12;
        this.mLastTouchY = r13;
    L28:
        return false;
    L5:
        if (r14 != 1) goto L7;
    L26:
        this.mDragging = false;
        goto L28
    L7:
        if (r14 == 2) goto L12;
        if (r14 == 3) goto L26;
    L12:
        if (MotionEventCompat.isFromSource(r11, 8194) == false) goto L28;
        if ((r11.getButtonState() & 1) == 0) goto L28;
        if (this.mDragging == true) goto L28;
        if (this.mLastTouchX == r12) goto L22;
    L24:
        this.mLastTouchX = r12;
        this.mLastTouchY = r13;
        boolean r15 = this.mListener.onDragStart(r10, this);
        this.mDragging = r15;
        return r15;
    L22:
        if (this.mLastTouchY != r13) goto L24;
        goto L24
    }
}

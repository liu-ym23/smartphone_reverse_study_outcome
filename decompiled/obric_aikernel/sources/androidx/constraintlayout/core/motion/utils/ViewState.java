package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;

/* JADX INFO: loaded from: classes.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    public ViewState() {
    }

    public void getState(MotionWidget r10) {
        this.left = r10.getLeft();
        this.top = r10.getTop();
        this.right = r10.getRight();
        this.bottom = r10.getBottom();
        this.rotation = (int) r10.getRotationZ();
    }

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}

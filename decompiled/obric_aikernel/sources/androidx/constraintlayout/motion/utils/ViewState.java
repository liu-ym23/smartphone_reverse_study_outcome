package androidx.constraintlayout.motion.utils;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    public ViewState() {
    }

    public void getState(View r10) {
        this.left = r10.getLeft();
        this.top = r10.getTop();
        this.right = r10.getRight();
        this.bottom = r10.getBottom();
        this.rotation = r10.getRotation();
    }

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}

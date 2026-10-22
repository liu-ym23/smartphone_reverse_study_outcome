package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;

    public NestedScrollingParentHelper(@NonNull ViewGroup r5) {
    }

    public int getNestedScrollAxes() {
        int r5 = this.mNestedScrollAxesTouch;
        return this.mNestedScrollAxesNonTouch | r5;
    }

    public void onNestedScrollAccepted(@NonNull View r5, @NonNull View r10, int r11) {
        onNestedScrollAccepted(r5, r10, r11, 0);
    }

    public void onStopNestedScroll(@NonNull View r5) {
        onStopNestedScroll(r5, 0);
    }

    public void onNestedScrollAccepted(@NonNull View r5, @NonNull View r10, int r11, int r12) {
        if (r12 != 1) goto L5;
        this.mNestedScrollAxesNonTouch = r11;
        return;
    L5:
        this.mNestedScrollAxesTouch = r11;
    }

    public void onStopNestedScroll(@NonNull View r5, int r10) {
        if (r10 != 1) goto L5;
        this.mNestedScrollAxesNonTouch = 0;
        return;
    L5:
        this.mNestedScrollAxesTouch = 0;
    }
}

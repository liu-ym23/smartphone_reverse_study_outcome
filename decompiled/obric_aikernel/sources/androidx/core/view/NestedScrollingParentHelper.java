package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;

    public NestedScrollingParentHelper(@NonNull ViewGroup r10) {
    }

    public int getNestedScrollAxes() {
        int r10 = this.mNestedScrollAxesTouch;
        return this.mNestedScrollAxesNonTouch | r10;
    }

    public void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12) {
        onNestedScrollAccepted(r10, r11, r12, 0);
    }

    public void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        if (r13 != 1) goto L5;
        this.mNestedScrollAxesNonTouch = r12;
        return;
    L5:
        this.mNestedScrollAxesTouch = r12;
    }

    public void onStopNestedScroll(@NonNull View r10) {
        onStopNestedScroll(r10, 0);
    }

    public void onStopNestedScroll(@NonNull View r10, int r11) {
        if (r11 != 1) goto L5;
        this.mNestedScrollAxesNonTouch = 0;
        return;
    L5:
        this.mNestedScrollAxesTouch = 0;
    }
}

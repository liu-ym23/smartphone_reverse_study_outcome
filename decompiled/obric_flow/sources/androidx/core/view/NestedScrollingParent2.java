package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View r5, int r10, int r11, @NonNull int[] r12, int r13);

    void onNestedScroll(@NonNull View r5, int r10, int r11, int r12, int r13, int r14);

    void onNestedScrollAccepted(@NonNull View r5, @NonNull View r10, int r11, int r12);

    boolean onStartNestedScroll(@NonNull View r5, @NonNull View r10, int r11, int r12);

    void onStopNestedScroll(@NonNull View r5, int r10);
}

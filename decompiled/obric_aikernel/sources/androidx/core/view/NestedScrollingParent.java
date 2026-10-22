package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View r10, float r11, float r12, boolean r13);

    boolean onNestedPreFling(@NonNull View r10, float r11, float r12);

    void onNestedPreScroll(@NonNull View r10, int r11, int r12, @NonNull int[] r13);

    void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14);

    void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12);

    boolean onStartNestedScroll(@NonNull View r10, @NonNull View r11, int r12);

    void onStopNestedScroll(@NonNull View r10);
}

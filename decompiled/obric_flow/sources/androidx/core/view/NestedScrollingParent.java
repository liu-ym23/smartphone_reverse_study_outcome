package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View r5, float r10, float r11, boolean r12);

    boolean onNestedPreFling(@NonNull View r5, float r10, float r11);

    void onNestedPreScroll(@NonNull View r5, int r10, int r11, @NonNull int[] r12);

    void onNestedScroll(@NonNull View r5, int r10, int r11, int r12, int r13);

    void onNestedScrollAccepted(@NonNull View r5, @NonNull View r10, int r11);

    boolean onStartNestedScroll(@NonNull View r5, @NonNull View r10, int r11);

    void onStopNestedScroll(@NonNull View r5);
}

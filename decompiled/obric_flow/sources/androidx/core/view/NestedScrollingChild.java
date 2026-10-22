package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float r5, float r10, boolean r11);

    boolean dispatchNestedPreFling(float r5, float r10);

    boolean dispatchNestedPreScroll(int r5, int r10, @Nullable int[] r11, @Nullable int[] r12);

    boolean dispatchNestedScroll(int r5, int r10, int r11, int r12, @Nullable int[] r13);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean r5);

    boolean startNestedScroll(int r5);

    void stopNestedScroll();
}

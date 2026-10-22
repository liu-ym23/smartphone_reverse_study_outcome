package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float r10, float r11, boolean r12);

    boolean dispatchNestedPreFling(float r10, float r11);

    boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13);

    boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean r10);

    boolean startNestedScroll(int r10);

    void stopNestedScroll();
}

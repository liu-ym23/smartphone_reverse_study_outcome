package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int r5, int r10, @Nullable int[] r11, @Nullable int[] r12, int r13);

    boolean dispatchNestedScroll(int r5, int r10, int r11, int r12, @Nullable int[] r13, int r14);

    boolean hasNestedScrollingParent(int r5);

    boolean startNestedScroll(int r5, int r10);

    void stopNestedScroll(int r5);
}

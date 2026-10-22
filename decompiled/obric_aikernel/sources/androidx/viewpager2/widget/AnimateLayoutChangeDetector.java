package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS = null;
    private LinearLayoutManager mLayoutManager;

    static {
        ViewGroup.MarginLayoutParams r10 = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = r10;
        r10.setMargins(0, 0, 0, 0);
    }

    AnimateLayoutChangeDetector(@NonNull LinearLayoutManager r10) {
        this.mLayoutManager = r10;
    }

    private boolean arePagesLaidOutContiguously() {
        int r10 = this.mLayoutManager.getChildCount();
        if (r10 != 0) goto L6;
        return true;
    L6:
        if (this.mLayoutManager.getOrientation() != 0) goto L8;
        boolean r11 = true;
    L9:
        int[][] r12 = (int[][]) Array.newInstance(int.class, new int[]{r10, 2});
        int r13 = 0;
    L10:
        if (r13 >= r10) goto L28;
        View r14 = this.mLayoutManager.getChildAt(r13);
        if (r14 == null) goto L27;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
    L17:
        int[] r17 = r12[r13];
        if (r11 == false) goto L20;
        int r18 = r14.getLeft();
        int r19 = r16.leftMargin;
    L21:
        r17[0] = r18 - r19;
        int[] r20 = r12[r13];
        if (r11 == false) goto L24;
        int r21 = r14.getRight();
        int r22 = r16.rightMargin;
    L25:
        r20[1] = r21 + r22;
        r13 = r13 + 1;
        goto L10
    L24:
        r21 = r14.getBottom();
        r22 = r16.bottomMargin;
        goto L25
    L20:
        r18 = r14.getTop();
        r19 = r16.topMargin;
        goto L21
    L16:
        r16 = ZERO_MARGIN_LAYOUT_PARAMS;
        goto L17
    L27:
        throw new IllegalStateException("null view contained in the view hierarchy");
    L28:
        Arrays.sort(r12, new AnonymousClass1(this));
        int r110 = 1;
    L29:
        if (r110 >= r10) goto L34;
        if (r12[r110 - 1][1] != r12[r110][0]) goto L32;
        r110 = r110 + 1;
        goto L29
    L32:
        return false;
    L34:
        int r111 = r12[0][1] - r12[0][0];
        if (r12[0][0] <= 0) goto L37;
    L40:
        return false;
    L37:
        if (r12[r10 - 1][1] < r111) goto L40;
        return true;
    L8:
        r11 = false;
        goto L9
    }

    private boolean hasRunningChangingLayoutTransition() {
        int r10 = this.mLayoutManager.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(r11)) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean hasRunningChangingLayoutTransition(View r10) {
        if ((r10 instanceof ViewGroup) == false) goto L15;
        ViewGroup r11 = (ViewGroup) r10;
        LayoutTransition r12 = r11.getLayoutTransition();
        if (r12 != null) goto L7;
    L9:
        int r13 = r11.getChildCount();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L15;
        if (hasRunningChangingLayoutTransition(r11.getChildAt(r14)) == true) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        return true;
    L7:
        if (r12.isChangingLayout() == false) goto L9;
        return true;
    L15:
        return false;
    }

    boolean mayHaveInterferingAnimations() {
        if (arePagesLaidOutContiguously() == false) goto L7;
        if (this.mLayoutManager.getChildCount() <= 1) goto L7;
    L9:
        return false;
    L7:
        if (hasRunningChangingLayoutTransition() == false) goto L9;
        return true;
    }
}

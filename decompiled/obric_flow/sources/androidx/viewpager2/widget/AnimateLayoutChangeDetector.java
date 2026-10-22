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
        ViewGroup.MarginLayoutParams r5 = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = r5;
        r5.setMargins(0, 0, 0, 0);
    }

    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager r5) {
        this.mLayoutManager = r5;
    }

    private boolean arePagesLaidOutContiguously() {
        int r5 = this.mLayoutManager.getChildCount();
        if (r5 != 0) goto L6;
        return true;
    L6:
        if (this.mLayoutManager.getOrientation() != 0) goto L8;
        boolean r10 = true;
    L9:
        int[][] r11 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r5, 2});
        int r12 = 0;
    L10:
        if (r12 >= r5) goto L30;
        View r13 = this.mLayoutManager.getChildAt(r12);
        if (r13 == null) goto L29;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
    L17:
        int[] r16 = r11[r12];
        if (r10 == false) goto L21;
        int r17 = r13.getLeft();
        int r18 = r15.leftMargin;
    L22:
        r16[0] = r17 - r18;
        int[] r19 = r11[r12];
        if (r10 == false) goto L26;
        int r20 = r13.getRight();
        int r21 = r15.rightMargin;
    L27:
        r19[1] = r20 + r21;
        r12 = r12 + 1;
        goto L10
    L26:
        r20 = r13.getBottom();
        r21 = r15.bottomMargin;
        goto L27
    L21:
        r17 = r13.getTop();
        r18 = r15.topMargin;
        goto L22
    L16:
        r15 = ZERO_MARGIN_LAYOUT_PARAMS;
        goto L17
    L29:
        throw new IllegalStateException("null view contained in the view hierarchy");
    L30:
        Arrays.sort(r11, new AnonymousClass1(this));
        int r110 = 1;
    L31:
        if (r110 >= r5) goto L36;
        if (r11[r110 - 1][1] != r11[r110][0]) goto L34;
        r110 = r110 + 1;
        goto L31
    L34:
        return false;
    L36:
        int[] r111 = r11[0];
        int r22 = r111[1];
        int r112 = r111[0];
        int r23 = r22 - r112;
        if (r112 <= 0) goto L39;
    L42:
        return false;
    L39:
        if (r11[r5 - 1][1] < r23) goto L42;
        return true;
    L8:
        r10 = false;
        goto L9
    }

    private boolean hasRunningChangingLayoutTransition() {
        int r5 = this.mLayoutManager.getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L9;
        if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(r10)) == true) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean mayHaveInterferingAnimations() {
        if (arePagesLaidOutContiguously() == false) goto L7;
        if (this.mLayoutManager.getChildCount() <= 1) goto L7;
    L9:
        return false;
    L7:
        if (hasRunningChangingLayoutTransition() == false) goto L9;
        return true;
    }

    private static boolean hasRunningChangingLayoutTransition(View r5) {
        if ((r5 instanceof ViewGroup) == false) goto L15;
        ViewGroup r10 = (ViewGroup) r5;
        LayoutTransition r11 = r10.getLayoutTransition();
        if (r11 != null) goto L7;
    L9:
        int r12 = r10.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L15;
        if (hasRunningChangingLayoutTransition(r10.getChildAt(r13)) == true) goto L13;
        r13 = r13 + 1;
        goto L10
    L13:
        return true;
    L7:
        if (r11.isChangingLayout() == false) goto L9;
        return true;
    L15:
        return false;
    }
}

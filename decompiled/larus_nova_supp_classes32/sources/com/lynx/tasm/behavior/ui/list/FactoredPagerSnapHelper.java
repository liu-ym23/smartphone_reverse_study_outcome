package com.lynx.tasm.behavior.ui.list;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FactoredPagerSnapHelper extends PagerSnapHelper {
    public UIList.b a;
    public RecyclerView b;
    public double c;
    public int d;
    public OrientationHelper e;
    public OrientationHelper f;

    public FactoredPagerSnapHelper() {
        this.a = null;
        this.b = null;
        this.c = 0.5d;
        this.d = 0;
    }

    public final void attachToRecyclerView(RecyclerView r1) throws IllegalStateException {
        super/*androidx.recyclerview.widget.SnapHelper*/.attachToRecyclerView(r1);
        this.b = r1;
    }

    public final View findSnapView(RecyclerView.LayoutManager r2) {
        if (r2.canScrollVertically() == false) goto L7;
        return b(r2, getVerticalHelper(r2));
    L7:
        if (r2.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return b(r2, getHorizontalHelper(r2));
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r2) {
        OrientationHelper r0 = this.f;
        if (r0 != null) goto L5;
    L6:
        this.f = OrientationHelper.createHorizontalHelper(r2);
    L8:
        return this.f;
    L5:
        if (r0.getLayoutManager() == r2) goto L8;
        goto L6
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r2) {
        OrientationHelper r0 = this.e;
        if (r0 != null) goto L5;
    L6:
        this.e = OrientationHelper.createVerticalHelper(r2);
    L8:
        return this.e;
    L5:
        if (r0.getLayoutManager() == r2) goto L8;
        goto L6
    }

    public final View b(RecyclerView.LayoutManager r13, OrientationHelper r14) {
        View r1 = null;
        if (this.b != null) goto L5;
        return null;
    L5:
        int r0 = r13.getChildCount();
        if (r0 != 0) goto L10;
        UIList.b r15 = this.a;
        int r4 = this.b.getScrollX();
        int r5 = this.b.getScrollY();
        int r6 = this.b.getScrollX();
        int r7 = this.b.getScrollY();
        r15.a.a0(-1, r4, r5, r6, r7);
        return null;
    L10:
        if (r13.getClipToPadding() == false) goto L12;
        double r2 = ((double) r14.getStartAfterPadding()) + (((double) r14.getTotalSpace()) * this.c);
        int r8 = this.d;
    L13:
        int r3 = (int) (r2 + ((double) r8));
        int r9 = Integer.MAX_VALUE;
        int r10 = 0;
    L14:
        if (r10 >= r0) goto L19;
        View r11 = r13.getChildAt(r10);
        int r12 = Math.abs(((int) ((((double) r14.getDecoratedStart(r11)) + (((double) r14.getDecoratedMeasurement(r11)) * this.c)) + ((double) this.d))) - r3);
        if (r12 >= r9) goto L18;
        r1 = r11;
        r9 = r12;
    L18:
        r10 = r10 + 1;
        goto L14
    L19:
        if (r1 != null) goto L21;
        UIList.b r16 = this.a;
        int r17 = this.b.getScrollX();
        int r18 = this.b.getScrollY();
        int r19 = this.b.getScrollX();
        int r20 = this.b.getScrollY();
        r16.a.a0(-1, r17, r18, r19, r20);
    L21:
        return r1;
    L12:
        r2 = ((double) r14.getEnd()) * this.c;
        r8 = this.d;
        goto L13
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r11, View r12) {
        int[] r0 = new int[2];
        if (r11.canScrollHorizontally() == false) goto L5;
        r0[0] = a(r11, r12, getHorizontalHelper(r11));
    L7:
        if (r11.canScrollVertically() == false) goto L9;
        r0[1] = a(r11, r12, getVerticalHelper(r11));
    L11:
        if (this.b == null) goto L13;
        UIList.b r1 = this.a;
        int r5 = r11.getPosition(r12);
        int r6 = this.b.getScrollX();
        int r7 = this.b.getScrollY();
        int r8 = r0[0];
        int r9 = r0[1];
        r1.a.a0(r5, r6, r7, r8, r9);
    L13:
        return r0;
    L9:
        r0[1] = 0;
        goto L11
    L5:
        r0[0] = 0;
        goto L7
    }

    public final int a(RecyclerView.LayoutManager r7, View r8, OrientationHelper r9) {
        int r10 = (int) ((((double) r9.getDecoratedStart(r8)) + (((double) r9.getDecoratedMeasurement(r8)) * this.c)) + ((double) this.d));
        if (r7.getClipToPadding() == false) goto L5;
        double r0 = ((double) r9.getStartAfterPadding()) + (((double) r9.getTotalSpace()) * this.c);
        int r11 = this.d;
    L7:
        return r10 - ((int) (r0 + ((double) r11)));
    L5:
        r0 = ((double) r9.getEnd()) * this.c;
        r11 = this.d;
        goto L7
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r13, int r14, int r15) {
        if (this.b != null) goto L5;
        return -1;
    L5:
        int r0 = r13.getItemCount();
        if (r0 != 0) goto L10;
        UIList.b r16 = this.a;
        r16.a.a0(-1, this.b.getScrollX(), this.b.getScrollY(), this.b.getScrollX(), this.b.getScrollY());
        return -1;
    L10:
        if (r13.canScrollVertically() == false) goto L12;
        OrientationHelper r2 = getVerticalHelper(r13);
    L13:
        int r3 = r13.getChildCount();
        int r4 = 0;
        View r5 = null;
        View r6 = null;
        int r7 = Integer.MIN_VALUE;
        int r8 = Integer.MAX_VALUE;
        int r9 = 0;
    L14:
        if (r9 >= r3) goto L26;
        View r10 = r13.getChildAt(r9);
        if (r10 == null) goto L25;
        int r11 = a(r13, r10, r2);
        if (r11 > 0) goto L22;
        if (r11 <= r7) goto L22;
        r6 = r10;
        r7 = r11;
    L22:
        if (r11 < 0) goto L25;
        if (r11 >= r8) goto L25;
        r5 = r10;
        r8 = r11;
    L25:
        r9 = r9 + 1;
        goto L14
    L26:
        boolean r17 = isForwardFling(r13, r14, r15);
        if (r17 == false) goto L31;
        if (r5 == null) goto L31;
        return r13.getPosition(r5);
    L31:
        if (r17 == true) goto L35;
        if (r6 == null) goto L35;
        return r13.getPosition(r6);
    L35:
        if (r17 == false) goto L37;
        r5 = r6;
    L37:
        if (r5 != null) goto L39;
        return -1;
    L39:
        int r18 = r13.getPosition(r5);
        if (r17 == true) goto L42;
        int r19 = -1;
    L43:
        int r110 = r18 + r19;
        if (r110 < 0) goto L47;
        r4 = r110;
    L47:
        if (r4 < r0) goto L49;
        return -1;
    L49:
        return r4;
    L42:
        r19 = 1;
        goto L43
    L12:
        r2 = getHorizontalHelper(r13);
        goto L13
    }

    public final boolean isForwardFling(RecyclerView.LayoutManager r3, int r4, int r5) {
        if (r3.canScrollHorizontally() == false) goto L8;
        if (r4 >= 0) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (r5 >= 0) goto L13;
        return false;
    L13:
        return true;
    }
}

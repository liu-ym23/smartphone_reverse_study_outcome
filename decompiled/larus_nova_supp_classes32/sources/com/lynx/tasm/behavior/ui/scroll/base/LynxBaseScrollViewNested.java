package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxBaseScrollViewNested extends LynxBaseScrollViewDragging implements LynxBaseScrollViewNestedInternal {
    public final h7a.d m;
    public final NestedScrollingParentHelper n;
    public int o;
    public int p;

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal
    public final LynxBaseScrollViewNestedInternal r5() {
        ViewParent r0 = this.m.a(1);
        if ((r0 instanceof LynxBaseScrollViewNestedInternal) == true) goto L5;
        return null;
    L5:
        return (LynxBaseScrollViewNestedInternal) r0;
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.n.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.m.d;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal
    public int getBackwardNestedScrollMode() {
        return this.p;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal
    public int getForwardNestedScrollMode() {
        return this.o;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r8) {
        if (this.c == true) goto L30;
        if (r8 == 0) goto L30;
        int r0 = getScrollOffsetHorizontally();
        int[] r2 = getScrollRangeHorizontally();
        if (r8 <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        int r5 = getForwardNestedScrollMode();
    L13:
        if (r5 == 0) goto L29;
        if (r5 != 1) goto L16;
    L21:
        if (r4 == false) goto L26;
        if (r2[1] <= (r0 + 1)) goto L31;
    L27:
        return true;
    L31:
        return false;
    L26:
        if ((r0 - 1) > r2[0]) goto L27;
        return false;
    L16:
        if (r5 == 2) goto L21;
        if (r5 == 3) goto L21;
        return super.canScrollHorizontally(r8);
    L29:
        return true;
    L12:
        r5 = this.p;
        goto L13
    L9:
        r4 = false;
    L30:
        return false;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r8) {
        if (this.c == false) goto L30;
        if (r8 == 0) goto L30;
        int r0 = getScrollOffsetVertically();
        int[] r2 = getScrollRangeVertically();
        if (r8 <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        int r5 = this.o;
    L13:
        if (r5 == 0) goto L29;
        if (r5 != 1) goto L16;
    L21:
        if (r4 == false) goto L26;
        if (r2[1] <= (r0 + 1)) goto L31;
    L27:
        return true;
    L31:
        return false;
    L26:
        if ((r0 - 1) > r2[0]) goto L27;
        return false;
    L16:
        if (r5 == 2) goto L21;
        if (r5 == 3) goto L21;
        return super.canScrollVertically(r8);
    L29:
        return true;
    L12:
        r5 = this.p;
        goto L13
    L9:
        r4 = false;
    L30:
        return false;
    }

    public final boolean hasNestedScrollingParent(int r2) {
        if (this.m.a(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r2) {
        onStopNestedScroll(r2, 0);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r3) {
        h7a.d r0 = this.m;
        if (r0.d == false) goto L5;
        ViewCompat.stopNestedScroll(r0.c);
    L5:
        r0.d = r3;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging
    public final void stopNestedScroll(int r4) {
        h7a.d r0 = this.m;
        ViewParent r1 = r0.a(r4);
        if (r1 == null) goto L9;
        ViewParentCompat.onStopNestedScroll(r1, r0.c, r4);
        if (r4 != 0) goto L7;
        r0.a = null;
        return;
    L7:
        r0.b = null;
        return;
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r4, float r5) {
        h7a.d r0 = this.m;
        if (r0.d == false) goto L8;
        ViewParent r1 = r0.a(0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return ViewParentCompat.onNestedPreFling(r1, r0.c, r4, r5);
    L8:
        return false;
    }

    public final int n(int r5, boolean r6) {
        if (r6 == false) goto L4;
        int r7 = this.e;
    L6:
        return (int) (((double) (r5 * r7)) / (((double) (r7 - r5)) * 0.55d));
    L4:
        r7 = this.d;
        goto L6
    }

    public final void onStopNestedScroll(View r2, int r3) {
        this.n.onStopNestedScroll(r2, r3);
        stopNestedScroll(r3);
    }

    public final int q(int r5, boolean r6) {
        if (r6 == false) goto L4;
        int r7 = this.e;
    L5:
        double r0 = ((double) r5) * 0.55d;
        double r8 = r7;
        return (int) ((1.0d - (1.0d / ((r0 / r8) + 1.0d))) * r8);
    L4:
        r7 = this.d;
        goto L5
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging, h7a.b
    public final boolean startNestedScroll(int r7, int r8) {
        h7a.d r0 = this.m;
        if (r0.a(r8) == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return true;
    L9:
        if (r0.d == false) goto L22;
        ViewParent r2 = r0.c.getParent();
        View r4 = r0.c;
    L11:
        if (r2 == null) goto L22;
        if (ViewParentCompat.onStartNestedScroll(r2, r4, r0.c, r7, r8) == true) goto L14;
        if ((r2 instanceof View) == false) goto L21;
        r4 = (View) r2;
    L21:
        r2 = r2.getParent();
        goto L11
    L14:
        if (r8 != 0) goto L16;
        r0.a = r2;
    L17:
        ViewParentCompat.onNestedScrollAccepted(r2, r4, r0.c, r7, r8);
        return true;
    L16:
        r0.b = r2;
    L22:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public LynxBaseScrollViewNested(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.o = 0;
        this.p = 0;
        this.m = new h7a.d(this);
        this.n = new NestedScrollingParentHelper(this);
        this.a.f = this;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r4, float r5, boolean r6) {
        h7a.d r0 = this.m;
        if (r0.d == false) goto L8;
        ViewParent r1 = r0.a(0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return ViewParentCompat.onNestedFling(r1, r0.c, r4, r5, r6);
    L8:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r2, View r3, int r4) {
        return onStartNestedScroll(r2, r3, r4, 0);
    }

    public final void p(int r4, int r5, int[] r6) {
        if (this.c == false) goto L5;
        int r7 = getScrollOffsetVertically() + r5;
        int[] r8 = getScrollRangeVertically();
        int r9 = Math.min(Math.max(r7, r8[0]), r8[1]);
        h(r9);
        r6[0] = 0;
        r6[1] = r7 - r9;
        return;
    L5:
        int r10 = getScrollOffsetHorizontally() + r4;
        int[] r11 = getScrollRangeHorizontally();
        int r12 = Math.min(Math.max(r10, r11[0]), r11[1]);
        g(r12);
        r6[0] = r10 - r12;
        r6[1] = 0;
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging
    public final int[] k(int r20, int r21, int r22, int[] r23) {
        int[] r6 = getScrollOffset();
        int[] r11 = getScrollRange();
        int[] r13 = {0, 0};
        if (this.c == false) goto L6;
        if (r21 > 0) goto L7;
    L8:
        boolean r16 = false;
    L9:
        if (r16 == false) goto L11;
        int r0 = this.o;
    L12:
        if (r0 == 0) goto L55;
        if (r0 == 1) goto L45;
        if (r0 != 2) goto L17;
        int[] r4 = new int[2];
        int[] r3 = new int[2];
        if (r22 == 2147483634) goto L29;
    L31:
        int[] r17 = r3;
        dispatchNestedPreScroll(r20, r21, r4, r17, r22);
    L32:
        int r8 = r20 - r4[0];
        int r9 = r21 - r4[1];
        if (this.b == false) goto L35;
        r(r8, r9, r16, r6, r11, r22);
    L36:
        int[] r12 = new int[2];
        if (r22 == 2147483634) goto L39;
    L41:
        int r5 = r13[0];
        int r7 = r13[1];
        dispatchNestedScroll(r8 - r5, r9 - r7, r5, r7, r12, r22);
    L42:
        if (r23 == null) goto L58;
        r23[0] = r12[0] + r17[0];
        r23[1] = r12[1] + r17[1];
    L58:
        return r13;
    L39:
        if (this.b == false) goto L41;
        r12[0] = 0;
        r12[0] = 0;
        goto L42
    L35:
        p(r8, r9, r13);
        goto L36
    L29:
        if (this.b == false) goto L31;
        r4[0] = 0;
        r4[1] = 0;
        r3[0] = 0;
        r3[0] = 0;
        r17 = r3;
        goto L32
    L17:
        if (r0 != 3) goto L58;
        int[] r10 = new int[2];
        dispatchNestedPreScroll(r20, r21, new int[2], r10, r22);
        if (this.b == false) goto L22;
        r(r20, r21, r16, r6, r11, r22);
    L23:
        dispatchNestedScroll(r20, r21, 0, 0, null, r22);
        if (r23 == null) goto L58;
        r23[0] = r10[0];
        r23[1] = r10[1];
        goto L58
    L22:
        p(r20, r21, r13);
        goto L23
    L45:
        if (this.b == true) goto L58;
        dispatchNestedPreScroll(0, 0, new int[2], null, r22);
        if (r22 == 2147483634) goto L50;
    L52:
        p(r20, r21, r13);
    L53:
        int r14 = r13[0];
        int r15 = r13[1];
        dispatchNestedScroll(r20 - r14, r21 - r15, r14, r15, r23, r22);
        goto L58
    L50:
        if (this.b == true) goto L52;
        r13[0] = r20;
        r13[1] = r21;
        goto L53
    L55:
        if (this.b == false) goto L57;
        r(r20, r21, r16, r6, r11, r22);
        goto L58
    L57:
        p(r20, r21, r13);
        goto L58
    L11:
        r0 = this.p;
    L7:
        r16 = true;
        goto L9
    L6:
        if (r20 <= 0) goto L8;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r3, float r4, float r5, boolean r6) {
        if (r6 == true) goto L21;
        int r7 = (int) r4;
        int r8 = (int) r5;
        if (this.c == false) goto L7;
    L8:
        r7 = 0;
    L10:
        if (this.c == true) goto L12;
    L13:
        r8 = 0;
    L14:
        if (r7 != 0) goto L17;
        if (r8 != 0) goto L17;
        return false;
    L17:
        float r9 = r7;
        float r0 = r8;
        if (dispatchNestedPreFling(r9, r0) == true) goto L22;
        dispatchNestedFling(r9, r0, true);
        startNestedScroll(getNestedScrollAxis(), 1);
        int r10 = this.l.c;
        int r11 = Math.max(-r10, Math.min(r7, r10));
        int r12 = this.l.c;
        int r13 = Math.max(-r12, Math.min(r8, r12));
        i(3);
        this.a.e(r11, r13, new c(this));
        return true;
    L22:
        return false;
    L12:
        if (Math.abs(r8) >= this.l.b) goto L14;
    L7:
        if (Math.abs(r7) >= this.l.b) goto L10;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        onNestedPreScroll(r7, r8, r9, r10, 0);
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        this.n.onNestedScrollAccepted(r2, r3, r4, r5);
        if (this.c == false) goto L5;
        startNestedScroll(2, r5);
        return;
    L5:
        startNestedScroll(1, r5);
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        if (this.c == false) goto L9;
        if ((r3 & 2) == 0) goto L12;
        return true;
    L12:
        return false;
    L9:
        if ((r3 & 1) == 0) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean dispatchNestedPreScroll(int r16, int r17, int[] r18, int[] r19, int r20) {
        h7a.d r2 = this.m;
        if (r2.d == false) goto L31;
        ViewParent r5 = r2.a(r20);
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r16 != 0) goto L13;
        if (r17 != 0) goto L13;
        if (r19 == null) goto L32;
        r19[0] = 0;
        r19[1] = 0;
        return false;
    L32:
        return false;
    L13:
        if (r19 == null) goto L15;
        r2.c.getLocationInWindow(r19);
        int r6 = r19[0];
        int r12 = r6;
        int r13 = r19[1];
    L16:
        if (r18 == null) goto L18;
        int[] r14 = r18;
    L22:
        r14[0] = 0;
        r14[1] = 0;
        ViewParentCompat.onNestedPreScroll(r5, r2.c, r16, r17, r14, r20);
        if (r19 == null) goto L26;
        r2.c.getLocationInWindow(r19);
        r19[0] = r19[0] - r12;
        r19[1] = r19[1] - r13;
    L26:
        if (r14[0] == 0) goto L28;
    L29:
        return true;
    L28:
        if (r14[1] != 0) goto L29;
        return false;
    L18:
        if (r2.e != null) goto L20;
        r2.e = new int[2];
    L20:
        r14 = r2.e;
        goto L22
    L15:
        r12 = 0;
        r13 = 0;
        goto L16
    L31:
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12) {
        return dispatchNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    public final int[] m(int r12, int r13, int[] r14, int[] r15, int r16) {
        int[] r1 = {0, 0};
        if (this.c == false) goto L5;
        r1[1] = o(r13, r14[1], new int[]{r15[2], r15[3]}, r16, true);
    L6:
        return r1;
    L5:
        r1[0] = o(r12, r14[0], new int[]{r15[0], r15[1]}, r16, false);
        goto L6
    }

    public final int o(int r6, int r7, int[] r8, int r9, boolean r10) {
        boolean r0 = true;
        int r1 = r8[1];
        if (r7 <= r1) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L31;
        if (r6 < 0) goto L19;
        if (r9 == 0) goto L15;
        if (r9 == 2147483632) goto L15;
        if (r10 == false) goto L14;
        h(r7 + r6);
        return 0;
    L14:
        g(r7 + r6);
        return 0;
    L15:
        int r11 = q(n(r7 - r1, r10) + r6, r10);
        if (r10 == false) goto L18;
        h(r8[1] + r11);
        return 0;
    L18:
        g(r8[1] + r11);
        return 0;
    L19:
        if (r9 == 0) goto L26;
        if (r9 == 2147483632) goto L26;
        int r12 = Math.max(r7 + r6, r1);
        if (r10 == false) goto L25;
        h(r12);
    L54:
        int r13 = r12 - r7;
    L60:
        return r6 - r13;
    L25:
        g(r12);
    L26:
        int r14 = n(r7 - r1, r10);
        int r2 = -r6;
        int r15 = Math.max(r14 - r8[1], r2);
        int r16 = q(Math.max(r14 + r6, 0), r10);
        if (r10 == false) goto L29;
        h(r8[1] + r16);
    L65:
        return -(r2 - r15);
    L29:
        g(r8[1] + r16);
        goto L65
    L31:
        int r4 = r8[0];
        if (r7 < r4) goto L35;
        r0 = false;
    L35:
        if (r0 == false) goto L66;
        if (r6 > 0) goto L47;
        if (r9 == 0) goto L43;
        if (r9 == 2147483632) goto L43;
        if (r10 == false) goto L42;
        h(r7 + r6);
        return 0;
    L42:
        g(r7 + r6);
        return 0;
    L43:
        int r17 = q(n(r4 - r7, r10) - r6, r10);
        if (r10 == false) goto L46;
        h(-r17);
        return 0;
    L46:
        g(-r17);
        return 0;
    L47:
        if (r9 == 0) goto L55;
        if (r9 == 2147483632) goto L55;
        r12 = Math.min(r7 + r6, r4);
        if (r10 == false) goto L53;
        h(r12);
        goto L54
    L53:
        g(r12);
    L55:
        int r18 = n(r4 - r7, r10);
        r13 = Math.max((-r18) - r8[0], r6);
        int r19 = q(Math.max(r18 - r6, 0), r10);
        if (r10 == false) goto L58;
        h(-r19);
        goto L60
    L58:
        g(-r19);
        goto L60
    L66:
        return 0;
    L5:
        r3 = false;
        goto L7
    }

    public final void onNestedPreScroll(View r4, int r5, int r6, int[] r7, int r8) {
        boolean r9 = this.c;
        if (r9 == false) goto L5;
        int r1 = 0;
    L6:
        if (r9 == false) goto L8;
        int r10 = r6;
    L9:
        int[] r11 = k(r1, r10, r8, null);
        r7[0] = r5 - r11[0];
        r7[1] = r6 - r11[1];
        return;
    L8:
        r10 = 0;
        goto L9
    L5:
        r1 = r5;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r8, int r9, int r10, int r11, int r12) {
        onNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    public final boolean dispatchNestedScroll(int r16, int r17, int r18, int r19, int[] r20, int r21) {
        h7a.d r2 = this.m;
        if (r2.d == false) goto L23;
        ViewParent r5 = r2.a(r21);
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r16 != 0) goto L15;
        if (r17 != 0) goto L15;
        if (r18 != 0) goto L15;
        if (r19 != 0) goto L15;
        if (r20 == null) goto L24;
        r20[0] = 0;
        r20[1] = 0;
        return false;
    L24:
        return false;
    L15:
        if (r20 == null) goto L17;
        r2.c.getLocationInWindow(r20);
        int r6 = r20[0];
        int r13 = r6;
        int r14 = r20[1];
    L18:
        ViewParentCompat.onNestedScroll(r5, r2.c, r16, r17, r18, r19, r21);
        if (r20 == null) goto L21;
        r2.c.getLocationInWindow(r20);
        r20[0] = r20[0] - r13;
        r20[1] = r20[1] - r14;
    L21:
        return true;
    L17:
        r13 = 0;
        r14 = 0;
        goto L18
    L23:
        return false;
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        boolean r7 = this.c;
        if (r7 == false) goto L5;
        r4 = 0;
    L5:
        if (r7 == true) goto L8;
        r5 = 0;
    L8:
        k(r4, r5, r6, null);
    }

    public final void r(int r9, int r10, boolean r11, int[] r12, int[] r13, int r14) {
        boolean r0 = this.c;
        if (r0 == false) goto L8;
        int r3 = r12[1];
        int r4 = r13[2];
        if (r3 <= r13[3]) goto L7;
    L6:
        boolean r5 = true;
    L11:
        if (r0 == false) goto L16;
        int r1 = r12[1];
        int r2 = r13[2];
        int r6 = r13[3];
        if (r1 >= r2) goto L15;
    L14:
        boolean r7 = true;
    L19:
        if (r5 == false) goto L23;
        if (r11 == false) goto L22;
        m(r9, r10, r12, r13, r14);
        return;
    L22:
        int[] r8 = m(r9, r10, r12, r13, r14);
        scrollBy(r8[0], r8[1]);
        return;
    L23:
        if (r7 == false) goto L28;
        if (r11 == true) goto L26;
        m(r9, r10, r12, r13, r14);
        return;
    L26:
        int[] r15 = m(r9, r10, r12, r13, r14);
        scrollBy(r15[0], r15[1]);
        return;
    L28:
        if (r14 == 2147483634) goto L35;
        scrollBy(r9, r10);
        int[] r16 = getScrollOffset();
        m(r9 - (r16[0] - r12[0]), r10 - (r16[1] - r12[1]), r12, r13, r14);
        return;
    L35:
        return;
    L15:
        r7 = false;
        goto L19
    L16:
        int r17 = r12[0];
        int r18 = r13[0];
        int r19 = r13[1];
        if (r17 >= r18) goto L15;
    L7:
        r5 = false;
        goto L11
    L8:
        int r20 = r12[0];
        int r21 = r13[0];
        if (r20 <= r13[1]) goto L7;
        goto L7
    }
}

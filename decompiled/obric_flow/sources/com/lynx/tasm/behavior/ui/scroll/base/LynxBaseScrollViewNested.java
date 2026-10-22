package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import b0.f;
import com.lynx.tasm.t;
import hn.c;
import sg.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LynxBaseScrollViewNested extends c implements LynxBaseScrollViewNestedInternal {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t f10660l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final NestedScrollingParentHelper f10661m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10662n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10663o;

    public LynxBaseScrollViewNested(Context r5) {
        super(r5);
        this.f10662n = 0;
        this.f10663o = 0;
        this.f10660l = new t(this);
        this.f10661m = new NestedScrollingParentHelper(this);
        this.f17349a.f = this;
    }

    public final int c(int r5, int r10, int[] r11, int r12, boolean r13) {
        int r14 = r11[1];
        if (r10 <= r14) goto L34;
        if (r5 < 0) goto L19;
        if (r12 == 0) goto L13;
        if (r12 == 2147483632) goto L13;
        if (r13 == false) goto L11;
        int r15 = r10 + r5;
        scrollTo(getScrollX(), r15);
        return 0;
    L11:
        scrollTo(r10 + r5, getScrollY());
        return 0;
    L13:
        int r16 = i(d(r10 - r14, r13) + r5, r13);
        if (r13 == false) goto L17;
        int r17 = r11[1] + r16;
        scrollTo(getScrollX(), r17);
        return 0;
    L17:
        scrollTo(r11[1] + r16, getScrollY());
        return 0;
    L19:
        if (r12 == 0) goto L28;
        if (r12 == 2147483632) goto L28;
        int r18 = Math.max(r10 + r5, r14);
        if (r13 == false) goto L25;
        scrollTo(getScrollX(), r18);
    L27:
        return r5 - (r18 - r10);
    L25:
        scrollTo(r18, getScrollY());
    L28:
        int r19 = d(r10 - r14, r13);
        int r20 = -r5;
        int r21 = Math.max(r19 - r11[1], r20);
        int r22 = i(Math.max(r19 + r5, 0), r13);
        if (r13 == false) goto L31;
        int r23 = r11[1] + r22;
        scrollTo(getScrollX(), r23);
    L33:
        return -(r20 - r21);
    L31:
        scrollTo(r11[1] + r22, getScrollY());
        goto L33
    L34:
        int r24 = r11[0];
        if (r10 >= r24) goto L64;
        if (r5 > 0) goto L51;
        if (r12 == 0) goto L45;
        if (r12 == 2147483632) goto L45;
        if (r13 == false) goto L43;
        int r25 = r10 + r5;
        scrollTo(getScrollX(), r25);
        return 0;
    L43:
        scrollTo(r10 + r5, getScrollY());
        return 0;
    L45:
        int r26 = i(d(r24 - r10, r13) - r5, r13);
        if (r13 == false) goto L49;
        int r27 = getScrollX();
        scrollTo(r27, -r26);
        return 0;
    L49:
        scrollTo(-r26, getScrollY());
        return 0;
    L51:
        if (r12 == 0) goto L58;
        if (r12 == 2147483632) goto L58;
        r18 = Math.min(r10 + r5, r24);
        if (r13 == false) goto L57;
        scrollTo(getScrollX(), r18);
        goto L27
    L57:
        scrollTo(r18, getScrollY());
    L58:
        int r28 = d(r24 - r10, r13);
        int r29 = Math.max((-r28) - r11[0], r5);
        int r30 = i(Math.max(r28 - r5, 0), r13);
        if (r13 == false) goto L61;
        int r31 = getScrollX();
        scrollTo(r31, -r30);
    L63:
        return r5 - r29;
    L61:
        scrollTo(-r30, getScrollY());
        goto L63
    L64:
        return 0;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r10) {
        if (this.f17351c == true) goto L31;
        if (r10 == 0) goto L31;
        int r5 = getScrollOffsetHorizontally();
        int[] r11 = getScrollRangeHorizontally();
        if (r10 <= 0) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        int r13 = getForwardNestedScrollMode();
    L13:
        if (r13 == 0) goto L30;
        if (r13 != 1) goto L16;
    L21:
        if (r12 == false) goto L27;
        if (r11[1] <= (r5 + 1)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((r5 - 1) <= r11[0]) goto L29;
        return true;
    L29:
        return false;
    L16:
        if (r13 == 2) goto L21;
        if (r13 == 3) goto L21;
        return super.canScrollHorizontally(r10);
    L30:
        return true;
    L12:
        r13 = this.f10663o;
        goto L13
    L9:
        r12 = false;
    L31:
        return false;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r10) {
        if (this.f17351c == false) goto L31;
        if (r10 == 0) goto L31;
        int r5 = getScrollOffsetVertically();
        int[] r11 = getScrollRangeVertically();
        if (r10 <= 0) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        int r13 = this.f10662n;
    L13:
        if (r13 == 0) goto L30;
        if (r13 != 1) goto L16;
    L21:
        if (r12 == false) goto L27;
        if (r11[1] <= (r5 + 1)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((r5 - 1) <= r11[0]) goto L29;
        return true;
    L29:
        return false;
    L16:
        if (r13 == 2) goto L21;
        if (r13 == 3) goto L21;
        return super.canScrollVertically(r10);
    L30:
        return true;
    L12:
        r13 = this.f10663o;
        goto L13
    L9:
        r12 = false;
    L31:
        return false;
    }

    public final int d(int r5, boolean r10) {
        if (r10 == false) goto L4;
        int r11 = this.e;
    L6:
        return (int) (((double) (r5 * r11)) / (((double) (r11 - r5)) * 0.55d));
    L4:
        r11 = this.d;
        goto L6
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        t r12 = this.f10660l;
        if (r12.f10962b == false) goto L8;
        ViewParent r13 = (ViewParent) r12.f10963c;
        if (r13 != null) goto L7;
        return false;
    L7:
        return ViewParentCompat.onNestedFling(r13, (LynxBaseScrollViewNested) r12.e, r5, r10, r11);
    L8:
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r5, float r10) {
        t r11 = this.f10660l;
        if (r11.f10962b == false) goto L8;
        ViewParent r12 = (ViewParent) r11.f10963c;
        if (r12 != null) goto L7;
        return false;
    L7:
        return ViewParentCompat.onNestedPreFling(r12, (LynxBaseScrollViewNested) r11.e, r5, r10);
    L8:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r15, int r16, int[] r17, int[] r18, int r19) {
        t r5 = this.f10660l;
        if (r5.f10962b == false) goto L36;
        if (r19 != 0) goto L7;
        Object r10 = r5.f10963c;
    L6:
        ViewParent r11 = (ViewParent) r10;
        if (r11 != null) goto L11;
        return false;
    L11:
        if (r15 != 0) goto L16;
        if (r16 != 0) goto L16;
        if (r18 == null) goto L36;
        r18[0] = 0;
        r18[1] = 0;
    L16:
        LynxBaseScrollViewNested r12 = (LynxBaseScrollViewNested) r5.e;
        if (r18 == null) goto L19;
        r12.getLocationInWindow(r18);
        int r13 = r18[0];
        int r14 = r18[1];
    L20:
        if (r17 == null) goto L22;
        int[] r110 = r17;
    L26:
        r110[0] = 0;
        r110[1] = 0;
        ViewParentCompat.onNestedPreScroll(r11, (LynxBaseScrollViewNested) r5.e, r15, r16, r110, r19);
        if (r18 == null) goto L30;
        r12.getLocationInWindow(r18);
        r18[0] = r18[0] - r13;
        r18[1] = r18[1] - r14;
    L30:
        if (r110[0] == 0) goto L32;
    L35:
        return true;
    L32:
        if (r110[1] != 0) goto L35;
        return false;
    L22:
        if (((int[]) r5.f) != null) goto L24;
        r5.f = new int[2];
    L24:
        r110 = (int[]) r5.f;
        goto L26
    L19:
        r13 = 0;
        r14 = 0;
        goto L20
    L7:
        r10 = r5.d;
    L36:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r15, int r16, int r17, int r18, int[] r19, int r20) {
        t r5 = this.f10660l;
        if (r5.f10962b == false) goto L26;
        if (r20 != 0) goto L7;
        Object r10 = r5.f10963c;
    L6:
        ViewParent r11 = (ViewParent) r10;
        if (r11 != null) goto L11;
        return false;
    L11:
        if (r15 != 0) goto L18;
        if (r16 != 0) goto L18;
        if (r17 != 0) goto L18;
        if (r18 != 0) goto L18;
        if (r19 == null) goto L26;
        r19[0] = 0;
        r19[1] = 0;
    L18:
        LynxBaseScrollViewNested r12 = (LynxBaseScrollViewNested) r5.e;
        if (r19 == null) goto L21;
        r12.getLocationInWindow(r19);
        int r13 = r19[0];
        int r14 = r19[1];
    L22:
        ViewParentCompat.onNestedScroll(r11, (LynxBaseScrollViewNested) r5.e, r15, r16, r17, r18, r20);
        if (r19 == null) goto L25;
        r12.getLocationInWindow(r19);
        r19[0] = r19[0] - r13;
        r19[1] = r19[1] - r14;
    L25:
        return true;
    L21:
        r13 = 0;
        r14 = 0;
        goto L22
    L7:
        r10 = r5.d;
    L26:
        return false;
    }

    public final void e(int r10, int r11, boolean r12, int[] r13, int[] r14, int r15) {
        boolean r5 = this.f17351c;
        if (r5 == false) goto L8;
        if (r13[1] > new int[]{r14[2], r14[3]}[1]) goto L9;
    L10:
        boolean r16 = false;
    L11:
        if (r5 == false) goto L16;
        if (r13[1] < new int[]{r14[2], r14[3]}[0]) goto L17;
    L18:
        boolean r17 = false;
    L19:
        if (r16 == false) goto L25;
        if (r12 == false) goto L23;
        h(r10, r11, r13, r14, r15);
        return;
    L23:
        int[] r18 = h(r10, r11, r13, r14, r15);
        scrollBy(r18[0], r18[1]);
        return;
    L25:
        if (r17 == false) goto L32;
        if (r12 == true) goto L29;
        h(r10, r11, r13, r14, r15);
        return;
    L29:
        int[] r19 = h(r10, r11, r13, r14, r15);
        scrollBy(r19[0], r19[1]);
        return;
    L32:
        if (r15 == 2147483634) goto L35;
        scrollBy(r10, r11);
        int[] r20 = getScrollOffset();
        int[] r21 = {r10 - (r20[0] - r13[0]), r11 - (r20[1] - r13[1])};
        h(r21[0], r21[1], r13, r14, r15);
        return;
    L35:
        return;
    L17:
        r17 = true;
        goto L19
    L16:
        if (r13[0] >= new int[]{r14[0], r14[1]}[0]) goto L18;
    L9:
        r16 = true;
        goto L11
    L8:
        if (r13[0] <= new int[]{r14[0], r14[1]}[1]) goto L10;
        goto L9
    }

    public final void f(int r5, int r10, int[] r11) {
        if (this.f17351c == false) goto L6;
        int r12 = getScrollOffsetVertically() + r10;
        int[] r13 = getScrollRangeVertically();
        int r14 = Math.min(Math.max(r12, r13[0]), r13[1]);
        scrollTo(getScrollX(), r14);
        r11[0] = 0;
        r11[1] = r12 - r14;
        return;
    L6:
        int r15 = getScrollOffsetHorizontally() + r5;
        int[] r16 = getScrollRangeHorizontally();
        int r17 = Math.min(Math.max(r15, r16[0]), r16[1]);
        scrollTo(r17, getScrollY());
        r11[0] = r15 - r17;
        r11[1] = 0;
    }

    public final int[] g(int r20, int r21, int r22, int[] r23) {
        int[] r10 = getScrollOffset();
        int[] r11 = getScrollRange();
        int[] r13 = {0, 0};
        if (this.f17351c == false) goto L6;
        if (r21 > 0) goto L7;
    L8:
        boolean r16 = false;
    L9:
        if (r16 == false) goto L11;
        int r5 = this.f10662n;
    L12:
        if (r5 == 0) goto L58;
        if (r5 == 1) goto L47;
        if (r5 != 2) goto L17;
        int[] r12 = new int[2];
        int[] r14 = new int[2];
        if (r22 == 2147483634) goto L30;
    L32:
        int[] r17 = r14;
        dispatchNestedPreScroll(r20, r21, r12, r17, r22);
    L33:
        int r15 = r20 - r12[0];
        int r18 = r21 - r12[1];
        if (this.f17350b == false) goto L36;
        e(r15, r18, r16, r10, r11, r22);
    L37:
        int[] r19 = new int[2];
        if (r22 == 2147483634) goto L40;
    L42:
        int r24 = r13[0];
        int r25 = r13[1];
        dispatchNestedScroll(r15 - r24, r18 - r25, r24, r25, r19, r22);
    L43:
        if (r23 == null) goto L48;
        r23[0] = r19[0] + r17[0];
        r23[1] = r19[1] + r17[1];
        return r13;
    L48:
        return r13;
    L40:
        if (this.f17350b == false) goto L42;
        r19[0] = 0;
        r19[0] = 0;
        goto L43
    L36:
        f(r15, r18, r13);
        goto L37
    L30:
        if (this.f17350b == false) goto L32;
        r12[0] = 0;
        r12[1] = 0;
        r14[0] = 0;
        r14[0] = 0;
        r17 = r14;
        goto L33
    L17:
        if (r5 != 3) goto L48;
        int[] r26 = new int[2];
        dispatchNestedPreScroll(r20, r21, new int[2], r26, r22);
        if (this.f17350b == false) goto L22;
        e(r20, r21, r16, r10, r11, r22);
    L23:
        dispatchNestedScroll(r20, r21, 0, 0, null, r22);
        if (r23 == null) goto L48;
        r23[0] = r26[0];
        r23[1] = r26[1];
        return r13;
    L22:
        f(r20, r21, r13);
        goto L23
    L47:
        if (this.f17350b == true) goto L48;
        dispatchNestedPreScroll(0, 0, new int[2], null, r22);
        if (r22 == 2147483634) goto L52;
    L54:
        f(r20, r21, r13);
    L55:
        int r27 = r13[0];
        int r28 = r13[1];
        dispatchNestedScroll(r20 - r27, r21 - r28, r27, r28, r23, r22);
        return r13;
    L52:
        if (this.f17350b == true) goto L54;
        r13[0] = r20;
        r13[1] = r21;
        goto L55
    L58:
        if (this.f17350b == false) goto L61;
        e(r20, r21, r16, r10, r11, r22);
        return r13;
    L61:
        f(r20, r21, r13);
        return r13;
    L11:
        r5 = this.f10663o;
    L7:
        r16 = true;
        goto L9
    L6:
        if (r20 <= 0) goto L8;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal
    public int getBackwardNestedScrollMode() {
        return this.f10663o;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal
    public int getForwardNestedScrollMode() {
        return this.f10662n;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f10661m.getNestedScrollAxes();
    }

    public final int[] h(int r11, int r12, int[] r13, int[] r14, int r15) {
        int[] r5 = {0, 0};
        if (this.f17351c == false) goto L6;
        r5[1] = c(r12, r13[1], new int[]{r14[2], r14[3]}, r15, true);
        return r5;
    L6:
        r5[0] = c(r11, r13[0], new int[]{r14[0], r14[1]}, r15, false);
        return r5;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        if (((ViewParent) this.f10660l.f10963c) == null) goto L6;
        return true;
    L6:
        return false;
    }

    public final int i(int r5, boolean r10) {
        if (r10 == false) goto L4;
        int r11 = this.e;
    L5:
        double r12 = r11;
        return (int) ((1.0d - (1.0d / (((((double) r5) * 0.55d) / r12) + 1.0d))) * r12);
    L4:
        r11 = this.d;
        goto L5
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f10660l.f10962b;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        if (r12 == true) goto L21;
        int r13 = (int) r10;
        int r14 = (int) r11;
        boolean r15 = this.f17351c;
        f r16 = this.f17345k;
        if (r15 == false) goto L7;
    L8:
        r13 = 0;
    L10:
        if (this.f17351c == true) goto L12;
    L13:
        r14 = 0;
    L14:
        if (r13 != 0) goto L17;
        if (r14 != 0) goto L17;
        return false;
    L17:
        float r17 = r13;
        float r18 = r14;
        if (dispatchNestedPreFling(r17, r18) == true) goto L22;
        dispatchNestedFling(r17, r18, true);
        startNestedScroll(getNestedScrollAxis(), 1);
        int r19 = r16.f815c;
        int r20 = Math.max(-r19, Math.min(r13, r19));
        int r21 = r16.f815c;
        int r22 = Math.max(-r21, Math.min(r14, r21));
        a(3);
        this.f17349a.a(r20, r22, new a(this));
        return true;
    L22:
        return false;
    L12:
        if (Math.abs(r14) >= r16.f814b) goto L14;
    L7:
        if (Math.abs(r13) >= r16.f814b) goto L10;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r5, float r10, float r11) {
        return dispatchNestedPreFling(r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r5, int r10, int r11, int[] r12, int r13) {
        boolean r14 = this.f17351c;
        if (r14 == false) goto L5;
        int r15 = 0;
    L6:
        if (r14 == false) goto L8;
        int r16 = r11;
    L9:
        int[] r17 = g(r15, r16, r13, null);
        r12[0] = r10 - r17[0];
        r12[1] = r11 - r17[1];
        return;
    L8:
        r16 = 0;
        goto L9
    L5:
        r15 = r10;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14) {
        boolean r15 = this.f17351c;
        if (r15 == false) goto L5;
        r12 = 0;
    L5:
        if (r15 == true) goto L8;
        r13 = 0;
    L8:
        g(r12, r13, r14, null);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
        this.f10661m.onNestedScrollAccepted(r5, r10, r11, r12);
        if (this.f17351c == false) goto L6;
        startNestedScroll(2, r12);
        return;
    L6:
        startNestedScroll(1, r12);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        if (this.f17351c == false) goto L9;
        if ((r11 & 2) == 0) goto L7;
        return true;
    L7:
        return false;
    L9:
        if ((r11 & 1) == 0) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r5) {
        this.f10661m.onStopNestedScroll(r5, 0);
        stopNestedScroll(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        t r10 = this.f10660l;
        if (r10.f10962b == false) goto L5;
        ViewCompat.stopNestedScroll((LynxBaseScrollViewNested) r10.e);
    L5:
        r10.f10962b = r5;
    }

    @Override // hn.e, androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r10, int r11) {
        t r5 = this.f10660l;
        if (r11 != 0) goto L6;
        Object r12 = r5.f10963c;
    L8:
        if (((ViewParent) r12) == null) goto L11;
        return true;
    L11:
        if (r5.f10962b == false) goto L25;
        LynxBaseScrollViewNested r13 = (LynxBaseScrollViewNested) r5.e;
        ViewParent r14 = r13.getParent();
        View r15 = r13;
    L13:
        if (r14 == null) goto L31;
        if (ViewParentCompat.onStartNestedScroll(r14, r15, r13, r10, r11) == true) goto L16;
        if ((r14 instanceof View) == false) goto L24;
        r15 = (View) r14;
    L24:
        r14 = r14.getParent();
        goto L13
    L16:
        if (r11 != 0) goto L18;
        r5.f10963c = r14;
    L19:
        ViewParentCompat.onNestedScrollAccepted(r14, r15, r13, r10, r11);
        return true;
    L18:
        r5.d = r14;
        goto L19
    L31:
        return false;
    L25:
        return false;
    L6:
        r12 = r5.d;
        goto L8
    }

    @Override // hn.c, androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r5) {
        t r10 = this.f10660l;
        if (r5 != 0) goto L5;
        ViewParent r11 = (ViewParent) r10.f10963c;
    L6:
        if (r11 == null) goto L13;
        ViewParentCompat.onStopNestedScroll(r11, (LynxBaseScrollViewNested) r10.e, r5);
        if (r5 != 0) goto L11;
        r10.f10963c = null;
        return;
    L11:
        r10.d = null;
        return;
    L13:
        return;
    L5:
        r11 = (ViewParent) r10.d;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r10, r11, r12, r13, r14, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r5, View r10, int r11) {
        return onStartNestedScroll(r5, r10, r11, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r5) {
        t r10 = this.f10660l;
        if (r5 != 0) goto L5;
        ViewParent r11 = (ViewParent) r10.f10963c;
    L6:
        if (r11 == null) goto L9;
        return true;
    L9:
        return false;
    L5:
        r11 = (ViewParent) r10.d;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r5, int r10) {
        this.f10661m.onStopNestedScroll(r5, r10);
        stopNestedScroll(r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        onNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r5, View r10, int r11) {
        onNestedScrollAccepted(r5, r10, r11, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return dispatchNestedScroll(r10, r11, r12, r13, r14, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r5) {
        return startNestedScroll(r5, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        return dispatchNestedPreScroll(r10, r11, r12, r13, 0);
    }
}

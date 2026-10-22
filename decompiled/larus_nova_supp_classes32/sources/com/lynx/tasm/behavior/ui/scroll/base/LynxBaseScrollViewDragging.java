package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxBaseScrollViewDragging extends LynxBaseScrollViewScrolling implements h7a.b {
    public final d k;
    public final c l;

    public class a implements com.lynx.tasm.behavior.ui.scroll.base.d.c {
        public final /* synthetic */ LynxBaseScrollViewDragging a;

        public a(LynxBaseScrollViewDragging r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.base.d.c
        public final void a(boolean r2) {
            if (r2 == false) goto L5;
            this.a.i(0);
            return;
        }
    }

    public class b implements com.lynx.tasm.behavior.ui.scroll.base.d.c {
        public final /* synthetic */ LynxBaseScrollViewNestedInternal a;
        public final /* synthetic */ LynxBaseScrollViewDragging b;

        @Override // com.lynx.tasm.behavior.ui.scroll.base.d.c
        public final void a(boolean r4) {
            if (r4 == false) goto L8;
            LynxBaseScrollViewDragging r5 = this.b;
            if (r5.a.i(this.a, r5.c, new h7a.a(this)) == true) goto L9;
            this.b.i(0);
            return;
        L9:
            return;
        }

        public b(LynxBaseScrollViewDragging r1, LynxBaseScrollViewNestedInternal r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class c {
        public final int a;
        public final int b;
        public final int c;

        public c(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class d {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public VelocityTracker f;
        public final int[] g;

        public d() {
            this.e = -1;
            this.g = new int[2];
        }
    }

    @Override // h7a.b
    public View getView() {
        return this;
    }

    public int[] k(int r1, int r2, int r3, int[] r4) {
        return new int[2];
    }

    @Override // h7a.b
    public boolean startNestedScroll(int r1, int r2) {
        return false;
    }

    public void stopNestedScroll(int r1) {
    }

    private void l() {
        VelocityTracker r0 = this.k.f;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    public int getNestedScrollAxis() {
        if (this.c == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // h7a.b
    public final int[] b(boolean r6) {
        if (r6 == false) goto L4;
        int r0 = getScrollOffsetVertically();
    L5:
        if (r6 == false) goto L7;
        int[] r7 = getScrollRangeVertically();
    L8:
        boolean r1 = this.b;
        if (r1 == false) goto L14;
        int r3 = r7[0];
        if (r0 >= r3) goto L13;
        int r4 = r0 - 50;
    L16:
        if (r1 == false) goto L21;
        int r8 = r7[1];
        if (r0 <= r8) goto L20;
        int r2 = r0 + 50;
    L23:
        return new int[]{r4, r2};
    L20:
        r2 = r8 + 300;
        goto L23
    L21:
        r2 = r7[1];
        goto L23
    L13:
        r4 = r3 - 300;
        goto L16
    L14:
        r4 = r7[0];
        goto L16
    L7:
        r7 = getScrollRangeHorizontally();
        goto L8
    L4:
        r0 = getScrollOffsetHorizontally();
        goto L5
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        d r0 = this.k;
        if (r0.f != null) goto L5;
        r0.f = VelocityTracker.obtain();
    L5:
        this.k.f.addMovement(r8);
        int r1 = r8.getActionMasked();
        if (r1 == 0) goto L51;
        if (r1 == 1) goto L50;
        if (r1 == 2) goto L23;
        if (r1 != 3) goto L11;
        l();
        i(0);
    L57:
        if (this.h != 1) goto L60;
        return true;
    L60:
        return false;
    L11:
        if (r1 != 5) goto L13;
        d r2 = this.k;
        r2.e = r8.getPointerId(0);
        d r3 = this.k;
        int r4 = (int) (r8.getX() + 0.5f);
        r3.c = r4;
        r3.a = r4;
        d r5 = this.k;
        int r9 = (int) (r8.getY() + 0.5f);
        r5.d = r9;
        r5.b = r9;
        goto L57
    L13:
        if (r1 != 6) goto L57;
        int r6 = r8.getActionIndex();
        int r7 = r8.getPointerId(r6);
        d r10 = this.k;
        if (r7 != r10.e) goto L57;
        if (r6 != 0) goto L19;
        int r11 = 1;
    L20:
        r10.e = r8.getPointerId(r11);
        d r12 = this.k;
        int r13 = (int) (r8.getX(r11) + 0.5f);
        r12.c = r13;
        r12.a = r13;
        d r14 = this.k;
        int r15 = (int) (r8.getY(r11) + 0.5f);
        r14.d = r15;
        r14.b = r15;
        goto L57
    L19:
        r11 = 0;
        goto L20
    L23:
        int r16 = this.k.e;
        if (r16 == (-1)) goto L57;
        int r17 = r8.findPointerIndex(r16);
        if (r17 >= 0) goto L29;
        return false;
    L29:
        int r18 = (int) (r8.getX(r17) + 0.5f);
        int r19 = (int) (r8.getY(r17) + 0.5f);
        if (this.h == 1) goto L57;
        d r20 = this.k;
        int r21 = r18 - r20.a;
        int r22 = r19 - r20.b;
        if (this.c == true) goto L34;
    L38:
        boolean r23 = false;
    L40:
        if (this.c == false) goto L42;
    L46:
        boolean r24 = false;
    L47:
        if (r23 == true) goto L49;
        if (r24 == false) goto L57;
    L49:
        d r25 = this.k;
        r25.c = r18;
        r25.d = r19;
        i(1);
        goto L57
    L42:
        if (Math.abs(r21) <= this.l.a) goto L46;
        if ((getNestedScrollAxes() & 1) != 0) goto L46;
        r24 = true;
        goto L47
    L34:
        if (Math.abs(r22) <= this.l.a) goto L38;
        if ((getNestedScrollAxes() & 2) != 0) goto L38;
        r23 = true;
        goto L40
    L50:
        this.k.f.clear();
        stopNestedScroll(0);
        goto L57
    L51:
        d r26 = this.k;
        r26.e = r8.getPointerId(0);
        d r27 = this.k;
        int r28 = (int) (r8.getX() + 0.5f);
        r27.c = r28;
        r27.a = r28;
        d r29 = this.k;
        int r30 = (int) (r8.getY() + 0.5f);
        r29.d = r30;
        r29.b = r30;
        int r31 = this.h;
        if (r31 == 3) goto L54;
        if (r31 == 2) goto L54;
    L55:
        startNestedScroll(getNestedScrollAxis(), 0);
    L54:
        getParent().requestDisallowInterceptTouchEvent(true);
        i(1);
        goto L55
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r11) {
        d r0 = this.k;
        if (r0.f != null) goto L5;
        r0.f = VelocityTracker.obtain();
    L5:
        int r1 = r11.getActionMasked();
        boolean r2 = false;
        if (r1 != 0) goto L8;
        int[] r3 = this.k.g;
        r3[1] = 0;
        r3[0] = 0;
        this.a.g(false);
        startNestedScroll(getNestedScrollAxis(), 0);
    L8:
        MotionEvent r4 = MotionEvent.obtain(r11);
        int[] r5 = this.k.g;
        r4.offsetLocation(r5[0], r5[1]);
        if (r1 != 0) goto L11;
        this.k.e = r11.getPointerId(0);
        d r6 = this.k;
        int r7 = (int) (r11.getX() + 0.5f);
        r6.c = r7;
        r6.a = r7;
        d r8 = this.k;
        int r12 = (int) (r11.getY() + 0.5f);
        r8.d = r12;
        r8.b = r12;
    L98:
        if (r2 == true) goto L100;
        this.k.f.addMovement(r4);
    L100:
        r4.recycle();
        return true;
    L11:
        if (r1 != 1) goto L13;
        this.k.f.addMovement(r4);
        this.k.f.computeCurrentVelocity(1000, this.l.c);
        float r9 = 0.0f;
        if (this.c == true) goto L76;
        d r13 = this.k;
        float r14 = -r13.f.getXVelocity(r13.e);
    L78:
        if (this.c == false) goto L81;
        d r10 = this.k;
        r9 = -r10.f.getYVelocity(r10.e);
    L81:
        if (Math.abs(r14) >= 600.0f) goto L83;
        boolean r15 = true;
    L85:
        if ((r15 & (!this.c)) == true) goto L93;
        if (Math.abs(r9) < 600.0f) goto L89;
    L91:
        this.a.e((int) r14, (int) r9, new b(this, (LynxBaseScrollViewNestedInternal) this));
        i(3);
    L96:
        l();
        r2 = true;
        goto L98
    L89:
        if (this.c == false) goto L91;
    L93:
        if (this.a.i((LynxBaseScrollViewNestedInternal) this, this.c, new a(this)) == false) goto L95;
        i(3);
        goto L96
    L95:
        i(0);
        goto L96
    L83:
        r15 = false;
        goto L85
    L76:
        r14 = 0.0f;
        goto L78
    L13:
        if (r1 == 2) goto L28;
        if (r1 != 3) goto L16;
        l();
        i(0);
        goto L98
    L16:
        if (r1 != 5) goto L18;
        int r16 = r11.getActionIndex();
        this.k.e = r11.getPointerId(r16);
        d r17 = this.k;
        int r18 = (int) (r11.getX(r16) + 0.5f);
        r17.c = r18;
        r17.a = r18;
        d r19 = this.k;
        int r110 = (int) (r11.getY(r16) + 0.5f);
        r19.d = r110;
        r19.b = r110;
        goto L98
    L18:
        if (r1 != 6) goto L98;
        int r20 = r11.getActionIndex();
        int r21 = r11.getPointerId(r20);
        d r22 = this.k;
        if (r21 != r22.e) goto L98;
        if (r20 != 0) goto L24;
        int r23 = 1;
    L25:
        r22.e = r11.getPointerId(r23);
        d r24 = this.k;
        int r25 = (int) (r11.getX(r23) + 0.5f);
        r24.c = r25;
        r24.a = r25;
        d r26 = this.k;
        int r111 = (int) (r11.getY(r23) + 0.5f);
        r26.d = r111;
        r26.b = r111;
        goto L98
    L24:
        r23 = 0;
        goto L25
    L28:
        int r27 = this.k.e;
        if (r27 == (-1)) goto L98;
        int r28 = r11.findPointerIndex(r27);
        if (r28 >= 0) goto L34;
        return false;
    L34:
        int r29 = (int) (r11.getX(r28) + 0.5f);
        int r112 = (int) (r11.getY(r28) + 0.5f);
        d r30 = this.k;
        int r31 = r30.c - r29;
        int r32 = r30.d - r112;
        if (this.h != 1) goto L37;
        boolean r33 = true;
    L38:
        if (r33 == false) goto L40;
    L54:
        if (r33 == false) goto L98;
        if (getParent() == null) goto L58;
        getParent().requestDisallowInterceptTouchEvent(true);
    L58:
        i(1);
        int[] r34 = {0, 0};
        boolean r35 = this.c;
        if (r35 == false) goto L61;
        int r36 = 0;
    L62:
        if (r35 == false) goto L64;
        int r37 = r32;
    L65:
        int[] r38 = k(r36, r37, 0, r34);
        r4.offsetLocation(r34[0], r34[1]);
        d r39 = this.k;
        int r40 = r34[0];
        r39.c = r29 - r40;
        int r41 = r34[1];
        r39.d = r112 - r41;
        int[] r113 = r39.g;
        r113[0] = r113[0] + r40;
        r113[1] = r113[1] + r41;
        boolean r114 = this.c;
        if (r114 == true) goto L68;
    L69:
        if (r114 == true) goto L98;
        if (r38[0] == r31) goto L98;
    L72:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L98
    L68:
        if (r38[1] != r32) goto L72;
    L64:
        r37 = 0;
        goto L65
    L61:
        r36 = r31;
        goto L62
    L40:
        if (this.c == false) goto L47;
        int r42 = Math.abs(r32);
        int r43 = this.l.a;
        if (r42 <= r43) goto L47;
        if (r32 <= 0) goto L45;
        r32 = r32 - r43;
    L53:
        r33 = true;
        goto L54
    L45:
        r32 = r32 + r43;
    L47:
        if (this.c == true) goto L54;
        int r44 = Math.abs(r31);
        int r45 = this.l.a;
        if (r44 <= r45) goto L54;
        if (r31 <= 0) goto L52;
        r31 = r31 - r45;
        goto L53
    L52:
        r31 = r31 + r45;
        goto L53
    L37:
        r33 = false;
        goto L38
    }

    @Override // h7a.b
    public final boolean a(int r2, int[] r3) {
        if (r2 > r3[1]) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // h7a.b
    public final boolean c(int r2, int[] r3) {
        if (r2 >= r3[0]) goto L6;
        return true;
    L6:
        return false;
    }

    public LynxBaseScrollViewDragging(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.k = new d();
        ViewConfiguration r5 = ViewConfiguration.get(getContext());
        this.l = new c(r5.getScaledWindowTouchSlop(), r5.getScaledMinimumFlingVelocity(), r5.getScaledMaximumFlingVelocity());
    }
}

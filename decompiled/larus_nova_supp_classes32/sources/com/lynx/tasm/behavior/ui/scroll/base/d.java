package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.view.Choreographer;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements Runnable {
    public final f7a.a a;
    public c b;
    public int c;
    public int d;
    public b e;
    public LynxBaseScrollViewNested f;

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r3) {
            float r4 = r3 - 1.0f;
            return ((((r4 * r4) * r4) * r4) * r4) + 1.0f;
        }

        public a() {
        }
    }

    public class b implements Choreographer.FrameCallback {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r4) {
            d r5 = this.a;
            int r6 = r5.d;
            LynxBaseScrollViewNested r7 = r5.f;
            if (r6 < 0) goto L13;
            if (r7.c == false) goto L10;
            if (r7.getScrollOffsetVertically() >= r7.getScrollRangeVertically()[1]) goto L19;
        L20:
            boolean r8 = true;
        L21:
            if (r8 == false) goto L29;
            d r9 = this.a;
            int r10 = r9.d;
            LynxBaseScrollViewNested r11 = r9.f;
            if (r11.c == false) goto L25;
            int r2 = r11.getScrollY() + r10;
            int[] r12 = r11.getScrollRangeVertically();
            r11.h(Math.min(Math.max(r2, r12[0]), r12[1]));
        L27:
            if (this.a.e == null) goto L31;
            Choreographer.getInstance().postFrameCallback(this.a.e);
            return;
        L31:
            return;
        L25:
            int r3 = r11.getScrollX() + r10;
            int[] r13 = r11.getScrollRangeHorizontally();
            r11.g(Math.min(Math.max(r3, r13[0]), r13[1]));
            goto L27
        L29:
            this.a.h();
            return;
        L19:
            r8 = false;
            goto L21
        L10:
            if (r7.getScrollOffsetHorizontally() < r7.getScrollRangeHorizontally()[1]) goto L20;
        L13:
            if (r7.c == false) goto L18;
            if (r7.getScrollOffsetVertically() > r7.getScrollRangeVertically()[0]) goto L20;
        L18:
            if (r7.getScrollOffsetHorizontally() > r7.getScrollRangeHorizontally()[0]) goto L20;
            goto L19
        }
    }

    public interface c {
        void a(boolean r1);
    }

    public final void d() {
        if (this.a.b() == false) goto L11;
        LynxBaseScrollViewNested r0 = this.f;
        boolean r1 = r0.c;
        int r2 = 0;
        if (r1 == false) goto L7;
        int r4 = 0;
    L8:
        if (r1 == false) goto L10;
        f7a.a.C0091a r3 = this.a.c;
        r2 = r3.b - r3.c;
    L10:
        r0.k(r4, r2, this.c, null);
        f();
        return;
    L7:
        f7a.a.C0091a r5 = this.a.b;
        r4 = r5.b - r5.c;
        goto L8
    L11:
        g(true);
    }

    public final void f() {
        this.f.getView().removeCallbacks(this);
        ViewCompat.postOnAnimation(this.f.getView(), this);
    }

    public final void h() {
        if (this.e == null) goto L6;
        Choreographer.getInstance().removeFrameCallback(this.e);
        this.e = null;
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(Context r3) {
        this.c = 1;
        this.d = 0;
        this.e = null;
        this.a = new f7a.a(r3, new a());
    }

    public final void g(boolean r3) {
        this.f.getView().removeCallbacks(this);
        this.a.a();
        c r0 = this.b;
        if (r0 == null) goto L6;
        this.b = null;
        r0.a(r3);
        return;
    }

    public static int[] c(LynxBaseScrollViewNestedInternal r7, boolean r8, boolean r9) {
        int[] r0 = r7.b(r9);
        if (r9 == false) goto L5;
        int r1 = r7.getScrollOffsetVertically();
    L6:
        LynxBaseScrollViewNestedInternal r2 = r7.r5();
        if (r8 == false) goto L9;
        int r10 = r7.getForwardNestedScrollMode();
    L11:
        if (r10 == 1) goto L20;
        if (r10 != 2) goto L14;
        if (r2 == null) goto L23;
        int[] r11 = c(r2, r8, r9);
        r0[0] = r0[0] + r11[0];
        r0[1] = r0[1] + r11[1];
    L23:
        return new int[]{r0[0] - r1, r0[1] - r1};
    L14:
        if (r10 != 3) goto L23;
        if (r2 == null) goto L23;
        int[] r12 = c(r2, r8, r9);
        r0[0] = Math.max(r0[0], r12[0]);
        r0[1] = Math.max(r0[1], r12[1]);
        goto L23
    L20:
        if (r2 == null) goto L23;
        int[] r13 = c(r2, r8, r9);
        r0[0] = r0[0] + r13[0];
        r0[1] = r0[1] + r13[1];
        goto L23
    L9:
        r10 = r7.getBackwardNestedScrollMode();
        goto L11
    L5:
        r1 = r7.getScrollOffsetHorizontally();
        goto L6
    }

    public final void a(int r8, int r9, c r10) {
        g(false);
        f7a.a r1 = this.a;
        int r2 = this.f.getScrollX();
        int r3 = this.f.getScrollY();
        int r11 = r8 - this.f.getScrollX();
        int r12 = r9 - this.f.getScrollY();
        r1.a = 0;
        f7a.a.C0091a r4 = r1.b;
        r4.l = false;
        r4.a = r2;
        r4.c = r2;
        r4.b = r2;
        r4.d = r2 + r11;
        r4.h = AnimationUtils.currentAnimationTimeMillis();
        r4.i = 250;
        r4.g = 0.0f;
        r4.e = 0;
        f7a.a.C0091a r5 = r1.c;
        r5.l = false;
        r5.a = r3;
        r5.c = r3;
        r5.b = r3;
        r5.d = r3 + r12;
        r5.h = AnimationUtils.currentAnimationTimeMillis();
        r5.i = 250;
        r5.g = 0.0f;
        r5.e = 0;
        this.b = r10;
        this.c = 1;
        f();
    }

    public final void e(int r12, int r13, c r14) {
        g(false);
        LynxBaseScrollViewNested r1 = this.f;
        if (r1.c == false) goto L5;
        int r2 = 2;
    L6:
        r1.startNestedScroll(r2, 1);
        int[] r3 = this.f.getScrollOffset();
        this.f.getScrollRange();
        LynxBaseScrollViewNested r4 = this.f;
        boolean r5 = r4.c;
        this.b = r14;
        int r6 = r3[0];
        int r7 = r3[1];
        if (r5 == false) goto L10;
        if (r13 > 0) goto L11;
    L12:
        boolean r8 = false;
    L13:
        int[] r9 = c(r4, r8, r5);
        if (this.f.hasNestedScrollingParent(1) == false) goto L37;
        LynxBaseScrollViewNestedInternal r10 = this.f.r5();
        if (r5 == false) goto L18;
        int r11 = r13;
    L19:
        if (r11 == 0) goto L37;
        if ((r10 instanceof LynxBaseScrollViewNestedInternal) == false) goto L37;
        boolean r15 = ((LynxBaseScrollView) r10).c;
        if (r15 == false) goto L26;
        if (r13 > 0) goto L27;
    L28:
        boolean r16 = false;
    L29:
        int[] r17 = c(r10, r16, r15);
        if (r11 <= 0) goto L32;
        int r18 = this.f.getForwardNestedScrollMode();
    L34:
        if (r18 != 3) goto L37;
        r9[0] = Math.min(r9[0], r17[0]);
        r9[1] = Math.max(r9[1], r17[1]);
        goto L37
    L32:
        r18 = this.f.getBackwardNestedScrollMode();
    L27:
        r16 = true;
        goto L29
    L26:
        if (r12 <= 0) goto L28;
    L18:
        r11 = r12;
    L37:
        if (r5 == false) goto L39;
        int r0 = r9[0];
        int r19 = r3[1];
        int r20 = r0 + r19;
        int r21 = r9[1] + r19;
        int r22 = r6;
    L40:
        this.a.c(this.f.getScrollX(), this.f.getScrollY(), r12, r13, r6, r22, r20, r21, Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.c = 2147483632;
        f();
        return;
    L39:
        int r23 = r9[0];
        int r24 = r3[0];
        r6 = r23 + r24;
        r20 = r7;
        r21 = r20;
        r22 = r9[1] + r24;
    L11:
        r8 = true;
        goto L13
    L10:
        if (r12 <= 0) goto L12;
    L5:
        r2 = 1;
        goto L6
    }

    public final boolean i(LynxBaseScrollViewNestedInternal r5, boolean r6, c r7) {
        if (r5.d() == false) goto L18;
        if (r6 == false) goto L6;
        int r0 = r5.getScrollOffsetVertically();
    L7:
        if (r6 == false) goto L9;
        int[] r1 = r5.getScrollRangeVertically();
    L11:
        if (r5.a(r0, r1) == false) goto L15;
        b(r5, -10000, r6, r7);
        return true;
    L15:
        if (r5.c(r0, r1) == false) goto L22;
        b(r5, 10000, r6, r7);
        return true;
    L22:
        return false;
    L9:
        r1 = r5.getScrollRangeHorizontally();
        goto L11
    L6:
        r0 = r5.getScrollOffsetHorizontally();
        goto L7
    L18:
        LynxBaseScrollViewNestedInternal r8 = r5.r5();
        if (r8 != null) goto L21;
        return false;
    L21:
        return i(r8, r6, r7);
    }

    public final void b(h7a.b r29, int r30, boolean r31, c r32) {
        g(false);
        if (this.f.c == false) goto L5;
        int r2 = 2;
    L6:
        r29.startNestedScroll(r2, 1);
        if (r31 == false) goto L9;
        int r3 = r29.getScrollOffsetVertically();
    L10:
        if (r31 == false) goto L12;
        int[] r5 = r29.getScrollRangeVertically();
    L13:
        this.b = r32;
        if (r30 < 0) goto L23;
        f7a.a r6 = this.a;
        int r7 = r29.getScrollX();
        int r8 = r29.getScrollY();
        if (r31 == false) goto L18;
        int r9 = 0;
    L19:
        if (r31 == false) goto L21;
        int r10 = r30;
    L22:
        r6.c(r7, r8, r9, r10, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, (-r3) - r5[0], 0);
    L31:
        this.c = 2147483634;
        f();
        return;
    L21:
        r10 = 0;
        goto L22
    L18:
        r9 = r30;
        goto L19
    L23:
        f7a.a r11 = this.a;
        int r18 = r29.getScrollX();
        int r19 = r29.getScrollY();
        if (r31 == false) goto L26;
        int r20 = 0;
    L27:
        if (r31 == false) goto L29;
        int r21 = r30;
    L30:
        r11.c(r18, r19, r20, r21, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, r3 - r5[1]);
        goto L31
    L29:
        r21 = 0;
        goto L30
    L26:
        r20 = r30;
        goto L27
    L12:
        r5 = r29.getScrollRangeHorizontally();
        goto L13
    L9:
        r3 = r29.getScrollOffsetHorizontally();
        goto L10
    L5:
        r2 = 1;
        goto L6
    }
}

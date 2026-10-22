package hn;

import android.content.Context;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.bytedance.keva.KevaImpl;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNested;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fn.c f17346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f17347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17348c;
    public int d;
    public c7.e e;
    public LynxBaseScrollViewNested f;

    public g(Context r5) {
        this.f17348c = 1;
        this.d = 0;
        this.e = null;
        this.f17346a = new fn.c(r5, new com.obric.oui.panel.i(2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int[] e(LynxBaseScrollViewNestedInternal r10, boolean r11, boolean r12) {
        c r5 = (c) r10;
        if (r12 == false) goto L5;
        int r13 = r5.getScrollOffsetVertically();
    L6:
        if (r12 == false) goto L8;
        int[] r14 = r5.getScrollRangeVertically();
    L9:
        boolean r15 = r5.f17350b;
        if (r15 == false) goto L15;
        int r16 = r14[0];
        if (r13 >= r16) goto L14;
        int r17 = r13 - 50;
    L17:
        if (r15 == false) goto L22;
        int r18 = r14[1];
        if (r13 <= r18) goto L21;
        int r19 = r13 + 50;
    L23:
        int[] r20 = {r17, r19};
        if (r12 == false) goto L26;
        int r21 = r10.getScrollOffsetVertically();
    L27:
        ViewParent r22 = (ViewParent) ((LynxBaseScrollViewNested) r10).f10660l.d;
        if ((r22 instanceof LynxBaseScrollViewNestedInternal) == false) goto L30;
        LynxBaseScrollViewNestedInternal r23 = (LynxBaseScrollViewNestedInternal) r22;
    L31:
        if (r11 == false) goto L33;
        int r24 = r10.getForwardNestedScrollMode();
    L34:
        if (r24 == 1) goto L43;
        if (r24 != 2) goto L37;
        if (r23 == null) goto L46;
        int[] r25 = e(r23, r11, r12);
        r20[0] = r20[0] + r25[0];
        r20[1] = r20[1] + r25[1];
    L46:
        return new int[]{r20[0] - r21, r20[1] - r21};
    L37:
        if (r24 != 3) goto L46;
        if (r23 == null) goto L46;
        int[] r26 = e(r23, r11, r12);
        r20[0] = Math.max(r20[0], r26[0]);
        r20[1] = Math.max(r20[1], r26[1]);
        goto L46
    L43:
        if (r23 == null) goto L46;
        int[] r27 = e(r23, r11, r12);
        r20[0] = r20[0] + r27[0];
        r20[1] = r20[1] + r27[1];
        goto L46
    L33:
        r24 = r10.getBackwardNestedScrollMode();
        goto L34
    L30:
        r23 = null;
        goto L31
    L26:
        r21 = r10.getScrollOffsetHorizontally();
        goto L27
    L21:
        r19 = r18 + 300;
        goto L23
    L22:
        r19 = r14[1];
        goto L23
    L14:
        r17 = r16 - 300;
        goto L17
    L15:
        r17 = r14[0];
        goto L17
    L8:
        r14 = r5.getScrollRangeHorizontally();
        goto L9
    L5:
        r13 = r5.getScrollOffsetHorizontally();
        goto L6
    }

    public final void a(int r12, int r13, f r14) {
        c(false);
        LynxBaseScrollViewNested r5 = this.f;
        if (r5.f17351c == false) goto L5;
        int r10 = 2;
    L6:
        r5.startNestedScroll(r10, 1);
        int[] r11 = this.f.getScrollOffset();
        this.f.getScrollRange();
        LynxBaseScrollViewNested r15 = this.f;
        boolean r16 = r15.f17351c;
        this.f17347b = r14;
        int r17 = r11[0];
        int r18 = r11[1];
        if (r16 == false) goto L10;
        if (r13 > 0) goto L11;
    L12:
        boolean r19 = false;
    L13:
        int[] r20 = e(r15, r19, r16);
        if (this.f.hasNestedScrollingParent(1) == false) goto L39;
        ViewParent r21 = (ViewParent) this.f.f10660l.d;
        if ((r21 instanceof LynxBaseScrollViewNestedInternal) == false) goto L18;
        LynxBaseScrollViewNestedInternal r22 = (LynxBaseScrollViewNestedInternal) r21;
    L19:
        if (r16 == false) goto L21;
        int r23 = r13;
    L22:
        if (r23 == 0) goto L39;
        if (r22 == null) goto L39;
        boolean r24 = ((LynxBaseScrollView) r22).f17351c;
        if (r24 == false) goto L28;
        if (r13 > 0) goto L29;
    L30:
        boolean r110 = false;
    L31:
        int[] r25 = e(r22, r110, r24);
        if (r23 <= 0) goto L34;
        int r26 = this.f.getForwardNestedScrollMode();
    L36:
        if (r26 != 3) goto L39;
        r20[0] = Math.min(r20[0], r25[0]);
        r20[1] = Math.max(r20[1], r25[1]);
        goto L39
    L34:
        r26 = this.f.getBackwardNestedScrollMode();
    L29:
        r110 = true;
        goto L31
    L28:
        if (r12 <= 0) goto L30;
    L21:
        r23 = r12;
        goto L22
    L18:
        r22 = null;
    L39:
        if (r16 == false) goto L41;
        int r27 = r20[0];
        int r28 = r11[1];
        int r29 = r27 + r28;
        int r30 = r20[1] + r28;
        int r31 = r17;
    L42:
        this.f17346a.c(this.f.getScrollX(), this.f.getScrollY(), r12, r13, r17, r31, r29, r30, Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.f17348c = 2147483632;
        this.f.getView().removeCallbacks(this);
        ViewCompat.postOnAnimation(this.f.getView(), this);
        return;
    L41:
        int r32 = r20[0];
        int r33 = r11[0];
        r17 = r32 + r33;
        r29 = r18;
        r30 = r29;
        r31 = r20[1] + r33;
    L11:
        r19 = true;
        goto L13
    L10:
        if (r12 <= 0) goto L12;
    L5:
        r10 = 1;
        goto L6
    }

    public final void b(LynxBaseScrollViewNestedInternal r29, int r30, boolean r31, f r32) {
        c(false);
        if (this.f.f17351c == false) goto L5;
        int r5 = 2;
    L6:
        r29.startNestedScroll(r5, 1);
        if (r31 == false) goto L9;
        int r10 = r29.getScrollOffsetVertically();
    L10:
        if (r31 == false) goto L13;
        int[] r11 = r29.getScrollRangeVertically();
    L14:
        this.f17347b = r32;
        if (r30 < 0) goto L24;
        int r12 = r29.getScrollX();
        int r13 = r29.getScrollY();
        if (r31 == false) goto L19;
        int r14 = 0;
    L20:
        if (r31 == false) goto L22;
        int r15 = r30;
    L23:
        this.f17346a.c(r12, r13, r14, r15, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, (-r10) - r11[0], 0);
    L32:
        this.f17348c = 2147483634;
        this.f.getView().removeCallbacks(this);
        ViewCompat.postOnAnimation(this.f.getView(), this);
        return;
    L22:
        r15 = 0;
        goto L23
    L19:
        r14 = r30;
        goto L20
    L24:
        int r18 = r29.getScrollX();
        int r19 = r29.getScrollY();
        if (r31 == false) goto L27;
        int r20 = 0;
    L28:
        if (r31 == false) goto L30;
        int r21 = r30;
    L31:
        this.f17346a.c(r18, r19, r20, r21, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, r10 - r11[1]);
        goto L32
    L30:
        r21 = 0;
        goto L31
    L27:
        r20 = r30;
        goto L28
    L13:
        r11 = r29.getScrollRangeHorizontally();
        goto L14
    L9:
        r10 = r29.getScrollOffsetHorizontally();
        goto L10
    L5:
        r5 = 1;
        goto L6
    }

    public final void c(boolean r5) {
        this.f.getView().removeCallbacks(this);
        this.f17346a.a();
        f r10 = this.f17347b;
        if (r10 == null) goto L6;
        this.f17347b = null;
        r10.a(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d(LynxBaseScrollViewNestedInternal r10, boolean r11, f r12) {
        if (((i) r10).f17350b == false) goto L18;
        if (r11 == false) goto L6;
        int r5 = r10.getScrollOffsetVertically();
    L7:
        if (r11 == false) goto L9;
        int[] r13 = r10.getScrollRangeVertically();
    L11:
        if (r5 <= r13[1]) goto L15;
        b(r10, -10000, r11, r12);
        return true;
    L15:
        if (r5 >= r13[0]) goto L25;
        b(r10, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, r11, r12);
        return true;
    L25:
        return false;
    L9:
        r13 = r10.getScrollRangeHorizontally();
        goto L11
    L6:
        r5 = r10.getScrollOffsetHorizontally();
        goto L7
    L18:
        ViewParent r14 = (ViewParent) ((LynxBaseScrollViewNested) r10).f10660l.d;
        if ((r14 instanceof LynxBaseScrollViewNestedInternal) == false) goto L21;
        LynxBaseScrollViewNestedInternal r15 = (LynxBaseScrollViewNestedInternal) r14;
    L22:
        if (r15 == null) goto L25;
        return d(r15, r11, r12);
    L21:
        r15 = null;
        goto L22
    }

    @Override // java.lang.Runnable
    public final void run() {
        fn.c r5 = this.f17346a;
        if (r5.e() == false) goto L12;
        LynxBaseScrollViewNested r10 = this.f;
        boolean r11 = r10.f17351c;
        int r12 = 0;
        if (r11 == false) goto L7;
        int r13 = 0;
    L8:
        if (r11 == false) goto L10;
        fn.b r14 = (fn.b) r5.f16949c;
        r12 = r14.f16936b - r14.f16937c;
    L10:
        r10.g(r13, r12, this.f17348c, null);
        this.f.getView().removeCallbacks(this);
        ViewCompat.postOnAnimation(this.f.getView(), this);
        return;
    L7:
        fn.b r15 = (fn.b) r5.f16948b;
        r13 = r15.f16936b - r15.f16937c;
        goto L8
    L12:
        c(true);
    }
}

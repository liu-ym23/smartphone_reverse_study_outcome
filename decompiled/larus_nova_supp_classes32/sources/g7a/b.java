package g7a;

import android.view.View;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParentHelper;
import com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView;
import com.lynx.tasm.behavior.ui.scroll.NestedScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final boolean a;
    public boolean b;
    public boolean c;
    public final View d;
    public int e;
    public int f;
    public final NestedScrollingParentHelper g;

    public final void a() {
        int r0 = this.d.getScrollX();
        int r1 = this.d.getScrollY();
        boolean r2 = this.a;
        if (r2 == true) goto L12;
        View r4 = this.d;
        if ((r4 instanceof NestedHorizontalScrollView) == false) goto L12;
        NestedHorizontalScrollView r5 = (NestedHorizontalScrollView) r4;
        if (this.b == false) goto L10;
        r5.b(this.f, r1);
        this.b = false;
        return;
    L10:
        if (this.c == false) goto L23;
        r5.b(this.f, r1);
        this.c = false;
        return;
    L23:
        return;
    L12:
        if (r2 == false) goto L25;
        View r3 = this.d;
        if ((r3 instanceof NestedScrollView) == false) goto L26;
        NestedScrollView r6 = (NestedScrollView) r3;
        if (this.b == false) goto L19;
        r6.a(r0, this.f);
        this.b = false;
        return;
    L19:
        if (this.c == false) goto L28;
        r6.a(r0, this.f);
        this.c = false;
        return;
    L28:
        return;
    L26:
        return;
    }

    public final boolean b() {
        boolean r0 = this.a;
        if (r0 == true) goto L11;
        View r2 = this.d;
        if ((r2 instanceof NestedHorizontalScrollView) == false) goto L11;
        OverScroller r1 = ((NestedHorizontalScrollView) r2).getHScroller();
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.isFinished() == true) goto L21;
        return true;
    L21:
        return false;
    L11:
        if (r0 == false) goto L22;
        View r3 = this.d;
        if ((r3 instanceof NestedScrollView) == false) goto L23;
        OverScroller r4 = ((NestedScrollView) r3).getVScroller();
        if (r4 != null) goto L17;
        return false;
    L17:
        if (r4.isFinished() == true) goto L25;
        return true;
    L25:
        return false;
    L23:
        return false;
    L22:
        return false;
    }

    public final void e(int r6) {
        int r0 = this.d.getScrollX();
        int r1 = this.d.getScrollY();
        if (1 != r6) goto L5;
        return;
    L5:
        boolean r2 = this.a;
        if (r2 == true) goto L13;
        View r3 = this.d;
        if ((r3 instanceof NestedHorizontalScrollView) == false) goto L13;
        NestedHorizontalScrollView r4 = (NestedHorizontalScrollView) r3;
        int r5 = this.f;
        if (r0 == r5) goto L12;
        r4.b(r5, r1);
    L12:
        r4.stopNestedScroll(r6);
        return;
    L13:
        if (r2 == false) goto L22;
        View r7 = this.d;
        if ((r7 instanceof NestedScrollView) == false) goto L23;
        NestedScrollView r8 = (NestedScrollView) r7;
        int r9 = this.f;
        if (r1 == r9) goto L19;
        r8.a(r0, r9);
    L19:
        r8.stopNestedScroll(r6);
        return;
    L23:
        return;
    }

    public b(View r1, boolean r2, NestedScrollingParentHelper r3) {
        this.d = r1;
        this.a = r2;
        this.g = r3;
    }

    public final void c(View r8, int r9, int r10, int[] r11, int r12) {
        if (1 != r12) goto L5;
        return;
    L5:
        int r13 = this.d.getScrollX();
        int r1 = this.d.getScrollY();
        boolean r2 = this.a;
        if (r2 == true) goto L40;
        View r5 = this.d;
        if ((r5 instanceof NestedHorizontalScrollView) == false) goto L40;
        NestedHorizontalScrollView r6 = (NestedHorizontalScrollView) r5;
        int r14 = this.e;
        int r3 = this.f;
        if (r8.canScrollHorizontally(-1) == true) goto L17;
        if (r9 >= 0) goto L17;
        if ((r13 + r9) >= 0) goto L15;
        r6.scrollTo(0, r1);
    L16:
        r11[0] = r9;
    L25:
        if (r8.canScrollHorizontally(1) == true) goto L32;
        if (r9 <= 0) goto L32;
        if ((r13 + r9) <= r14) goto L30;
        r6.scrollTo(r14, r1);
    L31:
        r11[0] = r9;
        return;
    L30:
        r6.requestDisallowInterceptTouchEvent(true);
        r6.scrollBy(r9, 0);
    L32:
        if (r3 >= r13) goto L76;
        if (r13 > r14) goto L77;
        if (r9 >= 0) goto L78;
        r6.requestDisallowInterceptTouchEvent(true);
        if ((r13 + r9) >= r3) goto L38;
        r6.scrollBy(r3 - r13, 0);
    L39:
        r11[0] = r9;
        return;
    L38:
        r6.scrollBy(r9, 0);
        goto L39
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L15:
        r6.requestDisallowInterceptTouchEvent(true);
        r6.scrollBy(r9, 0);
    L17:
        if (r13 >= r3) goto L25;
        if (r9 <= 0) goto L25;
        r6.requestDisallowInterceptTouchEvent(true);
        if ((r13 + r9) <= r3) goto L22;
        r6.scrollBy(r3 - r13, 0);
    L23:
        r11[0] = r9;
        goto L25
    L22:
        r6.scrollBy(r9, 0);
    L40:
        if (r2 == false) goto L80;
        View r15 = this.d;
        if ((r15 instanceof NestedScrollView) == false) goto L81;
        NestedScrollView r16 = (NestedScrollView) r15;
        int r4 = this.e;
        int r7 = this.f;
        if (r8.canScrollVertically(-1) == true) goto L51;
        if (r10 >= 0) goto L51;
        if ((r1 + r10) >= 0) goto L49;
        r16.scrollTo(r13, 0);
    L50:
        r11[1] = r10;
    L59:
        if (r8.canScrollVertically(1) == true) goto L66;
        if (r10 <= 0) goto L66;
        if ((r1 + r10) <= r4) goto L64;
        r16.scrollTo(r13, r4);
    L65:
        r11[1] = r10;
        return;
    L64:
        r16.requestDisallowInterceptTouchEvent(true);
        r16.scrollBy(0, r10);
    L66:
        if (r7 >= r1) goto L83;
        if (r1 > r4) goto L84;
        if (r10 >= 0) goto L85;
        r16.requestDisallowInterceptTouchEvent(true);
        if ((r1 + r10) >= r7) goto L72;
        r16.scrollBy(0, r7 - r1);
    L73:
        r11[1] = r10;
        return;
    L72:
        r16.scrollBy(0, r10);
        goto L73
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L49:
        r16.requestDisallowInterceptTouchEvent(true);
        r16.scrollBy(0, r10);
    L51:
        if (r1 >= r7) goto L59;
        if (r10 <= 0) goto L59;
        r16.requestDisallowInterceptTouchEvent(true);
        if ((r1 + r10) <= r7) goto L56;
        r16.scrollBy(0, r7 - r1);
    L57:
        r11[1] = r10;
        goto L59
    L56:
        r16.scrollBy(0, r10);
        goto L57
    L81:
        return;
    }

    public final void d(int r7, int r8, int r9, int r10, int r11) {
        if (r11 != 0) goto L4;
        return;
    L4:
        int r12 = this.d.getScrollX();
        int r0 = this.d.getScrollY();
        boolean r1 = this.a;
        if (r1 == true) goto L31;
        View r4 = this.d;
        if ((r4 instanceof NestedHorizontalScrollView) == false) goto L31;
        NestedHorizontalScrollView r5 = (NestedHorizontalScrollView) r4;
        OverScroller r13 = r5.getHScroller();
        if (r13 != null) goto L11;
        return;
    L11:
        int r14 = this.e;
        int r2 = this.f;
        boolean r6 = this.b;
        if (r6 == true) goto L16;
        if (r7 >= 0) goto L16;
        if (r9 >= 0) goto L16;
        r5.b(0, r0);
        this.b = true;
    L21:
        boolean r15 = this.c;
        if (r15 == true) goto L26;
        if (r7 <= 0) goto L26;
        if (r9 <= 0) goto L26;
        r5.b(r14, r0);
        this.c = true;
        return;
    L26:
        if (r15 == false) goto L59;
        if (r12 == r14) goto L29;
        return;
    L29:
        if (r13.isFinished() == false) goto L61;
        r5.b(r2, r0);
        this.c = false;
        return;
    L61:
        return;
    L59:
        return;
    L16:
        if (r6 == false) goto L21;
        if (r12 != 0) goto L21;
        if (r13.isFinished() == false) goto L21;
        r5.b(r2, r0);
        this.b = false;
    L31:
        if (r1 == false) goto L63;
        View r16 = this.d;
        if ((r16 instanceof NestedScrollView) == false) goto L64;
        NestedScrollView r17 = (NestedScrollView) r16;
        OverScroller r18 = r17.getVScroller();
        if (r18 != null) goto L37;
        return;
    L37:
        int r3 = this.e;
        int r19 = this.f;
        boolean r20 = this.b;
        if (r20 == true) goto L42;
        if (r8 >= 0) goto L42;
        if (r10 >= 0) goto L42;
        r17.a(r12, 0);
        this.b = true;
    L47:
        boolean r21 = this.c;
        if (r21 == true) goto L52;
        if (r8 <= 0) goto L52;
        if (r10 <= 0) goto L52;
        r17.a(r12, r3);
        this.c = true;
        return;
    L52:
        if (r21 == false) goto L66;
        if (r0 == r3) goto L55;
        return;
    L55:
        if (r18.isFinished() == false) goto L68;
        r17.a(r12, r19);
        this.c = false;
        return;
    L68:
        return;
    L66:
        return;
    L42:
        if (r20 == false) goto L47;
        if (r0 != 0) goto L47;
        if (r18.isFinished() == false) goto L47;
        r17.a(r12, r19);
        this.b = false;
        goto L47
    L64:
        return;
    }
}

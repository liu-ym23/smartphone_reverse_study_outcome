package gn;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParentHelper;
import com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView;
import com.lynx.tasm.behavior.ui.scroll.NestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17112c;
    public final FrameLayout d;
    public int e;
    public int f;
    public final NestedScrollingParentHelper g;

    public c(FrameLayout r5, boolean r10, NestedScrollingParentHelper r11) {
        this.d = r5;
        this.f17110a = r10;
        this.g = r11;
    }

    public final void a() {
        FrameLayout r5 = this.d;
        int r10 = r5.getScrollX();
        int r11 = r5.getScrollY();
        boolean r12 = this.f17110a;
        if (r12 == false) goto L5;
    L14:
        if (r12 == true) goto L16;
        return;
    L16:
        if ((r5 instanceof NestedScrollView) == false) goto L27;
        NestedScrollView r13 = (NestedScrollView) r5;
        if (this.f17111b == false) goto L22;
        r13.a(r10, this.f);
        this.f17111b = false;
        return;
    L22:
        if (this.f17112c == false) goto L28;
        r13.a(r10, this.f);
        this.f17112c = false;
        return;
    L28:
        return;
    L27:
        return;
    L5:
        if ((r5 instanceof NestedHorizontalScrollView) == false) goto L14;
        NestedHorizontalScrollView r14 = (NestedHorizontalScrollView) r5;
        if (this.f17111b == false) goto L11;
        r14.a(this.f, r11);
        this.f17111b = false;
        return;
    L11:
        if (this.f17112c == false) goto L25;
        r14.a(this.f, r11);
        this.f17112c = false;
        return;
    }

    public final void b(int r10) {
        FrameLayout r5 = this.d;
        int r11 = r5.getScrollX();
        int r12 = r5.getScrollY();
        if (1 == r10) goto L24;
        boolean r13 = this.f17110a;
        if (r13 == false) goto L8;
    L14:
        if (r13 == true) goto L16;
        return;
    L16:
        if ((r5 instanceof NestedScrollView) == false) goto L23;
        NestedScrollView r14 = (NestedScrollView) r5;
        int r15 = this.f;
        if (r12 == r15) goto L20;
        r14.a(r11, r15);
    L20:
        r14.f10631b.stopNestedScroll(r10);
        return;
    L23:
        return;
    L8:
        if ((r5 instanceof NestedHorizontalScrollView) == false) goto L14;
        NestedHorizontalScrollView r16 = (NestedHorizontalScrollView) r5;
        int r17 = this.f;
        if (r11 == r17) goto L12;
        r16.a(r17, r12);
    L12:
        r16.f10628q.stopNestedScroll(r10);
        return;
    }

    public final void c(int r10, int r11, int r12, int r13, int r14) {
        if (r14 == 0) goto L69;
        FrameLayout r15 = this.d;
        int r5 = r15.getScrollX();
        int r16 = r15.getScrollY();
        boolean r17 = this.f17110a;
        if (r17 == false) goto L7;
    L33:
        if (r17 == true) goto L35;
        return;
    L35:
        if ((r15 instanceof NestedScrollView) == false) goto L65;
        NestedScrollView r18 = (NestedScrollView) r15;
        OverScroller r19 = r18.getVScroller();
        if (r19 == null) goto L71;
        int r20 = this.e;
        int r21 = this.f;
        boolean r22 = this.f17111b;
        if (r22 == true) goto L44;
        if (r11 >= 0) goto L44;
        if (r13 >= 0) goto L44;
        r18.a(r5, 0);
        this.f17111b = true;
    L49:
        boolean r23 = this.f17112c;
        if (r23 == true) goto L55;
        if (r11 <= 0) goto L55;
        if (r13 <= 0) goto L55;
        r18.a(r5, r20);
        this.f17112c = true;
        return;
    L55:
        if (r23 == false) goto L66;
        if (r16 == r20) goto L58;
        return;
    L58:
        if (r19.isFinished() == false) goto L68;
        r18.a(r5, r21);
        this.f17112c = false;
        return;
    L68:
        return;
    L66:
        return;
    L44:
        if (r22 == false) goto L49;
        if (r16 != 0) goto L49;
        if (r19.isFinished() == false) goto L49;
        r18.a(r5, r21);
        this.f17111b = false;
        goto L49
    L71:
        return;
    L65:
        return;
    L7:
        if ((r15 instanceof NestedHorizontalScrollView) == false) goto L33;
        NestedHorizontalScrollView r110 = (NestedHorizontalScrollView) r15;
        OverScroller r24 = r110.getHScroller();
        if (r24 == null) goto L70;
        int r111 = this.e;
        int r25 = this.f;
        boolean r26 = this.f17111b;
        if (r26 == true) goto L16;
        if (r10 >= 0) goto L16;
        if (r12 >= 0) goto L16;
        r110.a(0, r16);
        this.f17111b = true;
    L21:
        boolean r27 = this.f17112c;
        if (r27 == true) goto L27;
        if (r10 <= 0) goto L27;
        if (r12 <= 0) goto L27;
        r110.a(r111, r16);
        this.f17112c = true;
        return;
    L27:
        if (r27 == false) goto L61;
        if (r5 == r111) goto L30;
        return;
    L30:
        if (r24.isFinished() == false) goto L63;
        r110.a(r25, r16);
        this.f17112c = false;
        return;
    L63:
        return;
    L61:
        return;
    L16:
        if (r26 == false) goto L21;
        if (r5 != 0) goto L21;
        if (r24.isFinished() == false) goto L21;
        r110.a(r25, r16);
        this.f17111b = false;
        goto L21
    L70:
        return;
    }

    public final void d(View r10, int r11, int r12, int[] r13, int r14) {
        if (1 == r14) goto L86;
        FrameLayout r15 = this.d;
        int r5 = r15.getScrollX();
        int r16 = r15.getScrollY();
        boolean r17 = this.f17110a;
        if (r17 == false) goto L8;
    L42:
        if (r17 == true) goto L44;
        return;
    L44:
        if ((r15 instanceof NestedScrollView) == false) goto L82;
        NestedScrollView r18 = (NestedScrollView) r15;
        int r19 = this.e;
        int r20 = this.f;
        if (r10.canScrollVertically(-1) == true) goto L53;
        if (r12 >= 0) goto L53;
        if ((r16 + r12) >= 0) goto L51;
        r18.scrollTo(r5, 0);
    L52:
        r13[1] = r12;
    L61:
        if (r10.canScrollVertically(1) == true) goto L69;
        if (r12 <= 0) goto L69;
        if ((r16 + r12) <= r19) goto L66;
        r18.scrollTo(r5, r19);
    L67:
        r13[1] = r12;
        return;
    L66:
        r18.requestDisallowInterceptTouchEvent(true);
        r18.scrollBy(0, r12);
    L69:
        if (r20 >= r16) goto L83;
        if (r16 > r19) goto L84;
        if (r12 >= 0) goto L85;
        r18.requestDisallowInterceptTouchEvent(true);
        if ((r16 + r12) >= r20) goto L75;
        r18.scrollBy(0, r20 - r16);
    L76:
        r13[1] = r12;
        return;
    L75:
        r18.scrollBy(0, r12);
        goto L76
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L51:
        r18.requestDisallowInterceptTouchEvent(true);
        r18.scrollBy(0, r12);
    L53:
        if (r16 >= r20) goto L61;
        if (r12 <= 0) goto L61;
        r18.requestDisallowInterceptTouchEvent(true);
        if ((r16 + r12) <= r20) goto L58;
        r18.scrollBy(0, r20 - r16);
    L59:
        r13[1] = r12;
        goto L61
    L58:
        r18.scrollBy(0, r12);
        goto L59
    L82:
        return;
    L8:
        if ((r15 instanceof NestedHorizontalScrollView) == false) goto L42;
        NestedHorizontalScrollView r110 = (NestedHorizontalScrollView) r15;
        int r111 = this.e;
        int r21 = this.f;
        if (r10.canScrollHorizontally(-1) == true) goto L17;
        if (r11 >= 0) goto L17;
        if ((r5 + r11) >= 0) goto L15;
        r110.scrollTo(0, r16);
    L16:
        r13[0] = r11;
    L25:
        if (r10.canScrollHorizontally(1) == true) goto L33;
        if (r11 <= 0) goto L33;
        if ((r5 + r11) <= r111) goto L30;
        r110.scrollTo(r111, r16);
    L31:
        r13[0] = r11;
        return;
    L30:
        r110.requestDisallowInterceptTouchEvent(true);
        r110.scrollBy(r11, 0);
    L33:
        if (r21 >= r5) goto L78;
        if (r5 > r111) goto L79;
        if (r11 >= 0) goto L80;
        r110.requestDisallowInterceptTouchEvent(true);
        if ((r5 + r11) >= r21) goto L39;
        r110.scrollBy(r21 - r5, 0);
    L40:
        r13[0] = r11;
        return;
    L39:
        r110.scrollBy(r11, 0);
        goto L40
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L15:
        r110.requestDisallowInterceptTouchEvent(true);
        r110.scrollBy(r11, 0);
    L17:
        if (r5 >= r21) goto L25;
        if (r11 <= 0) goto L25;
        r110.requestDisallowInterceptTouchEvent(true);
        if ((r5 + r11) <= r21) goto L22;
        r110.scrollBy(r21 - r5, 0);
    L23:
        r13[0] = r11;
        goto L25
    L22:
        r110.scrollBy(r11, 0);
        goto L23
    }

    public final boolean e() {
        FrameLayout r5 = this.d;
        boolean r10 = this.f17110a;
        if (r10 == false) goto L5;
    L11:
        if (r10 == true) goto L13;
        return false;
    L13:
        if ((r5 instanceof NestedScrollView) == false) goto L23;
        OverScroller r11 = ((NestedScrollView) r5).getVScroller();
        if (r11 != null) goto L17;
        return false;
    L17:
        if (r11.isFinished() == true) goto L25;
        return true;
    L25:
        return false;
    L23:
        return false;
    L5:
        if ((r5 instanceof NestedHorizontalScrollView) == false) goto L11;
        OverScroller r12 = ((NestedHorizontalScrollView) r5).getHScroller();
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.isFinished() == true) goto L21;
        return true;
    L21:
        return false;
    }
}

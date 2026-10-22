package com.lynx.tasm.behavior.ui.swiper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ViewPager extends ViewGroup {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public final int G;
    public float H;
    public boolean H0;
    public float I;
    public float J;
    public float K;
    public b L;
    public boolean L0;
    public int M;
    public int N;
    public int O;
    public int P;
    public int P0;
    public int Q;
    public int R;
    public int S;
    public int T;
    public final List<d> U;
    public boolean V;
    public float V0;
    public boolean W;
    public boolean a;
    public boolean b;
    public float b1;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int g1;
    public int h;
    public final GestureDetector h1;
    public final Scroller i;
    public boolean j;
    public boolean k;
    public boolean k0;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean p0;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public e w;
    public final int x;
    public final int y;
    public final float z;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ ViewPager a;

        public a(ViewPager r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r4) {
            this.a.i.abortAnimation();
            ViewPager r0 = this.a;
            r0.F = 0;
            r0.D = true;
            r0.A = false;
            float r1 = r4.getX();
            r0.J = r1;
            r0.H = r1;
            ViewPager r2 = this.a;
            float r3 = r4.getY();
            r2.K = r3;
            r2.I = r3;
            ViewPager r5 = this.a;
            r5.E = r4.getPointerId(r4.getActionIndex());
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            boolean r0 = super.onFling(r4, r5, r6, r7);
            if (this.a.m() == false) goto L9;
            int r1 = this.a.y;
            if (r7 < (-r1)) goto L9;
            if (r7 > r1) goto L9;
        L14:
            return r0;
        L9:
            if (this.a.m() == true) goto L15;
            int r2 = this.a.x;
            if (r6 < (-r2)) goto L15;
            if (r6 <= r2) goto L14;
        L15:
            ViewPager r3 = this.a;
            r3.A = true;
            r3.i.abortAnimation();
            ViewPager.a(this.a, r6, r7);
            return super.onFling(r4, r5, r6, r7);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r5, MotionEvent r6, float r7, float r8) {
            ViewPager r0 = this.a;
            if (r0.B == false) goto L5;
        L22:
            ViewPager r9 = this.a;
            if (r9.B == false) goto L36;
            int r10 = r6.findPointerIndex(r9.E);
            float r11 = r6.getX(r10);
            float r12 = r6.getY(r10);
            ViewPager r13 = this.a;
            float r14 = r13.H - r11;
            float r1 = r13.I - r12;
            float r2 = r13.F;
            if (r13.m() == false) goto L27;
            float r3 = r1;
        L28:
            r13.F = (int) (r2 + r3);
            ViewPager r15 = this.a;
            r15.H = r11;
            r15.I = r12;
            if (r15.D == false) goto L32;
            r15.w();
            this.a.D = false;
        L32:
            if (this.a.m() == false) goto L34;
            this.a.scrollBy(0, (int) (((double) r1) + 0.5d));
            goto L36
        L34:
            this.a.scrollBy((int) (((double) r14) + 0.5d), 0);
            goto L36
        L27:
            r3 = r14;
        L36:
            return this.a.B;
        L5:
            if (r6.findPointerIndex(r0.E) == (-1)) goto L7;
            float r16 = Math.abs(r7);
            float r4 = Math.abs(r8);
            if (this.a.m() == false) goto L15;
            if (r4 <= r16) goto L15;
            if (this.a.e((int) r8) == false) goto L15;
        L20:
            ViewPager r17 = this.a;
            r17.B = true;
            ViewPager.b(r17);
            this.a.r(true);
        L15:
            if (this.a.m() == false) goto L17;
        L21:
            this.a.r(false);
            goto L22
        L17:
            if (r16 <= r4) goto L21;
            if (this.a.d((int) r7) == false) goto L21;
        L7:
            return super.onScroll(r5, r6, r7, r8);
        }
    }

    public interface b {
    }

    public static class c extends ViewGroup.LayoutParams {
        public int a;

        public c() {
            super(-1, -1);
        }
    }

    public interface d {
        void a(boolean r1, boolean r2);

        void b(boolean r1, float r2, float r3);

        void c(int r1, boolean r2);

        void d(int r1);

        void e(int r1, boolean r2);

        void onPageScrollStateChanged(int r1);
    }

    public interface e {
        void a(View r1);

        void b(ViewPager r1, View r2, boolean r3, int r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        setScrollState(0);
        Scroller r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isFinished() == true) goto L7;
        this.i.abortAnimation();
        goto L7
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.i.computeScrollOffset() == false) goto L18;
        if (m() == false) goto L7;
        int r0 = this.i.getFinalY();
    L8:
        this.g1 = r0;
        int r1 = getScrollX();
        int r2 = getScrollY();
        int r3 = this.i.getCurrX();
        int r4 = this.i.getCurrY();
        if (m() == false) goto L13;
        if (r2 == r4) goto L13;
        scrollTo(r1, r4);
    L16:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L13:
        if (m() == true) goto L16;
        if (r1 == r3) goto L16;
        scrollTo(r3, r2);
        goto L16
    L7:
        r0 = this.i.getFinalX();
        goto L8
    L18:
        if (getChildCount() > 0) goto L20;
        return;
    L20:
        if (this.v == 1) goto L52;
        int r5 = ((c) getCurrentView().getLayoutParams()).a;
        this.f = r5;
        if (this.g == r5) goto L28;
        Iterator r6 = ((ArrayList) this.U).iterator();
    L25:
        if (r6.hasNext() == false) goto L28;
        ((d) r6.next()).e(this.f, this.k);
    L28:
        if (this.r == false) goto L33;
        if (this.s == false) goto L33;
        this.n = false;
        this.s = false;
        requestLayout();
    L33:
        if (this.k == true) goto L42;
        if (this.j == false) goto L42;
        Iterator r7 = ((ArrayList) this.U).iterator();
    L38:
        if (r7.hasNext() == false) goto L40;
        ((d) r7.next()).d(this.f);
        goto L38
    L40:
        this.j = false;
    L42:
        if (this.g == (-1)) goto L44;
    L46:
        this.g = this.f;
        setScrollState(0);
        return;
    L44:
        if (this.f == (-1)) goto L46;
        this.k = false;
        goto L46
    }

    public final void f() {
        if (this.L != null) goto L5;
        return;
    L5:
        if (this.e <= 0) goto L34;
        boolean r1 = false;
        if (this.b == false) goto L9;
    L14:
        boolean r0 = true;
    L16:
        if (this.H0 == false) goto L19;
        if (r0 == true) goto L19;
        return;
    L19:
        u(this.N, r0);
        int r2 = this.h;
        if (r2 != (-1)) goto L22;
    L24:
        r2 = this.f;
        if (r2 != (-1)) goto L28;
        r2 = -1;
    L28:
        if (r2 >= 0) goto L30;
        return;
    L30:
        if (r2 >= this.e) goto L36;
        t(r2, r1, 1);
        return;
    L36:
        return;
    L22:
        if (r2 == this.f) goto L24;
        r1 = this.a;
        goto L28
    L9:
        if (this.c == true) goto L14;
        if (this.d == true) goto L14;
        r0 = false;
        goto L16
    }

    public final boolean g() {
        if (this.V == true) goto L5;
    L28:
        return false;
    L5:
        if (this.n == true) goto L28;
        if (this.k == true) goto L28;
        float r0 = this.V0;
        if (r0 <= 0.0f) goto L28;
        if (r0 >= 1.0f) goto L28;
        if (this.L == null) goto L28;
        if (this.b1 >= 0.0f) goto L20;
        if (this.e < 2) goto L28;
    L22:
        if (this.d == true) goto L28;
        if (this.b == true) goto L28;
        if (this.c == true) goto L28;
        return true;
    L20:
        if (this.e < 3) goto L28;
        goto L28
    }

    public int getChildExpectSize() {
        int r0 = this.M;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return getContentSize();
    }

    public final boolean h() {
        if (this.V == true) goto L5;
    L28:
        return false;
    L5:
        if (this.n == true) goto L28;
        if (this.k == true) goto L28;
        float r0 = this.b1;
        if (r0 <= 0.0f) goto L28;
        if (r0 >= 1.0f) goto L28;
        if (this.L == null) goto L28;
        if (this.V0 >= 0.0f) goto L20;
        if (this.e < 2) goto L28;
    L22:
        if (this.d == true) goto L28;
        if (this.b == true) goto L28;
        if (this.c == true) goto L28;
        return true;
    L20:
        if (this.e < 3) goto L28;
        goto L28
    }

    public final boolean l() {
        if (this.o == true) goto L5;
    L7:
        return false;
    L5:
        if (this.u != 0) goto L7;
        return true;
    }

    public final boolean m() {
        if (this.u == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void q() {
        if (this.e >= 1) goto L5;
        return;
    L5:
        int r0 = getChildExpectSize();
        if (r0 > 0) goto L8;
        return;
    L8:
        int r2 = getScrollDistance();
        int r3 = this.R + r0;
        if (r3 > 0) goto L11;
        return;
    L11:
        int r4 = r2 / r3;
        int r5 = r2 % r3;
        if (l() == false) goto L39;
        if (this.n == false) goto L28;
        if (r2 <= 0) goto L24;
        if (r5 == 0) goto L18;
        r4 = r4 + 1;
    L19:
        int r1 = (getWidth() + r2) - r5;
        if (r5 != 0) goto L22;
        int r6 = 0;
    L23:
        int r7 = r1 + r6;
    L25:
        int r8 = this.e;
        int r9 = (r8 - r4) % r8;
        if (r9 >= 0) goto L37;
        r9 = r9 + r8;
    L37:
        int r10 = r7;
        int r11 = 0;
    L59:
        int r12 = Math.max(0, getPageGap()) + r2;
        ArrayList r13 = new ArrayList();
        if (this.p == true) goto L81;
        List<View> r14 = getAllChildren();
    L62:
        View r15 = k(r9);
        r14.remove(r15);
        if (l() == false) goto L65;
        r11 = r10 - r0;
    L66:
        p(r15, r11, r10);
        v();
        if (l() == false) goto L71;
        if (r11 <= r2) goto L78;
        r10 = r11 - this.R;
    L74:
        int r16 = r9 + 1;
        int r17 = this.e;
        if (r16 < r17) goto L79;
        if (this.n == false) goto L78;
    L79:
        r9 = r16 % r17;
    L78:
        List r18 = r14;
    L135:
        Iterator r19 = r18.iterator();
    L137:
        if (r19.hasNext() == false) goto L143;
        View r20 = (View) r19.next();
        boolean r21 = this.p;
        e r22 = this.w;
        if (r22 == null) goto L141;
        r22.a(r20);
    L141:
        if (r21 == true) goto L137;
        removeView(r20);
        int r23 = ((c) r20.getLayoutParams()).a;
        this.L.getClass();
        goto L137
    L143:
        return;
    L71:
        if (r10 >= r12) goto L78;
        r11 = this.R + r10;
        goto L74
    L65:
        r10 = r11 + r0;
        goto L66
    L81:
        if (this.n == true) goto L116;
        int r24 = r9 - 1;
        int r25 = r11;
        int r26 = r10;
    L83:
        if (r24 < 0) goto L99;
        View r110 = k(r24);
        if (l() == false) goto L87;
        int r27 = r26 + this.R;
        int r28 = r27 + r0;
    L88:
        int r111 = r27;
        r26 = r28;
        r25 = r111;
        if (l() == false) goto L93;
        if ((r25 - this.R) < r12) goto L93;
    L96:
        r13.add(r110);
    L97:
        p(r110, r25, r26);
        r24 = r24 - 1;
    L93:
        if (l() == true) goto L97;
        if ((this.R + r26) > r2) goto L97;
    L87:
        r28 = r25 - this.R;
        r27 = r28 - r0;
    L99:
        if (r9 >= this.e) goto L134;
        View r29 = k(r9);
        if (l() == false) goto L103;
        r11 = r10 - r0;
    L105:
        if (l() == false) goto L108;
        if (r10 > r2) goto L108;
    L110:
        r13.add(r29);
    L111:
        p(r29, r11, r10);
        if (l() == false) goto L114;
        r10 = r11 - this.R;
    L115:
        r9 = r9 + 1;
        goto L99
    L114:
        r11 = this.R + r10;
    L108:
        if (l() == true) goto L111;
        if (r11 < r12) goto L111;
    L103:
        r10 = r11 + r0;
    L134:
        v();
        r18 = r13;
        goto L135
    L116:
        int r30 = r9;
    L117:
        View r31 = k(r30);
        if (l() == false) goto L120;
        r11 = r10 - r0;
    L122:
        if (l() == false) goto L125;
        if (r10 > r2) goto L125;
    L127:
        r13.add(r31);
    L128:
        p(r31, r11, r10);
        if (l() == false) goto L131;
        r10 = r11 - this.R;
    L132:
        r30 = (r30 + 1) % this.e;
        if (r30 != r9) goto L117;
    L131:
        r11 = this.R + r10;
    L125:
        if (l() == true) goto L128;
        if (r11 < r12) goto L128;
    L120:
        r10 = r11 + r0;
        goto L122
    L22:
        r6 = this.R + r0;
        goto L23
    L18:
        r4 = r4 % this.e;
        goto L19
    L24:
        r7 = (getWidth() + r2) - r5;
        goto L25
    L28:
        int r32 = getPaddingRight() - this.N;
        int r33 = 0;
    L30:
        if (r33 >= (this.e - 1)) goto L35;
        int r34 = r33 + 1;
        if (r2 < (((this.T - r32) + getWidth()) - (r34 * r3))) goto L36;
        r33 = r34;
    L36:
        r7 = ((this.T - r32) + getWidth()) - (r3 * r33);
        r9 = r33;
        goto L37
    L35:
        r33 = 0;
        goto L36
    L39:
        if (this.n == false) goto L49;
        if (r2 >= 0) goto L48;
        if (r5 == 0) goto L43;
        r4 = r4 - 1;
    L43:
        int r35 = this.e;
        r9 = ((r4 % r35) + r35) % r35;
        if (r5 != 0) goto L46;
        int r36 = -this.R;
    L47:
        r11 = ((r2 - r36) - r5) - this.R;
    L58:
        r10 = 0;
        goto L59
    L46:
        r36 = r0;
        goto L47
    L48:
        r9 = r4 % this.e;
        r11 = r2 - r5;
        goto L58
    L49:
        int r37 = getPaddingLeft() + this.N;
        r9 = 0;
    L51:
        if (r9 >= this.e) goto L56;
        int r38 = r9 + 1;
        if (r2 < ((this.S + r37) + (r38 * r3))) goto L57;
        r9 = r38;
    L57:
        r11 = (this.S + r37) + (r3 * r9);
        goto L58
    L56:
        r9 = 0;
        goto L57
    }

    public final void v() {
        if (this.w == null) goto L30;
        int r0 = getChildCount() - 1;
    L5:
        if (r0 <= (-1)) goto L36;
        View r2 = getChildAt(r0);
        boolean r4 = true;
        if (g() == true) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L29;
        if (h() == true) goto L16;
    L18:
        r4 = false;
    L19:
        if (r4 == true) goto L29;
        if (r2 == null) goto L29;
        if (l() == false) goto L25;
        int r5 = (r2.getLeft() - getScrollX()) + getOffset();
        int r6 = getPaddingLeft();
    L28:
        this.w.b(this, r2, m(), r5 - r6);
        goto L29
    L25:
        if (m() == false) goto L27;
        r5 = (r2.getTop() - getScrollY()) - getOffset();
        r6 = getPaddingTop();
        goto L28
    L27:
        r5 = (r2.getLeft() - getScrollX()) - getOffset();
        r6 = getPaddingLeft();
        goto L28
    L16:
        if (((c) r2.getLayoutParams()).a != (this.e - 1)) goto L18;
    L29:
        r0 = r0 - 1;
        goto L5
    L9:
        if (((c) r2.getLayoutParams()).a != 0) goto L11;
        r3 = true;
        goto L12
    L36:
        return;
    }

    public final void w() {
        if (this.k == false) goto L5;
        return;
    L5:
        if (this.j == false) goto L7;
        return;
    L7:
        if (this.l == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        Iterator r2 = ((ArrayList) this.U).iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        ((d) r2.next()).c(this.f, r0);
        goto L14
    L16:
        this.j = true;
        return;
    L9:
        if (this.v != 1) goto L11;
        r0 = true;
        goto L12
    }

    private List<View> getAllChildren() {
        int r0 = getChildCount();
        LinkedList r1 = new LinkedList();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1.add(getChildAt(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private int getContentHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getContentSize() {
        if (m() == false) goto L6;
        return getContentHeight();
    L6:
        return getContentWidth();
    }

    private int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private View getCurrentView() {
        int r0 = getPile() + (getChildExpectSize() / 2);
        int r1 = getScrollDistance();
        int r2 = getChildCount();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L18;
        View r5 = getChildAt(r4);
        int r6 = j(r5) - r1;
        if (m() == false) goto L7;
        int r7 = r5.getBottom();
    L8:
        int r8 = r7 - r1;
        int r9 = this.F;
        if (r9 <= 0) goto L11;
        r8 = r8 + this.R;
    L13:
        if (r6 > r0) goto L16;
        if (r8 < r0) goto L16;
        return r5;
    L16:
        r4 = r4 + 1;
        goto L3
    L11:
        if (r9 >= 0) goto L13;
        r6 = r6 - this.R;
        goto L13
    L7:
        r7 = r5.getRight();
        goto L8
    L18:
        return getChildAt(0);
    }

    private int getPageGap() {
        if (m() == false) goto L7;
        int r0 = getHeight() - getPaddingBottom();
        int r1 = this.R;
    L6:
        return r0 - r1;
    L7:
        r0 = getWidth() - getPaddingRight();
        r1 = this.R;
        goto L6
    }

    private int getPile() {
        if (m() == false) goto L7;
        return getPaddingTop() + getOffset();
    L7:
        if (l() == false) goto L11;
        return ((getPaddingLeft() + getOffset()) + getWidth()) - getChildExpectSize();
    L11:
        return getPaddingLeft() + getOffset();
    }

    private int getScrollDistance() {
        if (m() == false) goto L6;
        return getScrollY();
    L6:
        return getScrollX();
    }

    public final void s() {
        boolean r1 = true;
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        View r0 = getCurrentView();
        int r4 = getScrollDistance();
        int r2 = j(r0) - r4;
        if (m() == false) goto L8;
        int r3 = r0.getBottom();
    L9:
        int r5 = r3 - r4;
        if (g() == true) goto L12;
    L14:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L25;
        int r7 = getPile();
        if (m() == false) goto L21;
        this.i.startScroll(0, r4, 0, (r5 + this.R) - r7, this.P0);
    L42:
        setScrollState(2);
        invalidate();
        return;
    L21:
        if (this.o == false) goto L23;
        int r8 = getPile() + getChildExpectSize();
        this.i.startScroll(r4, 0, (r2 - this.R) - r8, 0, this.P0);
        goto L42
    L23:
        this.i.startScroll(r4, 0, (r5 + this.R) - r7, 0, this.P0);
        goto L42
    L25:
        if (h() == true) goto L27;
    L29:
        r1 = false;
    L30:
        if (r1 == false) goto L38;
        int r9 = getPile() + getChildExpectSize();
        if (m() == false) goto L35;
        this.i.startScroll(0, r4, 0, (r2 - this.R) - r9, this.P0);
        goto L42
    L35:
        if (this.o == false) goto L37;
        int r10 = getPile();
        this.i.startScroll(r4, 0, (r5 + this.R) - r10, 0, this.P0);
        goto L42
    L37:
        this.i.startScroll(r4, 0, (r2 - this.R) - r9, 0, this.P0);
        goto L42
    L38:
        int r11 = getPile() + (getChildExpectSize() / 2);
        int r12 = (r2 + r5) / 2;
        if (m() == false) goto L41;
        this.i.startScroll(0, r4, 0, r12 - r11, this.t);
        goto L42
    L41:
        this.i.startScroll(r4, 0, r12 - r11, 0, this.t);
        goto L42
    L27:
        if (((c) r0.getLayoutParams()).a != (this.e - 1)) goto L29;
    L12:
        if (((c) r0.getLayoutParams()).a != 0) goto L14;
        r6 = true;
        goto L16
    L8:
        r3 = r0.getRight();
        goto L9
    }

    public b getAdapter() {
        return this.L;
    }

    public int getCurrentIndex() {
        return this.f;
    }

    public int getOffset() {
        return this.N;
    }

    public int getTotalCount() {
        return this.e;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
    }

    public ViewPager(Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ void b(ViewPager r1) {
        r1.setScrollState(1);
    }

    private void setScrollState(int r3) {
        if (this.v != r3) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.U).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((d) r0.next()).onPageScrollStateChanged(r3);
        goto L7
    L9:
        this.v = r3;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r2) {
        if (this.l == false) goto L7;
        if (d(r2) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.q == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r2) {
        if (this.l == false) goto L7;
        if (e(r2) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.q == true) goto L8;
        return false;
    }

    public final boolean d(int r6) {
        if (m() == false) goto L5;
        return false;
    L5:
        if (this.L == null) goto L29;
        int r0 = this.e;
        if (r0 <= 1) goto L30;
        int r3 = this.f;
        if (r3 != (-1)) goto L11;
        return false;
    L11:
        if (this.n == true) goto L26;
        if (r6 > 0) goto L14;
    L19:
        if (r6 < 0) goto L21;
        return false;
    L21:
        if (this.o == true) goto L23;
        if (r3 > 0) goto L26;
        return false;
    L23:
        if (r3 < (r0 - 1)) goto L26;
        return false;
    L14:
        if (this.o == false) goto L18;
        if (r3 <= 0) goto L19;
    L18:
        if (r3 >= (r0 - 1)) goto L19;
    L26:
        return true;
    L30:
        return false;
    L29:
        return false;
    }

    public final boolean e(int r6) {
        if (m() == true) goto L5;
        return false;
    L5:
        if (this.L == null) goto L20;
        int r0 = this.e;
        if (r0 <= 1) goto L21;
        int r3 = this.f;
        if (r3 != (-1)) goto L11;
        return false;
    L11:
        if (this.n == true) goto L17;
        if (r6 > 0) goto L14;
    L15:
        if (r6 >= 0) goto L23;
        if (r3 > 0) goto L17;
        return false;
    L23:
        return false;
    L14:
        if (r3 >= (r0 - 1)) goto L15;
    L17:
        return true;
    L21:
        return false;
    L20:
        return false;
    }

    public final int j(View r2) {
        if (m() == false) goto L6;
        return r2.getTop();
    L6:
        return r2.getLeft();
    }

    public final View k(int r5) {
        int r0 = getChildCount() - 1;
    L4:
        if (r0 <= (-1)) goto L9;
        View r2 = getChildAt(r0);
        if (((c) r2.getLayoutParams()).a == r5) goto L7;
        r0 = r0 - 1;
        goto L4
    L7:
        return r2;
    L9:
        View r1 = (View) ListProtector.get(((com.lynx.tasm.behavior.ui.swiper.e) this.L).a.D, r5);
        c r3 = new c();
        r3.a = r5;
        addViewInLayout(r1, 0, r3, true);
        n(r1);
        return r1;
    }

    public final void n(View r10) {
        if (m() == false) goto L14;
        c r0 = (c) r10.getLayoutParams();
        int r6 = ((ViewGroup.LayoutParams) r0).width;
        if (r6 < 0) goto L7;
        int r1 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
    L13:
        int r2 = View.MeasureSpec.makeMeasureSpec(getChildExpectSize(), 1073741824);
    L23:
        r10.measure(r1, r2);
        return;
    L7:
        int r7 = Math.max(0, (getWidth() - getPaddingLeft()) - getPaddingRight());
        int r3 = ((ViewGroup.LayoutParams) r0).width;
        if (r3 != (-1)) goto L10;
        r1 = View.MeasureSpec.makeMeasureSpec(r7, 1073741824);
        goto L13
    L10:
        if (r3 != (-2)) goto L12;
        r1 = View.MeasureSpec.makeMeasureSpec(r7, Integer.MIN_VALUE);
        goto L13
    L12:
        r1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        goto L13
    L14:
        r1 = View.MeasureSpec.makeMeasureSpec(getChildExpectSize(), 1073741824);
        c r8 = (c) r10.getLayoutParams();
        int r9 = ((ViewGroup.LayoutParams) r8).height;
        if (r9 < 0) goto L17;
        r2 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
        goto L23
    L17:
        int r11 = Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom());
        int r12 = ((ViewGroup.LayoutParams) r8).height;
        if (r12 != (-1)) goto L20;
        r2 = View.MeasureSpec.makeMeasureSpec(r11, 1073741824);
        goto L23
    L20:
        if (r12 != (-2)) goto L22;
        r2 = View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
        goto L23
    L22:
        r2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        goto L23
    }

    public final void o(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.E) goto L9;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.H = r4.getX(r1);
        this.I = r4.getY(r1);
        this.E = r4.getPointerId(r1);
        return;
    L6:
        r1 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r15) {
        if (this.l == false) goto L5;
        int r0 = r15.getActionMasked();
        int r1 = r15.getActionIndex();
        if (r0 != 3) goto L9;
    L82:
        this.E = -1;
        this.B = false;
        this.C = false;
        this.A = false;
        this.D = false;
        this.F = 0;
        return false;
    L9:
        if (r0 == 1) goto L82;
        if (r0 == 0) goto L19;
        if (this.B == false) goto L16;
        return true;
    L16:
        if (this.C == false) goto L19;
        return false;
    L19:
        if (r0 == 0) goto L68;
        if (r0 != 2) goto L22;
        int r2 = this.E;
        if (r2 == (-1)) goto L81;
        int r3 = r15.findPointerIndex(r2);
        float r4 = r15.getX(r3);
        float r16 = r15.getY(r3);
        float r5 = r4 - this.H;
        float r6 = r16 - this.I;
        float r7 = r4 - this.J;
        float r8 = r16 - this.K;
        if (m() == false) goto L34;
        float r9 = r6;
    L35:
        int r11 = (int) r9;
        if (this.m == false) goto L43;
        if (r11 == 0) goto L43;
        if (c(this, m(), false, r11, (int) r4, (int) r16) == false) goto L43;
        this.H = r4;
        this.I = r16;
        this.C = true;
        return false;
    L43:
        if (m() == false) goto L57;
        if (Math.abs(r6) <= this.z) goto L54;
        if (Math.abs(r6) <= (Math.abs(r7) * 0.5f)) goto L54;
        r(true);
        setScrollState(1);
        this.B = true;
        this.D = true;
        if (r6 <= 0.0f) goto L51;
        float r17 = this.K + this.z;
    L52:
        this.I = r17;
        this.H = r4;
        goto L81
    L51:
        r17 = this.K - this.z;
    L54:
        if (r7 <= this.z) goto L81;
        this.C = true;
        goto L81
    L57:
        if (Math.abs(r5) <= this.z) goto L66;
        if (Math.abs(r5) <= (Math.abs(r8) * 0.5f)) goto L66;
        r(true);
        setScrollState(1);
        this.B = true;
        this.D = true;
        if (r5 <= 0.0f) goto L63;
        float r10 = this.J + this.z;
    L64:
        this.H = r10;
        this.I = r16;
        goto L81
    L63:
        r10 = this.J - this.z;
    L66:
        if (r8 <= this.z) goto L81;
        this.C = true;
        goto L81
    L34:
        r9 = r5;
    L81:
        return this.B;
    L22:
        if (r0 != 5) goto L24;
        this.E = r15.getPointerId(r1);
        goto L81
    L24:
        if (r0 != 6) goto L81;
        o(r15);
        goto L81
    L68:
        float r12 = r15.getX();
        this.J = r12;
        this.H = r12;
        float r13 = r15.getY();
        this.K = r13;
        this.I = r13;
        this.E = r15.getPointerId(r1);
        this.B = false;
        this.C = false;
        this.D = false;
        this.A = false;
        this.F = 0;
        this.i.computeScrollOffset();
        if (m() == false) goto L71;
        int r18 = this.i.getFinalY();
        int r14 = this.i.getCurrY();
    L72:
        int r19 = r18 - r14;
        if (this.L0 == false) goto L76;
        r(true);
    L76:
        if (this.v != 2) goto L81;
        if (Math.abs(r19) <= this.G) goto L81;
        this.i.abortAnimation();
        r(true);
        setScrollState(1);
        this.B = true;
        goto L81
    L71:
        r18 = this.i.getFinalX();
        r14 = this.i.getCurrX();
        goto L72
    L5:
        return super.onInterceptTouchEvent(r15);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        int r1 = r4.getActionMasked();
        if (r1 != 1) goto L5;
    L13:
        this.E = -1;
        if (this.A == true) goto L17;
        s();
    L17:
        if (this.l == false) goto L21;
        return this.h1.onTouchEvent(r4);
    L21:
        return super.onTouchEvent(r4);
    L5:
        if (r1 == 3) goto L13;
        if (r1 != 5) goto L9;
        this.E = r4.getPointerId(r0);
        this.H = r4.getX(r0);
        this.I = r4.getY(r0);
        goto L17
    L9:
        if (r1 != 6) goto L17;
        o(r4);
        goto L17
    }

    public final void r(boolean r2) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(r2);
        return;
    }

    public void setAdapter(b r5) {
        if (this.L == null) goto L10;
        int r0 = getChildCount() - 1;
    L5:
        if (r0 <= (-1)) goto L11;
        View r2 = getChildAt(r0);
        e r3 = this.w;
        if (r3 == null) goto L9;
        r3.a(r2);
    L9:
        removeView(r2);
        int r4 = ((c) r2.getLayoutParams()).a;
        this.L.getClass();
        r0 = r0 - 1;
    L11:
        this.L = r5;
        if (r5 != null) goto L14;
        return;
    L14:
        this.e = ((ArrayList) ((com.lynx.tasm.behavior.ui.swiper.e) r5).a.D).size();
        return;
    L10:
        removeAllViews();
        goto L11
    }

    public void setAnimDuration(int r1) {
        this.t = r1;
    }

    public void setBounceBeginThreshold(float r3) {
        if (r3 > 0.0f) goto L5;
    L7:
        this.V0 = -1.0f;
        return;
    L5:
        if (r3 >= 1.0f) goto L7;
        this.V0 = 1.0f - r3;
    }

    public void setBounceDuration(int r1) {
        this.P0 = r1;
    }

    public void setBounceEndThreshold(float r3) {
        if (r3 > 0.0f) goto L5;
    L7:
        this.b1 = -1.0f;
        return;
    L5:
        if (r3 >= 1.0f) goto L7;
        this.b1 = 1.0f - r3;
    }

    public void setEnableBounce(boolean r1) {
        this.V = r1;
    }

    public void setEnableNestedChild(boolean r1) {
        this.m = r1;
    }

    public void setEnableViceLoop(boolean r1) {
        this.r = r1;
    }

    public void setForceCanScroll(boolean r1) {
        this.q = r1;
    }

    public void setHLayoutUpdated(boolean r2) {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = r2;
    }

    public void setHandleGesture(boolean r1) {
        this.L0 = r1;
    }

    public void setIgnoreLayoutUpdate(boolean r1) {
        this.H0 = r1;
    }

    public void setIsRTL(boolean r1) {
        this.o = r1;
    }

    public void setKeepItemView(boolean r1) {
        this.p = r1;
    }

    public void setLoop(boolean r2) {
        this.n = r2;
        if (this.r == true) goto L5;
        return;
    L5:
        if (this.L != null) goto L7;
        return;
    L7:
        if (this.e > 1) goto L9;
        return;
    L9:
        if (this.f == (-1)) goto L15;
        requestLayout();
        return;
    }

    public void setOrientation(int r1) {
        this.u = r1;
    }

    public void setPageMargin(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.R = r1;
    }

    public void setPageSize(int r1) {
        this.M = r1;
    }

    public void setPropsUpdated(boolean r2) {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = r2;
    }

    public void setTouchable(boolean r1) {
        this.l = r1;
    }

    public void setTransformer(e r4) {
        if (this.w == null) goto L8;
        int r0 = getChildCount();
    L5:
        r0 = r0 - 1;
        if (r0 <= (-1)) goto L8;
        this.w.a(getChildAt(r0));
    L8:
        this.w = r4;
        v();
    }

    public void setVLayoutUpdated(boolean r2) {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = r2;
    }

    public ViewPager(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = 0;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 300;
        this.u = 0;
        this.v = 0;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = -1;
        this.F = 0;
        this.G = 0;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
        this.M = -1;
        this.N = 0;
        this.O = -1;
        this.P = -1;
        this.Q = -1;
        this.R = 0;
        this.S = Integer.MIN_VALUE;
        this.T = Integer.MAX_VALUE;
        this.V = false;
        this.W = false;
        this.k0 = false;
        this.p0 = false;
        this.H0 = false;
        this.L0 = true;
        this.P0 = 300;
        this.V0 = -1.0f;
        this.b1 = -1.0f;
        this.g1 = Integer.MIN_VALUE;
        this.h1 = new GestureDetector(new a(this), new Handler(Looper.getMainLooper()));
        Resources r7 = getResources();
        float r8 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density;
        this.i = new Scroller(r5, new LinearInterpolator());
        int r0 = (int) (600.0f * r8);
        this.y = r0;
        this.x = r0;
        this.z = ViewConfiguration.get(r5).getScaledTouchSlop();
        this.G = (int) (r8 * 2.0f);
        this.U = new ArrayList();
    }

    public final void i(int r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L21;
        if (l() == false) goto L13;
        if (this.n == true) goto L9;
    L11:
        int r6 = r4 - 1;
    L19:
        t(r6, true, !l() ? 1 : 0);
        return;
    L9:
        if ((r4 - 1) >= 0) goto L11;
        r4 = this.e;
        goto L11
    L13:
        if (this.n == true) goto L15;
    L17:
        r0 = r4 + 1;
    L18:
        r6 = r0;
        goto L19
    L15:
        if ((r4 + 1) < this.e) goto L17;
    L21:
        if (l() == false) goto L29;
        if (this.n == true) goto L25;
    L27:
        r0 = r4 + 1;
    L34:
        t(r0, true, l() ? 1 : 0);
        return;
    L25:
        if ((r4 + 1) < this.e) goto L27;
    L29:
        if (this.n == true) goto L31;
    L33:
        r0 = r4 - 1;
        goto L34
    L31:
        if ((r4 - 1) >= 0) goto L33;
        r4 = this.e;
        goto L33
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r2), ViewGroup.getDefaultSize(0, r3));
    }

    @Override // android.view.View
    public final void scrollTo(int r8, int r9) {
        int r0 = getChildExpectSize() + this.R;
        int r1 = this.e * r0;
        int r2 = getPaddingLeft() + this.N;
        boolean r6 = true;
        if (this.S != Integer.MIN_VALUE) goto L7;
        if (this.T != Integer.MAX_VALUE) goto L7;
    L14:
        boolean r3 = true;
    L15:
        this.O = r0;
        this.P = r1;
        this.Q = r2;
        if (r3 == false) goto L26;
        if (l() == false) goto L21;
        int r4 = getPaddingRight() - this.N;
        this.S = ((-(this.e - 1)) * (getChildExpectSize() + this.R)) + r4;
        this.T = r4;
        goto L26
    L21:
        if (m() == false) goto L23;
        int r5 = getPaddingTop();
    L24:
        int r7 = r5 + this.N;
        this.S = -r7;
        this.T = ((this.e - 1) * (getChildExpectSize() + this.R)) - r7;
        goto L26
    L23:
        r5 = getPaddingLeft();
    L26:
        if (this.n == false) goto L28;
    L79:
        super.scrollTo(r8, r9);
        int r10 = getChildExpectSize() + this.R;
        int r11 = this.e * r10;
        if (this.n == false) goto L98;
        if (r11 <= 0) goto L98;
        if (r10 <= 0) goto L98;
        int r12 = getScrollDistance();
        if (l() == false) goto L91;
        int r13 = getPaddingRight() - this.N;
        int r14 = r12 - (r10 / 2);
        if (r14 < 0) goto L89;
        int r15 = r14 / r11;
        this.S = ((r15 * r11) + r10) + r13;
        this.T = ((r15 + 1) * r11) + r13;
        goto L98
    L89:
        this.S = (((-((Math.abs(r14) / r11) + 1)) * r11) + r10) + r13;
        this.T = ((-(Math.abs(r14) / r11)) * r11) + r13;
        goto L98
    L91:
        if (m() == false) goto L93;
        int r16 = getPaddingTop();
    L94:
        int r17 = r16 + this.N;
        int r18 = r12 + (r10 / 2);
        if (r18 < 0) goto L97;
        int r19 = r18 / r11;
        this.S = (r19 * r11) - r17;
        this.T = (((r19 + 1) * r11) - r10) - r17;
        goto L98
    L97:
        this.S = ((-((Math.abs(r18) / r11) + 1)) * r11) - r17;
        this.T = (((-(Math.abs(r18) / r11)) * r11) - r10) - r17;
        goto L98
    L93:
        r16 = getPaddingLeft();
    L98:
        q();
        if (this.k == true) goto L113;
        if (this.j == false) goto L113;
        if (this.l == true) goto L105;
    L107:
        boolean r20 = false;
    L108:
        Iterator r21 = ((ArrayList) this.U).iterator();
    L110:
        if (r21.hasNext() == false) goto L113;
        ((d) r21.next()).b(r20, getScrollX(), getScrollY());
        goto L110
    L105:
        if (this.v != 1) goto L107;
        r20 = true;
    L113:
        if (this.n == false) goto L115;
        return;
    L115:
        if (this.W == false) goto L117;
    L118:
        s();
        if (this.p0 == true) goto L129;
        boolean r22 = this.W;
        boolean r23 = this.k0;
        if (this.k == true) goto L129;
        if (this.j == false) goto L129;
        Iterator r24 = ((ArrayList) this.U).iterator();
    L126:
        if (r24.hasNext() == false) goto L129;
        ((d) r24.next()).a(r22, r23);
    L129:
        if (this.W == false) goto L131;
    L134:
        this.p0 = r6;
        this.W = false;
        this.k0 = false;
        return;
    L131:
        if (this.k0 == true) goto L134;
        r6 = false;
        goto L134
    L117:
        if (this.k0 == false) goto L129;
    L28:
        if (m() == true) goto L30;
        int r25 = this.S;
        int r26 = this.T;
        if (g() == false) goto L55;
        if (this.o == false) goto L53;
        r26 = (int) (this.T - (this.V0 * (getChildExpectSize() + this.R)));
        goto L55
    L53:
        r25 = (int) (this.S + (this.V0 * (getChildExpectSize() + this.R)));
    L55:
        if (h() == false) goto L61;
        if (this.o == false) goto L59;
        r25 = (int) (this.S + (this.b1 * (getChildExpectSize() + this.R)));
        goto L61
    L59:
        r26 = (int) (this.T - (this.b1 * (getChildExpectSize() + this.R)));
    L61:
        if (g() == true) goto L63;
    L68:
        boolean r27 = false;
    L69:
        this.W = r27;
        if (h() == true) goto L72;
    L77:
        boolean r28 = false;
    L78:
        this.k0 = r28;
        r8 = Math.min(Math.max(r8, r25), r26);
        goto L79
    L72:
        if (this.o == false) goto L75;
        if (r8 > r25) goto L77;
    L76:
        r28 = true;
        goto L78
    L75:
        if (r8 < r26) goto L77;
    L63:
        if (this.o == false) goto L66;
        if (r8 < r26) goto L68;
    L67:
        r27 = true;
        goto L69
    L66:
        if (r8 > r25) goto L68;
    L30:
        if (g() == false) goto L32;
        int r29 = (int) (this.S + (this.V0 * (getChildExpectSize() + this.R)));
    L34:
        if (h() == false) goto L36;
        int r30 = (int) (this.T - (this.b1 * (getChildExpectSize() + this.R)));
    L38:
        if (g() == false) goto L41;
        if (r9 > r29) goto L41;
        boolean r31 = true;
    L42:
        this.W = r31;
        if (h() == false) goto L46;
        if (r9 < r30) goto L46;
        boolean r32 = true;
    L47:
        this.k0 = r32;
        r9 = Math.min(Math.max(r9, r29), r30);
    L46:
        r32 = false;
    L41:
        r31 = false;
        goto L42
    L36:
        r30 = this.T;
        goto L38
    L32:
        r29 = this.S;
    L7:
        if (this.O != r0) goto L14;
        if (this.P != r1) goto L14;
        if (this.Q != r2) goto L14;
        r3 = false;
        goto L15
    }

    public final void u(int r2, boolean r3) {
        this.N = r2;
        if (r3 == true) goto L5;
        return;
    L5:
        if (m() == false) goto L7;
        scrollTo(0, -r2);
        return;
    L7:
        scrollTo(-r2, 0);
    }

    public static void a(ViewPager r9, float r10, float r11) {
        if (r9.getChildCount() >= 1) goto L6;
        return;
    L6:
        if (r9.m() == false) goto L8;
        r10 = r11;
    L8:
        int r12 = r9.getPile();
        int r0 = r9.getScrollDistance();
        int r2 = ((c) r9.getCurrentView().getLayoutParams()).a;
        int r3 = 0;
        if (r10 >= 0.0f) goto L24;
        int r13 = r9.getChildCount();
        int r5 = Integer.MAX_VALUE;
    L11:
        if (r3 >= r13) goto L17;
        int r6 = r9.j(r9.getChildAt(r3)) - r0;
        if (r6 <= r12) goto L16;
        if (r6 >= r5) goto L16;
        r5 = r6;
    L16:
        r3 = r3 + 1;
        goto L11
    L17:
        if (r5 != Integer.MAX_VALUE) goto L20;
        r9.i(r2, true);
        return;
    L20:
        if (r9.m() == false) goto L22;
        r9.i.startScroll(0, r0, 0, r5 - r12, r9.t);
    L23:
        r9.setScrollState(2);
    L38:
        r9.invalidate();
        return;
    L22:
        r9.i.startScroll(r0, 0, r5 - r12, 0, r9.t);
        goto L23
    L24:
        int r14 = r9.getChildCount();
        int r4 = 0;
        int r7 = Integer.MIN_VALUE;
    L25:
        if (r4 >= r14) goto L31;
        int r8 = r9.j(r9.getChildAt(r4)) - r0;
        if (r8 >= r12) goto L30;
        if (r8 <= r7) goto L30;
        r7 = r8;
    L30:
        r4 = r4 + 1;
        goto L25
    L31:
        if (r7 != Integer.MIN_VALUE) goto L34;
        r9.i(r2, false);
        return;
    L34:
        if (r9.m() == false) goto L36;
        r9.i.startScroll(0, r0, 0, r7 - r12, r9.t);
    L37:
        r9.setScrollState(2);
        goto L38
    L36:
        r9.i.startScroll(r0, 0, r7 - r12, 0, r9.t);
        goto L37
    }

    @Override // android.view.ViewGroup
    public final void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        throw new IllegalStateException();
    }

    public final void p(View r5, int r6, int r7) {
        if (m() == false) goto L5;
        int r0 = getPaddingLeft();
        int r1 = r5.getMeasuredWidth() + r0;
        int r2 = r6;
        r6 = r0;
        int r3 = r7;
        r7 = r1;
    L6:
        r5.layout(r6, r2, r7, r3);
        return;
    L5:
        r2 = getPaddingTop();
        r3 = r5.getMeasuredHeight() + r2;
        goto L6
    }

    public final void t(int r12, boolean r13, int r14) {
        boolean r1 = true;
        if (this.e >= 1) goto L5;
        return;
    L5:
        if (getChildCount() < 1) goto L62;
        int r15 = MathUtils.clamp(r12, 0, this.e - 1);
        View r0 = getCurrentView();
        int r3 = ((c) r0.getLayoutParams()).a;
        if (r3 != r15) goto L10;
        return;
    L10:
        int r4 = getChildExpectSize();
        int r7 = getScrollDistance();
        int r5 = getPile() + (r4 / 2);
        int r6 = j(r0);
        if (m() == false) goto L13;
        int r2 = r0.getBottom();
    L14:
        int r8 = ((r6 + r2) / 2) - r7;
        int r9 = r4 + this.R;
        int r10 = (r15 - r3) * r9;
        boolean r11 = this.n;
        if (r11 == false) goto L17;
    L18:
        if (r14 != 1) goto L22;
        if (r15 > r3) goto L25;
        int r16 = this.e + r15;
    L26:
        r10 = (r16 - r3) * r9;
    L27:
        if (r11 == true) goto L36;
        this.s = true;
        if (r14 != 1) goto L31;
        if (r15 >= r3) goto L31;
    L35:
        this.n = r1;
    L31:
        if (r14 != 0) goto L34;
        if (r15 > r3) goto L35;
    L34:
        r1 = false;
    L36:
        w();
        if (l() == false) goto L44;
        Scroller r17 = this.i;
        int r18 = (r8 - r5) - r10;
        if (r13 == false) goto L41;
        int r19 = this.t;
    L42:
        r17.startScroll(r7, 0, r18, 0, r19);
    L55:
        setScrollState(2);
        if (m() == false) goto L58;
        int r110 = this.i.getFinalY();
    L59:
        this.g1 = r110;
        invalidate();
        return;
    L58:
        r110 = this.i.getFinalX();
        goto L59
    L41:
        r19 = 0;
        goto L42
    L44:
        if (m() == false) goto L50;
        Scroller r111 = this.i;
        int r20 = (r8 - r5) + r10;
        if (r13 == false) goto L48;
        int r112 = this.t;
    L49:
        r111.startScroll(0, r7, 0, r20, r112);
        goto L55
    L48:
        r112 = 0;
        goto L49
    L50:
        Scroller r113 = this.i;
        int r21 = r10 + (r8 - r5);
        if (r13 == false) goto L53;
        int r114 = this.t;
    L54:
        r113.startScroll(r7, 0, r21, 0, r114);
        goto L55
    L53:
        r114 = 0;
    L25:
        r16 = r15;
        goto L26
    L22:
        if (r14 != 0) goto L27;
        if (r15 <= r3) goto L25;
        r16 = r15 - this.e;
        goto L26
    L17:
        if (this.r == false) goto L36;
    L13:
        r2 = r0.getRight();
        goto L14
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.b == false) goto L5;
    L6:
        f();
        this.b = false;
        this.c = false;
        return;
    L5:
        if (this.c == true) goto L6;
    }

    @Override // android.view.View
    public final void setPadding(int r2, int r3, int r4, int r5) {
        int r0 = getPaddingLeft();
        super.setPadding(r2, r3, r4, r5);
        if (m() == false) goto L5;
        scrollBy(0, r0 - r2);
        return;
    L5:
        scrollBy(r0 - r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        int r6 = getChildCount() - 1;
    L3:
        if (r6 <= (-1)) goto L6;
        n(getChildAt(r6));
        r6 = r6 - 1;
        goto L3
    L6:
        if (this.d == false) goto L8;
    L13:
        f();
        this.d = false;
        this.b = false;
        this.c = false;
        return;
    L8:
        if (this.b == true) goto L13;
        if (this.c == true) goto L13;
        q();
    }

    public static boolean c(View r13, boolean r14, boolean r15, int r16, int r17, int r18) {
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r9 = (ViewGroup) r13;
        int r10 = r13.getScrollX();
        int r11 = r13.getScrollY();
        int r12 = r9.getChildCount() - 1;
    L5:
        if (r12 < 0) goto L18;
        View r1 = r9.getChildAt(r12);
        int r2 = r17 + r10;
        if (r2 < r1.getLeft()) goto L17;
        if (r2 >= r1.getRight()) goto L17;
        int r3 = r18 + r11;
        if (r3 < r1.getTop()) goto L17;
        if (r3 >= r1.getBottom()) goto L17;
        if (c(r1, r14, true, r16, r2 - r1.getLeft(), r3 - r1.getTop()) == false) goto L17;
        return true;
    L17:
        r12 = r12 - 1;
    L18:
        if (r15 == false) goto L26;
        if (r14 == false) goto L24;
        if (r13.canScrollVertically(-r16) == false) goto L26;
        return true;
    L24:
        if (r13.canScrollHorizontally(-r16) == false) goto L26;
        return true;
    L26:
        return false;
    }
}

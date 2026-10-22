package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.ttvideoengine.utils.ScreenUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NestBridgeWebView extends OfficeWebView implements NestedScrollingChild3 {
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public VelocityTracker E;
    public int F;
    public int G;
    public int H;
    public int I;
    public final int[] J;
    public final int[] K;
    public int L;
    public int M;
    public int N;
    public final NestedScrollingChildHelper O;
    public final boolean P;
    public float Q;
    public float R;
    public boolean S;
    public int v;
    public final boolean w;
    public OverScroller x;
    public EdgeEffect y;
    public EdgeEffect z;

    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        if (this.P == true) goto L9;
        if (this.x.computeScrollOffset() == false) goto L49;
        scrollTo(this.x.getCurrX(), this.x.getCurrY());
        postInvalidateOnAnimation();
        return;
    L49:
        return;
    L9:
        if (this.x.isFinished() == false) goto L11;
        return;
    L11:
        this.x.computeScrollOffset();
        int r0 = this.x.getCurrY();
        int r1 = this.x.getCurrX();
        int r2 = r0 - this.M;
        int r9 = r1 - this.N;
        this.M = r0;
        this.N = r1;
        int[] r6 = this.K;
        boolean r3 = false;
        r6[1] = 0;
        dispatchNestedPreScroll(0, r2, r6, null, 1);
        int r4 = r2 - this.K[1];
        int r5 = getScrollRange();
        int r10 = getHorizontalScrollRange();
        if (r4 != 0) goto L14;
        if (r9 != 0) goto L14;
    L28:
        if (r4 == 0) goto L45;
        int r7 = getOverScrollMode();
        if (r7 == 0) goto L33;
        if (r7 != 1) goto L34;
        if (r5 > 0) goto L33;
    L34:
        if (r3 == false) goto L43;
        p();
        if (r4 >= 0) goto L41;
        if (this.y.isFinished() == false) goto L43;
        this.y.onAbsorb((int) this.x.getCurrVelocity());
        goto L43
    L41:
        if (this.z.isFinished() == false) goto L43;
        this.z.onAbsorb((int) this.x.getCurrVelocity());
    L43:
        this.x.abortAnimation();
        stopNestedScroll(1);
    L33:
        r3 = true;
    L45:
        if (this.x.isFinished() == true) goto L47;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L47:
        stopNestedScroll(1);
        return;
    L14:
        int r14 = getScrollY();
        s(r9, r4, getScrollX(), r14, r10, r5, 0, 0, false);
        int r8 = getScrollY() - r14;
        int r11 = r4 - r8;
        this.K[1] = 0;
        if (this.w == false) goto L18;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == false) goto L27;
        dispatchNestedScroll(0, r8, 0, r11, this.J, 1, this.K);
    L27:
        r4 = r11 - this.K[1];
        goto L28
    L18:
        if (getScrollY() < 5) goto L20;
        boolean r13 = true;
    L21:
        if (r11 >= 0) goto L24;
        if (r13 == false) goto L24;
        r12 = false;
        goto L25
    L20:
        r13 = false;
        goto L21
    }

    public final boolean isNestedScrollingEnabled() {
        return this.O.isNestedScrollingEnabled();
    }

    public final void t() {
        VelocityTracker r0 = this.E;
        if (r0 == null) goto L6;
        r0.recycle();
        this.E = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getHorizontalScrollRange() {
        return Math.max(0, computeHorizontalScrollRange() - computeHorizontalScrollExtent());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int computeVerticalScrollRange() {
        int r0 = super/*android.webkit.WebView*/.computeVerticalScrollRange();
        this.v = r0;
        return r0;
    }

    public int getScrollRange() {
        return computeVerticalScrollRange();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p() {
        if (getOverScrollMode() != 2) goto L5;
        this.y = null;
        this.z = null;
        return;
    L5:
        if (this.y != null) goto L9;
        Context r0 = getContext();
        this.y = new EdgeEffect(r0);
        this.z = new EdgeEffect(r0);
        return;
    }

    public int getLastVerticalScrollRange() {
        return this.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        if (this.P == true) goto L7;
        return super/*android.webkit.WebView*/.dispatchTouchEvent(r4);
    L7:
        if (r4.getActionMasked() != 2) goto L14;
        if (Math.abs(r4.getX() - this.B) <= Math.abs(r4.getY() - this.A)) goto L14;
        if (getParent() == null) goto L14;
        getParent().requestDisallowInterceptTouchEvent(!this.C);
    L14:
        return super/*android.webkit.WebView*/.dispatchTouchEvent(r4);
    }

    public final boolean hasNestedScrollingParent(int r2) {
        return this.O.hasNestedScrollingParent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onInterceptTouchEvent(MotionEvent r12) {
        if (this.P == false) goto L5;
        int r0 = r12.getAction();
        if (r0 == 2) goto L9;
    L11:
        int r1 = r0 & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        if (r1 != 0) goto L14;
        int r2 = (int) r12.getY();
        int r4 = (int) r12.getX();
        this.A = r2;
        this.B = r4;
        this.I = r12.getPointerId(0);
        VelocityTracker r3 = this.E;
        if (r3 != null) goto L45;
        this.E = VelocityTracker.obtain();
    L46:
        this.E.addMovement(r12);
        this.x.computeScrollOffset();
        this.D = !this.x.isFinished();
        startNestedScroll(2, 0);
    L48:
        return this.D;
    L45:
        r3.clear();
        goto L46
    L14:
        if (r1 == 1) goto L38;
        if (r1 != 2) goto L17;
        int r5 = this.I;
        if (r5 == (-1)) goto L48;
        int r6 = r12.findPointerIndex(r5);
        if (r6 != (-1)) goto L28;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_NestBridgeWebView", "Invalid pointerId=" + r5 + " in onInterceptTouchEvent");
        goto L48
    L28:
        int r7 = (int) r12.getY(r6);
        int r8 = (int) r12.getX(r6);
        if (Math.abs(r7 - this.A) <= this.F) goto L48;
        if ((2 & getNestedScrollAxes()) != 0) goto L48;
        this.D = true;
        this.A = r7;
        this.B = r8;
        if (this.E != null) goto L35;
        this.E = VelocityTracker.obtain();
    L35:
        this.E.addMovement(r12);
        this.L = 0;
        ViewParent r13 = getParent();
        if (r13 == null) goto L48;
        r13.requestDisallowInterceptTouchEvent(true);
        goto L48
    L17:
        if (r1 == 3) goto L38;
        if (r1 != 6) goto L48;
        r(r12);
    L38:
        this.D = false;
        this.I = -1;
        t();
        if (this.x.springBack(getScrollX(), getScrollY(), 0, getHorizontalScrollRange(), 0, getScrollRange()) == false) goto L41;
        ViewCompat.postInvalidateOnAnimation(this);
    L41:
        stopNestedScroll(0);
        goto L48
    L9:
        if (this.D == false) goto L11;
        return true;
    L5:
        return super/*android.webkit.WebView*/.onInterceptTouchEvent(r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r26) {
        if (this.P == true) goto L42;
        int r0 = r26.getActionMasked();
        if (this.E != null) goto L7;
        this.E = VelocityTracker.obtain();
    L7:
        this.E.addMovement(r26);
        float r4 = r26.getX();
        float r5 = r26.getY();
        if (r0 == 0) goto L36;
        if (r0 == 1) goto L28;
        if (r0 == 2) goto L14;
        if (r0 != 3) goto L40;
        this.S = false;
        t();
    L40:
        return super.onTouchEvent(r26);
    L14:
        float r1 = this.Q - r4;
        float r2 = this.R - r5;
        if (this.S == true) goto L22;
        if (Math.abs(r1) <= this.F) goto L19;
    L20:
        this.S = true;
        goto L22
    L19:
        if (Math.abs(r2) > this.F) goto L20;
    L22:
        if (this.S == false) goto L40;
        if (this.w == false) goto L26;
        scrollBy((int) r1, (int) r2);
    L26:
        this.Q = r4;
        this.R = r5;
        goto L40
    L28:
        if (this.S == false) goto L34;
        this.E.computeCurrentVelocity(1000, this.H);
        float r3 = this.E.getXVelocity();
        float r6 = this.E.getYVelocity();
        if (Math.abs(r3) <= this.G) goto L32;
    L33:
        this.x.fling(getScrollX(), getScrollY(), -((int) r3), -((int) r6), 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0, Math.max(0, computeVerticalScrollRange() - getHeight()));
        invalidate();
        goto L34
    L32:
        if (Math.abs(r6) > this.G) goto L33;
    L34:
        this.S = false;
        t();
        goto L40
    L36:
        if (this.x.isFinished() == true) goto L38;
        this.x.abortAnimation();
    L38:
        this.Q = r4;
        this.R = r5;
        this.S = false;
        goto L40
    L42:
        if (this.E != null) goto L44;
        this.E = VelocityTracker.obtain();
    L44:
        int r7 = r26.getActionMasked();
        if (r7 != 0) goto L47;
        this.L = 0;
    L47:
        MotionEvent r14 = MotionEvent.obtain(r26);
        r14.offsetLocation(0.0f, this.L);
        if (r7 != 0) goto L50;
        boolean r8 = !this.x.isFinished();
        this.D = r8;
        if (r8 == false) goto L155;
        ViewParent r9 = getParent();
        if (r9 == null) goto L155;
        r9.requestDisallowInterceptTouchEvent(true);
    L155:
        if (this.x.isFinished() == true) goto L157;
        this.x.abortAnimation();
        stopNestedScroll(1);
    L157:
        this.A = (int) r26.getY();
        this.B = (int) r26.getX();
        this.I = r26.getPointerId(0);
        startNestedScroll(2, 0);
        this.C = false;
    L158:
        VelocityTracker r10 = this.E;
        if (r10 == null) goto L161;
        r10.addMovement(r14);
    L161:
        r14.recycle();
        return super.onTouchEvent(r26);
    L50:
        if (r7 != 1) goto L52;
        VelocityTracker r11 = this.E;
        r11.computeCurrentVelocity(1000, this.H);
        int r12 = (int) r11.getXVelocity(this.I);
        int r13 = (int) r11.getYVelocity(this.I);
        if (Math.abs(r12) < this.G) goto L138;
        if (Math.abs(r12) <= Math.abs(r13)) goto L138;
        q(-r12, 0);
    L145:
        this.I = -1;
        this.D = false;
        t();
        stopNestedScroll(0);
        EdgeEffect r15 = this.y;
        if (r15 == null) goto L148;
        r15.onRelease();
        this.z.onRelease();
    L148:
        this.C = false;
    L138:
        if (Math.abs(r13) < this.G) goto L143;
        int r16 = -r13;
        float r17 = r16;
        if (dispatchNestedPreFling(0.0f, r17) == true) goto L145;
        dispatchNestedFling(0.0f, r17, true);
        q(0, r16);
        goto L145
    L143:
        if (this.x.springBack(getScrollX(), getScrollY(), 0, getHorizontalScrollRange(), 0, getScrollRange()) == false) goto L145;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L145
    L52:
        if (r7 == 2) goto L69;
        if (r7 == 3) goto L61;
        if (r7 != 5) goto L56;
        int r18 = r26.getActionIndex();
        this.A = (int) r26.getY(r18);
        this.B = (int) r26.getX(r18);
        this.I = r26.getPointerId(r18);
        this.C = false;
        goto L158
    L56:
        if (r7 != 6) goto L158;
        r(r26);
        this.A = (int) r26.getY(r26.findPointerIndex(this.I));
        this.B = (int) r26.getX(r26.findPointerIndex(this.I));
        this.C = false;
        goto L158
    L61:
        if (this.D == true) goto L63;
    L65:
        this.I = -1;
        this.D = false;
        t();
        stopNestedScroll(0);
        EdgeEffect r19 = this.y;
        if (r19 == null) goto L68;
        r19.onRelease();
        this.z.onRelease();
    L68:
        this.C = false;
        goto L158
    L63:
        if (this.x.springBack(getScrollX(), getScrollY(), 0, getHorizontalScrollRange(), 0, getScrollRange()) == false) goto L65;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L65
    L69:
        int r20 = r26.findPointerIndex(this.I);
        if (r20 != (-1)) goto L72;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_NestBridgeWebView", "Invalid pointerId=" + this.I + " in onTouchEvent");
        goto L158
    L72:
        int r21 = (int) r26.getY(r20);
        int r22 = (int) r26.getX(r20);
        int r23 = this.A - r21;
        int r24 = this.B - r22;
        if (this.D == false) goto L75;
    L83:
        int r110 = r23;
        if (this.D == false) goto L158;
        if (dispatchNestedPreScroll(0, r110, this.K, this.J, 0) == false) goto L88;
        r110 = r110 - this.K[1];
        this.L += this.J[1];
    L88:
        int[] r25 = this.J;
        this.A = r21 - r25[1];
        this.B = r22 - r25[0];
        int r27 = getScrollX();
        int r111 = getScrollY();
        int r28 = getScrollRange();
        int r29 = getHorizontalScrollRange();
        int r30 = getOverScrollMode();
        if (r30 == 0) goto L94;
        if (r30 != 1) goto L93;
        if (r28 > 0) goto L94;
    L93:
        boolean r112 = false;
    L96:
        if (s(r24, r110, r27, r111, r29, r28, 0, 0, true) == true) goto L98;
    L100:
        int r31 = getScrollY() - r111;
        int r32 = r110 - r31;
        this.K[1] = 0;
        if (this.w == false) goto L104;
    L110:
        boolean r33 = true;
    L111:
        if (r33 == false) goto L113;
        dispatchNestedScroll(0, r31, 0, r32, this.J, 0, this.K);
    L113:
        int r34 = this.A;
        int[] r35 = this.J;
        int r36 = r35[1];
        this.A = r34 - r36;
        this.B -= r35[0];
        this.L += r36;
        if (r112 == false) goto L158;
        int r37 = r110 - this.K[1];
        p();
        int r38 = r111 + r37;
        if (r38 >= 0) goto L121;
        EdgeEffectCompat.onPull(this.y, r37 / getHeight(), r26.getX(r20) / getWidth());
        if (this.z.isFinished() == true) goto L125;
        this.z.onRelease();
    L125:
        EdgeEffect r39 = this.y;
        if (r39 == null) goto L158;
        if (r39.isFinished() == true) goto L130;
    L131:
        ViewCompat.postInvalidateOnAnimation(this);
        goto L158
    L130:
        if (this.z.isFinished() == true) goto L158;
    L121:
        if (r38 <= r28) goto L125;
        EdgeEffectCompat.onPull(this.z, r37 / getHeight(), 1.0f - (r26.getX(r20) / getWidth()));
        if (this.y.isFinished() == true) goto L125;
        this.y.onRelease();
        goto L125
    L104:
        if (getScrollY() < 5) goto L106;
        boolean r40 = true;
    L107:
        if (r110 >= 0) goto L110;
        if (r40 == false) goto L110;
        r33 = false;
        goto L111
    L106:
        r40 = false;
        goto L107
    L98:
        if (hasNestedScrollingParent(0) == true) goto L100;
        this.E.clear();
    L94:
        r112 = true;
        goto L96
    L75:
        if (Math.abs(r23) <= this.F) goto L83;
        ViewParent r41 = getParent();
        if (r41 == null) goto L79;
        r41.requestDisallowInterceptTouchEvent(true);
    L79:
        this.D = true;
        if (r23 <= 0) goto L82;
        r23 = r23 - this.F;
        goto L83
    L82:
        r23 = r23 + this.F;
        goto L83
    }

    public final void r(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.I) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.A = (int) r4.getY(r1);
        this.B = (int) r4.getX(r1);
        this.I = r4.getPointerId(r1);
        VelocityTracker r5 = this.E;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
        if (r1 == false) goto L4;
        t();
    L4:
        super/*android.webkit.WebView*/.requestDisallowInterceptTouchEvent(r1);
    }

    public void setNestedScrollingEnabled(boolean r2) {
        if (this.P == false) goto L5;
        this.O.setNestedScrollingEnabled(r2);
        return;
    L5:
        this.O.setNestedScrollingEnabled(false);
    }

    public final boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    public final void stopNestedScroll(int r2) {
        this.O.stopNestedScroll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NestBridgeWebView(Context r3, boolean r4) {
        super(r3);
        int r5 = com.ss.android.lark.officesdk.utils.di.g.a;
        this.w = com.ss.android.lark.officesdk.utils.di.g.a.a("cml_allow_native_scroll");
        this.C = false;
        this.D = false;
        this.I = -1;
        this.J = new int[2];
        this.K = new int[2];
        this.P = false;
        this.S = false;
        this.P = r4;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_NestBridgeWebView", "NestBridgeWebView: isNestedEnable=" + r4);
        this.x = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r6 = ViewConfiguration.get(getContext());
        this.F = r6.getScaledTouchSlop();
        this.G = r6.getScaledMinimumFlingVelocity();
        this.H = r6.getScaledMaximumFlingVelocity();
        setOverScrollMode(1);
        this.O = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(r4);
    }

    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.O.dispatchNestedPreFling(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(int r12, int r13) {
        this.x.fling(getScrollX(), getScrollY(), r12, r13, 0, getHorizontalScrollRange(), PluginList.LEVEL_NOT_SET, Integer.MAX_VALUE, 0, 0);
        startNestedScroll(2, 1);
        this.M = getScrollY();
        this.N = getScrollX();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final boolean startNestedScroll(int r2, int r3) {
        return this.O.startNestedScroll(r2, r3);
    }

    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.O.dispatchNestedFling(r2, r3, r4);
    }

    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onOverScrolled(int r1, int r2, boolean r3, boolean r4) {
        super/*android.webkit.WebView*/.onOverScrolled(r1, r2, r3, r4);
        this.C = r3;
    }

    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.O.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.O.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    public final boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.O.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public final void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        this.O.dispatchNestedScroll(r9, r10, r11, r12, r13, r14, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean s(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int r1 = r15 + r13;
        int r3 = r16 + r14;
        int r5 = 0 + r17;
        int r6 = 0 + r18;
        if (r1 <= r5) goto L5;
        r1 = r5;
    L7:
        boolean r7 = true;
    L9:
        if (r3 <= r6) goto L11;
        r3 = r6;
    L13:
        boolean r8 = true;
    L15:
        if (r7 == true) goto L18;
        if (r8 == true) goto L18;
    L20:
        if (r21 == true) goto L22;
    L23:
        onOverScrolled(r1, r3, r7, r8);
    L24:
        if (r7 == false) goto L27;
        if (r8 == false) goto L27;
        return true;
    L27:
        return false;
    L22:
        if (this.w == false) goto L24;
    L18:
        if (hasNestedScrollingParent(1) == true) goto L20;
        int r110 = r1;
        int r111 = r3;
        this.x.springBack(r110, r111, 0, getHorizontalScrollRange(), 0, getScrollRange());
        goto L20
    L11:
        if (r3 >= 0) goto L14;
        r3 = 0;
        goto L13
    L14:
        r8 = false;
        goto L15
    L5:
        if (r1 >= 0) goto L8;
        r1 = 0;
        goto L7
    L8:
        r7 = false;
        goto L9
    }
}

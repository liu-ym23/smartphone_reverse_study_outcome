package com.lynx.tasm.behavior.ui.list.container;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.oui.panel.i;
import en.h;
import fn.d;
import fn.e;
import fn.f;
import fn.g;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NestedScrollContainerView extends FrameLayout implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final i f10547y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f10548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10550c;
    public final int d;
    public final int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f10555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int[] f10556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f10557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int[] f10558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f10559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public VelocityTracker f10560q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g f10561r;
    public final ArrayList s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f10562t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final NestedScrollingParentHelper f10563u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final NestedScrollingChildHelper f10564v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f10565w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10566x;

    static {
        f10547y = new i(1);
    }

    public NestedScrollContainerView(Context r5) {
        super(r5, null, 0);
        this.f10548a = null;
        this.f10549b = true;
        this.f10550c = 0;
        this.d = 0;
        this.e = 0;
        this.f10553j = 1;
        this.f10554k = -1;
        this.f10555l = new int[2];
        this.f10556m = new int[2];
        this.f10557n = new int[2];
        this.f10558o = new int[2];
        this.f10559p = new int[2];
        this.s = new ArrayList();
        this.f10562t = new ArrayList();
        this.f10565w = -1.0f;
        this.f10566x = false;
        this.f10563u = new NestedScrollingParentHelper(this);
        this.f10564v = new NestedScrollingChildHelper(this);
        this.f10561r = new g((ListContainerView) this);
        setNestedScrollingEnabled(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r10 = ViewConfiguration.get(getContext());
        this.f10550c = r10.getScaledTouchSlop();
        this.d = r10.getScaledMinimumFlingVelocity();
        this.e = r10.getScaledMaximumFlingVelocity();
    }

    private int getNestedScrollAxis() {
        if (this.f10549b == false) goto L6;
        return 2;
    L6:
        return 1;
    }

    public final void a(int r10, int r11, int[] r12) {
        int r5 = getScrollX();
        int r13 = getScrollY();
        int r14 = getScrollRange();
        boolean r15 = this.f10549b;
        if (r15 == false) goto L5;
        int r16 = 0;
    L6:
        int r17 = r5 + r10;
        if (r17 >= 0) goto L9;
        r10 = -r5;
    L11:
        if (r15 == true) goto L14;
        r14 = 0;
    L14:
        int r18 = r13 + r11;
        if (r18 >= 0) goto L17;
        r11 = -r13;
    L20:
        if (Math.abs(r10) <= 0) goto L22;
    L23:
        super.scrollTo(r5 + r10, r13 + r11);
    L24:
        if (r12 == null) goto L27;
        r12[0] = r10;
        r12[1] = r11;
        return;
    L27:
        return;
    L22:
        if (Math.abs(r11) <= 0) goto L24;
    L17:
        if (r18 <= r14) goto L20;
        r11 = r14 - r13;
        goto L20
    L9:
        if (r17 <= r16) goto L11;
        r10 = r16 - r5;
        goto L11
    L5:
        r16 = r14;
        goto L6
    }

    public final boolean b(int r5) {
        int r10 = getScrollX();
        if (this.f10549b == false) goto L5;
        int r11 = 0;
    L6:
        int r12 = r10 + r11;
        int r13 = getScrollY();
        if (this.f10549b == true) goto L10;
        r5 = 0;
    L10:
        int r14 = r13 + r5;
        int r15 = getScrollRange();
        if (this.f10549b == false) goto L16;
        if (r14 <= 0) goto L15;
        if (r14 >= r15) goto L15;
        return true;
    L15:
        return false;
    L16:
        if (r12 <= 0) goto L19;
        if (r12 >= r15) goto L19;
        return true;
    L19:
        return false;
    L5:
        r11 = r5;
        goto L6
    }

    public final boolean c(int r20, int r21) {
        boolean r5 = this.f10549b;
        int r10 = this.d;
        if (r5 == false) goto L5;
    L8:
        int r11 = 0;
    L10:
        if (this.f10549b == true) goto L12;
    L15:
        int r12 = 0;
    L16:
        if (r11 != 0) goto L19;
        if (r12 != 0) goto L19;
        return false;
    L19:
        float r13 = r11;
        float r14 = r12;
        NestedScrollingChildHelper r15 = this.f10564v;
        if (r15.dispatchNestedPreFling(r13, r14) == true) goto L41;
        r15.dispatchNestedFling(r13, r14, true);
        r15.startNestedScroll(getNestedScrollAxis(), 1);
        int r16 = this.e;
        int r17 = Math.max(-r16, Math.min(r11, r16));
        int r18 = Math.max(-r16, Math.min(r12, r16));
        g r19 = this.f10561r;
        r19.g.setScrollState(3);
        r19.f = null;
        ListContainerView r22 = r19.g;
        r19.f16952a = r22.getScrollX();
        int r110 = r22.getScrollY();
        r19.f16953b = r110;
        r19.f16954c = 0;
        r19.d = 0;
        if (r22.f10548a != null) goto L38;
        float r23 = r22.f10565w;
        if (r23 <= 0.0f) goto L37;
        boolean r24 = r22.f10549b;
        if (r24 == false) goto L28;
        float r25 = r110;
    L30:
        if (r23 != Float.MAX_VALUE) goto L32;
        float r26 = r19.a(true) - r25;
        float r27 = r25 - r19.a(false);
    L36:
        r19.e.c(r19.f16952a, r19.f16953b, r17, r18, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, (int) r26, (int) r27);
    L39:
        r22.removeCallbacks(r19);
        ViewCompat.postOnAnimation(r22, r19);
        return true;
    L32:
        if (r24 == false) goto L34;
        int r28 = r22.getHeight();
    L35:
        r26 = r23 * r28;
        r27 = r26;
        goto L36
    L34:
        r28 = r22.getWidth();
        goto L35
    L28:
        r25 = r19.f16952a;
        goto L30
    L37:
        r19.e.c(r19.f16952a, r110, r17, r18, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        goto L39
    L38:
        r19.b(r17, r18);
        goto L39
    L41:
        return false;
    L12:
        if (Math.abs(r21) < r10) goto L15;
        r12 = r21;
        goto L16
    L5:
        if (Math.abs(r20) < r10) goto L8;
        r11 = r20;
        goto L10
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r5) {
        if (this.f10549b == false) goto L5;
        return false;
    L5:
        if (super.canScrollHorizontally(r5) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r5) {
        if (this.f10549b == true) goto L5;
        return false;
    L5:
        if (super.canScrollVertically(r5) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        if (this.f10549b == false) goto L5;
        return 0;
    L5:
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        if (this.f10549b == false) goto L5;
        return 0;
    L5:
        int r5 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (getChildCount() > 0) goto L8;
    L13:
        return r5;
    L8:
        if (getChildAt(0) == null) goto L13;
        View r10 = getChildAt(0);
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof FrameLayout.LayoutParams) == false) goto L13;
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
        return (r10.getWidth() + r12.leftMargin) + r12.rightMargin;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        if (this.f10549b == true) goto L5;
        return 0;
    L5:
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        if (this.f10549b == true) goto L5;
        return 0;
    L5:
        int r5 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (getChildCount() > 0) goto L8;
    L13:
        return r5;
    L8:
        if (getChildAt(0) == null) goto L13;
        View r10 = getChildAt(0);
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof FrameLayout.LayoutParams) == false) goto L13;
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
        return (r10.getHeight() + r12.topMargin) + r12.bottomMargin;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        return this.f10564v.dispatchNestedFling(r5, r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r5, float r10) {
        return this.f10564v.dispatchNestedPreFling(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        boolean r15 = this.f10564v.dispatchNestedPreScroll(r10, r11, r12, r13, r14);
        UIListContainer r16 = ((ListContainerView) this).f10546z;
        if (r16 == null) goto L6;
        if (r15 == false) goto L6;
        r16.recognizeGesturere();
    L6:
        return r15;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return this.f10564v.dispatchNestedScroll(r10, r11, r12, r13, r14, 0);
    }

    public e getCustomScrollHook() {
        g r5 = this.f10561r;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f10563u.getNestedScrollAxes();
    }

    public int getScrollRange() {
        if (getChildCount() > 0) goto L5;
    L15:
        return 0;
    L5:
        if (getChildAt(0) == null) goto L15;
        View r5 = getChildAt(0);
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof FrameLayout.LayoutParams) == false) goto L15;
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10;
        if (this.f10549b == false) goto L12;
        int r12 = (r5.getHeight() + r11.topMargin) + r11.bottomMargin;
        int r13 = getHeight() - getPaddingTop();
        int r14 = getPaddingBottom();
    L14:
        return Math.max(0, r12 - (r13 - r14));
    L12:
        r12 = (r5.getWidth() + r11.leftMargin) + r11.rightMargin;
        r13 = getWidth() - getPaddingLeft();
        r14 = getPaddingRight();
        goto L14
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f10564v.hasNestedScrollingParent(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f10564v.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f10560q != null) goto L5;
        this.f10560q = VelocityTracker.obtain();
    L5:
        this.f10560q.addMovement(r10);
        int r5 = r10.getActionMasked();
        NestedScrollingChildHelper r11 = this.f10564v;
        if (r5 == 0) goto L54;
        if (r5 == 1) goto L53;
        if (r5 == 2) goto L26;
        if (r5 != 3) goto L11;
        VelocityTracker r12 = this.f10560q;
        if (r12 == null) goto L25;
        r12.clear();
    L25:
        r11.stopNestedScroll(0);
        setScrollState(1);
    L61:
        if (this.f10553j != 2) goto L63;
        return true;
    L63:
        return false;
    L11:
        if (r5 != 5) goto L13;
        int r13 = r10.getActionIndex();
        this.f10554k = r10.getPointerId(r13);
        int r14 = (int) (r10.getX(r13) + 0.5f);
        this.f10551h = r14;
        this.f = r14;
        int r15 = (int) (r10.getY(r13) + 0.5f);
        this.f10552i = r15;
        this.g = r15;
        goto L61
    L13:
        if (r5 != 6) goto L61;
        int r16 = r10.getActionIndex();
        if (r10.getPointerId(r16) != this.f10554k) goto L61;
        if (r16 != 0) goto L19;
        int r17 = 1;
    L20:
        this.f10554k = r10.getPointerId(r17);
        int r18 = (int) (r10.getX(r17) + 0.5f);
        this.f10551h = r18;
        this.f = r18;
        int r19 = (int) (r10.getY(r17) + 0.5f);
        this.f10552i = r19;
        this.g = r19;
        goto L61
    L19:
        r17 = 0;
        goto L20
    L26:
        int r20 = this.f10554k;
        if (r20 == (-1)) goto L61;
        int r21 = r10.findPointerIndex(r20);
        if (r21 >= 0) goto L32;
        return false;
    L32:
        int r22 = (int) (r10.getX(r21) + 0.5f);
        int r23 = (int) (r10.getY(r21) + 0.5f);
        if (this.f10553j == 2) goto L61;
        int r24 = r22 - this.f;
        int r25 = r23 - this.g;
        boolean r26 = this.f10549b;
        int r27 = this.f10550c;
        if (r26 == true) goto L37;
    L41:
        boolean r28 = false;
    L43:
        if (this.f10549b == false) goto L45;
    L49:
        boolean r29 = false;
    L50:
        if (r28 == true) goto L52;
        if (r29 == false) goto L61;
    L52:
        this.f10551h = r22;
        this.f10552i = r23;
        setScrollState(2);
        goto L61
    L45:
        if (Math.abs(r24) <= r27) goto L49;
        if ((getNestedScrollAxes() & 1) != 0) goto L49;
        r29 = true;
        goto L50
    L37:
        if (Math.abs(r25) <= r27) goto L41;
        if ((getNestedScrollAxes() & 2) != 0) goto L41;
        r28 = true;
        goto L43
    L53:
        this.f10560q.clear();
        r11.stopNestedScroll(0);
        goto L61
    L54:
        this.f10554k = r10.getPointerId(0);
        int r30 = (int) (r10.getX() + 0.5f);
        this.f10551h = r30;
        this.f = r30;
        int r31 = (int) (r10.getY() + 0.5f);
        this.f10552i = r31;
        this.g = r31;
        int r32 = this.f10553j;
        if (r32 != 3) goto L57;
    L58:
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(2);
    L59:
        int[] r33 = this.f10557n;
        r33[1] = 0;
        r33[0] = 0;
        r11.startNestedScroll(getNestedScrollAxis(), 0);
        goto L61
    L57:
        if (r32 != 4) goto L59;
        goto L58
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        if (r12 == false) goto L4;
        return false;
    L4:
        return c((int) r10, (int) r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r5, float r10, float r11) {
        return this.f10564v.dispatchNestedPreFling(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        dispatchNestedPreScroll(r11, r12, r13, null, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        int r16 = getScrollRange();
        if (this.f10549b == false) goto L6;
        int r17 = getScrollY();
        scrollTo(getScrollX(), MathUtils.clamp(r17 + r14, 0, r16));
        int r5 = getScrollY() - r17;
        NestedScrollingChildHelper r18 = this.f10564v;
        r18.dispatchNestedScroll(0, r5, 0, r14 - r5, null, r15);
        return;
    L6:
        int r19 = getScrollX();
        scrollTo(MathUtils.clamp(r19 + r13, 0, r16), getScrollY());
        int r20 = getScrollX() - r19;
        NestedScrollingChildHelper r21 = this.f10564v;
        r21.dispatchNestedScroll(r20, 0, r13 - r20, 0, null, r15);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
        this.f10563u.onNestedScrollAccepted(r5, r10, r11, r12);
        boolean r13 = this.f10549b;
        NestedScrollingChildHelper r14 = this.f10564v;
        if (r13 == false) goto L6;
        r14.startNestedScroll(2, r12);
        return;
    L6:
        r14.startNestedScroll(1, r12);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        if (this.f10549b == false) goto L9;
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

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r5, int r10) {
        this.f10563u.onStopNestedScroll(r5, r10);
        this.f10564v.stopNestedScroll(r10);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r24) {
        if (this.f10560q != null) goto L5;
        this.f10560q = VelocityTracker.obtain();
    L5:
        MotionEvent r10 = MotionEvent.obtain(r24);
        int r5 = r24.getActionMasked();
        int[] r11 = this.f10557n;
        int r12 = 0;
        if (r5 != 0) goto L8;
        r11[1] = 0;
        r11[0] = 0;
    L8:
        r10.offsetLocation(r11[0], r11[1]);
        NestedScrollingChildHelper r13 = this.f10564v;
        if (r5 != 0) goto L11;
        this.f10554k = r24.getPointerId(0);
        int r14 = (int) (r24.getX() + 0.5f);
        this.f10551h = r14;
        this.f = r14;
        int r15 = (int) (r24.getY() + 0.5f);
        this.f10552i = r15;
        this.g = r15;
        r13.startNestedScroll(getNestedScrollAxis(), 0);
    L94:
        this.f10560q.addMovement(r10);
    L95:
        r10.recycle();
        return true;
    L11:
        if (r5 != 1) goto L13;
        this.f10560q.addMovement(r10);
        this.f10560q.computeCurrentVelocity(1000, this.e);
        float r16 = 0.0f;
        if (this.f10549b == true) goto L76;
        float r17 = -this.f10560q.getXVelocity(this.f10554k);
    L78:
        if (this.f10549b == false) goto L81;
        r16 = -this.f10560q.getYVelocity(this.f10554k);
    L81:
        if (c((int) r17, (int) r16) == true) goto L89;
        g r18 = this.f10561r;
        ListContainerView r19 = r18.g;
        if (r19.f10548a != null) goto L86;
    L87:
        setScrollState(1);
        goto L89
    L86:
        if (r19.f10553j == 1) goto L87;
        r19.setScrollState(3);
        r18.f = null;
        ListContainerView r20 = r18.g;
        r18.f16952a = r20.getScrollX();
        r18.f16953b = r20.getScrollY();
        r18.f16954c = 0;
        r18.d = 0;
        r18.b(0, 0);
        r20.removeCallbacks(r18);
        ViewCompat.postOnAnimation(r20, r18);
    L89:
        VelocityTracker r21 = this.f10560q;
        if (r21 == null) goto L92;
        r21.clear();
    L92:
        r13.stopNestedScroll(0);
        goto L95
    L76:
        r17 = 0.0f;
        goto L78
    L13:
        if (r5 == 2) goto L30;
        if (r5 != 3) goto L16;
        VelocityTracker r22 = this.f10560q;
        if (r22 == null) goto L29;
        r22.clear();
    L29:
        r13.stopNestedScroll(0);
        setScrollState(1);
        goto L94
    L16:
        if (r5 != 5) goto L18;
        int r23 = r24.getActionIndex();
        this.f10554k = r24.getPointerId(r23);
        int r25 = (int) (r24.getX(r23) + 0.5f);
        this.f10551h = r25;
        this.f = r25;
        int r26 = (int) (r24.getY(r23) + 0.5f);
        this.f10552i = r26;
        this.g = r26;
        goto L94
    L18:
        if (r5 != 6) goto L94;
        int r27 = r24.getActionIndex();
        if (r24.getPointerId(r27) != this.f10554k) goto L94;
        if (r27 != 0) goto L24;
        r12 = 1;
    L24:
        this.f10554k = r24.getPointerId(r12);
        int r28 = (int) (r24.getX(r12) + 0.5f);
        this.f10551h = r28;
        this.f = r28;
        int r29 = (int) (r24.getY(r12) + 0.5f);
        this.f10552i = r29;
        this.g = r29;
        goto L94
    L30:
        int r30 = this.f10554k;
        if (r30 == (-1)) goto L94;
        int r31 = r24.findPointerIndex(r30);
        if (r31 >= 0) goto L36;
        return false;
    L36:
        int r110 = (int) (r24.getX(r31) + 0.5f);
        int r111 = (int) (r24.getY(r31) + 0.5f);
        int r112 = this.f10551h - r110;
        int r113 = this.f10552i - r111;
        boolean r32 = dispatchNestedPreScroll(r112, r113, this.f10556m, this.f10555l, 0);
        int[] r33 = this.f10555l;
        if (r32 == false) goto L40;
        int[] r34 = this.f10556m;
        r112 = r112 - r34[0];
        r113 = r113 - r34[1];
        r10.offsetLocation(r33[0], r33[1]);
        r11[0] = r11[0] + r33[0];
        r11[1] = r11[1] + r33[1];
    L40:
        if (this.f10553j == 2) goto L58;
        boolean r35 = this.f10549b;
        int r36 = this.f10550c;
        if (r35 == false) goto L50;
        if (Math.abs(r113) <= r36) goto L50;
        if (r113 <= 0) goto L47;
        r113 = r113 - r36;
    L48:
        setScrollState(2);
        goto L58
    L47:
        r113 = r113 + r36;
    L50:
        if (this.f10549b == true) goto L58;
        if (Math.abs(r112) <= r36) goto L58;
        if (r112 <= 0) goto L55;
        r112 = r112 - r36;
    L56:
        setScrollState(2);
        goto L58
    L55:
        r112 = r112 + r36;
    L58:
        if (this.f10553j != 2) goto L94;
        this.f10551h = r110 - r33[0];
        this.f10552i = r111 - r33[1];
        boolean r37 = this.f10549b;
        if (r37 == false) goto L62;
        r112 = 0;
    L62:
        if (r37 == true) goto L65;
        r113 = 0;
    L65:
        int[] r38 = this.f10558o;
        r38[0] = 0;
        r38[1] = 0;
        a(r112, r113, r38);
        int r114 = r38[0];
        int r115 = r38[1];
        if (this.f10564v.dispatchNestedScroll(r114, r115, r112 - r114, r113 - r115, this.f10555l, 0) == false) goto L69;
        int r39 = this.f10551h;
        int r40 = r33[0];
        this.f10551h = r39 - r40;
        int r41 = this.f10552i;
        int r42 = r33[1];
        this.f10552i = r41 - r42;
        r10.offsetLocation(r40, r42);
        r11[0] = r11[0] + r33[0];
        r11[1] = r11[1] + r33[1];
    L69:
        if (r38[0] == 0) goto L71;
    L72:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L94
    L71:
        if (r38[1] == 0) goto L94;
        goto L72
    }

    public void setCustomScrollHook(e r5) {
        g r10 = this.f10561r;
        if (r10 == null) goto L6;
        r10.f = r5;
        return;
    }

    public void setEnableScroll(boolean r5) {
        setOnTouchListener(new d(r5, 0));
    }

    public void setIsVertical(boolean r5) {
        this.f10549b = r5;
    }

    public void setMaxFlingDistanceRatio(float r5) {
        this.f10565w = r5;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        this.f10564v.setNestedScrollingEnabled(r5);
    }

    public void setScrollState(int r5) {
        LynxLog.b(2, "UIListContainer.NestedScrollContainerView", "setScrollState: " + this.f10553j + " -> " + r5);
        if (r5 != this.f10553j) goto L6;
        return;
    L6:
        if (this.f10566x == true) goto L8;
    L10:
        this.f10553j = r5;
        if (r5 != 3) goto L13;
    L24:
        Iterator r10 = this.s.iterator();
    L26:
        if (r10.hasNext() == false) goto L31;
        ((UIListContainer) ((f) r10.next())).t(r5);
        goto L26
    L31:
        return;
    L13:
        if (r5 == 4) goto L24;
        g r11 = this.f10561r;
        r11.g.removeCallbacks(r11);
        r11.e.a();
        e r12 = r11.f;
        if (r12 == null) goto L24;
        UIListContainer r13 = ((fn.h) r12).f16957c;
        LynxContext r14 = r13.getLynxContext();
        if (r14 != null) goto L19;
    L23:
        r11.f = null;
        goto L24
    L19:
        if (r14.f10141i == null) goto L23;
        com.lynx.tasm.i r15 = r13.getLynxContext().f10141i;
        int r16 = r13.getSign();
        LynxTemplateRender r17 = (LynxTemplateRender) r15.f10879a;
        if (r17 == null) goto L23;
        r17.b0(r16);
        goto L23
    L8:
        if (r5 != 1) goto L10;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r5) {
        return this.f10564v.startNestedScroll(r5, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f10564v.stopNestedScroll(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return this.f10564v.dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r5) {
        return this.f10564v.hasNestedScrollingParent(r5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        dispatchNestedPreScroll(r11, r12, r13, null, r14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r5, View r10, int r11) {
        return onStartNestedScroll(r5, r10, r11, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r5, int r10) {
        return this.f10564v.startNestedScroll(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r5) {
        this.f10564v.stopNestedScroll(r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r5) {
        onStopNestedScroll(r5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r5, View r10, int r11) {
        onNestedScrollAccepted(r5, r10, r11, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        return dispatchNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r10, r11, r12, r13, r14, 0);
    }
}

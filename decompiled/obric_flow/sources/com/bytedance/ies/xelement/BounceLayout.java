package com.bytedance.ies.xelement;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import com.lynx.base.log.LynxLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import oe.c;
import oe.d;
import oe.i;
import oe.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u0010\f.J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u000bR.\u0010)\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R.\u0010-\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(¨\u0006/"}, d2 = {"Lcom/bytedance/ies/xelement/BounceLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Landroidx/core/view/NestedScrollingChild2;", "", "getNestedScrollAxes", "()I", "", "enabled", "", "setNestedScrollingEnabled", "(Z)V", "Loe/d;", "listener", "setOnScrollToEndListener", "(Loe/d;)V", "Loe/c;", "setOnBounceScrollListener", "(Loe/c;)V", "Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;", "a", "Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;", "getMScrollDirection", "()Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;", "setMScrollDirection", "(Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;)V", "mScrollDirection", "b", "Z", "getMEnableBounce", "()Z", "setMEnableBounce", "mEnableBounce", "Landroid/view/View;", "value", "j", "Landroid/view/View;", "getMContentView", "()Landroid/view/View;", "setMContentView", "(Landroid/view/View;)V", "mContentView", "k", "getMBounceView", "setMBounceView", "mBounceView", "ScrollDirection", "x-element-scroll_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceLayout extends FrameLayout implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrollDirection f6347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedScrollingParentHelper f6349c;
    public final NestedScrollingChildHelper d;
    public int e;
    public boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OverScroller f6351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f6352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f6353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f6354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f6355m;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;", "", "x-element-scroll_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScrollDirection f6356a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ScrollDirection f6357b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ScrollDirection f6358c = null;
        public static final ScrollDirection d = null;
        public static final /* synthetic */ ScrollDirection[] e = null;

        static {
            ScrollDirection r5 = new ScrollDirection("VERTICAL_TOP", 0);
            f6356a = r5;
            ScrollDirection r10 = new ScrollDirection("VERTICAL_BOTTOM", 1);
            f6357b = r10;
            ScrollDirection r11 = new ScrollDirection("HORIZONTAL_LEFT", 2);
            f6358c = r11;
            ScrollDirection r12 = new ScrollDirection("HORIZONTAL_RIGHT", 3);
            d = r12;
            e = new ScrollDirection[]{r5, r10, r11, r12};
        }

        public ScrollDirection(String r5, int r10) {
            super(r5, r10);
        }

        public static ScrollDirection valueOf(String r5) {
            return (ScrollDirection) Enum.valueOf(ScrollDirection.class, r5);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) e.clone();
        }
    }

    public BounceLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5, null, 0);
        this.f6347a = ScrollDirection.d;
        this.f6349c = new NestedScrollingParentHelper(this);
        this.d = new NestedScrollingChildHelper(this);
        this.f6351i = new OverScroller(r5);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r5) {
        ScrollDirection r10 = this.f6347a;
        if (r10 != ScrollDirection.d) goto L5;
        return true;
    L5:
        if (r10 == ScrollDirection.f6358c) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r5) {
        ScrollDirection r10 = this.f6347a;
        if (r10 != ScrollDirection.f6356a) goto L5;
        return true;
    L5:
        if (r10 == ScrollDirection.f6357b) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        ScrollDirection r5 = this.f6347a;
        if (r5 != ScrollDirection.d) goto L17;
        if (r5 != ScrollDirection.f6358c) goto L17;
        int r10 = getChildCount();
        int r11 = 0;
        if (r10 < 0) goto L14;
        int r12 = 0;
    L10:
        r12 = r12 + getChildAt(r11).getWidth();
        if (r11 == r10) goto L13;
        r11 = r11 + 1;
        goto L10
    L13:
        r11 = r12;
    L14:
        Log.d("BounceLayout", "computeHorizontalScrollRange: " + r11);
        return r11;
    L17:
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public final void computeScroll() {
        OverScroller r5 = this.f6351i;
        if (r5.computeScrollOffset() == false) goto L9;
        scrollTo(r5.getCurrX(), r5.getCurrY());
        c r10 = this.f6354l;
        if (r10 == null) goto L7;
        j r11 = (j) r10;
        r11.a(r5.getCurrX(), r5.getCurrY(), this.g, this.f6350h);
    L7:
        this.g = r5.getCurrX();
        this.f6350h = r5.getCurrY();
        postInvalidate();
        return;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        ScrollDirection r5 = this.f6347a;
        if (r5 != ScrollDirection.f6357b) goto L17;
        if (r5 != ScrollDirection.f6356a) goto L17;
        int r10 = getChildCount();
        int r11 = 0;
        if (r10 < 0) goto L14;
        int r12 = 0;
    L10:
        r12 = r12 + getChildAt(r11).getHeight();
        if (r11 == r10) goto L13;
        r11 = r11 + 1;
        goto L10
    L13:
        r11 = r12;
    L14:
        Log.d("BounceLayout", "computeVerticalScrollRange: " + r11);
        return r11;
    L17:
        return super.computeVerticalScrollRange();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        Log.d("BounceLayout", "dispatchNestedFling");
        return this.d.dispatchNestedFling(r5, r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r5, float r10) {
        Log.d("BounceLayout", "dispatchNestedPreFling");
        return this.d.dispatchNestedPreFling(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        Log.d("BounceLayout", "dispatchNestedPreScroll");
        return this.d.dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        Log.d("BounceLayout", "dispatchNestedScroll");
        return this.d.dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    public final View getMBounceView() {
        return this.f6353k;
    }

    public final View getMContentView() {
        return this.f6352j;
    }

    public final boolean getMEnableBounce() {
        return this.f6348b;
    }

    public final ScrollDirection getMScrollDirection() {
        return this.f6347a;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f6349c.getNestedScrollAxes();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r5) {
        Log.d("BounceLayout", "hasNestedScrollingParent");
        return this.d.hasNestedScrollingParent(r5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        Log.d("BounceLayout", "isNestedScrollingEnabled");
        return this.d.isNestedScrollingEnabled();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, getLeft(), getTop(), getRight(), getBottom());     // Catch: IllegalStateException -> L17
        View r15 = this.f6353k;     // Catch: IllegalStateException -> L17
        if (r15 == null) goto L30;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();     // Catch: IllegalStateException -> L17
        if (r16 == null) goto L26;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;     // Catch: IllegalStateException -> L17
        int r18 = this.f6347a.ordinal();     // Catch: IllegalStateException -> L17
        if (r18 != 0) goto L9;
        int r19 = r17.leftMargin;     // Catch: IllegalStateException -> L17
        int r20 = -(r15.getMeasuredHeight() + r17.bottomMargin);
    L23:
        r15.layout(r19, r20, r15.getMeasuredWidth() + r19, r15.getMeasuredHeight() + r20);     // Catch: IllegalStateException -> L17
        return;
    L9:
        if (r18 != 1) goto L11;
        int r110 = r17.leftMargin;     // Catch: IllegalStateException -> L17
        r20 = getMeasuredHeight() + r17.topMargin;     // Catch: IllegalStateException -> L17
        r19 = r110;
        goto L23
    L11:
        if (r18 != 2) goto L13;
        int r21 = -(r15.getMeasuredWidth() + r17.rightMargin);
        int r22 = r17.topMargin;     // Catch: IllegalStateException -> L17
    L20:
        r20 = r22;
        r19 = r21;
        goto L23
    L13:
        if (r18 == 3) goto L15;
        r19 = 0;
        r20 = 0;
        goto L23
    L15:
        r21 = getMeasuredWidth() + r17.leftMargin;     // Catch: IllegalStateException -> L17
        r22 = r17.topMargin;     // Catch: IllegalStateException -> L17
        goto L20
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");     // Catch: IllegalStateException -> L17
    L30:
        return;
    L17:
        e = move-exception;
        LynxLog.b(4, "BounceLayout", "Exception during layout: " + e.getMessage());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        View r12 = this.f6353k;
        if (r12 == null) goto L24;
        measureChildWithMargins(r12, r10, 0, r11, 0);
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L23;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        int r15 = this.f6347a.ordinal();
        if (r15 != 0) goto L9;
    L19:
        int r16 = r12.getMeasuredHeight() + r14.topMargin;
        int r17 = r14.bottomMargin;
    L20:
        this.e = r16 + r17;
        return;
    L9:
        if (r15 == 1) goto L19;
        if (r15 != 2) goto L13;
    L17:
        r16 = r12.getMeasuredWidth() + r14.rightMargin;
        r17 = r14.leftMargin;
        goto L20
    L13:
        if (r15 == 3) goto L17;
        throw new NoWhenBranchMatchedException();
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r5, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r5, "target");
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r5, int r10, int r11, int[] r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r12, "consumed");
        if (r13 != 0) goto L141;
        int r14 = this.f6347a.ordinal();
        if (r14 == 0) goto L104;
        if (r14 == 1) goto L74;
        if (r14 == 2) goto L44;
        if (r14 == 3) goto L14;
        return;
    L14:
        if (r5.canScrollHorizontally(1) == true) goto L28;
        if (r10 <= 0) goto L28;
        int r15 = getScrollX() + r10;
        int r16 = this.e;
        if (r15 <= r16) goto L22;
        c r17 = this.f6354l;
        if (r17 == null) goto L21;
        j r18 = (j) r17;
        r18.a(r16, 0, getScrollX(), 0);
    L21:
        scrollTo(this.e, getScrollY());
    L26:
        r12[0] = r10;
        this.g = getScrollX();
        return;
    L22:
        requestDisallowInterceptTouchEvent(true);
        c r19 = this.f6354l;
        if (r19 == null) goto L25;
        j r20 = (j) r19;
        r20.a(getScrollX() + r10, 0, getScrollX(), 0);
    L25:
        scrollBy(r10, 0);
    L28:
        if (r10 < 0) goto L30;
        return;
    L30:
        if (getScrollX() > 0) goto L32;
        return;
    L32:
        if (Math.abs(r10) <= getScrollX()) goto L37;
        c r21 = this.f6354l;
        if (r21 == null) goto L36;
        j r22 = (j) r21;
        r22.a(0, 0, getScrollX(), 0);
    L36:
        scrollBy(-getScrollX(), 0);
    L41:
        r12[0] = r10;
        this.g = getScrollX();
        return;
    L37:
        c r23 = this.f6354l;
        if (r23 == null) goto L40;
        j r24 = (j) r23;
        r24.a(getScrollX() + r10, 0, getScrollX(), 0);
    L40:
        scrollBy(r10, 0);
        goto L41
    L44:
        if (r5.canScrollHorizontally(-1) == true) goto L58;
        if (r10 >= 0) goto L58;
        int r25 = Math.abs(r10);
        int r26 = Math.abs(getScrollX()) + r25;
        int r27 = this.e;
        if (r26 <= r27) goto L52;
        c r28 = this.f6354l;
        if (r28 == null) goto L51;
        j r29 = (j) r28;
        r29.a(-r27, 0, getScrollX(), 0);
    L51:
        scrollTo(-this.e, getScrollY());
    L56:
        r12[0] = r10;
        this.g = getScrollX();
        return;
    L52:
        requestDisallowInterceptTouchEvent(true);
        c r30 = this.f6354l;
        if (r30 == null) goto L55;
        j r31 = (j) r30;
        r31.a(getScrollX() + r10, 0, getScrollX(), 0);
    L55:
        scrollBy(r10, 0);
    L58:
        if (r10 > 0) goto L60;
        return;
    L60:
        if (getScrollX() < 0) goto L62;
        return;
    L62:
        if (r10 <= Math.abs(getScrollX())) goto L67;
        c r32 = this.f6354l;
        if (r32 == null) goto L66;
        j r33 = (j) r32;
        r33.a(0, 0, -getScrollX(), 0);
    L66:
        scrollBy(-getScrollX(), 0);
    L71:
        r12[0] = r10;
        this.g = getScrollX();
        return;
    L67:
        c r34 = this.f6354l;
        if (r34 == null) goto L70;
        j r35 = (j) r34;
        r35.a(getScrollX() + r10, 0, getScrollX(), 0);
    L70:
        scrollBy(r10, 0);
        goto L71
    L74:
        if (r5.canScrollVertically(1) == true) goto L88;
        if (r11 <= 0) goto L88;
        int r36 = getScrollY() + r11;
        int r37 = this.e;
        if (r36 <= r37) goto L82;
        c r38 = this.f6354l;
        if (r38 == null) goto L81;
        j r39 = (j) r38;
        r39.a(0, r37, 0, getScrollY());
    L81:
        scrollTo(getScrollX(), this.e);
    L86:
        r12[1] = r11;
        this.f6350h = getScrollY();
        return;
    L82:
        requestDisallowInterceptTouchEvent(true);
        c r40 = this.f6354l;
        if (r40 == null) goto L85;
        j r41 = (j) r40;
        r41.a(0, getScrollY() + r11, 0, getScrollY());
    L85:
        scrollBy(0, r11);
    L88:
        if (r11 < 0) goto L90;
        return;
    L90:
        if (getScrollY() > 0) goto L92;
        return;
    L92:
        if (Math.abs(r11) <= getScrollY()) goto L97;
        c r42 = this.f6354l;
        if (r42 == null) goto L96;
        j r43 = (j) r42;
        r43.a(0, 0, 0, getScrollY());
    L96:
        scrollBy(0, -getScrollY());
    L101:
        r12[1] = r11;
        this.f6350h = getScrollY();
        return;
    L97:
        c r44 = this.f6354l;
        if (r44 == null) goto L100;
        j r45 = (j) r44;
        r45.a(0, getScrollY() + r11, 0, getScrollY());
    L100:
        scrollBy(0, r11);
        goto L101
    L104:
        if (r5.canScrollVertically(-1) == true) goto L118;
        if (r11 >= 0) goto L118;
        int r46 = Math.abs(r11);
        int r47 = Math.abs(getScrollY()) + r46;
        int r48 = this.e;
        if (r47 <= r48) goto L112;
        c r49 = this.f6354l;
        if (r49 == null) goto L111;
        j r50 = (j) r49;
        r50.a(0, -r48, 0, getScrollY());
    L111:
        scrollTo(getScrollX(), -this.e);
    L116:
        r12[1] = r11;
        this.f6350h = getScrollY();
        return;
    L112:
        requestDisallowInterceptTouchEvent(true);
        c r51 = this.f6354l;
        if (r51 == null) goto L115;
        j r52 = (j) r51;
        r52.a(0, getScrollY() + r11, 0, getScrollY());
    L115:
        scrollBy(0, r11);
    L118:
        if (r11 > 0) goto L120;
        return;
    L120:
        if (getScrollY() < 0) goto L122;
        return;
    L122:
        if (r11 <= Math.abs(getScrollY())) goto L127;
        c r53 = this.f6354l;
        if (r53 == null) goto L126;
        j r54 = (j) r53;
        r54.a(0, 0, 0, -getScrollY());
    L126:
        scrollBy(0, -getScrollY());
    L131:
        r12[1] = r11;
        this.f6350h = getScrollY();
        return;
    L127:
        c r55 = this.f6354l;
        if (r55 == null) goto L130;
        j r56 = (j) r55;
        r56.a(0, getScrollY() + r11, 0, getScrollY());
    L130:
        scrollBy(0, r11);
        goto L131
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r5, "target");
        if (r14 != 1) goto L61;
        int r15 = this.f6347a.ordinal();
        OverScroller r16 = this.f6351i;
        if (r15 == 0) goto L44;
        if (r15 == 1) goto L34;
        if (r15 == 2) goto L24;
        if (r15 == 3) goto L14;
        return;
    L14:
        if (this.f == true) goto L16;
    L19:
        if (r10 <= 0) goto L53;
        if (r12 <= 0) goto L54;
        int r17 = this.e;
        r16.startScroll(getScrollX(), getScrollY(), r17, 0);
        invalidate();
        this.f = true;
        return;
    L54:
        return;
    L53:
        return;
    L16:
        if (Math.abs(getScrollX()) != this.e) goto L19;
        int r18 = -getScrollX();
        r16.startScroll(getScrollX(), getScrollY(), r18, 0);
        invalidate();
        this.f = false;
        return;
    L24:
        if (this.f == true) goto L26;
    L29:
        if (r10 >= 0) goto L55;
        if (r12 >= 0) goto L56;
        int r19 = -this.e;
        r16.startScroll(getScrollX(), getScrollY(), r19, 0);
        invalidate();
        this.f = true;
        return;
    L56:
        return;
    L55:
        return;
    L26:
        if (Math.abs(getScrollX()) != this.e) goto L29;
        int r20 = -getScrollX();
        r16.startScroll(getScrollX(), getScrollY(), r20, 0);
        invalidate();
        this.f = false;
        return;
    L34:
        if (this.f == true) goto L36;
    L39:
        if (r11 <= 0) goto L57;
        if (r13 <= 0) goto L58;
        int r21 = this.e;
        r16.startScroll(getScrollX(), getScrollY(), 0, r21);
        invalidate();
        this.f = true;
        return;
    L58:
        return;
    L57:
        return;
    L36:
        if (getScrollY() != this.e) goto L39;
        int r22 = -getScrollY();
        r16.startScroll(getScrollX(), getScrollY(), 0, r22);
        invalidate();
        this.f = false;
        return;
    L44:
        if (this.f == true) goto L46;
    L49:
        if (r11 <= 0) goto L59;
        if (r13 <= 0) goto L60;
        int r23 = -this.e;
        r16.startScroll(getScrollX(), getScrollY(), 0, r23);
        invalidate();
        this.f = true;
        return;
    L60:
        return;
    L59:
        return;
    L46:
        if (getScrollY() != this.e) goto L49;
        int r24 = -getScrollY();
        r16.startScroll(getScrollX(), getScrollY(), 0, r24);
        invalidate();
        this.f = false;
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "child");
        Intrinsics.checkNotNullParameter(r10, "target");
        this.f6349c.onNestedScrollAccepted(r5, r10, r11, r12);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "child");
        Intrinsics.checkNotNullParameter(r10, "target");
        if (this.f6348b == true) goto L5;
        return false;
    L5:
        int r13 = this.f6347a.ordinal();
        if (r13 == 0) goto L17;
        if (r13 == 1) goto L17;
        if (r13 != 2) goto L10;
    L14:
        if (r11 != 1) goto L16;
        return true;
    L16:
        return false;
    L10:
        if (r13 == 3) goto L14;
        throw new NoWhenBranchMatchedException();
    L17:
        if (r11 != 2) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "target");
        this.f6349c.onStopNestedScroll(r10, r11);
        if (r11 == 1) goto L53;
        int r12 = this.f6347a.ordinal();
        OverScroller r5 = this.f6351i;
        if (r12 == 0) goto L44;
        if (r12 == 1) goto L34;
        if (r12 == 2) goto L24;
        if (r12 == 3) goto L14;
        return;
    L14:
        if (getScrollX() > 0) goto L17;
        return;
    L17:
        if (getScrollX() <= (((double) this.e) * 0.88d)) goto L21;
        d r13 = this.f6355m;
        if (r13 == null) goto L21;
        ((i) r13).a();
    L21:
        r5.startScroll(getScrollX(), getScrollY(), -getScrollX(), 0);
        invalidate();
        return;
    L24:
        if (getScrollX() < 0) goto L27;
        return;
    L27:
        if (Math.abs(getScrollX()) <= (((double) this.e) * 0.88d)) goto L31;
        d r14 = this.f6355m;
        if (r14 == null) goto L31;
        ((i) r14).a();
    L31:
        r5.startScroll(getScrollX(), getScrollY(), -getScrollX(), 0);
        invalidate();
        return;
    L34:
        if (getScrollY() > 0) goto L37;
        return;
    L37:
        if (getScrollY() <= (((double) this.e) * 0.88d)) goto L41;
        d r15 = this.f6355m;
        if (r15 == null) goto L41;
        ((i) r15).a();
    L41:
        r5.startScroll(getScrollX(), getScrollY(), 0, -getScrollY());
        invalidate();
        return;
    L44:
        if (getScrollY() < 0) goto L47;
        return;
    L47:
        if (Math.abs(getScrollY()) <= (((double) this.e) * 0.88d)) goto L51;
        d r16 = this.f6355m;
        if (r16 == null) goto L51;
        ((i) r16).a();
    L51:
        r5.startScroll(getScrollX(), getScrollY(), 0, -getScrollY());
        invalidate();
        return;
    }

    public final void setMBounceView(View r5) {
        View r10 = this.f6353k;
        if (r10 == null) goto L5;
        removeView(r10);
    L5:
        if (r5 == null) goto L7;
        addView(r5);
    L7:
        this.f6353k = r5;
    }

    public final void setMContentView(View r5) {
        View r10 = this.f6352j;
        if (r10 == null) goto L5;
        removeView(r10);
    L5:
        if (r5 == null) goto L7;
        addView(r5, -1, -1);
    L7:
        this.f6352j = r5;
    }

    public final void setMEnableBounce(boolean r5) {
        this.f6348b = r5;
    }

    public final void setMScrollDirection(ScrollDirection r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f6347a = r5;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        Log.d("BounceLayout", "setNestedScrollingEnabled");
        this.d.setNestedScrollingEnabled(r5);
    }

    public final void setOnBounceScrollListener(c r5) {
        this.f6354l = r5;
    }

    public final void setOnScrollToEndListener(d r5) {
        this.f6355m = r5;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r5, int r10) {
        Log.d("BounceLayout", "startNestedScroll");
        return this.d.startNestedScroll(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r5) {
        Log.d("BounceLayout", "stopNestedScroll");
        this.d.stopNestedScroll(r5);
    }
}

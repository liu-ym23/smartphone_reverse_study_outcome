package com.larus.bmhome.double_post.drag_panel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.platform.service.z2;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002HIB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010!\u001a\u00020\"H\u0014J(\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016J(\u0010)\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016J0\u0010*\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010(\u001a\u00020\bH\u0016J8\u0010/\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016J\u0018\u00104\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020\"2\u0006\u0010,\u001a\u00020\bH\u0002J\u0010\u00107\u001a\u0002082\u0006\u0010,\u001a\u00020\bH\u0002J\b\u00109\u001a\u00020\"H\u0002J \u0010:\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020%2\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u000208H\u0016J(\u0010=\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020%2\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u0002082\u0006\u0010-\u001a\u00020\u001cH\u0016J\u0018\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bH\u0016J\u000e\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u001cJ\u0006\u0010C\u001a\u00020\u001cJ\u000e\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\bJ\u000e\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020\u001eR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeFeedContainer;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "awemeContainer", "Landroid/view/ViewGroup;", "mScrollThreshold", "mRangeOffset", "mScrollRange", "getMScrollRange", "()I", "mFlingAllY", "mRecyclerConsumedFlingY", "mInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "mEndAnimator", "Landroid/animation/ValueAnimator;", "mFlingAnimator", "mEnable", "", "mListener", "Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeFeedContainer$IScrollListener;", "mNestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onFinishInflate", "", "onStartNestedScroll", "child", "Landroid/view/View;", "target", "axes", "type", "onNestedScrollAccepted", "onNestedPreScroll", "dx", "dy", "consumed", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStopNestedScroll", "getNestedScrollAxes", "flingAnimation", "dampingFactor", "", "end", "onNestedPreFling", "velocityX", "velocityY", "onNestedFling", "scrollTo", "x", "y", "setEnable", "enable", "getEnable", "setScrollRangeOffset", "offset", "setScrollListener", "listener", "Companion", "IScrollListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatAwemeFeedContainer extends LinearLayout implements NestedScrollingParent2 {
    public static final /* synthetic */ int l = 0;
    public RecyclerView a;
    public ViewGroup b;
    public final int c;
    public int d;
    public int e;
    public int f;
    public final DecelerateInterpolator g;
    public ValueAnimator h;
    public ValueAnimator i;
    public boolean j;
    public final NestedScrollingParentHelper k;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public ChatAwemeFeedContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatAwemeFeedContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setScrollListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        if (this.j == true) goto L7;
        return super.getNestedScrollAxes();
    L7:
        return this.k.getNestedScrollAxes();
    }

    private final int getMScrollRange() {
        return getMeasuredHeight() + this.d;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        RecyclerView r0 = getChildAt(0);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.a = r0;
        View r1 = getChildAt(1);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        this.b = (ViewGroup) r1;
    }

    public final boolean getEnable() {
        return this.j;
    }

    public final void setEnable(boolean r1) {
        this.j = r1;
    }

    public final void setScrollRangeOffset(int r1) {
        this.d = r1;
    }

    public final void onStopNestedScroll(View r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "target");
        FLogger.a.i("ChatAwemeFeedContainer", "onStopNestedScroll, type: " + r9);
        this.k.onStopNestedScroll(r8, r9);
        if (r9 == 0) goto L5;
        return;
    L5:
        if (getScrollY() < this.c) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
        int r11 = getMScrollRange();
    L11:
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{getScrollY(), r11});
        r12.setDuration(RangesKt.coerceAtMost(RangesKt.coerceAtLeast((long) ((getScrollY() / getMScrollRange()) * 400), 300), 400));
        r12.setInterpolator(new CubicBezierInterpolator(0.24f, 0.0f, 0.58f));
        r12.addUpdateListener(new g0(this));
        r12.addListener(new h0(r10, this, r12));
        r12.start();
        this.h = r12;
        return;
    L10:
        r11 = 0;
        goto L11
    L7:
        r10 = false;
        goto L8
    }

    @Override // android.view.View
    public final void scrollTo(int r2, int r3) {
        if (this.j == true) goto L5;
        super.scrollTo(r2, r3);
        return;
    L5:
        if (r3 >= 0) goto L7;
        r3 = 0;
    L7:
        super.scrollTo(r2, r3);
    }

    public ChatAwemeFeedContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = c7.b(Integer.valueOf(z2.a.getAwemeVideoFeedConfig().a()));
        this.g = new DecelerateInterpolator();
        this.k = new NestedScrollingParentHelper(this);
        setOrientation(1);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r11, float r12, float r13) {
        Intrinsics.checkNotNullParameter(r11, "target");
        if (this.j == false) goto L5;
        OverScroller r9 = new OverScroller(r11.getContext());
        r9.fling(0, 0, (int) r12, (int) r13, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.e = r9.getFinalY();
        this.f = 0;
        FLogger.a.i("ChatAwemeFeedContainer", "onNestedPreFling, mFlingAllY = " + this.e);
        return false;
    L5:
        return super.onNestedPreFling(r11, r12, r13);
    }

    public /* synthetic */ ChatAwemeFeedContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r2, float r3, float r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "target");
        if (this.j == false) goto L5;
        FLogger.a.i("ChatAwemeFeedContainer", "onNestedFling");
        return false;
    L5:
        return super.onNestedFling(r2, r3, r4, r5);
    }

    public final void onNestedScrollAccepted(View r4, View r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "target");
        FLogger.a.i("ChatAwemeFeedContainer", "onNestedScrollAccepted, type: " + r7);
        this.k.onNestedScrollAccepted(r4, r5, r6, r7);
        ValueAnimator r8 = this.h;
        if (r8 == null) goto L5;
        r8.cancel();
    L5:
        ValueAnimator r9 = this.i;
        if (r9 == null) goto L9;
        r9.cancel();
        return;
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
        if (this.j == true) goto L5;
    L7:
        return false;
    L5:
        if (r3 != 2) goto L7;
        return true;
    }

    public final void onNestedPreScroll(View r3, int r4, int r5, int[] r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r6, "consumed");
        if (r7 != 0) goto L9;
        if (r5 < 0) goto L6;
        return;
    L6:
        if (getScrollY() <= 0) goto L11;
        scrollBy(0, (int) (r5 * RangesKt.coerceAtLeast(1 - this.g.getInterpolation(getScrollY() / getMScrollRange()), 0.4f)));
        r6[1] = r5;
        return;
    L11:
        return;
    }

    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r7, "target");
        if (r12 != 0) goto L7;
        if (r11 <= 0) goto L38;
        requestDisallowInterceptTouchEvent(true);
        scrollBy(0, (int) (r11 * RangesKt.coerceAtLeast(1 - this.g.getInterpolation(getScrollY() / getMScrollRange()), 0.4f)));
        return;
    L38:
        return;
    L7:
        if (r9 <= 0) goto L14;
        int r0 = this.f + r9;
        this.f = r0;
        if (r11 <= 0) goto L14;
        int r13 = this.e - r0;
        FLogger.a.i("ChatAwemeFeedContainer", "do fling animation, allUnConsumedY = " + r13);
        if (r13 > 0) goto L13;
        return;
    L13:
        int r14 = r13 / 6;
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{0, r14, 0});
        r15.setDuration(RangesKt.coerceAtMost(RangesKt.coerceAtLeast((long) ((r14 / getMScrollRange()) * 700), 500), 700));
        r15.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 0.58f));
        r15.addUpdateListener(new f0(this));
        r15.start();
        this.i = r15;
    L14:
        RecyclerView r16 = null;
        if (r11 <= 0) goto L21;
        ViewGroup r1 = this.a;
        if (r1 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r1 = null;
    L20:
        if (r1.canScrollVertically(1) == true) goto L21;
    L27:
        RecyclerView r17 = this.a;
        if (r17 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r17 = null;
    L31:
        if (r17.getScrollState() != 2) goto L42;
        FLogger.a.w("ChatAwemeFeedContainer", "force make RecyclerView stop scroll");
        RecyclerView r18 = this.a;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L36:
        r16.stopScroll();
        return;
    L35:
        r16 = r18;
        goto L36
    L42:
        return;
    L21:
        if (r11 >= 0) goto L40;
        ViewGroup r19 = this.a;
        if (r19 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r19 = null;
    L26:
        if (r19.canScrollVertically(-1) == false) goto L27;
        return;
    }
}

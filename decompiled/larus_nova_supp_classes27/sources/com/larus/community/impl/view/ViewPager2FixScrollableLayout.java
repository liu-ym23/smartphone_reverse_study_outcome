package com.larus.community.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r29.m;
import r29.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0002J\"\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0013H\u0002J\"\u0010)\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001cH\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020+H\u0002R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b\u001e\u0010\u001f¨\u00062"}, d2 = {"Lcom/larus/community/impl/view/ViewPager2FixScrollableLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ignoreCheckScrollViews", "", "Landroid/view/View;", "getIgnoreCheckScrollViews", "()Ljava/util/List;", "setIgnoreCheckScrollViews", "(Ljava/util/List;)V", "touchSlop", "", "pagingTouchSlop", "initialX", "", "initialY", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager$delegate", "Lkotlin/Lazy;", "viewPagerEnableScroll", "", "child", "getChild", "()Landroid/view/View;", "child$delegate", "existChildCanScroll", "v", "orientation", "delta", "x", "y", "canScroll", "view", "isTouchPointInView", "requestDisallowInterceptTouchEvent", "", "disallowIntercept", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "reset", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewPager2FixScrollableLayout extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public List<? extends View> a;
    public final int b;
    public final int c;
    public float d;
    public float e;
    public final Lazy f;
    public boolean g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    private final View getChild() {
        return (View) this.h.getValue();
    }

    private final ViewPager2 getParentViewPager() {
        return (ViewPager2) this.f.getValue();
    }

    public final List<View> getIgnoreCheckScrollViews() {
        return this.a;
    }

    public ViewPager2FixScrollableLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r15) {
        Intrinsics.checkNotNullParameter(r15, "e");
        FLogger r0 = FLogger.a;
        r0.d("BF_VP2FixScrollable", "onInterceptTouchEvent: " + r15.getAction());
        ViewPager2 r1 = getParentViewPager();
        if (r1 == null) goto L64;
        int r6 = r1.getOrientation();
        int r2 = r15.getAction() & r15.getActionMasked();
        if (r2 != 1) goto L7;
    L58:
        r0.d("BF_VP2FixScrollable", "action up or cancel, reset");
        this.g = false;
        ViewPager2 r16 = getParentViewPager();
        if (r16 == null) goto L61;
        r16.setUserInputEnabled(true);
    L61:
        ViewParent r17 = getParent();
        if (r17 == null) goto L64;
        r17.requestDisallowInterceptTouchEvent(false);
        goto L64
    L7:
        if (r2 == 3) goto L58;
        if (r2 != 0) goto L10;
    L13:
        int r8 = (int) r15.getRawX();
        int r9 = (int) r15.getRawY();
        if (r15.getAction() != 0) goto L21;
        this.d = r15.getX();
        this.e = r15.getY();
        this.g = false;
        ViewParent r18 = getParent();
        if (r18 == null) goto L18;
        r18.requestDisallowInterceptTouchEvent(true);
    L18:
        r0.d("BF_VP2FixScrollable", "Forbid the parent to intercept the move event");
        return false;
    L21:
        if (r15.getAction() != 2) goto L57;
        if (r6 != 0) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L27;
        float r4 = r15.getX();
        float r5 = this.d;
    L28:
        float r7 = r4 - r5;
        if (r3 == false) goto L31;
        float r10 = r15.getY();
        float r11 = this.e;
    L32:
        float r12 = Math.abs(r7);
        float r13 = Math.abs(r10 - r11);
        if (r13 <= this.b) goto L44;
        if (r13 <= (((double) r12) * 0.5d)) goto L57;
        r0.d("BF_VP2FixScrollable", "The sliding angle is not enough, disable this ViewPager, then it will be handled by parent ViewPager");
        ViewPager2 r110 = getParentViewPager();
        if (r110 == null) goto L39;
        r110.setUserInputEnabled(false);
    L39:
        ViewParent r111 = getParent();
        if (r111 == null) goto L42;
        r111.requestDisallowInterceptTouchEvent(false);
    L42:
        return false;
    L44:
        if (r12 <= this.c) goto L57;
        if (a(getChild(), r6, r7, r8, r9) == true) goto L57;
        if ((((double) r12) * 0.5d) <= r13) goto L57;
        r0.d("BF_VP2FixScrollable", "If the sliding distance exceeds the sliding threshold of ViewPager, and the child cannot slide in the sliding direction, then it will be handled by this ViewPager");
        this.g = true;
        ViewPager2 r112 = getParentViewPager();
        if (r112 == null) goto L52;
        r112.setUserInputEnabled(true);
    L52:
        ViewParent r113 = getParent();
        if (r113 == null) goto L55;
        r113.requestDisallowInterceptTouchEvent(false);
    L55:
        return true;
    L31:
        r10 = r15.getX();
        r11 = this.d;
        goto L32
    L27:
        r4 = r15.getY();
        r5 = this.e;
        goto L28
    L24:
        r3 = false;
    L57:
        return super.onInterceptTouchEvent(r15);
    L10:
        if (this.g == false) goto L13;
        r0.d("BF_VP2FixScrollable", "viewPagerEnableScroll is true, fast return");
        return true;
    L64:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r2) {
        if (r2 == true) goto L8;
        super.requestDisallowInterceptTouchEvent(false);
        ViewParent r3 = getParent();
        if (r3 == null) goto L10;
        r3.requestDisallowInterceptTouchEvent(true);
        return;
    L10:
        return;
    L8:
        super.requestDisallowInterceptTouchEvent(true);
    }

    public final void setIgnoreCheckScrollViews(List<? extends View> r1) {
        this.a = r1;
    }

    public ViewPager2FixScrollableLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.c = ViewConfiguration.get(r2).getScaledPagingTouchSlop();
        this.f = LazyKt.lazy(new m(this));
        this.h = LazyKt.lazy(new n(this));
    }

    public final boolean a(View r11, int r12, float r13, int r14, int r15) {
        if (r11 != null) goto L5;
        return false;
    L5:
        int[] r1 = new int[2];
        r11.getLocationOnScreen(r1);
        int r2 = r1[0];
        int r3 = r1[1];
        int r4 = r11.getMeasuredWidth() + r2;
        int r5 = r11.getMeasuredHeight() + r3;
        if (r3 > r15) goto L9;
        if (r15 > r5) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L17;
        if (r2 > r14) goto L14;
        if (r14 > r4) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == true) goto L20;
        return false;
    L20:
        int r9 = -((int) Math.signum(r13));
        if (r12 == 0) goto L26;
        if (r12 != 1) goto L25;
        boolean r10 = r11.canScrollVertically(r9);
    L27:
        if (r10 == false) goto L37;
        List<? extends View> r16 = this.a;
        if (r16 != null) goto L31;
    L33:
        boolean r17 = false;
    L34:
        if (r17 == true) goto L37;
        return true;
    L31:
        if (r16.contains(r11) != true) goto L33;
        r17 = true;
    L37:
        if ((r11 instanceof ViewGroup) == false) goto L45;
        ViewGroup r18 = (ViewGroup) r11;
        int r20 = r18.getChildCount() - 1;
    L40:
        if ((-1) >= r20) goto L45;
        if (a(r18.getChildAt(r20), r12, r13, r14, r15) == true) goto L43;
        r20 = r20 - 1;
        goto L40
    L43:
        return true;
    L45:
        return false;
    L25:
        throw new IllegalArgumentException("orientation is not found");
    L26:
        r10 = r11.canScrollHorizontally(r9);
    L14:
        r7 = false;
    L17:
        r8 = false;
    L9:
        r6 = false;
        goto L10
    }
}

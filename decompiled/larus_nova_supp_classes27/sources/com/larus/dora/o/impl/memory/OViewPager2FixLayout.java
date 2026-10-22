package com.larus.dora.o.impl.memory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/o/impl/memory/OViewPager2FixLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "pagingTouchSlop", "initialX", "", "initialY", "viewPagerEnableScroll", "", "childClaimed", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "requestDisallowInterceptTouchEvent", "", "disallowIntercept", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "e", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OViewPager2FixLayout extends FrameLayout {
    public final int a;
    public final int b;
    public float c;
    public float d;
    public boolean e;
    public boolean f;

    public OViewPager2FixLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OViewPager2FixLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final ViewPager2 getParentViewPager() {
        ViewPager2 r0 = getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 == null) goto L13;
        if ((r1 instanceof ViewPager2) == true) goto L13;
        ViewPager2 r2 = r1.getParent();
        if ((r2 instanceof View) == false) goto L5;
        r1 = (View) r2;
        goto L6
    L5:
        r1 = null;
    L13:
        if ((r1 instanceof ViewPager2) == true) goto L15;
        return null;
    L15:
        return (ViewPager2) r1;
    L16:
        r1 = null;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        ViewPager2 r0 = getParentViewPager();
        if (r0 == null) goto L43;
        int r1 = r7.getActionMasked();
        if (r1 == 0) goto L39;
        if (r1 != 1) goto L9;
    L38:
        this.e = false;
        this.f = false;
        goto L43
    L9:
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L38;
    L14:
        if (this.e == true) goto L43;
        float r2 = Math.abs(r7.getX() - this.c);
        float r4 = Math.abs(r7.getY() - this.d);
        if (r0.getOrientation() != 0) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L22;
        float r5 = r2;
    L23:
        if (r3 == false) goto L26;
        r2 = r4;
    L26:
        if (r2 >= this.a) goto L43;
        if (this.f == true) goto L43;
        if (r5 <= this.b) goto L43;
        if ((r5 * 0.5f) <= r2) goto L43;
        this.e = true;
        ViewParent r6 = getParent();
        if (r6 == null) goto L43;
        r6.requestDisallowInterceptTouchEvent(false);
        goto L43
    L22:
        r5 = r4;
        goto L23
    L19:
        r3 = false;
        goto L20
    L39:
        this.c = r7.getX();
        this.d = r7.getY();
        this.e = false;
        this.f = false;
        ViewParent r8 = getParent();
        if (r8 == null) goto L43;
        r8.requestDisallowInterceptTouchEvent(true);
    L43:
        return super.onInterceptTouchEvent(r7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r2) {
        if (r2 == false) goto L4;
        this.f = true;
    L4:
        super.requestDisallowInterceptTouchEvent(r2);
    }

    public OViewPager2FixLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.b = ViewConfiguration.get(r2).getScaledPagingTouchSlop();
    }

    public /* synthetic */ OViewPager2FixLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

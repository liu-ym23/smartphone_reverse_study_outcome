package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0010H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/RecyclerViewContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchSlop", "", "hoverTapSlop", "initialX", "", "initialY", "parentInterceptTouchEvent", "", "needParentInterceptNow", "childIntercept", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "forceParentInterceptTouchEvent", "", "force", "canChildScroll", "orientation", "delta", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "requestDisallowInterceptTouchEvent", "disallowIntercept", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecyclerViewContainer extends FrameLayout {
    public final int a;
    public final int b;
    public float c;
    public float d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    private final View getChild() {
        if (getChildCount() > 0) goto L7;
        return null;
    L7:
        return getChildAt(0);
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

    public RecyclerViewContainer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        int r3 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.a = r3;
        this.b = r3 / 2;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "e");
        ViewPager2 r0 = getParentViewPager();
        if (r0 == null) goto L53;
        int r1 = r0.getOrientation();
        int r2 = r13.getAction();
        if (r2 != 0) goto L7;
        this.c = r13.getX();
        this.d = r13.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L53
    L7:
        if (r2 != 1) goto L9;
    L50:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L53
    L9:
        if (r2 != 2) goto L11;
        float r3 = r13.getX() - this.c;
        float r5 = r13.getY() - this.d;
        if (r1 != 0) goto L16;
        boolean r6 = true;
    L17:
        float r7 = Math.abs(r3);
        float r8 = 1.0f;
        if (r6 == false) goto L20;
        float r10 = 0.5f;
    L21:
        float r9 = r7 * r10;
        float r11 = Math.abs(r5);
        if (r6 == true) goto L25;
        r8 = 0.5f;
    L25:
        float r12 = r11 * r8;
        FLogger r14 = FLogger.a;
        r14.d("NestedScrollableContainer", "requestDisallowInterceptTouchEvent scaledDx=" + r9 + ", scaledDy=" + r12 + ", touchSlop=" + this.a + ", hoverTapSlop=" + this.b);
        if (r12 <= (r9 * 2)) goto L28;
        boolean r4 = true;
    L29:
        if (r6 != r4) goto L31;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L53
    L31:
        if (r6 == true) goto L34;
        r3 = r5;
    L34:
        int r15 = -((int) Math.signum(r3));
        if (r1 == 0) goto L41;
        if (r1 != 1) goto L44;
        View r16 = getChild();
        if (r16 == null) goto L44;
        boolean r17 = r16.canScrollVertically(r15);
    L45:
        if (r17 == false) goto L48;
        r14.i("NestedScrollableContainer", "requestDisallowInterceptTouchEvent true");
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L53
    L48:
        if (this.e == true) goto L53;
        getParent().requestDisallowInterceptTouchEvent(false);
    L44:
        r17 = false;
        goto L45
    L41:
        View r18 = getChild();
        if (r18 == null) goto L44;
        r17 = r18.canScrollHorizontally(r15);
        goto L45
    L28:
        r4 = false;
        goto L29
    L20:
        r10 = 1.0f;
        goto L21
    L16:
        r6 = false;
        goto L17
    L11:
        if (r2 == 3) goto L50;
    L53:
        return super.onInterceptTouchEvent(r13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
        this.e = r1;
    }

    public RecyclerViewContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        int r4 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.a = r4;
        this.b = r4 / 2;
    }
}

package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/larus/common_ui/view/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchSlop", "", "initialX", "", "initialY", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "canChildScroll", "", "orientation", "delta", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NestedScrollableHost extends FrameLayout {
    public final int a;
    public float b;
    public float c;

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

    public NestedScrollableHost(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "e");
        ViewPager2 r0 = getParentViewPager();
        if (r0 == null) goto L44;
        int r1 = r0.getOrientation();
        float r2 = 1.0f;
        if (a(r1, -1.0f) == true) goto L10;
        if (a(r1, 1.0f) == false) goto L44;
    L10:
        if (r11.getAction() != 0) goto L13;
        this.b = r11.getX();
        this.c = r11.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L44
    L13:
        if (r11.getAction() != 2) goto L44;
        float r3 = r11.getX() - this.b;
        float r4 = r11.getY() - this.c;
        if (r1 != 0) goto L17;
        boolean r6 = true;
    L18:
        float r7 = Math.abs(r3);
        if (r6 == false) goto L21;
        float r9 = 0.5f;
    L22:
        float r8 = r7 * r9;
        float r10 = Math.abs(r4);
        if (r6 == true) goto L26;
        r2 = 0.5f;
    L26:
        float r12 = r10 * r2;
        float r5 = this.a;
        if (r8 > r5) goto L31;
        if (r12 <= r5) goto L44;
    L31:
        if (r12 <= r8) goto L33;
        boolean r13 = true;
    L34:
        if (r6 != r13) goto L36;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L44
    L36:
        if (r6 == true) goto L40;
        r3 = r4;
    L40:
        if (a(r1, r3) == false) goto L42;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L44
    L42:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L44
    L33:
        r13 = false;
        goto L34
    L21:
        r9 = 1.0f;
        goto L22
    L17:
        r6 = false;
    L44:
        return super.onInterceptTouchEvent(r11);
    }

    public NestedScrollableHost(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public boolean a(int r3, float r4) {
        int r5 = -((int) Math.signum(r4));
        if (r3 != 0) goto L5;
        View r6 = getChild();
        if (r6 != null) goto L13;
        return false;
    L13:
        return r6.canScrollHorizontally(r5);
    L5:
        if (r3 == 1) goto L7;
        FLogger.a.e("NestedScrollableHost", "orientation param illegal");
        return false;
    L7:
        View r7 = getChild();
        if (r7 != null) goto L16;
        return false;
    L16:
        return r7.canScrollVertically(r5);
    }
}

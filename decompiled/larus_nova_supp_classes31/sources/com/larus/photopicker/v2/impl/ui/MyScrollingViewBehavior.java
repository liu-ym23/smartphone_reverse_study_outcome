package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J8\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\rH\u0016J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J \u0010\u001c\u001a\u0004\u0018\u00010\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MyScrollingViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tempRect", "Landroid/graphics/Rect;", "tempRect2", "appbarHeight", "", "layoutDependsOn", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "dependency", "onMeasureChild", "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "onLayoutChild", "layoutDirection", "onDependentViewChanged", "findDependency", "dependencies", "", "id", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MyScrollingViewBehavior extends CoordinatorLayout.Behavior<View> {
    public final Rect a;
    public final Rect b;
    public int c;

    public MyScrollingViewBehavior(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new Rect();
        this.b = new Rect();
    }

    public static View a(List r2, int r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        View r0 = (View) r4.next();
        if (r0.getId() != r3) goto L4;
        return r0;
    L8:
        return null;
    }

    public final boolean layoutDependsOn(CoordinatorLayout r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        if (r4.getId() != 2131388843) goto L5;
    L8:
        return true;
    L5:
        if (r4.getId() == 2131363085) goto L8;
        return false;
    }

    public final boolean onDependentViewChanged(CoordinatorLayout r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        if ((r4 instanceof AppBarLayout) == false) goto L7;
        this.c = ((AppBarLayout) r4).getHeight();
        return false;
    L7:
        return false;
    }

    public final boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        View r0 = a(r10.getDependencies(r11), 2131388843);
        int r1 = 0;
        if (r0 == null) goto L13;
        CoordinatorLayout.LayoutParams r2 = r11.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r3 = r2;
        Rect r6 = this.a;
        if (r0.getBottom() != 0) goto L10;
        View r4 = a(r10.getDependencies(r11), 2131363085);
        if (r4 == null) goto L9;
        r1 = r4.getBottom();
    L9:
        int r5 = ((ViewGroup.MarginLayoutParams) r3).topMargin;
    L11:
        int r7 = r1 + r5;
        r6.set(r10.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r3).leftMargin, r7, (r10.getWidth() - r10.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r3).rightMargin, ((r10.getHeight() + r0.getBottom()) - r10.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r3).bottomMargin);
        Rect r13 = this.b;
        GravityCompat.apply(8388659, r11.getMeasuredWidth(), r11.getMeasuredHeight(), r6, r13, r12);
        r11.layout(r13.left, r13.top, r13.right, r13.bottom);
        return true;
    L10:
        r1 = r0.getBottom();
        r5 = ((ViewGroup.MarginLayoutParams) r3).topMargin;
        goto L11
    L13:
        return false;
    }

    public final boolean onMeasureChild(CoordinatorLayout r8, View r9, int r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "child");
        View r0 = a(r8.getDependencies(r9), 2131388843);
        if (r0 == null) goto L13;
        int r14 = View.MeasureSpec.getSize(r12);
        if (r14 != 0) goto L7;
        r14 = r8.getHeight();
    L7:
        int r15 = (r14 - r0.getMeasuredHeight()) - this.c;
        if (r9.getLayoutParams().height != (-1)) goto L10;
        int r1 = 1073741824;
    L11:
        r8.onMeasureChild(r9, r10, r11, View.MeasureSpec.makeMeasureSpec(r15, r1), r13);
        return true;
    L10:
        r1 = Integer.MIN_VALUE;
        goto L11
    L13:
        return false;
    }
}

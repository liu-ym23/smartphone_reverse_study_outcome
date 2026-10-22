package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wp9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0011J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MyTitleViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "expanded", "", "tempRect", "Landroid/graphics/Rect;", "tempRect2", "viewOffsetHelper", "Lcom/larus/photopicker/v2/impl/utils/ViewOffsetHelper;", "tempTopBottomOffset", "", "tempLeftRightOffset", "setTopAndBottomOffset", "offset", "layoutDependsOn", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "dependency", "onLayoutChild", "layoutDirection", "findFirstDependency", "dependencies", "", "setExpanded", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MyTitleViewBehavior extends CoordinatorLayout.Behavior<View> {
    public boolean a;
    public final Rect b;
    public final Rect c;
    public h d;
    public int e;

    public MyTitleViewBehavior(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = true;
        this.b = new Rect();
        this.c = new Rect();
    }

    public final boolean layoutDependsOn(CoordinatorLayout r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        return r4 instanceof AppBarLayout;
    }

    public final boolean onLayoutChild(CoordinatorLayout r9, View r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r10, "child");
        r9.onLayoutChild(r10, r11);
        Iterator r0 = r9.getDependencies(r10).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        View r1 = (View) r0.next();
        if ((r1 instanceof AppBarLayout) == false) goto L4;
    L9:
        if (r1 == null) goto L12;
        CoordinatorLayout.LayoutParams r2 = r10.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r3 = r2;
        Rect r5 = this.b;
        r5.set(r9.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r3).leftMargin, r1.getBottom() + ((ViewGroup.MarginLayoutParams) r3).topMargin, (r9.getWidth() - r9.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r3).rightMargin, ((r9.getHeight() + r1.getBottom()) - r9.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r3).bottomMargin);
        Rect r12 = this.c;
        GravityCompat.apply(8388659, r10.getMeasuredWidth(), r10.getMeasuredHeight(), r5, r12, r11);
        r10.layout(r12.left, r12.top, r12.right, r12.bottom);
    L12:
        if (this.d != null) goto L14;
        this.d = new h(r10);
    L14:
        h r13 = this.d;
        if (r13 == null) goto L17;
        r13.b = r13.a.getTop();
        r13.c = r13.a.getLeft();
        r13.a();
    L17:
        int r14 = this.e;
        if (r14 == 0) goto L26;
        h r4 = this.d;
        if (r4 != null) goto L22;
    L24:
        this.e = 0;
        goto L26
    L22:
        if (r4.d == r14) goto L24;
        r4.d = r14;
        r4.a();
    L26:
        if (this.a == true) goto L34;
        int r15 = -r10.getMeasuredHeight();
        h r6 = this.d;
        if (r6 == null) goto L32;
        Intrinsics.checkNotNull(r6);
        if (r6.d == r15) goto L33;
        r6.d = r15;
        r6.a();
    L33:
        this.a = true;
        goto L34
    L32:
        this.e = r15;
    L34:
        h r16 = this.d;
        if (r16 == null) goto L37;
        int r17 = r16.d;
    L38:
        int r18 = MathUtils.clamp(r17, -r10.getMeasuredHeight(), 0);
        h r19 = this.d;
        if (r19 == null) goto L43;
        Intrinsics.checkNotNull(r19);
        if (r19.d == r18) goto L44;
        r19.d = r18;
        r19.a();
    L44:
        return true;
    L43:
        this.e = r18;
        goto L44
    L37:
        r17 = 0;
        goto L38
    L8:
        r1 = null;
        goto L9
    }
}

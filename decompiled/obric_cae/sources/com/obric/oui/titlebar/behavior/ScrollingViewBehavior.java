package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.oui.titlebar.OUnitedTitleBar;
import he.i;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k0.f;
import nb.a;
import t2.b;

/* JADX INFO: loaded from: classes2.dex */
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
    public ScrollingViewBehavior() {
    }

    public ScrollingViewBehavior(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10);
        TypedArray r11 = r8.obtainStyledAttributes(r10, a.f9512z);
        i.e(r11, "context.obtainStyledAttr…llingViewBehavior_Layout)");
        this.f6683f = r11.getDimensionPixelSize(0, 0);
        r11.recycle();
    }

    public static OUnitedTitleBar F(ArrayList r8) {
        i.f(r8, "views");
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        View r12 = (View) r8.get(r11);
        if ((r12 instanceof OUnitedTitleBar) == true) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return (OUnitedTitleBar) r12;
    L9:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final /* bridge */ /* synthetic */ View C(ArrayList r8) {
        return F(r8);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final float D(View r8) {
        i.f(r8, CloudServiceConstants.OCloud.HEADER);
        if ((r8 instanceof OUnitedTitleBar) == false) goto L20;
        OUnitedTitleBar r10 = (OUnitedTitleBar) r8;
        int r11 = r10.getTotalScrollRange();
        int r12 = r10.getDownNestedPreScrollRange();
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 == null) goto L19;
        CoordinatorLayout.c r14 = ((CoordinatorLayout.f) r13).f1563a;
        if ((r14 instanceof OUnitedTitleBar.Behavior) == false) goto L9;
        int r15 = ((OUnitedTitleBar.Behavior) r14).y();
    L10:
        if (r12 != 0) goto L12;
    L14:
        int r16 = r11 - r12;
        if (r16 == 0) goto L20;
        return (r15 / r16) + 1.0f;
    L12:
        if ((r11 + r15) > r12) goto L14;
        return 0.0f;
    L9:
        r15 = 0;
        goto L10
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L20:
        return 0.0f;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final int E(View r8) {
        if ((r8 instanceof OUnitedTitleBar) == false) goto L6;
        return ((OUnitedTitleBar) r8).getTotalScrollRange();
    L6:
        return r8.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean b(CoordinatorLayout r8, View r10, View r11) {
        i.f(r8, "parent");
        return r11 instanceof OUnitedTitleBar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean d(CoordinatorLayout r8, View r10, View r11) {
        i.f(r8, "parent");
        i.f(r11, "dependency");
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L14;
        CoordinatorLayout.c r13 = ((CoordinatorLayout.f) r12).f1563a;
        if ((r13 instanceof BaseBehavior) == false) goto L11;
        int r14 = ((r11.getBottom() - r10.getTop()) + ((BaseBehavior) r13).f6657j) + this.f6682e;
        if (this.f6683f != 0) goto L9;
        int r15 = 0;
    L10:
        int r16 = r14 - r15;
        WeakHashMap<View, h0> r17 = w.f8437a;
        r10.offsetTopAndBottom(r16);
        goto L11
    L9:
        float r18 = D(r11);
        int r19 = this.f6683f;
        r15 = b.p((int) (r18 * r19), 0, r19);
    L11:
        boolean r20 = r11 instanceof OUnitedTitleBar;
        return false;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void e(CoordinatorLayout r8, View r10, View r11) {
        i.f(r8, "parent");
        if ((r11 instanceof OUnitedTitleBar) == false) goto L6;
        f.a r12 = f.a.f8894f;
        i.e(r12, "AccessibilityNodeInfoCom…pat.ACTION_SCROLL_FORWARD");
        w.k(r8, r12.a());
        w.i(r8, 0);
        f.a r13 = f.a.f8895g;
        i.e(r13, "AccessibilityNodeInfoCom…at.ACTION_SCROLL_BACKWARD");
        w.k(r8, r13.a());
        w.i(r8, 0);
        w.m(r8, null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean q(CoordinatorLayout r8, View r10, Rect r11, boolean r12) {
        i.f(r8, "parent");
        i.f(r10, "child");
        i.f(r11, "rectangle");
        ArrayList r13 = r8.e(r10);
        i.e(r13, "parent.getDependencies(child)");
        OUnitedTitleBar r14 = F(r13);
        if (r14 == null) goto L8;
        Rect r15 = new Rect(r11);
        r15.offset(r10.getLeft(), r10.getTop());
        int r16 = r8.getWidth();
        int r17 = r8.getHeight();
        Rect r18 = this.f6680c;
        r18.set(0, 0, r16, r17);
        if (r18.contains(r15) == true) goto L8;
        r14.setExpanded(false);
        return true;
    L8:
        return false;
    }
}

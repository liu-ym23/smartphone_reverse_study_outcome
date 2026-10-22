package com.bytedance.ai.applet.login;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final CoordinatorLayout a;
    public ViewGroup b;
    public ViewGroup c;
    public com.bytedance.ai.widget.contianer.h d;
    public l2.a e;
    public Activity f;
    public Function0<Unit> g;

    public static final class a {
    }

    static {
    }

    public final void c() {
        com.bytedance.ai.utils.g.a.d("DrawerWidgetContainer", "closeDrawer");
        CoordinatorLayout.LayoutParams r0 = this.a.getChildAt(1).getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r1 = r0.getBehavior();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        ((BottomSheetBehavior) r1).b(4, true);
    }

    public final void f() {
        com.bytedance.ai.widget.contianer.h r0 = this.d;
        if (r0 == null) goto L7;
        l2.a r1 = this.e;
        if (r1 == null) goto L7;
        r1.c(r0);
    L7:
        this.e = null;
        this.d = null;
        ViewGroup r10 = this.c;
        if (r10 == null) goto L11;
        r10.removeAllViews();
        return;
    }

    public final void e() {
        c();
        f();
        ViewParent r0 = this.a.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        r1.removeView(this.a);
    L8:
        this.f = null;
        this.g = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public f(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        CoordinatorLayout r0 = new CoordinatorLayout(r10);
        FrameLayout r1 = new FrameLayout(r10);
        this.b = r1;
        r1.setBackgroundColor(ColorProtector.parseColor("#26000000"));
        ViewGroup r11 = this.b;
        if (r11 == null) goto L5;
        r11.setOnClickListener(new e(this));
    L5:
        r0.addView(this.b, new CoordinatorLayout.LayoutParams(-1, -1));
        FrameLayout r12 = new FrameLayout(r10);
        this.c = r12;
        r12.setId(View.generateViewId());
        ViewGroup r13 = this.c;
        if (r13 == null) goto L8;
        r13.setBackgroundResource(2131244042);
    L8:
        CoordinatorLayout.LayoutParams r14 = new CoordinatorLayout.LayoutParams(-1, -2);
        r14.setBehavior(new BottomSheetBehavior());
        r0.addView(this.c, r14);
        CoordinatorLayout.Behavior r15 = r14.getBehavior();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        BottomSheetBehavior r16 = (BottomSheetBehavior) r15;
        r16.getClass();
        g r17 = new g(this);
        if (r16.M.contains(r17) == true) goto L11;
        r16.M.add(r17);
    L11:
        this.a = r0;
    }

    public final void b(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        ViewParent r0 = this.a.getParent();     // Catch: Exception -> L18
        ViewGroup r11 = null;
        if ((r0 instanceof ViewGroup) == false) goto L6;
        ViewGroup r1 = (ViewGroup) r0;     // Catch: Exception -> L18
    L7:
        View r12 = r10.findViewById(R.id.content);     // Catch: Exception -> L18
        if ((r12 instanceof ViewGroup) == false) goto L11;
        r11 = (ViewGroup) r12;     // Catch: Exception -> L18
    L11:
        if (Intrinsics.areEqual(r1, r11) == true) goto L16;
        if (r1 == null) goto L14;
        r1.removeView(this.a);     // Catch: Exception -> L18
    L14:
        if (r11 == null) goto L16;
        r11.addView(this.a, -1, -1);     // Catch: Exception -> L18
    L16:
        this.f = r10;     // Catch: Exception -> L18
        return;
    L6:
        r1 = null;
    L18:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("DrawerWidgetContainer", "attachDrawer: failed", e);
    }

    public final void d(Function0<Unit> r10) {
        com.bytedance.ai.utils.g.a.d("DrawerWidgetContainer", "openDrawer");
        this.g = r10;
        CoordinatorLayout.LayoutParams r11 = this.a.getChildAt(1).getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r12 = r11.getBehavior();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        ((BottomSheetBehavior) r12).b(3, true);
    }

    public final void a(l2.a r10, com.bytedance.ai.widget.contianer.h r11) {
        View r0 = r11.realView();
        if (r0 != null) goto L7;
        com.bytedance.ai.utils.g.a.e("DrawerWidgetContainer", "addWidgetContainer: realView is null");
        return;
    L7:
        if (r0.getParent() == null) goto L9;
        com.bytedance.ai.utils.g.a.d("DrawerWidgetContainer", "addWidgetContainer: removing from parent first");
        ViewParent r1 = r0.getParent();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r1).removeView(r0);
    L9:
        this.e = r10;
        this.d = r11;
        ViewGroup r12 = this.c;
        if (r12 == null) goto L13;
        r12.addView(r0, -1, -2);
        return;
    }
}

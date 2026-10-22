package com.bytedance.ai.applet.login;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.obric.launcher.widget.R$drawable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoordinatorLayout f1736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f1737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f1738c;
    public Activity d;

    public c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        CoordinatorLayout r10 = new CoordinatorLayout(r5);
        FrameLayout r11 = new FrameLayout(r5);
        this.f1737b = r11;
        r11.setBackgroundColor(Color.parseColor("#26000000"));
        FrameLayout r12 = this.f1737b;
        if (r12 == null) goto L5;
        r12.setOnClickListener(new ar.a(this, 5));
    L5:
        r10.addView(this.f1737b, new CoordinatorLayout.LayoutParams(-1, -1));
        FrameLayout r13 = new FrameLayout(r5);
        this.f1738c = r13;
        r13.setId(View.generateViewId());
        FrameLayout r14 = this.f1738c;
        if (r14 == null) goto L8;
        r14.setBackgroundResource(R$drawable.normal_drawer_background);
    L8:
        CoordinatorLayout.LayoutParams r15 = new CoordinatorLayout.LayoutParams(-1, -2);
        r15.setBehavior(new BottomSheetBehavior());
        r10.addView(this.f1738c, r15);
        CoordinatorLayout.Behavior r16 = r15.getBehavior();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        BottomSheetBehavior r17 = (BottomSheetBehavior) r16;
        r17.getClass();
        b r18 = new b();
        ArrayList r19 = r17.f2886h;
        if (r19.contains(r18) == true) goto L11;
        r19.add(r18);
    L11:
        this.f1736a = r10;
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("DrawerWidgetContainer", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.d("DrawerWidgetContainer", "closeDrawer");
    L5:
        ViewGroup.LayoutParams r10 = this.f1736a.getChildAt(1).getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r11 = ((CoordinatorLayout.LayoutParams) r10).getBehavior();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        ((BottomSheetBehavior) r11).c(4);
    }

    public final void b(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        CoordinatorLayout r5 = this.f1736a;
        ViewParent r11 = r5.getParent();     // Catch: Exception -> L6
        ViewGroup r12 = null;
        if ((r11 instanceof ViewGroup) == false) goto L8;
        ViewGroup r13 = (ViewGroup) r11;     // Catch: Exception -> L6
    L9:
        View r14 = r10.findViewById(R.id.content);     // Catch: Exception -> L6
        if ((r14 instanceof ViewGroup) == false) goto L13;
        r12 = (ViewGroup) r14;     // Catch: Exception -> L6
    L13:
        if (Intrinsics.areEqual(r13, r12) == true) goto L18;
        if (r13 == null) goto L16;
        r13.removeView(r5);     // Catch: Exception -> L6
    L16:
        if (r12 == null) goto L18;
        r12.addView(r5, -1, -1);     // Catch: Exception -> L6
    L18:
        this.d = r10;     // Catch: Exception -> L6
        return;
    L8:
        r13 = null;
    L6:
        e = move-exception;
        Intrinsics.checkNotNullParameter("DrawerWidgetContainer", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L26;
        r15.e("DrawerWidgetContainer", "attachDrawer: failed", e);
        return;
    }

    public final void c() {
        Intrinsics.checkNotNullParameter("DrawerWidgetContainer", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.d("DrawerWidgetContainer", "openDrawer");
    L5:
        ViewGroup.LayoutParams r10 = this.f1736a.getChildAt(1).getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r11 = ((CoordinatorLayout.LayoutParams) r10).getBehavior();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        ((BottomSheetBehavior) r11).c(3);
    }
}

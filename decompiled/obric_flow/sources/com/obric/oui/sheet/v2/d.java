package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R$id;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.MaterialToken;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static void a(e r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "this");
        if (r5.getEnableMaterial() == false) goto L9;
        r5.getRootContainer().getContext();
        com.obric.oui.material.c[] r11 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!r5.b()));
        r5.getRootContainer().setBackgroundColor(0);
        if (r10 == false) goto L7;
        a.a.A(r5.getRootContainer(), r11);
        return;
    L7:
        a.a.y(r5.getRootContainer(), r11, false, 0, 14);
        return;
    }

    public static void b(e r5) {
        Intrinsics.checkNotNullParameter(r5, "this");
        if ((r5.getRootContainer().getBackground() instanceof ColorDrawable) == false) goto L10;
        Drawable r10 = r5.getRootContainer().getBackground();
        if (r10 == null) goto L8;
        r5.setBgColor(((ColorDrawable) r10).getColor());
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L10:
        if ((r5.getRootContainer().getBackground() instanceof GradientDrawable) == false) goto L21;
        Drawable r11 = r5.getRootContainer().getBackground();
        if (r11 == null) goto L19;
        ColorStateList r12 = ((GradientDrawable) r11).getColor();
        if (r12 != null) goto L16;
        int r13 = -1;
    L17:
        r5.setBgColor(r13);
        return;
    L16:
        r13 = r12.getDefaultColor();
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    public static void c(e r5) {
        Intrinsics.checkNotNullParameter(r5, "this");
        r5.k();
        int r10 = 0;
        View r11 = r5.getBodyContainer().getChildAt(0);
        if ((r11 instanceof ViewGroup) == false) goto L5;
        ViewGroup r12 = (ViewGroup) r11;
    L7:
        if ((r5.getScaffoldContainer() instanceof LinearLayout) == false) goto L18;
        r5.getBodyContainer().setPadding(0, 0, 0, 0);
        if (r12 == null) goto L12;
        r12.setClipToPadding(true);
    L12:
        if (r12 == null) goto L15;
        r12.setPadding(r12.getPaddingLeft(), r5.getBodyContentPaddingTop(), r12.getPaddingRight(), r5.getBodyContentPaddingBottom());
    L15:
        if (r12 == null) goto L39;
        r12.requestLayout();
        return;
    L39:
        return;
    L18:
        FrameLayout r13 = r5.getBodyContainer();
        if (r5.getFooterContainer().getVisibility() != 0) goto L21;
        int r14 = r5.getFooterContainer().getMeasuredHeight();
    L22:
        r13.setPadding(0, 0, 0, r14);
        if (r12 == null) goto L26;
        r12.setClipToPadding(false);
    L26:
        if (r12 != null) goto L29;
    L34:
        if (r12 == null) goto L40;
        r12.requestLayout();
        return;
    L40:
        return;
    L29:
        if (r5.getAutoAddBodyPaddingTopWhenOverlay() == true) goto L31;
    L33:
        r12.setPadding(r12.getPaddingLeft(), r5.getBodyContentPaddingTop() + r10, r12.getPaddingRight(), r5.getBodyContentPaddingBottom());
        goto L34
    L31:
        if (r5.getHeaderContainer().getVisibility() != 0) goto L33;
        r10 = r5.getHeaderContainer().getMeasuredHeight();
        goto L33
    L21:
        r14 = 0;
        goto L22
    L5:
        r12 = null;
        goto L7
    }

    public static void d(e r5, View r10) {
        Intrinsics.checkNotNullParameter(r5, "this");
        m.c(r10, r5.getScaffoldController().d);
        if (r10 == null) goto L5;
        r5.setBodyContentPaddingTop(r10.getPaddingTop());
        r5.setBodyContentPaddingBottom(r10.getPaddingBottom());
        return;
    L5:
        r5.setBodyContentPaddingTop(0);
        r5.setBodyContentPaddingBottom(0);
    }

    public static void e(e r5, View r10) {
        Intrinsics.checkNotNullParameter(r5, "this");
        m r11 = r5.getScaffoldController();
        r11.getClass();
        if ((r10 instanceof OSheetTitleBar) == false) goto L5;
        r11.f14518m = (OSheetTitleBar) r10;
    L6:
        m.c(r10, r11.f14512c);
        return;
    L5:
        r11.f14518m = null;
        goto L6
    }

    public static void f(e r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "this");
        if (r5.getBgColor() == r10) goto L19;
        boolean r11 = r5.b();
        r5.setBgColor(r10);
        boolean r12 = r5.b();
        if (r5.getEnableMaterial() == true) goto L7;
        r5.getRootContainer().setBackgroundColor(r10);
    L8:
        if (r11 == r12) goto L20;
        View r13 = r5.getScaffoldController().f14512c.getChildAt(0);
        if ((r13 instanceof OSheetTitleBar) == false) goto L21;
        OSheetTitleBar r14 = (OSheetTitleBar) r13;
        if (r12 == false) goto L14;
        int r15 = 2;
    L16:
        if (r14.s == r15) goto L22;
        r14.s = r15;
        r14.f();
        return;
    L22:
        return;
    L14:
        r15 = 1;
        goto L16
    L21:
        return;
    L20:
        return;
    L7:
        r5.g();
        goto L8
    }

    public static void g(e r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "this");
        Intrinsics.checkNotNullParameter(r11, "context");
        r10.setRootContainer((RadiusLayout) r10.f(R$id.root_constraint));
        r10.setupDimView(r11);
        r10.setHeaderContainer((FrameLayout) r10.f(R$id.header_container));
        r10.setBodyContainer((FrameLayout) r10.f(R$id.body_container));
        r10.setFooterContainer((FrameLayout) r10.f(R$id.footer_container));
        r10.setScaffoldContainer((ViewGroup) r10.f(R$id.scaffold_container));
        r10.a();
        r10.setScaffoldController(new m(r11, r10, r10.getRootContainer(), r10.getHeaderContainer(), r10.getBodyContainer(), r10.getFooterContainer(), r10.getScaffoldContainer(), r10.getDimView()));
        m r12 = r10.getScaffoldController();
        OSheet$HeightMode r5 = r10.getHeightStyle();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r12.f14515j = r5;
        m r13 = r10.getScaffoldController();
        r13.f14516k = r10.getIgnoreInsetBottom();
        m r14 = r10.getScaffoldController();
        Size r15 = r10.getFullWindowSize();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "fullWindowSize");
        j r16 = new j(0);
        RadiusLayout r17 = r14.f14511b;
        r17.setOnClickListener(r16);
        r14.f.setClipChildren(false);
        View r18 = r14.g;
        r18.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        r18.setAlpha(0.0f);
        com.lynx.tasm.utils.d.s(r18);
        r14.d(r15);
        r14.f();
        Intrinsics.checkNotNullParameter(r17, "container");
        int r19 = com.lynx.tasm.utils.a.B(10, r17);
        ViewGroup.LayoutParams r20 = r17.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        if (r21.topMargin >= r19) goto L7;
        r21.topMargin = r19;
    L7:
        r17.setLayoutParams(r20);
        r14.a();
        r10.j();
    }

    public static void h(e r5) {
        Intrinsics.checkNotNullParameter(r5, "this");
        r5.setFullWindowSize(com.lynx.tasm.utils.j.n(r5.getSheetContext()));
        if (r5.getUserWindowWidth() <= 0) goto L8;
        if (r5.getUserWindowWidth() >= r5.getFullWindowSize().getWidth()) goto L8;
        r5.setFullWindowSize(new Size(r5.getUserWindowWidth(), r5.getFullWindowSize().getHeight()));
    L8:
        if (r5.getUserWindowHeight() > 0) goto L10;
        return;
    L10:
        if (r5.getUserWindowHeight() >= r5.getFullWindowSize().getHeight()) goto L14;
        r5.setFullWindowSize(new Size(r5.getFullWindowSize().getWidth(), r5.getUserWindowHeight()));
        return;
    }
}

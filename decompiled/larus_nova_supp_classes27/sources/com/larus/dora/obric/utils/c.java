package com.larus.dora.obric.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final void a(final OFloatingTitleBar r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.setOutlineProvider(null);
        Resources r0 = r2.getResources();
        r2.setTranslationZ(WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
        b(r2);
        r2.post(new a(r2));
    }

    public static final void b(ViewGroup r4) {
        int r0 = 0;
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
        int r1 = r4.getChildCount();
    L3:
        if (r0 >= r1) goto L11;
        View r2 = r4.getChildAt(r0);
        if ((r2 instanceof ViewGroup) == false) goto L7;
        ViewGroup r3 = (ViewGroup) r2;
    L8:
        if (r3 == null) goto L10;
        b(r3);
    L10:
        r0 = r0 + 1;
        goto L3
    L7:
        r3 = null;
        goto L8
    }

    public static final ConstraintLayout c(Context r6, OFloatingTitleBar r7, View r8, int r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "titleBar");
        Intrinsics.checkNotNullParameter(r8, "body");
        Integer r0 = Integer.valueOf(r7.getId());
        if (r0.intValue() == (-1)) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        int r2 = r0.intValue();
    L12:
        ConstraintLayout r3 = new ConstraintLayout(r6);
        r3.setBackgroundColor(r9);
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        a(r7);
        FrameLayout r11 = new FrameLayout(r6);
        r11.setClipChildren(true);
        r11.setClipToPadding(false);
        r11.addView(r8, new FrameLayout.LayoutParams(-1, -1));
        if (r10 == null) goto L15;
        View r12 = new View(r6);
        r12.setBackgroundColor(ContextCompat.getColor(r6, 2131103066));
        r12.setClickable(true);
        r12.setFocusable(true);
        r12.setVisibility(8);
        r11.addView(r12, new FrameLayout.LayoutParams(-1, -1));
        r10.invoke(r12);
    L15:
        ViewGroup.LayoutParams r13 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r13).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r13).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r13).topToBottom = r2;
        ((ConstraintLayout.LayoutParams) r13).bottomToBottom = 0;
        Unit r14 = Unit.INSTANCE;
        r3.addView(r11, r13);
        ViewGroup.LayoutParams r15 = new ConstraintLayout.LayoutParams(0, -2);
        ((ConstraintLayout.LayoutParams) r15).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r15).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r15).topToTop = 0;
        r3.addView(r7, r15);
        return r3;
    L11:
        Integer r4 = Integer.valueOf(View.generateViewId());
        r7.setId(r4.intValue());
        r2 = r4.intValue();
        goto L12
    L5:
        r1 = false;
        goto L6
    }
}

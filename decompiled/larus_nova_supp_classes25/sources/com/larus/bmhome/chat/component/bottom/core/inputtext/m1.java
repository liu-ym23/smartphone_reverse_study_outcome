package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m1 {
    public static final View a(LayoutInflater r11, ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "parent");
        View r13 = r11.inflate(2131562604, r12, false);
        int r14 = com.larus.common_ui.dbx.theme.a.b(r13.getContext(), 2130971068);
        int r0 = com.larus.common_ui.dbx.theme.a.b(r13.getContext(), 2130971001);
        View r2 = r13.findViewById(2131381882);
        GradientDrawable r3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{ColorUtils.setAlphaComponent(r14, 20), ColorUtils.setAlphaComponent(r14, 10)});
        r3.setShape(1);
        r2.setBackground(r3);
        View r4 = r13.findViewById(2131381883);
        GradientDrawable r5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{ColorUtils.setAlphaComponent(r14, 20), ColorUtils.setAlphaComponent(r0, 10)});
        r5.setShape(0);
        r5.setCornerRadius(i5.h());
        r4.setBackground(r5);
        return r13;
    }
}

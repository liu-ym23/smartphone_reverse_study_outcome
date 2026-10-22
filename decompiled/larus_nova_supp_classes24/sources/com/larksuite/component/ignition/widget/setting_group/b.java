package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(GradientDrawable r9, Context r10, boolean r11, boolean r12, float r13) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r11 == false) goto L7;
        if (r12 == false) goto L7;
        r9.setCornerRadii(new float[]{r13, r13, r13, r13, r13, r13, r13, r13});
        return;
    L7:
        if (r11 == false) goto L9;
        r9.setCornerRadii(new float[]{r13, r13, r13, r13, 0.0f, 0.0f, 0.0f, 0.0f});
        return;
    L9:
        if (r12 == false) goto L11;
        r9.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r13, r13, r13, r13});
        return;
    L11:
        r9.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
    }
}

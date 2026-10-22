package com.ss.android.lark.inline.ai.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.color.UDColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static GradientDrawable a(FragmentActivity r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{UDColorUtils.getAlphaColor(r6, 2131100562, 0.0f), UDColorUtils.getAlphaColor(r6, 2131100562, 0.2f)});
    }

    public static ColorDrawable b(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new ColorDrawable(UDColorUtils.getAlphaColor(r3, 2131100562, 0.4f));
    }
}

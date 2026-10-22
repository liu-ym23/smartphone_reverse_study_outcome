package com.bytedance.awemeopen.writtenlayout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static float a;

    static {
        a = -1.0f;
    }

    public static int a(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        float r0 = a;
        if (r0 > 0.0f) goto L7;
        DisplayMetrics r1 = new DisplayMetrics();
        Object r4 = r2.getSystemService("window");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) r4).getDefaultDisplay().getMetrics(r1);
        r0 = r1.density;
        a = r0;
    L7:
        return (int) ((r3 * r0) + 0.5f);
    }
}

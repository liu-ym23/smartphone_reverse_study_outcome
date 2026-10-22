package com.bytedance.awemeopen.infra.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static float a = -1.0f;

    public static int a(Context r2, float r3) {
        float r0 = a;
        if (r0 >= 0.0f) goto L9;
        DisplayMetrics r1 = new DisplayMetrics();     // Catch: Exception -> L7
        ((WindowManager) r2.getSystemService("window")).getDefaultDisplay().getMetrics(r1);     // Catch: Exception -> L7
        r0 = r1.density;     // Catch: Exception -> L7
        a = r0;     // Catch: Exception -> L7
    L7:
        r0 = 2.0f;
    L9:
        return (int) ((r3 * r0) + 0.5f);
    }
}

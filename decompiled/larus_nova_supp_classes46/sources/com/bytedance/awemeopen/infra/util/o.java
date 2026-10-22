package com.bytedance.awemeopen.infra.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public static String a;

    static {
        a = "";
    }

    public static int a(Context r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        Resources r3 = r2.getResources();
        DisplayMetrics r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics());
        if (r4 != null) goto L8;
        return 0;
    L8:
        return r4.widthPixels;
    }
}

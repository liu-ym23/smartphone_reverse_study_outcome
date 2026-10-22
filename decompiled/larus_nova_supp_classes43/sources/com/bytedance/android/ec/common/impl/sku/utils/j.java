package com.bytedance.android.ec.common.impl.sku.utils;

import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(FragmentActivity r10) {
        if (r10 != null) goto L18;
        return 0;
    L18:
        Object r1 = r10.getSystemService("window");     // Catch: Exception -> L17
        DisplayMetrics r11 = null;
        if ((r1 instanceof WindowManager) == true) goto L8;
        r1 = null;
    L8:
        WindowManager r12 = (WindowManager) r1;     // Catch: Exception -> L17
        if (r12 == null) goto L11;
        Display r13 = r12.getDefaultDisplay();     // Catch: Exception -> L17
        Point r14 = new Point();     // Catch: Exception -> L17
        r13.getRealSize(r14);     // Catch: Exception -> L17
        return r14.y;
    L11:
        Resources r15 = r10.getResources();     // Catch: Exception -> L17
        if (r15 == null) goto L14;
        r11 = WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics());     // Catch: Exception -> L17
    L14:
        if (r11 != null) goto L16;
        return 0;
    L16:
        return r11.heightPixels;
    L21:
        return 0;
    }
}

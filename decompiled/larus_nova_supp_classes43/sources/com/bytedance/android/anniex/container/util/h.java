package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r10) {
        if ((r10 instanceof Activity) == false) goto L12;
        Activity r0 = (Activity) r10;
        WindowManager r1 = r0.getWindowManager();
        if (r1 == null) goto L7;
        Display r11 = r1.getDefaultDisplay();
    L8:
        if (r11 == null) goto L12;
        Display r12 = r0.getWindowManager().getDefaultDisplay();
        if (r12.getWidth() >= r12.getHeight()) goto L20;
    L21:
        return false;
    L20:
        return true;
    L7:
        r11 = null;
    L12:
        if (r10 == null) goto L17;
        Resources r13 = r10.getResources();
        if (r13 == null) goto L17;
        DisplayMetrics r14 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());
        if (r14 == null) goto L17;
    L19:
        if (r14.widthPixels < r14.heightPixels) goto L21;
    L17:
        Resources r15 = Resources.getSystem();
        r14 = WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics());
        goto L19
    }
}

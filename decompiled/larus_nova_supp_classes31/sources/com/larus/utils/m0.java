package com.larus.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m0 {
    public static int a;

    static {
    }

    public static int a(Context r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 30) goto L17;
        if ((r6 instanceof Activity) == false) goto L10;
        WindowManager r7 = ((Activity) r6).getWindowManager();
        Intrinsics.checkNotNull(r7);
    L11:
        WindowMetrics r8 = r7.getCurrentWindowMetrics();
        if (r8 == null) goto L29;
        Rect r9 = r8.getBounds();
        if (r9 != null) goto L31;
        return 0;
    L31:
        return r9.height();
    L29:
        return 0;
    L10:
        Object r10 = r6.getSystemService("window");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.view.WindowManager");
        r7 = (WindowManager) r10;
        goto L11
    L17:
        if ((r6 instanceof Activity) == false) goto L23;
        if (r1 < 30) goto L22;
        Display r2 = ((Activity) r6).getDisplay();
        if (r2 == null) goto L22;
    L25:
        if (r2 == null) goto L32;
        DisplayMetrics r11 = new DisplayMetrics();
        r2.getRealMetrics(r11);
        return r11.heightPixels;
    L32:
        return 0;
    L22:
        WindowManager r12 = ((Activity) r6).getWindowManager();
        Intrinsics.checkNotNull(r12);
    L24:
        r2 = r12.getDefaultDisplay();
        goto L25
    L23:
        Object r13 = r6.getSystemService("window");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.view.WindowManager");
        r12 = (WindowManager) r13;
        goto L24
    }

    public static int b(Context r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        Resources r2 = r1.getResources();
        return WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).widthPixels;
    }

    public static int c(Context r1) {
        int r0 = a;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r2 = b(r1);
        a = r2;
        return r2;
    }

    public static boolean d(WindowInsets r2) {
        Intrinsics.checkNotNullParameter(r2, "insets");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        return r2.isVisible(WindowInsets.Type.navigationBars());
    L6:
        if (r2.getSystemWindowInsetBottom() <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean e(View r6) {
        Intrinsics.checkNotNullParameter(r6, "bottomView");
        int[] r0 = new int[2];
        r6.getLocationOnScreen(r0);
        int r1 = r0[1] + r6.getHeight();
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L7:
        if (r3 == null) goto L9;
        int r4 = r3.bottomMargin;
    L10:
        int r5 = r1 + r4;
        int r7 = a(r6.getContext());
        FLogger.a.i("ScreenUtils", "isViewMeetScreenBottom viewBottom=" + r5 + " screenHeight=" + r7);
        if (r5 >= r7) goto L15;
        return false;
    L15:
        return true;
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = null;
        goto L7
    }
}

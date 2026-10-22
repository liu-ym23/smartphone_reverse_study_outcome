package com.larus.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public static final FragmentActivity a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        FragmentActivity r2 = getActivity(r1);
        if ((r2 instanceof FragmentActivity) == true) goto L7;
        return null;
    L7:
        return r2;
    }

    public static final int b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        WindowManager r0 = (WindowManager) r2.getSystemService("window");
        DisplayMetrics r1 = new DisplayMetrics();
        if (r0 == null) goto L6;
        r0.getDefaultDisplay().getRealMetrics(r1);
        return r1.heightPixels;
    L6:
        return c(r2);
    }

    public static final int c(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Resources r2 = AppHost.a.getApplication().getResources();
        return WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).heightPixels;
    }

    public static final int d(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Resources r2 = AppHost.a.getApplication().getResources();
        return WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).widthPixels;
    }

    public static final int e(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        i0.a.getClass();
        return i0.g();
    }

    public static final int f(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r0 = r3.getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r1 = (WindowManager) r0;
        if (Build.VERSION.SDK_INT < 30) goto L5;
        int r2 = r1.getCurrentWindowMetrics().getBounds().width();
    L6:
        Resources r4 = r3.getResources();
        int r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).widthPixels;
        if (g(r3) == true) goto L11;
        if (r5 == r2) goto L10;
        return r5;
    L10:
        return r5 - e(r3);
    L11:
        return r5;
    L5:
        DisplayMetrics r6 = new DisplayMetrics();
        r1.getDefaultDisplay().getRealMetrics(r6);
        r2 = r6.widthPixels;
        goto L6
    }

    public static final boolean g(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r0 = r3.getSystemService("window");
        if ((r0 instanceof WindowManager) == false) goto L5;
        WindowManager r1 = (WindowManager) r0;
    L7:
        if (r1 == null) goto L9;
        int r4 = r1.getDefaultDisplay().getRotation();
        if (r4 != 0) goto L15;
    L16:
        return true;
    L15:
        if (r4 == 2) goto L16;
        return false;
    L9:
        if (r3.getResources().getConfiguration().orientation != 1) goto L18;
        return true;
    L18:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static final Activity getActivity(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
    L4:
        if (r2 == null) goto L12;
        if ((r2 instanceof Activity) == true) goto L8;
        if ((r2 instanceof ContextWrapper) == false) goto L12;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L4
    L8:
        return (Activity) r2;
    L12:
        return null;
    }

    public static final boolean h(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getResources().getConfiguration().getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}

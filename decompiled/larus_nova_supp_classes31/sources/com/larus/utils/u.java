package com.larus.utils;

import android.graphics.Color;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u {
    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final int b(FragmentActivity r2) {
        if (r2 != null) goto L5;
        i0.a.getClass();
        return i0.e();
    L5:
        Integer r0 = nda.d.a().ka(r2);
        if (r0 != null) goto L8;
    L17:
        i0.a.getClass();
        return Math.min(i0.c(r2), i0.e());
    L8:
        if (r0.intValue() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L17;
        return r0.intValue();
    L10:
        r1 = false;
        goto L11
    }

    public static final int c(FragmentActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        i0.a.getClass();
        return i0.g();
    }

    public static final void d(FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        WindowCompat.setDecorFitsSystemWindows(r5.getWindow(), false);
        r5.getWindow().setNavigationBarColor(Color.argb(1, 255, 255, 255));     // Catch: Exception -> L5
    L7:
        WindowCompat.getInsetsController(r5.getWindow(), a(r5.getWindow())).setAppearanceLightNavigationBars(true);
        return;
    L5:
        e = move-exception;
        FLogger.a.e("FragmentActivityExt", "exception=" + e.getMessage());
        goto L7
    }

    public static final void f(FragmentActivity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        WindowCompat.setDecorFitsSystemWindows(r2.getWindow(), false);
        r2.getWindow().setStatusBarColor(0);
        r2.getWindow().setNavigationBarColor(0);
        WindowInsetsControllerCompat r4 = WindowCompat.getInsetsController(r2.getWindow(), a(r2.getWindow()));
        r4.setAppearanceLightStatusBars(r3);
        r4.setAppearanceLightNavigationBars(r3);
    }

    public static final void g(FragmentActivity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.getWindow().setNavigationBarColor(0);
        WindowCompat.getInsetsController(r2.getWindow(), a(r2.getWindow())).setAppearanceLightNavigationBars(r3);
    }

    public static final void h(FragmentActivity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.getWindow().setStatusBarColor(0);
        r2.getWindow().setNavigationBarColor(0);
        WindowInsetsControllerCompat r4 = WindowCompat.getInsetsController(r2.getWindow(), a(r2.getWindow()));
        r4.setAppearanceLightStatusBars(r3);
        r4.setAppearanceLightNavigationBars(r3);
    }

    public static final void e(FragmentActivity r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        WindowCompat.setDecorFitsSystemWindows(r5.getWindow(), false);
        r5.getWindow().setStatusBarColor(Color.argb(1, 255, 255, 255));     // Catch: Exception -> L5
    L7:
        WindowInsetsControllerCompat r8 = WindowCompat.getInsetsController(r5.getWindow(), a(r5.getWindow()));
        if (r7 == false) goto L10;
        r8.setAppearanceLightStatusBars(false);
        return;
    L10:
        r8.setAppearanceLightStatusBars(r6);
        return;
    L5:
        e = move-exception;
        FLogger.a.e("FragmentActivityExt", "exception=" + e.getMessage());
        goto L7
    }
}

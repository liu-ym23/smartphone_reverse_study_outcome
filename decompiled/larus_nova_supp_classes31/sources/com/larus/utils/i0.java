package com.larus.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i0 {
    public static final i0 a = null;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static final Rect g = null;
    public static boolean h;
    public static boolean i;
    public static int j;
    public static String k;

    public static final class a implements f09.a.b {
        public a() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            FLogger.a.i("ResourceCache", "onAppBackground: reset some cache");
            i0.f = -1;
        }
    }

    public i0() {
    }

    static {
        a = new i0();
        b = -1;
        c = -1;
        d = -1;
        e = -1;
        f = -1;
        g = new Rect();
        j = -1;
        AppHost.a.a().j(new a());
    }

    public static int e() {
        int r2 = f;
        int r3 = -1;
        if (r2 <= (-1)) goto L5;
        return r2;
    L5:
        Object r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 30) goto L11;
        Object r6 = AppHost.a.getApplication().getSystemService("window");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Throwable -> L14
        int r7 = ((WindowManager) r6).getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.navigationBars()).bottom;     // Catch: Throwable -> L14
        if (r7 <= 0) goto L11;
        FLogger.a.i("ResourceCache", "getNavBarHeight use window insets: " + r7);     // Catch: Throwable -> L14
        Integer r1 = Integer.valueOf(r7);     // Catch: Throwable -> L14
    L12:
        Object r8 = Result.constructor-impl(r1);     // Catch: Throwable -> L14
    L16:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L20;
        FLogger.a.w("ResourceCache", "getNavBarHeight failed: " + r9.getMessage(), r9);
    L20:
        if (Result.isFailure-impl(r8) == true) goto L23;
        r4 = r8;
    L23:
        Integer r10 = (Integer) r4;
        if (r10 == null) goto L27;
        int r0 = r10.intValue();
    L30:
        f = r0;
        return r0;
    L27:
        if (f() <= 0) goto L29;
        r3 = AppHost.a.getApplication().getResources().getDimensionPixelSize(f());
    L29:
        r0 = r3;
    L11:
        r1 = null;
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static int f() {
        int r0 = b;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r1 = AppHost.a.getApplication().getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        b = r1;
        return r1;
    }

    public static int g() {
        int r0 = e;
        int r1 = -1;
        if (r0 <= (-1)) goto L6;
        return r0;
    L6:
        if (h() <= 0) goto L8;
        r1 = AppHost.a.getApplication().getResources().getDimensionPixelSize(h());
    L8:
        e = r1;
        return r1;
    }

    public static int h() {
        int r0 = c;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r1 = AppHost.a.getApplication().getResources().getIdentifier("status_bar_height", "dimen", "android");
        c = r1;
        return r1;
    }

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

    public static int b(FragmentActivity r2) {
        i = true;
        Rect r0 = g;
        r0.setEmpty();
        a(r2.getWindow()).getWindowVisibleDisplayFrame(r0);
        int r1 = r0.height();
        int r3 = m0.a(r2) - g();
        if (r3 <= 0) goto L13;
        if (r1 <= 0) goto L13;
        int r4 = Math.max(r3 - r1, -1);
        if (r4 <= 0) goto L9;
        int r5 = r4;
    L10:
        j = r5;
        return r4;
    L9:
        r5 = 0;
    L13:
        return d;
    }

    public static int c(FragmentActivity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        boolean r1 = false;
        if (i == false) goto L11;
        int r0 = d;
        if (r0 <= (-1)) goto L11;
        if (h == false) goto L11;
        return Math.max(r0, 0);
    L11:
        if (Build.VERSION.SDK_INT < 30) goto L17;
        WindowInsets r2 = a(r7.getWindow()).getRootWindowInsets();
        if (r2 != null) goto L15;
    L22:
        boolean r3 = false;
    L24:
        if (r3 == true) goto L32;
        String r4 = k;
        if (r4 != null) goto L28;
    L30:
        k = r7.getClass().getSimpleName();
        FLogger.a.d("ResourceCache", "calculateNavBarHeight, but should not cache it, activity:" + r7.getClass().getSimpleName() + ' ');
        return b(r7);
    L28:
        if (Intrinsics.areEqual(r4, r7.getClass().getSimpleName()) == true) goto L30;
    L32:
        Integer r5 = null;
        k = null;
        Integer r6 = Integer.valueOf(b(r7));
        if (r6.intValue() < 0) goto L35;
        r1 = true;
    L35:
        if (r1 == false) goto L37;
        r5 = r6;
    L37:
        if (r5 == null) goto L39;
        d = r5.intValue();
    L39:
        FLogger.a.d("ResourceCache", "calculateNavBarHeight:" + d + ",activity:" + r7.getClass().getSimpleName() + ' ');
        return d;
    L15:
        if (r2.isVisible(WindowInsets.Type.navigationBars()) != true) goto L22;
    L21:
        r3 = true;
        goto L24
    L17:
        WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets(a(r7.getWindow()));
        if (r8 == null) goto L22;
        if (r8.isVisible(WindowInsetsCompat.Type.navigationBars()) != true) goto L22;
        goto L21
    }

    public static void d(boolean r1) {
        h = r1;
        if (r1 == true) goto L5;
        return;
    L5:
        if (j != (-1)) goto L9;
        j = e();
        return;
    }

    public static void i(final WeakReference r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        FragmentActivity r0 = (FragmentActivity) r2.get();
        if (r0 == null) goto L10;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        View r3 = a(r1);
        if (r3 == null) goto L12;
        ViewCompat.setOnApplyWindowInsetsListener(r3, new h0(r2));
        return;
    L12:
        return;
    L11:
        return;
    }
}

package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l0 {
    public static View a(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static final Activity b(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof ContextWrapper) == true) goto L8;
        return null;
    L8:
        if ((r10 instanceof Activity) == false) goto L11;
        return (Activity) r10;
    L11:
        return b(((ContextWrapper) r10).getBaseContext());
    }

    public static final FragmentActivity c(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof ContextWrapper) == true) goto L8;
        return null;
    L8:
        if ((r10 instanceof FragmentActivity) == false) goto L11;
        return (FragmentActivity) r10;
    L11:
        return c(((ContextWrapper) r10).getBaseContext());
    }

    public static final void d(Window r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$makeStatusBarTransparent");
        r10.clearFlags(67108864);
        r10.addFlags(Integer.MIN_VALUE);
        int r0 = a(r10).getSystemUiVisibility();
        a(r10).setSystemUiVisibility(r0 | 1280);
        r10.setStatusBarColor(0);
    }

    public static final int e(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$navigationOrGestureBarHeight");
        Activity r0 = b(r10);
        if (r0 == null) goto L14;
        Rect r11 = new Rect();
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        View r12 = a(r1);
        if (r12 == null) goto L14;
        r12.getWindowVisibleDisplayFrame(r11);
        int r13 = r11.height();
        zh.b.a.getClass();
        int r14 = zh.b.a(r10);
        Point r15 = f(r10);
        if (r15 == null) goto L11;
        int r16 = r15.y;
    L13:
        return RangesKt.coerceAtLeast((r16 - r14) - r13, 0);
    L11:
        r16 = 0;
    L14:
        return 0;
    }

    public static final Point f(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$screenSize");
        Object r11 = r10.getSystemService("window");
        if ((r11 instanceof WindowManager) == true) goto L5;
        r11 = null;
    L5:
        WindowManager r12 = (WindowManager) r11;
        if (r12 == null) goto L15;
        Display r13 = r12.getDefaultDisplay();
        if (r13 == null) goto L16;
        Point r0 = new Point();
        r13.getRealSize(r0);
        if (r0.x > 0) goto L12;
        return null;
    L12:
        if (r0.y > 0) goto L14;
        return null;
    L14:
        return r0;
    L16:
        return null;
    L15:
        return null;
    }
}

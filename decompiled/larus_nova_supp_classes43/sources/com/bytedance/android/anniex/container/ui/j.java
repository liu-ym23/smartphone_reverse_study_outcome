package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static Integer c;
    public final Window a;
    public FrameLayout b;

    public static final class a {
    }

    static {
    }

    public final void d() {
        Window r0 = this.a;
        View r1 = a(r0);
        r1.setSystemUiVisibility(r1.getSystemUiVisibility() & (-5));
        r0.clearFlags(1024);
        Window r10 = this.a;
        int r11 = Build.VERSION.SDK_INT;
        r10.clearFlags(67108864);
        r10.addFlags(Integer.MIN_VALUE);
        r10.setStatusBarColor(0);
        View r12 = a(r10);
        r12.setSystemUiVisibility((1024 | r12.getSystemUiVisibility()) | 256);
        if (r11 < 28) goto L6;
        WindowManager.LayoutParams r13 = r10.getAttributes();
        r13.layoutInDisplayCutoutMode = 1;
        r10.setAttributes(r13);
        return;
    }

    public j(Window r10) {
        Intrinsics.checkNotNullParameter(r10, "window");
        this.a = r10;
    }

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

    public static int b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Integer r0 = c;
        if (r0 != null) goto L13;
        Resources r11 = r10.getResources();
        int r1 = r11.getIdentifier("status_bar_height", "dimen", "android");
        if (r1 <= 0) goto L8;
        c = Integer.valueOf(r11.getDimensionPixelSize(r1));
    L8:
        Integer r12 = c;
        if (r12 != null) goto L14;
        return 0;
    L14:
        return r12.intValue();
    L13:
        return r0.intValue();
    }

    public final void c(StatusFontMode r10) {
        Intrinsics.checkNotNullParameter(r10, "fontMode");
        Window r0 = this.a;
        if (r10 != StatusFontMode.DARK) goto L5;
        boolean r11 = true;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L17;
        WindowInsetsControllerCompat r1 = WindowCompat.getInsetsController(r0, a(r0));
        if (r1 == null) goto L11;
        r1.setAppearanceLightStatusBars(r11);
        return;
    L11:
        View r12 = a(r0);
        int r13 = r12.getSystemUiVisibility();
        if (r11 == false) goto L14;
        int r14 = r13 | 8192;
    L15:
        r12.setSystemUiVisibility(r14);
        return;
    L14:
        r14 = r13 & (-8193);
        goto L15
    L17:
        return;
    L5:
        r11 = false;
        goto L7
    }

    public final void e(boolean r10) {
        FrameLayout r0 = this.b;
        if (r0 == null) goto L10;
        if (r10 == false) goto L7;
        int r11 = 8;
    L8:
        r0.setVisibility(r11);
        return;
    L7:
        r11 = 0;
        goto L8
    }

    public final void f(boolean r10) {
        if (r10 == false) goto L5;
        Window r11 = this.a;
        View r1 = a(r11);
        r1.setSystemUiVisibility(r1.getSystemUiVisibility() & (-5));
        r11.clearFlags(1024);
        return;
    L5:
        Window r12 = this.a;
        View r13 = a(r12);
        r13.setSystemUiVisibility(r13.getSystemUiVisibility() | 4);
        r12.addFlags(1024);
    }
}

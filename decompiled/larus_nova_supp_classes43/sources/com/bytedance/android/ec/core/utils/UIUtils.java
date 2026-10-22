package com.bytedance.android.ec.core.utils;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UIUtils {
    public static final Lazy a = null;

    public UIUtils() {
    }

    public static Handler c() {
        return (Handler) a.getValue();
    }

    static {
        a = LazyKt.lazy(UIUtils$uiHandler$2.INSTANCE);
    }

    public static boolean d() {
        return Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
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

    public static void e(Runnable r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        if (d() == false) goto L5;
        r1.run();
        return;
    L5:
        c().post(r1);
    }

    public static void b(Window r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "window");
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        if (((((((double) Color.red(r11)) * 0.299d) + (((double) Color.green(r11)) * 0.587d)) + (((double) Color.blue(r11)) * 0.114d)) / ((double) 255)) <= 0.5d) goto L8;
        a(r10).setSystemUiVisibility(a(r10).getSystemUiVisibility() | 16);
        return;
    L8:
        a(r10).setSystemUiVisibility(a(r10).getSystemUiVisibility() & (-17));
    }

    public static void f(ViewGroup r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setClipChildren");
        int r0 = 12;
    L3:
        int r1 = r0 - 1;
        if (r0 <= 0) goto L21;
        r10.setClipChildren(false);
        ViewParent r12 = r10.getParent();
        if ((r12 instanceof ViewGroup) == true) goto L8;
        r12 = null;
    L8:
        r10 = (ViewGroup) r12;
        if (r10 == null) goto L22;
        if (r11 == null) goto L14;
        if (((Boolean) r11.invoke(r10)).booleanValue() == false) goto L14;
        r10.setClipChildren(false);
        return;
    L14:
        r0 = r1;
        goto L3
    L22:
        return;
    }

    public static void g(Window r0, String r1) {
        if (r0 != null) goto L11;
        return;
    L11:
        Integer r10 = s.b(r1);     // Catch: Exception -> L8
        if (r10 == null) goto L13;
        int r11 = r10.intValue();     // Catch: Exception -> L8
        r0.setNavigationBarColor(r11);     // Catch: Exception -> L8
        b(r0, r11);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}

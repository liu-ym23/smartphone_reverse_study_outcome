package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
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

    public static void b(Activity r10, String r11) {
        if (r10 == null) goto L6;
        Window r0 = r10.getWindow();
        r0.clearFlags(67108864);
        a(r0).setSystemUiVisibility(1280);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setStatusBarColor(0);
    L6:
        if (Intrinsics.areEqual("light", r11) == false) goto L9;
        g.f(r10);
        return;
    L9:
        if (Intrinsics.areEqual("dark", r11) == false) goto L13;
        g.g(r10);
        return;
    }
}

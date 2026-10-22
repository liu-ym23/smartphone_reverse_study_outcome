package com.bytedance.android.annie.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u {
    public static int a;

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

    public static int b(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r0 = a;
        if (r0 == 0) goto L8;
        return r0;
    L8:
        Resources r11 = r10.getResources();
        int r12 = r11.getDimensionPixelSize(r11.getIdentifier("status_bar_height", "dimen", "android"));
        a = r12;
        return r12;
    }
}

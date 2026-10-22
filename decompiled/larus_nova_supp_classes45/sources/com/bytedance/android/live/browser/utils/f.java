package com.bytedance.android.live.browser.utils;

import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
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

    public static boolean b(Window r2) {
        View r3 = a(r2);
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3.getSystemUiVisibility() & IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) != 8192) goto L9;
        return true;
    L9:
        return false;
    }
}

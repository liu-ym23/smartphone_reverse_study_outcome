package com.larus.voicecall.impl.util;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y0 {
    public static final void a(FragmentActivity r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Window r5 = r3.getWindow();
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L11;
        WindowInsetsController r6 = r5.getInsetsController();
        if (r6 != null) goto L7;
        return;
    L7:
        if (r4 == false) goto L9;
        r6.setSystemBarsAppearance(8, 8);
        return;
    L9:
        r6.setSystemBarsAppearance(0, 8);
        return;
    L11:
        if (r0 < 23) goto L26;
        View r7 = r5.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L17;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L17:
        int r2 = r7.getSystemUiVisibility();
        if (r4 == false) goto L20;
        int r8 = r2 | 8192;
    L21:
        r7.setSystemUiVisibility(r8);
        return;
    L20:
        r8 = r2 & (-8193);
        goto L21
    }
}

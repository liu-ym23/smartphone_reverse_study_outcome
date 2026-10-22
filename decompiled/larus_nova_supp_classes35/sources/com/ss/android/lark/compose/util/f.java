package com.ss.android.lark.compose.util;

import android.app.Activity;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.h;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final void a(Activity r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r5 = ContextCompat.getColor(r3, r4);     // Catch: Exception -> L10
        h r0 = WindowInsetsUtils.c(r3);     // Catch: Exception -> L10
        r0.k(true);     // Catch: Exception -> L10
        r0.r(true);     // Catch: Exception -> L10
        r0.f(false);     // Catch: Exception -> L10
        r0.o(false);     // Catch: Exception -> L10
        r0.c(false);     // Catch: Exception -> L10
        r0.b(r5);     // Catch: Exception -> L10
        WindowInsetsUtils.e(r3);     // Catch: Exception -> L10
        WindowCompat.setDecorFitsSystemWindows(r3.getWindow(), false);     // Catch: Exception -> L10
        View r6 = r3.getWindow().getDecorView();     // Catch: Exception -> L10
        if (com.larus.home.impl.utils.c.e == false) goto L8;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L10
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L10
        if (r1 == com.larus.home.impl.utils.c.a) goto L8;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Exception -> L10
    L8:
        r6.setBackgroundColor(r5);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("FlowChatSetting immersivePage failed!", e);
    }
}

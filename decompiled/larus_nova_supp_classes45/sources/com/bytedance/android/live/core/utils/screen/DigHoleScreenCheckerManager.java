package com.bytedance.android.live.core.utils.screen;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.alog.middleware.ALogService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class DigHoleScreenCheckerManager {
    public static final Map<String, a> b = null;
    public static final Map<String, a> c = null;
    public final boolean a;

    static {
        b = new AnonymousClass1();
        c = new AnonymousClass2();
    }

    public DigHoleScreenCheckerManager(Context r7) {
        boolean r0 = false;
        this.a = false;
        if ((r7 instanceof Activity) == true) goto L6;
    L18:
        boolean r1 = false;
    L21:
        if (r1 == false) goto L45;
    L42:
        r0 = true;
    L43:
        this.a = r0;
        return;
    L45:
        String r2 = Build.MANUFACTURER.toUpperCase().trim();     // Catch: Exception -> L39
        String r3 = Build.BRAND.toUpperCase().trim();     // Catch: Exception -> L39
        a r4 = (a) ((HashMap) b).get(r2);     // Catch: Exception -> L39
        a r5 = (a) ((HashMap) c).get(r3);     // Catch: Exception -> L39
        if (r4 != null) goto L25;
    L27:
        boolean r6 = false;
    L28:
        if (r5 == null) goto L33;
        if (r4 == r5) goto L33;
        if (r5.b(r7) == false) goto L33;
        boolean r8 = true;
    L34:
        if (r6 == true) goto L38;
        if (r8 == true) goto L38;
    L37:
        boolean r9 = false;
    L41:
        if (r9 == false) goto L43;
    L38:
        r9 = true;
    L33:
        r8 = false;
        goto L34
    L25:
        if (r4.b(r7) == false) goto L27;
        r6 = true;
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L18;
        View r11 = ((Activity) r7).getWindow().getDecorView();
        if (c.e == false) goto L47;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r12 = ThreadMethodProxy.currentThread();
        if (r12 == c.a) goto L47;
        c.a(r12, "getDecorView");
    L47:
        Object r13 = r11.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(r11, new Object[0]);     // Catch: Exception -> L19
        Object r14 = r13.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(r13, new Object[0]);     // Catch: Exception -> L19
        List r15 = (List) r14.getClass().getMethod("getBoundingRects", new Class[0]).invoke(r14, new Object[0]);     // Catch: Exception -> L19
        if (r15 == null) goto L18;
        if (r15.size() <= 0) goto L18;
        r1 = true;
    L19:
        e = move-exception;
        ALogService.dSafely("DigHoleCheck", Log.getStackTraceString(e));
        goto L18
    }
}

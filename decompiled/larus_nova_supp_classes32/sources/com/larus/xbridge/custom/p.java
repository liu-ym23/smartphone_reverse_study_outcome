package com.larus.xbridge.custom;

import android.app.Activity;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.getKeyboardHeight";
    }

    public p() {
    }

    public static int f(Activity r3) {
        View r4 = r3.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(r4);
        if (r5 == null) goto L12;
        Insets r6 = r5.getInsets(WindowInsetsCompat.Type.ime());
        if (r6 == null) goto L12;
        Integer r7 = Integer.valueOf(r6.bottom);
    L13:
        if (r7 != null) goto L17;
        return 0;
    L17:
        return r7.intValue();
    L12:
        r7 = null;
        goto L13
    }

    public final void a(dx7.b r6, ux7.d.d r7, IvyBridgePlatformType r8) {
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "type");
        Activity r9 = AppHost.a.a().getCurrentActivity();
        int r0 = 0;
        if (r9 != null) goto L20;
        int r10 = 0;
    L8:
        int r11 = (int) c7.d(Integer.valueOf(r10));
    L12:
        if (r11 < 0) goto L15;
        r0 = 1;
    L15:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("result", Integer.valueOf(r0));
        if (r0 != 1) goto L18;
        r2.put("height", Integer.valueOf(r11));
    L18:
        FLogger.a.i("AppKeyboardHeightMethod", "app.getKeyboardHeight height = " + r11 + " result = " + r0);
        bx7.c.d(this, r7, r2);
        return;
    L5:
        e = move-exception;
        FLogger.a.i("AppKeyboardHeightMethod", "app.getKeyboardHeight e=" + e.getMessage());
        r11 = -1;
        goto L12
    L20:
        r10 = f(r9);     // Catch: Exception -> L5
        goto L8
    }
}

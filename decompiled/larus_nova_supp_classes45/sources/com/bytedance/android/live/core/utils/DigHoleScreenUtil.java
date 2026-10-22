package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.screen.DigHoleScreenCheckerManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class DigHoleScreenUtil {
    private DigHoleScreenUtil() {
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_live_core_utils_DigHoleScreenUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static boolean isAllScreenForAndroidP(Context r4) {
        if ((r4 instanceof Activity) == true) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L8;
        return false;
    L8:
        View r5 = INVOKEVIRTUAL_com_bytedance_android_live_core_utils_DigHoleScreenUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) r4).getWindow());
        Object r6 = r5.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(r5, new Object[0]);     // Catch: Exception -> L15
        Object r7 = r6.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(r6, new Object[0]);     // Catch: Exception -> L15
        List r8 = (List) r7.getClass().getMethod("getBoundingRects", new Class[0]).invoke(r7, new Object[0]);     // Catch: Exception -> L15
        if (r8 == null) goto L20;
        if (r8.size() <= 0) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isCutOut(Context r4) {
        Resources r5 = r4.getResources();     // Catch: Exception -> L12
        int r1 = r5.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");     // Catch: Exception -> L12
        if (r1 <= 0) goto L6;
        String r6 = r5.getString(r1);     // Catch: Exception -> L12
    L7:
        if (r6 == null) goto L15;
        if (TextUtils.isEmpty(r6) == true) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L6:
        r6 = null;
    L17:
        return false;
    }

    public static boolean isDigHole(Context r1) {
        if (isAllScreenForAndroidP(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (new DigHoleScreenCheckerManager(r1).a == true) goto L10;
        if (isCutOut(r1) == true) goto L10;
        return false;
    }

    public static boolean isNeedStatusBarAdapt(Context r1, boolean r2, boolean r3) {
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L13;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L13;
        if (r2 == false) goto L11;
        if (r3 == true) goto L11;
        return true;
    L11:
        return isDigHole(r1);
    L13:
        return isDigHole(r1);
    }
}

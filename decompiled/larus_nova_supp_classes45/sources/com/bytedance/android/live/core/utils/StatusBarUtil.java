package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.core.utils.statusbar.StatusBarInfoType;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.i3;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class StatusBarUtil {
    public static boolean JUMP_FROM_LIVE_PLAY_ACTIVITY;
    public static boolean STATUS_BAR_ADAPT_ENABLE;
    private static int desiredTopSpaceHeight;
    public static int portraitStatusBarHeight;

    static {
        STATUS_BAR_ADAPT_ENABLE = j40.r.a.getValue().booleanValue();
        JUMP_FROM_LIVE_PLAY_ACTIVITY = false;
        portraitStatusBarHeight = 0;
    }

    public static boolean isStatusBarAdaptCombineJudge() {
        if (STATUS_BAR_ADAPT_ENABLE == true) goto L5;
    L9:
        return false;
    L5:
        if (JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L9;
        if (isStatusBarTransparent() == false) goto L9;
        return true;
    }

    public static boolean isStatusBarTransparent() {
        if (((Boolean) i3.a.getValue()).booleanValue() == false) goto L13;
        IMiddleHostService r0 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r0 != null) goto L7;
        return false;
    L7:
        IMiddleWareHostContext r1 = r0.appContext();
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.isTransparentStatusBar();
    L13:
        if (desiredTopSpaceHeight != 0) goto L16;
        return true;
    L16:
        return false;
    }

    private StatusBarUtil() {
    }

    public static int getDesiredTopSpaceHeight() {
        return desiredTopSpaceHeight;
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_live_core_utils_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static int getStatusBarColor(Activity r1) {
        return r1.getResources().getColor(2131106784);
    }

    public static int getStatusBarHeight(Context r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = r5.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r1 <= 0) goto L8;
        r0 = r5.getResources().getDimensionPixelSize(r1);
    L8:
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        com.bytedance.android.live.core.utils.statusbar.a.a(r0, StatusBarInfoType.STATUSBAR_HEIGHT);
        return r0;
    }

    public static void hideStatusBar(Activity r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r2, false, false) == false) goto L7;
        return;
    L7:
        hideStatusBarInternel(r2);
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        com.bytedance.android.live.core.utils.statusbar.a.a(0, StatusBarInfoType.HIDE_STATUSBAR);
    }

    public static void hideStatusBarInternel(Activity r2) {
        r2.getWindow().setFlags(RomUtils.SZ, RomUtils.SZ);
        setStatusBarColor(r2);
    }

    public static void hideStatusBarOnLollipop(Activity r0) {
        hideStatusBar(r0);
    }

    public static void setDesiredTopSpaceHeight(int r1) {
        desiredTopSpaceHeight = r1;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        com.bytedance.android.live.core.utils.statusbar.a.a(desiredTopSpaceHeight, StatusBarInfoType.STE_STATUSBAR_HEIGHT);
    }

    public static void setStatusBarColor(Activity r1) {
        r1.getWindow().setStatusBarColor(getStatusBarColor(r1));
    }
}

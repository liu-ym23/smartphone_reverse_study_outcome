package com.ss.android.lark.chameleon.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class UiUtils {
    private static final String TAG = "UiUtils";
    private static int navigationHeight = -1;
    private static RectF reactionArea;
    private static int[] reactionLoc;
    private static int realScreenHeight;

    static {
        reactionLoc = new int[2];
    }

    public UiUtils() {
    }

    public static View INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static int dp2px(int r1) {
        return (int) ((r1 * INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) + 0.5f);
    }

    public static int getNavigationBarHeight(Context r3) {
        int r0 = navigationHeight;
        if (r0 != (-1)) goto L10;
        Resources r4 = r3.getResources();
        int r1 = r4.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r1 <= 0) goto L8;
        int r5 = r4.getDimensionPixelSize(r1);
        navigationHeight = r5;
        return r5;
    L8:
        return 0;
    L10:
        return r0;
    }

    public static Resources getResources(Context r0) {
        return r0.getResources();
    }

    public static int getScreenHeight(Context r1) {
        int r0 = realScreenHeight;
        if (r0 != 0) goto L6;
        Display r2 = ((WindowManager) r1.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics r3 = new DisplayMetrics();
        r2.getRealMetrics(r3);
        int r4 = r3.heightPixels;
        realScreenHeight = r4;
        return r4;
    L6:
        return r0;
    }

    public static void hide(View r1) {
        if (r1 == null) goto L5;
        r1.setVisibility(8);
        return;
    }

    public static void invisible(View r1) {
        if (r1 == null) goto L5;
        r1.setVisibility(4);
        return;
    }

    public static boolean isActivityRunning(Activity r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (isActivityRunningInner(r0) == false) goto L6;
        return true;
    }

    private static boolean isActivityRunningInner(Activity r1) {
        if (r1.isDestroyed() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.isFinishing() == true) goto L7;
        return true;
    }

    public static boolean isVisible(View r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int px2sp(int r1) {
        return (int) ((r1 / INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).scaledDensity) + 0.5f);
    }

    public static void show(View r1) {
        if (r1 == null) goto L5;
        r1.setVisibility(0);
        return;
    }

    public static void display(View r0, boolean r1) {
        if (r1 == false) goto L4;
        show(r0);
        return;
    L4:
        hide(r0);
    }

    public static int dp2px(Context r0, float r1) {
        return (int) ((r1 * INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).density) + 0.5f);
    }

    public static int getColor(Context r0, int r1) {
        return getResources(r0).getColor(r1);
    }

    public static Drawable getCompatDrawable(Context r0, int r1) {
        return AppCompatResources.getDrawable(r0, r1);
    }

    public static int getDimens(Context r0, int r1) {
        return getResources(r0).getDimensionPixelSize(r1);
    }

    public static Drawable getDrawable(Context r0, int r1) {
        return getResources(r0).getDrawable(r1);
    }

    public static int getInternalDimensionSize(Resources r2, String r3) {
        int r4 = r2.getIdentifier(r3, "dimen", "android");
        if (r4 > 0) goto L7;
        return 0;
    L7:
        return r2.getDimensionPixelSize(r4);
    }

    public static String getString(Context r0, int r1) {
        return getResources(r0).getString(r1);
    }

    public static String[] getStringArray(Context r0, int r1) {
        return getResources(r0).getStringArray(r1);
    }

    public static boolean isHoverOnView(View r6, MotionEvent r7) {
        r6.getLocationOnScreen(reactionLoc);
        int[] r1 = reactionLoc;
        int r2 = r1[0];
        RectF r0 = new RectF(r2, r1[1], r2 + r6.getWidth(), reactionLoc[1] + r6.getHeight());
        reactionArea = r0;
        return r0.contains(r7.getRawX(), r7.getRawY());
    }

    public static int px2dp(Context r0, float r1) {
        return (int) ((r1 / INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).density) + 0.5f);
    }

    public static int px2sp(Context r0, int r1) {
        return (int) ((r1 / INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).scaledDensity) + 0.5f);
    }

    public static String getString(Context r0, int r1, Object... r2) throws Resources.NotFoundException {
        return getResources(r0).getString(r1, r2);
    }

    public static void setForegroundDrawable(Activity r3, float r4, Drawable r5) {
        if (r3 == null) goto L10;
        Window r6 = r3.getWindow();
        if (r6 == null) goto L11;
        View r0 = INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r6);
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r0.setForeground(r5);
        return;
    L8:
        WindowManager.LayoutParams r7 = r6.getAttributes();
        r7.alpha = r4;
        r6.setAttributes(r7);
        return;
    L11:
        return;
    }
}

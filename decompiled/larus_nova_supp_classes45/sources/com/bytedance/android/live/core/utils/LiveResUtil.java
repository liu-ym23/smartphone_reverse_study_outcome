package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveResUtil {
    private static final float DIP_UPPER = 0.5f;
    private static final int MAX_TRACE = 5;
    private static Resources mResources;

    public static Resources getResources() {
        Resources r0 = mResources;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Context r1 = getContext();
        if (r1 == null) goto L8;
        mResources = r1.getResources();
    L8:
        Resources r2 = mResources;
        if (r2 == null) goto L11;
        return r2;
    L11:
        return Resources.getSystem();
    }

    public static Context getContext() {
        return jc1.a.b();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return INVOKEVIRTUAL_com_bytedance_android_live_core_utils_LiveResUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
    }

    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    private LiveResUtil() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_live_core_utils_LiveResUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static float dip2Px(float r2) {
        return TypedValue.applyDimension(1, r2, getDisplayMetrics());
    }

    public static int dp2Px(float r1) {
        return (int) ((r1 * getDisplayMetrics().density) + DIP_UPPER);
    }

    public static int getColor(int r1) {
        return getResources().getColor(r1);
    }

    public static int getDimension(int r1) {
        return (int) getResources().getDimension(r1);
    }

    public static Drawable getDrawable(int r1) {
        return getResources().getDrawable(r1);
    }

    public static String getString(int r1) {
        return getResources().getString(r1);
    }

    public static String[] getStringArray(int r1) {
        return getResources().getStringArray(r1);
    }

    public static String getString(int r1, Object... r2) {
        return getResources().getString(r1, r2);
    }

    public static String getQuantityString(int r1, int r2, Object... r3) {
        return getResources().getQuantityString(r1, r2, r3);
    }
}
